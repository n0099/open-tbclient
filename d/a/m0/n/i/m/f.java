package d.a.m0.n.i.m;
/* loaded from: classes3.dex */
public class f extends g {

    /* renamed from: d  reason: collision with root package name */
    public String f51898d;

    /* renamed from: e  reason: collision with root package name */
    public String f51899e;

    /* renamed from: f  reason: collision with root package name */
    public int f51900f;

    /* renamed from: g  reason: collision with root package name */
    public String f51901g;

    /* renamed from: h  reason: collision with root package name */
    public String f51902h;

    /* renamed from: i  reason: collision with root package name */
    public int f51903i;

    public f(String str, int i2, String str2, int i3) {
        super(i3);
        this.f51903i = -1;
        this.f51898d = str;
        this.f51899e = str2;
        this.f51900f = i2;
    }

    public String f() {
        return this.f51898d;
    }

    public int g() {
        return this.f51903i;
    }

    public String h() {
        return this.f51902h;
    }

    public String i() {
        return this.f51901g;
    }

    public int j() {
        return this.f51900f;
    }

    public String k() {
        return this.f51899e;
    }

    public void l(String str) {
        this.f51902h = str;
    }

    public f m(String str) {
        this.f51901g = str;
        return this;
    }

    public f(String str, String str2, String str3, int i2) {
        super(i2);
        this.f51903i = -1;
        this.f51898d = str;
        this.f51899e = str3;
        try {
            this.f51900f = Integer.valueOf(str2).intValue();
        } catch (NumberFormatException unused) {
            this.f51900f = 0;
        }
    }
}
