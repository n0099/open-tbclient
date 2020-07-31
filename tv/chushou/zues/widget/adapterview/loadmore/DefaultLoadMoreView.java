package tv.chushou.zues.widget.adapterview.loadmore;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import tv.chushou.zues.b;
/* loaded from: classes6.dex */
public class DefaultLoadMoreView extends RelativeLayout {
    public DefaultLoadMoreView(Context context) {
        this(context, null, 0);
    }

    public DefaultLoadMoreView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DefaultLoadMoreView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(getContext()).inflate(b.f.zues_recyclerview_load_more_footer, (ViewGroup) this, true);
    }
}
