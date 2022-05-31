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
public class lj0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<Class<?>, ArrayList<tj0>> a;
    public final ConcurrentHashMap<Object, ArrayList<tj0>> b;

    public lj0() {
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

    public final void a(@NonNull tj0 tj0Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, tj0Var) == null) {
            synchronized (this) {
                ArrayList<tj0> arrayList = this.a.get(tj0Var.b);
                boolean z2 = true;
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    this.a.put(tj0Var.b, arrayList);
                } else {
                    Iterator<tj0> it = arrayList.iterator();
                    while (it.hasNext()) {
                        if (it.next().a == tj0Var.a) {
                            z = true;
                            break;
                        }
                    }
                }
                z = false;
                if (!z) {
                    arrayList.add(tj0Var);
                }
                ArrayList<tj0> arrayList2 = this.b.get(tj0Var.a);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>();
                    this.b.put(tj0Var.a, arrayList2);
                } else {
                    Iterator<tj0> it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        if (it2.next().d == tj0Var.d) {
                            break;
                        }
                    }
                }
                z2 = false;
                if (!z2) {
                    arrayList2.add(tj0Var);
                }
            }
        }
    }

    public <T extends oj0> void b(@Nullable T t) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) || t == null) {
            return;
        }
        synchronized (this) {
            ArrayList<tj0> arrayList = this.a.get(t.getClass());
            if (arrayList != null) {
                Iterator<tj0> it = arrayList.iterator();
                while (it.hasNext()) {
                    tj0 next = it.next();
                    f(next, next.d, t);
                }
            }
        }
    }

    public <T extends oj0> void c(@NonNull Object obj, int i, @NonNull rj0<T> rj0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, obj, i, rj0Var) == null) {
            a(new tj0(i, obj, rj0Var.a(), rj0Var));
        }
    }

    public <T extends oj0> void d(@NonNull Object obj, @NonNull rj0<T> rj0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, obj, rj0Var) == null) {
            c(obj, 0, rj0Var);
        }
    }

    public final void e(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, obj) == null) {
            synchronized (this) {
                ArrayList<tj0> arrayList = this.b.get(obj);
                if (arrayList != null) {
                    Iterator<tj0> it = arrayList.iterator();
                    while (it.hasNext()) {
                        tj0 next = it.next();
                        ArrayList<tj0> arrayList2 = this.a.get(next.b);
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

    public final <T extends oj0> void f(tj0 tj0Var, rj0<T> rj0Var, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, tj0Var, rj0Var, t) == null) {
            int i = tj0Var.c;
            if (i == 0) {
                rj0Var.onEvent(t);
            } else if (i == 1) {
                sj0.b().a(tj0Var, rj0Var, t);
            } else if (i == 2) {
                kj0.b().a(tj0Var, rj0Var, t);
            } else if (i != 3) {
            } else {
                jj0.b().a(tj0Var, rj0Var, t);
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
