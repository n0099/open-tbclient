package com.bytedance.sdk.openadsdk.j;

import android.text.TextUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static final ConcurrentLinkedQueue<com.bytedance.sdk.openadsdk.j.a.a> f4865a = new ConcurrentLinkedQueue<>();

    public static void a(a aVar, long j, long j2) {
        if (aVar != null) {
            f4865a.offer(new com.bytedance.sdk.openadsdk.j.a.a(aVar.a(), aVar.getCorePoolSize(), aVar.getMaximumPoolSize(), j, j2));
            a(false);
        }
    }

    public static void a(boolean z) {
        int valueOf;
        c f = e.f();
        if ((z || f4865a.size() >= 60) && f != null) {
            synchronized (f4865a) {
                if (!f4865a.isEmpty()) {
                    com.bytedance.sdk.openadsdk.j.a.a[] aVarArr = (com.bytedance.sdk.openadsdk.j.a.a[]) f4865a.toArray(new com.bytedance.sdk.openadsdk.j.a.a[f4865a.size()]);
                    f4865a.clear();
                    if (aVarArr.length != 0) {
                        HashMap hashMap = new HashMap();
                        int length = aVarArr.length;
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= length) {
                                break;
                            }
                            com.bytedance.sdk.openadsdk.j.a.a aVar = aVarArr[i2];
                            String a2 = a(aVar.a(), aVar.b(), aVar.c());
                            com.bytedance.sdk.openadsdk.j.a.c cVar = (com.bytedance.sdk.openadsdk.j.a.c) hashMap.get(a2);
                            if (cVar == null) {
                                hashMap.put(a2, new com.bytedance.sdk.openadsdk.j.a.c(aVar.a(), aVar.b(), aVar.c(), aVar.d(), aVar.d(), aVar.e(), aVar.e(), 1));
                            } else {
                                if (aVar.d() > cVar.c()) {
                                    cVar.a(aVar.d());
                                }
                                cVar.b(aVar.d());
                                if (aVar.e() > cVar.d()) {
                                    cVar.c(aVar.e());
                                }
                                cVar.d(aVar.e());
                                cVar.a(1);
                            }
                            i = i2 + 1;
                        }
                        for (com.bytedance.sdk.openadsdk.j.a.c cVar2 : hashMap.values()) {
                            if (cVar2.e() > 0 && !TextUtils.isEmpty(cVar2.b())) {
                                String b = cVar2.b();
                                char c = 65535;
                                switch (b.hashCode()) {
                                    case 3366:
                                        if (b.equals("io")) {
                                            c = 0;
                                            break;
                                        }
                                        break;
                                    case 2993840:
                                        if (b.equals("aidl")) {
                                            c = 1;
                                            break;
                                        }
                                        break;
                                }
                                switch (c) {
                                    case 0:
                                        cVar2.b(((ThreadPoolExecutor) e.a()).getLargestPoolSize());
                                        break;
                                    case 1:
                                        cVar2.b(((ThreadPoolExecutor) e.b()).getLargestPoolSize());
                                        break;
                                }
                                f.a(cVar2);
                            }
                        }
                    }
                    Set<Thread> keySet = Thread.getAllStackTraces().keySet();
                    int i3 = 0;
                    HashMap hashMap2 = new HashMap();
                    Iterator<Thread> it = keySet.iterator();
                    while (true) {
                        int i4 = i3;
                        if (it.hasNext()) {
                            String name = it.next().getName();
                            if (!TextUtils.isEmpty(name) && name.startsWith("tt_pangle_thread_")) {
                                i4++;
                                Integer num = (Integer) hashMap2.get(name);
                                if (num == null) {
                                    valueOf = 1;
                                } else {
                                    valueOf = Integer.valueOf(num.intValue() + 1);
                                }
                                hashMap2.put(name, valueOf);
                            }
                            i3 = i4;
                        } else {
                            JSONArray jSONArray = new JSONArray();
                            int i5 = 0;
                            Iterator it2 = hashMap2.keySet().iterator();
                            while (true) {
                                int i6 = i5;
                                if (it2.hasNext()) {
                                    String str = (String) it2.next();
                                    try {
                                        jSONArray.put(i6, ((Integer) hashMap2.get(str)) + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str);
                                        i5 = i6 + 1;
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                        i5 = i6;
                                    }
                                } else {
                                    f.a(new com.bytedance.sdk.openadsdk.j.a.b(i4, jSONArray.toString()));
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static String a(String str, int i, int i2) {
        return str + "_core_" + i + "_max_" + i2;
    }
}
