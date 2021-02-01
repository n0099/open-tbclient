package com.qq.e.ads.interstitial2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.comm.a;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.pi.UIADI;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes15.dex */
public class UnifiedInterstitialAD {

    /* renamed from: a  reason: collision with root package name */
    private UIADI f11465a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f11466b;
    private boolean c;
    private boolean d;
    private AtomicInteger e;
    private AtomicInteger f;
    private volatile UnifiedInterstitialMediaListener g;
    private volatile VideoOption h;
    private volatile int i;
    private volatile int j;
    private volatile int k;

    public UnifiedInterstitialAD(Activity activity, String str, UnifiedInterstitialADListener unifiedInterstitialADListener) {
        this(activity, str, unifiedInterstitialADListener, (Map) null);
    }

    public UnifiedInterstitialAD(Activity activity, String str, UnifiedInterstitialADListener unifiedInterstitialADListener, Map map) {
        this.f11466b = false;
        this.c = false;
        this.d = false;
        this.e = new AtomicInteger(0);
        this.f = new AtomicInteger(0);
        if (GDTADManager.getInstance().isInitialized()) {
            a(activity, GDTADManager.getInstance().getAppStatus().getAPPID(), str, unifiedInterstitialADListener, map);
            return;
        }
        GDTLogger.e("SDK 尚未初始化，请在 Application 中调用 GDTADManager.getInstance().initWith() 初始化");
        unifiedInterstitialADListener.onNoAD(a.a(2003));
    }

    @Deprecated
    public UnifiedInterstitialAD(Activity activity, String str, String str2, UnifiedInterstitialADListener unifiedInterstitialADListener) {
        this(activity, str, str2, unifiedInterstitialADListener, null);
    }

    @Deprecated
    public UnifiedInterstitialAD(Activity activity, String str, String str2, UnifiedInterstitialADListener unifiedInterstitialADListener, Map map) {
        this.f11466b = false;
        this.c = false;
        this.d = false;
        this.e = new AtomicInteger(0);
        this.f = new AtomicInteger(0);
        GDTLogger.w("此构造方法即将废弃，请在 Application 中初始化 SDK 后，使用不带 appId 的构造方法，详细请参考Demo");
        a(activity, str, str2, unifiedInterstitialADListener, map);
    }

