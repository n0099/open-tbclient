package com.kwad.sdk.core.preload;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.AnyThread;
import com.ksad.download.d.b;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.core.diskcache.b.c;
import com.kwad.sdk.core.report.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.f;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class SplashPreloadManager {

    /* renamed from: a  reason: collision with root package name */
    private HashMap<String, PreLoadItem> f9676a;

    /* renamed from: b  reason: collision with root package name */
    private List<String> f9677b;
    private volatile SharedPreferences c;
    private final Object d;

    /* loaded from: classes5.dex */
    public static class PreLoadItem extends com.kwad.sdk.core.response.a.a implements Serializable {
        public long cacheTime;
        public long expiredTime;
        public String preloadId;
    }

    /* loaded from: classes5.dex */
    public static class PreLoadPara extends com.kwad.sdk.core.response.a.a implements Serializable {
        public int isValidReturned;
        public long spreadTime;
    }

    /* loaded from: classes5.dex */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final SplashPreloadManager f9678a = new SplashPreloadManager();
    }

    private SplashPreloadManager() {
        this.d = new Object();
        this.f9676a = new HashMap<>();
        this.f9677b = new ArrayList();
        a();
    }

    @AnyThread
    private void a(AdInfo adInfo) {
        PreLoadItem preLoadItem = new PreLoadItem();
        preLoadItem.cacheTime = System.currentTimeMillis();
        preLoadItem.expiredTime = System.currentTimeMillis() + (adInfo.adPreloadInfo.validityPeriod * 1000);
        preLoadItem.preloadId = com.kwad.sdk.core.response.b.a.H(adInfo);
        synchronized (this.d) {
            this.f9676a.put(adInfo.adPreloadInfo.preloadId, preLoadItem);
            if (!this.f9677b.contains(adInfo.adPreloadInfo.preloadId)) {
                this.f9677b.add(adInfo.adPreloadInfo.preloadId);
            }
        }
        if (this.c != null) {
            SharedPreferences.Editor edit = this.c.edit();
            edit.putString(adInfo.adPreloadInfo.preloadId, preLoadItem.toJson().toString());
            edit.apply();
        }
    }

    @AnyThread
    public static SplashPreloadManager b() {
        SplashPreloadManager splashPreloadManager = a.f9678a;
        if (splashPreloadManager.c == null) {
            splashPreloadManager.a();
        }
        return splashPreloadManager;
    }

    @AnyThread
    private boolean b(String str) {
        if (str != null) {
            File b2 = com.kwad.sdk.core.diskcache.b.a.a().b(str);
            com.kwad.sdk.core.d.a.a("PreloadManager", "check preloadId " + str + " file exists " + (b2 == null ? "null" : Boolean.valueOf(b2.exists())));
            return b2 != null && b2.exists();
        }
        return false;
    }

    private void d() {
        Map<String, ?> all = this.c.getAll();
        ArrayList<String> arrayList = new ArrayList();
        for (String str : all.keySet()) {
            PreLoadItem preLoadItem = new PreLoadItem();
            try {
                String str2 = (String) all.get(str);
                if (str2 != null) {
                    preLoadItem.parseJson(new JSONObject(str2));
                    if (!TextUtils.isEmpty(preLoadItem.preloadId)) {
                        File b2 = com.kwad.sdk.core.diskcache.b.a.a().b(preLoadItem.preloadId);
                        if (b2 == null || !b2.exists()) {
                            arrayList.add(preLoadItem.preloadId);
                            com.kwad.sdk.core.d.a.a("PreloadManager", "Remove null file list " + preLoadItem.preloadId);
                        } else {
                            synchronized (this.d) {
                                this.f9676a.put(str, preLoadItem);
                                if (!this.f9677b.contains(str)) {
                                    this.f9677b.add(str);
                                }
                            }
                        }
                    }
                }
            } catch (JSONException e) {
                com.kwad.sdk.core.d.a.a(e);
            }
        }
        SharedPreferences.Editor edit = this.c.edit();
        for (String str3 : arrayList) {
            edit.remove(str3);
        }
        edit.apply();
    }

    private void e() {
        int size;
        String str;
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.d) {
            ArrayList<String> arrayList = new ArrayList();
            for (String str2 : this.f9676a.keySet()) {
                PreLoadItem preLoadItem = this.f9676a.get(str2);
                if (preLoadItem != null && preLoadItem.expiredTime < currentTimeMillis) {
                    arrayList.add(str2);
                }
            }
            SharedPreferences.Editor edit = this.c.edit();
            for (String str3 : arrayList) {
                this.f9677b.remove(str3);
                this.f9676a.remove(str3);
                edit.remove(str3);
                com.kwad.sdk.core.diskcache.b.a.a().c(str3);
            }
            edit.apply();
            size = this.f9677b.size();
        }
        if (size > 30) {
            com.kwad.sdk.core.d.a.a("PreloadManager", "大于 30 按失效日期远近顺序移除");
            int i = size - 15;
            for (int i2 = 0; i2 < i; i2++) {
                long j = Long.MAX_VALUE;
                String str4 = "";
                synchronized (this.d) {
                    for (PreLoadItem preLoadItem2 : this.f9676a.values()) {
                        if (preLoadItem2.expiredTime < j) {
                            j = preLoadItem2.expiredTime;
                            str = preLoadItem2.preloadId;
                        } else {
                            str = str4;
                        }
                        str4 = str;
                    }
                    if (!TextUtils.isEmpty(str4)) {
                        this.f9677b.remove(str4);
                        this.f9676a.remove(str4);
                        this.c.edit().remove(str4).apply();
                        com.kwad.sdk.core.d.a.a("PreloadManager", "移除 preloadId = " + str4 + " expiredTime =  " + j);
                    }
                }
                if (!TextUtils.isEmpty(str4)) {
                    com.kwad.sdk.core.diskcache.b.a.a().c(str4);
                }
            }
        }
    }

    @AnyThread
    public int a(AdResultData adResultData, boolean z) {
        int i;
        int i2;
        int i3 = 0;
        for (AdTemplate adTemplate : adResultData.adTemplateList) {
            if (adTemplate != null) {
                Iterator<AdInfo> it = adTemplate.adInfoList.iterator();
                while (true) {
                    i2 = i3;
                    if (!it.hasNext()) {
                        break;
                    }
                    AdInfo next = it.next();
                    if (next.adPreloadInfo != null && this.c != null) {
                        if (b(next.adPreloadInfo.preloadId)) {
                            a(next);
                            i2++;
                        } else {
                            String a2 = com.kwad.sdk.core.response.b.a.J(next) ? com.kwad.sdk.core.response.b.a.a(next) : com.kwad.sdk.core.response.b.a.K(next) ? com.kwad.sdk.core.response.b.a.D(next).materialUrl : null;
                            if (!TextUtils.isEmpty(a2)) {
                                String H = com.kwad.sdk.core.response.b.a.H(next);
                                if (next.adPreloadInfo.preloadType != 1 || b.b(KsAdSDK.getContext()) || z) {
                                    com.kwad.sdk.core.d.a.a("PreloadManager", "start Download preloadId " + H + " true url " + a2);
                                    e();
                                    c.a aVar = new c.a();
                                    if (f.a(a2, H, aVar)) {
                                        a(next);
                                        i2++;
                                    } else {
                                        e.b(adTemplate, 1, aVar.f9385a);
                                    }
                                }
                            }
                        }
                    }
                    i3 = i2;
                }
                i = i2;
            } else {
                i = i3;
            }
            i3 = i;
        }
        AdTemplate adTemplate2 = adResultData.adTemplateList.size() > 0 ? adResultData.adTemplateList.get(0) : null;
        if (i3 > 0) {
            e.d(adTemplate2, i3);
        }
        return i3;
    }

    public File a(String str) {
        if (str != null) {
            com.kwad.sdk.core.d.a.a("PreloadManager", "getVideoFile preloadId " + str + "  url " + str);
            File b2 = com.kwad.sdk.core.diskcache.b.a.a().b(str);
            if (b2 != null && b2.exists()) {
                return b2;
            }
        }
        return null;
    }

    public void a() {
        Context context = KsAdSDK.getContext();
        if (context != null) {
            this.c = context.getSharedPreferences("ksadsdk_splash_preload_id_list", 0);
            d();
        }
    }

    @AnyThread
    public boolean a(AdResultData adResultData) {
        PreLoadItem preLoadItem;
        if (adResultData.adTemplateList.isEmpty()) {
            return false;
        }
        AdTemplate adTemplate = adResultData.adTemplateList.get(0);
        if (adTemplate.adInfoList.isEmpty()) {
            return false;
        }
        AdInfo adInfo = adTemplate.adInfoList.get(0);
        if (adInfo.adPreloadInfo != null) {
            String H = com.kwad.sdk.core.response.b.a.H(adInfo);
            boolean b2 = b(H);
            PreLoadPara preLoadPara = new PreLoadPara();
            preLoadPara.isValidReturned = b2 ? 1 : 0;
            if (b2) {
                synchronized (this.d) {
                    preLoadItem = this.f9676a.get(H);
                }
                if (preLoadItem != null) {
                    preLoadPara.spreadTime = preLoadItem.cacheTime;
                }
            }
            com.kwad.sdk.core.d.a.a("PreloadManager", "check checked " + b2 + " spreadTime " + preLoadPara.spreadTime);
            com.kwad.sdk.core.report.b.b(adTemplate, preLoadPara.toJson());
            return b2;
        }
        return false;
    }

    @AnyThread
    public boolean b(AdResultData adResultData) {
        if (!adResultData.adTemplateList.isEmpty()) {
            AdTemplate adTemplate = adResultData.adTemplateList.get(0);
            if (!adTemplate.adInfoList.isEmpty()) {
                return com.kwad.sdk.core.response.b.a.K(adTemplate.adInfoList.get(0));
            }
        }
        return false;
    }

    public List<String> c() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.d) {
            com.kwad.sdk.core.d.a.a("PreloadManager", "getPreloadIdList start ");
            for (int i = 0; i < this.f9677b.size(); i++) {
                String str = this.f9677b.get(i);
                File b2 = com.kwad.sdk.core.diskcache.b.a.a().b(str);
                if (b2 != null && b2.exists()) {
                    arrayList.add(str);
                }
            }
            com.kwad.sdk.core.d.a.a("PreloadManager", "getPreloadIdList end ");
        }
        com.kwad.sdk.core.d.a.a("PreloadManager", "getPreloadIdList " + this.f9677b.size());
        return arrayList;
    }
}
