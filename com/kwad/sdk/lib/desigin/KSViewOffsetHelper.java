package com.kwad.sdk.lib.desigin;

import android.view.View;
import androidx.annotation.Keep;
import androidx.core.view.ViewCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Keep
/* loaded from: classes7.dex */
public class KSViewOffsetHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int mLayoutLeft;
    public int mLayoutTop;
    public int mOffsetLeft;
    public int mOffsetTop;
    public final View mView;

    public KSViewOffsetHelper(View view) {
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
        this.mView = view;
    }

    private void updateOffsets() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            View view = this.mView;
            ViewCompat.offsetTopAndBottom(view, this.mOffsetTop - (view.getTop() - this.mLayoutTop));
            View view2 = this.mView;
            ViewCompat.offsetLeftAndRight(view2, this.mOffsetLeft - (view2.getLeft() - this.mLayoutLeft));
        }
    }

    public int getLayoutLeft() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mLayoutLeft : invokeV.intValue;
    }

    public int getLayoutTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mLayoutTop : invokeV.intValue;
    }

    public int getLeftAndRightOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mOffsetLeft : invokeV.intValue;
    }

    public int getTopAndBottomOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mOffsetTop : invokeV.intValue;
    }

    public void onViewLayout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.mLayoutTop = this.mView.getTop();
            this.mLayoutLeft = this.mView.getLeft();
            updateOffsets();
        }
    }

    public boolean setLeftAndRightOffset(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            if (this.mOffsetLeft != i2) {
                this.mOffsetLeft = i2;
                updateOffsets();
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public boolean setTopAndBottomOffset(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            if (this.mOffsetTop != i2) {
                this.mOffsetTop = i2;
                updateOffsets();
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }
}
