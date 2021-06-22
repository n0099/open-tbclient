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
import com.qq.e.comm.compliance.ApkDownloadComplianceInterface;
import com.qq.e.comm.compliance.DownloadConfirmCallBack;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.pi.RVADI;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.VideoAdValidity;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class RewardVideoAD implements ApkDownloadComplianceInterface, DownloadConfirmListener {
    public static final int REWARD_TYPE_PAGE = 1;
    public static final int REWARD_TYPE_VIDEO = 0;

    /* renamed from: a  reason: collision with root package name */
    public RewardVideoADListener f39104a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f39105b;

    /* renamed from: c  reason: collision with root package name */
    public RVADI f39106c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f39107d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f39108e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f39109f;

    /* renamed from: g  reason: collision with root package name */
    public String f39110g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f39111h;

    /* renamed from: i  reason: collision with root package name */
    public Map<String, String> f39112i;
    public LoadAdParams j;
    public ServerSideVerificationOptions k;
    public DownloadConfirmListener l;

    /* renamed from: com.qq.e.ads.rewardvideo.RewardVideoAD$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public class AnonymousClass1 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f39113a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f39114b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ RewardVideoADListener f39115c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f39116d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f39117e;

        public AnonymousClass1(Context context, String str, RewardVideoADListener rewardVideoADListener, String str2, boolean z) {
            this.f39113a = context;
            this.f39114b = str;
            this.f39115c = rewardVideoADListener;
            this.f39116d = str2;
            this.f39117e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (GDTADManager.getInstance().initWith(this.f39113a, this.f39114b)) {
                try {
                    final POFactory pOFactory = GDTADManager.getInstance().getPM().getPOFactory();
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.qq.e.ads.rewardvideo.RewardVideoAD.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                if (pOFactory == null) {
                                    RewardVideoAD.this.a(2001);
                                    return;
                                }
                                ADListenerAdapter aDListenerAdapter = new ADListenerAdapter(AnonymousClass1.this.f39115c, new ADListenerAdapter.CacheCallback() { // from class: com.qq.e.ads.rewardvideo.RewardVideoAD.1.1.1
                                    @Override // com.qq.e.ads.rewardvideo.RewardVideoAD.ADListenerAdapter.CacheCallback
                                    public void onCached() {
                                        RewardVideoAD.this.f39111h = true;
                                    }

                                    @Override // com.qq.e.ads.rewardvideo.RewardVideoAD.ADListenerAdapter.CacheCallback
                                    public void onLoaded() {
                                        RewardVideoAD.this.f39111h = false;
                                    }
                                });
                                aDListenerAdapter.setBase(RewardVideoAD.this);
                                RewardVideoAD.this.f39106c = pOFactory.getRewardVideoADDelegate(AnonymousClass1.this.f39113a, AnonymousClass1.this.f39114b, AnonymousClass1.this.f39116d, aDListenerAdapter);
                                RewardVideoAD.this.f39106c.setVolumeOn(AnonymousClass1.this.f39117e);
                                RewardVideoAD.this.f39106c.setLoadAdParams(RewardVideoAD.this.j);
                                RewardVideoAD.this.f39106c.setServerSideVerificationOptions(RewardVideoAD.this.k);
                                RewardVideoAD.this.f39105b = true;
                                if (RewardVideoAD.this.f39109f) {
                                    RewardVideoAD.this.loadAD();
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

    /* loaded from: classes7.dex */
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
        public CacheCallback f39124a;
        public RewardVideoADListener adListener;

        /* renamed from: b  reason: collision with root package name */
        public WeakReference<RewardVideoAD> f39125b;

        /* loaded from: classes7.dex */
        public interface CacheCallback {
            void onCached();

            void onLoaded();
        }

        public ADListenerAdapter(RewardVideoADListener rewardVideoADListener) {
            this.adListener = rewardVideoADListener;
        }

        public ADListenerAdapter(RewardVideoADListener rewardVideoADListener, CacheCallback cacheCallback) {
            this.adListener = rewardVideoADListener;
            this.f39124a = cacheCallback;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            switch (aDEvent.getType()) {
                case 1:
                    this.adListener.onADLoad();
                    CacheCallback cacheCallback = this.f39124a;
                    if (cacheCallback != null) {
                        cacheCallback.onLoaded();
                        return;
                    }
                    return;
                case 2:
                    CacheCallback cacheCallback2 = this.f39124a;
                    if (cacheCallback2 != null) {
                        cacheCallback2.onCached();
                    }
                    this.adListener.onVideoCached();
                    return;
                case 3:
                    this.adListener.onADShow();
                    return;
                case 4:
                    this.adListener.onADExpose();
                    return;
                case 5:
                    if (aDEvent.getParas().length <= 0 || !(aDEvent.getParas()[0] instanceof String)) {
                        return;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put(ServerSideVerificationOptions.TRANS_ID, aDEvent.getParas()[0]);
                    this.adListener.onReward(hashMap);
                    return;
                case 6:
                    if (this.f39125b != null && aDEvent.getParas().length == 1) {
                        Object obj = aDEvent.getParas()[0];
                        if ((obj instanceof String) && this.f39125b.get() != null) {
                            this.f39125b.get().setExt((String) obj);
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
                    this.adListener.onError(AdErrorConvertor.formatErrorCode(((Integer) aDEvent.getParas()[0]).intValue()));
                    return;
                default:
                    return;
            }
        }

        public void setBase(RewardVideoAD rewardVideoAD) {
            this.f39125b = new WeakReference<>(rewardVideoAD);
        }
    }

    public RewardVideoAD(Context context, String str, RewardVideoADListener rewardVideoADListener) {
        this(context, str, rewardVideoADListener, true);
    }

    public RewardVideoAD(Context context, String str, RewardVideoADListener rewardVideoADListener, boolean z) {
        this.f39112i = new HashMap();
        this.j = null;
        if (GDTADManager.getInstance().isInitialized()) {
            a(context, GDTADManager.getInstance().getAppStatus().getAPPID(), str, rewardVideoADListener, z);
            return;
        }
        GDTLogger.e("SDK 尚未初始化，请在 Application 中调用 GDTADManager.getInstance().initWith() 初始化");
        rewardVideoADListener.onError(AdErrorConvertor.formatErrorCode(2003));
    }

    @Deprecated
    public RewardVideoAD(Context context, String str, String str2, RewardVideoADListener rewardVideoADListener) {
        this(context, str, str2, rewardVideoADListener, true);
    }

    @Deprecated
    public RewardVideoAD(Context context, String str, String str2, RewardVideoADListener rewardVideoADListener, boolean z) {
        this.f39112i = new HashMap();
        this.j = null;
        GDTLogger.w("此构造方法即将废弃，请在 Application 中初始化 SDK 后，使用不带 appId 的构造方法，详细请参考Demo");
        a(context, str, str2, rewardVideoADListener, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final int i2) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.qq.e.ads.rewardvideo.RewardVideoAD.2
            @Override // java.lang.Runnable
            public void run() {
                if (RewardVideoAD.this.f39104a != null) {
                    RewardVideoAD.this.f39104a.onError(AdErrorConvertor.formatErrorCode(i2));
                }
            }
        });
    }

    private void a(Context context, String str, String str2, RewardVideoADListener rewardVideoADListener, boolean z) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || rewardVideoADListener == null) {
            GDTLogger.e(String.format("RewardVideoAD Constructor params error, context=%s, appID=%s, posID=%s, rewardVideoADListener=%s", context, str, str2, rewardVideoADListener));
            return;
        }
        this.f39104a = rewardVideoADListener;
        this.f39107d = true;
        if (!a.a(context)) {
            GDTLogger.e("Required Activity/Service/Permission Not Declared in AndroidManifest.xml");
            a(4002);
            return;
        }
        this.f39108e = true;
        this.f39110g = str2;
        GDTADManager.INIT_EXECUTOR.execute(new AnonymousClass1(context, str, rewardVideoADListener, str2, z));
    }

    public VideoAdValidity checkValidity() {
        RVADI rvadi;
        return hasShown() ? VideoAdValidity.SHOWED : SystemClock.elapsedRealtime() > getExpireTimestamp() - 1000 ? VideoAdValidity.OVERDUE : (this.f39111h || (rvadi = this.f39106c) == null || rvadi.getRewardAdType() != 0) ? VideoAdValidity.VALID : VideoAdValidity.NONE_CACHE;
    }

    public String getAdNetWorkName() {
        RVADI rvadi = this.f39106c;
        if (rvadi != null) {
            return rvadi.getAdNetWorkName();
        }
        GDTLogger.e("please invoke getAdNetWorkName method after callback \"onADLoad\" or the ad does not support \"getAdNetWorkName\" ");
        return null;
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        RVADI rvadi = this.f39106c;
        if (rvadi != null) {
            return rvadi.getApkInfoUrl();
        }
        return null;
    }

    public int getECPM() {
        RVADI rvadi = this.f39106c;
        if (rvadi != null) {
            return rvadi.getECPM();
        }
        GDTLogger.e("please invoke getECPM method after callback \"onADLoad\" ");
        return -1;
    }

    public String getECPMLevel() {
        RVADI rvadi = this.f39106c;
        if (rvadi != null) {
            return rvadi.getECPMLevel();
        }
        GDTLogger.e("please invoke getECPMLevel method after callback \"onADLoad\" ");
        return null;
    }

    public long getExpireTimestamp() {
        RVADI rvadi = this.f39106c;
        if (rvadi != null) {
            return rvadi.getExpireTimestamp();
        }
        GDTLogger.e("please invoke getExpireTimestamp method after callback \"onADLoad\" ");
        return 0L;
    }

    public Map<String, String> getExts() {
        return this.f39112i;
    }

    public int getRewardAdType() {
        RVADI rvadi = this.f39106c;
        if (rvadi != null) {
            return rvadi.getRewardAdType();
        }
        GDTLogger.e("please invoke getRewardAdType method after callback \"onADLoad\" or the ad does not support \"getRewardAdType\" ");
        return 0;
    }

    public int getVideoDuration() {
        RVADI rvadi = this.f39106c;
        if (rvadi != null) {
            return rvadi.getVideoDuration();
        }
        GDTLogger.e("please invoke getVideoDuration method after callback \"onADLoad\" or the ad does not support \"getVideoDuration\" ");
        return 0;
    }

    public boolean hasShown() {
        RVADI rvadi = this.f39106c;
        if (rvadi != null) {
            return rvadi.hasShown();
        }
        GDTLogger.e("please invoke hasShown method after callback \"onADLoad\" ");
        return false;
    }

    public void loadAD() {
        if (!this.f39107d || !this.f39108e) {
            GDTLogger.e("AD init Params OR Context error, details in logs produced while init RewardVideoAD");
        } else if (!this.f39105b) {
            this.f39109f = true;
        } else {
            RVADI rvadi = this.f39106c;
            if (rvadi != null) {
                rvadi.loadAD();
            } else {
                GDTLogger.e("RewardVideo AD Init error, see more logs");
            }
        }
    }

    @Override // com.qq.e.comm.compliance.DownloadConfirmListener
    public void onDownloadConfirm(Activity activity, int i2, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
        DownloadConfirmListener downloadConfirmListener = this.l;
        if (downloadConfirmListener != null) {
            downloadConfirmListener.onDownloadConfirm(activity, i2, str, downloadConfirmCallBack);
        }
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        this.l = downloadConfirmListener;
        RVADI rvadi = this.f39106c;
        if (rvadi != null) {
            rvadi.setDownloadConfirmListener(this);
        }
    }

    public void setExt(String str) {
        this.f39112i.put(Constants.KEYS.EXPOSED_CLICK_URL_KEY, str);
    }

    public void setLoadAdParams(LoadAdParams loadAdParams) {
        this.j = loadAdParams;
        RVADI rvadi = this.f39106c;
        if (rvadi != null) {
            rvadi.setLoadAdParams(loadAdParams);
        }
    }

    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.k = serverSideVerificationOptions;
        RVADI rvadi = this.f39106c;
        if (rvadi != null) {
            rvadi.setServerSideVerificationOptions(serverSideVerificationOptions);
        }
    }

    public void setTag(Map map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        try {
            GDTADManager.getInstance().getSM().setDEVCodeSetting(Constants.KEYS.AD_TAGS, new JSONObject(map), this.f39110g);
        } catch (Exception e2) {
            GDTLogger.e("NativeUnifiedAD#setTag Exception");
            e2.printStackTrace();
        }
    }

    public void showAD() {
        RVADI rvadi = this.f39106c;
        if (rvadi != null) {
            rvadi.showAD();
        } else {
            GDTLogger.e("please invoke showAD method after callback \"onADLoad\" ");
        }
    }

    public void showAD(Activity activity) {
        RVADI rvadi = this.f39106c;
        if (rvadi != null) {
            rvadi.showAD(activity);
        } else {
            GDTLogger.e("please invoke showAD method after callback \"onADLoad\" ");
        }
    }
}
