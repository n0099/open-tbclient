package d.a.n0.a.h0.t;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.g1.f;
import d.a.n0.a.h0.u.g;
import d.a.n0.a.k;
import d.a.n0.a.v2.q0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes7.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45205a;

    /* renamed from: b  reason: collision with root package name */
    public static LinkedList<d> f45206b;

    /* renamed from: c  reason: collision with root package name */
    public static Map<String, d.a.n0.a.p.e.b> f45207c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.n0.a.h0.t.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class RunnableC0767a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public RunnableC0767a() {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (a.f45205a) {
                    Log.d("SwanAppSlavePool", "getPreloadSlaveManager prepare next start.");
                }
                a.l(f.V().getActivity());
                if (a.f45205a) {
                    Log.d("SwanAppSlavePool", "getPreloadSlaveManager prepare next end.");
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b extends d.a.n0.a.h0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f45208a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f45209b;

        public b(d dVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45208a = dVar;
            this.f45209b = z;
        }

        @Override // d.a.n0.a.h0.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (a.f45205a) {
                    Log.d("SwanAppSlavePool", "onPageFinished slaveId: " + this.f45208a.f45212a.b() + " url: " + str);
                }
                if (!d.a.n0.a.u1.a.a.C() || !g.N().g0()) {
                    a.j(this.f45208a, this.f45209b);
                } else {
                    a.k(this.f45208a, this.f45209b);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements ValueCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f45210a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f45211b;

        public c(d dVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45210a = dVar;
            this.f45211b = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (a.f45205a) {
                    Log.d("SwanAppSlavePool", "slave onReceiveValue: " + str);
                }
                a.j(this.f45210a, this.f45211b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public d.a.n0.a.p.e.b f45212a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f45213b;

        /* renamed from: c  reason: collision with root package name */
        public final ArrayList<e> f45214c;

        /* renamed from: d  reason: collision with root package name */
        public long f45215d;

        /* renamed from: e  reason: collision with root package name */
        public long f45216e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f45217f;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45214c = new ArrayList<>();
            this.f45217f = true;
        }
    }

    /* loaded from: classes7.dex */
    public interface e {
        void onReady();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(318556326, "Ld/a/n0/a/h0/t/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(318556326, "Ld/a/n0/a/h0/t/a;");
                return;
            }
        }
        f45205a = k.f45831a;
        f45206b = new LinkedList<>();
        f45207c = new TreeMap();
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            f45206b.clear();
            f45207c.clear();
        }
    }

    public static d e(Context context, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(AdIconUtil.AD_TEXT_ID, null, context, z)) == null) {
            d dVar = new d();
            dVar.f45215d = System.currentTimeMillis();
            dVar.f45213b = false;
            dVar.f45212a = g.N().y0(context, new b(dVar, z));
            return dVar;
        }
        return (d) invokeLZ.objValue;
    }

    public static d f(@Nullable Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, activity)) == null) ? g(activity, false) : (d) invokeL.objValue;
    }

    public static d g(@Nullable Activity activity, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65543, null, activity, z)) == null) {
            if (f45205a) {
                Log.d("SwanAppSlavePool", "getPreloadSlaveManager");
            }
            if (f45206b.isEmpty()) {
                return e(i(activity), false);
            }
            if (f45205a) {
                Log.d("SwanAppSlavePool", "getPreloadSlaveManager : " + f45206b.getFirst());
            }
            d removeFirst = f45206b.removeFirst();
            d.a.n0.a.p.e.b bVar = removeFirst.f45212a;
            if (bVar != null && activity != null) {
                bVar.e(activity);
            }
            if (f45205a) {
                Log.d("SwanAppSlavePool", "getPreloadSlaveManager prepare next.");
            }
            if (!z) {
                q0.Y(new RunnableC0767a(), 600L);
            }
            return removeFirst;
        }
        return (d) invokeLZ.objValue;
    }

    public static d.a.n0.a.p.e.b h(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            d.a.n0.a.p.e.b bVar = f45207c.get(str != null ? str : "");
            if (bVar != null) {
                f45207c.remove(str);
            }
            return bVar;
        }
        return (d.a.n0.a.p.e.b) invokeL.objValue;
    }

    public static Context i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            if (context == null) {
                return d.a.n0.a.c1.a.b();
            }
            return ((context instanceof Activity) && ((Activity) context).isFinishing()) ? d.a.n0.a.c1.a.b() : context;
        }
        return (Context) invokeL.objValue;
    }

    public static void j(@NonNull d dVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65546, null, dVar, z) == null) {
            if (z && dVar.f45217f) {
                d.a.n0.a.h0.t.c.a.h(dVar.f45212a);
            }
            dVar.f45216e = System.currentTimeMillis();
            dVar.f45213b = true;
            if (dVar.f45214c.isEmpty()) {
                return;
            }
            Iterator<e> it = dVar.f45214c.iterator();
            while (it.hasNext()) {
                e next = it.next();
                if (next != null) {
                    next.onReady();
                }
            }
            dVar.f45214c.clear();
        }
    }

    public static void k(@NonNull d dVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65547, null, dVar, z) == null) {
            d.a.n0.a.e0.f.d.f.k().o(dVar.f45212a, new c(dVar, z));
        }
    }

    public static void l(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, context) == null) {
            if (f45206b.size() < 2) {
                if (f45205a) {
                    Log.d("SwanAppSlavePool", "preloadSlaveManager do preload.");
                }
                f45206b.add(e(i(context), true));
            } else if (f45205a) {
                Log.e("SwanAppSlavePool", "preloadSlaveManager max size exceeded");
            }
            if (f45205a) {
                Log.d("SwanAppSlavePool", "preloadSlaveManager size: " + f45206b.size());
            }
        }
    }

    public static void m(@NonNull String str, d.a.n0.a.p.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, str, bVar) == null) {
            Map<String, d.a.n0.a.p.e.b> map = f45207c;
            if (str == null) {
                str = "";
            }
            map.put(str, bVar);
        }
    }

    public static void n(d dVar, e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65550, null, dVar, eVar) == null) || eVar == null) {
            return;
        }
        if (dVar.f45213b) {
            eVar.onReady();
            return;
        }
        dVar.f45214c.add(eVar);
        dVar.f45217f = false;
    }
}
