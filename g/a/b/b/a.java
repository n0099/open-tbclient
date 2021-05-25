package g.a.b.b;
/* loaded from: classes7.dex */
public abstract class a extends d implements g.a.a.b {

    /* renamed from: i  reason: collision with root package name */
    public Class[] f68278i;
    public Class[] j;

    public a(int i2, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i2, str, cls);
        this.f68278i = clsArr;
        this.j = clsArr2;
    }

    public Class[] l() {
        if (this.j == null) {
            this.j = e(5);
        }
        return this.j;
    }

    public Class[] m() {
        if (this.f68278i == null) {
            this.f68278i = e(3);
        }
        return this.f68278i;
    }
}
