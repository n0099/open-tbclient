package d.a.p0;

import com.baidu.ubc.UBC;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public String f67713a;

    /* renamed from: b  reason: collision with root package name */
    public String f67714b;

    /* renamed from: c  reason: collision with root package name */
    public int f67715c;

    /* renamed from: d  reason: collision with root package name */
    public String f67716d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f67717e;

    /* renamed from: f  reason: collision with root package name */
    public long f67718f;

    /* renamed from: g  reason: collision with root package name */
    public int f67719g;

    /* renamed from: h  reason: collision with root package name */
    public String f67720h;

    /* renamed from: i  reason: collision with root package name */
    public String f67721i;
    public boolean j;
    public String k;
    public String l;

    public o(String str, String str2, int i2) {
        this.f67716d = "";
        this.j = false;
        this.k = "";
        this.l = "0";
        this.f67713a = str;
        this.f67714b = str;
        this.f67715c = -1;
        this.f67716d = str2;
        this.f67719g = i2;
        if ((i2 & 2) == 0) {
            this.f67718f = System.currentTimeMillis();
        }
    }

    public String a() {
        return this.f67721i;
    }

    public String b() {
        return this.f67716d;
    }

    public String c() {
        return this.f67720h;
    }

    public String d() {
        return this.k;
    }

    public int e() {
        return this.f67715c;
    }

    public String f() {
        return this.f67714b;
    }

    public String g() {
        return this.f67713a;
    }

    public JSONObject h() {
        return this.f67717e;
    }

    public int i() {
        return this.f67719g;
    }

    public String j() {
        return this.l;
    }

    public long k() {
        return this.f67718f;
    }

    public boolean l() {
        return this.j;
    }

    public void m(String str) {
        this.f67721i = str;
    }

    public void n(boolean z) {
        this.j = z;
    }

    public void o() {
        String str = this.f67713a;
        if (str != null && str.equals(this.f67714b) && g.m().a(this.f67713a)) {
            this.f67720h = UBC.getUBCContext().h();
        }
    }

    public void p(String str) {
        this.k = str;
    }

    public void q(String str) {
        this.l = str;
    }

    public o(String str, JSONObject jSONObject, int i2) {
        this.f67716d = "";
        this.j = false;
        this.k = "";
        this.l = "0";
        this.f67713a = str;
        this.f67714b = str;
        this.f67715c = -1;
        this.f67717e = jSONObject;
        this.f67719g = i2;
        if ((i2 & 2) == 0) {
            this.f67718f = System.currentTimeMillis();
        }
    }

    public o(String str, String str2, int i2, String str3, int i3) {
        this.f67716d = "";
        this.j = false;
        this.k = "";
        this.l = "0";
        this.f67713a = str2;
        this.f67714b = str;
        this.f67715c = i2;
        this.f67716d = str3;
        this.f67719g = i3;
        if ((i3 & 2) == 0) {
            this.f67718f = System.currentTimeMillis();
        }
    }

    public o(String str, String str2, int i2, String str3, long j, int i3) {
        this.f67716d = "";
        this.j = false;
        this.k = "";
        this.l = "0";
        this.f67713a = str2;
        this.f67714b = str;
        this.f67715c = i2;
        this.f67716d = str3;
        this.f67719g = i3;
        if ((i3 & 2) == 0) {
            if (j > 0) {
                this.f67718f = j;
            } else {
                this.f67718f = System.currentTimeMillis();
            }
        }
    }
}
