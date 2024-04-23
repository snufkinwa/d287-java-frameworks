<!--<strong>DO NOT DISTRIBUTE OR PUBLICLY POST SOLUTIONS TO THESE LABS. MAKE ALL FORKS OF THIS REPOSITORY WITH SOLUTION CODE PRIVATE. PLEASE REFER TO THE STUDENT CODE OF CONDUCT AND ETHICAL EXPECTATIONS FOR COLLEGE OF INFORMATION TECHNOLOGY STUDENTS FOR SPECIFICS. ** </strong>-->


## D287 – JAVA FRAMEWORKS


## Notes
1.	Edit README.md to include notes describing changes of code.

2. Customize the HTML user interface for your customer’s application. The user interface should include the shop name, the product names, and the names of the parts.Customize the HTML user interface for your customer’s application. The user interface should include the shop name, the product names, and the names of the parts.
> File: /src/main/resources/templates/mainscreen.html <br> Edited on line 14, 21, 53
3. Add an “About” page to the application to describe your chosen customer’s company to web viewers and include navigation to and from the “About” page and the main screen.
> File(s): /src/main/resources/templates/about.html<br>/src/main/resources/templates/mainscreen.html <br> Edited on line 24-28
> /src/main/java/com/example/demo/controllers/MainScreenControllerr.java<br>
> Lines 55-59
4. Add a sample inventory appropriate for your chosen store to the application. You should have five parts and five products in your sample inventory and should not overwrite existing data in the database.
    <br> <br>Note: Make sure the sample inventory is added only when both the part and product lists are empty. When adding the sample inventory appropriate for the store, the inventory is stored in a set so duplicate items cannot be added to your products. When duplicate items are added, make a “multi-pack” part.
>File(s): /src/main/java/com/example/demo/bootstrap/BootStrapData.java <br>
> Edited lines 40-41, 43-68 <br>
5. Add a “Buy Now” button to your product list. Your “Buy Now” button must meet each of the following parameters:
   <br>•  The “Buy Now” button must be next to the buttons that update and delete products.
   <br>•  The button should decrement the inventory of that product by one. It should not affect the inventory of any of the associated parts.
   <br>•  Display a message that indicates the success or failure of a purchase.
>File(s): /src/main/java/com/example/demo/controllers/AddProductController.java<br>
> Lines 175-188<br>
> /src/main/resources/templates/InhousePartForm.html<br>
> Lines 2, 27, 29, 31 trying to fix an error with update button, but it did not work<br>
> /src/main/resources/templates/mainscreen.html<br>
> Lines 96<br>
> /src/main/resources/templates/outOfStock.html<br>
> Lines 1-12 <br>
> /src/main/resources/templates/purchaseConfirmation<br>
> Lines 1-12 <br>