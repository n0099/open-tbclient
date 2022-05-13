package com.repackage;

import android.app.Activity;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.AnyThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JsCodeCacheCallback;
import com.baidu.searchbox.v8engine.JsCodeCacheResult;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class u22 implements q22 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean e;
    public transient /* synthetic */ FieldHolder $fh;
    public t22 a;
    public String b;
    public boolean c;
    public boolean d;

    /* loaded from: classes7.dex */
    public class a implements JsCodeCacheCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u22 a;

        public a(u22 u22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u22Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u22Var;
        }

        @Override // com.baidu.searchbox.v8engine.JsCodeCacheCallback
        public void onJsCodeCacheFinished(JsCodeCacheResult jsCodeCacheResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jsCodeCacheResult) == null) {
                if (u22.e) {
                    Log.d("V8MasterAdapter", jsCodeCacheResult != null ? jsCodeCacheResult.toString() : StringUtil.NULL_STRING);
                }
                if (jsCodeCacheResult == null || !jsCodeCacheResult.isCacheUsed) {
                    return;
                }
                if (TextUtils.equals(jsCodeCacheResult.businessId, "appframe")) {
                    this.a.c = true;
                } else if (TextUtils.equals(jsCodeCacheResult.businessId, "appjs")) {
                    this.a.d = true;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements m82 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iz1 a;
        public final /* synthetic */ u22 b;

        public b(u22 u22Var, iz1 iz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u22Var, iz1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = u22Var;
            this.a = iz1Var;
        }

        @Override // com.repackage.m82
        public void a(c82 c82Var) {
            iz1 iz1Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, c82Var) == null) || (iz1Var = this.a) == null) {
                return;
            }
            iz1Var.a(this.b.b);
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        public c(u22 u22Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u22Var, Integer.valueOf(i)};
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    Process.setThreadPriority(this.a);
                } catch (Throwable th) {
                    ux1.c("V8MasterAdapter", th.getMessage());
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755312932, "Lcom/repackage/u22;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755312932, "Lcom/repackage/u22;");
                return;
            }
        }
        e = eh1.a;
    }

    public u22(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.repackage.q22
    public void F(i72 i72Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, i72Var) == null) || i72Var == null) {
            return;
        }
        if (e) {
            Log.d("V8MasterAdapter", "pathList item: " + i72Var.b);
        }
        this.a.j(mz1.a("appjs", i72Var.b));
    }

    @Override // com.repackage.q22
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            t22 t22Var = this.a;
            if (t22Var != null) {
                return t22Var.h();
            }
            if (e) {
                Log.d("V8MasterAdapter", Log.getStackTraceString(new Exception("illegal state")));
                return "";
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.q22
    public void d(iz1 iz1Var) {
        t22 t22Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iz1Var) == null) || (t22Var = this.a) == null) {
            return;
        }
        t22Var.l(new b(this, iz1Var));
    }

    @Override // com.repackage.q22
    public void destroy() {
        t22 t22Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (t22Var = this.a) == null) {
            return;
        }
        t22Var.g();
    }

    @Override // com.repackage.q22
    public void f(Activity activity) {
        t22 t22Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, activity) == null) || (t22Var = this.a) == null) {
            return;
        }
        t22Var.d(activity);
    }

    @Override // com.repackage.q22
    public sz1 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a.i() : (sz1) invokeV.objValue;
    }

    public t22 i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) ? new t22(str, "runtime/index.js") : (t22) invokeL.objValue;
    }

    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? mz1.b(this.c, this.d) : invokeV.intValue;
    }

    @Override // com.repackage.q22
    public void loadUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            if (this.a == null) {
                t22 i = i(o72.U().c0());
                this.a = i;
                this.b = str;
                i.k(new a(this));
            } else if (e) {
                Log.e("V8MasterAdapter", Log.getStackTraceString(new Exception("same instance loadUrl should not be call twice.")));
            }
        }
    }

    @Override // com.repackage.q22
    @AnyThread
    public void r(int i) {
        t22 t22Var;
        c82 i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i) == null) || (t22Var = this.a) == null || (i2 = t22Var.i()) == null) {
            return;
        }
        i2.runOnJSThread(new c(this, i));
    }
}
