module PassMngr {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;
    requires java.desktop;
    requires java.sql;
	requires java.xml;
	
	opens gui to javafx.fxml;

	exports gui;
    exports Main;
}
