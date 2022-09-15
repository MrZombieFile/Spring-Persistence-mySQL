package cat.itacademy.barcelonactiva.adria.s04.t02.n01.S04T02N01Adria.controllers;

import cat.itacademy.barcelonactiva.adria.s04.t02.n01.S04T02N01Adria.entity.Fruita;
import cat.itacademy.barcelonactiva.adria.s04.t02.n01.S04T02N01Adria.repository.FruitaRepository;
import cat.itacademy.barcelonactiva.adria.s04.t02.n01.S04T02N01Adria.service.FruitaService;
import cat.itacademy.barcelonactiva.adria.s04.t02.n01.S04T02N01Adria.service.FruitaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/fruita")
public class FruitaController {
    @Autowired
    private FruitaServiceImpl fruitaService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Fruita>> getAllAvailableFruits(@RequestParam(required = false) String name){
        try{
            List<Fruita> fruites = new ArrayList<Fruita>();
            if (name == null)
                fruitaService.findAll().forEach(fruites::add);
            else
                //fruitaService.findByTitleContaining(name).forEach(fruites::add);
            if (fruites.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(fruites, HttpStatus.OK);
        }catch(Exception exc){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Fruita> createFruita(@RequestBody Fruita fruita){
        try{
            Fruita _fruita = fruitaService.save(new Fruita(fruita.getName(), fruita.getQuantityKilos()));
            return new ResponseEntity<>(_fruita, HttpStatus.CREATED);
        }catch(Exception exc){
            System.out.println(exc.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Fruita> getFruitaById(@PathVariable("id") long id){
        Optional<Fruita> fruitaData = fruitaService.findById(id);
        if (fruitaData.isPresent()){
            return new ResponseEntity<>(fruitaData.get(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getOneByName/{name}")
    public ResponseEntity<Fruita> getFruitaById(@PathVariable("name") String name){
        Fruita fruitaData = fruitaService.findByName(name).get();
        if (fruitaData != null){
            return new ResponseEntity<>(fruitaData, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Fruita> updateFruita(@PathVariable("id") long id, @RequestBody Fruita fruita){
        Optional<Fruita> fruitaData = fruitaService.findById(id);
        if (fruitaData.isPresent()){
            Fruita _fruita = fruitaData.get();
            _fruita.setName(fruita.getName());
            _fruita.setQuantityKilos(fruita.getQuantityKilos());

            return new ResponseEntity<>(fruitaService.save(_fruita),HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<HttpStatus> deleteFruita(@PathVariable("id") long id){
        try{
            fruitaService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch(Exception exc){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

