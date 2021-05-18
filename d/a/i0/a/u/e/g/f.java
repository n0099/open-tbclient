package d.a.i0.a.u.e.g;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import d.a.i0.a.v2.q0;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f extends d.a.i0.a.u.c.d {

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44798e;

        public a(String str) {
            this.f44798e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.i0.a.h0.g.g W = d.a.i0.a.g1.f.V().W();
            if (W == null) {
                d.a.i0.a.e0.d.b("Api-PullDownRefresh", "manager is null");
                f.this.d(this.f44798e, new d.a.i0.a.u.h.b(1001));
            } else if (!(W.m() instanceof d.a.i0.a.h0.g.f)) {
                d.a.i0.a.e0.d.b("Api-PullDownRefresh", "top fragment error");
                f.this.d(this.f44798e, new d.a.i0.a.u.h.b(1001));
            } else {
                d.a.i0.a.h0.g.f fVar = (d.a.i0.a.h0.g.f) W.m();
                if (fVar.h0() == null) {
                    d.a.i0.a.e0.d.b("Api-PullDownRefresh", "view is null");
                    f.this.d(this.f44798e, new d.a.i0.a.u.h.b(1001));
                    return;
                }
                fVar.h0().w(false);
                d.a.i0.a.e0.d.g("Api-PullDownRefresh", "refresh complete");
                f.this.d(this.f44798e, new d.a.i0.a.u.h.b(0));
            }
        }
    }

    public f(@NonNull d.a.i0.a.u.c.b bVar) {
        super(bVar);
    }

    public d.a.i0.a.u.h.b r(String str) {
        if (d.a.i0.a.u.c.d.f44636c) {
            Log.d("Api-PullDownRefresh", "stop pull down refresh");
        }
        Pair<d.a.i0.a.u.h.b, JSONObject> b2 = d.a.i0.a.u.i.b.b("Api-PullDownRefresh", str);
        d.a.i0.a.u.h.b bVar = (d.a.i0.a.u.h.b) b2.first;
        if (!bVar.a()) {
            if (d.a.i0.a.u.c.d.f44636c) {
                d.a.i0.a.e0.d.b("Api-PullDownRefresh", "parse fail");
            }
            return bVar;
        }
        String optString = ((JSONObject) b2.second).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            d.a.i0.a.e0.d.b("Api-PullDownRefresh", "callback is null");
            return new d.a.i0.a.u.h.b(1001, "callback is null");
        }
        q0.b0(new a(optString));
        return new d.a.i0.a.u.h.b(0);
    }
}
