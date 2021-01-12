package com.kwad.sdk.lib.desigin;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.math.MathUtils;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import com.kwad.sdk.R;
import com.kwad.sdk.lib.desigin.KSCoordinatorLayout;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
@Keep
@KSCoordinatorLayout.DefaultBehavior(KSBehavior.class)
/* loaded from: classes4.dex */
public class KSAppBarLayout extends LinearLayout {
    private static final int INVALID_SCROLL_RANGE = -1;
    static final int PENDING_ACTION_ANIMATE_ENABLED = 4;
    static final int PENDING_ACTION_COLLAPSED = 2;
    static final int PENDING_ACTION_EXPANDED = 1;
    static final int PENDING_ACTION_FORCE = 8;
    static final int PENDING_ACTION_NONE = 0;
    private boolean mCollapsed;
    private boolean mCollapsible;
    private int mDownPreScrollRange;
    private int mDownScrollRange;
    private boolean mHaveChildWithInterpolator;
    private WindowInsetsCompat mLastInsets;
    private List<OnOffsetChangedListener> mListeners;
    private int mPendingAction;
    private int[] mTmpStatesArray;
    private int mTotalScrollRange;

    /* loaded from: classes4.dex */
    public static class KSBehavior extends KSHeaderBehavior<KSAppBarLayout> {
        private static final int INVALID_POSITION = -1;
        private static final int MAX_OFFSET_ANIMATION_DURATION = 600;
        private WeakReference<View> mLastNestedScrollingChildRef;
        private ValueAnimator mOffsetAnimator;
        private int mOffsetDelta;
        private int mOffsetToChildIndexOnLayout;
        private boolean mOffsetToChildIndexOnLayoutIsMinHeight;
        private float mOffsetToChildIndexOnLayoutPerc;
        private DragCallback mOnDragCallback;

        /* loaded from: classes4.dex */
        public static abstract class DragCallback {
            public abstract boolean canDrag(@NonNull KSAppBarLayout kSAppBarLayout);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* loaded from: classes4.dex */
        public static class SavedState extends AbsSavedState {
            public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.kwad.sdk.lib.desigin.KSAppBarLayout.KSBehavior.SavedState.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // android.os.Parcelable.Creator
                public SavedState createFromParcel(Parcel parcel) {
                    return new SavedState(parcel, null);
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.ClassLoaderCreator
                public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return new SavedState(parcel, classLoader);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // android.os.Parcelable.Creator
                public SavedState[] newArray(int i) {
                    return new SavedState[i];
                }
            };
            boolean firstVisibleChildAtMinimumHeight;
            int firstVisibleChildIndex;
            float firstVisibleChildPercentageShown;

            public SavedState(Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                this.firstVisibleChildIndex = parcel.readInt();
                this.firstVisibleChildPercentageShown = parcel.readFloat();
                this.firstVisibleChildAtMinimumHeight = parcel.readByte() != 0;
            }

            public SavedState(Parcelable parcelable) {
                super(parcelable);
            }

            @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i) {
                super.writeToParcel(parcel, i);
                parcel.writeInt(this.firstVisibleChildIndex);
                parcel.writeFloat(this.firstVisibleChildPercentageShown);
                parcel.writeByte((byte) (this.firstVisibleChildAtMinimumHeight ? 1 : 0));
            }
        }

        public KSBehavior() {
            this.mOffsetToChildIndexOnLayout = -1;
        }

        public KSBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.mOffsetToChildIndexOnLayout = -1;
        }

        private void animateOffsetTo(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, int i, float f) {
            int abs = Math.abs(getTopBottomOffsetForScrollingSibling() - i);
            float abs2 = Math.abs(f);
            animateOffsetWithDuration(kSCoordinatorLayout, kSAppBarLayout, i, abs2 > 0.0f ? Math.round((abs / abs2) * 1000.0f) * 3 : (int) (((abs / kSAppBarLayout.getHeight()) + 1.0f) * 150.0f));
        }

