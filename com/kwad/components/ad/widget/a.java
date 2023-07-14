package com.kwad.components.ad.widget;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;
/* loaded from: classes10.dex */
public abstract class a implements ValueAnimator.AnimatorUpdateListener {
    public WeakReference<View> Ci;

    public a(View view2) {
        this.Ci = new WeakReference<>(view2);
    }

    public abstract void a(ViewGroup.LayoutParams layoutParams, Object obj);

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        WeakReference<View> weakReference = this.Ci;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        View view2 = this.Ci.get();
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        a(layoutParams, valueAnimator.getAnimatedValue());
        view2.setLayoutParams(layoutParams);
    }
}
