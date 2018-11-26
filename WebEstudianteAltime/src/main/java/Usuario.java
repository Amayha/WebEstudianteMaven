import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

public class Usuario {
	private PApplet app;
	private PFont roboto1, roboto2;
	private PImage cuadro2, cuadro, icono, cuadroUG1, pico, cuadroUG2, conteM, conteM1, acti, actiCua, libro, bomb,
			mArt, mLibr, mCalc, mBomb, calc, art;
	private boolean materia, concentrarse;
	private float porcentaje1, porcentaje2, porcentaje3, porcentaje4;

	public Usuario(PApplet app) {
		this.app = app;
		roboto1 = app.createFont("Roboto-Bold.ttf", 20);
		roboto2 = app.createFont("Roboto-Regular.ttf", 20);
		cuadro = app.loadImage("cuadrouser.png");
		cuadro2 = app.loadImage("cuadrouser2.png");
		icono = app.loadImage("userGrande.png");
		cuadroUG1 = app.loadImage("cuadroUG1.png");
		pico = app.loadImage("pico.png");
		cuadroUG2 = app.loadImage("cuadroUG2.png");
		conteM = app.loadImage("conteM.png");
		conteM1 = app.loadImage("conteM1.png");
		acti = app.loadImage("acti.png");
		actiCua = app.loadImage("actiCua.png");
		libro = app.loadImage("libro.png");
		bomb = app.loadImage("bomb.png");
		calc = app.loadImage("calc.png");
		art = app.loadImage("arte.png");
		mArt = app.loadImage("materiaArte.png");
		mBomb = app.loadImage("materiaBombillo.png");
		mCalc = app.loadImage("materiaCalculadora.png");
		mLibr = app.loadImage("materiaLibro.png");
		materia = false;
		concentrarse = false;
		porcentaje1 = 50;
		porcentaje2 = 70;
		porcentaje3 = 60;
		porcentaje4 = 90;

	}

	public void pintar() {

		app.image(cuadro, 112, 127);
		app.image(cuadro2, 112, 399);
		app.image(icono, 128, 145);

		app.fill(116, 111, 126);
		app.textSize(16);
		app.text("Nombre", 218, 175);
		app.textSize(12);
		app.text("Usuario@Gmail.com", 218, 197);
		app.textSize(14);
		app.text("Progreso", 128, 252);

		app.image(libro, 128.73f, 262.51f);
		app.image(bomb, 128.73f, 287);
		app.image(calc, 128.73f, 314);
		app.image(art, 128.73f, 340);

		app.noStroke();

		app.textSize(9);
		app.fill(116, 111, 125);
		app.text(porcentaje1 + "%", 158 + porcentaje1 / 100 * 156f + 5, 272);
		app.text(porcentaje2 + "%", 158 + porcentaje2 / 100 * 156f + 5, 300);
		app.text(porcentaje3 + "%", 158 + porcentaje3 / 100 * 156f + 5, 327);
		app.text(porcentaje4 + "%", 158 + porcentaje4 / 100 * 156f + 5, 353);
		app.fill(91, 184, 238);
		app.rect(158, 266, porcentaje1 / 100 * 156f, 6);
		app.rect(158, 293, porcentaje2 / 100 * 156f, 6);
		app.rect(158, 320, porcentaje3 / 100 * 156f, 6);
		app.rect(158, 347, porcentaje4 / 100 * 156f, 6);
		app.textSize(12);
		app.fill(116, 111, 125);

		app.text("Coe", 340, 272);
		app.text("Log", 340, 300);
		app.text("Alge", 340, 327);
		app.text("Intro", 340, 354);

		app.textSize(16);
		app.text("Tarea nueva?", 137, 435);
		app.fill(255, 138, 102);
		app.text("Agrega una tarea \nrapidadmente  --->", 137, 463);
		if (materia == true) {
			app.image(pico, 483, 318);
			app.image(cuadroUG2, 408, 359);
			for (int i = 0; i < 3; i++) {
				app.image(acti, 449, 93 * i + 385);
				app.image(actiCua, 449, 93 * i + 388);
			}
			app.fill(30);

			app.text("Ensayo", 485, 430);
			app.text("Lectura", 485, 524);
			app.text("Escrito", 485, 616);
			app.fill(150);
			app.textSize(14);

			app.text("Usualmente te demoras:  120 min", 595, 430);
			app.text("Usualmente te demoras:  30 min", 595, 524);
			app.text("Usualmente te demoras:  60 min", 595, 616);
			if (app.mouseX > 960 && app.mouseX < 1090 && app.mouseY > 400 && app.mouseY < 440) {
				app.fill(0);
			} else {
				app.fill(30, 141, 205);
			}
			app.text("Empezar en \r\n" + "modo concentracion", 966, 417);
			if (app.mouseX > 960 && app.mouseX < 1090 && app.mouseY > 500 && app.mouseY < 540) {
				app.fill(0);
			} else {
				app.fill(30, 141, 205);
			}
			app.text("Empezar en \r\n" + "modo concentracion", 966, 524 - 13);
			if (app.mouseX > 960 && app.mouseX < 1090 && app.mouseY > 590 && app.mouseY < 630) {
				app.fill(0);
			} else {
				app.fill(30, 141, 205);
			}
			app.text("Empezar en \r\n" + "modo concentracion", 966, 616 - 13);

		}

		app.image(cuadroUG1, 408, 124);
		app.fill(116, 111, 126);
		app.textFont(roboto2);
		app.textSize(16);
		app.text("Tus materias", 735, 160);

		for (int i = 0; i < 4; i++) {
			app.image(conteM, (float) (140 * i + 450.26), 175.83f);
			if (app.mouseX > (float) (140 * i + 450.26) && app.mouseX < (float) (140 * i + 450.26) + conteM.width
					&& app.mouseY > 175 && app.mouseY < 175 + conteM.height) {
				app.image(conteM1, (float) (140 * i + 450.26), 175.83f);
			}
		}
		app.image(mLibr, 486.15f + 5, 198.02f);
		app.image(mBomb, 624.61f + 5, 197.38f);
		app.image(mCalc, 763f + 5, 199f);
		app.image(mArt, 900.71f + 5, 198.23f);
		app.fill(50);
		app.textSize(11);
		app.textAlign(app.CENTER);
		app.text("Comunicacion \noral y escrita 1", 460.05f + 50, 260.38f);
		app.text("Logica y \nargumentacion", 605.55f + 45, 260.38f);
		app.text("Algebra y \nfunciones", 755.45f + 35, 260.38f);
		app.text("Introduccion al \ndiseño", 884.24f + 45, 260.38f);
		app.textAlign(app.CORNER);

	}

	public void mouse() {
		for (int i = 0; i < 4; i++) {
			if (app.mouseX > (float) (140 * i + 450.26) && app.mouseX < (float) (140 * i + 450.26) + conteM.width
					&& app.mouseY > 175 && app.mouseY < 175 + conteM.height) {
				materia = true;
			}
		}
		if (app.mouseX > 960 && app.mouseX < 1090 && app.mouseY > 400 && app.mouseY < 440
				|| app.mouseX > 960 && app.mouseX < 1090 && app.mouseY > 500 && app.mouseY < 540
				|| app.mouseX > 960 && app.mouseX < 1090 && app.mouseY > 590 && app.mouseY < 630 && materia == true) {
			concentrarse = true;
		}

	}

	public boolean isConcentrarse() {
		return concentrarse;
	}

	public void setConcentrarse(boolean concentrarse) {
		this.concentrarse = concentrarse;
	}

}
