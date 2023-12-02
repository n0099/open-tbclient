package com.kwad.components.ad.reward.presenter.platdetail;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.baidu.tieba.R;
import com.kwad.components.core.video.l;
import com.kwad.sdk.utils.bd;
/* loaded from: classes10.dex */
public final class b extends com.kwad.components.ad.reward.presenter.b {
    public View ub;
    public View uc;
    public View ud;
    public View ue;
    public Animator uh;
    public Animator ui;
    public Animator uj;
    public bd um;
    public bd un;
    public final long tY = 1600;
    public final long tZ = 3000;
    public final long ua = 5000;
    public boolean uf = false;
    public boolean ug = false;
    public Animator uk = null;
    public long ul = 3000;
    public Interpolator uo = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
    public l gO = new l() { // from class: com.kwad.components.ad.reward.presenter.platdetail.b.1
        public boolean up = false;

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayPaused() {
            super.onMediaPlayPaused();
            b.this.uf = true;
            com.kwad.sdk.core.e.c.d("RewardImagePlayerPresenter", "onMediaPlayPaused : ");
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            b.this.uf = false;
            com.kwad.sdk.core.e.c.d("RewardImagePlayerPresenter", "onMediaPlayStart : ");
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j, long j2) {
            super.onMediaPlayProgress(j, j2);
            if (j2 >= b.this.ul && !this.up) {
                this.up = true;
                b.this.hR();
            }
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlaying() {
            super.onMediaPlaying();
            b.this.uf = false;
            com.kwad.sdk.core.e.c.d("RewardImagePlayerPresenter", "onMediaPlaying : ");
            if (b.this.uk != null && !b.this.uk.isRunning()) {
                b.this.uk.start();
                b.a(b.this, (Animator) null);
            }
        }
    };

    private View hQ() {
        ImageView imageView = new ImageView(getContext());
        imageView.setClickable(false);
        imageView.setFocusable(false);
        imageView.setFocusableInTouchMode(false);
        imageView.setLongClickable(false);
        imageView.setBackgroundColor(Color.parseColor("#222222"));
        imageView.setAlpha(0.2f);
        return imageView;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        hP();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        this.ub = null;
        com.kwad.components.ad.reward.m.b jM = this.qn.oI.jM();
        if (jM != null) {
            jM.release();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.uf = true;
        Animator animator = this.ui;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.uh;
        if (animator2 != null) {
            animator2.cancel();
        }
        Animator animator3 = this.uj;
        if (animator3 != null) {
            animator3.cancel();
        }
        this.qn.oI.b(this.gO);
    }

    public static void p(View view2) {
        if (view2 != null) {
            try {
                if (view2.getParent() != null) {
                    ((ViewGroup) view2.getParent()).removeView(view2);
                }
            } catch (Throwable th) {
                com.kwad.sdk.core.e.c.printStackTraceOnly(th);
            }
        }
    }

    private Animator a(View view2, long j) {
        float[] fArr = {1.0f, 1.106f, 1.0f, 1.106f, 1.0f};
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, Key.SCALE_X, fArr);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view2, Key.SCALE_Y, fArr);
        AnimatorSet animatorSet = new AnimatorSet();
        View view3 = this.uc;
        if (view3 != null) {
            animatorSet.playTogether(ofFloat, ofFloat2, ObjectAnimator.ofFloat(view3, Key.ALPHA, 0.2f, 0.0f));
        } else {
            animatorSet.playTogether(ofFloat, ofFloat2);
        }
        animatorSet.setDuration(j);
        animatorSet.setInterpolator(this.uo);
        return animatorSet;
    }

    private Animator a(View view2, View view3) {
        Animator o = o(view2);
        Animator o2 = o(view3);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view3, Key.SCALE_X, 1.0f);
        ofFloat.setDuration(300L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(ofFloat, o2);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playTogether(o, animatorSet);
        return animatorSet2;
    }

    public static /* synthetic */ Animator a(b bVar, Animator animator) {
        bVar.uk = null;
        return null;
    }

    private Animator b(View view2, long j) {
        Animator a = a(view2, 1600L);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, Key.ALPHA, 1.0f);
        ofFloat.setDuration(5000L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(a, ofFloat);
        animatorSet.setDuration(1600L);
        return animatorSet;
    }

    public static /* synthetic */ View c(b bVar, View view2) {
        bVar.ud = null;
        return null;
    }

    public static /* synthetic */ View d(b bVar, View view2) {
        bVar.ue = null;
        return null;
    }

    private View a(@DrawableRes int i, ViewGroup viewGroup) {
        ImageView imageView = (ImageView) LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d04d9, viewGroup, false);
        imageView.setImageDrawable(getContext().getResources().getDrawable(i));
        return imageView;
    }

    public static /* synthetic */ View b(b bVar, View view2) {
        bVar.uc = null;
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull Animator animator) {
        if (!this.uf) {
            animator.start();
        } else {
            this.uk = animator;
        }
    }

    public static /* synthetic */ boolean b(b bVar, boolean z) {
        bVar.ug = true;
        return true;
    }

    private void hP() {
        this.um = new bd(getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0704c6), getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0704c4));
        this.un = new bd(getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0704c5), getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0704c3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hR() {
        this.uh = a(this.ub, 1600L);
        this.ui = a(this.ud, this.ue);
        this.uj = b(this.ub, 1600L);
        this.uh.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.b.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.p(b.this.uc);
                b.b(b.this, (View) null);
                if (!b.this.ug) {
                    b bVar = b.this;
                    bVar.a(bVar.ui);
                }
            }
        });
        this.ui.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.b.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b bVar = b.this;
                bVar.a(bVar.uj);
                b.p(b.this.ud);
                b.p(b.this.ue);
                b.c(b.this, null);
                b.d(b.this, null);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.b(b.this, true);
            }
        });
        this.uj.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.b.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b bVar = b.this;
                bVar.a(bVar.uj);
            }
        });
        a(this.uh);
    }

    private Animator o(View view2) {
        if (this.um == null || this.un == null) {
            hP();
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, Key.TRANSLATION_Y, -(com.kwad.sdk.d.a.a.getScreenHeight(getContext()) + ((this.un.getHeight() + this.um.getHeight()) / 2)));
        float Le = this.un.Le() / this.um.Le();
        float Lf = this.un.Lf() / this.um.Lf();
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view2, Key.SCALE_X, 1.0f, Le);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view2, Key.SCALE_Y, 1.0f, Lf);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(view2, Key.ALPHA, 1.0f, 0.8f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(3000L);
        animatorSet.playTogether(ofFloat2, ofFloat3, ofFloat, ofFloat4);
        animatorSet.setInterpolator(this.uo);
        return animatorSet;
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.qn.oI.a(this.gO);
        FrameLayout O = this.qn.oI.jM().O(getContext());
        this.ub = O;
        if (O.getParent() != null) {
            return;
        }
        ((FrameLayout) findViewById(R.id.obfuscated_res_0x7f091476)).addView(this.ub, -1, -1);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = -this.um.getHeight();
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f091490);
        View hQ = hQ();
        this.uc = hQ;
        frameLayout.addView(hQ, -1, -1);
        View a = a(R.drawable.obfuscated_res_0x7f080e86, frameLayout);
        this.ud = a;
        frameLayout.addView(a, layoutParams);
        View a2 = a(R.drawable.obfuscated_res_0x7f080e87, frameLayout);
        this.ue = a2;
        frameLayout.addView(a2, layoutParams);
    }
}
