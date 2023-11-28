package com.kwad.components.ad.splashscreen.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Vibrator;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.bn;
/* loaded from: classes10.dex */
public abstract class i extends e implements com.kwad.sdk.core.h.c {
    public static long ld = 400;
    public com.kwad.components.ad.splashscreen.f.a Ds;
    public Vibrator eh;

    public abstract void initView();

    public abstract void j(int i, String str);

    public abstract void lc();

    public abstract void ld();

    public abstract void le();

    public abstract void lf();

    public abstract void lg();

    public abstract void lh();

    private void li() {
        com.kwad.components.ad.splashscreen.h hVar = this.Df;
        if (hVar != null) {
            com.kwad.components.ad.splashscreen.f.a aVar = this.Ds;
            if (aVar == null) {
                this.Ds = new com.kwad.components.ad.splashscreen.f.a(getContext(), this.Df.mAdTemplate) { // from class: com.kwad.components.ad.splashscreen.c.i.1
                    {
                        super(r3);
                    }

                    @Override // com.kwad.components.ad.splashscreen.f.a
                    @SuppressLint({"SetTextI18n"})
                    public final void k(int i, String str) {
                        i.this.j(i, str);
                    }
                };
            } else {
                aVar.setAdTemplate(hVar.mAdTemplate);
            }
            com.kwad.components.core.e.d.c cVar = this.Df.mApkDownloadHelper;
            if (cVar != null) {
                cVar.b(this.Ds);
            }
        }
    }

    @Override // com.kwad.sdk.core.h.c
    public final void aM() {
        if (!this.Df.Cu) {
            lf();
        }
    }

    @Override // com.kwad.sdk.core.h.c
    public final void aN() {
        lg();
    }

    @Override // com.kwad.components.ad.splashscreen.c.e, com.kwad.sdk.mvp.Presenter
    public void aj() {
        super.aj();
        com.kwad.components.ad.splashscreen.h hVar = this.Df;
        if (hVar == null) {
            return;
        }
        AdInfo dP = com.kwad.sdk.core.response.b.e.dP(hVar.mAdTemplate);
        le();
        lc();
        if (com.kwad.sdk.core.response.b.a.aF(dP)) {
            li();
        }
        ld();
        lh();
        this.Df.Cr.a(this);
    }

    public final void lj() {
        Context context = getContext();
        if (context != null) {
            this.eh = (Vibrator) context.getSystemService("vibrator");
        }
        bn.a(getContext(), this.eh);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        initView();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void onUnbind() {
        super.onUnbind();
        this.Df.Cr.b(this);
        lg();
        bn.b(getContext(), this.eh);
    }
}
