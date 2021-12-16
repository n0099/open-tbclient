package com.google.android.material.appbar;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class ViewOffsetHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean horizontalOffsetEnabled;
    public int layoutLeft;
    public int layoutTop;
    public int offsetLeft;
    public int offsetTop;
    public boolean verticalOffsetEnabled;
    public final View view;

    public ViewOffsetHelper(View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.verticalOffsetEnabled = true;
        this.horizontalOffsetEnabled = true;
        this.view = view;
    }

    public void applyOffsets() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View view = this.view;
            ViewCompat.offsetTopAndBottom(view, this.offsetTop - (view.getTop() - this.layoutTop));
            View view2 = this.view;
            ViewCompat.offsetLeftAndRight(view2, this.offsetLeft - (view2.getLeft() - this.layoutLeft));
        }
    }

    public int getLayoutLeft() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.layoutLeft : invokeV.intValue;
    }

    public int getLayoutTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.layoutTop : invokeV.intValue;
    }

    public int getLeftAndRightOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.offsetLeft : invokeV.intValue;
    }

    public int getTopAndBottomOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.offsetTop : invokeV.intValue;
    }

    public boolean isHorizontalOffsetEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.horizontalOffsetEnabled : invokeV.booleanValue;
    }

    public boolean isVerticalOffsetEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.verticalOffsetEnabled : invokeV.booleanValue;
    }

    public void onViewLayout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.layoutTop = this.view.getTop();
            this.layoutLeft = this.view.getLeft();
        }
    }

    public void setHorizontalOffsetEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.horizontalOffsetEnabled = z;
        }
    }

    public boolean setLeftAndRightOffset(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            if (!this.horizontalOffsetEnabled || this.offsetLeft == i2) {
                return false;
            }
            this.offsetLeft = i2;
            applyOffsets();
            return true;
        }
        return invokeI.booleanValue;
    }

    public boolean setTopAndBottomOffset(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            if (!this.verticalOffsetEnabled || this.offsetTop == i2) {
                return false;
            }
            this.offsetTop = i2;
            applyOffsets();
            return true;
        }
        return invokeI.booleanValue;
    }

    public void setVerticalOffsetEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.verticalOffsetEnabled = z;
        }
    }
}
