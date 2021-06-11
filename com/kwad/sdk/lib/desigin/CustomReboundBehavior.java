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
import android.widget.LinearLayout;
import androidx.annotation.Keep;
import androidx.core.math.MathUtils;
import com.kwad.sdk.R;
import com.kwad.sdk.lib.desigin.KSAppBarLayout;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Keep
/* loaded from: classes7.dex */
public class CustomReboundBehavior extends CustomAppBarLayoutBehavior {
    public static final int DEFAULT_REBOUND_MAX_OFFSET = 150;
    public static final int REBOUND_ANIM_TIME = 200;
    public static final String TAG = CustomReboundBehavior.class.toString();
    public static final int TYPE_UNKNOWN = -1;
    public WeakReference<KSAppBarLayout> mAppBartReference;
    public WeakReference<KSCoordinatorLayout> mCoordinatorReference;
    public List<CustomReboundOffsetCallback> mCustomReboundOffsetCallbacks;
    public boolean mEnableRebound;
    public HeaderTopBottomOffsetChangeListener mHeaderTopBottomOffsetChangeListener;
    public int mOffsetDelta;
    public int mOffsetRebound;
    public int mPreHeadHeight;
    public final int mReboundMaxOffset;
    public ValueAnimator mReboundRecoverAnimator;
    public View mReboundView;
    public final int mReboundViewId;
    public int mReboundViewOriginHeight;
    public int mReboundViewOriginWidth;

    /* loaded from: classes7.dex */
    public interface HeaderTopBottomOffsetChangeListener {
        void onHeaderTopBottomOffsetChange(int i2, int i3);
    }

