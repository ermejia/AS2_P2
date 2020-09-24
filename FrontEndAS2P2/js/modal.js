
$('#tbldata').on('click','tr td',function(evt){
    var target,idArea,idAnimal,nombre,edad,tamaño,peso,color,genero,pais,riesgo,sci;
    target = $(event.target);
    idAnimal = target.parent().find("td").eq(0).html();
    idArea = target.parent("tr").find("td").eq(1).html();
    nombre= target.parent("tr").find("td").eq(2).html();
    edad = target.parent("tr").find("td").eq(3).html();
    tamaño = target.parent("tr").find("td").eq(4).html();
    peso = target.parent("tr").find("td").eq(5).html();
    color = target.parent("tr").find("td").eq(6).html();
    genero = target.parent("tr").find("td").eq(7).html();
    pais = target.parent("tr").find("td").eq(8).html();
    riesgo = target.parent("tr").find("td").eq(9).html();
    sci = target.parent("tr").find("td").eq(10).html();
    $("#idAnimal").val(idAnimal);
    $("#idArea").val(idArea);
    $("#name").val(nombre);
    $("#age").val(edad);
    $("#heigth").val(tamaño);
    $("#weight").val(peso);
    $("#color").val(color);
    $("#gender").val(genero);
    $("#country").val(pais);
    $("#extinction").val(riesgo);
    $("#sciname").val(sci);
    $("#modal_animal").modal('show');
});
