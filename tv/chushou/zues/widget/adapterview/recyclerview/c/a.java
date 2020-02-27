package tv.chushou.zues.widget.adapterview.recyclerview.c;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
/* loaded from: classes5.dex */
public class a {
    public static int e(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager != null) {
            if (layoutManager instanceof LinearLayoutManager) {
                return ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
            }
            if (layoutManager instanceof StaggeredGridLayoutManager) {
                StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
                int[] iArr = new int[staggeredGridLayoutManager.getSpanCount()];
                staggeredGridLayoutManager.findLastVisibleItemPositions(iArr);
                if (iArr.length > 0) {
                    int i = iArr[0];
                    for (int i2 = 1; i2 < iArr.length; i2++) {
                        if (iArr[i2] > i) {
                            i = iArr[i2];
                        }
                    }
                    return i;
                }
                return -1;
            }
            return -1;
        }
        return -1;
    }

    public static int f(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager != null) {
            if (layoutManager instanceof LinearLayoutManager) {
                return ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
            }
            if (layoutManager instanceof StaggeredGridLayoutManager) {
                StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
                int[] iArr = new int[staggeredGridLayoutManager.getSpanCount()];
                staggeredGridLayoutManager.findFirstVisibleItemPositions(iArr);
                if (iArr.length > 0) {
                    int i = iArr[0];
                    for (int i2 = 1; i2 < iArr.length; i2++) {
                        if (iArr[i2] < i) {
                            i = iArr[i2];
                        }
                    }
                    return i;
                }
                return -1;
            }
            return -1;
        }
        return -1;
    }
}
