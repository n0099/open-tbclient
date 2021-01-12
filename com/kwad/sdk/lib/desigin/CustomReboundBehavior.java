package com.kwad.sdk.lib.desigin;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.Keep;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.core.math.MathUtils;
import com.kwad.sdk.R;
import com.kwad.sdk.lib.desigin.KSAppBarLayout;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Keep
/* loaded from: classes4.dex */
public class CustomReboundBehavior extends CustomAppBarLayoutBehavior {
    private static final int DEFAULT_REBOUND_MAX_OFFSET = 150;
    private static final int REBOUND_ANIM_TIME = 200;
    private static final String TAG = CustomReboundBehavior.class.toString();
    private static final int TYPE_UNKNOWN = -1;
    private WeakReference<KSAppBarLayout> mAppBartReference;
    private WeakReference<KSCoordinatorLayout> mCoordinatorReference;
    private List<CustomReboundOffsetCallback> mCustomReboundOffsetCallbacks;
    private boolean mEnableRebound;
    private HeaderTopBottomOffsetChangeListener mHeaderTopBottomOffsetChangeListener;
    private int mOffsetDelta;
    private int mOffsetRebound;
    private int mPreHeadHeight;
    private final int mReboundMaxOffset;
    private ValueAnimator mReboundRecoverAnimator;
    private View mReboundView;
    private final int mReboundViewId;
    private int mReboundViewOriginHeight;
    private int mReboundViewOriginWidth;

    /* loaded from: classes4.dex */
    public interface HeaderTopBottomOffsetChangeListener {
        void onHeaderTopBottomOffsetChange(int i, int i2);
    }

