import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Date;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

public class Home {
	private PApplet app;
	private Date fecha;
	private String dia;
	private PImage buho;
	private PFont roboto1, roboto2;
	private PImage contenedorNoti, cuadros_notas, rosa, noti, noti2, scroll, notis, estrella;
	FirebaseDatabase db;
	DatabaseReference referencia;
	FileInputStream serviceAccount;
	ArrayList<Noticia> noticias; 


	public Home(PApplet app) {
		this.app = app;
		roboto1 = app.createFont("Roboto-Bold.ttf", 20);
		roboto2 = app.createFont("Roboto-Regular.ttf", 20);
		fecha = new Date();
		buho = app.loadImage("Buho-estudianto.png");
		cuadros_notas = app.loadImage("cuadros-notas.png");
		contenedorNoti = app.loadImage("contenedor-notificaciones.png");
		rosa = app.loadImage("rosa.png");
		noti = app.loadImage("notificacion.png");
		noti2 = app.loadImage("notificacion2.png");
		scroll = app.loadImage("scroll-bar.png");
		notis = app.loadImage("notis.png");
		estrella = app.loadImage("estrella.png");
		
		noticias = new ArrayList<Noticia>();
		
		try {
			serviceAccount = new FileInputStream("altime-c395e-firebase-adminsdk-k12xi-56b27b28a8.json");

			FirebaseOptions options = new FirebaseOptions.Builder()
					.setCredentials(GoogleCredentials.fromStream(serviceAccount))
					.setDatabaseUrl("https://altime-c395e.firebaseio.com/").build();

			FirebaseApp.initializeApp(options);

			// paso 1 para vincular la base de datos
			db = FirebaseDatabase.getInstance();
			// paso 2 crear la consulta a la base de datos
			referencia = db.getReference().child("noticias");// cambiar referencia

			referencia.addValueEventListener(new ValueEventListener() {
				
				public void onDataChange(DataSnapshot dataSnapshot) {
					System.out.println("Llego nodo de Firebase " + dataSnapshot.getKey());
					for (DataSnapshot ds : dataSnapshot.getChildren())
			        {
						System.out.println("Llego nodo de Firebase " );
			            Noticia noticia = ds.getValue(Noticia.class);
			            System.out.println("Llego nodo de Firebase "  + noticia.getTiponoticia());
			            System.out.println("Llego nodo de Firebase "  + noticia.getTexto());

			            noticias.add(noticia);
			            
			            //noticias.add(noticia);
			        }
					// llenarArreglo(dataSnapshot);
					System.out.println("Ejecuto setAdapter...!!!");
				}

			
				public void onCancelled(DatabaseError databaseError) {

				}
			});
			System.out.println("Esperando ... ");
			Thread.sleep(10000);
			System.out.println("Successfully created new user: ");

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

	public void pintar() {
		app.image(cuadros_notas, 190, 124);
		app.image(cuadros_notas, 497, 124);
		app.image(cuadros_notas, 804, 124);
		app.image(contenedorNoti, 190, 327);
		app.image(rosa, 192, 327);
		app.image(noti, 238, 393);
		
		//app.image(notis, 258.95f, 396f);
//		app.image(scroll, 751, 394);
		for (int i = 0; i < 2; i++) {
			app.image(noti2, 238, noti2.height * i + 481);
		}
		switch (fecha.getDay()) {
		case 1:
			dia = "LUN";
			break;
		case 2:
			dia = "MAR";
			break;
		case 3:
			dia = "MIE";
			break;
		case 4:
			dia = "JUE";
			break;
		case 5:
			dia = "VIE";
			break;
		case 6:
			dia = "SAB";
			break;
		case 0:
			dia = "DOM";
			break;
		}
		app.noStroke();
		app.fill(232, 71, 91);
		app.textFont(roboto1);
		app.text(dia, 230, 178);
		app.textFont(roboto2);
		app.ellipse(209 + (74 / 2), 188 + (74 / 2), 74, 74);
		app.fill(255);
		app.textSize(30);
		app.text(fecha.getDate(), 229, 236);
		app.textSize(17);
		app.fill(50);

		app.text("Apuntes de afan?", 561, 177);

		app.fill(241, 135, 105);
		app.text("Agrega un evento para hoy \nrapidamente--->", 533, 224);

		app.textSize(24);
		app.fill(50);
		app.text("Mucho trabajo?", 827, 177);
		app.textSize(18);
		app.text("Recientementre estas \ntrabajando bastante en:", 827, 210);
		app.fill(226, 166, 14);
		app.text("Comunicacion Oral y \nEscrita 1: Ensayo - 30 Min", 827, 265);

		app.fill(116, 111, 125);
		app.textSize(16);
		app.text("No tienes ningun \nevento planeado \npara hoy.", 295, 204);
		app.textSize(24);
		app.fill(255);
		app.text("Tus Notificaciones", 385, 361);
		app.image(buho, 873, 394);
		
		// estrella
		
		app.image(estrella,265 , 410);
		
		app.fill(116, 111, 125);
		app.textSize(14);
		// noticia 1 -- info del buho 
		app.text(noticias.get(0).getTexto(), 335, 440);
		app.text(noticias.get(0).getDiasemana(), 289, 500);
		app.text(noticias.get(0).getNumerodia(), 289, 522);
		
		// noticia 2 
		app.text(noticias.get(1).getTexto(), 355, 530);
		app.text(noticias.get(1).getDiasemana(), 289, 515);
		app.text(noticias.get(1).getNumerodia(), 289, 530);
		
		// noticia 3  
		app.text(noticias.get(2).getTexto(), 355, 610);
		app.text(noticias.get(2).getDiasemana(), 289, 595);
		app.text(noticias.get(2).getNumerodia(), 289, 610);
		
		
	}

	public void mouse() {
		// TODO Auto-generated method stub

	}

}
