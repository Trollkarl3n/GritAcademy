var imgList = document.getElementById('img-list');
var caroBtns = document.getElementsByClassName('caro-btn');

var positionUnit = -100;

for (var i = 0; i < caroBtns.length; i++) {
    caroBtns[i].addEventListener('click', function (event) {
        for (var j = 0; j < caroBtns.length; j++) {
            caroBtns[j].style.backgroundColor = "#ffffff44";
        }
        event.target.style.backgroundColor = "#fff";
        var x = Array.prototype.indexOf.call(caroBtns, event.target);
        var position = x * positionUnit;
        imgList.style.left = position + "%";
    });
}