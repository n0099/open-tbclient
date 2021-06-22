package d.a.m0.a.w2.j;

import android.content.Context;
import android.view.View;
import android.widget.PopupWindow;
import com.baidu.swan.apps.view.menu.SwanImageMenuView;
import java.util.List;
/* loaded from: classes3.dex */
public class b extends d.a.m0.a.z1.b.e.a {
    public b(View view) {
        super(view);
        s(-1);
        p(true);
        q(true);
    }

    @Override // d.a.m0.a.z1.b.e.a
    public void l(View view, List<d.a.m0.a.z1.b.e.b> list) {
        ((SwanImageMenuView) view).d(list);
    }

    @Override // d.a.m0.a.z1.b.e.a
    public View m(Context context) {
        SwanImageMenuView swanImageMenuView = new SwanImageMenuView(context);
        swanImageMenuView.setMenu(this);
        return swanImageMenuView;
    }

    @Override // d.a.m0.a.z1.b.e.a
    public void u(PopupWindow popupWindow) {
        popupWindow.showAtLocation(this.f49929a, 80, 0, 0);
    }
}
