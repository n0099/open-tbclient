package com.kwad.components.ad.splashscreen.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.motion.widget.Key;
import com.kwad.sdk.R;
/* loaded from: classes8.dex */
public class KsRotateView extends b {
    public static int Al = 50;
    public static int Am = -12;
    public static int An = -25;
    public static int Ao = 12;
    public static int Ap = 25;
    public ImageView Ak;
    @DrawableRes
    public int Aq;
    public ImageView nC;

    public KsRotateView(@NonNull Context context) {
        super(context);
    }

    public KsRotateView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public KsRotateView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    public final void a(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_KsShakeView, i, 0);
        this.Aq = obtainStyledAttributes.getResourceId(5, com.baidu.tieba.R.drawable.obfuscated_res_0x7f080c8a);
        obtainStyledAttributes.recycle();
        ImageView imageView = new ImageView(getContext());
        this.Ak = imageView;
        imageView.setImageResource(com.baidu.tieba.R.drawable.obfuscated_res_0x7f080c89);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 49;
        addView(this.Ak, layoutParams);
        this.nC = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = com.kwad.sdk.b.kwai.a.a(context, 22.0f);
        layoutParams2.gravity = 1;
        addView(this.nC, layoutParams2);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    public int getAnimationDelayTime() {
        return 500;
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    public View getInteractionView() {
        return this.nC;
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    public final Animator kD() {
        View interactionView = getInteractionView();
        if (interactionView == null) {
            return null;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        interactionView.setPivotX(interactionView.getWidth() / 2.0f);
        interactionView.setPivotY(interactionView.getHeight() / 2.0f);
        ObjectAnimator duration = ObjectAnimator.ofFloat(interactionView, "rotation", 0.0f, An).setDuration(500L);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(interactionView, Key.ALPHA, 1.0f, 1.0f);
        ofFloat.setDuration(340L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(interactionView, "rotation", An, 0.0f).setDuration(Al);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(interactionView, "rotation", 0.0f, Ao).setDuration(Al);
        ObjectAnimator duration4 = ObjectAnimator.ofFloat(interactionView, "rotation", Ao, 0.0f).setDuration(Al);
        ObjectAnimator duration5 = ObjectAnimator.ofFloat(interactionView, "rotation", 0.0f, Am).setDuration(Al);
        ObjectAnimator duration6 = ObjectAnimator.ofFloat(interactionView, "rotation", Am, 0.0f).setDuration(Al);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(interactionView, Key.ALPHA, 1.0f, 1.0f);
        ofFloat2.setDuration(500L);
        ObjectAnimator duration7 = ObjectAnimator.ofFloat(interactionView, "rotation", 0.0f, Ap).setDuration(500L);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(interactionView, Key.ALPHA, 1.0f, 1.0f);
        ofFloat.setDuration(340L);
        animatorSet.playSequentially(duration, ofFloat, duration2, duration3, duration4, duration5, duration6, ofFloat2, duration7, ofFloat3, ObjectAnimator.ofFloat(interactionView, "rotation", Ap, 0.0f).setDuration(Al), ObjectAnimator.ofFloat(interactionView, "rotation", 0.0f, Am).setDuration(Al), ObjectAnimator.ofFloat(interactionView, "rotation", Am, 0.0f).setDuration(Al), ObjectAnimator.ofFloat(interactionView, "rotation", 0.0f, Ao).setDuration(Al), ObjectAnimator.ofFloat(interactionView, "rotation", Ao, 0.0f).setDuration(Al));
        return animatorSet;
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    public final void kE() {
        getInteractionView().setRotation(0.0f);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    public final void kp() {
        this.nC.setImageResource(this.Aq);
    }
}
