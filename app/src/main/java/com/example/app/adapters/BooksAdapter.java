package com.example.app.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.app.BookActivity;
import com.example.app.R;
import com.example.app.models.Books;

import java.util.ArrayList;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.BooksViewHolder> {
    private ArrayList<Books> mBooks;
    private Context mContext;
    private CardView mCardView;

    public BooksAdapter(ArrayList<Books> mBooks, Context mContext) {
        this.mBooks = mBooks;
        this.mContext = mContext;
    }


    @NonNull
    @Override
    public BooksViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.book_list, viewGroup, false);

        return new BooksViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BooksViewHolder booksViewHolder, int i) {


        Books book = mBooks.get(i);


        booksViewHolder.tvTitle.setText(book.getTitle());
        booksViewHolder.imageView.setImageResource(book.getThumbnail());


    }

    @Override
    public int getItemCount() {
        return mBooks.size();
    }

    class BooksViewHolder extends RecyclerView.ViewHolder {


        ImageView imageView;
        TextView tvTitle;


        BooksViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.book_img);
            tvTitle = itemView.findViewById(R.id.book_title);
            mCardView = itemView.findViewById(R.id.card_view);
            mCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    Books books = mBooks.get(position);


                    Intent intent = new Intent(mContext, BookActivity.class);
                    intent.putExtra("Title", books.getTitle());
                    intent.putExtra("Category", books.getCategory());
                    intent.putExtra("Description", books.getDescription());
                    intent.putExtra("Image", books.getThumbnail());
                    mContext.startActivity(intent);
                    Toast.makeText(mContext, books.getTitle() + "clicked", Toast.LENGTH_SHORT).show();
                }






            });


        }
    }
}
