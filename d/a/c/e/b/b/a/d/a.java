package d.a.c.e.b.b.a.d;
/* loaded from: classes.dex */
public class a implements h {

    /* renamed from: a  reason: collision with root package name */
    public Object f42131a;

    public a(Object obj) {
        if (obj == null || !obj.getClass().isArray()) {
            return;
        }
        this.f42131a = obj;
    }

    @Override // d.a.c.e.b.b.a.d.h
    public Object a(d.a.c.e.b.b.a.e.c cVar) {
        Object obj = this.f42131a;
        if (obj != null) {
            return d.a.c.e.b.b.a.e.b.b(obj, cVar);
        }
        return null;
    }
}
