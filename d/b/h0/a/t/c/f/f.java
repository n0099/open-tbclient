package d.b.h0.a.t.c.f;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import d.b.h0.a.i2.k0;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f extends d.b.h0.a.t.b.d {

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46766e;

        public a(String str) {
            this.f46766e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.h0.a.e0.l.f W = d.b.h0.a.z0.f.V().W();
            if (W == null) {
                d.b.h0.a.c0.c.b("Api-PullDownRefresh", "manager is null");
                f.this.c(this.f46766e, new d.b.h0.a.t.e.b(1001));
            } else if (!(W.m() instanceof d.b.h0.a.e0.l.e)) {
                d.b.h0.a.c0.c.b("Api-PullDownRefresh", "top fragment error");
                f.this.c(this.f46766e, new d.b.h0.a.t.e.b(1001));
            } else {
                d.b.h0.a.e0.l.e eVar = (d.b.h0.a.e0.l.e) W.m();
                if (eVar.b0() == null) {
                    d.b.h0.a.c0.c.b("Api-PullDownRefresh", "view is null");
                    f.this.c(this.f46766e, new d.b.h0.a.t.e.b(1001));
                    return;
                }
                eVar.b0().w(false);
                d.b.h0.a.c0.c.g("Api-PullDownRefresh", "refresh complete");
                f.this.c(this.f46766e, new d.b.h0.a.t.e.b(0));
            }
        }
    }

    public f(@NonNull d.b.h0.a.t.b.b bVar) {
        super(bVar);
    }

    public d.b.h0.a.t.e.b q(String str) {
        if (d.b.h0.a.t.b.d.f46650c) {
            Log.d("Api-PullDownRefresh", "stop pull down refresh");
        }
        Pair<d.b.h0.a.t.e.b, JSONObject> a2 = d.b.h0.a.t.f.b.a("Api-PullDownRefresh", str);
        d.b.h0.a.t.e.b bVar = (d.b.h0.a.t.e.b) a2.first;
        if (!bVar.b()) {
            if (d.b.h0.a.t.b.d.f46650c) {
                d.b.h0.a.c0.c.b("Api-PullDownRefresh", "parse fail");
            }
            return bVar;
        }
        String optString = ((JSONObject) a2.second).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            d.b.h0.a.c0.c.b("Api-PullDownRefresh", "callback is null");
            return new d.b.h0.a.t.e.b(1001, "callback is null");
        }
        k0.X(new a(optString));
        return new d.b.h0.a.t.e.b(0);
    }
}
