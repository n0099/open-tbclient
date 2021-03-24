package com.qq.e.ads.splash;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import com.qq.e.comm.a;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.compliance.ApkDownloadComplianceInterface;
import com.qq.e.comm.compliance.DownloadConfirmCallBack;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.constants.ErrorCode;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.plugin.c;
import com.qq.e.comm.pi.NSPVI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class SplashAD implements ApkDownloadComplianceInterface, DownloadConfirmListener {
    public static final int EVENT_TYPE_AD_CLICKED = 4;
    public static final int EVENT_TYPE_AD_DISMISSED = 1;
    public static final int EVENT_TYPE_AD_EXPOSURE = 6;
    public static final int EVENT_TYPE_AD_LOADED = 7;
    public static final int EVENT_TYPE_AD_PRESENT = 3;
    public static final int EVENT_TYPE_AD_TICK = 5;
    public static final int EVENT_TYPE_AD_ZOOM_OUT = 8;
    public static final int EVENT_TYPE_AD_ZOOM_OUT_PLAY_FINISH = 9;
    public static final int EVENT_TYPE_NO_AD = 2;

    /* renamed from: a  reason: collision with root package name */
    public volatile NSPVI f38229a;

    /* renamed from: b  reason: collision with root package name */
    public volatile ViewGroup f38230b;

    /* renamed from: c  reason: collision with root package name */
    public volatile SplashADListener f38231c;

    /* renamed from: d  reason: collision with root package name */
    public volatile LoadAdParams f38232d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f38233e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f38234f;

    /* renamed from: g  reason: collision with root package name */
    public int f38235g;

    /* renamed from: h  reason: collision with root package name */
    public int f38236h;
    public volatile View i;
    public DownloadConfirmListener j;

    /* loaded from: classes6.dex */
    public class ADListenerAdapter implements ADListener {
        public ADListenerAdapter() {
        }

        public /* synthetic */ ADListenerAdapter(SplashAD splashAD, byte b2) {
            this();
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            if (SplashAD.this.f38231c == null) {
                GDTLogger.e("SplashADListener == null");
                return;
            }
            Object[] paras = aDEvent.getParas();
            switch (aDEvent.getType()) {
                case 1:
                    SplashAD.this.f38231c.onADDismissed();
                    return;
                case 2:
                    if (paras.length <= 0 || !(paras[0] instanceof Integer)) {
                        GDTLogger.e("Splash onNoAD event get params error.");
                        return;
                    } else {
                        SplashAD.this.f38231c.onNoAD(AdErrorConvertor.formatErrorCode(((Integer) paras[0]).intValue()));
                        return;
                    }
                case 3:
                    SplashAD.this.f38231c.onADPresent();
                    return;
                case 4:
                    SplashAD.this.f38231c.onADClicked();
                    return;
                case 5:
                    if (paras.length == 1 && (paras[0] instanceof Long)) {
                        SplashAD.this.f38231c.onADTick(((Long) paras[0]).longValue());
                        return;
                    } else {
                        GDTLogger.e("Splash onADTick event get param error.");
                        return;
                    }
                case 6:
                    SplashAD.this.f38231c.onADExposure();
                    return;
                case 7:
                    if (paras.length == 1 && (paras[0] instanceof Long)) {
                        SplashAD.this.f38231c.onADLoaded(((Long) paras[0]).longValue());
                        return;
                    } else {
                        GDTLogger.e("Splash onADLoaded event get param error.");
                        return;
                    }
                case 8:
                    if (SplashAD.this.f38231c instanceof SplashADZoomOutListener) {
                        ((SplashADZoomOutListener) SplashAD.this.f38231c).onZoomOut();
                        return;
                    }
                    return;
                case 9:
                    if (SplashAD.this.f38231c instanceof SplashADZoomOutListener) {
                        ((SplashADZoomOutListener) SplashAD.this.f38231c).onZoomOutPlayFinish();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public SplashAD(Context context, View view, String str, SplashADListener splashADListener, int i) {
        this(context, view, str, splashADListener, i, (View) null);
    }

    public SplashAD(Context context, View view, String str, SplashADListener splashADListener, int i, View view2) {
        this(context, view, str, splashADListener, i, (Map) null, view2);
    }

    public SplashAD(Context context, View view, String str, SplashADListener splashADListener, int i, Map map, View view2) {
        this.f38233e = false;
        if (GDTADManager.getInstance().isInitialized()) {
            a(context, view, GDTADManager.getInstance().getAppStatus().getAPPID(), str, splashADListener, i, map, view2);
            return;
        }
        GDTLogger.e("SDK 尚未初始化，请在 Application 中调用 GDTADManager.getInstance().initWith() 初始化");
        a(splashADListener, 2003);
    }

    @Deprecated
    public SplashAD(Context context, View view, String str, String str2, SplashADListener splashADListener, int i) {
        this(context, view, str, str2, splashADListener, i, (View) null);
    }

    @Deprecated
    public SplashAD(Context context, View view, String str, String str2, SplashADListener splashADListener, int i, View view2) {
        this(context, view, str, str2, splashADListener, i, null, view2);
    }

    @Deprecated
    public SplashAD(Context context, View view, String str, String str2, SplashADListener splashADListener, int i, Map map, View view2) {
        this.f38233e = false;
        GDTLogger.w("此构造方法即将废弃，请在 Application 中初始化 SDK 后，使用不带 appId 的构造方法，详细请参考Demo");
        a(context, view, str, str2, splashADListener, i, map, view2);
    }

    public SplashAD(Context context, String str, SplashADListener splashADListener) {
        this(context, str, splashADListener, 0);
    }

    public SplashAD(Context context, String str, SplashADListener splashADListener, int i) {
        this(context, (View) null, str, splashADListener, i);
    }

    @Deprecated
    public SplashAD(Context context, String str, String str2, SplashADListener splashADListener) {
        this(context, str, str2, splashADListener, 0);
    }

    @Deprecated
    public SplashAD(Context context, String str, String str2, SplashADListener splashADListener, int i) {
        this(context, (View) null, str, str2, splashADListener, i);
    }

    private void a(final Context context, final View view, final String str, final String str2, final SplashADListener splashADListener, final int i, final Map map, final View view2) {
        this.f38231c = splashADListener;
        if (StringUtil.isEmpty(str) || StringUtil.isEmpty(str2) || context == null) {
            GDTLogger.e(String.format("SplashAD Constructor params error, appid=%s,posId=%s,context=%s", str, str2, context));
            a(splashADListener, 2001);
        } else if (a.a(context)) {
            GDTADManager.INIT_EXECUTOR.execute(new Runnable() { // from class: com.qq.e.ads.splash.SplashAD.1
                @Override // java.lang.Runnable
                public void run() {
                    if (GDTADManager.getInstance().initWith(context, str)) {
                        try {
                            final POFactory pOFactory = GDTADManager.getInstance().getPM().getPOFactory();
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.qq.e.ads.splash.SplashAD.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    try {
                                        if (pOFactory == null) {
                                            GDTLogger.e("factory return null");
                                            SplashAD.this.a(splashADListener, (int) ErrorCode.POFACTORY_GET_INTERFACE_ERROR);
                                            return;
                                        }
                                        SplashAD.this.f38229a = pOFactory.getNativeSplashAdView(context, str, str2);
                                        if (SplashAD.this.f38229a == null) {
                                            GDTLogger.e("SplashAdView created by factory return null");
                                            SplashAD.this.a(splashADListener, (int) ErrorCode.POFACTORY_GET_INTERFACE_ERROR);
                                            return;
                                        }
                                        if (SplashAD.this.f38232d != null) {
                                            SplashAD.this.f38229a.setLoadAdParams(SplashAD.this.f38232d);
                                        }
                                        SplashAD.a(SplashAD.this, map, str2);
                                        SplashAD.this.f38229a.setFetchDelay(i);
                                        SplashAD.this.f38229a.setAdListener(new ADListenerAdapter(SplashAD.this, (byte) 0));
                                        SplashAD.this.f38229a.setSkipView(view);
                                        SplashAD.this.f38229a.setFloatView(view2);
                                        SplashAD.this.f38229a.setAdLogoMargin(SplashAD.this.f38235g, SplashAD.this.f38236h);
                                        SplashAD.this.f38229a.setPreloadView(SplashAD.this.i);
                                        if ((splashADListener instanceof SplashADZoomOutListener) && ((SplashADZoomOutListener) splashADListener).isSupportZoomOut()) {
                                            SplashAD.this.f38229a.setSupportZoomOut(true);
                                        }
                                        if (SplashAD.this.f38230b != null) {
                                            SplashAD.this.fetchAndShowIn(SplashAD.this.f38230b);
                                        }
                                        if (SplashAD.this.f38233e) {
                                            SplashAD.this.f38229a.preload();
                                            SplashAD.this.f38233e = false;
                                        }
                                        if (SplashAD.this.f38234f) {
                                            SplashAD.this.f38229a.fetchAdOnly();
                                            SplashAD.this.f38234f = false;
                                        }
                                    } catch (Throwable th) {
                                        GDTLogger.e("Unknown Exception", th);
                                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                        SplashAD.this.a(splashADListener, 6000);
                                    }
                                }
                            });
                        } catch (c e2) {
                            GDTLogger.e("Fail to init splash plugin", e2);
                            SplashAD.this.a(splashADListener, 200102);
                        } catch (Throwable th) {
                            GDTLogger.e("Unknown Exception", th);
                            SplashAD.this.a(splashADListener, 6000);
                        }
                    }
                }
            });
        } else {
            GDTLogger.e("Required Activity/Service/Permission Not Declared in AndroidManifest.xml");
            a(splashADListener, 4002);
        }
    }

    public static /* synthetic */ void a(SplashAD splashAD, Map map, String str) {
        if (map == null || map.size() <= 0) {
            return;
        }
        try {
            GDTADManager.getInstance().getSM().setDEVCodeSetting(Constants.KEYS.AD_TAGS, new JSONObject(map), str);
        } catch (Exception e2) {
            GDTLogger.e("SplashAD#setTag Exception");
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final SplashADListener splashADListener, final int i) {
        if (splashADListener != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.qq.e.ads.splash.SplashAD.2
                @Override // java.lang.Runnable
                public void run() {
                    splashADListener.onNoAD(AdErrorConvertor.formatErrorCode(i));
                }
            });
        }
    }

    public final void fetchAdOnly() {
        if (this.f38229a == null) {
            this.f38234f = true;
            return;
        }
        GDTLogger.e("splashAD fetchAdOnly");
        this.f38229a.fetchAdOnly();
    }

    public final void fetchAndShowIn(ViewGroup viewGroup) {
        if (viewGroup == null) {
            GDTLogger.e("SplashAD fetchAndShowIn params null ");
            a(this.f38231c, 2001);
        } else if (this.f38229a != null) {
            this.f38229a.fetchAndShowIn(viewGroup);
        } else {
            this.f38230b = viewGroup;
        }
    }

    public final String getAdNetWorkName() {
        if (this.f38229a != null) {
            return this.f38229a.getAdNetWorkName();
        }
        GDTLogger.e("The ad does not support \"getAdNetWorkName\" or you should call this method after \"onAdPresent\"");
        return null;
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public final String getApkInfoUrl() {
        if (this.f38229a != null) {
            return this.f38229a.getApkInfoUrl();
        }
        return null;
    }

    public final String getECPMLevel() {
        if (this.f38229a != null) {
            return this.f38229a.getECPMLevel();
        }
        GDTLogger.e("The ad does not support \"getECPMLevel\" or you should call this method after \"onAdPresent\"");
        return null;
    }

    public final Map getExt() {
        try {
            return NSPVI.ext;
        } catch (Exception e2) {
            GDTLogger.e("splash ad can not get extra");
            e2.printStackTrace();
            return null;
        }
    }

    public final Bitmap getZoomOutBitmap() {
        if (this.f38229a != null) {
            return this.f38229a.getZoomOutBitmap();
        }
        return null;
    }

    @Override // com.qq.e.comm.compliance.DownloadConfirmListener
    public final void onDownloadConfirm(Activity activity, int i, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
        DownloadConfirmListener downloadConfirmListener = this.j;
        if (downloadConfirmListener != null) {
            downloadConfirmListener.onDownloadConfirm(activity, i, str, downloadConfirmCallBack);
        }
    }

    public final void preLoad() {
        if (this.f38229a != null) {
            this.f38229a.preload();
        } else {
            this.f38233e = true;
        }
    }

    public final void setAdLogoMargin(int i, int i2) {
        this.f38235g = i;
        this.f38236h = i2;
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public final void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        this.j = downloadConfirmListener;
        if (this.f38229a != null) {
            this.f38229a.setDownloadConfirmListener(this);
        }
    }

    public final void setLoadAdParams(LoadAdParams loadAdParams) {
        if (this.f38229a != null) {
            this.f38229a.setLoadAdParams(loadAdParams);
        } else {
            this.f38232d = loadAdParams;
        }
    }

    public final void setPreloadView(View view) {
        if (this.f38229a != null) {
            this.f38229a.setPreloadView(view);
        } else {
            this.i = view;
        }
    }

    public final void showAd(ViewGroup viewGroup) {
        if (viewGroup == null) {
            GDTLogger.e("SplashAD showAd params null ");
            a(this.f38231c, 2001);
        } else if (this.f38229a != null) {
            this.f38229a.showAd(viewGroup);
        } else {
            this.f38230b = viewGroup;
        }
    }

    public final void zoomOutAnimationFinish() {
        if (this.f38229a != null) {
            this.f38229a.zoomOutAnimationFinish();
        }
    }
}
