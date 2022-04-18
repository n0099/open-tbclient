package com.repackage;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.nad.jni.NADNativeHelper;
import com.baidu.nadcore.net.request.Headers;
import com.baidu.prologue.business.data.BaseVM;
import com.baidu.prologue.business.data.ParseError;
import com.baidu.sofire.d.D;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tbadk.util.AdExtParam;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import com.qq.e.comm.constants.Constants;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class qa1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Handler a;
    public ra1 b;
    public int c;
    public volatile boolean d;

    /* loaded from: classes7.dex */
    public class a extends jp0<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ long b;
        public final /* synthetic */ long c;

        public a(qa1 qa1Var, String str, long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qa1Var, str, Long.valueOf(j), Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = j;
            this.c = j2;
        }

        @Override // com.repackage.hp0
        public void a(Exception exc, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, exc, i) == null) {
                BaseVM.m(this.a, this.b, this.c, exc.getMessage(), "update");
            }
        }

        @Override // com.repackage.ip0
        public /* bridge */ /* synthetic */ Object d(Headers headers, String str, int i) throws Exception {
            f(headers, str, i);
            return str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ip0
        /* renamed from: e */
        public void b(Headers headers, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048579, this, headers, str, i) == null) {
                BaseVM.m(this.a, this.b, this.c, BasicPushStatus.SUCCESS_CODE, "update");
                try {
                    va1.b(str, this.a);
                } catch (ParseError e) {
                    e.printStackTrace();
                }
            }
        }

        public String f(Headers headers, String str, int i) throws Exception {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, headers, str, i)) == null) ? str : (String) invokeLLI.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b extends jp0<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ long b;
        public final /* synthetic */ long c;
        public final /* synthetic */ ra1 d;
        public final /* synthetic */ qa1 e;

        public b(qa1 qa1Var, String str, long j, long j2, ra1 ra1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qa1Var, str, Long.valueOf(j), Long.valueOf(j2), ra1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = qa1Var;
            this.a = str;
            this.b = j;
            this.c = j2;
            this.d = ra1Var;
        }

        @Override // com.repackage.hp0
        public void a(Exception exc, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, exc, i) == null) {
                BaseVM.m(this.a, this.b, this.c, exc.getMessage(), "query");
                if (this.e.d || this.e.a == null) {
                    return;
                }
                this.e.a.removeCallbacksAndMessages(null);
                this.e.a.post(new c(this.e, this.a));
            }
        }

        @Override // com.repackage.ip0
        public /* bridge */ /* synthetic */ Object d(Headers headers, String str, int i) throws Exception {
            f(headers, str, i);
            return str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ip0
        /* renamed from: e */
        public void b(Headers headers, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048579, this, headers, str, i) == null) {
                BaseVM.m(this.a, this.b, this.c, BasicPushStatus.SUCCESS_CODE, "query");
                if (this.e.d) {
                    return;
                }
                this.e.a.removeCallbacksAndMessages(null);
                try {
                    List<bb1> b = va1.b(str, this.a);
                    if (b != null && b.size() > 0 && b.get(0) != null) {
                        this.d.b(b.get(0));
                    } else {
                        this.d.a(new Throwable("no ad"));
                    }
                } catch (ParseError e) {
                    e.printStackTrace();
                    this.d.a(e);
                }
            }
        }

        public String f(Headers headers, String str, int i) throws Exception {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, headers, str, i)) == null) ? str : (String) invokeLLI.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qa1 a;

        public c(qa1 qa1Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qa1Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qa1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.d = true;
                bb1 m = za1.m();
                if (this.a.b == null) {
                    return;
                }
                if (m == null) {
                    this.a.b.a(new Throwable("no ad"));
                    return;
                }
                m.C = 2;
                this.a.b.b(m);
            }
        }
    }

    public qa1() {
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
        this.a = new Handler(Looper.getMainLooper());
        this.c = 5000;
        this.d = false;
    }

    public final void e(JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || oa1.a().d() == null || !oa1.a().d().has("client_ext") || (optJSONObject = oa1.a().d().optJSONObject("client_ext")) == null) {
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

    public final void f(HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hashMap) == null) {
            oi0 a2 = hi0.a();
            hashMap.put("ver", a2.q());
            hashMap.put("sv", "1.0");
            hashMap.put("uid", a2.m());
            hashMap.put(TiebaStatic.Params.BDID, a2.g());
            hashMap.put("cuid", a2.b());
            hashMap.put(SearchJsBridge.COOKIE_MOD, a2.j());
            hashMap.put(SearchJsBridge.COOKIE_OV, a2.c());
            hashMap.put("imei", a2.p());
            hashMap.put("ua", a2.i());
            hashMap.put("fmt", "json");
            hashMap.put("apna", a2.packageName());
            hashMap.put("eid", a2.d());
            hashMap.put("st", "1");
            hashMap.put("ot", "2");
            hashMap.put("nt", String.valueOf(new fp0().c()));
            hashMap.put(Config.EXCEPTION_CRASH_TYPE, "2");
            hashMap.put("is_https", "1");
            hashMap.put(HttpRequest.ANDROID_ID, a2.a());
            hashMap.put("from", oa1.a().from());
            hashMap.put("cfrom", oa1.a().a());
            hashMap.put("User-Agent", hi0.e());
            if (TextUtils.isEmpty(a2.h())) {
                return;
            }
            hashMap.put("oaid", a2.h());
        }
    }

    public final void g(@NonNull HashMap<String, String> hashMap, String str, String str2, long j) {
        Iterator<bb1> it;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{hashMap, str, str2, Long.valueOf(j)}) != null) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            new JSONObject();
            if (u8.f().h()) {
                jSONObject.put("k", "cmd");
                jSONObject.put("v", str2);
                jSONArray.put(jSONObject);
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("k", AdExtParam.KEY_NAD_CORE_VERSION);
            jSONObject2.put("v", "5.2.0.3");
            jSONArray.put(jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            List<bb1> r = za1.r();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            JSONArray jSONArray2 = new JSONArray();
            TextUtils.equals(str, oa1.a().e());
            int i = 0;
            if (r != null && r.size() > 0) {
                Iterator<bb1> it2 = r.iterator();
                while (it2.hasNext()) {
                    bb1 next = it2.next();
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("k", next.c);
                    if (TextUtils.isEmpty(next.c)) {
                        it = it2;
                    } else {
                        int e = za1.e(next);
                        StringBuilder sb = new StringBuilder();
                        it = it2;
                        sb.append("onAdSuccess: ");
                        sb.append(e);
                        Log.e("Afd", sb.toString());
                        if (e == 0) {
                            if (next.h()) {
                                ty0.b(arrayList2, next.c);
                            }
                            if (next.f()) {
                                ty0.b(arrayList, next.c);
                            }
                        } else if (next.h()) {
                            i |= e;
                        }
                    }
                    jSONObject4.put("r", String.valueOf(next.w));
                    if (next.h()) {
                        jSONArray2.put(jSONObject4);
                    }
                    it2 = it;
                }
            }
            jSONObject3.put("d", jSONArray2);
            jSONObject3.put("s", db1.d());
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
                    BaseVM.c = String.valueOf(i);
                } else {
                    BaseVM.c = "";
                }
            }
            JSONObject jSONObject7 = new JSONObject();
            jSONObject7.put("k", "logid");
            jSONObject7.put("v", String.valueOf(j));
            jSONArray.put(jSONObject7);
            JSONObject jSONObject8 = new JSONObject();
            jSONObject8.put("k", "uid");
            jSONObject8.put("v", hi0.a().m());
            jSONArray.put(jSONObject8);
            JSONObject jSONObject9 = new JSONObject();
            jSONObject9.put("k", "ext_info");
            JSONObject jSONObject10 = new JSONObject();
            jSONObject10.put("ipdx", fm0.a().a());
            jSONObject10.put("update_mark", NADNativeHelper.b());
            jSONObject10.put("boot_mark", NADNativeHelper.a());
            try {
                e(jSONObject10);
                jSONObject10.put(Constants.KEYS.AD_INFO, jSONObject3);
                jSONObject9.put("v", jSONObject10.toString());
                jSONObject9.put(AdExtParam.KEY_IADEX, hi0.d().f());
                jSONArray.put(jSONObject9);
                hashMap.put("ext", jSONArray.toString());
            } catch (JSONException e2) {
                e = e2;
                e.printStackTrace();
            }
        } catch (JSONException e3) {
            e = e3;
        }
    }

    public final String h(String str, Map<String, String> map) {
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

    public final qp0 i(String str, String str2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{str, str2, Long.valueOf(j)})) == null) {
            String a2 = ka1.a();
            StringBuilder sb = new StringBuilder();
            sb.append(a2);
            sb.append(TextUtils.equals(str, "update") ? "?action=update" : "?action=query");
            String sb2 = sb.toString();
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(D.COLUMN_PLUGIN_ACTIVITY_INFO_LIST, TextUtils.equals(str, "update") ? String.valueOf(ab1.p()) : "1");
            hashMap.put("pid", str2);
            hashMap.put("product_id ", hi0.a().l());
            f(hashMap);
            g(hashMap, str2, str, j);
            qp0 qp0Var = new qp0();
            qp0Var.k(h(sb2, hashMap));
            qp0Var.c();
            return qp0Var;
        }
        return (qp0) invokeCommon.objValue;
    }

    public void j(String str, ra1 ra1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, ra1Var) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            wa1.a(String.valueOf(currentTimeMillis));
            qp0 i = i("query", str, currentTimeMillis);
            i.f = this.c;
            JSONObject d = oa1.a().d();
            if (d != null && d.has("query_response_thread")) {
                i.h(d.optInt("query_response_thread", 0) == 0);
            }
            yo0.b().a().a(i, new b(this, str, currentTimeMillis, System.currentTimeMillis(), ra1Var));
            this.b = ra1Var;
            this.d = false;
            this.c = oa1.a().f() - ab1.n();
            Handler handler = this.a;
            if (handler != null) {
                handler.postDelayed(new c(this, str), this.c);
            }
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            String optString = oa1.a().d().optString("na_cpc_update_pid");
            if (TextUtils.isEmpty(optString)) {
                optString = oa1.a().e();
            }
            String str = optString;
            yo0.b().a().a(i("update", str, currentTimeMillis), new a(this, str, currentTimeMillis, System.currentTimeMillis()));
        }
    }
}
