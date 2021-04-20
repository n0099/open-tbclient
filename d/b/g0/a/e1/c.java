package d.b.g0.a.e1;

import android.text.TextUtils;
import android.util.Log;
import d.b.g0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class c {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f44758e = k.f45443a;

    /* renamed from: f  reason: collision with root package name */
    public static String f44759f = "SwanAppParam";

    /* renamed from: a  reason: collision with root package name */
    public String f44760a;

    /* renamed from: b  reason: collision with root package name */
    public String f44761b;

    /* renamed from: c  reason: collision with root package name */
    public String f44762c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f44763d;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public c f44764a = new c();

        public c a() {
            return this.f44764a;
        }

        public a b(String str) {
            this.f44764a.f44761b = str;
            return this;
        }

        public a c(boolean z) {
            this.f44764a.f44763d = z;
            return this;
        }

        public a d(String str) {
            this.f44764a.f44760a = str;
            return this;
        }

        public a e(String str) {
            this.f44764a.f44762c = str;
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
            cVar.f44760a = jSONObject.optString("page");
            cVar.f44762c = jSONObject.optString("params");
            cVar.f44761b = jSONObject.optString("baseUrl");
            cVar.f44763d = jSONObject.optBoolean("isFirstPage");
            return cVar;
        } catch (JSONException e2) {
            if (f44758e) {
                String str2 = f44759f;
                Log.e(str2, "createSwanAppParam() error: " + Log.getStackTraceString(e2));
            }
            return null;
        }
    }

    public String f() {
        return this.f44761b;
    }

    public String g() {
        return this.f44760a;
    }

    public String h() {
        return this.f44762c;
    }

    public String i() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("page", this.f44760a);
            jSONObject.put("params", this.f44762c);
            jSONObject.put("baseUrl", this.f44761b);
            jSONObject.put("isFirstPage", this.f44763d);
        } catch (JSONException e2) {
            if (f44758e) {
                String str = f44759f;
                Log.e(str, "toJSONString error: " + Log.getStackTraceString(e2));
            }
        }
        return jSONObject.toString();
    }

    public void j() {
        this.f44763d = false;
    }
}
