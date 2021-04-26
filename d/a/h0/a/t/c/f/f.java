package d.a.h0.a.t.c.f;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import d.a.h0.a.i2.k0;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f extends d.a.h0.a.t.b.d {

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44146e;

        public a(String str) {
            this.f44146e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.h0.a.e0.l.f W = d.a.h0.a.z0.f.V().W();
            if (W == null) {
                d.a.h0.a.c0.c.b("Api-PullDownRefresh", "manager is null");
                f.this.c(this.f44146e, new d.a.h0.a.t.e.b(1001));
            } else if (!(W.m() instanceof d.a.h0.a.e0.l.e)) {
                d.a.h0.a.c0.c.b("Api-PullDownRefresh", "top fragment error");
                f.this.c(this.f44146e, new d.a.h0.a.t.e.b(1001));
            } else {
                d.a.h0.a.e0.l.e eVar = (d.a.h0.a.e0.l.e) W.m();
                if (eVar.f0() == null) {
                    d.a.h0.a.c0.c.b("Api-PullDownRefresh", "view is null");
                    f.this.c(this.f44146e, new d.a.h0.a.t.e.b(1001));
                    return;
                }
                eVar.f0().w(false);
                d.a.h0.a.c0.c.g("Api-PullDownRefresh", "refresh complete");
                f.this.c(this.f44146e, new d.a.h0.a.t.e.b(0));
            }
        }
    }

    public f(@NonNull d.a.h0.a.t.b.b bVar) {
        super(bVar);
    }

    public d.a.h0.a.t.e.b q(String str) {
        if (d.a.h0.a.t.b.d.f44021c) {
            Log.d("Api-PullDownRefresh", "stop pull down refresh");
        }
        Pair<d.a.h0.a.t.e.b, JSONObject> a2 = d.a.h0.a.t.f.b.a("Api-PullDownRefresh", str);
        d.a.h0.a.t.e.b bVar = (d.a.h0.a.t.e.b) a2.first;
        if (!bVar.a()) {
            if (d.a.h0.a.t.b.d.f44021c) {
                d.a.h0.a.c0.c.b("Api-PullDownRefresh", "parse fail");
            }
            return bVar;
        }
        String optString = ((JSONObject) a2.second).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            d.a.h0.a.c0.c.b("Api-PullDownRefresh", "callback is null");
            return new d.a.h0.a.t.e.b(1001, "callback is null");
        }
        k0.X(new a(optString));
        return new d.a.h0.a.t.e.b(0);
    }
}
