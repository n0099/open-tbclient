package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.me;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes6.dex */
public class ne {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements me.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;
        public LinkedList<oe<?>> b;

        public a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i;
        }

        @Override // com.repackage.me
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // com.repackage.me.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.b.clear();
                this.b = null;
            }
        }

        @Override // com.repackage.me.a
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.b = new LinkedList<>();
            }
        }

        @Override // com.repackage.me
        public int getMaxSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a : invokeV.intValue;
        }

        @Override // com.repackage.me.a
        public String h(oe<?> oeVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, oeVar)) == null) {
                if (oeVar.f < System.currentTimeMillis()) {
                    return oeVar.a;
                }
                this.b.add(oeVar);
                String str = null;
                if (this.b.size() > getMaxSize()) {
                    long j = 0;
                    int i = -1;
                    for (int i2 = 0; i2 < this.b.size(); i2++) {
                        oe<?> oeVar2 = this.b.get(i2);
                        if (i == -1 || oeVar2.e < j) {
                            str = oeVar2.a;
                            j = oeVar2.e;
                            i = i2;
                        }
                    }
                    this.b.remove(i);
                }
                return str;
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements me.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;
        public HashMap<String, Long> b;

        public b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = new HashMap<>();
            this.a = i;
        }

        @Override // com.repackage.me
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // com.repackage.me.b
        public String d(oe<?> oeVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oeVar)) == null) {
                String i = i(oeVar.a);
                synchronized (this) {
                    this.b.put(oeVar.a, Long.valueOf(oeVar.e));
                }
                return i;
            }
            return (String) invokeL.objValue;
        }

        @Override // com.repackage.me.b
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        @Override // com.repackage.me.b
        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            }
        }

        @Override // com.repackage.me.b
        public String g(oe<?> oeVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, oeVar)) == null) {
                if (oeVar.f < System.currentTimeMillis()) {
                    return oeVar.a;
                }
                return d(oeVar);
            }
            return (String) invokeL.objValue;
        }

        @Override // com.repackage.me
        public int getMaxSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a : invokeV.intValue;
        }

        public String i(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                String str2 = null;
                if (!this.b.containsKey(str) && this.b.size() >= this.a) {
                    synchronized (this) {
                        long j = -1;
                        for (Map.Entry<String, Long> entry : this.b.entrySet()) {
                            long longValue = entry.getValue().longValue();
                            if (j == -1 || j > longValue) {
                                str2 = entry.getKey();
                                j = longValue;
                            }
                        }
                        if (str2 != null) {
                            this.b.remove(str2);
                        }
                    }
                    return str2;
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        @Override // com.repackage.me.b
        public void release() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                synchronized (this) {
                    this.b.clear();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements me {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.me
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.repackage.me
        public int getMaxSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 1;
            }
            return invokeV.intValue;
        }
    }

    public static me a(int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            if (z) {
                return new b(i);
            }
            return new a(i);
        }
        return (me) invokeCommon.objValue;
    }

    public static me b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new c() : (me) invokeV.objValue;
    }
}