    public CustomReboundBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int i = R.attr.ksad_reboundMaxOffset;
        int i2 = R.attr.ksad_reboundViewId;
        int i3 = R.attr.ksad_enableRebound;
        int[] iArr = {i, i2, i3};
        Arrays.sort(iArr);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        this.mReboundMaxOffset = obtainStyledAttributes.getDimensionPixelOffset(Arrays.binarySearch(iArr, i), (int) ((context.getResources().getDisplayMetrics().density * 150.0f) + 0.5f));
        this.mReboundViewId = obtainStyledAttributes.getResourceId(Arrays.binarySearch(iArr, i2), 0);
        this.mEnableRebound = obtainStyledAttributes.getBoolean(Arrays.binarySearch(iArr, i3), true);
        obtainStyledAttributes.recycle();
        if (this.mReboundViewId == 0) {
            throw new IllegalArgumentException("should set rebound view id , with 'reboundViewId'");
        }
    }

    public CustomReboundBehavior(CustomAppBarBehaviorParams customAppBarBehaviorParams) {
        super(customAppBarBehaviorParams);
        this.mReboundMaxOffset = customAppBarBehaviorParams.mReboundMaxOffset;
        this.mEnableRebound = customAppBarBehaviorParams.mEnableRebound;
        this.mReboundViewId = customAppBarBehaviorParams.mReboundViewId;
        if (this.mReboundViewId == 0) {
            throw new IllegalArgumentException("should set rebound view id , with 'reboundViewId'");
        }
    }

    private void animateReboundRecover(final KSCoordinatorLayout kSCoordinatorLayout, final KSAppBarLayout kSAppBarLayout) {
        if (this.mReboundRecoverAnimator == null) {
            this.mReboundRecoverAnimator = new ValueAnimator();
            this.mReboundRecoverAnimator.setDuration(200L);
            this.mReboundRecoverAnimator.setInterpolator(new DecelerateInterpolator());
            this.mReboundRecoverAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.lib.desigin.CustomReboundBehavior.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    CustomReboundBehavior.this.updateReboundHeaderHeight(kSCoordinatorLayout, kSAppBarLayout, ((Integer) valueAnimator.getAnimatedValue()).intValue(), 2);
                }
            });
        } else if (this.mReboundRecoverAnimator.isRunning()) {
            this.mReboundRecoverAnimator.cancel();
        }
        this.mReboundRecoverAnimator.setIntValues(this.mOffsetRebound, 0);
        this.mReboundRecoverAnimator.start();
    }

    private void checkShouldReboundRecover(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout) {
        if (this.mOffsetRebound > 0) {
            animateReboundRecover(kSCoordinatorLayout, kSAppBarLayout);
        }
    }

    private int getHeaderExpandedHeight(KSAppBarLayout kSAppBarLayout) {
        int childCount = kSAppBarLayout.getChildCount();
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = kSAppBarLayout.getChildAt(i2);
            KSAppBarLayout.LayoutParams layoutParams = (KSAppBarLayout.LayoutParams) childAt.getLayoutParams();
            i += layoutParams.topMargin + layoutParams.bottomMargin + childAt.getMeasuredHeight();
        }
        return Math.max(0, i);
    }

    private static int getScreenWidthPx(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    private int updateReboundByScroll(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, int i, int i2) {
        if (kSAppBarLayout.getHeight() < this.mPreHeadHeight || i != 1) {
            updateReboundOffsetByScroll(kSCoordinatorLayout, kSAppBarLayout, this.mOffsetRebound + (i2 / 3));
            return getTopBottomOffsetForScrollingSibling() - i2;
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateReboundHeaderHeight(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, int i, int i2) {
        if (kSAppBarLayout.getHeight() < this.mPreHeadHeight || i < 0 || i > this.mReboundMaxOffset) {
            return;
        }
        this.mOffsetRebound = i;
        if (this.mCustomReboundOffsetCallbacks != null && this.mEnableRebound) {
            float f = (this.mOffsetRebound * 1.0f) / this.mReboundMaxOffset;
            for (int size = this.mCustomReboundOffsetCallbacks.size() - 1; size >= 0; size--) {
                this.mCustomReboundOffsetCallbacks.get(size).rebound(i2, f, this.mOffsetRebound);
            }
        }
        if (this.mReboundView != null) {
            ViewGroup.LayoutParams layoutParams = this.mReboundView.getLayoutParams();
            layoutParams.height = this.mReboundViewOriginHeight + i;
            if (layoutParams.width != this.mReboundViewOriginWidth) {
                layoutParams.width = this.mReboundViewOriginWidth;
            }
            this.mReboundView.setLayoutParams(layoutParams);
        }
        kSCoordinatorLayout.dispatchDependentViewsChanged(kSAppBarLayout);
    }

    private void updateReboundOffsetByScroll(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, int i) {
        if (this.mReboundRecoverAnimator != null && this.mReboundRecoverAnimator.isRunning()) {
            this.mReboundRecoverAnimator.cancel();
        }
        updateReboundHeaderHeight(kSCoordinatorLayout, kSAppBarLayout, i, 1);
    }

    public void addReboundOffsetCallback(CustomReboundOffsetCallback customReboundOffsetCallback) {
        if (this.mCustomReboundOffsetCallbacks == null) {
            this.mCustomReboundOffsetCallbacks = new ArrayList();
        }
        this.mCustomReboundOffsetCallbacks.add(customReboundOffsetCallback);
    }

    public void clearReboundOffsetCallback() {
        if (this.mCustomReboundOffsetCallbacks != null) {
            this.mCustomReboundOffsetCallbacks.clear();
        }
    }

    public int getOffsetDelta() {
        return this.mOffsetDelta;
    }

    public int getOffsetRebound() {
        return this.mOffsetRebound;
    }

    public int getReboundMaxOffset() {
        return this.mReboundMaxOffset;
    }

    @Override // com.kwad.sdk.lib.desigin.CustomAppBarLayoutBehavior, com.kwad.sdk.lib.desigin.KSAppBarLayout.KSBehavior, com.kwad.sdk.lib.desigin.KSHeaderBehavior
    public int getTopBottomOffsetForScrollingSibling() {
        return getTopAndBottomOffset() + this.mOffsetDelta;
    }

    public boolean isEnableRebound() {
        return this.mEnableRebound;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.lib.desigin.KSAppBarLayout.KSBehavior, com.kwad.sdk.lib.desigin.KSHeaderBehavior
    public void onFlingFinished(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout) {
        super.onFlingFinished(kSCoordinatorLayout, kSAppBarLayout);
        checkShouldReboundRecover(kSCoordinatorLayout, kSAppBarLayout);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.lib.desigin.CustomAppBarLayoutBehavior, com.kwad.sdk.lib.desigin.KSAppBarLayout.KSBehavior, com.kwad.sdk.lib.desigin.KSCoordinatorLayout.Behavior
    public boolean onMeasureChild(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, int i, int i2, int i3, int i4) {
        boolean onMeasureChild = super.onMeasureChild(kSCoordinatorLayout, kSAppBarLayout, i, i2, i3, i4);
        if (this.mPreHeadHeight != kSAppBarLayout.getMeasuredHeight() && kSAppBarLayout.getMeasuredHeight() != 0) {
            this.mPreHeadHeight = getHeaderExpandedHeight(kSAppBarLayout);
        }
        if (this.mReboundView == null) {
            View findViewById = kSAppBarLayout.findViewById(this.mReboundViewId);
            if (findViewById == null) {
                throw new NullPointerException(String.format("find rebound view with id %d is null", Integer.valueOf(this.mReboundViewId)));
            }
            this.mReboundViewOriginHeight = findViewById.getMeasuredHeight();
            this.mReboundViewOriginWidth = getScreenWidthPx(findViewById.getContext());
            this.mReboundView = findViewById;
        }
        if (this.mCoordinatorReference == null) {
            this.mCoordinatorReference = new WeakReference<>(kSCoordinatorLayout);
        }
        if (this.mAppBartReference == null) {
            this.mAppBartReference = new WeakReference<>(kSAppBarLayout);
        }
        return onMeasureChild;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.lib.desigin.CustomAppBarLayoutBehavior, com.kwad.sdk.lib.desigin.KSAppBarLayout.KSBehavior, com.kwad.sdk.lib.desigin.KSCoordinatorLayout.Behavior
    public void onNestedScroll(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, View view, int i, int i2, int i3, int i4, int i5) {
        if (i4 < 0 && i5 == 1 && this.mHeaderTopBottomOffsetChangeListener != null) {
            this.mHeaderTopBottomOffsetChangeListener.onHeaderTopBottomOffsetChange(getTopBottomOffsetForScrollingSibling() - i4, -kSAppBarLayout.getDownNestedScrollRange());
        }
        super.onNestedScroll(kSCoordinatorLayout, kSAppBarLayout, view, i, i2, i3, i4, i5);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.lib.desigin.KSAppBarLayout.KSBehavior, com.kwad.sdk.lib.desigin.KSCoordinatorLayout.Behavior
    public boolean onStartNestedScroll(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, View view, View view2, int i, int i2) {
        boolean onStartNestedScroll = super.onStartNestedScroll(kSCoordinatorLayout, kSAppBarLayout, view, view2, i, i2);
        if (onStartNestedScroll && this.mReboundRecoverAnimator != null && this.mReboundRecoverAnimator.isRunning()) {
            this.mReboundRecoverAnimator.cancel();
        }
        return onStartNestedScroll;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.lib.desigin.KSAppBarLayout.KSBehavior, com.kwad.sdk.lib.desigin.KSCoordinatorLayout.Behavior
    public void onStopNestedScroll(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, View view, int i) {
        super.onStopNestedScroll(kSCoordinatorLayout, kSAppBarLayout, view, i);
        checkShouldReboundRecover(kSCoordinatorLayout, kSAppBarLayout);
    }

    public void removeReboundOffsetCallback(CustomReboundOffsetCallback customReboundOffsetCallback) {
        if (this.mCustomReboundOffsetCallbacks != null) {
            this.mCustomReboundOffsetCallbacks.remove(customReboundOffsetCallback);
        }
    }

    public void setEnableRebound(boolean z) {
        this.mEnableRebound = z;
        if (this.mCoordinatorReference == null || this.mCoordinatorReference.get() == null || this.mAppBartReference == null || this.mAppBartReference.get() == null) {
            return;
        }
        animateReboundRecover(this.mCoordinatorReference.get(), this.mAppBartReference.get());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.lib.desigin.CustomAppBarLayoutBehavior, com.kwad.sdk.lib.desigin.KSHeaderBehavior
    public int setHeaderTopBottomOffset(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, int i) {
        return setHeaderTopBottomOffset(kSCoordinatorLayout, kSAppBarLayout, i, Integer.MIN_VALUE, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.lib.desigin.CustomAppBarLayoutBehavior, com.kwad.sdk.lib.desigin.KSAppBarLayout.KSBehavior, com.kwad.sdk.lib.desigin.KSHeaderBehavior
    public int setHeaderTopBottomOffset(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, int i, int i2, int i3) {
        return setHeaderTopBottomOffset(kSCoordinatorLayout, kSAppBarLayout, i, i2, i3, -1);
    }

    @Override // com.kwad.sdk.lib.desigin.CustomAppBarLayoutBehavior
    public int setHeaderTopBottomOffset(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, int i, int i2, int i3, int i4) {
        if (this.mHeaderTopBottomOffsetChangeListener != null) {
            this.mHeaderTopBottomOffsetChangeListener.onHeaderTopBottomOffsetChange(i, i2);
        }
        if (this.mEnableRebound) {
            int topBottomOffsetForScrollingSibling = getTopBottomOffsetForScrollingSibling();
            if (this.mOffsetRebound <= 0 || kSAppBarLayout.getHeight() < this.mPreHeadHeight) {
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
                if (i2 == 0 || topBottomOffsetForScrollingSibling < i2 || topBottomOffsetForScrollingSibling > i3) {
                    this.mOffsetDelta = 0;
                    return 0;
                }
                int clamp = MathUtils.clamp(i, i2, i3);
                if (topBottomOffsetForScrollingSibling == clamp) {
                    if (topBottomOffsetForScrollingSibling != i2) {
                        return updateReboundByScroll(kSCoordinatorLayout, kSAppBarLayout, i4, i);
                    }
                    return 0;
                }
                int interpolateOffset = kSAppBarLayout.hasChildWithInterpolator() ? interpolateOffset(kSAppBarLayout, clamp) : clamp;
                boolean topAndBottomOffset = setTopAndBottomOffset(interpolateOffset);
                this.mOffsetDelta = clamp - interpolateOffset;
                int i6 = topBottomOffsetForScrollingSibling - clamp;
                if (!topAndBottomOffset && kSAppBarLayout.hasChildWithInterpolator()) {
                    kSCoordinatorLayout.dispatchDependentViewsChanged(kSAppBarLayout);
                }
                kSAppBarLayout.dispatchOffsetUpdates(getTopAndBottomOffset());
                updateAppBarLayoutDrawableState(kSCoordinatorLayout, kSAppBarLayout, clamp, clamp < topBottomOffsetForScrollingSibling ? -1 : 1, false);
                return i6;
            }
            return updateReboundByScroll(kSCoordinatorLayout, kSAppBarLayout, i4, i);
        }
        return super.setHeaderTopBottomOffset(kSCoordinatorLayout, kSAppBarLayout, i, i2, i3, i4);
    }

    public void setHeaderTopBottomOffsetChangeListener(HeaderTopBottomOffsetChangeListener headerTopBottomOffsetChangeListener) {
        this.mHeaderTopBottomOffsetChangeListener = headerTopBottomOffsetChangeListener;
    }
}
