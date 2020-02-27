package tv.chushou.zues.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import tv.chushou.zues.b;
/* loaded from: classes5.dex */
public class FlowLayout extends ViewGroup {
    private int mHorizontalSpacing;
    private int mVerticalSpacing;

    public FlowLayout(Context context) {
        super(context);
    }

    public FlowLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.i.FlowLayout);
        try {
            this.mHorizontalSpacing = obtainStyledAttributes.getDimensionPixelSize(b.i.FlowLayout_horizontal_spacing, 5);
            this.mVerticalSpacing = obtainStyledAttributes.getDimensionPixelSize(b.i.FlowLayout_vertical_spacing, 5);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int resolveSize = resolveSize(0, i);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int childCount = getChildCount();
        int i6 = 0;
        int i7 = 0;
        int i8 = paddingLeft;
        while (i6 < childCount) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i, i2);
                int measuredWidth = childAt.getMeasuredWidth();
                i3 = childAt.getMeasuredHeight();
                int max = Math.max(i3, i7);
                if (i8 + measuredWidth + paddingRight > resolveSize) {
                    int i9 = paddingLeft + measuredWidth + this.mHorizontalSpacing;
                    i4 = max + this.mVerticalSpacing + paddingTop;
                    i5 = i9;
                } else {
                    i4 = paddingTop;
                    i5 = this.mHorizontalSpacing + measuredWidth + i8;
                    i3 = max;
                }
            } else {
                i3 = i7;
                i4 = paddingTop;
                i5 = i8;
            }
            i6++;
            i8 = i5;
            paddingTop = i4;
            i7 = i3;
        }
        setMeasuredDimension(resolveSize, resolveSize(paddingTop + i7 + paddingBottom, i2));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int childCount = getChildCount();
        int i6 = paddingLeft;
        int i7 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                i7 = Math.max(measuredHeight, i7);
                if (i6 + measuredWidth + paddingRight > i5) {
                    paddingTop = i7 + this.mVerticalSpacing + paddingTop;
                    i6 = paddingLeft;
                    i7 = measuredHeight;
                }
                childAt.layout(i6, paddingTop, i6 + measuredWidth, measuredHeight + paddingTop);
                i6 += this.mHorizontalSpacing + measuredWidth;
            }
        }
    }
}
