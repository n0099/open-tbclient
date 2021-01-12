package com.win.opensdk;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.win.opensdk.core.Info;
/* loaded from: classes3.dex */
public class PBInterstitial {
    private String java;
    private cf pYM;
    private PBInterstitialListener pYN;

    public PBInterstitial(@NonNull Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        this.java = str;
        this.pYM = new cf(applicationContext, str);
        this.pYM.pYN = new PBInterstitialListener() { // from class: com.win.opensdk.PBInterstitial.1
            @Override // com.win.opensdk.PBInterstitialListener
            public final void onInterstitialDismissed() {
                if (PBInterstitial.this.pYN != null) {
                    PBInterstitial.this.pYN.onInterstitialDismissed();
                }
            }

            @Override // com.win.opensdk.PBInterstitialListener
            public final void onInterstitialDisplayed() {
                if (PBInterstitial.this.pYN != null) {
                    PBInterstitial.this.pYN.onInterstitialDisplayed();
                }
            }

            @Override // com.win.opensdk.PBInterstitialListener
            public final void onInterstitialShowFail(String str2) {
                if (PBInterstitial.this.pYN != null) {
                    PBInterstitial.this.pYN.onInterstitialShowFail(str2);
                }
            }

            @Override // com.win.opensdk.PBListener
            public final void onFail(PBError pBError) {
                if (PBInterstitial.this.pYN != null) {
                    PBInterstitial.this.pYN.onFail(pBError);
                }
            }

            @Override // com.win.opensdk.PBListener
            public final void onLoaded() {
                if (PBInterstitial.this.pYN != null) {
                    PBInterstitial.this.pYN.onLoaded();
                }
            }

            @Override // com.win.opensdk.PBListener
            public final void onClicked() {
                if (PBInterstitial.this.pYN != null) {
                    PBInterstitial.this.pYN.onClicked();
                }
            }
        };
    }

    public String getPid() {
        return this.java;
    }

    public void load() {
        final cf cfVar = this.pYM;
        if (cfVar.java() && cfVar.pZd.isEffective() && !cfVar.pZd.isShown()) {
            cfVar.a(cfVar.pZd);
            return;
        }
        if (cfVar.pZR == null) {
            cfVar.pZR = new ad(cfVar.pYI, cfVar.java, e.f54case);
        }
        cfVar.pZR.pZO = new ae<Info>() { // from class: com.win.opensdk.cf.2
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.win.opensdk.ae
            public final /* synthetic */ void bH(Info info) {
                cf.this.a(info);
            }

            @Override // com.win.opensdk.ae
            public final void b(PBError pBError) {
                cf.this.pYN.onFail(pBError);
            }
        };
        cfVar.pZR.eGz();
    }

    public void setInterstitialListener(PBInterstitialListener pBInterstitialListener) {
        this.pYN = pBInterstitialListener;
    }

    public boolean isReady() {
        cf cfVar = this.pYM;
        return cfVar.m74a() || cfVar.c();
    }

    public void show() {
        cf cfVar = this.pYM;
        if (!av.iJ(cfVar.pYI)) {
            if (cfVar.pYN != null) {
                cfVar.pYN.onInterstitialShowFail(PBError.NO_NETWORK.getMsg());
            }
        } else if (az.iR(cfVar.pYI) == 1 && cfVar.pZd != null && !TextUtils.isEmpty(cfVar.pZd.getLoad()) && !TextUtils.isEmpty(az.m65c(cfVar.pYI)) && cfVar.pZd.getPid().equals(az.m65c(cfVar.pYI))) {
            aw.bJ(cfVar.pYI, cfVar.pZd.getLoad());
            w.iK(cfVar.pYI).a(new x(cfVar.pZd)).eGz();
            if (cfVar.pZd != null) {
                az.l(cfVar.pYI, cfVar.pZd.getId() + ":" + System.currentTimeMillis(), false);
            }
            z.b(cfVar.pZd);
        } else if (cfVar.eGX()) {
            if (!cfVar.m74a() || !cfVar.java()) {
                return;
            }
            cfVar.pYL = false;
            bp.eGY().a(bp.aW(cfVar.pZd.getTraceid(), cfVar.pZd.getId(), cfVar.pZd.getPid()), cfVar.pYP);
            cfVar.eGz();
        } else if (!cfVar.m75b() || !cfVar.c() || !cfVar.java()) {
        } else {
            cfVar.pZl = false;
            cfVar.eGz();
        }
    }

    public void destroy() {
        cf cfVar = this.pYM;
        cfVar.f13743a = false;
        cfVar.pYL = false;
        cfVar.pZl = false;
        if (cfVar.pZR == null) {
            return;
        }
        cfVar.pZR.eGA();
    }
}
