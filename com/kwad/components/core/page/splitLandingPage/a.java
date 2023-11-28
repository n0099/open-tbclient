package com.kwad.components.core.page.splitLandingPage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.components.core.e.d.c;
import com.kwad.components.core.page.c.b;
import com.kwad.components.core.page.splitLandingPage.view.SplitScrollWebView;
import com.kwad.components.core.page.splitLandingPage.view.a;
import com.kwad.components.core.proxy.e;
import com.kwad.components.core.s.n;
import com.kwad.components.core.widget.FeedVideoView;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class a extends e {
    public FeedVideoView NQ;
    public LinearLayout NR;
    public SplitScrollWebView PN;
    public Presenter PO;
    public com.kwad.components.core.page.splitLandingPage.view.a PP;
    public com.kwad.components.core.page.c.a PQ;
    public boolean PR;
    public AdTemplate mAdTemplate;
    public c mApkDownloadHelper;

    @Override // com.kwad.components.core.proxy.e
    public final int oR() {
        return R.layout.obfuscated_res_0x7f0d051b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pK() {
        this.PQ.lP();
        this.PQ.G(this.NQ);
        this.PQ.k(new com.kwad.components.core.page.recycle.e(this.mAdTemplate, this.mApkDownloadHelper, null));
    }

    @Override // com.kwad.components.core.proxy.e, com.kwad.sdk.l.a.b
    public final boolean onBackPressed() {
        SplitScrollWebView splitScrollWebView = this.PN;
        if (splitScrollWebView != null && splitScrollWebView.canGoBack()) {
            this.PN.goBack();
            return true;
        } else if (pJ()) {
            return true;
        } else {
            FeedVideoView feedVideoView = this.NQ;
            if (feedVideoView != null) {
                return feedVideoView.tg();
            }
            return false;
        }
    }

    @Override // com.kwad.components.core.proxy.e, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final void onDestroy() {
        super.onDestroy();
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate != null) {
            adTemplate.mAdWebVideoPageShowing = false;
        }
    }

    public final void pL() {
        this.NQ.pL();
    }

    public static a at(AdTemplate adTemplate) {
        a aVar = new a();
        Bundle bundle = new Bundle();
        bundle.putString("key_photo", adTemplate.toJson().toString());
        bundle.putBoolean("key_report", adTemplate.mPvReported);
        aVar.setArguments(bundle);
        return aVar;
    }

    private void j(ViewGroup viewGroup) {
        Presenter presenter = new Presenter();
        this.PO = presenter;
        presenter.G(viewGroup);
        b bVar = new b();
        bVar.G(this.PN);
        com.kwad.components.core.page.c.a aVar = new com.kwad.components.core.page.c.a();
        this.PQ = aVar;
        aVar.G(this.NQ);
        this.PO.a(bVar);
        this.PO.a(this.PQ);
    }

    public final void setApkDownloadHelper(c cVar) {
        this.mApkDownloadHelper = cVar;
    }

    public static /* synthetic */ boolean a(a aVar, boolean z) {
        aVar.PR = false;
        return false;
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final void onViewCreated(@NonNull View view2, @Nullable Bundle bundle) {
        super.onViewCreated(view2, bundle);
        this.NQ = (FeedVideoView) findViewById(R.id.obfuscated_res_0x7f0914d2);
        this.PN = (SplitScrollWebView) findViewById(R.id.obfuscated_res_0x7f091511);
        w(view2);
        j(this.lC);
        initView();
    }

    private void initView() {
        com.kwad.components.core.page.recycle.e eVar = new com.kwad.components.core.page.recycle.e(this.mAdTemplate, this.mApkDownloadHelper, null);
        this.PO.k(eVar);
        com.kwad.components.core.page.splitLandingPage.view.a aVar = new com.kwad.components.core.page.splitLandingPage.view.a(this.mContext, new com.kwad.components.core.page.splitLandingPage.a.a(eVar.adTemplate, eVar.Kx));
        this.PP = aVar;
        aVar.a(new a.InterfaceC0657a() { // from class: com.kwad.components.core.page.splitLandingPage.a.3
            @Override // com.kwad.components.core.page.splitLandingPage.view.a.InterfaceC0657a
            public final boolean pM() {
                return a.this.pJ();
            }
        });
        this.NQ.post(new Runnable() { // from class: com.kwad.components.core.page.splitLandingPage.a.4
            @Override // java.lang.Runnable
            public final void run() {
                a.this.PN.setTranslationY(a.this.PN.getTranslationY() + a.this.NQ.getHeight());
            }
        });
        this.PN.setSplitScrollWebViewListener(new SplitScrollWebView.a() { // from class: com.kwad.components.core.page.splitLandingPage.a.5
            @Override // com.kwad.components.core.page.splitLandingPage.view.SplitScrollWebView.a
            public final void d(float f) {
                a.this.PN.setTranslationY(a.this.PN.getTranslationY() - f);
            }

            @Override // com.kwad.components.core.page.splitLandingPage.view.SplitScrollWebView.a
            public final boolean pN() {
                if (!a.this.PP.pO() && d.Am() == 2) {
                    return false;
                }
                AnimatorSet animatorSet = new AnimatorSet();
                Animator a = n.a((View) a.this.PN, (Interpolator) null, a.this.PN.getTranslationY(), 0.0f);
                if (d.Am() == 2) {
                    if (!a.this.NQ.isComplete()) {
                        animatorSet.playSequentially(a, a.this.PP.aG(true));
                    } else {
                        animatorSet.playTogether(a);
                    }
                } else if (d.Am() == 1) {
                    animatorSet.playTogether(a);
                }
                animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.core.page.splitLandingPage.a.5.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public final void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        a.this.NQ.pL();
                        if (d.Am() == 2 && !a.this.NQ.isComplete()) {
                            a.this.PP.pP();
                        }
                    }
                });
                animatorSet.start();
                return true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pJ() {
        SplitScrollWebView splitScrollWebView = this.PN;
        if (splitScrollWebView == null || splitScrollWebView.getTranslationY() != 0.0f || this.PR) {
            return false;
        }
        this.PN.setDisableAnimation(false);
        this.PR = true;
        SplitScrollWebView splitScrollWebView2 = this.PN;
        Animator a = n.a((View) splitScrollWebView2, (Interpolator) null, 0.0f, splitScrollWebView2.getTranslationY() + this.NQ.getHeight());
        AnimatorSet animatorSet = new AnimatorSet();
        if (d.Am() == 2 && this.PP.isVisible()) {
            this.PP.pL();
            animatorSet.playSequentially(this.PP.aG(false), a);
        } else {
            animatorSet.play(a);
        }
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.core.page.splitLandingPage.a.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                a.this.pK();
                a.this.NQ.pP();
                a.a(a.this, false);
            }
        });
        animatorSet.start();
        return true;
    }

    private void w(View view2) {
        this.NR = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09151e);
        TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09151f);
        ((ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091520)).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.splitLandingPage.a.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                a.this.NR.setVisibility(8);
            }
        });
        AdInfo dP = com.kwad.sdk.core.response.b.e.dP(this.mAdTemplate);
        boolean bw = com.kwad.sdk.core.response.b.a.bw(dP);
        String bs = com.kwad.sdk.core.response.b.a.bs(dP);
        if (bw) {
            this.NR.setVisibility(0);
            textView.setText(bs);
            textView.setSelected(true);
            return;
        }
        this.NR.setVisibility(8);
    }

    @Override // com.kwad.components.core.proxy.e, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        String string = getArguments().getString("key_photo");
        AdTemplate adTemplate = new AdTemplate();
        if (string != null) {
            try {
                adTemplate.parseJson(new JSONObject(string));
            } catch (JSONException e) {
                com.kwad.sdk.core.e.c.printStackTrace(e);
            }
        }
        this.mAdTemplate = adTemplate;
        adTemplate.mPvReported = getArguments().getBoolean("key_report", false);
        this.mAdTemplate.mAdWebVideoPageShowing = true;
    }
}
