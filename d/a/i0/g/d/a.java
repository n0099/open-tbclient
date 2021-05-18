package d.a.i0.g.d;

import android.util.Log;
import androidx.annotation.NonNull;
import d.a.i0.a.a2.e;
import d.a.i0.a.e2.c.f;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends d.a.i0.g.f.a {

    /* renamed from: d.a.i0.g.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0990a implements d.a.i0.a.v2.e1.b<f> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.u0.b f46895e;

        public C0990a(a aVar, d.a.i0.a.u0.b bVar) {
            this.f46895e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(f fVar) {
            boolean z = true;
            if ((fVar == null || fVar.f41523d || fVar.j != 1) ? false : false) {
                this.f46895e.b(null);
            } else {
                this.f46895e.onFail(10001, "authorize fail.");
            }
        }
    }

    public a() {
        super("authorize");
    }

    @Override // d.a.i0.g.f.a
    public d.a.i0.a.u.h.b a(@NonNull JSONObject jSONObject, @NonNull d.a.i0.a.u0.b bVar) {
        if (d.a.i0.g.f.a.f46900b && jSONObject.optBoolean("debug", false)) {
            Log.i("authorize", "debug mode: true.");
            bVar.b(null);
            return null;
        }
        e Q = e.Q();
        if (Q == null) {
            bVar.onFail(10001, "authorize fail.");
            return null;
        }
        Q.T().e("mapp_gamecenter_private_api", new C0990a(this, bVar));
        return null;
    }
}
