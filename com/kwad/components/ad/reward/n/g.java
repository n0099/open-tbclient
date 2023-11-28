package com.kwad.components.ad.reward.n;

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
/* loaded from: classes10.dex */
public final class g extends s implements View.OnClickListener {
    public TextView hz;
    public com.kwad.components.ad.reward.g qn;

    /* loaded from: classes10.dex */
    public interface a {
        void ht();
    }

    public g(com.kwad.components.ad.reward.g gVar) {
        this.qn = gVar;
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final void a(r rVar) {
        String str;
        TextView textView;
        super.a(rVar);
        AdTemplate adTemplate = rVar.getAdTemplate();
        if (adTemplate != null && (str = com.kwad.sdk.core.response.b.b.da(adTemplate).title) != null && (textView = this.hz) != null) {
            textView.setText(str);
        }
    }

    public final void f(ViewGroup viewGroup) {
        super.a(viewGroup, R.id.obfuscated_res_0x7f091329, R.id.obfuscated_res_0x7f091327);
        if (this.hz == null) {
            this.hz = (TextView) this.sy.findViewById(R.id.obfuscated_res_0x7f091328);
        }
        this.sy.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        if (view2.equals(this.sy)) {
            com.kwad.components.ad.reward.g gVar = this.qn;
            gVar.a(1, gVar.mContext, 1, 1);
        }
    }

    public static Animator q(View view2) {
        if (view2 == null) {
            return null;
        }
        int dimensionPixelSize = view2.getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0704d5);
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
        final Animator q = q(this.sy);
        if (q == null) {
            aVar.ht();
            return;
        }
        q.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.n.g.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.ht();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.ht();
                }
            }
        });
        this.sy.postDelayed(new Runnable() { // from class: com.kwad.components.ad.reward.n.g.2
            @Override // java.lang.Runnable
            public final void run() {
                q.start();
            }
        }, 500L);
    }

    @Override // com.kwad.components.ad.reward.n.s, com.kwad.components.ad.reward.n.d
    public final ViewGroup gD() {
        return this.sy;
    }
}
