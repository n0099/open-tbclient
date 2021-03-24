package d.b.g0.l.l.k;
/* loaded from: classes3.dex */
public class f extends g {

    /* renamed from: d  reason: collision with root package name */
    public String f49009d;

    /* renamed from: e  reason: collision with root package name */
    public String f49010e;

    /* renamed from: f  reason: collision with root package name */
    public int f49011f;

    /* renamed from: g  reason: collision with root package name */
    public String f49012g;

    /* renamed from: h  reason: collision with root package name */
    public String f49013h;
    public int i;

    public f(String str, int i, String str2, int i2) {
        super(i2);
        this.i = -1;
        this.f49009d = str;
        this.f49010e = str2;
        this.f49011f = i;
    }

    public String f() {
        return this.f49009d;
    }

    public int g() {
        return this.i;
    }

    public String h() {
        return this.f49013h;
    }

    public String i() {
        return this.f49012g;
    }

    public int j() {
        return this.f49011f;
    }

    public String k() {
        return this.f49010e;
    }

    public void l(String str) {
        this.f49013h = str;
    }

    public f m(String str) {
        this.f49012g = str;
        return this;
    }

    public f(String str, String str2, String str3, int i) {
        super(i);
        this.i = -1;
        this.f49009d = str;
        this.f49010e = str3;
        try {
            this.f49011f = Integer.valueOf(str2).intValue();
        } catch (NumberFormatException unused) {
            this.f49011f = 0;
        }
    }
}
