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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.lib.desigin.KSCoordinatorLayout;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
@Keep
@KSCoordinatorLayout.DefaultBehavior(KSBehavior.class)
/* loaded from: classes7.dex */
public class KSAppBarLayout extends LinearLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int INVALID_SCROLL_RANGE = -1;
    public static final int PENDING_ACTION_ANIMATE_ENABLED = 4;
    public static final int PENDING_ACTION_COLLAPSED = 2;
    public static final int PENDING_ACTION_EXPANDED = 1;
    public static final int PENDING_ACTION_FORCE = 8;
    public static final int PENDING_ACTION_NONE = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mCollapsed;
    public boolean mCollapsible;
    public int mDownPreScrollRange;
    public int mDownScrollRange;
    public boolean mHaveChildWithInterpolator;
    public WindowInsetsCompat mLastInsets;
    public List<OnOffsetChangedListener> mListeners;
    public int mPendingAction;
    public int[] mTmpStatesArray;
    public int mTotalScrollRange;

    /* loaded from: classes7.dex */
    public static class KSBehavior extends KSHeaderBehavior<KSAppBarLayout> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int INVALID_POSITION = -1;
        public static final int MAX_OFFSET_ANIMATION_DURATION = 600;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<View> mLastNestedScrollingChildRef;
        public ValueAnimator mOffsetAnimator;
        public int mOffsetDelta;
        public int mOffsetToChildIndexOnLayout;
        public boolean mOffsetToChildIndexOnLayoutIsMinHeight;
        public float mOffsetToChildIndexOnLayoutPerc;
        public DragCallback mOnDragCallback;

        /* loaded from: classes7.dex */
        public static abstract class DragCallback {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public DragCallback() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            public abstract boolean canDrag(@NonNull KSAppBarLayout kSAppBarLayout);
        }

        /* loaded from: classes7.dex */
        public static class SavedState extends AbsSavedState {
            public static /* synthetic */ Interceptable $ic;
            public static final Parcelable.Creator<SavedState> CREATOR;
            public transient /* synthetic */ FieldHolder $fh;
            public boolean firstVisibleChildAtMinimumHeight;
            public int firstVisibleChildIndex;
            public float firstVisibleChildPercentageShown;

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1695412184, "Lcom/kwad/sdk/lib/desigin/KSAppBarLayout$KSBehavior$SavedState;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(-1695412184, "Lcom/kwad/sdk/lib/desigin/KSAppBarLayout$KSBehavior$SavedState;");
                        return;
                    }
                }
                CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.kwad.sdk.lib.desigin.KSAppBarLayout.KSBehavior.SavedState.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                            }
                        }
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // android.os.Parcelable.Creator
                    public SavedState createFromParcel(Parcel parcel) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) ? new SavedState(parcel, null) : (SavedState) invokeL.objValue;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // android.os.Parcelable.ClassLoaderCreator
                    public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                        InterceptResult invokeLL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, parcel, classLoader)) == null) ? new SavedState(parcel, classLoader) : (SavedState) invokeLL.objValue;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // android.os.Parcelable.Creator
                    public SavedState[] newArray(int i2) {
                        InterceptResult invokeI;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeI = interceptable2.invokeI(1048580, this, i2)) == null) ? new SavedState[i2] : (SavedState[]) invokeI.objValue;
                    }
                };
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SavedState(Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {parcel, classLoader};
                    interceptable.invokeUnInit(65537, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super((Parcel) objArr2[0], (ClassLoader) objArr2[1]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65537, newInitContext);
                        return;
                    }
                }
                this.firstVisibleChildIndex = parcel.readInt();
                this.firstVisibleChildPercentageShown = parcel.readFloat();
                this.firstVisibleChildAtMinimumHeight = parcel.readByte() != 0;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SavedState(Parcelable parcelable) {
                super(parcelable);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {parcelable};
                    interceptable.invokeUnInit(65538, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        super((Parcelable) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65538, newInitContext);
                        return;
                    }
                }
            }

            @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, parcel, i2) == null) {
                    super.writeToParcel(parcel, i2);
                    parcel.writeInt(this.firstVisibleChildIndex);
                    parcel.writeFloat(this.firstVisibleChildPercentageShown);
                    parcel.writeByte(this.firstVisibleChildAtMinimumHeight ? (byte) 1 : (byte) 0);
                }
            }
        }

        public KSBehavior() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mOffsetToChildIndexOnLayout = -1;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public KSBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, attributeSet};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mOffsetToChildIndexOnLayout = -1;
        }

        private void animateOffsetTo(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, int i2, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{kSCoordinatorLayout, kSAppBarLayout, Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
                int abs = Math.abs(getTopBottomOffsetForScrollingSibling() - i2);
                float abs2 = Math.abs(f2);
                animateOffsetWithDuration(kSCoordinatorLayout, kSAppBarLayout, i2, abs2 > 0.0f ? Math.round((abs / abs2) * 1000.0f) * 3 : (int) (((abs / kSAppBarLayout.getHeight()) + 1.0f) * 150.0f));
            }
        }

        private void animateOffsetWithDuration(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLII(65540, this, kSCoordinatorLayout, kSAppBarLayout, i2, i3) == null) {
                int topBottomOffsetForScrollingSibling = getTopBottomOffsetForScrollingSibling();
                if (topBottomOffsetForScrollingSibling == i2) {
                    ValueAnimator valueAnimator = this.mOffsetAnimator;
                    if (valueAnimator == null || !valueAnimator.isRunning()) {
                        return;
                    }
                    this.mOffsetAnimator.cancel();
                    return;
                }
                ValueAnimator valueAnimator2 = this.mOffsetAnimator;
                if (valueAnimator2 == null) {
                    ValueAnimator valueAnimator3 = new ValueAnimator();
                    this.mOffsetAnimator = valueAnimator3;
                    valueAnimator3.setInterpolator(KSAnimationUtils.DECELERATE_INTERPOLATOR);
                    this.mOffsetAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, kSCoordinatorLayout, kSAppBarLayout) { // from class: com.kwad.sdk.lib.desigin.KSAppBarLayout.KSBehavior.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ KSBehavior this$0;
                        public final /* synthetic */ KSAppBarLayout val$child;
                        public final /* synthetic */ KSCoordinatorLayout val$coordinatorLayout;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, kSCoordinatorLayout, kSAppBarLayout};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i4 = newInitContext.flag;
                                if ((i4 & 1) != 0) {
                                    int i5 = i4 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$coordinatorLayout = kSCoordinatorLayout;
                            this.val$child = kSAppBarLayout;
                        }

                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator4) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator4) == null) {
                                this.this$0.setHeaderTopBottomOffset(this.val$coordinatorLayout, this.val$child, ((Integer) valueAnimator4.getAnimatedValue()).intValue());
                            }
                        }
                    });
                } else {
                    valueAnimator2.cancel();
                }
                this.mOffsetAnimator.setDuration(Math.min(i3, 600));
                this.mOffsetAnimator.setIntValues(topBottomOffsetForScrollingSibling, i2);
                this.mOffsetAnimator.start();
            }
        }

        public static boolean checkFlag(int i2, int i3) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeII = interceptable.invokeII(AdIconUtil.AD_TEXT_ID, null, i2, i3)) == null) ? (i2 & i3) == i3 : invokeII.booleanValue;
        }

        public static View getAppBarChildOnOffset(KSAppBarLayout kSAppBarLayout, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(AdIconUtil.BAIDU_LOGO_ID, null, kSAppBarLayout, i2)) == null) {
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
            return (View) invokeLI.objValue;
        }

        private int getChildIndexOnOffset(KSAppBarLayout kSAppBarLayout, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(65543, this, kSAppBarLayout, i2)) == null) {
                int childCount = kSAppBarLayout.getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt = kSAppBarLayout.getChildAt(i3);
                    int i4 = -i2;
                    if (childAt.getTop() <= i4 && childAt.getBottom() >= i4) {
                        return i3;
                    }
                }
                return -1;
            }
            return invokeLI.intValue;
        }

        private int interpolateOffset(KSAppBarLayout kSAppBarLayout, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(65544, this, kSAppBarLayout, i2)) == null) {
                int abs = Math.abs(i2);
                int childCount = kSAppBarLayout.getChildCount();
                int i3 = 0;
                int i4 = 0;
                while (true) {
                    if (i4 >= childCount) {
                        break;
                    }
                    View childAt = kSAppBarLayout.getChildAt(i4);
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
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
            return invokeLI.intValue;
        }

        private boolean shouldJumpElevationState(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, this, kSCoordinatorLayout, kSAppBarLayout)) == null) {
                List<View> dependents = kSCoordinatorLayout.getDependents(kSAppBarLayout);
                int size = dependents.size();
                for (int i2 = 0; i2 < size; i2++) {
                    KSCoordinatorLayout.Behavior behavior = ((KSCoordinatorLayout.LayoutParams) dependents.get(i2).getLayoutParams()).getBehavior();
                    if (behavior instanceof ScrollingViewBehavior) {
                        return ((ScrollingViewBehavior) behavior).getOverlayTop() != 0;
                    }
                }
                return false;
            }
            return invokeLL.booleanValue;
        }

        private void snapToChildIfNeeded(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout) {
            int topBottomOffsetForScrollingSibling;
            int childIndexOnOffset;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(65546, this, kSCoordinatorLayout, kSAppBarLayout) == null) || (childIndexOnOffset = getChildIndexOnOffset(kSAppBarLayout, (topBottomOffsetForScrollingSibling = getTopBottomOffsetForScrollingSibling()))) < 0) {
                return;
            }
            View childAt = kSAppBarLayout.getChildAt(childIndexOnOffset);
            int scrollFlags = ((LayoutParams) childAt.getLayoutParams()).getScrollFlags();
            if ((scrollFlags & 17) == 17) {
                int i2 = -childAt.getTop();
                int i3 = -childAt.getBottom();
                if (childIndexOnOffset == kSAppBarLayout.getChildCount() - 1) {
                    i3 += kSAppBarLayout.getTopInset();
                }
                if (checkFlag(scrollFlags, 2)) {
                    i3 += ViewCompat.getMinimumHeight(childAt);
                } else if (checkFlag(scrollFlags, 5)) {
                    int minimumHeight = ViewCompat.getMinimumHeight(childAt) + i3;
                    if (topBottomOffsetForScrollingSibling < minimumHeight) {
                        i2 = minimumHeight;
                    } else {
                        i3 = minimumHeight;
                    }
                }
                if (topBottomOffsetForScrollingSibling < (i3 + i2) / 2) {
                    i2 = i3;
                }
                animateOffsetTo(kSCoordinatorLayout, kSAppBarLayout, MathUtils.clamp(i2, -kSAppBarLayout.getTotalScrollRange(), 0), 0.0f);
            }
        }

        private void updateAppBarLayoutDrawableState(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, int i2, int i3, boolean z) {
            View appBarChildOnOffset;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(65547, this, new Object[]{kSCoordinatorLayout, kSAppBarLayout, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) || (appBarChildOnOffset = getAppBarChildOnOffset(kSAppBarLayout, i2)) == null) {
                return;
            }
            int scrollFlags = ((LayoutParams) appBarChildOnOffset.getLayoutParams()).getScrollFlags();
            boolean z2 = false;
            if ((scrollFlags & 1) != 0) {
                int minimumHeight = ViewCompat.getMinimumHeight(appBarChildOnOffset);
                if (i3 <= 0 || (scrollFlags & 12) == 0 ? !((scrollFlags & 2) == 0 || (-i2) < (appBarChildOnOffset.getBottom() - minimumHeight) - kSAppBarLayout.getTopInset()) : (-i2) >= (appBarChildOnOffset.getBottom() - minimumHeight) - kSAppBarLayout.getTopInset()) {
                    z2 = true;
                }
            }
            boolean collapsedState = kSAppBarLayout.setCollapsedState(z2);
            if (Build.VERSION.SDK_INT >= 11) {
                if (z || (collapsedState && shouldJumpElevationState(kSCoordinatorLayout, kSAppBarLayout))) {
                    kSAppBarLayout.jumpDrawablesToCurrentState();
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwad.sdk.lib.desigin.KSHeaderBehavior
        public boolean canDragView(KSAppBarLayout kSAppBarLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kSAppBarLayout)) == null) {
                DragCallback dragCallback = this.mOnDragCallback;
                if (dragCallback != null) {
                    return dragCallback.canDrag(kSAppBarLayout);
                }
                WeakReference<View> weakReference = this.mLastNestedScrollingChildRef;
                if (weakReference != null) {
                    View view = weakReference.get();
                    return (view == null || !view.isShown() || view.canScrollVertically(-1)) ? false : true;
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwad.sdk.lib.desigin.KSHeaderBehavior
        public int getMaxDragOffset(KSAppBarLayout kSAppBarLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, kSAppBarLayout)) == null) ? -kSAppBarLayout.getDownNestedScrollRange() : invokeL.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwad.sdk.lib.desigin.KSHeaderBehavior
        public int getScrollRangeForDragFling(KSAppBarLayout kSAppBarLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, kSAppBarLayout)) == null) ? kSAppBarLayout.getTotalScrollRange() : invokeL.intValue;
        }

        @Override // com.kwad.sdk.lib.desigin.KSHeaderBehavior
        public int getTopBottomOffsetForScrollingSibling() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? getTopAndBottomOffset() + this.mOffsetDelta : invokeV.intValue;
        }

        @VisibleForTesting
        public boolean isOffsetAnimatorRunning() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                ValueAnimator valueAnimator = this.mOffsetAnimator;
                return valueAnimator != null && valueAnimator.isRunning();
            }
            return invokeV.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.kwad.sdk.lib.desigin.KSHeaderBehavior
        public void onFlingFinished(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048585, this, kSCoordinatorLayout, kSAppBarLayout) == null) {
                snapToChildIfNeeded(kSCoordinatorLayout, kSAppBarLayout);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwad.sdk.lib.desigin.KSViewOffsetBehavior, com.kwad.sdk.lib.desigin.KSCoordinatorLayout.Behavior
        public boolean onLayoutChild(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, int i2) {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048587, this, kSCoordinatorLayout, kSAppBarLayout, i2)) == null) {
                boolean onLayoutChild = super.onLayoutChild(kSCoordinatorLayout, (KSCoordinatorLayout) kSAppBarLayout, i2);
                int pendingAction = kSAppBarLayout.getPendingAction();
                int i3 = this.mOffsetToChildIndexOnLayout;
                if (i3 >= 0 && (pendingAction & 8) == 0) {
                    View childAt = kSAppBarLayout.getChildAt(i3);
                    setHeaderTopBottomOffset(kSCoordinatorLayout, kSAppBarLayout, (-childAt.getBottom()) + (this.mOffsetToChildIndexOnLayoutIsMinHeight ? ViewCompat.getMinimumHeight(childAt) + kSAppBarLayout.getTopInset() : Math.round(childAt.getHeight() * this.mOffsetToChildIndexOnLayoutPerc)));
                } else if (pendingAction != 0) {
                    boolean z = (pendingAction & 4) != 0;
                    if ((pendingAction & 2) != 0) {
                        int i4 = -kSAppBarLayout.getUpNestedPreScrollRange();
                        if (z) {
                            animateOffsetTo(kSCoordinatorLayout, kSAppBarLayout, i4, 0.0f);
                        } else {
                            setHeaderTopBottomOffset(kSCoordinatorLayout, kSAppBarLayout, i4);
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
            return invokeLLI.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwad.sdk.lib.desigin.KSCoordinatorLayout.Behavior
        public boolean onMeasureChild(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, int i2, int i3, int i4, int i5) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{kSCoordinatorLayout, kSAppBarLayout, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
                if (((ViewGroup.MarginLayoutParams) ((KSCoordinatorLayout.LayoutParams) kSAppBarLayout.getLayoutParams())).height == -2) {
                    kSCoordinatorLayout.onMeasureChild(kSAppBarLayout, i2, i3, View.MeasureSpec.makeMeasureSpec(0, 0), i5);
                    return true;
                }
                return super.onMeasureChild(kSCoordinatorLayout, (KSCoordinatorLayout) kSAppBarLayout, i2, i3, i4, i5);
            }
            return invokeCommon.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwad.sdk.lib.desigin.KSCoordinatorLayout.Behavior
        public void onNestedPreScroll(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, View view, int i2, int i3, int[] iArr, int i4) {
            int i5;
            int i6;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{kSCoordinatorLayout, kSAppBarLayout, view, Integer.valueOf(i2), Integer.valueOf(i3), iArr, Integer.valueOf(i4)}) == null) || i3 == 0) {
                return;
            }
            if (i3 < 0) {
                int i7 = -kSAppBarLayout.getTotalScrollRange();
                i5 = i7;
                i6 = kSAppBarLayout.getDownNestedPreScrollRange() + i7;
            } else {
                i5 = -kSAppBarLayout.getUpNestedPreScrollRange();
                i6 = 0;
            }
            if (i5 != i6) {
                iArr[1] = scroll(kSCoordinatorLayout, kSAppBarLayout, i3, i5, i6);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwad.sdk.lib.desigin.KSCoordinatorLayout.Behavior
        public void onNestedScroll(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, View view, int i2, int i3, int i4, int i5, int i6) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{kSCoordinatorLayout, kSAppBarLayout, view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) || i5 >= 0) {
                return;
            }
            scroll(kSCoordinatorLayout, kSAppBarLayout, i5, -kSAppBarLayout.getDownNestedScrollRange(), 0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwad.sdk.lib.desigin.KSCoordinatorLayout.Behavior
        public void onRestoreInstanceState(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, Parcelable parcelable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048595, this, kSCoordinatorLayout, kSAppBarLayout, parcelable) == null) {
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
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwad.sdk.lib.desigin.KSCoordinatorLayout.Behavior
        public Parcelable onSaveInstanceState(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048597, this, kSCoordinatorLayout, kSAppBarLayout)) == null) {
                Parcelable onSaveInstanceState = super.onSaveInstanceState(kSCoordinatorLayout, (KSCoordinatorLayout) kSAppBarLayout);
                int topAndBottomOffset = getTopAndBottomOffset();
                int childCount = kSAppBarLayout.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = kSAppBarLayout.getChildAt(i2);
                    int bottom = childAt.getBottom() + topAndBottomOffset;
                    if (childAt.getTop() + topAndBottomOffset <= 0 && bottom >= 0) {
                        SavedState savedState = new SavedState(onSaveInstanceState);
                        savedState.firstVisibleChildIndex = i2;
                        savedState.firstVisibleChildAtMinimumHeight = bottom == ViewCompat.getMinimumHeight(childAt) + kSAppBarLayout.getTopInset();
                        savedState.firstVisibleChildPercentageShown = bottom / childAt.getHeight();
                        return savedState;
                    }
                }
                return onSaveInstanceState;
            }
            return (Parcelable) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwad.sdk.lib.desigin.KSCoordinatorLayout.Behavior
        public boolean onStartNestedScroll(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, View view, View view2, int i2, int i3) {
            InterceptResult invokeCommon;
            ValueAnimator valueAnimator;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048599, this, new Object[]{kSCoordinatorLayout, kSAppBarLayout, view, view2, Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
                boolean z = (i2 & 2) != 0 && kSAppBarLayout.hasScrollableChildren() && kSCoordinatorLayout.getHeight() - view.getHeight() <= kSAppBarLayout.getHeight();
                if (z && (valueAnimator = this.mOffsetAnimator) != null) {
                    valueAnimator.cancel();
                }
                this.mLastNestedScrollingChildRef = null;
                return z;
            }
            return invokeCommon.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwad.sdk.lib.desigin.KSCoordinatorLayout.Behavior
        public void onStopNestedScroll(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, View view, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLI(1048601, this, kSCoordinatorLayout, kSAppBarLayout, view, i2) == null) {
                if (i2 == 0) {
                    snapToChildIfNeeded(kSCoordinatorLayout, kSAppBarLayout);
                }
                this.mLastNestedScrollingChildRef = new WeakReference<>(view);
            }
        }

        public void setDragCallback(@Nullable DragCallback dragCallback) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048602, this, dragCallback) == null) {
                this.mOnDragCallback = dragCallback;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.kwad.sdk.lib.desigin.KSHeaderBehavior
        public int setHeaderTopBottomOffset(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, int i2, int i3, int i4) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048604, this, new Object[]{kSCoordinatorLayout, kSAppBarLayout, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
                int topBottomOffsetForScrollingSibling = getTopBottomOffsetForScrollingSibling();
                int i5 = 0;
                if (i3 == 0 || topBottomOffsetForScrollingSibling < i3 || topBottomOffsetForScrollingSibling > i4) {
                    this.mOffsetDelta = 0;
                } else {
                    int clamp = MathUtils.clamp(i2, i3, i4);
                    if (topBottomOffsetForScrollingSibling != clamp) {
                        int interpolateOffset = kSAppBarLayout.hasChildWithInterpolator() ? interpolateOffset(kSAppBarLayout, clamp) : clamp;
                        boolean topAndBottomOffset = setTopAndBottomOffset(interpolateOffset);
                        i5 = topBottomOffsetForScrollingSibling - clamp;
                        this.mOffsetDelta = clamp - interpolateOffset;
                        if (!topAndBottomOffset && kSAppBarLayout.hasChildWithInterpolator()) {
                            kSCoordinatorLayout.dispatchDependentViewsChanged(kSAppBarLayout);
                        }
                        kSAppBarLayout.dispatchOffsetUpdates(getTopAndBottomOffset());
                        updateAppBarLayoutDrawableState(kSCoordinatorLayout, kSAppBarLayout, clamp, clamp < topBottomOffsetForScrollingSibling ? -1 : 1, false);
                    }
                }
                return i5;
            }
            return invokeCommon.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class LayoutParams extends LinearLayout.LayoutParams {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int COLLAPSIBLE_FLAGS = 10;
        public static final int FLAG_QUICK_RETURN = 5;
        public static final int FLAG_SNAP = 17;
        public static final int SCROLL_FLAG_ENTER_ALWAYS = 4;
        public static final int SCROLL_FLAG_ENTER_ALWAYS_COLLAPSED = 8;
        public static final int SCROLL_FLAG_EXIT_UNTIL_COLLAPSED = 2;
        public static final int SCROLL_FLAG_SCROLL = 1;
        public static final int SCROLL_FLAG_SNAP = 16;
        public transient /* synthetic */ FieldHolder $fh;
        public int mScrollFlags;
        public Interpolator mScrollInterpolator;

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        /* loaded from: classes7.dex */
        public @interface ScrollFlags {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mScrollFlags = 1;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(int i2, int i3, float f2) {
            super(i2, i3, f2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue(), ((Float) objArr2[2]).floatValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mScrollFlags = 1;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, attributeSet};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.mScrollFlags = 1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_AppBarLayout_Layout);
            this.mScrollFlags = obtainStyledAttributes.getInt(R.styleable.ksad_AppBarLayout_Layout_ksad_layout_scrollFlags, 0);
            if (obtainStyledAttributes.hasValue(R.styleable.ksad_AppBarLayout_Layout_ksad_layout_scrollInterpolator)) {
                this.mScrollInterpolator = AnimationUtils.loadInterpolator(context, obtainStyledAttributes.getResourceId(R.styleable.ksad_AppBarLayout_Layout_ksad_layout_scrollInterpolator, 0));
            }
            obtainStyledAttributes.recycle();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {layoutParams};
                interceptable.invokeUnInit(65539, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((ViewGroup.LayoutParams) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
            this.mScrollFlags = 1;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {marginLayoutParams};
                interceptable.invokeUnInit(65540, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((ViewGroup.MarginLayoutParams) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65540, newInitContext);
                    return;
                }
            }
            this.mScrollFlags = 1;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        @RequiresApi(19)
        public LayoutParams(LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {layoutParams};
                interceptable.invokeUnInit(AdIconUtil.AD_TEXT_ID, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((LinearLayout.LayoutParams) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(AdIconUtil.AD_TEXT_ID, newInitContext);
                    return;
                }
            }
            this.mScrollFlags = 1;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        @RequiresApi(19)
        public LayoutParams(LayoutParams layoutParams) {
            super((LinearLayout.LayoutParams) layoutParams);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {layoutParams};
                interceptable.invokeUnInit(AdIconUtil.BAIDU_LOGO_ID, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((LinearLayout.LayoutParams) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(AdIconUtil.BAIDU_LOGO_ID, newInitContext);
                    return;
                }
            }
            this.mScrollFlags = 1;
            this.mScrollFlags = layoutParams.mScrollFlags;
            this.mScrollInterpolator = layoutParams.mScrollInterpolator;
        }

        public int getScrollFlags() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mScrollFlags : invokeV.intValue;
        }

        public Interpolator getScrollInterpolator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mScrollInterpolator : (Interpolator) invokeV.objValue;
        }

        public boolean isCollapsible() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                int i2 = this.mScrollFlags;
                return (i2 & 1) == 1 && (i2 & 10) != 0;
            }
            return invokeV.booleanValue;
        }

        public void setScrollFlags(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
                this.mScrollFlags = i2;
            }
        }

        public void setScrollInterpolator(Interpolator interpolator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, interpolator) == null) {
                this.mScrollInterpolator = interpolator;
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface OnOffsetChangedListener {
        void onOffsetChanged(KSAppBarLayout kSAppBarLayout, int i2);
    }

    /* loaded from: classes7.dex */
    public static class ScrollingViewBehavior extends KSHeaderScrollingViewBehavior {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public ScrollingViewBehavior() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, attributeSet};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_ScrollingViewBehavior_Layout);
            setOverlayTop(obtainStyledAttributes.getDimensionPixelSize(R.styleable.ksad_ScrollingViewBehavior_Layout_ksad_behavior_overlapTop, 0));
            obtainStyledAttributes.recycle();
        }

        public static int getAppBarLayoutOffset(KSAppBarLayout kSAppBarLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, kSAppBarLayout)) == null) {
                KSCoordinatorLayout.Behavior behavior = ((KSCoordinatorLayout.LayoutParams) kSAppBarLayout.getLayoutParams()).getBehavior();
                if (behavior instanceof KSBehavior) {
                    return ((KSBehavior) behavior).getTopBottomOffsetForScrollingSibling();
                }
                return 0;
            }
            return invokeL.intValue;
        }

        private void offsetChildAsNeeded(KSCoordinatorLayout kSCoordinatorLayout, View view, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(65539, this, kSCoordinatorLayout, view, view2) == null) {
                KSCoordinatorLayout.Behavior behavior = ((KSCoordinatorLayout.LayoutParams) view2.getLayoutParams()).getBehavior();
                if (behavior instanceof KSBehavior) {
                    ViewCompat.offsetTopAndBottom(view, (((view2.getBottom() - view.getTop()) + ((KSBehavior) behavior).mOffsetDelta) + getVerticalLayoutGap()) - getOverlapPixelsForOffset(view2));
                }
            }
        }

        @Override // com.kwad.sdk.lib.desigin.KSHeaderScrollingViewBehavior
        public /* bridge */ /* synthetic */ View findFirstDependency(List list) {
            return findFirstDependency((List<View>) list);
        }

        @Override // com.kwad.sdk.lib.desigin.KSHeaderScrollingViewBehavior
        public KSAppBarLayout findFirstDependency(List<View> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    View view = list.get(i2);
                    if (view instanceof KSAppBarLayout) {
                        return (KSAppBarLayout) view;
                    }
                }
                return null;
            }
            return (KSAppBarLayout) invokeL.objValue;
        }

        @Override // com.kwad.sdk.lib.desigin.KSHeaderScrollingViewBehavior
        public float getOverlapRatioForOffset(View view) {
            InterceptResult invokeL;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view)) == null) {
                if (view instanceof KSAppBarLayout) {
                    KSAppBarLayout kSAppBarLayout = (KSAppBarLayout) view;
                    int totalScrollRange = kSAppBarLayout.getTotalScrollRange();
                    int downNestedPreScrollRange = kSAppBarLayout.getDownNestedPreScrollRange();
                    int appBarLayoutOffset = getAppBarLayoutOffset(kSAppBarLayout);
                    if ((downNestedPreScrollRange == 0 || totalScrollRange + appBarLayoutOffset > downNestedPreScrollRange) && (i2 = totalScrollRange - downNestedPreScrollRange) != 0) {
                        return (appBarLayoutOffset / i2) + 1.0f;
                    }
                }
                return 0.0f;
            }
            return invokeL.floatValue;
        }

        @Override // com.kwad.sdk.lib.desigin.KSHeaderScrollingViewBehavior
        public int getScrollRange(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, view)) == null) ? view instanceof KSAppBarLayout ? ((KSAppBarLayout) view).getTotalScrollRange() : super.getScrollRange(view) : invokeL.intValue;
        }

        @Override // com.kwad.sdk.lib.desigin.KSCoordinatorLayout.Behavior
        public boolean layoutDependsOn(KSCoordinatorLayout kSCoordinatorLayout, View view, View view2) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, kSCoordinatorLayout, view, view2)) == null) ? view2 instanceof KSAppBarLayout : invokeLLL.booleanValue;
        }

        @Override // com.kwad.sdk.lib.desigin.KSCoordinatorLayout.Behavior
        public boolean onDependentViewChanged(KSCoordinatorLayout kSCoordinatorLayout, View view, View view2) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, kSCoordinatorLayout, view, view2)) == null) {
                offsetChildAsNeeded(kSCoordinatorLayout, view, view2);
                return false;
            }
            return invokeLLL.booleanValue;
        }

        @Override // com.kwad.sdk.lib.desigin.KSHeaderScrollingViewBehavior, com.kwad.sdk.lib.desigin.KSCoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onMeasureChild(KSCoordinatorLayout kSCoordinatorLayout, View view, int i2, int i3, int i4, int i5) {
            return super.onMeasureChild(kSCoordinatorLayout, view, i2, i3, i4, i5);
        }

        @Override // com.kwad.sdk.lib.desigin.KSCoordinatorLayout.Behavior
        public boolean onRequestChildRectangleOnScreen(KSCoordinatorLayout kSCoordinatorLayout, View view, Rect rect, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{kSCoordinatorLayout, view, rect, Boolean.valueOf(z)})) == null) {
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
            return invokeCommon.booleanValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public KSAppBarLayout(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KSAppBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
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
        ViewCompat.setOnApplyWindowInsetsListener(this, new OnApplyWindowInsetsListener(this) { // from class: com.kwad.sdk.lib.desigin.KSAppBarLayout.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ KSAppBarLayout this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view, windowInsetsCompat)) == null) ? this.this$0.onWindowInsetChanged(windowInsetsCompat) : (WindowInsetsCompat) invokeLL.objValue;
            }
        });
    }

    private void invalidateScrollRanges() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.mTotalScrollRange = -1;
            this.mDownPreScrollRange = -1;
            this.mDownScrollRange = -1;
        }
    }

    private boolean setCollapsibleState(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65539, this, z)) == null) {
            if (this.mCollapsible != z) {
                this.mCollapsible = z;
                refreshDrawableState();
                return true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    private void setExpanded(boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65540, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            this.mPendingAction = (z ? 1 : 2) | (z2 ? 4 : 0) | (z3 ? 8 : 0);
            requestLayout();
        }
    }

    private void updateCollapsible() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            int childCount = getChildCount();
            boolean z = false;
            int i2 = 0;
            while (true) {
                if (i2 >= childCount) {
                    break;
                } else if (((LayoutParams) getChildAt(i2).getLayoutParams()).isCollapsible()) {
                    z = true;
                    break;
                } else {
                    i2++;
                }
            }
            setCollapsibleState(z);
        }
    }

    public void addOnOffsetChangedListener(OnOffsetChangedListener onOffsetChangedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onOffsetChangedListener) == null) {
            if (this.mListeners == null) {
                this.mListeners = new ArrayList();
            }
            if (onOffsetChangedListener == null || this.mListeners.contains(onOffsetChangedListener)) {
                return;
            }
            this.mListeners.add(onOffsetChangedListener);
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, layoutParams)) == null) ? layoutParams instanceof LayoutParams : invokeL.booleanValue;
    }

    public void dispatchOffsetUpdates(int i2) {
        List<OnOffsetChangedListener> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || (list = this.mListeners) == null) {
            return;
        }
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            OnOffsetChangedListener onOffsetChangedListener = this.mListeners.get(i3);
            if (onOffsetChangedListener != null) {
                onOffsetChangedListener.onOffsetChanged(this, i2);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? new LayoutParams(-1, -2) : (LayoutParams) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, attributeSet)) == null) ? new LayoutParams(getContext(), attributeSet) : (LayoutParams) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, layoutParams)) == null) ? (Build.VERSION.SDK_INT < 19 || !(layoutParams instanceof LinearLayout.LayoutParams)) ? layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams) : new LayoutParams((LinearLayout.LayoutParams) layoutParams) : (LayoutParams) invokeL.objValue;
    }

    public int getDownNestedPreScrollRange() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            int i2 = this.mDownPreScrollRange;
            if (i2 != -1) {
                return i2;
            }
            int i3 = 0;
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = getChildAt(childCount);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight();
                int i4 = layoutParams.mScrollFlags;
                if ((i4 & 5) == 5) {
                    int i5 = i3 + ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                    i3 = (i4 & 8) != 0 ? i5 + ViewCompat.getMinimumHeight(childAt) : i5 + (measuredHeight - ((i4 & 2) != 0 ? ViewCompat.getMinimumHeight(childAt) : getTopInset()));
                } else if (i3 > 0) {
                    break;
                }
            }
            int max = Math.max(0, i3);
            this.mDownPreScrollRange = max;
            return max;
        }
        return invokeV.intValue;
    }

    public int getDownNestedScrollRange() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            int i2 = this.mDownScrollRange;
            if (i2 != -1) {
                return i2;
            }
            int childCount = getChildCount();
            int i3 = 0;
            int i4 = 0;
            while (true) {
                if (i3 >= childCount) {
                    break;
                }
                View childAt = getChildAt(i3);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight() + ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                int i5 = layoutParams.mScrollFlags;
                if ((i5 & 1) == 0) {
                    break;
                }
                i4 += measuredHeight;
                if ((i5 & 2) != 0) {
                    i4 -= ViewCompat.getMinimumHeight(childAt) + getTopInset();
                    break;
                }
                i3++;
            }
            int max = Math.max(0, i4);
            this.mDownScrollRange = max;
            return max;
        }
        return invokeV.intValue;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            int topInset = getTopInset();
            int minimumHeight = ViewCompat.getMinimumHeight(this);
            if (minimumHeight == 0) {
                int childCount = getChildCount();
                minimumHeight = childCount >= 1 ? ViewCompat.getMinimumHeight(getChildAt(childCount - 1)) : 0;
                if (minimumHeight == 0) {
                    return getHeight() / 3;
                }
            }
            return (minimumHeight * 2) + topInset;
        }
        return invokeV.intValue;
    }

    public int getPendingAction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.mPendingAction : invokeV.intValue;
    }

    @Deprecated
    public float getTargetElevation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return 0.0f;
        }
        return invokeV.floatValue;
    }

    @VisibleForTesting
    public final int getTopInset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            WindowInsetsCompat windowInsetsCompat = this.mLastInsets;
            if (windowInsetsCompat != null) {
                return windowInsetsCompat.getSystemWindowInsetTop();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public final int getTotalScrollRange() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            int i2 = this.mTotalScrollRange;
            if (i2 != -1) {
                return i2;
            }
            int childCount = getChildCount();
            int i3 = 0;
            int i4 = 0;
            while (true) {
                if (i3 >= childCount) {
                    break;
                }
                View childAt = getChildAt(i3);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight();
                int i5 = layoutParams.mScrollFlags;
                if ((i5 & 1) == 0) {
                    break;
                }
                i4 += measuredHeight + ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                if ((i5 & 2) != 0) {
                    i4 -= ViewCompat.getMinimumHeight(childAt);
                    break;
                }
                i3++;
            }
            int max = Math.max(0, i4 - getTopInset());
            this.mTotalScrollRange = max;
            return max;
        }
        return invokeV.intValue;
    }

    public int getUpNestedPreScrollRange() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? getTotalScrollRange() : invokeV.intValue;
    }

    public boolean hasChildWithInterpolator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.mHaveChildWithInterpolator : invokeV.booleanValue;
    }

    public boolean hasScrollableChildren() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? getTotalScrollRange() != 0 : invokeV.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i2)) == null) {
            if (this.mTmpStatesArray == null) {
                this.mTmpStatesArray = new int[2];
            }
            int[] iArr = this.mTmpStatesArray;
            int[] onCreateDrawableState = super.onCreateDrawableState(i2 + iArr.length);
            iArr[0] = this.mCollapsible ? R.attr.ksad_state_collapsible : -R.attr.ksad_state_collapsible;
            iArr[1] = (this.mCollapsible && this.mCollapsed) ? R.attr.ksad_state_collapsed : -R.attr.ksad_state_collapsed;
            return LinearLayout.mergeDrawableStates(onCreateDrawableState, iArr);
        }
        return (int[]) invokeI.objValue;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            super.onLayout(z, i2, i3, i4, i5);
            invalidateScrollRanges();
            int i6 = 0;
            this.mHaveChildWithInterpolator = false;
            int childCount = getChildCount();
            while (true) {
                if (i6 >= childCount) {
                    break;
                } else if (((LayoutParams) getChildAt(i6).getLayoutParams()).getScrollInterpolator() != null) {
                    this.mHaveChildWithInterpolator = true;
                    break;
                } else {
                    i6++;
                }
            }
            updateCollapsible();
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048600, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            invalidateScrollRanges();
        }
    }

    public WindowInsetsCompat onWindowInsetChanged(WindowInsetsCompat windowInsetsCompat) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, windowInsetsCompat)) == null) {
            WindowInsetsCompat windowInsetsCompat2 = ViewCompat.getFitsSystemWindows(this) ? windowInsetsCompat : null;
            if (!ObjectsCompat.equals(this.mLastInsets, windowInsetsCompat2)) {
                this.mLastInsets = windowInsetsCompat2;
                invalidateScrollRanges();
            }
            return windowInsetsCompat;
        }
        return (WindowInsetsCompat) invokeL.objValue;
    }

    public void removeOnOffsetChangedListener(OnOffsetChangedListener onOffsetChangedListener) {
        List<OnOffsetChangedListener> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048602, this, onOffsetChangedListener) == null) || (list = this.mListeners) == null || onOffsetChangedListener == null) {
            return;
        }
        list.remove(onOffsetChangedListener);
    }

    public void resetPendingAction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.mPendingAction = 0;
        }
    }

    public boolean setCollapsedState(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048604, this, z)) == null) {
            if (this.mCollapsed != z) {
                this.mCollapsed = z;
                refreshDrawableState();
                return true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public void setExpanded(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            setExpanded(z, ViewCompat.isLaidOut(this));
        }
    }

    public void setExpanded(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            setExpanded(z, z2, true);
        }
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i2) == null) {
            if (i2 != 1) {
                throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
            }
            super.setOrientation(i2);
        }
    }

    @Deprecated
    public void setTargetElevation(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048608, this, f2) == null) || Build.VERSION.SDK_INT < 21) {
            return;
        }
        KSViewUtilsLollipop.setDefaultAppBarLayoutStateListAnimator(this, f2);
    }
}
