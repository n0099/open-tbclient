package d.a.n0.a.u.e.o;

import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f47801g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile k f47802h;

    /* renamed from: i  reason: collision with root package name */
    public static d.a.n0.a.y0.k.g.a f47803i;
    public static boolean j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, Boolean> f47804a;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, d.a.n0.a.y0.k.g.a> f47805b;

    /* renamed from: c  reason: collision with root package name */
    public int f47806c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.n0.a.v2.e1.b<Integer> f47807d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.n0.a.g1.h f47808e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.n0.a.t0.a f47809f;

    /* loaded from: classes7.dex */
    public class a extends d.a.n0.a.t0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ k f47810a;

        public a(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47810a = kVar;
        }

        @Override // d.a.n0.a.t0.a, d.a.n0.a.t0.b
        public boolean onKeyDown(int i2, KeyEvent keyEvent) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i2, keyEvent)) == null) {
                if (i2 == 4 && this.f47810a.f47807d != null && this.f47810a.g()) {
                    this.f47810a.f47807d.onCallback(1);
                    return true;
                }
                return false;
            }
            return invokeIL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1231350262, "Ld/a/n0/a/u/e/o/k;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1231350262, "Ld/a/n0/a/u/e/o/k;");
                return;
            }
        }
        f47801g = d.a.n0.a.k.f45831a;
    }

    public k() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f47804a = new HashMap<>();
        this.f47805b = new HashMap<>();
        this.f47806c = -1;
        this.f47807d = null;
        this.f47808e = null;
        this.f47809f = new a(this);
    }

    public static k e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f47802h == null) {
                synchronized (k.class) {
                    if (f47802h == null) {
                        f47802h = new k();
                    }
                }
            }
            return f47802h;
        }
        return (k) invokeV.objValue;
    }

    public void b(d.a.n0.a.y0.k.g.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null || TextUtils.isEmpty(aVar.c())) {
            return;
        }
        this.f47805b.put(aVar.c(), aVar);
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            d.a.n0.a.e0.d.g("SwanInlinePlayerManager", "clearCacheVideo: ");
            f47803i = null;
            j = false;
        }
    }

    public d.a.n0.a.y0.k.g.a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (f47801g && f47803i != null) {
                Log.i("SwanInlinePlayerManager", "getCacheVideoPlayer: " + f47803i.c());
            }
            return f47803i;
        }
        return (d.a.n0.a.y0.k.g.a) invokeV.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            boolean z = true;
            z = (!(d() != null && d().f0() == null) || j) ? false : false;
            d.a.n0.a.e0.d.g("SwanInlinePlayerManager", "hasCacheVideo: " + z);
            return z;
        }
        return invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int i2 = this.f47806c;
            return i2 == 90 || i2 == -90;
        }
        return invokeV.booleanValue;
    }

    public void h() {
        d.a.n0.a.v2.e1.b<Integer> bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && g() && (bVar = this.f47807d) != null) {
            bVar.onCallback(0);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (g()) {
                if (f47801g) {
                    Log.i("SwanInlinePlayerManager", "onForegroundChange: full screen ");
                }
                d.a.n0.a.z1.b.a.f();
                d.a.n0.a.z1.b.a.k(true);
            } else if (f47801g) {
                Log.i("SwanInlinePlayerManager", "onForegroundChange: vertical screen. ");
            }
        }
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                if (f47801g) {
                    Log.i("SwanInlinePlayerManager", "pauseOtherPlayers: empty player id ");
                    return;
                }
                return;
            }
            HashMap<String, d.a.n0.a.y0.k.g.a> hashMap = this.f47805b;
            if (hashMap == null || hashMap.size() <= 0) {
                return;
            }
            for (String str2 : this.f47805b.keySet()) {
                if (str2.equals(str)) {
                    if (f47801g) {
                        Log.i("SwanInlinePlayerManager", "pauseOtherPlayers: skip itself." + str);
                    }
                } else {
                    d.a.n0.a.y0.k.g.a aVar = this.f47805b.get(str2);
                    if (aVar != null) {
                        aVar.pause();
                        aVar.Q().c(aVar.c());
                    }
                }
            }
        }
    }

    public void k(String str, boolean z) {
        HashMap<String, Boolean> hashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, z) == null) || (hashMap = this.f47804a) == null) {
            return;
        }
        hashMap.put(str, Boolean.valueOf(z));
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            d.a.n0.a.g1.f.V().getActivity().registerCallback(this.f47809f);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            synchronized (this) {
                w();
                v();
                this.f47804a = null;
                this.f47805b.clear();
                this.f47807d = null;
            }
            f47802h = null;
        }
    }

    public void n(d.a.n0.a.y0.k.g.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, aVar) == null) || aVar == null) {
            return;
        }
        if (d() == null) {
            j = false;
        } else if (TextUtils.equals(d().c(), aVar.c())) {
            d.a.n0.a.e0.d.g("SwanInlinePlayerManager", "releaseCacheVideo: clear cache video " + aVar.c());
            f47803i = null;
            j = false;
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f47807d = null;
        }
    }

    public void p(String str) {
        HashMap<String, Boolean> hashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, str) == null) || (hashMap = this.f47804a) == null) {
            return;
        }
        hashMap.remove(str);
        int size = this.f47804a.keySet().size();
        if (f47801g) {
            Log.i("SwanInlinePlayerManager", "removePlayerState: last player count " + size);
        }
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.f47805b.remove(str);
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            d.a.n0.a.e0.d.g("SwanInlinePlayerManager", "setCacheInUsed: true");
            j = true;
        }
    }

    public void s(d.a.n0.a.y0.k.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, aVar) == null) {
            if (f47801g) {
                Log.i("SwanInlinePlayerManager", "setCacheVideo: " + aVar.toString());
            }
            f47803i = aVar;
        }
    }

    public void t(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.f47806c = i2;
        }
    }

    public void u(d.a.n0.a.v2.e1.b<Integer> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bVar) == null) {
            this.f47807d = bVar;
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            SwanAppActivity activity = d.a.n0.a.g1.f.V().getActivity();
            d.a.n0.a.t0.a aVar = this.f47809f;
            if (aVar == null || activity == null) {
                return;
            }
            activity.unregisterCallback(aVar);
        }
    }

    public void w() {
        d.a.n0.a.g1.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (hVar = this.f47808e) == null) {
            return;
        }
        d.a.n0.a.g1.i.f(hVar);
        this.f47808e = null;
    }
}
