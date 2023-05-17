package com.kwad.sdk.kwai.kwai;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.report.f;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.az;
/* loaded from: classes9.dex */
public final class d implements View.OnClickListener {
    public int RA;
    public int RB;
    public boolean RC;
    public final boolean Ru;
    public final boolean Rv;
    public View Rw;
    public ImageView Rx;
    public TextView Ry;
    public Button Rz;
    public final AdInfo mAdInfo;
    @NonNull
    public final AdTemplate mAdTemplate;
    @NonNull
    public final Context mContext;
    @NonNull
    public View mRootView = rj();

    public d(@NonNull Context context, @NonNull AdTemplate adTemplate, boolean z, boolean z2, boolean z3) {
        this.mContext = context;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
        this.Ru = z;
        this.Rv = z2;
        this.RC = z3;
        kp();
    }

    private void b(FrameLayout frameLayout) {
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070499);
        int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07049a);
        this.RA = dimensionPixelSize + dimensionPixelSize2;
        ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : new FrameLayout.LayoutParams(-1, dimensionPixelSize);
        layoutParams2.gravity = 48;
        layoutParams2.leftMargin = dimensionPixelSize2;
        layoutParams2.rightMargin = dimensionPixelSize2;
        layoutParams2.topMargin = dimensionPixelSize2;
        this.mRootView.setTranslationY(-this.RA);
        frameLayout.addView(this.mRootView, layoutParams2);
        show();
    }

    private void c(FrameLayout frameLayout) {
        int screenWidth = az.getScreenWidth(this.mContext);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070497);
        int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070496);
        int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070495);
        this.RB = screenWidth - dimensionPixelSize;
        ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : new FrameLayout.LayoutParams(-1, dimensionPixelOffset);
        layoutParams2.gravity = 80;
        layoutParams2.leftMargin = dimensionPixelSize;
        layoutParams2.rightMargin = 0;
        layoutParams2.bottomMargin = dimensionPixelSize2;
        this.mRootView.setTranslationX(this.RB);
        frameLayout.addView(this.mRootView, layoutParams2);
        show();
    }

    private void kp() {
        this.Rz.setText(this.Ru ? "安装" : "打开");
        this.Rw.setOnClickListener(this);
        this.Rz.setOnClickListener(this);
        KSImageLoader.loadAppIcon(this.Rx, com.kwad.sdk.core.response.a.a.bn(com.kwad.sdk.core.response.a.d.bQ(this.mAdTemplate)), this.mAdTemplate, 8);
        String ae = com.kwad.sdk.core.response.a.a.ae(com.kwad.sdk.core.response.a.d.bQ(this.mAdTemplate));
        if (ae.length() >= 8) {
            ae = ae.substring(0, 7) + StringHelper.STRING_MORE;
        }
        this.Ry.setText(this.mContext.getString(this.Ru ? R.string.obfuscated_res_0x7f0f0afc : R.string.obfuscated_res_0x7f0f0afd, ae));
    }

    @SuppressLint({"InflateParams"})
    private View rj() {
        LayoutInflater from;
        int i;
        if (this.Ru && this.Rv) {
            from = LayoutInflater.from(this.mContext);
            i = R.layout.obfuscated_res_0x7f0d048b;
        } else {
            from = LayoutInflater.from(this.mContext);
            i = R.layout.obfuscated_res_0x7f0d048a;
        }
        this.mRootView = from.inflate(i, (ViewGroup) null);
        ViewCompat.setElevation(this.mRootView, this.mContext.getResources().getDimension(R.dimen.obfuscated_res_0x7f070498));
        this.Rw = this.mRootView.findViewById(R.id.obfuscated_res_0x7f091279);
        this.Rx = (ImageView) this.mRootView.findViewById(R.id.obfuscated_res_0x7f09127b);
        this.Ry = (TextView) this.mRootView.findViewById(R.id.obfuscated_res_0x7f09127a);
        this.Rz = (Button) this.mRootView.findViewById(R.id.obfuscated_res_0x7f09127c);
        return this.mRootView;
    }

    private void show() {
        ObjectAnimator ofFloat = (this.Ru && this.Rv) ? ObjectAnimator.ofFloat(this.mRootView, View.TRANSLATION_X, this.RB, 0.0f) : ObjectAnimator.ofFloat(this.mRootView, View.TRANSLATION_Y, -this.RA, 0.0f);
        ofFloat.setInterpolator(PathInterpolatorCompat.create(0.25f, 0.1f, 0.27f, 0.87f));
        ofFloat.setDuration(300L);
        ofFloat.start();
    }

    private Animator w(View view2) {
        ObjectAnimator ofFloat = (this.Ru && this.Rv) ? ObjectAnimator.ofFloat(view2, View.TRANSLATION_X, 0.0f, this.RB) : ObjectAnimator.ofFloat(view2, View.TRANSLATION_Y, 0.0f, -this.RA);
        ofFloat.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.42f, 0.85f, 0.64f));
        ofFloat.setDuration(260L);
        return ofFloat;
    }

    public final void a(FrameLayout frameLayout) {
        if (this.mRootView.getParent() != null) {
            return;
        }
        if (this.Ru && this.Rv) {
            c(frameLayout);
        } else {
            b(frameLayout);
        }
        this.mRootView.postDelayed(new Runnable() { // from class: com.kwad.sdk.kwai.kwai.d.1
            @Override // java.lang.Runnable
            public final void run() {
                d.this.dismiss();
            }
        }, 10000L);
    }

    public final void dismiss() {
        if (this.mRootView.getParent() == null) {
            return;
        }
        final ViewGroup viewGroup = (ViewGroup) this.mRootView.getParent();
        Animator w = w(this.mRootView);
        w.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.kwai.kwai.d.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                viewGroup.removeView(d.this.mRootView);
            }
        });
        w.start();
        c.rd().ri();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        dismiss();
        if (view2.getId() != R.id.obfuscated_res_0x7f09127c) {
            if (view2.getId() == R.id.obfuscated_res_0x7f091279) {
                if (!this.Ru) {
                    com.kwad.sdk.core.report.a.p(this.mAdTemplate, 48);
                } else if (!this.RC) {
                    com.kwad.sdk.core.report.a.q(this.mAdTemplate, 46);
                } else {
                    f fVar = new f();
                    fVar.aK(69);
                    fVar.aP(23);
                    fVar.aT(1);
                    com.kwad.sdk.core.report.a.a(this.mAdTemplate, fVar);
                }
            }
        } else if (!this.Ru) {
            if (ai.W(this.mContext, com.kwad.sdk.core.response.a.a.ag(this.mAdInfo))) {
                com.kwad.sdk.core.report.a.at(this.mAdTemplate);
            }
            com.kwad.sdk.core.report.a.p(this.mAdTemplate, 47);
        } else {
            if (this.RC) {
                f fVar2 = new f();
                fVar2.aK(29);
                fVar2.aP(23);
                com.kwad.sdk.core.report.a.a(this.mAdTemplate, fVar2);
            } else {
                com.kwad.sdk.core.report.a.q(this.mAdTemplate, 45);
            }
            if (ai.X(((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getContext(), this.mAdInfo.downloadFilePath)) {
                com.kwad.sdk.core.report.a.h(this.mAdTemplate, 1);
            }
        }
    }
}
