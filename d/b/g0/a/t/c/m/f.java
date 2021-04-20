package d.b.g0.a.t.c.m;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f extends d.b.g0.a.t.b.d {

    /* renamed from: d  reason: collision with root package name */
    public String f46568d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.g0.a.i2.u0.b<Integer> f46569e;

    /* loaded from: classes2.dex */
    public class a implements d.b.g0.a.i2.u0.b<Integer> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(Integer num) {
            if (num.intValue() == 1 || num.intValue() == 0) {
                f.this.s();
            }
        }
    }

    public f(@NonNull d.b.g0.a.t.b.b bVar) {
        super(bVar);
        this.f46569e = new a();
    }

    public d.b.g0.a.t.e.b r(String str) {
        Pair<d.b.g0.a.t.e.b, JSONObject> a2 = d.b.g0.a.t.f.b.a("Api-ExitFullScreenApi", str);
        d.b.g0.a.t.e.b bVar = (d.b.g0.a.t.e.b) a2.first;
        if (!bVar.b()) {
            if (d.b.g0.a.t.b.d.f46321c) {
                d.b.g0.a.c0.c.b("Api-ExitFullScreenApi", "parse fail");
            }
            return bVar;
        }
        String optString = ((JSONObject) a2.second).optString("cb");
        this.f46568d = optString;
        if (TextUtils.isEmpty(optString)) {
            return new d.b.g0.a.t.e.b(201);
        }
        j.c().o(this.f46569e);
        j.c().i();
        return new d.b.g0.a.t.e.b(0);
    }

    public final void s() {
        j.c().p();
        j.c().k();
        c(this.f46568d, new d.b.g0.a.t.e.b(0));
    }
}
