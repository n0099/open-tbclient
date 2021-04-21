package d.b.h0.n;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public String f49967a;

    /* renamed from: b  reason: collision with root package name */
    public String f49968b;

    /* renamed from: c  reason: collision with root package name */
    public int f49969c;

    /* renamed from: d  reason: collision with root package name */
    public String f49970d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f49971e;

    /* renamed from: f  reason: collision with root package name */
    public long f49972f;

    /* renamed from: g  reason: collision with root package name */
    public int f49973g;

    /* renamed from: h  reason: collision with root package name */
    public String f49974h;
    public String i;
    public boolean j;
    public String k;

    public i(String str, String str2, int i) {
        this.f49970d = "";
        this.j = false;
        this.k = "";
        this.f49967a = str;
        this.f49968b = str;
        this.f49969c = -1;
        this.f49970d = str2;
        this.f49973g = i;
        if ((i & 2) == 0) {
            this.f49972f = System.currentTimeMillis();
        }
        try {
            this.f49971e = new JSONObject(this.f49970d);
        } catch (JSONException unused) {
        }
    }

    public String a() {
        JSONObject jSONObject = this.f49971e;
        return jSONObject != null ? jSONObject.optString("bizId") : "";
    }

    public String b() {
        return this.i;
    }

    public String c() {
        return this.f49970d;
    }

    public String d() {
        return this.f49974h;
    }

    public String e() {
        return this.k;
    }

    public int f() {
        return this.f49969c;
    }

    public String g() {
        return this.f49968b;
    }

    public String h() {
        return this.f49967a;
    }

    public JSONObject i() {
        return this.f49971e;
    }

    public int j() {
        return this.f49973g;
    }

    public long k() {
        return this.f49972f;
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
        String str = this.f49967a;
        if (str != null && str.equals(this.f49968b) && d.g().a(this.f49967a)) {
            this.f49974h = e.g().i();
        }
    }

    public i(String str, JSONObject jSONObject, int i) {
        this.f49970d = "";
        this.j = false;
        this.k = "";
        this.f49967a = str;
        this.f49968b = str;
        this.f49969c = -1;
        this.f49971e = jSONObject;
        this.f49973g = i;
        if ((i & 2) == 0) {
            this.f49972f = System.currentTimeMillis();
        }
    }

    public i(String str, String str2, int i, String str3, int i2) {
        this.f49970d = "";
        this.j = false;
        this.k = "";
        this.f49967a = str2;
        this.f49968b = str;
        this.f49969c = i;
        this.f49970d = str3;
        this.f49973g = i2;
        if ((i2 & 2) == 0) {
            this.f49972f = System.currentTimeMillis();
        }
        try {
            this.f49971e = new JSONObject(this.f49970d);
        } catch (JSONException unused) {
        }
    }

    public i(String str, String str2, int i, String str3, long j, int i2) {
        this.f49970d = "";
        this.j = false;
        this.k = "";
        this.f49967a = str2;
        this.f49968b = str;
        this.f49969c = i;
        this.f49970d = str3;
        this.f49973g = i2;
        if ((i2 & 2) == 0) {
            if (j > 0) {
                this.f49972f = j;
            } else {
                this.f49972f = System.currentTimeMillis();
            }
        }
        if (TextUtils.isEmpty(this.f49970d)) {
            return;
        }
        try {
            this.f49971e = new JSONObject(this.f49970d);
        } catch (JSONException unused) {
        }
    }
}
