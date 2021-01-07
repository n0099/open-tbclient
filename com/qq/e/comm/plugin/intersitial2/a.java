package com.qq.e.comm.plugin.intersitial2;

import android.text.TextUtils;
import com.qq.e.ads.interstitial2.UnifiedInterstitialADListener;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.pi.AdData;
import com.qq.e.comm.plugin.intersitial2.e;
import com.qq.e.comm.plugin.util.ag;
import com.qq.e.comm.plugin.util.ai;
import com.qq.e.comm.plugin.util.w;
import com.qq.e.comm.util.GDTLogger;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
class a implements ADListener {

    /* renamed from: a  reason: collision with root package name */
    private static final String f12401a = a.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private final UnifiedInterstitialADListener f12402b;
    private final e c;
    private NativeExpressADView d;
    private AdData e;
    private e.a f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(e eVar, UnifiedInterstitialADListener unifiedInterstitialADListener, String str, e.a aVar) {
        this.c = eVar;
        this.f12402b = unifiedInterstitialADListener;
        this.f = aVar;
    }

    public NativeExpressADView a() {
        return this.d;
    }

    public AdData b() {
        return this.e;
    }

    @Override // com.qq.e.comm.adevent.ADListener
    public void onADEvent(final ADEvent aDEvent) {
        w.a(new Runnable() { // from class: com.qq.e.comm.plugin.intersitial2.a.1
            @Override // java.lang.Runnable
            public void run() {
                ai.b(a.f12401a, "onADEvent ( %d )", Integer.valueOf(aDEvent.getType()));
                switch (aDEvent.getType()) {
                    case 1:
                        if (aDEvent.getParas().length != 1 || !(aDEvent.getParas()[0] instanceof Integer)) {
                            GDTLogger.e("AdEvent.Params error for UnifiedBannerView(" + aDEvent + ")");
                            return;
                        }
                        a.this.f12402b.onNoAD(ag.a(((Integer) aDEvent.getParas()[0]).intValue()));
                        if (a.this.f != null) {
                            a.this.f.a(false);
                            return;
                        }
                        return;
                    case 2:
                        if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof List) && (((List) aDEvent.getParas()[0]).get(0) instanceof NativeExpressADView)) {
                            if (a.this.d != null) {
                                a.this.d.destroy();
                            }
                            a.this.d = (NativeExpressADView) ((List) aDEvent.getParas()[0]).get(0);
                            try {
                                a.this.c.a(new JSONObject(a.this.d.getBoundData().getProperty("ad_info")));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            a.this.d.render();
                            return;
                        } else if (aDEvent.getParas().length != 1 || !(aDEvent.getParas()[0] instanceof AdData) || aDEvent.getParas()[0] == null) {
                            GDTLogger.e("ADEvent.Params error for UnifiedBannerView(" + aDEvent + ")");
                            return;
                        } else {
                            if (a.this.e != null) {
                                a.this.e = null;
                            }
                            a.this.e = (AdData) aDEvent.getParas()[0];
                            if (a.this.f12402b != null) {
                                a.this.f12402b.onADReceive();
                            }
                            if (a.this.f != null) {
                                a.this.f.a(true);
                                return;
                            }
                            return;
                        }
                    case 3:
                        if (a.this.d != null) {
                            a.this.d.destroy();
                            a.this.d = null;
                        }
                        a.this.f12402b.onNoAD(ag.a(5007));
                        return;
                    case 4:
                        a.this.f12402b.onADReceive();
                        if (a.this.f != null) {
                            a.this.f.a(true);
                            return;
                        }
                        return;
                    case 5:
                        if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                            a.this.f12402b.onADExposure();
                        } else {
                            GDTLogger.e("ADEvent.Params error for UnifiedBannerView(" + aDEvent + ")");
                        }
                        if (a.this.f != null) {
                            a.this.f.a(false);
                            return;
                        }
                        return;
                    case 6:
                        if (aDEvent.getParas().length != 2 || !(aDEvent.getParas()[0] instanceof NativeExpressADView) || !(aDEvent.getParas()[1] instanceof String)) {
                            GDTLogger.e("ADEvent.Params error for UnifiedBannerView(" + aDEvent + ")");
                            return;
                        }
                        String str = (String) aDEvent.getParas()[1];
                        if (!TextUtils.isEmpty(str)) {
                            try {
                                e unused = a.this.c;
                                e.ext.put(Constants.KEYS.EXPOSED_CLICK_URL_KEY, str);
                            } catch (Exception e2) {
                                GDTLogger.e("interstitial2 set click url error");
                                e2.printStackTrace();
                            }
                        }
                        a.this.f12402b.onADClicked();
                        return;
                    case 7:
                        if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                            a.this.c.close();
                            return;
                        } else {
                            GDTLogger.e("ADEvent.Params error for UnifiedBannerView(" + aDEvent + ")");
                            return;
                        }
                    case 8:
                        if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                            a.this.f12402b.onADLeftApplication();
                            return;
                        } else {
                            GDTLogger.e("ADEvent.Params error for UnifiedBannerView(" + aDEvent + ")");
                            return;
                        }
                    case 9:
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    default:
                        return;
                    case 10:
                        a.this.c.c();
                        return;
                    case 20:
                        a.this.c.b();
                        return;
                    case 21:
                        if (SDKStatus.getSDKVersionCode() >= 60) {
                            a.this.f12402b.onVideoCached();
                            return;
                        }
                        return;
                }
            }
        });
    }
}