    public CustomReboundBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int i2 = R.attr.ksad_reboundMaxOffset;
        int i3 = R.attr.ksad_reboundViewId;
        int i4 = R.attr.ksad_enableRebound;
        int[] iArr = {i2, i3, i4};
        Arrays.sort(iArr);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        this.mReboundMaxOffset = obtainStyledAttributes.getDimensionPixelOffset(Arrays.binarySearch(iArr, i2), (int) ((context.getResources().getDisplayMetrics().density * 150.0f) + 0.5f));
        this.mReboundViewId = obtainStyledAttributes.getResourceId(Arrays.binarySearch(iArr, i3), 0);
        this.mEnableRebound = obtainStyledAttributes.getBoolean(Arrays.binarySearch(iArr, i4), true);
        obtainStyledAttributes.recycle();
        if (this.mReboundViewId == 0) {
            throw new IllegalArgumentException("should set rebound view id , with 'reboundViewId'");
        }
    }

    public CustomReboundBehavior(CustomAppBarBehaviorParams customAppBarBehaviorParams) {
        super(customAppBarBehaviorParams);
        this.mReboundMaxOffset = customAppBarBehaviorParams.mReboundMaxOffset;
        this.mEnableRebound = customAppBarBehaviorParams.mEnableRebound;
        int i2 = customAppBarBehaviorParams.mReboundViewId;
        this.mReboundViewId = i2;
        if (i2 == 0) {
            throw new IllegalArgumentException("should set rebound view id , with 'reboundViewId'");
        }
    }

    private void animateReboundRecover(final KSCoordinatorLayout kSCoordinatorLayout, final KSAppBarLayout kSAppBarLayout) {
        ValueAnimator valueAnimator = this.mReboundRecoverAnimator;
        if (valueAnimator == null) {
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.mReboundRecoverAnimator = valueAnimator2;
            valueAnimator2.setDuration(200L);
            this.mReboundRecoverAnimator.setInterpolator(new DecelerateInterpolator());
            this.mReboundRecoverAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.lib.desigin.CustomReboundBehavior.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator3) {
                    CustomReboundBehavior.this.updateReboundHeaderHeight(kSCoordinatorLayout, kSAppBarLayout, ((Integer) valueAnimator3.getAnimatedValue()).intValue(), 2);
                }
            });
        } else if (valueAnimator.isRunning()) {
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
        int i2 = 0;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = kSAppBarLayout.getChildAt(i3);
            KSAppBarLayout.LayoutParams layoutParams = (KSAppBarLayout.LayoutParams) childAt.getLayoutParams();
            i2 += ((LinearLayout.LayoutParams) layoutParams).bottomMargin + ((LinearLayout.LayoutParams) layoutParams).topMargin + childAt.getMeasuredHeight();
        }
        return Math.max(0, i2);
    }

    public static int getScreenWidthPx(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    private int updateReboundByScroll(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, int i2, int i3) {
        if (kSAppBarLayout.getHeight() < this.mPreHeadHeight || i2 != 1) {
            updateReboundOffsetByScroll(kSCoordinatorLayout, kSAppBarLayout, this.mOffsetRebound + (i3 / 3));
            return getTopBottomOffsetForScrollingSibling() - i3;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateReboundHeaderHeight(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, int i2, int i3) {
        int i4;
        if (kSAppBarLayout.getHeight() < this.mPreHeadHeight || i2 < 0 || i2 > (i4 = this.mReboundMaxOffset)) {
            return;
        }
        this.mOffsetRebound = i2;
        List<CustomReboundOffsetCallback> list = this.mCustomReboundOffsetCallbacks;
        if (list != null && this.mEnableRebound) {
            float f2 = (i2 * 1.0f) / i4;
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mCustomReboundOffsetCallbacks.get(size).rebound(i3, f2, this.mOffsetRebound);
            }
        }
        View view = this.mReboundView;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = this.mReboundViewOriginHeight + i2;
            int i5 = layoutParams.width;
            int i6 = this.mReboundViewOriginWidth;
            if (i5 != i6) {
                layoutParams.width = i6;
            }
            this.mReboundView.setLayoutParams(layoutParams);
        }
        kSCoordinatorLayout.dispatchDependentViewsChanged(kSAppBarLayout);
    }

    private void updateReboundOffsetByScroll(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, int i2) {
        ValueAnimator valueAnimator = this.mReboundRecoverAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.mReboundRecoverAnimator.cancel();
        }
        updateReboundHeaderHeight(kSCoordinatorLayout, kSAppBarLayout, i2, 1);
    }

    public void addReboundOffsetCallback(CustomReboundOffsetCallback customReboundOffsetCallback) {
        if (this.mCustomReboundOffsetCallbacks == null) {
            this.mCustomReboundOffsetCallbacks = new ArrayList();
        }
        this.mCustomReboundOffsetCallbacks.add(customReboundOffsetCallback);
    }

    public void clearReboundOffsetCallback() {
        List<CustomReboundOffsetCallback> list = this.mCustomReboundOffsetCallbacks;
        if (list != null) {
            list.clear();
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
    public boolean onMeasureChild(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, int i2, int i3, int i4, int i5) {
        boolean onMeasureChild = super.onMeasureChild(kSCoordinatorLayout, kSAppBarLayout, i2, i3, i4, i5);
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
    public void onNestedScroll(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, View view, int i2, int i3, int i4, int i5, int i6) {
        HeaderTopBottomOffsetChangeListener headerTopBottomOffsetChangeListener;
        if (i5 < 0 && i6 == 1 && (headerTopBottomOffsetChangeListener = this.mHeaderTopBottomOffsetChangeListener) != null) {
            headerTopBottomOffsetChangeListener.onHeaderTopBottomOffsetChange(getTopBottomOffsetForScrollingSibling() - i5, -kSAppBarLayout.getDownNestedScrollRange());
        }
        super.onNestedScroll(kSCoordinatorLayout, kSAppBarLayout, view, i2, i3, i4, i5, i6);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.lib.desigin.KSAppBarLayout.KSBehavior, com.kwad.sdk.lib.desigin.KSCoordinatorLayout.Behavior
    public boolean onStartNestedScroll(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, View view, View view2, int i2, int i3) {
        ValueAnimator valueAnimator;
        boolean onStartNestedScroll = super.onStartNestedScroll(kSCoordinatorLayout, kSAppBarLayout, view, view2, i2, i3);
        if (onStartNestedScroll && (valueAnimator = this.mReboundRecoverAnimator) != null && valueAnimator.isRunning()) {
            this.mReboundRecoverAnimator.cancel();
        }
        return onStartNestedScroll;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.lib.desigin.KSAppBarLayout.KSBehavior, com.kwad.sdk.lib.desigin.KSCoordinatorLayout.Behavior
    public void onStopNestedScroll(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, View view, int i2) {
        super.onStopNestedScroll(kSCoordinatorLayout, kSAppBarLayout, view, i2);
        checkShouldReboundRecover(kSCoordinatorLayout, kSAppBarLayout);
    }

    public void removeReboundOffsetCallback(CustomReboundOffsetCallback customReboundOffsetCallback) {
        List<CustomReboundOffsetCallback> list = this.mCustomReboundOffsetCallbacks;
        if (list != null) {
            list.remove(customReboundOffsetCallback);
        }
    }

    public void setEnableRebound(boolean z) {
        WeakReference<KSAppBarLayout> weakReference;
        this.mEnableRebound = z;
        WeakReference<KSCoordinatorLayout> weakReference2 = this.mCoordinatorReference;
        if (weakReference2 == null || weakReference2.get() == null || (weakReference = this.mAppBartReference) == null || weakReference.get() == null) {
            return;
        }
        animateReboundRecover(this.mCoordinatorReference.get(), this.mAppBartReference.get());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.lib.desigin.CustomAppBarLayoutBehavior, com.kwad.sdk.lib.desigin.KSHeaderBehavior
    public int setHeaderTopBottomOffset(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, int i2) {
        return setHeaderTopBottomOffset(kSCoordinatorLayout, kSAppBarLayout, i2, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.lib.desigin.CustomAppBarLayoutBehavior, com.kwad.sdk.lib.desigin.KSAppBarLayout.KSBehavior, com.kwad.sdk.lib.desigin.KSHeaderBehavior
    public int setHeaderTopBottomOffset(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, int i2, int i3, int i4) {
        return setHeaderTopBottomOffset(kSCoordinatorLayout, kSAppBarLayout, i2, i3, i4, -1);
    }

    @Override // com.kwad.sdk.lib.desigin.CustomAppBarLayoutBehavior
    public int setHeaderTopBottomOffset(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, int i2, int i3, int i4, int i5) {
        HeaderTopBottomOffsetChangeListener headerTopBottomOffsetChangeListener = this.mHeaderTopBottomOffsetChangeListener;
        if (headerTopBottomOffsetChangeListener != null) {
            headerTopBottomOffsetChangeListener.onHeaderTopBottomOffsetChange(i2, i3);
        }
        if (this.mEnableRebound) {
            int topBottomOffsetForScrollingSibling = getTopBottomOffsetForScrollingSibling();
            if (this.mOffsetRebound <= 0 || kSAppBarLayout.getHeight() < this.mPreHeadHeight) {
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
                if (i3 == 0 || topBottomOffsetForScrollingSibling < i3 || topBottomOffsetForScrollingSibling > i4) {
                    this.mOffsetDelta = 0;
                    return 0;
                }
                int clamp = MathUtils.clamp(i2, i3, i4);
                if (topBottomOffsetForScrollingSibling == clamp) {
                    if (topBottomOffsetForScrollingSibling != i3) {
                        return updateReboundByScroll(kSCoordinatorLayout, kSAppBarLayout, i5, i2);
                    }
                    return 0;
                }
                int interpolateOffset = kSAppBarLayout.hasChildWithInterpolator() ? interpolateOffset(kSAppBarLayout, clamp) : clamp;
                boolean topAndBottomOffset = setTopAndBottomOffset(interpolateOffset);
                this.mOffsetDelta = clamp - interpolateOffset;
                int i8 = topBottomOffsetForScrollingSibling - clamp;
                if (!topAndBottomOffset && kSAppBarLayout.hasChildWithInterpolator()) {
                    kSCoordinatorLayout.dispatchDependentViewsChanged(kSAppBarLayout);
                }
                kSAppBarLayout.dispatchOffsetUpdates(getTopAndBottomOffset());
                updateAppBarLayoutDrawableState(kSCoordinatorLayout, kSAppBarLayout, clamp, clamp < topBottomOffsetForScrollingSibling ? -1 : 1, false);
                return i8;
            }
            return updateReboundByScroll(kSCoordinatorLayout, kSAppBarLayout, i5, i2);
        }
        return super.setHeaderTopBottomOffset(kSCoordinatorLayout, kSAppBarLayout, i2, i3, i4, i5);
    }

    public void setHeaderTopBottomOffsetChangeListener(HeaderTopBottomOffsetChangeListener headerTopBottomOffsetChangeListener) {
        this.mHeaderTopBottomOffsetChangeListener = headerTopBottomOffsetChangeListener;
    }
}
