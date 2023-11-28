package com.kwai.adclient.kscommerciallogger.model;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public final class b extends d {
    public static /* synthetic */ Interceptable $ic;
    public static final d aSA;
    public static final d aSo;
    public static final d aSp;
    public static final d aSq;
    public static final d aSr;
    public static final d aSs;
    public static final d aSt;
    public static final d aSu;
    public static final d aSv;
    public static final d aSw;
    public static final d aSx;
    public static final d aSy;
    public static final d aSz;
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
        aSo = new d("NETWORK_NO_BODY");
        aSp = new d("NETWORK_FORMAT_ERROR");
        aSq = new d("NETWORK_INFO_INCOMPLETE");
        aSr = new d("NETWORK_BUSINESS_ERROR");
        aSs = new d("NETWORK_ERROR");
        aSt = new d("METHOD_PARAM_ILLEGAL");
        aSu = new d("METHOD_LONG_TIME");
        aSv = new d("METHOD_ERROR");
        aSw = new d("PAGE_RENDER_FAIL");
        aSx = new d("VIEW_RENDER_FAIL");
        aSy = new d("RENDER_ERROR");
        aSz = new d("MATERIAL_LOAD_FAIL");
        aSA = new d("EXCEPTION");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(String str) {
        super(str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }
}
