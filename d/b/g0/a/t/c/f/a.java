package d.b.g0.a.t.c.f;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.res.widget.loadingview.LoadingView;
import d.b.g0.a.i2.h0;
import d.b.g0.a.i2.k0;
import d.b.g0.a.q1.b.c.a;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends d.b.g0.a.t.b.d {

    /* renamed from: d.b.g0.a.t.c.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0802a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.q1.b.c.a f45988e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f45989f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f45990g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ boolean f45991h;

        public RunnableC0802a(a aVar, d.b.g0.a.q1.b.c.a aVar2, Context context, String str, boolean z) {
            this.f45988e = aVar2;
            this.f45989f = context;
            this.f45990g = str;
            this.f45991h = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            LoadingView loadingView;
            View e2 = this.f45988e.e();
            if (e2 instanceof LoadingView) {
                loadingView = (LoadingView) e2;
            } else {
                loadingView = new LoadingView(this.f45989f);
                FrameLayout frameLayout = new FrameLayout(this.f45989f);
                frameLayout.setPadding(0, 0, 0, h0.f(160.0f));
                frameLayout.addView(loadingView);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 17;
                this.f45988e.k(frameLayout, layoutParams);
            }
            if (!TextUtils.isEmpty(this.f45990g)) {
                loadingView.setMsg(this.f45990g);
            }
            this.f45988e.i(this.f45991h);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.e0.l.c f45992e;

        public b(a aVar, d.b.g0.a.e0.l.c cVar) {
            this.f45992e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.g0.a.q1.b.c.a floatLayer = ((a.InterfaceC0764a) this.f45992e).getFloatLayer();
            if (floatLayer != null && (floatLayer.e() instanceof FrameLayout) && (((FrameLayout) floatLayer.e()).getChildAt(0) instanceof LoadingView)) {
                floatLayer.g();
            }
        }
    }

    public a(@NonNull d.b.g0.a.t.b.b bVar) {
        super(bVar);
    }

    public final void q(@NonNull d.b.g0.a.q1.b.c.a aVar, @NonNull Context context, String str, boolean z) {
        k0.X(new RunnableC0802a(this, aVar, context, str, z));
    }

    public d.b.g0.a.t.e.b r() {
        Context h2 = h();
        if (!(h2 instanceof SwanAppActivity)) {
            if (d.b.g0.a.t.b.d.f45928c) {
                d.b.g0.a.c0.c.b("Api-LoadingView", "context not support");
            }
            return new d.b.g0.a.t.e.b(1001, "context not support");
        }
        d.b.g0.a.e0.l.f swanAppFragmentManager = ((SwanAppActivity) h2).getSwanAppFragmentManager();
        if (swanAppFragmentManager == null) {
            if (d.b.g0.a.t.b.d.f45928c) {
                d.b.g0.a.c0.c.b("Api-LoadingView", "none fragmentManger");
            }
            return new d.b.g0.a.t.e.b(1001, "none fragmentManger");
        }
        d.b.g0.a.e0.l.c m = swanAppFragmentManager.m();
        if (!(m instanceof a.InterfaceC0764a)) {
            if (d.b.g0.a.t.b.d.f45928c) {
                d.b.g0.a.c0.c.b("Api-LoadingView", "fragment not support");
            }
            return new d.b.g0.a.t.e.b(1001, "fragment not support");
        } else if (m.l() == null) {
            if (d.b.g0.a.t.b.d.f45928c) {
                d.b.g0.a.c0.c.b("Api-LoadingView", "fragment has detached");
            }
            return new d.b.g0.a.t.e.b(1001, "fragment has detached");
        } else {
            k0.X(new b(this, m));
            d.b.g0.a.c0.c.g("Api-LoadingView", "hide loading success");
            return new d.b.g0.a.t.e.b(0);
        }
    }

    public d.b.g0.a.t.e.b s(String str) {
        if (d.b.g0.a.t.b.d.f45928c) {
            Log.d("Api-LoadingView", "start show loading");
        }
        if (k()) {
            d.b.g0.a.c0.c.b("Api-LoadingView", "Api-LoadingView does not supported when app is invisible.");
            return new d.b.g0.a.t.e.b(1001, "Api-LoadingView does not supported when app is invisible.");
        }
        Pair<d.b.g0.a.t.e.b, JSONObject> a2 = d.b.g0.a.t.f.b.a("Api-LoadingView", str);
        d.b.g0.a.t.e.b bVar = (d.b.g0.a.t.e.b) a2.first;
        if (!bVar.b()) {
            if (d.b.g0.a.t.b.d.f45928c) {
                d.b.g0.a.c0.c.b("Api-LoadingView", "parse fail");
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) a2.second;
        d.b.g0.a.c0.c.g("Api-LoadingView", "handleShowLoading : joParams = \n" + jSONObject);
        String optString = jSONObject.optString("title");
        if (TextUtils.isEmpty(optString)) {
            if (d.b.g0.a.t.b.d.f45928c) {
                d.b.g0.a.c0.c.b("Api-LoadingView", "none title");
            }
            return new d.b.g0.a.t.e.b(202, "none title");
        }
        boolean optBoolean = jSONObject.optBoolean("mask", false);
        Context h2 = h();
        if (!(h2 instanceof SwanAppActivity)) {
            if (d.b.g0.a.t.b.d.f45928c) {
                d.b.g0.a.c0.c.b("Api-LoadingView", "context not support");
            }
            return new d.b.g0.a.t.e.b(1001, "context not support");
        }
        d.b.g0.a.e0.l.f swanAppFragmentManager = ((SwanAppActivity) h2).getSwanAppFragmentManager();
        if (swanAppFragmentManager == null) {
            if (d.b.g0.a.t.b.d.f45928c) {
                d.b.g0.a.c0.c.b("Api-LoadingView", "none fragment");
            }
            return new d.b.g0.a.t.e.b(1001, "none fragment");
        }
        d.b.g0.a.e0.l.c m = swanAppFragmentManager.m();
        if (!(m instanceof a.InterfaceC0764a)) {
            if (d.b.g0.a.t.b.d.f45928c) {
                d.b.g0.a.c0.c.b("Api-LoadingView", "fragment not support");
            }
            return new d.b.g0.a.t.e.b(1001, "fragment not support");
        }
        d.b.g0.a.q1.b.c.a floatLayer = ((a.InterfaceC0764a) m).getFloatLayer();
        if (floatLayer == null) {
            if (d.b.g0.a.t.b.d.f45928c) {
                d.b.g0.a.c0.c.b("Api-LoadingView", "can't get floatLayer");
            }
            return new d.b.g0.a.t.e.b(1001, "can't get floatLayer");
        }
        q(floatLayer, h2, optString, optBoolean);
        d.b.g0.a.c0.c.g("Api-LoadingView", "show loading success");
        return new d.b.g0.a.t.e.b(0);
    }
}
