package d.a.l0.n.i.m;
/* loaded from: classes3.dex */
public abstract class g {

    /* renamed from: a  reason: collision with root package name */
    public int f48122a;

    /* renamed from: b  reason: collision with root package name */
    public String f48123b = "-1";

    /* renamed from: c  reason: collision with root package name */
    public String f48124c = "-1";

    public g(int i2) {
        this.f48122a = i2;
    }

    public int a() {
        return this.f48122a;
    }

    public String b() {
        return this.f48123b;
    }

    public String c() {
        return this.f48124c;
    }

    public g d(String str) {
        this.f48123b = str;
        return this;
    }

    public g e(String str) {
        this.f48124c = str;
        return this;
    }
}
