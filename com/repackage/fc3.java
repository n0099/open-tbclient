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
public final class fc3 implements cc3, ec3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<dc3<?>, Set<b>> l;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Set a;
        public final /* synthetic */ Set b;

        public a(fc3 fc3Var, Set set, Set set2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fc3Var, set, set2};
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
    public interface b extends bf3<Set<dc3<?>>> {
    }

    /* loaded from: classes6.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public static final fc3 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-390428548, "Lcom/repackage/fc3$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-390428548, "Lcom/repackage/fc3$c;");
                    return;
                }
            }
            a = new fc3();
        }
    }

    public fc3() {
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

    public static fc3 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? c.a : (fc3) invokeV.objValue;
    }

    public final <T> boolean b(T... tArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, tArr)) == null) ? tArr == null || tArr.length < 1 : invokeL.booleanValue;
    }

    public fc3 c(Set<dc3<?>> set) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, set)) == null) {
            if (set.isEmpty()) {
                return this;
            }
            HashSet hashSet = new HashSet();
            synchronized (this.l) {
                for (dc3<?> dc3Var : set) {
                    hashSet.addAll(i(dc3Var));
                }
            }
            d(hashSet, set);
            return this;
        }
        return (fc3) invokeL.objValue;
    }

    public final fc3 d(Set<b> set, Set<dc3<?>> set2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, set, set2)) == null) {
            au2.j().i(new a(this, set, set2));
            return this;
        }
        return (fc3) invokeLL.objValue;
    }

    public fc3 e(dc3<?>... dc3VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, dc3VarArr)) == null) {
            c(Sets.newHashSet(dc3VarArr));
            return this;
        }
        return (fc3) invokeL.objValue;
    }

    public fc3 f(bc3 bc3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bc3Var)) == null) {
            String bc3Var2 = bc3Var == null ? "" : bc3Var.toString();
            if (cc3.a) {
                Log.i("Tracer-ErrCode", bc3Var2);
            }
            ix1.c("Tracer-ErrCode", bc3Var2);
            return this;
        }
        return (fc3) invokeL.objValue;
    }

    public fc3 g(b bVar, dc3<?>... dc3VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, bVar, dc3VarArr)) == null) {
            if (bVar != null) {
                synchronized (this.l) {
                    Set<dc3<?>> keySet = b(dc3VarArr) ? this.l.keySet() : Sets.newHashSet(dc3VarArr);
                    for (dc3<?> dc3Var : keySet) {
                        if (dc3Var != null) {
                            i(dc3Var).add(bVar);
                        }
                    }
                    d(Sets.newHashSet(bVar), keySet);
                }
            }
            return this;
        }
        return (fc3) invokeLL.objValue;
    }

    public fc3 h(dc3<?>... dc3VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, dc3VarArr)) == null) {
            synchronized (this.l) {
                for (dc3<?> dc3Var : dc3VarArr) {
                    if (!this.l.containsKey(dc3Var)) {
                        this.l.put(dc3Var, new HashSet());
                    }
                }
            }
            return this;
        }
        return (fc3) invokeL.objValue;
    }

    public final Set<b> i(@NonNull dc3<?> dc3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, dc3Var)) == null) {
            Set<b> set = this.l.get(dc3Var);
            if (set == null) {
                HashSet hashSet = new HashSet();
                this.l.put(dc3Var, hashSet);
                return hashSet;
            }
            return set;
        }
        return (Set) invokeL.objValue;
    }

    public fc3 j(b bVar, dc3<?>... dc3VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar, dc3VarArr)) == null) {
            if (bVar != null) {
                synchronized (this.l) {
                    for (dc3<?> dc3Var : b(dc3VarArr) ? this.l.keySet() : Sets.newHashSet(dc3VarArr)) {
                        if (dc3Var != null) {
                            i(dc3Var).remove(bVar);
                        }
                    }
                }
            }
            return this;
        }
        return (fc3) invokeLL.objValue;
    }
}
