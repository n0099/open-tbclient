package com.kwad.components.ad.fullscreen.b.kwai;

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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.constraintlayout.motion.widget.Key;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import com.kwad.components.ad.reward.k;
import com.kwad.components.core.m.n;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.utils.bd;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class f extends com.kwad.components.ad.reward.presenter.a implements View.OnClickListener, com.kwad.sdk.core.g.b {
    public com.kwad.sdk.core.g.d eN;
    public Vibrator eO;
    public ViewGroup eP;
    public TextView eQ;
    public TextView eR;
    public ImageView eS;
    public FrameLayout eT;
    public ImageView eU;
    public FrameLayout eV;
    public TextView eW;
    @Nullable
    public Animator eY;
    public AdInfo mAdInfo;
    public boolean eX = false;
    public com.kwad.components.ad.reward.d.e mPlayEndPageListener = new com.kwad.components.ad.reward.d.e() { // from class: com.kwad.components.ad.fullscreen.b.kwai.f.1
        @Override // com.kwad.components.ad.reward.d.e
        public final void bA() {
            f.a(f.this, true);
            if (f.this.eP != null) {
                f.this.eP.setVisibility(8);
            }
            if (f.this.eV != null) {
                f.this.eV.setVisibility(8);
            }
            if (f.this.eN != null) {
                f.this.eN.bA(f.this.getContext());
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public Animator a(float f, float f2) {
        if (this.eP == null) {
            return null;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        Resources resources = this.eP.getResources();
        Animator a = n.a(this.eS, null, 100L, 16.0f);
        a.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.fullscreen.b.kwai.f.7
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                f.this.eS.setPivotX(f.this.eS.getWidth());
                f.this.eS.setPivotY(f.this.eS.getHeight());
            }
        });
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.eP, Key.TRANSLATION_X, f - (this.eP.getLeft() + (this.eP.getWidth() / 2.0f)));
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.eP, Key.TRANSLATION_Y, f2 - (this.eP.getTop() + (this.eP.getHeight() / 2.0f)));
        float dimension = resources.getDimension(R.dimen.obfuscated_res_0x7f07048d);
        final float dimension2 = resources.getDimension(R.dimen.obfuscated_res_0x7f070491);
        float width = this.eT.getWidth();
        float width2 = this.eS.getWidth();
        if (width == 0.0f || width2 == 0.0f) {
            return null;
        }
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(width, dimension);
        ofFloat3.addUpdateListener(new com.kwad.components.ad.widget.a(this.eU) { // from class: com.kwad.components.ad.fullscreen.b.kwai.f.8
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
        ofFloat4.addUpdateListener(new com.kwad.components.ad.widget.a(this.eS) { // from class: com.kwad.components.ad.fullscreen.b.kwai.f.9
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
        int color = resources.getColor(R.color.obfuscated_res_0x7f060791);
        final int color2 = resources.getColor(R.color.obfuscated_res_0x7f06078d);
        final int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070492);
        ValueAnimator ofArgb = com.kwad.sdk.widget.a.ofArgb(color, color2);
        ofArgb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.fullscreen.b.kwai.f.10
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                GradientDrawable gradientDrawable = (GradientDrawable) f.this.eU.getBackground();
                gradientDrawable.mutate();
                gradientDrawable.setColor(intValue);
                if (intValue == color2) {
                    gradientDrawable.setStroke(dimensionPixelSize, -1);
                }
                f.this.eU.setBackground(gradientDrawable);
            }
        });
        ValueAnimator ofFloat5 = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat5.setDuration(200L);
        ofFloat5.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.fullscreen.b.kwai.f.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                f.this.eQ.setAlpha(floatValue);
                f.this.eR.setAlpha(floatValue);
            }
        });
        ValueAnimator ofFloat6 = ValueAnimator.ofFloat(this.eQ.getHeight(), 0.0f);
        ofFloat6.addUpdateListener(new com.kwad.components.ad.widget.a(this.eQ) { // from class: com.kwad.components.ad.fullscreen.b.kwai.f.12
            @Override // com.kwad.components.ad.widget.a
            public final void a(ViewGroup.LayoutParams layoutParams, Object obj) {
                layoutParams.height = (int) ((Float) obj).floatValue();
            }
        });
        ValueAnimator ofFloat7 = ValueAnimator.ofFloat(this.eR.getHeight(), 0.0f);
        ofFloat7.addUpdateListener(new com.kwad.components.ad.widget.a(this.eR) { // from class: com.kwad.components.ad.fullscreen.b.kwai.f.13
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
        clone.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.fullscreen.b.kwai.f.2
            public boolean fa = false;

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                this.fa = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (this.fa) {
                    return;
                }
                clone.start();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                f.this.eS.setPivotX(dimension2);
                f.this.eS.setPivotY(dimension2);
            }
        });
        final ViewGroup.LayoutParams layoutParams = this.eV.getLayoutParams();
        final ValueAnimator duration = ValueAnimator.ofFloat(0.0f, resources.getDimension(R.dimen.obfuscated_res_0x7f070494)).setDuration(500L);
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.fullscreen.b.kwai.f.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                try {
                    if (f.this.eV == null) {
                        duration.cancel();
                    } else if (f.this.eX) {
                        f.this.eV.setVisibility(8);
                        duration.cancel();
                    } else {
                        f.this.eV.setVisibility(0);
                        layoutParams.width = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        f.this.eV.setLayoutParams(layoutParams);
                    }
                } catch (Exception e) {
                    com.kwad.sdk.core.e.b.printStackTraceOnly(e);
                    com.kwad.components.core.b.a.b(e);
                }
            }
        });
        animatorSet3.playTogether(clone, duration, ObjectAnimator.ofFloat(this.eW, Key.ALPHA, 0.0f, 1.0f).setDuration(500L));
        animatorSet.playSequentially(a, a.clone(), a.clone(), ofFloat5, animatorSet2, animatorSet3);
        return animatorSet;
    }

    public static String a(k kVar, AdInfo adInfo) {
        String cj = com.kwad.sdk.core.response.a.b.cj(adInfo);
        com.kwad.components.core.c.a.c cVar = kVar.mApkDownloadHelper;
        if (!com.kwad.sdk.core.response.a.a.am(adInfo) || cVar == null) {
            return cj;
        }
        int mI = cVar.mI();
        AdMatrixInfo.DownloadTexts ck = com.kwad.sdk.core.response.a.b.ck(adInfo);
        return mI != 8 ? mI != 12 ? ck.adActionDescription : ck.openAppLabel : ck.installAppLabel;
    }

    private void a(AdInfo adInfo) {
        String ci = com.kwad.sdk.core.response.a.b.ci(adInfo);
        TextView textView = this.eQ;
        if (textView != null) {
            textView.setText(ci);
        }
        TextView textView2 = this.eW;
        if (textView2 != null) {
            textView2.setText(ci);
        }
        String a = a(this.nM, adInfo);
        TextView textView3 = this.eR;
        if (textView3 != null) {
            textView3.setText("或点击" + a);
        }
    }

    public static /* synthetic */ boolean a(f fVar, boolean z) {
        fVar.eX = true;
        return true;
    }

    private void bW() {
        final AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) findViewById(R.id.obfuscated_res_0x7f09138a);
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d04c2, (ViewGroup) adBaseFrameLayout, false);
        this.eP = viewGroup;
        viewGroup.setVisibility(0);
        Resources resources = this.eP.getResources();
        final int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07048f);
        final int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07048e);
        int dimensionPixelSize3 = resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070493);
        int dimensionPixelSize4 = resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07048d);
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d04c3, (ViewGroup) adBaseFrameLayout, false);
        this.eV = frameLayout;
        this.eW = (TextView) frameLayout.findViewById(R.id.obfuscated_res_0x7f09139a);
        this.eV.setVisibility(4);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, dimensionPixelSize4);
        layoutParams.leftMargin = dimensionPixelSize;
        layoutParams.bottomMargin = dimensionPixelSize3;
        layoutParams.gravity = 83;
        adBaseFrameLayout.addView(this.eV, layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        adBaseFrameLayout.addView(this.eP, layoutParams2);
        com.kwad.sdk.core.report.a.c(this.nM.mAdTemplate, (int) Constants.METHOD_IM_SEND_MCAST_MSG, (JSONObject) null);
        this.eP.post(new Runnable() { // from class: com.kwad.components.ad.fullscreen.b.kwai.f.6
            @Override // java.lang.Runnable
            public final void run() {
                int height = adBaseFrameLayout.getHeight();
                f fVar = f.this;
                fVar.eY = fVar.a(dimensionPixelSize, height - dimensionPixelSize2);
                if (f.this.eY != null) {
                    f.this.eY.start();
                }
            }
        });
    }

    private void initView() {
        this.eQ = (TextView) this.eP.findViewById(R.id.obfuscated_res_0x7f091397);
        this.eR = (TextView) this.eP.findViewById(R.id.obfuscated_res_0x7f091396);
        this.eS = (ImageView) this.eP.findViewById(R.id.obfuscated_res_0x7f091394);
        this.eT = (FrameLayout) this.eP.findViewById(R.id.obfuscated_res_0x7f091392);
        this.eU = (ImageView) this.eP.findViewById(R.id.obfuscated_res_0x7f091393);
        this.eQ.setOnClickListener(this);
        this.eR.setOnClickListener(this);
        this.eT.setOnClickListener(this);
        this.eW.setOnClickListener(this);
    }

    @Override // com.kwad.sdk.core.g.b
    public final void a(double d) {
        com.kwad.sdk.core.c.b.tp();
        Activity currentActivity = com.kwad.sdk.core.c.b.getCurrentActivity();
        Activity activity = getActivity();
        boolean z = activity != null && activity.equals(currentActivity);
        if (com.kwad.components.core.c.kwai.b.mq() || !z) {
            bd.a(new Runnable() { // from class: com.kwad.components.ad.fullscreen.b.kwai.f.4
                @Override // java.lang.Runnable
                public final void run() {
                    f.this.eN.vb();
                }
            }, null, 500L);
            return;
        }
        if (this.nM != null) {
            com.kwad.sdk.core.report.f fVar = new com.kwad.sdk.core.report.f();
            fVar.e(d);
            this.nM.a(getContext(), Cea708Decoder.COMMAND_DF5, 1, 0L, false, fVar);
        }
        bd.a(new Runnable() { // from class: com.kwad.components.ad.fullscreen.b.kwai.f.5
            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.sdk.core.e.b.d("ShakePresenter", "onShakeEvent openGate2");
                f.this.eN.vb();
            }
        }, null, 500L);
        bd.a(getContext(), this.eO);
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        super.aq();
        this.mAdInfo = com.kwad.sdk.core.response.a.d.bQ(this.nM.mAdTemplate);
        if (com.kwad.components.ad.fullscreen.a.a.a(getContext(), this.nM.mAdTemplate)) {
            this.nM.a(this.mPlayEndPageListener);
            bW();
            initView();
            a(this.mAdInfo);
            float ch = com.kwad.sdk.core.response.a.b.ch(this.mAdInfo);
            com.kwad.sdk.core.g.d dVar = this.eN;
            if (dVar == null) {
                com.kwad.sdk.core.g.d dVar2 = new com.kwad.sdk.core.g.d(ch);
                this.eN = dVar2;
                dVar2.a(this);
            } else {
                dVar.d(ch);
            }
            this.eN.bz(getContext());
            Context context = getContext();
            if (context != null) {
                this.eO = (Vibrator) context.getSystemService("vibrator");
            }
            com.kwad.components.ad.fullscreen.a.a.G(getContext());
        }
    }

    @Override // com.kwad.sdk.core.g.b
    public final void bX() {
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        this.nM.a(getContext(), Cea708Decoder.COMMAND_DF6, 1);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.eX = false;
        ViewGroup viewGroup = this.eP;
        if (viewGroup != null) {
            if (viewGroup.getParent() != null) {
                ((ViewGroup) this.eP.getParent()).removeView(this.eP);
            }
            this.eP = null;
        }
        bd.b(getContext(), this.eO);
        this.eO = null;
        Animator animator = this.eY;
        if (animator != null) {
            animator.cancel();
            this.eY = null;
        }
        this.nM.b(this.mPlayEndPageListener);
    }
}
