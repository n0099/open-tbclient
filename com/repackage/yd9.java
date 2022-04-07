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
public class yd9 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public zd9 a;
    public long b;
    public int c;
    public long d;
    public LinkedList<xd9> e;
    public ArrayList<String> f;

    /* loaded from: classes7.dex */
    public class a implements Comparator<xd9> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(yd9 yd9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yd9Var};
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
        public int compare(xd9 xd9Var, xd9 xd9Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, xd9Var, xd9Var2)) == null) {
                int h = xd9Var2.h() - xd9Var.h();
                return h == 0 ? (int) (xd9Var2.i() - xd9Var.i()) : h;
            }
            return invokeLL.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755145501, "Lcom/repackage/yd9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755145501, "Lcom/repackage/yd9;");
                return;
            }
        }
        g = AppConfig.isDebug();
    }

    public yd9(Context context, boolean z) {
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
        this.a = zd9.f(context);
        j(z);
    }

    public void a(xd9 xd9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, xd9Var) == null) {
            if (xd9Var != null) {
                if (this.e.size() == 0) {
                    this.e.addFirst(xd9Var);
                } else {
                    int i = 0;
                    Iterator<xd9> it = this.e.iterator();
                    while (it.hasNext() && xd9Var.h() < it.next().h()) {
                        i++;
                    }
                    this.e.add(i, xd9Var);
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
            if (this.c < nd9.f().m()) {
                if (g) {
                    Log.d("VoyagerTaskModel", "current count: " + this.c + ", max: " + nd9.f().m());
                }
                return true;
            }
            this.c = 0;
            return System.currentTimeMillis() - this.b > nd9.f().l();
        }
        return invokeV.booleanValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            d();
            ge9.b(pd9.g().h());
            LinkedList<xd9> linkedList = this.e;
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
        zd9 zd9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (zd9Var = this.a) == null) {
            return;
        }
        zd9Var.a();
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            LinkedList<xd9> linkedList = this.e;
            if (linkedList != null && linkedList.size() != 0) {
                long h = nd9.f().h();
                File h2 = pd9.g().h();
                Iterator<xd9> it = this.e.iterator();
                while (it.hasNext()) {
                    xd9 next = it.next();
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
                int g2 = nd9.f().g();
                int size = this.e.size();
                if (size <= g2) {
                    return;
                }
                int i = size - g2;
                for (int i2 = i; i2 > 0; i2--) {
                    xd9 removeLast = this.e.removeLast();
                    removeLast.r(false);
                    removeLast.q(System.currentTimeMillis());
                    n(removeLast);
                    ge9.d(pd9.g().h(), removeLast.j());
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
                    ge9.d(pd9.g().h(), it.next());
                    it.remove();
                }
            }
        }
    }

    public final void g() {
        ArrayList<File> f;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (f = pd9.g().f()) == null || f.size() == 0) {
            return;
        }
        Iterator<File> it = f.iterator();
        while (it.hasNext()) {
            String name = it.next().getName();
            Iterator<xd9> it2 = this.e.iterator();
            while (it2.hasNext() && !TextUtils.equals(name, it2.next().j())) {
            }
            it.remove();
        }
        if (g) {
            Log.d("VoyagerTaskModel", "unreference file count: " + f.size());
        }
        if (f.size() > 0) {
            ge9.c(f);
        }
    }

    public final boolean h() {
        InterceptResult invokeV;
        LinkedList<xd9> linkedList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.a == null || (linkedList = this.e) == null || linkedList.size() == 0) {
                return false;
            }
            String c = this.a.c();
            xd9 xd9Var = null;
            Iterator<xd9> it = this.e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                xd9 next = it.next();
                if (TextUtils.equals(c, next.j())) {
                    xd9Var = next;
                    break;
                }
            }
            if (xd9Var != null) {
                this.e.remove(xd9Var);
            }
            File file = new File(pd9.g().h(), c);
            if (file.exists()) {
                file.delete();
                this.d -= file.length();
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public xd9 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            LinkedList<xd9> linkedList = this.e;
            if (linkedList != null && linkedList.size() != 0) {
                return this.e.getFirst();
            }
            if (g) {
                Log.d("VoyagerTaskModel", "have no task in list");
            }
            this.c = 0;
            return null;
        }
        return (xd9) invokeV.objValue;
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

    public void k(xd9 xd9Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, xd9Var) == null) || xd9Var == null) {
            return;
        }
        this.a.h(xd9Var);
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.e.size() <= 0) {
            return;
        }
        Collections.sort(this.e, new a(this));
    }

    public void m(boolean z, xd9 xd9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048588, this, z, xd9Var) == null) {
            xd9Var.r(false);
            xd9Var.q(System.currentTimeMillis());
            n(xd9Var);
            if (z) {
                this.e.remove(xd9Var);
            }
        }
    }

    public void n(xd9 xd9Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, xd9Var) == null) || xd9Var == null) {
            return;
        }
        this.a.i(xd9Var);
    }

    public void o(xd9 xd9Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, xd9Var) == null) || xd9Var == null) {
            return;
        }
        this.a.j(xd9Var);
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

    public void q(xd9 xd9Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, xd9Var) == null) || xd9Var == null) {
            return;
        }
        this.e.remove(xd9Var);
        this.e.addLast(xd9Var);
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.c++;
        }
    }

    public void s(boolean z, xd9 xd9Var, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Boolean.valueOf(z), xd9Var, Long.valueOf(j)}) == null) {
            xd9Var.r(false);
            xd9Var.s(xd9Var.k() + 1);
            xd9Var.q(System.currentTimeMillis());
            if (z) {
                if (g) {
                    Log.d("VoyagerTaskModel", "max upload count: " + xd9Var.d() + ", has uploaded " + xd9Var.k());
                }
                if (xd9Var.k() < xd9Var.d()) {
                    o(xd9Var);
                    q(xd9Var);
                    return;
                }
                n(xd9Var);
                this.e.remove(xd9Var);
                return;
            }
            o(xd9Var);
            a(xd9Var);
            if (g) {
                Log.d("VoyagerTaskModel", "add task " + xd9Var.j() + " to list");
            }
            this.d += j;
            while (this.d > nd9.f().h()) {
                if (!h()) {
                    this.d = 0L;
                    return;
                }
            }
        }
    }

    public void t(boolean z, xd9 xd9Var, long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Boolean.valueOf(z), xd9Var, Long.valueOf(j), str}) == null) {
            xd9Var.r(true);
            xd9Var.q(System.currentTimeMillis());
            xd9Var.p(str);
            n(xd9Var);
            if (z) {
                this.e.remove(xd9Var);
                this.d -= j;
            }
        }
    }

    public void u(boolean z, xd9 xd9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048596, this, z, xd9Var) == null) {
            xd9Var.r(false);
            xd9Var.q(System.currentTimeMillis());
            o(xd9Var);
            if (z) {
                q(xd9Var);
            } else {
                a(xd9Var);
            }
        }
    }
}
