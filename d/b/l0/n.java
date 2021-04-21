package d.b.l0;

import com.baidu.ubc.UBC;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    public String f64953a;

    /* renamed from: b  reason: collision with root package name */
    public String f64954b;

    /* renamed from: c  reason: collision with root package name */
    public int f64955c;

    /* renamed from: d  reason: collision with root package name */
    public String f64956d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f64957e;

    /* renamed from: f  reason: collision with root package name */
    public long f64958f;

    /* renamed from: g  reason: collision with root package name */
    public int f64959g;

    /* renamed from: h  reason: collision with root package name */
    public String f64960h;
    public String i;
    public boolean j;
    public String k;
    public String l;

    public n(String str, String str2, int i) {
        this.f64956d = "";
        this.j = false;
        this.k = "";
        this.l = "0";
        this.f64953a = str;
        this.f64954b = str;
        this.f64955c = -1;
        this.f64956d = str2;
        this.f64959g = i;
        if ((i & 2) == 0) {
            this.f64958f = System.currentTimeMillis();
        }
    }

    public String a() {
        return this.i;
    }

    public String b() {
        return this.f64956d;
    }

    public String c() {
        return this.f64960h;
    }

    public String d() {
        return this.k;
    }

    public int e() {
        return this.f64955c;
    }

    public String f() {
        return this.f64954b;
    }

    public String g() {
        return this.f64953a;
    }

    public JSONObject h() {
        return this.f64957e;
    }

    public int i() {
        return this.f64959g;
    }

    public String j() {
        return this.l;
    }

    public long k() {
        return this.f64958f;
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
        String str = this.f64953a;
        if (str != null && str.equals(this.f64954b) && g.m().a(this.f64953a)) {
            this.f64960h = UBC.getUBCContext().i();
        }
    }

    public void p(String str) {
        this.k = str;
    }

    public void q(String str) {
        this.l = str;
    }

    public n(String str, JSONObject jSONObject, int i) {
        this.f64956d = "";
        this.j = false;
        this.k = "";
        this.l = "0";
        this.f64953a = str;
        this.f64954b = str;
        this.f64955c = -1;
        this.f64957e = jSONObject;
        this.f64959g = i;
        if ((i & 2) == 0) {
            this.f64958f = System.currentTimeMillis();
        }
    }

    public n(String str, String str2, int i, String str3, int i2) {
        this.f64956d = "";
        this.j = false;
        this.k = "";
        this.l = "0";
        this.f64953a = str2;
        this.f64954b = str;
        this.f64955c = i;
        this.f64956d = str3;
        this.f64959g = i2;
        if ((i2 & 2) == 0) {
            this.f64958f = System.currentTimeMillis();
        }
    }

    public n(String str, String str2, int i, String str3, long j, int i2) {
        this.f64956d = "";
        this.j = false;
        this.k = "";
        this.l = "0";
        this.f64953a = str2;
        this.f64954b = str;
        this.f64955c = i;
        this.f64956d = str3;
        this.f64959g = i2;
        if ((i2 & 2) == 0) {
            if (j > 0) {
                this.f64958f = j;
            } else {
                this.f64958f = System.currentTimeMillis();
            }
        }
    }
}
