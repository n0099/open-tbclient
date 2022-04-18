package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* compiled from: NavBarLogic.java */
/* loaded from: classes6.dex */
public final /* synthetic */ class lo6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static mo6 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (UbsABTestHelper.isFrsModifyABTestA()) {
                return new oo6();
            }
            return new no6();
        }
        return (mo6) invokeV.objValue;
    }
}
