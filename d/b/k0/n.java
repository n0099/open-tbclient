package d.b.k0;

import com.baidu.ubc.UBC;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    public String f63971a;

    /* renamed from: b  reason: collision with root package name */
    public String f63972b;

    /* renamed from: c  reason: collision with root package name */
    public int f63973c;

    /* renamed from: d  reason: collision with root package name */
    public String f63974d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f63975e;

    /* renamed from: f  reason: collision with root package name */
    public long f63976f;

    /* renamed from: g  reason: collision with root package name */
    public int f63977g;

    /* renamed from: h  reason: collision with root package name */
    public String f63978h;
    public String i;
    public boolean j;
    public String k;
    public String l;

    public n(String str, String str2, int i) {
        this.f63974d = "";
        this.j = false;
        this.k = "";
        this.l = "0";
        this.f63971a = str;
        this.f63972b = str;
        this.f63973c = -1;
        this.f63974d = str2;
        this.f63977g = i;
        if ((i & 2) == 0) {
            this.f63976f = System.currentTimeMillis();
        }
    }

    public String a() {
        return this.i;
    }

    public String b() {
        return this.f63974d;
    }

    public String c() {
        return this.f63978h;
    }

    public String d() {
        return this.k;
    }

    public int e() {
        return this.f63973c;
    }

    public String f() {
        return this.f63972b;
    }

    public String g() {
        return this.f63971a;
    }

    public JSONObject h() {
        return this.f63975e;
    }

    public int i() {
        return this.f63977g;
    }

    public String j() {
        return this.l;
    }

    public long k() {
        return this.f63976f;
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
        String str = this.f63971a;
        if (str != null && str.equals(this.f63972b) && g.m().a(this.f63971a)) {
            this.f63978h = UBC.getUBCContext().i();
        }
    }

    public void p(String str) {
        this.k = str;
    }

    public void q(String str) {
        this.l = str;
    }

    public n(String str, JSONObject jSONObject, int i) {
        this.f63974d = "";
        this.j = false;
        this.k = "";
        this.l = "0";
        this.f63971a = str;
        this.f63972b = str;
        this.f63973c = -1;
        this.f63975e = jSONObject;
        this.f63977g = i;
        if ((i & 2) == 0) {
            this.f63976f = System.currentTimeMillis();
        }
    }

    public n(String str, String str2, int i, String str3, int i2) {
        this.f63974d = "";
        this.j = false;
        this.k = "";
        this.l = "0";
        this.f63971a = str2;
        this.f63972b = str;
        this.f63973c = i;
        this.f63974d = str3;
        this.f63977g = i2;
        if ((i2 & 2) == 0) {
            this.f63976f = System.currentTimeMillis();
        }
    }

    public n(String str, String str2, int i, String str3, long j, int i2) {
        this.f63974d = "";
        this.j = false;
        this.k = "";
        this.l = "0";
        this.f63971a = str2;
        this.f63972b = str;
        this.f63973c = i;
        this.f63974d = str3;
        this.f63977g = i2;
        if ((i2 & 2) == 0) {
            if (j > 0) {
                this.f63976f = j;
            } else {
                this.f63976f = System.currentTimeMillis();
            }
        }
    }
}
