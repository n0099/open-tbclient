package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public final class w02 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static b b;
    public static LinkedHashMap<String, String> c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements nf3<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nf3 a;

        public a(nf3 nf3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nf3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nf3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nf3
        /* renamed from: a */
        public void onCallback(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (w02.a) {
                    Log.d("SwanAppLaunchTips", ">> default launchInfo: " + str);
                }
                this.a.onCallback(w02.b.d(str));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755255272, "Lcom/repackage/w02;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755255272, "Lcom/repackage/w02;");
                return;
            }
        }
        a = eh1.a;
    }

    public static void c() {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, null) == null) || (bVar = b) == null) {
            return;
        }
        bVar.c();
    }

    public static synchronized void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            synchronized (w02.class) {
                if (b != null) {
                    u02.e();
                    b.i();
                }
                b = new b(null);
                if (c != null) {
                    for (Map.Entry<String, String> entry : c.entrySet()) {
                        b.g(entry.getKey(), entry.getValue());
                    }
                    b.l(true);
                    c = null;
                }
                b.h();
            }
        }
    }

    public static void e(nf3<String> nf3Var) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, nf3Var) == null) || nf3Var == null || (bVar = b) == null) {
            return;
        }
        if (!TextUtils.isEmpty(bVar.a)) {
            if (a) {
                Log.d("SwanAppLaunchTips", ">> exception launchInfo: " + b.a);
            }
            b bVar2 = b;
            nf3Var.onCallback(bVar2.d(bVar2.a));
            return;
        }
        b.e(new a(nf3Var));
    }

    public static void f(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65542, null, z) == null) || t03.J().l() == 1) {
            return;
        }
        d();
        l();
        j();
        k();
    }

    public static void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, str) == null) {
            h(str, id3.g(System.currentTimeMillis(), "【HH:mm:ss】"));
        }
    }

    public static void h(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, str, str2) == null) {
            b bVar = b;
            if (bVar != null) {
                bVar.g(str, str2);
                return;
            }
            if (c == null) {
                c = new LinkedHashMap<>();
            }
            c.put(str, str2);
        }
    }

    public static void i(int i) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65545, null, i) == null) || (bVar = b) == null) {
            return;
        }
        bVar.k(i);
    }

    public static void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            z02.d().g();
            z02.d().i();
        }
    }

    public static void k() {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65547, null) == null) || (bVar = b) == null) {
            return;
        }
        bVar.m();
    }

    public static void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, null) == null) {
            l12.d().g();
            l12.d().i();
        }
    }

    /* loaded from: classes7.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public boolean b;
        public int c;
        public long d;
        public final r12 e;

        /* loaded from: classes7.dex */
        public class a extends rd2 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SwanAppActivity a;
            public final /* synthetic */ b b;

            public a(b bVar, SwanAppActivity swanAppActivity) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, swanAppActivity};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = bVar;
                this.a = swanAppActivity;
            }

            @Override // com.repackage.rd2, com.repackage.sd2
            public void f() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.j()) {
                    this.a.unregisterCallback(this);
                }
            }
        }

        /* renamed from: com.repackage.w02$b$b  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0540b implements nf3<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ nf3 a;

            public C0540b(b bVar, nf3 nf3Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, nf3Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = nf3Var;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.repackage.nf3
            /* renamed from: a */
            public void onCallback(String str) {
                nf3 nf3Var;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (nf3Var = this.a) == null) {
                    return;
                }
                nf3Var.onCallback(str);
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(49137626, "Lcom/repackage/w02$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(49137626, "Lcom/repackage/w02$b;");
                    return;
                }
            }
            bk2.g0().n();
        }

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = "";
            this.b = true;
            System.currentTimeMillis();
            this.c = 0;
            this.d = f();
            this.e = new r12();
        }

        public void c() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.c == 1) {
                if (!TextUtils.equals(hm2.U().T(), t02.a())) {
                    if (w02.a) {
                        Log.d("SwanAppLaunchTips", "current page is not skeleton error first page");
                        Log.d("SwanAppLaunchTips", "current page: " + hm2.U().T());
                        String a2 = t02.a();
                        StringBuilder sb = new StringBuilder();
                        sb.append("skeleton error first page: ");
                        if (a2 == null) {
                            a2 = "";
                        }
                        sb.append(a2);
                        Log.d("SwanAppLaunchTips", sb.toString());
                        return;
                    }
                    return;
                }
                String C = hm2.U().C();
                if (TextUtils.isEmpty(C)) {
                    return;
                }
                hm2.U().m(C, new va2("check-skeleton-status"));
            }
        }

        public String d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                StringBuilder sb = new StringBuilder(bk2.c().getText(R.string.obfuscated_res_0x7f0f1303));
                sb.append(str);
                String e = r02.e();
                if (!TextUtils.isEmpty(e)) {
                    sb.append(e);
                }
                return sb.toString();
            }
            return (String) invokeL.objValue;
        }

        public void e(@NonNull nf3<String> nf3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, nf3Var) == null) {
                this.e.e(new C0540b(this, nf3Var));
            }
        }

        public final long f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                u03 a0 = u03.a0();
                if (a0 != null) {
                    return a0.V().l("launch_time", 0L);
                }
                return 0L;
            }
            return invokeV.longValue;
        }

        public void g(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
                String str3 = "\n" + str2 + str;
                if (!TextUtils.isEmpty(this.a)) {
                    str3 = this.a + str3;
                }
                this.a = str3;
                ux1.k("SwanAppLaunchTips", str2 + str);
            }
        }

        public void h() {
            SwanAppActivity activity;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (activity = hm2.U().getActivity()) == null || activity.isFinishing()) {
                return;
            }
            activity.registerCallback(new a(this, activity));
        }

        public void i() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                this.e.i();
            }
        }

        public final boolean j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                String f = !TextUtils.isEmpty(this.a) ? this.a : this.e.f();
                if (!this.b || TextUtils.isEmpty(f)) {
                    return false;
                }
                r02.h(this.d, f);
                this.b = false;
                return true;
            }
            return invokeV.booleanValue;
        }

        public void k(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
                this.c = i;
            }
        }

        public void l(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
                this.b = z;
            }
        }

        public void m() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
                this.e.h();
            }
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }
}
