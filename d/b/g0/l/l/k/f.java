package d.b.g0.l.l.k;
/* loaded from: classes3.dex */
public class f extends g {

    /* renamed from: d  reason: collision with root package name */
    public String f49402d;

    /* renamed from: e  reason: collision with root package name */
    public String f49403e;

    /* renamed from: f  reason: collision with root package name */
    public int f49404f;

    /* renamed from: g  reason: collision with root package name */
    public String f49405g;

    /* renamed from: h  reason: collision with root package name */
    public String f49406h;
    public int i;

    public f(String str, int i, String str2, int i2) {
        super(i2);
        this.i = -1;
        this.f49402d = str;
        this.f49403e = str2;
        this.f49404f = i;
    }

    public String f() {
        return this.f49402d;
    }

    public int g() {
        return this.i;
    }

    public String h() {
        return this.f49406h;
    }

    public String i() {
        return this.f49405g;
    }

    public int j() {
        return this.f49404f;
    }

    public String k() {
        return this.f49403e;
    }

    public void l(String str) {
        this.f49406h = str;
    }

    public f m(String str) {
        this.f49405g = str;
        return this;
    }

    public f(String str, String str2, String str3, int i) {
        super(i);
        this.i = -1;
        this.f49402d = str;
        this.f49403e = str3;
        try {
            this.f49404f = Integer.valueOf(str2).intValue();
        } catch (NumberFormatException unused) {
            this.f49404f = 0;
        }
    }
}
