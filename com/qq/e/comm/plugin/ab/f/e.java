package com.qq.e.comm.plugin.ab.f;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.qq.e.comm.plugin.util.ai;
import com.qq.e.comm.plugin.y.u;
import com.qq.e.comm.util.GDTLogger;
import com.sina.weibo.sdk.constant.WBConstants;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private com.qq.e.comm.plugin.ab.f.a f11795a;

    /* renamed from: b  reason: collision with root package name */
    private b f11796b;
    private a c = new a();
    private f d;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private Map<String, com.qq.e.comm.plugin.ab.f.a.b> f11803a;

        private a() {
            this.f11803a = new HashMap();
        }

        com.qq.e.comm.plugin.ab.f.a.b a(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return this.f11803a.get(str);
        }

        void a(String str, com.qq.e.comm.plugin.ab.f.a.b bVar) {
            if (TextUtils.isEmpty(str) || bVar == null) {
                return;
            }
            this.f11803a.put(str, bVar);
        }
    }

    /* loaded from: classes15.dex */
    private static class b {

        /* renamed from: a  reason: collision with root package name */
        private Map<String, com.qq.e.comm.plugin.ab.f.a.c> f11804a = new HashMap();

        public b(JSONObject jSONObject) {
            a(jSONObject);
        }

        private void a(JSONObject jSONObject) {
            com.qq.e.comm.plugin.ab.f.a.a aVar = new com.qq.e.comm.plugin.ab.f.a.a(jSONObject);
            this.f11804a.put("download", aVar);
            this.f11804a.put("package", aVar);
            this.f11804a.put("network", aVar);
        }

        com.qq.e.comm.plugin.ab.f.a.c a(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return this.f11804a.get(str);
        }

        void a(String str, com.qq.e.comm.plugin.ab.f.a.c cVar) {
            if (TextUtils.isEmpty(str) || cVar == null) {
                return;
            }
            this.f11804a.put(str, cVar);
        }
    }

    public e(com.qq.e.comm.plugin.ab.f.a aVar, JSONObject jSONObject) {
        this.f11795a = aVar;
        this.f11796b = new b(jSONObject);
    }

    private void a(String str, String str2, String str3) {
        com.qq.e.comm.plugin.ab.f.a.b a2 = this.c.a(str);
        if (a2 != null) {
            a2.a(this, str, str2, str3);
        } else {
            a(str3, 2, "Unsupported action!", 0);
        }
    }

    private void b(String str) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                a(jSONObject.optString("action"), jSONObject.optJSONObject("params").toString(), jSONObject.optString(WBConstants.SHARE_CALLBACK_ID));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public com.qq.e.comm.plugin.ab.c.f<String> a(String str) {
        JSONObject jSONObject;
        String str2;
        String str3 = "";
        String str4 = "";
        String str5 = "";
        String str6 = "";
        if (f.a(Uri.parse(str))) {
            this.d = new f(this.f11795a);
            this.d.a();
            com.qq.e.comm.plugin.ab.b.d a2 = this.d.a(str);
            if (a2 != null) {
                ai.a("UnJsBridge-iFrame", a2.toString());
                str3 = a2.a();
                str4 = a2.b();
                String jSONObject2 = a2.d() != null ? a2.d().toString() : null;
                str2 = a2.e();
                str6 = a2.c();
                str5 = jSONObject2;
            } else {
                str2 = "";
            }
        } else {
            ai.a("UnJsBridge-jsPrompt", str);
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException e) {
                e.printStackTrace();
                jSONObject = null;
            }
            if (jSONObject == null) {
                u.a(100292, 3, null, new com.qq.e.comm.plugin.y.d().a("msg", str));
                return new com.qq.e.comm.plugin.ab.c.f<>(-1, "Invalid message");
            } else if (!"GDTJsBridge".equals(jSONObject.optString("gdtJB"))) {
                u.a(100292, 4, null, new com.qq.e.comm.plugin.y.d().a("msg", str));
                return new com.qq.e.comm.plugin.ab.c.f<>(-1, "Unsupported protocol");
            } else {
                str3 = jSONObject.optString("service");
                str4 = jSONObject.optString("action");
                str5 = jSONObject.optString("params");
                str6 = jSONObject.optString(WBConstants.SHARE_CALLBACK_ID);
                str2 = "";
            }
        }
        if (!"template".equals(str3)) {
            com.qq.e.comm.plugin.ab.f.a.c a3 = this.f11796b.a(str3);
            return a3 != null ? a3.a(this, this.f11795a.c(), str3, str4, str5, str6) : new com.qq.e.comm.plugin.ab.c.f<>(1000, "Unsupported service");
        }
        if ("multiAction".equals(str4)) {
            if (TextUtils.isEmpty(str2)) {
                str2 = str5;
            }
            b(str2);
        } else {
            a(str4, str5, str6);
        }
        return new com.qq.e.comm.plugin.ab.c.f<>(null);
    }

    public e a(com.qq.e.comm.plugin.ab.f.a.b bVar) {
        if (bVar != null) {
            this.c.a(bVar.a(), bVar);
        }
        return this;
    }

    public Set<String> a() {
        return this.c.f11803a.keySet();
    }

    public void a(final com.qq.e.comm.plugin.ab.b.b bVar) {
        if (bVar != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.qq.e.comm.plugin.ab.f.e.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        e.this.f11795a.b(bVar.a());
                    } catch (Throwable th) {
                        GDTLogger.report("Exception while fire JSEvent");
                    }
                }
            });
        }
    }

    @Deprecated
    public void a(final com.qq.e.comm.plugin.ab.b.e eVar) {
        if (eVar != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.qq.e.comm.plugin.ab.f.e.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        e.this.f11795a.b(eVar.a());
                    } catch (Throwable th) {
                        GDTLogger.report("Exception while sending JSResponse", th);
                    }
                }
            });
        }
    }

    public void a(String str, int i, String str2, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("callbackid", str);
            jSONObject.put("status", i);
            jSONObject.put("data", str2);
            jSONObject.put("keep", i2);
        } catch (JSONException e) {
            GDTLogger.w("Exception while sendingJSResponse", e);
        }
        final String str3 = "bridge.callback(" + jSONObject.toString() + ");";
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.qq.e.comm.plugin.ab.f.e.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    e.this.f11795a.b(str3);
                } catch (Throwable th) {
                    GDTLogger.report("Exception while sending JSResponse", th);
                }
            }
        });
    }

    public void a(String str, com.qq.e.comm.plugin.ab.f.a.c cVar) {
        this.f11796b.a(str, cVar);
    }
}
