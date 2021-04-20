package d.b.c.e.b.b.a.c;

import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e implements c {

    /* renamed from: a  reason: collision with root package name */
    public JSONObject f42130a;

    public e(JSONObject jSONObject) {
        this.f42130a = jSONObject;
    }

    @Override // d.b.c.e.b.b.a.c.c
    public Set<String> a() {
        Iterator<String> keys = this.f42130a.keys();
        if (keys != null) {
            HashSet hashSet = new HashSet();
            while (keys.hasNext()) {
                String next = keys.next();
                if (next != null) {
                    hashSet.add(next.toString());
                }
            }
            return hashSet;
        }
        return null;
    }

    @Override // d.b.c.e.b.b.a.c.c
    public void b(String str, Object obj) {
        try {
            this.f42130a.putOpt(str, obj);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.b.c.e.b.b.a.c.c
    public Object c(String str, Type type) {
        Object d2 = d(str);
        if (d2 != null) {
            d.b.c.e.b.b.a.e.c cVar = new d.b.c.e.b.b.a.e.c(type);
            d.b.c.e.b.b.a.d.h a2 = d.b.c.e.b.b.a.e.g.a(d2);
            return a2 != null ? a2.a(cVar) : d2;
        }
        return d2;
    }

    public Object d(String str) {
        return this.f42130a.opt(str);
    }
}
