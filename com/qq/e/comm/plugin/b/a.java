package com.qq.e.comm.plugin.b;

import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.mobstat.Config;
import com.qq.e.ads.banner2.UnifiedBannerADListener;
import com.qq.e.ads.banner2.UnifiedBannerView;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.plugin.util.ag;
import com.qq.e.comm.plugin.util.ai;
import com.qq.e.comm.plugin.util.ak;
import com.qq.e.comm.plugin.util.w;
import com.qq.e.comm.util.GDTLogger;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
class a implements ADListener {

    /* renamed from: a  reason: collision with root package name */
    private static final String f12210a = a.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private final UnifiedBannerView f12211b;
    private final UnifiedBannerADListener c;
    private NativeExpressADView d;
    private d e;
    private boolean f;
    private com.qq.e.comm.plugin.y.c g = new com.qq.e.comm.plugin.y.c();

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(UnifiedBannerView unifiedBannerView, d dVar, UnifiedBannerADListener unifiedBannerADListener, String str) {
        this.f12211b = unifiedBannerView;
        this.e = dVar;
        this.c = unifiedBannerADListener;
        this.g.a(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.f = false;
    }

    public NativeExpressADView a() {
        return this.d;
    }

    public void a(boolean z) {
        if (z && this.f) {
            w.a(new Runnable() { // from class: com.qq.e.comm.plugin.b.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.c.onADCloseOverlay();
                    a.this.f = false;
                }
            });
        }
    }

    @Override // com.qq.e.comm.adevent.ADListener
    public void onADEvent(final ADEvent aDEvent) {
        w.a(new Runnable() { // from class: com.qq.e.comm.plugin.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                ai.b(a.f12210a, "onADEvent ( %d )", Integer.valueOf(aDEvent.getType()));
                switch (aDEvent.getType()) {
                    case 1:
                        if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof Integer)) {
                            a.this.c.onNoAD(ag.a(((Integer) aDEvent.getParas()[0]).intValue()));
                            return;
                        } else {
                            GDTLogger.e("AdEvent.Params error for UnifiedBannerView(" + aDEvent + ")");
                            return;
                        }
                    case 2:
                        if (aDEvent.getParas().length != 1 || !(aDEvent.getParas()[0] instanceof List) || !(((List) aDEvent.getParas()[0]).get(0) instanceof NativeExpressADView)) {
                            GDTLogger.e("ADEvent.Params error for UnifiedBannerView(" + aDEvent + ")");
                            return;
                        }
                        if (a.this.d != null) {
                            a.this.d.destroy();
                        }
                        a.this.d = (NativeExpressADView) ((List) aDEvent.getParas()[0]).get(0);
                        try {
                            JSONObject jSONObject = new JSONObject(a.this.d.getBoundData().getProperty("ad_info"));
                            a.this.g.b(jSONObject.optString(Config.CELL_LOCATION));
                            a.this.g.c(jSONObject.optString("traceid"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        for (int i = 0; i < a.this.f12211b.getChildCount(); i++) {
                            View childAt = a.this.f12211b.getChildAt(i);
                            if (childAt instanceof NativeExpressADView) {
                                ((NativeExpressADView) childAt).destroy();
                            }
                        }
                        a.this.f12211b.removeAllViews();
                        a.this.f12211b.addView(a.this.d, new FrameLayout.LayoutParams(-1, -1));
                        a.this.d.render();
                        a.this.c.onADReceive();
                        a.this.c();
                        return;
                    case 3:
                    case 4:
                    default:
                        return;
                    case 5:
                        if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                            a.this.c.onADExposure();
                        } else {
                            GDTLogger.e("ADEvent.Params error for UnifiedBannerView(" + aDEvent + ")");
                        }
                        com.qq.e.comm.plugin.y.d dVar = new com.qq.e.comm.plugin.y.d();
                        dVar.a("width", Integer.valueOf(ak.b(a.this.d.getContext(), a.this.d.getWidth())));
                        dVar.a("heignt", Integer.valueOf(ak.b(a.this.d.getContext(), a.this.d.getHeight())));
                        return;
                    case 6:
                        if (aDEvent.getParas().length != 2 || !(aDEvent.getParas()[0] instanceof NativeExpressADView) || !(aDEvent.getParas()[1] instanceof String)) {
                            GDTLogger.e("ADEvent.Params error for UnifiedBannerView(" + aDEvent + ")");
                            return;
                        }
                        String str = (String) aDEvent.getParas()[1];
                        if (!TextUtils.isEmpty(str)) {
                            try {
                                d unused = a.this.e;
                                d.ext.put(Constants.KEYS.EXPOSED_CLICK_URL_KEY, str);
                            } catch (Exception e2) {
                                GDTLogger.e("banner2 set click url error");
                                e2.printStackTrace();
                            }
                        }
                        a.this.c.onADClicked();
                        return;
                    case 7:
                        if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                            a.this.c.onADClosed();
                            return;
                        } else {
                            GDTLogger.e("ADEvent.Params error for UnifiedBannerView(" + aDEvent + ")");
                            return;
                        }
                    case 8:
                        if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                            a.this.c.onADLeftApplication();
                            return;
                        } else {
                            GDTLogger.e("ADEvent.Params error for UnifiedBannerView(" + aDEvent + ")");
                            return;
                        }
                    case 9:
                        if (aDEvent.getParas().length != 1 || !(aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                            GDTLogger.e("ADEvent.Params error for UnifiedBannerView(" + aDEvent + ")");
                            return;
                        }
                        a.this.c.onADOpenOverlay();
                        a.this.f = true;
                        return;
                    case 10:
                        if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                            a.this.c.onADCloseOverlay();
                            return;
                        } else {
                            GDTLogger.e("ADEvent.Params error for UnifiedBannerView(" + aDEvent + ")");
                            return;
                        }
                }
            }
        });
    }
}
