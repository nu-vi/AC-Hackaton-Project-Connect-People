var hash = location.hash.substr(1);
$(document).ready(function () {

    $("#submit-form").click(function () {
        $.ajax({
            url: 'http://localhost:8080/connectpeople/api/user/' + hash + '/create-event',
            type: "POST",
            data: JSON.stringify({
                title: $("#inputPlan").val(),
                location: $("#inputPlace").val(),
                time: $("#inputTime").val(),
                numberOfPeople: $("#inputAmount").val()
            }),
            contentType: "application/json",
            async: true,
            success: successCallback,
            error: errorCallback
        });

    })
});

    function successCallback(response) {

        var id = response.id;
        alert(id);

        window.location.href = "/feed-page.html#" + id;
    }

    function errorCallback(request, status, error) {
        console.log(error);
    }