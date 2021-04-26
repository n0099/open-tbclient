package d.a.l0;

import com.baidu.ubc.UBC;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public String f63258a;

    /* renamed from: b  reason: collision with root package name */
    public String f63259b;

    /* renamed from: c  reason: collision with root package name */
    public int f63260c;

    /* renamed from: d  reason: collision with root package name */
    public String f63261d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f63262e;

    /* renamed from: f  reason: collision with root package name */
    public long f63263f;

    /* renamed from: g  reason: collision with root package name */
    public int f63264g;

    /* renamed from: h  reason: collision with root package name */
    public String f63265h;

    /* renamed from: i  reason: collision with root package name */
    public String f63266i;
    public boolean j;
    public String k;
    public String l;

    public o(String str, String str2, int i2) {
        this.f63261d = "";
        this.j = false;
        this.k = "";
        this.l = "0";
        this.f63258a = str;
        this.f63259b = str;
        this.f63260c = -1;
        this.f63261d = str2;
        this.f63264g = i2;
        if ((i2 & 2) == 0) {
            this.f63263f = System.currentTimeMillis();
        }
    }

    public String a() {
        return this.f63266i;
    }

    public String b() {
        return this.f63261d;
    }

    public String c() {
        return this.f63265h;
    }

    public String d() {
        return this.k;
    }

    public int e() {
        return this.f63260c;
    }

    public String f() {
        return this.f63259b;
    }

    public String g() {
        return this.f63258a;
    }

    public JSONObject h() {
        return this.f63262e;
    }

    public int i() {
        return this.f63264g;
    }

    public String j() {
        return this.l;
    }

    public long k() {
        return this.f63263f;
    }

    public boolean l() {
        return this.j;
    }

    public void m(String str) {
        this.f63266i = str;
    }

    public void n(boolean z) {
        this.j = z;
    }

    public void o() {
        String str = this.f63258a;
        if (str != null && str.equals(this.f63259b) && g.m().a(this.f63258a)) {
            this.f63265h = UBC.getUBCContext().g();
        }
    }

    public void p(String str) {
        this.k = str;
    }

    public void q(String str) {
        this.l = str;
    }

    public o(String str, JSONObject jSONObject, int i2) {
        this.f63261d = "";
        this.j = false;
        this.k = "";
        this.l = "0";
        this.f63258a = str;
        this.f63259b = str;
        this.f63260c = -1;
        this.f63262e = jSONObject;
        this.f63264g = i2;
        if ((i2 & 2) == 0) {
            this.f63263f = System.currentTimeMillis();
        }
    }

    public o(String str, String str2, int i2, String str3, int i3) {
        this.f63261d = "";
        this.j = false;
        this.k = "";
        this.l = "0";
        this.f63258a = str2;
        this.f63259b = str;
        this.f63260c = i2;
        this.f63261d = str3;
        this.f63264g = i3;
        if ((i3 & 2) == 0) {
            this.f63263f = System.currentTimeMillis();
        }
    }

    public o(String str, String str2, int i2, String str3, long j, int i3) {
        this.f63261d = "";
        this.j = false;
        this.k = "";
        this.l = "0";
        this.f63258a = str2;
        this.f63259b = str;
        this.f63260c = i2;
        this.f63261d = str3;
        this.f63264g = i3;
        if ((i3 & 2) == 0) {
            if (j > 0) {
                this.f63263f = j;
            } else {
                this.f63263f = System.currentTimeMillis();
            }
        }
    }
}
