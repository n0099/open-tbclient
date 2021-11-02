package com.ss.android.socialbase.appdownloader;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f68893a;

    /* renamed from: b  reason: collision with root package name */
    public int f68894b;

    /* renamed from: c  reason: collision with root package name */
    public String f68895c;

    /* renamed from: d  reason: collision with root package name */
    public String f68896d;

    /* renamed from: e  reason: collision with root package name */
    public String f68897e;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f68894b = -1;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? b().toString() : (String) invokeV.objValue;
    }

    public JSONObject b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            a(jSONObject);
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("ah_plan_type", this.f68893a);
            jSONObject.put("error_code", String.valueOf(this.f68894b));
            jSONObject.put(GameCodeGetResponseMsg.PARAM_ERROR_MSG, this.f68895c);
            jSONObject.put("real_device_plan", this.f68896d);
            jSONObject.put("device_plans", this.f68897e);
        } catch (Throwable unused) {
        }
    }

    public static a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            a aVar = new a();
            try {
                JSONObject jSONObject = new JSONObject(str);
                aVar.f68897e = jSONObject.optString("device_plans", null);
                aVar.f68896d = jSONObject.optString("real_device_plan", null);
                aVar.f68895c = jSONObject.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG, null);
                aVar.f68893a = jSONObject.optString("ah_plan_type", null);
                String optString = jSONObject.optString("error_code");
                if (TextUtils.isEmpty(optString)) {
                    aVar.f68894b = -1;
                } else {
                    aVar.f68894b = Integer.parseInt(optString);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return aVar;
        }
        return (a) invokeL.objValue;
    }
}
