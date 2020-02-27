package tv.chushou.zues.widget.adapterview;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
/* loaded from: classes5.dex */
public class CustomSwipeRefreshLayout extends SwipeRefreshLayout {
    private a nWW;

    /* loaded from: classes5.dex */
    public interface a {
        boolean dQv();
    }

    public CustomSwipeRefreshLayout(Context context) {
        super(context);
    }

    public CustomSwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setCanChildScrollUpCallback(a aVar) {
        this.nWW = aVar;
    }

    @Override // android.support.v4.widget.SwipeRefreshLayout
    public boolean canChildScrollUp() {
        return this.nWW != null ? this.nWW.dQv() : super.canChildScrollUp();
    }
}
