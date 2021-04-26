package d.a.h0.a.f2;

import java.util.Locale;
/* loaded from: classes3.dex */
public final class c<ValueT> {

    /* renamed from: a  reason: collision with root package name */
    public final String f42490a;

    /* renamed from: b  reason: collision with root package name */
    public ValueT f42491b;

    /* renamed from: c  reason: collision with root package name */
    public a<ValueT> f42492c;

    /* loaded from: classes3.dex */
    public interface a<ValueT> {
        ValueT update() throws IllegalStateException;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v1, resolved type: d.a.h0.a.f2.e */
    /* JADX WARN: Multi-variable type inference failed */
    public c(String str) {
        this.f42490a = str;
        e.a().h(this);
    }

    public CharSequence a() {
        ValueT valuet = this.f42491b;
        return valuet == null ? "" : valuet.toString();
    }

    public boolean b() {
        return c(this.f42492c);
    }

    public boolean c(a<ValueT> aVar) {
        if (aVar != null) {
            try {
                return d(aVar.update());
            } catch (IllegalStateException e2) {
                d.a.h0.a.c0.c.l("Tracer", "index update IllegalStateException " + e2.getMessage());
                return false;
            }
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v1, resolved type: d.a.h0.a.f2.e */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean d(ValueT valuet) {
        this.f42491b = valuet;
        e.a().e(this);
        return true;
    }

    public c<ValueT> e(a<ValueT> aVar) {
        this.f42492c = aVar;
        b();
        return this;
    }

    public String toString() {
        return String.format(Locale.getDefault(), "%s :: %s(%s)", super.toString(), this.f42490a, a());
    }
}
