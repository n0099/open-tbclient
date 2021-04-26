package d.a.j0.d2.p;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.LinearInterpolator;
import d.a.c.e.p.l;
/* loaded from: classes3.dex */
public class d {
    public static void b(final View view) {
        if (view.getVisibility() != 0) {
            view.setVisibility(0);
        }
        int i2 = l.i(view.getContext());
        ValueAnimator ofInt = ValueAnimator.ofInt((-i2) / 4, (i2 * 7) / 6);
        ofInt.setDuration(6000L);
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: d.a.j0.d2.p.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                view.setY(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        ofInt.start();
    }
}
