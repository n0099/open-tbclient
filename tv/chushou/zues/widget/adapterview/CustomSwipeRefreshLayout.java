package tv.chushou.zues.widget.adapterview;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
/* loaded from: classes6.dex */
public class CustomSwipeRefreshLayout extends SwipeRefreshLayout {
    private a otw;

    /* loaded from: classes6.dex */
    public interface a {
        boolean eal();
    }

    public CustomSwipeRefreshLayout(Context context) {
        super(context);
    }

    public CustomSwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setCanChildScrollUpCallback(a aVar) {
        this.otw = aVar;
    }

    @Override // android.support.v4.widget.SwipeRefreshLayout
    public boolean canChildScrollUp() {
        return this.otw != null ? this.otw.eal() : super.canChildScrollUp();
    }
}
