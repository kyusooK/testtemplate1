package edittemplate.external;

import java.util.Date;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "inventory", url = "${api.url.inventory}")
public interface ProductService {
    @RequestMapping(method = RequestMethod.POST, path = "/products")
    public void decreaseStock(@RequestBody Product product);

    @GetMapping(path = "/products/search/findByGetStock")
    public Product getStock(@PathVariable("id") Long id);
}
