package d.a.m0.a.u.e.g;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.res.widget.loadingview.LoadingView;
import d.a.m0.a.v2.n0;
import d.a.m0.a.v2.q0;
import d.a.m0.a.z1.b.c.a;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends d.a.m0.a.u.c.d {

    /* renamed from: d.a.m0.a.u.e.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0899a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.z1.b.c.a f48695e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f48696f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f48697g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ boolean f48698h;

        public RunnableC0899a(a aVar, d.a.m0.a.z1.b.c.a aVar2, Context context, String str, boolean z) {
            this.f48695e = aVar2;
            this.f48696f = context;
            this.f48697g = str;
            this.f48698h = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            LoadingView loadingView;
            View e2 = this.f48695e.e();
            if (e2 instanceof LoadingView) {
                loadingView = (LoadingView) e2;
            } else {
                loadingView = new LoadingView(this.f48696f);
                FrameLayout frameLayout = new FrameLayout(this.f48696f);
                frameLayout.setPadding(0, 0, 0, n0.g(160.0f));
                frameLayout.addView(loadingView);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 17;
                this.f48695e.l(frameLayout, layoutParams);
            }
            if (!TextUtils.isEmpty(this.f48697g)) {
                loadingView.setMsg(this.f48697g);
            }
            this.f48695e.i(this.f48698h);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.h0.g.d f48699e;

        public b(a aVar, d.a.m0.a.h0.g.d dVar) {
            this.f48699e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.m0.a.z1.b.c.a floatLayer = ((a.InterfaceC0994a) this.f48699e).getFloatLayer();
            if (floatLayer != null && (floatLayer.e() instanceof FrameLayout) && (((FrameLayout) floatLayer.e()).getChildAt(0) instanceof LoadingView)) {
                floatLayer.g();
            }
        }
    }

    public a(@NonNull d.a.m0.a.u.c.b bVar) {
        super(bVar);
    }

    public final void r(@NonNull d.a.m0.a.z1.b.c.a aVar, @NonNull Context context, String str, boolean z) {
        q0.b0(new RunnableC0899a(this, aVar, context, str, z));
    }

    public d.a.m0.a.u.h.b s() {
        Context i2 = i();
        if (!(i2 instanceof SwanAppActivity)) {
            if (d.a.m0.a.u.c.d.f48594c) {
                d.a.m0.a.e0.d.b("Api-LoadingView", "context not support");
            }
            return new d.a.m0.a.u.h.b(1001, "context not support");
        }
        d.a.m0.a.h0.g.g swanAppFragmentManager = ((SwanAppActivity) i2).getSwanAppFragmentManager();
        if (swanAppFragmentManager == null) {
            if (d.a.m0.a.u.c.d.f48594c) {
                d.a.m0.a.e0.d.b("Api-LoadingView", "none fragmentManger");
            }
            return new d.a.m0.a.u.h.b(1001, "none fragmentManger");
        }
        d.a.m0.a.h0.g.d m = swanAppFragmentManager.m();
        if (!(m instanceof a.InterfaceC0994a)) {
            if (d.a.m0.a.u.c.d.f48594c) {
                d.a.m0.a.e0.d.b("Api-LoadingView", "fragment not support");
            }
            return new d.a.m0.a.u.h.b(1001, "fragment not support");
        } else if (m.q() == null) {
            if (d.a.m0.a.u.c.d.f48594c) {
                d.a.m0.a.e0.d.b("Api-LoadingView", "fragment has detached");
            }
            return new d.a.m0.a.u.h.b(1001, "fragment has detached");
        } else {
            q0.b0(new b(this, m));
            d.a.m0.a.e0.d.g("Api-LoadingView", "hide loading success");
            return new d.a.m0.a.u.h.b(0);
        }
    }

    public d.a.m0.a.u.h.b t(String str) {
        if (d.a.m0.a.u.c.d.f48594c) {
            Log.d("Api-LoadingView", "start show loading");
        }
        if (l()) {
            d.a.m0.a.e0.d.b("Api-LoadingView", "Api-LoadingView does not supported when app is invisible.");
            return new d.a.m0.a.u.h.b(1001, "Api-LoadingView does not supported when app is invisible.");
        }
        Pair<d.a.m0.a.u.h.b, JSONObject> b2 = d.a.m0.a.u.i.b.b("Api-LoadingView", str);
        d.a.m0.a.u.h.b bVar = (d.a.m0.a.u.h.b) b2.first;
        if (!bVar.isSuccess()) {
            if (d.a.m0.a.u.c.d.f48594c) {
                d.a.m0.a.e0.d.b("Api-LoadingView", "parse fail");
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) b2.second;
        d.a.m0.a.e0.d.g("Api-LoadingView", "handleShowLoading : joParams = \n" + jSONObject);
        String optString = jSONObject.optString("title");
        if (TextUtils.isEmpty(optString)) {
            if (d.a.m0.a.u.c.d.f48594c) {
                d.a.m0.a.e0.d.b("Api-LoadingView", "none title");
            }
            return new d.a.m0.a.u.h.b(202, "none title");
        }
        boolean optBoolean = jSONObject.optBoolean("mask", false);
        Context i2 = i();
        if (!(i2 instanceof SwanAppActivity)) {
            if (d.a.m0.a.u.c.d.f48594c) {
                d.a.m0.a.e0.d.b("Api-LoadingView", "context not support");
            }
            return new d.a.m0.a.u.h.b(1001, "context not support");
        }
        d.a.m0.a.h0.g.g swanAppFragmentManager = ((SwanAppActivity) i2).getSwanAppFragmentManager();
        if (swanAppFragmentManager == null) {
            if (d.a.m0.a.u.c.d.f48594c) {
                d.a.m0.a.e0.d.b("Api-LoadingView", "none fragment");
            }
            return new d.a.m0.a.u.h.b(1001, "none fragment");
        }
        d.a.m0.a.h0.g.d m = swanAppFragmentManager.m();
        if (!(m instanceof a.InterfaceC0994a)) {
            if (d.a.m0.a.u.c.d.f48594c) {
                d.a.m0.a.e0.d.b("Api-LoadingView", "fragment not support");
            }
            return new d.a.m0.a.u.h.b(1001, "fragment not support");
        }
        d.a.m0.a.z1.b.c.a floatLayer = ((a.InterfaceC0994a) m).getFloatLayer();
        if (floatLayer == null) {
            if (d.a.m0.a.u.c.d.f48594c) {
                d.a.m0.a.e0.d.b("Api-LoadingView", "can't get floatLayer");
            }
            return new d.a.m0.a.u.h.b(1001, "can't get floatLayer");
        }
        r(floatLayer, i2, optString, optBoolean);
        d.a.m0.a.e0.d.g("Api-LoadingView", "show loading success");
        return new d.a.m0.a.u.h.b(0);
    }
}
