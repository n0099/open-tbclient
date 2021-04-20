package d.b.g0.f.g;

import android.util.Log;
import androidx.annotation.NonNull;
import d.b.g0.a.v1.c.e;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends d.b.g0.f.i.a {

    /* renamed from: d.b.g0.f.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0958a implements d.b.g0.a.i2.u0.b<e> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.p0.b f48231e;

        public C0958a(a aVar, d.b.g0.a.p0.b bVar) {
            this.f48231e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(e eVar) {
            boolean z = true;
            if ((eVar == null || eVar.f47163d || eVar.j != 1) ? false : false) {
                this.f48231e.a(null);
            } else {
                this.f48231e.onFail(10001, "authorize fail.");
            }
        }
    }

    public a() {
        super("authorize");
    }

    @Override // d.b.g0.f.i.a
    public d.b.g0.a.t.e.b a(@NonNull JSONObject jSONObject, @NonNull d.b.g0.a.p0.b bVar) {
        if (d.b.g0.f.i.a.f48236b && jSONObject.optBoolean("debug", false)) {
            Log.i("authorize", "debug mode: true.");
            bVar.a(null);
            return null;
        }
        d.b.g0.a.r1.e O = d.b.g0.a.r1.e.O();
        if (O == null) {
            bVar.onFail(10001, "authorize fail.");
            return null;
        }
        O.R().e("mapp_gamecenter_private_api", new C0958a(this, bVar));
        return null;
    }
}
