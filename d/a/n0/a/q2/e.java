package d.a.n0.a.q2;

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
public final class e implements d.a.n0.a.q2.b, d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<d.a.n0.a.q2.c<?>, Set<b>> l;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Set f46863e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Set f46864f;

        public a(e eVar, Set set, Set set2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, set, set2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46863e = set;
            this.f46864f = set2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                for (b bVar : this.f46863e) {
                    bVar.onCallback(this.f46864f);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface b extends d.a.n0.a.v2.e1.b<Set<d.a.n0.a.q2.c<?>>> {
    }

    /* loaded from: classes7.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final e f46865a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-227044209, "Ld/a/n0/a/q2/e$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-227044209, "Ld/a/n0/a/q2/e$c;");
                    return;
                }
            }
            f46865a = new e();
        }
    }

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = new HashMap();
    }

    public static e a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? c.f46865a : (e) invokeV.objValue;
    }

    public final <T> boolean b(T... tArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, tArr)) == null) ? tArr == null || tArr.length < 1 : invokeL.booleanValue;
    }

    public e c(Set<d.a.n0.a.q2.c<?>> set) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, set)) == null) {
            if (set.isEmpty()) {
                return this;
            }
            HashSet hashSet = new HashSet();
            synchronized (this.l) {
                for (d.a.n0.a.q2.c<?> cVar : set) {
                    hashSet.addAll(i(cVar));
                }
            }
            d(hashSet, set);
            return this;
        }
        return (e) invokeL.objValue;
    }

    public final e d(Set<b> set, Set<d.a.n0.a.q2.c<?>> set2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, set, set2)) == null) {
            d.a.n0.a.r1.k.i.a.k().j(new a(this, set, set2));
            return this;
        }
        return (e) invokeLL.objValue;
    }

    public e e(d.a.n0.a.q2.c<?>... cVarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cVarArr)) == null) {
            c(Sets.newHashSet(cVarArr));
            return this;
        }
        return (e) invokeL.objValue;
    }

    public e f(d.a.n0.a.q2.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, aVar)) == null) {
            String aVar2 = aVar == null ? "" : aVar.toString();
            if (d.a.n0.a.q2.b.f46851a) {
                Log.i("Tracer-ErrCode", aVar2);
            }
            d.a.n0.a.e0.d.b("Tracer-ErrCode", aVar2);
            return this;
        }
        return (e) invokeL.objValue;
    }

    public e g(b bVar, d.a.n0.a.q2.c<?>... cVarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, bVar, cVarArr)) == null) {
            if (bVar != null) {
                synchronized (this.l) {
                    Set<d.a.n0.a.q2.c<?>> keySet = b(cVarArr) ? this.l.keySet() : Sets.newHashSet(cVarArr);
                    for (d.a.n0.a.q2.c<?> cVar : keySet) {
                        if (cVar != null) {
                            i(cVar).add(bVar);
                        }
                    }
                    d(Sets.newHashSet(bVar), keySet);
                }
            }
            return this;
        }
        return (e) invokeLL.objValue;
    }

    public e h(d.a.n0.a.q2.c<?>... cVarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, cVarArr)) == null) {
            synchronized (this.l) {
                for (d.a.n0.a.q2.c<?> cVar : cVarArr) {
                    if (!this.l.containsKey(cVar)) {
                        this.l.put(cVar, new HashSet());
                    }
                }
            }
            return this;
        }
        return (e) invokeL.objValue;
    }

    public final Set<b> i(@NonNull d.a.n0.a.q2.c<?> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, cVar)) == null) {
            Set<b> set = this.l.get(cVar);
            if (set == null) {
                HashSet hashSet = new HashSet();
                this.l.put(cVar, hashSet);
                return hashSet;
            }
            return set;
        }
        return (Set) invokeL.objValue;
    }

    public e j(b bVar, d.a.n0.a.q2.c<?>... cVarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar, cVarArr)) == null) {
            if (bVar != null) {
                synchronized (this.l) {
                    for (d.a.n0.a.q2.c<?> cVar : b(cVarArr) ? this.l.keySet() : Sets.newHashSet(cVarArr)) {
                        if (cVar != null) {
                            i(cVar).remove(bVar);
                        }
                    }
                }
            }
            return this;
        }
        return (e) invokeLL.objValue;
    }
}
