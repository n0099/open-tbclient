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
/* loaded from: classes7.dex */
public class yk0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<Class<?>, ArrayList<gl0>> a;
    public final ConcurrentHashMap<Object, ArrayList<gl0>> b;

    public yk0() {
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

    public final void a(@NonNull gl0 gl0Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, gl0Var) == null) {
            synchronized (this) {
                ArrayList<gl0> arrayList = this.a.get(gl0Var.b);
                boolean z2 = true;
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    this.a.put(gl0Var.b, arrayList);
                } else {
                    Iterator<gl0> it = arrayList.iterator();
                    while (it.hasNext()) {
                        if (it.next().a == gl0Var.a) {
                            z = true;
                            break;
                        }
                    }
                }
                z = false;
                if (!z) {
                    arrayList.add(gl0Var);
                }
                ArrayList<gl0> arrayList2 = this.b.get(gl0Var.a);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>();
                    this.b.put(gl0Var.a, arrayList2);
                } else {
                    Iterator<gl0> it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        if (it2.next().d == gl0Var.d) {
                            break;
                        }
                    }
                }
                z2 = false;
                if (!z2) {
                    arrayList2.add(gl0Var);
                }
            }
        }
    }

    public <T extends bl0> void b(@Nullable T t) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) || t == null) {
            return;
        }
        synchronized (this) {
            ArrayList<gl0> arrayList = this.a.get(t.getClass());
            if (arrayList != null) {
                Iterator<gl0> it = arrayList.iterator();
                while (it.hasNext()) {
                    gl0 next = it.next();
                    f(next, next.d, t);
                }
            }
        }
    }

    public <T extends bl0> void c(@NonNull Object obj, int i, @NonNull el0<T> el0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, obj, i, el0Var) == null) {
            a(new gl0(i, obj, el0Var.a(), el0Var));
        }
    }

    public <T extends bl0> void d(@NonNull Object obj, @NonNull el0<T> el0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, obj, el0Var) == null) {
            c(obj, 0, el0Var);
        }
    }

    public final void e(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, obj) == null) {
            synchronized (this) {
                ArrayList<gl0> arrayList = this.b.get(obj);
                if (arrayList != null) {
                    Iterator<gl0> it = arrayList.iterator();
                    while (it.hasNext()) {
                        gl0 next = it.next();
                        ArrayList<gl0> arrayList2 = this.a.get(next.b);
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

    public final <T extends bl0> void f(gl0 gl0Var, el0<T> el0Var, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, gl0Var, el0Var, t) == null) {
            int i = gl0Var.c;
            if (i == 0) {
                el0Var.onEvent(t);
            } else if (i == 1) {
                fl0.b().a(gl0Var, el0Var, t);
            } else if (i == 2) {
                xk0.b().a(gl0Var, el0Var, t);
            } else if (i != 3) {
            } else {
                wk0.b().a(gl0Var, el0Var, t);
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
