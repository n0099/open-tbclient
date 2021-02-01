package com.kwad.sdk.lib.desigin;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.annotation.Keep;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import com.kwad.sdk.R;
import com.kwad.sdk.lib.desigin.KSAppBarLayout;
import com.kwad.sdk.lib.desigin.KSCoordinatorLayout;
import java.util.Arrays;
import java.util.List;
@Keep
/* loaded from: classes3.dex */
public class CustomAppBarLayoutBehavior extends KSAppBarLayout.KSBehavior implements CustomAppBarCustomAttrListener, CustomAppBarFlingConsumer {
    private static final String TAG = CustomAppBarLayoutBehavior.class.toString();
    private CustomAppBarFlingConsumer mCustomAppBarFlingConsumer;
    private int mExtraFixedSize;
    private final int mFlingConsumeViewId;
    private CustomHeaderBehaviorEx<KSAppBarLayout, CustomAppBarLayoutBehavior> mHeaderExBehavior;
    private int mOffsetDelta;
    private int mScrollableSize;
    private boolean mScrollableSizeChangeable;

    public CustomAppBarLayoutBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mScrollableSizeChangeable = true;
        int i = R.attr.ksad_headerFlingNested;
        int i2 = R.attr.ksad_extraFixedSize;
        int i3 = R.attr.ksad_flingConsumeViewId;
        int[] iArr = {i, i2, i3};
        Arrays.sort(iArr);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        boolean z = obtainStyledAttributes.getBoolean(Arrays.binarySearch(iArr, i), false);
        this.mExtraFixedSize = obtainStyledAttributes.getDimensionPixelSize(Arrays.binarySearch(iArr, i2), 0);
        int resourceId = obtainStyledAttributes.getResourceId(Arrays.binarySearch(iArr, i3), 0);
        obtainStyledAttributes.recycle();
        if (resourceId == 0) {
            throw new IllegalArgumentException("should set head fling offset consume view , with 'flingConsumeViewId'");
        }
        this.mFlingConsumeViewId = resourceId;
        if (z) {
            this.mHeaderExBehavior = new CustomHeaderBehaviorEx<>(context, attributeSet, this);
            this.mHeaderExBehavior.setExtraFixedSize(this.mExtraFixedSize);
        }
    }

    public CustomAppBarLayoutBehavior(CustomAppBarBehaviorParams customAppBarBehaviorParams) {
        this.mScrollableSizeChangeable = true;
        this.mExtraFixedSize = customAppBarBehaviorParams.mExtraFixedSize;
        this.mFlingConsumeViewId = customAppBarBehaviorParams.mFlingConsumeViewId;
        if (customAppBarBehaviorParams.mEnableNestedFling) {
            this.mHeaderExBehavior = new CustomHeaderBehaviorEx<>(this);
            this.mHeaderExBehavior.setExtraFixedSize(this.mExtraFixedSize);
        }
    }

    private void cancelTargetIfNeeded(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, View view, int i, int i2, int[] iArr, int i3) {
        if (i3 == 1 && iArr[1] == 0 && i2 < 0 && kSAppBarLayout.getTop() == 0) {
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            view.onTouchEvent(obtain);
            obtain.recycle();
        }
    }

    private static View getAppBarChildOnOffset(KSAppBarLayout kSAppBarLayout, int i) {
        int abs = Math.abs(i);
        int childCount = kSAppBarLayout.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = kSAppBarLayout.getChildAt(i2);
            if (abs >= childAt.getTop() && abs <= childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    private boolean shouldJumpElevationState(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout) {
        List<View> dependents = kSCoordinatorLayout.getDependents(kSAppBarLayout);
        int size = dependents.size();
        for (int i = 0; i < size; i++) {
            KSCoordinatorLayout.Behavior behavior = ((KSCoordinatorLayout.LayoutParams) dependents.get(i).getLayoutParams()).getBehavior();
            if (behavior instanceof KSAppBarLayout.ScrollingViewBehavior) {
                return ((KSAppBarLayout.ScrollingViewBehavior) behavior).getOverlayTop() != 0;
            }
        }
        return false;
    }

    @Override // com.kwad.sdk.lib.desigin.CustomAppBarFlingConsumer
    public void consumeAppBarFling(int i, int i2) {
        if (this.mCustomAppBarFlingConsumer != null) {
            this.mCustomAppBarFlingConsumer.consumeAppBarFling(i, i2);
        }
    }

    @Override // com.kwad.sdk.lib.desigin.CustomAppBarCustomAttrListener
    public int getExtraFixedSize() {
        return this.mExtraFixedSize;
    }

    public int getScrollRange(KSAppBarLayout kSAppBarLayout) {
        return kSAppBarLayout.getTotalScrollRange() - this.mExtraFixedSize;
    }

    public int getScrollableSize() {
        return this.mScrollableSize;
    }

    @Override // com.kwad.sdk.lib.desigin.KSAppBarLayout.KSBehavior, com.kwad.sdk.lib.desigin.KSHeaderBehavior
    public int getTopBottomOffsetForScrollingSibling() {
        return getTopAndBottomOffset() + this.mOffsetDelta;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int interpolateOffset(KSAppBarLayout kSAppBarLayout, int i) {
        int i2;
        int abs = Math.abs(i);
        int childCount = kSAppBarLayout.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = kSAppBarLayout.getChildAt(i3);
            KSAppBarLayout.LayoutParams layoutParams = (KSAppBarLayout.LayoutParams) childAt.getLayoutParams();
            Interpolator scrollInterpolator = layoutParams.getScrollInterpolator();
            if (abs >= childAt.getTop() && abs <= childAt.getBottom()) {
                if (scrollInterpolator != null) {
                    int scrollFlags = layoutParams.getScrollFlags();
                    if ((scrollFlags & 1) != 0) {
                        i2 = layoutParams.bottomMargin + childAt.getHeight() + layoutParams.topMargin + 0;
                        if ((scrollFlags & 2) != 0) {
                            i2 -= ViewCompat.getMinimumHeight(childAt);
                        }
                    } else {
                        i2 = 0;
                    }
                    if (ViewCompat.getFitsSystemWindows(childAt)) {
                        i2 -= kSAppBarLayout.getTopInset();
                    }
                    if (i2 > 0) {
                        return Integer.signum(i) * (Math.round(scrollInterpolator.getInterpolation((abs - childAt.getTop()) / i2) * i2) + childAt.getTop());
                    }
                    return i;
                }
                return i;
            }
        }
        return i;
    }

    @Override // com.kwad.sdk.lib.desigin.KSAppBarLayout.KSBehavior
    public boolean isOffsetAnimatorRunning() {
        return false;
    }

    @Override // com.kwad.sdk.lib.desigin.CustomAppBarFlingConsumer
    public void onAppBarTouchDown() {
        if (this.mCustomAppBarFlingConsumer != null) {
            this.mCustomAppBarFlingConsumer.onAppBarTouchDown();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.lib.desigin.KSHeaderBehavior, com.kwad.sdk.lib.desigin.KSCoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, MotionEvent motionEvent) {
        return this.mHeaderExBehavior == null ? super.onInterceptTouchEvent(kSCoordinatorLayout, (KSCoordinatorLayout) kSAppBarLayout, motionEvent) : this.mHeaderExBehavior.onInterceptTouchEvent(kSCoordinatorLayout, (KSCoordinatorLayout) kSAppBarLayout, motionEvent);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.lib.desigin.KSAppBarLayout.KSBehavior, com.kwad.sdk.lib.desigin.KSCoordinatorLayout.Behavior
    public boolean onMeasureChild(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, int i, int i2, int i3, int i4) {
        boolean onMeasureChild = super.onMeasureChild(kSCoordinatorLayout, kSAppBarLayout, i, i2, i3, i4);
        if (this.mCustomAppBarFlingConsumer == null) {
            View findViewById = kSCoordinatorLayout.findViewById(this.mFlingConsumeViewId);
            if (!(findViewById instanceof CustomAppBarFlingConsumer)) {
                throw new IllegalArgumentException(String.format("find fling consume view with id %d is not instanceof HeaderFlingConsumer", Integer.valueOf(this.mFlingConsumeViewId)));
            }
            this.mCustomAppBarFlingConsumer = (CustomAppBarFlingConsumer) findViewById;
        }
        return onMeasureChild;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.lib.desigin.KSAppBarLayout.KSBehavior, com.kwad.sdk.lib.desigin.KSCoordinatorLayout.Behavior
    public void onNestedPreScroll(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, View view, int i, int i2, int[] iArr, int i3) {
        int i4;
        int i5;
        cancelTargetIfNeeded(kSCoordinatorLayout, kSAppBarLayout, view, i, i2, iArr, i3);
        if (i2 != 0) {
            if (i2 < 0) {
                i4 = -getScrollRange(kSAppBarLayout);
                i5 = i4 + kSAppBarLayout.getDownNestedPreScrollRange();
            } else {
                i4 = -getScrollRange(kSAppBarLayout);
                i5 = 0;
            }
            if (i4 != i5) {
                iArr[1] = scroll(kSCoordinatorLayout, kSAppBarLayout, i2, i4, i5);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.lib.desigin.KSAppBarLayout.KSBehavior, com.kwad.sdk.lib.desigin.KSCoordinatorLayout.Behavior
    public void onNestedScroll(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, View view, int i, int i2, int i3, int i4, int i5) {
        if (i4 < 0) {
            if (i5 == 1) {
                super.setHeaderTopBottomOffset(kSCoordinatorLayout, kSAppBarLayout, getTopBottomOffsetForScrollingSibling() - i4, -kSAppBarLayout.getDownNestedScrollRange(), 0);
            } else {
                setHeaderTopBottomOffset(kSCoordinatorLayout, kSAppBarLayout, getTopBottomOffsetForScrollingSibling() - i4, -kSAppBarLayout.getDownNestedScrollRange(), 0, i5);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.lib.desigin.KSHeaderBehavior, com.kwad.sdk.lib.desigin.KSCoordinatorLayout.Behavior
    public boolean onTouchEvent(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, MotionEvent motionEvent) {
        return this.mHeaderExBehavior == null ? super.onTouchEvent(kSCoordinatorLayout, (KSCoordinatorLayout) kSAppBarLayout, motionEvent) : this.mHeaderExBehavior.onTouchEvent(kSCoordinatorLayout, (KSCoordinatorLayout) kSAppBarLayout, motionEvent);
    }

    public void setExtraFixedSize(int i) {
        this.mExtraFixedSize = i;
        if (this.mHeaderExBehavior != null) {
            this.mHeaderExBehavior.setExtraFixedSize(this.mExtraFixedSize);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.lib.desigin.KSHeaderBehavior
    public int setHeaderTopBottomOffset(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, int i) {
        return setHeaderTopBottomOffset(kSCoordinatorLayout, kSAppBarLayout, i, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.lib.desigin.KSAppBarLayout.KSBehavior, com.kwad.sdk.lib.desigin.KSHeaderBehavior
    public int setHeaderTopBottomOffset(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, int i, int i2, int i3) {
        return setHeaderTopBottomOffset(kSCoordinatorLayout, kSAppBarLayout, i, i2, i3, -1);
    }

    public int setHeaderTopBottomOffset(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, int i, int i2, int i3, int i4) {
        int topBottomOffsetForScrollingSibling = getTopBottomOffsetForScrollingSibling();
        if (this.mScrollableSizeChangeable) {
            int scrollableSize = getScrollableSize();
            int i5 = i - topBottomOffsetForScrollingSibling;
            if (i5 <= 0) {
                if (scrollableSize <= 0) {
                    return -i5;
                }
                if (scrollableSize + i <= 0) {
                    setTopAndBottomOffset(-scrollableSize);
                    return scrollableSize + i;
                }
            }
        }
        if (i2 == 0 || topBottomOffsetForScrollingSibling < i2 || topBottomOffsetForScrollingSibling > i3) {
            this.mOffsetDelta = 0;
            return 0;
        }
        int clamp = MathUtils.clamp(i, i2, i3);
        if (topBottomOffsetForScrollingSibling != clamp) {
            int interpolateOffset = kSAppBarLayout.hasChildWithInterpolator() ? interpolateOffset(kSAppBarLayout, clamp) : clamp;
            boolean topAndBottomOffset = setTopAndBottomOffset(interpolateOffset);
            int i6 = topBottomOffsetForScrollingSibling - clamp;
            this.mOffsetDelta = clamp - interpolateOffset;
            if (!topAndBottomOffset && kSAppBarLayout.hasChildWithInterpolator()) {
                kSCoordinatorLayout.dispatchDependentViewsChanged(kSAppBarLayout);
            }
            kSAppBarLayout.dispatchOffsetUpdates(getTopAndBottomOffset());
            updateAppBarLayoutDrawableState(kSCoordinatorLayout, kSAppBarLayout, clamp, clamp < topBottomOffsetForScrollingSibling ? -1 : 1, false);
            return i6;
        }
        return 0;
    }

    public void setScrollableSize(int i) {
        this.mScrollableSize = i;
    }

    public void setScrollableSizeChangeable(boolean z) {
        this.mScrollableSizeChangeable = z;
    }

    public void stopFling() {
        if (this.mHeaderExBehavior != null) {
            this.mHeaderExBehavior.stopFling();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void updateAppBarLayoutDrawableState(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, int i, int i2, boolean z) {
        View appBarChildOnOffset = getAppBarChildOnOffset(kSAppBarLayout, i);
        if (appBarChildOnOffset != null) {
            int scrollFlags = ((KSAppBarLayout.LayoutParams) appBarChildOnOffset.getLayoutParams()).getScrollFlags();
            if ((scrollFlags & 1) != 0) {
                int minimumHeight = ViewCompat.getMinimumHeight(appBarChildOnOffset);
                if (i2 <= 0 || (scrollFlags & 12) == 0 ? (scrollFlags & 2) == 0 || (-i) >= (appBarChildOnOffset.getBottom() - minimumHeight) - kSAppBarLayout.getTopInset() : (-i) < (appBarChildOnOffset.getBottom() - minimumHeight) - kSAppBarLayout.getTopInset()) {
                }
            }
            if (z || shouldJumpElevationState(kSCoordinatorLayout, kSAppBarLayout)) {
                kSAppBarLayout.jumpDrawablesToCurrentState();
            }
        }
    }
}
