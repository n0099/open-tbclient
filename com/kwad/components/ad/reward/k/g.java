package com.kwad.components.ad.reward.k;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.TextView;
import androidx.appcompat.widget.TooltipCompatHandler;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.baidu.tieba.R;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes9.dex */
public final class g extends v implements View.OnClickListener {
    public TextView eQ;
    public com.kwad.components.ad.reward.k nM;

    /* loaded from: classes9.dex */
    public interface a {
        void gX();
    }

    public g(com.kwad.components.ad.reward.k kVar) {
        this.nM = kVar;
    }

    public static Animator n(View view2) {
        if (view2 == null) {
            return null;
        }
        int dimensionPixelSize = view2.getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0704c1);
        Interpolator create = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator duration = ObjectAnimator.ofFloat(view2, Key.TRANSLATION_Y, -dimensionPixelSize).setDuration(500L);
        duration.setInterpolator(create);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(view2, Key.ALPHA, 1.0f, 1.0f).setDuration(TooltipCompatHandler.LONG_CLICK_HIDE_TIMEOUT_MS);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(view2, Key.TRANSLATION_Y, 0.0f).setDuration(500L);
        duration3.setInterpolator(create);
        animatorSet.playSequentially(duration, duration2, duration3);
        return animatorSet;
    }

    public final void a(final a aVar, long j) {
        final Animator n = n(this.pV);
        if (n == null) {
            aVar.gX();
            return;
        }
        n.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.k.g.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.gX();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.gX();
                }
            }
        });
        this.pV.postDelayed(new Runnable() { // from class: com.kwad.components.ad.reward.k.g.2
            @Override // java.lang.Runnable
            public final void run() {
                n.start();
            }
        }, 500L);
    }

    @Override // com.kwad.components.ad.reward.k.d
    public final void a(u uVar) {
        String str;
        TextView textView;
        super.a(uVar);
        AdTemplate adTemplate = uVar.getAdTemplate();
        if (adTemplate == null || (str = com.kwad.sdk.core.response.a.b.bA(adTemplate).title) == null || (textView = this.eQ) == null) {
            return;
        }
        textView.setText(str);
    }

    public final void e(ViewGroup viewGroup) {
        super.a(viewGroup, R.id.obfuscated_res_0x7f091267, R.id.obfuscated_res_0x7f091265);
        if (this.eQ == null) {
            this.eQ = (TextView) this.pV.findViewById(R.id.obfuscated_res_0x7f091266);
        }
        this.pV.setOnClickListener(this);
    }

    @Override // com.kwad.components.ad.reward.k.v, com.kwad.components.ad.reward.k.d
    public final ViewGroup fR() {
        return this.pV;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        if (view2.equals(this.pV)) {
            com.kwad.components.ad.reward.k kVar = this.nM;
            kVar.a(kVar.mContext, 1, 1);
        }
    }
}
