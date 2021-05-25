package d.a.n0.n2;

import android.content.Context;
import android.view.View;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class f {
    public static boolean a(d.a.m0.d0.h hVar) {
        if (hVar != null) {
            return hVar.isViewAttached();
        }
        return false;
    }

    public static void b(d.a.m0.d0.h hVar, View.OnClickListener onClickListener, Context context, View view, String str, boolean z) {
        if (a(hVar) || context == null || view == null) {
            return;
        }
        if (hVar == null) {
            hVar = new d.a.m0.d0.h(context, onClickListener);
        }
        hVar.j(context.getResources().getDimensionPixelSize(R.dimen.tbds530));
        hVar.attachView(view, z);
        hVar.o();
        hVar.onChangeSkinType();
    }
}
