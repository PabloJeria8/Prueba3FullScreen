package cl.empresapjm.prueba3fullscreen.views.movies;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cl.empresapjm.prueba3fullscreen.R;
import cl.empresapjm.prueba3fullscreen.adapters.MovieAdapter;
import cl.empresapjm.prueba3fullscreen.adapters.MoviesCallback;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoviesFragment extends Fragment implements MoviesCallback {

    private MovieAdapter adapter;
    private RecyclerView recyclerView;

    public MoviesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movies, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

/*        Movie movie = (Movie) getActivity().getIntent().getSerializableExtra(MoviesFragment.);
        String key = chat.getKey();

        recyclerView = (RecyclerView) view;
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        adapter = new MovieAdapter(chat.getKey(), this);
        recyclerView.setAdapter(adapter);*/

    }

    @Override
    public void update() {
        recyclerView.scrollToPosition(adapter.getItemCount() - 1);
    }


    @Override
    public void onStop() {
        super.onStop();
        adapter.cleanup();;
    }
}
