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
public final class ec3 implements bc3, dc3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<cc3<?>, Set<b>> l;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Set a;
        public final /* synthetic */ Set b;

        public a(ec3 ec3Var, Set set, Set set2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ec3Var, set, set2};
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
    public interface b extends af3<Set<cc3<?>>> {
    }

    /* loaded from: classes6.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public static final ec3 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-419057699, "Lcom/repackage/ec3$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-419057699, "Lcom/repackage/ec3$c;");
                    return;
                }
            }
            a = new ec3();
        }
    }

    public ec3() {
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

    public static ec3 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? c.a : (ec3) invokeV.objValue;
    }

    public final <T> boolean b(T... tArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, tArr)) == null) ? tArr == null || tArr.length < 1 : invokeL.booleanValue;
    }

    public ec3 c(Set<cc3<?>> set) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, set)) == null) {
            if (set.isEmpty()) {
                return this;
            }
            HashSet hashSet = new HashSet();
            synchronized (this.l) {
                for (cc3<?> cc3Var : set) {
                    hashSet.addAll(i(cc3Var));
                }
            }
            d(hashSet, set);
            return this;
        }
        return (ec3) invokeL.objValue;
    }

    public final ec3 d(Set<b> set, Set<cc3<?>> set2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, set, set2)) == null) {
            zt2.j().i(new a(this, set, set2));
            return this;
        }
        return (ec3) invokeLL.objValue;
    }

    public ec3 e(cc3<?>... cc3VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cc3VarArr)) == null) {
            c(Sets.newHashSet(cc3VarArr));
            return this;
        }
        return (ec3) invokeL.objValue;
    }

    public ec3 f(ac3 ac3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, ac3Var)) == null) {
            String ac3Var2 = ac3Var == null ? "" : ac3Var.toString();
            if (bc3.a) {
                Log.i("Tracer-ErrCode", ac3Var2);
            }
            hx1.c("Tracer-ErrCode", ac3Var2);
            return this;
        }
        return (ec3) invokeL.objValue;
    }

    public ec3 g(b bVar, cc3<?>... cc3VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, bVar, cc3VarArr)) == null) {
            if (bVar != null) {
                synchronized (this.l) {
                    Set<cc3<?>> keySet = b(cc3VarArr) ? this.l.keySet() : Sets.newHashSet(cc3VarArr);
                    for (cc3<?> cc3Var : keySet) {
                        if (cc3Var != null) {
                            i(cc3Var).add(bVar);
                        }
                    }
                    d(Sets.newHashSet(bVar), keySet);
                }
            }
            return this;
        }
        return (ec3) invokeLL.objValue;
    }

    public ec3 h(cc3<?>... cc3VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, cc3VarArr)) == null) {
            synchronized (this.l) {
                for (cc3<?> cc3Var : cc3VarArr) {
                    if (!this.l.containsKey(cc3Var)) {
                        this.l.put(cc3Var, new HashSet());
                    }
                }
            }
            return this;
        }
        return (ec3) invokeL.objValue;
    }

    public final Set<b> i(@NonNull cc3<?> cc3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, cc3Var)) == null) {
            Set<b> set = this.l.get(cc3Var);
            if (set == null) {
                HashSet hashSet = new HashSet();
                this.l.put(cc3Var, hashSet);
                return hashSet;
            }
            return set;
        }
        return (Set) invokeL.objValue;
    }

    public ec3 j(b bVar, cc3<?>... cc3VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar, cc3VarArr)) == null) {
            if (bVar != null) {
                synchronized (this.l) {
                    for (cc3<?> cc3Var : b(cc3VarArr) ? this.l.keySet() : Sets.newHashSet(cc3VarArr)) {
                        if (cc3Var != null) {
                            i(cc3Var).remove(bVar);
                        }
                    }
                }
            }
            return this;
        }
        return (ec3) invokeLL.objValue;
    }
}
