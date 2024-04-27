<!--<strong>DO NOT DISTRIBUTE OR PUBLICLY POST SOLUTIONS TO THESE LABS. MAKE ALL FORKS OF THIS REPOSITORY WITH SOLUTION CODE PRIVATE. PLEASE REFER TO THE STUDENT CODE OF CONDUCT AND ETHICAL EXPECTATIONS FOR COLLEGE OF INFORMATION TECHNOLOGY STUDENTS FOR SPECIFICS. ** </strong>-->


## D287 – JAVA FRAMEWORKS


## Notes
1.	Edit README.md to include notes describing changes of code.

2. Customize the HTML user interface for your customer’s application. The user interface should include the shop name, the product names, and the names of the parts.Customize the HTML user interface for your customer’s application. The user interface should include the shop name, the product names, and the names of the parts.
> File:<br> /src/main/resources/templates/mainscreen.html <br> Edited on line 14, 21, 53
3. Add an “About” page to the application to describe your chosen customer’s company to web viewers and include navigation to and from the “About” page and the main screen.
> File(s):<br> /src/main/resources/templates/about.html<br>/src/main/resources/templates/mainscreen.html <br> Edited on line 24-28
> /src/main/java/com/example/demo/controllers/MainScreenControllerr.java<br>
> Lines 55-59
4. Add a sample inventory appropriate for your chosen store to the application. You should have five parts and five products in your sample inventory and should not overwrite existing data in the database.
    <br> <br>Note: Make sure the sample inventory is added only when both the part and product lists are empty. When adding the sample inventory appropriate for the store, the inventory is stored in a set so duplicate items cannot be added to your products. When duplicate items are added, make a “multi-pack” part.
>File(s):<br> /src/main/java/com/example/demo/bootstrap/BootStrapData.java <br>
> Edited lines 42-96 <br>
5. Add a “Buy Now” button to your product list. Your “Buy Now” button must meet each of the following parameters:
   <br>•  The “Buy Now” button must be next to the buttons that update and delete products.
   <br>•  The button should decrement the inventory of that product by one. It should not affect the inventory of any of the associated parts.
   <br>•  Display a message that indicates the success or failure of a purchase.
