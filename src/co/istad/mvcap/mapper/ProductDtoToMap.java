package co.istad.mvcap.mapper;

import co.istad.mvcap.dto.ProductDto;
import co.istad.mvcap.model.Product;
import java.util.function.Function;
//done
public class ProductDtoToMap implements Function<Product, ProductDto> {
    @Override
    public ProductDto apply(Product product) {
        return new ProductDto(product.getId(),product.getCode(), product.getName());
    }
}
