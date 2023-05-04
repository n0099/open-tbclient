package com.google.android.material.appbar;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.badge.BadgeDrawable;
import java.util.List;
/* loaded from: classes8.dex */
public abstract class HeaderScrollingViewBehavior extends ViewOffsetBehavior<View> {
    public int overlayTop;
    public final Rect tempRect1;
    public final Rect tempRect2;
    public int verticalLayoutGap;

    public static int resolveGravity(int i) {
        return i == 0 ? BadgeDrawable.TOP_START : i;
    }

    @Nullable
    public abstract View findFirstDependency(List<View> list);

    public float getOverlapRatioForOffset(View view2) {
        return 1.0f;
    }

    public boolean shouldHeaderOverlapScrollingChild() {
        return false;
    }

    public HeaderScrollingViewBehavior() {
        this.tempRect1 = new Rect();
        this.tempRect2 = new Rect();
        this.verticalLayoutGap = 0;
    }

    public final int getOverlayTop() {
        return this.overlayTop;
    }

    public final int getVerticalLayoutGap() {
        return this.verticalLayoutGap;
    }

    public HeaderScrollingViewBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.tempRect1 = new Rect();
        this.tempRect2 = new Rect();
        this.verticalLayoutGap = 0;
    }

    public final int getOverlapPixelsForOffset(View view2) {
        if (this.overlayTop == 0) {
            return 0;
        }
        float overlapRatioForOffset = getOverlapRatioForOffset(view2);
        int i = this.overlayTop;
        return MathUtils.clamp((int) (overlapRatioForOffset * i), 0, i);
    }

    public int getScrollRange(@NonNull View view2) {
        return view2.getMeasuredHeight();
    }

    public final void setOverlayTop(int i) {
        this.overlayTop = i;
    }

    @Override // com.google.android.material.appbar.ViewOffsetBehavior
    public void layoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view2, int i) {
        View findFirstDependency = findFirstDependency(coordinatorLayout.getDependencies(view2));
        if (findFirstDependency != null) {
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) view2.getLayoutParams();
            Rect rect = this.tempRect1;
            rect.set(coordinatorLayout.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, findFirstDependency.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, ((coordinatorLayout.getHeight() + findFirstDependency.getBottom()) - coordinatorLayout.getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
            WindowInsetsCompat lastWindowInsets = coordinatorLayout.getLastWindowInsets();
            if (lastWindowInsets != null && ViewCompat.getFitsSystemWindows(coordinatorLayout) && !ViewCompat.getFitsSystemWindows(view2)) {
                rect.left += lastWindowInsets.getSystemWindowInsetLeft();
                rect.right -= lastWindowInsets.getSystemWindowInsetRight();
            }
            Rect rect2 = this.tempRect2;
            GravityCompat.apply(resolveGravity(layoutParams.gravity), view2.getMeasuredWidth(), view2.getMeasuredHeight(), rect, rect2, i);
            int overlapPixelsForOffset = getOverlapPixelsForOffset(findFirstDependency);
            view2.layout(rect2.left, rect2.top - overlapPixelsForOffset, rect2.right, rect2.bottom - overlapPixelsForOffset);
            this.verticalLayoutGap = rect2.top - findFirstDependency.getBottom();
            return;
        }
        super.layoutChild(coordinatorLayout, view2, i);
        this.verticalLayoutGap = 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onMeasureChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view2, int i, int i2, int i3, int i4) {
        View findFirstDependency;
        int i5;
        WindowInsetsCompat lastWindowInsets;
        int i6 = view2.getLayoutParams().height;
        if ((i6 == -1 || i6 == -2) && (findFirstDependency = findFirstDependency(coordinatorLayout.getDependencies(view2))) != null) {
            int size = View.MeasureSpec.getSize(i3);
            if (size > 0) {
                if (ViewCompat.getFitsSystemWindows(findFirstDependency) && (lastWindowInsets = coordinatorLayout.getLastWindowInsets()) != null) {
                    size += lastWindowInsets.getSystemWindowInsetTop() + lastWindowInsets.getSystemWindowInsetBottom();
                }
            } else {
                size = coordinatorLayout.getHeight();
            }
            int scrollRange = size + getScrollRange(findFirstDependency);
            int measuredHeight = findFirstDependency.getMeasuredHeight();
            if (shouldHeaderOverlapScrollingChild()) {
                view2.setTranslationY(-measuredHeight);
            } else {
                scrollRange -= measuredHeight;
            }
            if (i6 == -1) {
                i5 = 1073741824;
            } else {
                i5 = Integer.MIN_VALUE;
            }
            coordinatorLayout.onMeasureChild(view2, i, i2, View.MeasureSpec.makeMeasureSpec(scrollRange, i5), i4);
            return true;
        }
        return false;
    }
}
