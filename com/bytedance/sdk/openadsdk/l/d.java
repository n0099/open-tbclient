package com.bytedance.sdk.openadsdk.l;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final ConcurrentLinkedQueue<com.bytedance.sdk.openadsdk.l.a.a> f29765a = new ConcurrentLinkedQueue<>();

    public static void a(a aVar, long j, long j2) {
        if (aVar == null) {
            return;
        }
        f29765a.offer(new com.bytedance.sdk.openadsdk.l.a.a(aVar.a(), aVar.getCorePoolSize(), aVar.getMaximumPoolSize(), j, j2));
        a(false);
    }

    public static void a(boolean z) {
        int valueOf;
        c g2 = e.g();
        if ((z || f29765a.size() >= 60) && g2 != null) {
            synchronized (f29765a) {
                if (f29765a.isEmpty()) {
                    return;
                }
                com.bytedance.sdk.openadsdk.l.a.a[] aVarArr = (com.bytedance.sdk.openadsdk.l.a.a[]) f29765a.toArray(new com.bytedance.sdk.openadsdk.l.a.a[f29765a.size()]);
                f29765a.clear();
                int i = 0;
                if (aVarArr.length != 0) {
                    HashMap hashMap = new HashMap();
                    for (com.bytedance.sdk.openadsdk.l.a.a aVar : aVarArr) {
                        String a2 = a(aVar.a(), aVar.b(), aVar.c());
                        com.bytedance.sdk.openadsdk.l.a.c cVar = (com.bytedance.sdk.openadsdk.l.a.c) hashMap.get(a2);
                        if (cVar == null) {
                            hashMap.put(a2, new com.bytedance.sdk.openadsdk.l.a.c(aVar.a(), aVar.b(), aVar.c(), aVar.d(), aVar.d(), aVar.e(), aVar.e(), 1));
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
                    }
                    for (com.bytedance.sdk.openadsdk.l.a.c cVar2 : hashMap.values()) {
                        if (cVar2.e() > 0 && !TextUtils.isEmpty(cVar2.b())) {
                            String b2 = cVar2.b();
                            char c2 = 65535;
                            int hashCode = b2.hashCode();
                            if (hashCode != 3366) {
                                if (hashCode == 2993840 && b2.equals("aidl")) {
                                    c2 = 1;
                                }
                            } else if (b2.equals("io")) {
                                c2 = 0;
                            }
                            if (c2 == 0) {
                                cVar2.b(((ThreadPoolExecutor) e.a()).getLargestPoolSize());
                            } else if (c2 == 1) {
                                cVar2.b(((ThreadPoolExecutor) e.c()).getLargestPoolSize());
                            }
                            g2.a(cVar2);
                        }
                    }
                }
                Set<Thread> keySet = Thread.getAllStackTraces().keySet();
                HashMap hashMap2 = new HashMap();
                int i2 = 0;
                for (Thread thread : keySet) {
                    String name = thread.getName();
                    if (!TextUtils.isEmpty(name) && name.startsWith("tt_pangle_thread_")) {
                        i2++;
                        Integer num = (Integer) hashMap2.get(name);
                        if (num == null) {
                            valueOf = 1;
                        } else {
                            valueOf = Integer.valueOf(num.intValue() + 1);
                        }
                        hashMap2.put(name, valueOf);
                    }
                }
                JSONArray jSONArray = new JSONArray();
                for (String str : hashMap2.keySet()) {
                    try {
                        jSONArray.put(i, ((Integer) hashMap2.get(str)) + "_" + str);
                        i++;
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                g2.a(new com.bytedance.sdk.openadsdk.l.a.b(i2, jSONArray.toString()));
            }
        }
    }

    public static String a(String str, int i, int i2) {
        return str + "_core_" + i + "_max_" + i2;
    }
}
