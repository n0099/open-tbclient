package com.duxiaoman.dxmpay.statistics.internal;

import android.text.TextUtils;
import d.d.a.a.b.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public class StatService {

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentHashMap<String, Long> f30722a;

    /* loaded from: classes6.dex */
    public enum ETag {
        in,
        out,
        push,
        back
    }

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static StatService f30723a = new StatService();
    }

    public static StatService a() {
        return a.f30723a;
    }

    public static void b(String str) {
        a().f30722a.put(str, Long.valueOf(System.currentTimeMillis()));
    }

    public static void c(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        i.a().c(str, null, str2, str3, System.currentTimeMillis());
    }

    public static void d(String str, String str2, String str3, String str4) {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add(0, "");
        long f2 = f(str);
        if (f2 > 0) {
            arrayList.add(Long.toString(f2));
            hashMap.put("duration", Long.valueOf(f2));
        }
        arrayList.add(str2);
        if (str3 != null) {
            arrayList.add(str3);
        }
        e(str, null, arrayList, hashMap, str4);
    }

    public static void e(String str, String str2, Collection<String> collection, Map<String, Object> map, String str3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        i.a().d(str, str2, collection, map, str3, System.currentTimeMillis());
    }

    public static long f(String str) {
        Long l = a().f30722a.get(str);
        if (l == null) {
            return -1L;
        }
        Long valueOf = Long.valueOf(System.currentTimeMillis() - l.longValue());
        a().f30722a.remove(str);
        return valueOf.longValue();
    }

    public static void g(String str, String str2, Collection<String> collection, Map<String, Object> map, String str3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(0, "");
        long f2 = f(str);
        if (f2 > 0) {
            arrayList.add(Long.toString(f2));
            if (map == null) {
                map = new HashMap<>();
            }
            map.put("duration", Long.valueOf(f2));
        }
        arrayList.add(str2);
        if (collection != null) {
            arrayList.addAll(collection);
        }
        e(str, null, arrayList, map, str3);
    }

    public StatService() {
        this.f30722a = new ConcurrentHashMap<>();
    }
}
