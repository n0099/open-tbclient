package com.qq.e.ads.rewardvideo2;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import com.qq.e.ads.LiteAbstractAD;
import com.qq.e.comm.a;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.pi.RVADI2;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.VideoAdValidity;
/* loaded from: classes3.dex */
public class ExpressRewardVideoAD extends LiteAbstractAD<RVADI2> {
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
    private RVADI2 f11817a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f11818b;
    private boolean c = true;
    private ExpressRewardVideoAdListener d;

    /* loaded from: classes3.dex */
    private static class AdListenerAdapter implements ADListener {

        /* renamed from: a  reason: collision with root package name */
        private ExpressRewardVideoAdListener f11819a;

        AdListenerAdapter(ExpressRewardVideoAdListener expressRewardVideoAdListener) {
            this.f11819a = expressRewardVideoAdListener;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            if (this.f11819a == null || aDEvent == null) {
                return;
            }
            switch (aDEvent.getType()) {
                case 100:
                    this.f11819a.onAdLoaded();
                    return;
                case 101:
                    this.f11819a.onVideoCached();
                    return;
                case 102:
                    this.f11819a.onShow();
                    return;
                case 103:
                    this.f11819a.onExpose();
                    return;
                case 104:
                    this.f11819a.onReward();
                    return;
                case 105:
                    this.f11819a.onClick();
                    return;
                case 106:
                    this.f11819a.onClose();
                    return;
                case 107:
                    if (aDEvent.getParas().length <= 0 || !(aDEvent.getParas()[0] instanceof Integer)) {
                        return;
                    }
                    this.f11819a.onError(a.a(((Integer) aDEvent.getParas()[0]).intValue()));
                    return;
                case 108:
                    this.f11819a.onVideoComplete();
                    return;
                default:
                    return;
            }
        }
    }

    public ExpressRewardVideoAD(Context context, String str, ExpressRewardVideoAdListener expressRewardVideoAdListener) {
        this.d = expressRewardVideoAdListener;
        if (GDTADManager.getInstance().isInitialized()) {
            a(context, GDTADManager.getInstance().getAppStatus().getAPPID(), str);
            return;
        }
        GDTLogger.e("SDK 尚未初始化，请在 Application 中调用 GDTADManager.getInstance().initWith() 初始化");
        a(2003);
    }

    public ExpressRewardVideoAD(Context context, String str, String str2, ExpressRewardVideoAdListener expressRewardVideoAdListener) {
        this.d = expressRewardVideoAdListener;
        a(context, str, str2);
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.qq.e.ads.LiteAbstractAD
    protected final /* synthetic */ RVADI2 a(Context context, POFactory pOFactory, String str, String str2) {
        return pOFactory.getExpressRewardVideoADDelegate(context, str, str2, new AdListenerAdapter(this.d));
    }

    @Override // com.qq.e.ads.LiteAbstractAD
    protected final void a(int i) {
        if (this.d != null) {
            this.d.onError(a.a(i));
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.qq.e.ads.LiteAbstractAD
    protected final /* synthetic */ void a(RVADI2 rvadi2) {
        this.f11817a = rvadi2;
        this.f11817a.setVolumeOn(this.c);
        if (this.f11818b) {
            this.f11817a.loadAD();
            this.f11818b = false;
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
        if (this.f11817a != null) {
            z = this.f11817a.isVideoCached();
        } else {
            GDTLogger.w("don't call isVideoCached before loading AD success");
            z = false;
        }
        return !z ? VideoAdValidity.NONE_CACHE : VideoAdValidity.VALID;
    }

    public void destroy() {
        if (this.f11817a != null) {
            this.f11817a.destroy();
        }
    }

    public String getECPMLevel() {
        if (this.f11817a != null) {
            return this.f11817a.getECPMLevel();
        }
        GDTLogger.w("don't call getECPMLevel before loading AD success");
        return null;
    }

    public long getExpireTimestamp() {
        if (this.f11817a != null) {
            return this.f11817a.getExpireTimestamp();
        }
        GDTLogger.w("don't call getExpireTimestamp before loading AD success");
        return 0L;
    }

    public int getVideoDuration() {
        if (this.f11817a != null) {
            return this.f11817a.getVideoDuration();
        }
        GDTLogger.w("don't call getVideoDuration before loading AD success");
        return 0;
    }

    public boolean hasShown() {
        if (this.f11817a != null) {
            return this.f11817a.hasShown();
        }
        GDTLogger.w("don't call hasShown before loading AD success");
        return false;
    }

    public void loadAD() {
        if (this.f11817a != null) {
            this.f11817a.loadAD();
        } else {
            this.f11818b = true;
        }
    }

    public void setVolumeOn(boolean z) {
        if (this.f11817a != null) {
            this.f11817a.setVolumeOn(z);
        } else {
            this.c = z;
        }
    }

    public void showAD(Activity activity) {
        if (this.f11817a != null) {
            this.f11817a.showAD(activity);
        } else {
            GDTLogger.w("don't call showAD before loading AD success");
        }
    }
}
