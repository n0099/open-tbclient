package com.kuaishou.weapon.un;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class y0 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "RISK_AUTH_FAILED";

    /* renamed from: b  reason: collision with root package name */
    public static final String f55309b = "RISK_SERVICE_OBJECT_NULL";

    /* renamed from: c  reason: collision with root package name */
    public static final String f55310c = "RISK_GET_FIELD_EMPTY";

    /* renamed from: d  reason: collision with root package name */
    public static final String f55311d = "RISK_EXCEPTION_HAPPEN";

    /* renamed from: e  reason: collision with root package name */
    public static final String f55312e = "RISK_SWITCH_CLOSED";

    /* renamed from: f  reason: collision with root package name */
    public static final String f55313f = "RISK_NOT_ALLOWED";

    /* renamed from: g  reason: collision with root package name */
    public static final int f55314g = -2;

    /* renamed from: h  reason: collision with root package name */
    public static final int f55315h = -1;

    /* renamed from: i  reason: collision with root package name */
    public static final int f55316i = 0;

    /* renamed from: j  reason: collision with root package name */
    public static final int f55317j = 1;
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
