package d.a.l0.n.i.m;
/* loaded from: classes3.dex */
public class f extends g {

    /* renamed from: d  reason: collision with root package name */
    public String f51790d;

    /* renamed from: e  reason: collision with root package name */
    public String f51791e;

    /* renamed from: f  reason: collision with root package name */
    public int f51792f;

    /* renamed from: g  reason: collision with root package name */
    public String f51793g;

    /* renamed from: h  reason: collision with root package name */
    public String f51794h;

    /* renamed from: i  reason: collision with root package name */
    public int f51795i;

    public f(String str, int i2, String str2, int i3) {
        super(i3);
        this.f51795i = -1;
        this.f51790d = str;
        this.f51791e = str2;
        this.f51792f = i2;
    }

    public String f() {
        return this.f51790d;
    }

    public int g() {
        return this.f51795i;
    }

    public String h() {
        return this.f51794h;
    }

    public String i() {
        return this.f51793g;
    }

    public int j() {
        return this.f51792f;
    }

    public String k() {
        return this.f51791e;
    }

    public void l(String str) {
        this.f51794h = str;
    }

    public f m(String str) {
        this.f51793g = str;
        return this;
    }

    public f(String str, String str2, String str3, int i2) {
        super(i2);
        this.f51795i = -1;
        this.f51790d = str;
        this.f51791e = str3;
        try {
            this.f51792f = Integer.valueOf(str2).intValue();
        } catch (NumberFormatException unused) {
            this.f51792f = 0;
        }
    }
}
