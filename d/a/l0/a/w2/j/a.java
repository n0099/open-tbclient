package d.a.l0.a.w2.j;

import android.content.Context;
import android.view.View;
import android.widget.PopupWindow;
import com.baidu.swan.apps.view.menu.SwanContextMenuView;
import d.a.l0.a.v2.n0;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends d.a.l0.a.z1.b.e.a {
    public a(View view) {
        super(view);
        s(n0.f(view.getContext(), 178.0f));
        p(true);
        q(true);
    }

    @Override // d.a.l0.a.z1.b.e.a
    public void l(View view, List<d.a.l0.a.z1.b.e.b> list) {
        ((SwanContextMenuView) view).c(list);
    }

    @Override // d.a.l0.a.z1.b.e.a
    public View m(Context context) {
        return new SwanContextMenuView(context);
    }

    @Override // d.a.l0.a.z1.b.e.a
    public void u(PopupWindow popupWindow) {
        popupWindow.showAtLocation(this.f49821a, 17, 0, 0);
    }
}
