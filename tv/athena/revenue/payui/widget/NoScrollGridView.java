package tv.athena.revenue.payui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;
import com.baidu.tieba.j9b;
import com.baidu.tieba.p6b;
/* loaded from: classes9.dex */
public class NoScrollGridView extends GridView {
    public int a;

    public NoScrollGridView(Context context) {
        this(context, null);
    }

    public NoScrollGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p6b.PayUi_NoScrollGridView);
        int integer = obtainStyledAttributes.getInteger(0, 536870911);
        this.a = integer;
        if (integer != 536870911) {
            this.a = j9b.a(integer);
        }
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(this.a, Integer.MIN_VALUE));
    }

    public NoScrollGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 536870911;
        a(context, attributeSet);
    }
}
