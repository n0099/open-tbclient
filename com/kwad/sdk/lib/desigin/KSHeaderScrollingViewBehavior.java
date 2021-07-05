package com.kwad.sdk.lib.desigin;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Keep;
import androidx.core.math.MathUtils;
import androidx.core.view.GravityCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.badge.BadgeDrawable;
import com.kwad.sdk.lib.desigin.KSCoordinatorLayout;
import java.util.List;
@Keep
/* loaded from: classes7.dex */
public abstract class KSHeaderScrollingViewBehavior extends KSViewOffsetBehavior<View> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int mOverlayTop;
    public final Rect mTempRect1;
    public final Rect mTempRect2;
    public int mVerticalLayoutGap;

    public KSHeaderScrollingViewBehavior() {
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
        this.mTempRect1 = new Rect();
        this.mTempRect2 = new Rect();
        this.mVerticalLayoutGap = 0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KSHeaderScrollingViewBehavior(Context context, AttributeSet attributeSet) {
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
        this.mTempRect1 = new Rect();
        this.mTempRect2 = new Rect();
        this.mVerticalLayoutGap = 0;
    }

    public static int resolveGravity(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) ? i2 == 0 ? BadgeDrawable.TOP_START : i2 : invokeI.intValue;
    }

    public abstract View findFirstDependency(List<View> list);

    public final int getOverlapPixelsForOffset(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view)) == null) {
            if (this.mOverlayTop == 0) {
                return 0;
            }
            float overlapRatioForOffset = getOverlapRatioForOffset(view);
            int i2 = this.mOverlayTop;
            return MathUtils.clamp((int) (overlapRatioForOffset * i2), 0, i2);
        }
        return invokeL.intValue;
    }

    public float getOverlapRatioForOffset(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view)) == null) {
            return 1.0f;
        }
        return invokeL.floatValue;
    }

    public final int getOverlayTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mOverlayTop : invokeV.intValue;
    }

    public int getScrollRange(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, view)) == null) ? view.getMeasuredHeight() : invokeL.intValue;
    }

    public final int getVerticalLayoutGap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mVerticalLayoutGap : invokeV.intValue;
    }

    @Override // com.kwad.sdk.lib.desigin.KSViewOffsetBehavior
    public void layoutChild(KSCoordinatorLayout kSCoordinatorLayout, View view, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048582, this, kSCoordinatorLayout, view, i2) == null) {
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
    }

    @Override // com.kwad.sdk.lib.desigin.KSCoordinatorLayout.Behavior
    public boolean onMeasureChild(KSCoordinatorLayout kSCoordinatorLayout, View view, int i2, int i3, int i4, int i5) {
        InterceptResult invokeCommon;
        View findFirstDependency;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{kSCoordinatorLayout, view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
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
        return invokeCommon.booleanValue;
    }

    public final void setOverlayTop(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.mOverlayTop = i2;
        }
    }
}
