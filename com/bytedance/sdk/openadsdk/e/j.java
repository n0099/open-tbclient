package com.bytedance.sdk.openadsdk.e;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.core.widget.webview.a.e;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f68144a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f68145b;

    /* renamed from: c  reason: collision with root package name */
    public int f68146c;

    /* renamed from: d  reason: collision with root package name */
    public String f68147d;

    /* renamed from: e  reason: collision with root package name */
    public String f68148e;

    /* renamed from: f  reason: collision with root package name */
    public final Context f68149f;

    /* renamed from: g  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.core.e.m f68150g;

    /* renamed from: h  reason: collision with root package name */
    public String f68151h;

    /* renamed from: i  reason: collision with root package name */
    public long f68152i;

    /* renamed from: j  reason: collision with root package name */
    public long f68153j;
    public long k;
    public long l;
    public long m;
    public long n;
    public boolean o;
    public AtomicInteger p;
    public WebView q;
    public boolean r;
    public AtomicInteger s;
    public List<com.bytedance.sdk.openadsdk.core.e.d> t;
    public ConcurrentHashMap<String, com.bytedance.sdk.openadsdk.core.e.d> u;
    public String v;
    public JSONObject w;
    public q x;
    public AtomicBoolean y;
    public boolean z;

    /* renamed from: com.bytedance.sdk.openadsdk.e.j$1  reason: invalid class name */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j f68154a;

        public a(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68154a = jVar;
        }

        @JavascriptInterface
        public String getUrl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f68154a.v : (String) invokeV.objValue;
        }

        @JavascriptInterface
        public void readHtml(String str, String str2) {
            com.bytedance.sdk.openadsdk.core.e.d dVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return;
            }
            if (this.f68154a.u == null) {
                this.f68154a.u = new ConcurrentHashMap();
            }
            if (this.f68154a.u.containsKey(str)) {
                dVar = (com.bytedance.sdk.openadsdk.core.e.d) this.f68154a.u.get(str);
            } else {
                com.bytedance.sdk.openadsdk.core.e.d dVar2 = new com.bytedance.sdk.openadsdk.core.e.d();
                this.f68154a.u.put(str, dVar2);
                dVar2.a(str);
                dVar = dVar2;
            }
            dVar.b(str2);
            if (this.f68154a.t == null) {
                this.f68154a.t = new ArrayList();
            }
            this.f68154a.t.add(dVar);
        }

        @JavascriptInterface
        public void readPercent(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("measure height: ");
                int i2 = 0;
                sb.append(this.f68154a.q == null ? 0 : this.f68154a.q.getMeasuredHeight());
                com.bytedance.sdk.component.utils.k.b("LandingPageLog", sb.toString());
                com.bytedance.sdk.component.utils.k.b("LandingPageLog", "read percent: " + String.valueOf(str));
                try {
                    int intValue = Float.valueOf(str).intValue();
                    if (intValue > 100) {
                        i2 = 100;
                    } else if (intValue >= 0) {
                        i2 = intValue;
                    }
                } catch (Throwable unused) {
                }
                this.f68154a.p.set(i2);
            }
        }

        public /* synthetic */ a(j jVar, AnonymousClass1 anonymousClass1) {
            this(jVar);
        }
    }

    public j(Context context, com.bytedance.sdk.openadsdk.core.e.m mVar, WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, mVar, webView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f68144a = 1;
        this.f68145b = false;
        this.f68146c = -1;
        this.f68151h = "landingpage";
        this.f68152i = 0L;
        this.f68153j = 0L;
        this.k = 0L;
        this.l = 0L;
        this.m = 0L;
        this.n = 0L;
        this.o = false;
        this.p = new AtomicInteger(0);
        this.r = false;
        this.s = new AtomicInteger(0);
        this.v = "";
        this.y = new AtomicBoolean(false);
        this.z = false;
        this.f68149f = com.bytedance.sdk.openadsdk.core.o.a();
        this.f68150g = mVar;
        this.q = webView;
        this.t = new ArrayList();
        this.u = new ConcurrentHashMap<>();
        if (Build.VERSION.SDK_INT >= 17) {
            this.q.addJavascriptInterface(new a(this, null), "JS_LANDING_PAGE_LOG_OBJ");
        }
    }

    private void f() {
        List<com.bytedance.sdk.openadsdk.core.e.d> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65547, this) == null) || (list = this.t) == null || list.size() == 0) {
            return;
        }
        if (!com.bytedance.sdk.openadsdk.core.o.h().u() || com.bytedance.sdk.component.utils.n.c(com.bytedance.sdk.openadsdk.core.o.a()) == 4) {
            com.bytedance.sdk.openadsdk.j.a.a().a(this.t, this.f68150g, this.w);
        }
    }

    public q b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.x : (q) invokeV.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            com.bytedance.sdk.component.utils.k.b("LandingPageLog", "onResume");
            this.f68152i = System.currentTimeMillis();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            com.bytedance.sdk.component.utils.k.b("LandingPageLog", MissionEvent.MESSAGE_STOP);
            if (this.f68144a == 2) {
                if (this.k > 0 || !a()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    this.f68153j = currentTimeMillis;
                    long max = currentTimeMillis - Math.max(this.f68152i, this.k);
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("load_status", this.f68144a);
                        jSONObject.put("max_scroll_percent", this.p.get());
                        jSONObject.putOpt("render_type", "h5");
                        jSONObject.putOpt("render_type_2", 0);
                    } catch (JSONException unused) {
                    }
                    a("stay_page", jSONObject, Math.min(max, 600000L));
                }
            }
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            com.bytedance.sdk.component.utils.k.b("LandingPageLog", MissionEvent.MESSAGE_DESTROY);
            f();
            this.q = null;
            if (this.y.get() || !this.f68145b) {
                return;
            }
            d.b(this.f68149f, this.f68150g, this.f68151h, System.currentTimeMillis() - this.n);
        }
    }

    public j b(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048587, this, z)) == null) {
            this.r = z;
            return this;
        }
        return (j) invokeZ.objValue;
    }

    private boolean b(String str) {
        InterceptResult invokeL;
        com.bytedance.sdk.openadsdk.core.e.m mVar;
        com.bytedance.sdk.openadsdk.core.j.h h2;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, this, str)) == null) ? (TextUtils.isEmpty(str) || (mVar = this.f68150g) == null || mVar.s() == 0 || com.bytedance.sdk.openadsdk.core.widget.webview.a.e.a(str) != e.a.f67791a || (h2 = com.bytedance.sdk.openadsdk.core.o.h()) == null || h2.n() <= this.s.get()) ? false : true : invokeL.booleanValue;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.f68151h = str;
    }

    public void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
            this.k = j2;
        }
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.z : invokeV.booleanValue;
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.z = z;
        }
    }

    public void a(q qVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, qVar) == null) {
            this.x = qVar;
        }
    }

    public void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject) == null) {
            this.w = jSONObject;
        }
    }

    public void a(WebView webView, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, webView, i2) == null) {
            com.bytedance.sdk.component.utils.k.b("LandingPageLog", "onWebProgress: " + i2);
            if (this.l == 0 && i2 > 0) {
                this.l = System.currentTimeMillis();
            } else if (this.m == 0 && i2 == 100) {
                this.m = System.currentTimeMillis();
            }
        }
    }

    public void a(WebView webView, String str, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, webView, str, bitmap) == null) {
            com.bytedance.sdk.component.utils.k.b("LandingPageLog", "onWebStarted: " + String.valueOf(str));
            q qVar = this.x;
            if (qVar != null) {
                qVar.j();
            }
            if (this.f68145b) {
                return;
            }
            this.n = System.currentTimeMillis();
            this.f68145b = true;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("render_type", "h5");
                jSONObject.putOpt("render_type_2", 0);
            } catch (Exception unused) {
            }
            a("load_start", jSONObject);
        }
    }

    public void a(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, webView, str) == null) {
            com.bytedance.sdk.component.utils.k.b("LandingPageLog", "onWebFinished: " + String.valueOf(str));
            q qVar = this.x;
            if (qVar != null) {
                qVar.k();
            }
            if (webView != null && !this.o && this.r) {
                this.o = true;
                com.bytedance.sdk.component.utils.j.a(webView, "javascript:\n    function sendScroll() {\n        try {\n            var totalH = document.body.scrollHeight || document.documentElement.scrollHeight;\n            var clientH = window.innerHeight || document.documentElement.clientHeight;\n            var scrollH = document.body.scrollTop || document.documentElement.scrollTop;\n            var validH = scrollH + clientH;\n            var result = (validH / totalH * 100).toFixed(2);\n            console.log('LandingPageLogscroll status: (' + scrollH + '+' + clientH + ')/' + totalH + '=' + result);\n            window.JS_LANDING_PAGE_LOG_OBJ.readPercent(result);\n        } catch (e) {\n            console.log('sendScroll error' + e)\n        }\n    }\nsendScroll();\nwindow.addEventListener('scroll', function (e) {\n    sendScroll();\n});");
                if (b(str)) {
                    this.v = str;
                    com.bytedance.sdk.component.utils.j.a(webView, "javascript:var url = window.JS_LANDING_PAGE_LOG_OBJ.getUrl();window.JS_LANDING_PAGE_LOG_OBJ.readHtml(url,document.documentElement.outerHTML);");
                    this.s.incrementAndGet();
                }
            }
            if (this.y.get()) {
                return;
            }
            if (this.f68144a != 3) {
                this.f68144a = 2;
            }
            this.y.set(true);
            this.f68152i = System.currentTimeMillis();
            if (this.f68144a == 2) {
                long j2 = this.m - this.l;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("error_code", this.f68146c);
                    jSONObject.put("error_msg", this.f68147d);
                    jSONObject.put("error_url", this.f68148e);
                    jSONObject.putOpt("render_type", "h5");
                    jSONObject.putOpt("render_type_2", 0);
                } catch (Exception unused) {
                }
                a("load_finish", jSONObject, Math.min(j2, 600000L));
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("error_code", this.f68146c);
                jSONObject2.put("error_msg", this.f68147d);
                jSONObject2.put("error_url", this.f68148e);
                jSONObject2.putOpt("render_type", "h5");
                jSONObject2.putOpt("render_type_2", 0);
            } catch (Exception unused2) {
            }
            a("load_fail", jSONObject2);
        }
    }

    public void a(int i2, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, str2, str3}) == null) {
            com.bytedance.sdk.component.utils.k.b("LandingPageLog", "onWebError: " + i2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + str2 + "，" + str3);
            q qVar = this.x;
            if (qVar != null) {
                qVar.l();
            }
            if (!(str3 != null && str3.startsWith("image")) && this.f68144a != 2) {
                this.f68144a = 3;
            }
            this.f68146c = i2;
            this.f68147d = str;
            this.f68148e = str2;
        }
    }

    @RequiresApi(api = 21)
    public void a(WebView webView, WebResourceRequest webResourceRequest) {
        com.bytedance.sdk.openadsdk.core.e.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, webView, webResourceRequest) == null) || webResourceRequest == null || TextUtils.isEmpty(webResourceRequest.getUrl().toString())) {
            return;
        }
        String uri = webResourceRequest.getUrl().toString();
        if (b(uri)) {
            if (this.u == null) {
                this.u = new ConcurrentHashMap<>();
            }
            if (this.u.containsKey(uri)) {
                dVar = this.u.get(uri);
            } else {
                com.bytedance.sdk.openadsdk.core.e.d dVar2 = new com.bytedance.sdk.openadsdk.core.e.d();
                this.u.put(uri, dVar2);
                dVar2.a(uri);
                dVar = dVar2;
            }
            dVar.a(webResourceRequest.getRequestHeaders());
        }
    }

    private void a(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, str, jSONObject) == null) {
            a(str, jSONObject, -1L);
        }
    }

    private void a(String str, JSONObject jSONObject, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, this, new Object[]{str, jSONObject, Long.valueOf(j2)}) == null) || !this.r || this.f68150g == null || TextUtils.isEmpty(str)) {
            return;
        }
        JSONObject jSONObject2 = null;
        if (jSONObject != null) {
            try {
                int i2 = 1;
                jSONObject.put("is_playable", com.bytedance.sdk.openadsdk.core.e.o.a(this.f68150g) ? 1 : 0);
                if (!com.bytedance.sdk.openadsdk.core.h.a.a().a(this.f68150g)) {
                    i2 = 0;
                }
                jSONObject.put("usecache", i2);
            } catch (JSONException unused) {
            }
            try {
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("ad_extra_data", jSONObject.toString());
                    if (j2 > 0) {
                        jSONObject3.put("duration", j2);
                    }
                } catch (JSONException unused2) {
                }
                jSONObject2 = jSONObject3;
            } catch (JSONException unused3) {
            }
        }
        com.bytedance.sdk.component.utils.k.b("LandingPageLog", "sendEvent: " + String.valueOf(this.f68151h) + StringUtil.ARRAY_ELEMENT_SEPARATOR + String.valueOf(str) + ", ext=" + String.valueOf(jSONObject2));
        d.d(this.f68149f, this.f68150g, this.f68151h, str, jSONObject2);
    }
}
