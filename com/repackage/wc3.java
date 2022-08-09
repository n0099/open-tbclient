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
public final class wc3 implements tc3, vc3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<uc3<?>, Set<b>> l;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Set a;
        public final /* synthetic */ Set b;

        public a(wc3 wc3Var, Set set, Set set2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wc3Var, set, set2};
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

    /* loaded from: classes7.dex */
    public interface b extends sf3<Set<uc3<?>>> {
    }

    /* loaded from: classes7.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public static final wc3 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(96267019, "Lcom/repackage/wc3$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(96267019, "Lcom/repackage/wc3$c;");
                    return;
                }
            }
            a = new wc3();
        }
    }

    public wc3() {
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

    public static wc3 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? c.a : (wc3) invokeV.objValue;
    }

    public final <T> boolean b(T... tArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, tArr)) == null) ? tArr == null || tArr.length < 1 : invokeL.booleanValue;
    }

    public wc3 c(Set<uc3<?>> set) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, set)) == null) {
            if (set.isEmpty()) {
                return this;
            }
            HashSet hashSet = new HashSet();
            synchronized (this.l) {
                for (uc3<?> uc3Var : set) {
                    hashSet.addAll(i(uc3Var));
                }
            }
            d(hashSet, set);
            return this;
        }
        return (wc3) invokeL.objValue;
    }

    public final wc3 d(Set<b> set, Set<uc3<?>> set2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, set, set2)) == null) {
            ru2.j().i(new a(this, set, set2));
            return this;
        }
        return (wc3) invokeLL.objValue;
    }

    public wc3 e(uc3<?>... uc3VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, uc3VarArr)) == null) {
            c(Sets.newHashSet(uc3VarArr));
            return this;
        }
        return (wc3) invokeL.objValue;
    }

    public wc3 f(sc3 sc3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, sc3Var)) == null) {
            String sc3Var2 = sc3Var == null ? "" : sc3Var.toString();
            if (tc3.a) {
                Log.i("Tracer-ErrCode", sc3Var2);
            }
            zx1.c("Tracer-ErrCode", sc3Var2);
            return this;
        }
        return (wc3) invokeL.objValue;
    }

    public wc3 g(b bVar, uc3<?>... uc3VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, bVar, uc3VarArr)) == null) {
            if (bVar != null) {
                synchronized (this.l) {
                    Set<uc3<?>> keySet = b(uc3VarArr) ? this.l.keySet() : Sets.newHashSet(uc3VarArr);
                    for (uc3<?> uc3Var : keySet) {
                        if (uc3Var != null) {
                            i(uc3Var).add(bVar);
                        }
                    }
                    d(Sets.newHashSet(bVar), keySet);
                }
            }
            return this;
        }
        return (wc3) invokeLL.objValue;
    }

    public wc3 h(uc3<?>... uc3VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, uc3VarArr)) == null) {
            synchronized (this.l) {
                for (uc3<?> uc3Var : uc3VarArr) {
                    if (!this.l.containsKey(uc3Var)) {
                        this.l.put(uc3Var, new HashSet());
                    }
                }
            }
            return this;
        }
        return (wc3) invokeL.objValue;
    }

    public final Set<b> i(@NonNull uc3<?> uc3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, uc3Var)) == null) {
            Set<b> set = this.l.get(uc3Var);
            if (set == null) {
                HashSet hashSet = new HashSet();
                this.l.put(uc3Var, hashSet);
                return hashSet;
            }
            return set;
        }
        return (Set) invokeL.objValue;
    }

    public wc3 j(b bVar, uc3<?>... uc3VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar, uc3VarArr)) == null) {
            if (bVar != null) {
                synchronized (this.l) {
                    for (uc3<?> uc3Var : b(uc3VarArr) ? this.l.keySet() : Sets.newHashSet(uc3VarArr)) {
                        if (uc3Var != null) {
                            i(uc3Var).remove(bVar);
                        }
                    }
                }
            }
            return this;
        }
        return (wc3) invokeLL.objValue;
    }
}
