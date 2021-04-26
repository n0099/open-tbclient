package d.a.h0.a.e1;

import android.text.TextUtils;
import android.util.Log;
import d.a.h0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f42396e = k.f43101a;

    /* renamed from: f  reason: collision with root package name */
    public static String f42397f = "SwanAppParam";

    /* renamed from: a  reason: collision with root package name */
    public String f42398a;

    /* renamed from: b  reason: collision with root package name */
    public String f42399b;

    /* renamed from: c  reason: collision with root package name */
    public String f42400c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f42401d;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public c f42402a = new c();

        public c a() {
            return this.f42402a;
        }

        public a b(String str) {
            this.f42402a.f42399b = str;
            return this;
        }

        public a c(boolean z) {
            this.f42402a.f42401d = z;
            return this;
        }

        public a d(String str) {
            this.f42402a.f42398a = str;
            return this;
        }

        public a e(String str) {
            this.f42402a.f42400c = str;
            return this;
        }
    }

    public static c e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            c cVar = new c();
            JSONObject jSONObject = new JSONObject(str);
            cVar.f42398a = jSONObject.optString("page");
            cVar.f42400c = jSONObject.optString("params");
            cVar.f42399b = jSONObject.optString("baseUrl");
            cVar.f42401d = jSONObject.optBoolean("isFirstPage");
            return cVar;
        } catch (JSONException e2) {
            if (f42396e) {
                String str2 = f42397f;
                Log.e(str2, "createSwanAppParam() error: " + Log.getStackTraceString(e2));
            }
            return null;
        }
    }

    public String f() {
        return this.f42399b;
    }

    public String g() {
        return this.f42398a;
    }

    public String h() {
        return this.f42400c;
    }

    public String i() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("page", this.f42398a);
            jSONObject.put("params", this.f42400c);
            jSONObject.put("baseUrl", this.f42399b);
            jSONObject.put("isFirstPage", this.f42401d);
        } catch (JSONException e2) {
            if (f42396e) {
                String str = f42397f;
                Log.e(str, "toJSONString error: " + Log.getStackTraceString(e2));
            }
        }
        return jSONObject.toString();
    }

    public void j() {
        this.f42401d = false;
    }
}
