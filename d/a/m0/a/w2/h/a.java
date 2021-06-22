package d.a.m0.a.w2.h;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import d.a.m0.a.v2.f;
import d.a.m0.a.z1.b.b.h;
/* loaded from: classes3.dex */
public class a implements h.c {

    /* renamed from: a  reason: collision with root package name */
    public FrameLayout f49505a = null;

    /* renamed from: d.a.m0.a.w2.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0960a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f49506e;

        public RunnableC0960a(ViewGroup viewGroup) {
            this.f49506e = viewGroup;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f49505a == null) {
                a.this.f49505a = new FrameLayout(this.f49506e.getContext());
                a.this.f49505a.setBackgroundResource(d.a.m0.a.c.aiapps_night_mode_cover_layer);
            }
            this.f49506e.removeView(a.this.f49505a);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            this.f49506e.addView(a.this.f49505a, layoutParams);
        }
    }

    @Override // d.a.m0.a.z1.b.b.h.c
    public void a(h hVar, h.b bVar) {
        if (hVar == null || bVar == null || ProcessUtils.isMainProcess() || !SwanAppProcessInfo.isSwanAppProcess(ProcessUtils.getCurProcessName())) {
            return;
        }
        f(hVar);
        ViewGroup viewGroup = (ViewGroup) hVar.findViewById(16908290);
        if (viewGroup != null) {
            if (d.a.m0.a.c1.a.H().a()) {
                d(viewGroup, bVar.r);
            } else {
                e(viewGroup);
            }
        }
    }

    public final void d(ViewGroup viewGroup, View view) {
        if (viewGroup == null || view == null || !(viewGroup instanceof FrameLayout)) {
            return;
        }
        view.post(new RunnableC0960a(viewGroup));
    }

    public final void e(ViewGroup viewGroup) {
        FrameLayout frameLayout;
        if (viewGroup == null || (frameLayout = this.f49505a) == null) {
            return;
        }
        viewGroup.removeView(frameLayout);
        this.f49505a = null;
    }

    public final void f(h hVar) {
        Context context = hVar.getContext();
        if (hVar.getContext() instanceof ContextWrapper) {
            context = ((ContextWrapper) hVar.getContext()).getBaseContext();
        }
        if (context instanceof Activity) {
            f.b((Activity) context, hVar);
        }
    }
}
