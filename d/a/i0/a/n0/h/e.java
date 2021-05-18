package d.a.i0.a.n0.h;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.favordata.SwanFavorDataManager;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.webkit.sdk.VideoCloudSetting;
import d.a.i0.a.k;
import d.a.i0.a.k2.g.h;
import d.a.i0.a.n0.l.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes2.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f43428a = k.f43025a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f43429b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f43430c;

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Set f43431e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f43432f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.n.j.i.a f43433g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ long f43434h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ b.C0752b f43435i;

        public a(Set set, boolean z, d.a.i0.n.j.i.a aVar, long j, b.C0752b c0752b) {
            this.f43431e = set;
            this.f43432f = z;
            this.f43433g = aVar;
            this.f43434h = j;
            this.f43435i = c0752b;
        }

        @Override // java.lang.Runnable
        public void run() {
            HashSet hashSet = new HashSet();
            Set set = this.f43431e;
            if (set != null) {
                hashSet.addAll(set);
            }
            Set<String> f2 = d.a.i0.a.a1.e.f();
            hashSet.addAll(f2);
            d.a.i0.a.e0.d.h("SwanAppDiskCleaner", "排除正在活动的小程：" + f2);
            Set<String> b2 = d.a.i0.a.n0.h.b.b();
            hashSet.addAll(b2);
            d.a.i0.a.e0.d.h("SwanAppDiskCleaner", "排除正在下载中的小程：" + b2);
            Map<String, PMSAppInfo> t = d.a.i0.n.g.a.h().t();
            if (d.a.i0.a.n0.f.c().d().n(t)) {
                if (e.f43428a) {
                    Log.d("SwanAppDiskCleaner", "删除所有小程序包下的历史版本包");
                }
                d.a.i0.a.a1.e.d(hashSet, t);
                Map m = e.this.m(86400000L, t);
                if (m.isEmpty()) {
                    return;
                }
                ArrayList arrayList = new ArrayList(m.keySet());
                e.k(hashSet, arrayList);
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                e.l(arrayList, arrayList2, arrayList3);
                ArrayList arrayList4 = new ArrayList();
                int max = Math.max(10, this.f43432f ? e.f43429b : this.f43433g.f47956d);
                e.r(arrayList3, max, arrayList4);
                long j = this.f43433g.f47957e;
                e.q(arrayList3, j * VideoCloudSetting.HOUR_MILLISECOND, arrayList4, m);
                int max2 = Math.max(40, this.f43432f ? e.f43430c : this.f43433g.f47954b);
                e.r(arrayList2, max2, arrayList4);
                long j2 = this.f43433g.f47955c;
                e.q(arrayList2, VideoCloudSetting.HOUR_MILLISECOND * j2, arrayList4, m);
                d.a.i0.a.e0.d.h("SwanAppDiskCleaner", "clean_internal_hour=" + this.f43434h + " pre_hold_count=" + max + " pre_force_clean_hour=" + j + " used_hold_count=" + max2 + " used_force_clean_hour=" + j2 + "\n appIdList(" + arrayList.size() + ")=" + arrayList + "\n historyList(" + arrayList2.size() + ")=" + arrayList2 + "\n preloadList(" + arrayList3.size() + ")=" + arrayList3 + "\n cleanList(" + arrayList4.size() + ")=" + arrayList4 + "\n");
                d.a.i0.a.n0.f.c().d().g(arrayList4, false, false, this.f43435i);
                d.a.i0.a.h0.m.r.a.c();
                return;
            }
            d.a.i0.a.e0.d.h("SwanAppDiskCleaner", "PMS数据库没有文件，不需要清理");
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements Comparator<PMSAppInfo> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(PMSAppInfo pMSAppInfo, PMSAppInfo pMSAppInfo2) {
            return Long.compare(pMSAppInfo2.createTime, pMSAppInfo.createTime);
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    static {
        d.a.i0.a.c1.a.Z().getSwitch("swan_disk_level_pkg_hold_used", 0);
        f43429b = 0;
        d.a.i0.a.c1.a.Z().getSwitch("swan_disk_level_pkg_hold_predownload", 0);
        f43430c = 0;
    }

    public static void k(Set<String> set, List<String> list) {
        if (set != null) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                if (set.contains(it.next())) {
                    it.remove();
                }
            }
        }
        list.remove("sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u");
    }

    public static void l(@NonNull List<String> list, @NonNull List<String> list2, @NonNull List<String> list3) {
        Set<String> h2 = d.a.i0.a.j0.c.b.h(AppRuntime.getAppContext().getContentResolver());
        List<SwanFavorItemData> i2 = SwanFavorDataManager.h().i();
        HashSet hashSet = new HashSet();
        for (SwanFavorItemData swanFavorItemData : i2) {
            hashSet.add(swanFavorItemData.getAppKey());
        }
        for (String str : list) {
            if (!h2.contains(str) && !hashSet.contains(str)) {
                list3.add(str);
            } else {
                list2.add(str);
            }
        }
    }

    public static boolean n() {
        return h.a().getBoolean("key_disk_force_clean", false);
    }

    public static boolean o(long j) {
        return System.currentTimeMillis() - h.a().getLong("clean_disk_check_time", 0L) < j;
    }

    public static void p(boolean z) {
        h.a().putBoolean("key_disk_force_clean", z);
    }

    public static void q(List<String> list, long j, List<String> list2, Map<String, Long> map) {
        Long l;
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!TextUtils.isEmpty(next) && (l = map.get(next)) != null && j < System.currentTimeMillis() - l.longValue()) {
                list2.add(next);
                it.remove();
            }
        }
    }

    public static void r(List<String> list, int i2, List<String> list2) {
        if (list == null || list.isEmpty() || i2 < 0 || i2 >= list.size()) {
            return;
        }
        Iterator<String> it = list.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            String next = it.next();
            if (!TextUtils.isEmpty(next)) {
                int i4 = i3 + 1;
                if (i3 >= i2) {
                    list2.add(next);
                    it.remove();
                }
                i3 = i4;
            }
        }
    }

    @AnyThread
    public synchronized void i(@Nullable Set<String> set, boolean z, b.C0752b c0752b) {
        j(set, z, c0752b);
    }

    @AnyThread
    public synchronized void j(@Nullable Set<String> set, boolean z, b.C0752b c0752b) {
        if (!ProcessUtils.isMainProcess()) {
            if (f43428a) {
                Log.w("SwanAppDiskCleaner", "非主进程调用，不执行操作");
            }
            return;
        }
        d.a.i0.a.e0.d.h("SwanAppDiskCleaner", "是否为强制自动清理：" + z);
        d.a.i0.n.j.i.a a2 = d.a.i0.n.j.i.b.b().a();
        boolean z2 = z && c.a();
        long j = a2.f47953a;
        if (z2 || !o(VideoCloudSetting.HOUR_MILLISECOND * j)) {
            h.a().putLong("clean_disk_check_time", System.currentTimeMillis());
            ExecutorUtilsExt.postOnSerial(new a(set, z, a2, j, c0752b), "cleanDiskSpaceOptimized");
        }
    }

    @NonNull
    @WorkerThread
    public final Map<String, Long> m(long j, Map<String, PMSAppInfo> map) {
        if (map != null && !map.isEmpty()) {
            ArrayList<PMSAppInfo> arrayList = new ArrayList(map.values());
            Collections.sort(arrayList, new b(null));
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (PMSAppInfo pMSAppInfo : arrayList) {
                long currentTimeMillis = System.currentTimeMillis();
                long j2 = pMSAppInfo.createTime;
                if (currentTimeMillis - j2 > j) {
                    linkedHashMap.put(pMSAppInfo.appId, Long.valueOf(j2));
                }
            }
            return linkedHashMap;
        }
        return Collections.emptyMap();
    }
}
