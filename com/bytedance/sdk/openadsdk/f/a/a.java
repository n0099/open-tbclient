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
/* loaded from: classes6.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public Context f29041a;

    /* renamed from: b  reason: collision with root package name */
    public m f29042b;

    /* renamed from: c  reason: collision with root package name */
    public h f29043c;

    /* renamed from: e  reason: collision with root package name */
    public String f29045e;

    /* renamed from: g  reason: collision with root package name */
    public g f29047g;

    /* renamed from: d  reason: collision with root package name */
    public Handler f29044d = new Handler(Looper.getMainLooper());

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f29046f = false;

    /* renamed from: h  reason: collision with root package name */
    public final Map<String, g> f29048h = new HashMap();

    @NonNull
    public abstract Context a(j jVar);

    @Nullable
    public abstract String a();

    @AnyThread
    public abstract void a(String str);

    public abstract void b(j jVar);

    public final void b(String str, p pVar) {
        if (this.f29046f) {
            return;
        }
        if (TextUtils.isEmpty(pVar.f29092f)) {
            i.a("By passing js callback due to empty callback: " + str);
            return;
        }
        if (!str.startsWith(StringUtil.ARRAY_START) || !str.endsWith("}")) {
            i.a(new IllegalArgumentException("Illegal callback data: " + str));
        }
        i.a("Invoking js callback: " + pVar.f29092f);
        a("{\"__msg_type\":\"callback\",\"__callback_id\":\"" + pVar.f29092f + "\",\"__params\":" + str + "}", pVar);
    }

    public void invokeMethod(final String str) {
        if (this.f29046f) {
            return;
        }
        i.a("Received call: " + str);
        this.f29044d.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.f.a.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.f29046f) {
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
                        a.this.b(x.a(new r(pVar.f29087a, "Failed to parse invocation.")), pVar);
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
        if (this.f29046f || (a2 = a()) == null) {
            return;
        }
        g b2 = b(pVar.f29093g);
        if (b2 == null) {
            i.b("Received call with unknown namespace, " + pVar);
            m mVar = this.f29042b;
            if (mVar != null) {
                mVar.a(a(), pVar.f29090d, 2);
            }
            b(x.a(new r(-4, "Namespace " + pVar.f29093g + " unknown.")), pVar);
            return;
        }
        f fVar = new f();
        fVar.f29057b = a2;
        fVar.f29056a = this.f29041a;
        fVar.f29058c = b2;
        try {
            g.a a3 = b2.a(pVar, fVar);
            if (a3 == null) {
                i.b("Received call but not registered, " + pVar);
                if (this.f29042b != null) {
                    this.f29042b.a(a(), pVar.f29090d, 2);
                }
                b(x.a(new r(-2, "Function " + pVar.f29090d + " is not registered.")), pVar);
                return;
            }
            if (a3.f29074a) {
                b(a3.f29075b, pVar);
            }
            if (this.f29042b != null) {
                this.f29042b.a(a(), pVar.f29090d);
            }
        } catch (Exception e2) {
            i.a("call finished with error, " + pVar, e2);
            b(x.a(e2), pVar);
        }
    }

    @Nullable
    private g b(String str) {
        if (!TextUtils.equals(str, this.f29045e) && !TextUtils.isEmpty(str)) {
            return this.f29048h.get(str);
        }
        return this.f29047g;
    }

    public final void a(j jVar, u uVar) {
        this.f29041a = a(jVar);
        this.f29043c = jVar.f29081d;
        this.f29042b = jVar.f29086i;
        this.f29047g = new g(jVar, this, uVar);
        this.f29045e = jVar.k;
        b(jVar);
    }

    public final <T> void a(String str, T t) {
        if (this.f29046f) {
            return;
        }
        String a2 = this.f29043c.a((h) t);
        i.a("Sending js event: " + str);
        a("{\"__msg_type\":\"event\",\"__event_id\":\"" + str + "\",\"__params\":" + a2 + "}");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public p a(JSONObject jSONObject) {
        if (this.f29046f) {
            return null;
        }
        String optString = jSONObject.optString("__callback_id");
        String optString2 = jSONObject.optString(WebChromeClient.KEY_FUNCTION_NAME);
        String a2 = a();
        if (a2 == null) {
            m mVar = this.f29042b;
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
            m mVar2 = this.f29042b;
            if (mVar2 != null) {
                mVar2.a(a2, optString2, 1);
            }
            return p.a(optString, -1);
        }
    }
}
