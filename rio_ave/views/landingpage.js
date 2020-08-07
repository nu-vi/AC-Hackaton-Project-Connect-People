$(document).ready(function () {

    $("#newUser_btn").click( function() {
        $.ajax({
            url: 'http://localhost:8080/connectpeople/api/create-user',
            type: "POST",
            data: JSON.stringify({
                name:$("#Name").val(),
                password:$("#Password").val(),
                email:$("#Email").val(),
                phone:$("#Phone").val(),
                city:$("#City").val()
            }),
            contentType: "application/json",
            async: true,
            success: successCallback,
            error: errorCallback
        });

    })

    $("#login_btn").click( function() {
        $.ajax({
            url:"http://localhost:8080/connectpeople/api/login",
            type:"POST",
            data: JSON.stringify({
                email:$("#DropdownFormEmail").val(),
                password:$("#DropdownFormPassword").val()
            }),
            contentType: "application/json",
            async: true,
            success: success,
            error: error
        });
    })



})


function success(response) {

    var id = response.id;
    alert(id);

    window.location.href = "/feed-page.html#" + id;
}

function error(request, status, error) {
    console.log(error);
}

function successCallback(response) {
    console.log(response);
    alert("HEYYAYAYAYAYAYYYA");
}

function errorCallback(request, status, error) {
    console.log(error);
}

function populate(customerData) {

    for (var i = 0; i < customerData.length; i++) {
        var str = "<tr><td>" + customerData[i].firstName + "</td><td>"
            + customerData[i].lastName + "</td><td>"
            + customerData[i].email + "</td><td>"
            + customerData[i].phone + "</td>"
            + "<td><button type='button' class='btn btn-outline-success'>Edit</button></td>" +
            "<td><button type='button' class='btn btn-outline-danger'>Delete</button></td></tr>";
        $(str).appendTo('#users-table');
    }

};