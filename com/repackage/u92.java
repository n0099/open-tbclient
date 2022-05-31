package com.repackage;

import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class u92 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static volatile u92 b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements ae3<Exception> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ae3 a;
        public final /* synthetic */ int b;

        /* renamed from: com.repackage.u92$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0532a implements ae3<Exception> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0532a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.repackage.ae3
            /* renamed from: a */
            public void onCallback(Exception exc) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                    hw1.l("SwanAppCoresManager", "ensureSwanCore: update swan-js finish. ", exc);
                    ae3 ae3Var = this.a.a;
                    if (ae3Var != null) {
                        ae3Var.onCallback(exc);
                    }
                }
            }
        }

        public a(u92 u92Var, ae3 ae3Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u92Var, ae3Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ae3Var;
            this.b = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ae3
        /* renamed from: a */
        public void onCallback(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                if (exc == null) {
                    hw1.k("SwanAppCoresManager", "ensureSwanCore: done by update preset ");
                    ae3 ae3Var = this.a;
                    if (ae3Var != null) {
                        ae3Var.onCallback(null);
                        return;
                    }
                    return;
                }
                hw1.k("SwanAppCoresManager", "ensureSwanCore: update preset failed ");
                m83.o(this.b, new C0532a(this));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements ae3<Exception> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ae3 a;
        public final /* synthetic */ int b;

        /* loaded from: classes7.dex */
        public class a implements ae3<Exception> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.repackage.ae3
            /* renamed from: a */
            public void onCallback(Exception exc) {
                ae3 ae3Var;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, exc) == null) || (ae3Var = this.a.a) == null) {
                    return;
                }
                ae3Var.onCallback(exc);
            }
        }

        public b(u92 u92Var, ae3 ae3Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u92Var, ae3Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ae3Var;
            this.b = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ae3
        /* renamed from: a */
        public void onCallback(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                if (exc != null) {
                    ae3 ae3Var = this.a;
                    if (ae3Var != null) {
                        ae3Var.onCallback(exc);
                        return;
                    }
                    return;
                }
                q92.h(this.b, new a(this));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u92 a;

        public c(u92 u92Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u92Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u92Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755306205, "Lcom/repackage/u92;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755306205, "Lcom/repackage/u92;");
                return;
            }
        }
        a = rf1.a;
    }

    public u92() {
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

    public static u92 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (b == null) {
                synchronized (u92.class) {
                    if (b == null) {
                        b = new u92();
                    }
                }
            }
            return b;
        }
        return (u92) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            q83.b().e(null, 0);
            q83.b().e(null, 1);
            q92.h(0, null);
            q92.h(1, null);
        }
    }

    public void c(@Nullable ae3<Exception> ae3Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ae3Var, i) == null) {
            hw1.k("SwanAppCoresManager", "ensureSwanCore: invoke frameType = " + i);
            g(new a(this, ae3Var, i), i);
        }
    }

    public void e(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            if (a) {
                Log.d("SwanAppCoresManager", "onAppUpgrade oldVersion: " + i + " ,newVersion: " + i2);
            }
            m83.l(i, i2);
            q92.g(i, i2);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ExecutorUtilsExt.postOnElastic(new c(this), "tryUpdateAllPresetCoresAsync", 2);
        }
    }

    public final void g(@Nullable ae3<Exception> ae3Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, ae3Var, i) == null) {
            q83.b().e(new b(this, ae3Var, i), i);
        }
    }
}
