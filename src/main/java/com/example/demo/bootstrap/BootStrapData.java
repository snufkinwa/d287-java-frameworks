package com.example.demo.bootstrap;

import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.InhousePart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository = outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadSampleData();
    }

    public void loadSampleData() {
        if (partRepository.count() == 0 && productRepository.count() == 0) {

            InhousePart processor = new InhousePart();
            processor.setName("Intel Core i7 Processor");
            processor.setPrice(987.99);
            processor.setInv(35);
            processor.setMinInv(5);
            processor.setMaxInv(30);
            processor.setPartId(1);
            partRepository.save(processor);

            InhousePart motherboard = new InhousePart();
            motherboard.setName("ASUS Prime Z390-A Motherboard");
            motherboard.setPrice(287.99);
            motherboard.setInv(4);
            motherboard.setMinInv(5);
            motherboard.setMaxInv(25);
            motherboard.setPartId(2);
            partRepository.save(motherboard);

            InhousePart ram = new InhousePart();
            ram.setName("Corsair Vengeance LPX 32GB (2x16GB) DDR4 3200MHz");
            ram.setPrice(187.99);
            ram.setInv(7);
            ram.setPartId(3);
            ram.setMinInv(5);
            ram.setMaxInv(30);
            partRepository.save(ram);

            OutsourcedPart graphicsCard = new OutsourcedPart();
            graphicsCard.setName("NVIDIA GeForce RTX 4080 TI");
            graphicsCard.setPrice(2987.99);
            graphicsCard.setInv(14);
            graphicsCard.setMinInv(8);
            graphicsCard.setMaxInv(25);
            graphicsCard.setCompanyName("Some Manufacturer");
            outsourcedPartRepository.save(graphicsCard);

            OutsourcedPart psu = new OutsourcedPart();
            psu.setName("Corsair CX750M 750W 80+ Bronze Certified Fully Modular PSU");
            psu.setPrice(87.99);
            psu.setInv(12);
            psu.setMinInv(5);
            psu.setMaxInv(30);
            psu.setCompanyName("Another Manufacturer");
            outsourcedPartRepository.save(psu);

            processor.validateInventory();
            motherboard.validateInventory();
            ram.validateInventory();
            graphicsCard.validateInventory();
            psu.validateInventory();


            Product supremeGamingBeast = new Product("Supreme Gaming Beast", 9999.99, 14);
            Product epicGamingArsenal = new Product("Epic Gaming Arsenal", 8543.99, 12);
            Product legendaryGamingRig = new Product("Legendary Gaming Rig", 7897.99, 10);
            Product mightyGamingFortress = new Product("Mighty Gaming Fortress", 6879.99, 11);
            Product eliteGamingCitadel = new Product("Elite Gaming Citadel", 4356.99, 28);


            productRepository.save(supremeGamingBeast);
            productRepository.save(epicGamingArsenal);
            productRepository.save(legendaryGamingRig);
            productRepository.save(mightyGamingFortress);
            productRepository.save(eliteGamingCitadel);

       /*
        OutsourcedPart o= new OutsourcedPart();
        o.setCompanyName("Western Governors University");
        o.setName("out test");
        o.setInv(5);
        o.setPrice(20.0);
        o.setId(100L);
        outsourcedPartRepository.save(o);
        OutsourcedPart thePart=null;
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            if(part.getName().equals("out test"))thePart=part;
        }

        System.out.println(thePart.getCompanyName());
        */

            List<OutsourcedPart> outsourcedParts = (List<OutsourcedPart>) outsourcedPartRepository.findAll();
            for (OutsourcedPart part : outsourcedParts) {
                System.out.println(part.getName() + " " + part.getCompanyName());
            }

        /*
        Product bicycle= new Product("bicycle",100.0,15);
        Product unicycle= new Product("unicycle",100.0,15);
        productRepository.save(bicycle);
        productRepository.save(unicycle);
        */

            System.out.println("Started in Bootstrap");
            System.out.println("Number of Products" + productRepository.count());
            System.out.println(productRepository.findAll());
            System.out.println("Number of Parts" + partRepository.count());
            System.out.println(partRepository.findAll());

        }
    }
}
