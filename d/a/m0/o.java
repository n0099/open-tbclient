package d.a.m0;

import com.baidu.ubc.UBC;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public String f63982a;

    /* renamed from: b  reason: collision with root package name */
    public String f63983b;

    /* renamed from: c  reason: collision with root package name */
    public int f63984c;

    /* renamed from: d  reason: collision with root package name */
    public String f63985d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f63986e;

    /* renamed from: f  reason: collision with root package name */
    public long f63987f;

    /* renamed from: g  reason: collision with root package name */
    public int f63988g;

    /* renamed from: h  reason: collision with root package name */
    public String f63989h;

    /* renamed from: i  reason: collision with root package name */
    public String f63990i;
    public boolean j;
    public String k;
    public String l;

    public o(String str, String str2, int i2) {
        this.f63985d = "";
        this.j = false;
        this.k = "";
        this.l = "0";
        this.f63982a = str;
        this.f63983b = str;
        this.f63984c = -1;
        this.f63985d = str2;
        this.f63988g = i2;
        if ((i2 & 2) == 0) {
            this.f63987f = System.currentTimeMillis();
        }
    }

    public String a() {
        return this.f63990i;
    }

    public String b() {
        return this.f63985d;
    }

    public String c() {
        return this.f63989h;
    }

    public String d() {
        return this.k;
    }

    public int e() {
        return this.f63984c;
    }

    public String f() {
        return this.f63983b;
    }

    public String g() {
        return this.f63982a;
    }

    public JSONObject h() {
        return this.f63986e;
    }

    public int i() {
        return this.f63988g;
    }

    public String j() {
        return this.l;
    }

    public long k() {
        return this.f63987f;
    }

    public boolean l() {
        return this.j;
    }

    public void m(String str) {
        this.f63990i = str;
    }

    public void n(boolean z) {
        this.j = z;
    }

    public void o() {
        String str = this.f63982a;
        if (str != null && str.equals(this.f63983b) && g.m().a(this.f63982a)) {
            this.f63989h = UBC.getUBCContext().h();
        }
    }

    public void p(String str) {
        this.k = str;
    }

    public void q(String str) {
        this.l = str;
    }

    public o(String str, JSONObject jSONObject, int i2) {
        this.f63985d = "";
        this.j = false;
        this.k = "";
        this.l = "0";
        this.f63982a = str;
        this.f63983b = str;
        this.f63984c = -1;
        this.f63986e = jSONObject;
        this.f63988g = i2;
        if ((i2 & 2) == 0) {
            this.f63987f = System.currentTimeMillis();
        }
    }

    public o(String str, String str2, int i2, String str3, int i3) {
        this.f63985d = "";
        this.j = false;
        this.k = "";
        this.l = "0";
        this.f63982a = str2;
        this.f63983b = str;
        this.f63984c = i2;
        this.f63985d = str3;
        this.f63988g = i3;
        if ((i3 & 2) == 0) {
            this.f63987f = System.currentTimeMillis();
        }
    }

    public o(String str, String str2, int i2, String str3, long j, int i3) {
        this.f63985d = "";
        this.j = false;
        this.k = "";
        this.l = "0";
        this.f63982a = str2;
        this.f63983b = str;
        this.f63984c = i2;
        this.f63985d = str3;
        this.f63988g = i3;
        if ((i3 & 2) == 0) {
            if (j > 0) {
                this.f63987f = j;
            } else {
                this.f63987f = System.currentTimeMillis();
            }
        }
    }
}
