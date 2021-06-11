package d.a.l0.g.d;

import android.util.Log;
import androidx.annotation.NonNull;
import d.a.l0.a.a2.e;
import d.a.l0.a.e2.c.f;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends d.a.l0.g.f.a {

    /* renamed from: d.a.l0.g.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1057a implements d.a.l0.a.v2.e1.b<f> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.u0.b f50745e;

        public C1057a(a aVar, d.a.l0.a.u0.b bVar) {
            this.f50745e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(f fVar) {
            boolean z = true;
            if ((fVar == null || fVar.f45373d || fVar.j != 1) ? false : false) {
                this.f50745e.a(null);
            } else {
                this.f50745e.onFail(10001, "authorize fail.");
            }
        }
    }

    public a() {
        super("authorize");
    }

    @Override // d.a.l0.g.f.a
    public d.a.l0.a.u.h.b a(@NonNull JSONObject jSONObject, @NonNull d.a.l0.a.u0.b bVar) {
        if (d.a.l0.g.f.a.f50750b && jSONObject.optBoolean("debug", false)) {
            Log.i("authorize", "debug mode: true.");
            bVar.a(null);
            return null;
        }
        e Q = e.Q();
        if (Q == null) {
            bVar.onFail(10001, "authorize fail.");
            return null;
        }
        Q.T().e("mapp_gamecenter_private_api", new C1057a(this, bVar));
        return null;
    }
}
