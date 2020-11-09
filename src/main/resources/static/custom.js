let map;
let marker;
let image;
var contentString = '<h2>' + city + ', ' + state + '</h2>';

    function initMap() {

    console.log(google);

    let infowindow = new google.maps.InfoWindow({
         content: contentString
    });

    map = new google.maps.Map(document.getElementById('map'), {
        center: coords,
        zoom: 10,
        scrollwheel: false
    });

    marker = new google.maps.Marker({
        position: coords,
        map: map,
        icon: image,
        animation: google.maps.Animation.DROP
    });

    image = {
        url: '/location.png', 
        scaledSize: new google.maps.Size(50, 50)
    };

    google.maps.event.addListener(marker, 'click', function() {
        infowindow.open(map,marker);
    });
}


    
