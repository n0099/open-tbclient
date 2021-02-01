package com.fun.ad;

import android.text.TextUtils;
import android.widget.Button;
import com.fun.ad.sdk.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.api.KsNativeAd;
/* loaded from: classes6.dex */
public class ai implements KsAppDownloadListener {

    /* renamed from: a  reason: collision with root package name */
    public Button f7750a;

    /* renamed from: b  reason: collision with root package name */
    public String f7751b;

    public ai(KsNativeAd ksNativeAd, Button button, String str, String str2, String str3) {
        this.f7751b = ksNativeAd.getActionDescription();
        this.f7750a = button;
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadFailed() {
        Button button = this.f7750a;
        if (button == null || button.getTag(R.id.download_button_listener) != this) {
            return;
        }
        if (TextUtils.isEmpty(this.f7751b)) {
            this.f7750a.setText(R.string.ad_interaction_type_download);
        } else {
            this.f7750a.setText(this.f7751b);
        }
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadFinished() {
        Button button = this.f7750a;
        if (button == null || button.getTag(R.id.download_button_listener) != this) {
            return;
        }
        this.f7750a.setText(R.string.ad_interaction_type_install);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadStarted() {
        Button button = this.f7750a;
        if (button == null || button.getTag(R.id.download_button_listener) != this) {
            return;
        }
        Button button2 = this.f7750a;
        button2.setText(button2.getContext().getResources().getString(R.string.ad_interaction_type_downloading, "%0/100"));
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onIdle() {
        Button button = this.f7750a;
        if (button == null || button.getTag(R.id.download_button_listener) != this) {
            return;
        }
        if (TextUtils.isEmpty(this.f7751b)) {
            this.f7750a.setText(R.string.ad_interaction_type_download);
        } else {
            this.f7750a.setText(this.f7751b);
        }
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onInstalled() {
        Button button = this.f7750a;
        if (button == null || button.getTag(R.id.download_button_listener) != this) {
            return;
        }
        this.f7750a.setText(R.string.ad_interaction_type_open);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onProgressUpdate(int i) {
        Button button = this.f7750a;
        if (button == null || button.getTag(R.id.download_button_listener) != this) {
            return;
        }
        Button button2 = this.f7750a;
        button2.setText(button2.getContext().getResources().getString(R.string.ad_interaction_type_downloading, String.format("%s/100", Integer.valueOf(i))));
    }
}
