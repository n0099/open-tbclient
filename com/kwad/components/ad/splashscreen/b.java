package com.kwad.components.ad.splashscreen;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.core.request.model.a;
import com.kwad.components.core.s.m;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bn;
/* loaded from: classes10.dex */
public final class b {
    public static final Handler fS = new Handler(Looper.getMainLooper());

    /* loaded from: classes10.dex */
    public static class a {
        public volatile boolean BZ;

        public a() {
            this.BZ = false;
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0620b {
        public volatile boolean Ca;

        public C0620b() {
            this.Ca = false;
        }

        public /* synthetic */ C0620b(byte b) {
            this();
        }

        public static /* synthetic */ boolean a(C0620b c0620b, boolean z) {
            c0620b.Ca = true;
            return true;
        }
    }

    public static void a(ImpInfo impInfo) {
        final SceneImpl sceneImpl = impInfo.adScene;
        if (TextUtils.isEmpty(sceneImpl.getBidResponse()) && TextUtils.isEmpty(sceneImpl.getBidResponseV2())) {
            com.kwad.components.core.o.a.pX().qa();
            final long elapsedRealtime = SystemClock.elapsedRealtime();
            com.kwad.components.ad.splashscreen.monitor.b.kO();
            com.kwad.components.ad.splashscreen.monitor.b.q(sceneImpl.posId);
            sceneImpl.setAdStyle(4);
            sceneImpl.setAdNum(5);
            ImpInfo impInfo2 = new ImpInfo(sceneImpl);
            com.kwad.sdk.core.e.c.d("KsAdSplashScreenLoadManager", "loadSplashScreenCache ");
            KsAdLoadManager.M();
            KsAdLoadManager.a(new a.C0661a().e(impInfo2).aI(false).a(new com.kwad.components.core.request.d() { // from class: com.kwad.components.ad.splashscreen.b.5
                @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.k
                public final void a(@NonNull AdResultData adResultData) {
                    if (adResultData.getAdTemplateList().size() > 0) {
                        int b = SplashPreloadManager.kw().b(adResultData, false);
                        com.kwad.sdk.core.e.c.d("KsAdSplashScreenLoadManager", "loadSplashScreenCache onSuccess:" + adResultData.getAdTemplateList().size() + " saved " + b);
                        com.kwad.components.ad.splashscreen.monitor.b.kO();
                        com.kwad.components.ad.splashscreen.monitor.b.a(adResultData.getAdTemplateList(), SystemClock.elapsedRealtime() - elapsedRealtime, SceneImpl.this.getPosId());
                        com.kwad.components.core.o.a.pX().aA(adResultData.getAdTemplateList().size());
                    }
                }

                @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.k
                public final void onError(int i, String str) {
                    com.kwad.components.ad.splashscreen.monitor.b.kO();
                    com.kwad.components.ad.splashscreen.monitor.b.b(i, str, SceneImpl.this.getPosId());
                    com.kwad.sdk.core.e.c.d("KsAdSplashScreenLoadManager", "loadSplashScreenCache onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
                }
            }).ql());
        }
    }

    public static void a(final KsLoadManager.SplashScreenAdListener splashScreenAdListener, final KsSplashScreenAd ksSplashScreenAd, final AdTemplate adTemplate) {
        bn.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.4
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    KsAdLoadManager.M().a((KsAdLoadManager) KsSplashScreenAd.this);
                    splashScreenAdListener.onSplashScreenAdLoad(KsSplashScreenAd.this);
                    com.kwad.components.ad.splashscreen.monitor.a.kM().X(adTemplate);
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTrace(th);
                }
            }
        });
    }

    public static boolean a(C0620b c0620b, AdTemplate adTemplate, long j, long j2, Runnable runnable) {
        if (c0620b.Ca) {
            com.kwad.components.ad.splashscreen.monitor.b.kO();
            com.kwad.components.ad.splashscreen.monitor.b.b(adTemplate, 7, j, j2);
            com.kwad.sdk.core.e.c.d("KsAdSplashScreenLoadManager", "loadSplashAd isTimeOut return ");
            return true;
        }
        fS.removeCallbacks(runnable);
        return false;
    }

    public static boolean a(AdResultData adResultData, a aVar, com.kwad.components.core.request.d dVar, boolean z, long j) {
        String str;
        String str2;
        if (adResultData.getAdTemplateList().size() == 0) {
            com.kwad.components.ad.splashscreen.monitor.b.kO();
            int i = com.kwad.sdk.core.network.e.ats.errorCode;
            if (TextUtils.isEmpty(adResultData.testErrorMsg)) {
                str = com.kwad.sdk.core.network.e.ats.msg;
            } else {
                str = adResultData.testErrorMsg;
            }
            com.kwad.components.ad.splashscreen.monitor.b.c(z, i, str, j);
            aVar.BZ = true;
            int i2 = com.kwad.sdk.core.network.e.ats.errorCode;
            if (TextUtils.isEmpty(adResultData.testErrorMsg)) {
                str2 = com.kwad.sdk.core.network.e.ats.msg;
            } else {
                str2 = adResultData.testErrorMsg;
            }
            dVar.a(i2, str2, z);
            com.kwad.components.core.o.a.pX().az(3);
            return true;
        }
        return false;
    }

    public static void loadSplashScreenAd(@NonNull KsScene ksScene, @NonNull final KsLoadManager.SplashScreenAdListener splashScreenAdListener) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        final SceneImpl covert = SceneImpl.covert(ksScene);
        com.kwad.components.ad.splashscreen.monitor.b.kO();
        com.kwad.components.ad.splashscreen.monitor.b.p(covert.getPosId());
        boolean a2 = m.qR().a(covert, "loadSplashScreenAd");
        covert.setAdStyle(4);
        covert.setAdNum(1);
        com.kwad.sdk.core.e.c.d("KsAdSplashScreenLoadManager", "loadSplashScreenAd ");
        final a aVar = new a((byte) 0);
        aVar.BZ = false;
        final long elapsedRealtime2 = SystemClock.elapsedRealtime();
        final ImpInfo impInfo = new ImpInfo(covert);
        final C0620b c0620b = new C0620b((byte) 0);
        com.kwad.components.core.o.a.pX().pZ();
        fS.postDelayed(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.1
            @Override // java.lang.Runnable
            public final void run() {
                b.a(ImpInfo.this);
            }
        }, 15000L);
        final Runnable runnable = new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.2
            @Override // java.lang.Runnable
            public final void run() {
                C0620b.a(C0620b.this, true);
                com.kwad.sdk.core.e.c.d("KsAdSplashScreenLoadManager", "loadSplashAd mTimeOutRunnable timeOut");
                KsLoadManager.SplashScreenAdListener splashScreenAdListener2 = splashScreenAdListener;
                com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.atu;
                splashScreenAdListener2.onError(eVar.errorCode, eVar.msg);
                com.kwad.components.ad.splashscreen.monitor.b.kO();
                com.kwad.sdk.core.network.e eVar2 = com.kwad.sdk.core.network.e.atu;
                com.kwad.components.ad.splashscreen.monitor.b.c(false, eVar2.errorCode, eVar2.msg, covert.getPosId());
                com.kwad.components.core.o.a.pX().az(4);
            }
        };
        int a3 = com.kwad.sdk.core.config.d.a(com.kwad.components.ad.splashscreen.b.a.CL);
        if (a3 < 0) {
            a3 = 5000;
        }
        fS.postDelayed(runnable, a3);
        final long elapsedRealtime3 = SystemClock.elapsedRealtime() - elapsedRealtime;
        com.kwad.components.ad.splashscreen.monitor.b.kO();
        com.kwad.components.ad.splashscreen.monitor.b.f(covert.getPosId(), elapsedRealtime3);
        KsAdLoadManager.M();
        KsAdLoadManager.a(new a.C0661a().e(impInfo).aH(true).aI(a2).a(new com.kwad.components.core.request.d() { // from class: com.kwad.components.ad.splashscreen.b.3
            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.c
            public final void a(final int i, final String str, boolean z) {
                if (C0620b.this.Ca) {
                    com.kwad.sdk.core.e.c.d("KsAdSplashScreenLoadManager", "loadSplashAd onError isTimeOut return " + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
                    return;
                }
                b.fS.removeCallbacks(runnable);
                if (!aVar.BZ && i != com.kwad.sdk.core.network.e.ats.errorCode) {
                    com.kwad.components.ad.splashscreen.monitor.b.kO();
                    com.kwad.components.ad.splashscreen.monitor.b.b(z, i, str, covert.getPosId());
                    com.kwad.components.ad.splashscreen.monitor.b.kO();
                    com.kwad.components.ad.splashscreen.monitor.b.c(z, i, str, covert.getPosId());
                }
                bn.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.3.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.kwad.sdk.core.e.c.d("KsAdSplashScreenLoadManager", "loadSplashAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
                        splashScreenAdListener.onError(i, str);
                        if (i == com.kwad.sdk.core.network.e.atv.errorCode) {
                            com.kwad.components.core.o.a.pX().az(0);
                        } else {
                            com.kwad.components.core.o.a.pX().az(3);
                        }
                    }
                });
            }

            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.c
            public final void a(@NonNull final AdResultData adResultData, boolean z) {
                bn.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.3.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            splashScreenAdListener.onRequestResult(adResultData.getAdTemplateList().size());
                            com.kwad.components.ad.splashscreen.monitor.a.kM().o(covert.getPosId());
                        } catch (Throwable th) {
                            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                        }
                    }
                });
                if (b.a(adResultData, aVar, this, z, covert.posId)) {
                    return;
                }
                AdTemplate adTemplate = adResultData.getAdTemplateList().get(0);
                adTemplate.loadDataTime = SystemClock.elapsedRealtime() - elapsedRealtime2;
                adTemplate.notNetworkRequest = z;
                com.kwad.components.ad.splashscreen.monitor.b.kO();
                com.kwad.components.ad.splashscreen.monitor.b.d(adTemplate, elapsedRealtime3);
                com.kwad.sdk.commercial.e.c.j(adTemplate, 1);
                long elapsedRealtime4 = SystemClock.elapsedRealtime();
                KsSplashScreenAdControl ksSplashScreenAdControl = new KsSplashScreenAdControl(covert, adResultData);
                if (com.kwad.sdk.core.config.d.a(com.kwad.components.ad.splashscreen.b.a.CP)) {
                    SplashPreloadManager.kw();
                    if (SplashPreloadManager.f(adResultData)) {
                        if (!b.a(C0620b.this, adTemplate, elapsedRealtime4, elapsedRealtime3, runnable)) {
                            b.a(splashScreenAdListener, ksSplashScreenAdControl, adTemplate);
                            if (SplashPreloadManager.kw().e(adResultData)) {
                                com.kwad.components.ad.splashscreen.monitor.b.kO();
                                com.kwad.components.ad.splashscreen.monitor.b.a(adTemplate, 2, elapsedRealtime4, elapsedRealtime3);
                                com.kwad.sdk.core.e.c.d("KsAdSplashScreenLoadManager", "loadSplashAd cache returned");
                                com.kwad.components.core.o.a.pX().az(1);
                                return;
                            } else if (SplashPreloadManager.kw().b(adResultData, true) > 0) {
                                com.kwad.components.ad.splashscreen.monitor.b.kO();
                                com.kwad.components.ad.splashscreen.monitor.b.a(adTemplate, 3, elapsedRealtime4, elapsedRealtime3);
                                com.kwad.components.core.o.a.pX().az(2);
                                return;
                            } else {
                                com.kwad.components.ad.splashscreen.monitor.b.kO();
                                com.kwad.components.ad.splashscreen.monitor.b.b(adTemplate, 4, elapsedRealtime4, elapsedRealtime3);
                                return;
                            }
                        }
                        return;
                    }
                }
                boolean e = SplashPreloadManager.kw().e(adResultData);
                com.kwad.sdk.core.e.c.d("KsAdSplashScreenLoadManager", "loadSplashAd onSuccess " + e);
                if (e) {
                    if (!b.a(C0620b.this, adTemplate, elapsedRealtime4, elapsedRealtime3, runnable)) {
                        b.a(splashScreenAdListener, ksSplashScreenAdControl, adTemplate);
                        com.kwad.components.ad.splashscreen.monitor.b.kO();
                        com.kwad.components.ad.splashscreen.monitor.b.a(adTemplate, 2, elapsedRealtime4, elapsedRealtime3);
                        com.kwad.sdk.core.e.c.d("KsAdSplashScreenLoadManager", "loadSplashAd cache returned");
                        com.kwad.components.core.o.a.pX().az(1);
                        return;
                    }
                    return;
                }
                SplashPreloadManager.kw();
                if (SplashPreloadManager.f(adResultData)) {
                    com.kwad.sdk.core.e.c.d("KsAdSplashScreenLoadManager", "loadSplashAd image returned");
                    int b = SplashPreloadManager.kw().b(adResultData, true);
                    if (b.a(C0620b.this, adTemplate, elapsedRealtime4, elapsedRealtime3, runnable)) {
                        return;
                    }
                    if (b > 0) {
                        b.a(splashScreenAdListener, ksSplashScreenAdControl, adTemplate);
                        com.kwad.components.ad.splashscreen.monitor.b.kO();
                        com.kwad.components.ad.splashscreen.monitor.b.a(adTemplate, 3, elapsedRealtime4, elapsedRealtime3);
                        com.kwad.components.core.o.a.pX().az(2);
                        return;
                    }
                    com.kwad.components.ad.splashscreen.monitor.b.kO();
                    com.kwad.components.ad.splashscreen.monitor.b.b(adTemplate, 4, elapsedRealtime4, elapsedRealtime3);
                    aVar.BZ = true;
                    com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.atv;
                    a(eVar.errorCode, eVar.msg, z);
                } else if (C0620b.this.Ca) {
                    com.kwad.sdk.core.e.c.d("KsAdSplashScreenLoadManager", "loadSplashAd isTimeOut return ");
                } else {
                    b.fS.removeCallbacks(runnable);
                    com.kwad.components.ad.splashscreen.monitor.b.kO();
                    com.kwad.components.ad.splashscreen.monitor.b.b(adTemplate, 5, elapsedRealtime4, elapsedRealtime3);
                    aVar.BZ = true;
                    a(com.kwad.sdk.core.network.e.att.errorCode, "请求成功，但缓存未命中", z);
                    com.kwad.sdk.core.e.c.d("KsAdSplashScreenLoadManager", "loadSplashAd no cache returned");
                    com.kwad.components.core.o.a.pX().az(3);
                }
            }
        }).ql());
    }
}
