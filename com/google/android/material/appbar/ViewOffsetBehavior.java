package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class ViewOffsetBehavior extends CoordinatorLayout.Behavior {
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            if (viewOffsetHelper != null && viewOffsetHelper.isHorizontalOffsetEnabled()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isVerticalOffsetEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ViewOffsetHelper viewOffsetHelper = this.viewOffsetHelper;
            if (viewOffsetHelper != null && viewOffsetHelper.isVerticalOffsetEnabled()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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

    public void layoutChild(CoordinatorLayout coordinatorLayout, View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048580, this, coordinatorLayout, view2, i) == null) {
            coordinatorLayout.onLayoutChild(view2, i);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view2, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048581, this, coordinatorLayout, view2, i)) == null) {
            layoutChild(coordinatorLayout, view2, i);
            if (this.viewOffsetHelper == null) {
                this.viewOffsetHelper = new ViewOffsetHelper(view2);
            }
            this.viewOffsetHelper.onViewLayout();
            this.viewOffsetHelper.applyOffsets();
            int i2 = this.tempTopBottomOffset;
            if (i2 != 0) {
                this.viewOffsetHelper.setTopAndBottomOffset(i2);
                this.tempTopBottomOffset = 0;
            }
            int i3 = this.tempLeftRightOffset;
            if (i3 != 0) {
                this.viewOffsetHelper.setLeftAndRightOffset(i3);
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
        if ((interceptable == null || interceptable.invokeZ(1048582, this, z) == null) && (viewOffsetHelper = this.viewOffsetHelper) != null) {
            viewOffsetHelper.setHorizontalOffsetEnabled(z);
        }
    }

    public boolean setLeftAndRightOffset(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            ViewOffsetHelper viewOffsetHelper = this.viewOffsetHelper;
            if (viewOffsetHelper != null) {
                return viewOffsetHelper.setLeftAndRightOffset(i);
            }
            this.tempLeftRightOffset = i;
            return false;
        }
        return invokeI.booleanValue;
    }

    public boolean setTopAndBottomOffset(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            ViewOffsetHelper viewOffsetHelper = this.viewOffsetHelper;
            if (viewOffsetHelper != null) {
                return viewOffsetHelper.setTopAndBottomOffset(i);
            }
            this.tempTopBottomOffset = i;
            return false;
        }
        return invokeI.booleanValue;
    }

    public void setVerticalOffsetEnabled(boolean z) {
        ViewOffsetHelper viewOffsetHelper;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048585, this, z) == null) && (viewOffsetHelper = this.viewOffsetHelper) != null) {
            viewOffsetHelper.setVerticalOffsetEnabled(z);
        }
    }
}
