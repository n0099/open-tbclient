package com.kuaishou.weapon.p0;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class q1 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "com.kuaishou.weapon";
    public static final String b = "5.0.1";
    public static final boolean c = false;
    public static final String d = "weapon";
    public static final String e = "0.0.0";
    public static final String f = "com.kuaishou.weapon.p0.env.action";
    public static final String g = "p0";
    public transient /* synthetic */ FieldHolder $fh;

    public q1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
