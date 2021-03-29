package d.b.b.e.b.b.a.b;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class m implements h {

    /* renamed from: a  reason: collision with root package name */
    public OrmObject f41622a;

    public m(OrmObject ormObject) {
        this.f41622a = ormObject;
    }

    @Override // d.b.b.e.b.b.a.b.h
    public Object a(d.b.b.e.b.b.a.e.c cVar) {
        Object f2 = f(cVar);
        if (f2 != null) {
            if (f2 instanceof JSONObject) {
                return f2.toString();
            }
            return f2 instanceof JSONArray ? f2.toString() : f2;
        }
        return null;
    }

    @Override // d.b.b.e.b.b.a.b.h
    public Object b(d.b.b.e.b.b.a.e.c cVar) {
        return e(cVar);
    }

    @Override // d.b.b.e.b.b.a.b.h
    public Object c(d.b.b.e.b.b.a.e.c cVar) {
        return this.f41622a;
    }

    @Override // d.b.b.e.b.b.a.b.h
    public Object d(d.b.b.e.b.b.a.e.c cVar) {
        return this.f41622a;
    }

    @Override // d.b.b.e.b.b.a.b.h
    public Object e(d.b.b.e.b.b.a.e.c cVar) {
        Object f2 = f(cVar);
        if (f2 == null || !(f2 instanceof JSONObject)) {
            return null;
        }
        return f2.toString();
    }

    @Override // d.b.b.e.b.b.a.b.h
    public Object f(d.b.b.e.b.b.a.e.c cVar) {
        return OrmObject.jsonWithObject(this.f41622a);
    }
}
