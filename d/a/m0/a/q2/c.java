package d.a.m0.a.q2;

import java.util.Locale;
/* loaded from: classes3.dex */
public final class c<ValueT> {

    /* renamed from: a  reason: collision with root package name */
    public final String f48008a;

    /* renamed from: b  reason: collision with root package name */
    public ValueT f48009b;

    /* renamed from: c  reason: collision with root package name */
    public a<ValueT> f48010c;

    /* loaded from: classes3.dex */
    public interface a<ValueT> {
        ValueT update() throws IllegalStateException;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v1, resolved type: d.a.m0.a.q2.e */
    /* JADX WARN: Multi-variable type inference failed */
    public c(String str) {
        this.f48008a = str;
        e.a().h(this);
    }

    public CharSequence a() {
        ValueT valuet = this.f48009b;
        return valuet == null ? "" : valuet.toString();
    }

    public boolean b() {
        return c(this.f48010c);
    }

    public boolean c(a<ValueT> aVar) {
        if (aVar != null) {
            try {
                return d(aVar.update());
            } catch (IllegalStateException e2) {
                d.a.m0.a.e0.d.l("Tracer", "index update IllegalStateException " + e2.getMessage());
                return false;
            }
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v1, resolved type: d.a.m0.a.q2.e */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean d(ValueT valuet) {
        this.f48009b = valuet;
        e.a().e(this);
        return true;
    }

    public c<ValueT> e(a<ValueT> aVar) {
        this.f48010c = aVar;
        b();
        return this;
    }

    public String toString() {
        return String.format(Locale.getDefault(), "%s :: %s(%s)", super.toString(), this.f48008a, a());
    }
}
