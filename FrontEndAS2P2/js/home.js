axios.get('http://localhost:7001/AS2P2-1.0-SNAPSHOT/animalServlet')
    .then(response => {
        console.log(response.data)
    })
    .catch(error => {
        console.error(error)
    });