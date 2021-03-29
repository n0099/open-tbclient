package d.b.k0;

import com.baidu.ubc.UBC;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    public String f63972a;

    /* renamed from: b  reason: collision with root package name */
    public String f63973b;

    /* renamed from: c  reason: collision with root package name */
    public int f63974c;

    /* renamed from: d  reason: collision with root package name */
    public String f63975d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f63976e;

    /* renamed from: f  reason: collision with root package name */
    public long f63977f;

    /* renamed from: g  reason: collision with root package name */
    public int f63978g;

    /* renamed from: h  reason: collision with root package name */
    public String f63979h;
    public String i;
    public boolean j;
    public String k;
    public String l;

    public n(String str, String str2, int i) {
        this.f63975d = "";
        this.j = false;
        this.k = "";
        this.l = "0";
        this.f63972a = str;
        this.f63973b = str;
        this.f63974c = -1;
        this.f63975d = str2;
        this.f63978g = i;
        if ((i & 2) == 0) {
            this.f63977f = System.currentTimeMillis();
        }
    }

    public String a() {
        return this.i;
    }

    public String b() {
        return this.f63975d;
    }

    public String c() {
        return this.f63979h;
    }

    public String d() {
        return this.k;
    }

    public int e() {
        return this.f63974c;
    }

    public String f() {
        return this.f63973b;
    }

    public String g() {
        return this.f63972a;
    }

    public JSONObject h() {
        return this.f63976e;
    }

    public int i() {
        return this.f63978g;
    }

    public String j() {
        return this.l;
    }

    public long k() {
        return this.f63977f;
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
        String str = this.f63972a;
        if (str != null && str.equals(this.f63973b) && g.m().a(this.f63972a)) {
            this.f63979h = UBC.getUBCContext().i();
        }
    }

    public void p(String str) {
        this.k = str;
    }

    public void q(String str) {
        this.l = str;
    }

    public n(String str, JSONObject jSONObject, int i) {
        this.f63975d = "";
        this.j = false;
        this.k = "";
        this.l = "0";
        this.f63972a = str;
        this.f63973b = str;
        this.f63974c = -1;
        this.f63976e = jSONObject;
        this.f63978g = i;
        if ((i & 2) == 0) {
            this.f63977f = System.currentTimeMillis();
        }
    }

    public n(String str, String str2, int i, String str3, int i2) {
        this.f63975d = "";
        this.j = false;
        this.k = "";
        this.l = "0";
        this.f63972a = str2;
        this.f63973b = str;
        this.f63974c = i;
        this.f63975d = str3;
        this.f63978g = i2;
        if ((i2 & 2) == 0) {
            this.f63977f = System.currentTimeMillis();
        }
    }

    public n(String str, String str2, int i, String str3, long j, int i2) {
        this.f63975d = "";
        this.j = false;
        this.k = "";
        this.l = "0";
        this.f63972a = str2;
        this.f63973b = str;
        this.f63974c = i;
        this.f63975d = str3;
        this.f63978g = i2;
        if ((i2 & 2) == 0) {
            if (j > 0) {
                this.f63977f = j;
            } else {
                this.f63977f = System.currentTimeMillis();
            }
        }
    }
}
