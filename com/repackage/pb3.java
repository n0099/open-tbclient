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
/* loaded from: classes6.dex */
public final class pb3 implements mb3, ob3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<nb3<?>, Set<b>> l;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Set a;
        public final /* synthetic */ Set b;

        public a(pb3 pb3Var, Set set, Set set2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pb3Var, set, set2};
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
                    bVar.a(this.b);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface b extends le3<Set<nb3<?>>> {
    }

    /* loaded from: classes6.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public static final pb3 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-105060559, "Lcom/repackage/pb3$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-105060559, "Lcom/repackage/pb3$c;");
                    return;
                }
            }
            a = new pb3();
        }
    }

    public pb3() {
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

    public static pb3 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? c.a : (pb3) invokeV.objValue;
    }

    public final <T> boolean b(T... tArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, tArr)) == null) ? tArr == null || tArr.length < 1 : invokeL.booleanValue;
    }

    public pb3 c(Set<nb3<?>> set) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, set)) == null) {
            if (set.isEmpty()) {
                return this;
            }
            HashSet hashSet = new HashSet();
            synchronized (this.l) {
                for (nb3<?> nb3Var : set) {
                    hashSet.addAll(i(nb3Var));
                }
            }
            d(hashSet, set);
            return this;
        }
        return (pb3) invokeL.objValue;
    }

    public final pb3 d(Set<b> set, Set<nb3<?>> set2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, set, set2)) == null) {
            kt2.j().i(new a(this, set, set2));
            return this;
        }
        return (pb3) invokeLL.objValue;
    }

    public pb3 e(nb3<?>... nb3VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, nb3VarArr)) == null) {
            c(Sets.newHashSet(nb3VarArr));
            return this;
        }
        return (pb3) invokeL.objValue;
    }

    public pb3 f(lb3 lb3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, lb3Var)) == null) {
            String lb3Var2 = lb3Var == null ? "" : lb3Var.toString();
            if (mb3.a) {
                Log.i("Tracer-ErrCode", lb3Var2);
            }
            sw1.c("Tracer-ErrCode", lb3Var2);
            return this;
        }
        return (pb3) invokeL.objValue;
    }

    public pb3 g(b bVar, nb3<?>... nb3VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, bVar, nb3VarArr)) == null) {
            if (bVar != null) {
                synchronized (this.l) {
                    Set<nb3<?>> keySet = b(nb3VarArr) ? this.l.keySet() : Sets.newHashSet(nb3VarArr);
                    for (nb3<?> nb3Var : keySet) {
                        if (nb3Var != null) {
                            i(nb3Var).add(bVar);
                        }
                    }
                    d(Sets.newHashSet(bVar), keySet);
                }
            }
            return this;
        }
        return (pb3) invokeLL.objValue;
    }

    public pb3 h(nb3<?>... nb3VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, nb3VarArr)) == null) {
            synchronized (this.l) {
                for (nb3<?> nb3Var : nb3VarArr) {
                    if (!this.l.containsKey(nb3Var)) {
                        this.l.put(nb3Var, new HashSet());
                    }
                }
            }
            return this;
        }
        return (pb3) invokeL.objValue;
    }

    public final Set<b> i(@NonNull nb3<?> nb3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, nb3Var)) == null) {
            Set<b> set = this.l.get(nb3Var);
            if (set == null) {
                HashSet hashSet = new HashSet();
                this.l.put(nb3Var, hashSet);
                return hashSet;
            }
            return set;
        }
        return (Set) invokeL.objValue;
    }

    public pb3 j(b bVar, nb3<?>... nb3VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar, nb3VarArr)) == null) {
            if (bVar != null) {
                synchronized (this.l) {
                    for (nb3<?> nb3Var : b(nb3VarArr) ? this.l.keySet() : Sets.newHashSet(nb3VarArr)) {
                        if (nb3Var != null) {
                            i(nb3Var).remove(bVar);
                        }
                    }
                }
            }
            return this;
        }
        return (pb3) invokeLL.objValue;
    }
}
