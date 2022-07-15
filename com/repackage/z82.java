package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.favordata.SwanFavorDataManager;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ba2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes7.dex */
public class z82 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static final int b;
    public static final int c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Set a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ yb4 c;
        public final /* synthetic */ long d;
        public final /* synthetic */ ba2.b e;
        public final /* synthetic */ z82 f;

        public a(z82 z82Var, Set set, boolean z, yb4 yb4Var, long j, ba2.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z82Var, set, Boolean.valueOf(z), yb4Var, Long.valueOf(j), bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = z82Var;
            this.a = set;
            this.b = z;
            this.c = yb4Var;
            this.d = j;
            this.e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                HashSet hashSet = new HashSet();
                Set set = this.a;
                if (set != null) {
                    hashSet.addAll(set);
                }
                Set<String> f = dj2.f();
                hashSet.addAll(f);
                hx1.k("SwanAppDiskCleaner", "排除正在活动的小程：" + f);
                Set<String> b = w82.b();
                hashSet.addAll(b);
                hx1.k("SwanAppDiskCleaner", "排除正在下载中的小程：" + b);
                Map<String, PMSAppInfo> v = c84.i().v();
                if (t82.c().d().n(v)) {
                    if (z82.a) {
                        Log.d("SwanAppDiskCleaner", "删除所有小程序包下的历史版本包");
                    }
                    dj2.d(hashSet, v);
                    Map m = this.f.m(86400000L, v);
                    if (m.isEmpty()) {
                        return;
                    }
                    ArrayList arrayList = new ArrayList(m.keySet());
                    z82.k(hashSet, arrayList);
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    z82.l(arrayList, arrayList2, arrayList3);
                    ArrayList arrayList4 = new ArrayList();
                    int max = Math.max(10, this.b ? z82.b : this.c.d);
                    z82.r(arrayList3, max, arrayList4);
                    long j = this.c.e;
                    z82.q(arrayList3, j * 3600000, arrayList4, m);
                    int max2 = Math.max(40, this.b ? z82.c : this.c.b);
                    z82.r(arrayList2, max2, arrayList4);
                    long j2 = this.c.c;
                    z82.q(arrayList2, 3600000 * j2, arrayList4, m);
                    hx1.k("SwanAppDiskCleaner", "clean_internal_hour=" + this.d + " pre_hold_count=" + max + " pre_force_clean_hour=" + j + " used_hold_count=" + max2 + " used_force_clean_hour=" + j2 + "\n appIdList(" + arrayList.size() + ")=" + arrayList + "\n historyList(" + arrayList2.size() + ")=" + arrayList2 + "\n preloadList(" + arrayList3.size() + ")=" + arrayList3 + "\n cleanList(" + arrayList4.size() + ")=" + arrayList4 + "\n");
                    t82.c().d().g(arrayList4, false, false, this.e);
                    z32.c();
                    return;
                }
                hx1.k("SwanAppDiskCleaner", "PMS数据库没有文件，不需要清理");
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements Comparator<PMSAppInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(PMSAppInfo pMSAppInfo, PMSAppInfo pMSAppInfo2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, pMSAppInfo, pMSAppInfo2)) == null) ? Long.compare(pMSAppInfo2.createTime, pMSAppInfo.createTime) : invokeLL.intValue;
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755158211, "Lcom/repackage/z82;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755158211, "Lcom/repackage/z82;");
                return;
            }
        }
        a = rg1.a;
        oj2.g0().getSwitch("swan_disk_level_pkg_hold_used", 0);
        b = 0;
        oj2.g0().getSwitch("swan_disk_level_pkg_hold_predownload", 0);
        c = 0;
    }

    public z82() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void k(Set<String> set, List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, set, list) == null) {
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
    }

    public static void l(@NonNull List<String> list, @NonNull List<String> list2, @NonNull List<String> list3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, null, list, list2, list3) == null) {
            Set<String> i = k72.i(AppRuntime.getAppContext().getContentResolver());
            List<SwanFavorItemData> i2 = SwanFavorDataManager.h().i();
            HashSet hashSet = new HashSet();
            for (SwanFavorItemData swanFavorItemData : i2) {
                hashSet.add(swanFavorItemData.getAppKey());
            }
            for (String str : list) {
                if (!i.contains(str) && !hashSet.contains(str)) {
                    list3.add(str);
                } else {
                    list2.add(str);
                }
            }
        }
    }

    public static boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? v83.a().getBoolean("key_disk_force_clean", false) : invokeV.booleanValue;
    }

    public static boolean o(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65549, null, j)) == null) ? System.currentTimeMillis() - v83.a().getLong("clean_disk_check_time", 0L) < j : invokeJ.booleanValue;
    }

    public static void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65550, null, z) == null) {
            v83.a().putBoolean("key_disk_force_clean", z);
        }
    }

    public static void q(List<String> list, long j, List<String> list2, Map<String, Long> map) {
        Long l;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65551, null, new Object[]{list, Long.valueOf(j), list2, map}) == null) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!TextUtils.isEmpty(next) && (l = map.get(next)) != null && j < System.currentTimeMillis() - l.longValue()) {
                    list2.add(next);
                    it.remove();
                }
            }
        }
    }

    public static void r(List<String> list, int i, List<String> list2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(65552, null, list, i, list2) == null) || list == null || list.isEmpty() || i < 0 || i >= list.size()) {
            return;
        }
        Iterator<String> it = list.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            String next = it.next();
            if (!TextUtils.isEmpty(next)) {
                int i3 = i2 + 1;
                if (i2 >= i) {
                    list2.add(next);
                    it.remove();
                }
                i2 = i3;
            }
        }
    }

    @AnyThread
    public synchronized void i(@Nullable Set<String> set, boolean z, ba2.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{set, Boolean.valueOf(z), bVar}) == null) {
            synchronized (this) {
                j(set, z, bVar);
            }
        }
    }

    @AnyThread
    public synchronized void j(@Nullable Set<String> set, boolean z, ba2.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{set, Boolean.valueOf(z), bVar}) == null) {
            synchronized (this) {
                if (!ProcessUtils.isMainProcess()) {
                    if (a) {
                        Log.w("SwanAppDiskCleaner", "非主进程调用，不执行操作");
                    }
                    return;
                }
                hx1.k("SwanAppDiskCleaner", "是否为强制自动清理：" + z);
                yb4 a2 = zb4.b().a();
                boolean z2 = z && x82.a();
                long j = a2.a;
                if (z2 || !o(3600000 * j)) {
                    v83.a().putLong("clean_disk_check_time", System.currentTimeMillis());
                    ExecutorUtilsExt.postOnSerial(new a(this, set, z, a2, j, bVar), "cleanDiskSpaceOptimized");
                }
            }
        }
    }

    @NonNull
    @WorkerThread
    public final Map<String, Long> m(long j, Map<String, PMSAppInfo> map) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(Constants.METHOD_SEND_USER_MSG, this, j, map)) == null) {
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
        return (Map) invokeJL.objValue;
    }
}
