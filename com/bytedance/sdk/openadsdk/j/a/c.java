package com.bytedance.sdk.openadsdk.j.a;

import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.JProtect;
import com.bytedance.sdk.component.utils.n;
import com.bytedance.sdk.openadsdk.AppLogHelper;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.j.a.c;
import com.bytedance.sdk.openadsdk.q.k;
import com.bytedance.sdk.openadsdk.q.q;
import com.google.zxing.maxicode.decoder.DecodedBitStreamParser;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class c<T extends c> implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f31620a;

    /* renamed from: b  reason: collision with root package name */
    public String f31621b;

    /* renamed from: c  reason: collision with root package name */
    public String f31622c;

    /* renamed from: d  reason: collision with root package name */
    public String f31623d;

    /* renamed from: e  reason: collision with root package name */
    public String f31624e;

    /* renamed from: f  reason: collision with root package name */
    public long f31625f;

    /* renamed from: g  reason: collision with root package name */
    public int f31626g;

    /* renamed from: h  reason: collision with root package name */
    public String f31627h;

    /* renamed from: i  reason: collision with root package name */
    public int f31628i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;

    public c() {
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
        this.f31623d = "3.7.0.3";
        this.f31625f = System.currentTimeMillis() / 1000;
        this.f31626g = 0;
        this.f31628i = 0;
    }

    public static c<c> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new c<>() : (c) invokeV.objValue;
    }

    private JSONObject r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(IAdRequestParam.OS, 1);
                com.bytedance.sdk.openadsdk.m.a.b(o.a(), jSONObject);
                jSONObject.put("oaid", k.a());
                jSONObject.put("model", Build.MODEL);
                jSONObject.put(IAdRequestParam.ANDROID_ID, j.c(o.a()));
                jSONObject.put("vendor", Build.MANUFACTURER);
                jSONObject.put("package_name", q.d());
                jSONObject.put("ua", q.b());
                jSONObject.put("applog_did", AppLogHelper.getInstance().getAppLogDid());
                jSONObject.put("ip", com.bytedance.sdk.openadsdk.core.k.c.a(true));
            } catch (Exception unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    private T s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) ? this : (T) invokeV.objValue;
    }

    public T a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            this.f31626g = i2;
            return s();
        }
        return (T) invokeI.objValue;
    }

    public T a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            this.f31620a = str;
            return s();
        }
        return (T) invokeL.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.j.a.a
    @Keep
    @JProtect
    public JSONObject a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) != null) {
            return (JSONObject) invokeV.objValue;
        }
        while (true) {
            char c2 = 'X';
            char c3 = 65494;
            while (true) {
                switch (c2) {
                    case 'W':
                        c2 = 'Y';
                        c3 = 31;
                    case 'X':
                        c2 = 'Y';
                        c3 = 31;
                    case 'Y':
                        while (true) {
                            switch (c3) {
                                case 29:
                                case 30:
                                    break;
                                case 31:
                                    JSONObject jSONObject = new JSONObject();
                                    try {
                                        if (!TextUtils.isEmpty(c())) {
                                            jSONObject.put("type", c());
                                        }
                                        if (!TextUtils.isEmpty(e())) {
                                            jSONObject.put("rit", e());
                                        }
                                        if (!TextUtils.isEmpty(f())) {
                                            jSONObject.put("creative_id", f());
                                        }
                                        if (!TextUtils.isEmpty(g())) {
                                            jSONObject.put("ad_sdk_version", g());
                                        }
                                        jSONObject.put("app_version", !TextUtils.isEmpty(i()) ? i() : q.f());
                                        if (j() > 0) {
                                            jSONObject.put("timestamp", j());
                                        }
                                        if (k() > 0) {
                                            jSONObject.put("adtype", k());
                                        }
                                        if (!TextUtils.isEmpty(l())) {
                                            jSONObject.put(IAdRequestParam.REQ_ID, l());
                                        }
                                        jSONObject.put("error_code", m());
                                        if (!TextUtils.isEmpty(n())) {
                                            jSONObject.put("error_msg", n());
                                        }
                                        if (!TextUtils.isEmpty(o())) {
                                            jSONObject.put("extra", o());
                                        }
                                        if (!TextUtils.isEmpty(p())) {
                                            jSONObject.put("image_url", p());
                                        }
                                        if (!TextUtils.isEmpty(d())) {
                                            jSONObject.put("event_extra", d());
                                        }
                                        if (!TextUtils.isEmpty(h())) {
                                            jSONObject.put("duration", h());
                                        }
                                        if (!TextUtils.isEmpty(h.d().h())) {
                                            jSONObject.put("appid", h.d().h());
                                        }
                                        if (!TextUtils.isEmpty(q())) {
                                            jSONObject.put("ad_info", q());
                                        }
                                        jSONObject.put("conn_type", n.b(o.a()));
                                    } catch (Exception e2) {
                                        e2.printStackTrace();
                                    }
                                    try {
                                        jSONObject.put("device_info", r());
                                    } catch (Throwable unused) {
                                    }
                                    return jSONObject;
                                default:
                                    c3 = DecodedBitStreamParser.GS;
                            }
                        }
                        break;
                    default:
                        c2 = 'W';
                }
            }
        }
    }

    public T b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            this.f31628i = i2;
            return s();
        }
        return (T) invokeI.objValue;
    }

    public T b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            this.m = str;
            return s();
        }
        return (T) invokeL.objValue;
    }

    public T c(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j)) == null) {
            this.f31625f = j;
            return s();
        }
        return (T) invokeJ.objValue;
    }

    public T c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            this.f31621b = str;
            return s();
        }
        return (T) invokeL.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f31620a : (String) invokeV.objValue;
    }

    public T d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            this.f31622c = str;
            return s();
        }
        return (T) invokeL.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.m : (String) invokeV.objValue;
    }

    public T e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            this.n = str;
            return s();
        }
        return (T) invokeL.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f31621b : (String) invokeV.objValue;
    }

    public T f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            this.f31627h = str;
            return s();
        }
        return (T) invokeL.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f31622c : (String) invokeV.objValue;
    }

    public T g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            this.j = str;
            return s();
        }
        return (T) invokeL.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f31623d : (String) invokeV.objValue;
    }

    public T h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            this.k = str;
            return s();
        }
        return (T) invokeL.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.n : (String) invokeV.objValue;
    }

    public T i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) {
            this.l = str;
            return s();
        }
        return (T) invokeL.objValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f31624e : (String) invokeV.objValue;
    }

    public long j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f31625f : invokeV.longValue;
    }

    public T j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, str)) == null) {
            this.o = str;
            return s();
        }
        return (T) invokeL.objValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f31626g : invokeV.intValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f31627h : (String) invokeV.objValue;
    }

    public int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f31628i : invokeV.intValue;
    }

    public String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.j : (String) invokeV.objValue;
    }

    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.k : (String) invokeV.objValue;
    }

    public String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.l : (String) invokeV.objValue;
    }

    public String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.o : (String) invokeV.objValue;
    }
}
