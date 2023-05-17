package com.kwai.adclient.kscommerciallogger.model;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public final class a extends d {
    public static /* synthetic */ Interceptable $ic;
    public static final d arA;
    public static final d arB;
    public static final d arC;
    public static final d arD;
    public static final d arE;
    public static final d arF;
    public static final d arG;
    public static final d arH;
    public static final d arI;
    public static final d arJ;
    public static final d arK;
    public static final d arL;
    public static final d arM;
    public static final d arN;
    public static final d arO;
    public static final d arP;
    public static final d arQ;
    public static final d ary;
    public static final d arz;
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
        ary = new d("DURATION_PAGE_LOAD");
        arz = new d("DURATION_WIDGET_LOAD");
        arA = new d("DURATION_RN_PAGE_LOAD");
        arB = new d("DURATION_TK_PAGE_LOAD");
        arC = new d("DURATION_WEB_PAGE_LOAD");
        arD = new d("NETWORK_LOAD_TIME");
        arE = new d("NETWORK_BIZ_CODE_ERROR");
        arF = new d("NETWORK_RESPONSE_ERROR");
        arG = new d("EXECUTION_METHOD_TIME");
        arH = new d("EXECUTION_IO_TIME");
        arI = new d("EXECUTION_BIZ_TIME");
        arJ = new d("FPS_AVG");
        arK = new d("FPS_LAG");
        arL = new d("MEMORY_USAGE");
        arM = new d("MEMORY_LEAK");
        arN = new d("MEMORY_OOM");
        arO = new d("CRASH_NATIVE");
        arP = new d("CRASH_UNNATIVE");
        arQ = new d("CRASH_ANR");
    }
}
