package d.b.h0.a.f2;

import java.util.Locale;
/* loaded from: classes3.dex */
public final class c<ValueT> {

    /* renamed from: a  reason: collision with root package name */
    public final String f45179a;

    /* renamed from: b  reason: collision with root package name */
    public ValueT f45180b;

    /* renamed from: c  reason: collision with root package name */
    public a<ValueT> f45181c;

    /* loaded from: classes3.dex */
    public interface a<ValueT> {
        ValueT update() throws IllegalStateException;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v1, resolved type: d.b.h0.a.f2.e */
    /* JADX WARN: Multi-variable type inference failed */
    public c(String str) {
        this.f45179a = str;
        e.a().h(this);
    }

    public CharSequence a() {
        ValueT valuet = this.f45180b;
        return valuet == null ? "" : valuet.toString();
    }

    public boolean b() {
        return c(this.f45181c);
    }

    public boolean c(a<ValueT> aVar) {
        if (aVar != null) {
            try {
                return d(aVar.update());
            } catch (IllegalStateException e2) {
                d.b.h0.a.c0.c.l("Tracer", "index update IllegalStateException " + e2.getMessage());
                return false;
            }
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v1, resolved type: d.b.h0.a.f2.e */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean d(ValueT valuet) {
        this.f45180b = valuet;
        e.a().e(this);
        return true;
    }

    public c<ValueT> e(a<ValueT> aVar) {
        this.f45181c = aVar;
        b();
        return this;
    }

    public String toString() {
        return String.format(Locale.getDefault(), "%s :: %s(%s)", super.toString(), this.f45179a, a());
    }
}
