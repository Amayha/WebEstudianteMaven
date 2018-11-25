import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

public class Calendario {
	private PApplet app;
	private PFont roboto1, roboto2;
	private PImage cuadroBuho, buho, mas, calbar, calbar2, eliminar, popup, guardar;
	private boolean evento, text1, text2;

	public Calendario(PApplet app) {
		this.app = app;
		roboto1 = app.createFont("Roboto-Bold.ttf", 20);
		roboto2 = app.createFont("Roboto-Regular.ttf", 20);
		cuadroBuho = app.loadImage("cuadroBuho.png");
		buho = app.loadImage("buhocal.png");
		mas = app.loadImage("calevent.png");
		calbar = app.loadImage("calbar.png");
		calbar2 = app.loadImage("calbar2.png");
		eliminar = app.loadImage("eliminar.png");
		guardar = app.loadImage("boton.png");
		popup = app.loadImage("popup.png");
		evento = false;
		text1 = false;
		text2 = false;
	}

	public void pintar() {
		app.image(cuadroBuho, 112, 121);
		app.image(buho, 114, 121);
		app.image(mas, 157, 28);
		if (app.mouseX > 155 && app.mouseX < 210 && app.mouseY > 30 && app.mouseY < 80) {
			app.tint(255, 0, 0, 40);
			app.image(mas, 157, 28);
			app.noTint();
		}
		app.image(calbar2, 112, 408);
		app.image(calbar, 112, 370);
		app.image(eliminar, 230, 560);
		app.fill(255, 138, 102);
		app.textSize(12);
		app.text("Eliminar", 221, 610);
		// esto es lo que sale al darle al +
		if (evento == true) {
			app.fill(0, 100);
			app.rect(0, 0, app.width, app.height);
			app.image(popup, 401, 240);
			app.image(guardar, 792, 398);
			if (app.mouseX > 704 && app.mouseX < 775 && app.mouseY > 400 && app.mouseY < 430) {
				app.fill(0);
			} else {
				app.fill(116, 111, 125);
			}
			app.textSize(18);
			app.text("Cancelar", 705, 420);
			if (text1 == true) {
				app.fill(0);
				app.text("Evento 1", 443, 326);
			} else {
				app.fill(196, 196, 196);
				app.text("Nombre su evento", 443, 326);
			}

			if (text2 == true) {
				app.fill(0);
				app.text("Hacer lectura", 443, 382);
			} else {
				app.fill(196, 196, 196);
				app.text("Descripci�n corta", 443, 382);
			}
			if (app.mouseX > 790 && app.mouseX < 890 && app.mouseY > 400 && app.mouseY < 430) {
				app.tint(255, 0, 0, 30);
				app.image(guardar, 792, 398);
				app.noTint();
			}
		}

	}

	public void mouse() {
		// presionar el + de agregar evento
		if (app.mouseX > 155 && app.mouseX < 210 && app.mouseY > 30 && app.mouseY < 80) {
			evento = true;
		}
		// presiona boton guardar;
		if (app.mouseX > 790 && app.mouseX < 890 && app.mouseY > 400 && app.mouseY < 430) {
			evento = false;
		}
		// presiona boton cancelar
		if (app.mouseX > 704 && app.mouseX < 775 && app.mouseY > 400 && app.mouseY < 430) {
			evento = false;
		}
		if (app.mouseX > 440 && app.mouseX < 600 && app.mouseY > 310 && app.mouseY < 330) {
			text1 = true;
		}
		if (app.mouseX > 440 && app.mouseX < 600 && app.mouseY > 365 && app.mouseY < 385) {
			text2 = true;
		}

	}
}
