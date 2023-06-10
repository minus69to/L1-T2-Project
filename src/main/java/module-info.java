module com.example.javapart2final {
    requires javafx.controls;
    requires javafx.fxml;

        requires org.controlsfx.controls;
            requires com.dlsc.formsfx;
                    requires org.kordamp.bootstrapfx.core;

    opens com.example.javapart2final to javafx.fxml;
    exports com.example.javapart2final;
}