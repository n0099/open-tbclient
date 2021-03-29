package d.b.g0.n;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public String f49246a;

    /* renamed from: b  reason: collision with root package name */
    public String f49247b;

    /* renamed from: c  reason: collision with root package name */
    public int f49248c;

    /* renamed from: d  reason: collision with root package name */
    public String f49249d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f49250e;

    /* renamed from: f  reason: collision with root package name */
    public long f49251f;

    /* renamed from: g  reason: collision with root package name */
    public int f49252g;

    /* renamed from: h  reason: collision with root package name */
    public String f49253h;
    public String i;
    public boolean j;
    public String k;

    public i(String str, String str2, int i) {
        this.f49249d = "";
        this.j = false;
        this.k = "";
        this.f49246a = str;
        this.f49247b = str;
        this.f49248c = -1;
        this.f49249d = str2;
        this.f49252g = i;
        if ((i & 2) == 0) {
            this.f49251f = System.currentTimeMillis();
        }
        try {
            this.f49250e = new JSONObject(this.f49249d);
        } catch (JSONException unused) {
        }
    }

    public String a() {
        JSONObject jSONObject = this.f49250e;
        return jSONObject != null ? jSONObject.optString("bizId") : "";
    }

    public String b() {
        return this.i;
    }

    public String c() {
        return this.f49249d;
    }

    public String d() {
        return this.f49253h;
    }

    public String e() {
        return this.k;
    }

    public int f() {
        return this.f49248c;
    }

    public String g() {
        return this.f49247b;
    }

    public String h() {
        return this.f49246a;
    }

    public JSONObject i() {
        return this.f49250e;
    }

    public int j() {
        return this.f49252g;
    }

    public long k() {
        return this.f49251f;
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
        String str = this.f49246a;
        if (str != null && str.equals(this.f49247b) && d.g().a(this.f49246a)) {
            this.f49253h = e.g().i();
        }
    }

    public i(String str, JSONObject jSONObject, int i) {
        this.f49249d = "";
        this.j = false;
        this.k = "";
        this.f49246a = str;
        this.f49247b = str;
        this.f49248c = -1;
        this.f49250e = jSONObject;
        this.f49252g = i;
        if ((i & 2) == 0) {
            this.f49251f = System.currentTimeMillis();
        }
    }

    public i(String str, String str2, int i, String str3, int i2) {
        this.f49249d = "";
        this.j = false;
        this.k = "";
        this.f49246a = str2;
        this.f49247b = str;
        this.f49248c = i;
        this.f49249d = str3;
        this.f49252g = i2;
        if ((i2 & 2) == 0) {
            this.f49251f = System.currentTimeMillis();
        }
        try {
            this.f49250e = new JSONObject(this.f49249d);
        } catch (JSONException unused) {
        }
    }

    public i(String str, String str2, int i, String str3, long j, int i2) {
        this.f49249d = "";
        this.j = false;
        this.k = "";
        this.f49246a = str2;
        this.f49247b = str;
        this.f49248c = i;
        this.f49249d = str3;
        this.f49252g = i2;
        if ((i2 & 2) == 0) {
            if (j > 0) {
                this.f49251f = j;
            } else {
                this.f49251f = System.currentTimeMillis();
            }
        }
        if (TextUtils.isEmpty(this.f49249d)) {
            return;
        }
        try {
            this.f49250e = new JSONObject(this.f49249d);
        } catch (JSONException unused) {
        }
    }
}
