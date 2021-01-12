package com.qq.e.comm.plugin.intersitial2;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.mobstat.Config;
import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.interstitial2.UnifiedInterstitialADListener;
import com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.ads.nativ.NativeExpressMediaListener;
import com.qq.e.comm.pi.AdData;
import com.qq.e.comm.pi.UIADI;
import com.qq.e.comm.plugin.ad.l;
import com.qq.e.comm.plugin.util.ad;
import com.qq.e.comm.plugin.util.ai;
import com.qq.e.comm.plugin.util.ak;
import com.qq.e.comm.plugin.util.ao;
import com.qq.e.comm.plugin.util.m;
import com.qq.e.comm.plugin.util.w;
import com.qq.e.comm.util.AdError;
import com.qq.e.comm.util.GDTLogger;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e implements DialogInterface.OnDismissListener, UIADI, com.qq.e.comm.plugin.r.a {

    /* renamed from: a  reason: collision with root package name */
    private final com.qq.e.comm.plugin.intersitial2.a f12107a;

    /* renamed from: b  reason: collision with root package name */
    private final g f12108b;
    private com.qq.e.comm.plugin.intersitial2.fullscreen.d c;
    private final UnifiedInterstitialADListener d;
    private volatile UnifiedInterstitialMediaListener e;
    private final String f;
    private final String g;
    private WeakReference<Activity> h;
    private Dialog i;
    private ad j;
    private boolean k;
    private boolean l;
    private final double m;
    private ImageView n;
    private com.qq.e.comm.plugin.y.c o;
    private boolean p;
    private boolean q;

    /* loaded from: classes3.dex */
    public interface a {
        void a(boolean z);
    }

    public e(Activity activity, String str, String str2, UnifiedInterstitialADListener unifiedInterstitialADListener) {
        this(activity, str, str2, l.DEFAULT, unifiedInterstitialADListener);
    }

    public e(Activity activity, String str, String str2, l lVar, UnifiedInterstitialADListener unifiedInterstitialADListener) {
        this.j = new ad();
        this.l = false;
        this.m = h.a();
        this.n = null;
        this.o = new com.qq.e.comm.plugin.y.c();
        this.f = str;
        this.g = str2;
        this.h = new WeakReference<>(activity);
        this.d = unifiedInterstitialADListener;
        this.f12107a = new com.qq.e.comm.plugin.intersitial2.a(this, unifiedInterstitialADListener, str2, new a() { // from class: com.qq.e.comm.plugin.intersitial2.e.1
            @Override // com.qq.e.comm.plugin.intersitial2.e.a
            public void a(boolean z) {
                e.this.q = z;
            }
        });
        this.f12108b = new g(activity, new ADSize(-1, -2), str, str2, lVar, this.f12107a);
        this.c = new com.qq.e.comm.plugin.intersitial2.fullscreen.d(activity, new ADSize(-1, -2), str, str2, lVar, this.f12107a);
        this.o.a(str2);
    }

    private int a(Point point, Point point2) {
        double d = this.m;
        if (d()) {
            d = h.b();
        }
        ai.a("isVideo = %b, rate = %d", Boolean.valueOf(d()), Integer.valueOf((int) (100.0d * d)));
        if (point.x < point.y) {
            return (int) (d * point.x);
        }
        if (point2.x >= point2.y || !h.a(this.g)) {
            if (point.x <= 0 || point.y <= 0 || point2.x <= 0 || point2.y <= 0) {
                return 0;
            }
            return (int) (((d * point2.x) * point.y) / point2.y);
        }
        return 0;
    }

    private void a(boolean z, Activity activity) {
        if (activity == null) {
            GDTLogger.e("Activity param for doshow Method should not be null");
        } else if (activity.getWindow() == null) {
            GDTLogger.e("Activity's Window should not be null");
        } else {
            com.qq.e.comm.plugin.ad.e eVar = com.qq.e.comm.plugin.ad.e.UNIFIED_INTERSTITIAL;
            c.a(eVar, d(), this.o);
            if (this.i != null && this.i.isShowing()) {
                GDTLogger.e("UnifiedInterstitialAD is showing , please do not call show right now !");
                c.a(eVar, d(), 4015, this.o);
            } else if (this.k) {
                GDTLogger.e("UnifiedInterstitialAD has shown , please loadAd again !");
                c.a(eVar, d(), 4015, this.o);
            } else {
                NativeExpressADView a2 = this.f12107a.a();
                if (a2 == null) {
                    GDTLogger.e("cannot show before AD ready !");
                    c.a(eVar, d(), 4014, this.o);
                    return;
                }
                a2.setMediaListener(new NativeExpressMediaListener() { // from class: com.qq.e.comm.plugin.intersitial2.e.2
                    @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                    public void onVideoCached(NativeExpressADView nativeExpressADView) {
                    }

                    @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                    public void onVideoComplete(NativeExpressADView nativeExpressADView) {
                        if (e.this.e != null) {
                            e.this.e.onVideoComplete();
                        }
                        if (e.this.n != null) {
                            e.this.n.setVisibility(8);
                        }
                    }

                    @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                    public void onVideoError(NativeExpressADView nativeExpressADView, AdError adError) {
                        if (e.this.e != null) {
                            e.this.e.onVideoError(adError);
                        }
                        if (e.this.n != null) {
                            e.this.n.setVisibility(8);
                        }
                    }

                    @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                    public void onVideoInit(NativeExpressADView nativeExpressADView) {
                        if (e.this.e != null) {
                            e.this.e.onVideoInit();
                        }
                    }

                    @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                    public void onVideoLoading(NativeExpressADView nativeExpressADView) {
                        if (e.this.e != null) {
                            e.this.e.onVideoLoading();
                        }
                    }

                    @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                    public void onVideoPageClose(NativeExpressADView nativeExpressADView) {
                        if (e.this.e != null) {
                            e.this.e.onVideoPageClose();
                        }
                    }

                    @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                    public void onVideoPageOpen(NativeExpressADView nativeExpressADView) {
                        if (e.this.e != null) {
                            e.this.e.onVideoPageOpen();
                        }
                    }

                    @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                    public void onVideoPause(NativeExpressADView nativeExpressADView) {
                        if (e.this.e != null) {
                            e.this.e.onVideoPause();
                        }
                    }

                    @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                    public void onVideoReady(NativeExpressADView nativeExpressADView, long j) {
                        if (e.this.e != null) {
                            e.this.e.onVideoReady(j);
                        }
                    }

                    @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                    public void onVideoStart(NativeExpressADView nativeExpressADView) {
                        if (e.this.e != null) {
                            e.this.e.onVideoStart();
                        }
                        if (e.this.n != null) {
                            e.this.n.setVisibility(0);
                        }
                    }
                });
                this.i = new Dialog(activity);
                this.i.setOnDismissListener(this);
                this.i.setCanceledOnTouchOutside(false);
                this.i.setOwnerActivity(activity);
                Window window = this.i.getWindow();
                if (window == null) {
                    GDTLogger.e("Dialog Window should not be null");
                    return;
                }
                window.setBackgroundDrawable(new ColorDrawable(0));
                this.i.setFeatureDrawableAlpha(0, 0);
                this.i.requestWindowFeature(1);
                if (z) {
                    window.addFlags(2);
                    window.clearFlags(32);
                } else {
                    window.clearFlags(2);
                    window.addFlags(32);
                }
                if (a2.getParent() != null) {
                    ((ViewGroup) a2.getParent()).removeView(a2);
                }
                Point point = new Point();
                activity.getWindowManager().getDefaultDisplay().getSize(point);
                Point point2 = a2.getTag() instanceof Point ? (Point) a2.getTag() : new Point();
                int a3 = a(point, point2);
                if (a3 <= 0) {
                    GDTLogger.e("Layout Error !");
                    c.a(eVar, d(), 4005, this.o);
                    return;
                }
                if (d()) {
                    if (window != null && h.c()) {
                        window.addFlags(16777216);
                    }
                    Context applicationContext = activity.getApplicationContext();
                    ImageView imageView = new ImageView(applicationContext);
                    imageView.setImageBitmap(ao.a("iVBORw0KGgoAAAANSUhEUgAAAFQAAABUCAMAAAArteDzAAAAOVBMVEUAAAAAAADJyckAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAD09PS+vr4AAAAAAADDw8P///8gbgZqAAAAEnRSTlNAAJsnBTwKMDQ4KxgU348dHJQg6cWiAAABv0lEQVRYw7TW0XKDIBCF4ZPssiCQxPr+D1vambZpko1Hhf+WmW9QEcBpLas3iWkKQJhSlFu101rvUS0y4alJihKoI0a4xaI7UJOAtwWxjahlEGXbgKqATJRF5wC6MFOoJWwq2TpaAzYW6hoq2JG8RTVjV1l9VCN2FtVDNWF36V4FMU9+rs9oxqHyK1RwMHlGKw5XH1ELOFywBzShQ+k/OqNL8z2qAV0KeocKOiV/qKFb9otmdCv/oAb0nSr4N8q/Vfif/nr5QMsbvPoLoKEFr7ssyxlO52W5OEPlG43eZJamuubiPUb8QhX+dJrqD3hpQwsYlTdRGipgVN6ENHQCo/ImphMMYFTeBAwVnMqbjbyBU3mzkQJO5U0IIjiVNxuZQKq02cgJrMqajQxgVdZ0SE89g2sIOuTxh3yoIUtqyOIf8psO2VCGbH1DNukRx8mQg2/IET3oMuFfez6bs4MTAEAYCIIf/Qrpv1krOBFhMKkhj9vdOs+elV7fDbQx81qMV3lKitFL5rkACYI8As4IRgrgFWhOJILQHULMCIVEZJfQckIgCtUJpKzQx0J0AyUv4gHIHP+DzE066hO53nPcBuKXGs07rkSBAAAAAElFTkSuQmCC"));
                    int a4 = ak.a(applicationContext, 24);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a4, a4);
                    layoutParams.gravity = 53;
                    int a5 = ak.a(applicationContext, 8);
                    layoutParams.rightMargin = a5;
                    layoutParams.topMargin = a5;
                    a2.addView(imageView, layoutParams);
                    this.n = new ImageView(applicationContext);
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(ak.a(applicationContext, 46), ak.a(applicationContext, 14));
                    layoutParams2.gravity = 8388693;
                    a2.addView(this.n, layoutParams2);
                    this.n.setVisibility(8);
                    com.qq.e.comm.plugin.util.g.a(this.n, com.qq.e.comm.plugin.ad.e.UNIFIED_INTERSTITIAL);
                    imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qq.e.comm.plugin.intersitial2.e.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            e.this.close();
                        }
                    });
                }
                this.i.setContentView(a2, new ViewGroup.LayoutParams(a3, (point2.x <= 0 || point2.y <= 0) ? -2 : (point2.y * a3) / point2.x));
                this.j.a(activity);
                if (!com.qq.e.comm.plugin.util.f.a(activity)) {
                    GDTLogger.e("构造插屏广告时的Activity已经被系统回收，如果需要跨Activity展示插屏广告请在show方法中指定Activity参数");
                    return;
                }
                this.i.show();
                this.k = true;
                w.a(new Runnable() { // from class: com.qq.e.comm.plugin.intersitial2.e.4
                    @Override // java.lang.Runnable
                    public void run() {
                        e.this.d.onADOpened();
                    }
                });
            }
        }
    }

    private boolean d() {
        NativeExpressADView a2 = this.f12107a.a();
        if (a2 == null) {
            return false;
        }
        try {
            return !m.a(new JSONObject(a2.getBoundData().getProperty("ad_info")).optString("video"));
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int a() {
        return this.f12108b.f();
    }

    public void a(JSONObject jSONObject) {
        this.o.b(jSONObject.optString(Config.CELL_LOCATION));
        this.o.c(jSONObject.optString("traceid"));
    }

    public void b() {
        if (this.i == null || !d()) {
            return;
        }
        this.i.cancel();
        this.l = true;
    }

    public void c() {
        if (this.i == null || !d()) {
            return;
        }
        if (!com.qq.e.comm.plugin.util.f.a(this.i.getOwnerActivity())) {
            GDTLogger.e("构造插屏广告时的Activity已经被系统回收，如果需要跨Activity展示插屏广告请在show方法中指定Activity参数");
            return;
        }
        this.i.show();
        this.l = false;
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void close() {
        if (this.i != null) {
            this.i.dismiss();
        }
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void destory() {
        NativeExpressADView a2 = this.f12107a.a();
        if (a2 != null) {
            a2.destroy();
        }
        if (this.i != null) {
            this.i.dismiss();
        }
    }

    @Override // com.qq.e.comm.pi.UIADI
    public String getAdNetWorkName() {
        return null;
    }

    @Override // com.qq.e.comm.pi.UIADI
    public int getAdPatternType() {
        if (this.p) {
            AdData b2 = this.f12107a.b();
            if (b2 == null) {
                return 0;
            }
            return b2.getAdPatternType();
        }
        NativeExpressADView a2 = this.f12107a.a();
        if (a2 != null) {
            return a2.getBoundData().getAdPatternType();
        }
        return 0;
    }

    @Override // com.qq.e.comm.pi.UIADI
    public int getECPM() {
        if (this.p) {
            AdData b2 = this.f12107a.b();
            if (b2 == null) {
                return -1;
            }
            return b2.getECPM();
        }
        NativeExpressADView a2 = this.f12107a.a();
        if (a2 == null) {
            GDTLogger.e("Can't getECPM before AD ready!");
            return -1;
        }
        AdData boundData = a2.getBoundData();
        if (boundData != null) {
            return boundData.getECPM();
        }
        GDTLogger.e("AD Parse failed, can't getECPM");
        return -1;
    }

    @Override // com.qq.e.comm.pi.UIADI
    public String getECPMLevel() {
        if (this.p) {
            AdData b2 = this.f12107a.b();
            if (b2 == null) {
                return null;
            }
            return b2.getECPMLevel();
        }
        NativeExpressADView a2 = this.f12107a.a();
        if (a2 == null) {
            GDTLogger.e("Can't getECPMLevel before AD ready!");
            return null;
        }
        AdData boundData = a2.getBoundData();
        if (boundData != null) {
            return boundData.getECPMLevel();
        }
        GDTLogger.e("AD Parse failed, can't getECPMLevel");
        return null;
    }

    @Override // com.qq.e.comm.plugin.r.a
    public int getMediationPrice() {
        return this.f12108b.getMediationPrice();
    }

    @Override // com.qq.e.comm.plugin.r.a
    public boolean isContractAd() {
        return this.f12108b.isContractAd();
    }

    @Override // com.qq.e.comm.pi.UIADI
    public boolean isValid() {
        return this.q;
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void loadAd() {
        this.p = false;
        this.f12108b.loadAd(com.qq.e.comm.plugin.ad.e.UNIFIED_INTERSTITIAL.c());
        Activity activity = this.h.get();
        if (activity != null) {
            activity.getWindowManager().getDefaultDisplay().getSize(new Point());
        }
        this.k = false;
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void loadFullScreenAD() {
        this.p = true;
        this.c.loadAd(com.qq.e.comm.plugin.ad.e.UNIFIED_INTERSTITIAL.c());
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.l) {
            return;
        }
        destory();
        this.j.a();
        w.a(new Runnable() { // from class: com.qq.e.comm.plugin.intersitial2.e.6
            @Override // java.lang.Runnable
            public void run() {
                e.this.d.onADClosed();
            }
        });
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void setDownAPPConfirmPolicy(DownAPPConfirmPolicy downAPPConfirmPolicy) {
        this.f12108b.setDownAPPConfirmPolicy(downAPPConfirmPolicy);
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void setMaxVideoDuration(int i) {
        this.f12108b.setMaxVideoDuration(i);
        this.c.setMaxVideoDuration(i);
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void setMediaListener(UnifiedInterstitialMediaListener unifiedInterstitialMediaListener) {
        this.e = unifiedInterstitialMediaListener;
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void setMinVideoDuration(int i) {
        this.f12108b.setMinVideoDuration(i);
        this.c.setMinVideoDuration(i);
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void setVideoOption(VideoOption videoOption) {
        this.f12108b.setVideoOption(videoOption);
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void setVideoPlayPolicy(int i) {
        this.f12108b.setVideoPlayPolicy(i);
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void show() {
        Activity activity = this.h.get();
        if (activity == null) {
            GDTLogger.e("构造插屏广告时的Activity已经被系统回收，如果需要跨Activity展示插屏广告请在show方法中指定Activity参数");
        } else {
            show(activity);
        }
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void show(Activity activity) {
        a(true, activity);
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void showAsPopupWindow() {
        Activity activity = this.h.get();
        if (activity == null) {
            GDTLogger.e("构造插屏广告时的Activity已经被系统回收，如果需要跨Activity展示插屏广告请在showAsPopupWindown方法中指定Activity参数");
        } else {
            showAsPopupWindow(activity);
        }
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void showAsPopupWindow(Activity activity) {
        a(false, activity);
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void showFullScreenAD(Activity activity) {
        if (activity == null) {
            GDTLogger.e("Activity param for show should not be null");
            return;
        }
        com.qq.e.comm.plugin.ad.e eVar = com.qq.e.comm.plugin.ad.e.UNIFIED_INTERSTITIAL_FULLSCREEN;
        c.a(eVar, true, this.o);
        JSONObject a2 = this.c.a();
        if (a2 == null) {
            GDTLogger.e("UnifiedInterstitial full screen video AD null , please loadAd again !");
            c.a(eVar, true, 4014, this.o);
        } else if (this.c == null) {
            c.a(eVar, true, 5024, this.o);
        } else {
            com.qq.e.comm.plugin.intersitial2.fullscreen.a.a(this.f, this.g, this.c.g(), a2, this.d, this.e, new a() { // from class: com.qq.e.comm.plugin.intersitial2.e.5
                @Override // com.qq.e.comm.plugin.intersitial2.e.a
                public void a(boolean z) {
                    e.this.q = z;
                }
            });
        }
    }
}
