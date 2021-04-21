package d.b.c.e.b.b.a.b;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class m implements h {

    /* renamed from: a  reason: collision with root package name */
    public OrmObject f42359a;

    public m(OrmObject ormObject) {
        this.f42359a = ormObject;
    }

    @Override // d.b.c.e.b.b.a.b.h
    public Object a(d.b.c.e.b.b.a.e.c cVar) {
        Object f2 = f(cVar);
        if (f2 != null) {
            if (f2 instanceof JSONObject) {
                return f2.toString();
            }
            return f2 instanceof JSONArray ? f2.toString() : f2;
        }
        return null;
    }

    @Override // d.b.c.e.b.b.a.b.h
    public Object b(d.b.c.e.b.b.a.e.c cVar) {
        return e(cVar);
    }

    @Override // d.b.c.e.b.b.a.b.h
    public Object c(d.b.c.e.b.b.a.e.c cVar) {
        return this.f42359a;
    }

    @Override // d.b.c.e.b.b.a.b.h
    public Object d(d.b.c.e.b.b.a.e.c cVar) {
        return this.f42359a;
    }

    @Override // d.b.c.e.b.b.a.b.h
    public Object e(d.b.c.e.b.b.a.e.c cVar) {
        Object f2 = f(cVar);
        if (f2 == null || !(f2 instanceof JSONObject)) {
            return null;
        }
        return f2.toString();
    }

    @Override // d.b.c.e.b.b.a.b.h
    public Object f(d.b.c.e.b.b.a.e.c cVar) {
        return OrmObject.jsonWithObject(this.f42359a);
    }
}
