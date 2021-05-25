package d.a.l0.j.k.e;

import android.content.Context;
import android.os.Bundle;
import d.a.l0.a.k;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f extends d.a.l0.j.k.a<d.a.l0.a.h1.c.e> {
    static {
        boolean z = k.f43199a;
    }

    public static f e() {
        return new f();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.l0.j.k.a
    /* renamed from: d */
    public boolean b(Context context, d.a.l0.a.h1.c.e eVar, d.a.l0.a.h1.b bVar, d.a.l0.a.a2.e eVar2, JSONObject jSONObject) {
        return g(context, eVar, bVar, eVar2);
    }

    public final Bundle f(d.a.l0.a.h1.c.e eVar) {
        Bundle bundle = new Bundle();
        bundle.putString("slaveId", eVar.f40846g);
        bundle.putDouble("latitude", eVar.n.f42673e);
        bundle.putDouble("longitude", eVar.n.f42674f);
        bundle.putDouble("scale", eVar.o);
        bundle.putString("name", eVar.D);
        bundle.putString("address", eVar.E);
        bundle.putStringArrayList("ignoredApps", eVar.F);
        return bundle;
    }

    public final boolean g(Context context, d.a.l0.a.h1.c.e eVar, d.a.l0.a.h1.b bVar, d.a.l0.a.a2.e eVar2) {
        d.a.l0.a.e0.d.g("map", "OpenLocationAction start");
        if (!eVar.isValid()) {
            d.a.l0.a.e0.d.b("map", "model is invalid");
            return false;
        }
        d.a.l0.j.m.a.c3(f(eVar)).h3();
        d.a.l0.a.e0.d.g("map", "OpenLocationAction end");
        return true;
    }
}
