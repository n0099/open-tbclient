package d.a.m0.h.r;

import android.app.Activity;
import android.content.res.Resources;
import android.view.ViewGroup;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.games.inspector.SwanInspectorEndpoint;
import d.a.m0.a.e;
import d.a.m0.a.z1.b.b.h;
import d.a.m0.f.g;
import d.a.m0.h.s.a;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public FullScreenFloatView f51449a;

    /* loaded from: classes3.dex */
    public class a implements FullScreenFloatView.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f51450a;

        public a(Activity activity) {
            this.f51450a = activity;
        }

        @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.c
        public void a() {
        }

        @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.c
        public void onClick() {
            b.this.d(this.f51450a);
        }
    }

    public final void b(Activity activity) {
        FullScreenFloatView a2 = d.a.m0.a.z1.a.a.a(activity, (ViewGroup) activity.findViewById(16908290), 2);
        this.f51449a = a2;
        a2.setFloatButtonText(activity.getString(g.aiapps_game_inspector_info_button));
        this.f51449a.setFloatImageBackground(e.aiapps_float_view_button_shape);
        this.f51449a.setAutoAttachEnable(false);
        this.f51449a.setDragImageListener(new a(activity));
        this.f51449a.setVisibility(0);
    }

    public void c(a.c cVar, Activity activity) {
        d.a.m0.h.c0.a.a aVar;
        if (activity == null || this.f51449a != null) {
            return;
        }
        if (d.a.m0.h.r.a.f((cVar == null || (aVar = cVar.f51458c) == null) ? null : aVar.f51043f).b()) {
            b(activity);
        }
    }

    public final void d(Activity activity) {
        d.a.m0.a.a2.e i2 = d.a.m0.a.a2.e.i();
        if (i2 == null || i2.N() == null) {
            return;
        }
        Resources resources = activity.getResources();
        String u = SwanInspectorEndpoint.v().u(resources);
        h.a aVar = new h.a(activity);
        aVar.V(resources.getString(g.aiapps_swan_inspector_info_title));
        aVar.x(u);
        aVar.n(new d.a.m0.a.w2.h.a());
        aVar.m(false);
        aVar.O(g.aiapps_ok, null);
        aVar.X();
    }
}
