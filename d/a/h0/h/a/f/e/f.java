package d.a.h0.h.a.f.e;

import android.content.Context;
import android.os.Bundle;
import d.a.h0.a.k;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f extends d.a.h0.h.a.f.a<d.a.h0.a.a1.c.e> {
    static {
        boolean z = k.f43101a;
    }

    public static f e() {
        return new f();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.h0.h.a.f.a
    /* renamed from: d */
    public boolean b(Context context, d.a.h0.a.a1.c.e eVar, d.a.h0.a.a1.b bVar, d.a.h0.a.r1.e eVar2, JSONObject jSONObject) {
        return g(context, eVar, bVar, eVar2);
    }

    public final Bundle f(d.a.h0.a.a1.c.e eVar) {
        Bundle bundle = new Bundle();
        bundle.putString("slaveId", eVar.f41093g);
        bundle.putDouble("latitude", eVar.n.f41178e);
        bundle.putDouble("longitude", eVar.n.f41179f);
        bundle.putDouble("scale", eVar.o);
        bundle.putString("name", eVar.D);
        bundle.putString("address", eVar.E);
        bundle.putStringArrayList("ignoredApps", eVar.F);
        return bundle;
    }

    public final boolean g(Context context, d.a.h0.a.a1.c.e eVar, d.a.h0.a.a1.b bVar, d.a.h0.a.r1.e eVar2) {
        d.a.h0.a.c0.c.g("map", "OpenLocationAction start");
        if (!eVar.isValid()) {
            d.a.h0.a.c0.c.b("map", "model is invalid");
            return false;
        }
        d.a.h0.h.a.h.a.V2(f(eVar)).a3();
        d.a.h0.a.c0.c.g("map", "OpenLocationAction end");
        return true;
    }
}
