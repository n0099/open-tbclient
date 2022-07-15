package com.kwai.adclient.kscommerciallogger.model;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public final class b extends d {
    public static /* synthetic */ Interceptable $ic;
    public static final d a;
    public static final d b;
    public static final d c;
    public static final d d;
    public static final d e;
    public static final d f;
    public static final d g;
    public static final d h;
    public static final d i;
    public static final d j;
    public static final d k;
    public static final d l;
    public static final d m;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(592864076, "Lcom/kwai/adclient/kscommerciallogger/model/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(592864076, "Lcom/kwai/adclient/kscommerciallogger/model/b;");
                return;
            }
        }
        a = new d("NETWORK_NO_BODY");
        b = new d("NETWORK_FORMAT_ERROR");
        c = new d("NETWORK_INFO_INCOMPLETE");
        d = new d("NETWORK_BUSINESS_ERROR");
        e = new d("NETWORK_ERROR");
        f = new d("METHOD_PARAM_ILLEGAL");
        g = new d("METHOD_LONG_TIME");
        h = new d("METHOD_ERROR");
        i = new d("PAGE_RENDER_FAIL");
        j = new d("VIEW_RENDER_FAIL");
        k = new d("RENDER_ERROR");
        l = new d("MATERIAL_LOAD_FAIL");
        m = new d("EXCEPTION");
    }
}
