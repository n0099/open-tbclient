package com.win.opensdk;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.win.opensdk.core.Info;
/* loaded from: classes3.dex */
public class PBInterstitial {
    private String java;
    private cf qjr;
    private PBInterstitialListener qjs;

    public PBInterstitial(@NonNull Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        this.java = str;
        this.qjr = new cf(applicationContext, str);
        this.qjr.qjs = new PBInterstitialListener() { // from class: com.win.opensdk.PBInterstitial.1
            @Override // com.win.opensdk.PBInterstitialListener
            public final void onInterstitialDismissed() {
                if (PBInterstitial.this.qjs != null) {
                    PBInterstitial.this.qjs.onInterstitialDismissed();
                }
            }

            @Override // com.win.opensdk.PBInterstitialListener
            public final void onInterstitialDisplayed() {
                if (PBInterstitial.this.qjs != null) {
                    PBInterstitial.this.qjs.onInterstitialDisplayed();
                }
            }

            @Override // com.win.opensdk.PBInterstitialListener
            public final void onInterstitialShowFail(String str2) {
                if (PBInterstitial.this.qjs != null) {
                    PBInterstitial.this.qjs.onInterstitialShowFail(str2);
                }
            }

            @Override // com.win.opensdk.PBListener
            public final void onFail(PBError pBError) {
                if (PBInterstitial.this.qjs != null) {
                    PBInterstitial.this.qjs.onFail(pBError);
                }
            }

            @Override // com.win.opensdk.PBListener
            public final void onLoaded() {
                if (PBInterstitial.this.qjs != null) {
                    PBInterstitial.this.qjs.onLoaded();
                }
            }

            @Override // com.win.opensdk.PBListener
            public final void onClicked() {
                if (PBInterstitial.this.qjs != null) {
                    PBInterstitial.this.qjs.onClicked();
                }
            }
        };
    }

    public String getPid() {
        return this.java;
    }

    public void load() {
        final cf cfVar = this.qjr;
        if (cfVar.java() && cfVar.qjI.isEffective() && !cfVar.qjI.isShown()) {
            cfVar.a(cfVar.qjI);
            return;
        }
        if (cfVar.qkw == null) {
            cfVar.qkw = new ad(cfVar.qjn, cfVar.java, e.f54case);
        }
        cfVar.qkw.qkt = new ae<Info>() { // from class: com.win.opensdk.cf.2
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.win.opensdk.ae
            public final /* synthetic */ void bH(Info info) {
                cf.this.a(info);
            }

            @Override // com.win.opensdk.ae
            public final void b(PBError pBError) {
                cf.this.qjs.onFail(pBError);
            }
        };
        cfVar.qkw.eIX();
    }

    public void setInterstitialListener(PBInterstitialListener pBInterstitialListener) {
        this.qjs = pBInterstitialListener;
    }

    public boolean isReady() {
        cf cfVar = this.qjr;
        return cfVar.m73a() || cfVar.c();
    }

    public void show() {
        cf cfVar = this.qjr;
        if (!av.iM(cfVar.qjn)) {
            if (cfVar.qjs != null) {
                cfVar.qjs.onInterstitialShowFail(PBError.NO_NETWORK.getMsg());
            }
        } else if (az.iU(cfVar.qjn) == 1 && cfVar.qjI != null && !TextUtils.isEmpty(cfVar.qjI.getLoad()) && !TextUtils.isEmpty(az.m64c(cfVar.qjn)) && cfVar.qjI.getPid().equals(az.m64c(cfVar.qjn))) {
            aw.bH(cfVar.qjn, cfVar.qjI.getLoad());
            w.iN(cfVar.qjn).a(new x(cfVar.qjI)).eIX();
            if (cfVar.qjI != null) {
                az.l(cfVar.qjn, cfVar.qjI.getId() + ":" + System.currentTimeMillis(), false);
            }
            z.b(cfVar.qjI);
        } else if (cfVar.eJv()) {
            if (!cfVar.m73a() || !cfVar.java()) {
                return;
            }
            cfVar.qjq = false;
            bp.eJw().a(bp.aX(cfVar.qjI.getTraceid(), cfVar.qjI.getId(), cfVar.qjI.getPid()), cfVar.qju);
            cfVar.eIX();
        } else if (!cfVar.m74b() || !cfVar.c() || !cfVar.java()) {
        } else {
            cfVar.qjQ = false;
            cfVar.eIX();
        }
    }

    public void destroy() {
        cf cfVar = this.qjr;
        cfVar.f13745a = false;
        cfVar.qjq = false;
        cfVar.qjQ = false;
        if (cfVar.qkw == null) {
            return;
        }
        cfVar.qkw.eIY();
    }
}
