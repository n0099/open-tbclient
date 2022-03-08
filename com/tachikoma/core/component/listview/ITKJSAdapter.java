package com.tachikoma.core.component.listview;

import com.kwad.v8.V8Object;
@Deprecated
/* loaded from: classes8.dex */
public interface ITKJSAdapter {
    int itemCount(int i2);

    int itemType(int i2, int i3);

    V8Object renderFooter(int i2);

    V8Object renderHeader(int i2);

    V8Object renderItem(int i2, int i3, String str);

    void reuseItemView(V8Object v8Object, int i2, int i3);
}
