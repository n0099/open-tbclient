package com.repackage;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes6.dex */
public final class m52 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static LinkedList<e> b;
    public static Map<String, nl1> c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (m52.a) {
                    Log.d("SwanAppSlavePool", "getPreloadSlaveManager prepare next start.");
                }
                m52.n(uk2.U().getActivity());
                if (m52.a) {
                    Log.d("SwanAppSlavePool", "getPreloadSlaveManager prepare next end.");
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b extends vx1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;
        public final /* synthetic */ boolean b;

        public b(e eVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
            this.b = z;
        }

        @Override // com.repackage.vx1
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (m52.a) {
                    Log.d("SwanAppSlavePool", "onPageFinished slaveId: " + this.a.a.c() + " url: " + str);
                }
                if (!gv2.D() || !b62.U().q0()) {
                    m52.l(this.a, this.b);
                } else {
                    m52.m(this.a, this.b);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements ValueCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;
        public final /* synthetic */ boolean b;

        public c(e eVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
            this.b = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (m52.a) {
                    Log.d("SwanAppSlavePool", "slave onReceiveValue: " + str);
                }
                m52.l(this.a, this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class d extends vx1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nl1 a;

        public d(nl1 nl1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nl1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nl1Var;
        }

        @Override // com.repackage.vx1
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.a.destroy();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public nl1 a;
        public boolean b;
        public final ArrayList<f> c;
        public long d;
        public long e;
        public boolean f;

        public e() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = new ArrayList<>();
            this.f = true;
        }
    }

    /* loaded from: classes6.dex */
    public interface f {
        void onReady();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755548377, "Lcom/repackage/m52;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755548377, "Lcom/repackage/m52;");
                return;
            }
        }
        a = rf1.a;
        b = new LinkedList<>();
        c = new TreeMap();
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            b.clear();
            c.clear();
        }
    }

    public static e e(Context context, int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{context, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            if (!r52.d()) {
                i = 0;
            }
            e eVar = new e();
            eVar.d = System.currentTimeMillis();
            eVar.b = false;
            eVar.a = b62.U().K0(context, i, new b(eVar, z));
            return eVar;
        }
        return (e) invokeCommon.objValue;
    }

    public static e f(@Nullable Activity activity, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, activity, i)) == null) {
            if (a) {
                Log.d("SwanAppSlavePool", "getPreloadSlaveManager: " + i);
                Log.d("SwanAppSlavePool", Log.getStackTraceString(new Exception()));
            }
            return g(activity, i, false);
        }
        return (e) invokeLI.objValue;
    }

    public static e g(@Nullable Activity activity, int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{activity, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            if (a) {
                Log.d("SwanAppSlavePool", "getPreloadSlaveManager");
            }
            if (!r52.d()) {
                i = 0;
            }
            e eVar = null;
            Iterator<e> it = b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                e next = it.next();
                if (next.a.T() == i) {
                    eVar = next;
                    break;
                }
            }
            if (eVar == null) {
                return e(k(activity), i, false);
            }
            b.remove(eVar);
            nl1 nl1Var = eVar.a;
            if (nl1Var != null && activity != null) {
                nl1Var.f(activity);
            }
            if (a) {
                Log.d("SwanAppSlavePool", "getPreloadSlaveManager prepare next.");
            }
            if (!z) {
                int g = it2.g();
                if (g <= 0) {
                    g = 600;
                }
                bd3.b0(new a(), g);
            }
            return eVar;
        }
        return (e) invokeCommon.objValue;
    }

    public static nl1 h(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            nl1 nl1Var = c.get(str != null ? str : "");
            if (nl1Var != null) {
                c.remove(str);
            }
            return nl1Var;
        }
        return (nl1) invokeL.objValue;
    }

    public static boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            hz2 a0 = hz2.a0();
            if (a0 == null || a0.P() == null) {
                return false;
            }
            return a0.P().u;
        }
        return invokeV.booleanValue;
    }

    public static boolean j(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65546, null, i)) == null) {
            for (int i2 = 0; i2 < b.size(); i2++) {
                if (b.get(i2).a.T() == i) {
                    return true;
                }
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public static Context k(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
            if (context == null) {
                return oi2.c();
            }
            return ((context instanceof Activity) && ((Activity) context).isFinishing()) ? oi2.c() : context;
        }
        return (Context) invokeL.objValue;
    }

    public static void l(@NonNull e eVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65548, null, eVar, z) == null) {
            if (z && eVar.f) {
                s52.j(eVar.a);
            }
            eVar.e = System.currentTimeMillis();
            eVar.b = true;
            if (eVar.c.isEmpty()) {
                return;
            }
            Iterator<f> it = eVar.c.iterator();
            while (it.hasNext()) {
                f next = it.next();
                if (next != null) {
                    next.onReady();
                }
            }
            eVar.c.clear();
        }
    }

    public static void m(@NonNull e eVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65549, null, eVar, z) == null) {
            sw1.k().o(eVar.a, new c(eVar, z));
        }
    }

    public static void n(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, context) == null) {
            if (!j(0)) {
                b.add(e(k(context), 0, true));
            }
            if (!j(1) && r52.d() && i()) {
                b.add(e(k(context), 1, true));
            }
        }
    }

    public static void o(@NonNull String str, nl1 nl1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65551, null, str, nl1Var) == null) {
            Map<String, nl1> map = c;
            if (str == null) {
                str = "";
            }
            map.put(str, nl1Var);
        }
    }

    public static void p(@NonNull nl1<?> nl1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, nl1Var) == null) {
            if (nl1Var.T() == 1 && !i()) {
                if (b62.U().l0()) {
                    nl1Var.destroy();
                    return;
                } else {
                    b62.U().K(new d(nl1Var));
                    return;
                }
            }
            e eVar = new e();
            eVar.d = System.currentTimeMillis();
            eVar.b = false;
            eVar.a = nl1Var;
            b.add(eVar);
            if (gv2.D() && b62.U().q0()) {
                m(eVar, true);
            } else {
                l(eVar, true);
            }
        }
    }

    public static void q(e eVar, f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65553, null, eVar, fVar) == null) || fVar == null) {
            return;
        }
        if (eVar.b) {
            fVar.onReady();
            return;
        }
        eVar.c.add(fVar);
        eVar.f = false;
    }
}
