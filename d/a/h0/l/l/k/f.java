package d.a.h0.l.l.k;
/* loaded from: classes3.dex */
public class f extends g {

    /* renamed from: d  reason: collision with root package name */
    public String f47244d;

    /* renamed from: e  reason: collision with root package name */
    public String f47245e;

    /* renamed from: f  reason: collision with root package name */
    public int f47246f;

    /* renamed from: g  reason: collision with root package name */
    public String f47247g;

    /* renamed from: h  reason: collision with root package name */
    public String f47248h;

    /* renamed from: i  reason: collision with root package name */
    public int f47249i;

    public f(String str, int i2, String str2, int i3) {
        super(i3);
        this.f47249i = -1;
        this.f47244d = str;
        this.f47245e = str2;
        this.f47246f = i2;
    }

    public String f() {
        return this.f47244d;
    }

    public int g() {
        return this.f47249i;
    }

    public String h() {
        return this.f47248h;
    }

    public String i() {
        return this.f47247g;
    }

    public int j() {
        return this.f47246f;
    }

    public String k() {
        return this.f47245e;
    }

    public void l(String str) {
        this.f47248h = str;
    }

    public f m(String str) {
        this.f47247g = str;
        return this;
    }

    public f(String str, String str2, String str3, int i2) {
        super(i2);
        this.f47249i = -1;
        this.f47244d = str;
        this.f47245e = str3;
        try {
            this.f47246f = Integer.valueOf(str2).intValue();
        } catch (NumberFormatException unused) {
            this.f47246f = 0;
        }
    }
}
