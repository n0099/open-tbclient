package g.c.i;
/* loaded from: classes7.dex */
public class d extends g implements b {

    /* renamed from: c  reason: collision with root package name */
    public String f68796c = "*";

    @Override // g.c.i.a
    public String c() {
        return this.f68796c;
    }

    @Override // g.c.i.b
    public void f(String str) throws IllegalArgumentException {
        if (str != null) {
            this.f68796c = str;
            return;
        }
        throw new IllegalArgumentException("http resource descriptor must not be null");
    }
}
