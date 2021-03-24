package d.b.g0.n;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public String f49245a;

    /* renamed from: b  reason: collision with root package name */
    public String f49246b;

    /* renamed from: c  reason: collision with root package name */
    public int f49247c;

    /* renamed from: d  reason: collision with root package name */
    public String f49248d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f49249e;

    /* renamed from: f  reason: collision with root package name */
    public long f49250f;

    /* renamed from: g  reason: collision with root package name */
    public int f49251g;

    /* renamed from: h  reason: collision with root package name */
    public String f49252h;
    public String i;
    public boolean j;
    public String k;

    public i(String str, String str2, int i) {
        this.f49248d = "";
        this.j = false;
        this.k = "";
        this.f49245a = str;
        this.f49246b = str;
        this.f49247c = -1;
        this.f49248d = str2;
        this.f49251g = i;
        if ((i & 2) == 0) {
            this.f49250f = System.currentTimeMillis();
        }
        try {
            this.f49249e = new JSONObject(this.f49248d);
        } catch (JSONException unused) {
        }
    }

    public String a() {
        JSONObject jSONObject = this.f49249e;
        return jSONObject != null ? jSONObject.optString("bizId") : "";
    }

    public String b() {
        return this.i;
    }

    public String c() {
        return this.f49248d;
    }

    public String d() {
        return this.f49252h;
    }

    public String e() {
        return this.k;
    }

    public int f() {
        return this.f49247c;
    }

    public String g() {
        return this.f49246b;
    }

    public String h() {
        return this.f49245a;
    }

    public JSONObject i() {
        return this.f49249e;
    }

    public int j() {
        return this.f49251g;
    }

    public long k() {
        return this.f49250f;
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
        String str = this.f49245a;
        if (str != null && str.equals(this.f49246b) && d.g().a(this.f49245a)) {
            this.f49252h = e.g().i();
        }
    }

    public i(String str, JSONObject jSONObject, int i) {
        this.f49248d = "";
        this.j = false;
        this.k = "";
        this.f49245a = str;
        this.f49246b = str;
        this.f49247c = -1;
        this.f49249e = jSONObject;
        this.f49251g = i;
        if ((i & 2) == 0) {
            this.f49250f = System.currentTimeMillis();
        }
    }

    public i(String str, String str2, int i, String str3, int i2) {
        this.f49248d = "";
        this.j = false;
        this.k = "";
        this.f49245a = str2;
        this.f49246b = str;
        this.f49247c = i;
        this.f49248d = str3;
        this.f49251g = i2;
        if ((i2 & 2) == 0) {
            this.f49250f = System.currentTimeMillis();
        }
        try {
            this.f49249e = new JSONObject(this.f49248d);
        } catch (JSONException unused) {
        }
    }

    public i(String str, String str2, int i, String str3, long j, int i2) {
        this.f49248d = "";
        this.j = false;
        this.k = "";
        this.f49245a = str2;
        this.f49246b = str;
        this.f49247c = i;
        this.f49248d = str3;
        this.f49251g = i2;
        if ((i2 & 2) == 0) {
            if (j > 0) {
                this.f49250f = j;
            } else {
                this.f49250f = System.currentTimeMillis();
            }
        }
        if (TextUtils.isEmpty(this.f49248d)) {
            return;
        }
        try {
            this.f49249e = new JSONObject(this.f49248d);
        } catch (JSONException unused) {
        }
    }
}
