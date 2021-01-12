package com.fun.ad.sdk;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import com.alibaba.fastjson.parser.JSONLexer;
import com.fun.ad.ab;
import com.fun.ad.ac;
import com.fun.ad.ad;
import com.fun.ad.ae;
import com.fun.ad.af;
import com.fun.ad.aj;
import com.fun.ad.al;
import com.fun.ad.an;
import com.fun.ad.ao;
import com.fun.ad.aq;
import com.fun.ad.as;
import com.fun.ad.at;
import com.fun.ad.au;
import com.fun.ad.av;
import com.fun.ad.aw;
import com.fun.ad.az;
import com.fun.ad.b;
import com.fun.ad.bd;
import com.fun.ad.be;
import com.fun.ad.bg;
import com.fun.ad.bh;
import com.fun.ad.bl;
import com.fun.ad.bm;
import com.fun.ad.bo;
import com.fun.ad.bp;
import com.fun.ad.bs;
import com.fun.ad.bt;
import com.fun.ad.bu;
import com.fun.ad.d;
import com.fun.ad.e;
import com.fun.ad.h;
import com.fun.ad.i;
import com.fun.ad.l;
import com.fun.ad.m;
import com.fun.ad.n;
import com.fun.ad.o;
import com.fun.ad.p;
import com.fun.ad.q;
import com.fun.ad.r;
import com.fun.ad.s;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.t;
import com.fun.ad.x;
import com.fun.ad.y;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes14.dex */
public final class FunAdFactory {
    public static FunAdFactory INST = new FunAdFactory();
    public Map<String, au> mSlotIds = new HashMap();
    public bg mCSJFactory = new bg();
    public af mKSFactory = new af();
    public aq mGDTFactory = new aq();
    public l mJYFactory = new l();
    public Map<String, p> mAdLoaders = new HashMap();
    public Map<String, FunNativeAdLoader> mNativeAdLoaders = new HashMap();
    public Map<String, FunDrawVideoAdLoader> mDrawVideoAdLoaders = new HashMap();

    private p adLoader(au auVar) {
        p pVar = this.mAdLoaders.get(auVar.f7758a);
        if (pVar == null) {
            p pVar2 = new p(auVar, this.mCSJFactory, this.mKSFactory, this.mGDTFactory, this.mJYFactory);
            this.mAdLoaders.put(auVar.f7758a, pVar2);
            return pVar2;
        }
        return pVar;
    }

    public static FunAdFactory getInstance() {
        return INST;
    }

