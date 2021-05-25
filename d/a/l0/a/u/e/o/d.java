package d.a.l0.a.u.e.o;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import d.a.l0.a.n2.f.a;
import d.a.l0.a.u.c.d;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d extends d.a.l0.a.u.c.d {

    /* loaded from: classes2.dex */
    public class a implements d.b {

        /* renamed from: d.a.l0.a.u.e.o.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0866a implements a.c {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ l f45157a;

            public C0866a(l lVar) {
                this.f45157a = lVar;
            }

            @Override // d.a.l0.a.n2.f.a.c
            public void a(float f2, int i2) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("direction", f2);
                    jSONObject.put("accuracy", d.a.l0.a.n2.f.a.h(i2));
                    this.f45157a.d(d.this, jSONObject);
                } catch (JSONException e2) {
                    d.a.l0.a.e0.d.b("Api-Compass", "handle compass,json error，" + e2.toString());
                    this.f45157a.f(d.this, "Json error");
                }
            }
        }

        public a() {
        }

        @Override // d.a.l0.a.u.c.d.b
        public d.a.l0.a.u.h.b a(d.a.l0.a.a2.e eVar, JSONObject jSONObject, @Nullable String str) {
            d.a.l0.a.e0.d.g("Api-Compass", " init ");
            l lVar = new l("compassChange", jSONObject, str);
            d.a.l0.a.n2.f.a i2 = d.a.l0.a.n2.f.a.i();
            i2.l(d.this.i());
            i2.o(new C0866a(lVar));
            d.a.l0.a.e0.d.g("Api-Compass", "start listen compass");
            i2.p();
            lVar.b(d.this);
            return new d.a.l0.a.u.h.b(0);
        }
    }

    public d(@NonNull d.a.l0.a.u.c.b bVar) {
        super(bVar);
    }

    public d.a.l0.a.u.h.b s(String str) {
        if (d.a.l0.a.u.c.d.f44812c) {
            Log.d("Api-Compass", "start listen compass");
        }
        return j(str, true, new a());
    }

    public d.a.l0.a.u.h.b t() {
        if (d.a.l0.a.u.c.d.f44812c) {
            Log.d("Api-Compass", "stop accelerometer");
        }
        d.a.l0.a.e0.d.g("Api-Compass", "stop listen compass");
        d.a.l0.a.n2.f.a.i().q();
        return new d.a.l0.a.u.h.b(0);
    }
}