        private void animateOffsetWithDuration(final KSCoordinatorLayout kSCoordinatorLayout, final KSAppBarLayout kSAppBarLayout, int i, int i2) {
            int topBottomOffsetForScrollingSibling = getTopBottomOffsetForScrollingSibling();
            if (topBottomOffsetForScrollingSibling == i) {
                if (this.mOffsetAnimator == null || !this.mOffsetAnimator.isRunning()) {
                    return;
                }
                this.mOffsetAnimator.cancel();
                return;
            }
            if (this.mOffsetAnimator == null) {
                this.mOffsetAnimator = new ValueAnimator();
                this.mOffsetAnimator.setInterpolator(KSAnimationUtils.DECELERATE_INTERPOLATOR);
                this.mOffsetAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.lib.desigin.KSAppBarLayout.KSBehavior.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        KSBehavior.this.setHeaderTopBottomOffset(kSCoordinatorLayout, kSAppBarLayout, ((Integer) valueAnimator.getAnimatedValue()).intValue());
                    }
                });
            } else {
                this.mOffsetAnimator.cancel();
            }
            this.mOffsetAnimator.setDuration(Math.min(i2, 600));
            this.mOffsetAnimator.setIntValues(topBottomOffsetForScrollingSibling, i);
            this.mOffsetAnimator.start();
        }

        private static boolean checkFlag(int i, int i2) {
            return (i & i2) == i2;
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

        private int getChildIndexOnOffset(KSAppBarLayout kSAppBarLayout, int i) {
            int childCount = kSAppBarLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = kSAppBarLayout.getChildAt(i2);
                if (childAt.getTop() <= (-i) && childAt.getBottom() >= (-i)) {
                    return i2;
                }
            }
            return -1;
        }

        private int interpolateOffset(KSAppBarLayout kSAppBarLayout, int i) {
            int i2;
            int abs = Math.abs(i);
            int childCount = kSAppBarLayout.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = kSAppBarLayout.getChildAt(i3);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
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

        private boolean shouldJumpElevationState(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout) {
            List<View> dependents = kSCoordinatorLayout.getDependents(kSAppBarLayout);
            int size = dependents.size();
            for (int i = 0; i < size; i++) {
                KSCoordinatorLayout.Behavior behavior = ((KSCoordinatorLayout.LayoutParams) dependents.get(i).getLayoutParams()).getBehavior();
                if (behavior instanceof ScrollingViewBehavior) {
                    return ((ScrollingViewBehavior) behavior).getOverlayTop() != 0;
                }
            }
            return false;
        }

        private void snapToChildIfNeeded(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout) {
            int topBottomOffsetForScrollingSibling = getTopBottomOffsetForScrollingSibling();
            int childIndexOnOffset = getChildIndexOnOffset(kSAppBarLayout, topBottomOffsetForScrollingSibling);
            if (childIndexOnOffset >= 0) {
                View childAt = kSAppBarLayout.getChildAt(childIndexOnOffset);
                int scrollFlags = ((LayoutParams) childAt.getLayoutParams()).getScrollFlags();
                if ((scrollFlags & 17) == 17) {
                    int i = -childAt.getTop();
                    int i2 = -childAt.getBottom();
                    if (childIndexOnOffset == kSAppBarLayout.getChildCount() - 1) {
                        i2 += kSAppBarLayout.getTopInset();
                    }
                    if (checkFlag(scrollFlags, 2)) {
                        i2 += ViewCompat.getMinimumHeight(childAt);
                    } else if (checkFlag(scrollFlags, 5)) {
                        int minimumHeight = ViewCompat.getMinimumHeight(childAt) + i2;
                        if (topBottomOffsetForScrollingSibling < minimumHeight) {
                            i = minimumHeight;
                        } else {
                            i2 = minimumHeight;
                        }
                    }
                    if (topBottomOffsetForScrollingSibling >= (i2 + i) / 2) {
                        i2 = i;
                    }
                    animateOffsetTo(kSCoordinatorLayout, kSAppBarLayout, MathUtils.clamp(i2, -kSAppBarLayout.getTotalScrollRange(), 0), 0.0f);
                }
            }
        }

        private void updateAppBarLayoutDrawableState(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, int i, int i2, boolean z) {
            boolean z2 = false;
            View appBarChildOnOffset = getAppBarChildOnOffset(kSAppBarLayout, i);
            if (appBarChildOnOffset != null) {
                int scrollFlags = ((LayoutParams) appBarChildOnOffset.getLayoutParams()).getScrollFlags();
                if ((scrollFlags & 1) != 0) {
                    int minimumHeight = ViewCompat.getMinimumHeight(appBarChildOnOffset);
                    if (i2 > 0 && (scrollFlags & 12) != 0) {
                        z2 = (-i) >= (appBarChildOnOffset.getBottom() - minimumHeight) - kSAppBarLayout.getTopInset();
                    } else if ((scrollFlags & 2) != 0) {
                        z2 = (-i) >= (appBarChildOnOffset.getBottom() - minimumHeight) - kSAppBarLayout.getTopInset();
                    }
                }
                boolean collapsedState = kSAppBarLayout.setCollapsedState(z2);
                if (Build.VERSION.SDK_INT >= 11) {
                    if (z || (collapsedState && shouldJumpElevationState(kSCoordinatorLayout, kSAppBarLayout))) {
                        kSAppBarLayout.jumpDrawablesToCurrentState();
                    }
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwad.sdk.lib.desigin.KSHeaderBehavior
        public boolean canDragView(KSAppBarLayout kSAppBarLayout) {
            if (this.mOnDragCallback != null) {
                return this.mOnDragCallback.canDrag(kSAppBarLayout);
            }
            if (this.mLastNestedScrollingChildRef != null) {
                View view = this.mLastNestedScrollingChildRef.get();
                return (view == null || !view.isShown() || view.canScrollVertically(-1)) ? false : true;
            }
            return true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwad.sdk.lib.desigin.KSHeaderBehavior
        public int getMaxDragOffset(KSAppBarLayout kSAppBarLayout) {
            return -kSAppBarLayout.getDownNestedScrollRange();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.kwad.sdk.lib.desigin.KSHeaderBehavior
        public int getScrollRangeForDragFling(KSAppBarLayout kSAppBarLayout) {
            return kSAppBarLayout.getTotalScrollRange();
        }

        @Override // com.kwad.sdk.lib.desigin.KSHeaderBehavior
        public int getTopBottomOffsetForScrollingSibling() {
            return getTopAndBottomOffset() + this.mOffsetDelta;
        }

        @VisibleForTesting
        public boolean isOffsetAnimatorRunning() {
            return this.mOffsetAnimator != null && this.mOffsetAnimator.isRunning();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.kwad.sdk.lib.desigin.KSHeaderBehavior
        public void onFlingFinished(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout) {
            snapToChildIfNeeded(kSCoordinatorLayout, kSAppBarLayout);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwad.sdk.lib.desigin.KSViewOffsetBehavior, com.kwad.sdk.lib.desigin.KSCoordinatorLayout.Behavior
        public boolean onLayoutChild(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, int i) {
            boolean onLayoutChild = super.onLayoutChild(kSCoordinatorLayout, (KSCoordinatorLayout) kSAppBarLayout, i);
            int pendingAction = kSAppBarLayout.getPendingAction();
            if (this.mOffsetToChildIndexOnLayout >= 0 && (pendingAction & 8) == 0) {
                View childAt = kSAppBarLayout.getChildAt(this.mOffsetToChildIndexOnLayout);
                int i2 = -childAt.getBottom();
                setHeaderTopBottomOffset(kSCoordinatorLayout, kSAppBarLayout, this.mOffsetToChildIndexOnLayoutIsMinHeight ? ViewCompat.getMinimumHeight(childAt) + kSAppBarLayout.getTopInset() + i2 : Math.round(childAt.getHeight() * this.mOffsetToChildIndexOnLayoutPerc) + i2);
            } else if (pendingAction != 0) {
                boolean z = (pendingAction & 4) != 0;
                if ((pendingAction & 2) != 0) {
                    int i3 = -kSAppBarLayout.getUpNestedPreScrollRange();
                    if (z) {
                        animateOffsetTo(kSCoordinatorLayout, kSAppBarLayout, i3, 0.0f);
                    } else {
                        setHeaderTopBottomOffset(kSCoordinatorLayout, kSAppBarLayout, i3);
                    }
                } else if ((pendingAction & 1) != 0) {
                    if (z) {
                        animateOffsetTo(kSCoordinatorLayout, kSAppBarLayout, 0, 0.0f);
                    } else {
                        setHeaderTopBottomOffset(kSCoordinatorLayout, kSAppBarLayout, 0);
                    }
                }
            }
            kSAppBarLayout.resetPendingAction();
            this.mOffsetToChildIndexOnLayout = -1;
            setTopAndBottomOffset(MathUtils.clamp(getTopAndBottomOffset(), -kSAppBarLayout.getTotalScrollRange(), 0));
            updateAppBarLayoutDrawableState(kSCoordinatorLayout, kSAppBarLayout, getTopAndBottomOffset(), 0, true);
            kSAppBarLayout.dispatchOffsetUpdates(getTopAndBottomOffset());
            return onLayoutChild;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwad.sdk.lib.desigin.KSCoordinatorLayout.Behavior
        public boolean onMeasureChild(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, int i, int i2, int i3, int i4) {
            if (((KSCoordinatorLayout.LayoutParams) kSAppBarLayout.getLayoutParams()).height == -2) {
                kSCoordinatorLayout.onMeasureChild(kSAppBarLayout, i, i2, View.MeasureSpec.makeMeasureSpec(0, 0), i4);
                return true;
            }
            return super.onMeasureChild(kSCoordinatorLayout, (KSCoordinatorLayout) kSAppBarLayout, i, i2, i3, i4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwad.sdk.lib.desigin.KSCoordinatorLayout.Behavior
        public void onNestedPreScroll(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, View view, int i, int i2, int[] iArr, int i3) {
            int i4;
            int i5;
            if (i2 != 0) {
                if (i2 < 0) {
                    i4 = -kSAppBarLayout.getTotalScrollRange();
                    i5 = i4 + kSAppBarLayout.getDownNestedPreScrollRange();
                } else {
                    i4 = -kSAppBarLayout.getUpNestedPreScrollRange();
                    i5 = 0;
                }
                if (i4 != i5) {
                    iArr[1] = scroll(kSCoordinatorLayout, kSAppBarLayout, i2, i4, i5);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwad.sdk.lib.desigin.KSCoordinatorLayout.Behavior
        public void onNestedScroll(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, View view, int i, int i2, int i3, int i4, int i5) {
            if (i4 < 0) {
                scroll(kSCoordinatorLayout, kSAppBarLayout, i4, -kSAppBarLayout.getDownNestedScrollRange(), 0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwad.sdk.lib.desigin.KSCoordinatorLayout.Behavior
        public void onRestoreInstanceState(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, Parcelable parcelable) {
            if (!(parcelable instanceof SavedState)) {
                super.onRestoreInstanceState(kSCoordinatorLayout, (KSCoordinatorLayout) kSAppBarLayout, parcelable);
                this.mOffsetToChildIndexOnLayout = -1;
                return;
            }
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(kSCoordinatorLayout, (KSCoordinatorLayout) kSAppBarLayout, savedState.getSuperState());
            this.mOffsetToChildIndexOnLayout = savedState.firstVisibleChildIndex;
            this.mOffsetToChildIndexOnLayoutPerc = savedState.firstVisibleChildPercentageShown;
            this.mOffsetToChildIndexOnLayoutIsMinHeight = savedState.firstVisibleChildAtMinimumHeight;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwad.sdk.lib.desigin.KSCoordinatorLayout.Behavior
        public Parcelable onSaveInstanceState(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout) {
            Parcelable onSaveInstanceState = super.onSaveInstanceState(kSCoordinatorLayout, (KSCoordinatorLayout) kSAppBarLayout);
            int topAndBottomOffset = getTopAndBottomOffset();
            int childCount = kSAppBarLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = kSAppBarLayout.getChildAt(i);
                int bottom = childAt.getBottom() + topAndBottomOffset;
                if (childAt.getTop() + topAndBottomOffset <= 0 && bottom >= 0) {
                    SavedState savedState = new SavedState(onSaveInstanceState);
                    savedState.firstVisibleChildIndex = i;
                    savedState.firstVisibleChildAtMinimumHeight = bottom == ViewCompat.getMinimumHeight(childAt) + kSAppBarLayout.getTopInset();
                    savedState.firstVisibleChildPercentageShown = bottom / childAt.getHeight();
                    return savedState;
                }
            }
            return onSaveInstanceState;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwad.sdk.lib.desigin.KSCoordinatorLayout.Behavior
        public boolean onStartNestedScroll(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, View view, View view2, int i, int i2) {
            boolean z = (i & 2) != 0 && kSAppBarLayout.hasScrollableChildren() && kSCoordinatorLayout.getHeight() - view.getHeight() <= kSAppBarLayout.getHeight();
            if (z && this.mOffsetAnimator != null) {
                this.mOffsetAnimator.cancel();
            }
            this.mLastNestedScrollingChildRef = null;
            return z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwad.sdk.lib.desigin.KSCoordinatorLayout.Behavior
        public void onStopNestedScroll(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, View view, int i) {
            if (i == 0) {
                snapToChildIfNeeded(kSCoordinatorLayout, kSAppBarLayout);
            }
            this.mLastNestedScrollingChildRef = new WeakReference<>(view);
        }

        public void setDragCallback(@Nullable DragCallback dragCallback) {
            this.mOnDragCallback = dragCallback;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.kwad.sdk.lib.desigin.KSHeaderBehavior
        public int setHeaderTopBottomOffset(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, int i, int i2, int i3) {
            int topBottomOffsetForScrollingSibling = getTopBottomOffsetForScrollingSibling();
            if (i2 == 0 || topBottomOffsetForScrollingSibling < i2 || topBottomOffsetForScrollingSibling > i3) {
                this.mOffsetDelta = 0;
                return 0;
            }
            int clamp = MathUtils.clamp(i, i2, i3);
            if (topBottomOffsetForScrollingSibling != clamp) {
                int interpolateOffset = kSAppBarLayout.hasChildWithInterpolator() ? interpolateOffset(kSAppBarLayout, clamp) : clamp;
                boolean topAndBottomOffset = setTopAndBottomOffset(interpolateOffset);
                int i4 = topBottomOffsetForScrollingSibling - clamp;
                this.mOffsetDelta = clamp - interpolateOffset;
                if (!topAndBottomOffset && kSAppBarLayout.hasChildWithInterpolator()) {
                    kSCoordinatorLayout.dispatchDependentViewsChanged(kSAppBarLayout);
                }
                kSAppBarLayout.dispatchOffsetUpdates(getTopAndBottomOffset());
                updateAppBarLayoutDrawableState(kSCoordinatorLayout, kSAppBarLayout, clamp, clamp < topBottomOffsetForScrollingSibling ? -1 : 1, false);
                return i4;
            }
            return 0;
        }
    }

    /* loaded from: classes4.dex */
    public static class LayoutParams extends LinearLayout.LayoutParams {
        static final int COLLAPSIBLE_FLAGS = 10;
        static final int FLAG_QUICK_RETURN = 5;
        static final int FLAG_SNAP = 17;
        public static final int SCROLL_FLAG_ENTER_ALWAYS = 4;
        public static final int SCROLL_FLAG_ENTER_ALWAYS_COLLAPSED = 8;
        public static final int SCROLL_FLAG_EXIT_UNTIL_COLLAPSED = 2;
        public static final int SCROLL_FLAG_SCROLL = 1;
        public static final int SCROLL_FLAG_SNAP = 16;
        int mScrollFlags;
        Interpolator mScrollInterpolator;

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        /* loaded from: classes4.dex */
        public @interface ScrollFlags {
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.mScrollFlags = 1;
        }

        public LayoutParams(int i, int i2, float f) {
            super(i, i2, f);
            this.mScrollFlags = 1;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.mScrollFlags = 1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_AppBarLayout_Layout);
            this.mScrollFlags = obtainStyledAttributes.getInt(R.styleable.ksad_AppBarLayout_Layout_ksad_layout_scrollFlags, 0);
            if (obtainStyledAttributes.hasValue(R.styleable.ksad_AppBarLayout_Layout_ksad_layout_scrollInterpolator)) {
                this.mScrollInterpolator = AnimationUtils.loadInterpolator(context, obtainStyledAttributes.getResourceId(R.styleable.ksad_AppBarLayout_Layout_ksad_layout_scrollInterpolator, 0));
            }
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.mScrollFlags = 1;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.mScrollFlags = 1;
        }

        @RequiresApi(19)
        public LayoutParams(LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
            this.mScrollFlags = 1;
        }

        @RequiresApi(19)
        public LayoutParams(LayoutParams layoutParams) {
            super((LinearLayout.LayoutParams) layoutParams);
            this.mScrollFlags = 1;
            this.mScrollFlags = layoutParams.mScrollFlags;
            this.mScrollInterpolator = layoutParams.mScrollInterpolator;
        }

        public int getScrollFlags() {
            return this.mScrollFlags;
        }

        public Interpolator getScrollInterpolator() {
            return this.mScrollInterpolator;
        }

        boolean isCollapsible() {
            return (this.mScrollFlags & 1) == 1 && (this.mScrollFlags & 10) != 0;
        }

        public void setScrollFlags(int i) {
            this.mScrollFlags = i;
        }

        public void setScrollInterpolator(Interpolator interpolator) {
            this.mScrollInterpolator = interpolator;
        }
    }

    /* loaded from: classes4.dex */
    public interface OnOffsetChangedListener {
        void onOffsetChanged(KSAppBarLayout kSAppBarLayout, int i);
    }

    /* loaded from: classes4.dex */
    public static class ScrollingViewBehavior extends KSHeaderScrollingViewBehavior {
        public ScrollingViewBehavior() {
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_ScrollingViewBehavior_Layout);
            setOverlayTop(obtainStyledAttributes.getDimensionPixelSize(R.styleable.ksad_ScrollingViewBehavior_Layout_ksad_behavior_overlapTop, 0));
            obtainStyledAttributes.recycle();
        }

        private static int getAppBarLayoutOffset(KSAppBarLayout kSAppBarLayout) {
            KSCoordinatorLayout.Behavior behavior = ((KSCoordinatorLayout.LayoutParams) kSAppBarLayout.getLayoutParams()).getBehavior();
            if (behavior instanceof KSBehavior) {
                return ((KSBehavior) behavior).getTopBottomOffsetForScrollingSibling();
            }
            return 0;
        }

        private void offsetChildAsNeeded(KSCoordinatorLayout kSCoordinatorLayout, View view, View view2) {
            KSCoordinatorLayout.Behavior behavior = ((KSCoordinatorLayout.LayoutParams) view2.getLayoutParams()).getBehavior();
            if (behavior instanceof KSBehavior) {
                ViewCompat.offsetTopAndBottom(view, ((((KSBehavior) behavior).mOffsetDelta + (view2.getBottom() - view.getTop())) + getVerticalLayoutGap()) - getOverlapPixelsForOffset(view2));
            }
        }

        @Override // com.kwad.sdk.lib.desigin.KSHeaderScrollingViewBehavior
        /* bridge */ /* synthetic */ View findFirstDependency(List list) {
            return findFirstDependency((List<View>) list);
        }

        @Override // com.kwad.sdk.lib.desigin.KSHeaderScrollingViewBehavior
        KSAppBarLayout findFirstDependency(List<View> list) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                View view = list.get(i);
                if (view instanceof KSAppBarLayout) {
                    return (KSAppBarLayout) view;
                }
            }
            return null;
        }

        @Override // com.kwad.sdk.lib.desigin.KSHeaderScrollingViewBehavior
        float getOverlapRatioForOffset(View view) {
            int i;
            if (view instanceof KSAppBarLayout) {
                KSAppBarLayout kSAppBarLayout = (KSAppBarLayout) view;
                int totalScrollRange = kSAppBarLayout.getTotalScrollRange();
                int downNestedPreScrollRange = kSAppBarLayout.getDownNestedPreScrollRange();
                int appBarLayoutOffset = getAppBarLayoutOffset(kSAppBarLayout);
                if ((downNestedPreScrollRange == 0 || totalScrollRange + appBarLayoutOffset > downNestedPreScrollRange) && (i = totalScrollRange - downNestedPreScrollRange) != 0) {
                    return 1.0f + (appBarLayoutOffset / i);
                }
                return 0.0f;
            }
            return 0.0f;
        }

        @Override // com.kwad.sdk.lib.desigin.KSHeaderScrollingViewBehavior
        public int getScrollRange(View view) {
            return view instanceof KSAppBarLayout ? ((KSAppBarLayout) view).getTotalScrollRange() : super.getScrollRange(view);
        }

        @Override // com.kwad.sdk.lib.desigin.KSCoordinatorLayout.Behavior
        public boolean layoutDependsOn(KSCoordinatorLayout kSCoordinatorLayout, View view, View view2) {
            return view2 instanceof KSAppBarLayout;
        }

        @Override // com.kwad.sdk.lib.desigin.KSCoordinatorLayout.Behavior
        public boolean onDependentViewChanged(KSCoordinatorLayout kSCoordinatorLayout, View view, View view2) {
            offsetChildAsNeeded(kSCoordinatorLayout, view, view2);
            return false;
        }

        @Override // com.kwad.sdk.lib.desigin.KSHeaderScrollingViewBehavior, com.kwad.sdk.lib.desigin.KSCoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onMeasureChild(KSCoordinatorLayout kSCoordinatorLayout, View view, int i, int i2, int i3, int i4) {
            return super.onMeasureChild(kSCoordinatorLayout, view, i, i2, i3, i4);
        }

        @Override // com.kwad.sdk.lib.desigin.KSCoordinatorLayout.Behavior
        public boolean onRequestChildRectangleOnScreen(KSCoordinatorLayout kSCoordinatorLayout, View view, Rect rect, boolean z) {
            KSAppBarLayout findFirstDependency = findFirstDependency(kSCoordinatorLayout.getDependencies(view));
            if (findFirstDependency != null) {
                rect.offset(view.getLeft(), view.getTop());
                Rect rect2 = this.mTempRect1;
                rect2.set(0, 0, kSCoordinatorLayout.getWidth(), kSCoordinatorLayout.getHeight());
                if (!rect2.contains(rect)) {
                    findFirstDependency.setExpanded(false, !z);
                    return true;
                }
            }
            return false;
        }
    }

    public KSAppBarLayout(Context context) {
        this(context, null);
    }

    public KSAppBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTotalScrollRange = -1;
        this.mDownPreScrollRange = -1;
        this.mDownScrollRange = -1;
        this.mPendingAction = 0;
        setOrientation(1);
        if (Build.VERSION.SDK_INT >= 21) {
            KSViewUtilsLollipop.setBoundsViewOutlineProvider(this);
            KSViewUtilsLollipop.setStateListAnimatorFromAttrs(this, attributeSet, 0, R.style.ksad_Widget_Design_KSAppBarLayout);
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_AppBarLayout, 0, R.style.ksad_Widget_Design_KSAppBarLayout);
        ViewCompat.setBackground(this, obtainStyledAttributes.getDrawable(R.styleable.ksad_AppBarLayout_android_background));
        if (obtainStyledAttributes.hasValue(R.styleable.ksad_AppBarLayout_ksad_expanded)) {
            setExpanded(obtainStyledAttributes.getBoolean(R.styleable.ksad_AppBarLayout_ksad_expanded, false), false, false);
        }
        if (Build.VERSION.SDK_INT >= 26) {
            if (obtainStyledAttributes.hasValue(R.styleable.ksad_AppBarLayout_android_keyboardNavigationCluster)) {
                setKeyboardNavigationCluster(obtainStyledAttributes.getBoolean(R.styleable.ksad_AppBarLayout_android_keyboardNavigationCluster, false));
            }
            if (obtainStyledAttributes.hasValue(R.styleable.ksad_AppBarLayout_android_touchscreenBlocksFocus)) {
                setTouchscreenBlocksFocus(obtainStyledAttributes.getBoolean(R.styleable.ksad_AppBarLayout_android_touchscreenBlocksFocus, false));
            }
        }
        obtainStyledAttributes.recycle();
        ViewCompat.setOnApplyWindowInsetsListener(this, new OnApplyWindowInsetsListener() { // from class: com.kwad.sdk.lib.desigin.KSAppBarLayout.1
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                return KSAppBarLayout.this.onWindowInsetChanged(windowInsetsCompat);
            }
        });
    }

    private void invalidateScrollRanges() {
        this.mTotalScrollRange = -1;
        this.mDownPreScrollRange = -1;
        this.mDownScrollRange = -1;
    }

    private boolean setCollapsibleState(boolean z) {
        if (this.mCollapsible != z) {
            this.mCollapsible = z;
            refreshDrawableState();
            return true;
        }
        return false;
    }

    private void setExpanded(boolean z, boolean z2, boolean z3) {
        this.mPendingAction = (z3 ? 8 : 0) | (z2 ? 4 : 0) | (z ? 1 : 2);
        requestLayout();
    }

    private void updateCollapsible() {
        boolean z;
        int childCount = getChildCount();
        int i = 0;
        while (true) {
            if (i >= childCount) {
                z = false;
                break;
            } else if (((LayoutParams) getChildAt(i).getLayoutParams()).isCollapsible()) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        setCollapsibleState(z);
    }

    public void addOnOffsetChangedListener(OnOffsetChangedListener onOffsetChangedListener) {
        if (this.mListeners == null) {
            this.mListeners = new ArrayList();
        }
        if (onOffsetChangedListener == null || this.mListeners.contains(onOffsetChangedListener)) {
            return;
        }
        this.mListeners.add(onOffsetChangedListener);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void dispatchOffsetUpdates(int i) {
        if (this.mListeners != null) {
            int size = this.mListeners.size();
            for (int i2 = 0; i2 < size; i2++) {
                OnOffsetChangedListener onOffsetChangedListener = this.mListeners.get(i2);
                if (onOffsetChangedListener != null) {
                    onOffsetChangedListener.onOffsetChanged(this, i);
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (Build.VERSION.SDK_INT < 19 || !(layoutParams instanceof LinearLayout.LayoutParams)) ? layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams) : new LayoutParams((LinearLayout.LayoutParams) layoutParams);
    }

    public int getDownNestedPreScrollRange() {
        int i;
        if (this.mDownPreScrollRange != -1) {
            return this.mDownPreScrollRange;
        }
        int childCount = getChildCount() - 1;
        int i2 = 0;
        while (childCount >= 0) {
            View childAt = getChildAt(childCount);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i3 = layoutParams.mScrollFlags;
            if ((i3 & 5) == 5) {
                int i4 = layoutParams.bottomMargin + layoutParams.topMargin + i2;
                i = (i3 & 8) != 0 ? i4 + ViewCompat.getMinimumHeight(childAt) : (i3 & 2) != 0 ? i4 + (measuredHeight - ViewCompat.getMinimumHeight(childAt)) : i4 + (measuredHeight - getTopInset());
            } else if (i2 > 0) {
                break;
            } else {
                i = i2;
            }
            childCount--;
            i2 = i;
        }
        int max = Math.max(0, i2);
        this.mDownPreScrollRange = max;
        return max;
    }

    public int getDownNestedScrollRange() {
        int i;
        if (this.mDownScrollRange != -1) {
            return this.mDownScrollRange;
        }
        int childCount = getChildCount();
        int i2 = 0;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int i4 = layoutParams.mScrollFlags;
            if ((i4 & 1) == 0) {
                break;
            }
            i2 += measuredHeight;
            if ((i4 & 2) != 0) {
                i = i2 - (ViewCompat.getMinimumHeight(childAt) + getTopInset());
                break;
            }
        }
        i = i2;
        int max = Math.max(0, i);
        this.mDownScrollRange = max;
        return max;
    }

    final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int minimumHeight = ViewCompat.getMinimumHeight(this);
        if (minimumHeight != 0) {
            return (minimumHeight * 2) + topInset;
        }
        int childCount = getChildCount();
        int minimumHeight2 = childCount >= 1 ? ViewCompat.getMinimumHeight(getChildAt(childCount - 1)) : 0;
        return minimumHeight2 != 0 ? (minimumHeight2 * 2) + topInset : getHeight() / 3;
    }

    int getPendingAction() {
        return this.mPendingAction;
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    @VisibleForTesting
    public final int getTopInset() {
        if (this.mLastInsets != null) {
            return this.mLastInsets.getSystemWindowInsetTop();
        }
        return 0;
    }

    public final int getTotalScrollRange() {
        int i;
        if (this.mTotalScrollRange != -1) {
            return this.mTotalScrollRange;
        }
        int childCount = getChildCount();
        int i2 = 0;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i4 = layoutParams.mScrollFlags;
            if ((i4 & 1) == 0) {
                break;
            }
            i2 += layoutParams.bottomMargin + measuredHeight + layoutParams.topMargin;
            if ((i4 & 2) != 0) {
                i = i2 - ViewCompat.getMinimumHeight(childAt);
                break;
            }
        }
        i = i2;
        int max = Math.max(0, i - getTopInset());
        this.mTotalScrollRange = max;
        return max;
    }

    int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    public boolean hasChildWithInterpolator() {
        return this.mHaveChildWithInterpolator;
    }

    boolean hasScrollableChildren() {
        return getTotalScrollRange() != 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i) {
        if (this.mTmpStatesArray == null) {
            this.mTmpStatesArray = new int[2];
        }
        int[] iArr = this.mTmpStatesArray;
        int[] onCreateDrawableState = super.onCreateDrawableState(iArr.length + i);
        iArr[0] = this.mCollapsible ? R.attr.ksad_state_collapsible : -R.attr.ksad_state_collapsible;
        iArr[1] = (this.mCollapsible && this.mCollapsed) ? R.attr.ksad_state_collapsed : -R.attr.ksad_state_collapsed;
        return mergeDrawableStates(onCreateDrawableState, iArr);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        invalidateScrollRanges();
        this.mHaveChildWithInterpolator = false;
        int childCount = getChildCount();
        int i5 = 0;
        while (true) {
            if (i5 >= childCount) {
                break;
            } else if (((LayoutParams) getChildAt(i5).getLayoutParams()).getScrollInterpolator() != null) {
                this.mHaveChildWithInterpolator = true;
                break;
            } else {
                i5++;
            }
        }
        updateCollapsible();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        invalidateScrollRanges();
    }

    WindowInsetsCompat onWindowInsetChanged(WindowInsetsCompat windowInsetsCompat) {
        WindowInsetsCompat windowInsetsCompat2 = ViewCompat.getFitsSystemWindows(this) ? windowInsetsCompat : null;
        if (!ObjectsCompat.equals(this.mLastInsets, windowInsetsCompat2)) {
            this.mLastInsets = windowInsetsCompat2;
            invalidateScrollRanges();
        }
        return windowInsetsCompat;
    }

    public void removeOnOffsetChangedListener(OnOffsetChangedListener onOffsetChangedListener) {
        if (this.mListeners == null || onOffsetChangedListener == null) {
            return;
        }
        this.mListeners.remove(onOffsetChangedListener);
    }

    void resetPendingAction() {
        this.mPendingAction = 0;
    }

    boolean setCollapsedState(boolean z) {
        if (this.mCollapsed != z) {
            this.mCollapsed = z;
            refreshDrawableState();
            return true;
        }
        return false;
    }

    public void setExpanded(boolean z) {
        setExpanded(z, ViewCompat.isLaidOut(this));
    }

    public void setExpanded(boolean z, boolean z2) {
        setExpanded(z, z2, true);
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i) {
        if (i != 1) {
            throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
        }
        super.setOrientation(i);
    }

    @Deprecated
    public void setTargetElevation(float f) {
        if (Build.VERSION.SDK_INT >= 21) {
            KSViewUtilsLollipop.setDefaultAppBarLayoutStateListAnimator(this, f);
        }
    }
}
