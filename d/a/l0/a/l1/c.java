package d.a.l0.a.l1;

import android.text.TextUtils;
import android.util.Log;
import d.a.l0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f43361e = k.f43199a;

    /* renamed from: f  reason: collision with root package name */
    public static String f43362f = "SwanAppParam";

    /* renamed from: a  reason: collision with root package name */
    public String f43363a;

    /* renamed from: b  reason: collision with root package name */
    public String f43364b;

    /* renamed from: c  reason: collision with root package name */
    public String f43365c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f43366d;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public c f43367a = new c();

        public c a() {
            return this.f43367a;
        }

        public a b(String str) {
            this.f43367a.f43364b = str;
            return this;
        }

        public a c(boolean z) {
            this.f43367a.f43366d = z;
            return this;
        }

        public a d(String str) {
            this.f43367a.f43363a = str;
            return this;
        }

        public a e(String str) {
            this.f43367a.f43365c = str;
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
            cVar.f43363a = jSONObject.optString("page");
            cVar.f43365c = jSONObject.optString("params");
            cVar.f43364b = jSONObject.optString("baseUrl");
            cVar.f43366d = jSONObject.optBoolean("isFirstPage");
            return cVar;
        } catch (JSONException e2) {
            if (f43361e) {
                String str2 = f43362f;
                Log.e(str2, "createSwanAppParam() error: " + Log.getStackTraceString(e2));
            }
            return null;
        }
    }

    public String f() {
        return this.f43364b;
    }

    public String g() {
        return this.f43363a;
    }

    public String h() {
        return this.f43365c;
    }

    public String i() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("page", this.f43363a);
            jSONObject.put("params", this.f43365c);
            jSONObject.put("baseUrl", this.f43364b);
            jSONObject.put("isFirstPage", this.f43366d);
        } catch (JSONException e2) {
            if (f43361e) {
                String str = f43362f;
                Log.e(str, "toJSONString error: " + Log.getStackTraceString(e2));
            }
        }
        return jSONObject.toString();
    }

    public void j() {
        this.f43366d = false;
    }
}
