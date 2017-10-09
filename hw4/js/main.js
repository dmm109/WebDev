window.onload = function() {

	/* --------- login module start -------------- */
	(function() {
		// a self contained "namespace"

		//login section elements
		var loginLink = document.getElementById("login-link");
		var loginForm = document.getElementById("login-form");
		var loginSubmit = document.getElementById('login-submit');
		var logoutLink = document.getElementById('logout-link');
		var profileLink = document.getElementById('profile-link');
		var authorizedSection = document.getElementById("authorized");

		var userName = document.getElementById('username');
		var userPassword = document.getElementById('password');

		
		loginLink.addEventListener('click', showLoginForm, false);
		loginSubmit.addEventListener('click', logIn, false);
		logoutLink.addEventListener('click', logOut, false);
		profileLink.addEventListener('click', getProfile, false);
		
		function showLoginForm() {
			loginLink.style.display = "none";
			loginForm.style.display = "block";
			loginSubmit.style.display = "block";
			userName.focus();
		}

		function showAuthorizedSection() {
			authorizedSection.style.display = "block";
			loginForm.style.display = "none";
			loginSubmit.style.display = "none";
		}

		function logIn() {
			//check credential
			var userNameValue = userName.value;
			var userNameValueLength = userName.value.length;
			var userPasswordValue = userPassword.value;
			var userPasswordLength = userPassword.value.length;

			if (userNameValueLength == 0 || userPasswordLength == 0) {
				if (userNameValueLength == 0) {
					console.log('username is empty');
				}
				if (userPasswordLength == 0) {
					console.log('password is empty');
				}
			} else if (userNameValue != 'admin' || userPasswordValue != '1234') {
				console.log('username or password is invalid');
			} else if (userNameValue == 'admin' && userPasswordValue == '1234') {
				showAuthorizedSection();
			}
		}

		function logOut() {
			userName.value = '';
			userPassword.value = '';
			authorizedSection.style.display = "none";
			loginLink.style.display = "block";
		}

		function getProfile() {
			console.log('Profile link was clicked');
		}
	})();
	/* --------- login module end  -------------- */

	/* --------- make donation module start -------------- 
	(function() {
		var donateBotton = document.getElementById('donate-botton');
		var donationAddress = document.getElementById('donation-address');
		var donateFormContainer = document.getElementById('donate-form-container');
		var customAmount = document.getElementById('customAmount');
		var donateForm = document.forms['_xclick'];
		var donateLaterLink = document.getElementById('donate-later-link');
		var checkedInd = 2;

		function showDotationForm() {
			donationAddress.style.display = "none";
			donateFormContainer.style.display = "block";
		}


		donateBotton.addEventListener('click', showDotationForm, false);

		//uncheck selected radio buttons if custom amount was choosen
		function onCustomAmountFocus() {
			for (var i = 0; i < donateForm.length; i++) {
				if (donateForm[i].type == 'radio') {
					donateForm[i].onclick = function() {
						customAmount.value = '';
					}
				}
				if (donateForm[i].type == 'radio' && donateForm[i].checked == true) {
					checkedInd = i;
					donateForm[i].checked = false;
				}
			}
		}


		customAmount.addEventListener('focus', onCustomAmountFocus, false);

		function onCustomAmountBlur() {
			var value = customAmount.value;
			if (value == '') {
				donateForm[checkedInd].checked = true;
			}
		}


		customAmount.addEventListener('blur', onCustomAmountBlur, false);

		function donateLater() {
			donationAddress.style.display = "block";
			donateFormContainer.style.display = "none";
		}


		donateLaterLink.addEventListener('click', donateLater, false);

	})();
	/* --------- make donation module end -------------- */

	/* --------- geolocation | google maps multi markers module start -------------- */
	(function() {

		var locationUI = document.getElementById('location-ui');
		var locationMap = document.getElementById('location-map');
		
		var breweries = [
		['New District', 38.84, -77.08], 
		['Mad Fox', 38.88, -77.17],
		['Caboose Brewing Co.', 38.90, -77.27],
		['Beltway Brewing Company', 38.99, -77.41],
		['Crooked Run Brewing', 38.99, -77.42],
		['Old Ox', 39.02, -77.45],
		['Belly Love', 39.13, -77.70]
		];

		var mapOptions = {
				center : new google.maps.LatLng(38.98, -77.40),
				zoom : 10,
				mapTypeId : google.maps.MapTypeId.ROADMAP,
				mapTypeControlOptions : {
					style : google.maps.MapTypeControlStyle.DROPDOWN_MENU,
					position : google.maps.ControlPosition.TOP_RIGHT
				}
			};
			
		var map = new google.maps.Map(locationMap, mapOptions);

		var infowindow = new google.maps.InfoWindow();

		var marker, i;

		for ( i = 0; i < breweries.length; i++) {
			marker = new google.maps.Marker({
				position : new google.maps.LatLng(breweries[i][1], breweries[i][2]),
				map : map
			});

			google.maps.event.addListener(marker, 'click', (function(marker, i) {
				return function() {
					var content = breweries[i][0];
					infowindow.setContent(content);
					infowindow.open(map, marker);
				}
			})(marker, i));
			
			google.maps.event.addListenerOnce(map, 'idle', function(){
    			locationUI.innerHTML = "2017 B&G Brewery Trail";
			})
		}

	})();

}
