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
    public Context f28977a;

    /* renamed from: b  reason: collision with root package name */
    public m f28978b;

    /* renamed from: c  reason: collision with root package name */
    public h f28979c;

    /* renamed from: e  reason: collision with root package name */
    public String f28981e;

    /* renamed from: g  reason: collision with root package name */
    public g f28983g;

    /* renamed from: d  reason: collision with root package name */
    public Handler f28980d = new Handler(Looper.getMainLooper());

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f28982f = false;

    /* renamed from: h  reason: collision with root package name */
    public final Map<String, g> f28984h = new HashMap();

    @NonNull
    public abstract Context a(j jVar);

    @Nullable
    public abstract String a();

    @AnyThread
    public abstract void a(String str);

    public abstract void b(j jVar);

    public final void b(String str, p pVar) {
        if (this.f28982f) {
            return;
        }
        if (TextUtils.isEmpty(pVar.f29026f)) {
            i.a("By passing js callback due to empty callback: " + str);
            return;
        }
        if (!str.startsWith(StringUtil.ARRAY_START) || !str.endsWith("}")) {
            i.a(new IllegalArgumentException("Illegal callback data: " + str));
        }
        i.a("Invoking js callback: " + pVar.f29026f);
        a("{\"__msg_type\":\"callback\",\"__callback_id\":\"" + pVar.f29026f + "\",\"__params\":" + str + "}", pVar);
    }

    public void invokeMethod(final String str) {
        if (this.f28982f) {
            return;
        }
        i.a("Received call: " + str);
        this.f28980d.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.f.a.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.f28982f) {
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
                        a.this.b(x.a(new r(pVar.f29021a, "Failed to parse invocation.")), pVar);
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
        if (this.f28982f || (a2 = a()) == null) {
            return;
        }
        g b2 = b(pVar.f29027g);
        if (b2 == null) {
            i.b("Received call with unknown namespace, " + pVar);
            m mVar = this.f28978b;
            if (mVar != null) {
                mVar.a(a(), pVar.f29024d, 2);
            }
            b(x.a(new r(-4, "Namespace " + pVar.f29027g + " unknown.")), pVar);
            return;
        }
        f fVar = new f();
        fVar.f28993b = a2;
        fVar.f28992a = this.f28977a;
        fVar.f28994c = b2;
        try {
            g.a a3 = b2.a(pVar, fVar);
            if (a3 == null) {
                i.b("Received call but not registered, " + pVar);
                if (this.f28978b != null) {
                    this.f28978b.a(a(), pVar.f29024d, 2);
                }
                b(x.a(new r(-2, "Function " + pVar.f29024d + " is not registered.")), pVar);
                return;
            }
            if (a3.f29009a) {
                b(a3.f29010b, pVar);
            }
            if (this.f28978b != null) {
                this.f28978b.a(a(), pVar.f29024d);
            }
        } catch (Exception e2) {
            i.a("call finished with error, " + pVar, e2);
            b(x.a(e2), pVar);
        }
    }

    @Nullable
    private g b(String str) {
        if (!TextUtils.equals(str, this.f28981e) && !TextUtils.isEmpty(str)) {
            return this.f28984h.get(str);
        }
        return this.f28983g;
    }

    public final void a(j jVar, u uVar) {
        this.f28977a = a(jVar);
        this.f28979c = jVar.f29016d;
        this.f28978b = jVar.i;
        this.f28983g = new g(jVar, this, uVar);
        this.f28981e = jVar.k;
        b(jVar);
    }

    public final <T> void a(String str, T t) {
        if (this.f28982f) {
            return;
        }
        String a2 = this.f28979c.a((h) t);
        i.a("Sending js event: " + str);
        a("{\"__msg_type\":\"event\",\"__event_id\":\"" + str + "\",\"__params\":" + a2 + "}");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public p a(JSONObject jSONObject) {
        if (this.f28982f) {
            return null;
        }
        String optString = jSONObject.optString("__callback_id");
        String optString2 = jSONObject.optString(WebChromeClient.KEY_FUNCTION_NAME);
        String a2 = a();
        if (a2 == null) {
            m mVar = this.f28978b;
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
            m mVar2 = this.f28978b;
            if (mVar2 != null) {
                mVar2.a(a2, optString2, 1);
            }
            return p.a(optString, -1);
        }
    }
}
