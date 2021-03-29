package d.b.b.e.b.b.a.b;

import android.util.SparseArray;
import java.lang.reflect.Type;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class q implements h {

    /* renamed from: a  reason: collision with root package name */
    public SparseArray<?> f41626a;

    public q(SparseArray<?> sparseArray) {
        this.f41626a = sparseArray;
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
        return this.f41626a;
    }

    @Override // d.b.b.e.b.b.a.b.h
    public Object d(d.b.b.e.b.b.a.e.c cVar) {
        return this.f41626a;
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
        Type[] b2 = cVar.b();
        JSONObject jSONObject = new JSONObject();
        int size = this.f41626a.size();
        for (int i = 0; i < size; i++) {
            int keyAt = this.f41626a.keyAt(i);
            Object obj = this.f41626a.get(keyAt);
            if (obj != null) {
                if (b2 != null && b2.length >= 1) {
                    Object f2 = d.b.b.e.b.b.a.e.f.a(obj).f(new d.b.b.e.b.b.a.e.c(b2[0]));
                    if (f2 != null) {
                        try {
                            jSONObject.put(String.valueOf(keyAt), f2);
                        } catch (JSONException unused) {
                        }
                    }
                } else {
                    Object f3 = d.b.b.e.b.b.a.e.f.a(obj).f(new d.b.b.e.b.b.a.e.c(cVar.a()));
                    if (f3 != null) {
                        jSONObject.put(String.valueOf(keyAt), f3);
                    }
                }
            }
        }
        return jSONObject;
    }
}
