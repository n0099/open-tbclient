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
public final class m62 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static LinkedList<e> b;
    public static Map<String, nm1> c;
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
                if (m62.a) {
                    Log.d("SwanAppSlavePool", "getPreloadSlaveManager prepare next start.");
                }
                m62.n(ul2.U().getActivity());
                if (m62.a) {
                    Log.d("SwanAppSlavePool", "getPreloadSlaveManager prepare next end.");
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b extends vy1 {
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

        @Override // com.repackage.vy1
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (m62.a) {
                    Log.d("SwanAppSlavePool", "onPageFinished slaveId: " + this.a.a.b() + " url: " + str);
                }
                if (!gw2.D() || !b72.U().q0()) {
                    m62.l(this.a, this.b);
                } else {
                    m62.m(this.a, this.b);
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
                if (m62.a) {
                    Log.d("SwanAppSlavePool", "slave onReceiveValue: " + str);
                }
                m62.l(this.a, this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class d extends vy1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nm1 a;

        public d(nm1 nm1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nm1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nm1Var;
        }

        @Override // com.repackage.vy1
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
        public nm1 a;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755547416, "Lcom/repackage/m62;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755547416, "Lcom/repackage/m62;");
                return;
            }
        }
        a = rg1.a;
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
            if (!r62.d()) {
                i = 0;
            }
            e eVar = new e();
            eVar.d = System.currentTimeMillis();
            eVar.b = false;
            eVar.a = b72.U().K0(context, i, new b(eVar, z));
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
            if (!r62.d()) {
                i = 0;
            }
            e eVar = null;
            Iterator<e> it = b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                e next = it.next();
                if (next.a.S() == i) {
                    eVar = next;
                    break;
                }
            }
            if (eVar == null) {
                return e(k(activity), i, false);
            }
            b.remove(eVar);
            nm1 nm1Var = eVar.a;
            if (nm1Var != null && activity != null) {
                nm1Var.e(activity);
            }
            if (a) {
                Log.d("SwanAppSlavePool", "getPreloadSlaveManager prepare next.");
            }
            if (!z) {
                int g = iu2.g();
                if (g <= 0) {
                    g = 600;
                }
                be3.b0(new a(), g);
            }
            return eVar;
        }
        return (e) invokeCommon.objValue;
    }

    public static nm1 h(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            nm1 nm1Var = c.get(str != null ? str : "");
            if (nm1Var != null) {
                c.remove(str);
            }
            return nm1Var;
        }
        return (nm1) invokeL.objValue;
    }

    public static boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            h03 b0 = h03.b0();
            if (b0 == null || b0.Q() == null) {
                return false;
            }
            return b0.Q().u;
        }
        return invokeV.booleanValue;
    }

    public static boolean j(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65546, null, i)) == null) {
            for (int i2 = 0; i2 < b.size(); i2++) {
                if (b.get(i2).a.S() == i) {
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
                return oj2.c();
            }
            return ((context instanceof Activity) && ((Activity) context).isFinishing()) ? oj2.c() : context;
        }
        return (Context) invokeL.objValue;
    }

    public static void l(@NonNull e eVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65548, null, eVar, z) == null) {
            if (z && eVar.f) {
                s62.j(eVar.a);
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
            sx1.k().o(eVar.a, new c(eVar, z));
        }
    }

    public static void n(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, context) == null) {
            if (!j(0)) {
                b.add(e(k(context), 0, true));
            }
            if (!j(1) && r62.d() && i()) {
                b.add(e(k(context), 1, true));
            }
        }
    }

    public static void o(@NonNull String str, nm1 nm1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65551, null, str, nm1Var) == null) {
            Map<String, nm1> map = c;
            if (str == null) {
                str = "";
            }
            map.put(str, nm1Var);
        }
    }

    public static void p(@NonNull nm1<?> nm1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, nm1Var) == null) {
            if (nm1Var.S() == 1 && !i()) {
                if (b72.U().l0()) {
                    nm1Var.destroy();
                    return;
                } else {
                    b72.U().K(new d(nm1Var));
                    return;
                }
            }
            e eVar = new e();
            eVar.d = System.currentTimeMillis();
            eVar.b = false;
            eVar.a = nm1Var;
            b.add(eVar);
            if (gw2.D() && b72.U().q0()) {
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
