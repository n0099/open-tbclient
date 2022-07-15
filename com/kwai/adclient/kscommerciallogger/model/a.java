package com.kwai.adclient.kscommerciallogger.model;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public final class a extends d {
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
    public static final d n;
    public static final d o;
    public static final d p;
    public static final d q;
    public static final d r;
    public static final d s;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(592864045, "Lcom/kwai/adclient/kscommerciallogger/model/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(592864045, "Lcom/kwai/adclient/kscommerciallogger/model/a;");
                return;
            }
        }
        a = new d("DURATION_PAGE_LOAD");
        b = new d("DURATION_WIDGET_LOAD");
        c = new d("DURATION_RN_PAGE_LOAD");
        d = new d("DURATION_TK_PAGE_LOAD");
        e = new d("DURATION_WEB_PAGE_LOAD");
        f = new d("NETWORK_LOAD_TIME");
        g = new d("NETWORK_BIZ_CODE_ERROR");
        h = new d("NETWORK_RESPONSE_ERROR");
        i = new d("EXECUTION_METHOD_TIME");
        j = new d("EXECUTION_IO_TIME");
        k = new d("EXECUTION_BIZ_TIME");
        l = new d("FPS_AVG");
        m = new d("FPS_LAG");
        n = new d("MEMORY_USAGE");
        o = new d("MEMORY_LEAK");
        p = new d("MEMORY_OOM");
        q = new d("CRASH_NATIVE");
        r = new d("CRASH_UNNATIVE");
        s = new d("CRASH_ANR");
    }
}
