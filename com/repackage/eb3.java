package com.repackage;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Sets;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes5.dex */
public final class eb3 implements bb3, db3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<cb3<?>, Set<b>> l;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Set a;
        public final /* synthetic */ Set b;

        public a(eb3 eb3Var, Set set, Set set2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eb3Var, set, set2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = set;
            this.b = set2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                for (b bVar : this.a) {
                    bVar.onCallback(this.b);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b extends ae3<Set<cb3<?>>> {
    }

    /* loaded from: classes5.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public static final eb3 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-419981220, "Lcom/repackage/eb3$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-419981220, "Lcom/repackage/eb3$c;");
                    return;
                }
            }
            a = new eb3();
        }
    }

    public eb3() {
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
        this.l = new HashMap();
    }

    public static eb3 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? c.a : (eb3) invokeV.objValue;
    }

    public final <T> boolean b(T... tArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, tArr)) == null) ? tArr == null || tArr.length < 1 : invokeL.booleanValue;
    }

    public eb3 c(Set<cb3<?>> set) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, set)) == null) {
            if (set.isEmpty()) {
                return this;
            }
            HashSet hashSet = new HashSet();
            synchronized (this.l) {
                for (cb3<?> cb3Var : set) {
                    hashSet.addAll(i(cb3Var));
                }
            }
            d(hashSet, set);
            return this;
        }
        return (eb3) invokeL.objValue;
    }

    public final eb3 d(Set<b> set, Set<cb3<?>> set2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, set, set2)) == null) {
            zs2.j().i(new a(this, set, set2));
            return this;
        }
        return (eb3) invokeLL.objValue;
    }

    public eb3 e(cb3<?>... cb3VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cb3VarArr)) == null) {
            c(Sets.newHashSet(cb3VarArr));
            return this;
        }
        return (eb3) invokeL.objValue;
    }

    public eb3 f(ab3 ab3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, ab3Var)) == null) {
            String ab3Var2 = ab3Var == null ? "" : ab3Var.toString();
            if (bb3.a) {
                Log.i("Tracer-ErrCode", ab3Var2);
            }
            hw1.c("Tracer-ErrCode", ab3Var2);
            return this;
        }
        return (eb3) invokeL.objValue;
    }

    public eb3 g(b bVar, cb3<?>... cb3VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, bVar, cb3VarArr)) == null) {
            if (bVar != null) {
                synchronized (this.l) {
                    Set<cb3<?>> keySet = b(cb3VarArr) ? this.l.keySet() : Sets.newHashSet(cb3VarArr);
                    for (cb3<?> cb3Var : keySet) {
                        if (cb3Var != null) {
                            i(cb3Var).add(bVar);
                        }
                    }
                    d(Sets.newHashSet(bVar), keySet);
                }
            }
            return this;
        }
        return (eb3) invokeLL.objValue;
    }

    public eb3 h(cb3<?>... cb3VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, cb3VarArr)) == null) {
            synchronized (this.l) {
                for (cb3<?> cb3Var : cb3VarArr) {
                    if (!this.l.containsKey(cb3Var)) {
                        this.l.put(cb3Var, new HashSet());
                    }
                }
            }
            return this;
        }
        return (eb3) invokeL.objValue;
    }

    public final Set<b> i(@NonNull cb3<?> cb3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, cb3Var)) == null) {
            Set<b> set = this.l.get(cb3Var);
            if (set == null) {
                HashSet hashSet = new HashSet();
                this.l.put(cb3Var, hashSet);
                return hashSet;
            }
            return set;
        }
        return (Set) invokeL.objValue;
    }

    public eb3 j(b bVar, cb3<?>... cb3VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar, cb3VarArr)) == null) {
            if (bVar != null) {
                synchronized (this.l) {
                    for (cb3<?> cb3Var : b(cb3VarArr) ? this.l.keySet() : Sets.newHashSet(cb3VarArr)) {
                        if (cb3Var != null) {
                            i(cb3Var).remove(bVar);
                        }
                    }
                }
            }
            return this;
        }
        return (eb3) invokeLL.objValue;
    }
}
