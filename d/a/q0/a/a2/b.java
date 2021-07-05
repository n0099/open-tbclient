package d.a.q0.a.a2;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.a2.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public final class b implements d.a.q0.a.v2.e1.b<i.a> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f46664g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, d.a.q0.a.v2.e1.b<i.a>> f46665e;

    /* renamed from: f  reason: collision with root package name */
    public final List<d.a.q0.a.v2.e1.c<i.a, Boolean>> f46666f;

    /* loaded from: classes8.dex */
    public class a implements d.a.q0.a.v2.e1.b<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.v2.e1.b f46667e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f46668f;

        public a(b bVar, d.a.q0.a.v2.e1.b bVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, bVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46668f = bVar;
            this.f46667e = bVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || TextUtils.isEmpty(str)) {
                return;
            }
            this.f46668f.f46665e.put(str, this.f46667e);
        }
    }

    /* renamed from: d.a.q0.a.a2.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0683b implements d.a.q0.a.v2.e1.b<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f46669e;

        public C0683b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46669e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f46669e.f46665e.remove(str);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(110529822, "Ld/a/q0/a/a2/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(110529822, "Ld/a/q0/a/a2/b;");
                return;
            }
        }
        f46664g = d.a.q0.a.k.f49133a;
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f46665e = new HashMap();
        this.f46666f = new ArrayList();
    }

    public b b(d.a.q0.a.v2.e1.c<i.a, Boolean> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
            if (cVar != null) {
                this.f46666f.add(cVar);
            }
            return this;
        }
        return (b) invokeL.objValue;
    }

    public final boolean c(i.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
            if (aVar == null) {
                return false;
            }
            for (d.a.q0.a.v2.e1.c<i.a, Boolean> cVar : this.f46666f) {
                if (cVar != null && !cVar.a(aVar).booleanValue()) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.q0.a.v2.e1.b
    /* renamed from: d */
    public void onCallback(i.a aVar) {
        d.a.q0.a.v2.e1.b<i.a> bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            if (f46664g) {
                Log.i("EventHandler", "handle: " + aVar);
            }
            if (!c(aVar) || (bVar = this.f46665e.get(aVar.f46689f)) == null) {
                return;
            }
            bVar.onCallback(aVar);
        }
    }

    public b e(d.a.q0.a.v2.e1.b<i.a> bVar, String... strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, bVar, strArr)) == null) {
            if (bVar != null && strArr != null && strArr.length > 0) {
                d.a.q0.a.v2.e1.a.d(new a(this, bVar), strArr);
            }
            return this;
        }
        return (b) invokeLL.objValue;
    }

    public b f(String... strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, strArr)) == null) {
            if (strArr != null && strArr.length > 0) {
                d.a.q0.a.v2.e1.a.d(new C0683b(this), strArr);
            }
            return this;
        }
        return (b) invokeL.objValue;
    }
}
