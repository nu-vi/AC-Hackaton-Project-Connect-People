var hash = location.hash.substr(1);

$(document).ready(function() {
    
    $.ajax({
            url: 'http://localhost:8080/connectpeople/api/user/' + hash + '/friends',
            async: true,
            success: successCallback,
            error: errorCallback
        });
});

function successCallback(response) {
    console.log("test");
    populateFriends(response);
}

function errorCallback(request, status, error) {

}

function populateFriends(userFriends) {

    userFriends.forEach(user => {
        let content = '<div class="col-md-4"><div class = "img-container">' +
            '<img class="rounded friend-background" src="resources/friendlist-background-2.png">' +
            '<div id="friendName" class="top-center">' + user.name + '</div>' +
            '<div class="second-center">Location: ' + user.city + '</div>' +
            '<div class="third-center">' + user.email + '</div>' +
            '<div class="fourth-center">' + user.phone + '</div>' +
            '</div></div>'


        $(content).appendTo('#friends-container');
    })


};


