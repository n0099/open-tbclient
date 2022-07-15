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
/* loaded from: classes5.dex */
public class ck0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<Class<?>, ArrayList<kk0>> a;
    public final ConcurrentHashMap<Object, ArrayList<kk0>> b;

    public ck0() {
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

    public final void a(@NonNull kk0 kk0Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, kk0Var) == null) {
            synchronized (this) {
                ArrayList<kk0> arrayList = this.a.get(kk0Var.b);
                boolean z2 = true;
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    this.a.put(kk0Var.b, arrayList);
                } else {
                    Iterator<kk0> it = arrayList.iterator();
                    while (it.hasNext()) {
                        if (it.next().a == kk0Var.a) {
                            z = true;
                            break;
                        }
                    }
                }
                z = false;
                if (!z) {
                    arrayList.add(kk0Var);
                }
                ArrayList<kk0> arrayList2 = this.b.get(kk0Var.a);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>();
                    this.b.put(kk0Var.a, arrayList2);
                } else {
                    Iterator<kk0> it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        if (it2.next().d == kk0Var.d) {
                            break;
                        }
                    }
                }
                z2 = false;
                if (!z2) {
                    arrayList2.add(kk0Var);
                }
            }
        }
    }

    public <T extends fk0> void b(@Nullable T t) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) || t == null) {
            return;
        }
        synchronized (this) {
            ArrayList<kk0> arrayList = this.a.get(t.getClass());
            if (arrayList != null) {
                Iterator<kk0> it = arrayList.iterator();
                while (it.hasNext()) {
                    kk0 next = it.next();
                    f(next, next.d, t);
                }
            }
        }
    }

    public <T extends fk0> void c(@NonNull Object obj, int i, @NonNull ik0<T> ik0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, obj, i, ik0Var) == null) {
            a(new kk0(i, obj, ik0Var.a(), ik0Var));
        }
    }

    public <T extends fk0> void d(@NonNull Object obj, @NonNull ik0<T> ik0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, obj, ik0Var) == null) {
            c(obj, 0, ik0Var);
        }
    }

    public final void e(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, obj) == null) {
            synchronized (this) {
                ArrayList<kk0> arrayList = this.b.get(obj);
                if (arrayList != null) {
                    Iterator<kk0> it = arrayList.iterator();
                    while (it.hasNext()) {
                        kk0 next = it.next();
                        ArrayList<kk0> arrayList2 = this.a.get(next.b);
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

    public final <T extends fk0> void f(kk0 kk0Var, ik0<T> ik0Var, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, kk0Var, ik0Var, t) == null) {
            int i = kk0Var.c;
            if (i == 0) {
                ik0Var.onEvent(t);
            } else if (i == 1) {
                jk0.b().a(kk0Var, ik0Var, t);
            } else if (i == 2) {
                bk0.b().a(kk0Var, ik0Var, t);
            } else if (i != 3) {
            } else {
                ak0.b().a(kk0Var, ik0Var, t);
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
