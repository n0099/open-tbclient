package com.fun.ad;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.alibaba.fastjson.parser.JSONLexer;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.fun.ad.au;
import com.fun.ad.d;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunAdLoadListener;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunAdType;
import com.fun.ad.sdk.FunAdView;
import com.fun.ad.sdk.FunRippedAd;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes15.dex */
public final class p {
    public aq pHA;
    public l pHB;
    public FunAdLoadListener pHC;
    public FunAdSlot.AdLoadMode pHD;
    public au pHx;
    public bg pHy;
    public af pHz;
    public boolean h = true;
    public Handler j = new a(Looper.getMainLooper());
    public Map<String, FunRippedAd> k = new HashMap();
    public Map<String, b> f = new HashMap();

    /* loaded from: classes15.dex */
    public class a extends Handler {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Looper looper) {
            super(looper);
            p.this = r1;
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            p pVar;
            FunAdLoadListener funAdLoadListener;
            for (Map.Entry<String, b> entry : p.this.f.entrySet()) {
                if (entry.getValue().f8085b && (funAdLoadListener = (pVar = p.this).pHC) != null) {
                    funAdLoadListener.onAdLoaded(pVar.pHx.f8057a);
                    return;
                }
            }
            p pVar2 = p.this;
            FunAdLoadListener funAdLoadListener2 = pVar2.pHC;
            if (funAdLoadListener2 != null) {
                funAdLoadListener2.onError(pVar2.pHx.f8057a);
            }
        }
    }

    /* loaded from: classes15.dex */
    public static class b {

        /* renamed from: a */
        public int f8084a = 0;

        /* renamed from: b */
        public boolean f8085b = false;
        public long c = 0;

        public void a() {
            this.f8084a = 0;
            this.f8085b = false;
            this.c = 0L;
        }
    }

    public p(au auVar, bg bgVar, af afVar, aq aqVar, l lVar) {
        this.pHx = auVar;
        this.pHy = bgVar;
        this.pHz = afVar;
        this.pHA = aqVar;
        this.pHB = lVar;
    }

    public static /* synthetic */ void a(p pVar, String str, String str2, String str3) {
        if (pVar != null) {
            m.a("FunAdLoader 广告加载成功，广告ID：" + str3);
            b bVar = pVar.f.get(str3);
            if (bVar != null) {
                bVar.c = System.currentTimeMillis();
                bVar.f8085b = true;
                if ((pVar.pHD == FunAdSlot.AdLoadMode.PRIORITY_FIRST && bVar.f8084a == 0) || pVar.pHD == FunAdSlot.AdLoadMode.TIME_FIRST) {
                    pVar.pHD = FunAdSlot.AdLoadMode.PRIORITY_FIRST;
                    pVar.h = false;
                    pVar.j.removeMessages(0);
                    FunAdLoadListener funAdLoadListener = pVar.pHC;
                    if (funAdLoadListener != null) {
                        funAdLoadListener.onAdLoaded(pVar.pHx.f8057a);
                    }
                }
                ((d.a) d.pHm).c(str, str2, str3);
                return;
            }
            Log.e("FunAdSdk", "FunAdLoader 不应该走到这里");
            return;
        }
        throw null;
    }

    public final boolean a(au.a aVar) {
        j jVar = j.pHt;
        String str = this.pHx.f8057a;
        String str2 = aVar.f8059a;
        if (jVar != null) {
            String str3 = jVar.f8082a.get(str.concat(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).concat(str2));
            FunRippedAd funRippedAd = this.k.get(aVar.f8059a);
            if (funRippedAd == null) {
                funRippedAd = b(aVar);
                this.k.put(aVar.f8059a, funRippedAd);
            }
            if (funRippedAd != null && !TextUtils.isEmpty(funRippedAd.uniqueId)) {
                m.a("FunAdLoader 广告去重，sid: " + this.pHx.f8057a + "adUniqueID：" + funRippedAd.uniqueId);
                m.a("FunAdLoader 广告去重，sid: " + this.pHx.f8057a + "showAdUniqueID：" + str3);
                boolean equals = TextUtils.equals(funRippedAd.uniqueId, str3);
                if (equals) {
                    return equals;
                }
                j jVar2 = j.pHt;
                String str4 = this.pHx.f8057a;
                String str5 = aVar.f8059a;
                String str6 = funRippedAd.uniqueId;
                if (jVar2 != null) {
                    jVar2.f8082a.put(str4.concat(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).concat(str5), str6);
                    return equals;
                }
                throw null;
            }
            return false;
        }
        throw null;
    }

    public static /* synthetic */ void a(p pVar, String str, String str2, String str3, int i, String str4) {
        if (pVar != null) {
            m.a("FunAdLoader 广告加载失败，广告ID：" + str3 + "，code：" + i + "，message：" + str4);
            if (pVar.f.get(str3) != null) {
                ((d.a) d.pHm).a(str, str2, str3, i, str4);
                return;
            } else {
                Log.e("FunAdSdk", "FunAdLoader 不应该走到这里");
                return;
            }
        }
        throw null;
    }

    public final void a(Activity activity, FunAdView funAdView, au.a aVar, FunAdInteractionListener funAdInteractionListener) {
        String str = aVar.f8060b;
        char c = 65535;
        switch (str.hashCode()) {
            case -1900686778:
                if (str.equals(FunAdType.JY_NATIVE)) {
                    c = 24;
                    break;
                }
                break;
            case -1377301807:
                if (str.equals(FunAdType.KS_NATIVE_EXPRESS)) {
                    c = '\r';
                    break;
                }
                break;
            case -1303381232:
                if (str.equals(FunAdType.GDT_NATIVE_EXPRESS2)) {
                    c = 19;
                    break;
                }
                break;
            case -1291455752:
                if (str.equals(FunAdType.KS_FULLSCREEN_VIDEO)) {
                    c = 14;
                    break;
                }
                break;
            case -1263692214:
                if (str.equals(FunAdType.CSJ_INTERACTION_EXPRESS)) {
                    c = 5;
                    break;
                }
                break;
            case -1187931233:
                if (str.equals(FunAdType.KS_NATIVE)) {
                    c = 11;
                    break;
                }
                break;
            case -1106926588:
                if (str.equals(FunAdType.KS_REWARD_VIDEO)) {
                    c = 15;
                    break;
                }
                break;
            case -1031178769:
                if (str.equals(FunAdType.KS_SPLASH)) {
                    c = '\f';
                    break;
                }
                break;
            case -950004865:
                if (str.equals(FunAdType.CSJ_NATIVE_EXPRESS)) {
                    c = 7;
                    break;
                }
                break;
            case -942661506:
                if (str.equals(FunAdType.GDT_SPLASH)) {
                    c = 23;
                    break;
                }
                break;
            case -596233886:
                if (str.equals(FunAdType.GDT_NATIVE_EXPRESS)) {
                    c = 18;
                    break;
                }
                break;
            case -39027267:
                if (str.equals(FunAdType.JY_REWARD_VIDEO)) {
                    c = JSONLexer.EOI;
                    break;
                }
                break;
            case 114133351:
                if (str.equals(FunAdType.GDT_UNIFIED_BANNER)) {
                    c = 16;
                    break;
                }
                break;
            case 125016359:
                if (str.equals(FunAdType.GDT_UNIFIED_INTERSTITIAL)) {
                    c = 20;
                    break;
                }
                break;
            case 347930415:
                if (str.equals(FunAdType.CSJ_SPLASH_EXPRESS)) {
                    c = '\n';
                    break;
                }
                break;
            case 425812868:
                if (str.equals(FunAdType.GDT_NATIVE_UNIFIED)) {
                    c = 17;
                    break;
                }
                break;
            case 543046357:
                if (str.equals(FunAdType.GDT_REWARD_VIDEO)) {
                    c = 22;
                    break;
                }
                break;
            case 556489085:
                if (str.equals(FunAdType.CSJ_BANNER_NATIVE)) {
                    c = 6;
                    break;
                }
                break;
            case 647173702:
                if (str.equals(FunAdType.CSJ_INTERACTION)) {
                    c = 4;
                    break;
                }
                break;
            case 1168375858:
                if (str.equals(FunAdType.CSJ_REWARD_VIDEO)) {
                    c = '\b';
                    break;
                }
                break;
            case 1319012390:
                if (str.equals(FunAdType.CSJ_FULLSCREEN_VIDEO)) {
                    c = 3;
                    break;
                }
                break;
            case 1328722634:
                if (str.equals(FunAdType.CSJ_BANNER_EXPRESS)) {
                    c = 1;
                    break;
                }
                break;
            case 1578961350:
                if (str.equals(FunAdType.CSJ_BANNER)) {
                    c = 0;
                    break;
                }
                break;
            case 1872382491:
                if (str.equals(FunAdType.JY_INTERSTITIAL)) {
                    c = 25;
                    break;
                }
                break;
            case 1922685617:
                if (str.equals(FunAdType.CSJ_NATIVE)) {
                    c = 2;
                    break;
                }
                break;
            case 1990506825:
                if (str.equals(FunAdType.GDT_FULLSCREEN_VIDEO)) {
                    c = 21;
                    break;
                }
                break;
            case 2079438081:
                if (str.equals(FunAdType.CSJ_SPLASH)) {
                    c = '\t';
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case '\b':
            case '\t':
            case '\n':
                String str2 = this.pHx.f8057a;
                bg bgVar = this.pHy;
                am amVar = new am(this, funAdInteractionListener, str2, aVar);
                if (bgVar != null) {
                    bd bdVar = bgVar.f8067a.get(bgVar.a(str2, aVar.f8059a));
                    if (bdVar == null) {
                        Log.e("FunAdSdk", "CSJAdLoaderFactory: 广告展示错误，必须先load广告 sid: " + str2 + ", adId: " + aVar.f8059a);
                        return;
                    } else {
                        bdVar.a(activity, funAdView, amVar);
                        return;
                    }
                }
                throw null;
            case 11:
            case '\f':
            case '\r':
            case 14:
            case 15:
                String str3 = this.pHx.f8057a;
                af afVar = this.pHz;
                ag agVar = new ag(this, funAdInteractionListener, str3, aVar);
                if (afVar != null) {
                    ac acVar = afVar.f8045a.get(afVar.a(str3, aVar.f8059a));
                    if (acVar == null) {
                        Log.e("FunAdSdk", "KSAdLoaderFactory: 广告展示错误，必须先load广告 sid: " + str3 + ", adId: " + aVar.f8059a);
                        return;
                    } else {
                        acVar.a(activity, funAdView, agVar);
                        return;
                    }
                }
                throw null;
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                String str4 = this.pHx.f8057a;
                aq aqVar = this.pHA;
                aa aaVar = new aa(this, funAdInteractionListener, str4, aVar);
                if (aqVar != null) {
                    an anVar = aqVar.f8053a.get(aqVar.a(str4, aVar.f8059a));
                    if (anVar == null) {
                        Log.e("FunAdSdk", "GDTAdLoaderFactory: 广告展示错误，必须先load广告 sid: " + str4 + ", adId: " + aVar.f8059a);
                        return;
                    } else {
                        anVar.a(activity, funAdView, aaVar);
                        return;
                    }
                }
                throw null;
            case 24:
            case 25:
            case 26:
                String str5 = this.pHx.f8057a;
                l lVar = this.pHB;
                u uVar = new u(this, funAdInteractionListener, str5, aVar);
                if (lVar != null) {
                    i iVar = lVar.f8083a.get(lVar.a(str5, aVar.f8059a));
                    if (iVar == null) {
                        Log.e("FunAdSdk", "JYAdLoaderFactory: 广告展示错误，必须先load广告 sid: " + str5 + ", adId: " + aVar.f8059a);
                        return;
                    } else {
                        iVar.a(activity, funAdView, uVar);
                        return;
                    }
                }
                throw null;
            default:
                return;
        }
    }

    public final FunRippedAd b(au.a aVar) {
        String str = aVar.f8060b;
        char c = 65535;
        switch (str.hashCode()) {
            case -1900686778:
                if (str.equals(FunAdType.JY_NATIVE)) {
                    c = 24;
                    break;
                }
                break;
            case -1377301807:
                if (str.equals(FunAdType.KS_NATIVE_EXPRESS)) {
                    c = '\r';
                    break;
                }
                break;
            case -1303381232:
                if (str.equals(FunAdType.GDT_NATIVE_EXPRESS2)) {
                    c = 19;
                    break;
                }
                break;
            case -1291455752:
                if (str.equals(FunAdType.KS_FULLSCREEN_VIDEO)) {
                    c = 14;
                    break;
                }
                break;
            case -1263692214:
                if (str.equals(FunAdType.CSJ_INTERACTION_EXPRESS)) {
                    c = 5;
                    break;
                }
                break;
            case -1187931233:
                if (str.equals(FunAdType.KS_NATIVE)) {
                    c = 11;
                    break;
                }
                break;
            case -1106926588:
                if (str.equals(FunAdType.KS_REWARD_VIDEO)) {
                    c = 15;
                    break;
                }
                break;
            case -1031178769:
                if (str.equals(FunAdType.KS_SPLASH)) {
                    c = '\f';
                    break;
                }
                break;
            case -950004865:
                if (str.equals(FunAdType.CSJ_NATIVE_EXPRESS)) {
                    c = 7;
                    break;
                }
                break;
            case -942661506:
                if (str.equals(FunAdType.GDT_SPLASH)) {
                    c = 23;
                    break;
                }
                break;
            case -596233886:
                if (str.equals(FunAdType.GDT_NATIVE_EXPRESS)) {
                    c = 18;
                    break;
                }
                break;
            case -39027267:
                if (str.equals(FunAdType.JY_REWARD_VIDEO)) {
                    c = JSONLexer.EOI;
                    break;
                }
                break;
            case 114133351:
                if (str.equals(FunAdType.GDT_UNIFIED_BANNER)) {
                    c = 16;
                    break;
                }
                break;
            case 125016359:
                if (str.equals(FunAdType.GDT_UNIFIED_INTERSTITIAL)) {
                    c = 20;
                    break;
                }
                break;
            case 347930415:
                if (str.equals(FunAdType.CSJ_SPLASH_EXPRESS)) {
                    c = '\n';
                    break;
                }
                break;
            case 425812868:
                if (str.equals(FunAdType.GDT_NATIVE_UNIFIED)) {
                    c = 17;
                    break;
                }
                break;
            case 543046357:
                if (str.equals(FunAdType.GDT_REWARD_VIDEO)) {
                    c = 22;
                    break;
                }
                break;
            case 556489085:
                if (str.equals(FunAdType.CSJ_BANNER_NATIVE)) {
                    c = 6;
                    break;
                }
                break;
            case 647173702:
                if (str.equals(FunAdType.CSJ_INTERACTION)) {
                    c = 4;
                    break;
                }
                break;
            case 1168375858:
                if (str.equals(FunAdType.CSJ_REWARD_VIDEO)) {
                    c = '\b';
                    break;
                }
                break;
            case 1319012390:
                if (str.equals(FunAdType.CSJ_FULLSCREEN_VIDEO)) {
                    c = 3;
                    break;
                }
                break;
            case 1328722634:
                if (str.equals(FunAdType.CSJ_BANNER_EXPRESS)) {
                    c = 1;
                    break;
                }
                break;
            case 1578961350:
                if (str.equals(FunAdType.CSJ_BANNER)) {
                    c = 0;
                    break;
                }
                break;
            case 1872382491:
                if (str.equals(FunAdType.JY_INTERSTITIAL)) {
                    c = 25;
                    break;
                }
                break;
            case 1922685617:
                if (str.equals(FunAdType.CSJ_NATIVE)) {
                    c = 2;
                    break;
                }
                break;
            case 1990506825:
                if (str.equals(FunAdType.GDT_FULLSCREEN_VIDEO)) {
                    c = 21;
                    break;
                }
                break;
            case 2079438081:
                if (str.equals(FunAdType.CSJ_SPLASH)) {
                    c = '\t';
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case '\b':
            case '\t':
            case '\n':
                bg bgVar = this.pHy;
                String str2 = this.pHx.f8057a;
                if (bgVar != null) {
                    bd bdVar = bgVar.f8067a.get(bgVar.a(str2, aVar.f8059a));
                    if (bdVar != null) {
                        return bdVar.eBl();
                    }
                    return null;
                }
                throw null;
            case 11:
            case '\f':
            case '\r':
            case 14:
            case 15:
                af afVar = this.pHz;
                String str3 = this.pHx.f8057a;
                if (afVar != null) {
                    ac acVar = afVar.f8045a.get(afVar.a(str3, aVar.f8059a));
                    if (acVar != null) {
                        return acVar.eBl();
                    }
                    return null;
                }
                throw null;
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                aq aqVar = this.pHA;
                String str4 = this.pHx.f8057a;
                if (aqVar != null) {
                    an anVar = aqVar.f8053a.get(aqVar.a(str4, aVar.f8059a));
                    if (anVar != null) {
                        return anVar.eBl();
                    }
                    return null;
                }
                throw null;
            case 24:
            case 25:
            case 26:
                l lVar = this.pHB;
                String str5 = this.pHx.f8057a;
                if (lVar != null) {
                    i iVar = lVar.f8083a.get(lVar.a(str5, aVar.f8059a));
                    return iVar != null ? iVar.eBl() : null;
                }
                throw null;
            default:
                return null;
        }
    }
}
