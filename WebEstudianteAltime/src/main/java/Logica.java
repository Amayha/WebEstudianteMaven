import processing.core.PApplet;
import processing.core.PImage;

public class Logica {
	private PApplet app;
	private int pantalla;
	private Home home;
	private Calendario calen;
	private Concentracion con;
	private Usuario us;
	private int encima;
	private PImage nav, barra, cuaLog, casa, casa2, estu, estu2, cal, cal2, ojo, lupa, buscador, estu3;

	public Logica(PApplet app) {
		this.app = app;

		pantalla = 2;
		home = new Home(app);
		calen = new Calendario(app);
		con = new Concentracion(app);
		us = new Usuario(app);
		buscador = app.loadImage("buscador.png");
		lupa = app.loadImage("buscar.png");
		nav = app.loadImage("barra-nav.png");
		barra = app.loadImage("barra-arriba.png");
		estu3 = app.loadImage("estubar.png");
		cuaLog = app.loadImage("cuadros-logo.png");
		casa = app.loadImage("home.png");
		estu = app.loadImage("estu.png");
		estu2 = app.loadImage("estu2.png");
		cal2 = app.loadImage("cal2.png");
		cal = app.loadImage("cal.png");
		casa2 = app.loadImage("ppal.png");
		ojo = app.loadImage("ojo.png");
		encima = 1;
	}

	public void pintar() {
		if (pantalla != 0) {
			navegacion();
		}

		switch (pantalla) {
		case 0:

			break;
		case 1:
			home.pintar();
			break;
		case 2:
			calen.pintar();
			break;
		case 3:

			us.pintar();
			if (us.isConcentrarse() == true) {
				pantalla++;
				us.setConcentrarse(!us.isConcentrarse());
			}

			break;
		case 4:

			con.pintar();
			if (con.isGuardar() == true) {
				pantalla--;
				con.setGuardar(!con.isGuardar());
			}
			break;
		}
		if (app.mouseX > 20 && app.mouseX < 70 && app.mouseY > 130 && app.mouseY < 200) {
			encima = 1;
		} else if (app.mouseX > 20 && app.mouseX < 70 && app.mouseY > 240 && app.mouseY < 300) {
			encima = 2;
		} else if (app.mouseX > 20 && app.mouseX < 70 && app.mouseY > 360 && app.mouseY < 410) {
			encima = 3;
		} else {
			encima = 0;
		}
	}

	public void mouse() {
		System.out.println(app.mouseX + " " + app.mouseY);
		if (pantalla != 0) {
			if (app.mouseX > 20 && app.mouseX < 70 && app.mouseY > 130 && app.mouseY < 200) {
				pantalla = 1;
			}
			if (app.mouseX > 20 && app.mouseX < 70 && app.mouseY > 240 && app.mouseY < 300) {
				pantalla = 2;
			}
			if (app.mouseX > 20 && app.mouseX < 70 && app.mouseY > 350 && app.mouseY < 420) {
				pantalla = 3;
			}

		}
		switch (pantalla) {
		case 0:

			break;
		case 1:
			home.mouse();
			break;
		case 2:
			calen.mouse();
			break;
		case 3:
			us.mouse();
			break;
		case 4:
			con.mouse();
			break;
		}
	}

	public void navegacion() {
		app.image(nav, 0, 0);
		app.image(barra, 112, 19);
		app.image(ojo, 26, 19);
		app.image(casa2, 29, 149);
		app.image(cal, 28.16f, 258.57f);
		app.image(estu2, 32.85f, 372.65f);
		app.image(estu, 1086, 32);
		app.fill(226, 166, 14);
		app.textSize(20);
		app.text("Estudiante", 985, 63);
		app.image(lupa, 923, 44);
		app.image(buscador, 630, 36);
		app.fill(144, 144, 144);
		app.text("Buscar", (float) 649.73, 60);
		if (pantalla != 0 && pantalla != 4) {
			if (pantalla == 1 || encima == 1) {
				app.image(cuaLog, 6, 124);
				app.image(casa, 29, 149);
				app.fill(209, 59, 78);
				app.textSize(18);
				app.text("Inicio", 22, 226);
			}
			if (pantalla == 2 || encima == 2) {
				app.image(cuaLog, 6, 231);
				app.image(cal2, 28.16f, 258.57f);
				app.fill(241, 135, 104);
				app.textSize(16);
				app.text("Calendario", 6, 330);
			}
			if (pantalla == 3 || encima == 3) {
				app.image(cuaLog, 6, 349);
				app.image(estu3, 32.85f, 372.65f);
				app.textSize(17);
				app.fill(254, 200, 42);
				app.text("Perfil", 23, 450);
			}
		}
	}
}