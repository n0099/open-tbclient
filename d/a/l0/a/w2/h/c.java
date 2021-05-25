package d.a.l0.a.w2.h;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import d.a.l0.a.e;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public RelativeLayout f45727a = null;

    public final void a(ViewGroup viewGroup) {
        if (viewGroup != null && (viewGroup instanceof RelativeLayout)) {
            if (this.f45727a == null) {
                RelativeLayout relativeLayout = new RelativeLayout(viewGroup.getContext());
                this.f45727a = relativeLayout;
                relativeLayout.setBackgroundResource(e.aiapps_night_black_background_bg);
            }
            viewGroup.removeView(this.f45727a);
            viewGroup.addView(this.f45727a, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    public void b(ViewGroup viewGroup) {
        if (viewGroup == null || ProcessUtils.isMainProcess() || !SwanAppProcessInfo.isSwanAppProcess(ProcessUtils.getCurProcessName())) {
            return;
        }
        if (d.a.l0.a.c1.a.H().a()) {
            a(viewGroup);
        } else {
            c(viewGroup);
        }
    }

    public final void c(ViewGroup viewGroup) {
        RelativeLayout relativeLayout;
        if (viewGroup == null || (relativeLayout = this.f45727a) == null) {
            return;
        }
        viewGroup.removeView(relativeLayout);
        this.f45727a = null;
    }
}
