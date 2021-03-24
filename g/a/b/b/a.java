package g.a.b.b;
/* loaded from: classes7.dex */
public abstract class a extends d implements g.a.a.b {
    public Class[] i;
    public Class[] j;

    public a(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i, str, cls);
        this.i = clsArr;
        this.j = clsArr2;
    }

    public Class[] l() {
        if (this.j == null) {
            this.j = e(5);
        }
        return this.j;
    }

    public Class[] m() {
        if (this.i == null) {
            this.i = e(3);
        }
        return this.i;
    }
}
