package com.example.app.SpringBootWebShop.service.Admin;

import com.example.app.SpringBootWebShop.entity.Fruit;
import com.example.app.SpringBootWebShop.exceptions.UseOrderException;
import com.example.app.SpringBootWebShop.repository.FruitRepository;
import com.example.app.SpringBootWebShop.utils.Constants;
import com.example.app.SpringBootWebShop.utils.ResponseMessage;
import com.example.app.SpringBootWebShop.utils.StringGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.StreamSupport;

@Service
public class AdminFruitService {

    private static final Logger LOGGER =
            Logger.getLogger(AdminFruitService.class.getName());

    @Autowired
    FruitRepository repository;

    public ResponseEntity<?> addFruit(String[] data, MultipartFile multipartFile) throws IOException {
        Map<String, String> errors = validateData(data);
        if (!errors.isEmpty()) {
            try {
                throw new UseOrderException("Check inputs", errors);
            } catch (UseOrderException e) {
                return new ResponseEntity<>(new ResponseMessage(false,
                        e.getErrors(errors)), HttpStatus.OK);
            }
        } else {
            String imgPrefix = StringGenerator.genStr();
            Fruit fruit = new Fruit();
            fruit.setName(data[0]);
            fruit.setArticle(data[1]);
            fruit.setDescr(data[2]);
            fruit.setPrice(Double.parseDouble(data[3]));

            String fileUpload = imgPrefix + "-" + data[4];
            byte[] bytes = multipartFile.getBytes();
            Path path = Paths.get(Constants.URL_TO_UPLOADS + fileUpload);
            Files.write(path, bytes);

            LOGGER.info("Upload path info: " + path);

            fruit.setImg(fileUpload);
            repository.save(fruit);

            return new ResponseEntity<>(new ResponseMessage(true,
                    Constants.SAVED_MSG), HttpStatus.OK);
        }
    }

    // TODO develop
    public ResponseEntity<?> updateFruit(){
        return null;
    }

    // TODO develop
    public ResponseEntity<?> deleteFruit(){
        return null;
    }

    // TODO requires some extra work to validate the file

    public List<Fruit> getAll() {
        Iterable<Fruit> iterable = repository.findAll();
        List<Fruit> list =
                StreamSupport.stream(iterable.spliterator(), false)
                        .map(fruit -> new Fruit(fruit.getId(), fruit.getImg(),
                                fruit.getName(), fruit.getArticle(),
                                fruit.getDescr(), fruit.getPrice()))
                        .toList();
        return new ArrayList<>(list);
    }

    private Map<String, String> validateData(String[] data) {
        Map<String, String> errors = new HashMap<>();
        if (data[0].isEmpty() | data[0].equals(" "))
            errors.put("name", Constants.INPUT_REQ_MSG);
        if (data[1].isEmpty() | data[1].equals(" "))
            errors.put("article", Constants.INPUT_REQ_MSG);
        if (data[2].isEmpty() | data[2].equals(" "))
            errors.put("description", Constants.INPUT_REQ_MSG);
        if (data[3].isEmpty() | data[3].equals(" "))
            errors.put("price", Constants.INPUT_REQ_MSG);
        if (data[4].isEmpty() | data[3].equals(" "))
            errors.put("file", Constants.ADD_FILE_MSG);
        return errors;
    }
}
