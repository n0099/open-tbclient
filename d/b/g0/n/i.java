package d.b.g0.n;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public String f49638a;

    /* renamed from: b  reason: collision with root package name */
    public String f49639b;

    /* renamed from: c  reason: collision with root package name */
    public int f49640c;

    /* renamed from: d  reason: collision with root package name */
    public String f49641d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f49642e;

    /* renamed from: f  reason: collision with root package name */
    public long f49643f;

    /* renamed from: g  reason: collision with root package name */
    public int f49644g;

    /* renamed from: h  reason: collision with root package name */
    public String f49645h;
    public String i;
    public boolean j;
    public String k;

    public i(String str, String str2, int i) {
        this.f49641d = "";
        this.j = false;
        this.k = "";
        this.f49638a = str;
        this.f49639b = str;
        this.f49640c = -1;
        this.f49641d = str2;
        this.f49644g = i;
        if ((i & 2) == 0) {
            this.f49643f = System.currentTimeMillis();
        }
        try {
            this.f49642e = new JSONObject(this.f49641d);
        } catch (JSONException unused) {
        }
    }

    public String a() {
        JSONObject jSONObject = this.f49642e;
        return jSONObject != null ? jSONObject.optString("bizId") : "";
    }

    public String b() {
        return this.i;
    }

    public String c() {
        return this.f49641d;
    }

    public String d() {
        return this.f49645h;
    }

    public String e() {
        return this.k;
    }

    public int f() {
        return this.f49640c;
    }

    public String g() {
        return this.f49639b;
    }

    public String h() {
        return this.f49638a;
    }

    public JSONObject i() {
        return this.f49642e;
    }

    public int j() {
        return this.f49644g;
    }

    public long k() {
        return this.f49643f;
    }

    public boolean l() {
        return this.j;
    }

    public void m(String str) {
        this.i = str;
    }

    public void n(boolean z) {
        this.j = z;
    }

    public void o() {
        String str = this.f49638a;
        if (str != null && str.equals(this.f49639b) && d.g().a(this.f49638a)) {
            this.f49645h = e.g().i();
        }
    }

    public i(String str, JSONObject jSONObject, int i) {
        this.f49641d = "";
        this.j = false;
        this.k = "";
        this.f49638a = str;
        this.f49639b = str;
        this.f49640c = -1;
        this.f49642e = jSONObject;
        this.f49644g = i;
        if ((i & 2) == 0) {
            this.f49643f = System.currentTimeMillis();
        }
    }

    public i(String str, String str2, int i, String str3, int i2) {
        this.f49641d = "";
        this.j = false;
        this.k = "";
        this.f49638a = str2;
        this.f49639b = str;
        this.f49640c = i;
        this.f49641d = str3;
        this.f49644g = i2;
        if ((i2 & 2) == 0) {
            this.f49643f = System.currentTimeMillis();
        }
        try {
            this.f49642e = new JSONObject(this.f49641d);
        } catch (JSONException unused) {
        }
    }

    public i(String str, String str2, int i, String str3, long j, int i2) {
        this.f49641d = "";
        this.j = false;
        this.k = "";
        this.f49638a = str2;
        this.f49639b = str;
        this.f49640c = i;
        this.f49641d = str3;
        this.f49644g = i2;
        if ((i2 & 2) == 0) {
            if (j > 0) {
                this.f49643f = j;
            } else {
                this.f49643f = System.currentTimeMillis();
            }
        }
        if (TextUtils.isEmpty(this.f49641d)) {
            return;
        }
        try {
            this.f49642e = new JSONObject(this.f49641d);
        } catch (JSONException unused) {
        }
    }
}
