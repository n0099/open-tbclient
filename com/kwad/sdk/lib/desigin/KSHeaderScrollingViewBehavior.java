package com.kwad.sdk.lib.desigin;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Keep;
import androidx.core.math.MathUtils;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.kwad.sdk.lib.desigin.KSCoordinatorLayout;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
@Keep
/* loaded from: classes5.dex */
public abstract class KSHeaderScrollingViewBehavior extends KSViewOffsetBehavior<View> {
    private int mOverlayTop;
    final Rect mTempRect1;
    final Rect mTempRect2;
    private int mVerticalLayoutGap;

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

    private static int resolveGravity(int i) {
        if (i == 0) {
            return 8388659;
        }
        return i;
    }

    abstract View findFirstDependency(List<View> list);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int getOverlapPixelsForOffset(View view) {
        if (this.mOverlayTop == 0) {
            return 0;
        }
        return MathUtils.clamp((int) (getOverlapRatioForOffset(view) * this.mOverlayTop), 0, this.mOverlayTop);
    }

    float getOverlapRatioForOffset(View view) {
        return 1.0f;
    }

    public final int getOverlayTop() {
        return this.mOverlayTop;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getScrollRange(View view) {
        return view.getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int getVerticalLayoutGap() {
        return this.mVerticalLayoutGap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.lib.desigin.KSViewOffsetBehavior
    public void layoutChild(KSCoordinatorLayout kSCoordinatorLayout, View view, int i) {
        View findFirstDependency = findFirstDependency(kSCoordinatorLayout.getDependencies(view));
        if (findFirstDependency == null) {
            super.layoutChild(kSCoordinatorLayout, view, i);
            this.mVerticalLayoutGap = 0;
            return;
        }
        KSCoordinatorLayout.LayoutParams layoutParams = (KSCoordinatorLayout.LayoutParams) view.getLayoutParams();
        Rect rect = this.mTempRect1;
        rect.set(kSCoordinatorLayout.getPaddingLeft() + layoutParams.leftMargin, findFirstDependency.getBottom() + layoutParams.topMargin, (kSCoordinatorLayout.getWidth() - kSCoordinatorLayout.getPaddingRight()) - layoutParams.rightMargin, ((kSCoordinatorLayout.getHeight() + findFirstDependency.getBottom()) - kSCoordinatorLayout.getPaddingBottom()) - layoutParams.bottomMargin);
        WindowInsetsCompat lastWindowInsets = kSCoordinatorLayout.getLastWindowInsets();
        if (lastWindowInsets != null && ViewCompat.getFitsSystemWindows(kSCoordinatorLayout) && !ViewCompat.getFitsSystemWindows(view)) {
            rect.left += lastWindowInsets.getSystemWindowInsetLeft();
            rect.right -= lastWindowInsets.getSystemWindowInsetRight();
        }
        Rect rect2 = this.mTempRect2;
        GravityCompat.apply(resolveGravity(layoutParams.gravity), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i);
        int overlapPixelsForOffset = getOverlapPixelsForOffset(findFirstDependency);
        view.layout(rect2.left, rect2.top - overlapPixelsForOffset, rect2.right, rect2.bottom - overlapPixelsForOffset);
        this.mVerticalLayoutGap = rect2.top - findFirstDependency.getBottom();
    }

    @Override // com.kwad.sdk.lib.desigin.KSCoordinatorLayout.Behavior
    public boolean onMeasureChild(KSCoordinatorLayout kSCoordinatorLayout, View view, int i, int i2, int i3, int i4) {
        View findFirstDependency;
        int i5 = view.getLayoutParams().height;
        if ((i5 == -1 || i5 == -2) && (findFirstDependency = findFirstDependency(kSCoordinatorLayout.getDependencies(view))) != null) {
            if (ViewCompat.getFitsSystemWindows(findFirstDependency) && !ViewCompat.getFitsSystemWindows(view)) {
                ViewCompat.setFitsSystemWindows(view, true);
                if (ViewCompat.getFitsSystemWindows(view)) {
                    view.requestLayout();
                    return true;
                }
            }
            int size = View.MeasureSpec.getSize(i3);
            if (size == 0) {
                size = kSCoordinatorLayout.getHeight();
            }
            kSCoordinatorLayout.onMeasureChild(view, i, i2, View.MeasureSpec.makeMeasureSpec(getScrollRange(findFirstDependency) + (size - findFirstDependency.getMeasuredHeight()), i5 == -1 ? 1073741824 : Integer.MIN_VALUE), i4);
            return true;
        }
        return false;
    }

    public final void setOverlayTop(int i) {
        this.mOverlayTop = i;
    }
}
