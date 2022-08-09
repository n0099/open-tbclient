package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.nad.jni.NADNativeHelper;
import com.baidu.prologue.business.data.BaseVM;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tbadk.core.atomData.AbsMsgImageActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tbadk.util.AdExtParam;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.comm.constants.Constants;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class nb1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ nb1 b;

        public a(nb1 nb1Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nb1Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nb1Var;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                String f = this.b.f(this.a, currentTimeMillis);
                String f2 = this.b.f(this.a, 86400000 + currentTimeMillis);
                String f3 = this.b.f(this.a, 172800000 + currentTimeMillis);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(AbsMsgImageActivityConfig.CURRENT_URL, f);
                    jSONObject.put("tomorrow_url", f2);
                    jSONObject.put("after_tomorrow_url", f3);
                    jSONObject.put("cache_time", currentTimeMillis);
                } catch (JSONException unused) {
                }
                ey0.a().b("splash_sp_name").j("splash_query_cache_url", jSONObject.toString(), false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final nb1 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-162378474, "Lcom/repackage/nb1$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-162378474, "Lcom/repackage/nb1$b;");
                    return;
                }
            }
            a = new nb1(null);
        }
    }

    public /* synthetic */ nb1(a aVar) {
        this();
    }

    public static nb1 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b.a : (nb1) invokeV.objValue;
    }

    public final void a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || cb1.a().d() == null || !cb1.a().d().has("client_ext") || (optJSONObject = cb1.a().d().optJSONObject("client_ext")) == null) {
            return;
        }
        Iterator<String> keys = optJSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                jSONObject.put(next, optJSONObject.opt(next));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public final void b(HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hashMap) == null) {
            lh0 a2 = dh0.a();
            hashMap.put("ver", TextUtils.isEmpty(a2.k()) ? a2.t() : a2.k());
            hashMap.put("sv", "1.0");
            hashMap.put("uid", a2.p());
            hashMap.put(TiebaStatic.Params.BDID, a2.i());
            hashMap.put("cuid", a2.b());
            hashMap.put(SearchJsBridge.COOKIE_MOD, a2.m());
            hashMap.put("ov", a2.c());
            hashMap.put("imei", a2.s());
            hashMap.put("ua", a2.l());
            hashMap.put("fmt", "json");
            hashMap.put("apna", a2.packageName());
            hashMap.put("eid", a2.d());
            hashMap.put("st", "1");
            hashMap.put("ot", "2");
            hashMap.put("nt", String.valueOf(new ho0().c()));
            hashMap.put(Config.EXCEPTION_CRASH_TYPE, "2");
            hashMap.put("is_https", "1");
            hashMap.put(HttpRequest.ANDROID_ID, a2.a());
            hashMap.put("from", cb1.a().from());
            hashMap.put("cfrom", cb1.a().a());
            hashMap.put("User-Agent", dh0.e());
        }
    }

    public final void c(@NonNull HashMap<String, String> hashMap, String str, String str2, long j) {
        nb1 nb1Var;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{hashMap, str, str2, Long.valueOf(j)}) != null) {
            return;
        }
        long j2 = j;
        try {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            if (w8.f().h()) {
                jSONObject.put("k", "cmd");
                jSONObject.put("v", str2);
                jSONArray.put(jSONObject);
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("k", AdExtParam.KEY_NAD_CORE_VERSION);
            jSONObject2.put("v", "5.7.0.18");
            jSONArray.put(jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            List<qb1> t = ob1.t();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            JSONArray jSONArray2 = new JSONArray();
            int i = 0;
            if (t != null) {
                try {
                    if (t.size() > 0) {
                        Iterator<qb1> it = t.iterator();
                        while (it.hasNext()) {
                            qb1 next = it.next();
                            JSONObject jSONObject4 = new JSONObject();
                            Iterator<qb1> it2 = it;
                            jSONObject4.put("k", next.c);
                            if (!TextUtils.isEmpty(next.c)) {
                                int g = ob1.g(next, j2);
                                Log.e("RequestUrlManager", "onAdSuccess: " + g);
                                if (g == 0) {
                                    if (next.h()) {
                                        wx0.b(arrayList2, next.c);
                                    }
                                    if (next.f()) {
                                        wx0.b(arrayList, next.c);
                                    }
                                } else if (next.h()) {
                                    i |= g;
                                }
                            }
                            jSONObject4.put("r", String.valueOf(next.x));
                            if (next.h()) {
                                jSONArray2.put(jSONObject4);
                            }
                            it = it2;
                            j2 = j;
                        }
                    }
                } catch (JSONException e) {
                    e = e;
                    e.printStackTrace();
                    return;
                }
            }
            jSONObject3.put("d", jSONArray2);
            jSONObject3.put("s", sb1.d());
            jSONArray.put(new JSONObject());
            if (TextUtils.equals(str2, "query")) {
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("k", "ukey");
                jSONObject5.put("v", TextUtils.join(",", arrayList));
                jSONArray.put(jSONObject5);
                JSONObject jSONObject6 = new JSONObject();
                jSONObject6.put("k", "xz_ukey");
                jSONObject6.put("v", TextUtils.join(",", arrayList2));
                jSONArray.put(jSONObject6);
                if (arrayList2.isEmpty()) {
                    if (i == 0) {
                        i = 1;
                    }
                    String valueOf = String.valueOf(i);
                    BaseVM.c = valueOf;
                    nb1Var = this;
                    nb1Var.n(j, valueOf);
                } else {
                    nb1Var = this;
                    BaseVM.c = "";
                }
            } else {
                nb1Var = this;
            }
            JSONObject jSONObject7 = new JSONObject();
            jSONObject7.put("k", "logid");
            jSONObject7.put("v", String.valueOf(j));
            jSONArray.put(jSONObject7);
            JSONObject jSONObject8 = new JSONObject();
            jSONObject8.put("k", "uid");
            jSONObject8.put("v", dh0.a().p());
            jSONArray.put(jSONObject8);
            JSONObject jSONObject9 = new JSONObject();
            jSONObject9.put("k", "ext_info");
            JSONObject jSONObject10 = new JSONObject();
            jSONObject10.put("ipdx", gl0.a().a());
            jSONObject10.put("update_mark", NADNativeHelper.b());
            jSONObject10.put("boot_mark", NADNativeHelper.a());
            nb1Var.a(jSONObject10);
            jSONObject10.put(Constants.KEYS.AD_INFO, jSONObject3);
            jSONObject9.put("v", jSONObject10.toString());
            jSONArray.put(jSONObject9);
            JSONObject jSONObject11 = new JSONObject();
            jSONObject11.put("k", AdExtParam.KEY_IADEX);
            jSONObject11.put("v", dh0.d().h());
            jSONArray.put(jSONObject11);
            JSONObject jSONObject12 = new JSONObject();
            jSONObject12.put("k", "oaid_v");
            jSONObject12.put("v", dh0.d().j());
            jSONArray.put(jSONObject12);
            try {
                JSONObject jSONObject13 = new JSONObject();
                jSONObject13.put("k", "encoded_ua_new");
                jSONObject13.put("v", URLEncoder.encode(dh0.e(), IMAudioTransRequest.CHARSET));
                jSONArray.put(jSONObject13);
            } catch (UnsupportedEncodingException unused) {
            }
            hashMap.put("ext", jSONArray.toString());
        } catch (JSONException e2) {
            e = e2;
        }
    }

    public final String d(String str, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, map)) == null) {
            if (map != null && map.size() != 0) {
                URI create = URI.create(str);
                StringBuilder sb = new StringBuilder(TextUtils.isEmpty(create.getQuery()) ? "" : create.getQuery());
                if (sb.length() > 0) {
                    sb.append('&');
                }
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    sb.append(entry.getKey());
                    sb.append("=");
                    sb.append(entry.getValue());
                    sb.append('&');
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                try {
                    return new URI(create.getScheme(), create.getAuthority(), create.getPath(), sb.toString(), create.getFragment()).toString();
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
            }
            return str;
        }
        return (String) invokeLL.objValue;
    }

    public String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) ? f(str, System.currentTimeMillis()) : (String) invokeL.objValue;
    }

    public String f(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048581, this, str, j)) == null) {
            String a2 = ya1.a();
            StringBuilder sb = new StringBuilder();
            sb.append(a2);
            sb.append(TextUtils.equals(str, "update") ? "?action=update" : "?action=query");
            String sb2 = sb.toString();
            String i = i(str);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("ac", TextUtils.equals(str, "update") ? String.valueOf(pb1.o()) : "1");
            hashMap.put("pid", i);
            hashMap.put("product_id ", dh0.a().o());
            b(hashMap);
            c(hashMap, i, str, j);
            return d(sb2, hashMap);
        }
        return (String) invokeLJ.objValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && pb1.s()) {
            h("query");
        }
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            fz0.d(new a(this, str), "cache splash request url");
        }
    }

    public final String i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            if (TextUtils.equals(str, "update")) {
                String optString = cb1.a().d().optString("na_cpc_update_pid");
                return !TextUtils.isEmpty(optString) ? optString : cb1.a().e();
            }
            return pb1.l();
        }
        return (String) invokeL.objValue;
    }

    public final String j(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048585, this, j)) == null) {
            int a2 = o01.a(j, System.currentTimeMillis());
            if (a2 >= 2) {
                return ey0.a().b("splash_sp_name").getString("after_tomorrow_reason", "");
            }
            if (a2 == 1) {
                return ey0.a().b("splash_sp_name").getString("tomorrow_reason", "");
            }
            return ey0.a().b("splash_sp_name").getString("current_reason", "");
        }
        return (String) invokeJ.objValue;
    }

    public String k(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            if (TextUtils.equals(str, "query")) {
                str2 = l(str);
                Log.d("RequestUrlManager", " getQueryUrl from cache url ： " + str2);
            } else {
                str2 = "";
            }
            if (TextUtils.isEmpty(str2)) {
                String e = e(str);
                Log.d("RequestUrlManager", " getQueryUrl NOCache url ： " + e);
                return e;
            }
            return str2;
        }
        return (String) invokeL.objValue;
    }

    public String l(String str) {
        InterceptResult invokeL;
        String optString;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            String string = ey0.a().b("splash_sp_name").getString("splash_query_cache_url", "");
            if (TextUtils.isEmpty(string)) {
                return "";
            }
            try {
                JSONObject jSONObject = new JSONObject(string);
                long optLong = jSONObject.optLong("cache_time");
                int a2 = o01.a(optLong, System.currentTimeMillis());
                if (a2 >= 2) {
                    optString = jSONObject.optString("after_tomorrow_url");
                } else if (a2 == 1) {
                    optString = jSONObject.optString("tomorrow_url");
                } else {
                    optString = jSONObject.optString(AbsMsgImageActivityConfig.CURRENT_URL);
                }
                String str2 = optString;
                if (TextUtils.isEmpty(str2)) {
                    return str2;
                }
                BaseVM.c = j(optLong);
                if (te0.a) {
                    return str2 + "&cache_time=" + (optLong / 1000);
                }
                return str2;
            } catch (JSONException unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public final void n(long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048588, this, j, str) == null) {
            int a2 = o01.a(System.currentTimeMillis(), j);
            if (a2 >= 2) {
                ey0.a().b("splash_sp_name").i("after_tomorrow_reason", str);
            } else if (a2 == 1) {
                ey0.a().b("splash_sp_name").i("tomorrow_reason", str);
            } else {
                ey0.a().b("splash_sp_name").i("current_reason", str);
            }
        }
    }

    public nb1() {
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
}
