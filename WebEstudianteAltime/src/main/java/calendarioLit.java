import java.applet.Applet;
import java.util.ArrayList;
import java.util.Date;

import processing.core.PApplet;
import processing.core.PImage;

public class calendarioLit {
	private PApplet app;
	private String[] monthNames = { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto",
			"Septiembre", "Octubre", "Noviembre", "Diciembre" };
	private int[] monthDays = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private String[] weekDays = { "Domingo", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado" };
	private int currentMonth;
	private int currentYear;
	private int[] eventos;
	private boolean clic, evento;
	private float plannerWidth;
	private float margin;

	private PImage flecha, flecha2;
	private float topLabelMargin;
	private float calendarWidth;
	private float calendarHeight;
	private float spacing;
	private int dia, mesNum;
	private String mes, curDayOfWeekName;
	private int diaSel;
	private int daysInMonth;
	private int dayOfMonth;
	private int dayOfWeek;
	private Date date;
	private int startingDayOfMonth;
	private float xoff;
	private float yoff;
	private float boxWidth;
	private float boxHeight, x, y;

	public calendarioLit(PApplet app) {
		this.app = app;
		plannerWidth = 0;
		flecha = app.loadImage("flecha.png");
		flecha2 = app.loadImage("flecha2.png");
		margin = 50;
		topLabelMargin = 100;

		calendarWidth = app.width - plannerWidth - (margin * 2);
		calendarHeight = app.height - (margin * 2) - topLabelMargin;
		spacing = 0;
		currentMonth = app.month() - 1;
		currentYear = app.year();
		evento = false;

	}

	public String getMes() {
		return mes;
	}

	void pintar() {
		// Date Metrics
		app.textAlign(app.CENTER);

		String monthName = monthNames[currentMonth];
		daysInMonth = monthDays[currentMonth];

		mes = monthNames[currentMonth];

		if (currentMonth == 1 && isLeapYear(currentYear))
			daysInMonth++;
		dayOfMonth = -1;
		dayOfWeek = -1;
		String dayOfWeekName = "";

		if (currentMonth == app.month() - 1 && currentYear == app.year()) {
			dayOfMonth = app.day();
			dayOfWeek = (new Date()).getDay();
			dayOfWeekName = weekDays[dayOfWeek];
		}

		date = new Date();
		date.setYear(currentYear);
		date.setMonth(currentMonth);
		date.setDate(1);

		startingDayOfMonth = date.getDay(); // int(7 - (dayOfMonth % 7)); //NOT WORKING!
		String startingDayOfMonthName = weekDays[startingDayOfMonth];

		// Celendar Metrics
		int numRows = app.ceil((startingDayOfMonth + daysInMonth) / 7);
		margin = 50;
		topLabelMargin = 100;
		calendarWidth = 787 - plannerWidth - (margin * 2);
		calendarHeight = 618 - (margin * 2) - topLabelMargin;
		boxWidth = (calendarWidth - (6 * spacing)) / 7;
		boxHeight = (calendarHeight - ((numRows - 1) * spacing)) / numRows;

		app.fill(204);
		app.textSize(12);
		app.fill(150);

		for (int i = 0; i < weekDays.length; i++)
			app.text(weekDays[i], margin + 348 + (spacing * i) + (boxWidth * i) + boxWidth / 2,
					margin + topLabelMargin / 10 * 7);

		app.line(margin, (float) (margin + topLabelMargin / 10 * 8.5), app.width - plannerWidth - margin,
				(float) (margin + topLabelMargin / 10 * 8.5));

		app.stroke(0);

		xoff = startingDayOfMonth;
		yoff = 0;
		for (int i = 0; i < daysInMonth; i++) {
			curDayOfWeekName = weekDays[(int) xoff];

			x = margin + 350 + (spacing * xoff) + (boxWidth * xoff);
			y = margin + topLabelMargin + (spacing * yoff) + (boxHeight * yoff);

			app.noStroke();
			app.fill(51);

			app.stroke(219, 219, 219);
			if ((i + 1) == dayOfMonth)
				app.fill(219);
			else
				app.fill(255);

			if (app.mouseX > x && app.mouseX < x + boxWidth && app.mouseY > y && app.mouseY < y + boxHeight
					&& evento == false) {
				app.fill(219);
			}

			if (app.mouseX > x && app.mouseX < x + boxWidth && app.mouseY > y && app.mouseY < y + boxHeight
					&& clic == true && evento == false) {
				diaSel = i + 1;
				mesNum = currentMonth;
				clic = false;
			}
			if (i == diaSel - 1 && currentMonth == mesNum && evento == false) {
				app.fill(241, 135, 104);
			}

			app.rect(x, y, boxWidth, boxHeight);

			app.fill(100);
			app.textSize(24);

			app.text(i + 1, x + boxWidth / 2, y + boxHeight / 2);

			app.textSize(9);

			xoff = (xoff + 1) % 7;
			if (xoff == 0)
				yoff++;
		}

		app.noStroke();
		if (plannerWidth > 50) {
			app.fill(51);

			app.stroke(0);
			app.fill(204);

		}
		app.fill(20);
		app.textSize(25);

		app.text(monthName, 245, 320);
		app.fill(150);
		app.textSize(22);
		app.text(currentYear, 245, 345);
		app.textAlign(app.CORNER);
		app.image(flecha, 159, 308);
		app.image(flecha2, 329.15f, 308);
		if (app.mouseX > 150 && app.mouseX < 170 && app.mouseY > 300 && app.mouseY < 325) {
			app.tint(0, 100);
			app.image(flecha, 159, 308);
			app.noTint();
		}

	}

	public String[] getMonthNames() {
		return monthNames;
	}

	boolean isLeapYear(int year) {
		if (year % 400 == 0)
			return true;
		else if (year % 100 == 0)
			return false;
		else if (year % 4 == 0)
			return true;
		else
			return false;
	}

	void mouse() {
		if (app.mouseX > 155 && app.mouseX < 210 && app.mouseY > 30 && app.mouseY < 80) {
			evento = true;
		}
		if (app.mouseX > 790 && app.mouseX < 890 && app.mouseY > 400 && app.mouseY < 430) {
			evento = false;
		}
		// presiona boton cancelar
		if (app.mouseX > 704 && app.mouseX < 775 && app.mouseY > 400 && app.mouseY < 430) {
			evento = false;
		}
		if (app.mouseX > 150 && app.mouseX < 170 && app.mouseY > 300 && app.mouseY < 325) {
			currentMonth--;
			if (currentMonth < 0) {
				currentYear--;
				currentMonth = 11;
			}
		}
		if (app.mouseX > 325 && app.mouseX < 340 && app.mouseY > 300 && app.mouseY < 325) {
			currentMonth++;
			if (currentMonth > 11) {
				currentYear++;
				currentMonth = 0;
			}
		}
		if (app.mouseButton == app.LEFT) {
			clic = true;
		}
	}

	int getDayInMonth(int year, int month, int dayOfWeek, int num) {
		Date date = new Date();
		date.setYear(year);
		date.setMonth(month);
		date.setDate(1);

		int startingDayOfMonth = date.getDay();

		return 7 * (dayOfWeek > startingDayOfMonth ? num - 1 : num) + (dayOfWeek) - startingDayOfMonth;
	}

	int lastDayInMonth(int year, int month, int dayOfWeek) {
		int daysInMonth = monthDays[month];
		if (month == 1 && isLeapYear(year))
			daysInMonth++;

		Date date = new Date();
		date.setYear(year);
		date.setMonth(month);
		date.setDate(daysInMonth);

		int lastDayOfMonth = date.getDay();

		return daysInMonth - (lastDayOfMonth - dayOfWeek) - (dayOfWeek - 1 > lastDayOfMonth ? 7 : 0) - 1;
	}

	boolean overPlannerScroller() {
		return (app.mouseY > margin + topLabelMargin && app.mouseY < margin + topLabelMargin + calendarHeight
				&& app.mouseX > app.width - plannerWidth - 15 && app.mouseX < app.width - plannerWidth + 5);
	}

	public int getDiaSel() {
		return diaSel;
	}

}