>File(s):<br>
>/src/main/java/com/example/demo/controllers/AddProductController.java<br>
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
>File(s): <br>
>/src/main/resources/templates/about.html<br>
> Lines 33-54, 64-66 Stylizing the 'Go Back' button<br>
> /src/main/resources/templates/mainscreen.html<br>
> Lines 20-25<br><br><code>      .table-row-warning {
background-color: #d4edda;
}
.table-row-danger {
background-color: #f8d7da; /* Light red background color */
}
</code><br><br>, 
> 54-55<br><br>``` <th>Min Inventory</th><th>Max Inventory</th>```<br><br>, 
> 60
> <br><br>```<tr th:each="tempPart : ${parts}" th:class="${tempPart.inv >= tempPart.maxInv} ? 'table-row-warning' : (${tempPart.inv <= tempPart.minInv} ? 'table-row-danger' : '')">```<br><br>, 
> 64-65<br><br><code></code><br><br><br>
> /src/main/resources/templates/InhousePartForm.html<br>
> Lines 25-26<br><br>```<p><input type="text" th:field="*{minInv}" placeholder="Min Inventory" class="form-control mb-4 col-4"/></p><p><input type="text" th:field="*{maxInv}" placeholder="Max Inventory" class="form-control mb-4 col-4"/></p>```<br><br> text inputs for minInv and maxInv<br>
> /src/main/resources/templates/OutsourcedPartForm.html<br>
> Lines 24-25 <br><br>```<p><input type="text" th:field="*{minInv}" placeholder="Min Inventory" class="form-control mb-4 col-4"/></p><p><input type="text" th:field="*{maxInv}" placeholder="Max Inventory" class="form-control mb-4 col-4"/></p>```<br><br>
> text inputs for minInv and maxInv<br> 
> /src/main/java/com/example/demo/controllers/AddInhouseController.java<br>
> Lines 44-53<br><br><code> } else {
if (part.getInv() < part.getMinInv()) {
theBindingResult.rejectValue("inv", "error.LowInventory", "Inventory must be above the minimum inventory value");
return "InhousePartForm";
} else if (part.getInv() > part.getMaxInv()) {
theBindingResult.rejectValue("inv", "error.HighInventory", "Inventory must be below the maximum inventory value");
return "InhousePartForm";
}
InhousePartService repo=context.getBean(InhousePartServiceImpl.class);
</code><br><br> Enforce that the inventory is between or at the minimum and maximum value inhouse part<br><br>
> /src/main/java/com/example/demo/controllers/AddOutsourcedController.java<br>
> Lines 45-59, 61<br><br>
> <code>} else {
            if (part.getInv() < part.getMinInv()) {
                theBindingResult.rejectValue("inv", "error.LowInventory", "Inventory must be above the minimum inventory value");
                //return "OutSourcedPartForm";
            } else if (part.getInv() > part.getMaxInv()) {
                theBindingResult.rejectValue("inv", "error.HighInventory", "Inventory must be below the maximum inventory value");
                return "OutsourcedPartForm";
            }<br>
            OutsourcedPartService repo=context.getBean(OutsourcedPartServiceImpl.class);
            OutsourcedPart op=repo.findById((int)part.getId());
            if(op!=null)part.setProducts(op.getProducts());
</code><br><bR> Enforce that the inventory is between or at the minimum and maximum value outsourced part<br>
> /src/main/resources/application.properties<br>
> Lines 1 <br><code>server.port= 8080
</code><br>, 7<br><code>spring.datasource.url=jdbc:h2:file:~/spring-boot-h2-db105
</code><br><br> Establishing port and Rename the file the persistent storage is saved to.<br><br>
> /src/main/java/com/example/demo/bootstrap/BootStrapData.java <br>
> Edited lines 51-53<br>
> <code>processor.setInv(187);<br>
processor.setInv(350);<br>
processor.setMinInv(50);<br>
processor.setMaxInv(300);<br>
</code>, 61-62<br><code> motherboard.setMinInv(50);
motherboard.setMaxInv(250);
</code><br>
> 69<br><code>ram.setInv(46);
</code>, <br>88-89<br><code>psu.setMinInv(50);
psu.setMaxInv(300);
</code>, <br> 93-99<br><code>   processor.validateInventory();
motherboard.validateInventory();
ram.validateInventory();
graphicsCard.validateInventory();
psu.validateInventory();
</code><br><br> Modify the sample inventory to include the maximum and minimum fields. Testing the color coding html, if it low the row is red, if it over the inventory the row is green.  <br><br>
> /src/main/java/com/example/demo/domain/Part.java<br>
> Lines 31-32<br><br><code> int minInv;
int maxInv;
</code><br><br>, 
> 43<br><br><code> public Part(String name, double price, int inv, int minInv, int maxInv) {
</code><br><br>, 
> 47-48<br><br><code>this.minInv = minInv;<br>
this.maxInv = maxInv;
</code><br><br>, 
> 51<br><br><code>public Part(long id, String name, double price, int inv, int minInv, int maxInv) {
</code><br><br>, 
>56-57<br><br><code>this.minInv = minInv;<br>
this.maxInv = maxInv;
</code><br><br>, 92-119<br><br><code>   public int getMinInv() {
return minInv;
}
    public int getMaxInv() {
        return maxInv;
    }
    public void setMaxInv(int maxInv) {
        this.maxInv = maxInv;
    }
    public void setMinInv(int minInv) {
        this.minInv = minInv;
    }
    public boolean isValidInventory() {
        return inv >= minInv && inv <= maxInv;
    }
    public void validateInventory() {
        if (isValidInventory()) {
            System.out.println("Inventory is valid for " + getName());
        } else {
            System.out.println("Invalid inventory for " + getName());
        }
    }</code><br><br> Add additional fields to the part entity for maximum and minimum inventory.
7. Add validation for between or at the maximum and minimum fields. The validation must include the following:
   <br>•  Display error messages for low inventory when adding and updating parts if the inventory is less than the minimum number of parts.
   <br>•  Display error messages for low inventory when adding and updating products lowers the part inventory below the minimum.
   <br>•  Display error messages when adding and updating parts if the inventory is greater than the maximum.
>/src/main/java/com/example/demo/controllers/AddProductController.java
> Line 181-193<br><br>
<code>   if (product.getInv() <= 0) {
return "outOfStock";
}
        // Reduce inventory and save the product
        product.setInv(product.getInv() - 1);
        //Reduce part inventory
        //for (Part part : product.getParts()) {
        //    part.setInv(part.getInv() - 1);
        //}
        productService.save(product);
        return "paymentConfirmation";</code>
> 
> /src/main/java/com/example/demo/validators/EnufPartsValidator.java<br>
>Line 36<br><br>
> <code> if (part.getInv() < part.getMinInv()) {
theBindingResult.rejectValue("inv", "error.LowInventory", "Inventory must be above the minimum inventory value");
//return "OutSourcedPartForm";
} else if (part.getInv() > part.getMaxInv()) {
theBindingResult.rejectValue("inv", "error.HighInventory", "Inventory must be below the maximum inventory value");
return "OutsourcedPartForm";
}<br></code>
> 
> A good portion of this prompt error messages were made to enforce inventory stays between minimum and maximum, did not add more as it met requirements
> 
8. Add at least two unit tests for the maximum and minimum fields to the PartTest class in the test package.
>
> 
9.   Remove the class files for any unused validators in order to clean your code.
>