    public void destroyAd(@NonNull String str) {
        if (this.mSlotIds.get(str) == null) {
            Log.e("FunAdSdk", "FunAdFactory destroy广告位：" + str + "未配置任何类型的广告ID列表");
            return;
        }
        p pVar = this.mAdLoaders.get(str);
        if (pVar != null) {
            List<au.a> list = pVar.pEE.c;
            if (list != null && !list.isEmpty()) {
                pVar.j.removeMessages(0);
                for (au.a aVar : list) {
                    String str2 = aVar.f7761b;
                    char c = 65535;
                    switch (str2.hashCode()) {
                        case -1900686778:
                            if (str2.equals(FunAdType.JY_NATIVE)) {
                                c = 24;
                                break;
                            }
                            break;
                        case -1377301807:
                            if (str2.equals(FunAdType.KS_NATIVE_EXPRESS)) {
                                c = '\r';
                                break;
                            }
                            break;
                        case -1303381232:
                            if (str2.equals(FunAdType.GDT_NATIVE_EXPRESS2)) {
                                c = 19;
                                break;
                            }
                            break;
                        case -1291455752:
                            if (str2.equals(FunAdType.KS_FULLSCREEN_VIDEO)) {
                                c = 14;
                                break;
                            }
                            break;
                        case -1263692214:
                            if (str2.equals(FunAdType.CSJ_INTERACTION_EXPRESS)) {
                                c = 5;
                                break;
                            }
                            break;
                        case -1187931233:
                            if (str2.equals(FunAdType.KS_NATIVE)) {
                                c = 11;
                                break;
                            }
                            break;
                        case -1106926588:
                            if (str2.equals(FunAdType.KS_REWARD_VIDEO)) {
                                c = 15;
                                break;
                            }
                            break;
                        case -1031178769:
                            if (str2.equals(FunAdType.KS_SPLASH)) {
                                c = '\f';
                                break;
                            }
                            break;
                        case -950004865:
                            if (str2.equals(FunAdType.CSJ_NATIVE_EXPRESS)) {
                                c = 7;
                                break;
                            }
                            break;
                        case -942661506:
                            if (str2.equals(FunAdType.GDT_SPLASH)) {
                                c = 23;
                                break;
                            }
                            break;
                        case -596233886:
                            if (str2.equals(FunAdType.GDT_NATIVE_EXPRESS)) {
                                c = 18;
                                break;
                            }
                            break;
                        case -39027267:
                            if (str2.equals(FunAdType.JY_REWARD_VIDEO)) {
                                c = JSONLexer.EOI;
                                break;
                            }
                            break;
                        case 114133351:
                            if (str2.equals(FunAdType.GDT_UNIFIED_BANNER)) {
                                c = 16;
                                break;
                            }
                            break;
                        case 125016359:
                            if (str2.equals(FunAdType.GDT_UNIFIED_INTERSTITIAL)) {
                                c = 20;
                                break;
                            }
                            break;
                        case 347930415:
                            if (str2.equals(FunAdType.CSJ_SPLASH_EXPRESS)) {
                                c = '\n';
                                break;
                            }
                            break;
                        case 425812868:
                            if (str2.equals(FunAdType.GDT_NATIVE_UNIFIED)) {
                                c = 17;
                                break;
                            }
                            break;
                        case 543046357:
                            if (str2.equals(FunAdType.GDT_REWARD_VIDEO)) {
                                c = 22;
                                break;
                            }
                            break;
                        case 556489085:
                            if (str2.equals(FunAdType.CSJ_BANNER_NATIVE)) {
                                c = 6;
                                break;
                            }
                            break;
                        case 647173702:
                            if (str2.equals(FunAdType.CSJ_INTERACTION)) {
                                c = 4;
                                break;
                            }
                            break;
                        case 1168375858:
                            if (str2.equals(FunAdType.CSJ_REWARD_VIDEO)) {
                                c = '\b';
                                break;
                            }
                            break;
                        case 1319012390:
                            if (str2.equals(FunAdType.CSJ_FULLSCREEN_VIDEO)) {
                                c = 3;
                                break;
                            }
                            break;
                        case 1328722634:
                            if (str2.equals(FunAdType.CSJ_BANNER_EXPRESS)) {
                                c = 1;
                                break;
                            }
                            break;
                        case 1578961350:
                            if (str2.equals(FunAdType.CSJ_BANNER)) {
                                c = 0;
                                break;
                            }
                            break;
                        case 1872382491:
                            if (str2.equals(FunAdType.JY_INTERSTITIAL)) {
                                c = 25;
                                break;
                            }
                            break;
                        case 1922685617:
                            if (str2.equals(FunAdType.CSJ_NATIVE)) {
                                c = 2;
                                break;
                            }
                            break;
                        case 1990506825:
                            if (str2.equals(FunAdType.GDT_FULLSCREEN_VIDEO)) {
                                c = 21;
                                break;
                            }
                            break;
                        case 2079438081:
                            if (str2.equals(FunAdType.CSJ_SPLASH)) {
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
                            bg bgVar = pVar.pEF;
                            String str3 = pVar.pEE.f7758a;
                            if (bgVar != null) {
                                String a2 = bgVar.a(str3, aVar.f7760a);
                                bd bdVar = bgVar.f7768a.get(a2);
                                if (bdVar != null) {
                                    bdVar.a();
                                }
                                bgVar.f7768a.remove(a2);
                                break;
                            } else {
                                throw null;
                            }
                        case 11:
                        case '\f':
                        case '\r':
                        case 14:
                        case 15:
                            af afVar = pVar.pEG;
                            String str4 = pVar.pEE.f7758a;
                            if (afVar != null) {
                                String a3 = afVar.a(str4, aVar.f7760a);
                                ac acVar = afVar.f7746a.get(a3);
                                if (acVar != null) {
                                    acVar.a();
                                }
                                afVar.f7746a.remove(a3);
                                break;
                            } else {
                                throw null;
                            }
                        case 16:
                        case 17:
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                            aq aqVar = pVar.pEH;
                            String str5 = pVar.pEE.f7758a;
                            if (aqVar != null) {
                                String a4 = aqVar.a(str5, aVar.f7760a);
                                an anVar = aqVar.f7754a.get(a4);
                                if (anVar != null) {
                                    anVar.a();
                                }
                                aqVar.f7754a.remove(a4);
                                break;
                            } else {
                                throw null;
                            }
                        case 24:
                        case 25:
                        case 26:
                            l lVar = pVar.pEI;
                            String str6 = pVar.pEE.f7758a;
                            if (lVar != null) {
                                String a5 = lVar.a(str6, aVar.f7760a);
                                i iVar = lVar.f7784a.get(a5);
                                if (iVar != null) {
                                    iVar.a();
                                }
                                lVar.f7784a.remove(a5);
                                break;
                            } else {
                                throw null;
                            }
                    }
                    p.b bVar = pVar.f.get(aVar.f7760a);
                    if (bVar != null) {
                        bVar.a();
                    }
                }
                pVar.pEJ = null;
                return;
            }
            Log.e("FunAdSdk", "FunAdLoader destroy广告位：" + pVar.pEE.f7758a + "未配置任何类型的广告ID");
            return;
        }
        Log.e("FunAdSdk", "FunAdFactory: 广告destroy错误，必须先load广告 sid: " + str);
    }

    public void destroyDrawVideoAd(@NonNull String str) {
        if (this.mSlotIds.get(str) == null) {
            Log.e("FunAdSdk", "FunAdFactory destroy广告位：" + str + "未配置任何类型的广告ID列表");
        } else {
            this.mDrawVideoAdLoaders.remove(str);
        }
    }

    public void destroyNativeAd(@NonNull String str) {
        if (this.mSlotIds.get(str) == null) {
            Log.e("FunAdSdk", "FunAdFactory destroy广告位：" + str + "未配置任何类型的广告ID列表");
        } else {
            this.mNativeAdLoaders.remove(str);
        }
    }

    public String getAdType(String str) {
        String str2;
        if (this.mSlotIds.get(str) == null) {
            Log.e("FunAdSdk", "FunAdFactory getAdType广告位：" + str + "未配置任何类型的广告ID列表");
            return null;
        }
        p pVar = this.mAdLoaders.get(str);
        if (pVar != null) {
            List<au.a> list = pVar.pEE.c;
            if (list != null && !list.isEmpty()) {
                Iterator<au.a> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        str2 = null;
                        break;
                    }
                    au.a next = it.next();
                    p.b bVar = pVar.f.get(next.f7760a);
                    if (bVar != null && bVar.f7786b && System.currentTimeMillis() - bVar.c <= d.i) {
                        str2 = next.f7761b;
                        break;
                    }
                }
            } else {
                Log.e("FunAdSdk", "FunAdLoader isReady广告位：" + pVar.pEE.f7758a + "未配置任何类型的广告ID");
                str2 = null;
            }
            return str2;
        }
        Log.e("FunAdSdk", "FunAdFactory: 广告展示错误，必须先load广告 sid: " + str);
        return null;
    }

    public FunRippedAd getDeepLinkAd(String str) {
        FunRippedAd funRippedAd;
        if (this.mSlotIds.get(str) == null) {
            Log.e("FunAdSdk", "FunAdFactory getAdType广告位：" + str + "未配置任何类型的广告ID列表");
            return null;
        }
        p pVar = this.mAdLoaders.get(str);
        if (pVar != null) {
            List<au.a> list = pVar.pEE.c;
            if (list != null && !list.isEmpty()) {
                Iterator<au.a> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        funRippedAd = null;
                        break;
                    }
                    au.a next = it.next();
                    p.b bVar = pVar.f.get(next.f7760a);
                    if (bVar != null && bVar.f7786b && System.currentTimeMillis() - bVar.c <= d.i) {
                        FunRippedAd b2 = pVar.b(next);
                        pVar.k.put(next.f7760a, b2);
                        if (b2 != null && b2.isDeepLinkAd) {
                            funRippedAd = b2;
                            break;
                        }
                    }
                }
            } else {
                Log.e("FunAdSdk", "FunAdLoader isReady广告位：" + pVar.pEE.f7758a + "未配置任何类型的广告ID");
                funRippedAd = null;
            }
            return funRippedAd;
        }
        Log.e("FunAdSdk", "FunAdFactory: 广告展示错误，必须先load广告 sid: " + str);
        return null;
    }

    public void init(Context context) {
        this.mCSJFactory.f7768a.clear();
        this.mKSFactory.f7746a.clear();
        this.mGDTFactory.f7754a.clear();
    }

    public boolean isAdReady(String str) {
        boolean z;
        if (this.mSlotIds.get(str) == null) {
            Log.e("FunAdSdk", "FunAdFactory isAdReady广告位：" + str + "未配置任何类型的广告ID列表");
            return false;
        }
        p pVar = this.mAdLoaders.get(str);
        if (pVar != null) {
            List<au.a> list = pVar.pEE.c;
            if (list != null && !list.isEmpty()) {
                Iterator<au.a> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    p.b bVar = pVar.f.get(it.next().f7760a);
                    if (bVar != null && bVar.f7786b && System.currentTimeMillis() - bVar.c <= d.i) {
                        z = true;
                        break;
                    }
                }
            } else {
                Log.e("FunAdSdk", "FunAdLoader isReady广告位：" + pVar.pEE.f7758a + "未配置任何类型的广告ID");
                z = false;
            }
            return z;
        }
        Log.e("FunAdSdk", "FunAdFactory: 广告展示错误，必须先load广告 sid: " + str);
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:311:0x00e3, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void loadAd(@NonNull Context context, @NonNull FunAdSlot funAdSlot, @NonNull FunAdLoadListener funAdLoadListener) {
        az azVar;
        bp bpVar;
        t tVar;
        ae aeVar;
        au auVar = this.mSlotIds.get(funAdSlot.getSid());
        if (auVar == null) {
            Log.e("FunAdSdk", "FunAdFactory load广告位：" + funAdSlot.getSid() + "未配置任何类型的广告ID列表");
            funAdLoadListener.onError(funAdSlot.getSid());
            return;
        }
        p adLoader = adLoader(auVar);
        List<au.a> list = adLoader.pEE.c;
        if (list != null && !list.isEmpty()) {
            adLoader.j.removeMessages(0);
            adLoader.h = true;
            adLoader.pEK = funAdSlot.getAdLoadMode();
            adLoader.pEJ = funAdLoadListener;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    au.a aVar = list.get(i2);
                    p.b bVar = adLoader.f.get(aVar.f7760a);
                    if (bVar == null) {
                        bVar = new p.b();
                        adLoader.f.put(aVar.f7760a, bVar);
                    }
                    bVar.f7785a = i2;
                    if (bVar.f7786b && System.currentTimeMillis() - bVar.c <= d.i) {
                        if ((adLoader.pEK == FunAdSlot.AdLoadMode.PRIORITY_FIRST && bVar.f7785a == 0) || adLoader.pEK == FunAdSlot.AdLoadMode.TIME_FIRST) {
                            adLoader.pEK = FunAdSlot.AdLoadMode.PRIORITY_FIRST;
                            adLoader.h = false;
                            adLoader.j.removeMessages(0);
                            FunAdLoadListener funAdLoadListener2 = adLoader.pEJ;
                            if (funAdLoadListener2 != null) {
                                funAdLoadListener2.onAdLoaded(adLoader.pEE.f7758a);
                            }
                        }
                    } else {
                        System.currentTimeMillis();
                        adLoader.k.put(aVar.f7760a, null);
                        String str = aVar.f7761b;
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
                                bg bgVar = adLoader.pEF;
                                aj ajVar = new aj(adLoader, funAdSlot, aVar);
                                if (bgVar != null) {
                                    String a2 = bgVar.a(funAdSlot.getSid(), aVar.f7760a);
                                    bd bdVar = bgVar.f7768a.get(a2);
                                    if (bdVar == null) {
                                        String str2 = aVar.f7761b;
                                        char c2 = 65535;
                                        switch (str2.hashCode()) {
                                            case -1263692214:
                                                if (str2.equals(FunAdType.CSJ_INTERACTION_EXPRESS)) {
                                                    c2 = 5;
                                                    break;
                                                }
                                                break;
                                            case -950004865:
                                                if (str2.equals(FunAdType.CSJ_NATIVE_EXPRESS)) {
                                                    c2 = 7;
                                                    break;
                                                }
                                                break;
                                            case 347930415:
                                                if (str2.equals(FunAdType.CSJ_SPLASH_EXPRESS)) {
                                                    c2 = '\n';
                                                    break;
                                                }
                                                break;
                                            case 556489085:
                                                if (str2.equals(FunAdType.CSJ_BANNER_NATIVE)) {
                                                    c2 = 6;
                                                    break;
                                                }
                                                break;
                                            case 647173702:
                                                if (str2.equals(FunAdType.CSJ_INTERACTION)) {
                                                    c2 = 4;
                                                    break;
                                                }
                                                break;
                                            case 1168375858:
                                                if (str2.equals(FunAdType.CSJ_REWARD_VIDEO)) {
                                                    c2 = '\b';
                                                    break;
                                                }
                                                break;
                                            case 1319012390:
                                                if (str2.equals(FunAdType.CSJ_FULLSCREEN_VIDEO)) {
                                                    c2 = 3;
                                                    break;
                                                }
                                                break;
                                            case 1328722634:
                                                if (str2.equals(FunAdType.CSJ_BANNER_EXPRESS)) {
                                                    c2 = 1;
                                                    break;
                                                }
                                                break;
                                            case 1578961350:
                                                if (str2.equals(FunAdType.CSJ_BANNER)) {
                                                    c2 = 0;
                                                    break;
                                                }
                                                break;
                                            case 1922685617:
                                                if (str2.equals(FunAdType.CSJ_NATIVE)) {
                                                    c2 = 2;
                                                    break;
                                                }
                                                break;
                                            case 2079438081:
                                                if (str2.equals(FunAdType.CSJ_SPLASH)) {
                                                    c2 = '\t';
                                                    break;
                                                }
                                                break;
                                        }
                                        switch (c2) {
                                            case 0:
                                                aeVar = new bl(aVar);
                                                bgVar.f7768a.put(a2, aeVar);
                                                break;
                                            case 1:
                                                aeVar = new bo(aVar);
                                                bgVar.f7768a.put(a2, aeVar);
                                                break;
                                            case 2:
                                                aeVar = new n(aVar);
                                                bgVar.f7768a.put(a2, aeVar);
                                                break;
                                            case 3:
                                                aeVar = new b(aVar);
                                                bgVar.f7768a.put(a2, aeVar);
                                                break;
                                            case 4:
                                                aeVar = new e(aVar);
                                                bgVar.f7768a.put(a2, aeVar);
                                                break;
                                            case 5:
                                                aeVar = new h(aVar);
                                                bgVar.f7768a.put(a2, aeVar);
                                                break;
                                            case 6:
                                                aeVar = new bt(aVar);
                                                bgVar.f7768a.put(a2, aeVar);
                                                break;
                                            case 7:
                                                aeVar = new s(aVar);
                                                bgVar.f7768a.put(a2, aeVar);
                                                break;
                                            case '\b':
                                                aeVar = new y(aVar);
                                                bgVar.f7768a.put(a2, aeVar);
                                                break;
                                            case '\t':
                                                aeVar = new ab(aVar);
                                                bgVar.f7768a.put(a2, aeVar);
                                                break;
                                            case '\n':
                                                aeVar = new ae(aVar);
                                                bgVar.f7768a.put(a2, aeVar);
                                                break;
                                            default:
                                                Log.e("FunAdSdk", "CSJAdLoaderFactory error: not support ad type: " + aVar.f7761b);
                                                aeVar = null;
                                                break;
                                        }
                                    } else {
                                        aeVar = bdVar;
                                    }
                                    if (aeVar != null) {
                                        aeVar.a(context, funAdSlot, ajVar);
                                        continue;
                                    } else {
                                        Log.e("FunAdSdk", "CSJAdLoaderFactory loadAd adLoader == null: 不应该走这里");
                                        break;
                                    }
                                } else {
                                    throw null;
                                }
                            case 11:
                            case '\f':
                            case '\r':
                            case 14:
                            case 15:
                                af afVar = adLoader.pEG;
                                ad adVar = new ad(adLoader, funAdSlot, aVar);
                                if (afVar != null) {
                                    String a3 = afVar.a(funAdSlot.getSid(), aVar.f7760a);
                                    ac acVar = afVar.f7746a.get(a3);
                                    if (acVar == null) {
                                        String str3 = aVar.f7761b;
                                        char c3 = 65535;
                                        switch (str3.hashCode()) {
                                            case -1377301807:
                                                if (str3.equals(FunAdType.KS_NATIVE_EXPRESS)) {
                                                    c3 = 1;
                                                    break;
                                                }
                                                break;
                                            case -1291455752:
                                                if (str3.equals(FunAdType.KS_FULLSCREEN_VIDEO)) {
                                                    c3 = 2;
                                                    break;
                                                }
                                                break;
                                            case -1187931233:
                                                if (str3.equals(FunAdType.KS_NATIVE)) {
                                                    c3 = 0;
                                                    break;
                                                }
                                                break;
                                            case -1106926588:
                                                if (str3.equals(FunAdType.KS_REWARD_VIDEO)) {
                                                    c3 = 3;
                                                    break;
                                                }
                                                break;
                                            case -1031178769:
                                                if (str3.equals(FunAdType.KS_SPLASH)) {
                                                    c3 = 4;
                                                    break;
                                                }
                                                break;
                                        }
                                        switch (c3) {
                                            case 0:
                                                azVar = new ao(aVar);
                                                afVar.f7746a.put(a3, azVar);
                                                break;
                                            case 1:
                                                azVar = new at(aVar);
                                                afVar.f7746a.put(a3, azVar);
                                                break;
                                            case 2:
                                                azVar = new al(aVar);
                                                afVar.f7746a.put(a3, azVar);
                                                break;
                                            case 3:
                                                azVar = new aw(aVar);
                                                afVar.f7746a.put(a3, azVar);
                                                break;
                                            case 4:
                                                azVar = new az(aVar);
                                                afVar.f7746a.put(a3, azVar);
                                                break;
                                            default:
                                                Log.e("FunAdSdk", "KSAdLoaderFactory error: not support ad type: " + aVar.f7761b);
                                                azVar = null;
                                                break;
                                        }
                                    } else {
                                        azVar = acVar;
                                    }
                                    if (azVar != null) {
                                        azVar.a(context, funAdSlot, adVar);
                                        continue;
                                    } else {
                                        Log.e("FunAdSdk", "KSAdLoaderFactory loadAd adLoader == null: 不应该走这里");
                                        break;
                                    }
                                } else {
                                    throw null;
                                }
                            case 16:
                            case 17:
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                                aq aqVar = adLoader.pEH;
                                x xVar = new x(adLoader, funAdSlot, aVar);
                                if (aqVar != null) {
                                    String a4 = aqVar.a(funAdSlot.getSid(), aVar.f7760a);
                                    an anVar = aqVar.f7754a.get(a4);
                                    if (anVar == null) {
                                        String str4 = aVar.f7761b;
                                        char c4 = 65535;
                                        switch (str4.hashCode()) {
                                            case -1303381232:
                                                if (str4.equals(FunAdType.GDT_NATIVE_EXPRESS2)) {
                                                    c4 = 3;
                                                    break;
                                                }
                                                break;
                                            case -942661506:
                                                if (str4.equals(FunAdType.GDT_SPLASH)) {
                                                    c4 = 7;
                                                    break;
                                                }
                                                break;
                                            case -596233886:
                                                if (str4.equals(FunAdType.GDT_NATIVE_EXPRESS)) {
                                                    c4 = 2;
                                                    break;
                                                }
                                                break;
                                            case 114133351:
                                                if (str4.equals(FunAdType.GDT_UNIFIED_BANNER)) {
                                                    c4 = 0;
                                                    break;
                                                }
                                                break;
                                            case 125016359:
                                                if (str4.equals(FunAdType.GDT_UNIFIED_INTERSTITIAL)) {
                                                    c4 = 4;
                                                    break;
                                                }
                                                break;
                                            case 425812868:
                                                if (str4.equals(FunAdType.GDT_NATIVE_UNIFIED)) {
                                                    c4 = 1;
                                                    break;
                                                }
                                                break;
                                            case 543046357:
                                                if (str4.equals(FunAdType.GDT_REWARD_VIDEO)) {
                                                    c4 = 6;
                                                    break;
                                                }
                                                break;
                                            case 1990506825:
                                                if (str4.equals(FunAdType.GDT_FULLSCREEN_VIDEO)) {
                                                    c4 = 5;
                                                    break;
                                                }
                                                break;
                                        }
                                        switch (c4) {
                                            case 0:
                                                bpVar = new bs(aVar);
                                                aqVar.f7754a.put(a4, bpVar);
                                                break;
                                            case 1:
                                                bpVar = new bh(aVar);
                                                aqVar.f7754a.put(a4, bpVar);
                                                break;
                                            case 2:
                                                bpVar = new be(aVar);
                                                aqVar.f7754a.put(a4, bpVar);
                                                break;
                                            case 3:
                                                bpVar = new av(aVar);
                                                aqVar.f7754a.put(a4, bpVar);
                                                break;
                                            case 4:
                                                bpVar = new bu(aVar);
                                                aqVar.f7754a.put(a4, bpVar);
                                                break;
                                            case 5:
                                                bpVar = new as(aVar);
                                                aqVar.f7754a.put(a4, bpVar);
                                                break;
                                            case 6:
                                                bpVar = new bm(aVar);
                                                aqVar.f7754a.put(a4, bpVar);
                                                break;
                                            case 7:
                                                bpVar = new bp(aVar);
                                                aqVar.f7754a.put(a4, bpVar);
                                                break;
                                            default:
                                                Log.e("FunAdSdk", "GDTAdLoaderFactory error: not support ad type: " + aVar.f7761b);
                                                bpVar = null;
                                                break;
                                        }
                                    } else {
                                        bpVar = anVar;
                                    }
                                    if (bpVar != null) {
                                        bpVar.a(context, funAdSlot, xVar);
                                        continue;
                                    } else {
                                        Log.e("FunAdSdk", "GDTAdLoaderFactory loadAd adLoader == null: 不应该走这里");
                                        break;
                                    }
                                } else {
                                    throw null;
                                }
                            case 24:
                            case 25:
                            case 26:
                                l lVar = adLoader.pEI;
                                r rVar = new r(adLoader, funAdSlot, aVar);
                                if (lVar != null) {
                                    String a5 = lVar.a(funAdSlot.getSid(), aVar.f7760a);
                                    i iVar = lVar.f7784a.get(a5);
                                    if (iVar == null) {
                                        String str5 = aVar.f7761b;
                                        char c5 = 65535;
                                        int hashCode = str5.hashCode();
                                        if (hashCode != -1900686778) {
                                            if (hashCode != -39027267) {
                                                if (hashCode == 1872382491 && str5.equals(FunAdType.JY_INTERSTITIAL)) {
                                                    c5 = 1;
                                                }
                                            } else if (str5.equals(FunAdType.JY_REWARD_VIDEO)) {
                                                c5 = 2;
                                            }
                                        } else if (str5.equals(FunAdType.JY_NATIVE)) {
                                            c5 = 0;
                                        }
                                        if (c5 == 0) {
                                            tVar = new q(aVar);
                                        } else if (c5 == 1) {
                                            tVar = new o(aVar);
                                        } else if (c5 != 2) {
                                            Log.e("FunAdSdk", "JYAdLoaderFactory error: not support ad type: " + aVar.f7761b);
                                            tVar = null;
                                        } else {
                                            tVar = new t(aVar);
                                        }
                                        lVar.f7784a.put(a5, tVar);
                                    } else {
                                        tVar = iVar;
                                    }
                                    if (tVar != null) {
                                        tVar.a(context, funAdSlot, rVar);
                                        continue;
                                    } else {
                                        Log.e("FunAdSdk", "JYAdLoaderFactory loadAd adLoader == null: 不应该走这里");
                                        break;
                                    }
                                } else {
                                    throw null;
                                }
                                break;
                        }
                    }
                    i = i2 + 1;
                } else {
                    m.a("FunAdLoader load sid: " + adLoader.pEE.f7758a + " wt: " + adLoader.pEE.f7759b);
                    if (adLoader.h) {
                        adLoader.j.sendEmptyMessageDelayed(0, adLoader.pEE.f7759b);
                        return;
                    }
                    return;
                }
            }
        } else {
            Log.e("FunAdSdk", "FunAdLoader load广告位：" + adLoader.pEE.f7758a + "未配置任何类型的广告ID");
        }
    }

    public void loadDrawVideoAd(@NonNull Activity activity, @NonNull FunAdSlot funAdSlot, @NonNull FunDrawVideoAdLoadListener funDrawVideoAdLoadListener) {
        au auVar = this.mSlotIds.get(funAdSlot.getSid());
        if (auVar == null) {
            Log.e("FunAdSdk", "FunAdFactory load广告位：" + funAdSlot.getSid() + "未配置任何类型的广告ID列表");
            return;
        }
        FunDrawVideoAdLoader funDrawVideoAdLoader = this.mDrawVideoAdLoaders.get(funAdSlot.getSid());
        if (funDrawVideoAdLoader == null) {
            funDrawVideoAdLoader = new FunDrawVideoAdLoader(auVar);
            this.mDrawVideoAdLoaders.put(funAdSlot.getSid(), funDrawVideoAdLoader);
        }
        funDrawVideoAdLoader.setActivity(activity);
        funDrawVideoAdLoader.load(funAdSlot, funDrawVideoAdLoadListener);
    }

    public void loadNativeAd(@NonNull Activity activity, @NonNull FunAdSlot funAdSlot, @NonNull FunNativeAdLoadListener funNativeAdLoadListener) {
        au auVar = this.mSlotIds.get(funAdSlot.getSid());
        if (auVar == null) {
            Log.e("FunAdSdk", "FunAdFactory load广告位：" + funAdSlot.getSid() + "未配置任何类型的广告ID列表");
            return;
        }
        FunNativeAdLoader funNativeAdLoader = this.mNativeAdLoaders.get(funAdSlot.getSid());
        if (funNativeAdLoader == null) {
            funNativeAdLoader = new FunNativeAdLoader(auVar);
            this.mNativeAdLoaders.put(funAdSlot.getSid(), funNativeAdLoader);
        }
        funNativeAdLoader.setActivity(activity);
        funNativeAdLoader.load(funAdSlot, funNativeAdLoadListener);
    }

    public void setSlotIds(Map<String, au> map) {
        p pVar;
        HashMap hashMap = new HashMap(map);
        this.mSlotIds = hashMap;
        for (String str : hashMap.keySet()) {
            au auVar = this.mSlotIds.get(str);
            if (auVar != null && (pVar = this.mAdLoaders.get(auVar.f7758a)) != null) {
                pVar.pEE = auVar;
            }
        }
    }

    public void showAd(@NonNull Activity activity, FunAdView funAdView, @NonNull String str, @NonNull FunAdInteractionListener funAdInteractionListener) {
        boolean z;
        au.a aVar;
        au.a aVar2;
        boolean z2;
        au.a aVar3 = null;
        if (this.mSlotIds.get(str) == null) {
            Log.e("FunAdSdk", "FunAdFactory show广告位：" + str + "未配置任何类型的广告ID列表");
            funAdInteractionListener.onAdError(str);
            return;
        }
        p pVar = this.mAdLoaders.get(str);
        if (pVar != null) {
            List<au.a> list = pVar.pEE.c;
            if (list != null && !list.isEmpty()) {
                if (d.h) {
                    Iterator<au.a> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            aVar2 = null;
                            break;
                        }
                        au.a next = it.next();
                        p.b bVar = pVar.f.get(next.f7760a);
                        if (bVar != null && bVar.f7786b) {
                            FunRippedAd funRippedAd = pVar.k.get(next.f7760a);
                            if (funRippedAd == null) {
                                funRippedAd = pVar.b(next);
                                pVar.k.put(next.f7760a, funRippedAd);
                            }
                            if (funRippedAd != null && funRippedAd.isDeepLinkAd) {
                                aVar2 = next;
                                break;
                            }
                        }
                    }
                    if (aVar2 != null) {
                        for (au.a aVar4 : list) {
                            p.b bVar2 = pVar.f.get(aVar4.f7760a);
                            if (bVar2 != null && bVar2.f7786b) {
                                bVar2.a();
                            }
                        }
                        pVar.a(activity, funAdView, aVar2, funAdInteractionListener);
                        pVar.k.clear();
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        return;
                    }
                }
                for (au.a aVar5 : list) {
                    p.b bVar3 = pVar.f.get(aVar5.f7760a);
                    if (bVar3 != null && bVar3.f7786b) {
                        bVar3.a();
                        aVar = aVar3 == null ? aVar5 : aVar3;
                        if (!d.g || !pVar.a(aVar5)) {
                            pVar.a(activity, funAdView, aVar5, funAdInteractionListener);
                            pVar.k.clear();
                            z = true;
                            break;
                        }
                        aVar3 = aVar;
                    }
                }
                z = false;
                aVar = aVar3;
                if (z || aVar == null) {
                    return;
                }
                pVar.a(activity, funAdView, aVar, funAdInteractionListener);
                pVar.k.clear();
                return;
            }
            Log.e("FunAdSdk", "FunAdLoader show广告位：" + pVar.pEE.f7758a + "未配置任何类型的广告ID");
            return;
        }
        Log.e("FunAdSdk", "FunAdFactory: 广告展示错误，必须先load广告 sid: " + str);
        funAdInteractionListener.onAdError(str);
    }
}
