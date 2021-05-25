package com.bytedance.sdk.openadsdk.preload.geckox.a;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.os.SystemClock;
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
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: com.bytedance.sdk.openadsdk.preload.geckox.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0318a {

        /* renamed from: a  reason: collision with root package name */
        public String f29972a;

        /* renamed from: b  reason: collision with root package name */
        public String f29973b;

        /* renamed from: c  reason: collision with root package name */
        public int f29974c;

        /* renamed from: d  reason: collision with root package name */
        public long f29975d;

        /* renamed from: e  reason: collision with root package name */
        public File f29976e;

        public C0318a(String str, String str2, int i2, long j, File file) {
            this.f29972a = str;
            this.f29973b = str2;
            this.f29974c = i2;
            this.f29975d = j;
            this.f29976e = file;
        }
    }

    public static void b(Context context, List<C0318a> list, com.bytedance.sdk.openadsdk.preload.geckox.e.a aVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (C0318a c0318a : list) {
            File file = c0318a.f29976e;
            long uptimeMillis = SystemClock.uptimeMillis();
            boolean a2 = d.a(file);
            long uptimeMillis2 = SystemClock.uptimeMillis();
            if (a2) {
                if (aVar != null) {
                    aVar.b(c0318a.f29973b);
                }
                b.a(context).a(c0318a.f29972a, c0318a.f29973b, c0318a.f29974c, 200, c0318a.f29975d, 0, null, uptimeMillis2 - uptimeMillis, 1);
            } else {
                b.a(context).a(c0318a.f29972a, c0318a.f29973b, c0318a.f29974c, 201, c0318a.f29975d, 601, "delete failed", uptimeMillis2 - uptimeMillis, 1);
            }
        }
    }

    public static void a(final Context context, Map<String, ComponentModel.b> map, File file, final com.bytedance.sdk.openadsdk.preload.geckox.e.a aVar) {
        if (map == null || map.isEmpty()) {
            return;
        }
        final List<C0318a> list = null;
        try {
            list = a(map, file);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (list == null) {
            return;
        }
        f.a().execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.preload.geckox.a.a.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    a.b(context, list, aVar);
                } catch (Exception e3) {
                    com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("clean-channel", "", e3);
                }
            }
        });
    }

    public static List<C0318a> a(Map<String, ComponentModel.b> map, File file) {
        ComponentModel.b value;
        List<ComponentModel.a> list;
        Iterator<Map.Entry<String, ComponentModel.b>> it;
        Iterator<ComponentModel.a> it2;
        File file2;
        List<Long> b2;
        Iterator<Long> it3;
        File file3;
        List<Long> b3;
        Iterator<Map.Entry<String, ComponentModel.b>> it4;
        Iterator<ComponentModel.a> it5;
        String str;
        File file4;
        List<Long> list2;
        File file5;
        String str2;
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<String, ComponentModel.b>> it6 = map.entrySet().iterator();
        while (it6.hasNext()) {
            Map.Entry<String, ComponentModel.b> next = it6.next();
            String key = next.getKey();
            File file6 = new File(file, key);
            if (file6.isDirectory() && (value = next.getValue()) != null && (list = value.f30099a) != null && !list.isEmpty()) {
                List<ComponentModel.a> list3 = value.f30099a;
                HashSet hashSet = new HashSet();
                Iterator<ComponentModel.a> it7 = list3.iterator();
                while (it7.hasNext()) {
                    ComponentModel.a next2 = it7.next();
                    String str3 = next2.f30096a;
                    if (!hashSet.contains(str3)) {
                        hashSet.add(str3);
                        int i2 = next2.f30097b;
                        List<Long> list4 = next2.f30098c;
                        File file7 = new File(file6, str3);
                        String str4 = "";
                        String str5 = "--pending-delete";
                        if (i2 != 1) {
                            if (i2 != 2) {
                                if (i2 == 3) {
                                    File file8 = new File(file6, str3);
                                    File file9 = new File(file6, str3 + "--pending-delete");
                                    file8.renameTo(file9);
                                    arrayList.add(new C0318a(key, str3, i2, 0L, file9));
                                }
                            } else if (list4 != null && (b3 = k.b(file7)) != null && !b3.isEmpty()) {
                                for (Long l : b3) {
                                    if (list4.get(0).longValue() > l.longValue()) {
                                        File file10 = new File(file7, l + str5);
                                        it4 = it6;
                                        new File(file7, l + str4).renameTo(file10);
                                        it5 = it7;
                                        str = str5;
                                        file4 = file7;
                                        file5 = file6;
                                        str2 = str4;
                                        list2 = list4;
                                        arrayList.add(new C0318a(key, str3, i2, l.longValue(), file10));
                                    } else {
                                        it4 = it6;
                                        it5 = it7;
                                        str = str5;
                                        file4 = file7;
                                        list2 = list4;
                                        file5 = file6;
                                        str2 = str4;
                                    }
                                    it6 = it4;
                                    str5 = str;
                                    str4 = str2;
                                    list4 = list2;
                                    it7 = it5;
                                    file7 = file4;
                                    file6 = file5;
                                }
                            }
                            it = it6;
                            it2 = it7;
                            file2 = file6;
                        } else {
                            it = it6;
                            it2 = it7;
                            File file11 = file7;
                            file2 = file6;
                            if (list4 != null && (b2 = k.b(file11)) != null && !b2.isEmpty()) {
                                Iterator<Long> it8 = b2.iterator();
                                while (it8.hasNext()) {
                                    Long next3 = it8.next();
                                    if (list4.contains(next3)) {
                                        File file12 = file11;
                                        File file13 = new File(file12, next3 + "--pending-delete");
                                        new File(file12, next3 + "").renameTo(file13);
                                        it3 = it8;
                                        file3 = file12;
                                        arrayList.add(new C0318a(key, str3, i2, next3.longValue(), file13));
                                    } else {
                                        it3 = it8;
                                        file3 = file11;
                                    }
                                    file11 = file3;
                                    it8 = it3;
                                }
                            }
                        }
                        it6 = it;
                        it7 = it2;
                        file6 = file2;
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
            statisticModel.f30108common = common2;
            statisticModel.packages.addAll(a(bVar.a()));
            if (statisticModel.packages.isEmpty()) {
                return;
            }
            String str = "https://" + bVar.i() + "/gecko/server/packages/stats";
            String a2 = com.bytedance.sdk.openadsdk.preload.geckox.c.b.a().b().a(statisticModel);
            for (int i2 = 0; i2 < 3; i2++) {
                try {
                    a(bVar, str, a2);
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("clean-channel", "upload failed", a2);
        }
    }

    public static void a(com.bytedance.sdk.openadsdk.preload.geckox.b bVar, String str, String str2) throws Exception {
        com.bytedance.sdk.openadsdk.preload.geckox.i.c a2 = bVar.h().a(str, str2);
        if (a2.f30084c == 200) {
            if (new JSONObject(a2.f30083b).getInt("status") != 0) {
                throw new RuntimeException("upload failed");
            }
            return;
        }
        throw new NetworkErrorException("net work get failed, code: " + a2.f30084c + ", url:" + str);
    }
}
