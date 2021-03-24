package d.b.g0.a.j2.g;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import d.b.g0.a.c;
import d.b.g0.a.i2.e;
import d.b.g0.a.q1.b.b.g;
/* loaded from: classes3.dex */
public class a implements g.c {

    /* renamed from: a  reason: collision with root package name */
    public FrameLayout f45036a = null;

    /* renamed from: d.b.g0.a.j2.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0715a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f45037e;

        public RunnableC0715a(ViewGroup viewGroup) {
            this.f45037e = viewGroup;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f45036a == null) {
                a.this.f45036a = new FrameLayout(this.f45037e.getContext());
                a.this.f45036a.setBackgroundResource(c.aiapps_night_mode_cover_layer);
            }
            this.f45037e.removeView(a.this.f45036a);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            this.f45037e.addView(a.this.f45036a, layoutParams);
        }
    }

    @Override // d.b.g0.a.q1.b.b.g.c
    public void a(g gVar, g.b bVar) {
        if (gVar == null || bVar == null || ProcessUtils.isMainProcess() || !SwanAppProcessInfo.isSwanAppProcess(ProcessUtils.getCurProcessName())) {
            return;
        }
        f(gVar);
        ViewGroup viewGroup = (ViewGroup) gVar.findViewById(16908290);
        if (viewGroup != null) {
            if (d.b.g0.a.w0.a.z().a()) {
                d(viewGroup, bVar.s);
            } else {
                e(viewGroup);
            }
        }
    }

    public final void d(ViewGroup viewGroup, View view) {
        if (viewGroup == null || view == null || !(viewGroup instanceof FrameLayout)) {
            return;
        }
        view.post(new RunnableC0715a(viewGroup));
    }

    public final void e(ViewGroup viewGroup) {
        FrameLayout frameLayout;
        if (viewGroup == null || (frameLayout = this.f45036a) == null) {
            return;
        }
        viewGroup.removeView(frameLayout);
        this.f45036a = null;
    }

    public final void f(g gVar) {
        Context context = gVar.getContext();
        if (gVar.getContext() instanceof ContextWrapper) {
            context = ((ContextWrapper) gVar.getContext()).getBaseContext();
        }
        if (context instanceof Activity) {
            e.b((Activity) context, gVar);
        }
    }
}
