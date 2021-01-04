package com.qq.e.ads.banner2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.widget.FrameLayout;
import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.comm.a;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.pi.UBVI;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes3.dex */
public class UnifiedBannerView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private UBVI f11723a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f11724b;
    private boolean c;
    private boolean d;
    private DownAPPConfirmPolicy e;
    private AtomicInteger f;
    private int g;
    private LoadAdParams h;

    public UnifiedBannerView(Activity activity, String str, UnifiedBannerADListener unifiedBannerADListener) {
        this(activity, str, unifiedBannerADListener, (Map) null);
    }

    public UnifiedBannerView(Activity activity, String str, UnifiedBannerADListener unifiedBannerADListener, Map map) {
        super(activity);
        this.f11724b = false;
        this.c = false;
        this.d = false;
        this.f = new AtomicInteger(0);
        this.g = 30;
        this.h = null;
        if (GDTADManager.getInstance().isInitialized()) {
            a(activity, GDTADManager.getInstance().getAppStatus().getAPPID(), str, unifiedBannerADListener, map);
            return;
        }
        GDTLogger.e("SDK 尚未初始化，请在 Application 中调用 GDTADManager.getInstance().initWith() 初始化");
        unifiedBannerADListener.onNoAD(a.a(2003));
    }

    @Deprecated
    public UnifiedBannerView(Activity activity, String str, String str2, UnifiedBannerADListener unifiedBannerADListener) {
        this(activity, str, str2, unifiedBannerADListener, null);
    }

    @Deprecated
    public UnifiedBannerView(Activity activity, String str, String str2, UnifiedBannerADListener unifiedBannerADListener, Map map) {
        super(activity);
        this.f11724b = false;
        this.c = false;
        this.d = false;
        this.f = new AtomicInteger(0);
        this.g = 30;
        this.h = null;
        GDTLogger.w("此构造方法即将废弃，请在 Application 中初始化 SDK 后，使用不带 appId 的构造方法，详细请参考Demo");
        a(activity, str, str2, unifiedBannerADListener, map);
    }

    private void a(final Activity activity, final String str, final String str2, final UnifiedBannerADListener unifiedBannerADListener, final Map map) {
        if (StringUtil.isEmpty(str) || StringUtil.isEmpty(str2) || activity == null || unifiedBannerADListener == null) {
            GDTLogger.e(String.format("UnifiedBannerView Constructor params error, appid=%s,posId=%s,context=%s,listener=%s", str, str2, activity, unifiedBannerADListener));
            return;
        }
        this.f11724b = true;
        if (!a.a(activity)) {
            GDTLogger.e("Required Activity/Service/Permission Not Declared in AndroidManifest.xml");
            return;
        }
        this.c = true;
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
                                    UnifiedBannerView.this.f11723a = pOFactory.getUnifiedBannerViewDelegate(UnifiedBannerView.this, activity, str, str2, unifiedBannerADListener);
                                    UnifiedBannerView.this.d = true;
                                    UnifiedBannerView.a(UnifiedBannerView.this, map, str2);
                                    if (UnifiedBannerView.this.e != null) {
                                        UnifiedBannerView.this.setDownConfirmPolicy(UnifiedBannerView.this.e);
                                    }
                                    UnifiedBannerView.this.setRefresh(UnifiedBannerView.this.g);
                                    UnifiedBannerView.this.setLoadAdParams(UnifiedBannerView.this.h);
                                    while (UnifiedBannerView.this.f.getAndDecrement() > 0) {
                                        UnifiedBannerView.this.loadAD();
                                    }
                                }
                            } catch (Throwable th) {
                                try {
                                    GDTLogger.e("Exception while init UnifiedBannerView Core", th);
                                } finally {
                                    UnifiedBannerView.this.d = true;
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

    static /* synthetic */ void a(UnifiedBannerView unifiedBannerView, Map map, String str) {
        if (map == null || map.size() <= 0) {
            return;
        }
        try {
            GDTADManager.getInstance().getSM().setDEVCodeSetting(Constants.KEYS.AD_TAGS, new JSONObject(map), str);
        } catch (Exception e) {
            GDTLogger.e("UnifiedBanner#setTag Exception");
            e.printStackTrace();
        }
    }

    public void destroy() {
        if (this.f11723a != null) {
            this.f11723a.destroy();
        }
    }

    public Map getExt() {
        try {
            if (this.f11723a != null) {
                return UBVI.ext;
            }
        } catch (Exception e) {
            GDTLogger.e("banner2 can not get ext");
        }
        return null;
    }

    public void loadAD() {
        if (!this.f11724b || !this.c) {
            GDTLogger.e("UnifiedBannerView init Paras OR Context error,See More logs while new BannerView");
        } else if (!this.d) {
            this.f.incrementAndGet();
        } else if (this.f11723a != null) {
            this.f11723a.fetchAd();
        } else {
            GDTLogger.e("UnifiedBannerView Init error,See More Logs");
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.f11723a != null) {
            this.f11723a.onWindowFocusChanged(z);
        }
    }

    public void setDownConfirmPolicy(DownAPPConfirmPolicy downAPPConfirmPolicy) {
        this.e = downAPPConfirmPolicy;
        if (downAPPConfirmPolicy == null || this.f11723a == null) {
            return;
        }
        this.f11723a.setDownAPPConfirmPolicy(downAPPConfirmPolicy);
    }

    public void setLoadAdParams(LoadAdParams loadAdParams) {
        this.h = loadAdParams;
        if (this.f11723a != null) {
            this.f11723a.setLoadAdParams(this.h);
        }
    }

    public void setRefresh(int i) {
        this.g = i;
        if (this.f11723a != null) {
            this.f11723a.setRefresh(i);
        }
    }
}
