package com.win.opensdk;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.win.opensdk.core.Info;
/* loaded from: classes3.dex */
public class PBInterstitial {
    private String java;
    private cf qiR;
    private PBInterstitialListener qiS;

    public PBInterstitial(@NonNull Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        this.java = str;
        this.qiR = new cf(applicationContext, str);
        this.qiR.qiS = new PBInterstitialListener() { // from class: com.win.opensdk.PBInterstitial.1
            @Override // com.win.opensdk.PBInterstitialListener
            public final void onInterstitialDismissed() {
                if (PBInterstitial.this.qiS != null) {
                    PBInterstitial.this.qiS.onInterstitialDismissed();
                }
            }

            @Override // com.win.opensdk.PBInterstitialListener
            public final void onInterstitialDisplayed() {
                if (PBInterstitial.this.qiS != null) {
                    PBInterstitial.this.qiS.onInterstitialDisplayed();
                }
            }

            @Override // com.win.opensdk.PBInterstitialListener
            public final void onInterstitialShowFail(String str2) {
                if (PBInterstitial.this.qiS != null) {
                    PBInterstitial.this.qiS.onInterstitialShowFail(str2);
                }
            }

            @Override // com.win.opensdk.PBListener
            public final void onFail(PBError pBError) {
                if (PBInterstitial.this.qiS != null) {
                    PBInterstitial.this.qiS.onFail(pBError);
                }
            }

            @Override // com.win.opensdk.PBListener
            public final void onLoaded() {
                if (PBInterstitial.this.qiS != null) {
                    PBInterstitial.this.qiS.onLoaded();
                }
            }

            @Override // com.win.opensdk.PBListener
            public final void onClicked() {
                if (PBInterstitial.this.qiS != null) {
                    PBInterstitial.this.qiS.onClicked();
                }
            }
        };
    }

    public String getPid() {
        return this.java;
    }

    public void load() {
        final cf cfVar = this.qiR;
        if (cfVar.java() && cfVar.qji.isEffective() && !cfVar.qji.isShown()) {
            cfVar.a(cfVar.qji);
            return;
        }
        if (cfVar.qjW == null) {
            cfVar.qjW = new ad(cfVar.qiN, cfVar.java, e.f54case);
        }
        cfVar.qjW.qjT = new ae<Info>() { // from class: com.win.opensdk.cf.2
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.win.opensdk.ae
            public final /* synthetic */ void bH(Info info) {
                cf.this.a(info);
            }

            @Override // com.win.opensdk.ae
            public final void b(PBError pBError) {
                cf.this.qiS.onFail(pBError);
            }
        };
        cfVar.qjW.eIP();
    }

    public void setInterstitialListener(PBInterstitialListener pBInterstitialListener) {
        this.qiS = pBInterstitialListener;
    }

    public boolean isReady() {
        cf cfVar = this.qiR;
        return cfVar.m74a() || cfVar.c();
    }

    public void show() {
        cf cfVar = this.qiR;
        if (!av.iM(cfVar.qiN)) {
            if (cfVar.qiS != null) {
                cfVar.qiS.onInterstitialShowFail(PBError.NO_NETWORK.getMsg());
            }
        } else if (az.iU(cfVar.qiN) == 1 && cfVar.qji != null && !TextUtils.isEmpty(cfVar.qji.getLoad()) && !TextUtils.isEmpty(az.m65c(cfVar.qiN)) && cfVar.qji.getPid().equals(az.m65c(cfVar.qiN))) {
            aw.bI(cfVar.qiN, cfVar.qji.getLoad());
            w.iN(cfVar.qiN).a(new x(cfVar.qji)).eIP();
            if (cfVar.qji != null) {
                az.l(cfVar.qiN, cfVar.qji.getId() + ":" + System.currentTimeMillis(), false);
            }
            z.b(cfVar.qji);
        } else if (cfVar.eJn()) {
            if (!cfVar.m74a() || !cfVar.java()) {
                return;
            }
            cfVar.qiQ = false;
            bp.eJo().a(bp.aX(cfVar.qji.getTraceid(), cfVar.qji.getId(), cfVar.qji.getPid()), cfVar.qiU);
            cfVar.eIP();
        } else if (!cfVar.m75b() || !cfVar.c() || !cfVar.java()) {
        } else {
            cfVar.qjq = false;
            cfVar.eIP();
        }
    }

    public void destroy() {
        cf cfVar = this.qiR;
        cfVar.f13745a = false;
        cfVar.qiQ = false;
        cfVar.qjq = false;
        if (cfVar.qjW == null) {
            return;
        }
        cfVar.qjW.eIQ();
    }
}
