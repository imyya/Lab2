package com.example.sb_online_shop;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.sb_online_shop.Domaine.CustomerRepository;
import com.example.sb_online_shop.Domaine.Item;
import com.example.sb_online_shop.Domaine.ItemRepository;
import com.example.sb_online_shop.Domaine.OrderRepository;
import com.example.sb_online_shop.Domaine.Product;
import com.example.sb_online_shop.Domaine.ProductRepository;
import com.example.sb_online_shop.Domaine.Order;
import com.example.sb_online_shop.Domaine.Customer;


@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);
	private final CustomerRepository crepository;
	private final OrderRepository orepository;
	private final ProductRepository pRepository;
	private final ItemRepository iRepository;

	public DemoApplication(CustomerRepository cRepository, OrderRepository oRepository, ProductRepository pRepository, ItemRepository iRepository){
		this.crepository = cRepository;
		this.orepository = oRepository;
		this.pRepository=pRepository;
		this.iRepository=iRepository;

	}
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		logger.info("Online Shop started at http://localhost:8080/");
	}

	@Override
	public void run(String... args) throws Exception {
		Customer c1 = new Customer("Bugs Bunny", "New York", 59000);
		Customer c2 = new Customer("Daffy Duck", "Los Angeles", 37000);
		Customer c3 = new Customer("Porky Pig", "Miami", 28000 );
		crepository.saveAll(Arrays.asList(c1,c2, c3));
		
		Order o1 = new Order(100, c1);
		Order o2 = new Order(300, c1);
		Order o3 = new Order(200, c2);
		Order o4 = new Order(140, c3);
		orepository.saveAll(Arrays.asList(o1, o2, o3, o4));

		Product shirt = new Product("Shirt", "A nice shirt", 200.0);
        Product phone = new Product("Phone", "A smartphone", 300.0);
        Product tv = new Product("TV", "A 50-inch TV", 400.0);
        Product shoes = new Product("Shoes", "A pair of running shoes", 200.0);
        pRepository.saveAll(Arrays.asList(shirt, phone, tv, shoes));

      
        orepository.saveAll(Arrays.asList(o1, o2, o3));

        Item i1 = new Item(1, shirt.getPrice(), shirt);
        i1.setOrder(o1);
        Item i2 = new Item(1, phone.getPrice(), phone);
        Item i3 = new Item(1, tv.getPrice(), tv);
        Item i4 = new Item(1, shoes.getPrice(), shoes);
        i2.setOrder(o2);
        i3.setOrder(o2);
        i4.setOrder(o2);
        Item i5 = new Item(1, tv.getPrice(), tv);
        Item i6 = new Item(1, phone.getPrice(), phone);
        Item i7 = new Item(1, shoes.getPrice(), shoes);
        i5.setOrder(o3);
        i6.setOrder(o3);
        i7.setOrder(o3);
        iRepository.saveAll(Arrays.asList(i1, i2, i3, i4, i5, i6, i7));

		int i_order = 0;
		System.out.println("----- All Orders ------");

		for (Order o : orepository.findAll()) {
			i_order++;
			System.out.print("customer " + o.getCustomer().getFullname() + " : order " + o.getId() + " : " + o.getTotal() + "$ : [");
			o.getItems().forEach(item -> System.out.print(item.getProduct().getName() + "(" + item.getPrice() + "$) "));
			System.out.println("]");
			
			}
			
			System.out.println(" ");
		
		System.out.println("-----             ------");

	}

}
