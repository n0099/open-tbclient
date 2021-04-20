package d.b.c.e.g;

import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import com.baidu.adp.lib.guide.MaskView;
/* loaded from: classes.dex */
public class a {
    public static View a(LayoutInflater layoutInflater, b bVar) {
        View b2 = bVar.b(layoutInflater);
        MaskView.LayoutParams layoutParams = new MaskView.LayoutParams(-2, -2);
        layoutParams.f2204c = bVar.getXOffset();
        layoutParams.f2205d = bVar.getYOffset();
        layoutParams.f2202a = bVar.a();
        layoutParams.f2203b = bVar.c();
        b2.setLayoutParams(layoutParams);
        return b2;
    }

    public static Rect b(View view, int i, int i2) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        Rect rect = new Rect();
        rect.set(iArr[0], iArr[1], iArr[0] + view.getMeasuredWidth(), iArr[1] + view.getMeasuredHeight());
        rect.offset(-i, -i2);
        return rect;
    }
}
