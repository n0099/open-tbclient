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
/* loaded from: classes7.dex */
public final class rc3 implements oc3, qc3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<pc3<?>, Set<b>> l;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Set a;
        public final /* synthetic */ Set b;

        public a(rc3 rc3Var, Set set, Set set2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rc3Var, set, set2};
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

    /* loaded from: classes7.dex */
    public interface b extends nf3<Set<pc3<?>>> {
    }

    /* loaded from: classes7.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public static final rc3 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-46878736, "Lcom/repackage/rc3$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-46878736, "Lcom/repackage/rc3$c;");
                    return;
                }
            }
            a = new rc3();
        }
    }

    public rc3() {
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

    public static rc3 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? c.a : (rc3) invokeV.objValue;
    }

    public final <T> boolean b(T... tArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, tArr)) == null) ? tArr == null || tArr.length < 1 : invokeL.booleanValue;
    }

    public rc3 c(Set<pc3<?>> set) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, set)) == null) {
            if (set.isEmpty()) {
                return this;
            }
            HashSet hashSet = new HashSet();
            synchronized (this.l) {
                for (pc3<?> pc3Var : set) {
                    hashSet.addAll(i(pc3Var));
                }
            }
            d(hashSet, set);
            return this;
        }
        return (rc3) invokeL.objValue;
    }

    public final rc3 d(Set<b> set, Set<pc3<?>> set2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, set, set2)) == null) {
            mu2.j().i(new a(this, set, set2));
            return this;
        }
        return (rc3) invokeLL.objValue;
    }

    public rc3 e(pc3<?>... pc3VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, pc3VarArr)) == null) {
            c(Sets.newHashSet(pc3VarArr));
            return this;
        }
        return (rc3) invokeL.objValue;
    }

    public rc3 f(nc3 nc3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, nc3Var)) == null) {
            String nc3Var2 = nc3Var == null ? "" : nc3Var.toString();
            if (oc3.a) {
                Log.i("Tracer-ErrCode", nc3Var2);
            }
            ux1.c("Tracer-ErrCode", nc3Var2);
            return this;
        }
        return (rc3) invokeL.objValue;
    }

    public rc3 g(b bVar, pc3<?>... pc3VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, bVar, pc3VarArr)) == null) {
            if (bVar != null) {
                synchronized (this.l) {
                    Set<pc3<?>> keySet = b(pc3VarArr) ? this.l.keySet() : Sets.newHashSet(pc3VarArr);
                    for (pc3<?> pc3Var : keySet) {
                        if (pc3Var != null) {
                            i(pc3Var).add(bVar);
                        }
                    }
                    d(Sets.newHashSet(bVar), keySet);
                }
            }
            return this;
        }
        return (rc3) invokeLL.objValue;
    }

    public rc3 h(pc3<?>... pc3VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, pc3VarArr)) == null) {
            synchronized (this.l) {
                for (pc3<?> pc3Var : pc3VarArr) {
                    if (!this.l.containsKey(pc3Var)) {
                        this.l.put(pc3Var, new HashSet());
                    }
                }
            }
            return this;
        }
        return (rc3) invokeL.objValue;
    }

    public final Set<b> i(@NonNull pc3<?> pc3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, pc3Var)) == null) {
            Set<b> set = this.l.get(pc3Var);
            if (set == null) {
                HashSet hashSet = new HashSet();
                this.l.put(pc3Var, hashSet);
                return hashSet;
            }
            return set;
        }
        return (Set) invokeL.objValue;
    }

    public rc3 j(b bVar, pc3<?>... pc3VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar, pc3VarArr)) == null) {
            if (bVar != null) {
                synchronized (this.l) {
                    for (pc3<?> pc3Var : b(pc3VarArr) ? this.l.keySet() : Sets.newHashSet(pc3VarArr)) {
                        if (pc3Var != null) {
                            i(pc3Var).remove(bVar);
                        }
                    }
                }
            }
            return this;
        }
        return (rc3) invokeLL.objValue;
    }
}
