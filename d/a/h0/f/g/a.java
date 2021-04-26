package d.a.h0.f.g;

import android.util.Log;
import androidx.annotation.NonNull;
import d.a.h0.a.v1.c.e;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends d.a.h0.f.i.a {

    /* renamed from: d.a.h0.f.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0917a implements d.a.h0.a.i2.u0.b<e> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.p0.b f46021e;

        public C0917a(a aVar, d.a.h0.a.p0.b bVar) {
            this.f46021e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(e eVar) {
            boolean z = true;
            if ((eVar == null || eVar.f44913d || eVar.j != 1) ? false : false) {
                this.f46021e.a(null);
            } else {
                this.f46021e.onFail(10001, "authorize fail.");
            }
        }
    }

    public a() {
        super("authorize");
    }

    @Override // d.a.h0.f.i.a
    public d.a.h0.a.t.e.b a(@NonNull JSONObject jSONObject, @NonNull d.a.h0.a.p0.b bVar) {
        if (d.a.h0.f.i.a.f46026b && jSONObject.optBoolean("debug", false)) {
            Log.i("authorize", "debug mode: true.");
            bVar.a(null);
            return null;
        }
        d.a.h0.a.r1.e O = d.a.h0.a.r1.e.O();
        if (O == null) {
            bVar.onFail(10001, "authorize fail.");
            return null;
        }
        O.R().e("mapp_gamecenter_private_api", new C0917a(this, bVar));
        return null;
    }
}
