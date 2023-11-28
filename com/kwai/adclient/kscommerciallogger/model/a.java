package com.kwai.adclient.kscommerciallogger.model;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes10.dex */
public final class a extends d {
    public static /* synthetic */ Interceptable $ic;
    public static final d aRV;
    public static final d aRW;
    public static final d aRX;
    public static final d aRY;
    public static final d aRZ;
    public static final d aSa;
    public static final d aSb;
    public static final d aSc;
    public static final d aSd;
    public static final d aSe;
    public static final d aSf;
    public static final d aSg;
    public static final d aSh;
    public static final d aSi;
    public static final d aSj;
    public static final d aSk;
    public static final d aSl;
    public static final d aSm;
    public static final d aSn;
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
        aRV = new d("DURATION_PAGE_LOAD");
        aRW = new d("DURATION_WIDGET_LOAD");
        aRX = new d("DURATION_RN_PAGE_LOAD");
        aRY = new d("DURATION_TK_PAGE_LOAD");
        aRZ = new d("DURATION_WEB_PAGE_LOAD");
        aSa = new d("NETWORK_LOAD_TIME");
        aSb = new d("NETWORK_BIZ_CODE_ERROR");
        aSc = new d("NETWORK_RESPONSE_ERROR");
        aSd = new d("EXECUTION_METHOD_TIME");
        aSe = new d("EXECUTION_IO_TIME");
        aSf = new d("EXECUTION_BIZ_TIME");
        aSg = new d("FPS_AVG");
        aSh = new d("FPS_LAG");
        aSi = new d("MEMORY_USAGE");
        aSj = new d("MEMORY_LEAK");
        aSk = new d("MEMORY_OOM");
        aSl = new d("CRASH_NATIVE");
        aSm = new d("CRASH_UNNATIVE");
        aSn = new d("CRASH_ANR");
    }
}
