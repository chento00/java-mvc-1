package co.istad.mvcap.view;

import co.istad.mvcap.dto.ProductDto;
import java.util.*;

public class ProductListView {
    public static void list(List<ProductDto> productDtoList) {
        System.out.println("My Product List");
        System.out.println("---------------");
        productDtoList.forEach(productDto -> {
            System.out.println("ID   = "+productDto.uuid());
            System.out.println("Code = " + productDto.code());
            System.out.println("Name = " + productDto.name());
            System.out.println("---------------");
        });
    }
    public static void single(ProductDto productDto){
        System.out.println("----------------------------------------");
        System.out.println("My Product");
        System.out.println("----------------------------------------");
        System.out.println("ID      = "+productDto.uuid());
        System.out.println("Code    = " + productDto.code());
        System.out.println("Name    = " + productDto.name());
    }
}
