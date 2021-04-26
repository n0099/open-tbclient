package com.bytedance.sdk.openadsdk.f.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.AnyThread;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.webkit.sdk.WebChromeClient;
import com.bytedance.sdk.openadsdk.f.a.g;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public Context f29867a;

    /* renamed from: b  reason: collision with root package name */
    public m f29868b;

    /* renamed from: c  reason: collision with root package name */
    public h f29869c;

    /* renamed from: e  reason: collision with root package name */
    public String f29871e;

    /* renamed from: g  reason: collision with root package name */
    public g f29873g;

    /* renamed from: d  reason: collision with root package name */
    public Handler f29870d = new Handler(Looper.getMainLooper());

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f29872f = false;

    /* renamed from: h  reason: collision with root package name */
    public final Map<String, g> f29874h = new HashMap();

    @NonNull
    public abstract Context a(j jVar);

    @Nullable
    public abstract String a();

    @AnyThread
    public abstract void a(String str);

    public abstract void b(j jVar);

    public final void b(String str, p pVar) {
        if (this.f29872f) {
            return;
        }
        if (TextUtils.isEmpty(pVar.f29918f)) {
            i.a("By passing js callback due to empty callback: " + str);
            return;
        }
        if (!str.startsWith(StringUtil.ARRAY_START) || !str.endsWith("}")) {
            i.a(new IllegalArgumentException("Illegal callback data: " + str));
        }
        i.a("Invoking js callback: " + pVar.f29918f);
        a("{\"__msg_type\":\"callback\",\"__callback_id\":\"" + pVar.f29918f + "\",\"__params\":" + str + "}", pVar);
    }

    public void invokeMethod(final String str) {
        if (this.f29872f) {
            return;
        }
        i.a("Received call: " + str);
        this.f29870d.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.f.a.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.f29872f) {
                    return;
                }
                p pVar = null;
                try {
                    pVar = a.this.a(new JSONObject(str));
                } catch (JSONException e2) {
                    i.b("Exception thrown while parsing function.", e2);
                }
                if (p.a(pVar)) {
                    i.a("By pass invalid call: " + pVar);
                    if (pVar != null) {
                        a.this.b(x.a(new r(pVar.f29913a, "Failed to parse invocation.")), pVar);
                        return;
                    }
                    return;
                }
                a.this.a(pVar);
            }
        });
    }

    public void a(String str, @Nullable p pVar) {
        a(str);
    }

    @MainThread
    public final void a(p pVar) {
        String a2;
        if (this.f29872f || (a2 = a()) == null) {
            return;
        }
        g b2 = b(pVar.f29919g);
        if (b2 == null) {
            i.b("Received call with unknown namespace, " + pVar);
            m mVar = this.f29868b;
            if (mVar != null) {
                mVar.a(a(), pVar.f29916d, 2);
            }
            b(x.a(new r(-4, "Namespace " + pVar.f29919g + " unknown.")), pVar);
            return;
        }
        f fVar = new f();
        fVar.f29883b = a2;
        fVar.f29882a = this.f29867a;
        fVar.f29884c = b2;
        try {
            g.a a3 = b2.a(pVar, fVar);
            if (a3 == null) {
                i.b("Received call but not registered, " + pVar);
                if (this.f29868b != null) {
                    this.f29868b.a(a(), pVar.f29916d, 2);
                }
                b(x.a(new r(-2, "Function " + pVar.f29916d + " is not registered.")), pVar);
                return;
            }
            if (a3.f29900a) {
                b(a3.f29901b, pVar);
            }
            if (this.f29868b != null) {
                this.f29868b.a(a(), pVar.f29916d);
            }
        } catch (Exception e2) {
            i.a("call finished with error, " + pVar, e2);
            b(x.a(e2), pVar);
        }
    }

    @Nullable
    private g b(String str) {
        if (!TextUtils.equals(str, this.f29871e) && !TextUtils.isEmpty(str)) {
            return this.f29874h.get(str);
        }
        return this.f29873g;
    }

    public final void a(j jVar, u uVar) {
        this.f29867a = a(jVar);
        this.f29869c = jVar.f29907d;
        this.f29868b = jVar.f29912i;
        this.f29873g = new g(jVar, this, uVar);
        this.f29871e = jVar.k;
        b(jVar);
    }

    public final <T> void a(String str, T t) {
        if (this.f29872f) {
            return;
        }
        String a2 = this.f29869c.a((h) t);
        i.a("Sending js event: " + str);
        a("{\"__msg_type\":\"event\",\"__event_id\":\"" + str + "\",\"__params\":" + a2 + "}");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public p a(JSONObject jSONObject) {
        if (this.f29872f) {
            return null;
        }
        String optString = jSONObject.optString("__callback_id");
        String optString2 = jSONObject.optString(WebChromeClient.KEY_FUNCTION_NAME);
        String a2 = a();
        if (a2 == null) {
            m mVar = this.f29868b;
            if (mVar != null) {
                mVar.a(null, null, 3);
            }
            return null;
        }
        try {
            String string = jSONObject.getString("__msg_type");
            String string2 = jSONObject.getString("params");
            String string3 = jSONObject.getString("JSSDK");
            String optString3 = jSONObject.optString("namespace");
            return p.a().a(string3).b(string).c(optString2).d(string2).e(optString).f(optString3).g(jSONObject.optString("__iframe_url")).a();
        } catch (JSONException e2) {
            i.b("Failed to create call.", e2);
            m mVar2 = this.f29868b;
            if (mVar2 != null) {
                mVar2.a(a2, optString2, 1);
            }
            return p.a(optString, -1);
        }
    }
}
