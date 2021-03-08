package com.bytedance.sdk.openadsdk.playable;

import android.content.Context;
import android.view.ViewTreeObserver;
import android.webkit.WebView;
import com.baidu.live.tbadk.img.effect.ResizeImageAction;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private Context f4950a;
    private WeakReference<WebView> b;
    private a d;
    private String h;
    private String i;
    private String j;
    private JSONObject l;
    private JSONObject m;
    private String n;
    private boolean o;
    private boolean p;
    private boolean q;
    private int e = 0;
    private int f = 0;
    private JSONObject g = new JSONObject();
    private Map<String, String> k = new HashMap();
    private c c = new c(this);

    private e(final WebView webView, a aVar) {
        this.f4950a = webView.getContext();
        this.b = new WeakReference<>(webView);
        this.d = aVar;
        f.a(webView);
        webView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.sdk.openadsdk.playable.e.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                try {
                    if (e.this.e != webView.getWidth() || e.this.f != webView.getHeight()) {
                        e.this.e = webView.getWidth();
                        e.this.f = webView.getHeight();
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("width", e.this.e);
                        jSONObject.put("height", e.this.f);
                        e.this.a(ResizeImageAction.ACTION_NAME, jSONObject);
                        e.this.g = jSONObject;
                    }
                } catch (Throwable th) {
                    d.a("PlayablePlugin", "onSizeChanged error", th);
                }
            }
        });
    }

    public Context a() {
        return this.f4950a;
    }

    public e a(String str, String str2) {
        this.k.put(str, str2);
        return this;
    }

    public Map<String, String> b() {
        return this.k;
    }

    public e a(String str) {
        this.h = str;
        return this;
    }

    public e b(String str) {
        this.i = str;
        return this;
    }

    public JSONObject c() {
        return this.m;
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

    public String d() {
        return this.i;
    }

    public String e() {
        return this.h;
    }

    public e d(String str) {
        this.j = str;
        return this;
    }

    public String f() {
        return this.j;
    }

    public e e(String str) {
        this.n = str;
        return this;
    }

    public String g() {
        return this.n;
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

    public boolean h() {
        return this.o;
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

    public boolean i() {
        return this.p;
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

    public Set<String> j() {
        return this.c.a();
    }

    public void a(String str, JSONObject jSONObject) {
        if (d.a()) {
            d.a("PlayablePlugin", "CALL JS [" + str + "] " + (jSONObject != null ? jSONObject.toString() : ""));
        }
        this.d.a(str, jSONObject);
    }

    public b k() {
        return this.d.a();
    }

    public a l() {
        return this.d;
    }

    public JSONObject m() {
        return this.g;
    }

    public JSONObject n() {
        return this.l;
    }

    public void o() {
        this.d.b();
    }

    public void p() {
        b(false);
    }

    public void q() {
        b(true);
    }

    public void r() {
        try {
            this.c.b();
        } catch (Throwable th) {
        }
    }

    public JSONObject b(String str, JSONObject jSONObject) {
        long currentTimeMillis = System.currentTimeMillis();
        if (d.a()) {
            d.a("PlayablePlugin", "PlayablePlugin JSB-REQ [" + str + "] " + (jSONObject != null ? jSONObject.toString() : ""));
        }
        JSONObject a2 = this.c.a(str, jSONObject);
        if (d.a()) {
            d.a("PlayablePlugin", "PlayablePlugin JSB-RSP [" + str + "] time:" + (System.currentTimeMillis() - currentTimeMillis) + " " + (a2 != null ? a2.toString() : ""));
        }
        return a2;
    }

    public static e a(WebView webView, a aVar) {
        if (webView == null || aVar == null) {
            return null;
        }
        return new e(webView, aVar);
    }
}
