package d.b.k0;

import com.baidu.ubc.UBC;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    public String f64672a;

    /* renamed from: b  reason: collision with root package name */
    public String f64673b;

    /* renamed from: c  reason: collision with root package name */
    public int f64674c;

    /* renamed from: d  reason: collision with root package name */
    public String f64675d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f64676e;

    /* renamed from: f  reason: collision with root package name */
    public long f64677f;

    /* renamed from: g  reason: collision with root package name */
    public int f64678g;

    /* renamed from: h  reason: collision with root package name */
    public String f64679h;
    public String i;
    public boolean j;
    public String k;
    public String l;

    public n(String str, String str2, int i) {
        this.f64675d = "";
        this.j = false;
        this.k = "";
        this.l = "0";
        this.f64672a = str;
        this.f64673b = str;
        this.f64674c = -1;
        this.f64675d = str2;
        this.f64678g = i;
        if ((i & 2) == 0) {
            this.f64677f = System.currentTimeMillis();
        }
    }

    public String a() {
        return this.i;
    }

    public String b() {
        return this.f64675d;
    }

    public String c() {
        return this.f64679h;
    }

    public String d() {
        return this.k;
    }

    public int e() {
        return this.f64674c;
    }

    public String f() {
        return this.f64673b;
    }

    public String g() {
        return this.f64672a;
    }

    public JSONObject h() {
        return this.f64676e;
    }

    public int i() {
        return this.f64678g;
    }

    public String j() {
        return this.l;
    }

    public long k() {
        return this.f64677f;
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
        String str = this.f64672a;
        if (str != null && str.equals(this.f64673b) && g.m().a(this.f64672a)) {
            this.f64679h = UBC.getUBCContext().i();
        }
    }

    public void p(String str) {
        this.k = str;
    }

    public void q(String str) {
        this.l = str;
    }

    public n(String str, JSONObject jSONObject, int i) {
        this.f64675d = "";
        this.j = false;
        this.k = "";
        this.l = "0";
        this.f64672a = str;
        this.f64673b = str;
        this.f64674c = -1;
        this.f64676e = jSONObject;
        this.f64678g = i;
        if ((i & 2) == 0) {
            this.f64677f = System.currentTimeMillis();
        }
    }

    public n(String str, String str2, int i, String str3, int i2) {
        this.f64675d = "";
        this.j = false;
        this.k = "";
        this.l = "0";
        this.f64672a = str2;
        this.f64673b = str;
        this.f64674c = i;
        this.f64675d = str3;
        this.f64678g = i2;
        if ((i2 & 2) == 0) {
            this.f64677f = System.currentTimeMillis();
        }
    }

    public n(String str, String str2, int i, String str3, long j, int i2) {
        this.f64675d = "";
        this.j = false;
        this.k = "";
        this.l = "0";
        this.f64672a = str2;
        this.f64673b = str;
        this.f64674c = i;
        this.f64675d = str3;
        this.f64678g = i2;
        if ((i2 & 2) == 0) {
            if (j > 0) {
                this.f64677f = j;
            } else {
                this.f64677f = System.currentTimeMillis();
            }
        }
    }
}
