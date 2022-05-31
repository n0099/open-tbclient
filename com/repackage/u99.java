package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes7.dex */
public class u99 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public v99 a;
    public long b;
    public int c;
    public long d;
    public LinkedList<t99> e;
    public ArrayList<String> f;

    /* loaded from: classes7.dex */
    public class a implements Comparator<t99> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(u99 u99Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u99Var};
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
        public int compare(t99 t99Var, t99 t99Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, t99Var, t99Var2)) == null) {
                int h = t99Var2.h() - t99Var.h();
                return h == 0 ? (int) (t99Var2.i() - t99Var.i()) : h;
            }
            return invokeLL.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755305988, "Lcom/repackage/u99;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755305988, "Lcom/repackage/u99;");
                return;
            }
        }
        g = AppConfig.isDebug();
    }

    public u99(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = v99.f(context);
        j(z);
    }

    public void a(t99 t99Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, t99Var) == null) {
            if (t99Var != null) {
                if (this.e.size() == 0) {
                    this.e.addFirst(t99Var);
                } else {
                    int i = 0;
                    Iterator<t99> it = this.e.iterator();
                    while (it.hasNext() && t99Var.h() < it.next().h()) {
                        i++;
                    }
                    this.e.add(i, t99Var);
                }
            }
            if (g) {
                Log.d("VoyagerTaskModel", "count: " + this.e.size());
            }
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.c < j99.f().m()) {
                if (g) {
                    Log.d("VoyagerTaskModel", "current count: " + this.c + ", max: " + j99.f().m());
                }
                return true;
            }
            this.c = 0;
            return System.currentTimeMillis() - this.b > j99.f().l();
        }
        return invokeV.booleanValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            d();
            ca9.b(l99.g().h());
            LinkedList<t99> linkedList = this.e;
            if (linkedList != null && linkedList.size() > 0) {
                this.e.clear();
            }
            ArrayList<String> arrayList = this.f;
            if (arrayList != null && arrayList.size() > 0) {
                this.f.clear();
            }
            this.b = 0L;
            this.c = 0;
            this.d = 0L;
        }
    }

    public final void d() {
        v99 v99Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (v99Var = this.a) == null) {
            return;
        }
        v99Var.a();
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            LinkedList<t99> linkedList = this.e;
            if (linkedList != null && linkedList.size() != 0) {
                long h = j99.f().h();
                File h2 = l99.g().h();
                Iterator<t99> it = this.e.iterator();
                while (it.hasNext()) {
                    t99 next = it.next();
                    File file = new File(h2, next.j());
                    if (this.d < h) {
                        if (file.exists()) {
                            this.d += file.length();
                        }
                    } else {
                        next.r(false);
                        next.q(System.currentTimeMillis());
                        n(next);
                        file.delete();
                    }
                }
                if (g) {
                    Log.d("VoyagerTaskModel", "task count after delete exceed task: " + this.e.size());
                }
                int g2 = j99.f().g();
                int size = this.e.size();
                if (size <= g2) {
                    return;
                }
                int i = size - g2;
                for (int i2 = i; i2 > 0; i2--) {
                    t99 removeLast = this.e.removeLast();
                    removeLast.r(false);
                    removeLast.q(System.currentTimeMillis());
                    n(removeLast);
                    ca9.d(l99.g().h(), removeLast.j());
                }
                if (g) {
                    Log.d("VoyagerTaskModel", "delete count: " + i);
                }
            } else if (g) {
                Log.d("VoyagerTaskModel", "task list length 0");
            }
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.a.g(this.f, this.e);
            if (this.f.size() > 0) {
                Iterator<String> it = this.f.iterator();
                while (it.hasNext()) {
                    ca9.d(l99.g().h(), it.next());
                    it.remove();
                }
            }
        }
    }

    public final void g() {
        ArrayList<File> f;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (f = l99.g().f()) == null || f.size() == 0) {
            return;
        }
        Iterator<File> it = f.iterator();
        while (it.hasNext()) {
            String name = it.next().getName();
            Iterator<t99> it2 = this.e.iterator();
            while (it2.hasNext() && !TextUtils.equals(name, it2.next().j())) {
            }
            it.remove();
        }
        if (g) {
            Log.d("VoyagerTaskModel", "unreference file count: " + f.size());
        }
        if (f.size() > 0) {
            ca9.c(f);
        }
    }

    public final boolean h() {
        InterceptResult invokeV;
        LinkedList<t99> linkedList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.a == null || (linkedList = this.e) == null || linkedList.size() == 0) {
                return false;
            }
            String c = this.a.c();
            t99 t99Var = null;
            Iterator<t99> it = this.e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                t99 next = it.next();
                if (TextUtils.equals(c, next.j())) {
                    t99Var = next;
                    break;
                }
            }
            if (t99Var != null) {
                this.e.remove(t99Var);
            }
            File file = new File(l99.g().h(), c);
            if (file.exists()) {
                file.delete();
                this.d -= file.length();
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public t99 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            LinkedList<t99> linkedList = this.e;
            if (linkedList != null && linkedList.size() != 0) {
                return this.e.getFirst();
            }
            if (g) {
                Log.d("VoyagerTaskModel", "have no task in list");
            }
            this.c = 0;
            return null;
        }
        return (t99) invokeV.objValue;
    }

    public final void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            if (z) {
                c();
                return;
            }
            this.e = new LinkedList<>();
            this.f = new ArrayList<>();
            this.b = 0L;
            this.c = 0;
            this.d = 0L;
            f();
            g();
            e();
            l();
        }
    }

    public void k(t99 t99Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, t99Var) == null) || t99Var == null) {
            return;
        }
        this.a.h(t99Var);
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.e.size() <= 0) {
            return;
        }
        Collections.sort(this.e, new a(this));
    }

    public void m(boolean z, t99 t99Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048588, this, z, t99Var) == null) {
            t99Var.r(false);
            t99Var.q(System.currentTimeMillis());
            n(t99Var);
            if (z) {
                this.e.remove(t99Var);
            }
        }
    }

    public void n(t99 t99Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, t99Var) == null) || t99Var == null) {
            return;
        }
        this.a.i(t99Var);
    }

    public void o(t99 t99Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, t99Var) == null) || t99Var == null) {
            return;
        }
        this.a.j(t99Var);
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.b = System.currentTimeMillis();
            if (g) {
                Log.d("VoyagerTaskModel", "update check task time: " + this.b);
            }
        }
    }

    public void q(t99 t99Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, t99Var) == null) || t99Var == null) {
            return;
        }
        this.e.remove(t99Var);
        this.e.addLast(t99Var);
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.c++;
        }
    }

    public void s(boolean z, t99 t99Var, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Boolean.valueOf(z), t99Var, Long.valueOf(j)}) == null) {
            t99Var.r(false);
            t99Var.s(t99Var.k() + 1);
            t99Var.q(System.currentTimeMillis());
            if (z) {
                if (g) {
                    Log.d("VoyagerTaskModel", "max upload count: " + t99Var.d() + ", has uploaded " + t99Var.k());
                }
                if (t99Var.k() < t99Var.d()) {
                    o(t99Var);
                    q(t99Var);
                    return;
                }
                n(t99Var);
                this.e.remove(t99Var);
                return;
            }
            o(t99Var);
            a(t99Var);
            if (g) {
                Log.d("VoyagerTaskModel", "add task " + t99Var.j() + " to list");
            }
            this.d += j;
            while (this.d > j99.f().h()) {
                if (!h()) {
                    this.d = 0L;
                    return;
                }
            }
        }
    }

    public void t(boolean z, t99 t99Var, long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Boolean.valueOf(z), t99Var, Long.valueOf(j), str}) == null) {
            t99Var.r(true);
            t99Var.q(System.currentTimeMillis());
            t99Var.p(str);
            n(t99Var);
            if (z) {
                this.e.remove(t99Var);
                this.d -= j;
            }
        }
    }

    public void u(boolean z, t99 t99Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048596, this, z, t99Var) == null) {
            t99Var.r(false);
            t99Var.q(System.currentTimeMillis());
            o(t99Var);
            if (z) {
                q(t99Var);
            } else {
                a(t99Var);
            }
        }
    }
}
