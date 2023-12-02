package com.kwad.sdk.a.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.baidu.tieba.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.report.j;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.m.l;
import com.kwad.sdk.utils.ak;
import com.kwad.sdk.utils.bi;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class e implements View.OnClickListener {
    public final boolean alg;
    public final boolean alh;
    public View ali;
    public ImageView alj;
    public TextView alk;
    public Button all;
    public int alm;
    public int aln;
    public boolean alo;
    public final AdInfo mAdInfo;
    @NonNull
    public final AdTemplate mAdTemplate;
    @NonNull
    public final Context mContext;
    @NonNull
    public View mRootView = zb();

    public e(@NonNull Context context, @NonNull AdTemplate adTemplate, boolean z, boolean z2, boolean z3) {
        this.mContext = context;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.dP(adTemplate);
        this.alg = z;
        this.alh = z2;
        this.alo = z3;
        lK();
    }

    private Animator B(View view2) {
        ObjectAnimator ofFloat;
        if (this.alg && this.alh) {
            ofFloat = ObjectAnimator.ofFloat(view2, View.TRANSLATION_X, 0.0f, this.aln);
        } else {
            ofFloat = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Y, 0.0f, -this.alm);
        }
        ofFloat.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.42f, 0.85f, 0.64f));
        ofFloat.setDuration(260L);
        return ofFloat;
    }

    private void c(FrameLayout frameLayout) {
        FrameLayout.LayoutParams layoutParams;
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0704cb);
        int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0704cc);
        this.alm = dimensionPixelSize + dimensionPixelSize2;
        ViewGroup.LayoutParams layoutParams2 = this.mRootView.getLayoutParams();
        if (layoutParams2 instanceof FrameLayout.LayoutParams) {
            layoutParams = (FrameLayout.LayoutParams) layoutParams2;
        } else {
            layoutParams = new FrameLayout.LayoutParams(-1, dimensionPixelSize);
        }
        layoutParams.gravity = 48;
        layoutParams.leftMargin = dimensionPixelSize2;
        layoutParams.rightMargin = dimensionPixelSize2;
        layoutParams.topMargin = dimensionPixelSize2;
        this.mRootView.setTranslationY(-this.alm);
        frameLayout.addView(this.mRootView, layoutParams);
        show();
    }

    private void d(FrameLayout frameLayout) {
        FrameLayout.LayoutParams layoutParams;
        int screenWidth = bi.getScreenWidth(this.mContext);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0704c9);
        int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0704c8);
        int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f0704c7);
        this.aln = screenWidth - dimensionPixelSize;
        ViewGroup.LayoutParams layoutParams2 = this.mRootView.getLayoutParams();
        if (layoutParams2 instanceof FrameLayout.LayoutParams) {
            layoutParams = (FrameLayout.LayoutParams) layoutParams2;
        } else {
            layoutParams = new FrameLayout.LayoutParams(-1, dimensionPixelOffset);
        }
        layoutParams.gravity = 80;
        layoutParams.leftMargin = dimensionPixelSize;
        layoutParams.rightMargin = 0;
        layoutParams.bottomMargin = dimensionPixelSize2;
        this.mRootView.setTranslationX(this.aln);
        frameLayout.addView(this.mRootView, layoutParams);
        show();
    }

    private void lK() {
        String str;
        int i;
        Button button = this.all;
        if (this.alg) {
            str = "安装";
        } else {
            str = "打开";
        }
        button.setText(str);
        this.ali.setOnClickListener(this);
        this.all.setOnClickListener(this);
        KSImageLoader.loadAppIcon(this.alj, com.kwad.sdk.core.response.b.a.cf(com.kwad.sdk.core.response.b.e.dP(this.mAdTemplate)), this.mAdTemplate, 8);
        String av = com.kwad.sdk.core.response.b.a.av(com.kwad.sdk.core.response.b.e.dP(this.mAdTemplate));
        if (av.length() >= 8) {
            av = av.substring(0, 7) + "...";
        }
        Context context = this.mContext;
        if (this.alg) {
            i = R.string.obfuscated_res_0x7f0f0b91;
        } else {
            i = R.string.obfuscated_res_0x7f0f0b92;
        }
        this.alk.setText(context.getString(i, av));
    }

    @SuppressLint({"InflateParams"})
    private View zb() {
        if (this.alg && this.alh) {
            this.mRootView = l.inflate(this.mContext, R.layout.obfuscated_res_0x7f0d04dc, null);
        } else {
            this.mRootView = l.inflate(this.mContext, R.layout.obfuscated_res_0x7f0d04db, null);
        }
        ViewCompat.setElevation(this.mRootView, this.mContext.getResources().getDimension(R.dimen.obfuscated_res_0x7f0704ca));
        this.ali = this.mRootView.findViewById(R.id.obfuscated_res_0x7f09137b);
        this.alj = (ImageView) this.mRootView.findViewById(R.id.obfuscated_res_0x7f09137d);
        this.alk = (TextView) this.mRootView.findViewById(R.id.obfuscated_res_0x7f09137c);
        this.all = (Button) this.mRootView.findViewById(R.id.obfuscated_res_0x7f09137e);
        return this.mRootView;
    }

    private void show() {
        ObjectAnimator ofFloat;
        if (this.alg && this.alh) {
            ofFloat = ObjectAnimator.ofFloat(this.mRootView, View.TRANSLATION_X, this.aln, 0.0f);
        } else {
            ofFloat = ObjectAnimator.ofFloat(this.mRootView, View.TRANSLATION_Y, -this.alm, 0.0f);
        }
        ofFloat.setInterpolator(PathInterpolatorCompat.create(0.25f, 0.1f, 0.27f, 0.87f));
        ofFloat.setDuration(300L);
        ofFloat.start();
    }

    public final void b(FrameLayout frameLayout) {
        if (this.mRootView.getParent() != null) {
            return;
        }
        if (this.alg && this.alh) {
            d(frameLayout);
        } else {
            c(frameLayout);
        }
        this.mRootView.postDelayed(new Runnable() { // from class: com.kwad.sdk.a.a.e.1
            @Override // java.lang.Runnable
            public final void run() {
                e.this.dismiss();
            }
        }, 10000L);
    }

    public final void dismiss() {
        if (this.mRootView.getParent() == null) {
            return;
        }
        final ViewGroup viewGroup = (ViewGroup) this.mRootView.getParent();
        Animator B = B(this.mRootView);
        B.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.a.a.e.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                viewGroup.removeView(e.this.mRootView);
            }
        });
        B.start();
        c.yT().yY();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        dismiss();
        if (view2.getId() == R.id.obfuscated_res_0x7f09137e) {
            if (this.alg) {
                if (this.alo) {
                    j jVar = new j();
                    jVar.cC(29);
                    jVar.cJ(23);
                    com.kwad.sdk.core.report.a.e(this.mAdTemplate, (JSONObject) null, jVar);
                } else {
                    com.kwad.sdk.core.report.a.r(this.mAdTemplate, 45);
                }
                ak.a(com.kwad.sdk.core.response.b.a.G(this.mAdInfo), new ak.a() { // from class: com.kwad.sdk.a.a.e.3
                    @Override // com.kwad.sdk.utils.ak.a
                    public final void f(Throwable th) {
                        com.kwad.sdk.commercial.b.a.j(e.this.mAdTemplate, 100003, Log.getStackTraceString(th));
                    }

                    @Override // com.kwad.sdk.utils.ak.a
                    public final void ob() {
                        com.kwad.sdk.core.report.a.k(e.this.mAdTemplate, 1);
                        com.kwad.sdk.commercial.b.a.aZ(e.this.mAdTemplate);
                    }
                });
                return;
            }
            if (ak.ap(this.mContext, com.kwad.sdk.core.response.b.a.ay(this.mAdInfo))) {
                com.kwad.sdk.core.report.a.bK(this.mAdTemplate);
            }
            com.kwad.sdk.core.report.a.q(this.mAdTemplate, 47);
        } else if (view2.getId() == R.id.obfuscated_res_0x7f09137b) {
            if (this.alg) {
                if (this.alo) {
                    j jVar2 = new j();
                    jVar2.cC(69);
                    jVar2.cJ(23);
                    jVar2.cN(1);
                    com.kwad.sdk.core.report.a.e(this.mAdTemplate, (JSONObject) null, jVar2);
                    return;
                }
                com.kwad.sdk.core.report.a.r(this.mAdTemplate, 46);
                return;
            }
            com.kwad.sdk.core.report.a.q(this.mAdTemplate, 48);
        }
    }
}
