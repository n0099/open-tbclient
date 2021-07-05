package d.a.q0.a.u.e.o;

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
/* loaded from: classes8.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f51103g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile k f51104h;

    /* renamed from: i  reason: collision with root package name */
    public static d.a.q0.a.y0.k.g.a f51105i;
    public static boolean j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, Boolean> f51106a;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, d.a.q0.a.y0.k.g.a> f51107b;

    /* renamed from: c  reason: collision with root package name */
    public int f51108c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.q0.a.v2.e1.b<Integer> f51109d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.q0.a.g1.h f51110e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.q0.a.t0.a f51111f;

    /* loaded from: classes8.dex */
    public class a extends d.a.q0.a.t0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ k f51112a;

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
            this.f51112a = kVar;
        }

        @Override // d.a.q0.a.t0.a, d.a.q0.a.t0.b
        public boolean onKeyDown(int i2, KeyEvent keyEvent) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i2, keyEvent)) == null) {
                if (i2 == 4 && this.f51112a.f51109d != null && this.f51112a.g()) {
                    this.f51112a.f51109d.onCallback(1);
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2111559283, "Ld/a/q0/a/u/e/o/k;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2111559283, "Ld/a/q0/a/u/e/o/k;");
                return;
            }
        }
        f51103g = d.a.q0.a.k.f49133a;
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
        this.f51106a = new HashMap<>();
        this.f51107b = new HashMap<>();
        this.f51108c = -1;
        this.f51109d = null;
        this.f51110e = null;
        this.f51111f = new a(this);
    }

    public static k e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f51104h == null) {
                synchronized (k.class) {
                    if (f51104h == null) {
                        f51104h = new k();
                    }
                }
            }
            return f51104h;
        }
        return (k) invokeV.objValue;
    }

    public void b(d.a.q0.a.y0.k.g.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null || TextUtils.isEmpty(aVar.c())) {
            return;
        }
        this.f51107b.put(aVar.c(), aVar);
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            d.a.q0.a.e0.d.g("SwanInlinePlayerManager", "clearCacheVideo: ");
            f51105i = null;
            j = false;
        }
    }

    public d.a.q0.a.y0.k.g.a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (f51103g && f51105i != null) {
                Log.i("SwanInlinePlayerManager", "getCacheVideoPlayer: " + f51105i.c());
            }
            return f51105i;
        }
        return (d.a.q0.a.y0.k.g.a) invokeV.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            boolean z = true;
            z = (!(d() != null && d().f0() == null) || j) ? false : false;
            d.a.q0.a.e0.d.g("SwanInlinePlayerManager", "hasCacheVideo: " + z);
            return z;
        }
        return invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int i2 = this.f51108c;
            return i2 == 90 || i2 == -90;
        }
        return invokeV.booleanValue;
    }

    public void h() {
        d.a.q0.a.v2.e1.b<Integer> bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && g() && (bVar = this.f51109d) != null) {
            bVar.onCallback(0);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (g()) {
                if (f51103g) {
                    Log.i("SwanInlinePlayerManager", "onForegroundChange: full screen ");
                }
                d.a.q0.a.z1.b.a.f();
                d.a.q0.a.z1.b.a.k(true);
            } else if (f51103g) {
                Log.i("SwanInlinePlayerManager", "onForegroundChange: vertical screen. ");
            }
        }
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                if (f51103g) {
                    Log.i("SwanInlinePlayerManager", "pauseOtherPlayers: empty player id ");
                    return;
                }
                return;
            }
            HashMap<String, d.a.q0.a.y0.k.g.a> hashMap = this.f51107b;
            if (hashMap == null || hashMap.size() <= 0) {
                return;
            }
            for (String str2 : this.f51107b.keySet()) {
                if (str2.equals(str)) {
                    if (f51103g) {
                        Log.i("SwanInlinePlayerManager", "pauseOtherPlayers: skip itself." + str);
                    }
                } else {
                    d.a.q0.a.y0.k.g.a aVar = this.f51107b.get(str2);
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
        if (!(interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, z) == null) || (hashMap = this.f51106a) == null) {
            return;
        }
        hashMap.put(str, Boolean.valueOf(z));
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            d.a.q0.a.g1.f.V().getActivity().registerCallback(this.f51111f);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            synchronized (this) {
                w();
                v();
                this.f51106a = null;
                this.f51107b.clear();
                this.f51109d = null;
            }
            f51104h = null;
        }
    }

    public void n(d.a.q0.a.y0.k.g.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, aVar) == null) || aVar == null) {
            return;
        }
        if (d() == null) {
            j = false;
        } else if (TextUtils.equals(d().c(), aVar.c())) {
            d.a.q0.a.e0.d.g("SwanInlinePlayerManager", "releaseCacheVideo: clear cache video " + aVar.c());
            f51105i = null;
            j = false;
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f51109d = null;
        }
    }

    public void p(String str) {
        HashMap<String, Boolean> hashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, str) == null) || (hashMap = this.f51106a) == null) {
            return;
        }
        hashMap.remove(str);
        int size = this.f51106a.keySet().size();
        if (f51103g) {
            Log.i("SwanInlinePlayerManager", "removePlayerState: last player count " + size);
        }
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.f51107b.remove(str);
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            d.a.q0.a.e0.d.g("SwanInlinePlayerManager", "setCacheInUsed: true");
            j = true;
        }
    }

    public void s(d.a.q0.a.y0.k.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, aVar) == null) {
            if (f51103g) {
                Log.i("SwanInlinePlayerManager", "setCacheVideo: " + aVar.toString());
            }
            f51105i = aVar;
        }
    }

    public void t(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.f51108c = i2;
        }
    }

    public void u(d.a.q0.a.v2.e1.b<Integer> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bVar) == null) {
            this.f51109d = bVar;
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            SwanAppActivity activity = d.a.q0.a.g1.f.V().getActivity();
            d.a.q0.a.t0.a aVar = this.f51111f;
            if (aVar == null || activity == null) {
                return;
            }
            activity.unregisterCallback(aVar);
        }
    }

    public void w() {
        d.a.q0.a.g1.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (hVar = this.f51110e) == null) {
            return;
        }
        d.a.q0.a.g1.i.f(hVar);
        this.f51110e = null;
    }
}
