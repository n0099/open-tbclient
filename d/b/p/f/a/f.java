package d.b.p.f.a;

import android.content.Context;
import android.text.TextUtils;
import d.b.p.b;
import d.b.p.f.a.d;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f implements i {
    @Override // d.b.p.f.a.i
    public String a(Context context) {
        return d.b.p.b.d(context.getApplicationContext()).a();
    }

    @Override // d.b.p.f.a.i
    public JSONArray b(Context context) {
        T t;
        b.d dVar;
        d dVar2 = new d();
        d.b.p.b.d(context).k(dVar2);
        boolean d2 = dVar2.d(10000);
        JSONArray jSONArray = new JSONArray();
        if (d2) {
            d.b c2 = dVar2.c();
            if (c2 != null && (t = c2.f65064a) != 0 && (dVar = (b.d) t) != null && dVar.b() != null) {
                for (b.e eVar : dVar.b()) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("aid", eVar.f64949b);
                        jSONObject.put("pkg", eVar.f64948a);
                        jSONObject.put("priority", eVar.f64950c);
                        jSONArray.put(jSONObject);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        } else {
            dVar2.e();
        }
        return jSONArray;
    }

    @Override // d.b.p.f.a.i
    public String c(Context context) {
        d dVar = new d();
        d.b.p.b.d(context).j(dVar);
        if (!dVar.d(10000)) {
            dVar.e();
            return null;
        }
        d.b c2 = dVar.c();
        if (c2 == null || TextUtils.isEmpty((CharSequence) c2.f65064a)) {
            return null;
        }
        return (String) c2.f65064a;
    }

    @Override // d.b.p.f.a.i
    public String d(Context context) {
        d dVar = new d();
        d.b.p.b.d(context).h(dVar);
        if (!dVar.d(10000)) {
            dVar.e();
            return null;
        }
        d.b c2 = dVar.c();
        if (c2 == null || TextUtils.isEmpty((CharSequence) c2.f65064a)) {
            return null;
        }
        return (String) c2.f65064a;
    }

    @Override // d.b.p.f.a.i
    public String e(Context context) {
        return d.b.p.b.d(context.getApplicationContext()).c();
    }
}
