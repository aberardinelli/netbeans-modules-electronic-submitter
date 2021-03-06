package org.webcat.netbeans.submitter.options;

//--------------------------------------------------------------------------

import java.net.MalformedURLException;
import java.net.URL;
import org.webcat.netbeans.submitter.model.SubmitterModel;

/**
 * The visual design of the electronic submission plug-in.
 * 
 * @author Tony Allevato, based on code by Robert Poole, Rusty Todd, and
 *     Stephan McCarn
 */
final class SubmitterPanel extends javax.swing.JPanel
{
    //~ Instance/static variables .............................................

    private boolean isValid;
    private SubmitterModel model;
    private final SubmitterOptionsPanelController controller;


    //~ Constructors ..........................................................

    // ----------------------------------------------------------
    SubmitterPanel(SubmitterOptionsPanelController controller)
    {
        this.controller = controller;
        initComponents();

        model = SubmitterModel.getInstance();
        errorText.setVisible(false);
        isValid = false;
    }


    // ----------------------------------------------------------
    /**
     * Uses the model to store desired user variables.
     * If nothing is there, will leave the default values.
     */
    void load()
    {
        String emailText = model.getEmail();
        if (emailText.length() > 0)
        {
            emailTextField.setText(emailText);
        }
        
        String mailServerText = model.getMailServer();
        if (mailServerText.length() > 0)
        {
            mailServerTextField.setText(mailServerText);
        }

        String urlText = model.getSubmitUrl();
        if (urlText.length() > 0)
        {
            urlTextField.setText(urlText);
        }

        String usernameText = model.getUsername();
        if (usernameText.length() > 0)
        {
            usernameTextField.setText(usernameText);
        }

        valid();
    }


    // ----------------------------------------------------------
    /**
     * Uses the model to load defined user variables.
     */
    void store()
    {
        model.setEmail(emailTextField.getText());
        model.setMailServer(mailServerTextField.getText());
        model.setSubmitUrl(urlTextField.getText());
        model.setUsername(usernameTextField.getText());
    }
    
    
    // ----------------------------------------------------------
    /**
     * Validate the necessary fields.
     *
     * @return isValid
     */
    boolean valid()
    {
        String urlText = urlTextField.getText();

        try
        {
            URL testURL = new URL(urlText);
            isValid = true;
        }
        catch (MalformedURLException ex)
        {
            isValid = false;
            errorText.setText("Error: You must enter a well-formed URL.");
        }
        
        if (isValid)
        {
            errorText.setVisible(false);
        }
        else
        {
            errorText.setVisible(true);
        }

        return isValid;
    }
    

    // ----------------------------------------------------------
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        errorText = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        urlTextField = new javax.swing.JTextField();
        usernameTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        mailServerTextField = new javax.swing.JTextField();
        emailTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        errorText.setForeground(new java.awt.Color(255, 0, 0));
        errorText.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        org.openide.awt.Mnemonics.setLocalizedText(errorText, org.openide.util.NbBundle.getMessage(SubmitterPanel.class, "SubmitterPanel.errorText.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(SubmitterPanel.class, "SubmitterPanel.submissionURL.text")); // NOI18N

        urlTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                urlTextFieldKeyReleased(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(SubmitterPanel.class, "SubmitterPanel.username.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel4, org.openide.util.NbBundle.getMessage(SubmitterPanel.class, "SubmitterPanel.smtpServer.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel5, org.openide.util.NbBundle.getMessage(SubmitterPanel.class, "SubmitterPanel.emailAddress.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(SubmitterPanel.class, "SubmitterPanel.jLabel1.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel6, org.openide.util.NbBundle.getMessage(SubmitterPanel.class, "SubmitterPanel.jLabel6.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(errorText)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(usernameTextField)
                            .addComponent(urlTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                            .addComponent(mailServerTextField)
                            .addComponent(emailTextField)))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(urlTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mailServerTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorText, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void urlTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_urlTextFieldKeyReleased
        valid();
        controller.changed();
    }//GEN-LAST:event_urlTextFieldKeyReleased

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField emailTextField;
    private javax.swing.JLabel errorText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField mailServerTextField;
    private javax.swing.JTextField urlTextField;
    private javax.swing.JTextField usernameTextField;
    // End of variables declaration//GEN-END:variables
}
