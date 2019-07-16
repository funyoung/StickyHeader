package com.saber.customstickyheader;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.saber.stickyheader.stickyView.StickHeaderItemDecoration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RecyclerUtils {
    public static void initOuter(RecyclerView recyclerView, int itemCount, int spanCount, int offset) {
        final RecyclerAdapter adapter = new RecyclerAdapter();
        GridLayoutManager manager = new GridLayoutManager(recyclerView.getContext(), spanCount);

        setData(adapter, itemCount);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(manager);
        recyclerView.addItemDecoration(new StickHeaderItemDecoration(adapter));


        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return adapter.getSpanSizeFromPosition(position);
            }
        });

        manager.scrollToPositionWithOffset(offset, 0);
    }

    private static void setData(RecyclerAdapter adapter, int itemCount) {
        HeaderDataImpl headerData1 = new HeaderDataImpl(HeaderDataImpl.HEADER_TYPE_1, R.layout.header1_item_recycler);
        HeaderDataImpl headerData2 = new HeaderDataImpl(HeaderDataImpl.HEADER_TYPE_2, R.layout.header2_item_recycler);

        adapter.setHeaderAndData(Collections.<CustomerData>emptyList(), headerData1);

        List<CustomerData> items = new ArrayList<>();
        for (int i = 0; i < itemCount; i++) {
            items.add(new CustomerData(i));
        }
        adapter.setHeaderAndData(items, headerData2);
    }

    public static void initInner(RecyclerView codeView) {
        int itemCount = new Random().nextInt(20) + 4;
        final RecyclerSimpleAdapter adapter = new RecyclerSimpleAdapter();

        LinearLayoutManager manager = new LinearLayoutManager(codeView.getContext(), LinearLayoutManager.HORIZONTAL, false);


//        List<CustomerData> items = new ArrayList<>();
//        for (int i = 0; i < itemCount; i++) {
//            items.add(new CustomerData(i));
//        }
//        adapter.setHeaderAndData(items, null);

        codeView.setAdapter(adapter);
        codeView.setLayoutManager(manager);

        // todo: set divider line decoration
        //recyclerView.addItemDecoration(new StickHeaderItemDecoration(adapter));


//        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
//            @Override
//            public int getSpanSize(int position) {
//                return adapter.getSpanSizeFromPosition(position);
//            }
//        });
//
//        manager.scrollToPositionWithOffset(offset, 0);
    }
}
