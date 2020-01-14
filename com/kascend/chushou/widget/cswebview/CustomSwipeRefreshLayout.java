package com.kascend.chushou.widget.cswebview;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
/* loaded from: classes4.dex */
public class CustomSwipeRefreshLayout extends SwipeRefreshLayout {
    private a nhF;

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
        this.nhF = aVar;
    }

    @Override // android.support.v4.widget.SwipeRefreshLayout
    public boolean canChildScrollUp() {
        return this.nhF != null ? this.nhF.a() : super.canChildScrollUp();
    }
}
