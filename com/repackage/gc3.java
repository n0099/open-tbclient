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
public final class gc3 implements dc3, fc3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<ec3<?>, Set<b>> l;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Set a;
        public final /* synthetic */ Set b;

        public a(gc3 gc3Var, Set set, Set set2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gc3Var, set, set2};
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

    /* loaded from: classes6.dex */
    public interface b extends cf3<Set<ec3<?>>> {
    }

    /* loaded from: classes6.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public static final gc3 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-361799397, "Lcom/repackage/gc3$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-361799397, "Lcom/repackage/gc3$c;");
                    return;
                }
            }
            a = new gc3();
        }
    }

    public gc3() {
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

    public static gc3 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? c.a : (gc3) invokeV.objValue;
    }

    public final <T> boolean b(T... tArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, tArr)) == null) ? tArr == null || tArr.length < 1 : invokeL.booleanValue;
    }

    public gc3 c(Set<ec3<?>> set) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, set)) == null) {
            if (set.isEmpty()) {
                return this;
            }
            HashSet hashSet = new HashSet();
            synchronized (this.l) {
                for (ec3<?> ec3Var : set) {
                    hashSet.addAll(i(ec3Var));
                }
            }
            d(hashSet, set);
            return this;
        }
        return (gc3) invokeL.objValue;
    }

    public final gc3 d(Set<b> set, Set<ec3<?>> set2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, set, set2)) == null) {
            bu2.j().i(new a(this, set, set2));
            return this;
        }
        return (gc3) invokeLL.objValue;
    }

    public gc3 e(ec3<?>... ec3VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, ec3VarArr)) == null) {
            c(Sets.newHashSet(ec3VarArr));
            return this;
        }
        return (gc3) invokeL.objValue;
    }

    public gc3 f(cc3 cc3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, cc3Var)) == null) {
            String cc3Var2 = cc3Var == null ? "" : cc3Var.toString();
            if (dc3.a) {
                Log.i("Tracer-ErrCode", cc3Var2);
            }
            jx1.c("Tracer-ErrCode", cc3Var2);
            return this;
        }
        return (gc3) invokeL.objValue;
    }

    public gc3 g(b bVar, ec3<?>... ec3VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, bVar, ec3VarArr)) == null) {
            if (bVar != null) {
                synchronized (this.l) {
                    Set<ec3<?>> keySet = b(ec3VarArr) ? this.l.keySet() : Sets.newHashSet(ec3VarArr);
                    for (ec3<?> ec3Var : keySet) {
                        if (ec3Var != null) {
                            i(ec3Var).add(bVar);
                        }
                    }
                    d(Sets.newHashSet(bVar), keySet);
                }
            }
            return this;
        }
        return (gc3) invokeLL.objValue;
    }

    public gc3 h(ec3<?>... ec3VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, ec3VarArr)) == null) {
            synchronized (this.l) {
                for (ec3<?> ec3Var : ec3VarArr) {
                    if (!this.l.containsKey(ec3Var)) {
                        this.l.put(ec3Var, new HashSet());
                    }
                }
            }
            return this;
        }
        return (gc3) invokeL.objValue;
    }

    public final Set<b> i(@NonNull ec3<?> ec3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, ec3Var)) == null) {
            Set<b> set = this.l.get(ec3Var);
            if (set == null) {
                HashSet hashSet = new HashSet();
                this.l.put(ec3Var, hashSet);
                return hashSet;
            }
            return set;
        }
        return (Set) invokeL.objValue;
    }

    public gc3 j(b bVar, ec3<?>... ec3VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar, ec3VarArr)) == null) {
            if (bVar != null) {
                synchronized (this.l) {
                    for (ec3<?> ec3Var : b(ec3VarArr) ? this.l.keySet() : Sets.newHashSet(ec3VarArr)) {
                        if (ec3Var != null) {
                            i(ec3Var).remove(bVar);
                        }
                    }
                }
            }
            return this;
        }
        return (gc3) invokeLL.objValue;
    }
}
