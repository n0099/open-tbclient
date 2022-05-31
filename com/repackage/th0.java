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
/* loaded from: classes7.dex */
public class th0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final LruCache<String, ni0> a;
    public final LruCache<String, String> b;
    public final LruCache<String, String> c;

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final th0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(14907736, "Lcom/repackage/th0$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(14907736, "Lcom/repackage/th0$a;");
                    return;
                }
            }
            a = new th0();
        }
    }

    public th0() {
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

    public static th0 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? a.a : (th0) invokeV.objValue;
    }

    @NonNull
    public final ei0 a(String str, String str2, String str3, @NonNull String str4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, str, str2, str3, str4)) == null) {
            ei0 ei0Var = new ei0();
            ei0Var.g = str;
            ei0Var.g(str2);
            ei0Var.d = str3;
            TextUtils.isEmpty(str3);
            ei0Var.p.a = str4;
            ei0Var.r.a = new JSONObject().toString();
            return ei0Var;
        }
        return (ei0) invokeLLLL.objValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0085, code lost:
        if (r1.equals("batchgetdownloadstatus") != false) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(lg0 lg0Var, pg0 pg0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lg0Var, pg0Var) == null) {
            String str = (String) ix0.b(lg0Var.d(), "params");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject c = hx0.c(str);
            String optString = c.optString("type", "");
            String e = lg0Var.e();
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            Context b = xg0.b();
            char c2 = 0;
            if (!NetUtil.a(b) && (TextUtils.equals(optString, "startdownload") || TextUtils.equals(optString, "resumedownload"))) {
                Toast.makeText(b, b.getString(R.string.obfuscated_res_0x7f0f0b95), 0).show();
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
                    c(c, pg0Var);
                    return;
                case 1:
                    i(c, pg0Var);
                    return;
                case 2:
                    g(c, pg0Var);
                    return;
                case 3:
                    h(c, pg0Var);
                    return;
                case 4:
                    d(c, pg0Var);
                    return;
                case 5:
                    e(c, pg0Var);
                    return;
                case 6:
                    f(e, c, pg0Var);
                    return;
                case 7:
                    j(c, pg0Var);
                    return;
                case '\b':
                    m(c, pg0Var);
                    return;
                case '\t':
                    n(c, pg0Var);
                    return;
                default:
                    return;
            }
        }
    }

    public final void c(JSONObject jSONObject, pg0 pg0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, jSONObject, pg0Var) == null) || jSONObject == null || pg0Var == null) {
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
                    ni0 l = l(optString4, optString5, optJSONObject.optString("packageName", ""), optJSONObject.optString("ext_info", ""), optString3, optString2);
                    if (l != null) {
                        String u = l.u();
                        Uri uri = l.t().k;
                        jSONArray.put(hx0.c(dj0.a(u, l.t().i + "", uri == null ? "" : uri.toString(), optString5)));
                    }
                }
            }
            if (jSONArray.length() <= 0) {
                dj0.b(pg0Var, true, hashMap);
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            hx0.f(jSONObject2, "result", jSONArray);
            hashMap.put("data", jSONObject2.toString());
            dj0.b(pg0Var, true, hashMap);
        } else if (!TextUtils.isEmpty(optString)) {
            dj0.b(pg0Var, false, hashMap);
        }
    }

    public final void d(JSONObject jSONObject, @Nullable pg0 pg0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, jSONObject, pg0Var) == null) || jSONObject == null) {
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
            ni0 l = l(optString, optString4, optString8, optString5, optString7, optString6);
            if (l != null) {
                l.c();
                dj0.c(pg0Var, optString3, optString2, optString4, "1");
            }
            dj0.b(pg0Var, false, hashMap);
            return;
        }
        dj0.b(pg0Var, false, hashMap);
    }

    public final void e(JSONObject jSONObject, @Nullable pg0 pg0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, jSONObject, pg0Var) == null) || jSONObject == null) {
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
            ni0 l = l("", optString2, optString4, optString3, optString6, optString5);
            if (l != null) {
                l.v();
                dj0.b(pg0Var, true, hashMap);
                return;
            }
            dj0.b(pg0Var, false, hashMap);
            return;
        }
        dj0.b(pg0Var, false, hashMap);
    }

    public final void f(String str, JSONObject jSONObject, @Nullable pg0 pg0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048581, this, str, jSONObject, pg0Var) == null) || jSONObject == null) {
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
            ni0 l = l("", optString2, optString4, optString3, optString6, optString5);
            if (l != null) {
                l.t();
                l.v();
                dj0.b(pg0Var, true, hashMap);
                return;
            }
            dj0.b(pg0Var, cj0.f(optString4), hashMap);
            return;
        }
        dj0.b(pg0Var, false, hashMap);
    }

    public final void g(JSONObject jSONObject, @Nullable pg0 pg0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, jSONObject, pg0Var) == null) || jSONObject == null) {
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
            ni0 l = l(optString, optString4, optString8, optString5, optString7, optString6);
            if (l != null) {
                l.t();
                l.v();
                dj0.c(pg0Var, optString3, optString2, optString4, "2");
                return;
            }
            dj0.b(pg0Var, false, hashMap);
            return;
        }
        dj0.b(pg0Var, false, null);
    }

    public final void h(JSONObject jSONObject, @Nullable pg0 pg0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, jSONObject, pg0Var) == null) || jSONObject == null) {
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
            ni0 l = l(optString, optString4, optString8, optString5, optString7, optString6);
            if (l != null) {
                l.t();
                l.v();
                dj0.c(pg0Var, optString3, optString2, optString4, "1");
                return;
            }
            dj0.b(pg0Var, false, hashMap);
            return;
        }
        dj0.b(pg0Var, false, hashMap);
    }

    public final void i(JSONObject jSONObject, @Nullable pg0 pg0Var) {
        Uri uri;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject, pg0Var) == null) || jSONObject == null) {
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
            ni0 l = l(optString, optString3, optString6, optString5, optString8, optString7);
            if (l != null) {
                ei0 t = l.t();
                l.v();
                if (t != null && (uri = t.k) != null) {
                    optString4 = uri.toString();
                }
                hashMap.put("data", dj0.a("0", "0", optString4, optString3));
                dj0.b(pg0Var, true, hashMap);
                return;
            }
            dj0.b(pg0Var, false, hashMap);
            return;
        }
        dj0.b(pg0Var, false, hashMap);
    }

    public final void j(JSONObject jSONObject, @Nullable pg0 pg0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, jSONObject, pg0Var) == null) || jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString(WebChromeClient.KEY_ARG_CALLBACK);
        String optString2 = jSONObject.optString("packageName", "");
        HashMap hashMap = new HashMap();
        hashMap.put(WebChromeClient.KEY_ARG_CALLBACK, optString);
        JSONObject jSONObject2 = new JSONObject();
        String str = "1";
        if (!TextUtils.isEmpty(optString2) && cj0.b(optString2)) {
            str = "0";
        }
        hx0.f(jSONObject2, "result", str);
        hashMap.put("data", jSONObject2.toString());
        if (pg0Var != null) {
            pg0Var.a(true, hashMap);
        }
    }

    public final ni0 l(String str, String str2, String str3, String str4, String str5, String str6) {
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
            ni0 ni0Var = this.a.get(str2);
            if (ni0Var == null && !TextUtils.isEmpty(str)) {
                ei0 a2 = a(str, str2, str3, dj0.d(str4));
                if (a2.q == null) {
                    a2.q = new fi0();
                }
                if (a2.p == null) {
                    a2.p = new hi0();
                }
                fi0 fi0Var = a2.q;
                fi0Var.b = str6;
                fi0Var.a = str5;
                if (!TextUtils.isEmpty(str4)) {
                    JSONObject c = hx0.c(str4);
                    a2.q.f = c.optInt("close_v_dl");
                    a2.q.b = c.optString("source");
                    a2.p.h = c.optString("app_name");
                    a2.p.g = c.optString("app_icon");
                    a2.p.i = c.optString("version");
                }
                ni0Var = new ni0(a2);
                this.a.put(str2, ni0Var);
            }
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                this.b.put(str2, str);
            }
            return ni0Var;
        }
        return (ni0) invokeCommon.objValue;
    }

    public final void m(JSONObject jSONObject, @Nullable pg0 pg0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048587, this, jSONObject, pg0Var) == null) || jSONObject == null) {
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
        ix0.e(this.c, optString4, optString2);
        HashMap hashMap = new HashMap();
        hashMap.put(WebChromeClient.KEY_ARG_CALLBACK, optString2);
        if (!TextUtils.isEmpty(optString6) && !TextUtils.isEmpty(optString7)) {
            ni0 l = l(optString, optString4, optString8, optString5, optString7, optString6);
            if (l != null) {
                l.x(optString3, optString2, optString7, optString6);
                dj0.b(pg0Var, true, hashMap);
                return;
            }
            dj0.b(pg0Var, false, hashMap);
            return;
        }
        dj0.b(pg0Var, false, hashMap);
    }

    public final void n(JSONObject jSONObject, @Nullable pg0 pg0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048588, this, jSONObject, pg0Var) == null) || jSONObject == null) {
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
        ix0.g(this.c, optString4);
        HashMap hashMap = new HashMap();
        hashMap.put(WebChromeClient.KEY_ARG_CALLBACK, optString2);
        if (!TextUtils.isEmpty(optString6) && !TextUtils.isEmpty(optString7)) {
            ni0 l = l(optString, optString4, optString8, optString5, optString7, optString6);
            if (l != null) {
                l.y(optString3, optString2, optString7, optString6);
                dj0.b(pg0Var, true, hashMap);
                return;
            }
            dj0.b(pg0Var, false, hashMap);
            return;
        }
        dj0.b(pg0Var, false, hashMap);
    }
}
