package com.qq.e.ads.dfa;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.qq.e.comm.a;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.DFA;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
public class GDTApkManager {

    /* renamed from: a  reason: collision with root package name */
    private DFA f11744a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f11745b;
    private boolean c = false;
    private AtomicInteger d = new AtomicInteger(0);
    private Context e;

    public GDTApkManager(final Context context, final IGDTApkListener iGDTApkListener) {
        this.f11745b = false;
        if (!GDTADManager.getInstance().isInitialized()) {
            GDTLogger.e("SDK 尚未初始化，请在 Application 中调用 GDTADManager.getInstance().initWith() 初始化");
            return;
        }
        final String appid = GDTADManager.getInstance().getAppStatus().getAPPID();
        if (StringUtil.isEmpty(appid) || context == null || iGDTApkListener == null) {
            GDTLogger.e(String.format("GDTApkManager Constructor params error, appid=%s,context=%s,listener=%s", appid, context, iGDTApkListener));
        } else if (!a.a(context)) {
            GDTLogger.e("Required Activity/Service/Permission Not Declared in AndroidManifest.xml");
        } else {
            this.f11745b = true;
            this.e = context;
            GDTADManager.INIT_EXECUTOR.execute(new Runnable() { // from class: com.qq.e.ads.dfa.GDTApkManager.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!GDTADManager.getInstance().initWith(context, appid)) {
                        GDTLogger.e("Fail to init ADManager");
                        return;
                    }
                    try {
                        final POFactory pOFactory = GDTADManager.getInstance().getPM().getPOFactory();
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.qq.e.ads.dfa.GDTApkManager.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    if (pOFactory != null) {
                                        GDTApkManager.this.f11744a = GDTADManager.getInstance().getPM().getPOFactory().getGDTApkDelegate(iGDTApkListener);
                                        GDTApkManager.this.c = true;
                                        while (GDTApkManager.this.d.getAndDecrement() > 0) {
                                            GDTApkManager.this.loadGDTApk();
                                        }
                                    }
                                } catch (Throwable th) {
                                    try {
                                        GDTLogger.e("Exception while init UnifiedBannerView Core", th);
                                    } finally {
                                        GDTApkManager.this.c = true;
                                    }
                                }
                            }
                        });
                    } catch (Throwable th) {
                        GDTLogger.e("Exception while init UnifiedBannerView plugin", th);
                    }
                }
            });
        }
    }

    public final void loadGDTApk() {
        if (!this.f11745b) {
            GDTLogger.e("GDTApkManager init Context error,See More logs while new GDTApkManager");
        } else if (!this.c) {
            this.d.incrementAndGet();
        } else if (this.f11744a != null) {
            this.f11744a.loadGDTApk();
        } else {
            GDTLogger.e("InterstitialAD Init error,See More Logs");
        }
    }

    public final void startInstall(GDTApk gDTApk) {
        if (this.f11744a != null) {
            this.f11744a.startInstall(this.e, gDTApk);
        }
    }
}
