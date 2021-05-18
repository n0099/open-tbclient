package d.a.i0.h.r;

import android.app.Activity;
import android.content.res.Resources;
import android.view.ViewGroup;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.games.inspector.SwanInspectorEndpoint;
import d.a.i0.a.e;
import d.a.i0.a.z1.b.b.h;
import d.a.i0.f.g;
import d.a.i0.h.s.a;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public FullScreenFloatView f47491a;

    /* loaded from: classes3.dex */
    public class a implements FullScreenFloatView.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f47492a;

        public a(Activity activity) {
            this.f47492a = activity;
        }

        @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.c
        public void a() {
        }

        @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.c
        public void onClick() {
            b.this.d(this.f47492a);
        }
    }

    public final void b(Activity activity) {
        FullScreenFloatView a2 = d.a.i0.a.z1.a.a.a(activity, (ViewGroup) activity.findViewById(16908290), 2);
        this.f47491a = a2;
        a2.setFloatButtonText(activity.getString(g.aiapps_game_inspector_info_button));
        this.f47491a.setFloatImageBackground(e.aiapps_float_view_button_shape);
        this.f47491a.setAutoAttachEnable(false);
        this.f47491a.setDragImageListener(new a(activity));
        this.f47491a.setVisibility(0);
    }

    public void c(a.c cVar, Activity activity) {
        d.a.i0.h.c0.a.a aVar;
        if (activity == null || this.f47491a != null) {
            return;
        }
        if (d.a.i0.h.r.a.f((cVar == null || (aVar = cVar.f47500c) == null) ? null : aVar.f47085f).b()) {
            b(activity);
        }
    }

    public final void d(Activity activity) {
        d.a.i0.a.a2.e i2 = d.a.i0.a.a2.e.i();
        if (i2 == null || i2.N() == null) {
            return;
        }
        Resources resources = activity.getResources();
        String u = SwanInspectorEndpoint.v().u(resources);
        h.a aVar = new h.a(activity);
        aVar.V(resources.getString(g.aiapps_swan_inspector_info_title));
        aVar.x(u);
        aVar.n(new d.a.i0.a.w2.h.a());
        aVar.m(false);
        aVar.O(g.aiapps_ok, null);
        aVar.X();
    }
}
