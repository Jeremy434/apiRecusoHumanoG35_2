package co.usa.recursohumanog35.recursohumanog35.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.recursohumanog35.recursohumanog35.model.Empleado;
import co.usa.recursohumanog35.recursohumanog35.repository.Empleadorepositorio;

@Service
public class EmpleadoServicio {
    
    @Autowired
    private Empleadorepositorio empleadorepositorio;

    public List<Empleado>getAll(){
        return empleadorepositorio.getAll();
    }

    public Optional<Empleado>getEmpleado(int id){
        return empleadorepositorio.getEmpleado(id);
    }

    public Empleado save(Empleado empleado){
        if (empleado.getNumId()==null) {
            return empleadorepositorio.save(empleado);
            
        } else {
            Optional<Empleado> consulta=empleadorepositorio.getEmpleado(empleado.getNumId());
            if (consulta.isEmpty()) {
                return empleadorepositorio.save(empleado);
                
            } else {
                return empleado;                
            }
            
        }
    }

    public Empleado update(Empleado empleado){
        if (empleado.getNumId()!=null) {
            Optional<Empleado> consulta=empleadorepositorio.getEmpleado(empleado.getNumId());
            if (!consulta.isEmpty()) {
                if (empleado.getNombre()!=null) {
                    consulta.get().setNombre(empleado.getNombre());                    
                }
                if (empleado.getEdad()!=null) {
                    consulta.get().setEdad(empleado.getEdad());
                    
                }
                if (empleado.getCiudad()!=null) {
                    consulta.get().setCiudad(empleado.getCiudad());                    
                }
                if (empleado.getSalario()!=null) {
                    consulta.get().setSalario(empleado.getSalario());
                    
                }

                return empleadorepositorio.save(consulta.get());                              
            }

            
        }
        return empleado;
    }

    public boolean deleteEmpleado(int numId){
        Optional<Empleado> consulta=empleadorepositorio.getEmpleado(numId);
        if (!consulta.isEmpty()) {
            empleadorepositorio.delete(consulta.get());
            return true;
            
        }
        return false;
    }
    

}
