package d.b.g0.l.l.k;
/* loaded from: classes3.dex */
public class f extends g {

    /* renamed from: d  reason: collision with root package name */
    public String f49010d;

    /* renamed from: e  reason: collision with root package name */
    public String f49011e;

    /* renamed from: f  reason: collision with root package name */
    public int f49012f;

    /* renamed from: g  reason: collision with root package name */
    public String f49013g;

    /* renamed from: h  reason: collision with root package name */
    public String f49014h;
    public int i;

    public f(String str, int i, String str2, int i2) {
        super(i2);
        this.i = -1;
        this.f49010d = str;
        this.f49011e = str2;
        this.f49012f = i;
    }

    public String f() {
        return this.f49010d;
    }

    public int g() {
        return this.i;
    }

    public String h() {
        return this.f49014h;
    }

    public String i() {
        return this.f49013g;
    }

    public int j() {
        return this.f49012f;
    }

    public String k() {
        return this.f49011e;
    }

    public void l(String str) {
        this.f49014h = str;
    }

    public f m(String str) {
        this.f49013g = str;
        return this;
    }

    public f(String str, String str2, String str3, int i) {
        super(i);
        this.i = -1;
        this.f49010d = str;
        this.f49011e = str3;
        try {
            this.f49012f = Integer.valueOf(str2).intValue();
        } catch (NumberFormatException unused) {
            this.f49012f = 0;
        }
    }
}
