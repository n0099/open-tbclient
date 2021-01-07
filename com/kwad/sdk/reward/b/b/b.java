package com.kwad.sdk.reward.b.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.kwad.sdk.R;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.reward.b.b.b.e;
import com.kwad.sdk.reward.d;
/* loaded from: classes5.dex */
public class b extends d {
    public b(boolean z) {
        if (z) {
            a((Presenter) new e());
        } else {
            a((Presenter) new com.kwad.sdk.reward.b.b.b.a());
            a((Presenter) new com.kwad.sdk.reward.b.b.b.b());
        }
        a((Presenter) new com.kwad.sdk.reward.b.b.b.d());
        a((Presenter) new com.kwad.sdk.reward.b.b.b.c());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        final View b2 = b(R.id.ksad_play_detail_top_toolbar);
        this.f10950a.o.add(new com.kwad.sdk.reward.a.d() { // from class: com.kwad.sdk.reward.b.b.b.1
            @Override // com.kwad.sdk.reward.a.d
            public void a() {
                b2.setVisibility(0);
                b2.setAlpha(1.0f);
                b2.animate().alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.reward.b.b.b.1.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        b2.setVisibility(8);
                    }
                }).setDuration(300L).start();
            }

            @Override // com.kwad.sdk.reward.a.d
            public void b() {
                b2.setVisibility(0);
                b2.setAlpha(0.0f);
                b2.animate().alpha(1.0f).setListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.reward.b.b.b.1.2
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        b2.setVisibility(0);
                    }
                }).setDuration(300L).start();
            }
        });
    }
}
