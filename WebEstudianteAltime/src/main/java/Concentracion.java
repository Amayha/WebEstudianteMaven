import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

public class Concentracion {
	private PApplet app;
	private PFont roboto1, roboto2;
	private boolean estado;
	private PImage concentracion, play, stop, pause;
	private boolean conteo, popUp;

	public Concentracion(PApplet app) {
		this.app = app;
		concentracion = app.loadImage("concentracion.png");
		play = app.loadImage("start.png");
		stop = app.loadImage("stop.png");

		pause = app.loadImage("pausa.png");
		roboto1 = app.createFont("Roboto-Bold.ttf", 20);
		estado = false;
		roboto2 = app.createFont("Roboto-Regular.ttf", 20);
	}

	public void pintar() {
		app.fill(230, 180);
		app.rect(0, 0, app.width, app.height);
		app.image(concentracion, 112, 111);
		if (conteo == false) {
			app.image(play, 600, 551);
		} else {
			app.image(pause, 600, 551);
			app.image(stop, 680, 620);
		}
		if (app.mouseX > 600 && app.mouseX < 705 && app.mouseY > 555 && app.mouseY < 650 && conteo == false) {
			app.tint(0, 0, 255, 20);
			app.image(play, 600, 551);

			app.noTint();
		}
		if (app.mouseX > 600 && app.mouseX < 700 && app.mouseY > 555 && app.mouseY < 650 && conteo == true) {
			app.tint(0, 0, 255, 20);
			app.image(pause, 600, 551);
			app.noTint();
		}
		if (app.mouseX > 700 && app.mouseX < 730 && app.mouseY > 620 && app.mouseY < 670 && conteo == true) {
			app.tint(0, 0, 0, 30);
			app.image(stop, 680, 620);
			app.noTint();
		}
		if (popUp == true) {
			app.fill(0, 30);
			app.rect(0, 0, app.width, app.height);
		}
	}

	public void mouse() {
		if (app.mouseX > 600 && app.mouseX < 700 && app.mouseY > 555 && app.mouseY < 650) {
			conteo = !conteo;
		}
		if (app.mouseX > 700 && app.mouseX < 730 && app.mouseY > 620 && app.mouseY < 670 && conteo == true) {
			popUp = true;
		}
	}
}

