package com.kuaishou.weapon.un;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class y0 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "RISK_AUTH_FAILED";
    public static final String b = "RISK_SERVICE_OBJECT_NULL";
    public static final String c = "RISK_GET_FIELD_EMPTY";
    public static final String d = "RISK_EXCEPTION_HAPPEN";
    public static final String e = "RISK_SWITCH_CLOSED";
    public static final String f = "RISK_NOT_ALLOWED";
    public static final int g = -2;
    public static final int h = -1;
    public static final int i = 0;
    public static final int j = 1;
    public static final int k = -3;
    public static final int l = -4;
    public transient /* synthetic */ FieldHolder $fh;

    public y0() {
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
}
