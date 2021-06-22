package d.a.m0.a.u.e.o;

import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.SwanAppActivity;
import d.a.m0.a.v2.q0;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class i extends d.a.m0.a.u.c.d {

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f48949e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f48950f;

        public a(int i2, String str) {
            this.f48949e = i2;
            this.f48950f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            View b2 = d.a.m0.a.z1.b.a.b();
            LinearLayout c2 = d.a.m0.a.z1.b.a.c();
            int i2 = this.f48949e;
            if (i2 == -90) {
                if (b2 != null) {
                    b2.setVisibility(8);
                }
                if (c2 != null) {
                    c2.setVisibility(8);
                }
                d.a.m0.a.z1.b.a.f();
                d.a.m0.a.z1.b.a.k(true);
                i.v(8);
            } else if (i2 != 90) {
                d.a.m0.a.z1.b.a.m();
                if (b2 != null) {
                    b2.setVisibility(0);
                }
                if (c2 != null) {
                    c2.setVisibility(0);
                }
                i.w();
            } else {
                if (b2 != null) {
                    b2.setVisibility(8);
                }
                if (c2 != null) {
                    c2.setVisibility(8);
                }
                d.a.m0.a.z1.b.a.f();
                d.a.m0.a.z1.b.a.k(true);
                i.v(0);
            }
            k.e().t(this.f48949e);
            i.this.d(this.f48950f, new d.a.m0.a.u.h.b(0));
        }
    }

    public i(@NonNull d.a.m0.a.u.c.b bVar) {
        super(bVar);
    }

    public static void v(int i2) {
        SwanAppActivity activity = d.a.m0.a.g1.f.V().getActivity();
        activity.setRequestedOrientation(i2);
        activity.getWindow().setFlags(1024, 1024);
    }

    public static void w() {
        SwanAppActivity activity = d.a.m0.a.g1.f.V().getActivity();
        activity.setRequestedOrientation(1);
        if (!d.a.m0.a.z1.b.a.g(d.a.m0.a.z1.b.a.d(activity))) {
            d.a.m0.a.z1.b.a.k(false);
        }
        if (activity.getWindow() != null) {
            activity.getWindow().clearFlags(1024);
        }
        if (d.a.m0.a.g1.f.V().J() != null) {
            d.a.m0.a.g1.f.V().J().i2();
        }
    }

    public final void t(int i2, String str) {
        q0.X(new a(i2, str));
    }

    public final int u(boolean z, int i2) {
        if (z) {
            return i2;
        }
        return -1;
    }

    public d.a.m0.a.u.h.b x(String str) {
        if (d.a.m0.a.u.c.d.f48594c) {
            Log.d("Api-FullScreenApi", "start set full screen");
        }
        Pair<d.a.m0.a.u.h.b, JSONObject> b2 = d.a.m0.a.u.i.b.b("Api-FullScreenApi", str);
        d.a.m0.a.u.h.b bVar = (d.a.m0.a.u.h.b) b2.first;
        if (!bVar.isSuccess()) {
            if (d.a.m0.a.u.c.d.f48594c) {
                d.a.m0.a.e0.d.b("Api-FullScreenApi", "parse fail");
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) b2.second;
        t(u(jSONObject.optBoolean("fullScreen"), jSONObject.optInt("direction")), jSONObject.optString("cb"));
        return new d.a.m0.a.u.h.b(0);
    }
}
