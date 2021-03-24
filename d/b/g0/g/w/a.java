package d.b.g0.g.w;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.facebook.common.internal.Sets;
import d.b.g0.a.i2.k0;
import d.b.g0.a.k;
import d.b.g0.a.r1.e;
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
    public static final boolean i = k.f45050a;
    public static final Set<String> j = Sets.newHashSet("REFERER", "USER-AGENT");
    public static final Set<String> k = Sets.newHashSet("localhost", "127.0.0.1");

    /* renamed from: e  reason: collision with root package name */
    public int f48584e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.g0.g.e.d.c f48585f;

    /* renamed from: g  reason: collision with root package name */
    public String f48586g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.g0.g.i.b f48587h;

    /* renamed from: d.b.g0.g.w.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0994a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSEvent f48588e;

        public RunnableC0994a(JSEvent jSEvent) {
            this.f48588e = jSEvent;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.super.dispatchEvent(this.f48588e);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Object f48590e;

        public b(Object obj) {
            this.f48590e = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.g0.g.i0.b.a(a.this.f48585f, true, this.f48590e);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48592e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f48593f;

        public c(String str, int i) {
            this.f48592e = str;
            this.f48593f = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.g0.g.w.g.b bVar = new d.b.g0.g.w.g.b();
            bVar.errMsg = this.f48592e;
            bVar.statusCode = this.f48593f;
            d.b.g0.g.i0.b.a(a.this.f48585f, false, bVar);
        }
    }

    public a(@NonNull d.b.g0.g.i.b bVar, d.b.g0.g.e.d.c cVar) {
        super(bVar);
        this.f48584e = 0;
        this.f48587h = bVar;
        this.f48586g = B();
        this.f48585f = cVar;
    }

    public static void I(@NonNull Request.Builder builder, d.b.g0.g.e.d.c cVar, Map<String, String> map) {
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
        String B = this.f48585f.B("url");
        if (this.f48585f != null && !TextUtils.isEmpty(this.f48586g)) {
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
                int c2 = d.b.g0.a.s1.a.b.c("request", url, "");
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
        this.f48587h.postOnJSThread(new c(str2, i2));
    }

    public void G(Object obj) {
        this.f48587h.postOnJSThread(new b(obj));
    }

    public HttpUrl H(String str) {
        HttpUrl parse = HttpUrl.parse(str);
        if (d.b.g0.a.r1.d.e().n() == null) {
            if (D(parse)) {
                return parse;
            }
            return null;
        } else if ((i && d.b.g0.a.m1.a.a.m()) || D(parse)) {
            return parse;
        } else {
            return null;
        }
    }

    public void J(@NonNull Request.Builder builder, d.b.g0.g.e.d.c cVar, Map<String, String> map, boolean z) {
        I(builder, cVar, map);
        if (z) {
            builder.header("Referer", E());
        }
    }

    public void K(d.b.g0.g.e.d.c cVar) {
        d.b.g0.g.e.d.c cVar2;
        if (cVar == null || (cVar2 = this.f48585f) == null) {
            return;
        }
        cVar2.G("success", cVar.u("success"));
        this.f48585f.G("fail", cVar.u("fail"));
        this.f48585f.G("complete", cVar.u("complete"));
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
        if (this.f48585f == null || e.y() == null) {
            return;
        }
        e.y().V().cancelTag(this.f48586g);
    }

    @Override // com.baidu.searchbox.v8engine.event.EventTargetImpl, com.baidu.searchbox.v8engine.event.EventTarget
    public boolean dispatchEvent(JSEvent jSEvent) {
        this.f48587h.postOnJSThread(new RunnableC0994a(jSEvent));
        return true;
    }
}
