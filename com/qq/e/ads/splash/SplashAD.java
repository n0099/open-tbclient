package com.qq.e.ads.splash;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.mapapi.UIMsg;
import com.qq.e.comm.a;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.constants.ErrorCode;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.NSPVI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public final class SplashAD {

    /* renamed from: a  reason: collision with root package name */
    private volatile NSPVI f11523a;

    /* renamed from: b  reason: collision with root package name */
    private volatile ViewGroup f11524b;
    private volatile SplashADListener c;
    private volatile LoadAdParams d;
    private volatile boolean e;
    private volatile boolean f;
    private int g;
    private int h;
    private volatile View i;

    /* loaded from: classes15.dex */
    private class ADListenerAdapter implements ADListener {
        private ADListenerAdapter() {
        }

        /* synthetic */ ADListenerAdapter(SplashAD splashAD, byte b2) {
            this();
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            if (SplashAD.this.c == null) {
                GDTLogger.e("SplashADListener == null");
                return;
            }
            Object[] paras = aDEvent.getParas();
            switch (aDEvent.getType()) {
                case 1:
                    SplashAD.this.c.onADDismissed();
                    return;
                case 2:
                    if (paras.length <= 0 || !(paras[0] instanceof Integer)) {
                        GDTLogger.e("Splash onNoAD event get params error.");
                        return;
                    } else {
                        SplashAD.this.c.onNoAD(a.a(((Integer) paras[0]).intValue()));
                        return;
                    }
                case 3:
                    SplashAD.this.c.onADPresent();
                    return;
                case 4:
                    SplashAD.this.c.onADClicked();
                    return;
                case 5:
                    if (paras.length == 1 && (paras[0] instanceof Long)) {
                        SplashAD.this.c.onADTick(((Long) paras[0]).longValue());
                        return;
                    } else {
                        GDTLogger.e("Splash onADTick event get param error.");
                        return;
                    }
                case 6:
                    SplashAD.this.c.onADExposure();
                    return;
                case 7:
                    if (paras.length == 1 && (paras[0] instanceof Long)) {
                        SplashAD.this.c.onADLoaded(((Long) paras[0]).longValue());
                        return;
                    } else {
                        GDTLogger.e("Splash onADLoaded event get param error.");
                        return;
                    }
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
        this.e = false;
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
        this.e = false;
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
        this.c = splashADListener;
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
                                            SplashAD.this.a(splashADListener, 200103);
                                            return;
                                        }
                                        SplashAD.this.f11523a = pOFactory.getNativeSplashAdView(context, str, str2);
                                        if (SplashAD.this.f11523a == null) {
                                            GDTLogger.e("SplashAdView created by factory return null");
                                            SplashAD.this.a(splashADListener, 200103);
                                            return;
                                        }
                                        if (SplashAD.this.d != null) {
                                            SplashAD.this.f11523a.setLoadAdParams(SplashAD.this.d);
                                        }
                                        SplashAD.a(SplashAD.this, map, str2);
                                        SplashAD.this.f11523a.setFetchDelay(i);
                                        SplashAD.this.f11523a.setAdListener(new ADListenerAdapter(SplashAD.this, (byte) 0));
                                        SplashAD.this.f11523a.setSkipView(view);
                                        SplashAD.this.f11523a.setFloatView(view2);
                                        SplashAD.this.f11523a.setAdLogoMargin(SplashAD.this.g, SplashAD.this.h);
                                        SplashAD.this.f11523a.setPreloadView(SplashAD.this.i);
                                        if (SplashAD.this.f11524b != null) {
                                            SplashAD.this.fetchAndShowIn(SplashAD.this.f11524b);
                                        }
                                        if (SplashAD.this.e) {
                                            SplashAD.this.f11523a.preload();
                                            SplashAD.this.e = false;
                                        }
                                        if (SplashAD.this.f) {
                                            SplashAD.this.f11523a.fetchAdOnly();
                                            SplashAD.this.f = false;
                                        }
                                    } catch (Throwable th) {
                                        GDTLogger.e("Unknown Exception", th);
                                        SplashAD.this.a(splashADListener, (int) ErrorCode.OtherError.UNKNOWN_ERROR);
                                    }
                                }
                            });
                        } catch (com.qq.e.comm.managers.plugin.a e) {
                            GDTLogger.e("Fail to init splash plugin", e);
                            SplashAD.this.a(splashADListener, (int) UIMsg.f_FUN.FUN_ID_VOICE_SCH_OPTION);
                        } catch (Throwable th) {
                            GDTLogger.e("Unknown Exception", th);
                            SplashAD.this.a(splashADListener, (int) ErrorCode.OtherError.UNKNOWN_ERROR);
                        }
                    }
                }
            });
        } else {
            GDTLogger.e("Required Activity/Service/Permission Not Declared in AndroidManifest.xml");
            a(splashADListener, 4002);
        }
    }

    static /* synthetic */ void a(SplashAD splashAD, Map map, String str) {
        if (map == null || map.size() <= 0) {
            return;
        }
        try {
            GDTADManager.getInstance().getSM().setDEVCodeSetting(Constants.KEYS.AD_TAGS, new JSONObject(map), str);
        } catch (Exception e) {
            GDTLogger.e("SplashAD#setTag Exception");
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final SplashADListener splashADListener, final int i) {
        if (splashADListener != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.qq.e.ads.splash.SplashAD.2
                @Override // java.lang.Runnable
                public void run() {
                    splashADListener.onNoAD(a.a(i));
                }
            });
        }
    }

    public final void fetchAdOnly() {
        if (this.f11523a == null) {
            this.f = true;
            return;
        }
        GDTLogger.e("splashAD fetchAdOnly");
        this.f11523a.fetchAdOnly();
    }

    public final void fetchAndShowIn(ViewGroup viewGroup) {
        if (viewGroup == null) {
            GDTLogger.e("SplashAD fetchAndShowIn params null ");
            a(this.c, 2001);
        } else if (this.f11523a != null) {
            this.f11523a.fetchAndShowIn(viewGroup);
        } else {
            this.f11524b = viewGroup;
        }
    }

    public final String getAdNetWorkName() {
        if (this.f11523a != null) {
            return this.f11523a.getAdNetWorkName();
        }
        GDTLogger.e("The ad does not support \"getAdNetWorkName\" or you should call this method after \"onAdPresent\"");
        return null;
    }

    public final String getECPMLevel() {
        if (this.f11523a != null) {
            return this.f11523a.getECPMLevel();
        }
        GDTLogger.e("The ad does not support \"getECPMLevel\" or you should call this method after \"onAdPresent\"");
        return null;
    }

    public final Map getExt() {
        try {
            NSPVI nspvi = this.f11523a;
            return NSPVI.ext;
        } catch (Exception e) {
            GDTLogger.e("splash ad can not get extra");
            e.printStackTrace();
            return null;
        }
    }

    public final void preLoad() {
        if (this.f11523a != null) {
            this.f11523a.preload();
        } else {
            this.e = true;
        }
    }

    public final void setAdLogoMargin(int i, int i2) {
        this.g = i;
        this.h = i2;
    }

    public final void setLoadAdParams(LoadAdParams loadAdParams) {
        if (this.f11523a != null) {
            this.f11523a.setLoadAdParams(loadAdParams);
        } else {
            this.d = loadAdParams;
        }
    }

    public final void setPreloadView(View view) {
        if (this.f11523a != null) {
            this.f11523a.setPreloadView(view);
        } else {
            this.i = view;
        }
    }

    public final void showAd(ViewGroup viewGroup) {
        if (viewGroup == null) {
            GDTLogger.e("SplashAD showAd params null ");
            a(this.c, 2001);
        } else if (this.f11523a != null) {
            this.f11523a.showAd(viewGroup);
        } else {
            this.f11524b = viewGroup;
        }
    }
}
