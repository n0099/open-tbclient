package tv.athena.revenue.payui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;
import i.a.a.e.h;
import i.a.a.e.n.b;
/* loaded from: classes8.dex */
public class NoScrollGridView extends GridView {

    /* renamed from: e  reason: collision with root package name */
    public int f72984e;

    public NoScrollGridView(Context context) {
        this(context, null);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, h.PayUi_NoScrollGridView);
        int integer = obtainStyledAttributes.getInteger(h.PayUi_NoScrollGridView_pay_ui_gv_max_height_dp, 536870911);
        this.f72984e = integer;
        if (integer != 536870911) {
            this.f72984e = b.a(integer);
        }
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(this.f72984e, Integer.MIN_VALUE));
    }

    public NoScrollGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NoScrollGridView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f72984e = 536870911;
        a(context, attributeSet);
    }
}
