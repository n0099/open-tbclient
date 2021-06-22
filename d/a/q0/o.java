package d.a.q0;

import com.baidu.ubc.UBC;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public String f68127a;

    /* renamed from: b  reason: collision with root package name */
    public String f68128b;

    /* renamed from: c  reason: collision with root package name */
    public int f68129c;

    /* renamed from: d  reason: collision with root package name */
    public String f68130d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f68131e;

    /* renamed from: f  reason: collision with root package name */
    public long f68132f;

    /* renamed from: g  reason: collision with root package name */
    public int f68133g;

    /* renamed from: h  reason: collision with root package name */
    public String f68134h;

    /* renamed from: i  reason: collision with root package name */
    public String f68135i;
    public boolean j;
    public String k;
    public String l;

    public o(String str, String str2, int i2) {
        this.f68130d = "";
        this.j = false;
        this.k = "";
        this.l = "0";
        this.f68127a = str;
        this.f68128b = str;
        this.f68129c = -1;
        this.f68130d = str2;
        this.f68133g = i2;
        if ((i2 & 2) == 0) {
            this.f68132f = System.currentTimeMillis();
        }
    }

    public String a() {
        return this.f68135i;
    }

    public String b() {
        return this.f68130d;
    }

    public String c() {
        return this.f68134h;
    }

    public String d() {
        return this.k;
    }

    public int e() {
        return this.f68129c;
    }

    public String f() {
        return this.f68128b;
    }

    public String g() {
        return this.f68127a;
    }

    public JSONObject h() {
        return this.f68131e;
    }

    public int i() {
        return this.f68133g;
    }

    public String j() {
        return this.l;
    }

    public long k() {
        return this.f68132f;
    }

    public boolean l() {
        return this.j;
    }

    public void m(String str) {
        this.f68135i = str;
    }

    public void n(boolean z) {
        this.j = z;
    }

    public void o() {
        String str = this.f68127a;
        if (str != null && str.equals(this.f68128b) && g.m().a(this.f68127a)) {
            this.f68134h = UBC.getUBCContext().h();
        }
    }

    public void p(String str) {
        this.k = str;
    }

    public void q(String str) {
        this.l = str;
    }

    public o(String str, JSONObject jSONObject, int i2) {
        this.f68130d = "";
        this.j = false;
        this.k = "";
        this.l = "0";
        this.f68127a = str;
        this.f68128b = str;
        this.f68129c = -1;
        this.f68131e = jSONObject;
        this.f68133g = i2;
        if ((i2 & 2) == 0) {
            this.f68132f = System.currentTimeMillis();
        }
    }

    public o(String str, String str2, int i2, String str3, int i3) {
        this.f68130d = "";
        this.j = false;
        this.k = "";
        this.l = "0";
        this.f68127a = str2;
        this.f68128b = str;
        this.f68129c = i2;
        this.f68130d = str3;
        this.f68133g = i3;
        if ((i3 & 2) == 0) {
            this.f68132f = System.currentTimeMillis();
        }
    }

    public o(String str, String str2, int i2, String str3, long j, int i3) {
        this.f68130d = "";
        this.j = false;
        this.k = "";
        this.l = "0";
        this.f68127a = str2;
        this.f68128b = str;
        this.f68129c = i2;
        this.f68130d = str3;
        this.f68133g = i3;
        if ((i3 & 2) == 0) {
            if (j > 0) {
                this.f68132f = j;
            } else {
                this.f68132f = System.currentTimeMillis();
            }
        }
    }
}
