package com.kwad.components.ad.splashscreen.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Vibrator;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.bd;
/* loaded from: classes8.dex */
public abstract class h extends e {
    public static long gO = 400;
    public Vibrator eO;
    public com.kwad.components.ad.splashscreen.d.a yM;

    private void km() {
        com.kwad.components.ad.splashscreen.h hVar = this.yF;
        if (hVar != null) {
            com.kwad.components.ad.splashscreen.d.a aVar = this.yM;
            if (aVar == null) {
                this.yM = new com.kwad.components.ad.splashscreen.d.a(getContext(), this.yF.mAdTemplate) { // from class: com.kwad.components.ad.splashscreen.b.h.1
                    @Override // com.kwad.components.ad.splashscreen.d.a
                    @SuppressLint({"SetTextI18n"})
                    public final void Z(String str) {
                        h.this.Y(str);
                    }
                };
            } else {
                aVar.setAdTemplate(hVar.mAdTemplate);
            }
            com.kwad.components.core.c.a.c cVar = this.yF.mApkDownloadHelper;
            if (cVar != null) {
                cVar.b(this.yM);
            }
        }
    }

    public abstract void Y(String str);

    @Override // com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    public void aq() {
        super.aq();
        if (this.yF == null) {
            return;
        }
        kl();
        AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(this.yF.mAdTemplate);
        ki();
        kf();
        if (com.kwad.sdk.core.response.a.a.am(bQ)) {
            km();
        }
        kg();
        kj();
        kk();
        kh();
    }

    public abstract void initView();

    public abstract void kf();

    public abstract void kg();

    public abstract void kh();

    public abstract void ki();

    public abstract void kj();

    public abstract void kk();

    public abstract void kl();

    public final void kn() {
        Context context = getContext();
        if (context != null) {
            this.eO = (Vibrator) context.getSystemService("vibrator");
        }
        bd.a(getContext(), this.eO);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        initView();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void onUnbind() {
        super.onUnbind();
        bd.b(getContext(), this.eO);
    }
}
