package co.usa.recursohumanog35.recursohumanog35.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.usa.recursohumanog35.recursohumanog35.model.Empleado;
import co.usa.recursohumanog35.recursohumanog35.service.EmpleadoServicio;

@RestController
@RequestMapping("/api/empleado")
public class EmpleadoControlador {
    @Autowired
    private EmpleadoServicio empleadoServicio;

    @GetMapping("/all")
    public List<Empleado>getEmpleados(){
        return empleadoServicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Empleado>getEmpleado(@PathVariable("id") int id){
        return  empleadoServicio.getEmpleado(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Empleado save(@RequestBody Empleado empleado){
        return empleadoServicio.save(empleado);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Empleado update(@RequestBody Empleado empleado){
        return empleadoServicio.update(empleado);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteEmpleado(@PathVariable("id") int numId){
        return empleadoServicio.deleteEmpleado(numId);
    }



    
}
