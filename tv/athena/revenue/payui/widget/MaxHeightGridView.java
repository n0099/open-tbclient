package tv.athena.revenue.payui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import i.a.a.e.h;
import i.a.a.e.n.b;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\u0012"}, d2 = {"Ltv/athena/revenue/payui/widget/MaxHeightGridView;", "Landroid/widget/GridView;", "", "widthMeasureSpec", "heightMeasureSpec", "", "onMeasure", "(II)V", "maxHeight", "I", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "payui_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
public final class MaxHeightGridView extends GridView {

    /* renamed from: e  reason: collision with root package name */
    public int f72983e;

    @JvmOverloads
    public MaxHeightGridView(Context context) {
        this(context, null, 0, 6, null);
    }

    @JvmOverloads
    public MaxHeightGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    @JvmOverloads
    public /* synthetic */ MaxHeightGridView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i2, int i3) {
        try {
            try {
                int size = View.MeasureSpec.getSize(i3);
                if (this.f72983e != -1) {
                    size = this.f72983e;
                    i3 = View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE);
                } else {
                    i3 = View.MeasureSpec.makeMeasureSpec(size, 0);
                }
                getLayoutParams().height = size;
            } catch (Exception e2) {
                RLog.info("ScrollViewWithMaxHeight", "error: " + e2);
            }
        } finally {
            super.onMeasure(i2, i3);
        }
    }

    @JvmOverloads
    public MaxHeightGridView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f72983e = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, h.PayUi_NoScrollGridView);
        int integer = obtainStyledAttributes.getInteger(h.PayUi_NoScrollGridView_pay_ui_gv_max_height_dp, 536870911);
        this.f72983e = integer;
        if (integer != 536870911) {
            this.f72983e = b.a(integer);
        }
        obtainStyledAttributes.recycle();
    }
}
