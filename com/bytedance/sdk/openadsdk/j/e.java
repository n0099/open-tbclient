package com.bytedance.sdk.openadsdk.j;

import android.content.Context;
import android.view.ViewTreeObserver;
import android.webkit.WebView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public Context f29307a;

    /* renamed from: b  reason: collision with root package name */
    public WeakReference<WebView> f29308b;

    /* renamed from: d  reason: collision with root package name */
    public a f29310d;

    /* renamed from: h  reason: collision with root package name */
    public String f29314h;

    /* renamed from: i  reason: collision with root package name */
    public String f29315i;
    public String j;
    public JSONObject l;
    public JSONObject m;
    public String n;
    public boolean o;
    public boolean p;
    public boolean q;

    /* renamed from: e  reason: collision with root package name */
    public int f29311e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f29312f = 0;

    /* renamed from: g  reason: collision with root package name */
    public JSONObject f29313g = new JSONObject();
    public Map<String, String> k = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public c f29309c = new c(this);

    public e(Context context, final WebView webView, a aVar) {
        this.f29307a = context;
        this.f29308b = new WeakReference<>(webView);
        this.f29310d = aVar;
        f.a(webView);
        webView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.sdk.openadsdk.j.e.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                try {
                    if (e.this.f29311e == webView.getWidth() && e.this.f29312f == webView.getHeight()) {
                        return;
                    }
                    e.this.f29311e = webView.getWidth();
                    e.this.f29312f = webView.getHeight();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("width", e.this.f29311e);
                    jSONObject.put("height", e.this.f29312f);
                    e.this.a("resize", jSONObject);
                    e.this.f29313g = jSONObject;
                } catch (Throwable th) {
                    d.a("PlayablePlugin", "onSizeChanged error", th);
                }
            }
        });
    }

    public JSONObject c() {
        return this.m;
    }

    public String d() {
        return this.f29315i;
    }

    public String e() {
        return this.f29314h;
    }

    public String f() {
        return this.j;
    }

    public String g() {
        return this.n;
    }

    public boolean h() {
        return this.o;
    }

    public boolean i() {
        return this.p;
    }

    public Set<String> j() {
        return this.f29309c.a();
    }

    public b k() {
        return this.f29310d.a();
    }

    public a l() {
        return this.f29310d;
    }

    public JSONObject m() {
        return this.f29313g;
    }

    public JSONObject n() {
        return this.l;
    }

    public void o() {
        this.f29310d.b();
    }

    public void p() {
        b(false);
    }

    public void q() {
        b(true);
    }

    public void r() {
        try {
            this.f29309c.b();
        } catch (Throwable unused) {
        }
    }

    public e c(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("playable_style", str);
            this.m = jSONObject;
        } catch (Throwable th) {
            d.a("PlayablePlugin", "setPlayableStyle error", th);
        }
        return this;
    }

    public e d(String str) {
        this.j = str;
        return this;
    }

    public e e(String str) {
        this.n = str;
        return this;
    }

    public Map<String, String> b() {
        return this.k;
    }

    public Context a() {
        return this.f29307a;
    }

    public e b(String str) {
        this.f29315i = str;
        return this;
    }

    public e a(String str, String str2) {
        this.k.put(str, str2);
        return this;
    }

    public e b(boolean z) {
        this.p = z;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("viewStatus", this.p);
            a("viewableChange", jSONObject);
        } catch (Throwable th) {
            d.a("PlayablePlugin", "setViewable error", th);
        }
        return this;
    }

    public e a(String str) {
        this.f29314h = str;
        return this;
    }

    public e c(boolean z) {
        this.q = z;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("send_click", this.q);
            a("change_playable_click", jSONObject);
        } catch (Throwable th) {
            d.a("PlayablePlugin", "setPlayableClick error", th);
        }
        return this;
    }

    public e a(boolean z) {
        this.o = z;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("endcard_mute", this.o);
            a("volumeChange", jSONObject);
        } catch (Throwable th) {
            d.a("PlayablePlugin", "setIsMute error", th);
        }
        return this;
    }

    public JSONObject b(String str, JSONObject jSONObject) {
        long currentTimeMillis = System.currentTimeMillis();
        if (d.a()) {
            StringBuilder sb = new StringBuilder();
            sb.append("PlayablePlugin JSB-REQ [");
            sb.append(str);
            sb.append("] ");
            sb.append(jSONObject != null ? jSONObject.toString() : "");
            d.a("PlayablePlugin", sb.toString());
        }
        JSONObject a2 = this.f29309c.a(str, jSONObject);
        if (d.a()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("PlayablePlugin JSB-RSP [");
            sb2.append(str);
            sb2.append("] time:");
            sb2.append(System.currentTimeMillis() - currentTimeMillis);
            sb2.append(" ");
            sb2.append(a2 != null ? a2.toString() : "");
            d.a("PlayablePlugin", sb2.toString());
        }
        return a2;
    }

    public void a(String str, JSONObject jSONObject) {
        if (d.a()) {
            StringBuilder sb = new StringBuilder();
            sb.append("CALL JS [");
            sb.append(str);
            sb.append("] ");
            sb.append(jSONObject != null ? jSONObject.toString() : "");
            d.a("PlayablePlugin", sb.toString());
        }
        this.f29310d.a(str, jSONObject);
    }

    public static e a(Context context, WebView webView, a aVar) {
        if (webView == null || aVar == null) {
            return null;
        }
        return new e(context, webView, aVar);
    }
}
