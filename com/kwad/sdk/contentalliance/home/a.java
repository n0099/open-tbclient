package com.kwad.sdk.contentalliance.home;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f5754a = new a();
    private Map<Long, List<AdTemplate>> b = new HashMap();

    private a() {
    }

    public static a a() {
        return f5754a;
    }

    public static boolean a(@NonNull AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.b.c.b(adTemplate) && adTemplate.mPreloadData.isPreload && SystemClock.elapsedRealtime() - adTemplate.mPreloadData.mCacheTime < com.kwad.sdk.core.response.b.d.G(com.kwad.sdk.core.response.b.c.k(adTemplate)) - 120000;
    }

    public synchronized List<AdTemplate> a(long j) {
        ArrayList arrayList;
        List<AdTemplate> list = this.b != null ? this.b.get(Long.valueOf(j)) : null;
        if (list != null) {
            ArrayList arrayList2 = new ArrayList(list);
            Iterator<AdTemplate> it = arrayList2.iterator();
            while (it.hasNext()) {
                if (!a(it.next())) {
                    it.remove();
                }
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        return arrayList;
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
        this.b = hashMap;
    }

    public synchronized void b() {
        com.kwad.sdk.core.d.a.a("ContentDataMemCache", "clearAll()");
        if (this.b != null) {
            this.b.clear();
        }
    }

    public synchronized void b(long j) {
        com.kwad.sdk.core.d.a.a("ContentDataMemCache", "clear() posId=" + j);
        if (this.b != null && this.b.containsKey(Long.valueOf(j))) {
            List<AdTemplate> list = this.b.get(Long.valueOf(j));
            if (list != null) {
                list.clear();
            }
            this.b.remove(Long.valueOf(j));
        }
    }

    public synchronized boolean c(long j) {
        List<AdTemplate> list;
        list = this.b != null ? this.b.get(Long.valueOf(j)) : null;
        return list == null ? true : list.isEmpty();
    }
}
