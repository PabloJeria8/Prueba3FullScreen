package cl.empresapjm.prueba3fullscreen.views.main.drawer;

import android.content.Context;
import android.net.Uri;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import cl.empresapjm.prueba3fullscreen.data.CurrentUser;
import cl.empresapjm.prueba3fullscreen.data.EmailProcessor;
import cl.empresapjm.prueba3fullscreen.data.Nodes;
import cl.empresapjm.prueba3fullscreen.data.PhotoPreference;
import cl.empresapjm.prueba3fullscreen.models.LocalUser;

/**
 * Created by Pablo on 04-10-2017.
 */

public class UploadPhoto {

    private Context context;

    public UploadPhoto(Context context) {
        this.context = context;
    }

    public void toFirebase(String path){
        final CurrentUser currentUser = new CurrentUser();
        String folder = new EmailProcessor().sanitizedEmail(currentUser.email()+"/");
        /*String folder = currentUser.sanitizedEmail(currentUser.email()+"/");*/
        String photoName = "avatar.jpeg";
        String baseUrl = "gs://examples-2f445.appspot.com//avatars/";
        String redUrl = baseUrl+folder+photoName;

        StorageReference storageReference = FirebaseStorage.getInstance().getReferenceFromUrl(redUrl);
        storageReference.putFile(Uri.parse(path)).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                @SuppressWarnings("VisibleForTests") String[] fullUrl = taskSnapshot.getDownloadUrl().toString().split("&token");
                String url = fullUrl[0];

                new PhotoPreference(context).photosave(url);

                LocalUser user = new LocalUser();
                user.setEmail(currentUser.email());
                user.setName(currentUser.getCurrentUser().getDisplayName());
                user.setPhoto(url);
                user.setUid(currentUser.uid());

                String key = new EmailProcessor().sanitizedEmail(currentUser.email());
                /*String key = currentUser.sanitizedEmail(currentUser.email());*/
                /*new Nodes().users().child(key).setValue(user);*/

                new Nodes().user(key).setValue(user);
                FirebaseDatabase.getInstance().getReference().child("users").child(key).setValue(user);

            }
        });

    }

}
