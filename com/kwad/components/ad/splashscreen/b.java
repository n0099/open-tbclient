package com.kwad.components.ad.splashscreen;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.core.k.kwai.a;
import com.kwad.components.core.m.m;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.components.splash.SplashPreloadManager;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bd;
/* loaded from: classes9.dex */
public final class b {
    public static final Handler mHandler = new Handler(Looper.getMainLooper());

    /* loaded from: classes9.dex */
    public static class a {
        public volatile boolean xr;

        public a() {
            this.xr = false;
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0616b {
        public volatile boolean xs;

        public C0616b() {
            this.xs = false;
        }

        public /* synthetic */ C0616b(byte b) {
            this();
        }

        public static /* synthetic */ boolean a(C0616b c0616b, boolean z) {
            c0616b.xs = true;
            return true;
        }
    }

    public static void a(KsScene ksScene) {
        com.kwad.components.core.j.a.og().oi();
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        com.kwad.components.splash.monitor.a.qG();
        com.kwad.components.splash.monitor.a.qI();
        ksScene.setAdStyle(4);
        ksScene.setAdNum(5);
        com.kwad.sdk.core.e.b.d("KsAdSplashScreenLoadManager", "loadSplashScreenCache ");
        KsAdLoadManager.ab();
        KsAdLoadManager.a(new a.C0636a().c(new com.kwad.components.core.k.kwai.b(ksScene)).ax(false).a(new com.kwad.components.core.k.c() { // from class: com.kwad.components.ad.splashscreen.b.4
            @Override // com.kwad.components.core.k.c, com.kwad.components.core.k.g
            public final void a(@NonNull AdResultData adResultData) {
                if (adResultData.getAdTemplateList().size() > 0) {
                    int b = SplashPreloadManager.qD().b(adResultData, false);
                    com.kwad.sdk.core.e.b.d("KsAdSplashScreenLoadManager", "loadSplashScreenCache onSuccess:" + adResultData.getAdTemplateList().size() + " saved " + b);
                    com.kwad.components.splash.monitor.a.qG().b(adResultData.getAdTemplateList(), SystemClock.elapsedRealtime() - elapsedRealtime);
                    com.kwad.components.core.j.a.og().an(adResultData.getAdTemplateList().size());
                }
            }

            @Override // com.kwad.components.core.k.c, com.kwad.components.core.k.g
            public final void onError(int i, String str) {
                com.kwad.components.splash.monitor.a.qG();
                com.kwad.components.splash.monitor.a.f(i, str);
                com.kwad.sdk.core.e.b.d("KsAdSplashScreenLoadManager", "loadSplashScreenCache onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
            }
        }).oo());
    }

    public static void loadSplashScreenAd(@NonNull final KsScene ksScene, @NonNull final KsLoadManager.SplashScreenAdListener splashScreenAdListener) {
        boolean a2 = m.oF().a(ksScene, "loadSplashScreenAd");
        ksScene.setAdStyle(4);
        ksScene.setAdNum(1);
        com.kwad.sdk.core.e.b.d("KsAdSplashScreenLoadManager", "loadSplashScreenAd ");
        final a aVar = new a((byte) 0);
        aVar.xr = false;
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        com.kwad.components.core.k.kwai.b bVar = new com.kwad.components.core.k.kwai.b(ksScene);
        final C0616b c0616b = new C0616b((byte) 0);
        com.kwad.components.core.j.a.og().oh();
        mHandler.postDelayed(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.1
            @Override // java.lang.Runnable
            public final void run() {
                b.a(KsScene.this);
            }
        }, 15000L);
        final Runnable runnable = new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.2
            @Override // java.lang.Runnable
            public final void run() {
                C0616b.a(C0616b.this, true);
                com.kwad.sdk.core.e.b.d("KsAdSplashScreenLoadManager", "loadSplashAd mTimeOutRunnable timeOut");
                KsLoadManager.SplashScreenAdListener splashScreenAdListener2 = splashScreenAdListener;
                com.kwad.sdk.core.network.f fVar = com.kwad.sdk.core.network.f.Yf;
                splashScreenAdListener2.onError(fVar.errorCode, fVar.Qd);
                com.kwad.components.splash.monitor.a.qG();
                com.kwad.sdk.core.network.f fVar2 = com.kwad.sdk.core.network.f.Yf;
                com.kwad.components.splash.monitor.a.a("", false, fVar2.errorCode, fVar2.Qd);
                com.kwad.components.core.j.a.og().am(4);
            }
        };
        mHandler.postDelayed(runnable, com.kwad.components.ad.splashscreen.a.b.jK());
        com.kwad.components.splash.monitor.a.qG();
        com.kwad.components.splash.monitor.a.qH();
        KsAdLoadManager.ab();
        KsAdLoadManager.a(new a.C0636a().c(bVar).aw(true).ax(a2).a(new com.kwad.components.core.k.c() { // from class: com.kwad.components.ad.splashscreen.b.3
            @Override // com.kwad.components.core.k.c, com.kwad.components.core.k.b
            public final void a(final int i, final String str, boolean z) {
                if (C0616b.this.xs) {
                    com.kwad.sdk.core.e.b.d("KsAdSplashScreenLoadManager", "loadSplashAd onError isTimeOut return " + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
                    return;
                }
                b.mHandler.removeCallbacks(runnable);
                if (!aVar.xr) {
                    com.kwad.components.splash.monitor.a.qG();
                    com.kwad.components.splash.monitor.a.a("", z, i, str);
                }
                bd.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.3.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.kwad.sdk.core.e.b.d("KsAdSplashScreenLoadManager", "loadSplashAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
                        splashScreenAdListener.onError(i, str);
                        if (i == com.kwad.sdk.core.network.f.Yg.errorCode) {
                            com.kwad.components.core.j.a.og().am(0);
                        } else {
                            com.kwad.components.core.j.a.og().am(3);
                        }
                    }
                });
            }

            @Override // com.kwad.components.core.k.c, com.kwad.components.core.k.b
            public final void a(@NonNull final AdResultData adResultData, boolean z) {
                bd.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.3.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            splashScreenAdListener.onRequestResult(adResultData.getAdTemplateList().size());
                        } catch (Throwable th) {
                            com.kwad.sdk.core.e.b.printStackTraceOnly(th);
                        }
                    }
                });
                if (adResultData.getAdTemplateList().size() <= 0) {
                    if (C0616b.this.xs) {
                        com.kwad.sdk.core.e.b.d("KsAdSplashScreenLoadManager", "loadSplashAd isTimeOut return ");
                        return;
                    }
                    b.mHandler.removeCallbacks(runnable);
                    com.kwad.components.splash.monitor.a.qG();
                    com.kwad.components.splash.monitor.a.l("", 6);
                    com.kwad.components.splash.monitor.a.qG();
                    com.kwad.sdk.core.network.f fVar = com.kwad.sdk.core.network.f.Yd;
                    com.kwad.components.splash.monitor.a.a("", z, fVar.errorCode, fVar.Qd);
                    aVar.xr = true;
                    com.kwad.sdk.core.network.f fVar2 = com.kwad.sdk.core.network.f.Yd;
                    a(fVar2.errorCode, fVar2.Qd, z);
                    com.kwad.components.core.j.a.og().am(3);
                    return;
                }
                AdTemplate adTemplate = adResultData.getAdTemplateList().get(0);
                adTemplate.loadDataTime = SystemClock.elapsedRealtime() - elapsedRealtime;
                adTemplate.notNetworkRequest = z;
                String az = com.kwad.sdk.core.response.a.a.az(com.kwad.sdk.core.response.a.d.bQ(adTemplate));
                com.kwad.components.splash.monitor.a.qG().U(adTemplate);
                com.kwad.components.splash.monitor.a.qG();
                com.kwad.components.splash.monitor.a.l(az, 1);
                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                final KsSplashScreenAdControl ksSplashScreenAdControl = new KsSplashScreenAdControl(ksScene, adResultData);
                boolean f = SplashPreloadManager.qD().f(adResultData);
                com.kwad.sdk.core.e.b.d("KsAdSplashScreenLoadManager", "loadSplashAd onSuccess " + f);
                if (!f) {
                    SplashPreloadManager.qD();
                    if (!SplashPreloadManager.g(adResultData)) {
                        if (C0616b.this.xs) {
                            com.kwad.sdk.core.e.b.d("KsAdSplashScreenLoadManager", "loadSplashAd isTimeOut return ");
                            return;
                        }
                        b.mHandler.removeCallbacks(runnable);
                        com.kwad.components.splash.monitor.a.qG();
                        com.kwad.components.splash.monitor.a.l(az, 5);
                        com.kwad.components.splash.monitor.a.qG();
                        com.kwad.sdk.core.network.f fVar3 = com.kwad.sdk.core.network.f.Ye;
                        com.kwad.components.splash.monitor.a.a(az, z, fVar3.errorCode, fVar3.Qd);
                        aVar.xr = true;
                        a(com.kwad.sdk.core.network.f.Ye.errorCode, "请求成功，但缓存未命中", z);
                        com.kwad.sdk.core.e.b.d("KsAdSplashScreenLoadManager", "loadSplashAd no cache returned");
                        com.kwad.components.core.j.a.og().am(3);
                        return;
                    }
                    com.kwad.sdk.core.e.b.d("KsAdSplashScreenLoadManager", "loadSplashAd image returned");
                    int b = SplashPreloadManager.qD().b(adResultData, true);
                    if (!C0616b.this.xs) {
                        b.mHandler.removeCallbacks(runnable);
                        if (b > 0) {
                            bd.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.3.4
                                @Override // java.lang.Runnable
                                public final void run() {
                                    try {
                                        KsAdLoadManager.ab().a((KsAdLoadManager) ksSplashScreenAdControl);
                                        splashScreenAdListener.onSplashScreenAdLoad(ksSplashScreenAdControl);
                                    } catch (Throwable th) {
                                        com.kwad.sdk.core.e.b.printStackTrace(th);
                                    }
                                }
                            });
                            adTemplate.checkDataTime = SystemClock.elapsedRealtime() - elapsedRealtime2;
                            com.kwad.components.splash.monitor.a.qG();
                            com.kwad.components.splash.monitor.a.l(az, 3);
                            com.kwad.components.splash.monitor.a.qG().V(adTemplate);
                            com.kwad.components.core.j.a.og().am(2);
                            return;
                        }
                        com.kwad.components.splash.monitor.a.qG();
                        com.kwad.sdk.core.network.f fVar4 = com.kwad.sdk.core.network.f.Yg;
                        com.kwad.components.splash.monitor.a.a(az, z, fVar4.errorCode, fVar4.Qd);
                        com.kwad.components.splash.monitor.a.qG();
                        com.kwad.components.splash.monitor.a.l(az, 4);
                        aVar.xr = true;
                        com.kwad.sdk.core.network.f fVar5 = com.kwad.sdk.core.network.f.Yg;
                        a(fVar5.errorCode, fVar5.Qd, z);
                        return;
                    }
                } else if (!C0616b.this.xs) {
                    b.mHandler.removeCallbacks(runnable);
                    com.kwad.components.splash.monitor.a.qG();
                    com.kwad.components.splash.monitor.a.l(az, 2);
                    bd.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.3.3
                        @Override // java.lang.Runnable
                        public final void run() {
                            try {
                                KsAdLoadManager.ab().a((KsAdLoadManager) ksSplashScreenAdControl);
                                splashScreenAdListener.onSplashScreenAdLoad(ksSplashScreenAdControl);
                            } catch (Throwable th) {
                                com.kwad.sdk.core.e.b.printStackTrace(th);
                            }
                        }
                    });
                    adTemplate.checkDataTime = SystemClock.elapsedRealtime() - elapsedRealtime2;
                    com.kwad.components.splash.monitor.a.qG().V(adTemplate);
                    com.kwad.sdk.core.e.b.d("KsAdSplashScreenLoadManager", "loadSplashAd cache returned");
                    com.kwad.components.core.j.a.og().am(1);
                    return;
                }
                com.kwad.components.splash.monitor.a.qG();
                com.kwad.components.splash.monitor.a.l(az, 7);
                com.kwad.sdk.core.e.b.d("KsAdSplashScreenLoadManager", "loadSplashAd isTimeOut return ");
            }
        }).oo());
    }
}
