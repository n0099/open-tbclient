package com.kwad.components.splash;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.AnyThread;
import com.baidu.android.common.others.lang.StringUtil;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.components.core.video.f;
import com.kwad.components.splash.monitor.SplashMonitorInfo;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.diskcache.a.c;
import com.kwad.sdk.core.e.b;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ae;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class SplashPreloadManager {
    public HashMap<String, PreLoadItem> QD;
    public List<String> QE;
    public volatile SharedPreferences QF;
    public final Object mLock;

    @KsJson
    /* loaded from: classes9.dex */
    public static class PreLoadItem extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public long cacheTime;
        public long expiredTime;
        public String preloadId;
    }

    @KsJson
    /* loaded from: classes9.dex */
    public static class PreLoadPara extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public int isValidReturned;
        public long spreadTime;
    }

    /* loaded from: classes9.dex */
    public static class a {
        public static final SplashPreloadManager QG = new SplashPreloadManager((byte) 0);
    }

    public SplashPreloadManager() {
        this.mLock = new Object();
        this.QD = new HashMap<>();
        this.QE = new ArrayList();
        init();
    }

    public /* synthetic */ SplashPreloadManager(byte b) {
        this();
    }

    @AnyThread
    public static boolean aY(String str) {
        if (str != null) {
            File ad = com.kwad.sdk.core.diskcache.a.a.sS().ad(str);
            StringBuilder sb = new StringBuilder("check preloadId ");
            sb.append(str);
            sb.append(" file exists ");
            sb.append(ad == null ? StringUtil.NULL_STRING : Boolean.valueOf(ad.exists()));
            b.d("PreloadManager", sb.toString());
            if (ad != null && ad.exists()) {
                return true;
            }
        }
        return false;
    }

    public static File aZ(String str) {
        if (str != null) {
            b.d("PreloadManager", "getVideoFile preloadId " + str + "  url " + str);
            File ad = com.kwad.sdk.core.diskcache.a.a.sS().ad(str);
            if (ad == null || !ad.exists()) {
                return null;
            }
            return ad;
        }
        return null;
    }

    private void dT() {
        Map<String, ?> all = this.QF.getAll();
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
                            File ad = com.kwad.sdk.core.diskcache.a.a.sS().ad(preLoadItem.preloadId);
                            if (ad == null || !ad.exists()) {
                                arrayList.add(preLoadItem.preloadId);
                                b.d("PreloadManager", "Remove null file list " + preLoadItem.preloadId);
                            } else {
                                synchronized (this.mLock) {
                                    this.QD.put(str, preLoadItem);
                                    if (!this.QE.contains(str)) {
                                        this.QE.add(str);
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (Exception e) {
                b.printStackTrace(e);
            }
        }
        SharedPreferences.Editor edit = this.QF.edit();
        for (String str3 : arrayList) {
            edit.remove(str3);
        }
        edit.apply();
    }

    @AnyThread
    public static boolean g(AdResultData adResultData) {
        if (!adResultData.getAdTemplateList().isEmpty()) {
            AdTemplate adTemplate = adResultData.getAdTemplateList().get(0);
            if (!adTemplate.adInfoList.isEmpty()) {
                return com.kwad.sdk.core.response.a.a.aC(adTemplate.adInfoList.get(0));
            }
        }
        return false;
    }

    private void init() {
        Context context = KsAdSDKImpl.get().getContext();
        if (context != null) {
            this.QF = context.getSharedPreferences("ksadsdk_splash_preload_id_list", 0);
            dT();
        }
    }

    private void qC() {
        int size;
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.mLock) {
            ArrayList<String> arrayList = new ArrayList();
            for (String str : this.QD.keySet()) {
                PreLoadItem preLoadItem = this.QD.get(str);
                if (preLoadItem != null && preLoadItem.expiredTime < currentTimeMillis) {
                    arrayList.add(str);
                }
            }
            SharedPreferences.Editor edit = this.QF.edit();
            for (String str2 : arrayList) {
                this.QE.remove(str2);
                this.QD.remove(str2);
                edit.remove(str2);
                com.kwad.sdk.core.diskcache.a.a.sS().remove(str2);
            }
            edit.apply();
            size = this.QE.size();
        }
        if (size > 30) {
            b.d("PreloadManager", "大于 30 按失效日期远近顺序移除");
            int i = size - 15;
            for (int i2 = 0; i2 < i; i2++) {
                long j = Long.MAX_VALUE;
                String str3 = "";
                synchronized (this.mLock) {
                    for (PreLoadItem preLoadItem2 : this.QD.values()) {
                        if (preLoadItem2.expiredTime < j) {
                            j = preLoadItem2.expiredTime;
                            str3 = preLoadItem2.preloadId;
                        }
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        this.QE.remove(str3);
                        this.QD.remove(str3);
                        this.QF.edit().remove(str3).apply();
                        b.d("PreloadManager", "移除 preloadId = " + str3 + " expiredTime =  " + j);
                    }
                }
                if (!TextUtils.isEmpty(str3)) {
                    com.kwad.sdk.core.diskcache.a.a.sS().remove(str3);
                }
            }
        }
    }

    @AnyThread
    public static SplashPreloadManager qD() {
        SplashPreloadManager splashPreloadManager = a.QG;
        if (splashPreloadManager.QF == null) {
            splashPreloadManager.init();
        }
        return splashPreloadManager;
    }

    @AnyThread
    private void v(AdInfo adInfo) {
        PreLoadItem preLoadItem = new PreLoadItem();
        preLoadItem.cacheTime = System.currentTimeMillis();
        preLoadItem.expiredTime = System.currentTimeMillis() + (adInfo.adPreloadInfo.validityPeriod * 1000);
        preLoadItem.preloadId = com.kwad.sdk.core.response.a.a.az(adInfo);
        synchronized (this.mLock) {
            this.QD.put(adInfo.adPreloadInfo.preloadId, preLoadItem);
            if (!this.QE.contains(adInfo.adPreloadInfo.preloadId)) {
                this.QE.add(adInfo.adPreloadInfo.preloadId);
            }
        }
        if (this.QF != null) {
            SharedPreferences.Editor edit = this.QF.edit();
            edit.putString(adInfo.adPreloadInfo.preloadId, preLoadItem.toJson().toString());
            edit.apply();
        }
    }

    @AnyThread
    public final int b(AdResultData adResultData, boolean z) {
        Iterator<AdTemplate> it = adResultData.getAdTemplateList().iterator();
        com.kwad.components.splash.monitor.a.qG();
        com.kwad.components.splash.monitor.a.h(adResultData);
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            AdTemplate next = it.next();
            if (next != null) {
                for (AdInfo adInfo : next.adInfoList) {
                    if (adInfo.adPreloadInfo == null || this.QF == null) {
                        com.kwad.components.splash.monitor.a.qG();
                        com.kwad.components.splash.monitor.a.a(adInfo, 3, SplashMonitorInfo.ERROR_PRELOAD_ID_INVALID_MSG);
                    } else {
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        if (aY(adInfo.adPreloadInfo.preloadId)) {
                            com.kwad.components.splash.monitor.a.qG().a(adInfo, SystemClock.elapsedRealtime() - elapsedRealtime, 2);
                            v(adInfo);
                            i++;
                        } else {
                            String A = com.kwad.sdk.core.response.a.a.aB(adInfo) ? com.kwad.sdk.core.response.a.a.A(adInfo) : com.kwad.sdk.core.response.a.a.aC(adInfo) ? com.kwad.sdk.core.response.a.a.at(adInfo).materialUrl : null;
                            if (TextUtils.isEmpty(A)) {
                                com.kwad.components.splash.monitor.a.qG();
                                com.kwad.components.splash.monitor.a.a(adInfo, 2, SplashMonitorInfo.ERROR_URL_INVALID_MSG);
                            } else {
                                String az = com.kwad.sdk.core.response.a.a.az(adInfo);
                                if (adInfo.adPreloadInfo.preloadType != 1 || ae.isWifiConnected(KsAdSDKImpl.get().getContext()) || z) {
                                    b.d("PreloadManager", "start Download preloadId " + az + " true url " + A);
                                    qC();
                                    c.a aVar = new c.a();
                                    if (f.a(A, az, aVar)) {
                                        v(adInfo);
                                        i++;
                                        com.kwad.components.splash.monitor.a.qG().a(adInfo, SystemClock.elapsedRealtime() - elapsedRealtime, 1);
                                    } else {
                                        com.kwad.components.splash.monitor.a.qG();
                                        com.kwad.components.splash.monitor.a.a(adInfo, 4, aVar.Qd);
                                        com.kwad.components.core.j.a.og().b(next, 1, aVar.Qd);
                                    }
                                } else {
                                    com.kwad.components.splash.monitor.a.qG();
                                    com.kwad.components.splash.monitor.a.a(adInfo, 1, SplashMonitorInfo.ERROR_NET_MSG);
                                }
                            }
                        }
                    }
                }
            }
        }
        AdTemplate adTemplate = adResultData.getAdTemplateList().size() > 0 ? adResultData.getAdTemplateList().get(0) : null;
        if (i > 0) {
            com.kwad.components.core.j.a.og().d(adTemplate, i);
        }
        return i;
    }

    @AnyThread
    public final boolean f(AdResultData adResultData) {
        PreLoadItem preLoadItem;
        boolean z = false;
        z = false;
        z = false;
        if (!adResultData.getAdTemplateList().isEmpty()) {
            AdTemplate adTemplate = adResultData.getAdTemplateList().get(0);
            if (!adTemplate.adInfoList.isEmpty()) {
                AdInfo adInfo = adTemplate.adInfoList.get(0);
                if (adInfo.adPreloadInfo != null) {
                    String az = com.kwad.sdk.core.response.a.a.az(adInfo);
                    z = aY(az);
                    PreLoadPara preLoadPara = new PreLoadPara();
                    preLoadPara.isValidReturned = z ? 1 : 0;
                    if (z) {
                        synchronized (this.mLock) {
                            preLoadItem = this.QD.get(az);
                        }
                        if (preLoadItem != null) {
                            preLoadPara.spreadTime = preLoadItem.cacheTime;
                        }
                    }
                    b.d("PreloadManager", "check checked " + z + " spreadTime " + preLoadPara.spreadTime);
                    com.kwad.sdk.core.report.a.c(adTemplate, preLoadPara.toJson());
                }
            }
        }
        return z;
    }

    public final List<String> qE() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.mLock) {
            b.d("PreloadManager", "getPreloadIdList start ");
            for (int i = 0; i < this.QE.size(); i++) {
                String str = this.QE.get(i);
                File ad = com.kwad.sdk.core.diskcache.a.a.sS().ad(str);
                if (ad != null && ad.exists()) {
                    arrayList.add(str);
                }
            }
            b.d("PreloadManager", "getPreloadIdList end ");
        }
        b.d("PreloadManager", "getPreloadIdList " + this.QE.size());
        return arrayList;
    }
}
