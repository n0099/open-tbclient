package d.a.i0.n.i.m;
/* loaded from: classes3.dex */
public class f extends g {

    /* renamed from: d  reason: collision with root package name */
    public String f47940d;

    /* renamed from: e  reason: collision with root package name */
    public String f47941e;

    /* renamed from: f  reason: collision with root package name */
    public int f47942f;

    /* renamed from: g  reason: collision with root package name */
    public String f47943g;

    /* renamed from: h  reason: collision with root package name */
    public String f47944h;

    /* renamed from: i  reason: collision with root package name */
    public int f47945i;

    public f(String str, int i2, String str2, int i3) {
        super(i3);
        this.f47945i = -1;
        this.f47940d = str;
        this.f47941e = str2;
        this.f47942f = i2;
    }

    public String f() {
        return this.f47940d;
    }

    public int g() {
        return this.f47945i;
    }

    public String h() {
        return this.f47944h;
    }

    public String i() {
        return this.f47943g;
    }

    public int j() {
        return this.f47942f;
    }

    public String k() {
        return this.f47941e;
    }

    public void l(String str) {
        this.f47944h = str;
    }

    public f m(String str) {
        this.f47943g = str;
        return this;
    }

    public f(String str, String str2, String str3, int i2) {
        super(i2);
        this.f47945i = -1;
        this.f47940d = str;
        this.f47941e = str3;
        try {
            this.f47942f = Integer.valueOf(str2).intValue();
        } catch (NumberFormatException unused) {
            this.f47942f = 0;
        }
    }
}
