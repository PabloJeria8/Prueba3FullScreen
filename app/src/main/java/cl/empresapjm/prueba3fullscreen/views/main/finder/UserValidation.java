package cl.empresapjm.prueba3fullscreen.views.main.finder;

import android.content.Context;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import cl.empresapjm.prueba3fullscreen.data.CurrentUser;
import cl.empresapjm.prueba3fullscreen.data.EmailProcessor;
import cl.empresapjm.prueba3fullscreen.data.Nodes;
import cl.empresapjm.prueba3fullscreen.models.LocalUser;
import cl.empresapjm.prueba3fullscreen.models.Movie;

/**
 * Created by Pablo on 07-10-2017.
 */

public class UserValidation {

    private FinderCallback callback;
    private Context context;

    public UserValidation(FinderCallback callback, Context context) {
        this.callback = callback;
        this.context = context;
    }

    public void init(String email)
    {
        if (email.trim().length()>0)
        {
            if (email.contains("@"))
            {
                String currentEmail =  new CurrentUser().email();

                if (!email.equals(currentEmail))
                {
                    callback.error("Usuario no iniciado");
                }
                    else
                {
                    findUser(email);
                }
            }
            else
            {
                callback.error("Email mal escrito");
            }

        }else
        {
            callback.error("Se necesita email");
        }
    }

    private void findUser(final String email)
    {
        new Nodes().user(new EmailProcessor().sanitizedEmail(email)).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                LocalUser localUser = dataSnapshot.getValue(LocalUser.class);
                if (localUser!=null)
                {
                    createMovies(email);
                    callback.success();
                }else
                {
                    callback.notFound();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void createMovies(String email) {

        String emails = new EmailProcessor().sanitizedEmail(email);

        String key = FirebaseDatabase.getInstance().getReference().child("movies").push().getKey();
        Movie movie = new Movie();
      /*  Movie movielist = new Movie();*/
        movie.setUid(key);
        movie.setDone(true);
        movie.setTitle("BLADE RUNNER 2049");
        movie.setDescription("Han pasado 30 años desde los acontecimientos ocurridos en Blade Runner (1982). El oficial K (Ryan Gosling), un blade runner caza-replicantes del Departamento de Policía de Los Ángeles, descubre un secreto que ha estado enterrado durante mucho tiempo y que tiene el potencial de llevar a la sociedad al caos. Su investigación le conducirá a la búsqueda del legendario Rick Deckard (Harrison Ford), un antiguo blade runner en paradero desconocido, que lleva desaparecido 30 años.");
        new Nodes().movies().child(key).setValue(movie);

        String key2 = FirebaseDatabase.getInstance().getReference().child("movies").push().getKey();
        Movie movie2 = new Movie();
        movie2.setUid(key2);
        movie2.setDone(true);
        movie2.setTitle("AMITYVILLE: EL DESPERTAR");
        movie2.setDescription("Una ambiciosa becaria en un programa de noticias dirige a un equipo de periodistas, clérigos e investigadores paranormales en una investigación sobre el caso más famoso de casas embrujadas en el mundo.");
        new Nodes().movies().child(key2).setValue(movie2);

        String key3 = FirebaseDatabase.getInstance().getReference().child("movies").push().getKey();
        Movie movie3 = new Movie();
        movie3.setUid(key3);
        movie3.setDone(true);
        movie3.setTitle("IT (ESO)");
        movie3.setDescription("Cuando los niños comienzan a desaparecer en la ciudad de Derry, Maine, un grupo de niños pequeños confrontan sus mayores temores al enfrentarse a un malvado payaso llamado Pennywise, cuya historia de asesinato y violencia data de siglos. \"IT (Eso)\" es protagonizada por Bill Skarsgård como el villano central de la historia, Pennywise. Un conjunto de actores jóvenes también protagonizan la película, incluyendo a Jaeden Lieberher, Jeremy Ray Taylor, Sophia Lillis, Finn Wolfhard , Wyatt Oleff, Chosen Jacobs, Jack Dylan Grazer y Nicholas Hamilton.");
        new Nodes().movies().child(key3).setValue(movie3);

        callback.success();
    }



}
