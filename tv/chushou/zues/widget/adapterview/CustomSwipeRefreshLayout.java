package tv.chushou.zues.widget.adapterview;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
/* loaded from: classes5.dex */
public class CustomSwipeRefreshLayout extends SwipeRefreshLayout {
    private a nNQ;

    /* loaded from: classes5.dex */
    public interface a {
        boolean dRR();
    }

    public CustomSwipeRefreshLayout(Context context) {
        super(context);
    }

    public CustomSwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setCanChildScrollUpCallback(a aVar) {
        this.nNQ = aVar;
    }

    @Override // android.support.v4.widget.SwipeRefreshLayout
    public boolean canChildScrollUp() {
        return this.nNQ != null ? this.nNQ.dRR() : super.canChildScrollUp();
    }
}
