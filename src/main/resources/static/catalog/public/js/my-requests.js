const xhr = new XMLHttpRequest(); 
xhr.onreadystatechange = () => {
	if(xhr.readyState == 4 && xhr.status === 200){
		const res = JSON.parse(xhr.responseText); //parsing the string into a JSON object
		const productsContainer = document.querySelector('#product-container'); //finding the div
		
		for(let product of res){
			//look up difference in for in
			//append every element of res to div
			const productContainer = document.createElement('div'); 
			const productLink = document.createElement('a'); 
			productLink.setAttribute('href', '/catalog/product.html');//creating a link element anchor element
			//when link is hit we will go there in our products pages
			productLink.innerText = product.name
			productContainer.innerText = product.name; //setting product text to product container
			//key --> product is used to access the response instance array;  --> wh
			productsContainer.append(productLink);//link products to product
			productsContainer.append(productContainer);//added to newly created div
		} //use of for in loop to not have to create the key value syntax --> res[product].name

	}
}
xhr.open('GET','/products',true); 
xhr.send(); 


