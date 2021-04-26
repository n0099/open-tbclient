package d.a.h0.g.p;

import android.app.Activity;
import android.content.res.Resources;
import android.view.ViewGroup;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.games.inspector.SwanInspectorEndpoint;
import d.a.h0.a.e;
import d.a.h0.a.h;
import d.a.h0.a.q1.b.b.g;
import d.a.h0.g.q.a;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public FullScreenFloatView f46753a;

    /* loaded from: classes3.dex */
    public class a implements FullScreenFloatView.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f46754a;

        public a(Activity activity) {
            this.f46754a = activity;
        }

        @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.c
        public void a() {
        }

        @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.c
        public void onClick() {
            b.this.d(this.f46754a);
        }
    }

    public final void b(Activity activity) {
        FullScreenFloatView a2 = d.a.h0.a.q1.a.b.a(activity, (ViewGroup) activity.findViewById(16908290), 2);
        this.f46753a = a2;
        a2.setFloatButtonText(activity.getString(h.aiapps_swan_inspector_info_button));
        this.f46753a.setFloatImageBackground(e.aiapps_float_view_button_shape);
        this.f46753a.setAutoAttachEnable(false);
        this.f46753a.setDragImageListener(new a(activity));
        this.f46753a.setVisibility(0);
    }

    public void c(a.c cVar, Activity activity) {
        d.a.h0.g.z.a.a aVar;
        if (activity == null || this.f46753a != null) {
            return;
        }
        if (d.a.h0.g.p.a.f((cVar == null || (aVar = cVar.f46762c) == null) ? null : aVar.f46920f).b()) {
            b(activity);
        }
    }

    public final void d(Activity activity) {
        d.a.h0.a.r1.e h2 = d.a.h0.a.r1.e.h();
        if (h2 == null || h2.L() == null) {
            return;
        }
        Resources resources = activity.getResources();
        String u = SwanInspectorEndpoint.v().u(resources);
        g.a aVar = new g.a(activity);
        aVar.V(resources.getString(h.aiapps_swan_inspector_info_title));
        aVar.y(u);
        aVar.n(new d.a.h0.a.j2.g.a());
        aVar.m(false);
        aVar.O(h.aiapps_ok, null);
        aVar.X();
    }
}
