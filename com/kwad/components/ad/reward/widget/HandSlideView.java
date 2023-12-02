package com.kwad.components.ad.reward.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.baidu.tieba.R;
import com.kwad.sdk.widget.KSFrameLayout;
/* loaded from: classes10.dex */
public class HandSlideView extends KSFrameLayout {
    public AnimatorSet Aa;
    public float Ab;
    public float Ac;
    public float Ad;
    public long Ae;
    public long Af;
    public int Ag;
    public int Ah;
    public ImageView fi;
    public boolean started;
    public View zZ;

    /* loaded from: classes10.dex */
    public interface a {
        void onHandSlideLoopEnd();
    }

    public HandSlideView(@NonNull Context context) {
        super(context);
        this.Ae = 600L;
        this.Af = 500L;
        this.Ag = 3;
        this.Ah = 0;
        this.started = false;
    }

    public static /* synthetic */ int b(HandSlideView handSlideView) {
        int i = handSlideView.Ah;
        handSlideView.Ah = i + 1;
        return i;
    }

    public static ValueAnimator.AnimatorUpdateListener s(final View view2) {
        return new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.widget.HandSlideView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = (int) floatValue;
                    view2.setLayoutParams(layoutParams);
                }
            }
        };
    }

    public HandSlideView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Ae = 600L;
        this.Af = 500L;
        this.Ag = 3;
        this.Ah = 0;
        this.started = false;
    }

    public HandSlideView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Ae = 600L;
        this.Af = 500L;
        this.Ag = 3;
        this.Ah = 0;
        this.started = false;
    }

    private AnimatorSet b(View view2, View view3) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, Key.TRANSLATION_Y, 0.0f, -this.Ab);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view2, "rotation", 30.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view2, Key.ALPHA, 0.0f, 1.0f);
        ofFloat3.setDuration(10L);
        ValueAnimator ofFloat4 = ValueAnimator.ofFloat(this.Ac, this.Ad);
        ofFloat4.addUpdateListener(s(view3));
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(view3, Key.ALPHA, 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(this.Ae);
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3, ofFloat4, ofFloat5);
        animatorSet.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.0f, 0.2f, 1.0f));
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playTogether(ObjectAnimator.ofFloat(view2, Key.ALPHA, 1.0f, 0.0f), ObjectAnimator.ofFloat(view3, Key.ALPHA, 1.0f, 0.0f));
        animatorSet2.setDuration(this.Af);
        animatorSet2.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.0f, 0.2f, 1.0f));
        AnimatorSet animatorSet3 = new AnimatorSet();
        animatorSet3.playSequentially(animatorSet, animatorSet2);
        return animatorSet3;
    }

    public final void a(@Nullable final a aVar) {
        this.started = true;
        AnimatorSet b = b(this.fi, this.zZ);
        this.Aa = b;
        b.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.widget.HandSlideView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (HandSlideView.this.Aa == null) {
                    return;
                }
                HandSlideView.b(HandSlideView.this);
                if (HandSlideView.this.Ah < HandSlideView.this.Ag) {
                    HandSlideView.this.Aa.start();
                    return;
                }
                HandSlideView.this.Aa.removeListener(this);
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.onHandSlideLoopEnd();
                }
            }
        });
        this.Aa.start();
    }

    public final void destroy() {
        this.started = false;
        AnimatorSet animatorSet = this.Aa;
        if (animatorSet != null) {
            animatorSet.removeAllListeners();
            this.Aa.cancel();
            this.Aa = null;
        }
    }

    public final boolean isStarted() {
        return this.started;
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void init(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super.init(context, attributeSet);
        FrameLayout.inflate(getContext(), R.layout.obfuscated_res_0x7f0d04d8, this);
        this.fi = (ImageView) findViewById(R.id.obfuscated_res_0x7f091375);
        this.zZ = findViewById(R.id.obfuscated_res_0x7f091376);
        this.Ab = getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f0704c1);
        this.Ac = getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f0704bd);
        this.Ad = getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f0704bc);
    }
}
