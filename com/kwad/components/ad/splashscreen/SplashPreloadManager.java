package com.kwad.components.ad.splashscreen;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.AnyThread;
import com.baidu.android.common.others.lang.StringUtil;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.ad.splashscreen.monitor.SplashMonitorInfo;
import com.kwad.components.core.video.j;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.network.a.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.i;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class SplashPreloadManager {
    public HashMap<String, PreLoadItem> Cl;
    public List<String> Cm;
    public volatile SharedPreferences Cn;
    public final Object mLock;

    @KsJson
    /* loaded from: classes10.dex */
    public static class PreLoadItem extends com.kwad.sdk.core.response.a.a implements Serializable {
        public long cacheTime;
        public long expiredTime;
        public String preloadId;
    }

    /* loaded from: classes10.dex */
    public static class a {
        public static final SplashPreloadManager Co = new SplashPreloadManager((byte) 0);
    }

    public SplashPreloadManager() {
        this.mLock = new Object();
        this.Cl = new HashMap<>();
        this.Cm = new ArrayList();
        init();
    }

    private void init() {
        Context context = KsAdSDKImpl.get().getContext();
        if (context != null) {
            this.Cn = context.getSharedPreferences("ksadsdk_splash_preload_id_list", 0);
            initData();
        }
    }

    @AnyThread
    public static SplashPreloadManager kw() {
        SplashPreloadManager splashPreloadManager = a.Co;
        if (splashPreloadManager.Cn == null) {
            splashPreloadManager.init();
        }
        return splashPreloadManager;
    }

    public /* synthetic */ SplashPreloadManager(byte b) {
        this();
    }

    public static File T(String str) {
        if (str != null) {
            com.kwad.sdk.core.e.c.d("PreloadManager", "getVideoFile preloadId " + str + "  url " + str);
            File bO = com.kwad.sdk.core.diskcache.b.a.BS().bO(str);
            if (bO != null && bO.exists()) {
                return bO;
            }
            return null;
        }
        return null;
    }

    @AnyThread
    public static boolean f(AdResultData adResultData) {
        if (!adResultData.getAdTemplateList().isEmpty()) {
            AdTemplate adTemplate = adResultData.getAdTemplateList().get(0);
            if (!adTemplate.adInfoList.isEmpty()) {
                return com.kwad.sdk.core.response.b.a.bd(adTemplate.adInfoList.get(0));
            }
        }
        return false;
    }

    public static boolean p(AdInfo adInfo) {
        if (com.kwad.sdk.core.config.d.a(com.kwad.components.ad.splashscreen.b.a.CP) && com.kwad.sdk.core.response.b.a.bd(adInfo)) {
            return true;
        }
        return false;
    }

    private void initData() {
        Map<String, ?> all = this.Cn.getAll();
        ArrayList<String> arrayList = new ArrayList();
        for (String str : all.keySet()) {
            PreLoadItem preLoadItem = new PreLoadItem();
            try {
                Object obj = all.get(str);
                if (obj instanceof String) {
                    String str2 = (String) obj;
                    if (!TextUtils.isEmpty(str2)) {
                        preLoadItem.parseJson(new JSONObject(str2));
                        if (!TextUtils.isEmpty(preLoadItem.preloadId)) {
                            File bO = com.kwad.sdk.core.diskcache.b.a.BS().bO(preLoadItem.preloadId);
                            if (bO != null && bO.exists()) {
                                synchronized (this.mLock) {
                                    this.Cl.put(str, preLoadItem);
                                    if (!this.Cm.contains(str)) {
                                        this.Cm.add(str);
                                    }
                                }
                            } else {
                                arrayList.add(preLoadItem.preloadId);
                                com.kwad.sdk.core.e.c.d("PreloadManager", "Remove null file list " + preLoadItem.preloadId);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                com.kwad.sdk.core.e.c.printStackTrace(e);
            }
        }
        SharedPreferences.Editor edit = this.Cn.edit();
        for (String str3 : arrayList) {
            edit.remove(str3);
        }
        edit.apply();
    }

    private void kv() {
        int size;
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.mLock) {
            ArrayList<String> arrayList = new ArrayList();
            for (String str : this.Cl.keySet()) {
                PreLoadItem preLoadItem = this.Cl.get(str);
                if (preLoadItem != null && preLoadItem.expiredTime < currentTimeMillis) {
                    arrayList.add(str);
                }
            }
            SharedPreferences.Editor edit = this.Cn.edit();
            for (String str2 : arrayList) {
                this.Cm.remove(str2);
                this.Cl.remove(str2);
                edit.remove(str2);
                com.kwad.sdk.core.diskcache.b.a.BS().remove(str2);
            }
            edit.apply();
            size = this.Cm.size();
        }
        if (size > 30) {
            com.kwad.sdk.core.e.c.d("PreloadManager", "大于 30 按失效日期远近顺序移除");
            int i = size - 15;
            for (int i2 = 0; i2 < i; i2++) {
                long j = Long.MAX_VALUE;
                String str3 = "";
                synchronized (this.mLock) {
                    for (PreLoadItem preLoadItem2 : this.Cl.values()) {
                        if (preLoadItem2.expiredTime < j) {
                            j = preLoadItem2.expiredTime;
                            str3 = preLoadItem2.preloadId;
                        }
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        this.Cm.remove(str3);
                        this.Cl.remove(str3);
                        this.Cn.edit().remove(str3).apply();
                        com.kwad.sdk.core.e.c.d("PreloadManager", "移除 preloadId = " + str3 + " expiredTime =  " + j);
                    }
                }
                if (!TextUtils.isEmpty(str3)) {
                    com.kwad.sdk.core.diskcache.b.a.BS().remove(str3);
                }
            }
        }
    }

    @AnyThread
    private void o(AdInfo adInfo) {
        PreLoadItem preLoadItem = new PreLoadItem();
        preLoadItem.cacheTime = System.currentTimeMillis();
        preLoadItem.expiredTime = System.currentTimeMillis() + (adInfo.adPreloadInfo.validityPeriod * 1000);
        preLoadItem.preloadId = com.kwad.sdk.core.response.b.a.aZ(adInfo);
        synchronized (this.mLock) {
            this.Cl.put(adInfo.adPreloadInfo.preloadId, preLoadItem);
            if (!this.Cm.contains(adInfo.adPreloadInfo.preloadId)) {
                this.Cm.add(adInfo.adPreloadInfo.preloadId);
            }
        }
        if (this.Cn != null) {
            SharedPreferences.Editor edit = this.Cn.edit();
            edit.putString(adInfo.adPreloadInfo.preloadId, preLoadItem.toJson().toString());
            edit.apply();
        }
    }

    @AnyThread
    private boolean q(AdInfo adInfo) {
        Object valueOf;
        if (p(adInfo)) {
            return KSImageLoader.isImageExist(com.kwad.sdk.core.response.b.a.aU(adInfo).materialUrl);
        }
        String str = adInfo.adPreloadInfo.preloadId;
        if (str != null) {
            File bO = com.kwad.sdk.core.diskcache.b.a.BS().bO(str);
            StringBuilder sb = new StringBuilder("check preloadId ");
            sb.append(str);
            sb.append(" file exists ");
            if (bO == null) {
                valueOf = StringUtil.NULL_STRING;
            } else {
                valueOf = Boolean.valueOf(bO.exists());
            }
            sb.append(valueOf);
            com.kwad.sdk.core.e.c.d("PreloadManager", sb.toString());
            if (bO != null && bO.exists()) {
                return true;
            }
        }
        return false;
    }

    public final List<String> R() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.mLock) {
            com.kwad.sdk.core.e.c.d("PreloadManager", "getPreloadIdList start ");
            for (int i = 0; i < this.Cm.size(); i++) {
                String str = this.Cm.get(i);
                File bO = com.kwad.sdk.core.diskcache.b.a.BS().bO(str);
                if (bO != null && bO.exists()) {
                    arrayList.add(str);
                }
            }
            com.kwad.sdk.core.e.c.d("PreloadManager", "getPreloadIdList end ");
        }
        com.kwad.sdk.core.e.c.d("PreloadManager", "getPreloadIdList " + this.Cm.size());
        return arrayList;
    }

    @AnyThread
    public final int b(AdResultData adResultData, boolean z) {
        AdTemplate adTemplate;
        String str;
        boolean z2;
        boolean a2;
        Iterator<AdTemplate> it = adResultData.getAdTemplateList().iterator();
        com.kwad.components.ad.splashscreen.monitor.b.kO();
        com.kwad.components.ad.splashscreen.monitor.b.g(adResultData);
        int i = 0;
        while (true) {
            adTemplate = null;
            if (!it.hasNext()) {
                break;
            }
            AdTemplate next = it.next();
            if (next != null) {
                for (AdInfo adInfo : next.adInfoList) {
                    if (adInfo.adPreloadInfo != null && this.Cn != null) {
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        if (!q(adInfo)) {
                            if (com.kwad.sdk.core.response.b.a.bc(adInfo)) {
                                str = com.kwad.sdk.core.response.b.a.K(adInfo);
                            } else if (com.kwad.sdk.core.response.b.a.bd(adInfo)) {
                                str = com.kwad.sdk.core.response.b.a.aU(adInfo).materialUrl;
                            } else {
                                str = null;
                            }
                            if (!TextUtils.isEmpty(str)) {
                                String aZ = com.kwad.sdk.core.response.b.a.aZ(adInfo);
                                if (adInfo.adPreloadInfo.preloadType == 1 && !ag.isWifiConnected(KsAdSDKImpl.get().getContext()) && !z) {
                                    z2 = false;
                                } else {
                                    z2 = true;
                                }
                                if (z2) {
                                    com.kwad.sdk.core.e.c.d("PreloadManager", "start Download preloadId " + aZ + " true url " + str);
                                    kv();
                                    a.C0709a c0709a = new a.C0709a();
                                    if (p(adInfo)) {
                                        if (KSImageLoader.loadImageSync(str) != null) {
                                            a2 = true;
                                        } else {
                                            a2 = false;
                                        }
                                    } else {
                                        a2 = j.a(str, aZ, c0709a);
                                    }
                                    if (a2) {
                                        o(adInfo);
                                        i++;
                                        com.kwad.components.ad.splashscreen.monitor.b.kO();
                                        com.kwad.components.ad.splashscreen.monitor.b.a(next, SystemClock.elapsedRealtime() - elapsedRealtime, 1);
                                    } else {
                                        com.kwad.components.ad.splashscreen.monitor.b.kO();
                                        com.kwad.components.ad.splashscreen.monitor.b.d(next, 4, c0709a.msg);
                                        com.kwad.components.core.o.a.pX().f(next, 1, c0709a.msg);
                                    }
                                } else {
                                    com.kwad.components.ad.splashscreen.monitor.b.kO();
                                    com.kwad.components.ad.splashscreen.monitor.b.d(next, 1, SplashMonitorInfo.ERROR_NET_MSG);
                                }
                            } else {
                                com.kwad.components.ad.splashscreen.monitor.b.kO();
                                com.kwad.components.ad.splashscreen.monitor.b.d(next, 2, SplashMonitorInfo.ERROR_URL_INVALID_MSG);
                            }
                        } else {
                            com.kwad.components.ad.splashscreen.monitor.b.kO();
                            com.kwad.components.ad.splashscreen.monitor.b.a(next, SystemClock.elapsedRealtime() - elapsedRealtime, 2);
                            o(adInfo);
                            i++;
                        }
                    } else {
                        com.kwad.components.ad.splashscreen.monitor.b.kO();
                        com.kwad.components.ad.splashscreen.monitor.b.d(next, 3, SplashMonitorInfo.ERROR_PRELOAD_ID_INVALID_MSG);
                    }
                }
            }
        }
        if (adResultData.getAdTemplateList().size() > 0) {
            adTemplate = adResultData.getAdTemplateList().get(0);
        }
        if (i > 0) {
            i.an("splashAd_", "onSplashVideoAdCacheSuccess");
            com.kwad.components.core.o.a.pX().e(adTemplate, i);
        } else {
            i.an("splashAd_", "onSplashVideoAdCacheFailed");
        }
        return i;
    }

    @AnyThread
    public final boolean e(AdResultData adResultData) {
        if (!adResultData.getAdTemplateList().isEmpty()) {
            AdTemplate adTemplate = adResultData.getAdTemplateList().get(0);
            if (!adTemplate.adInfoList.isEmpty()) {
                AdInfo adInfo = adTemplate.adInfoList.get(0);
                if (adInfo.adPreloadInfo != null) {
                    if (p(adInfo)) {
                        return KSImageLoader.isImageExist(com.kwad.sdk.core.response.b.a.aU(adInfo).materialUrl);
                    }
                    return q(adInfo);
                }
            }
        }
        return false;
    }
}
