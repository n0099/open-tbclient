package com.kascend.chushou.widget.cswebview;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
/* loaded from: classes4.dex */
public class CustomSwipeRefreshLayout extends SwipeRefreshLayout {
    private a nhA;

    /* loaded from: classes4.dex */
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
        this.nhA = aVar;
    }

    @Override // android.support.v4.widget.SwipeRefreshLayout
    public boolean canChildScrollUp() {
        return this.nhA != null ? this.nhA.a() : super.canChildScrollUp();
    }
}
