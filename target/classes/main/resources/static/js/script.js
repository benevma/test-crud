
		function getUtenti() {
		    URL = window.location.origin+"/operazionicrud/select";  //Your URL
		    var xmlhttp = new XMLHttpRequest();
		    xmlhttp.open("GET", URL, false);
		    xmlhttp.setRequestHeader("Content-Type", "application/json");
		    xmlhttp.send();
	    	return JSON.parse(xmlhttp.responseText);
	    
		}
		
		function elimina(id) {
		    URL =  window.location.origin+"/operazionicrud/delete?idUtente="+id;  //Your URL
		    var xmlhttp = new XMLHttpRequest();
		    xmlhttp.open("GET", URL, false);
		    xmlhttp.setRequestHeader("Content-Type", "application/json");
		    xmlhttp.send();	    
		}
		
		function modifica(id) {
			var eta = document.getElementById('mod'+id).value;
			URL= window.location.origin+"/operazionicrud/update?eta="+eta+"&idUtente="+id;
		    var xmlhttp = new XMLHttpRequest();
		    xmlhttp.open("GET", URL, false);
		    xmlhttp.setRequestHeader("Content-Type", "application/json");
		    xmlhttp.send();
		}
		
		function aggiungi() {
			var eta = document.getElementById('eta').value;
			var nome = document.getElementById('nome').value;
			URL= window.location.origin+"/operazionicrud/insert?eta="+eta+"&nome="+nome;
		    var xmlhttp = new XMLHttpRequest();
		    xmlhttp.open("GET", URL, false);
		    xmlhttp.setRequestHeader("Content-Type", "application/json");
		    xmlhttp.send();
		}