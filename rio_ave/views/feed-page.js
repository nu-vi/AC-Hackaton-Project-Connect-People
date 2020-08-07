var hash = location.hash.substr(1);

$(document).ready(function() {

    $("#addEvent").click( function(e) {
        //e.preventDefault();
        window.location.href= "addEvent.html#" + hash;
    });

    $.ajax({
        url: 'http://localhost:8080/connectpeople/api/user/' + hash + '/event-set',
        async: true,
        success: successCallback,
        error: errorCallback
    });
});

function successCallback(response) {
    response.forEach(event => {

        var contentlol = '<h1>' + event.title + '</h1>';

        var content = '<div id="event" class="container">' +
            '<div class="row">' +
            '<div class="[ col-xs-12 col-sm-offset-2 col-sm-8 ]">' +
            '<ul class ="event-list">' +
            '<li>' +
            '<span class="time">' + event.time + '</span>' +
            '<div class="info">' +
            '<h2 class="title">' + event.title + '</h2> ' +
            '<p class="desc">' + event.description + '</p>' +
            '<p class="desc">' + event.location + '</p>'
            '</div>' +
            '</li>' + '</ul>' + '</div> </div> </div>';


        $("#event-feed").append(contentlol);
    })
}

function errorCallback(request,status, error) {
    console.log(error);
}
