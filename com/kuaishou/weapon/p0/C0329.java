package com.kuaishou.weapon.p0;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.c.b;
import org.json.JSONArray;
import org.json.JSONObject;
/* renamed from: com.kuaishou.weapon.p0.ʼˋ  reason: contains not printable characters */
/* loaded from: classes5.dex */
public class C0329 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: ʻ  reason: contains not printable characters */
    public Context f73;

    /* renamed from: ʼ  reason: contains not printable characters */
    public int f74;

    public C0329(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f73 = context;
        this.f74 = i;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public String m243(String str) {
        InterceptResult invokeL;
        JSONObject m244;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            try {
                JSONObject m253 = new C0333(str, C0331.f85).m253(this.f73);
                if (m253 == null || (m244 = m244()) == null) {
                    return null;
                }
                m253.put("module_section", m244);
                return m253.toString();
            } catch (Throwable unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public JSONObject m244() {
        InterceptResult invokeV;
        JSONArray m582;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                int m392 = C0374.m389(this.f73).m392(C0374.f313, 0);
                C0374 m389 = C0374.m389(this.f73);
                boolean m408 = m389.m408("a1_p_s_p_s");
                boolean m4082 = m389.m408("a1_p_s_p_s_c_b");
                if (m392 == 1 && ((m408 || m4082) && (m582 = new C0408(this.f73).m582(0)) != null)) {
                    jSONObject.put("10000", m582);
                    try {
                        jSONObject.put("11301", C0433.m867(b.t().q()));
                        jSONObject.put("11302", C0433.m867(b.t().r()));
                        jSONObject.put("11303", C0433.m867(b.t().s()));
                    } catch (Throwable unused) {
                    }
                    jSONObject.put("11007", System.currentTimeMillis() - currentTimeMillis);
                    jSONObject.put("11017", jSONObject.toString().length());
                    return jSONObject;
                }
            } catch (Throwable unused2) {
            }
            return null;
        }
        return (JSONObject) invokeV.objValue;
    }
}
