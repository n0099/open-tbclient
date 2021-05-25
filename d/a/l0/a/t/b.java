package d.a.l0.a.t;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.LinearInterpolator;
import d.a.l0.k.d;
/* loaded from: classes2.dex */
public class b {
    public static ObjectAnimator a(View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationY", 0.0f);
        ofFloat.setDuration(320L);
        ofFloat.setInterpolator(new d(0.32f, 0.6f, 0.1f, 1.0f));
        return ofFloat;
    }

    public static ObjectAnimator b(View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 0.0f);
        ofFloat.setDuration(240L);
        ofFloat.setInterpolator(new LinearInterpolator());
        return ofFloat;
    }

    public static ObjectAnimator c(View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f);
        ofFloat.setDuration(320L);
        ofFloat.setInterpolator(new LinearInterpolator());
        return ofFloat;
    }

    public static ObjectAnimator d(View view, int i2) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationY", i2);
        ofFloat.setDuration(240L);
        ofFloat.setInterpolator(new d(0.32f, 0.6f, 0.1f, 1.0f));
        return ofFloat;
    }
}
