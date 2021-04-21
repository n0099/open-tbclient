package d.b.c.e.b.b.a.d;
/* loaded from: classes.dex */
public class a implements h {

    /* renamed from: a  reason: collision with root package name */
    public Object f42376a;

    public a(Object obj) {
        if (obj == null || !obj.getClass().isArray()) {
            return;
        }
        this.f42376a = obj;
    }

    @Override // d.b.c.e.b.b.a.d.h
    public Object a(d.b.c.e.b.b.a.e.c cVar) {
        Object obj = this.f42376a;
        if (obj != null) {
            return d.b.c.e.b.b.a.e.b.b(obj, cVar);
        }
        return null;
    }
}
