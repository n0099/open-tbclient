package com.win.opensdk;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.win.opensdk.core.Info;
/* loaded from: classes4.dex */
public class PBInterstitial {
    private String java;
    private cf qdn;
    private PBInterstitialListener qdo;

    public PBInterstitial(@NonNull Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        this.java = str;
        this.qdn = new cf(applicationContext, str);
        this.qdn.qdo = new PBInterstitialListener() { // from class: com.win.opensdk.PBInterstitial.1
            @Override // com.win.opensdk.PBInterstitialListener
            public final void onInterstitialDismissed() {
                if (PBInterstitial.this.qdo != null) {
                    PBInterstitial.this.qdo.onInterstitialDismissed();
                }
            }

            @Override // com.win.opensdk.PBInterstitialListener
            public final void onInterstitialDisplayed() {
                if (PBInterstitial.this.qdo != null) {
                    PBInterstitial.this.qdo.onInterstitialDisplayed();
                }
            }

            @Override // com.win.opensdk.PBInterstitialListener
            public final void onInterstitialShowFail(String str2) {
                if (PBInterstitial.this.qdo != null) {
                    PBInterstitial.this.qdo.onInterstitialShowFail(str2);
                }
            }

            @Override // com.win.opensdk.PBListener
            public final void onFail(PBError pBError) {
                if (PBInterstitial.this.qdo != null) {
                    PBInterstitial.this.qdo.onFail(pBError);
                }
            }

            @Override // com.win.opensdk.PBListener
            public final void onLoaded() {
                if (PBInterstitial.this.qdo != null) {
                    PBInterstitial.this.qdo.onLoaded();
                }
            }

            @Override // com.win.opensdk.PBListener
            public final void onClicked() {
                if (PBInterstitial.this.qdo != null) {
                    PBInterstitial.this.qdo.onClicked();
                }
            }
        };
    }

    public String getPid() {
        return this.java;
    }

    public void load() {
        final cf cfVar = this.qdn;
        if (cfVar.java() && cfVar.qdE.isEffective() && !cfVar.qdE.isShown()) {
            cfVar.a(cfVar.qdE);
            return;
        }
        if (cfVar.qes == null) {
            cfVar.qes = new ad(cfVar.qdj, cfVar.java, e.f55case);
        }
        cfVar.qes.qep = new ae<Info>() { // from class: com.win.opensdk.cf.2
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.win.opensdk.ae
            public final /* synthetic */ void bH(Info info) {
                cf.this.a(info);
            }

            @Override // com.win.opensdk.ae
            public final void b(PBError pBError) {
                cf.this.qdo.onFail(pBError);
            }
        };
        cfVar.qes.eKp();
    }

    public void setInterstitialListener(PBInterstitialListener pBInterstitialListener) {
        this.qdo = pBInterstitialListener;
    }

    public boolean isReady() {
        cf cfVar = this.qdn;
        return cfVar.m78a() || cfVar.c();
    }

    public void show() {
        cf cfVar = this.qdn;
        if (!av.iL(cfVar.qdj)) {
            if (cfVar.qdo != null) {
                cfVar.qdo.onInterstitialShowFail(PBError.NO_NETWORK.getMsg());
            }
        } else if (az.iT(cfVar.qdj) == 1 && cfVar.qdE != null && !TextUtils.isEmpty(cfVar.qdE.getLoad()) && !TextUtils.isEmpty(az.m69c(cfVar.qdj)) && cfVar.qdE.getPid().equals(az.m69c(cfVar.qdj))) {
            aw.bJ(cfVar.qdj, cfVar.qdE.getLoad());
            w.iM(cfVar.qdj).a(new x(cfVar.qdE)).eKp();
            if (cfVar.qdE != null) {
                az.l(cfVar.qdj, cfVar.qdE.getId() + ":" + System.currentTimeMillis(), false);
            }
            z.b(cfVar.qdE);
        } else if (cfVar.eKN()) {
            if (!cfVar.m78a() || !cfVar.java()) {
                return;
            }
            cfVar.qdm = false;
            bp.eKO().a(bp.aX(cfVar.qdE.getTraceid(), cfVar.qdE.getId(), cfVar.qdE.getPid()), cfVar.qdq);
            cfVar.eKp();
        } else if (!cfVar.m79b() || !cfVar.c() || !cfVar.java()) {
        } else {
            cfVar.qdM = false;
            cfVar.eKp();
        }
    }

    public void destroy() {
        cf cfVar = this.qdn;
        cfVar.f14043a = false;
        cfVar.qdm = false;
        cfVar.qdM = false;
        if (cfVar.qes == null) {
            return;
        }
        cfVar.qes.eKq();
    }
}
