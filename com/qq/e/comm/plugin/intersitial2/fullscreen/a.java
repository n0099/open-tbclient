package com.qq.e.comm.plugin.intersitial2.fullscreen;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.ar.face.algo.FAUEnum;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.qq.e.ads.interstitial2.UnifiedInterstitialADListener;
import com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.ACTD;
import com.qq.e.comm.plugin.ad.g;
import com.qq.e.comm.plugin.c.f;
import com.qq.e.comm.plugin.intersitial2.e;
import com.qq.e.comm.plugin.intersitial2.fullscreen.InterstitialFSEventCenter;
import com.qq.e.comm.plugin.util.aa;
import com.qq.e.comm.plugin.util.af;
import com.qq.e.comm.plugin.util.ai;
import com.qq.e.comm.plugin.util.ar;
import com.qq.e.comm.plugin.util.az;
import com.qq.e.comm.plugin.util.t;
import com.qq.e.comm.plugin.w.a.d;
import com.qq.e.comm.plugin.w.d;
import com.qq.e.comm.plugin.w.i;
import com.qq.e.comm.plugin.y.u;
import com.qq.e.comm.util.AdError;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.util.HashMap;
import org.json.JSONObject;
import yaq.gdtadv;
/* JADX WARN: Classes with same name are omitted:
  assets/yaqgdtadv0.sec
 */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: com.qq.e.comm.plugin.intersitial2.fullscreen.a$2  reason: invalid class name */
    /* loaded from: classes3.dex */
    static final class AnonymousClass2 implements d.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f12422a;

        AnonymousClass2(String str) {
            this.f12422a = str;
        }

        @Override // com.qq.e.comm.plugin.w.d.b
        public void a() {
            GDTLogger.d("GDTNativeExpress FullScreenAD report video info success");
            if (StringUtil.isEmpty(this.f12422a)) {
                return;
            }
            af.a(this.f12422a);
        }

        @Override // com.qq.e.comm.plugin.w.d.b
        public void a(int i, Exception exc) {
            GDTLogger.e("GDTNativeExpress FullScreenAD report video info error");
        }
    }

    /* renamed from: com.qq.e.comm.plugin.intersitial2.fullscreen.a$3  reason: invalid class name */
    /* loaded from: classes3.dex */
    static final class AnonymousClass3 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.s.a f12423a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ g f12424b;
        final /* synthetic */ View c;
        final /* synthetic */ d.b d;

        AnonymousClass3(com.qq.e.comm.plugin.s.a aVar, g gVar, View view, d.b bVar) {
            this.f12423a = aVar;
            this.f12424b = gVar;
            this.c = view;
            this.d = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            String q = this.f12423a.q();
            i.a(this.f12424b.a(this.c, this.f12424b.a().m(), this.f12423a.x(), null), com.qq.e.comm.plugin.ad.a.a().b(this.c), this.f12423a, new com.qq.e.comm.plugin.w.b(this.f12423a.D(), com.qq.e.comm.plugin.ad.e.NATIVEEXPRESSAD, this.f12423a.B()), q, new d.b() { // from class: com.qq.e.comm.plugin.intersitial2.fullscreen.a.3.1
                @Override // com.qq.e.comm.plugin.w.d.b
                public void a() {
                    GDTLogger.d("GDT Native Express FullScreenVideo Cover exposure success");
                    String t = AnonymousClass3.this.f12423a.t();
                    if (!TextUtils.isEmpty(t)) {
                        af.a(t);
                    }
                    if (AnonymousClass3.this.d != null) {
                        AnonymousClass3.this.d.a();
                    }
                }

                @Override // com.qq.e.comm.plugin.w.d.b
                public void a(int i, Exception exc) {
                    GDTLogger.e("GDT Native Express FullScreenVideo Cover exposure error");
                    if (AnonymousClass3.this.d != null) {
                        AnonymousClass3.this.d.a(i, exc);
                    }
                }
            });
        }
    }

    private static void a(com.qq.e.comm.plugin.s.a aVar, View view, int i, String str) {
        int i2 = (!com.qq.e.comm.plugin.util.d.a(aVar.E()) || com.qq.e.comm.plugin.util.b.g(aVar.E())) ? 0 : 1;
        int integerForPlacement = GDTADManager.getInstance().getSM().getIntegerForPlacement(Constants.KEYS.DownConfirm, aVar.B(), 0);
        d.a a2 = i.a(aVar);
        d.e eVar = new d.e(aVar.D(), com.qq.e.comm.plugin.ad.e.NATIVEEXPRESSAD, aVar.B());
        d.b c = new d.b(i2, d.c.InnerBrowser).a(str).b(integerForPlacement).c(i);
        c.i = com.qq.e.comm.plugin.ad.a.a().b(view);
        if (a(i)) {
            a(aVar, com.qq.e.comm.plugin.ad.a.a().b(view), i, str, eVar, c, aVar.y());
        } else {
            com.qq.e.comm.plugin.w.a.d.a(view, a2, eVar, c);
        }
    }

    public static void a(com.qq.e.comm.plugin.s.a aVar, View view, int i, String str, com.qq.e.comm.plugin.c.a.c cVar) {
        if (com.qq.e.comm.plugin.c.e.a(aVar)) {
            com.qq.e.comm.plugin.c.e.a(new f.a(aVar, view).a(i).a(str).b(false).d(a(i)).e(true).a(), cVar);
        } else {
            a(aVar, view, i, str);
        }
    }

    public static void a(com.qq.e.comm.plugin.s.a aVar, View view, g gVar, d.b bVar) {
        gdtadv.getVresult(FAUEnum.PR_TIMEOUT, 1, aVar, view, gVar, bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(com.qq.e.comm.plugin.s.a aVar, com.qq.e.comm.plugin.intersitial2.fullscreen.a.a aVar2, boolean z, int i) {
        gdtadv.getVresult(210, 1, aVar, aVar2, Boolean.valueOf(z), Integer.valueOf(i));
    }

    public static void a(String str, String str2, int i, long j, String str3, String str4, com.qq.e.comm.plugin.y.c cVar) {
        GDTLogger.d("trackWebViewEvent, adType : " + str + " area : " + str2 + " endCardType : " + i + " costTime : " + j + " url : " + str3);
        int i2 = 2020030;
        if (i == 1) {
            i2 = 2020031;
        } else if (i == 2) {
            i2 = 2020034;
        }
        com.qq.e.comm.plugin.y.g b2 = new com.qq.e.comm.plugin.y.g(i2).b(j);
        b2.a(cVar);
        int connValue = GDTADManager.getInstance().getDeviceStatus().getNetworkType().getConnValue();
        com.qq.e.comm.plugin.y.d dVar = new com.qq.e.comm.plugin.y.d();
        dVar.a("adType", str);
        dVar.a(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA, str2);
        dVar.a("nt", Integer.valueOf(connValue));
        dVar.a("wu", str3);
        if (!TextUtils.isEmpty(str4)) {
            dVar.a(TiebaInitialize.LogFields.ERROR_MESSAGE, str4);
        }
        b2.a(dVar);
        u.a(b2);
        if (j > IMConnection.RETRY_DELAY_TIMES) {
            u.a(100352, ((int) j) / 50, cVar, dVar);
        }
    }

    public static void a(String str, String str2, String str3, JSONObject jSONObject, final UnifiedInterstitialADListener unifiedInterstitialADListener, final UnifiedInterstitialMediaListener unifiedInterstitialMediaListener, final e.a aVar) {
        com.qq.e.comm.plugin.ad.e eVar = com.qq.e.comm.plugin.ad.e.UNIFIED_INTERSTITIAL_FULLSCREEN;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            GDTLogger.d("showFullScreenAD appID or posID null");
            com.qq.e.comm.plugin.intersitial2.c.a(eVar, true, 4001, (com.qq.e.comm.plugin.y.c) null);
        } else if (jSONObject == null) {
            GDTLogger.d("showFullScreenAD adData null");
            com.qq.e.comm.plugin.y.c cVar = new com.qq.e.comm.plugin.y.c();
            cVar.a(str2);
            com.qq.e.comm.plugin.intersitial2.c.a(eVar, true, 4014, cVar);
        } else {
            Context appContext = GDTADManager.getInstance().getAppContext();
            Intent intent = new Intent();
            if ("l".equals(GDTADManager.getInstance().getDeviceStatus().getScreenOrientation())) {
                intent.setClassName(appContext, ar.d());
            } else {
                intent.setClassName(appContext, ar.b());
            }
            intent.putExtra(ACTD.DELEGATE_NAME_KEY, "interstitialFullScreen");
            intent.putExtra("appid", str);
            intent.putExtra("posId", str2);
            intent.putExtra("adThreadId", str3);
            intent.putExtra(Constants.KEYS.AD_INFO, jSONObject.toString());
            intent.addFlags(268435456);
            appContext.startActivity(intent);
            final String optString = jSONObject.optString(Config.CELL_LOCATION);
            InterstitialFSEventCenter.a().a(optString, new InterstitialFSEventCenter.a() { // from class: com.qq.e.comm.plugin.intersitial2.fullscreen.a.1
                @Override // com.qq.e.comm.plugin.intersitial2.fullscreen.InterstitialFSEventCenter.a
                public void a(String str4, int i, Object obj) {
                    if (str4.equals(optString)) {
                        switch (i) {
                            case 10001:
                                if (unifiedInterstitialADListener != null) {
                                    unifiedInterstitialADListener.onADOpened();
                                    return;
                                }
                                return;
                            case 10002:
                                if (unifiedInterstitialADListener != null) {
                                    unifiedInterstitialADListener.onADExposure();
                                }
                                if (aVar != null) {
                                    aVar.a(false);
                                    return;
                                }
                                return;
                            case 10003:
                                if (unifiedInterstitialADListener != null) {
                                    unifiedInterstitialADListener.onADClicked();
                                    return;
                                }
                                return;
                            case 10004:
                                if (unifiedInterstitialADListener != null) {
                                    unifiedInterstitialADListener.onADClosed();
                                    return;
                                }
                                return;
                            case 10005:
                                if (unifiedInterstitialADListener != null) {
                                    unifiedInterstitialADListener.onVideoCached();
                                    return;
                                }
                                return;
                            case 10006:
                                if (unifiedInterstitialMediaListener != null) {
                                    unifiedInterstitialMediaListener.onVideoInit();
                                    return;
                                }
                                return;
                            case 10007:
                                if (unifiedInterstitialMediaListener != null) {
                                    unifiedInterstitialMediaListener.onVideoLoading();
                                    return;
                                }
                                return;
                            case 10008:
                                if (unifiedInterstitialMediaListener != null) {
                                    unifiedInterstitialMediaListener.onVideoReady(obj instanceof Long ? ((Long) obj).longValue() : -1L);
                                    return;
                                }
                                return;
                            case 10009:
                                if (unifiedInterstitialMediaListener != null) {
                                    unifiedInterstitialMediaListener.onVideoStart();
                                    return;
                                }
                                return;
                            case 10010:
                                if (unifiedInterstitialMediaListener != null) {
                                    unifiedInterstitialMediaListener.onVideoPause();
                                    return;
                                }
                                return;
                            case 10011:
                                if (unifiedInterstitialMediaListener != null) {
                                    unifiedInterstitialMediaListener.onVideoComplete();
                                    return;
                                }
                                return;
                            case 10012:
                                if (unifiedInterstitialMediaListener != null) {
                                    unifiedInterstitialMediaListener.onVideoError(obj instanceof AdError ? (AdError) obj : null);
                                    return;
                                }
                                return;
                            default:
                                return;
                        }
                    }
                }
            });
        }
    }

    public static boolean a(int i) {
        return i == 10;
    }

    public static boolean a(com.qq.e.comm.plugin.s.a aVar, int i, int i2, String str, d.e eVar, d.b bVar, String str2) {
        String M = aVar.M();
        if (TextUtils.isEmpty(M)) {
            return true;
        }
        String a2 = az.a(M, "s", str);
        if (t.a(a2)) {
            ai.b("gdt_tag_p", "endCard landingPage click, url = %s", a2);
            a2 = t.a(a2, g.a(str, i, "click"));
        }
        com.qq.e.comm.plugin.w.a.d.a(az.c(a2, "click_area", String.valueOf(i2)), aVar, null);
        HashMap hashMap = new HashMap();
        hashMap.put("code", "InnerBrowser");
        com.qq.e.comm.plugin.w.a.d.a(aVar.M(), aVar.E(), eVar, bVar, hashMap);
        aa.a(str2);
        return false;
    }
}
