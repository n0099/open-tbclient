package com.repackage;

import android.view.ViewGroup;
import java.util.List;
/* loaded from: classes7.dex */
public interface xo<V extends ViewGroup> {
    void a(List<eo> list);

    List<ro> getData();

    so getListAdapter();

    V getListView();

    void setData(List<? extends ro> list);
}
