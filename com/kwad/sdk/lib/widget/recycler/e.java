package com.kwad.sdk.lib.widget.recycler;

import androidx.annotation.FloatRange;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes7.dex */
public class e {

    /* loaded from: classes7.dex */
    public interface a {
        void a(AdTemplate adTemplate, @FloatRange(from = 0.0d, to = 1.0d) float f2);
    }

    public static int a(RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager;
        int[] findLastVisibleItemPositions;
        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null) {
            return -1;
        }
        if (layoutManager instanceof LinearLayoutManager) {
            return ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
        }
        if (!(layoutManager instanceof StaggeredGridLayoutManager) || (findLastVisibleItemPositions = ((StaggeredGridLayoutManager) layoutManager).findLastVisibleItemPositions(null)) == null || findLastVisibleItemPositions.length <= 0) {
            return -1;
        }
        int i2 = findLastVisibleItemPositions[0];
        for (int i3 : findLastVisibleItemPositions) {
            i2 = Math.min(i3, i2);
        }
        return i2;
    }

    public static int b(RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager;
        int[] findLastVisibleItemPositions;
        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null) {
            return -1;
        }
        if (layoutManager instanceof LinearLayoutManager) {
            return ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
        }
        if (!(layoutManager instanceof StaggeredGridLayoutManager) || (findLastVisibleItemPositions = ((StaggeredGridLayoutManager) layoutManager).findLastVisibleItemPositions(null)) == null || findLastVisibleItemPositions.length <= 0) {
            return -1;
        }
        int i2 = findLastVisibleItemPositions[0];
        for (int i3 : findLastVisibleItemPositions) {
            i2 = Math.max(i3, i2);
        }
        return i2;
    }
}
