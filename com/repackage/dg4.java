package com.repackage;

import android.annotation.SuppressLint;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@SuppressLint({"StaticFieldLeak"})
/* loaded from: classes5.dex */
public final class dg4 extends pg4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile dg4 d;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dg4() {
        super("aiapp_open_stat");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static dg4 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (d == null) {
                synchronized (dg4.class) {
                    if (d == null) {
                        d = new dg4();
                    }
                }
            }
            return d;
        }
        return (dg4) invokeV.objValue;
    }
}
