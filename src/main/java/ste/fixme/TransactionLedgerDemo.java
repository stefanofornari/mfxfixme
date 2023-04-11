package ste.fixme;

import io.github.palexdev.materialfx.dialogs.MFXGenericDialog;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.scene.layout.Pane;
import javafx.util.Callback;
//import org.scenicview.ScenicView;

/**
 * NOTES:
 * <ul>
 * <li>only one column for now can be selected for sorting; this is because we
 * can not (yet) tell which column should be used first (ordering by column 1
 * and then column 2 is different that ordering by column 2 first and then by
 * column 1.</li>
 * </ul>
 */
public class TransactionLedgerDemo extends Application {

    private static final Wallet WALLET = new Wallet("1489a7dd02ca2294ed999cfc175050c852851dec");
    private static final String TITLE = String.format("0x%s's incoming token transfers", "1489a7dd02ca2294ed999cfc175050c852851dec");

    @Override
    public void start(Stage stage) throws Exception {
/*
        Pane main = (Pane) TransactionLedgerDemo.loadLedgerDialogContent(new Wallet("01d34567890123456789012345678901234567890"), null);

        Scene scene = new Scene(main);
        stage.setScene(scene);
        stage.setTitle(TITLE);
        stage.show();

        final LedgerController controller = (LedgerController) main.getUserData();

        //
        // Just for demo purposes, let's set a small page size
        //
        controller.source().pageSize(20);

        controller.fetch();
//        ScenicView.show(scene);  // to use it, enable the dependency in pom.xml
*/
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TransactionLedgerDemo.class.getResource(fxml));
        return fxmlLoader.load();
    }

    public static void main(String[] args) throws Exception {
        launch();
    }

    public static Pane loadLedgerDialogContent(
            final Wallet wallet,
            final MFXGenericDialog dialog
    ) {
        return loadPane(
                "/fxml/LedgerDialog.fxml",
                new Callback<Class<?>, Object>() {
            /* controllerFactory */
            @Override
            public Object call(Class<?> p) {
                throw new RuntimeException("Fix me!");
                //return new LedgerController(dialog, new LedgerSource(wallet));
            }
        }
        );
    }

    public static Pane loadPane(String resource, Callback<Class<?>, Object> controllerFactory) {
        try {
            final Object[] controllerWrapper = new Object[1];

            Pane pane = FXMLLoader.load(
                    EditDialogDemo.class.getResource(resource),
                    null, /* resourceBundle */
                    null, /* builderFactory */
                    new Callback<Class<?>, Object>() {
                @Override
                public Object call(Class<?> p) {
                    return (controllerWrapper[0] = controllerFactory.call(p));
                }
            }
            );

            pane.setUserData(controllerWrapper[0]);

            return pane;
        } catch (IOException x) {
            //
            // TODO: better handling of this exception
            throw new RuntimeException("unable to load FXML " + resource, x);
        }
    }

}
