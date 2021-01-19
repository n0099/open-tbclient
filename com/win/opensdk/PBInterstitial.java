package com.win.opensdk;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.win.opensdk.core.Info;
/* loaded from: classes3.dex */
public class PBInterstitial {
    private String java;
    private cf pYN;
    private PBInterstitialListener pYO;

    public PBInterstitial(@NonNull Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        this.java = str;
        this.pYN = new cf(applicationContext, str);
        this.pYN.pYO = new PBInterstitialListener() { // from class: com.win.opensdk.PBInterstitial.1
            @Override // com.win.opensdk.PBInterstitialListener
            public final void onInterstitialDismissed() {
                if (PBInterstitial.this.pYO != null) {
                    PBInterstitial.this.pYO.onInterstitialDismissed();
                }
            }

            @Override // com.win.opensdk.PBInterstitialListener
            public final void onInterstitialDisplayed() {
                if (PBInterstitial.this.pYO != null) {
                    PBInterstitial.this.pYO.onInterstitialDisplayed();
                }
            }

            @Override // com.win.opensdk.PBInterstitialListener
            public final void onInterstitialShowFail(String str2) {
                if (PBInterstitial.this.pYO != null) {
                    PBInterstitial.this.pYO.onInterstitialShowFail(str2);
                }
            }

            @Override // com.win.opensdk.PBListener
            public final void onFail(PBError pBError) {
                if (PBInterstitial.this.pYO != null) {
                    PBInterstitial.this.pYO.onFail(pBError);
                }
            }

            @Override // com.win.opensdk.PBListener
            public final void onLoaded() {
                if (PBInterstitial.this.pYO != null) {
                    PBInterstitial.this.pYO.onLoaded();
                }
            }

            @Override // com.win.opensdk.PBListener
            public final void onClicked() {
                if (PBInterstitial.this.pYO != null) {
                    PBInterstitial.this.pYO.onClicked();
                }
            }
        };
    }

    public String getPid() {
        return this.java;
    }

    public void load() {
        final cf cfVar = this.pYN;
        if (cfVar.java() && cfVar.pZe.isEffective() && !cfVar.pZe.isShown()) {
            cfVar.a(cfVar.pZe);
            return;
        }
        if (cfVar.pZS == null) {
            cfVar.pZS = new ad(cfVar.pYJ, cfVar.java, e.f54case);
        }
        cfVar.pZS.pZP = new ae<Info>() { // from class: com.win.opensdk.cf.2
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.win.opensdk.ae
            public final /* synthetic */ void bH(Info info) {
                cf.this.a(info);
            }

            @Override // com.win.opensdk.ae
            public final void b(PBError pBError) {
                cf.this.pYO.onFail(pBError);
            }
        };
        cfVar.pZS.eGz();
    }

    public void setInterstitialListener(PBInterstitialListener pBInterstitialListener) {
        this.pYO = pBInterstitialListener;
    }

    public boolean isReady() {
        cf cfVar = this.pYN;
        return cfVar.m74a() || cfVar.c();
    }

    public void show() {
        cf cfVar = this.pYN;
        if (!av.iJ(cfVar.pYJ)) {
            if (cfVar.pYO != null) {
                cfVar.pYO.onInterstitialShowFail(PBError.NO_NETWORK.getMsg());
            }
        } else if (az.iR(cfVar.pYJ) == 1 && cfVar.pZe != null && !TextUtils.isEmpty(cfVar.pZe.getLoad()) && !TextUtils.isEmpty(az.m65c(cfVar.pYJ)) && cfVar.pZe.getPid().equals(az.m65c(cfVar.pYJ))) {
            aw.bJ(cfVar.pYJ, cfVar.pZe.getLoad());
            w.iK(cfVar.pYJ).a(new x(cfVar.pZe)).eGz();
            if (cfVar.pZe != null) {
                az.l(cfVar.pYJ, cfVar.pZe.getId() + ":" + System.currentTimeMillis(), false);
            }
            z.b(cfVar.pZe);
        } else if (cfVar.eGX()) {
            if (!cfVar.m74a() || !cfVar.java()) {
                return;
            }
            cfVar.pYM = false;
            bp.eGY().a(bp.aW(cfVar.pZe.getTraceid(), cfVar.pZe.getId(), cfVar.pZe.getPid()), cfVar.pYQ);
            cfVar.eGz();
        } else if (!cfVar.m75b() || !cfVar.c() || !cfVar.java()) {
        } else {
            cfVar.pZm = false;
            cfVar.eGz();
        }
    }

    public void destroy() {
        cf cfVar = this.pYN;
        cfVar.f13743a = false;
        cfVar.pYM = false;
        cfVar.pZm = false;
        if (cfVar.pZS == null) {
            return;
        }
        cfVar.pZS.eGA();
    }
}
