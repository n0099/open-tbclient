package d.b.g0.g.p;

import android.app.Activity;
import android.content.res.Resources;
import android.view.ViewGroup;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.games.inspector.SwanInspectorEndpoint;
import d.b.g0.a.e;
import d.b.g0.a.h;
import d.b.g0.a.q1.b.b.g;
import d.b.g0.g.q.a;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public FullScreenFloatView f48537a;

    /* loaded from: classes3.dex */
    public class a implements FullScreenFloatView.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f48538a;

        public a(Activity activity) {
            this.f48538a = activity;
        }

        @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.c
        public void a() {
        }

        @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.c
        public void onClick() {
            b.this.d(this.f48538a);
        }
    }

    public final void b(Activity activity) {
        FullScreenFloatView a2 = d.b.g0.a.q1.a.b.a(activity, (ViewGroup) activity.findViewById(16908290), 2);
        this.f48537a = a2;
        a2.setFloatButtonText(activity.getString(h.aiapps_swan_inspector_info_button));
        this.f48537a.setFloatImageBackground(e.aiapps_float_view_button_shape);
        this.f48537a.setAutoAttachEnable(false);
        this.f48537a.setDragImageListener(new a(activity));
        this.f48537a.setVisibility(0);
    }

    public void c(a.c cVar, Activity activity) {
        d.b.g0.g.z.a.a aVar;
        if (activity == null || this.f48537a != null) {
            return;
        }
        if (d.b.g0.g.p.a.f((cVar == null || (aVar = cVar.f48546c) == null) ? null : aVar.f48698f).b()) {
            b(activity);
        }
    }

    public final void d(Activity activity) {
        d.b.g0.a.r1.e y = d.b.g0.a.r1.e.y();
        if (y == null || y.L() == null) {
            return;
        }
        Resources resources = activity.getResources();
        String u = SwanInspectorEndpoint.v().u(resources);
        g.a aVar = new g.a(activity);
        aVar.V(resources.getString(h.aiapps_swan_inspector_info_title));
        aVar.y(u);
        aVar.n(new d.b.g0.a.j2.g.a());
        aVar.m(false);
        aVar.O(h.aiapps_ok, null);
        aVar.X();
    }
}
