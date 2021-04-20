package com.kwad.sdk.contentalliance.home;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.baidu.searchbox.config.AppConfig;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static a f32849a = new a();

    /* renamed from: b  reason: collision with root package name */
    public Map<Long, List<AdTemplate>> f32850b = new HashMap();

    public static a a() {
        return f32849a;
    }

    public static boolean a(@NonNull AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.b.c.b(adTemplate) && adTemplate.mPreloadData.isPreload && SystemClock.elapsedRealtime() - adTemplate.mPreloadData.mCacheTime < com.kwad.sdk.core.response.b.d.G(com.kwad.sdk.core.response.b.c.k(adTemplate)) - AppConfig.TIMESTAMP_AVAILABLE_DURATION;
    }

    public synchronized List<AdTemplate> a(long j) {
        List<AdTemplate> list = this.f32850b != null ? this.f32850b.get(Long.valueOf(j)) : null;
        if (list != null) {
            ArrayList arrayList = new ArrayList(list);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (!a((AdTemplate) it.next())) {
                    it.remove();
                }
            }
            return arrayList;
        }
        return null;
    }

    public synchronized void a(@NonNull List<AdTemplate> list) {
        com.kwad.sdk.core.d.a.a("ContentDataMemCache", "save()");
        HashMap hashMap = new HashMap();
        for (AdTemplate adTemplate : list) {
            List list2 = (List) hashMap.get(Long.valueOf(adTemplate.posId));
            if (list2 == null) {
                list2 = new ArrayList();
                hashMap.put(Long.valueOf(adTemplate.posId), list2);
            }
            KSImageLoader.preloadImage(com.kwad.sdk.core.response.b.c.m(adTemplate).a(), adTemplate);
            adTemplate.mPreloadData.mCacheTime = SystemClock.elapsedRealtime();
            adTemplate.mPreloadData.isPreload = true;
            list2.add(adTemplate);
            com.kwad.sdk.core.d.a.a("ContentDataMemCache", "preload save posId=" + adTemplate.posId);
        }
        this.f32850b = hashMap;
    }

    public synchronized void b() {
        com.kwad.sdk.core.d.a.a("ContentDataMemCache", "clearAll()");
        if (this.f32850b != null) {
            this.f32850b.clear();
        }
    }

    public synchronized void b(long j) {
        com.kwad.sdk.core.d.a.a("ContentDataMemCache", "clear() posId=" + j);
        if (this.f32850b != null && this.f32850b.containsKey(Long.valueOf(j))) {
            List<AdTemplate> list = this.f32850b.get(Long.valueOf(j));
            if (list != null) {
                list.clear();
            }
            this.f32850b.remove(Long.valueOf(j));
        }
    }

    public synchronized boolean c(long j) {
        List<AdTemplate> list;
        list = this.f32850b != null ? this.f32850b.get(Long.valueOf(j)) : null;
        return list == null ? true : list.isEmpty();
    }
}
