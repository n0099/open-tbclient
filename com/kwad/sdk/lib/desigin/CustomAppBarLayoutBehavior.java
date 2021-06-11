package com.kwad.sdk.lib.desigin;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import androidx.annotation.Keep;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import com.kwad.sdk.R;
import com.kwad.sdk.lib.desigin.KSAppBarLayout;
import com.kwad.sdk.lib.desigin.KSCoordinatorLayout;
import java.util.Arrays;
import java.util.List;
@Keep
/* loaded from: classes7.dex */
public class CustomAppBarLayoutBehavior extends KSAppBarLayout.KSBehavior implements CustomAppBarCustomAttrListener, CustomAppBarFlingConsumer {
    public static final String TAG = CustomAppBarLayoutBehavior.class.toString();
    public CustomAppBarFlingConsumer mCustomAppBarFlingConsumer;
    public int mExtraFixedSize;
    public final int mFlingConsumeViewId;
    public CustomHeaderBehaviorEx<KSAppBarLayout, CustomAppBarLayoutBehavior> mHeaderExBehavior;
    public int mOffsetDelta;
    public int mScrollableSize;
    public boolean mScrollableSizeChangeable;

    public CustomAppBarLayoutBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mScrollableSizeChangeable = true;
        int i2 = R.attr.ksad_headerFlingNested;
        int i3 = R.attr.ksad_extraFixedSize;
        int i4 = R.attr.ksad_flingConsumeViewId;
        int[] iArr = {i2, i3, i4};
        Arrays.sort(iArr);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        boolean z = obtainStyledAttributes.getBoolean(Arrays.binarySearch(iArr, i2), false);
        this.mExtraFixedSize = obtainStyledAttributes.getDimensionPixelSize(Arrays.binarySearch(iArr, i3), 0);
        int resourceId = obtainStyledAttributes.getResourceId(Arrays.binarySearch(iArr, i4), 0);
        obtainStyledAttributes.recycle();
        if (resourceId == 0) {
            throw new IllegalArgumentException("should set head fling offset consume view , with 'flingConsumeViewId'");
        }
        this.mFlingConsumeViewId = resourceId;
        if (z) {
            CustomHeaderBehaviorEx<KSAppBarLayout, CustomAppBarLayoutBehavior> customHeaderBehaviorEx = new CustomHeaderBehaviorEx<>(context, attributeSet, this);
            this.mHeaderExBehavior = customHeaderBehaviorEx;
            customHeaderBehaviorEx.setExtraFixedSize(this.mExtraFixedSize);
        }
    }

    public CustomAppBarLayoutBehavior(CustomAppBarBehaviorParams customAppBarBehaviorParams) {
        this.mScrollableSizeChangeable = true;
        this.mExtraFixedSize = customAppBarBehaviorParams.mExtraFixedSize;
        this.mFlingConsumeViewId = customAppBarBehaviorParams.mFlingConsumeViewId;
        if (customAppBarBehaviorParams.mEnableNestedFling) {
            CustomHeaderBehaviorEx<KSAppBarLayout, CustomAppBarLayoutBehavior> customHeaderBehaviorEx = new CustomHeaderBehaviorEx<>(this);
            this.mHeaderExBehavior = customHeaderBehaviorEx;
            customHeaderBehaviorEx.setExtraFixedSize(this.mExtraFixedSize);
        }
    }

    private void cancelTargetIfNeeded(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, View view, int i2, int i3, int[] iArr, int i4) {
        if (i4 == 1 && iArr[1] == 0 && i3 < 0 && kSAppBarLayout.getTop() == 0) {
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            view.onTouchEvent(obtain);
            obtain.recycle();
        }
    }

    public static View getAppBarChildOnOffset(KSAppBarLayout kSAppBarLayout, int i2) {
        int abs = Math.abs(i2);
        int childCount = kSAppBarLayout.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = kSAppBarLayout.getChildAt(i3);
            if (abs >= childAt.getTop() && abs <= childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    private boolean shouldJumpElevationState(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout) {
        List<View> dependents = kSCoordinatorLayout.getDependents(kSAppBarLayout);
        int size = dependents.size();
        for (int i2 = 0; i2 < size; i2++) {
            KSCoordinatorLayout.Behavior behavior = ((KSCoordinatorLayout.LayoutParams) dependents.get(i2).getLayoutParams()).getBehavior();
            if (behavior instanceof KSAppBarLayout.ScrollingViewBehavior) {
                return ((KSAppBarLayout.ScrollingViewBehavior) behavior).getOverlayTop() != 0;
            }
        }
        return false;
    }

    @Override // com.kwad.sdk.lib.desigin.CustomAppBarFlingConsumer
    public void consumeAppBarFling(int i2, int i3) {
        CustomAppBarFlingConsumer customAppBarFlingConsumer = this.mCustomAppBarFlingConsumer;
        if (customAppBarFlingConsumer != null) {
            customAppBarFlingConsumer.consumeAppBarFling(i2, i3);
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

    public int interpolateOffset(KSAppBarLayout kSAppBarLayout, int i2) {
        int abs = Math.abs(i2);
        int childCount = kSAppBarLayout.getChildCount();
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i4 >= childCount) {
                break;
            }
            View childAt = kSAppBarLayout.getChildAt(i4);
            KSAppBarLayout.LayoutParams layoutParams = (KSAppBarLayout.LayoutParams) childAt.getLayoutParams();
            Interpolator scrollInterpolator = layoutParams.getScrollInterpolator();
            if (abs < childAt.getTop() || abs > childAt.getBottom()) {
                i4++;
            } else if (scrollInterpolator != null) {
                int scrollFlags = layoutParams.getScrollFlags();
                if ((scrollFlags & 1) != 0) {
                    i3 = 0 + childAt.getHeight() + ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                    if ((scrollFlags & 2) != 0) {
                        i3 -= ViewCompat.getMinimumHeight(childAt);
                    }
                }
                if (ViewCompat.getFitsSystemWindows(childAt)) {
                    i3 -= kSAppBarLayout.getTopInset();
                }
                if (i3 > 0) {
                    float f2 = i3;
                    return Integer.signum(i2) * (childAt.getTop() + Math.round(f2 * scrollInterpolator.getInterpolation((abs - childAt.getTop()) / f2)));
                }
            }
        }
        return i2;
    }

    @Override // com.kwad.sdk.lib.desigin.KSAppBarLayout.KSBehavior
    public boolean isOffsetAnimatorRunning() {
        return false;
    }

    @Override // com.kwad.sdk.lib.desigin.CustomAppBarFlingConsumer
    public void onAppBarTouchDown() {
        CustomAppBarFlingConsumer customAppBarFlingConsumer = this.mCustomAppBarFlingConsumer;
        if (customAppBarFlingConsumer != null) {
            customAppBarFlingConsumer.onAppBarTouchDown();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.lib.desigin.KSHeaderBehavior, com.kwad.sdk.lib.desigin.KSCoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, MotionEvent motionEvent) {
        CustomHeaderBehaviorEx<KSAppBarLayout, CustomAppBarLayoutBehavior> customHeaderBehaviorEx = this.mHeaderExBehavior;
        return customHeaderBehaviorEx == null ? super.onInterceptTouchEvent(kSCoordinatorLayout, (KSCoordinatorLayout) kSAppBarLayout, motionEvent) : customHeaderBehaviorEx.onInterceptTouchEvent(kSCoordinatorLayout, (KSCoordinatorLayout) kSAppBarLayout, motionEvent);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.lib.desigin.KSAppBarLayout.KSBehavior, com.kwad.sdk.lib.desigin.KSCoordinatorLayout.Behavior
    public boolean onMeasureChild(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, int i2, int i3, int i4, int i5) {
        boolean onMeasureChild = super.onMeasureChild(kSCoordinatorLayout, kSAppBarLayout, i2, i3, i4, i5);
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
    public void onNestedPreScroll(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, View view, int i2, int i3, int[] iArr, int i4) {
        int i5;
        int i6;
        cancelTargetIfNeeded(kSCoordinatorLayout, kSAppBarLayout, view, i2, i3, iArr, i4);
        if (i3 != 0) {
            int i7 = -getScrollRange(kSAppBarLayout);
            if (i3 < 0) {
                i5 = i7;
                i6 = kSAppBarLayout.getDownNestedPreScrollRange() + i7;
            } else {
                i5 = i7;
                i6 = 0;
            }
            if (i5 != i6) {
                iArr[1] = scroll(kSCoordinatorLayout, kSAppBarLayout, i3, i5, i6);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.lib.desigin.KSAppBarLayout.KSBehavior, com.kwad.sdk.lib.desigin.KSCoordinatorLayout.Behavior
    public void onNestedScroll(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, View view, int i2, int i3, int i4, int i5, int i6) {
        if (i5 < 0) {
            if (i6 == 1) {
                super.setHeaderTopBottomOffset(kSCoordinatorLayout, kSAppBarLayout, getTopBottomOffsetForScrollingSibling() - i5, -kSAppBarLayout.getDownNestedScrollRange(), 0);
            } else {
                setHeaderTopBottomOffset(kSCoordinatorLayout, kSAppBarLayout, getTopBottomOffsetForScrollingSibling() - i5, -kSAppBarLayout.getDownNestedScrollRange(), 0, i6);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.lib.desigin.KSHeaderBehavior, com.kwad.sdk.lib.desigin.KSCoordinatorLayout.Behavior
    public boolean onTouchEvent(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, MotionEvent motionEvent) {
        CustomHeaderBehaviorEx<KSAppBarLayout, CustomAppBarLayoutBehavior> customHeaderBehaviorEx = this.mHeaderExBehavior;
        return customHeaderBehaviorEx == null ? super.onTouchEvent(kSCoordinatorLayout, (KSCoordinatorLayout) kSAppBarLayout, motionEvent) : customHeaderBehaviorEx.onTouchEvent(kSCoordinatorLayout, (KSCoordinatorLayout) kSAppBarLayout, motionEvent);
    }

    public void setExtraFixedSize(int i2) {
        this.mExtraFixedSize = i2;
        CustomHeaderBehaviorEx<KSAppBarLayout, CustomAppBarLayoutBehavior> customHeaderBehaviorEx = this.mHeaderExBehavior;
        if (customHeaderBehaviorEx != null) {
            customHeaderBehaviorEx.setExtraFixedSize(i2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.lib.desigin.KSHeaderBehavior
    public int setHeaderTopBottomOffset(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, int i2) {
        return setHeaderTopBottomOffset(kSCoordinatorLayout, kSAppBarLayout, i2, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.lib.desigin.KSAppBarLayout.KSBehavior, com.kwad.sdk.lib.desigin.KSHeaderBehavior
    public int setHeaderTopBottomOffset(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, int i2, int i3, int i4) {
        return setHeaderTopBottomOffset(kSCoordinatorLayout, kSAppBarLayout, i2, i3, i4, -1);
    }

    public int setHeaderTopBottomOffset(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, int i2, int i3, int i4, int i5) {
        int topBottomOffsetForScrollingSibling = getTopBottomOffsetForScrollingSibling();
        if (this.mScrollableSizeChangeable) {
            int scrollableSize = getScrollableSize();
            int i6 = i2 - topBottomOffsetForScrollingSibling;
            if (i6 <= 0) {
                if (scrollableSize <= 0) {
                    return -i6;
                }
                int i7 = scrollableSize + i2;
                if (i7 <= 0) {
                    setTopAndBottomOffset(-scrollableSize);
                    return i7;
                }
            }
        }
        int i8 = 0;
        if (i3 == 0 || topBottomOffsetForScrollingSibling < i3 || topBottomOffsetForScrollingSibling > i4) {
            this.mOffsetDelta = 0;
        } else {
            int clamp = MathUtils.clamp(i2, i3, i4);
            if (topBottomOffsetForScrollingSibling != clamp) {
                int interpolateOffset = kSAppBarLayout.hasChildWithInterpolator() ? interpolateOffset(kSAppBarLayout, clamp) : clamp;
                boolean topAndBottomOffset = setTopAndBottomOffset(interpolateOffset);
                i8 = topBottomOffsetForScrollingSibling - clamp;
                this.mOffsetDelta = clamp - interpolateOffset;
                if (!topAndBottomOffset && kSAppBarLayout.hasChildWithInterpolator()) {
                    kSCoordinatorLayout.dispatchDependentViewsChanged(kSAppBarLayout);
                }
                kSAppBarLayout.dispatchOffsetUpdates(getTopAndBottomOffset());
                updateAppBarLayoutDrawableState(kSCoordinatorLayout, kSAppBarLayout, clamp, clamp < topBottomOffsetForScrollingSibling ? -1 : 1, false);
            }
        }
        return i8;
    }

    public void setScrollableSize(int i2) {
        this.mScrollableSize = i2;
    }

    public void setScrollableSizeChangeable(boolean z) {
        this.mScrollableSizeChangeable = z;
    }

    public void stopFling() {
        CustomHeaderBehaviorEx<KSAppBarLayout, CustomAppBarLayoutBehavior> customHeaderBehaviorEx = this.mHeaderExBehavior;
        if (customHeaderBehaviorEx != null) {
            customHeaderBehaviorEx.stopFling();
        }
    }

    public void updateAppBarLayoutDrawableState(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, int i2, int i3, boolean z) {
        View appBarChildOnOffset = getAppBarChildOnOffset(kSAppBarLayout, i2);
        if (appBarChildOnOffset != null) {
            int scrollFlags = ((KSAppBarLayout.LayoutParams) appBarChildOnOffset.getLayoutParams()).getScrollFlags();
            if ((scrollFlags & 1) != 0) {
                int minimumHeight = ViewCompat.getMinimumHeight(appBarChildOnOffset);
                if ((i3 > 0 && (scrollFlags & 12) != 0) || (scrollFlags & 2) != 0) {
                    int i4 = -i2;
                    int bottom = (appBarChildOnOffset.getBottom() - minimumHeight) - kSAppBarLayout.getTopInset();
                }
            }
            if (z || shouldJumpElevationState(kSCoordinatorLayout, kSAppBarLayout)) {
                kSAppBarLayout.jumpDrawablesToCurrentState();
            }
        }
    }
}
