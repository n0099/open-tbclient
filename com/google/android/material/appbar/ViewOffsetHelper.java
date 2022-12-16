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
/* loaded from: classes7.dex */
public class ViewOffsetHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean horizontalOffsetEnabled;
    public int layoutLeft;
    public int layoutTop;
    public int offsetLeft;
    public int offsetTop;
    public boolean verticalOffsetEnabled;

    /* renamed from: view  reason: collision with root package name */
    public final View f1095view;

    public ViewOffsetHelper(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.verticalOffsetEnabled = true;
        this.horizontalOffsetEnabled = true;
        this.f1095view = view2;
    }

    public void applyOffsets() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View view2 = this.f1095view;
            ViewCompat.offsetTopAndBottom(view2, this.offsetTop - (view2.getTop() - this.layoutTop));
            View view3 = this.f1095view;
            ViewCompat.offsetLeftAndRight(view3, this.offsetLeft - (view3.getLeft() - this.layoutLeft));
        }
    }

    public int getLayoutLeft() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.layoutLeft;
        }
        return invokeV.intValue;
    }

    public int getLayoutTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.layoutTop;
        }
        return invokeV.intValue;
    }

    public int getLeftAndRightOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.offsetLeft;
        }
        return invokeV.intValue;
    }

    public int getTopAndBottomOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.offsetTop;
        }
        return invokeV.intValue;
    }

    public boolean isHorizontalOffsetEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.horizontalOffsetEnabled;
        }
        return invokeV.booleanValue;
    }

    public boolean isVerticalOffsetEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.verticalOffsetEnabled;
        }
        return invokeV.booleanValue;
    }

    public void onViewLayout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.layoutTop = this.f1095view.getTop();
            this.layoutLeft = this.f1095view.getLeft();
        }
    }

    public void setHorizontalOffsetEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.horizontalOffsetEnabled = z;
        }
    }

    public boolean setLeftAndRightOffset(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            if (this.horizontalOffsetEnabled && this.offsetLeft != i) {
                this.offsetLeft = i;
                applyOffsets();
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public boolean setTopAndBottomOffset(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            if (this.verticalOffsetEnabled && this.offsetTop != i) {
                this.offsetTop = i;
                applyOffsets();
                return true;
            }
            return false;
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
