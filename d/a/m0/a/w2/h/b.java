package d.a.m0.a.w2.h;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.menu.BaseMenuView;
/* loaded from: classes3.dex */
public class b implements d.a.m0.k.a {

    /* renamed from: a  reason: collision with root package name */
    public FrameLayout f49508a = null;

    @Override // d.a.m0.k.a
    public void a(BaseMenuView baseMenuView) {
        if (baseMenuView == null || ProcessUtils.isMainProcess() || !SwanAppProcessInfo.isSwanAppProcess(ProcessUtils.getCurProcessName())) {
            return;
        }
        if (d.a.m0.a.c1.a.H().a()) {
            b(baseMenuView);
        } else {
            c(baseMenuView);
        }
    }

    public final void b(ViewGroup viewGroup) {
        if (viewGroup != null && (viewGroup instanceof FrameLayout)) {
            if (this.f49508a == null) {
                FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
                this.f49508a = frameLayout;
                frameLayout.setBackgroundResource(d.a.m0.a.c.aiapps_night_mode_cover_layer);
            }
            viewGroup.removeView(this.f49508a);
            viewGroup.addView(this.f49508a, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public final void c(ViewGroup viewGroup) {
        FrameLayout frameLayout;
        if (viewGroup == null || (frameLayout = this.f49508a) == null) {
            return;
        }
        viewGroup.removeView(frameLayout);
        this.f49508a = null;
    }
}
