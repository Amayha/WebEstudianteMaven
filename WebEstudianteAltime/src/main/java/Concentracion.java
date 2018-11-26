import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

public class Concentracion {
	private PApplet app;
	private PFont roboto1, roboto2;
	private boolean estado;
	private PImage concentracion, play, stop, pause, popup, aceptar, cancelar;
	private boolean conteo, popUp, guardar;
	private int hrs = 0;
	private int min = 0;
	private int seg = 0;
	private int contador;
	int dias;

	private boolean estado1 = false;

	public Concentracion(PApplet app) {
		this.app = app;
		concentracion = app.loadImage("concentracion.png");
		play = app.loadImage("start.png");
		stop = app.loadImage("stop.png");
		popup = app.loadImage("conpop.png");
		aceptar = app.loadImage("aceptar.png");
		cancelar = app.loadImage("cancelar.png");
		pause = app.loadImage("pausa.png");
		roboto1 = app.createFont("Roboto-Bold.ttf", 20);
		estado = false;
		roboto2 = app.createFont("Roboto-Regular.ttf", 20);
		guardar = false;
		time();
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
		app.fill(0);
		app.textSize(60);

		app.textAlign(app.CENTER);
		app.text(hrs, 472, 398);
		app.text(min, 648, 398);
		app.text(seg, 833, 398);
		app.text(":", 552, 398);
		app.text(":", 736, 398);

		app.textAlign(app.CORNER);

		if (popUp == true) {
			app.fill(0, 30);
			app.rect(0, 0, app.width, app.height);
			app.image(popup, 491, 250);
			app.image(aceptar, 663, 463.19f);
			app.image(cancelar, 513, 463.19f);
			if (app.mouseX > 660 && app.mouseX < 775 && app.mouseY > 460 && app.mouseY < 505) {
				app.tint(0, 0, 255, 30);
				app.image(aceptar, 663, 463.19f);
				app.noTint();
			}
			if (app.mouseX > 513 && app.mouseX < 620 && app.mouseY > 463 && app.mouseY < 505) {
				app.tint(200, 40);
				app.image(cancelar, 513, 463.19f);
				app.noTint();
			}
		}
	}

	public void time() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					try {
						if (estado) {
							seg++;
						}

						if (seg > 59) {
							seg = 0;
							min++;
						}

						if (min > 59) {
							min = 0;
							hrs++;
						}

						if (hrs > 24) {
							hrs = 0;
							dias++;
						}

						/*
						 * if(seg >= 5 && seg <= 59) { estado = false;
						 * System.out.println("pareeeee, pareee que me quiero bajaaar"); }
						 */

						Thread.sleep(1000);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}

			}
		}).start();

	}

	public void mouse() {
		// reanudar o pausa
		if (app.mouseX > 600 && app.mouseX < 700 && app.mouseY > 555 && app.mouseY < 650 && popUp == false) {
			conteo = !conteo;
			estado = !estado;
		}
		// darle stop
		if (app.mouseX > 700 && app.mouseX < 730 && app.mouseY > 620 && app.mouseY < 670 && conteo == true
				&& popUp == false) {
			popUp = true;
			estado = !estado;
		}
		// guardar tiempo
		if (app.mouseX > 660 && app.mouseX < 775 && app.mouseY > 460 && app.mouseY < 505) {
			guardar = true;
			popUp = false;
			hrs = 0;
			min = 0;
			conteo = false;
			seg = 0;
		}
		// cancelar guardado de tiempo
		if (app.mouseX > 513 && app.mouseX < 620 && app.mouseY > 463 && app.mouseY < 505) {
			popUp = false;
			estado = !estado;
		}
	}

	public boolean isGuardar() {
		return guardar;
	}

	public void setGuardar(boolean guardar) {
		this.guardar = guardar;
	}
}
