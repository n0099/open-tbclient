package com.kwad.sdk.lib.desigin;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.Keep;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.lib.desigin.KSCoordinatorLayout;
import java.util.Arrays;
@Keep
/* loaded from: classes7.dex */
public abstract class CustomActionBarBehavior extends KSCoordinatorLayout.Behavior<RelativeLayout> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int mActionBarBgColor;
    public float mActionBarColorChangeRange;
    public float mActionBarHeight;
    public Activity mActivity;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomActionBarBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (context instanceof Activity) {
            this.mActivity = (Activity) context;
        }
        Resources resources = context.getResources();
        if (resources != null) {
            this.mActionBarBgColor = -1;
            i2 = (int) resources.getDimension(R.dimen.ksad_title_bar_height);
        } else {
            i2 = 0;
        }
        int i5 = R.attr.ksad_action_bar_height;
        int i6 = R.attr.ksad_action_bar_bg_color;
        int i7 = R.attr.ksad_color_change_range;
        int[] iArr = {i5, i6, i7};
        Arrays.sort(iArr);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        this.mActionBarHeight = obtainStyledAttributes.getDimensionPixelOffset(Arrays.binarySearch(iArr, i5), i2);
        this.mActionBarBgColor = obtainStyledAttributes.getColor(Arrays.binarySearch(iArr, i6), this.mActionBarBgColor);
        this.mActionBarColorChangeRange = obtainStyledAttributes.getDimensionPixelSize(Arrays.binarySearch(iArr, i7), i2);
        obtainStyledAttributes.recycle();
    }

    public int getColorWithAlpha(float f2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), Integer.valueOf(i2)})) == null) ? (Math.min(255, Math.max(0, (int) (f2 * 255.0f))) << 24) + (i2 & 16777215) : invokeCommon.intValue;
    }

    public abstract void initView(RelativeLayout relativeLayout);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.lib.desigin.KSCoordinatorLayout.Behavior
    public boolean layoutDependsOn(KSCoordinatorLayout kSCoordinatorLayout, RelativeLayout relativeLayout, View view) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, kSCoordinatorLayout, relativeLayout, view)) == null) ? view instanceof KSAppBarLayout : invokeLLL.booleanValue;
    }

    public void onActionBarHeightChanged(RelativeLayout relativeLayout, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(1048580, this, relativeLayout, f2) == null) {
            initView(relativeLayout);
            relativeLayout.setBackgroundColor(getColorWithAlpha(transRatio(0.08f, 1.0f, f2), this.mActionBarBgColor));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.lib.desigin.KSCoordinatorLayout.Behavior
    public boolean onDependentViewChanged(KSCoordinatorLayout kSCoordinatorLayout, RelativeLayout relativeLayout, View view) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, kSCoordinatorLayout, relativeLayout, view)) == null) {
            onActionBarHeightChanged(relativeLayout, Math.min((-view.getTop()) / (this.mActionBarColorChangeRange - this.mActionBarHeight), 1.0f));
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public void setActionBarColorChangeRange(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.mActionBarColorChangeRange = i2;
        }
    }

    public float transRatio(float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
            if (f4 < f2) {
                return 0.0f;
            }
            if (f4 > f3) {
                return 1.0f;
            }
            return (f4 - f2) / (f3 - f2);
        }
        return invokeCommon.floatValue;
    }
}
