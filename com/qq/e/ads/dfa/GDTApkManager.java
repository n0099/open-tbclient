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
/* loaded from: classes6.dex */
public class GDTApkManager {

    /* renamed from: a  reason: collision with root package name */
    public DFA f38070a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f38071b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f38072c = false;

    /* renamed from: d  reason: collision with root package name */
    public AtomicInteger f38073d = new AtomicInteger(0);

    /* renamed from: e  reason: collision with root package name */
    public Context f38074e;

    public GDTApkManager(final Context context, final IGDTApkListener iGDTApkListener) {
        String str;
        this.f38071b = false;
        if (GDTADManager.getInstance().isInitialized()) {
            final String appid = GDTADManager.getInstance().getAppStatus().getAPPID();
            if (StringUtil.isEmpty(appid) || context == null || iGDTApkListener == null) {
                str = String.format("GDTApkManager Constructor params error, appid=%s,context=%s,listener=%s", appid, context, iGDTApkListener);
            } else if (a.a(context)) {
                this.f38071b = true;
                this.f38074e = context;
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
                                            GDTApkManager.this.f38070a = GDTADManager.getInstance().getPM().getPOFactory().getGDTApkDelegate(iGDTApkListener);
                                            GDTApkManager.this.f38072c = true;
                                            while (GDTApkManager.this.f38073d.getAndDecrement() > 0) {
                                                GDTApkManager.this.loadGDTApk();
                                            }
                                        }
                                    } finally {
                                        try {
                                        } finally {
                                        }
                                    }
                                }
                            });
                        } catch (Throwable th) {
                            GDTLogger.e("Exception while init UnifiedBannerView plugin", th);
                        }
                    }
                });
                return;
            } else {
                str = "Required Activity/Service/Permission Not Declared in AndroidManifest.xml";
            }
        } else {
            str = "SDK 尚未初始化，请在 Application 中调用 GDTADManager.getInstance().initWith() 初始化";
        }
        GDTLogger.e(str);
    }

    public final void loadGDTApk() {
        if (!this.f38071b) {
            GDTLogger.e("GDTApkManager init Context error,See More logs while new GDTApkManager");
        } else if (!this.f38072c) {
            this.f38073d.incrementAndGet();
        } else {
            DFA dfa = this.f38070a;
            if (dfa != null) {
                dfa.loadGDTApk();
            } else {
                GDTLogger.e("InterstitialAD Init error,See More Logs");
            }
        }
    }

    public final void startInstall(GDTApk gDTApk) {
        DFA dfa = this.f38070a;
        if (dfa != null) {
            dfa.startInstall(this.f38074e, gDTApk);
        }
    }
}
