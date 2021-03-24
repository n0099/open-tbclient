package d.b.b.e.b.b.a.b;

import android.os.Bundle;
import java.lang.reflect.Type;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c implements h {

    /* renamed from: a  reason: collision with root package name */
    public Bundle f41612a;

    public c(Bundle bundle) {
        this.f41612a = bundle;
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
        return this.f41612a;
    }

    @Override // d.b.b.e.b.b.a.b.h
    public Object d(d.b.b.e.b.b.a.e.c cVar) {
        return this.f41612a;
    }

    @Override // d.b.b.e.b.b.a.b.h
    public Object e(d.b.b.e.b.b.a.e.c cVar) {
        return this.f41612a;
    }

    @Override // d.b.b.e.b.b.a.b.h
    public Object f(d.b.b.e.b.b.a.e.c cVar) {
        Type[] b2 = cVar.b();
        Set<String> keySet = this.f41612a.keySet();
        JSONObject jSONObject = new JSONObject();
        for (String str : keySet) {
            Object obj = this.f41612a.get(str);
            if (b2 != null && b2.length >= 2) {
                try {
                    jSONObject.put(str, d.b.b.e.b.b.a.e.f.a(obj).f(new d.b.b.e.b.b.a.e.c(b2[1])));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            } else {
                try {
                    jSONObject.put(str, d.b.b.e.b.b.a.e.f.a(obj).f(new d.b.b.e.b.b.a.e.c(cVar.a())));
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
            }
        }
        return jSONObject;
    }
}
