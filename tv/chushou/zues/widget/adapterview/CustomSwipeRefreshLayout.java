package tv.chushou.zues.widget.adapterview;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
/* loaded from: classes6.dex */
public class CustomSwipeRefreshLayout extends SwipeRefreshLayout {
    private a qno;

    /* loaded from: classes6.dex */
    public interface a {
        boolean eHU();
    }

    public CustomSwipeRefreshLayout(Context context) {
        super(context);
    }

    public CustomSwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setCanChildScrollUpCallback(a aVar) {
        this.qno = aVar;
    }

    @Override // android.support.v4.widget.SwipeRefreshLayout
    public boolean canChildScrollUp() {
        return this.qno != null ? this.qno.eHU() : super.canChildScrollUp();
    }
}
