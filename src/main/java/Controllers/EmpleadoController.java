/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.uv.DAOEmpleado;
import org.uv.Empleado;


/**
 *
 * @author Yolotzin Groth Hdez
 */



@RestController
public class EmpleadoController {
    //http://localhost:8000/empleado
    
    @Autowired
    DAOEmpleado empleadoRepository;
    
  @GetMapping("/empleado3")
    public List<Empleado> IstEmpleados(){
        return empleadoRepository.findAll();
    }
      @GetMapping("/empleado3/{id}")
    public Empleado byIdEmpleados(@PathVariable long id){
        Optional<Empleado> opt= empleadoRepository.findById(id);
        
        if(opt.isPresent())
           return opt.get();
        else
            return null;
        
    }
    
    @PostMapping("/empleado3")
    public Empleado addEmpleado(@RequestBody Empleado empleado){
        Empleado tempEmpleado=empleadoRepository.save(empleado);
        return tempEmpleado;
    }
    
    @PutMapping("/empleado3/{id}")
	public Empleado updateEmpleado(@PathVariable Long id ,@RequestBody Empleado empleado) {
		return empleadoRepository.save(empleado);
	}
    
    @DeleteMapping("/empleado3/{id}")
	public void deleteEmpleado(@PathVariable("id") Long id) {
		empleadoRepository.deleteById(id);
	}
}
