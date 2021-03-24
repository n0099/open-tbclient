package d.b.b.e.b.b.a.d;
/* loaded from: classes.dex */
public class a implements h {

    /* renamed from: a  reason: collision with root package name */
    public Object f41638a;

    public a(Object obj) {
        if (obj == null || !obj.getClass().isArray()) {
            return;
        }
        this.f41638a = obj;
    }

    @Override // d.b.b.e.b.b.a.d.h
    public Object a(d.b.b.e.b.b.a.e.c cVar) {
        Object obj = this.f41638a;
        if (obj != null) {
            return d.b.b.e.b.b.a.e.b.b(obj, cVar);
        }
        return null;
    }
}
