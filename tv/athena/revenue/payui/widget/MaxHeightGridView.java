package tv.athena.revenue.payui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;
import com.baidu.tieba.dgc;
import com.baidu.tieba.gdc;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\u0012"}, d2 = {"Ltv/athena/revenue/payui/widget/MaxHeightGridView;", "Landroid/widget/GridView;", "", "widthMeasureSpec", "heightMeasureSpec", "", "onMeasure", "(II)V", "maxHeight", "I", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "payui-base_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class MaxHeightGridView extends GridView {
    public int a;

    @JvmOverloads
    public MaxHeightGridView(Context context) {
        this(context, null, 0, 6, null);
    }

    @JvmOverloads
    public MaxHeightGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    @JvmOverloads
    public MaxHeightGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, gdc.PayUi_NoScrollGridView);
        int integer = obtainStyledAttributes.getInteger(0, 536870911);
        this.a = integer;
        if (integer != 536870911) {
            this.a = dgc.a(integer);
        }
        obtainStyledAttributes.recycle();
    }

    public /* synthetic */ MaxHeightGridView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i, int i2) {
        try {
            try {
                int size = View.MeasureSpec.getSize(i2);
                if (this.a != -1) {
                    size = this.a;
                    i2 = View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE);
                } else {
                    i2 = View.MeasureSpec.makeMeasureSpec(size, 0);
                }
                getLayoutParams().height = size;
            } catch (Exception e) {
                RLog.info("ScrollViewWithMaxHeight", "error: " + e);
            }
        } finally {
            super.onMeasure(i, i2);
        }
    }
}
