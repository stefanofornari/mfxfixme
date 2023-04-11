/*
 * EasyWallet
 * ----------
 *
 * Copyright (C) 2022 Stefano Fornari. Licensed under the
 * EUPL-1.2 or later (see LICENSE).
 *
 * All Rights Reserved.  No use, copying or distribution of this
 * work may be made except in accordance with a valid license
 * agreement from Stefano Fornari.  This notice must be
 * included on all copies, modifications and derivatives of this
 * work.
 *
 * STEFANO FORNARI MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY
 * OF THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
 * PURPOSE, OR NON-INFRINGEMENT. STEFANO FORNARI SHALL NOT BE LIABLE FOR ANY
 * DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR DISTRIBUTING
 * THIS SOFTWARE OR ITS DERIVATIVES.
 */
package ste.fixme;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTextField;
import io.github.palexdev.materialfx.dialogs.MFXGenericDialog;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TitledPane;

/**
 *
 */
public class EditWalletController extends OkCancelControllerBase {

    @FXML
    protected MFXButton searchButton;

    @FXML
    protected MFXButton searchCancelButton;

    @FXML
    protected MFXTextField mnemonicText;

    @FXML
    protected MFXTextField keyText;

    @FXML
    protected TitledPane mnemonicPane;

    private Wallet wallet;

    public void wallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public EditWalletController(final MFXGenericDialog dialog) {
        super(dialog);
    }

    @FXML
    public void initialize() {
        mnemonicPane.setExpanded(false);
    }

    @FXML
    protected void onSearchCancel(ActionEvent e) {
    }

    @FXML
    protected void onSearch(ActionEvent e) {
    }

    /**
     * Invoked when the ok button is pressed.
     *
     * @return the updated wallet
     *
     * @throws IllegalStateException if wallet has not been set
     */
    @Override
    protected Wallet onOk() throws IllegalStateException {
        return wallet;
    }
}
