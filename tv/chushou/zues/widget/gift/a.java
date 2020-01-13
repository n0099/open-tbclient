package tv.chushou.zues.widget.gift;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.View;
/* loaded from: classes4.dex */
public class a {
    public static ObjectAnimator a(View view, float f, float f2, long j) {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("translationX", f, f2), PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f));
        ofPropertyValuesHolder.setDuration(j);
        return ofPropertyValuesHolder;
    }

    public static ObjectAnimator b(View view, float f, float f2, long j) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", f, f2);
        ofFloat.setDuration(j);
        return ofFloat;
    }

    public static ObjectAnimator a(View view, int i, int i2, long j) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationY", i, i2);
        ofFloat.setDuration(j);
        return ofFloat;
    }

    public static ObjectAnimator a(View view, int i, int i2, long j, int i3) {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("translationY", i, i2), PropertyValuesHolder.ofFloat("alpha", 1.0f, 0.0f));
        ofPropertyValuesHolder.setStartDelay(i3);
        ofPropertyValuesHolder.setDuration(j);
        return ofPropertyValuesHolder;
    }

    public static AnimatorSet a(ObjectAnimator objectAnimator, ObjectAnimator objectAnimator2) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(objectAnimator).before(objectAnimator2);
        return animatorSet;
    }
}
