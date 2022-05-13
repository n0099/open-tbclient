package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* compiled from: NavBarLogic.java */
/* loaded from: classes6.dex */
public final /* synthetic */ class mn6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static nn6 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (UbsABTestHelper.isFrsModifyABTestA()) {
                return new pn6();
            }
            return new on6();
        }
        return (nn6) invokeV.objValue;
    }
}
