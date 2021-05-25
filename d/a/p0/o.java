package d.a.p0;

import com.baidu.ubc.UBC;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public String f63995a;

    /* renamed from: b  reason: collision with root package name */
    public String f63996b;

    /* renamed from: c  reason: collision with root package name */
    public int f63997c;

    /* renamed from: d  reason: collision with root package name */
    public String f63998d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f63999e;

    /* renamed from: f  reason: collision with root package name */
    public long f64000f;

    /* renamed from: g  reason: collision with root package name */
    public int f64001g;

    /* renamed from: h  reason: collision with root package name */
    public String f64002h;

    /* renamed from: i  reason: collision with root package name */
    public String f64003i;
    public boolean j;
    public String k;
    public String l;

    public o(String str, String str2, int i2) {
        this.f63998d = "";
        this.j = false;
        this.k = "";
        this.l = "0";
        this.f63995a = str;
        this.f63996b = str;
        this.f63997c = -1;
        this.f63998d = str2;
        this.f64001g = i2;
        if ((i2 & 2) == 0) {
            this.f64000f = System.currentTimeMillis();
        }
    }

    public String a() {
        return this.f64003i;
    }

    public String b() {
        return this.f63998d;
    }

    public String c() {
        return this.f64002h;
    }

    public String d() {
        return this.k;
    }

    public int e() {
        return this.f63997c;
    }

    public String f() {
        return this.f63996b;
    }

    public String g() {
        return this.f63995a;
    }

    public JSONObject h() {
        return this.f63999e;
    }

    public int i() {
        return this.f64001g;
    }

    public String j() {
        return this.l;
    }

    public long k() {
        return this.f64000f;
    }

    public boolean l() {
        return this.j;
    }

    public void m(String str) {
        this.f64003i = str;
    }

    public void n(boolean z) {
        this.j = z;
    }

    public void o() {
        String str = this.f63995a;
        if (str != null && str.equals(this.f63996b) && g.m().a(this.f63995a)) {
            this.f64002h = UBC.getUBCContext().h();
        }
    }

    public void p(String str) {
        this.k = str;
    }

    public void q(String str) {
        this.l = str;
    }

    public o(String str, JSONObject jSONObject, int i2) {
        this.f63998d = "";
        this.j = false;
        this.k = "";
        this.l = "0";
        this.f63995a = str;
        this.f63996b = str;
        this.f63997c = -1;
        this.f63999e = jSONObject;
        this.f64001g = i2;
        if ((i2 & 2) == 0) {
            this.f64000f = System.currentTimeMillis();
        }
    }

    public o(String str, String str2, int i2, String str3, int i3) {
        this.f63998d = "";
        this.j = false;
        this.k = "";
        this.l = "0";
        this.f63995a = str2;
        this.f63996b = str;
        this.f63997c = i2;
        this.f63998d = str3;
        this.f64001g = i3;
        if ((i3 & 2) == 0) {
            this.f64000f = System.currentTimeMillis();
        }
    }

    public o(String str, String str2, int i2, String str3, long j, int i3) {
        this.f63998d = "";
        this.j = false;
        this.k = "";
        this.l = "0";
        this.f63995a = str2;
        this.f63996b = str;
        this.f63997c = i2;
        this.f63998d = str3;
        this.f64001g = i3;
        if ((i3 & 2) == 0) {
            if (j > 0) {
                this.f64000f = j;
            } else {
                this.f64000f = System.currentTimeMillis();
            }
        }
    }
}
