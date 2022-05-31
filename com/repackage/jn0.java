package com.repackage;

import android.text.TextUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class jn0 {
    public static /* synthetic */ Interceptable $ic;
    public static rn0 a;
    public static rn0 b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755583035, "Lcom/repackage/jn0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755583035, "Lcom/repackage/jn0;");
        }
    }

    public jn0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static rn0 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (b == null) {
                synchronized (jn0.class) {
                    if (b == null) {
                        if (a == null) {
                            a = (rn0) ServiceManager.getService(rn0.a);
                        }
                        b = a;
                    }
                    if (b != null) {
                        return b;
                    }
                    if (TextUtils.equals("okhttp", "mixed")) {
                        b = b.b().a("okhttp");
                    } else {
                        b = hn0.a;
                    }
                }
            }
            return b;
        }
        return (rn0) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public pn0 a;
        public pn0 b;

        /* loaded from: classes6.dex */
        public class a implements rn0 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ pn0 b;

            public a(b bVar, pn0 pn0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, pn0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = pn0Var;
            }

            @Override // com.repackage.rn0
            public pn0 a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b : (pn0) invokeV.objValue;
            }
        }

        /* renamed from: com.repackage.jn0$b$b  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static class C0448b {
            public static /* synthetic */ Interceptable $ic;
            public static final b a;
            public transient /* synthetic */ FieldHolder $fh;

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2071703479, "Lcom/repackage/jn0$b$b;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(-2071703479, "Lcom/repackage/jn0$b$b;");
                        return;
                    }
                }
                a = new b(null);
            }
        }

        public b() {
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
            this.a = null;
            this.b = null;
        }

        public static b b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? C0448b.a : (b) invokeV.objValue;
        }

        public rn0 a(String str) {
            InterceptResult invokeL;
            char c;
            pn0 pn0Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                int hashCode = str.hashCode();
                if (hashCode != -1015101340) {
                    if (hashCode == 1544803905 && str.equals("default")) {
                        c = 0;
                    }
                    c = 65535;
                } else {
                    if (str.equals("okhttp")) {
                        c = 1;
                    }
                    c = 65535;
                }
                if (c == 0) {
                    if (this.a == null) {
                        synchronized (jn0.class) {
                            if (this.a == null) {
                                this.a = hn0.a.b(str);
                            }
                        }
                    }
                    pn0Var = this.a;
                } else if (c == 1) {
                    if (this.b == null) {
                        synchronized (jn0.class) {
                            if (this.b == null) {
                                this.b = hn0.a.b(str);
                            }
                        }
                    }
                    pn0Var = this.b;
                } else {
                    throw new IllegalStateException("Unexpected type:" + str);
                }
                return new a(this, pn0Var);
            }
            return (rn0) invokeL.objValue;
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }
}
