package d.a.l0.h.y;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.mobads.container.util.XAdRemoteEvent;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.facebook.common.internal.Sets;
import d.a.l0.a.a2.d;
import d.a.l0.a.a2.e;
import d.a.l0.a.k;
import d.a.l0.a.v2.q0;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends EventTargetImpl {

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f51393i = k.f46875a;
    public static final Set<String> j = Sets.newHashSet("REFERER", "USER-AGENT");
    public static final Set<String> k = Sets.newHashSet("localhost", "127.0.0.1");

    /* renamed from: e  reason: collision with root package name */
    public int f51394e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.l0.a.y.b.a f51395f;

    /* renamed from: g  reason: collision with root package name */
    public String f51396g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.l0.a.l0.c f51397h;

    /* renamed from: d.a.l0.h.y.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1113a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSEvent f51398e;

        public RunnableC1113a(JSEvent jSEvent) {
            this.f51398e = jSEvent;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.super.dispatchEvent(this.f51398e);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Object f51400e;

        public b(Object obj) {
            this.f51400e = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.l0.h.m0.c.a(a.this.f51395f, true, this.f51400e);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f51402e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f51403f;

        public c(String str, int i2) {
            this.f51402e = str;
            this.f51403f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.l0.h.y.f.b bVar = new d.a.l0.h.y.f.b();
            bVar.errMsg = this.f51402e;
            bVar.statusCode = this.f51403f;
            d.a.l0.h.m0.c.a(a.this.f51395f, false, bVar);
        }
    }

    public a(@NonNull d.a.l0.a.l0.c cVar, d.a.l0.a.y.b.a aVar) {
        super(cVar);
        this.f51394e = 0;
        this.f51397h = cVar;
        this.f51396g = A();
        this.f51395f = aVar;
    }

    public static void H(@NonNull Request.Builder builder, d.a.l0.a.y.b.a aVar, Map<String, String> map) {
        if (aVar == null || aVar.l() < 1) {
            return;
        }
        for (String str : aVar.k()) {
            if (!TextUtils.isEmpty(str) && !j.contains(str.toUpperCase(Locale.US))) {
                String f2 = q0.f(aVar.I(str));
                if (!TextUtils.isEmpty(f2)) {
                    if (map != null) {
                        map.put(str.toLowerCase(Locale.US), f2);
                    }
                    builder.header(str, f2);
                }
            }
        }
    }

    public String A() {
        String V = e.V();
        if (TextUtils.isEmpty(V)) {
            return "";
        }
        return V + "_" + System.currentTimeMillis();
    }

    public String B() {
        String C = this.f51395f.C("url");
        if (this.f51395f != null && !TextUtils.isEmpty(this.f51396g)) {
            if (TextUtils.isEmpty(C)) {
                E("", -1, "request:url is invalid");
                return null;
            } else if (e.i() == null) {
                E("", -1, "request:swanApp is null");
                return null;
            } else {
                HttpUrl G = G(C);
                if (G == null) {
                    E(C, -1, "request:url scheme is invalid");
                    return null;
                }
                String url = G.url().toString();
                int c2 = d.a.l0.a.b2.a.b.c("request", url, "");
                if (c2 != 0) {
                    if (c2 == 1) {
                        E(url, -1, "request:host not in white list");
                        return null;
                    } else if (c2 != 2) {
                        E(url, -1, "request:host not in white list");
                        return null;
                    } else {
                        E(url, -1, "request:url header must be https or wss");
                        return null;
                    }
                }
                return url;
            }
        }
        E("", 0, "request:swanApp is null");
        return null;
    }

    public boolean C(@Nullable HttpUrl httpUrl) {
        return (httpUrl == null || k.contains(httpUrl.host().toLowerCase(Locale.US))) ? false : true;
    }

    public String D() {
        e i2 = e.i();
        return i2 != null ? String.format("https://smartapp.baidu.com/%s/%s/page-frame.html", i2.D(), i2.K()) : "";
    }

    public void E(String str, int i2, String str2) {
        this.f51397h.postOnJSThread(new c(str2, i2));
    }

    public void F(Object obj) {
        this.f51397h.postOnJSThread(new b(obj));
    }

    public HttpUrl G(String str) {
        HttpUrl parse = HttpUrl.parse(str);
        if (d.g().x() == null) {
            if (C(parse)) {
                return parse;
            }
            return null;
        } else if ((f51393i && d.a.l0.a.u1.a.a.o()) || C(parse)) {
            return parse;
        } else {
            return null;
        }
    }

    public void I(@NonNull Request.Builder builder, d.a.l0.a.y.b.a aVar, Map<String, String> map, boolean z) {
        H(builder, aVar, map);
        if (z) {
            builder.header("Referer", D());
        }
    }

    public void J(d.a.l0.a.y.b.a aVar) {
        d.a.l0.a.y.b.a aVar2;
        if (aVar == null || (aVar2 = this.f51395f) == null) {
            return;
        }
        aVar2.H("success", aVar.v("success"));
        this.f51395f.H(com.baidu.pass.biometrics.face.liveness.b.b.g0, aVar.v(com.baidu.pass.biometrics.face.liveness.b.b.g0));
        this.f51395f.H(XAdRemoteEvent.COMPLETE, aVar.v(XAdRemoteEvent.COMPLETE));
    }

    public JSONObject K(Headers headers) throws JSONException {
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
        if (this.f51395f == null || e.i() == null) {
            return;
        }
        e.i().X().cancelTag(this.f51396g);
    }

    @Override // com.baidu.searchbox.v8engine.event.EventTargetImpl, com.baidu.searchbox.v8engine.event.EventTarget
    public boolean dispatchEvent(JSEvent jSEvent) {
        this.f51397h.postOnJSThread(new RunnableC1113a(jSEvent));
        return true;
    }
}
