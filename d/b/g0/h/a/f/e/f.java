package d.b.g0.h.a.f.e;

import android.content.Context;
import android.os.Bundle;
import d.b.g0.a.k;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f extends d.b.g0.h.a.f.a<d.b.g0.a.a1.c.e> {
    static {
        boolean z = k.f45050a;
    }

    public static f e() {
        return new f();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.h.a.f.a
    /* renamed from: d */
    public boolean b(Context context, d.b.g0.a.a1.c.e eVar, d.b.g0.a.a1.b bVar, d.b.g0.a.r1.e eVar2, JSONObject jSONObject) {
        return g(context, eVar, bVar, eVar2);
    }

    public final Bundle f(d.b.g0.a.a1.c.e eVar) {
        Bundle bundle = new Bundle();
        bundle.putString("slaveId", eVar.f43113g);
        bundle.putDouble("latitude", eVar.n.f43190e);
        bundle.putDouble("longitude", eVar.n.f43191f);
        bundle.putDouble("scale", eVar.o);
        bundle.putString("name", eVar.D);
        bundle.putString("address", eVar.E);
        bundle.putStringArrayList("ignoredApps", eVar.F);
        return bundle;
    }

    public final boolean g(Context context, d.b.g0.a.a1.c.e eVar, d.b.g0.a.a1.b bVar, d.b.g0.a.r1.e eVar2) {
        d.b.g0.a.c0.c.g("map", "OpenLocationAction start");
        if (!eVar.isValid()) {
            d.b.g0.a.c0.c.b("map", "model is invalid");
            return false;
        }
        d.b.g0.h.a.h.a.W2(f(eVar)).b3();
        d.b.g0.a.c0.c.g("map", "OpenLocationAction end");
        return true;
    }
}
