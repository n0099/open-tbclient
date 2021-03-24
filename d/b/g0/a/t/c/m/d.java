package d.b.g0.a.t.c.m;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import d.b.g0.a.c2.e.a;
import d.b.g0.a.t.b.d;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d extends d.b.g0.a.t.b.d {

    /* loaded from: classes3.dex */
    public class a implements d.b {

        /* renamed from: d.b.g0.a.t.c.m.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0828a implements a.c {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ k f46170a;

            public C0828a(k kVar) {
                this.f46170a = kVar;
            }

            @Override // d.b.g0.a.c2.e.a.c
            public void a(float f2, int i) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("direction", f2);
                    jSONObject.put("accuracy", d.b.g0.a.c2.e.a.h(i));
                    this.f46170a.d(d.this, jSONObject);
                } catch (JSONException e2) {
                    d.b.g0.a.c0.c.b("Api-Compass", "handle compass,json error，" + e2.toString());
                    this.f46170a.f(d.this, "Json error");
                }
            }
        }

        public a() {
        }

        @Override // d.b.g0.a.t.b.d.b
        public d.b.g0.a.t.e.b a(d.b.g0.a.r1.e eVar, JSONObject jSONObject, @Nullable String str) {
            d.b.g0.a.c0.c.g("Api-Compass", " init ");
            k kVar = new k("compassChange", jSONObject, str);
            d.b.g0.a.c2.e.a i = d.b.g0.a.c2.e.a.i();
            i.l(d.this.h());
            i.o(new C0828a(kVar));
            d.b.g0.a.c0.c.g("Api-Compass", "start listen compass");
            i.p();
            kVar.b(d.this);
            return new d.b.g0.a.t.e.b(0);
        }
    }

    public d(@NonNull d.b.g0.a.t.b.b bVar) {
        super(bVar);
    }

    public d.b.g0.a.t.e.b r(String str) {
        if (d.b.g0.a.t.b.d.f45928c) {
            Log.d("Api-Compass", "start listen compass");
        }
        return i(str, true, new a());
    }

    public d.b.g0.a.t.e.b s() {
        if (d.b.g0.a.t.b.d.f45928c) {
            Log.d("Api-Compass", "stop accelerometer");
        }
        d.b.g0.a.c0.c.g("Api-Compass", "stop listen compass");
        d.b.g0.a.c2.e.a.i().q();
        return new d.b.g0.a.t.e.b(0);
    }
}
