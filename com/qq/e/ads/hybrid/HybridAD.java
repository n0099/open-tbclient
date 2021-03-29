package com.qq.e.ads.hybrid;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.qq.e.comm.a;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.HADI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public class HybridAD implements HADI {

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f38082a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f38083b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f38084c;

    /* renamed from: d  reason: collision with root package name */
    public HADI f38085d;

    /* renamed from: e  reason: collision with root package name */
    public HybridADListener f38086e;

    /* renamed from: f  reason: collision with root package name */
    public CountDownLatch f38087f = new CountDownLatch(1);

    public HybridAD(Context context, HybridADSetting hybridADSetting, HybridADListener hybridADListener) {
        if (GDTADManager.getInstance().isInitialized()) {
            a(context, GDTADManager.getInstance().getAppStatus().getAPPID(), hybridADSetting, hybridADListener);
            return;
        }
        GDTLogger.e("SDK 尚未初始化，请在 Application 中调用 GDTADManager.getInstance().initWith() 初始化");
        hybridADListener.onError(AdErrorConvertor.formatErrorCode(2003));
    }

    @Deprecated
    public HybridAD(Context context, String str, HybridADSetting hybridADSetting, HybridADListener hybridADListener) {
        GDTLogger.w("此构造方法即将废弃，请在 Application 中初始化 SDK 后，使用不带 appId 的构造方法，详细请参考Demo");
        a(context, str, hybridADSetting, hybridADListener);
    }

    private void a(final Context context, final String str, final HybridADSetting hybridADSetting, final HybridADListener hybridADListener) {
        if (context == null || TextUtils.isEmpty(str) || hybridADListener == null) {
            GDTLogger.e(String.format("HybridAD Constructor params error, context=%s, appID=%s,HybridADListener=%s", context, str, hybridADListener));
            return;
        }
        this.f38086e = hybridADListener;
        this.f38083b = true;
        if (!a.a(context)) {
            GDTLogger.e("Required Activity/Service/Permission Not Declared in AndroidManifest.xml");
            return;
        }
        this.f38084c = true;
        GDTADManager.INIT_EXECUTOR.execute(new Runnable() { // from class: com.qq.e.ads.hybrid.HybridAD.1
            @Override // java.lang.Runnable
            public void run() {
                if (GDTADManager.getInstance().initWith(context, str)) {
                    try {
                        final POFactory pOFactory = GDTADManager.getInstance().getPM().getPOFactory();
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.qq.e.ads.hybrid.HybridAD.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                POFactory pOFactory2 = pOFactory;
                                if (pOFactory2 != null) {
                                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                    HybridAD.this.f38085d = pOFactory2.getHybridAD(hybridADSetting, hybridADListener);
                                    HybridAD.this.f38082a = true;
                                } else {
                                    GDTLogger.e("poFactory is null");
                                    HybridAD.a(HybridAD.this, 2001);
                                }
                                HybridAD.this.f38087f.countDown();
                            }
                        });
                        return;
                    } catch (Throwable th) {
                        GDTLogger.e("Exception while init HybridAD plugin", th);
                    }
                } else {
                    GDTLogger.e("Fail to init ADManager");
                }
                HybridAD.a(HybridAD.this, 2001);
                HybridAD.this.f38087f.countDown();
            }
        });
    }

    public static /* synthetic */ void a(HybridAD hybridAD, int i) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.qq.e.ads.hybrid.HybridAD.3
            @Override // java.lang.Runnable
            public void run() {
                if (HybridAD.this.f38086e != null) {
                    HybridAD.this.f38086e.onError(AdErrorConvertor.formatErrorCode(r2));
                }
            }
        });
    }

    @Override // com.qq.e.comm.pi.HADI
    public void loadUrl(final String str) {
        boolean z;
        if (this.f38083b && this.f38084c) {
            z = true;
        } else {
            GDTLogger.e("AD init Params OR Context error, details in logs produced while init HybridAD");
            z = false;
        }
        if (!z) {
            GDTLogger.e("HybridAD loadUrl error");
        } else if (this.f38082a) {
            this.f38085d.loadUrl(str);
        } else {
            new Thread(new Runnable() { // from class: com.qq.e.ads.hybrid.HybridAD.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        HybridAD.this.f38087f.await(30L, TimeUnit.SECONDS);
                        if (HybridAD.this.f38082a) {
                            HybridAD.this.f38085d.loadUrl(str);
                            return;
                        }
                        GDTLogger.e("delegate init failed ");
                        HybridAD.a(HybridAD.this, 2001);
                    } catch (InterruptedException unused) {
                        GDTLogger.e("buffered loadUrl action timeout");
                        HybridAD.a(HybridAD.this, 2001);
                    }
                }
            }).start();
        }
    }
}
