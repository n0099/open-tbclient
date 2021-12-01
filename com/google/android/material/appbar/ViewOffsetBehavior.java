package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class ViewOffsetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int tempLeftRightOffset;
    public int tempTopBottomOffset;
    public ViewOffsetHelper viewOffsetHelper;

    public ViewOffsetBehavior() {
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
        this.tempTopBottomOffset = 0;
        this.tempLeftRightOffset = 0;
    }

    public int getLeftAndRightOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ViewOffsetHelper viewOffsetHelper = this.viewOffsetHelper;
            if (viewOffsetHelper != null) {
                return viewOffsetHelper.getLeftAndRightOffset();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int getTopAndBottomOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ViewOffsetHelper viewOffsetHelper = this.viewOffsetHelper;
            if (viewOffsetHelper != null) {
                return viewOffsetHelper.getTopAndBottomOffset();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean isHorizontalOffsetEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ViewOffsetHelper viewOffsetHelper = this.viewOffsetHelper;
            return viewOffsetHelper != null && viewOffsetHelper.isHorizontalOffsetEnabled();
        }
        return invokeV.booleanValue;
    }

    public boolean isVerticalOffsetEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ViewOffsetHelper viewOffsetHelper = this.viewOffsetHelper;
            return viewOffsetHelper != null && viewOffsetHelper.isVerticalOffsetEnabled();
        }
        return invokeV.booleanValue;
    }

    public void layoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048580, this, coordinatorLayout, v, i2) == null) {
            coordinatorLayout.onLayoutChild(v, i2);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048581, this, coordinatorLayout, v, i2)) == null) {
            layoutChild(coordinatorLayout, v, i2);
            if (this.viewOffsetHelper == null) {
                this.viewOffsetHelper = new ViewOffsetHelper(v);
            }
            this.viewOffsetHelper.onViewLayout();
            this.viewOffsetHelper.applyOffsets();
            int i3 = this.tempTopBottomOffset;
            if (i3 != 0) {
                this.viewOffsetHelper.setTopAndBottomOffset(i3);
                this.tempTopBottomOffset = 0;
            }
            int i4 = this.tempLeftRightOffset;
            if (i4 != 0) {
                this.viewOffsetHelper.setLeftAndRightOffset(i4);
                this.tempLeftRightOffset = 0;
                return true;
            }
            return true;
        }
        return invokeLLI.booleanValue;
    }

    public void setHorizontalOffsetEnabled(boolean z) {
        ViewOffsetHelper viewOffsetHelper;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048582, this, z) == null) || (viewOffsetHelper = this.viewOffsetHelper) == null) {
            return;
        }
        viewOffsetHelper.setHorizontalOffsetEnabled(z);
    }

    public boolean setLeftAndRightOffset(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            ViewOffsetHelper viewOffsetHelper = this.viewOffsetHelper;
            if (viewOffsetHelper != null) {
                return viewOffsetHelper.setLeftAndRightOffset(i2);
            }
            this.tempLeftRightOffset = i2;
            return false;
        }
        return invokeI.booleanValue;
    }

    public boolean setTopAndBottomOffset(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            ViewOffsetHelper viewOffsetHelper = this.viewOffsetHelper;
            if (viewOffsetHelper != null) {
                return viewOffsetHelper.setTopAndBottomOffset(i2);
            }
            this.tempTopBottomOffset = i2;
            return false;
        }
        return invokeI.booleanValue;
    }

    public void setVerticalOffsetEnabled(boolean z) {
        ViewOffsetHelper viewOffsetHelper;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || (viewOffsetHelper = this.viewOffsetHelper) == null) {
            return;
        }
        viewOffsetHelper.setVerticalOffsetEnabled(z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewOffsetBehavior(Context context, AttributeSet attributeSet) {
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
        this.tempTopBottomOffset = 0;
        this.tempLeftRightOffset = 0;
    }
}
