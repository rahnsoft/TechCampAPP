package com.example.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.app.adapters.BooksAdapter;
import com.example.app.models.Books;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Books> mBooks = new ArrayList<>();
    private BooksAdapter mAdapter;
    private RecyclerView mRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recycler_view);
        mBooks.add(new Books("BatMan", "Westlands", "Comic", R.drawable.mariasemples));
        mBooks.add(new Books("John", "nice", "syfy", R.drawable.hediedwith));
        mBooks.add(new Books("Wick", "good", "thriller", R.drawable.themartian));
        mBooks.add(new Books("Point", "awesome", "action", R.drawable.privacy));
        mBooks.add(new Books("Blank", "ok", "drama", R.drawable.thevigitarian));
        mBooks.add(new Books("Advancement", "better", "game", R.drawable.thewildrobot));
        mBooks.add(new Books("Visitors", "not bad", "anime", R.drawable.hediedwith));
        mBooks.add(new Books("Techcamp", "watch it", "romance", R.drawable.mariasemples));
        mBooks.add(new Books("Ghosts", "waste", "action", R.drawable.themartian));
        mBooks.add(new Books("Bat", "never heard of it", "Comic", R.drawable.privacy));



        mAdapter = new BooksAdapter(mBooks,this);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this,3));
        mRecyclerView.setAdapter(mAdapter);




    }


}
