package cl.empresapjm.prueba3fullscreen.data;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Pablo on 04-10-2017.
 */

public class Nodes {

    private DatabaseReference root = FirebaseDatabase.getInstance().getReference();

    public DatabaseReference users(){
        return root.child("users");
    }
    public DatabaseReference user(String key)
    {
        return users().child(key);
    }

    public DatabaseReference movies()
    {
        return root.child("movies");
    }

    public DatabaseReference moviescomment(String email){ return root.child("moviescomment").child(email);}

}
