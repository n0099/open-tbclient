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
public class zj0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<Class<?>, ArrayList<hk0>> a;
    public final ConcurrentHashMap<Object, ArrayList<hk0>> b;

    public zj0() {
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

    public final void a(@NonNull hk0 hk0Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, hk0Var) == null) {
            synchronized (this) {
                ArrayList<hk0> arrayList = this.a.get(hk0Var.b);
                boolean z2 = true;
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    this.a.put(hk0Var.b, arrayList);
                } else {
                    Iterator<hk0> it = arrayList.iterator();
                    while (it.hasNext()) {
                        if (it.next().a == hk0Var.a) {
                            z = true;
                            break;
                        }
                    }
                }
                z = false;
                if (!z) {
                    arrayList.add(hk0Var);
                }
                ArrayList<hk0> arrayList2 = this.b.get(hk0Var.a);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>();
                    this.b.put(hk0Var.a, arrayList2);
                } else {
                    Iterator<hk0> it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        if (it2.next().d == hk0Var.d) {
                            break;
                        }
                    }
                }
                z2 = false;
                if (!z2) {
                    arrayList2.add(hk0Var);
                }
            }
        }
    }

    public <T extends ck0> void b(@Nullable T t) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) || t == null) {
            return;
        }
        synchronized (this) {
            ArrayList<hk0> arrayList = this.a.get(t.getClass());
            if (arrayList != null) {
                Iterator<hk0> it = arrayList.iterator();
                while (it.hasNext()) {
                    hk0 next = it.next();
                    f(next, next.d, t);
                }
            }
        }
    }

    public <T extends ck0> void c(@NonNull Object obj, int i, @NonNull fk0<T> fk0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, obj, i, fk0Var) == null) {
            a(new hk0(i, obj, fk0Var.a(), fk0Var));
        }
    }

    public <T extends ck0> void d(@NonNull Object obj, @NonNull fk0<T> fk0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, obj, fk0Var) == null) {
            c(obj, 0, fk0Var);
        }
    }

    public final void e(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, obj) == null) {
            synchronized (this) {
                ArrayList<hk0> arrayList = this.b.get(obj);
                if (arrayList != null) {
                    Iterator<hk0> it = arrayList.iterator();
                    while (it.hasNext()) {
                        hk0 next = it.next();
                        ArrayList<hk0> arrayList2 = this.a.get(next.b);
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

    public final <T extends ck0> void f(hk0 hk0Var, fk0<T> fk0Var, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, hk0Var, fk0Var, t) == null) {
            int i = hk0Var.c;
            if (i == 0) {
                fk0Var.onEvent(t);
            } else if (i == 1) {
                gk0.b().a(hk0Var, fk0Var, t);
            } else if (i == 2) {
                yj0.b().a(hk0Var, fk0Var, t);
            } else if (i != 3) {
            } else {
                xj0.b().a(hk0Var, fk0Var, t);
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
