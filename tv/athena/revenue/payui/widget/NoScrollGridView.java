package tv.athena.revenue.payui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;
import i.a.a.e.g;
import i.a.a.e.l.b;
/* loaded from: classes8.dex */
public class NoScrollGridView extends GridView {

    /* renamed from: e  reason: collision with root package name */
    public int f69594e;

    public NoScrollGridView(Context context) {
        this(context, null);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.NoScrollGridView);
        int integer = obtainStyledAttributes.getInteger(g.NoScrollGridView_gv_max_height_dp, 536870911);
        this.f69594e = integer;
        if (integer != 536870911) {
            this.f69594e = b.a(integer);
        }
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(this.f69594e, Integer.MIN_VALUE));
    }

    public NoScrollGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NoScrollGridView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f69594e = 536870911;
        a(context, attributeSet);
    }
}
