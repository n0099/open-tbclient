package com.bytedance.sdk.openadsdk.preload.geckox.a;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.os.SystemClock;
import com.baidu.sapi2.utils.SapiUtils;
import com.bytedance.sdk.openadsdk.preload.geckox.model.Common;
import com.bytedance.sdk.openadsdk.preload.geckox.model.ComponentModel;
import com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.StatisticModel;
import com.bytedance.sdk.openadsdk.preload.geckox.utils.d;
import com.bytedance.sdk.openadsdk.preload.geckox.utils.f;
import com.bytedance.sdk.openadsdk.preload.geckox.utils.i;
import com.bytedance.sdk.openadsdk.preload.geckox.utils.k;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    public static void a(final Context context, Map<String, ComponentModel.b> map, File file, final com.bytedance.sdk.openadsdk.preload.geckox.e.a aVar) {
        if (map != null && !map.isEmpty()) {
            final List<C1030a> list = null;
            try {
                list = a(map, file);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (list != null) {
                f.a().execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.preload.geckox.a.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            a.b(context, list, aVar);
                        } catch (Exception e2) {
                            com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("clean-channel", "", e2);
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, List<C1030a> list, com.bytedance.sdk.openadsdk.preload.geckox.e.a aVar) {
        if (list != null && !list.isEmpty()) {
            for (C1030a c1030a : list) {
                File file = c1030a.e;
                long uptimeMillis = SystemClock.uptimeMillis();
                boolean a2 = d.a(file);
                long uptimeMillis2 = SystemClock.uptimeMillis();
                if (a2) {
                    if (aVar != null) {
                        aVar.b(c1030a.f7443b);
                    }
                    b.a(context).a(c1030a.f7442a, c1030a.f7443b, c1030a.c, 200, c1030a.d, 0, null, uptimeMillis2 - uptimeMillis, 1);
                } else {
                    b.a(context).a(c1030a.f7442a, c1030a.f7443b, c1030a.c, 201, c1030a.d, 601, "delete failed", uptimeMillis2 - uptimeMillis, 1);
                }
            }
        }
    }

    private static List<C1030a> a(Map<String, ComponentModel.b> map, File file) {
        ComponentModel.b value;
        List<Long> b2;
        List<Long> b3;
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, ComponentModel.b> entry : map.entrySet()) {
            String key = entry.getKey();
            File file2 = new File(file, key);
            if (file2.isDirectory() && (value = entry.getValue()) != null && value.f7508a != null && !value.f7508a.isEmpty()) {
                List<ComponentModel.a> list = value.f7508a;
                HashSet hashSet = new HashSet();
                for (ComponentModel.a aVar : list) {
                    String str = aVar.f7506a;
                    if (!hashSet.contains(str)) {
                        hashSet.add(str);
                        int i = aVar.f7507b;
                        List<Long> list2 = aVar.c;
                        File file3 = new File(file2, str);
                        switch (i) {
                            case 1:
                                if (list2 != null && (b3 = k.b(file3)) != null && !b3.isEmpty()) {
                                    for (Long l : b3) {
                                        if (list2.contains(l)) {
                                            File file4 = new File(file3, l + "--pending-delete");
                                            new File(file3, l + "").renameTo(file4);
                                            arrayList.add(new C1030a(key, str, i, l.longValue(), file4));
                                        }
                                    }
                                    break;
                                }
                                break;
                            case 2:
                                if (list2 != null && (b2 = k.b(file3)) != null && !b2.isEmpty()) {
                                    for (Long l2 : b2) {
                                        if (list2.get(0).longValue() > l2.longValue()) {
                                            File file5 = new File(file3, l2 + "--pending-delete");
                                            new File(file3, l2 + "").renameTo(file5);
                                            arrayList.add(new C1030a(key, str, i, l2.longValue(), file5));
                                        }
                                    }
                                    break;
                                }
                                break;
                            case 3:
                                File file6 = new File(file2, str);
                                File file7 = new File(file2, str + "--pending-delete");
                                file6.renameTo(file7);
                                arrayList.add(new C1030a(key, str, i, 0L, file7));
                                break;
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public static List<StatisticModel.PackageStatisticModel> a(Context context) {
        return b.a(context).a();
    }

    public static void a(com.bytedance.sdk.openadsdk.preload.geckox.b bVar) {
        if (bVar.c()) {
            Common common2 = new Common(bVar.j(), bVar.n(), bVar.q(), com.bytedance.sdk.openadsdk.preload.geckox.utils.a.b(bVar.a()), i.a(bVar.a()), bVar.k(), bVar.l());
            StatisticModel statisticModel = new StatisticModel();
            statisticModel.f7516common = common2;
            statisticModel.packages.addAll(a(bVar.a()));
            if (!statisticModel.packages.isEmpty()) {
                String str = SapiUtils.COOKIE_HTTPS_URL_PREFIX + bVar.i() + "/gecko/server/packages/stats";
                String a2 = com.bytedance.sdk.openadsdk.preload.geckox.c.b.a().b().a(statisticModel);
                for (int i = 0; i < 3; i++) {
                    try {
                        a(bVar, str, a2);
                        return;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("clean-channel", "upload failed", a2);
            }
        }
    }

    private static void a(com.bytedance.sdk.openadsdk.preload.geckox.b bVar, String str, String str2) throws Exception {
        com.bytedance.sdk.openadsdk.preload.geckox.i.c a2 = bVar.h().a(str, str2);
        if (a2.c != 200) {
            throw new NetworkErrorException("net work get failed, code: " + a2.c + ", url:" + str);
        }
        if (new JSONObject(a2.f7496b).getInt("status") != 0) {
            throw new RuntimeException("upload failed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.bytedance.sdk.openadsdk.preload.geckox.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1030a {

        /* renamed from: a  reason: collision with root package name */
        String f7442a;

        /* renamed from: b  reason: collision with root package name */
        String f7443b;
        int c;
        long d;
        File e;

        C1030a(String str, String str2, int i, long j, File file) {
            this.f7442a = str;
            this.f7443b = str2;
            this.c = i;
            this.d = j;
            this.e = file;
        }
    }
}
