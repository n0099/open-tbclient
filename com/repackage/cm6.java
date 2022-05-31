package com.repackage;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* compiled from: TabBarLogic.java */
/* loaded from: classes5.dex */
public final /* synthetic */ class cm6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static em6 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (UbsABTestHelper.isFrsModifyABTestA()) {
                return new bm6();
            }
            return new dm6();
        }
        return (em6) invokeV.objValue;
    }

    @ColorInt
    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return SkinManager.getColor(UbsABTestHelper.isFrsModifyABTestA() ? R.color.CAM_X0108 : R.color.CAM_X0107);
        }
        return invokeV.intValue;
    }

    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return UtilHelper.getDimenPixelSize(UbsABTestHelper.isFrsModifyABTestA() ? R.dimen.T_X07 : R.dimen.tbds42);
        }
        return invokeV.intValue;
    }
}
