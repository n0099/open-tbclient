package g.c.j;
/* loaded from: classes8.dex */
public class b implements a {

    /* renamed from: a  reason: collision with root package name */
    public final String f71647a;

    public b(String str) {
        if (str != null) {
            this.f71647a = str;
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
            if (this.f71647a.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    @Override // g.c.j.a
    public String c() {
        return this.f71647a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        return this.f71647a.equals(((b) obj).f71647a);
    }

    public int hashCode() {
        return this.f71647a.hashCode();
    }

    @Override // g.c.j.a
    public String toString() {
        return c();
    }
}
