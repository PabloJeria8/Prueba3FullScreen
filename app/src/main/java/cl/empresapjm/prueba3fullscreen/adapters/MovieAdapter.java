package cl.empresapjm.prueba3fullscreen.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;

import cl.empresapjm.prueba3fullscreen.R;
import cl.empresapjm.prueba3fullscreen.data.Nodes;
import cl.empresapjm.prueba3fullscreen.models.Movie;

/**
 * Created by Pablo on 07-10-2017.
 */

public class MovieAdapter extends FirebaseRecyclerAdapter<Movie, MovieAdapter.MovieHolder> {

    private MoviesCallback callback;

    public MovieAdapter(String chatId, MoviesCallback callback) {
        super(Movie.class, R.layout.list_item_movies, MovieHolder.class, new Nodes().movies());
        this.callback = callback;
    }

    public static class MovieHolder extends RecyclerView.ViewHolder
    {
        public MovieHolder(View itemView) {
            super(itemView);
        }
    }


    @Override
    protected void populateViewHolder(MovieHolder viewHolder, Movie model, int position) {

        TextView textView = (TextView) viewHolder.itemView;
        textView.setText(model.getTitle());
    }

    @Override
    protected void onDataChanged() {
        super.onDataChanged();
        callback.update();
    }











}
