axios.get('http://localhost:7001/AS2P2-1.0-SNAPSHOT/animalServlet')
    .then(response => {
        var i =1;
        var array = [];
        var data = [];
        array = response.data;
        for (i = 0; i < array.length; i++) {
            data[i] = array[i];
        }

        var result = "<table  class=\"fl-table\" id=\"animalTable\" >";
        result += "<thead>\n" +
            "        <tr>\n" +
            "            <th style=\"display:none;\">ID Animal</th>\n" +
            "            <th style=\"display:none;\">ID Area</th>\n" +
            "            <th>Nombre</th>\n" +
            "            <th>Edad</th>\n" +
            "            <th>Tamaño en metros</th>\n" +
            "            <th>Peso en Kg</th>\n" +
            "            <th>Color</th>\n" +
            "            <th>Genero</th>\n" +
            "            <th>Pais de Procedencia</th>\n" +
            "            <th>Riesgo de Extincion</th>\n" +
            "            <th>Nombre Cientifico</th>\n" +

            "        </tr>\n" +
            "        </thead> <tbody id='tbldata'>" ;
        for(var i=0; i<array.length; i++) {
            result += "<tr>";
            result += "<td style=\"display:none;\">"+data[i].IdAnimal+"</td>";
            result += "<td style=\"display:none;\">"+data[i].idArea+"</td>";
            result += "<td>"+data[i].name+"</td>";
            result += "<td>"+data[i].age+"</td>";
            result += "<td>"+data[i].heigth+"</td>";
            result += "<td>"+data[i].weight+"</td>";
            result += "<td>"+data[i].color+"</td>";
            result += "<td>"+data[i].gender+"</td>";
            result += "<td>"+data[i].country+"</td>";
            result += "<td>"+data[i].extinctionRisk+"</td>";
            result += "<td>"+data[i].sciName+"</td>";
            result += "</tr>";
        }
        var val = data[0].idArea;
        result += "</tbody > </table>";
        document.getElementById("table").innerHTML =result;
        document.getElementById("divarea").innerHTML = "<input type=\"text\" class=\"form-control\" id=\"idArea\" name=\"idArea\" value=\""+data[0].idArea+"\" style=\"display:none;\">"
        if (val== 1){
            document.getElementById("head").innerHTML = "" +
                "    <p> <label for=\"nameArea\">Nombre </label><input type=\"text\" value='Sabana Africana' class=\"form-control\" id=\"nameArea\" disabled></p>\n" +
                "    <p> <label for=\"tamaño\">Tamaño en m2 </label><input type=\"text\" value='1500' class=\"form-control\" id=\"tamaño\" disabled></p>\n" +
                "    <p> <label for=\"horario\">Horario </label><input type=\"text\" value='9am - 5pm' class=\"form-control\" id=\"horario\" disabled ></p>\n" +
                "    <p> <label for=\"limpieza\">Dias de limpieza </label><input class=\"form-control\" value='Monday' id=\"limpieza\" disabled></p>"
        }
        if (val== 2){
            document.getElementById("head").innerHTML = "" +
                "    <p> <label for=\"nameArea\">Nombre </label><input type=\"text\" value='Jungla' class=\"form-control\" id=\"nameArea\" disabled></p>\n" +
                "    <p> <label for=\"tamaño\">Tamaño en m2 </label><input type=\"text\" value='1500' class=\"form-control\" id=\"tamaño\" disabled></p>\n" +
                "    <p> <label for=\"horario\">Horario </label><input type=\"text\" value='10am - 5pm' class=\"form-control\" id=\"horario\" disabled ></p>\n" +
                "    <p> <label for=\"limpieza\">Dias de limpieza </label><input class=\"form-control\" value='Tuesday' id=\"limpieza\" disabled></p>"
        }
        if (val== 3){
            document.getElementById("head").innerHTML = "" +
                "    <p> <label for=\"nameArea\">Nombre </label><input type=\"text\" value='Oceanos' class=\"form-control\" id=\"nameArea\" disabled></p>\n" +
                "    <p> <label for=\"tamaño\">Tamaño en m2 </label><input type=\"text\" value='2500' class=\"form-control\" id=\"tamaño\" disabled></p>\n" +
                "    <p> <label for=\"horario\">Horario </label><input type=\"text\" value='8am - 5pm' class=\"form-control\" id=\"horario\" disabled ></p>\n" +
                "    <p> <label for=\"limpieza\">Dias de limpieza </label><input class=\"form-control\" value='Wednesday' id=\"limpieza\" disabled></p>"
        }



    })
    .catch(error => {
        console.error(error)
    });


