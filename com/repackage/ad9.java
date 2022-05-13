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
public class ad9 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public bd9 a;
    public long b;
    public int c;
    public long d;
    public LinkedList<zc9> e;
    public ArrayList<String> f;

    /* loaded from: classes5.dex */
    public class a implements Comparator<zc9> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(ad9 ad9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ad9Var};
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
        public int compare(zc9 zc9Var, zc9 zc9Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, zc9Var, zc9Var2)) == null) {
                int h = zc9Var2.h() - zc9Var.h();
                return h == 0 ? (int) (zc9Var2.i() - zc9Var.i()) : h;
            }
            return invokeLL.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755860485, "Lcom/repackage/ad9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755860485, "Lcom/repackage/ad9;");
                return;
            }
        }
        g = AppConfig.isDebug();
    }

    public ad9(Context context, boolean z) {
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
        this.a = bd9.f(context);
        j(z);
    }

    public void a(zc9 zc9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, zc9Var) == null) {
            if (zc9Var != null) {
                if (this.e.size() == 0) {
                    this.e.addFirst(zc9Var);
                } else {
                    int i = 0;
                    Iterator<zc9> it = this.e.iterator();
                    while (it.hasNext() && zc9Var.h() < it.next().h()) {
                        i++;
                    }
                    this.e.add(i, zc9Var);
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
            if (this.c < pc9.f().m()) {
                if (g) {
                    Log.d("VoyagerTaskModel", "current count: " + this.c + ", max: " + pc9.f().m());
                }
                return true;
            }
            this.c = 0;
            return System.currentTimeMillis() - this.b > pc9.f().l();
        }
        return invokeV.booleanValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            d();
            id9.b(rc9.g().h());
            LinkedList<zc9> linkedList = this.e;
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
        bd9 bd9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (bd9Var = this.a) == null) {
            return;
        }
        bd9Var.a();
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            LinkedList<zc9> linkedList = this.e;
            if (linkedList != null && linkedList.size() != 0) {
                long h = pc9.f().h();
                File h2 = rc9.g().h();
                Iterator<zc9> it = this.e.iterator();
                while (it.hasNext()) {
                    zc9 next = it.next();
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
                int g2 = pc9.f().g();
                int size = this.e.size();
                if (size <= g2) {
                    return;
                }
                int i = size - g2;
                for (int i2 = i; i2 > 0; i2--) {
                    zc9 removeLast = this.e.removeLast();
                    removeLast.r(false);
                    removeLast.q(System.currentTimeMillis());
                    n(removeLast);
                    id9.d(rc9.g().h(), removeLast.j());
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
                    id9.d(rc9.g().h(), it.next());
                    it.remove();
                }
            }
        }
    }

    public final void g() {
        ArrayList<File> f;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (f = rc9.g().f()) == null || f.size() == 0) {
            return;
        }
        Iterator<File> it = f.iterator();
        while (it.hasNext()) {
            String name = it.next().getName();
            Iterator<zc9> it2 = this.e.iterator();
            while (it2.hasNext() && !TextUtils.equals(name, it2.next().j())) {
            }
            it.remove();
        }
        if (g) {
            Log.d("VoyagerTaskModel", "unreference file count: " + f.size());
        }
        if (f.size() > 0) {
            id9.c(f);
        }
    }

    public final boolean h() {
        InterceptResult invokeV;
        LinkedList<zc9> linkedList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.a == null || (linkedList = this.e) == null || linkedList.size() == 0) {
                return false;
            }
            String c = this.a.c();
            zc9 zc9Var = null;
            Iterator<zc9> it = this.e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                zc9 next = it.next();
                if (TextUtils.equals(c, next.j())) {
                    zc9Var = next;
                    break;
                }
            }
            if (zc9Var != null) {
                this.e.remove(zc9Var);
            }
            File file = new File(rc9.g().h(), c);
            if (file.exists()) {
                file.delete();
                this.d -= file.length();
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public zc9 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            LinkedList<zc9> linkedList = this.e;
            if (linkedList != null && linkedList.size() != 0) {
                return this.e.getFirst();
            }
            if (g) {
                Log.d("VoyagerTaskModel", "have no task in list");
            }
            this.c = 0;
            return null;
        }
        return (zc9) invokeV.objValue;
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

    public void k(zc9 zc9Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, zc9Var) == null) || zc9Var == null) {
            return;
        }
        this.a.h(zc9Var);
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.e.size() <= 0) {
            return;
        }
        Collections.sort(this.e, new a(this));
    }

    public void m(boolean z, zc9 zc9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048588, this, z, zc9Var) == null) {
            zc9Var.r(false);
            zc9Var.q(System.currentTimeMillis());
            n(zc9Var);
            if (z) {
                this.e.remove(zc9Var);
            }
        }
    }

    public void n(zc9 zc9Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, zc9Var) == null) || zc9Var == null) {
            return;
        }
        this.a.i(zc9Var);
    }

    public void o(zc9 zc9Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, zc9Var) == null) || zc9Var == null) {
            return;
        }
        this.a.j(zc9Var);
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

    public void q(zc9 zc9Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, zc9Var) == null) || zc9Var == null) {
            return;
        }
        this.e.remove(zc9Var);
        this.e.addLast(zc9Var);
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.c++;
        }
    }

    public void s(boolean z, zc9 zc9Var, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Boolean.valueOf(z), zc9Var, Long.valueOf(j)}) == null) {
            zc9Var.r(false);
            zc9Var.s(zc9Var.k() + 1);
            zc9Var.q(System.currentTimeMillis());
            if (z) {
                if (g) {
                    Log.d("VoyagerTaskModel", "max upload count: " + zc9Var.d() + ", has uploaded " + zc9Var.k());
                }
                if (zc9Var.k() < zc9Var.d()) {
                    o(zc9Var);
                    q(zc9Var);
                    return;
                }
                n(zc9Var);
                this.e.remove(zc9Var);
                return;
            }
            o(zc9Var);
            a(zc9Var);
            if (g) {
                Log.d("VoyagerTaskModel", "add task " + zc9Var.j() + " to list");
            }
            this.d += j;
            while (this.d > pc9.f().h()) {
                if (!h()) {
                    this.d = 0L;
                    return;
                }
            }
        }
    }

    public void t(boolean z, zc9 zc9Var, long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Boolean.valueOf(z), zc9Var, Long.valueOf(j), str}) == null) {
            zc9Var.r(true);
            zc9Var.q(System.currentTimeMillis());
            zc9Var.p(str);
            n(zc9Var);
            if (z) {
                this.e.remove(zc9Var);
                this.d -= j;
            }
        }
    }

    public void u(boolean z, zc9 zc9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048596, this, z, zc9Var) == null) {
            zc9Var.r(false);
            zc9Var.q(System.currentTimeMillis());
            o(zc9Var);
            if (z) {
                q(zc9Var);
            } else {
                a(zc9Var);
            }
        }
    }
}
