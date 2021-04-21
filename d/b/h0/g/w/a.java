package d.b.h0.g.w;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.mobads.container.util.XAdRemoteEvent;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.facebook.common.internal.Sets;
import d.b.h0.a.i2.k0;
import d.b.h0.a.k;
import d.b.h0.a.r1.e;
import java.util.List;
import java.util.Map;
import java.util.Set;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends EventTargetImpl {
    public static final boolean i = k.f45772a;
    public static final Set<String> j = Sets.newHashSet("REFERER", "USER-AGENT");
    public static final Set<String> k = Sets.newHashSet("localhost", "127.0.0.1");

    /* renamed from: e  reason: collision with root package name */
    public int f49306e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.h0.g.e.d.c f49307f;

    /* renamed from: g  reason: collision with root package name */
    public String f49308g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.h0.g.i.b f49309h;

    /* renamed from: d.b.h0.g.w.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1027a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSEvent f49310e;

        public RunnableC1027a(JSEvent jSEvent) {
            this.f49310e = jSEvent;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.super.dispatchEvent(this.f49310e);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Object f49312e;

        public b(Object obj) {
            this.f49312e = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.h0.g.i0.b.a(a.this.f49307f, true, this.f49312e);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f49314e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f49315f;

        public c(String str, int i) {
            this.f49314e = str;
            this.f49315f = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.h0.g.w.g.b bVar = new d.b.h0.g.w.g.b();
            bVar.errMsg = this.f49314e;
            bVar.statusCode = this.f49315f;
            d.b.h0.g.i0.b.a(a.this.f49307f, false, bVar);
        }
    }

    public a(@NonNull d.b.h0.g.i.b bVar, d.b.h0.g.e.d.c cVar) {
        super(bVar);
        this.f49306e = 0;
        this.f49309h = bVar;
        this.f49308g = B();
        this.f49307f = cVar;
    }

    public static void I(@NonNull Request.Builder builder, d.b.h0.g.e.d.c cVar, Map<String, String> map) {
        if (cVar == null || cVar.l() < 1) {
            return;
        }
        for (String str : cVar.k()) {
            if (!TextUtils.isEmpty(str) && !j.contains(str.toUpperCase())) {
                String g2 = k0.g(cVar.H(str));
                if (!TextUtils.isEmpty(g2)) {
                    if (map != null) {
                        map.put(str.toLowerCase(), g2);
                    }
                    builder.header(str, g2);
                }
            }
        }
    }

    public String B() {
        String T = e.T();
        if (TextUtils.isEmpty(T)) {
            return "";
        }
        return T + "_" + System.currentTimeMillis();
    }

    public String C() {
        String B = this.f49307f.B("url");
        if (this.f49307f != null && !TextUtils.isEmpty(this.f49308g)) {
            if (TextUtils.isEmpty(B)) {
                F("", -1, "request:url is invalid");
                return null;
            } else if (e.y() == null) {
                F("", -1, "request:swanApp is null");
                return null;
            } else {
                HttpUrl H = H(B);
                if (H == null) {
                    F(B, -1, "request:url scheme is invalid");
                    return null;
                }
                String url = H.url().toString();
                int c2 = d.b.h0.a.s1.a.b.c("request", url, "");
                if (c2 != 0) {
                    if (c2 == 1) {
                        F(url, -1, "request:host not in white list");
                        return null;
                    } else if (c2 != 2) {
                        F(url, -1, "request:host not in white list");
                        return null;
                    } else {
                        F(url, -1, "request:url header must be https or wss");
                        return null;
                    }
                }
                return url;
            }
        }
        F("", 0, "request:swanApp is null");
        return null;
    }

    public boolean D(@Nullable HttpUrl httpUrl) {
        return (httpUrl == null || k.contains(httpUrl.host().toLowerCase())) ? false : true;
    }

    public String E() {
        e y = e.y();
        return y != null ? String.format("https://smartapp.baidu.com/%s/%s/page-frame.html", y.B(), y.I()) : "";
    }

    public void F(String str, int i2, String str2) {
        this.f49309h.postOnJSThread(new c(str2, i2));
    }

    public void G(Object obj) {
        this.f49309h.postOnJSThread(new b(obj));
    }

    public HttpUrl H(String str) {
        HttpUrl parse = HttpUrl.parse(str);
        if (d.b.h0.a.r1.d.e().n() == null) {
            if (D(parse)) {
                return parse;
            }
            return null;
        } else if ((i && d.b.h0.a.m1.a.a.m()) || D(parse)) {
            return parse;
        } else {
            return null;
        }
    }

    public void J(@NonNull Request.Builder builder, d.b.h0.g.e.d.c cVar, Map<String, String> map, boolean z) {
        I(builder, cVar, map);
        if (z) {
            builder.header("Referer", E());
        }
    }

    public void K(d.b.h0.g.e.d.c cVar) {
        d.b.h0.g.e.d.c cVar2;
        if (cVar == null || (cVar2 = this.f49307f) == null) {
            return;
        }
        cVar2.G("success", cVar.u("success"));
        this.f49307f.G("fail", cVar.u("fail"));
        this.f49307f.G(XAdRemoteEvent.COMPLETE, cVar.u(XAdRemoteEvent.COMPLETE));
    }

    public JSONObject L(Headers headers) throws JSONException {
        List<String> values;
        JSONObject jSONObject = new JSONObject();
        if (headers == null) {
            return jSONObject;
        }
        for (String str : headers.names()) {
            if (!TextUtils.isEmpty(str) && (values = headers.values(str)) != null) {
                StringBuilder sb = new StringBuilder();
                int size = values.size();
                for (int i2 = 0; i2 < size; i2++) {
                    sb.append(values.get(i2));
                    if (i2 == size - 1) {
                        break;
                    }
                    sb.append(",");
                }
                jSONObject.put(str, sb.toString());
            }
        }
        return jSONObject;
    }

    @JavascriptInterface
    public void abort() {
        if (this.f49307f == null || e.y() == null) {
            return;
        }
        e.y().V().cancelTag(this.f49308g);
    }

    @Override // com.baidu.searchbox.v8engine.event.EventTargetImpl, com.baidu.searchbox.v8engine.event.EventTarget
    public boolean dispatchEvent(JSEvent jSEvent) {
        this.f49309h.postOnJSThread(new RunnableC1027a(jSEvent));
        return true;
    }
}
