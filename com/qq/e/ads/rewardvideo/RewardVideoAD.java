package com.qq.e.ads.rewardvideo;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.qq.e.comm.a;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.pi.RVADI;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.VideoAdValidity;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class RewardVideoAD {
    public static final int REWARD_TYPE_PAGE = 1;
    public static final int REWARD_TYPE_VIDEO = 0;

    /* renamed from: a  reason: collision with root package name */
    private RewardVideoADListener f11507a;

    /* renamed from: b  reason: collision with root package name */
    private volatile boolean f11508b;
    private RVADI c;
    private volatile boolean d;
    private volatile boolean e;
    private volatile boolean f;
    private String g;
    private boolean h;
    private Map<String, String> i;
    private LoadAdParams j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.qq.e.ads.rewardvideo.RewardVideoAD$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass1 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f11509a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f11510b;
        final /* synthetic */ RewardVideoADListener c;
        final /* synthetic */ String d;
        final /* synthetic */ boolean e;

        AnonymousClass1(Context context, String str, RewardVideoADListener rewardVideoADListener, String str2, boolean z) {
            this.f11509a = context;
            this.f11510b = str;
            this.c = rewardVideoADListener;
            this.d = str2;
            this.e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (GDTADManager.getInstance().initWith(this.f11509a, this.f11510b)) {
                try {
                    final POFactory pOFactory = GDTADManager.getInstance().getPM().getPOFactory();
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.qq.e.ads.rewardvideo.RewardVideoAD.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                if (pOFactory != null) {
                                    ADListenerAdapter aDListenerAdapter = new ADListenerAdapter(AnonymousClass1.this.c, new ADListenerAdapter.CacheCallback() { // from class: com.qq.e.ads.rewardvideo.RewardVideoAD.1.1.1
                                        @Override // com.qq.e.ads.rewardvideo.RewardVideoAD.ADListenerAdapter.CacheCallback
                                        public void onCached() {
                                            RewardVideoAD.this.h = true;
                                        }

                                        @Override // com.qq.e.ads.rewardvideo.RewardVideoAD.ADListenerAdapter.CacheCallback
                                        public void onLoaded() {
                                            RewardVideoAD.this.h = false;
                                        }
                                    });
                                    aDListenerAdapter.setBase(RewardVideoAD.this);
                                    RewardVideoAD.this.c = pOFactory.getRewardVideoADDelegate(AnonymousClass1.this.f11509a, AnonymousClass1.this.f11510b, AnonymousClass1.this.d, aDListenerAdapter);
                                    RewardVideoAD.this.c.setVolumeOn(AnonymousClass1.this.e);
                                    RewardVideoAD.this.c.setLoadAdParams(RewardVideoAD.this.j);
                                    RewardVideoAD.this.f11508b = true;
                                    if (RewardVideoAD.this.f) {
                                        RewardVideoAD.this.loadAD();
                                    }
                                } else {
                                    RewardVideoAD.this.a(2001);
                                }
                            } catch (Throwable th) {
                                GDTLogger.e("Exception while init Core", th);
                                RewardVideoAD.this.a(2001);
                            }
                        }
                    });
                    return;
                } catch (Throwable th) {
                    GDTLogger.e("Exception while init Reward Video AD Core", th);
                }
            }
            RewardVideoAD.this.a(2001);
        }
    }

    /* loaded from: classes3.dex */
    public static class ADListenerAdapter implements ADListener {
        public static final int EVENT_TYPE_ON_AD_CLICK = 6;
        public static final int EVENT_TYPE_ON_AD_CLOSE = 8;
        public static final int EVENT_TYPE_ON_AD_EXPOSE = 4;
        public static final int EVENT_TYPE_ON_AD_LOADED = 1;
        public static final int EVENT_TYPE_ON_AD_SHOW = 3;
        public static final int EVENT_TYPE_ON_ERROR = 9;
        public static final int EVENT_TYPE_ON_REWARD = 5;
        public static final int EVENT_TYPE_ON_VIDEO_CACHED = 2;
        public static final int EVENT_TYPE_ON_VIDEO_COMPLETE = 7;

        /* renamed from: a  reason: collision with root package name */
        private CacheCallback f11516a;
        public RewardVideoADListener adListener;

        /* renamed from: b  reason: collision with root package name */
        private WeakReference<RewardVideoAD> f11517b;

        /* loaded from: classes3.dex */
        interface CacheCallback {
            void onCached();

            void onLoaded();
        }

        public ADListenerAdapter(RewardVideoADListener rewardVideoADListener) {
            this.adListener = rewardVideoADListener;
        }

        public ADListenerAdapter(RewardVideoADListener rewardVideoADListener, CacheCallback cacheCallback) {
            this.adListener = rewardVideoADListener;
            this.f11516a = cacheCallback;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            switch (aDEvent.getType()) {
                case 1:
                    this.adListener.onADLoad();
                    if (this.f11516a != null) {
                        this.f11516a.onLoaded();
                        return;
                    }
                    return;
                case 2:
                    this.adListener.onVideoCached();
                    if (this.f11516a != null) {
                        this.f11516a.onCached();
                        return;
                    }
                    return;
                case 3:
                    this.adListener.onADShow();
                    return;
                case 4:
                    this.adListener.onADExpose();
                    return;
                case 5:
                    this.adListener.onReward();
                    return;
                case 6:
                    if (this.f11517b != null && aDEvent.getParas().length == 1) {
                        Object obj = aDEvent.getParas()[0];
                        if ((obj instanceof String) && this.f11517b.get() != null) {
                            this.f11517b.get().setExt((String) obj);
                        }
                    }
                    this.adListener.onADClick();
                    return;
                case 7:
                    this.adListener.onVideoComplete();
                    return;
                case 8:
                    this.adListener.onADClose();
                    return;
                case 9:
                    if (aDEvent.getParas().length <= 0 || !(aDEvent.getParas()[0] instanceof Integer)) {
                        return;
                    }
                    this.adListener.onError(a.a(((Integer) aDEvent.getParas()[0]).intValue()));
                    return;
                default:
                    return;
            }
        }

        public void setBase(RewardVideoAD rewardVideoAD) {
            this.f11517b = new WeakReference<>(rewardVideoAD);
        }
    }

    public RewardVideoAD(Context context, String str, RewardVideoADListener rewardVideoADListener) {
        this(context, str, rewardVideoADListener, true);
    }

    public RewardVideoAD(Context context, String str, RewardVideoADListener rewardVideoADListener, boolean z) {
        this.i = new HashMap();
        this.j = null;
        if (GDTADManager.getInstance().isInitialized()) {
            a(context, GDTADManager.getInstance().getAppStatus().getAPPID(), str, rewardVideoADListener, z);
            return;
        }
        GDTLogger.e("SDK 尚未初始化，请在 Application 中调用 GDTADManager.getInstance().initWith() 初始化");
        rewardVideoADListener.onError(a.a(2003));
    }

    @Deprecated
    public RewardVideoAD(Context context, String str, String str2, RewardVideoADListener rewardVideoADListener) {
        this(context, str, str2, rewardVideoADListener, true);
    }

    @Deprecated
    public RewardVideoAD(Context context, String str, String str2, RewardVideoADListener rewardVideoADListener, boolean z) {
        this.i = new HashMap();
        this.j = null;
        GDTLogger.w("此构造方法即将废弃，请在 Application 中初始化 SDK 后，使用不带 appId 的构造方法，详细请参考Demo");
        a(context, str, str2, rewardVideoADListener, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final int i) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.qq.e.ads.rewardvideo.RewardVideoAD.2
            @Override // java.lang.Runnable
            public void run() {
                if (RewardVideoAD.this.f11507a != null) {
                    RewardVideoAD.this.f11507a.onError(a.a(i));
                }
            }
        });
    }

    private void a(Context context, String str, String str2, RewardVideoADListener rewardVideoADListener, boolean z) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || rewardVideoADListener == null) {
            GDTLogger.e(String.format("RewardVideoAD Constructor params error, context=%s, appID=%s, posID=%s, rewardVideoADListener=%s", context, str, str2, rewardVideoADListener));
            return;
        }
        this.f11507a = rewardVideoADListener;
        this.d = true;
        if (!a.a(context)) {
            GDTLogger.e("Required Activity/Service/Permission Not Declared in AndroidManifest.xml");
            a(4002);
            return;
        }
        this.e = true;
        this.g = str2;
        GDTADManager.INIT_EXECUTOR.execute(new AnonymousClass1(context, str, rewardVideoADListener, str2, z));
    }

    public VideoAdValidity checkValidity() {
        return hasShown() ? VideoAdValidity.SHOWED : SystemClock.elapsedRealtime() > getExpireTimestamp() - 1000 ? VideoAdValidity.OVERDUE : !this.h ? VideoAdValidity.NONE_CACHE : VideoAdValidity.VALID;
    }

    public String getAdNetWorkName() {
        if (this.c != null) {
            return this.c.getAdNetWorkName();
        }
        GDTLogger.e("please invoke getAdNetWorkName method after callback \"onADLoad\" or the ad does not support \"getAdNetWorkName\" ");
        return null;
    }

    public int getECPM() {
        if (this.c != null) {
            return this.c.getECPM();
        }
        GDTLogger.e("please invoke getECPM method after callback \"onADLoad\" ");
        return -1;
    }

    public String getECPMLevel() {
        if (this.c != null) {
            return this.c.getECPMLevel();
        }
        GDTLogger.e("please invoke getECPMLevel method after callback \"onADLoad\" ");
        return null;
    }

    public long getExpireTimestamp() {
        if (this.c != null) {
            return this.c.getExpireTimestamp();
        }
        GDTLogger.e("please invoke getExpireTimestamp method after callback \"onADLoad\" ");
        return 0L;
    }

    public Map<String, String> getExts() {
        return this.i;
    }

    public int getRewardAdType() {
        if (this.c != null) {
            return this.c.getRewardAdType();
        }
        GDTLogger.e("please invoke getRewardAdType method after callback \"onADLoad\" or the ad does not support \"getRewardAdType\" ");
        return 0;
    }

    public int getVideoDuration() {
        if (this.c != null) {
            return this.c.getVideoDuration();
        }
        GDTLogger.e("please invoke getVideoDuration method after callback \"onADLoad\" or the ad does not support \"getVideoDuration\" ");
        return 0;
    }

    public boolean hasShown() {
        if (this.c != null) {
            return this.c.hasShown();
        }
        GDTLogger.e("please invoke hasShown method after callback \"onADLoad\" ");
        return false;
    }

    public void loadAD() {
        if (!this.d || !this.e) {
            GDTLogger.e("AD init Params OR Context error, details in logs produced while init RewardVideoAD");
        } else if (!this.f11508b) {
            this.f = true;
        } else if (this.c != null) {
            this.c.loadAD();
        } else {
            GDTLogger.e("RewardVideo AD Init error, see more logs");
        }
    }

    public void setExt(String str) {
        this.i.put(Constants.KEYS.EXPOSED_CLICK_URL_KEY, str);
    }

    public void setLoadAdParams(LoadAdParams loadAdParams) {
        this.j = loadAdParams;
        if (this.c != null) {
            this.c.setLoadAdParams(this.j);
        }
    }

    public void setTag(Map map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        try {
            GDTADManager.getInstance().getSM().setDEVCodeSetting(Constants.KEYS.AD_TAGS, new JSONObject(map), this.g);
        } catch (Exception e) {
            GDTLogger.e("NativeUnifiedAD#setTag Exception");
            e.printStackTrace();
        }
    }

    public void showAD() {
        if (this.c != null) {
            this.c.showAD();
        } else {
            GDTLogger.e("please invoke showAD method after callback \"onADLoad\" ");
        }
    }

    public void showAD(Activity activity) {
        if (this.c != null) {
            this.c.showAD(activity);
        } else {
            GDTLogger.e("please invoke showAD method after callback \"onADLoad\" ");
        }
    }
}
