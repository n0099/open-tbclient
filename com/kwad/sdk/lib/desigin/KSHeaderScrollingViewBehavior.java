package com.kwad.sdk.lib.desigin;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Keep;
import androidx.core.math.MathUtils;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.badge.BadgeDrawable;
import com.kwad.sdk.lib.desigin.KSCoordinatorLayout;
import java.util.List;
@Keep
/* loaded from: classes7.dex */
public abstract class KSHeaderScrollingViewBehavior extends KSViewOffsetBehavior<View> {
    public int mOverlayTop;
    public final Rect mTempRect1;
    public final Rect mTempRect2;
    public int mVerticalLayoutGap;

    public KSHeaderScrollingViewBehavior() {
        this.mTempRect1 = new Rect();
        this.mTempRect2 = new Rect();
        this.mVerticalLayoutGap = 0;
    }

    public KSHeaderScrollingViewBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTempRect1 = new Rect();
        this.mTempRect2 = new Rect();
        this.mVerticalLayoutGap = 0;
    }

    public static int resolveGravity(int i2) {
        return i2 == 0 ? BadgeDrawable.TOP_START : i2;
    }

    public abstract View findFirstDependency(List<View> list);

    public final int getOverlapPixelsForOffset(View view) {
        if (this.mOverlayTop == 0) {
            return 0;
        }
        float overlapRatioForOffset = getOverlapRatioForOffset(view);
        int i2 = this.mOverlayTop;
        return MathUtils.clamp((int) (overlapRatioForOffset * i2), 0, i2);
    }

    public float getOverlapRatioForOffset(View view) {
        return 1.0f;
    }

    public final int getOverlayTop() {
        return this.mOverlayTop;
    }

    public int getScrollRange(View view) {
        return view.getMeasuredHeight();
    }

    public final int getVerticalLayoutGap() {
        return this.mVerticalLayoutGap;
    }

    @Override // com.kwad.sdk.lib.desigin.KSViewOffsetBehavior
    public void layoutChild(KSCoordinatorLayout kSCoordinatorLayout, View view, int i2) {
        int i3;
        View findFirstDependency = findFirstDependency(kSCoordinatorLayout.getDependencies(view));
        if (findFirstDependency != null) {
            KSCoordinatorLayout.LayoutParams layoutParams = (KSCoordinatorLayout.LayoutParams) view.getLayoutParams();
            Rect rect = this.mTempRect1;
            rect.set(kSCoordinatorLayout.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, findFirstDependency.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, (kSCoordinatorLayout.getWidth() - kSCoordinatorLayout.getPaddingRight()) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, ((kSCoordinatorLayout.getHeight() + findFirstDependency.getBottom()) - kSCoordinatorLayout.getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
            WindowInsetsCompat lastWindowInsets = kSCoordinatorLayout.getLastWindowInsets();
            if (lastWindowInsets != null && ViewCompat.getFitsSystemWindows(kSCoordinatorLayout) && !ViewCompat.getFitsSystemWindows(view)) {
                rect.left += lastWindowInsets.getSystemWindowInsetLeft();
                rect.right -= lastWindowInsets.getSystemWindowInsetRight();
            }
            Rect rect2 = this.mTempRect2;
            GravityCompat.apply(resolveGravity(layoutParams.gravity), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i2);
            int overlapPixelsForOffset = getOverlapPixelsForOffset(findFirstDependency);
            view.layout(rect2.left, rect2.top - overlapPixelsForOffset, rect2.right, rect2.bottom - overlapPixelsForOffset);
            i3 = rect2.top - findFirstDependency.getBottom();
        } else {
            super.layoutChild(kSCoordinatorLayout, view, i2);
            i3 = 0;
        }
        this.mVerticalLayoutGap = i3;
    }

    @Override // com.kwad.sdk.lib.desigin.KSCoordinatorLayout.Behavior
    public boolean onMeasureChild(KSCoordinatorLayout kSCoordinatorLayout, View view, int i2, int i3, int i4, int i5) {
        View findFirstDependency;
        int i6 = view.getLayoutParams().height;
        if ((i6 == -1 || i6 == -2) && (findFirstDependency = findFirstDependency(kSCoordinatorLayout.getDependencies(view))) != null) {
            if (ViewCompat.getFitsSystemWindows(findFirstDependency) && !ViewCompat.getFitsSystemWindows(view)) {
                ViewCompat.setFitsSystemWindows(view, true);
                if (ViewCompat.getFitsSystemWindows(view)) {
                    view.requestLayout();
                    return true;
                }
            }
            int size = View.MeasureSpec.getSize(i4);
            if (size == 0) {
                size = kSCoordinatorLayout.getHeight();
            }
            kSCoordinatorLayout.onMeasureChild(view, i2, i3, View.MeasureSpec.makeMeasureSpec((size - findFirstDependency.getMeasuredHeight()) + getScrollRange(findFirstDependency), i6 == -1 ? 1073741824 : Integer.MIN_VALUE), i5);
            return true;
        }
        return false;
    }

    public final void setOverlayTop(int i2) {
        this.mOverlayTop = i2;
    }
}
