package com.qq.e.ads.banner2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.widget.FrameLayout;
import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.comm.a;
import com.qq.e.comm.compliance.ApkDownloadComplianceInterface;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.pi.UBVI;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes5.dex */
public class UnifiedBannerView extends FrameLayout implements ApkDownloadComplianceInterface {

    /* renamed from: a  reason: collision with root package name */
    public UBVI f35226a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f35227b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f35228c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f35229d;

    /* renamed from: e  reason: collision with root package name */
    public DownAPPConfirmPolicy f35230e;

    /* renamed from: f  reason: collision with root package name */
    public AtomicInteger f35231f;

    /* renamed from: g  reason: collision with root package name */
    public int f35232g;

    /* renamed from: h  reason: collision with root package name */
    public LoadAdParams f35233h;

    public UnifiedBannerView(Activity activity, String str, UnifiedBannerADListener unifiedBannerADListener) {
        this(activity, str, unifiedBannerADListener, (Map) null);
    }

    public UnifiedBannerView(Activity activity, String str, UnifiedBannerADListener unifiedBannerADListener, Map map) {
        super(activity);
        this.f35227b = false;
        this.f35228c = false;
        this.f35229d = false;
        this.f35231f = new AtomicInteger(0);
        this.f35232g = 30;
        this.f35233h = null;
        if (GDTADManager.getInstance().isInitialized()) {
            a(activity, GDTADManager.getInstance().getAppStatus().getAPPID(), str, unifiedBannerADListener, map);
            return;
        }
        GDTLogger.e("SDK 尚未初始化，请在 Application 中调用 GDTADManager.getInstance().initWith() 初始化");
        unifiedBannerADListener.onNoAD(AdErrorConvertor.formatErrorCode(2003));
    }

    @Deprecated
    public UnifiedBannerView(Activity activity, String str, String str2, UnifiedBannerADListener unifiedBannerADListener) {
        this(activity, str, str2, unifiedBannerADListener, null);
    }

    @Deprecated
    public UnifiedBannerView(Activity activity, String str, String str2, UnifiedBannerADListener unifiedBannerADListener, Map map) {
        super(activity);
        this.f35227b = false;
        this.f35228c = false;
        this.f35229d = false;
        this.f35231f = new AtomicInteger(0);
        this.f35232g = 30;
        this.f35233h = null;
        GDTLogger.w("此构造方法即将废弃，请在 Application 中初始化 SDK 后，使用不带 appId 的构造方法，详细请参考Demo");
        a(activity, str, str2, unifiedBannerADListener, map);
    }

    private void a(final Activity activity, final String str, final String str2, final UnifiedBannerADListener unifiedBannerADListener, final Map map) {
        if (StringUtil.isEmpty(str) || StringUtil.isEmpty(str2) || activity == null || unifiedBannerADListener == null) {
            GDTLogger.e(String.format("UnifiedBannerView Constructor params error, appid=%s,posId=%s,context=%s,listener=%s", str, str2, activity, unifiedBannerADListener));
            return;
        }
        this.f35227b = true;
        if (!a.a(activity)) {
            GDTLogger.e("Required Activity/Service/Permission Not Declared in AndroidManifest.xml");
            return;
        }
        this.f35228c = true;
        setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        GDTADManager.INIT_EXECUTOR.execute(new Runnable() { // from class: com.qq.e.ads.banner2.UnifiedBannerView.1
            @Override // java.lang.Runnable
            public void run() {
                if (!GDTADManager.getInstance().initWith(activity, str)) {
                    GDTLogger.e("Fail to init ADManager");
                    return;
                }
                try {
                    final POFactory pOFactory = GDTADManager.getInstance().getPM().getPOFactory();
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.qq.e.ads.banner2.UnifiedBannerView.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                if (pOFactory != null) {
                                    UnifiedBannerView.this.f35226a = pOFactory.getUnifiedBannerViewDelegate(UnifiedBannerView.this, activity, str, str2, unifiedBannerADListener);
                                    UnifiedBannerView.this.f35229d = true;
                                    UnifiedBannerView.a(UnifiedBannerView.this, map, str2);
                                    if (UnifiedBannerView.this.f35230e != null) {
                                        UnifiedBannerView.this.setDownConfirmPolicy(UnifiedBannerView.this.f35230e);
                                    }
                                    UnifiedBannerView.this.setRefresh(UnifiedBannerView.this.f35232g);
                                    UnifiedBannerView.this.setLoadAdParams(UnifiedBannerView.this.f35233h);
                                    while (UnifiedBannerView.this.f35231f.getAndDecrement() > 0) {
                                        UnifiedBannerView.this.loadAD();
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
    }

    public static /* synthetic */ void a(UnifiedBannerView unifiedBannerView, Map map, String str) {
        if (map == null || map.size() <= 0) {
            return;
        }
        try {
            GDTADManager.getInstance().getSM().setDEVCodeSetting(Constants.KEYS.AD_TAGS, new JSONObject(map), str);
        } catch (Exception e2) {
            GDTLogger.e("UnifiedBanner#setTag Exception");
            e2.printStackTrace();
        }
    }

    public void destroy() {
        UBVI ubvi = this.f35226a;
        if (ubvi != null) {
            ubvi.destroy();
        }
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        UBVI ubvi = this.f35226a;
        if (ubvi != null) {
            return ubvi.getApkInfoUrl();
        }
        return null;
    }

    public Map getExt() {
        try {
            if (this.f35226a != null) {
                return UBVI.ext;
            }
            return null;
        } catch (Exception unused) {
            GDTLogger.e("banner2 can not get ext");
            return null;
        }
    }

    public void loadAD() {
        if (!this.f35227b || !this.f35228c) {
            GDTLogger.e("UnifiedBannerView init Paras OR Context error,See More logs while new BannerView");
        } else if (!this.f35229d) {
            this.f35231f.incrementAndGet();
        } else {
            UBVI ubvi = this.f35226a;
            if (ubvi != null) {
                ubvi.fetchAd();
            } else {
                GDTLogger.e("UnifiedBannerView Init error,See More Logs");
            }
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        UBVI ubvi = this.f35226a;
        if (ubvi != null) {
            ubvi.onWindowFocusChanged(z);
        }
    }

    public void setDownConfirmPolicy(DownAPPConfirmPolicy downAPPConfirmPolicy) {
        UBVI ubvi;
        this.f35230e = downAPPConfirmPolicy;
        if (downAPPConfirmPolicy == null || (ubvi = this.f35226a) == null) {
            return;
        }
        ubvi.setDownAPPConfirmPolicy(downAPPConfirmPolicy);
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        UBVI ubvi = this.f35226a;
        if (ubvi != null) {
            ubvi.setDownloadConfirmListener(downloadConfirmListener);
        }
    }

    public void setLoadAdParams(LoadAdParams loadAdParams) {
        this.f35233h = loadAdParams;
        UBVI ubvi = this.f35226a;
        if (ubvi != null) {
            ubvi.setLoadAdParams(loadAdParams);
        }
    }

    public void setRefresh(int i2) {
        this.f35232g = i2;
        UBVI ubvi = this.f35226a;
        if (ubvi != null) {
            ubvi.setRefresh(i2);
        }
    }
}
