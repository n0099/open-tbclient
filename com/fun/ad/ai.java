package com.fun.ad;

import android.text.TextUtils;
import android.widget.Button;
import com.fun.ad.sdk.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.api.KsNativeAd;
/* loaded from: classes15.dex */
public class ai implements KsAppDownloadListener {

    /* renamed from: a  reason: collision with root package name */
    public Button f8047a;

    /* renamed from: b  reason: collision with root package name */
    public String f8048b;

    public ai(KsNativeAd ksNativeAd, Button button, String str, String str2, String str3) {
        this.f8048b = ksNativeAd.getActionDescription();
        this.f8047a = button;
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadFailed() {
        if (TextUtils.isEmpty(this.f8048b)) {
            this.f8047a.setText(R.string.ad_interaction_type_download);
        } else {
            this.f8047a.setText(this.f8048b);
        }
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadFinished() {
        this.f8047a.setText(R.string.ad_interaction_type_install);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadStarted() {
        Button button = this.f8047a;
        button.setText(button.getContext().getResources().getString(R.string.ad_interaction_type_downloading, "%0/100"));
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onIdle() {
        if (TextUtils.isEmpty(this.f8048b)) {
            this.f8047a.setText(R.string.ad_interaction_type_download);
        } else {
            this.f8047a.setText(this.f8048b);
        }
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onInstalled() {
        this.f8047a.setText(R.string.ad_interaction_type_open);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onProgressUpdate(int i) {
        Button button = this.f8047a;
        button.setText(button.getContext().getResources().getString(R.string.ad_interaction_type_downloading, String.format("%s/100", Integer.valueOf(i))));
    }
}
