package d.b.g0.a.f2;

import java.util.Locale;
/* loaded from: classes3.dex */
public final class c<ValueT> {

    /* renamed from: a  reason: collision with root package name */
    public final String f44457a;

    /* renamed from: b  reason: collision with root package name */
    public ValueT f44458b;

    /* renamed from: c  reason: collision with root package name */
    public a<ValueT> f44459c;

    /* loaded from: classes3.dex */
    public interface a<ValueT> {
        ValueT update() throws IllegalStateException;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v1, resolved type: d.b.g0.a.f2.e */
    /* JADX WARN: Multi-variable type inference failed */
    public c(String str) {
        this.f44457a = str;
        e.a().h(this);
    }

    public CharSequence a() {
        ValueT valuet = this.f44458b;
        return valuet == null ? "" : valuet.toString();
    }

    public boolean b() {
        return c(this.f44459c);
    }

    public boolean c(a<ValueT> aVar) {
        if (aVar != null) {
            try {
                return d(aVar.update());
            } catch (IllegalStateException e2) {
                d.b.g0.a.c0.c.l("Tracer", "index update IllegalStateException " + e2.getMessage());
                return false;
            }
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v1, resolved type: d.b.g0.a.f2.e */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean d(ValueT valuet) {
        this.f44458b = valuet;
        e.a().e(this);
        return true;
    }

    public c<ValueT> e(a<ValueT> aVar) {
        this.f44459c = aVar;
        b();
        return this;
    }

    public String toString() {
        return String.format(Locale.getDefault(), "%s :: %s(%s)", super.toString(), this.f44457a, a());
    }
}
