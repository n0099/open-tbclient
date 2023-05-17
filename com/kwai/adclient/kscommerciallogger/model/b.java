package com.kwai.adclient.kscommerciallogger.model;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public final class b extends d {
    public static /* synthetic */ Interceptable $ic;
    public static final d arR;
    public static final d arS;
    public static final d arT;
    public static final d arU;
    public static final d arV;
    public static final d arW;
    public static final d arX;
    public static final d arY;
    public static final d arZ;
    public static final d asa;
    public static final d asb;
    public static final d asc;
    public static final d asd;
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
        arR = new d("NETWORK_NO_BODY");
        arS = new d("NETWORK_FORMAT_ERROR");
        arT = new d("NETWORK_INFO_INCOMPLETE");
        arU = new d("NETWORK_BUSINESS_ERROR");
        arV = new d("NETWORK_ERROR");
        arW = new d("METHOD_PARAM_ILLEGAL");
        arX = new d("METHOD_LONG_TIME");
        arY = new d("METHOD_ERROR");
        arZ = new d("PAGE_RENDER_FAIL");
        asa = new d("VIEW_RENDER_FAIL");
        asb = new d("RENDER_ERROR");
        asc = new d("MATERIAL_LOAD_FAIL");
        asd = new d("EXCEPTION");
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
