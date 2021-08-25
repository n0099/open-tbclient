package com.cmic.sso.sdk.c;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.util.AdExtParam;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.IWalletLoginListener;
import com.cmic.sso.sdk.auth.AuthnHelper;
import com.cmic.sso.sdk.b.b.g;
import com.heytap.mcssdk.mode.CommandMessage;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a extends g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public String B;
    public String C;
    public String D;

    /* renamed from: a  reason: collision with root package name */
    public CopyOnWriteArrayList<Throwable> f68989a;

    /* renamed from: b  reason: collision with root package name */
    public String f68990b;

    /* renamed from: c  reason: collision with root package name */
    public String f68991c;

    /* renamed from: d  reason: collision with root package name */
    public String f68992d;

    /* renamed from: e  reason: collision with root package name */
    public String f68993e;

    /* renamed from: f  reason: collision with root package name */
    public String f68994f;

    /* renamed from: g  reason: collision with root package name */
    public String f68995g;

    /* renamed from: h  reason: collision with root package name */
    public String f68996h;

    /* renamed from: i  reason: collision with root package name */
    public String f68997i;

    /* renamed from: j  reason: collision with root package name */
    public String f68998j;
    public String k;
    public String l;
    public String m;
    public String n;
    public JSONArray o;
    public String p;
    public String q;
    public String r;
    public String s;
    public String t;
    public String u;
    public String v;
    public String w;
    public String x;
    public String y;
    public String z;

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
        this.f68990b = null;
        this.f68991c = null;
        this.f68992d = null;
        this.f68993e = null;
        this.f68994f = null;
        this.f68995g = null;
        this.f68996h = null;
        this.f68997i = null;
        this.f68998j = null;
        this.k = "";
        this.l = null;
        this.m = null;
        this.n = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.f68989a = new CopyOnWriteArrayList<>();
    }

    public void A(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.A = str;
        }
    }

    public void B(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.B = str;
        }
    }

    public void C(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.C = str;
        }
    }

    public void D(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.D = str;
        }
    }

    @Override // com.cmic.sso.sdk.b.b.g
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.cmic.sso.sdk.b.b.g
    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            return null;
        }
        return (String) invokeL.objValue;
    }

    public void a(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, jSONArray) == null) {
            this.o = jSONArray;
        }
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.f68990b = str;
        }
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.z = str;
        }
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.w = str;
        }
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.x = str;
        }
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.y = str;
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.s = str;
        }
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.m = str;
        }
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.l = str;
        }
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.k = str;
        }
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.f68992d = str;
        }
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.f68993e = str;
        }
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.f68994f = str;
        }
    }

    public void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.f68997i = str;
        }
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.v = str;
        }
    }

    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.p = str;
        }
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            this.t = str;
        }
    }

    public void r(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            this.u = str;
        }
    }

    public void s(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            this.n = str;
        }
    }

    public void t(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            this.f68991c = str;
        }
    }

    public void u(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            this.f68995g = str;
        }
    }

    public void v(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, str) == null) {
            this.r = str;
        }
    }

    public void x(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
            this.f68996h = str;
        }
    }

    public void y(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, str) == null) {
            this.f68998j = str;
        }
    }

    public void z(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, str) == null) {
            this.q = str;
        }
    }

    @Override // com.cmic.sso.sdk.b.b.g
    public JSONObject b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("appid", this.f68990b);
                jSONObject.put("traceId", this.f68991c);
                jSONObject.put("appName", this.f68992d);
                jSONObject.put("appVersion", this.f68993e);
                jSONObject.put(CommandMessage.SDK_VERSION, AuthnHelper.SDK_VERSION);
                jSONObject.put("clientType", "android");
                jSONObject.put("timeOut", this.f68994f);
                jSONObject.put("requestTime", this.f68995g);
                jSONObject.put("responseTime", this.f68996h);
                jSONObject.put("elapsedTime", this.f68997i);
                jSONObject.put(AdExtParam.KEY_REQUEST_TYPE, this.f68998j);
                jSONObject.put("interfaceType", this.k);
                jSONObject.put("interfaceCode", this.l);
                jSONObject.put("interfaceElasped", this.m);
                jSONObject.put(IWalletLoginListener.KEY_LOGIN_TYPE, this.n);
                jSONObject.put("exceptionStackTrace", this.o);
                jSONObject.put("operatorType", this.p);
                jSONObject.put("networkType", this.q);
                jSONObject.put("networkClass", this.r);
                jSONObject.put("brand", this.s);
                jSONObject.put("reqDevice", this.t);
                jSONObject.put("reqSystem", this.u);
                jSONObject.put("simCardNum", this.v);
                jSONObject.put("imsiState", this.w);
                jSONObject.put(MiPushCommandMessage.KEY_RESULT_CODE, this.x);
                jSONObject.put("is_root", this.y);
                jSONObject.put("is_phoneStatePermission", this.z);
                jSONObject.put("AID", this.A);
                jSONObject.put("sysOperType", this.B);
                jSONObject.put("scripType", this.C);
                if (!TextUtils.isEmpty(this.D)) {
                    jSONObject.put("eip", this.D);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
