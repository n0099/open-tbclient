package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.http.HttpConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.UBCManager;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class yf {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public int b;
    public String c;
    public boolean d;
    public boolean e;

    public yf() {
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

    public void a() {
        JSONObject b;
        UBCManager uBCManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || new Random().nextInt(100) > 20 || (b = b()) == null || (uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)) == null) {
            return;
        }
        uBCManager.onEvent(HttpConfig.UBC_HTTP_ID, b.toString());
        uBCManager.onEvent("5607", b.toString());
    }

    public JSONObject b() {
        InterceptResult invokeV;
        JSONObject jSONObject;
        JSONException e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            try {
                jSONObject = new JSONObject();
                try {
                    jSONObject.put("url", this.a);
                    jSONObject.put("resultCode", this.b);
                    jSONObject.put("resultMsg", this.c);
                    int i = 1;
                    jSONObject.put("isHttps", this.d ? 1 : 0);
                    if (!this.e) {
                        i = 0;
                    }
                    jSONObject.put("isIpv6", i);
                } catch (JSONException e2) {
                    e = e2;
                    e.printStackTrace();
                    return jSONObject;
                }
            } catch (JSONException e3) {
                jSONObject = null;
                e = e3;
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
