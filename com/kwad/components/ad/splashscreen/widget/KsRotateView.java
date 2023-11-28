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
/* loaded from: classes10.dex */
public class KsRotateView extends b {
    public static int FU = 50;
    public static int FV = -12;
    public static int FW = -25;
    public static int FX = 12;
    public static int FY = 25;
    public ImageView FT;
    @DrawableRes
    public int FZ;
    public ImageView fq;

    @Override // com.kwad.components.ad.splashscreen.widget.b
    public int getAnimationDelayTime() {
        return 500;
    }

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
        this.FZ = obtainStyledAttributes.getResourceId(5, com.baidu.tieba.R.drawable.obfuscated_res_0x7f080e82);
        obtainStyledAttributes.recycle();
        ImageView imageView = new ImageView(getContext());
        this.FT = imageView;
        imageView.setImageResource(com.baidu.tieba.R.drawable.obfuscated_res_0x7f080e81);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 49;
        addView(this.FT, layoutParams);
        this.fq = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = com.kwad.sdk.d.a.a.a(context, 22.0f);
        layoutParams2.gravity = 1;
        addView(this.fq, layoutParams2);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    public View getInteractionView() {
        return this.fq;
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    public final void lK() {
        this.fq.setImageResource(this.FZ);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    public final void lM() {
        getInteractionView().setRotation(0.0f);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    public final Animator lL() {
        View interactionView = getInteractionView();
        if (interactionView == null) {
            return null;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        interactionView.setPivotX(interactionView.getWidth() / 2.0f);
        interactionView.setPivotY(interactionView.getHeight() / 2.0f);
        ObjectAnimator duration = ObjectAnimator.ofFloat(interactionView, "rotation", 0.0f, FW).setDuration(500L);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(interactionView, Key.ALPHA, 1.0f, 1.0f);
        ofFloat.setDuration(340L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(interactionView, "rotation", FW, 0.0f).setDuration(FU);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(interactionView, "rotation", 0.0f, FX).setDuration(FU);
        ObjectAnimator duration4 = ObjectAnimator.ofFloat(interactionView, "rotation", FX, 0.0f).setDuration(FU);
        ObjectAnimator duration5 = ObjectAnimator.ofFloat(interactionView, "rotation", 0.0f, FV).setDuration(FU);
        ObjectAnimator duration6 = ObjectAnimator.ofFloat(interactionView, "rotation", FV, 0.0f).setDuration(FU);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(interactionView, Key.ALPHA, 1.0f, 1.0f);
        ofFloat2.setDuration(500L);
        ObjectAnimator duration7 = ObjectAnimator.ofFloat(interactionView, "rotation", 0.0f, FY).setDuration(500L);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(interactionView, Key.ALPHA, 1.0f, 1.0f);
        ofFloat.setDuration(340L);
        animatorSet.playSequentially(duration, ofFloat, duration2, duration3, duration4, duration5, duration6, ofFloat2, duration7, ofFloat3, ObjectAnimator.ofFloat(interactionView, "rotation", FY, 0.0f).setDuration(FU), ObjectAnimator.ofFloat(interactionView, "rotation", 0.0f, FV).setDuration(FU), ObjectAnimator.ofFloat(interactionView, "rotation", FV, 0.0f).setDuration(FU), ObjectAnimator.ofFloat(interactionView, "rotation", 0.0f, FX).setDuration(FU), ObjectAnimator.ofFloat(interactionView, "rotation", FX, 0.0f).setDuration(FU));
        return animatorSet;
    }
}
