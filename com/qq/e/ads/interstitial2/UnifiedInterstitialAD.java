package com.qq.e.ads.interstitial2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.comm.a;
import com.qq.e.comm.compliance.ApkDownloadComplianceInterface;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.pi.UIADI;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes6.dex */
public class UnifiedInterstitialAD implements ApkDownloadComplianceInterface {

    /* renamed from: a  reason: collision with root package name */
    public UIADI f36060a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f36061b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f36062c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f36063d;

    /* renamed from: e  reason: collision with root package name */
    public AtomicInteger f36064e;

    /* renamed from: f  reason: collision with root package name */
    public AtomicInteger f36065f;

    /* renamed from: g  reason: collision with root package name */
    public volatile UnifiedInterstitialMediaListener f36066g;

    /* renamed from: h  reason: collision with root package name */
    public volatile VideoOption f36067h;

    /* renamed from: i  reason: collision with root package name */
    public volatile int f36068i;
    public volatile int j;

    public UnifiedInterstitialAD(Activity activity, String str, UnifiedInterstitialADListener unifiedInterstitialADListener) {
        this(activity, str, unifiedInterstitialADListener, (Map) null);
    }

    public UnifiedInterstitialAD(Activity activity, String str, UnifiedInterstitialADListener unifiedInterstitialADListener, Map map) {
        this.f36061b = false;
        this.f36062c = false;
        this.f36063d = false;
        this.f36064e = new AtomicInteger(0);
        this.f36065f = new AtomicInteger(0);
        if (GDTADManager.getInstance().isInitialized()) {
            a(activity, GDTADManager.getInstance().getAppStatus().getAPPID(), str, unifiedInterstitialADListener, map);
            return;
        }
        GDTLogger.e("SDK 尚未初始化，请在 Application 中调用 GDTADManager.getInstance().initWith() 初始化");
        unifiedInterstitialADListener.onNoAD(AdErrorConvertor.formatErrorCode(2003));
    }

    @Deprecated
    public UnifiedInterstitialAD(Activity activity, String str, String str2, UnifiedInterstitialADListener unifiedInterstitialADListener) {
        this(activity, str, str2, unifiedInterstitialADListener, null);
    }

    @Deprecated
    public UnifiedInterstitialAD(Activity activity, String str, String str2, UnifiedInterstitialADListener unifiedInterstitialADListener, Map map) {
        this.f36061b = false;
        this.f36062c = false;
        this.f36063d = false;
        this.f36064e = new AtomicInteger(0);
        this.f36065f = new AtomicInteger(0);
        GDTLogger.w("此构造方法即将废弃，请在 Application 中初始化 SDK 后，使用不带 appId 的构造方法，详细请参考Demo");
        a(activity, str, str2, unifiedInterstitialADListener, map);
    }

