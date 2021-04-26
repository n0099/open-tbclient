package d.a.h0.a.t.c.m;

import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.SwanAppActivity;
import d.a.h0.a.i2.k0;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class h extends d.a.h0.a.t.b.d {

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44287e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f44288f;

        public a(String str, int i2) {
            this.f44287e = str;
            this.f44288f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            View b2 = d.a.h0.a.q1.b.a.b();
            LinearLayout c2 = d.a.h0.a.q1.b.a.c();
            if (b2 != null && c2 != null) {
                int i2 = this.f44288f;
                if (i2 == -90) {
                    b2.setVisibility(8);
                    c2.setVisibility(8);
                    d.a.h0.a.q1.b.a.f();
                    d.a.h0.a.q1.b.a.k(true);
                    h.u(8);
                } else if (i2 != 90) {
                    d.a.h0.a.q1.b.a.m();
                    b2.setVisibility(0);
                    c2.setVisibility(0);
                    h.v();
                } else {
                    b2.setVisibility(8);
                    c2.setVisibility(8);
                    d.a.h0.a.q1.b.a.f();
                    d.a.h0.a.q1.b.a.k(true);
                    h.u(0);
                }
                j.c().n(this.f44288f);
                h.this.c(this.f44287e, new d.a.h0.a.t.e.b(0));
                return;
            }
            h.this.c(this.f44287e, new d.a.h0.a.t.e.b(1001));
        }
    }

    public h(@NonNull d.a.h0.a.t.b.b bVar) {
        super(bVar);
    }

    public static void u(int i2) {
        SwanAppActivity activity = d.a.h0.a.z0.f.V().getActivity();
        activity.setRequestedOrientation(i2);
        activity.getWindow().setFlags(1024, 1024);
    }

    public static void v() {
        SwanAppActivity activity = d.a.h0.a.z0.f.V().getActivity();
        activity.setRequestedOrientation(1);
        if (!d.a.h0.a.q1.b.a.g(d.a.h0.a.q1.b.a.d(activity))) {
            d.a.h0.a.q1.b.a.k(false);
        }
        if (activity.getWindow() != null) {
            activity.getWindow().clearFlags(1024);
        }
        if (d.a.h0.a.z0.f.V().J() != null) {
            d.a.h0.a.z0.f.V().J().c2();
        }
    }

    public final void s(int i2, String str) {
        k0.T(new a(str, i2));
    }

    public final int t(boolean z, int i2) {
        if (z) {
            return i2;
        }
        return -1;
    }

    public d.a.h0.a.t.e.b w(String str) {
        if (d.a.h0.a.t.b.d.f44021c) {
            Log.d("Api-FullScreenApi", "start set full screen");
        }
        Pair<d.a.h0.a.t.e.b, JSONObject> a2 = d.a.h0.a.t.f.b.a("Api-FullScreenApi", str);
        d.a.h0.a.t.e.b bVar = (d.a.h0.a.t.e.b) a2.first;
        if (!bVar.a()) {
            if (d.a.h0.a.t.b.d.f44021c) {
                d.a.h0.a.c0.c.b("Api-FullScreenApi", "parse fail");
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) a2.second;
        s(t(jSONObject.optBoolean("fullScreen"), jSONObject.optInt("direction")), jSONObject.optString("cb"));
        return new d.a.h0.a.t.e.b(0);
    }
}
