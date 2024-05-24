package is2epd8;


import controlador.ContactoController;
import controlador.ContactoControllerImpl;
import java.util.ArrayList;
import java.util.List;
import modelo.ContactoModel;
import modelo.ContactoModelImpl;
import vista.ContactoView;
import vista.ContactoViewImpl;

public class Experimento {


    
    public static void main(String[] args) {

        ContactoModel model = new ContactoModelImpl();
        List<ContactoView> views= new ArrayList<ContactoView>();        
         ContactoView view1 = new ContactoViewImpl();
         views.add(view1);
        //ContactoView view2 = new ContactoViewImpl();
        //views.add(view2);

        ContactoController controller = new ContactoControllerImpl();
        
        controller.setup(model, views);
        controller.start();
    }

}
