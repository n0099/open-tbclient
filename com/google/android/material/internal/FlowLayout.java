package com.google.android.material.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class FlowLayout extends ViewGroup {
    private int itemSpacing;
    private int lineSpacing;
    private boolean singleLine;

    public FlowLayout(Context context) {
        this(context, null);
    }

    public FlowLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlowLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.singleLine = false;
        loadFromAttributes(context, attributeSet);
    }

    @TargetApi(21)
    public FlowLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.singleLine = false;
        loadFromAttributes(context, attributeSet);
    }

    private void loadFromAttributes(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.FlowLayout, 0, 0);
        this.lineSpacing = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FlowLayout_lineSpacing, 0);
        this.itemSpacing = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FlowLayout_itemSpacing, 0);
        obtainStyledAttributes.recycle();
    }

    protected int getLineSpacing() {
        return this.lineSpacing;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setLineSpacing(int i) {
        this.lineSpacing = i;
    }

    protected int getItemSpacing() {
        return this.itemSpacing;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setItemSpacing(int i) {
        this.itemSpacing = i;
    }

    protected boolean isSingleLine() {
        return this.singleLine;
    }

    public void setSingleLine(boolean z) {
        this.singleLine = z;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        int i4 = (mode == Integer.MIN_VALUE || mode == 1073741824) ? size : ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int i5 = 0;
        int paddingRight = i4 - getPaddingRight();
        int i6 = 0;
        int i7 = paddingTop;
        while (true) {
            int i8 = paddingTop;
            if (i6 < getChildCount()) {
                View childAt = getChildAt(i6);
                if (childAt.getVisibility() != 8) {
                    measureChild(childAt, i, i2);
                    ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                    int i9 = 0;
                    if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                        i3 = 0;
                    } else {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        i9 = 0 + marginLayoutParams.leftMargin;
                        i3 = marginLayoutParams.rightMargin + 0;
                    }
                    if (paddingLeft + i9 + childAt.getMeasuredWidth() > paddingRight && !isSingleLine()) {
                        paddingLeft = getPaddingLeft();
                        i8 = i7 + this.lineSpacing;
                    }
                    int measuredWidth = paddingLeft + i9 + childAt.getMeasuredWidth();
                    int measuredHeight = i8 + childAt.getMeasuredHeight();
                    if (measuredWidth > i5) {
                        i5 = measuredWidth;
                    }
                    paddingLeft += i3 + i9 + childAt.getMeasuredWidth() + this.itemSpacing;
                    i7 = measuredHeight;
                }
                paddingTop = i8;
                i6++;
            } else {
                setMeasuredDimension(getMeasuredDimension(size, mode, i5), getMeasuredDimension(size2, mode2, i7));
                return;
            }
        }
    }

    private static int getMeasuredDimension(int i, int i2, int i3) {
        switch (i2) {
            case Integer.MIN_VALUE:
                return Math.min(i3, i);
            case 1073741824:
                return i;
            default:
                return i3;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (getChildCount() != 0) {
            boolean z2 = ViewCompat.getLayoutDirection(this) == 1;
            int paddingRight = z2 ? getPaddingRight() : getPaddingLeft();
            int paddingLeft = z2 ? getPaddingLeft() : getPaddingRight();
            int paddingTop = getPaddingTop();
            int i6 = (i3 - i) - paddingLeft;
            int i7 = 0;
            int i8 = paddingTop;
            int i9 = paddingTop;
            int i10 = paddingRight;
            while (i7 < getChildCount()) {
                View childAt = getChildAt(i7);
                if (childAt.getVisibility() != 8) {
                    ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                    int i11 = 0;
                    if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                        i5 = 0;
                    } else {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        int marginStart = MarginLayoutParamsCompat.getMarginStart(marginLayoutParams);
                        i5 = MarginLayoutParamsCompat.getMarginEnd(marginLayoutParams);
                        i11 = marginStart;
                    }
                    int measuredWidth = i10 + i11 + childAt.getMeasuredWidth();
                    if (!this.singleLine && measuredWidth > i6) {
                        i9 = i8 + this.lineSpacing;
                        i10 = paddingRight;
                    }
                    int measuredWidth2 = childAt.getMeasuredWidth() + i10 + i11;
                    i8 = childAt.getMeasuredHeight() + i9;
                    if (z2) {
                        childAt.layout(i6 - measuredWidth2, i9, (i6 - i10) - i11, i8);
                    } else {
                        childAt.layout(i10 + i11, i9, measuredWidth2, i8);
                    }
                    i10 += i5 + i11 + childAt.getMeasuredWidth() + this.itemSpacing;
                }
                i7++;
                i9 = i9;
            }
        }
    }
}
