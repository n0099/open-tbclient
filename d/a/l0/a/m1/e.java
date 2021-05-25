package d.a.l0.a.m1;

import android.graphics.Bitmap;
import d.a.l0.a.f1.e.b;
import d.a.l0.a.j2.h;
import d.a.l0.a.j2.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e {
    public static JSONObject a(d dVar, boolean z, Bitmap bitmap, boolean z2) {
        JSONObject e2 = c.e();
        if (dVar != null) {
            try {
                e2.put("page", dVar.f43460b);
            } catch (JSONException e3) {
                if (d.a.l0.a.a2.e.y) {
                    e3.printStackTrace();
                }
            }
        }
        e2.put("firstPage", z2);
        if (z && bitmap != null) {
            e2.put("image", c.c(bitmap));
        }
        return e2;
    }

    public static JSONObject b(d dVar) {
        JSONObject jSONObject = new JSONObject();
        if (dVar != null) {
            try {
                jSONObject.put("isH5Componet", dVar.f43465g == 0 ? "0" : "1");
            } catch (JSONException e2) {
                if (d.a.l0.a.a2.e.y) {
                    e2.printStackTrace();
                }
            }
        }
        return jSONObject;
    }

    public static void c(d dVar, int i2, boolean z, int i3) {
        d(dVar, i2, false, null, z, i3);
    }

    public static void d(d dVar, int i2, boolean z, Bitmap bitmap, boolean z2, int i3) {
        d.a.l0.a.q2.a aVar = new d.a.l0.a.q2.a();
        aVar.j(5L);
        aVar.h(i2);
        if (!h.f43129e || z2) {
            aVar.e(a(dVar, z, bitmap, z2).toString());
        }
        String valueOf = String.valueOf(i3);
        d.a.l0.a.j2.p.d dVar2 = new d.a.l0.a.j2.p.d();
        dVar2.p(aVar);
        dVar2.q(k.m(d.a.l0.a.a2.d.g().l()));
        dVar2.m(d.a.l0.a.a2.d.g().getAppId());
        dVar2.s = dVar.f43460b;
        dVar2.n(false);
        b.a L = d.a.l0.a.a2.e.Q() != null ? d.a.l0.a.a2.e.Q().L() : null;
        if (!h.f43129e || z2) {
            dVar2.s(valueOf);
            dVar2.r(L);
            dVar2.e(b(dVar));
            dVar2.e(d.a.l0.a.i2.a.d().e());
            dVar2.e(d.a.l0.a.i2.a.d().g());
        }
        k.L(dVar2);
    }
}
