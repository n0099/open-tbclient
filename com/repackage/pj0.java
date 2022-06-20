package com.repackage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public class pj0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<Class<?>, ArrayList<xj0>> a;
    public final ConcurrentHashMap<Object, ArrayList<xj0>> b;

    public pj0() {
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
        this.a = new ConcurrentHashMap<>();
        this.b = new ConcurrentHashMap<>();
    }

    public final void a(@NonNull xj0 xj0Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, xj0Var) == null) {
            synchronized (this) {
                ArrayList<xj0> arrayList = this.a.get(xj0Var.b);
                boolean z2 = true;
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    this.a.put(xj0Var.b, arrayList);
                } else {
                    Iterator<xj0> it = arrayList.iterator();
                    while (it.hasNext()) {
                        if (it.next().a == xj0Var.a) {
                            z = true;
                            break;
                        }
                    }
                }
                z = false;
                if (!z) {
                    arrayList.add(xj0Var);
                }
                ArrayList<xj0> arrayList2 = this.b.get(xj0Var.a);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>();
                    this.b.put(xj0Var.a, arrayList2);
                } else {
                    Iterator<xj0> it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        if (it2.next().d == xj0Var.d) {
                            break;
                        }
                    }
                }
                z2 = false;
                if (!z2) {
                    arrayList2.add(xj0Var);
                }
            }
        }
    }

    public <T extends sj0> void b(@Nullable T t) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) || t == null) {
            return;
        }
        synchronized (this) {
            ArrayList<xj0> arrayList = this.a.get(t.getClass());
            if (arrayList != null) {
                Iterator<xj0> it = arrayList.iterator();
                while (it.hasNext()) {
                    xj0 next = it.next();
                    f(next, next.d, t);
                }
            }
        }
    }

    public <T extends sj0> void c(@NonNull Object obj, int i, @NonNull vj0<T> vj0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, obj, i, vj0Var) == null) {
            a(new xj0(i, obj, vj0Var.a(), vj0Var));
        }
    }

    public <T extends sj0> void d(@NonNull Object obj, @NonNull vj0<T> vj0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, obj, vj0Var) == null) {
            c(obj, 0, vj0Var);
        }
    }

    public final void e(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, obj) == null) {
            synchronized (this) {
                ArrayList<xj0> arrayList = this.b.get(obj);
                if (arrayList != null) {
                    Iterator<xj0> it = arrayList.iterator();
                    while (it.hasNext()) {
                        xj0 next = it.next();
                        ArrayList<xj0> arrayList2 = this.a.get(next.b);
                        if (arrayList2 != null) {
                            arrayList2.remove(next);
                        }
                    }
                    arrayList.clear();
                    this.b.remove(obj);
                }
            }
        }
    }

    public final <T extends sj0> void f(xj0 xj0Var, vj0<T> vj0Var, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, xj0Var, vj0Var, t) == null) {
            int i = xj0Var.c;
            if (i == 0) {
                vj0Var.onEvent(t);
            } else if (i == 1) {
                wj0.b().a(xj0Var, vj0Var, t);
            } else if (i == 2) {
                oj0.b().a(xj0Var, vj0Var, t);
            } else if (i != 3) {
            } else {
                nj0.b().a(xj0Var, vj0Var, t);
            }
        }
    }

    public void g(@NonNull Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, obj) == null) {
            e(obj);
        }
    }
}
