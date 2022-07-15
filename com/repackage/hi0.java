package com.repackage;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.provider.FontsContractCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.net.util.NetUtil;
import com.baidu.nadcore.utils.LruCache;
import com.baidu.searchbox.perfframe.ioc.Constant;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class hi0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final LruCache<String, cj0> a;
    public final LruCache<String, String> b;
    public final LruCache<String, String> c;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final hi0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-327718555, "Lcom/repackage/hi0$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-327718555, "Lcom/repackage/hi0$a;");
                    return;
                }
            }
            a = new hi0();
        }
    }

    public hi0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new LruCache<>(5);
        this.b = new LruCache<>(5);
        this.c = new LruCache<>(5);
    }

    public static hi0 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? a.a : (hi0) invokeV.objValue;
    }

    @NonNull
    public final si0 a(String str, String str2, String str3, @NonNull String str4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, str, str2, str3, str4)) == null) {
            si0 si0Var = new si0();
            si0Var.g = str;
            si0Var.g(str2);
            si0Var.d = str3;
            TextUtils.isEmpty(str3);
            si0Var.p.a = str4;
            si0Var.r.a = new JSONObject().toString();
            return si0Var;
        }
        return (si0) invokeLLLL.objValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0085, code lost:
        if (r1.equals("batchgetdownloadstatus") != false) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(vg0 vg0Var, zg0 zg0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vg0Var, zg0Var) == null) {
            String str = (String) zx0.b(vg0Var.d(), "params");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject c = yx0.c(str);
            String optString = c.optString("type", "");
            String e = vg0Var.e();
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            Context b = hh0.b();
            char c2 = 0;
            if (!NetUtil.a(b) && (TextUtils.equals(optString, "startdownload") || TextUtils.equals(optString, "resumedownload"))) {
                Toast.makeText(b, b.getString(R.string.obfuscated_res_0x7f0f0b8a), 0).show();
                return;
            }
            switch (optString.hashCode()) {
                case -1263192174:
                    if (optString.equals("openapk")) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1028248962:
                    if (optString.equals("querypackage")) {
                        c2 = 7;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -690213213:
                    if (optString.equals(MiPushClient.COMMAND_REGISTER)) {
                        c2 = '\b';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -568075006:
                    if (optString.equals("canceldownload")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -515860354:
                    if (optString.equals("pausedownload")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 120066997:
                    if (optString.equals("resumedownload")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 636901206:
                    break;
                case 836015164:
                    if (optString.equals(MiPushClient.COMMAND_UNREGISTER)) {
                        c2 = '\t';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 900442785:
                    if (optString.equals("installapk")) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1490291434:
                    if (optString.equals("startdownload")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            switch (c2) {
                case 0:
                    c(c, zg0Var);
                    return;
                case 1:
                    i(c, zg0Var);
                    return;
                case 2:
                    g(c, zg0Var);
                    return;
                case 3:
                    h(c, zg0Var);
                    return;
                case 4:
                    d(c, zg0Var);
                    return;
                case 5:
                    e(c, zg0Var);
                    return;
                case 6:
                    f(e, c, zg0Var);
                    return;
                case 7:
                    j(c, zg0Var);
                    return;
                case '\b':
                    m(c, zg0Var);
                    return;
                case '\t':
                    n(c, zg0Var);
                    return;
                default:
                    return;
            }
        }
    }

    public final void c(JSONObject jSONObject, zg0 zg0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, jSONObject, zg0Var) == null) || jSONObject == null || zg0Var == null) {
            return;
        }
        String optString = jSONObject.optString(WebChromeClient.KEY_ARG_CALLBACK, "");
        JSONArray optJSONArray = jSONObject.optJSONArray("query");
        String optString2 = jSONObject.optString(Constant.KEY_BUSINESS, "");
        String optString3 = jSONObject.optString("page", "");
        HashMap hashMap = new HashMap();
        hashMap.put(WebChromeClient.KEY_ARG_CALLBACK, optString);
        if (optJSONArray != null && optJSONArray.length() > 0 && !TextUtils.isEmpty(optString3) && !TextUtils.isEmpty(optString2)) {
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null && !TextUtils.isEmpty(optJSONObject.optString("url", "")) && !TextUtils.isEmpty(optJSONObject.optString(FontsContractCompat.Columns.FILE_ID, "")) && !TextUtils.isEmpty(optJSONObject.optString("ext_info", ""))) {
                    String optString4 = optJSONObject.optString("url", "");
                    String optString5 = optJSONObject.optString(FontsContractCompat.Columns.FILE_ID, "");
                    cj0 l = l(optString4, optString5, optJSONObject.optString("packageName", ""), optJSONObject.optString("ext_info", ""), optString3, optString2);
                    if (l != null) {
                        String u = l.u();
                        Uri uri = l.t().k;
                        jSONArray.put(yx0.c(uj0.a(u, l.t().i + "", uri == null ? "" : uri.toString(), optString5)));
                    }
                }
            }
            if (jSONArray.length() <= 0) {
                uj0.b(zg0Var, true, hashMap);
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            yx0.f(jSONObject2, "result", jSONArray);
            hashMap.put("data", jSONObject2.toString());
            uj0.b(zg0Var, true, hashMap);
        } else if (!TextUtils.isEmpty(optString)) {
            uj0.b(zg0Var, false, hashMap);
        }
    }

    public final void d(JSONObject jSONObject, @Nullable zg0 zg0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, jSONObject, zg0Var) == null) || jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("url", "");
        String optString2 = jSONObject.optString("uri", "");
        String optString3 = jSONObject.optString(WebChromeClient.KEY_ARG_CALLBACK, "");
        String optString4 = jSONObject.optString(FontsContractCompat.Columns.FILE_ID, "");
        String optString5 = jSONObject.optString("ext_info", "");
        String optString6 = jSONObject.optString(Constant.KEY_BUSINESS, "");
        String optString7 = jSONObject.optString("page", "");
        String optString8 = jSONObject.optString("packageName", "");
        HashMap hashMap = new HashMap();
        hashMap.put(WebChromeClient.KEY_ARG_CALLBACK, optString3);
        if (!TextUtils.isEmpty(optString4) && !TextUtils.isEmpty(optString5) && !TextUtils.isEmpty(optString6) && !TextUtils.isEmpty(optString7)) {
            cj0 l = l(optString, optString4, optString8, optString5, optString7, optString6);
            if (l != null) {
                l.c();
                uj0.c(zg0Var, optString3, optString2, optString4, "1");
            }
            uj0.b(zg0Var, false, hashMap);
            return;
        }
        uj0.b(zg0Var, false, hashMap);
    }

    public final void e(JSONObject jSONObject, @Nullable zg0 zg0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, jSONObject, zg0Var) == null) || jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString(WebChromeClient.KEY_ARG_CALLBACK, "");
        String optString2 = jSONObject.optString(FontsContractCompat.Columns.FILE_ID, "");
        String optString3 = jSONObject.optString("ext_info", "");
        String optString4 = jSONObject.optString("packageName", "");
        String optString5 = jSONObject.optString(Constant.KEY_BUSINESS, "");
        String optString6 = jSONObject.optString("page", "");
        HashMap hashMap = new HashMap();
        hashMap.put(WebChromeClient.KEY_ARG_CALLBACK, optString);
        if (!TextUtils.isEmpty(optString4) && !TextUtils.isEmpty(optString5) && !TextUtils.isEmpty(optString6)) {
            cj0 l = l("", optString2, optString4, optString3, optString6, optString5);
            if (l != null) {
                l.v();
                uj0.b(zg0Var, true, hashMap);
                return;
            }
            uj0.b(zg0Var, false, hashMap);
            return;
        }
        uj0.b(zg0Var, false, hashMap);
    }

    public final void f(String str, JSONObject jSONObject, @Nullable zg0 zg0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048581, this, str, jSONObject, zg0Var) == null) || jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString(WebChromeClient.KEY_ARG_CALLBACK, "");
        String optString2 = jSONObject.optString(FontsContractCompat.Columns.FILE_ID, "");
        String optString3 = jSONObject.optString("ext_info", "");
        String optString4 = jSONObject.optString("packageName", "");
        String optString5 = jSONObject.optString(Constant.KEY_BUSINESS, "");
        String optString6 = jSONObject.optString("page", "");
        HashMap hashMap = new HashMap();
        hashMap.put(WebChromeClient.KEY_ARG_CALLBACK, optString);
        if (!TextUtils.isEmpty(optString4) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(optString5) && !TextUtils.isEmpty(optString6)) {
            cj0 l = l("", optString2, optString4, optString3, optString6, optString5);
            if (l != null) {
                l.t();
                l.v();
                uj0.b(zg0Var, true, hashMap);
                return;
            }
            uj0.b(zg0Var, tj0.f(optString4), hashMap);
            return;
        }
        uj0.b(zg0Var, false, hashMap);
    }

    public final void g(JSONObject jSONObject, @Nullable zg0 zg0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, jSONObject, zg0Var) == null) || jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("url", "");
        String optString2 = jSONObject.optString("uri", "");
        String optString3 = jSONObject.optString(WebChromeClient.KEY_ARG_CALLBACK, "");
        String optString4 = jSONObject.optString(FontsContractCompat.Columns.FILE_ID, "");
        String optString5 = jSONObject.optString("ext_info", "");
        String optString6 = jSONObject.optString(Constant.KEY_BUSINESS, "");
        String optString7 = jSONObject.optString("page", "");
        String optString8 = jSONObject.optString("packageName", "");
        HashMap hashMap = new HashMap();
        hashMap.put(WebChromeClient.KEY_ARG_CALLBACK, optString3);
        if (!TextUtils.isEmpty(optString4) && !TextUtils.isEmpty(optString5) && !TextUtils.isEmpty(optString6) && !TextUtils.isEmpty(optString7)) {
            cj0 l = l(optString, optString4, optString8, optString5, optString7, optString6);
            if (l != null) {
                l.t();
                l.v();
                uj0.c(zg0Var, optString3, optString2, optString4, "2");
                return;
            }
            uj0.b(zg0Var, false, hashMap);
            return;
        }
        uj0.b(zg0Var, false, null);
    }

    public final void h(JSONObject jSONObject, @Nullable zg0 zg0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, jSONObject, zg0Var) == null) || jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("url", "");
        String optString2 = jSONObject.optString("uri", "");
        String optString3 = jSONObject.optString(WebChromeClient.KEY_ARG_CALLBACK, "");
        String optString4 = jSONObject.optString(FontsContractCompat.Columns.FILE_ID, "");
        String optString5 = jSONObject.optString("ext_info", "");
        String optString6 = jSONObject.optString(Constant.KEY_BUSINESS, "");
        String optString7 = jSONObject.optString("page", "");
        String optString8 = jSONObject.optString("packageName", "");
        HashMap hashMap = new HashMap();
        hashMap.put(WebChromeClient.KEY_ARG_CALLBACK, optString3);
        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString5) && !TextUtils.isEmpty(optString6) && !TextUtils.isEmpty(optString7)) {
            cj0 l = l(optString, optString4, optString8, optString5, optString7, optString6);
            if (l != null) {
                l.t();
                l.v();
                uj0.c(zg0Var, optString3, optString2, optString4, "1");
                return;
            }
            uj0.b(zg0Var, false, hashMap);
            return;
        }
        uj0.b(zg0Var, false, hashMap);
    }

    public final void i(JSONObject jSONObject, @Nullable zg0 zg0Var) {
        Uri uri;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject, zg0Var) == null) || jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("url", "");
        String optString2 = jSONObject.optString(WebChromeClient.KEY_ARG_CALLBACK, "");
        String optString3 = jSONObject.optString(FontsContractCompat.Columns.FILE_ID, "");
        String optString4 = jSONObject.optString("uri", "");
        String optString5 = jSONObject.optString("ext_info", "");
        String optString6 = jSONObject.optString("packageName", "");
        String optString7 = jSONObject.optString(Constant.KEY_BUSINESS, "");
        String optString8 = jSONObject.optString("page", "");
        HashMap hashMap = new HashMap();
        hashMap.put(WebChromeClient.KEY_ARG_CALLBACK, optString2);
        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString5) && !TextUtils.isEmpty(optString8) && !TextUtils.isEmpty(optString7)) {
            cj0 l = l(optString, optString3, optString6, optString5, optString8, optString7);
            if (l != null) {
                si0 t = l.t();
                l.v();
                if (t != null && (uri = t.k) != null) {
                    optString4 = uri.toString();
                }
                hashMap.put("data", uj0.a("0", "0", optString4, optString3));
                uj0.b(zg0Var, true, hashMap);
                return;
            }
            uj0.b(zg0Var, false, hashMap);
            return;
        }
        uj0.b(zg0Var, false, hashMap);
    }

    public final void j(JSONObject jSONObject, @Nullable zg0 zg0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, jSONObject, zg0Var) == null) || jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString(WebChromeClient.KEY_ARG_CALLBACK);
        String optString2 = jSONObject.optString("packageName", "");
        HashMap hashMap = new HashMap();
        hashMap.put(WebChromeClient.KEY_ARG_CALLBACK, optString);
        JSONObject jSONObject2 = new JSONObject();
        String str = "1";
        if (!TextUtils.isEmpty(optString2) && tj0.b(optString2)) {
            str = "0";
        }
        yx0.f(jSONObject2, "result", str);
        hashMap.put("data", jSONObject2.toString());
        if (zg0Var != null) {
            zg0Var.a(true, hashMap);
        }
    }

    public final cj0 l(String str, String str2, String str3, String str4, String str5, String str6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{str, str2, str3, str4, str5, str6})) == null) {
            if (TextUtils.isEmpty(str2) && this.b.containsValue(str)) {
                for (String str7 : this.b.keySet()) {
                    if (TextUtils.equals(this.b.get(str7), str)) {
                        str2 = str7;
                    }
                }
            }
            if (TextUtils.isEmpty(str) && this.b.containsKey(str2)) {
                str = this.b.get(str2);
            }
            cj0 cj0Var = this.a.get(str2);
            if (cj0Var == null && !TextUtils.isEmpty(str)) {
                si0 a2 = a(str, str2, str3, uj0.d(str4));
                if (a2.q == null) {
                    a2.q = new ti0();
                }
                if (a2.p == null) {
                    a2.p = new wi0();
                }
                ti0 ti0Var = a2.q;
                ti0Var.b = str6;
                ti0Var.a = str5;
                if (!TextUtils.isEmpty(str4)) {
                    JSONObject c = yx0.c(str4);
                    a2.q.g = c.optInt("close_v_dl");
                    a2.q.c = c.optString("source");
                    a2.p.h = c.optString("app_name");
                    a2.p.g = c.optString("app_icon");
                    a2.p.i = c.optString("version");
                }
                cj0Var = new cj0(a2);
                this.a.put(str2, cj0Var);
            }
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                this.b.put(str2, str);
            }
            return cj0Var;
        }
        return (cj0) invokeCommon.objValue;
    }

    public final void m(JSONObject jSONObject, @Nullable zg0 zg0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048587, this, jSONObject, zg0Var) == null) || jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("url");
        String optString2 = jSONObject.optString(WebChromeClient.KEY_ARG_CALLBACK);
        String optString3 = jSONObject.optString("action");
        String optString4 = jSONObject.optString(FontsContractCompat.Columns.FILE_ID, "");
        String optString5 = jSONObject.optString("ext_info", "");
        String optString6 = jSONObject.optString(Constant.KEY_BUSINESS, "");
        String optString7 = jSONObject.optString("page", "");
        String optString8 = jSONObject.optString("packageName", "");
        zx0.e(this.c, optString4, optString2);
        HashMap hashMap = new HashMap();
        hashMap.put(WebChromeClient.KEY_ARG_CALLBACK, optString2);
        if (!TextUtils.isEmpty(optString6) && !TextUtils.isEmpty(optString7)) {
            cj0 l = l(optString, optString4, optString8, optString5, optString7, optString6);
            if (l != null) {
                l.x(optString3, optString2, optString7, optString6);
                uj0.b(zg0Var, true, hashMap);
                return;
            }
            uj0.b(zg0Var, false, hashMap);
            return;
        }
        uj0.b(zg0Var, false, hashMap);
    }

    public final void n(JSONObject jSONObject, @Nullable zg0 zg0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048588, this, jSONObject, zg0Var) == null) || jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("url");
        String optString2 = jSONObject.optString(WebChromeClient.KEY_ARG_CALLBACK);
        String optString3 = jSONObject.optString("action");
        String optString4 = jSONObject.optString(FontsContractCompat.Columns.FILE_ID, "");
        String optString5 = jSONObject.optString("ext_info", "");
        String optString6 = jSONObject.optString(Constant.KEY_BUSINESS, "");
        String optString7 = jSONObject.optString("page", "");
        String optString8 = jSONObject.optString("packageName", "");
        zx0.g(this.c, optString4);
        HashMap hashMap = new HashMap();
        hashMap.put(WebChromeClient.KEY_ARG_CALLBACK, optString2);
        if (!TextUtils.isEmpty(optString6) && !TextUtils.isEmpty(optString7)) {
            cj0 l = l(optString, optString4, optString8, optString5, optString7, optString6);
            if (l != null) {
                l.y(optString3, optString2, optString7, optString6);
                uj0.b(zg0Var, true, hashMap);
                return;
            }
            uj0.b(zg0Var, false, hashMap);
            return;
        }
        uj0.b(zg0Var, false, hashMap);
    }
}
