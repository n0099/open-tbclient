package d.a.l0.n.i.m;
/* loaded from: classes3.dex */
public class f extends g {

    /* renamed from: d  reason: collision with root package name */
    public String f48116d;

    /* renamed from: e  reason: collision with root package name */
    public String f48117e;

    /* renamed from: f  reason: collision with root package name */
    public int f48118f;

    /* renamed from: g  reason: collision with root package name */
    public String f48119g;

    /* renamed from: h  reason: collision with root package name */
    public String f48120h;

    /* renamed from: i  reason: collision with root package name */
    public int f48121i;

    public f(String str, int i2, String str2, int i3) {
        super(i3);
        this.f48121i = -1;
        this.f48116d = str;
        this.f48117e = str2;
        this.f48118f = i2;
    }

    public String f() {
        return this.f48116d;
    }

    public int g() {
        return this.f48121i;
    }

    public String h() {
        return this.f48120h;
    }

    public String i() {
        return this.f48119g;
    }

    public int j() {
        return this.f48118f;
    }

    public String k() {
        return this.f48117e;
    }

    public void l(String str) {
        this.f48120h = str;
    }

    public f m(String str) {
        this.f48119g = str;
        return this;
    }

    public f(String str, String str2, String str3, int i2) {
        super(i2);
        this.f48121i = -1;
        this.f48116d = str;
        this.f48117e = str3;
        try {
            this.f48118f = Integer.valueOf(str2).intValue();
        } catch (NumberFormatException unused) {
            this.f48118f = 0;
        }
    }
}
