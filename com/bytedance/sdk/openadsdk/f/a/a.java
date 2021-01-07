package com.bytedance.sdk.openadsdk.f.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.AnyThread;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.f.a.g;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    protected Context f7408a;

    /* renamed from: b  reason: collision with root package name */
    protected m f7409b;
    protected h c;
    protected String e;
    g g;
    protected Handler d = new Handler(Looper.getMainLooper());
    protected volatile boolean f = false;
    private final Map<String, g> h = new HashMap();

    @NonNull
    protected abstract Context a(j jVar);

    @Nullable
    protected abstract String a();

    @AnyThread
    protected abstract void a(String str);

    protected abstract void b(j jVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public void invokeMethod(final String str) {
        if (!this.f) {
            i.a("Received call: " + str);
            this.d.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.f.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!a.this.f) {
                        p pVar = null;
                        try {
                            pVar = a.this.a(new JSONObject(str));
                        } catch (JSONException e) {
                            i.b("Exception thrown while parsing function.", e);
                        }
                        if (p.a(pVar)) {
                            i.a("By pass invalid call: " + pVar);
                            if (pVar != null) {
                                a.this.b(x.a(new r(pVar.f7430a, "Failed to parse invocation.")), pVar);
                                return;
                            }
                            return;
                        }
                        a.this.a(pVar);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str, @Nullable p pVar) {
        a(str);
    }

    @MainThread
    protected final void a(p pVar) {
        String a2;
        if (!this.f && (a2 = a()) != null) {
            g b2 = b(pVar.g);
            if (b2 == null) {
                i.b("Received call with unknown namespace, " + pVar);
                if (this.f7409b != null) {
                    this.f7409b.a(a(), pVar.d, 2);
                }
                b(x.a(new r(-4, "Namespace " + pVar.g + " unknown.")), pVar);
                return;
            }
            f fVar = new f();
            fVar.f7417b = a2;
            fVar.f7416a = this.f7408a;
            fVar.c = b2;
            try {
                g.a a3 = b2.a(pVar, fVar);
                if (a3 == null) {
                    i.b("Received call but not registered, " + pVar);
                    if (this.f7409b != null) {
                        this.f7409b.a(a(), pVar.d, 2);
                    }
                    b(x.a(new r(-2, "Function " + pVar.d + " is not registered.")), pVar);
                    return;
                }
                if (a3.f7424a) {
                    b(a3.f7425b, pVar);
                }
                if (this.f7409b != null) {
                    this.f7409b.a(a(), pVar.d);
                }
            } catch (Exception e) {
                i.a("call finished with error, " + pVar, e);
                b(x.a(e), pVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(j jVar, u uVar) {
        this.f7408a = a(jVar);
        this.c = jVar.d;
        this.f7409b = jVar.i;
        this.g = new g(jVar, this, uVar);
        this.e = jVar.k;
        b(jVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(String str, p pVar) {
        if (!this.f) {
            if (TextUtils.isEmpty(pVar.f)) {
                i.a("By passing js callback due to empty callback: " + str);
                return;
            }
            if (!str.startsWith("{") || !str.endsWith("}")) {
                i.a(new IllegalArgumentException("Illegal callback data: " + str));
            }
            i.a("Invoking js callback: " + pVar.f);
            a("{\"__msg_type\":\"callback\",\"__callback_id\":\"" + pVar.f + "\",\"__params\":" + str + "}", pVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public p a(JSONObject jSONObject) {
        if (this.f) {
            return null;
        }
        String optString = jSONObject.optString("__callback_id");
        String optString2 = jSONObject.optString("func");
        String a2 = a();
        if (a2 == null) {
            if (this.f7409b != null) {
                this.f7409b.a(null, null, 3);
                return null;
            }
            return null;
        }
        try {
            String string = jSONObject.getString("__msg_type");
            String string2 = jSONObject.getString("params");
            String string3 = jSONObject.getString("JSSDK");
            String optString3 = jSONObject.optString("namespace");
            return p.a().a(string3).b(string).c(optString2).d(string2).e(optString).f(optString3).g(jSONObject.optString("__iframe_url")).a();
        } catch (JSONException e) {
            i.b("Failed to create call.", e);
            if (this.f7409b != null) {
                this.f7409b.a(a2, optString2, 1);
            }
            return p.a(optString, -1);
        }
    }

    @Nullable
    private g b(String str) {
        if (TextUtils.equals(str, this.e) || TextUtils.isEmpty(str)) {
            return this.g;
        }
        return this.h.get(str);
    }
}
