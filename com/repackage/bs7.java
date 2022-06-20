package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.switchs.DelayPbTaskSwitch;
import com.baidu.tbadk.switchs.PrefetchPbDataSwitch;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class bs7 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile bs7 c;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean a;
    public final boolean b;

    public bs7() {
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
        this.b = DelayPbTaskSwitch.getIsOn();
        this.a = PrefetchPbDataSwitch.getIsOn();
    }

    public static bs7 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (bs7.class) {
                    if (c == null) {
                        c = new bs7();
                    }
                }
            }
            return c;
        }
        return (bs7) invokeV.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b : invokeV.booleanValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : invokeV.booleanValue;
    }
}
