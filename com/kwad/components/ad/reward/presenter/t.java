package com.kwad.components.ad.reward.presenter;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.os.Vibrator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.constraintlayout.motion.widget.Key;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.utils.bn;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class t extends b implements View.OnClickListener, com.kwad.components.ad.reward.e.o, com.kwad.sdk.core.g.b {
    public com.kwad.sdk.core.g.d eg;
    public Vibrator eh;
    public TextView hA;
    public ImageView hB;
    public FrameLayout hC;
    public ImageView hD;
    public FrameLayout hE;
    public TextView hF;
    @Nullable
    public Animator hG;
    public ViewGroup hy;
    public TextView hz;
    public com.kwad.components.ad.reward.e.g mPlayEndPageListener = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.reward.presenter.t.1
        @Override // com.kwad.components.ad.reward.e.g
        public final void bL() {
            if (t.this.hy != null) {
                t.this.hy.setVisibility(8);
            }
            if (t.this.hE != null) {
                t.this.hE.setVisibility(8);
            }
            if (t.this.eg != null) {
                t.this.eg.bj(t.this.getContext());
            }
            if (t.this.hG != null) {
                t.this.hG.cancel();
                t.this.hG = null;
            }
        }
    };

    @Override // com.kwad.sdk.core.g.b
    public final void aV() {
    }

    @Override // com.kwad.components.ad.reward.e.o
    public final int cf() {
        return com.kwad.sdk.d.a.a.g(getContext(), R.dimen.obfuscated_res_0x7f07054e) + com.kwad.sdk.d.a.a.g(getContext(), R.dimen.obfuscated_res_0x7f070548);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public Animator a(float f, float f2) {
        if (this.hy == null) {
            return null;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        Resources resources = this.hy.getResources();
        Animator a = com.kwad.components.core.s.n.a((View) this.hB, (Interpolator) null, 100L, 16.0f);
        a.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.t.7
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                t.this.hB.setPivotX(t.this.hB.getWidth());
                t.this.hB.setPivotY(t.this.hB.getHeight());
            }
        });
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hy, Key.TRANSLATION_X, f - (this.hy.getLeft() + (this.hy.getWidth() / 2.0f)));
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.hy, Key.TRANSLATION_Y, f2 - (this.hy.getTop() + (this.hy.getHeight() / 2.0f)));
        float dimension = resources.getDimension(R.dimen.obfuscated_res_0x7f070548);
        final float dimension2 = resources.getDimension(R.dimen.obfuscated_res_0x7f07054c);
        float width = this.hC.getWidth();
        float width2 = this.hB.getWidth();
        if (width == 0.0f || width2 == 0.0f) {
            return null;
        }
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(width, dimension);
        ofFloat3.addUpdateListener(new com.kwad.components.ad.widget.a(this.hD) { // from class: com.kwad.components.ad.reward.presenter.t.8
            @Override // com.kwad.components.ad.widget.a
            public final void a(ViewGroup.LayoutParams layoutParams, Object obj) {
                float floatValue = ((Float) obj).floatValue();
                if (layoutParams != null) {
                    int i = (int) floatValue;
                    layoutParams.height = i;
                    layoutParams.width = i;
                }
            }
        });
        ValueAnimator ofFloat4 = ValueAnimator.ofFloat(width2, dimension2);
        ofFloat4.addUpdateListener(new com.kwad.components.ad.widget.a(this.hB) { // from class: com.kwad.components.ad.reward.presenter.t.9
            @Override // com.kwad.components.ad.widget.a
            public final void a(ViewGroup.LayoutParams layoutParams, Object obj) {
                float floatValue = ((Float) obj).floatValue();
                if (layoutParams != null) {
                    int i = (int) floatValue;
                    layoutParams.height = i;
                    layoutParams.width = i;
                }
            }
        });
        int color = resources.getColor(R.color.obfuscated_res_0x7f0607aa);
        final int color2 = resources.getColor(R.color.obfuscated_res_0x7f0607a6);
        final int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07054d);
        ValueAnimator ofArgb = com.kwad.sdk.widget.a.ofArgb(color, color2);
        ofArgb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.presenter.t.10
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                try {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    GradientDrawable gradientDrawable = (GradientDrawable) t.this.hD.getBackground();
                    gradientDrawable.mutate();
                    gradientDrawable.setColor(intValue);
                    if (intValue == color2) {
                        gradientDrawable.setStroke(dimensionPixelSize, -1);
                    }
                    t.this.hD.setBackground(gradientDrawable);
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTrace(th);
                }
            }
        });
        ValueAnimator ofFloat5 = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat5.setDuration(200L);
        ofFloat5.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.presenter.t.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                try {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    t.this.hz.setAlpha(floatValue);
                    t.this.hA.setAlpha(floatValue);
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTrace(th);
                }
            }
        });
        ValueAnimator ofFloat6 = ValueAnimator.ofFloat(this.hz.getHeight(), 0.0f);
        ofFloat6.addUpdateListener(new com.kwad.components.ad.widget.a(this.hz) { // from class: com.kwad.components.ad.reward.presenter.t.12
            @Override // com.kwad.components.ad.widget.a
            public final void a(ViewGroup.LayoutParams layoutParams, Object obj) {
                layoutParams.height = (int) ((Float) obj).floatValue();
            }
        });
        ValueAnimator ofFloat7 = ValueAnimator.ofFloat(this.hA.getHeight(), 0.0f);
        ofFloat7.addUpdateListener(new com.kwad.components.ad.widget.a(this.hA) { // from class: com.kwad.components.ad.reward.presenter.t.13
            @Override // com.kwad.components.ad.widget.a
            public final void a(ViewGroup.LayoutParams layoutParams, Object obj) {
                layoutParams.height = (int) ((Float) obj).floatValue();
            }
        });
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.setDuration(500L);
        animatorSet2.playTogether(ofFloat, ofFloat2, ofFloat3, ofFloat4, ofArgb, ofFloat6, ofFloat7);
        AnimatorSet animatorSet3 = new AnimatorSet();
        final Animator clone = a.clone();
        clone.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.t.2
            public boolean hI = false;

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                this.hI = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (!this.hI) {
                    clone.start();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                t.this.hB.setPivotX(dimension2);
                t.this.hB.setPivotY(dimension2);
            }
        });
        final ViewGroup.LayoutParams layoutParams = this.hE.getLayoutParams();
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, resources.getDimension(R.dimen.obfuscated_res_0x7f07054f)).setDuration(500L);
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.presenter.t.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                try {
                    t.this.hE.setVisibility(0);
                    layoutParams.width = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    t.this.hE.setLayoutParams(layoutParams);
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTrace(th);
                }
            }
        });
        animatorSet3.playTogether(clone, duration, ObjectAnimator.ofFloat(this.hF, Key.ALPHA, 0.0f, 1.0f).setDuration(500L));
        animatorSet.playSequentially(a, a.clone(), a.clone(), ofFloat5, animatorSet2, animatorSet3);
        return animatorSet;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        if (!com.kwad.sdk.core.response.b.b.dE(com.kwad.sdk.core.response.b.e.dP(this.qn.mAdTemplate))) {
            return;
        }
        this.qn.a(1, getContext(), Cea708Decoder.COMMAND_DF6, 1);
    }

    public static String a(com.kwad.components.ad.reward.g gVar, AdInfo adInfo) {
        String dK = com.kwad.sdk.core.response.b.b.dK(adInfo);
        com.kwad.components.core.e.d.c cVar = gVar.mApkDownloadHelper;
        if (com.kwad.sdk.core.response.b.a.aF(adInfo) && cVar != null) {
            int nM = cVar.nM();
            AdMatrixInfo.DownloadTexts dM = com.kwad.sdk.core.response.b.b.dM(adInfo);
            if (nM != 8) {
                if (nM != 12) {
                    return dM.adActionDescription;
                }
                return dM.openAppLabel;
            }
            return dM.installAppLabel;
        }
        return dK;
    }

    private void a(AdInfo adInfo) {
        String dI = com.kwad.sdk.core.response.b.b.dI(adInfo);
        TextView textView = this.hz;
        if (textView != null) {
            textView.setText(dI);
        }
        TextView textView2 = this.hF;
        if (textView2 != null) {
            textView2.setText(dI);
        }
        String a = a(this.qn, adInfo);
        TextView textView3 = this.hA;
        if (textView3 != null) {
            textView3.setText("或点击" + a);
        }
    }

    private void cg() {
        final int dimensionPixelSize;
        int dimensionPixelSize2;
        final AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) findViewById(R.id.obfuscated_res_0x7f091490);
        ViewGroup viewGroup = (ViewGroup) com.kwad.sdk.m.l.a(getContext(), R.layout.obfuscated_res_0x7f0d0511, adBaseFrameLayout, false);
        this.hy = viewGroup;
        viewGroup.setVisibility(0);
        Resources resources = this.hy.getResources();
        final int dimensionPixelSize3 = resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07054a);
        if (this.qn.mScreenOrientation == 1) {
            dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070549) + com.kwad.sdk.d.a.a.a(getContext(), 50.0f);
        } else {
            dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070549);
        }
        if (this.qn.mScreenOrientation == 1) {
            dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07054e) + com.kwad.sdk.d.a.a.a(getContext(), 50.0f);
        } else {
            dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07054e);
        }
        int dimensionPixelSize4 = resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070548);
        FrameLayout frameLayout = (FrameLayout) com.kwad.sdk.m.l.a(getContext(), R.layout.obfuscated_res_0x7f0d0512, adBaseFrameLayout, false);
        this.hE = frameLayout;
        this.hF = (TextView) frameLayout.findViewById(R.id.obfuscated_res_0x7f0914a6);
        this.hE.setVisibility(4);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, dimensionPixelSize4);
        layoutParams.leftMargin = dimensionPixelSize3;
        layoutParams.bottomMargin = dimensionPixelSize2;
        layoutParams.gravity = 83;
        adBaseFrameLayout.addView(this.hE, layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        adBaseFrameLayout.addView(this.hy, layoutParams2);
        com.kwad.sdk.core.report.a.b(this.qn.mAdTemplate, (int) Constants.METHOD_IM_SEND_MCAST_MSG, (JSONObject) null);
        this.hy.post(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.t.6
            @Override // java.lang.Runnable
            public final void run() {
                int height = adBaseFrameLayout.getHeight();
                t tVar = t.this;
                tVar.hG = tVar.a(dimensionPixelSize3, height - dimensionPixelSize);
                if (t.this.hG != null) {
                    t.this.hG.start();
                }
            }
        });
    }

    private void initView() {
        this.hz = (TextView) this.hy.findViewById(R.id.obfuscated_res_0x7f0914a2);
        this.hA = (TextView) this.hy.findViewById(R.id.obfuscated_res_0x7f0914a1);
        this.hB = (ImageView) this.hy.findViewById(R.id.obfuscated_res_0x7f09149f);
        this.hC = (FrameLayout) this.hy.findViewById(R.id.obfuscated_res_0x7f09149d);
        this.hD = (ImageView) this.hy.findViewById(R.id.obfuscated_res_0x7f09149e);
        this.hz.setOnClickListener(this);
        this.hA.setOnClickListener(this);
        this.hC.setOnClickListener(this);
        this.hF.setOnClickListener(this);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        AdInfo dP = com.kwad.sdk.core.response.b.e.dP(this.qn.mAdTemplate);
        this.qn.a(this);
        this.qn.b(this.mPlayEndPageListener);
        cg();
        initView();
        a(dP);
        float dG = com.kwad.sdk.core.response.b.b.dG(dP);
        com.kwad.sdk.core.g.d dVar = this.eg;
        if (dVar == null) {
            com.kwad.sdk.core.g.d dVar2 = new com.kwad.sdk.core.g.d(dG);
            this.eg = dVar2;
            dVar2.a(this);
        } else {
            dVar.e(dG);
        }
        this.eg.bi(getContext());
        Context context = getContext();
        if (context != null) {
            this.eh = (Vibrator) context.getSystemService("vibrator");
        }
    }

    @Override // com.kwad.sdk.core.g.b
    public final void a(double d) {
        boolean z;
        com.kwad.sdk.core.c.b.Ct();
        Activity currentActivity = com.kwad.sdk.core.c.b.getCurrentActivity();
        Activity activity = getActivity();
        if (activity != null && activity.equals(currentActivity)) {
            z = true;
        } else {
            z = false;
        }
        if (!com.kwad.components.core.e.c.b.nj() && z) {
            com.kwad.components.ad.reward.g gVar = this.qn;
            if (gVar != null && !gVar.fK()) {
                com.kwad.sdk.core.report.j jVar = new com.kwad.sdk.core.report.j();
                jVar.l(d);
                this.qn.a(1, getContext(), Cea708Decoder.COMMAND_DF5, 1, 0L, false, jVar);
            }
            bn.a(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.t.5
                @Override // java.lang.Runnable
                public final void run() {
                    com.kwad.sdk.core.e.c.d("RewardShakePresenter", "onShakeEvent openGate2");
                    t.this.eg.El();
                }
            }, null, 500L);
            com.kwad.sdk.core.response.b.e.dP(this.qn.mAdTemplate);
            if (!this.qn.fK()) {
                bn.a(getContext(), this.eh);
                return;
            }
            return;
        }
        bn.a(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.t.4
            @Override // java.lang.Runnable
            public final void run() {
                t.this.eg.El();
            }
        }, null, 500L);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        ViewGroup viewGroup = this.hy;
        if (viewGroup != null) {
            if (viewGroup.getParent() != null) {
                ((ViewGroup) this.hy.getParent()).removeView(this.hy);
            }
            this.hy = null;
        }
        bn.b(getContext(), this.eh);
        this.eh = null;
        Animator animator = this.hG;
        if (animator != null) {
            animator.cancel();
            this.hG = null;
        }
        this.qn.c(this.mPlayEndPageListener);
    }
}
