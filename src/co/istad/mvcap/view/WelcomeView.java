package co.istad.mvcap.view;

import co.istad.mvcap.controller.ProductController;
import co.istad.mvcap.dto.CreateProductDto;
import co.istad.mvcap.dto.ProductDto;
import co.istad.mvcap.dto.UpdateProductDto;
import co.istad.mvcap.util.InputUtil;
import java.util.Scanner;
import java.util.UUID;

public class WelcomeView {
    private void showMenu(){
        System.out.println("-------------------------");
        System.out.println("Welcome to My Application");
        System.out.println("-------------------------");
        System.out.println("1. Create new product");
        System.out.println("2. List all products");
        System.out.println("3. Remove product");
        System.out.println("4. Update Product");
        System.out.println("5. Search product by Name");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
    }
    private void showMessage(String message) {
        System.out.println("--------------------------------------------------");
        System.out.println("-> " + message);
    }

    public  void render() {
        ProductController controller = new ProductController();
        do {
             // show menu early line 11
            this.showMenu();
            //  get option
            int option = InputUtil.getInteger("Choose option -> ");
            switch (option) {
                case 1 ->  {
                    this.showMessage("Create new Product");
                    Integer code=InputUtil.getInteger("Enter Code: ");
                    String name=InputUtil.getText("Enter name : ");
                    Double priceIn=InputUtil.getFloatingPoint("Enter price in : ");
                    CreateProductDto createProductDto = new CreateProductDto(code, name, priceIn);
                    ProductDto productDto = controller.handleCreateNewProduct(createProductDto);
                    this.showMessage("Product is created successfully");
                    ProductListView.single(productDto);
                }
                case 2 ->  {
                    this.showMessage("Products have been found successfully");
                    ProductListView.list(controller.handleProductList());
                }
                case 3 ->  {
                    UUID uuid=UUID.fromString(InputUtil.getText("Enter UUID: "));
                    controller.handleRemoveByID(uuid);
                }
                case 4 ->  {
                    UUID uuid=UUID.fromString(InputUtil.getText("Enter UUID: "));
                    if(controller.searchById(uuid)){
                        String name=InputUtil.getText("Enter Name : ");
                        Double priceIn=InputUtil.getFloatingPoint("Enter Price In : ");
                        controller.handleUpdateById(uuid,new UpdateProductDto(name,priceIn));
                    }else{
                        System.out.println("Search not found");
                    }
                }
                case 5 ->  {
                   String name=InputUtil.getText("Enter Name to Search : ");
                   ProductListView.list(controller.handleSearchByName(name));
                }
                case 0 ->  {
                    System.exit(0);
                }
                default -> System.out.println("Invalid option..!");
            }
            InputUtil.pressEnterToContinue();
        }while (true);
    }
}
