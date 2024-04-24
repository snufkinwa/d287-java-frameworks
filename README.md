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
> Edited lines 42-96 <br>
5. Add a “Buy Now” button to your product list. Your “Buy Now” button must meet each of the following parameters:
   <br>•  The “Buy Now” button must be next to the buttons that update and delete products.
   <br>•  The button should decrement the inventory of that product by one. It should not affect the inventory of any of the associated parts.
   <br>•  Display a message that indicates the success or failure of a purchase.
>File(s): /src/main/java/com/example/demo/controllers/AddProductController.java<br>
> Lines 175-188<br>
> /src/main/resources/templates/mainscreen.html<br>
> Lines 96<br>
> /src/main/resources/templates/outOfStock.html<br>
> Lines 1-12 <br>
> /src/main/resources/templates/purchaseConfirmation<br>
> Lines 1-12 <br>
6. Modify the parts to track maximum and minimum inventory by doing the following:
   <br>•  Add additional fields to the part entity for maximum and minimum inventory.
   <br>•  Modify the sample inventory to include the maximum and minimum fields.
   <br>•  Add to the InhousePartForm and OutsourcedPartForm forms additional text inputs for the inventory so the user can set the maximum and minimum values.
   <br>•  Rename the file the persistent storage is saved to.
   <br>•  Modify the code to enforce that the inventory is between or at the minimum and maximum value.
>File(s): /src/main/resources/templates/about.html<br>
> Lines 33-54, 64-66 Stylizing the 'Go Back' button<br>
> /src/main/resources/templates/mainscreen.html<br>
> Lines 20-25, 54-55, 60, 64-65<br>
> /src/main/resources/templates/InhousePartForm.html<br>
> Lines 25-26 text inputs for minInv and maxInv
> /src/main/resources/templates/OutsourcedPartForm.html<br>
> Lines 24-25 text inputs for minInv and maxInv 
> /src/main/java/com/example/demo/controllers/AddInhouseController.java<br>
> Lines 44-53 enforce that the inventory is between or at the minimum and maximum value inhouse part<br>
> /src/main/java/com/example/demo/controllers/AddOutsourcedController.java<br>
> Lines 45-59, 61 enforce that the inventory is between or at the minimum and maximum value outsourced part<br>
> /src/main/resources/application.properties<br>
> Lines 1, 7 Establishing port and Rename the file the persistent storage is saved to.<br>
> /src/main/java/com/example/demo/bootstrap/BootStrapData.java <br>
> Edited lines 51-53, 61-62,69, 71-72, 79-81, 88-89, 93-99 Modify the sample inventory to include the maximum and minimum fields. Testing the color coding html, if it low the row is red, if it over the inventory the row is green.  <br>
> /src/main/java/com/example/demo/domain/Part.java<br>
> Lines 31-32, 43, 47-48, 51, 56-57, 92-119 Add additional fields to the part entity for maximum and minimum inventory.