package d.b.g0.a.j0.h;

import android.util.Log;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.webkit.sdk.VideoCloudSetting;
import d.b.g0.a.a2.g.h;
import d.b.g0.a.i2.p;
import d.b.g0.a.j0.j.b;
import d.b.g0.a.k;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes2.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f44816a = k.f45051a;

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Set f44817e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b.C0708b f44818f;

        public a(Set set, b.C0708b c0708b) {
            this.f44817e = set;
            this.f44818f = c0708b;
        }

        @Override // java.lang.Runnable
        public void run() {
            List<String> a2;
            h.a().putLong("clean_disk_check_time", System.currentTimeMillis());
            Map e2 = f.this.e(0L);
            if (e2.isEmpty()) {
                if (f.f44816a) {
                    Log.d("SwanAppDiskCleaner", "cleanDiskSpace empty");
                    return;
                }
                return;
            }
            List<String> arrayList = new ArrayList<>(e2.keySet());
            for (d.b.g0.a.j0.h.a aVar : Arrays.asList(new e(this.f44817e), new d(), new c())) {
                arrayList = aVar.a(arrayList);
            }
            if (arrayList == null || arrayList.isEmpty()) {
                if (f.f44816a) {
                    Log.i("SwanAppDiskCleaner", "cleanDiskSpace empty after strategy");
                    return;
                }
                return;
            }
            if (f.f44816a) {
                Log.i("SwanAppDiskCleaner", "after strategy swanApp size=" + arrayList.size());
            }
            d.b.g0.l.m.i.a a3 = d.b.g0.l.m.i.b.b().a();
            long j = a3.f49024b;
            long j2 = a3.f49026d;
            long j3 = a3.f49025c;
            long j4 = a3.f49023a;
            if (f.f44816a) {
                Log.i("SwanAppDiskCleaner", "forceCleanHour=" + j + ", ignoreCleanHour=" + j2 + ", holdMaxCount=" + j3 + ", maxCount=" + j4);
            }
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ((Long) e2.get(next)).longValue() <= j2 * VideoCloudSetting.HOUR_MILLISECOND) {
                    it.remove();
                    arrayList3.add(next);
                } else if (currentTimeMillis - ((Long) e2.get(next)).longValue() > VideoCloudSetting.HOUR_MILLISECOND * j) {
                    it.remove();
                    arrayList2.add(next);
                }
            }
            if (f.f44816a) {
                Log.i("SwanAppDiskCleaner", "timeoutSize=" + arrayList2.size() + ", ignoreCleanSize=" + arrayList3.size() + " normalSize=" + arrayList.size() + " allSize=" + e2.size());
            }
            List<String> a4 = new d.b.g0.a.j0.h.b((int) j3).a(arrayList);
            if (a4 != null) {
                a4.addAll(arrayList2);
                arrayList2 = a4;
            }
            if (arrayList3.size() > j4 && (a2 = new d.b.g0.a.j0.h.b((int) j4).a(arrayList3)) != null) {
                arrayList2.addAll(a2);
            }
            if (f.f44816a) {
                Log.i("SwanAppDiskCleaner", "deleteSwanAppList=" + arrayList2);
            }
            d.b.g0.a.j0.e.c().d().g(arrayList2, false, false, this.f44818f);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Comparator<PMSAppInfo> {
        public b(f fVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(PMSAppInfo pMSAppInfo, PMSAppInfo pMSAppInfo2) {
            return Long.compare(pMSAppInfo.createTime, pMSAppInfo2.createTime);
        }

        public /* synthetic */ b(f fVar, a aVar) {
            this(fVar);
        }
    }

    public final boolean c() {
        long j = h.a().getLong("clean_disk_check_time", 0L);
        boolean z = System.currentTimeMillis() - j >= 86400000;
        if (f44816a && !z) {
            Log.w("SwanAppDiskCleaner", "未达到指定频率不清理, lastTime=" + j + ", now=" + System.currentTimeMillis());
        }
        return z;
    }

    @AnyThread
    public synchronized void d(@Nullable Set<String> set, b.C0708b c0708b) {
        if (!ProcessUtils.isMainProcess()) {
            if (f44816a) {
                Log.w("SwanAppDiskCleaner", "非主进程调用，不执行操作");
            }
        } else if (c()) {
            p.g().execute(new a(set, c0708b), "cleanDiskSpace");
        }
    }

    @NonNull
    @WorkerThread
    public final Map<String, Long> e(long j) {
        Map<String, PMSAppInfo> s = d.b.g0.l.i.a.h().s();
        if (s != null && !s.isEmpty()) {
            ArrayList<PMSAppInfo> arrayList = new ArrayList(s.values());
            Collections.sort(arrayList, new b(this, null));
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
