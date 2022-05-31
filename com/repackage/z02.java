package com.repackage;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import com.baidu.swan.apps.jsbridge.SwanAppJsBridge;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.w62;
/* loaded from: classes7.dex */
public class z02 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public transient /* synthetic */ FieldHolder $fh;
    public p62 a;
    public z62 b;

    /* loaded from: classes7.dex */
    public class a extends l72 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public final /* synthetic */ z02 c;

        public a(@NonNull z02 z02Var, @NonNull String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z02Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = z02Var;
            this.a = str;
            this.b = str2;
            if (z02.c) {
                Log.d("SwanAppV8Daemon", "basePath: " + str + ", jsFile: " + str2);
            }
        }

        @Override // com.repackage.m72
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b : (String) invokeV.objValue;
        }

        @Override // com.repackage.l72, com.repackage.m72
        @Nullable
        public V8EngineConfiguration.CodeCacheSetting b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? super.b() : (V8EngineConfiguration.CodeCacheSetting) invokeV.objValue;
        }

        @Override // com.repackage.l72, com.repackage.m72
        public void c(p62 p62Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, p62Var) == null) {
                if (this.c.b != null) {
                    this.c.b.a(p62Var);
                }
                p62Var.A0();
            }
        }

        @Override // com.repackage.l72, com.repackage.m72
        public void d(p62 p62Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, p62Var) == null) {
                super.d(p62Var);
            }
        }

        @Override // com.repackage.m72
        public String getInitBasePath() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a : (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755165899, "Lcom/repackage/z02;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755165899, "Lcom/repackage/z02;");
                return;
            }
        }
        c = rf1.a;
    }

    public z02(@NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = v62.b(c(), new a(this, str, str2), null);
        this.a.addJavascriptInterface(new y02(this.a), SwanAppJsBridge.JAVASCRIPT_INTERFACE_NAME);
    }

    public final w62 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            w62.b bVar = new w62.b();
            bVar.c(3);
            bVar.b(x02.b());
            return bVar.a();
        }
        return (w62) invokeV.objValue;
    }

    public p62 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (p62) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            p62 p62Var = this.a;
            if (p62Var != null) {
                p62Var.V();
                this.a = null;
            }
            this.b = null;
        }
    }

    public void f(z62 z62Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, z62Var) == null) {
            this.b = z62Var;
        }
    }
}
