package d.a.q0.a.n0;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.favordata.SwanFavorDataManager;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.k;
import d.a.q0.a.k2.g.h;
import d.a.q0.a.n0.l.b;
import d.a.q0.a.p.b.a.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes8.dex */
public class d implements d.a.q0.a.m.c, d.a.q0.a.n0.l.b {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean m;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final InterfaceC0878d f49511e;

    /* renamed from: f  reason: collision with root package name */
    public final String f49512f;

    /* renamed from: g  reason: collision with root package name */
    public g f49513g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.q0.a.n0.c f49514h;

    /* renamed from: i  reason: collision with root package name */
    public l f49515i;
    public AtomicInteger j;
    public CopyOnWriteArrayList<String> k;
    public d.a.q0.a.n0.h.e l;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f49516e;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49516e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.q0.a.c1.a.a0().c(this.f49516e);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f49517e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f49518f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b.C0882b f49519g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d f49520h;

        public b(d dVar, List list, boolean z, b.C0882b c0882b) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, list, Boolean.valueOf(z), c0882b};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49520h = dVar;
            this.f49517e = list;
            this.f49518f = z;
            this.f49519g = c0882b;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f49520h.h(this.f49517e, this.f49518f, this.f49519g);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class c extends ProviderDelegation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
        public Bundle execCall(Bundle bundle) {
            InterceptResult invokeL;
            HashSet hashSet;
            int i2;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bundle)) == null) {
                if (bundle != null) {
                    hashSet = d.a.q0.a.v2.z0.a.a(bundle.getStringArray("key_exclude_ids"));
                    z = bundle.getBoolean("key_force_clean");
                    i2 = bundle.getInt("key_clean_scenes_type");
                } else {
                    hashSet = null;
                    i2 = 0;
                    z = false;
                }
                d d2 = f.c().d();
                d.a.q0.a.n0.l.c l = d.a.q0.a.n0.l.c.l();
                l.i(i2);
                d2.t(hashSet, z, l.k());
                return null;
            }
            return (Bundle) invokeL.objValue;
        }
    }

    /* renamed from: d.a.q0.a.n0.d$d  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0878d extends d.a.q0.a.n0.b {
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(122476075, "Ld/a/q0/a/n0/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(122476075, "Ld/a/q0/a/n0/d;");
                return;
            }
        }
        m = k.f49133a;
    }

    public d(InterfaceC0878d interfaceC0878d) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {interfaceC0878d};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f49512f = ProcessUtils.getCurProcessName();
        this.f49511e = interfaceC0878d;
        ExecutorUtilsExt.postOnElastic(new a(this), "addLoginStatusChangedListener", 2);
        this.j = new AtomicInteger(0);
        this.k = new CopyOnWriteArrayList<>();
        this.f49515i = d.a.q0.a.c1.b.m();
        this.f49513g = new g();
        l lVar = this.f49515i;
        if (lVar != null) {
            this.f49514h = lVar.b();
        }
        this.l = new d.a.q0.a.n0.h.e();
        if (m) {
            Log.i("SwanAppPurger", "create : " + toString());
        }
    }

    @Override // d.a.q0.a.m.c
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            String h2 = d.a.q0.a.c1.a.a0().h(this.f49511e.a());
            if (m) {
                Log.i("SwanAppPurger", "onLoginStatusChanged : " + toString());
                Log.i("SwanAppPurger", "onLoginStatusChanged : uid(" + h2 + ")  -> " + z);
            }
            if (z) {
                q();
            } else {
                j();
            }
        }
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.k.add(str);
    }

    public final Set<String> c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            HashSet hashSet = new HashSet();
            LinkedHashSet<d.a.q0.a.v1.c.f.c> q = d.a.q0.a.v1.c.f.e.k().q();
            if (q.size() < 1) {
                return hashSet;
            }
            Iterator<d.a.q0.a.v1.c.f.c> it = q.iterator();
            while (it.hasNext()) {
                d.a.q0.a.v1.c.f.c next = it.next();
                if (next.H() && (next.C() || next.E())) {
                    hashSet.add(next.getAppId());
                    if (m) {
                        Log.i("SwanAppPurger", "sent msg(" + i2 + ") to active swan(" + next.getAppId() + SmallTailInfo.EMOTION_SUFFIX);
                    }
                    d.a.q0.a.v1.c.a e2 = d.a.q0.a.v1.c.a.e();
                    d.a.q0.a.v1.c.c cVar = new d.a.q0.a.v1.c.c(i2);
                    cVar.b(next.f51259f);
                    e2.h(cVar);
                }
            }
            return hashSet;
        }
        return (Set) invokeI.objValue;
    }

    public final void d(String str, b.C0882b c0882b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, c0882b) == null) {
            d.a.q0.a.n0.l.c.m(c0882b).b(str);
            this.f49513g.a(str);
            d.a.q0.a.n0.c cVar = this.f49514h;
            if (cVar != null) {
                cVar.a(str);
            }
            d.a.q0.a.h0.m.p.a.n(str);
        }
    }

    public void e(@Nullable String str, boolean z, b.C0882b c0882b) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, Boolean.valueOf(z), c0882b}) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        f(arrayList, z, c0882b);
    }

    public void f(@Nullable List<String> list, boolean z, b.C0882b c0882b) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{list, Boolean.valueOf(z), c0882b}) == null) || list == null || list.isEmpty()) {
            return;
        }
        g(list, true, z, c0882b);
    }

    public void g(@Nullable List<String> list, boolean z, boolean z2, b.C0882b c0882b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{list, Boolean.valueOf(z), Boolean.valueOf(z2), c0882b}) == null) {
            if (!ProcessUtils.isMainProcess()) {
                if (m) {
                    Log.w("SwanAppPurger", "非主进程调用，不执行操作");
                    return;
                }
                return;
            }
            d.a.q0.a.e0.d.i("SwanAppPurger", "deleteSwanApp", new Exception("deleteSwanApp"));
            if (z2) {
                i(list);
            }
            if (list == null || list.isEmpty()) {
                return;
            }
            o(list);
            ExecutorUtilsExt.postOnSerial(new b(this, list, z, c0882b), "deleteSwanApp");
        }
    }

    @WorkerThread
    public void h(@Nullable List<String> list, boolean z, b.C0882b c0882b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{list, Boolean.valueOf(z), c0882b}) == null) {
            if (list == null) {
                if (m) {
                    Log.d("SwanAppPurger", "deleteSwanAppAndResetAccreditSync empty");
                    return;
                }
                return;
            }
            this.j.incrementAndGet();
            if (z) {
                d.a.q0.a.e0.d.h("SwanAppPurger", "删除小程序==>开始重置小程序授权");
                this.f49513g.g(list);
                int size = list.size();
                String[] strArr = new String[size];
                for (int i2 = 0; i2 < size; i2++) {
                    strArr[i2] = d.a.q0.a.v.a.a(list.get(i2));
                }
                d.a.q0.a.j0.d.a.b(strArr);
            }
            d.a.q0.a.e0.d.h("SwanAppPurger", "删除小程序==>清除小程序数据、杀进程");
            this.f49513g.e(list);
            for (String str : list) {
                if (this.k.contains(str) || TextUtils.isEmpty(str)) {
                    d.a.q0.a.e0.d.h("SwanAppPurger", "删除小程序==>删除忽略: " + str);
                } else {
                    if (m) {
                        Log.d("SwanAppPurger", "删除小程序==>删除小程序相关（小程序包、小程序分包）的APS记录: " + str);
                    }
                    d.a.q0.a.e0.d.h("SwanAppPurger", "删除小程序==>删除小程序文件: " + str);
                    p(str, c0882b);
                }
            }
            if (this.j.decrementAndGet() <= 0) {
                this.j.set(0);
                this.k.clear();
                d.a.q0.a.n0.h.b.a();
            }
            d.a.q0.a.n0.l.c.m(c0882b).j();
        }
    }

    public final void i(@Nullable List<String> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) || list == null || list.isEmpty()) {
            return;
        }
        List<SwanFavorItemData> i2 = SwanFavorDataManager.h().i();
        HashMap hashMap = new HashMap();
        for (SwanFavorItemData swanFavorItemData : i2) {
            hashMap.put(swanFavorItemData.getAppKey(), swanFavorItemData);
        }
        Set<String> h2 = d.a.q0.a.j0.c.b.h(AppRuntime.getAppContext().getContentResolver());
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String next = it.next();
            boolean contains = h2.contains(next);
            boolean containsKey = hashMap.containsKey(next);
            if (!contains && !containsKey) {
                if (k.f49133a) {
                    Log.d("SwanAppPurger", "清理过滤-不过滤： " + next);
                }
            } else {
                if (k.f49133a) {
                    Log.d("SwanAppPurger", "清理过滤-过滤此App：" + next + "； 历史：" + contains + "； 我的小程序：" + containsKey);
                }
                it.remove();
            }
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            l(k());
        }
    }

    public final Set<String> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? c(100) : (Set) invokeV.objValue;
    }

    public final void l(Set<String> set) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, set) == null) {
            d.a.q0.a.k2.h.d.j().g("aiapp_", set, true);
            String w = d.a.q0.a.k2.b.w();
            if (!TextUtils.isEmpty(w)) {
                d.a.q0.t.d.j(w);
            }
            String y = d.a.q0.a.k2.b.y();
            if (!TextUtils.isEmpty(y)) {
                d.a.q0.t.d.j(y);
            }
            String n = d.a.q0.a.a1.e.n();
            if (!TextUtils.isEmpty(n)) {
                d.a.q0.t.d.j(n);
            }
            l lVar = this.f49515i;
            if (lVar != null) {
                lVar.g();
                this.f49515i.c();
            }
        }
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.j.get() > 0 : invokeV.booleanValue;
    }

    public boolean n(Map<String, PMSAppInfo> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, map)) == null) {
            if (map == null || map.size() <= 0) {
                return false;
            }
            return (map.size() == 1 && map.containsKey("sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u")) ? false : true;
        }
        return invokeL.booleanValue;
    }

    public void o(@Nullable List<String> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, list) == null) || list == null || list.size() == 0) {
            return;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            d.a.q0.a.k2.g.b a2 = h.a();
            a2.putInt("bookshelf_insert" + it.next(), 0);
        }
    }

    public final void p(String str, b.C0882b c0882b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, str, c0882b) == null) {
            if (d.a.q0.a.n0.h.c.a() && d.a.q0.a.a1.e.f().contains(str)) {
                d.a.q0.a.e0.d.h("SwanAppPurger", "删除小程序==>小程序现在存活: " + str);
            } else if (d.a.q0.a.n0.h.b.c(str)) {
                d.a.q0.a.e0.d.h("SwanAppPurger", "删除小程序==>小程序现正在下载中: " + str);
            } else {
                d(str, c0882b);
                d.a.q0.a.e0.d.h("SwanAppPurger", "删除小程序==>删除小程序数据库数据: " + str);
                this.f49513g.f(str);
                d.a.q0.a.e0.d.h("SwanAppPurger", "删除小程序==>清空小程序分包记录: " + str);
                this.f49513g.d(str);
            }
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            s(r());
        }
    }

    public final Set<String> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? c(103) : (Set) invokeV.objValue;
    }

    public final void s(Set<String> set) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, set) == null) {
            d.a.q0.a.k2.h.d.j().g("aiapp_setting_", set, true);
        }
    }

    public void t(@Nullable Set<String> set, boolean z, b.C0882b c0882b) {
        d.a.q0.a.n0.h.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{set, Boolean.valueOf(z), c0882b}) == null) || (eVar = this.l) == null) {
            return;
        }
        eVar.i(set, z, c0882b);
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return "Process<" + this.f49512f + "> " + super.toString();
        }
        return (String) invokeV.objValue;
    }

    public void u(@Nullable Set<String> set, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{set, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            if (ProcessUtils.isMainProcess()) {
                d.a.q0.a.n0.l.c l = d.a.q0.a.n0.l.c.l();
                l.i(i2);
                t(set, z, l.k());
                return;
            }
            Bundle bundle = new Bundle();
            if (set != null && set.size() > 0) {
                bundle.putStringArray("key_exclude_ids", (String[]) set.toArray(new String[0]));
            }
            bundle.putBoolean("key_force_clean", z);
            bundle.putInt("key_clean_scenes_type", i2);
            d.a.q0.a.v1.b.d.b(c.class, bundle);
        }
    }
}
