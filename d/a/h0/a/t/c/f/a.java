package d.a.h0.a.t.c.f;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.res.widget.loadingview.LoadingView;
import d.a.h0.a.i2.h0;
import d.a.h0.a.i2.k0;
import d.a.h0.a.q1.b.c.a;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends d.a.h0.a.t.b.d {

    /* renamed from: d.a.h0.a.t.c.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0774a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.q1.b.c.a f44085e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f44086f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f44087g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ boolean f44088h;

        public RunnableC0774a(a aVar, d.a.h0.a.q1.b.c.a aVar2, Context context, String str, boolean z) {
            this.f44085e = aVar2;
            this.f44086f = context;
            this.f44087g = str;
            this.f44088h = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            LoadingView loadingView;
            View e2 = this.f44085e.e();
            if (e2 instanceof LoadingView) {
                loadingView = (LoadingView) e2;
            } else {
                loadingView = new LoadingView(this.f44086f);
                FrameLayout frameLayout = new FrameLayout(this.f44086f);
                frameLayout.setPadding(0, 0, 0, h0.f(160.0f));
                frameLayout.addView(loadingView);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 17;
                this.f44085e.k(frameLayout, layoutParams);
            }
            if (!TextUtils.isEmpty(this.f44087g)) {
                loadingView.setMsg(this.f44087g);
            }
            this.f44085e.i(this.f44088h);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.e0.l.c f44089e;

        public b(a aVar, d.a.h0.a.e0.l.c cVar) {
            this.f44089e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.h0.a.q1.b.c.a floatLayer = ((a.InterfaceC0736a) this.f44089e).getFloatLayer();
            if (floatLayer != null && (floatLayer.e() instanceof FrameLayout) && (((FrameLayout) floatLayer.e()).getChildAt(0) instanceof LoadingView)) {
                floatLayer.g();
            }
        }
    }

    public a(@NonNull d.a.h0.a.t.b.b bVar) {
        super(bVar);
    }

    public final void q(@NonNull d.a.h0.a.q1.b.c.a aVar, @NonNull Context context, String str, boolean z) {
        k0.X(new RunnableC0774a(this, aVar, context, str, z));
    }

    public d.a.h0.a.t.e.b r() {
        Context h2 = h();
        if (!(h2 instanceof SwanAppActivity)) {
            if (d.a.h0.a.t.b.d.f44021c) {
                d.a.h0.a.c0.c.b("Api-LoadingView", "context not support");
            }
            return new d.a.h0.a.t.e.b(1001, "context not support");
        }
        d.a.h0.a.e0.l.f swanAppFragmentManager = ((SwanAppActivity) h2).getSwanAppFragmentManager();
        if (swanAppFragmentManager == null) {
            if (d.a.h0.a.t.b.d.f44021c) {
                d.a.h0.a.c0.c.b("Api-LoadingView", "none fragmentManger");
            }
            return new d.a.h0.a.t.e.b(1001, "none fragmentManger");
        }
        d.a.h0.a.e0.l.c m = swanAppFragmentManager.m();
        if (!(m instanceof a.InterfaceC0736a)) {
            if (d.a.h0.a.t.b.d.f44021c) {
                d.a.h0.a.c0.c.b("Api-LoadingView", "fragment not support");
            }
            return new d.a.h0.a.t.e.b(1001, "fragment not support");
        } else if (m.m() == null) {
            if (d.a.h0.a.t.b.d.f44021c) {
                d.a.h0.a.c0.c.b("Api-LoadingView", "fragment has detached");
            }
            return new d.a.h0.a.t.e.b(1001, "fragment has detached");
        } else {
            k0.X(new b(this, m));
            d.a.h0.a.c0.c.g("Api-LoadingView", "hide loading success");
            return new d.a.h0.a.t.e.b(0);
        }
    }

    public d.a.h0.a.t.e.b s(String str) {
        if (d.a.h0.a.t.b.d.f44021c) {
            Log.d("Api-LoadingView", "start show loading");
        }
        if (k()) {
            d.a.h0.a.c0.c.b("Api-LoadingView", "Api-LoadingView does not supported when app is invisible.");
            return new d.a.h0.a.t.e.b(1001, "Api-LoadingView does not supported when app is invisible.");
        }
        Pair<d.a.h0.a.t.e.b, JSONObject> a2 = d.a.h0.a.t.f.b.a("Api-LoadingView", str);
        d.a.h0.a.t.e.b bVar = (d.a.h0.a.t.e.b) a2.first;
        if (!bVar.a()) {
            if (d.a.h0.a.t.b.d.f44021c) {
                d.a.h0.a.c0.c.b("Api-LoadingView", "parse fail");
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) a2.second;
        d.a.h0.a.c0.c.g("Api-LoadingView", "handleShowLoading : joParams = \n" + jSONObject);
        String optString = jSONObject.optString("title");
        if (TextUtils.isEmpty(optString)) {
            if (d.a.h0.a.t.b.d.f44021c) {
                d.a.h0.a.c0.c.b("Api-LoadingView", "none title");
            }
            return new d.a.h0.a.t.e.b(202, "none title");
        }
        boolean optBoolean = jSONObject.optBoolean("mask", false);
        Context h2 = h();
        if (!(h2 instanceof SwanAppActivity)) {
            if (d.a.h0.a.t.b.d.f44021c) {
                d.a.h0.a.c0.c.b("Api-LoadingView", "context not support");
            }
            return new d.a.h0.a.t.e.b(1001, "context not support");
        }
        d.a.h0.a.e0.l.f swanAppFragmentManager = ((SwanAppActivity) h2).getSwanAppFragmentManager();
        if (swanAppFragmentManager == null) {
            if (d.a.h0.a.t.b.d.f44021c) {
                d.a.h0.a.c0.c.b("Api-LoadingView", "none fragment");
            }
            return new d.a.h0.a.t.e.b(1001, "none fragment");
        }
        d.a.h0.a.e0.l.c m = swanAppFragmentManager.m();
        if (!(m instanceof a.InterfaceC0736a)) {
            if (d.a.h0.a.t.b.d.f44021c) {
                d.a.h0.a.c0.c.b("Api-LoadingView", "fragment not support");
            }
            return new d.a.h0.a.t.e.b(1001, "fragment not support");
        }
        d.a.h0.a.q1.b.c.a floatLayer = ((a.InterfaceC0736a) m).getFloatLayer();
        if (floatLayer == null) {
            if (d.a.h0.a.t.b.d.f44021c) {
                d.a.h0.a.c0.c.b("Api-LoadingView", "can't get floatLayer");
            }
            return new d.a.h0.a.t.e.b(1001, "can't get floatLayer");
        }
        q(floatLayer, h2, optString, optBoolean);
        d.a.h0.a.c0.c.g("Api-LoadingView", "show loading success");
        return new d.a.h0.a.t.e.b(0);
    }
}