    private void a(final Activity activity, final String str, final String str2, final UnifiedInterstitialADListener unifiedInterstitialADListener, final Map map) {
        if (StringUtil.isEmpty(str) || StringUtil.isEmpty(str2) || activity == null || unifiedInterstitialADListener == null) {
            GDTLogger.e(String.format("UnifiedInterstitialAD Constructor paras error, appid=%s,posId=%s,context=%s,listener=%s", str, str2, activity, unifiedInterstitialADListener));
            return;
        }
        this.f36061b = true;
        if (!a.a(activity)) {
            GDTLogger.e("Required Activity/Service/Permission Not Declared in AndroidManifest.xml");
            return;
        }
        this.f36062c = true;
        GDTADManager.INIT_EXECUTOR.execute(new Runnable() { // from class: com.qq.e.ads.interstitial2.UnifiedInterstitialAD.1
            @Override // java.lang.Runnable
            public void run() {
                if (!GDTADManager.getInstance().initWith(activity, str)) {
                    GDTLogger.e("Fail to init ADManager");
                    return;
                }
                try {
                    final POFactory pOFactory = GDTADManager.getInstance().getPM().getPOFactory();
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.qq.e.ads.interstitial2.UnifiedInterstitialAD.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                if (pOFactory != null) {
                                    UnifiedInterstitialAD.this.f36060a = pOFactory.getUnifiedInterstitialADDelegate(activity, str, str2, unifiedInterstitialADListener);
                                    UnifiedInterstitialAD.this.f36063d = true;
                                    UnifiedInterstitialAD.a(UnifiedInterstitialAD.this, map, str2);
                                    UnifiedInterstitialAD.this.setVideoOption(UnifiedInterstitialAD.this.f36067h);
                                    UnifiedInterstitialAD.this.setMediaListener(UnifiedInterstitialAD.this.f36066g);
                                    UnifiedInterstitialAD.this.setMinVideoDuration(UnifiedInterstitialAD.this.f36068i);
                                    UnifiedInterstitialAD.this.setMaxVideoDuration(UnifiedInterstitialAD.this.j);
                                    while (UnifiedInterstitialAD.this.f36064e.getAndDecrement() > 0) {
                                        UnifiedInterstitialAD.this.loadAD();
                                    }
                                    while (UnifiedInterstitialAD.this.f36065f.getAndDecrement() > 0) {
                                        UnifiedInterstitialAD.this.loadFullScreenAD();
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
                    GDTLogger.e("Exception while init UnifiedInterstitialAD plugin", th);
                }
            }
        });
    }

    public static /* synthetic */ void a(UnifiedInterstitialAD unifiedInterstitialAD, Map map, String str) {
        if (map == null || map.size() <= 0) {
            return;
        }
        try {
            GDTADManager.getInstance().getSM().setDEVCodeSetting(Constants.KEYS.AD_TAGS, new JSONObject(map), str);
        } catch (Exception e2) {
            GDTLogger.e("UnifiedInterstitialAD#setTag Exception");
            e2.printStackTrace();
        }
    }

    public void close() {
        UIADI uiadi = this.f36060a;
        if (uiadi != null) {
            uiadi.close();
        }
    }

    public void destroy() {
        UIADI uiadi = this.f36060a;
        if (uiadi != null) {
            uiadi.destory();
        }
    }

    public String getAdNetWorkName() {
        UIADI uiadi = this.f36060a;
        if (uiadi != null) {
            return uiadi.getAdNetWorkName();
        }
        GDTLogger.e("InterstitialAD init failed or not inited, can't call getAdNetWorkName");
        return null;
    }

    public int getAdPatternType() {
        UIADI uiadi = this.f36060a;
        if (uiadi != null) {
            return uiadi.getAdPatternType();
        }
        GDTLogger.e("InterstitialAD init failed or not inited, can't call getAdPatternType");
        return 0;
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        UIADI uiadi = this.f36060a;
        if (uiadi != null) {
            return uiadi.getApkInfoUrl();
        }
        return null;
    }

    public int getECPM() {
        UIADI uiadi = this.f36060a;
        if (uiadi != null) {
            return uiadi.getECPM();
        }
        GDTLogger.e("InterstitialAD init failed or not inited, can't call getECPM");
        return -1;
    }

    public String getECPMLevel() {
        UIADI uiadi = this.f36060a;
        if (uiadi != null) {
            return uiadi.getECPMLevel();
        }
        GDTLogger.e("InterstitialAD init failed or not inited, can't call getECPMLevel");
        return null;
    }

    public Map getExt() {
        try {
            if (this.f36060a != null) {
                return UIADI.ext;
            }
            return null;
        } catch (Exception unused) {
            GDTLogger.e("interstitial2 can not get ext");
            return null;
        }
    }

    public boolean isValid() {
        UIADI uiadi = this.f36060a;
        if (uiadi != null) {
            return uiadi.isValid();
        }
        GDTLogger.e("InterstitialAD init failed or not inited, can't call isValid");
        return false;
    }

    public void loadAD() {
        if (!this.f36061b || !this.f36062c) {
            GDTLogger.e("InterstitialAD init Paras OR Context error,See More logs while new InterstitialAD");
        } else if (!this.f36063d) {
            this.f36064e.incrementAndGet();
        } else {
            UIADI uiadi = this.f36060a;
            if (uiadi != null) {
                uiadi.loadAd();
            } else {
                GDTLogger.e("InterstitialAD Init error,See More Logs");
            }
        }
    }

    public void loadFullScreenAD() {
        if (!this.f36061b || !this.f36062c) {
            GDTLogger.e("InterstitialAD init Paras OR Context error,See More logs while new InterstitialAD");
        } else if (!this.f36063d) {
            this.f36065f.incrementAndGet();
        } else {
            UIADI uiadi = this.f36060a;
            if (uiadi != null) {
                uiadi.loadFullScreenAD();
            } else {
                GDTLogger.e("InterstitialAD Init error,See More Logs");
            }
        }
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        UIADI uiadi = this.f36060a;
        if (uiadi != null) {
            uiadi.setDownloadConfirmListener(downloadConfirmListener);
        }
    }

    public void setMaxVideoDuration(int i2) {
        this.j = i2;
        if (this.j > 0 && this.f36068i > this.j) {
            GDTLogger.e("maxVideoDuration 设置值非法，不得小于minVideoDuration");
        }
        UIADI uiadi = this.f36060a;
        if (uiadi != null) {
            uiadi.setMaxVideoDuration(i2);
        }
    }

    public void setMediaListener(UnifiedInterstitialMediaListener unifiedInterstitialMediaListener) {
        this.f36066g = unifiedInterstitialMediaListener;
        UIADI uiadi = this.f36060a;
        if (uiadi != null) {
            uiadi.setMediaListener(unifiedInterstitialMediaListener);
        }
    }

    public void setMinVideoDuration(int i2) {
        this.f36068i = i2;
        if (this.j > 0 && this.f36068i > this.j) {
            GDTLogger.e("minVideoDuration 设置值非法，不得大于maxVideoDuration");
        }
        UIADI uiadi = this.f36060a;
        if (uiadi != null) {
            uiadi.setMinVideoDuration(i2);
        }
    }

    public void setVideoOption(VideoOption videoOption) {
        this.f36067h = videoOption;
        UIADI uiadi = this.f36060a;
        if (uiadi != null) {
            uiadi.setVideoOption(videoOption);
        }
    }

    @Deprecated
    public void setVideoPlayPolicy(int i2) {
    }

    public void show() {
        UIADI uiadi = this.f36060a;
        if (uiadi != null) {
            uiadi.show();
        }
    }

    public void show(Activity activity) {
        UIADI uiadi = this.f36060a;
        if (uiadi != null) {
            uiadi.show(activity);
        }
    }

    public void showAsPopupWindow() {
        UIADI uiadi = this.f36060a;
        if (uiadi != null) {
            uiadi.showAsPopupWindow();
        }
    }

    public void showAsPopupWindow(Activity activity) {
        UIADI uiadi = this.f36060a;
        if (uiadi != null) {
            uiadi.showAsPopupWindow(activity);
        }
    }

    public void showFullScreenAD(Activity activity) {
        UIADI uiadi = this.f36060a;
        if (uiadi != null) {
            uiadi.showFullScreenAD(activity);
        }
    }
}
