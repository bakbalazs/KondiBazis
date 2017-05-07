// CHECKSTYLE:OFF
package hu.unideb.inf.kondibazis.ui.kezelo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hu.unideb.inf.kondibazis.szolg.interfaces.KonditeremSzolgaltatas;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremVo;
import hu.unideb.inf.kondibazis.ui.felulet.FeluletBetoltese;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

@Component
public class FoAblakKezelo implements Initializable {

	@Autowired
	private KonditeremSzolgaltatas konditeremSzolgaltatas;

	@Autowired
	private BejelentkezoKezelo bejelentkezoKezelo;

	private KonditeremVo bejelentkezettKonditerem;
	
	@FXML
	private Button berletLetrehozasaGomb;

	@FXML
	private Button tagHozzaadasaGomb;

	@FXML
	private Text konditeremNeve;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		konditeremNeve.setText(bejelentkezoKezelo.getBejelentkezettKonditerem().getKonditeremNeve());
		bejelentkezettKonditerem = bejelentkezoKezelo.getBejelentkezettKonditerem();
		System.out.println(bejelentkezettKonditerem);
	}

	@FXML
	public void berletLetrehozasa(ActionEvent event) throws IOException {
		FeluletBetoltese.BerletTestreszabasaFelulet(event);
	}

	@FXML
	public void tagHozzaadasa(ActionEvent event) throws IOException {
		FeluletBetoltese.TagHozzaadasaFelulet(event);
	}
	
	@FXML
	public void elerhetosegSzerkesztese(ActionEvent event) {
	
	}

	public KonditeremVo getBejelentkezettKonditerem() {
		return bejelentkezettKonditerem;
	}

	public void setBejelentkezettKonditerem(KonditeremVo bejelentkezettKonditerem) {
		this.bejelentkezettKonditerem = bejelentkezettKonditerem;
	}

}
