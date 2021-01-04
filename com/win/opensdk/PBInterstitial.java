package com.win.opensdk;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.win.opensdk.core.Info;
/* loaded from: classes4.dex */
public class PBInterstitial {
    private String java;
    private cf qbF;
    private PBInterstitialListener qbG;

    public PBInterstitial(@NonNull Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        this.java = str;
        this.qbF = new cf(applicationContext, str);
        this.qbF.qbG = new PBInterstitialListener() { // from class: com.win.opensdk.PBInterstitial.1
            @Override // com.win.opensdk.PBInterstitialListener
            public final void onInterstitialDismissed() {
                if (PBInterstitial.this.qbG != null) {
                    PBInterstitial.this.qbG.onInterstitialDismissed();
                }
            }

            @Override // com.win.opensdk.PBInterstitialListener
            public final void onInterstitialDisplayed() {
                if (PBInterstitial.this.qbG != null) {
                    PBInterstitial.this.qbG.onInterstitialDisplayed();
                }
            }

            @Override // com.win.opensdk.PBInterstitialListener
            public final void onInterstitialShowFail(String str2) {
                if (PBInterstitial.this.qbG != null) {
                    PBInterstitial.this.qbG.onInterstitialShowFail(str2);
                }
            }

            @Override // com.win.opensdk.PBListener
            public final void onFail(PBError pBError) {
                if (PBInterstitial.this.qbG != null) {
                    PBInterstitial.this.qbG.onFail(pBError);
                }
            }

            @Override // com.win.opensdk.PBListener
            public final void onLoaded() {
                if (PBInterstitial.this.qbG != null) {
                    PBInterstitial.this.qbG.onLoaded();
                }
            }

            @Override // com.win.opensdk.PBListener
            public final void onClicked() {
                if (PBInterstitial.this.qbG != null) {
                    PBInterstitial.this.qbG.onClicked();
                }
            }
        };
    }

    public String getPid() {
        return this.java;
    }

    public void load() {
        final cf cfVar = this.qbF;
        if (cfVar.java() && cfVar.qbW.isEffective() && !cfVar.qbW.isShown()) {
            cfVar.a(cfVar.qbW);
            return;
        }
        if (cfVar.qcK == null) {
            cfVar.qcK = new ad(cfVar.qbB, cfVar.java, e.f54case);
        }
        cfVar.qcK.qcH = new ae<Info>() { // from class: com.win.opensdk.cf.2
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.win.opensdk.ae
            public final /* synthetic */ void bG(Info info) {
                cf.this.a(info);
            }

            @Override // com.win.opensdk.ae
            public final void b(PBError pBError) {
                cf.this.qbG.onFail(pBError);
            }
        };
        cfVar.qcK.eJL();
    }

    public void setInterstitialListener(PBInterstitialListener pBInterstitialListener) {
        this.qbG = pBInterstitialListener;
    }

    public boolean isReady() {
        cf cfVar = this.qbF;
        return cfVar.m67a() || cfVar.c();
    }

    public void show() {
        cf cfVar = this.qbF;
        if (!av.iL(cfVar.qbB)) {
            if (cfVar.qbG != null) {
                cfVar.qbG.onInterstitialShowFail(PBError.NO_NETWORK.getMsg());
            }
        } else if (az.iT(cfVar.qbB) == 1 && cfVar.qbW != null && !TextUtils.isEmpty(cfVar.qbW.getLoad()) && !TextUtils.isEmpty(az.m58c(cfVar.qbB)) && cfVar.qbW.getPid().equals(az.m58c(cfVar.qbB))) {
            aw.bJ(cfVar.qbB, cfVar.qbW.getLoad());
            w.iM(cfVar.qbB).a(new x(cfVar.qbW)).eJL();
            if (cfVar.qbW != null) {
                az.l(cfVar.qbB, cfVar.qbW.getId() + ":" + System.currentTimeMillis(), false);
            }
            z.b(cfVar.qbW);
        } else if (cfVar.eKj()) {
            if (!cfVar.m67a() || !cfVar.java()) {
                return;
            }
            cfVar.qbE = false;
            bp.eKk().a(bp.aX(cfVar.qbW.getTraceid(), cfVar.qbW.getId(), cfVar.qbW.getPid()), cfVar.qbI);
            cfVar.eJL();
        } else if (!cfVar.m68b() || !cfVar.c() || !cfVar.java()) {
        } else {
            cfVar.qce = false;
            cfVar.eJL();
        }
    }

    public void destroy() {
        cf cfVar = this.qbF;
        cfVar.f14042a = false;
        cfVar.qbE = false;
        cfVar.qce = false;
        if (cfVar.qcK == null) {
            return;
        }
        cfVar.qcK.eJM();
    }
}
