package d.b.h0.w.p;
/* loaded from: classes3.dex */
public abstract class a implements Comparable<a> {

    /* renamed from: d.b.h0.w.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1122a {
        void a(c cVar);
    }

    public a() {
        d();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(a aVar) {
        if (aVar == null) {
            return 1;
        }
        return c() - aVar.c();
    }

    public abstract void b(InterfaceC1122a interfaceC1122a);

    public abstract int c();

    public abstract void d();
}
