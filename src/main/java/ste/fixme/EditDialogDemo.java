package ste.fixme;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.dialogs.MFXGenericDialog;
import javafx.scene.layout.Pane;
import javafx.util.Callback;

/**
 * NOTES:
 * <ul>
 *  <li>only one column for now can be selected for sorting; this is because we can
 *   not (yet) tell which column should be used first (ordering by column 1 and
 *   then column 2 is different that ordering by column 2 first and then by
 *   column 1.</li>
 * </ul>
 */
public class EditDialogDemo extends Application {

    private static final Wallet WALLET = new Wallet("1489a7dd02ca2294ed999cfc175050c852851dec");
    private static final String TITLE = String.format("0x%s's incoming token transfers", "1489a7dd02ca2294ed999cfc175050c852851dec");

    @Override
    public void start(Stage stage) throws Exception {

        Pane mainWindow = new Pane();
        MFXButton button = new MFXButton("CLICK ME");
        mainWindow.getChildren().add(button);

        Scene scene = new Scene(mainWindow);
        stage.setScene(scene);
        stage.setTitle(TITLE);
        stage.show();

        button.onActionProperty().setValue((event) -> {
            new EditWalletDialog(mainWindow, WALLET).showAndWait();
        });
    }

    public static Pane loadEditWalletDialogContent(
        final MFXGenericDialog dialog
    ) {
        return loadPane(
            "/fxml/EditWalletDialog.fxml",
            new Callback<Class<?>, Object>() {
                /* controllerFactory */
                @Override
                public Object call(Class<?> p) {
                    return new EditWalletController(dialog);
                }
            });
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

    public static void main(String[] args) {
        launch(args);
    }
}