    private void a(final Activity activity, final String str, final String str2, final UnifiedInterstitialADListener unifiedInterstitialADListener, final Map map) {
        if (StringUtil.isEmpty(str) || StringUtil.isEmpty(str2) || activity == null || unifiedInterstitialADListener == null) {
            GDTLogger.e(String.format("UnifiedInterstitialAD Constructor paras error, appid=%s,posId=%s,context=%s,listener=%s", str, str2, activity, unifiedInterstitialADListener));
            return;
        }
        this.f11466b = true;
        if (!a.a(activity)) {
            GDTLogger.e("Required Activity/Service/Permission Not Declared in AndroidManifest.xml");
            return;
        }
        this.c = true;
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
                                    UnifiedInterstitialAD.this.f11465a = pOFactory.getUnifiedInterstitialADDelegate(activity, str, str2, unifiedInterstitialADListener);
                                    UnifiedInterstitialAD.this.d = true;
                                    UnifiedInterstitialAD.a(UnifiedInterstitialAD.this, map, str2);
                                    UnifiedInterstitialAD.this.setVideoOption(UnifiedInterstitialAD.this.h);
                                    UnifiedInterstitialAD.this.setMediaListener(UnifiedInterstitialAD.this.g);
                                    UnifiedInterstitialAD.this.setMinVideoDuration(UnifiedInterstitialAD.this.j);
                                    UnifiedInterstitialAD.this.setMaxVideoDuration(UnifiedInterstitialAD.this.k);
                                    UnifiedInterstitialAD.this.setVideoPlayPolicy(UnifiedInterstitialAD.this.i);
                                    while (UnifiedInterstitialAD.this.e.getAndDecrement() > 0) {
                                        UnifiedInterstitialAD.this.loadAD();
                                    }
                                    while (UnifiedInterstitialAD.this.f.getAndDecrement() > 0) {
                                        UnifiedInterstitialAD.this.loadFullScreenAD();
                                    }
                                }
                            } catch (Throwable th) {
                                try {
                                    GDTLogger.e("Exception while init UnifiedInterstitialAD Core", th);
                                } finally {
                                    UnifiedInterstitialAD.this.d = true;
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

    static /* synthetic */ void a(UnifiedInterstitialAD unifiedInterstitialAD, Map map, String str) {
        if (map == null || map.size() <= 0) {
            return;
        }
        try {
            GDTADManager.getInstance().getSM().setDEVCodeSetting(Constants.KEYS.AD_TAGS, new JSONObject(map), str);
        } catch (Exception e) {
            GDTLogger.e("UnifiedInterstitialAD#setTag Exception");
            e.printStackTrace();
        }
    }

    public void close() {
        if (this.f11465a != null) {
            this.f11465a.close();
        }
    }

    public void destroy() {
        if (this.f11465a != null) {
            this.f11465a.destory();
        }
    }

    public String getAdNetWorkName() {
        if (this.f11465a != null) {
            return this.f11465a.getAdNetWorkName();
        }
        GDTLogger.e("InterstitialAD init failed or not inited, can't call getAdNetWorkName");
        return null;
    }

    public int getAdPatternType() {
        if (this.f11465a != null) {
            return this.f11465a.getAdPatternType();
        }
        GDTLogger.e("InterstitialAD init failed or not inited, can't call getAdPatternType");
        return 0;
    }

    public int getECPM() {
        if (this.f11465a != null) {
            return this.f11465a.getECPM();
        }
        GDTLogger.e("InterstitialAD init failed or not inited, can't call getECPM");
        return -1;
    }

    public String getECPMLevel() {
        if (this.f11465a != null) {
            return this.f11465a.getECPMLevel();
        }
        GDTLogger.e("InterstitialAD init failed or not inited, can't call getECPMLevel");
        return null;
    }

    public Map getExt() {
        try {
            if (this.f11465a != null) {
                return UIADI.ext;
            }
        } catch (Exception e) {
            GDTLogger.e("interstitial2 can not get ext");
        }
        return null;
    }

    public boolean isValid() {
        if (this.f11465a != null) {
            return this.f11465a.isValid();
        }
        GDTLogger.e("InterstitialAD init failed or not inited, can't call isValid");
        return false;
    }

    public void loadAD() {
        if (!this.f11466b || !this.c) {
            GDTLogger.e("InterstitialAD init Paras OR Context error,See More logs while new InterstitialAD");
        } else if (!this.d) {
            this.e.incrementAndGet();
        } else if (this.f11465a != null) {
            this.f11465a.loadAd();
        } else {
            GDTLogger.e("InterstitialAD Init error,See More Logs");
        }
    }

    public void loadFullScreenAD() {
        if (!this.f11466b || !this.c) {
            GDTLogger.e("InterstitialAD init Paras OR Context error,See More logs while new InterstitialAD");
        } else if (!this.d) {
            this.f.incrementAndGet();
        } else if (this.f11465a != null) {
            this.f11465a.loadFullScreenAD();
        } else {
            GDTLogger.e("InterstitialAD Init error,See More Logs");
        }
    }

    public void setMaxVideoDuration(int i) {
        this.k = i;
        if (this.k > 0 && this.j > this.k) {
            GDTLogger.e("maxVideoDuration 设置值非法，不得小于minVideoDuration");
        }
        if (this.f11465a != null) {
            this.f11465a.setMaxVideoDuration(i);
        }
    }

    public void setMediaListener(UnifiedInterstitialMediaListener unifiedInterstitialMediaListener) {
        this.g = unifiedInterstitialMediaListener;
        if (this.f11465a != null) {
            this.f11465a.setMediaListener(unifiedInterstitialMediaListener);
        }
    }

    public void setMinVideoDuration(int i) {
        this.j = i;
        if (this.k > 0 && this.j > this.k) {
            GDTLogger.e("minVideoDuration 设置值非法，不得大于maxVideoDuration");
        }
        if (this.f11465a != null) {
            this.f11465a.setMinVideoDuration(i);
        }
    }

    public void setVideoOption(VideoOption videoOption) {
        this.h = videoOption;
        if (this.f11465a != null) {
            this.f11465a.setVideoOption(videoOption);
        }
    }

    public void setVideoPlayPolicy(int i) {
        this.i = i;
        if (this.f11465a != null) {
            this.f11465a.setVideoPlayPolicy(i);
        }
    }

    public void show() {
        if (this.f11465a != null) {
            this.f11465a.show();
        }
    }

    public void show(Activity activity) {
        if (this.f11465a != null) {
            this.f11465a.show(activity);
        }
    }

    public void showAsPopupWindow() {
        if (this.f11465a != null) {
            this.f11465a.showAsPopupWindow();
        }
    }

    public void showAsPopupWindow(Activity activity) {
        if (this.f11465a != null) {
            this.f11465a.showAsPopupWindow(activity);
        }
    }

    public void showFullScreenAD(Activity activity) {
        if (this.f11465a != null) {
            this.f11465a.showFullScreenAD(activity);
        }
    }
}
