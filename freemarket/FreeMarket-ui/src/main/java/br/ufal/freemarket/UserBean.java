package br.ufal.freemarket;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


/**
 *
 * @author hotaviano
 */
@ManagedBean
@RequestScoped
public class UserBean implements Serializable {
    
    private Long value;
    
    public List<TesteData> getDatas() {
        List<TesteData> datas = new ArrayList<>();
        datas.add(new TesteData(1L, "Teste 1"));
        datas.add(new TesteData(2L, "Teste 2"));
        datas.add(new TesteData(3L, "Teste 3"));
        datas.add(new TesteData(4L, "Teste 4"));
        datas.add(new TesteData(5L, "Teste 5"));
        datas.add(new TesteData(6L, "Teste 6"));
        
        return datas;
    }
    
    public static class TesteData implements Serializable {
        private Long id;
        private String name;
        
        public TesteData() {}
        
        public TesteData(Long id, String name) {
            this.id = id;
            this.name = name;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }
    
}
