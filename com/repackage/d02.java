package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.support.v4.app.Fragment;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.vq2;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes5.dex */
public final class d02 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean e;
    public static final Set<String> f;
    public static final int g;
    public static final int h;
    public static final int i;
    public transient /* synthetic */ FieldHolder $fh;
    public oe4 a;
    public ArrayList<a02> b;
    public Queue<Runnable> c;
    public final List<a> d;

    /* loaded from: classes5.dex */
    public interface a {
        void a(@NonNull Fragment fragment);

        void b(@NonNull Fragment fragment);
    }

    /* loaded from: classes5.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public qe4 a;
        public String b;
        public final /* synthetic */ d02 c;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a02 a;
            public final /* synthetic */ a02 b;

            public a(b bVar, a02 a02Var, a02 a02Var2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, a02Var, a02Var2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = a02Var;
                this.b = a02Var2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    a02 a02Var = this.a;
                    if (a02Var != null && a02Var.Q()) {
                        this.a.l1(false);
                    }
                    a02 a02Var2 = this.a;
                    if (a02Var2 instanceof c02) {
                        ((c02) a02Var2).Y3();
                    }
                    this.b.l1(true);
                }
            }
        }

        /* renamed from: com.repackage.d02$b$b  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC0396b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a02 a;

            public RunnableC0396b(b bVar, a02 a02Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, a02Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = a02Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                a02 a02Var;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (a02Var = this.a) == null) {
                    return;
                }
                a02Var.l1(true);
            }
        }

        /* loaded from: classes5.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a02 a;

            public c(b bVar, a02 a02Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, a02Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = a02Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                a02 a02Var;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (a02Var = this.a) == null) {
                    return;
                }
                a02Var.l1(false);
            }
        }

        public b(d02 d02Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d02Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = d02Var;
            this.a = d02Var.a.a();
            this.b = str;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!TextUtils.isEmpty(this.b)) {
                    c02.T3(this.b);
                }
                while (!this.c.c.isEmpty()) {
                    if (this.c.c.peek() != null) {
                        ((Runnable) this.c.c.poll()).run();
                    }
                }
                d();
                this.a.f();
            }
        }

        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                a();
                return this.c.a.c();
            }
            return invokeV.booleanValue;
        }

        public void c(a02 a02Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, a02Var) == null) {
                qe4 qe4Var = this.a;
                qe4Var.g(a02Var);
                qe4Var.f();
                this.c.a.c();
            }
        }

        public final void d() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.c.b.isEmpty()) {
                return;
            }
            int size = this.c.b.size();
            boolean z = false;
            int i = size - 1;
            for (int i2 = i; i2 >= 0; i2--) {
                if (i2 >= i) {
                    if (d02.e) {
                        Log.d("SwanAppFragmentManager", "show fragment i " + i2 + " ,size: " + size);
                    }
                    this.a.j((Fragment) this.c.b.get(i2));
                    z = ((a02) this.c.b.get(i2)).D0;
                } else if (z) {
                    this.a.j((Fragment) this.c.b.get(i2));
                    z = ((a02) this.c.b.get(i2)).D0;
                } else {
                    this.a.g((Fragment) this.c.b.get(i2));
                }
            }
        }

        public final boolean e(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) ? d02.f.contains(str) : invokeL.booleanValue;
        }

        public b f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                List<Fragment> d = this.c.a.d();
                if (d != null && d.size() != this.c.b.size()) {
                    for (Fragment fragment : d) {
                        if (fragment != null && !this.c.b.contains(fragment)) {
                            if (d02.e) {
                                Log.d("SwanAppFragmentManager", "popAllFragments remove: " + fragment);
                            }
                            for (a aVar : this.c.d) {
                                if (aVar != null) {
                                    aVar.b(fragment);
                                }
                            }
                            this.a.h(fragment);
                        }
                    }
                }
                h(this.c.b.size());
                return this;
            }
            return (b) invokeV.objValue;
        }

        public b g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                h(1);
                return this;
            }
            return (b) invokeV.objValue;
        }

        public b h(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
                if (this.c.b.isEmpty()) {
                    return this;
                }
                ArrayList arrayList = (ArrayList) this.c.b.clone();
                int size = arrayList.size();
                int i2 = size - i;
                a02 a02Var = (i2 < 0 || i <= 0) ? null : (a02) arrayList.get(i2);
                while (true) {
                    size--;
                    if (size <= i2 - 1 || size < 0) {
                        break;
                    }
                    for (a aVar : this.c.d) {
                        if (aVar != null) {
                            aVar.b((Fragment) arrayList.get(size));
                        }
                    }
                    this.a.h((Fragment) arrayList.get(size));
                    this.c.b.remove(size);
                }
                this.c.c.offer(new c(this, a02Var));
                r();
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                if (this.c.b.isEmpty()) {
                    return this;
                }
                ArrayList arrayList = (ArrayList) this.c.b.clone();
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    if (!((a02) arrayList.get(size)).d2()) {
                        this.a.h((Fragment) arrayList.get(size));
                        this.c.b.remove(size);
                    }
                }
                r();
                return this;
            }
            return (b) invokeV.objValue;
        }

        public b j(a02 a02Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, a02Var)) == null) {
                s(a02Var);
                this.a.b(R.id.obfuscated_res_0x7f09016f, a02Var, "SwanAppFragment");
                this.c.b.add(a02Var);
                for (a aVar : this.c.d) {
                    if (aVar != null) {
                        aVar.a(a02Var);
                    }
                }
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b k(String str, uq2 uq2Var) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, uq2Var)) == null) ? l(str, uq2Var, false) : (b) invokeLL.objValue;
        }

        @Nullable
        public b l(String str, uq2 uq2Var, boolean z) {
            InterceptResult invokeLLZ;
            a02 Y2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048587, this, str, uq2Var, z)) == null) {
                if ("about".equals(str)) {
                    Y2 = xz1.p3();
                } else if ("authority".equals(str)) {
                    Y2 = zz1.e3();
                } else if ("pluginFunPage".equals(str)) {
                    Y2 = e02.X2(uq2Var.c, uq2Var.b);
                } else if (e(str)) {
                    Y2 = i02.b3(uq2Var, str);
                } else if (TextUtils.equals("settings", str)) {
                    Y2 = g02.U2();
                } else if ("normal".equals(str)) {
                    vq2.a aVar = new vq2.a();
                    aVar.d(uq2Var.a);
                    aVar.e(uq2Var.b);
                    aVar.b(uq2Var.c);
                    aVar.c(z);
                    aVar.g(uq2Var.e);
                    aVar.f(uq2Var.f);
                    Y2 = c02.L3(aVar.a());
                } else {
                    Y2 = "running_info".equals(str) ? f02.Y2() : null;
                }
                if (Y2 == null) {
                    return null;
                }
                j(Y2);
                return this;
            }
            return (b) invokeLLZ.objValue;
        }

        public b m(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
                int size = this.c.b.size();
                if (!this.c.b.isEmpty() && i >= 0 && i < size) {
                    this.a.h((a02) this.c.b.remove(i));
                }
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b n(int i, int i2) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(1048589, this, i, i2)) == null) {
                ed3.d(this.a, this.b, i, i2);
                return this;
            }
            return (b) invokeII.objValue;
        }

        public void o(a02 a02Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048590, this, a02Var) == null) {
                qe4 qe4Var = this.a;
                qe4Var.j(a02Var);
                qe4Var.f();
                this.c.a.c();
            }
        }

        public void p(List<a02> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048591, this, list) == null) {
                for (int i = 0; i < list.size(); i++) {
                    this.a.j(list.get(i));
                }
                this.a.f();
                this.c.a.c();
            }
        }

        public b q(uq2 uq2Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, uq2Var)) == null) {
                c02 l = this.c.l();
                if (l != null) {
                    l.U3(uq2Var);
                    return this;
                }
                return k("normal", uq2Var);
            }
            return (b) invokeL.objValue;
        }

        public final void r() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
                this.c.c.offer(new RunnableC0396b(this, this.c.m()));
            }
        }

        public final void s(a02 a02Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048594, this, a02Var) == null) {
                this.c.c.offer(new a(this, this.c.m(), a02Var));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755821301, "Lcom/repackage/d02;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755821301, "Lcom/repackage/d02;");
                return;
            }
        }
        e = eh1.a;
        HashSet hashSet = new HashSet();
        f = hashSet;
        g = R.anim.obfuscated_res_0x7f010022;
        h = R.anim.obfuscated_res_0x7f010025;
        i = R.anim.obfuscated_res_0x7f01001c;
        hashSet.add("adLanding");
        f.add("wxPay");
        f.add("default_webview");
        f.add("allianceLogin");
        f.add("web_mode");
        f.add("allianceChooseAddress");
        f.add("qrCodePay");
    }

    public d02(FragmentActivity fragmentActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fragmentActivity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = new LinkedList();
        this.a = fragmentActivity.getSupportFragmentManager();
        this.b = new ArrayList<>();
        this.d = new CopyOnWriteArrayList();
    }

    public void g(@Nullable a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
            return;
        }
        this.d.add(aVar);
    }

    public b h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new b(this, "") : (b) invokeV.objValue;
    }

    public b i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? new b(this, str) : (b) invokeL.objValue;
    }

    public a02 j(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            if (this.b.isEmpty() || i2 < 0 || i2 >= this.b.size()) {
                return null;
            }
            return this.b.get(i2);
        }
        return (a02) invokeI.objValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.b.size() : invokeV.intValue;
    }

    public c02 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.b.isEmpty()) {
                return null;
            }
            int size = this.b.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.b.get(i2).d2()) {
                    return (c02) this.b.get(i2);
                }
            }
            return null;
        }
        return (c02) invokeV.objValue;
    }

    @Nullable
    public a02 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? j(this.b.size() - 1) : (a02) invokeV.objValue;
    }

    @Nullable
    public <T extends a02> T n(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, cls)) == null) {
            if (cls != null) {
                for (int size = this.b.size() - 1; size >= 0; size--) {
                    T t = (T) this.b.get(size);
                    if (t.getClass() == cls) {
                        return t;
                    }
                }
                return null;
            }
            return null;
        }
        return (T) invokeL.objValue;
    }

    public c02 o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            for (int size = this.b.size() - 1; size >= 0; size--) {
                a02 a02Var = this.b.get(size);
                if (a02Var instanceof c02) {
                    return (c02) a02Var;
                }
            }
            return null;
        }
        return (c02) invokeV.objValue;
    }

    public void p(@Nullable a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) || aVar == null) {
            return;
        }
        this.d.remove(aVar);
    }
}
