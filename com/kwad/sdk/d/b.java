package com.kwad.sdk.d;

import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends AlertDialog {
    public com.kwad.sdk.d.a.a a;

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f58826b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public KsAdVideoPlayConfig f58827c;

    /* renamed from: d  reason: collision with root package name */
    public Activity f58828d;

    /* renamed from: e  reason: collision with root package name */
    public KsInterstitialAd.AdInteractionListener f58829e;

    public b(@NonNull Activity activity, @NonNull AdTemplate adTemplate, KsVideoPlayConfig ksVideoPlayConfig, KsInterstitialAd.AdInteractionListener adInteractionListener) {
        super(Wrapper.wrapContextIfNeed(activity));
        this.f58828d = activity;
        this.f58829e = adInteractionListener;
        this.f58827c = new KsAdVideoPlayConfig.Builder().videoSoundEnable(ksVideoPlayConfig != null && ksVideoPlayConfig.isVideoSoundEnable()).dataFlowAutoStart(com.kwad.sdk.core.config.b.p()).build();
        setOwnerActivity(activity);
        this.f58826b = adTemplate;
        if (this.a == null) {
            com.kwad.sdk.d.a.a aVar = new com.kwad.sdk.d.a.a(Wrapper.wrapContextIfNeed(activity));
            this.a = aVar;
            aVar.a(this.f58826b, this, this.f58827c, adInteractionListener, ksVideoPlayConfig != null && ksVideoPlayConfig.isShowLandscape());
        }
    }

    public void a(KsInterstitialAd.AdInteractionListener adInteractionListener) {
        this.f58829e = adInteractionListener;
        com.kwad.sdk.d.a.a aVar = this.a;
        if (aVar != null) {
            aVar.setAdInteractionListener(adInteractionListener);
        }
    }

    public boolean a() {
        try {
            if (isShowing() || this.f58828d == null || this.f58828d.isFinishing()) {
                return true;
            }
            show();
            this.f58829e.onAdShow();
            com.kwad.sdk.core.report.a.a(this.f58826b, (JSONObject) null);
            return true;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.a(th);
            return false;
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        KsInterstitialAd.AdInteractionListener adInteractionListener = this.f58829e;
        if (adInteractionListener != null) {
            adInteractionListener.onPageDismiss();
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        if (com.kwad.sdk.core.config.b.al()) {
            super.onBackPressed();
        }
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.a);
        setCanceledOnTouchOutside(false);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getWindow().setLayout(-1, -1);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.kwad.sdk.core.d.a.a("InterstitialDialog", "onDetachedFromWindow");
        com.kwad.sdk.d.a.a aVar = this.a;
        if (aVar != null) {
            aVar.e();
        }
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        com.kwad.sdk.core.d.a.a("InterstitialDialog", "onStart");
        setTitle((CharSequence) null);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        com.kwad.sdk.core.d.a.a("InterstitialDialog", "onWindowFocusChanged , hasFocus: " + z);
        if (z) {
            this.a.c();
        } else {
            this.a.d();
        }
    }
}
