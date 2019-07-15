package com.saber.customstickyheader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.saber.stickyheader.stickyView.StickHeaderItemDecoration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        final RecyclerAdapter adapter = new RecyclerAdapter();
        GridLayoutManager manager = new GridLayoutManager(this, 4);

        setData(adapter);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(manager);
        recyclerView.addItemDecoration(new StickHeaderItemDecoration(adapter));


        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return adapter.getSpanSizeFromPosition(position);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void setData(RecyclerAdapter adapter) {
        HeaderDataImpl headerData1 = new HeaderDataImpl(HeaderDataImpl.HEADER_TYPE_1, R.layout.header1_item_recycler);
        HeaderDataImpl headerData2 = new HeaderDataImpl(HeaderDataImpl.HEADER_TYPE_2, R.layout.header2_item_recycler);

        adapter.setHeaderAndData(Collections.<CustomerData>emptyList(), headerData1);

        List<CustomerData> items = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            items.add(new CustomerData(i));
        }
        adapter.setHeaderAndData(items, headerData2);
    }
}
