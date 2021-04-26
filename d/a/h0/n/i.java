package d.a.h0.n;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public String f47495a;

    /* renamed from: b  reason: collision with root package name */
    public String f47496b;

    /* renamed from: c  reason: collision with root package name */
    public int f47497c;

    /* renamed from: d  reason: collision with root package name */
    public String f47498d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f47499e;

    /* renamed from: f  reason: collision with root package name */
    public long f47500f;

    /* renamed from: g  reason: collision with root package name */
    public int f47501g;

    /* renamed from: h  reason: collision with root package name */
    public String f47502h;

    /* renamed from: i  reason: collision with root package name */
    public String f47503i;
    public boolean j;
    public String k;

    public i(String str, String str2, int i2) {
        this.f47498d = "";
        this.j = false;
        this.k = "";
        this.f47495a = str;
        this.f47496b = str;
        this.f47497c = -1;
        this.f47498d = str2;
        this.f47501g = i2;
        if ((i2 & 2) == 0) {
            this.f47500f = System.currentTimeMillis();
        }
        try {
            this.f47499e = new JSONObject(this.f47498d);
        } catch (JSONException unused) {
        }
    }

    public String a() {
        JSONObject jSONObject = this.f47499e;
        return jSONObject != null ? jSONObject.optString("bizId") : "";
    }

    public String b() {
        return this.f47503i;
    }

    public String c() {
        return this.f47498d;
    }

    public String d() {
        return this.f47502h;
    }

    public String e() {
        return this.k;
    }

    public int f() {
        return this.f47497c;
    }

    public String g() {
        return this.f47496b;
    }

    public String h() {
        return this.f47495a;
    }

    public JSONObject i() {
        return this.f47499e;
    }

    public int j() {
        return this.f47501g;
    }

    public long k() {
        return this.f47500f;
    }

    public boolean l() {
        return this.j;
    }

    public void m(String str) {
        this.f47503i = str;
    }

    public void n(boolean z) {
        this.j = z;
    }

    public void o() {
        String str = this.f47495a;
        if (str != null && str.equals(this.f47496b) && d.g().a(this.f47495a)) {
            this.f47502h = e.g().g();
        }
    }

    public i(String str, JSONObject jSONObject, int i2) {
        this.f47498d = "";
        this.j = false;
        this.k = "";
        this.f47495a = str;
        this.f47496b = str;
        this.f47497c = -1;
        this.f47499e = jSONObject;
        this.f47501g = i2;
        if ((i2 & 2) == 0) {
            this.f47500f = System.currentTimeMillis();
        }
    }

    public i(String str, String str2, int i2, String str3, int i3) {
        this.f47498d = "";
        this.j = false;
        this.k = "";
        this.f47495a = str2;
        this.f47496b = str;
        this.f47497c = i2;
        this.f47498d = str3;
        this.f47501g = i3;
        if ((i3 & 2) == 0) {
            this.f47500f = System.currentTimeMillis();
        }
        try {
            this.f47499e = new JSONObject(this.f47498d);
        } catch (JSONException unused) {
        }
    }

    public i(String str, String str2, int i2, String str3, long j, int i3) {
        this.f47498d = "";
        this.j = false;
        this.k = "";
        this.f47495a = str2;
        this.f47496b = str;
        this.f47497c = i2;
        this.f47498d = str3;
        this.f47501g = i3;
        if ((i3 & 2) == 0) {
            if (j > 0) {
                this.f47500f = j;
            } else {
                this.f47500f = System.currentTimeMillis();
            }
        }
        if (TextUtils.isEmpty(this.f47498d)) {
            return;
        }
        try {
            this.f47499e = new JSONObject(this.f47498d);
        } catch (JSONException unused) {
        }
    }
}
