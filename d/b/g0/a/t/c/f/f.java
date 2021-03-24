package d.b.g0.a.t.c.f;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import d.b.g0.a.i2.k0;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f extends d.b.g0.a.t.b.d {

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46044e;

        public a(String str) {
            this.f46044e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.g0.a.e0.l.f W = d.b.g0.a.z0.f.V().W();
            if (W == null) {
                d.b.g0.a.c0.c.b("Api-PullDownRefresh", "manager is null");
                f.this.c(this.f46044e, new d.b.g0.a.t.e.b(1001));
            } else if (!(W.m() instanceof d.b.g0.a.e0.l.e)) {
                d.b.g0.a.c0.c.b("Api-PullDownRefresh", "top fragment error");
                f.this.c(this.f46044e, new d.b.g0.a.t.e.b(1001));
            } else {
                d.b.g0.a.e0.l.e eVar = (d.b.g0.a.e0.l.e) W.m();
                if (eVar.Y() == null) {
                    d.b.g0.a.c0.c.b("Api-PullDownRefresh", "view is null");
                    f.this.c(this.f46044e, new d.b.g0.a.t.e.b(1001));
                    return;
                }
                eVar.Y().w(false);
                d.b.g0.a.c0.c.g("Api-PullDownRefresh", "refresh complete");
                f.this.c(this.f46044e, new d.b.g0.a.t.e.b(0));
            }
        }
    }

    public f(@NonNull d.b.g0.a.t.b.b bVar) {
        super(bVar);
    }

    public d.b.g0.a.t.e.b q(String str) {
        if (d.b.g0.a.t.b.d.f45928c) {
            Log.d("Api-PullDownRefresh", "stop pull down refresh");
        }
        Pair<d.b.g0.a.t.e.b, JSONObject> a2 = d.b.g0.a.t.f.b.a("Api-PullDownRefresh", str);
        d.b.g0.a.t.e.b bVar = (d.b.g0.a.t.e.b) a2.first;
        if (!bVar.b()) {
            if (d.b.g0.a.t.b.d.f45928c) {
                d.b.g0.a.c0.c.b("Api-PullDownRefresh", "parse fail");
            }
            return bVar;
        }
        String optString = ((JSONObject) a2.second).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            d.b.g0.a.c0.c.b("Api-PullDownRefresh", "callback is null");
            return new d.b.g0.a.t.e.b(1001, "callback is null");
        }
        k0.X(new a(optString));
        return new d.b.g0.a.t.e.b(0);
    }
}
