package d.a.l0.a.u.e.g;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import d.a.l0.a.v2.q0;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f extends d.a.l0.a.u.c.d {

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48648e;

        public a(String str) {
            this.f48648e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.l0.a.h0.g.g W = d.a.l0.a.g1.f.V().W();
            if (W == null) {
                d.a.l0.a.e0.d.b("Api-PullDownRefresh", "manager is null");
                f.this.d(this.f48648e, new d.a.l0.a.u.h.b(1001));
            } else if (!(W.m() instanceof d.a.l0.a.h0.g.f)) {
                d.a.l0.a.e0.d.b("Api-PullDownRefresh", "top fragment error");
                f.this.d(this.f48648e, new d.a.l0.a.u.h.b(1001));
            } else {
                d.a.l0.a.h0.g.f fVar = (d.a.l0.a.h0.g.f) W.m();
                if (fVar.h0() == null) {
                    d.a.l0.a.e0.d.b("Api-PullDownRefresh", "view is null");
                    f.this.d(this.f48648e, new d.a.l0.a.u.h.b(1001));
                    return;
                }
                fVar.h0().w(false);
                d.a.l0.a.e0.d.g("Api-PullDownRefresh", "refresh complete");
                f.this.d(this.f48648e, new d.a.l0.a.u.h.b(0));
            }
        }
    }

    public f(@NonNull d.a.l0.a.u.c.b bVar) {
        super(bVar);
    }

    public d.a.l0.a.u.h.b r(String str) {
        if (d.a.l0.a.u.c.d.f48486c) {
            Log.d("Api-PullDownRefresh", "stop pull down refresh");
        }
        Pair<d.a.l0.a.u.h.b, JSONObject> b2 = d.a.l0.a.u.i.b.b("Api-PullDownRefresh", str);
        d.a.l0.a.u.h.b bVar = (d.a.l0.a.u.h.b) b2.first;
        if (!bVar.isSuccess()) {
            if (d.a.l0.a.u.c.d.f48486c) {
                d.a.l0.a.e0.d.b("Api-PullDownRefresh", "parse fail");
            }
            return bVar;
        }
        String optString = ((JSONObject) b2.second).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            d.a.l0.a.e0.d.b("Api-PullDownRefresh", "callback is null");
            return new d.a.l0.a.u.h.b(1001, "callback is null");
        }
        q0.b0(new a(optString));
        return new d.a.l0.a.u.h.b(0);
    }
}
