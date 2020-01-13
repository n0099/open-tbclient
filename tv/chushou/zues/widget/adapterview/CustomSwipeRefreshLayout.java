package tv.chushou.zues.widget.adapterview;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
/* loaded from: classes4.dex */
public class CustomSwipeRefreshLayout extends SwipeRefreshLayout {
    private a nWc;

    /* loaded from: classes4.dex */
    public interface a {
        boolean dPg();
    }

    public CustomSwipeRefreshLayout(Context context) {
        super(context);
    }

    public CustomSwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setCanChildScrollUpCallback(a aVar) {
        this.nWc = aVar;
    }

    @Override // android.support.v4.widget.SwipeRefreshLayout
    public boolean canChildScrollUp() {
        return this.nWc != null ? this.nWc.dPg() : super.canChildScrollUp();
    }
}
