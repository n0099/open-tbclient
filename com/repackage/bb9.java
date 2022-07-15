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
/* loaded from: classes5.dex */
public class bb9 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public cb9 a;
    public long b;
    public int c;
    public long d;
    public LinkedList<ab9> e;
    public ArrayList<String> f;

    /* loaded from: classes5.dex */
    public class a implements Comparator<ab9> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(bb9 bb9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bb9Var};
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
        public int compare(ab9 ab9Var, ab9 ab9Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, ab9Var, ab9Var2)) == null) {
                int h = ab9Var2.h() - ab9Var.h();
                return h == 0 ? (int) (ab9Var2.i() - ab9Var.i()) : h;
            }
            return invokeLL.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755832616, "Lcom/repackage/bb9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755832616, "Lcom/repackage/bb9;");
                return;
            }
        }
        g = AppConfig.isDebug();
    }

    public bb9(Context context, boolean z) {
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
        this.a = cb9.h(context);
        j(z);
    }

    public void a(ab9 ab9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ab9Var) == null) {
            if (ab9Var != null) {
                if (this.e.size() == 0) {
                    this.e.addFirst(ab9Var);
                } else {
                    int i = 0;
                    Iterator<ab9> it = this.e.iterator();
                    while (it.hasNext() && ab9Var.h() < it.next().h()) {
                        i++;
                    }
                    this.e.add(i, ab9Var);
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
            if (this.c < qa9.f().m()) {
                if (g) {
                    Log.d("VoyagerTaskModel", "current count: " + this.c + ", max: " + qa9.f().m());
                }
                return true;
            }
            this.c = 0;
            return System.currentTimeMillis() - this.b > qa9.f().l();
        }
        return invokeV.booleanValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            d();
            jb9.b(sa9.g().h());
            LinkedList<ab9> linkedList = this.e;
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
        cb9 cb9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (cb9Var = this.a) == null) {
            return;
        }
        cb9Var.c();
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            LinkedList<ab9> linkedList = this.e;
            if (linkedList != null && linkedList.size() != 0) {
                long h = qa9.f().h();
                File h2 = sa9.g().h();
                Iterator<ab9> it = this.e.iterator();
                while (it.hasNext()) {
                    ab9 next = it.next();
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
                int g2 = qa9.f().g();
                int size = this.e.size();
                if (size <= g2) {
                    return;
                }
                int i = size - g2;
                for (int i2 = i; i2 > 0; i2--) {
                    ab9 removeLast = this.e.removeLast();
                    removeLast.r(false);
                    removeLast.q(System.currentTimeMillis());
                    n(removeLast);
                    jb9.d(sa9.g().h(), removeLast.j());
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
            this.a.i(this.f, this.e);
            if (this.f.size() > 0) {
                Iterator<String> it = this.f.iterator();
                while (it.hasNext()) {
                    jb9.d(sa9.g().h(), it.next());
                    it.remove();
                }
            }
        }
    }

    public final void g() {
        ArrayList<File> f;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (f = sa9.g().f()) == null || f.size() == 0) {
            return;
        }
        Iterator<File> it = f.iterator();
        while (it.hasNext()) {
            String name = it.next().getName();
            Iterator<ab9> it2 = this.e.iterator();
            while (it2.hasNext() && !TextUtils.equals(name, it2.next().j())) {
            }
            it.remove();
        }
        if (g) {
            Log.d("VoyagerTaskModel", "unreference file count: " + f.size());
        }
        if (f.size() > 0) {
            jb9.c(f);
        }
    }

    public final boolean h() {
        InterceptResult invokeV;
        LinkedList<ab9> linkedList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.a == null || (linkedList = this.e) == null || linkedList.size() == 0) {
                return false;
            }
            String e = this.a.e();
            ab9 ab9Var = null;
            Iterator<ab9> it = this.e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ab9 next = it.next();
                if (TextUtils.equals(e, next.j())) {
                    ab9Var = next;
                    break;
                }
            }
            if (ab9Var != null) {
                this.e.remove(ab9Var);
            }
            File file = new File(sa9.g().h(), e);
            if (file.exists()) {
                file.delete();
                this.d -= file.length();
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public ab9 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            LinkedList<ab9> linkedList = this.e;
            if (linkedList != null && linkedList.size() != 0) {
                return this.e.getFirst();
            }
            if (g) {
                Log.d("VoyagerTaskModel", "have no task in list");
            }
            this.c = 0;
            return null;
        }
        return (ab9) invokeV.objValue;
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

    public void k(ab9 ab9Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, ab9Var) == null) || ab9Var == null) {
            return;
        }
        this.a.j(ab9Var);
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.e.size() <= 0) {
            return;
        }
        Collections.sort(this.e, new a(this));
    }

    public void m(boolean z, ab9 ab9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048588, this, z, ab9Var) == null) {
            ab9Var.r(false);
            ab9Var.q(System.currentTimeMillis());
            n(ab9Var);
            if (z) {
                this.e.remove(ab9Var);
            }
        }
    }

    public void n(ab9 ab9Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, ab9Var) == null) || ab9Var == null) {
            return;
        }
        this.a.k(ab9Var);
    }

    public void o(ab9 ab9Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, ab9Var) == null) || ab9Var == null) {
            return;
        }
        this.a.l(ab9Var);
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

    public void q(ab9 ab9Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, ab9Var) == null) || ab9Var == null) {
            return;
        }
        this.e.remove(ab9Var);
        this.e.addLast(ab9Var);
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.c++;
        }
    }

    public void s(boolean z, ab9 ab9Var, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Boolean.valueOf(z), ab9Var, Long.valueOf(j)}) == null) {
            ab9Var.r(false);
            ab9Var.s(ab9Var.k() + 1);
            ab9Var.q(System.currentTimeMillis());
            if (z) {
                if (g) {
                    Log.d("VoyagerTaskModel", "max upload count: " + ab9Var.d() + ", has uploaded " + ab9Var.k());
                }
                if (ab9Var.k() < ab9Var.d()) {
                    o(ab9Var);
                    q(ab9Var);
                    return;
                }
                n(ab9Var);
                this.e.remove(ab9Var);
                return;
            }
            o(ab9Var);
            a(ab9Var);
            if (g) {
                Log.d("VoyagerTaskModel", "add task " + ab9Var.j() + " to list");
            }
            this.d += j;
            while (this.d > qa9.f().h()) {
                if (!h()) {
                    this.d = 0L;
                    return;
                }
            }
        }
    }

    public void t(boolean z, ab9 ab9Var, long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Boolean.valueOf(z), ab9Var, Long.valueOf(j), str}) == null) {
            ab9Var.r(true);
            ab9Var.q(System.currentTimeMillis());
            ab9Var.p(str);
            n(ab9Var);
            if (z) {
                this.e.remove(ab9Var);
                this.d -= j;
            }
        }
    }

    public void u(boolean z, ab9 ab9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048596, this, z, ab9Var) == null) {
            ab9Var.r(false);
            ab9Var.q(System.currentTimeMillis());
            o(ab9Var);
            if (z) {
                q(ab9Var);
            } else {
                a(ab9Var);
            }
        }
    }
}
