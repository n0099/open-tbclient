package com.qq.e.ads.rewardvideo2;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import com.qq.e.ads.LiteAbstractAD;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.compliance.ApkDownloadComplianceInterface;
import com.qq.e.comm.compliance.DownloadConfirmCallBack;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.pi.RVADI2;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.VideoAdValidity;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class ExpressRewardVideoAD extends LiteAbstractAD<RVADI2> implements ApkDownloadComplianceInterface, DownloadConfirmListener {
    public static final int EVENT_AD_LOAD = 100;
    public static final int EVENT_CLICK = 105;
    public static final int EVENT_CLOSE = 106;
    public static final int EVENT_COMPLETE = 108;
    public static final int EVENT_ERROR = 107;
    public static final int EVENT_EXPOSE = 103;
    public static final int EVENT_REWARD = 104;
    public static final int EVENT_SHOW = 102;
    public static final int EVENT_VIDEO_CACHED = 101;

    /* renamed from: a  reason: collision with root package name */
    public RVADI2 f39130a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f39131b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f39132c = true;

    /* renamed from: d  reason: collision with root package name */
    public ServerSideVerificationOptions f39133d;

    /* renamed from: e  reason: collision with root package name */
    public ExpressRewardVideoAdListener f39134e;

    /* renamed from: f  reason: collision with root package name */
    public DownloadConfirmListener f39135f;

    /* loaded from: classes7.dex */
    public static class AdListenerAdapter implements ADListener {

        /* renamed from: a  reason: collision with root package name */
        public ExpressRewardVideoAdListener f39136a;

        public AdListenerAdapter(ExpressRewardVideoAdListener expressRewardVideoAdListener) {
            this.f39136a = expressRewardVideoAdListener;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            if (this.f39136a == null || aDEvent == null) {
                return;
            }
            switch (aDEvent.getType()) {
                case 100:
                    this.f39136a.onAdLoaded();
                    return;
                case 101:
                    this.f39136a.onVideoCached();
                    return;
                case 102:
                    this.f39136a.onShow();
                    return;
                case 103:
                    this.f39136a.onExpose();
                    return;
                case 104:
                    if (aDEvent.getParas().length <= 0 || !(aDEvent.getParas()[0] instanceof String)) {
                        return;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put(ServerSideVerificationOptions.TRANS_ID, aDEvent.getParas()[0]);
                    this.f39136a.onReward(hashMap);
                    return;
                case 105:
                    this.f39136a.onClick();
                    return;
                case 106:
                    this.f39136a.onClose();
                    return;
                case 107:
                    if (aDEvent.getParas().length <= 0 || !(aDEvent.getParas()[0] instanceof Integer)) {
                        return;
                    }
                    this.f39136a.onError(AdErrorConvertor.formatErrorCode(((Integer) aDEvent.getParas()[0]).intValue()));
                    return;
                case 108:
                    this.f39136a.onVideoComplete();
                    return;
                default:
                    return;
            }
        }
    }

    public ExpressRewardVideoAD(Context context, String str, ExpressRewardVideoAdListener expressRewardVideoAdListener) {
        this.f39134e = expressRewardVideoAdListener;
        if (GDTADManager.getInstance().isInitialized()) {
            a(context, GDTADManager.getInstance().getAppStatus().getAPPID(), str);
            return;
        }
        GDTLogger.e("SDK 尚未初始化，请在 Application 中调用 GDTADManager.getInstance().initWith() 初始化");
        a(2003);
    }

    public ExpressRewardVideoAD(Context context, String str, String str2, ExpressRewardVideoAdListener expressRewardVideoAdListener) {
        this.f39134e = expressRewardVideoAdListener;
        a(context, str, str2);
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.qq.e.ads.LiteAbstractAD
    public final /* synthetic */ RVADI2 a(Context context, POFactory pOFactory, String str, String str2) {
        return pOFactory.getExpressRewardVideoADDelegate(context, str, str2, new AdListenerAdapter(this.f39134e));
    }

    @Override // com.qq.e.ads.LiteAbstractAD
    public final void a(int i2) {
        ExpressRewardVideoAdListener expressRewardVideoAdListener = this.f39134e;
        if (expressRewardVideoAdListener != null) {
            expressRewardVideoAdListener.onError(AdErrorConvertor.formatErrorCode(i2));
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.qq.e.ads.LiteAbstractAD
    public final /* synthetic */ void a(RVADI2 rvadi2) {
        RVADI2 rvadi22 = rvadi2;
        this.f39130a = rvadi22;
        rvadi22.setVolumeOn(this.f39132c);
        this.f39130a.setServerSideVerificationOptions(this.f39133d);
        if (this.f39131b) {
            this.f39130a.loadAD();
            this.f39131b = false;
        }
    }

    public VideoAdValidity checkValidity() {
        boolean z;
        if (hasShown()) {
            return VideoAdValidity.SHOWED;
        }
        if (SystemClock.elapsedRealtime() > getExpireTimestamp()) {
            return VideoAdValidity.OVERDUE;
        }
        RVADI2 rvadi2 = this.f39130a;
        if (rvadi2 != null) {
            z = rvadi2.isVideoCached();
        } else {
            GDTLogger.w("don't call isVideoCached before loading AD success");
            z = false;
        }
        return !z ? VideoAdValidity.NONE_CACHE : VideoAdValidity.VALID;
    }

    public void destroy() {
        RVADI2 rvadi2 = this.f39130a;
        if (rvadi2 != null) {
            rvadi2.destroy();
        }
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        RVADI2 rvadi2 = this.f39130a;
        if (rvadi2 != null) {
            return rvadi2.getApkInfoUrl();
        }
        return null;
    }

    public String getECPMLevel() {
        RVADI2 rvadi2 = this.f39130a;
        if (rvadi2 != null) {
            return rvadi2.getECPMLevel();
        }
        GDTLogger.w("don't call getECPMLevel before loading AD success");
        return null;
    }

    public long getExpireTimestamp() {
        RVADI2 rvadi2 = this.f39130a;
        if (rvadi2 != null) {
            return rvadi2.getExpireTimestamp();
        }
        GDTLogger.w("don't call getExpireTimestamp before loading AD success");
        return 0L;
    }

    public int getVideoDuration() {
        RVADI2 rvadi2 = this.f39130a;
        if (rvadi2 != null) {
            return rvadi2.getVideoDuration();
        }
        GDTLogger.w("don't call getVideoDuration before loading AD success");
        return 0;
    }

    public boolean hasShown() {
        RVADI2 rvadi2 = this.f39130a;
        if (rvadi2 != null) {
            return rvadi2.hasShown();
        }
        GDTLogger.w("don't call hasShown before loading AD success");
        return false;
    }

    public void loadAD() {
        RVADI2 rvadi2 = this.f39130a;
        if (rvadi2 != null) {
            rvadi2.loadAD();
        } else {
            this.f39131b = true;
        }
    }

    @Override // com.qq.e.comm.compliance.DownloadConfirmListener
    public void onDownloadConfirm(Activity activity, int i2, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
        DownloadConfirmListener downloadConfirmListener = this.f39135f;
        if (downloadConfirmListener != null) {
            downloadConfirmListener.onDownloadConfirm(activity, i2, str, downloadConfirmCallBack);
        }
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        this.f39135f = downloadConfirmListener;
        RVADI2 rvadi2 = this.f39130a;
        if (rvadi2 != null) {
            rvadi2.setDownloadConfirmListener(this);
        }
    }

    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        RVADI2 rvadi2 = this.f39130a;
        if (rvadi2 != null) {
            rvadi2.setServerSideVerificationOptions(serverSideVerificationOptions);
        } else {
            this.f39133d = serverSideVerificationOptions;
        }
    }

    public void setVolumeOn(boolean z) {
        RVADI2 rvadi2 = this.f39130a;
        if (rvadi2 != null) {
            rvadi2.setVolumeOn(z);
        } else {
            this.f39132c = z;
        }
    }

    public void showAD(Activity activity) {
        RVADI2 rvadi2 = this.f39130a;
        if (rvadi2 != null) {
            rvadi2.showAD(activity);
        } else {
            GDTLogger.w("don't call showAD before loading AD success");
        }
    }
}
