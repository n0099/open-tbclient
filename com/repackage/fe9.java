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
/* loaded from: classes6.dex */
public class fe9 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public ge9 a;
    public long b;
    public int c;
    public long d;
    public LinkedList<ee9> e;
    public ArrayList<String> f;

    /* loaded from: classes6.dex */
    public class a implements Comparator<ee9> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(fe9 fe9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fe9Var};
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
        public int compare(ee9 ee9Var, ee9 ee9Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, ee9Var, ee9Var2)) == null) {
                int h = ee9Var2.h() - ee9Var.h();
                return h == 0 ? (int) (ee9Var2.i() - ee9Var.i()) : h;
            }
            return invokeLL.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755710569, "Lcom/repackage/fe9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755710569, "Lcom/repackage/fe9;");
                return;
            }
        }
        g = AppConfig.isDebug();
    }

    public fe9(Context context, boolean z) {
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
        this.a = ge9.f(context);
        j(z);
    }

    public void a(ee9 ee9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ee9Var) == null) {
            if (ee9Var != null) {
                if (this.e.size() == 0) {
                    this.e.addFirst(ee9Var);
                } else {
                    int i = 0;
                    Iterator<ee9> it = this.e.iterator();
                    while (it.hasNext() && ee9Var.h() < it.next().h()) {
                        i++;
                    }
                    this.e.add(i, ee9Var);
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
            if (this.c < ud9.f().m()) {
                if (g) {
                    Log.d("VoyagerTaskModel", "current count: " + this.c + ", max: " + ud9.f().m());
                }
                return true;
            }
            this.c = 0;
            return System.currentTimeMillis() - this.b > ud9.f().l();
        }
        return invokeV.booleanValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            d();
            ne9.b(wd9.g().h());
            LinkedList<ee9> linkedList = this.e;
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
        ge9 ge9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (ge9Var = this.a) == null) {
            return;
        }
        ge9Var.a();
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            LinkedList<ee9> linkedList = this.e;
            if (linkedList != null && linkedList.size() != 0) {
                long h = ud9.f().h();
                File h2 = wd9.g().h();
                Iterator<ee9> it = this.e.iterator();
                while (it.hasNext()) {
                    ee9 next = it.next();
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
                int g2 = ud9.f().g();
                int size = this.e.size();
                if (size <= g2) {
                    return;
                }
                int i = size - g2;
                for (int i2 = i; i2 > 0; i2--) {
                    ee9 removeLast = this.e.removeLast();
                    removeLast.r(false);
                    removeLast.q(System.currentTimeMillis());
                    n(removeLast);
                    ne9.d(wd9.g().h(), removeLast.j());
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
                    ne9.d(wd9.g().h(), it.next());
                    it.remove();
                }
            }
        }
    }

    public final void g() {
        ArrayList<File> f;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (f = wd9.g().f()) == null || f.size() == 0) {
            return;
        }
        Iterator<File> it = f.iterator();
        while (it.hasNext()) {
            String name = it.next().getName();
            Iterator<ee9> it2 = this.e.iterator();
            while (it2.hasNext() && !TextUtils.equals(name, it2.next().j())) {
            }
            it.remove();
        }
        if (g) {
            Log.d("VoyagerTaskModel", "unreference file count: " + f.size());
        }
        if (f.size() > 0) {
            ne9.c(f);
        }
    }

    public final boolean h() {
        InterceptResult invokeV;
        LinkedList<ee9> linkedList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.a == null || (linkedList = this.e) == null || linkedList.size() == 0) {
                return false;
            }
            String c = this.a.c();
            ee9 ee9Var = null;
            Iterator<ee9> it = this.e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ee9 next = it.next();
                if (TextUtils.equals(c, next.j())) {
                    ee9Var = next;
                    break;
                }
            }
            if (ee9Var != null) {
                this.e.remove(ee9Var);
            }
            File file = new File(wd9.g().h(), c);
            if (file.exists()) {
                file.delete();
                this.d -= file.length();
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public ee9 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            LinkedList<ee9> linkedList = this.e;
            if (linkedList != null && linkedList.size() != 0) {
                return this.e.getFirst();
            }
            if (g) {
                Log.d("VoyagerTaskModel", "have no task in list");
            }
            this.c = 0;
            return null;
        }
        return (ee9) invokeV.objValue;
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

    public void k(ee9 ee9Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, ee9Var) == null) || ee9Var == null) {
            return;
        }
        this.a.h(ee9Var);
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.e.size() <= 0) {
            return;
        }
        Collections.sort(this.e, new a(this));
    }

    public void m(boolean z, ee9 ee9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048588, this, z, ee9Var) == null) {
            ee9Var.r(false);
            ee9Var.q(System.currentTimeMillis());
            n(ee9Var);
            if (z) {
                this.e.remove(ee9Var);
            }
        }
    }

    public void n(ee9 ee9Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, ee9Var) == null) || ee9Var == null) {
            return;
        }
        this.a.i(ee9Var);
    }

    public void o(ee9 ee9Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, ee9Var) == null) || ee9Var == null) {
            return;
        }
        this.a.j(ee9Var);
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

    public void q(ee9 ee9Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, ee9Var) == null) || ee9Var == null) {
            return;
        }
        this.e.remove(ee9Var);
        this.e.addLast(ee9Var);
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.c++;
        }
    }

    public void s(boolean z, ee9 ee9Var, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Boolean.valueOf(z), ee9Var, Long.valueOf(j)}) == null) {
            ee9Var.r(false);
            ee9Var.s(ee9Var.k() + 1);
            ee9Var.q(System.currentTimeMillis());
            if (z) {
                if (g) {
                    Log.d("VoyagerTaskModel", "max upload count: " + ee9Var.d() + ", has uploaded " + ee9Var.k());
                }
                if (ee9Var.k() < ee9Var.d()) {
                    o(ee9Var);
                    q(ee9Var);
                    return;
                }
                n(ee9Var);
                this.e.remove(ee9Var);
                return;
            }
            o(ee9Var);
            a(ee9Var);
            if (g) {
                Log.d("VoyagerTaskModel", "add task " + ee9Var.j() + " to list");
            }
            this.d += j;
            while (this.d > ud9.f().h()) {
                if (!h()) {
                    this.d = 0L;
                    return;
                }
            }
        }
    }

    public void t(boolean z, ee9 ee9Var, long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Boolean.valueOf(z), ee9Var, Long.valueOf(j), str}) == null) {
            ee9Var.r(true);
            ee9Var.q(System.currentTimeMillis());
            ee9Var.p(str);
            n(ee9Var);
            if (z) {
                this.e.remove(ee9Var);
                this.d -= j;
            }
        }
    }

    public void u(boolean z, ee9 ee9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048596, this, z, ee9Var) == null) {
            ee9Var.r(false);
            ee9Var.q(System.currentTimeMillis());
            o(ee9Var);
            if (z) {
                q(ee9Var);
            } else {
                a(ee9Var);
            }
        }
    }
}
