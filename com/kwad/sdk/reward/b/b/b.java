package com.kwad.sdk.reward.b.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.kwad.sdk.R;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.reward.b.b.b.e;
import com.kwad.sdk.reward.d;
/* loaded from: classes6.dex */
public class b extends d {
    public b(boolean z) {
        Presenter bVar;
        if (z) {
            bVar = new e();
        } else {
            a((Presenter) new com.kwad.sdk.reward.b.b.b.a());
            bVar = new com.kwad.sdk.reward.b.b.b.b();
        }
        a(bVar);
        a((Presenter) new com.kwad.sdk.reward.b.b.b.d());
        a((Presenter) new com.kwad.sdk.reward.b.b.b.c());
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        final View a2 = a(R.id.ksad_play_detail_top_toolbar);
        ((d) this).f33839a.o.add(new com.kwad.sdk.reward.a.e() { // from class: com.kwad.sdk.reward.b.b.b.1
            @Override // com.kwad.sdk.reward.a.e
            public void a() {
                a2.setVisibility(0);
                a2.setAlpha(1.0f);
                a2.animate().alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.reward.b.b.b.1.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        a2.setVisibility(8);
                    }
                }).setDuration(300L).start();
            }

            @Override // com.kwad.sdk.reward.a.e
            public void b() {
                a2.setVisibility(0);
                a2.setAlpha(0.0f);
                a2.animate().alpha(1.0f).setListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.reward.b.b.b.1.2
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        a2.setVisibility(0);
                    }
                }).setDuration(300L).start();
            }
        });
    }
}
