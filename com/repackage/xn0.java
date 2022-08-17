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
/* loaded from: classes7.dex */
public class xn0 {
    public static /* synthetic */ Interceptable $ic;
    public static fo0 a;
    public static fo0 b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755165961, "Lcom/repackage/xn0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755165961, "Lcom/repackage/xn0;");
        }
    }

    public xn0() {
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

    public static fo0 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (b == null) {
                synchronized (xn0.class) {
                    if (b == null) {
                        if (a == null) {
                            a = (fo0) ServiceManager.getService(fo0.a);
                        }
                        b = a;
                    }
                    if (b != null) {
                        return b;
                    }
                    if (TextUtils.equals("okhttp", "mixed")) {
                        b = b.b().a("okhttp");
                    } else {
                        b = vn0.a;
                    }
                }
            }
            return b;
        }
        return (fo0) invokeV.objValue;
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public do0 a;
        public do0 b;

        /* loaded from: classes7.dex */
        public class a implements fo0 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ do0 b;

            public a(b bVar, do0 do0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, do0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = do0Var;
            }

            @Override // com.repackage.fo0
            public do0 a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b : (do0) invokeV.objValue;
            }
        }

        /* renamed from: com.repackage.xn0$b$b  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public static class C0620b {
            public static /* synthetic */ Interceptable $ic;
            public static final b a;
            public transient /* synthetic */ FieldHolder $fh;

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(852804731, "Lcom/repackage/xn0$b$b;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(852804731, "Lcom/repackage/xn0$b$b;");
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
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? C0620b.a : (b) invokeV.objValue;
        }

        public fo0 a(String str) {
            InterceptResult invokeL;
            char c;
            do0 do0Var;
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
                        synchronized (xn0.class) {
                            if (this.a == null) {
                                this.a = vn0.a.b(str);
                            }
                        }
                    }
                    do0Var = this.a;
                } else if (c == 1) {
                    if (this.b == null) {
                        synchronized (xn0.class) {
                            if (this.b == null) {
                                this.b = vn0.a.b(str);
                            }
                        }
                    }
                    do0Var = this.b;
                } else {
                    throw new IllegalStateException("Unexpected type:" + str);
                }
                return new a(this, do0Var);
            }
            return (fo0) invokeL.objValue;
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }
}
