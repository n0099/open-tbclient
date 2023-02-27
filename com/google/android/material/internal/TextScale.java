package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.transition.Transition;
import androidx.transition.TransitionValues;
import java.util.Map;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes7.dex */
public class TextScale extends Transition {
    public static final String PROPNAME_SCALE = "android:textscale:scale";

    private void captureValues(@NonNull TransitionValues transitionValues) {
        View view2 = transitionValues.f1027view;
        if (view2 instanceof TextView) {
            transitionValues.values.put(PROPNAME_SCALE, Float.valueOf(((TextView) view2).getScaleX()));
        }
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(@NonNull TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(@NonNull TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    @Override // androidx.transition.Transition
    public Animator createAnimator(@NonNull ViewGroup viewGroup, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        float f;
        if (transitionValues == null || transitionValues2 == null || !(transitionValues.f1027view instanceof TextView)) {
            return null;
        }
        View view2 = transitionValues2.f1027view;
        if (!(view2 instanceof TextView)) {
            return null;
        }
        final TextView textView = (TextView) view2;
        Map<String, Object> map = transitionValues.values;
        Map<String, Object> map2 = transitionValues2.values;
        float f2 = 1.0f;
        if (map.get(PROPNAME_SCALE) != null) {
            f = ((Float) map.get(PROPNAME_SCALE)).floatValue();
        } else {
            f = 1.0f;
        }
        if (map2.get(PROPNAME_SCALE) != null) {
            f2 = ((Float) map2.get(PROPNAME_SCALE)).floatValue();
        }
        if (f == f2) {
            return null;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f, f2);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.internal.TextScale.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                textView.setScaleX(floatValue);
                textView.setScaleY(floatValue);
            }
        });
        return ofFloat;
    }
}
