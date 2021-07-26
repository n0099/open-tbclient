package d.a.d.e.d;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.d.e;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes7.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements e.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final int f41605a;

        /* renamed from: b  reason: collision with root package name */
        public LinkedList<g<?>> f41606b;

        public a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41605a = i2;
        }

        @Override // d.a.d.e.d.e
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // d.a.d.e.d.e.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f41606b.clear();
                this.f41606b = null;
            }
        }

        @Override // d.a.d.e.d.e.a
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f41606b = new LinkedList<>();
            }
        }

        @Override // d.a.d.e.d.e
        public int getMaxSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f41605a : invokeV.intValue;
        }

        @Override // d.a.d.e.d.e.a
        public String h(g<?> gVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, gVar)) == null) {
                if (gVar.f41614f < System.currentTimeMillis()) {
                    return gVar.f41609a;
                }
                this.f41606b.add(gVar);
                String str = null;
                if (this.f41606b.size() > getMaxSize()) {
                    long j = 0;
                    int i2 = -1;
                    for (int i3 = 0; i3 < this.f41606b.size(); i3++) {
                        g<?> gVar2 = this.f41606b.get(i3);
                        if (i2 == -1 || gVar2.f41613e < j) {
                            str = gVar2.f41609a;
                            j = gVar2.f41613e;
                            i2 = i3;
                        }
                    }
                    this.f41606b.remove(i2);
                }
                return str;
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements e.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final int f41607a;

        /* renamed from: b  reason: collision with root package name */
        public HashMap<String, Long> f41608b;

        public b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41608b = new HashMap<>();
            this.f41607a = i2;
        }

        @Override // d.a.d.e.d.e
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // d.a.d.e.d.e.b
        public String d(g<?> gVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar)) == null) {
                String i2 = i(gVar.f41609a);
                synchronized (this) {
                    this.f41608b.put(gVar.f41609a, Long.valueOf(gVar.f41613e));
                }
                return i2;
            }
            return (String) invokeL.objValue;
        }

        @Override // d.a.d.e.d.e.b
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        @Override // d.a.d.e.d.e.b
        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            }
        }

        @Override // d.a.d.e.d.e.b
        public String g(g<?> gVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, gVar)) == null) {
                if (gVar.f41614f < System.currentTimeMillis()) {
                    return gVar.f41609a;
                }
                return d(gVar);
            }
            return (String) invokeL.objValue;
        }

        @Override // d.a.d.e.d.e
        public int getMaxSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f41607a : invokeV.intValue;
        }

        public String i(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                String str2 = null;
                if (!this.f41608b.containsKey(str) && this.f41608b.size() >= this.f41607a) {
                    synchronized (this) {
                        long j = -1;
                        for (Map.Entry<String, Long> entry : this.f41608b.entrySet()) {
                            long longValue = entry.getValue().longValue();
                            if (j == -1 || j > longValue) {
                                str2 = entry.getKey();
                                j = longValue;
                            }
                        }
                        if (str2 != null) {
                            this.f41608b.remove(str2);
                        }
                    }
                    return str2;
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        @Override // d.a.d.e.d.e.b
        public void release() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                synchronized (this) {
                    this.f41608b.clear();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // d.a.d.e.d.e
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // d.a.d.e.d.e
        public int getMaxSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 1;
            }
            return invokeV.intValue;
        }
    }

    public static e a(int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (z) {
                return new b(i2);
            }
            return new a(i2);
        }
        return (e) invokeCommon.objValue;
    }

    public static e b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new c() : (e) invokeV.objValue;
    }
}
