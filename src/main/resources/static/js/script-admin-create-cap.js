$(function() {

    $('#addModalBtnSave').click(function(e) {
		e.preventDefault();
		$("#addModalBtnClear").prop("disabled", true);
		$("#addModalBtnSave").prop("disabled", true);
		$('#addModalSpinner').show();

        let formData = new FormData();
		formData.append('capName', $('input[id=nameInputAdd]').val());
		formData.append('capArt', $('input[id=artInputAdd]').val());
		formData.append('capDescr', $('textarea[id=descrTextareaAdd]').val());
		formData.append('capPrice', $('input[id=priceInputAdd]').val());
		formData.append('capFile', $('input[id=formFileAdd]')[0].files[0]);

        $.ajax({
            type: 'POST',
            enctype: 'multipart/form-data',
			dataType: 'json',
			contentType: false,
			processData: false,
			url: '/admin/create-cap',
			data: formData
        })
        .done(function(response) {
            if(response.success == false) {
                output = "<span style='color: #f02d1f; font-size: 16px;'>" + response.message + "</span>";
            }else {
                output = "<span style='color: #22a131; font-size: 16px;'>" + response.message + "</span>";
            }
            $('#addModalSpinner').hide();
            $('#addModalResponse').html(output);
            $("#addModalBtnClear").prop("disabled", false);
            $("#addModalBtnSave").prop("disabled", false);

        })
        .fail (function(e) {
            $('#addModalSpinner').hide();
            $("#addModalResponse").html(e.responseText);
            $("#addModalBtnClear").prop("disabled", false);
            $("#addModalBtnSave").prop("disabled", false);
        });
    });

    $('#addModalBtnClear').click(function(e) {
        $('#modalFormCreateCap')[0].reset();
        $('#addModalResponse').html('');
        location.reload();
    });

});
