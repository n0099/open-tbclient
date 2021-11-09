package com.qq.e.ads.cfg;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.comm.util.GDTLogger;
/* loaded from: classes2.dex */
public class MultiProcessFlag {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f67828a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f67829b;
    public transient /* synthetic */ FieldHolder $fh;

    public MultiProcessFlag() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static boolean isMultiProcess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? f67828a : invokeV.booleanValue;
    }

    public static void setMultiProcess(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65538, null, z) == null) {
            if (f67829b) {
                GDTLogger.w("MultiProcessFlag已经设置过，再次设置无效");
                return;
            }
            f67829b = true;
            f67828a = z;
        }
    }
}
