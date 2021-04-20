package d.b.g0.a.j2.g;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.menu.BaseMenuView;
import d.b.g0.a.c;
/* loaded from: classes3.dex */
public class b implements d.b.g0.i.a {

    /* renamed from: a  reason: collision with root package name */
    public FrameLayout f45432a = null;

    @Override // d.b.g0.i.a
    public void a(BaseMenuView baseMenuView) {
        if (baseMenuView == null || ProcessUtils.isMainProcess() || !SwanAppProcessInfo.isSwanAppProcess(ProcessUtils.getCurProcessName())) {
            return;
        }
        if (d.b.g0.a.w0.a.z().a()) {
            b(baseMenuView);
        } else {
            c(baseMenuView);
        }
    }

    public final void b(ViewGroup viewGroup) {
        if (viewGroup != null && (viewGroup instanceof FrameLayout)) {
            if (this.f45432a == null) {
                FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
                this.f45432a = frameLayout;
                frameLayout.setBackgroundResource(c.aiapps_night_mode_cover_layer);
            }
            viewGroup.removeView(this.f45432a);
            viewGroup.addView(this.f45432a, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public final void c(ViewGroup viewGroup) {
        FrameLayout frameLayout;
        if (viewGroup == null || (frameLayout = this.f45432a) == null) {
            return;
        }
        viewGroup.removeView(frameLayout);
        this.f45432a = null;
    }
}
