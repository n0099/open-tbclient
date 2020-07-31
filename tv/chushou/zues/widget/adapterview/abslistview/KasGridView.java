package tv.chushou.zues.widget.adapterview.abslistview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;
/* loaded from: classes6.dex */
public class KasGridView extends GridView {
    public KasGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public KasGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public KasGridView(Context context) {
        super(context);
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }
}
