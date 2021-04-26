package d.a.h0.a.t.c.m;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f extends d.a.h0.a.t.b.d {

    /* renamed from: d  reason: collision with root package name */
    public String f44284d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.h0.a.i2.u0.b<Integer> f44285e;

    /* loaded from: classes2.dex */
    public class a implements d.a.h0.a.i2.u0.b<Integer> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(Integer num) {
            if (num.intValue() == 1 || num.intValue() == 0) {
                f.this.s();
            }
        }
    }

    public f(@NonNull d.a.h0.a.t.b.b bVar) {
        super(bVar);
        this.f44285e = new a();
    }

    public d.a.h0.a.t.e.b r(String str) {
        Pair<d.a.h0.a.t.e.b, JSONObject> a2 = d.a.h0.a.t.f.b.a("Api-ExitFullScreenApi", str);
        d.a.h0.a.t.e.b bVar = (d.a.h0.a.t.e.b) a2.first;
        if (!bVar.a()) {
            if (d.a.h0.a.t.b.d.f44021c) {
                d.a.h0.a.c0.c.b("Api-ExitFullScreenApi", "parse fail");
            }
            return bVar;
        }
        String optString = ((JSONObject) a2.second).optString("cb");
        this.f44284d = optString;
        if (TextUtils.isEmpty(optString)) {
            return new d.a.h0.a.t.e.b(201);
        }
        j.c().o(this.f44285e);
        j.c().i();
        return new d.a.h0.a.t.e.b(0);
    }

    public final void s() {
        j.c().p();
        j.c().k();
        c(this.f44284d, new d.a.h0.a.t.e.b(0));
    }
}
