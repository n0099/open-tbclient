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
import com.kwad.sdk.lib.desigin.KSAppBarLayout;
import com.kwad.sdk.lib.desigin.KSCoordinatorLayout;
import java.util.Arrays;
import java.util.List;
@Keep
/* loaded from: classes7.dex */
public class CustomAppBarLayoutBehavior extends KSAppBarLayout.KSBehavior implements CustomAppBarCustomAttrListener, CustomAppBarFlingConsumer {
    public static /* synthetic */ Interceptable $ic;
    public static final String TAG;
    public transient /* synthetic */ FieldHolder $fh;
    public CustomAppBarFlingConsumer mCustomAppBarFlingConsumer;
    public int mExtraFixedSize;
    public final int mFlingConsumeViewId;
    public CustomHeaderBehaviorEx<KSAppBarLayout, CustomAppBarLayoutBehavior> mHeaderExBehavior;
    public int mOffsetDelta;
    public int mScrollableSize;
    public boolean mScrollableSizeChangeable;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(238933373, "Lcom/kwad/sdk/lib/desigin/CustomAppBarLayoutBehavior;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(238933373, "Lcom/kwad/sdk/lib/desigin/CustomAppBarLayoutBehavior;");
                return;
            }
        }
        TAG = CustomAppBarLayoutBehavior.class.toString();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomAppBarLayoutBehavior(Context context, AttributeSet attributeSet) {
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
        this.mScrollableSizeChangeable = true;
        int i4 = R.attr.ksad_headerFlingNested;
        int i5 = R.attr.ksad_extraFixedSize;
        int i6 = R.attr.ksad_flingConsumeViewId;
        int[] iArr = {i4, i5, i6};
        Arrays.sort(iArr);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        boolean z = obtainStyledAttributes.getBoolean(Arrays.binarySearch(iArr, i4), false);
        this.mExtraFixedSize = obtainStyledAttributes.getDimensionPixelSize(Arrays.binarySearch(iArr, i5), 0);
        int resourceId = obtainStyledAttributes.getResourceId(Arrays.binarySearch(iArr, i6), 0);
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
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {customAppBarBehaviorParams};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
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
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{kSCoordinatorLayout, kSAppBarLayout, view, Integer.valueOf(i2), Integer.valueOf(i3), iArr, Integer.valueOf(i4)}) == null) && i4 == 1 && iArr[1] == 0 && i3 < 0 && kSAppBarLayout.getTop() == 0) {
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            view.onTouchEvent(obtain);
            obtain.recycle();
        }
    }

    public static View getAppBarChildOnOffset(KSAppBarLayout kSAppBarLayout, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65540, null, kSAppBarLayout, i2)) == null) {
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

    private boolean shouldJumpElevationState(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, this, kSCoordinatorLayout, kSAppBarLayout)) == null) {
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
        return invokeLL.booleanValue;
    }

    @Override // com.kwad.sdk.lib.desigin.CustomAppBarFlingConsumer
    public void consumeAppBarFling(int i2, int i3) {
        CustomAppBarFlingConsumer customAppBarFlingConsumer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) || (customAppBarFlingConsumer = this.mCustomAppBarFlingConsumer) == null) {
            return;
        }
        customAppBarFlingConsumer.consumeAppBarFling(i2, i3);
    }

    @Override // com.kwad.sdk.lib.desigin.CustomAppBarCustomAttrListener
    public int getExtraFixedSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mExtraFixedSize : invokeV.intValue;
    }

    public int getScrollRange(KSAppBarLayout kSAppBarLayout) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, kSAppBarLayout)) == null) ? kSAppBarLayout.getTotalScrollRange() - this.mExtraFixedSize : invokeL.intValue;
    }

    public int getScrollableSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mScrollableSize : invokeV.intValue;
    }

    @Override // com.kwad.sdk.lib.desigin.KSAppBarLayout.KSBehavior, com.kwad.sdk.lib.desigin.KSHeaderBehavior
    public int getTopBottomOffsetForScrollingSibling() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? getTopAndBottomOffset() + this.mOffsetDelta : invokeV.intValue;
    }

    public int interpolateOffset(KSAppBarLayout kSAppBarLayout, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, kSAppBarLayout, i2)) == null) {
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
        return invokeLI.intValue;
    }

    @Override // com.kwad.sdk.lib.desigin.KSAppBarLayout.KSBehavior
    public boolean isOffsetAnimatorRunning() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.lib.desigin.CustomAppBarFlingConsumer
    public void onAppBarTouchDown() {
        CustomAppBarFlingConsumer customAppBarFlingConsumer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (customAppBarFlingConsumer = this.mCustomAppBarFlingConsumer) == null) {
            return;
        }
        customAppBarFlingConsumer.onAppBarTouchDown();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.lib.desigin.KSHeaderBehavior, com.kwad.sdk.lib.desigin.KSCoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, MotionEvent motionEvent) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048585, this, kSCoordinatorLayout, kSAppBarLayout, motionEvent)) == null) {
            CustomHeaderBehaviorEx<KSAppBarLayout, CustomAppBarLayoutBehavior> customHeaderBehaviorEx = this.mHeaderExBehavior;
            return customHeaderBehaviorEx == null ? super.onInterceptTouchEvent(kSCoordinatorLayout, (KSCoordinatorLayout) kSAppBarLayout, motionEvent) : customHeaderBehaviorEx.onInterceptTouchEvent(kSCoordinatorLayout, (KSCoordinatorLayout) kSAppBarLayout, motionEvent);
        }
        return invokeLLL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.lib.desigin.KSAppBarLayout.KSBehavior, com.kwad.sdk.lib.desigin.KSCoordinatorLayout.Behavior
    public boolean onMeasureChild(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, int i2, int i3, int i4, int i5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{kSCoordinatorLayout, kSAppBarLayout, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
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
        return invokeCommon.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.lib.desigin.KSAppBarLayout.KSBehavior, com.kwad.sdk.lib.desigin.KSCoordinatorLayout.Behavior
    public void onNestedPreScroll(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, View view, int i2, int i3, int[] iArr, int i4) {
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{kSCoordinatorLayout, kSAppBarLayout, view, Integer.valueOf(i2), Integer.valueOf(i3), iArr, Integer.valueOf(i4)}) == null) {
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
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.lib.desigin.KSAppBarLayout.KSBehavior, com.kwad.sdk.lib.desigin.KSCoordinatorLayout.Behavior
    public void onNestedScroll(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, View view, int i2, int i3, int i4, int i5, int i6) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{kSCoordinatorLayout, kSAppBarLayout, view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) || i5 >= 0) {
            return;
        }
        if (i6 == 1) {
            super.setHeaderTopBottomOffset(kSCoordinatorLayout, kSAppBarLayout, getTopBottomOffsetForScrollingSibling() - i5, -kSAppBarLayout.getDownNestedScrollRange(), 0);
        } else {
            setHeaderTopBottomOffset(kSCoordinatorLayout, kSAppBarLayout, getTopBottomOffsetForScrollingSibling() - i5, -kSAppBarLayout.getDownNestedScrollRange(), 0, i6);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.lib.desigin.KSHeaderBehavior, com.kwad.sdk.lib.desigin.KSCoordinatorLayout.Behavior
    public boolean onTouchEvent(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, MotionEvent motionEvent) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048593, this, kSCoordinatorLayout, kSAppBarLayout, motionEvent)) == null) {
            CustomHeaderBehaviorEx<KSAppBarLayout, CustomAppBarLayoutBehavior> customHeaderBehaviorEx = this.mHeaderExBehavior;
            return customHeaderBehaviorEx == null ? super.onTouchEvent(kSCoordinatorLayout, (KSCoordinatorLayout) kSAppBarLayout, motionEvent) : customHeaderBehaviorEx.onTouchEvent(kSCoordinatorLayout, (KSCoordinatorLayout) kSAppBarLayout, motionEvent);
        }
        return invokeLLL.booleanValue;
    }

    public void setExtraFixedSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.mExtraFixedSize = i2;
            CustomHeaderBehaviorEx<KSAppBarLayout, CustomAppBarLayoutBehavior> customHeaderBehaviorEx = this.mHeaderExBehavior;
            if (customHeaderBehaviorEx != null) {
                customHeaderBehaviorEx.setExtraFixedSize(i2);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.lib.desigin.KSHeaderBehavior
    public int setHeaderTopBottomOffset(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048597, this, kSCoordinatorLayout, kSAppBarLayout, i2)) == null) ? setHeaderTopBottomOffset(kSCoordinatorLayout, kSAppBarLayout, i2, Integer.MIN_VALUE, Integer.MAX_VALUE) : invokeLLI.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.lib.desigin.KSAppBarLayout.KSBehavior, com.kwad.sdk.lib.desigin.KSHeaderBehavior
    public int setHeaderTopBottomOffset(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048598, this, new Object[]{kSCoordinatorLayout, kSAppBarLayout, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) ? setHeaderTopBottomOffset(kSCoordinatorLayout, kSAppBarLayout, i2, i3, i4, -1) : invokeCommon.intValue;
    }

    public int setHeaderTopBottomOffset(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, int i2, int i3, int i4, int i5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048599, this, new Object[]{kSCoordinatorLayout, kSAppBarLayout, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
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
        return invokeCommon.intValue;
    }

    public void setScrollableSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            this.mScrollableSize = i2;
        }
    }

    public void setScrollableSizeChangeable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.mScrollableSizeChangeable = z;
        }
    }

    public void stopFling() {
        CustomHeaderBehaviorEx<KSAppBarLayout, CustomAppBarLayoutBehavior> customHeaderBehaviorEx;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || (customHeaderBehaviorEx = this.mHeaderExBehavior) == null) {
            return;
        }
        customHeaderBehaviorEx.stopFling();
    }

    public void updateAppBarLayoutDrawableState(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, int i2, int i3, boolean z) {
        View appBarChildOnOffset;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{kSCoordinatorLayout, kSAppBarLayout, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) || (appBarChildOnOffset = getAppBarChildOnOffset(kSAppBarLayout, i2)) == null) {
            return;
        }
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
