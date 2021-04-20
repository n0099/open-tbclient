package g.c.j;
/* loaded from: classes7.dex */
public class b implements a {

    /* renamed from: a  reason: collision with root package name */
    public final String f68653a;

    public b(String str) {
        if (str != null) {
            this.f68653a = str;
            return;
        }
        throw new IllegalArgumentException();
    }

    @Override // g.c.j.a
    public a a() {
        return new b(c());
    }

    @Override // g.c.j.a
    public boolean b(String str) {
        for (String str2 : str.replaceAll(" ", "").split(",")) {
            if (this.f68653a.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    @Override // g.c.j.a
    public String c() {
        return this.f68653a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        return this.f68653a.equals(((b) obj).f68653a);
    }

    public int hashCode() {
        return this.f68653a.hashCode();
    }

    @Override // g.c.j.a
    public String toString() {
        return c();
    }
}
