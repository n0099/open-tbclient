package d.a.i0.k;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.baidu.swan.menu.BaseMenuView;
/* loaded from: classes3.dex */
public class c {
    public static long a(BaseMenuView baseMenuView) {
        return baseMenuView.b() ? 240L : 200L;
    }

    public static ObjectAnimator b(BaseMenuView baseMenuView) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(baseMenuView, "translationY", 0.0f);
        ofFloat.setDuration(a(baseMenuView));
        ofFloat.setInterpolator(new d(0.32f, 0.6f, 0.1f, 1.0f));
        return ofFloat;
    }

    public static ObjectAnimator c(View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 0.0f);
        ofFloat.setDuration(160L);
        ofFloat.setInterpolator(new LinearInterpolator());
        return ofFloat;
    }

    public static ObjectAnimator d(View view, BaseMenuView baseMenuView) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f);
        ofFloat.setDuration(a(baseMenuView));
        ofFloat.setInterpolator(new LinearInterpolator());
        return ofFloat;
    }

    public static ObjectAnimator e(BaseMenuView baseMenuView) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(baseMenuView, "translationY", baseMenuView.getHeight());
        ofFloat.setDuration(160L);
        ofFloat.setInterpolator(new d(0.32f, 0.6f, 0.1f, 1.0f));
        return ofFloat;
    }
}
