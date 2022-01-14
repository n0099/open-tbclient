package com.kwad.sdk.core.preload;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.AnyThread;
import com.baidu.android.common.others.lang.StringUtil;
import com.ksad.download.c.b;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.diskcache.a.c;
import com.kwad.sdk.core.report.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.n;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class SplashPreloadManager {
    public HashMap<String, PreLoadItem> a;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f56014b;

    /* renamed from: c  reason: collision with root package name */
    public volatile SharedPreferences f56015c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f56016d;

    /* loaded from: classes3.dex */
    public static class PreLoadItem extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public long cacheTime;
        public long expiredTime;
        public String preloadId;
    }

    /* loaded from: classes3.dex */
    public static class PreLoadPara extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public int isValidReturned;
        public long spreadTime;
    }

    /* loaded from: classes3.dex */
    public static class a {
        public static final SplashPreloadManager a = new SplashPreloadManager();
    }

    public SplashPreloadManager() {
        this.f56016d = new Object();
        this.a = new HashMap<>();
        this.f56014b = new ArrayList();
        a();
    }

    @AnyThread
    private void a(AdInfo adInfo) {
        PreLoadItem preLoadItem = new PreLoadItem();
        preLoadItem.cacheTime = System.currentTimeMillis();
        preLoadItem.expiredTime = System.currentTimeMillis() + (adInfo.adPreloadInfo.validityPeriod * 1000);
        preLoadItem.preloadId = com.kwad.sdk.core.response.a.a.N(adInfo);
        synchronized (this.f56016d) {
            this.a.put(adInfo.adPreloadInfo.preloadId, preLoadItem);
            if (!this.f56014b.contains(adInfo.adPreloadInfo.preloadId)) {
                this.f56014b.add(adInfo.adPreloadInfo.preloadId);
            }
        }
        if (this.f56015c != null) {
            SharedPreferences.Editor edit = this.f56015c.edit();
            edit.putString(adInfo.adPreloadInfo.preloadId, preLoadItem.toJson().toString());
            edit.apply();
        }
    }

    @AnyThread
    public static SplashPreloadManager b() {
        SplashPreloadManager splashPreloadManager = a.a;
        if (splashPreloadManager.f56015c == null) {
            splashPreloadManager.a();
        }
        return splashPreloadManager;
    }

    @AnyThread
    private boolean b(String str) {
        if (str != null) {
            File b2 = com.kwad.sdk.core.diskcache.a.a.a().b(str);
            StringBuilder sb = new StringBuilder();
            sb.append("check preloadId ");
            sb.append(str);
            sb.append(" file exists ");
            sb.append(b2 == null ? StringUtil.NULL_STRING : Boolean.valueOf(b2.exists()));
            com.kwad.sdk.core.d.a.a("PreloadManager", sb.toString());
            return b2 != null && b2.exists();
        }
        return false;
    }

    private void d() {
        Map<String, ?> all = this.f56015c.getAll();
        ArrayList<String> arrayList = new ArrayList();
        for (String str : all.keySet()) {
            PreLoadItem preLoadItem = new PreLoadItem();
            try {
                String str2 = (String) all.get(str);
                if (str2 != null) {
                    preLoadItem.parseJson(new JSONObject(str2));
                    if (!TextUtils.isEmpty(preLoadItem.preloadId)) {
                        File b2 = com.kwad.sdk.core.diskcache.a.a.a().b(preLoadItem.preloadId);
                        if (b2 == null || !b2.exists()) {
                            arrayList.add(preLoadItem.preloadId);
                            com.kwad.sdk.core.d.a.a("PreloadManager", "Remove null file list " + preLoadItem.preloadId);
                        } else {
                            synchronized (this.f56016d) {
                                this.a.put(str, preLoadItem);
                                if (!this.f56014b.contains(str)) {
                                    this.f56014b.add(str);
                                }
                            }
                        }
                    }
                }
            } catch (JSONException e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
        }
        SharedPreferences.Editor edit = this.f56015c.edit();
        for (String str3 : arrayList) {
            edit.remove(str3);
        }
        edit.apply();
    }

    private void e() {
        int size;
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.f56016d) {
            ArrayList<String> arrayList = new ArrayList();
            for (String str : this.a.keySet()) {
                PreLoadItem preLoadItem = this.a.get(str);
                if (preLoadItem != null && preLoadItem.expiredTime < currentTimeMillis) {
                    arrayList.add(str);
                }
            }
            SharedPreferences.Editor edit = this.f56015c.edit();
            for (String str2 : arrayList) {
                this.f56014b.remove(str2);
                this.a.remove(str2);
                edit.remove(str2);
                com.kwad.sdk.core.diskcache.a.a.a().d(str2);
            }
            edit.apply();
            size = this.f56014b.size();
        }
        if (size > 30) {
            com.kwad.sdk.core.d.a.a("PreloadManager", "大于 30 按失效日期远近顺序移除");
            int i2 = size - 15;
            for (int i3 = 0; i3 < i2; i3++) {
                long j2 = Long.MAX_VALUE;
                String str3 = "";
                synchronized (this.f56016d) {
                    for (PreLoadItem preLoadItem2 : this.a.values()) {
                        if (preLoadItem2.expiredTime < j2) {
                            j2 = preLoadItem2.expiredTime;
                            str3 = preLoadItem2.preloadId;
                        }
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        this.f56014b.remove(str3);
                        this.a.remove(str3);
                        this.f56015c.edit().remove(str3).apply();
                        com.kwad.sdk.core.d.a.a("PreloadManager", "移除 preloadId = " + str3 + " expiredTime =  " + j2);
                    }
                }
                if (!TextUtils.isEmpty(str3)) {
                    com.kwad.sdk.core.diskcache.a.a.a().d(str3);
                }
            }
        }
    }

    @AnyThread
    public int a(AdResultData adResultData, boolean z) {
        Iterator<AdTemplate> it = adResultData.adTemplateList.iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            AdTemplate next = it.next();
            if (next != null) {
                for (AdInfo adInfo : next.adInfoList) {
                    if (adInfo.adPreloadInfo != null && this.f56015c != null) {
                        if (!b(adInfo.adPreloadInfo.preloadId)) {
                            String a2 = com.kwad.sdk.core.response.a.a.P(adInfo) ? com.kwad.sdk.core.response.a.a.a(adInfo) : com.kwad.sdk.core.response.a.a.Q(adInfo) ? com.kwad.sdk.core.response.a.a.I(adInfo).materialUrl : null;
                            if (!TextUtils.isEmpty(a2)) {
                                String N = com.kwad.sdk.core.response.a.a.N(adInfo);
                                if (adInfo.adPreloadInfo.preloadType != 1 || b.b(KsAdSDKImpl.get().getContext()) || z) {
                                    com.kwad.sdk.core.d.a.a("PreloadManager", "start Download preloadId " + N + " true url " + a2);
                                    e();
                                    c.a aVar = new c.a();
                                    if (!n.a(a2, N, aVar)) {
                                        d.a(next, 1, aVar.a);
                                    }
                                }
                            }
                        }
                        a(adInfo);
                        i2++;
                    }
                }
            }
        }
        AdTemplate adTemplate = adResultData.adTemplateList.size() > 0 ? adResultData.adTemplateList.get(0) : null;
        if (i2 > 0) {
            d.a(adTemplate, i2);
        }
        return i2;
    }

    public File a(String str) {
        if (str != null) {
            com.kwad.sdk.core.d.a.a("PreloadManager", "getVideoFile preloadId " + str + "  url " + str);
            File b2 = com.kwad.sdk.core.diskcache.a.a.a().b(str);
            if (b2 == null || !b2.exists()) {
                return null;
            }
            return b2;
        }
        return null;
    }

    public void a() {
        Context context = KsAdSDKImpl.get().getContext();
        if (context != null) {
            this.f56015c = context.getSharedPreferences("ksadsdk_splash_preload_id_list", 0);
            d();
        }
    }

    @AnyThread
    public boolean a(AdResultData adResultData) {
        PreLoadItem preLoadItem;
        boolean z = false;
        z = false;
        z = false;
        if (!adResultData.adTemplateList.isEmpty()) {
            AdTemplate adTemplate = adResultData.adTemplateList.get(0);
            if (!adTemplate.adInfoList.isEmpty()) {
                AdInfo adInfo = adTemplate.adInfoList.get(0);
                if (adInfo.adPreloadInfo != null) {
                    String N = com.kwad.sdk.core.response.a.a.N(adInfo);
                    z = b(N);
                    PreLoadPara preLoadPara = new PreLoadPara();
                    preLoadPara.isValidReturned = z ? 1 : 0;
                    if (z) {
                        synchronized (this.f56016d) {
                            preLoadItem = this.a.get(N);
                        }
                        if (preLoadItem != null) {
                            preLoadPara.spreadTime = preLoadItem.cacheTime;
                        }
                    }
                    com.kwad.sdk.core.d.a.a("PreloadManager", "check checked " + z + " spreadTime " + preLoadPara.spreadTime);
                    com.kwad.sdk.core.report.a.b(adTemplate, preLoadPara.toJson());
                }
            }
        }
        return z;
    }

    @AnyThread
    public boolean b(AdResultData adResultData) {
        if (!adResultData.adTemplateList.isEmpty()) {
            AdTemplate adTemplate = adResultData.adTemplateList.get(0);
            if (!adTemplate.adInfoList.isEmpty()) {
                return com.kwad.sdk.core.response.a.a.Q(adTemplate.adInfoList.get(0));
            }
        }
        return false;
    }

    public List<String> c() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.f56016d) {
            com.kwad.sdk.core.d.a.a("PreloadManager", "getPreloadIdList start ");
            for (int i2 = 0; i2 < this.f56014b.size(); i2++) {
                String str = this.f56014b.get(i2);
                File b2 = com.kwad.sdk.core.diskcache.a.a.a().b(str);
                if (b2 != null && b2.exists()) {
                    arrayList.add(str);
                }
            }
            com.kwad.sdk.core.d.a.a("PreloadManager", "getPreloadIdList end ");
        }
        com.kwad.sdk.core.d.a.a("PreloadManager", "getPreloadIdList " + this.f56014b.size());
        return arrayList;
    }
}
