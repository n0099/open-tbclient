package com.qq.e.comm.plugin;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.view.ViewGroup;
import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.qq.e.ads.banner2.UnifiedBannerADListener;
import com.qq.e.ads.banner2.UnifiedBannerView;
import com.qq.e.ads.dfa.IGDTApkListener;
import com.qq.e.ads.hybrid.HybridADListener;
import com.qq.e.ads.hybrid.HybridADSetting;
import com.qq.e.ads.interstitial2.UnifiedInterstitialADListener;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.ACTD;
import com.qq.e.comm.pi.DFA;
import com.qq.e.comm.pi.HADI;
import com.qq.e.comm.pi.NEADI;
import com.qq.e.comm.pi.NEADVI;
import com.qq.e.comm.pi.NEIADI;
import com.qq.e.comm.pi.NSPVI;
import com.qq.e.comm.pi.NUADI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.pi.RVADI;
import com.qq.e.comm.pi.RVADI2;
import com.qq.e.comm.pi.SVSD;
import com.qq.e.comm.pi.UBVI;
import com.qq.e.comm.pi.UIADI;
import com.qq.e.comm.pi.WRI;
import com.qq.e.comm.plugin.h.b;
import com.qq.e.comm.plugin.util.av;
import com.qq.e.comm.plugin.util.l;
import com.qq.e.comm.plugin.util.o;
import com.qq.e.comm.plugin.util.z;
import com.thunder.livesdk.system.ThunderNetStateService;
import java.util.HashMap;
import org.json.JSONObject;
import yaq.gdtadv;
/* JADX WARN: Classes with same name are omitted:
  assets/yaqgdtadv0.sec
 */
/* loaded from: classes15.dex */
public class POFactoryImpl implements POFactory {
    public static final String DETAIL_PAGE = "detailPage";
    public static final String DownloadManage = "downloadManage";
    public static final String HYBRID_AD_PAGE = "hybridADPage";
    public static final String InnerBrowser = "innerBrowser";
    public static final String InterstitialFullScreen = "interstitialFullScreen";
    public static final String RewardPage = "rewardPage";
    public static final String RewardVideo = "rewardVideo";
    public static final String RewardVideo2 = "rewardVideo2";

    /* renamed from: a  reason: collision with root package name */
    private static final POFactory f11586a = new POFactoryImpl();

    private POFactoryImpl() {
        com.qq.e.comm.plugin.x.a.a().b();
        Context appContext = GDTADManager.getInstance().getAppContext();
        if (appContext != null) {
            b.AAID.a(appContext);
        }
        av.a(appContext);
        l.a(o.b()).a();
        z.a().b();
        com.qq.e.comm.plugin.util.b.b(appContext);
    }

    public static POFactory getInstance() {
        return (POFactory) gdtadv.getobjresult(Constants.METHOD_IM_FRIEND_GROUP_QUERY_MEMBER, 1, new Object[0]);
    }

    @Override // com.qq.e.comm.pi.POFactory
    public void config(int i, String str) {
        gdtadv.getVresult(Constants.METHOD_IM_FRIEND_GROUP_ASSIGN, 0, this, Integer.valueOf(i), str);
    }

    @Override // com.qq.e.comm.pi.POFactory
    public SVSD getAPKDownloadServiceDelegate(Service service) {
        return (SVSD) gdtadv.getobjresult(Opcodes.IAND, 0, this, service);
    }

    @Override // com.qq.e.comm.pi.POFactory
    public ACTD getActivityDelegate(String str, Activity activity) {
        return (ACTD) gdtadv.getobjresult(ThunderNetStateService.NetState.SYSNET_UNKNOWN, 0, this, str, activity);
    }

    @Override // com.qq.e.comm.pi.POFactory
    public RVADI2 getExpressRewardVideoADDelegate(Context context, String str, String str2, ADListener aDListener) {
        return (RVADI2) gdtadv.getobjresult(128, 0, this, context, str, str2, aDListener);
    }

    @Override // com.qq.e.comm.pi.POFactory
    public DFA getGDTApkDelegate(IGDTApkListener iGDTApkListener) {
        return (DFA) gdtadv.getobjresult(129, 0, this, iGDTApkListener);
    }

    @Override // com.qq.e.comm.pi.POFactory
    public HADI getHybridAD(HybridADSetting hybridADSetting, HybridADListener hybridADListener) {
        return (HADI) gdtadv.getobjresult(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER, 0, this, hybridADSetting, hybridADListener);
    }

    @Override // com.qq.e.comm.pi.POFactory
    public NUADI getNativeAdManagerDelegate(Context context, String str, String str2, ADListener aDListener) {
        return (NUADI) gdtadv.getobjresult(IMPushPb.PushImClient.SDK_VERSION_FIELD_NUMBER, 0, this, context, str, str2, aDListener);
    }

    @Override // com.qq.e.comm.pi.POFactory
    public NEADI getNativeExpressADDelegate(Context context, ADSize aDSize, String str, String str2, ADListener aDListener) {
        return (NEADI) gdtadv.getobjresult(IMPushPb.PushImClient.ACTIONS_FIELD_NUMBER, 0, this, context, aDSize, str, str2, aDListener);
    }

    @Override // com.qq.e.comm.pi.POFactory
    public NEIADI getNativeExpressADDelegate2(Context context, String str, String str2, ADListener aDListener) {
        return (NEIADI) gdtadv.getobjresult(133, 0, this, context, str, str2, aDListener);
    }

    @Override // com.qq.e.comm.pi.POFactory
    public NEADVI getNativeExpressADView(NEADI neadi, Context context, ViewGroup viewGroup, ADSize aDSize, String str, String str2, JSONObject jSONObject, HashMap<String, JSONObject> hashMap) {
        return (NEADVI) gdtadv.getobjresult(134, 0, this, neadi, context, viewGroup, aDSize, str, str2, jSONObject, hashMap);
    }

    @Override // com.qq.e.comm.pi.POFactory
    public NSPVI getNativeSplashAdView(Context context, String str, String str2) {
        return (NSPVI) gdtadv.getobjresult(135, 0, this, context, str, str2);
    }

    @Override // com.qq.e.comm.pi.POFactory
    public RVADI getRewardVideoADDelegate(Context context, String str, String str2, ADListener aDListener) {
        return (RVADI) gdtadv.getobjresult(136, 0, this, context, str, str2, aDListener);
    }

    @Override // com.qq.e.comm.pi.POFactory
    public UBVI getUnifiedBannerViewDelegate(UnifiedBannerView unifiedBannerView, Activity activity, String str, String str2, UnifiedBannerADListener unifiedBannerADListener) {
        return (UBVI) gdtadv.getobjresult(137, 0, this, unifiedBannerView, activity, str, str2, unifiedBannerADListener);
    }

    @Override // com.qq.e.comm.pi.POFactory
    public UIADI getUnifiedInterstitialADDelegate(Activity activity, String str, String str2, UnifiedInterstitialADListener unifiedInterstitialADListener) {
        return (UIADI) gdtadv.getobjresult(138, 0, this, activity, str, str2, unifiedInterstitialADListener);
    }

    @Override // com.qq.e.comm.pi.POFactory
    public WRI getWebReporterDelegate(String str, long j) {
        return (WRI) gdtadv.getobjresult(139, 0, this, str, Long.valueOf(j));
    }

    @Override // com.qq.e.comm.pi.POFactory
    public void trackEvent(int i) {
        gdtadv.getVresult(140, 0, this, Integer.valueOf(i));
    }
}
