package g.a.b.b;
/* loaded from: classes8.dex */
public class e extends a implements g.a.a.c.a {
    public Class k;

    public e(int i2, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2, Class cls2) {
        super(i2, str, cls, clsArr, strArr, clsArr2);
        this.k = cls2;
    }

    @Override // g.a.b.b.f
    public String a(h hVar) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(hVar.e(i()));
        if (hVar.f71667b) {
            stringBuffer.append(hVar.g(n()));
        }
        if (hVar.f71667b) {
            stringBuffer.append(" ");
        }
        stringBuffer.append(hVar.f(f(), g()));
        stringBuffer.append(".");
        stringBuffer.append(j());
        hVar.a(stringBuffer, m());
        hVar.b(stringBuffer, l());
        return stringBuffer.toString();
    }

    public Class n() {
        if (this.k == null) {
            this.k = d(6);
        }
        return this.k;
    }
}
