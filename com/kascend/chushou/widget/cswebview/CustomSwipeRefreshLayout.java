package com.kascend.chushou.widget.cswebview;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
/* loaded from: classes5.dex */
public class CustomSwipeRefreshLayout extends SwipeRefreshLayout {
    private a naV;

    /* loaded from: classes5.dex */
    public interface a {
        boolean a();
    }

    public CustomSwipeRefreshLayout(Context context) {
        super(context);
    }

    public CustomSwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setCanChildScrollUpCallback(a aVar) {
        this.naV = aVar;
    }

    @Override // android.support.v4.widget.SwipeRefreshLayout
    public boolean canChildScrollUp() {
        return this.naV != null ? this.naV.a() : super.canChildScrollUp();
    }
}
