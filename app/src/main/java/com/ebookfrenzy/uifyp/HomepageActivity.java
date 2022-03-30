package com.ebookfrenzy.uifyp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ebookfrenzy.uifyp.adapter.CategoryAdapter;
import com.ebookfrenzy.uifyp.adapter.FeaturedProductAdapter;
import com.ebookfrenzy.uifyp.adapter.RecentlyViewedAdapter;
import com.ebookfrenzy.uifyp.model.Category;
import com.ebookfrenzy.uifyp.model.FeaturedProduct;
import com.ebookfrenzy.uifyp.model.RecentlyViewed;

import java.util.ArrayList;
import java.util.List;

public class HomepageActivity extends AppCompatActivity {

    RecyclerView featureRecyclerView, categoryRecyclerView, recentlyViewedRecycler;
    FeaturedProductAdapter featuredProductAdapter;
    List<FeaturedProduct> featuredProductList;

    CategoryAdapter categoryAdapter;
    List<Category> categoryList;

    RecentlyViewedAdapter recentlyViewedAdapter;
    List<RecentlyViewed> recentlyViewedList;

    ImageView allCategory;
    ImageView mProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);

        featureRecyclerView = findViewById(R.id.featuredRecycler);
        categoryRecyclerView = findViewById(R.id.categoryRecycler);
        allCategory = findViewById(R.id.allCategoryImage);
        recentlyViewedRecycler = findViewById(R.id.recently_item);
        mProfile = findViewById(R.id.myProfile);

        //method to navigate to all my profile activity

        mProfile.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent u = new Intent(HomepageActivity.this, MyProfile.class);
                startActivity(u);
            }
        });

        //method to navigate to all category activity
        allCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomepageActivity.this, AllCategory.class);
                startActivity(i);
            }
        });

        //adding data to model
        featuredProductList = new ArrayList<>();
        featuredProductList.add(new FeaturedProduct(1, R.drawable.product_picture));
        featuredProductList.add(new FeaturedProduct(2, R.drawable.product_picture2));
        featuredProductList.add(new FeaturedProduct(3, R.drawable.product_picture3));

        //adding data to model
        categoryList = new ArrayList<>();
        categoryList.add(new Category(1, R.drawable.ic_category_book));
        categoryList.add(new Category(2, R.drawable.ic_category_car));
        categoryList.add(new Category(3, R.drawable.ic_category_electronic));
        categoryList.add(new Category(4, R.drawable.ic_category_gym));
        categoryList.add(new Category(5, R.drawable.ic_category_sports));

        //adding data to model
        recentlyViewedList = new ArrayList<>();
        recentlyViewedList.add(new RecentlyViewed("Huawei Watch", "Description of item","RM 1500", "1", R.drawable.recent_picture1));



        setFeaturedRecycler(featuredProductList);
        setCategoryRecycler(categoryList);
        setRecentlyViewedRecycler(recentlyViewedList);
    }

    private void setFeaturedRecycler(List<FeaturedProduct> dataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        featureRecyclerView.setLayoutManager(layoutManager);
        featuredProductAdapter = new FeaturedProductAdapter(this,dataList);
        featureRecyclerView.setAdapter(featuredProductAdapter);
    }

    private void setCategoryRecycler(List<Category> categoryDataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        categoryRecyclerView.setLayoutManager(layoutManager);
        categoryAdapter = new CategoryAdapter(this,categoryDataList);
        categoryRecyclerView.setAdapter(categoryAdapter);
    }

    private void setRecentlyViewedRecycler(List<RecentlyViewed> recentlyViewedDataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recentlyViewedRecycler.setLayoutManager(layoutManager);
        recentlyViewedAdapter = new RecentlyViewedAdapter(this,recentlyViewedDataList);
        recentlyViewedRecycler.setAdapter(recentlyViewedAdapter);
    }
}
