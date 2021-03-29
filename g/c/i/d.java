package g.c.i;
/* loaded from: classes7.dex */
public class d extends g implements b {

    /* renamed from: c  reason: collision with root package name */
    public String f67643c = "*";

    @Override // g.c.i.a
    public String d() {
        return this.f67643c;
    }

    @Override // g.c.i.b
    public void g(String str) throws IllegalArgumentException {
        if (str != null) {
            this.f67643c = str;
            return;
        }
        throw new IllegalArgumentException("http resource descriptor must not be null");
    }
}
