package d.b.g0.a.t.c.m;

import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.SwanAppActivity;
import d.b.g0.a.i2.k0;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class h extends d.b.g0.a.t.b.d {

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46179e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f46180f;

        public a(String str, int i) {
            this.f46179e = str;
            this.f46180f = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            View b2 = d.b.g0.a.q1.b.a.b();
            LinearLayout c2 = d.b.g0.a.q1.b.a.c();
            if (b2 != null && c2 != null) {
                int i = this.f46180f;
                if (i == -90) {
                    b2.setVisibility(8);
                    c2.setVisibility(8);
                    d.b.g0.a.q1.b.a.f();
                    d.b.g0.a.q1.b.a.k(true);
                    h.u(8);
                } else if (i != 90) {
                    d.b.g0.a.q1.b.a.m();
                    b2.setVisibility(0);
                    c2.setVisibility(0);
                    h.v();
                } else {
                    b2.setVisibility(8);
                    c2.setVisibility(8);
                    d.b.g0.a.q1.b.a.f();
                    d.b.g0.a.q1.b.a.k(true);
                    h.u(0);
                }
                j.c().n(this.f46180f);
                h.this.c(this.f46179e, new d.b.g0.a.t.e.b(0));
                return;
            }
            h.this.c(this.f46179e, new d.b.g0.a.t.e.b(1001));
        }
    }

    public h(@NonNull d.b.g0.a.t.b.b bVar) {
        super(bVar);
    }

    public static void u(int i) {
        SwanAppActivity activity = d.b.g0.a.z0.f.V().getActivity();
        activity.setRequestedOrientation(i);
        activity.getWindow().setFlags(1024, 1024);
    }

    public static void v() {
        SwanAppActivity activity = d.b.g0.a.z0.f.V().getActivity();
        activity.setRequestedOrientation(1);
        if (!d.b.g0.a.q1.b.a.g(d.b.g0.a.q1.b.a.d(activity))) {
            d.b.g0.a.q1.b.a.k(false);
        }
        if (activity.getWindow() != null) {
            activity.getWindow().clearFlags(1024);
        }
        if (d.b.g0.a.z0.f.V().A() != null) {
            d.b.g0.a.z0.f.V().A().d2();
        }
    }

    public final void s(int i, String str) {
        k0.T(new a(str, i));
    }

    public final int t(boolean z, int i) {
        if (z) {
            return i;
        }
        return -1;
    }

    public d.b.g0.a.t.e.b w(String str) {
        if (d.b.g0.a.t.b.d.f45929c) {
            Log.d("Api-FullScreenApi", "start set full screen");
        }
        Pair<d.b.g0.a.t.e.b, JSONObject> a2 = d.b.g0.a.t.f.b.a("Api-FullScreenApi", str);
        d.b.g0.a.t.e.b bVar = (d.b.g0.a.t.e.b) a2.first;
        if (!bVar.b()) {
            if (d.b.g0.a.t.b.d.f45929c) {
                d.b.g0.a.c0.c.b("Api-FullScreenApi", "parse fail");
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) a2.second;
        s(t(jSONObject.optBoolean("fullScreen"), jSONObject.optInt("direction")), jSONObject.optString("cb"));
        return new d.b.g0.a.t.e.b(0);
    }
}
