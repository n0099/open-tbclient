package com.qq.e.comm.plugin.intersitial2;

import android.app.Activity;
import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.interstitial2.UnifiedInterstitialADListener;
import com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener;
import com.qq.e.comm.pi.UIADI;
import com.qq.e.comm.plugin.util.ad;
import com.qq.e.comm.util.AdError;
import com.qq.e.mediation.interfaces.BaseInterstitialAd;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes15.dex */
class f extends com.qq.e.comm.plugin.r.a.a<BaseInterstitialAd> implements UIADI {
    private UnifiedInterstitialADListener d;
    private BaseInterstitialAd e;
    private Activity f;
    private boolean g;
    private DownAPPConfirmPolicy h;
    private VideoOption i;
    private int j;
    private int k;
    private int l;
    private UnifiedInterstitialMediaListener m;
    private Set<BaseInterstitialAd> n;
    private ad o;

    public f(Activity activity, String str, String str2, UnifiedInterstitialADListener unifiedInterstitialADListener) {
        super(activity, str2);
        this.h = null;
        this.i = null;
        this.j = -1;
        this.k = -1;
        this.l = -1;
        this.n = new HashSet();
        this.o = new ad();
        this.d = unifiedInterstitialADListener;
        this.f = activity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (this.d != null) {
            this.d.onADReceive();
        }
        if (this.e != null) {
            this.e.setMediaListener(this.m);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.r.a.a
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public int b(final BaseInterstitialAd baseInterstitialAd) {
        final long currentTimeMillis = System.currentTimeMillis();
        baseInterstitialAd.setAdListener(new UnifiedInterstitialADListener() { // from class: com.qq.e.comm.plugin.intersitial2.f.1
            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADClicked() {
                if (baseInterstitialAd != f.this.e || f.this.d == null) {
                    return;
                }
                f.this.a((f) baseInterstitialAd, 70442);
                f.this.d.onADClicked();
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADClosed() {
                f.this.o.a();
                if (baseInterstitialAd != f.this.e || f.this.d == null) {
                    return;
                }
                f.this.d.onADClosed();
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADExposure() {
                if (baseInterstitialAd != f.this.e || f.this.d == null) {
                    return;
                }
                f.this.b((f) baseInterstitialAd, 70432);
                f.this.d.onADExposure();
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADLeftApplication() {
                if (baseInterstitialAd != f.this.e || f.this.d == null) {
                    return;
                }
                f.this.d.onADLeftApplication();
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADOpened() {
                if (baseInterstitialAd != f.this.e || f.this.d == null) {
                    return;
                }
                f.this.d.onADOpened();
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADReceive() {
                boolean z;
                int i;
                long currentTimeMillis2 = System.currentTimeMillis();
                int ecpm = baseInterstitialAd.getECPM();
                if (baseInterstitialAd instanceof com.qq.e.comm.plugin.r.a) {
                    i = ecpm <= 0 ? ((com.qq.e.comm.plugin.r.a) baseInterstitialAd).getMediationPrice() : ecpm;
                    z = ((com.qq.e.comm.plugin.r.a) baseInterstitialAd).isContractAd();
                } else {
                    z = false;
                    i = ecpm;
                }
                f.this.a((f) baseInterstitialAd, i, z, baseInterstitialAd.getAdapterPriority());
                f.this.a((f) baseInterstitialAd, currentTimeMillis2 - currentTimeMillis, true, 70412);
                if (f.this.i() && f.this.d((f) baseInterstitialAd) && !f.this.j()) {
                    f.this.h();
                    f.this.e = baseInterstitialAd;
                    f.this.l();
                }
                f.this.g = false;
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onNoAD(AdError adError) {
                f.this.a((f) baseInterstitialAd, System.currentTimeMillis() - currentTimeMillis, false, 70422);
                if (f.this.i() && f.this.c((f) baseInterstitialAd) && !f.this.b()) {
                    f.this.a();
                }
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onVideoCached() {
                if (baseInterstitialAd == f.this.e && f.this.d != null) {
                    f.this.d.onVideoCached();
                }
                f.this.n.add(baseInterstitialAd);
            }
        });
        if (this.i != null) {
            baseInterstitialAd.setVideoOption(this.i);
        }
        if (this.l >= 0) {
            baseInterstitialAd.setVideoPlayPolicy(this.l);
        }
        if (this.j > 0) {
            baseInterstitialAd.setMinVideoDuration(this.j);
        }
        if (this.k > 0) {
            baseInterstitialAd.setMaxVideoDuration(this.k);
        }
        if (this.h != null) {
            baseInterstitialAd.setDownAPPConfirmPolicy(this.h);
        }
        baseInterstitialAd.loadAd();
        return 70402;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.r.a.a
    /* renamed from: a */
    public BaseInterstitialAd b(com.qq.e.comm.plugin.r.b.c cVar) {
        if (cVar != null) {
            try {
                return b.a(cVar.e(), this.f, cVar.b(), cVar.g());
            } catch (Exception e) {
                a(70452, cVar);
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override // com.qq.e.comm.plugin.r.a.a
    protected void a() {
        if (this.d != null) {
            this.d.onNoAD(new AdError(5004, "No AD"));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.r.a.a
    /* renamed from: b  reason: avoid collision after fix types in other method */
    public void a(BaseInterstitialAd baseInterstitialAd) {
        this.e = baseInterstitialAd;
        if (this.e == null) {
            a();
            return;
        }
        l();
        if (!this.n.contains(this.e) || this.d == null) {
            return;
        }
        this.d.onVideoCached();
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void close() {
        this.o.a();
        if (this.e != null) {
            this.e.close();
        }
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void destory() {
        if (this.e != null) {
            this.e.destory();
        }
    }

    @Override // com.qq.e.comm.pi.UIADI
    public String getAdNetWorkName() {
        return k();
    }

    @Override // com.qq.e.comm.pi.UIADI
    public int getAdPatternType() {
        if (this.e != null) {
            this.e.getAdPatternType();
            return 0;
        }
        return 0;
    }

    @Override // com.qq.e.comm.pi.UIADI
    public int getECPM() {
        if (this.e != null) {
            return this.e.getECPM();
        }
        return -1;
    }

    @Override // com.qq.e.comm.pi.UIADI
    public String getECPMLevel() {
        if (this.e != null) {
            return this.e.getECPMLevel();
        }
        return null;
    }

    @Override // com.qq.e.comm.pi.UIADI
    public boolean isValid() {
        if (this.e != null) {
            return this.e.isValid();
        }
        return false;
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void loadAd() {
        c();
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void loadFullScreenAD() {
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void setDownAPPConfirmPolicy(DownAPPConfirmPolicy downAPPConfirmPolicy) {
        this.h = downAPPConfirmPolicy;
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void setMaxVideoDuration(int i) {
        this.k = i;
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void setMediaListener(UnifiedInterstitialMediaListener unifiedInterstitialMediaListener) {
        this.m = unifiedInterstitialMediaListener;
        if (this.e != null) {
            this.e.setMediaListener(unifiedInterstitialMediaListener);
        }
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void setMinVideoDuration(int i) {
        this.j = i;
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void setVideoOption(VideoOption videoOption) {
        this.i = videoOption;
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void setVideoPlayPolicy(int i) {
        this.l = i;
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void show() {
        if (this.g) {
            return;
        }
        this.o.a(this.f);
        if (this.e != null) {
            this.e.show();
        }
        this.g = true;
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void show(Activity activity) {
        if (this.g) {
            return;
        }
        this.o.a(activity);
        if (this.e != null) {
            this.e.show(activity);
        }
        this.g = true;
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void showAsPopupWindow() {
        if (this.g) {
            return;
        }
        this.o.a(this.f);
        if (this.e != null) {
            this.e.showAsPopupWindow();
        }
        this.g = true;
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void showAsPopupWindow(Activity activity) {
        if (this.g) {
            return;
        }
        this.o.a(activity);
        if (this.e != null) {
            this.e.showAsPopupWindow(activity);
        }
        this.g = true;
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void showFullScreenAD(Activity activity) {
        this.o.a(activity);
    }
}
