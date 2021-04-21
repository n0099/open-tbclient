package d.b.h0.l.l.k;
/* loaded from: classes3.dex */
public class f extends g {

    /* renamed from: d  reason: collision with root package name */
    public String f49731d;

    /* renamed from: e  reason: collision with root package name */
    public String f49732e;

    /* renamed from: f  reason: collision with root package name */
    public int f49733f;

    /* renamed from: g  reason: collision with root package name */
    public String f49734g;

    /* renamed from: h  reason: collision with root package name */
    public String f49735h;
    public int i;

    public f(String str, int i, String str2, int i2) {
        super(i2);
        this.i = -1;
        this.f49731d = str;
        this.f49732e = str2;
        this.f49733f = i;
    }

    public String f() {
        return this.f49731d;
    }

    public int g() {
        return this.i;
    }

    public String h() {
        return this.f49735h;
    }

    public String i() {
        return this.f49734g;
    }

    public int j() {
        return this.f49733f;
    }

    public String k() {
        return this.f49732e;
    }

    public void l(String str) {
        this.f49735h = str;
    }

    public f m(String str) {
        this.f49734g = str;
        return this;
    }

    public f(String str, String str2, String str3, int i) {
        super(i);
        this.i = -1;
        this.f49731d = str;
        this.f49732e = str3;
        try {
            this.f49733f = Integer.valueOf(str2).intValue();
        } catch (NumberFormatException unused) {
            this.f49733f = 0;
        }
    }
}
