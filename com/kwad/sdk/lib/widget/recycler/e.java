package com.kwad.sdk.lib.widget.recycler;

import androidx.annotation.FloatRange;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes4.dex */
public class e {

    /* loaded from: classes4.dex */
    public interface a {
        void a(AdTemplate adTemplate, @FloatRange(from = 0.0d, to = 1.0d) float f);
    }

    public static int a(RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager;
        int i;
        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null) {
            return -1;
        }
        if (layoutManager instanceof LinearLayoutManager) {
            return ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
        }
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            int[] findLastVisibleItemPositions = ((StaggeredGridLayoutManager) layoutManager).findLastVisibleItemPositions(null);
            if (findLastVisibleItemPositions == null || findLastVisibleItemPositions.length <= 0) {
                i = -1;
            } else {
                i = findLastVisibleItemPositions[0];
                for (int i2 : findLastVisibleItemPositions) {
                    i = Math.min(i2, i);
                }
            }
            return i;
        }
        return -1;
    }

    public static int b(RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager;
        int i;
        int[] findLastVisibleItemPositions;
        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null) {
            return -1;
        }
        if (layoutManager instanceof LinearLayoutManager) {
            return ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
        }
        if (!(layoutManager instanceof StaggeredGridLayoutManager) || (findLastVisibleItemPositions = ((StaggeredGridLayoutManager) layoutManager).findLastVisibleItemPositions(null)) == null || findLastVisibleItemPositions.length <= 0) {
            i = -1;
        } else {
            i = findLastVisibleItemPositions[0];
            for (int i2 : findLastVisibleItemPositions) {
                i = Math.max(i2, i);
            }
        }
        return i;
    }
}
