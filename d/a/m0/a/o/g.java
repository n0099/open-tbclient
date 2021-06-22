package d.a.m0.a.o;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.view.narootview.SwanAppInlineFullScreenContainer;
import d.a.m0.a.h;
import d.a.m0.a.h0.g.g;
import d.a.m0.a.v2.n0;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class g implements d.a.m0.f.i.l.f {

    /* renamed from: c  reason: collision with root package name */
    public static final ViewGroup.LayoutParams f47662c = new FrameLayout.LayoutParams(-1, -1);

    /* renamed from: a  reason: collision with root package name */
    public d.a.m0.a.h0.g.f f47663a;

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f47664b;

    @Override // d.a.m0.f.i.l.f
    public void a(String str, JSONObject jSONObject) {
        d.a.m0.a.h0.g.g W = d.a.m0.a.g1.f.V().W();
        Context appContext = AppRuntime.getAppContext();
        if (W == null) {
            if (appContext != null) {
                d.a.m0.a.z1.b.f.e.f(appContext, h.aiapps_open_fragment_failed_toast).F();
                return;
            }
            return;
        }
        d.a.m0.a.l1.b e2 = d.a.m0.a.l1.b.e(str, str);
        e2.i(jSONObject.toString());
        g.b i2 = W.i("adLanding");
        i2.n(d.a.m0.a.h0.g.g.f45860g, d.a.m0.a.h0.g.g.f45862i);
        i2.k("adLanding", e2).b();
    }

    @Override // d.a.m0.f.i.l.f
    public boolean b() {
        return false;
    }

    @Override // d.a.m0.f.i.l.f
    public boolean c(View view) {
        return false;
    }

    @Override // d.a.m0.f.i.l.f
    public boolean d(View view, d.a.m0.f.i.i.a aVar) {
        d.a.m0.a.h0.g.g W;
        d.a.m0.a.g1.f V = d.a.m0.a.g1.f.V();
        SwanAppActivity activity = V.getActivity();
        if (activity == null || activity.isFinishing() || (W = V.W()) == null) {
            return false;
        }
        d.a.m0.a.h0.g.f o = W.o();
        this.f47663a = o;
        if (o.t3()) {
            int u = n0.u();
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                    View childAt = viewGroup.getChildAt(i2);
                    if (childAt.getTop() < u) {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) childAt.getLayoutParams();
                        layoutParams.topMargin = childAt.getTop() + u;
                        childAt.setLayoutParams(layoutParams);
                    }
                }
            }
        }
        SwanAppInlineFullScreenContainer swanAppInlineFullScreenContainer = new SwanAppInlineFullScreenContainer(activity);
        this.f47664b = swanAppInlineFullScreenContainer;
        swanAppInlineFullScreenContainer.addView(view, f47662c);
        d.a.m0.a.z1.b.c.a floatLayer = o.getFloatLayer();
        if (floatLayer == null) {
            return false;
        }
        floatLayer.j(true);
        n0.b(activity);
        floatLayer.k(this.f47664b);
        return true;
    }

    @Override // d.a.m0.f.i.l.f
    public void e() {
    }

    @Override // d.a.m0.f.i.l.f
    public boolean f(View view, d.a.m0.f.i.i.a aVar) {
        return false;
    }

    @Override // d.a.m0.f.i.l.f
    public boolean removeView(View view) {
        d.a.m0.a.z1.b.c.a floatLayer;
        this.f47664b.removeAllViews();
        d.a.m0.a.h0.g.f fVar = this.f47663a;
        if (fVar == null || (floatLayer = fVar.getFloatLayer()) == null) {
            return false;
        }
        floatLayer.j(false);
        floatLayer.g();
        return true;
    }
}
