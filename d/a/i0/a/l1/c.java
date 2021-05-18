package d.a.i0.a.l1;

import android.text.TextUtils;
import android.util.Log;
import d.a.i0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f43187e = k.f43025a;

    /* renamed from: f  reason: collision with root package name */
    public static String f43188f = "SwanAppParam";

    /* renamed from: a  reason: collision with root package name */
    public String f43189a;

    /* renamed from: b  reason: collision with root package name */
    public String f43190b;

    /* renamed from: c  reason: collision with root package name */
    public String f43191c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f43192d;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public c f43193a = new c();

        public c a() {
            return this.f43193a;
        }

        public a b(String str) {
            this.f43193a.f43190b = str;
            return this;
        }

        public a c(boolean z) {
            this.f43193a.f43192d = z;
            return this;
        }

        public a d(String str) {
            this.f43193a.f43189a = str;
            return this;
        }

        public a e(String str) {
            this.f43193a.f43191c = str;
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
            cVar.f43189a = jSONObject.optString("page");
            cVar.f43191c = jSONObject.optString("params");
            cVar.f43190b = jSONObject.optString("baseUrl");
            cVar.f43192d = jSONObject.optBoolean("isFirstPage");
            return cVar;
        } catch (JSONException e2) {
            if (f43187e) {
                String str2 = f43188f;
                Log.e(str2, "createSwanAppParam() error: " + Log.getStackTraceString(e2));
            }
            return null;
        }
    }

    public String f() {
        return this.f43190b;
    }

    public String g() {
        return this.f43189a;
    }

    public String h() {
        return this.f43191c;
    }

    public String i() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("page", this.f43189a);
            jSONObject.put("params", this.f43191c);
            jSONObject.put("baseUrl", this.f43190b);
            jSONObject.put("isFirstPage", this.f43192d);
        } catch (JSONException e2) {
            if (f43187e) {
                String str = f43188f;
                Log.e(str, "toJSONString error: " + Log.getStackTraceString(e2));
            }
        }
        return jSONObject.toString();
    }

    public void j() {
        this.f43192d = false;
    }
}
