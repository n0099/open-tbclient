package d.a.m0.a.w2.h;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import d.a.m0.a.e;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public RelativeLayout f49509a = null;

    public final void a(ViewGroup viewGroup) {
        if (viewGroup != null && (viewGroup instanceof RelativeLayout)) {
            if (this.f49509a == null) {
                RelativeLayout relativeLayout = new RelativeLayout(viewGroup.getContext());
                this.f49509a = relativeLayout;
                relativeLayout.setBackgroundResource(e.aiapps_night_black_background_bg);
            }
            viewGroup.removeView(this.f49509a);
            viewGroup.addView(this.f49509a, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    public void b(ViewGroup viewGroup) {
        if (viewGroup == null || ProcessUtils.isMainProcess() || !SwanAppProcessInfo.isSwanAppProcess(ProcessUtils.getCurProcessName())) {
            return;
        }
        if (d.a.m0.a.c1.a.H().a()) {
            a(viewGroup);
        } else {
            c(viewGroup);
        }
    }

    public final void c(ViewGroup viewGroup) {
        RelativeLayout relativeLayout;
        if (viewGroup == null || (relativeLayout = this.f49509a) == null) {
            return;
        }
        viewGroup.removeView(relativeLayout);
        this.f49509a = null;
    }
}
