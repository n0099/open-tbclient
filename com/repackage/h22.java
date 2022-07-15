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
/* loaded from: classes6.dex */
public class h22 implements d22 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean e;
    public transient /* synthetic */ FieldHolder $fh;
    public g22 a;
    public String b;
    public boolean c;
    public boolean d;

    /* loaded from: classes6.dex */
    public class a implements JsCodeCacheCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h22 a;

        public a(h22 h22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h22Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h22Var;
        }

        @Override // com.baidu.searchbox.v8engine.JsCodeCacheCallback
        public void onJsCodeCacheFinished(JsCodeCacheResult jsCodeCacheResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jsCodeCacheResult) == null) {
                if (h22.e) {
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

    /* loaded from: classes6.dex */
    public class b implements z72 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vy1 a;
        public final /* synthetic */ h22 b;

        public b(h22 h22Var, vy1 vy1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h22Var, vy1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = h22Var;
            this.a = vy1Var;
        }

        @Override // com.repackage.z72
        public void a(p72 p72Var) {
            vy1 vy1Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, p72Var) == null) || (vy1Var = this.a) == null) {
                return;
            }
            vy1Var.a(this.b.b);
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        public c(h22 h22Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h22Var, Integer.valueOf(i)};
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
                    hx1.c("V8MasterAdapter", th.getMessage());
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755700215, "Lcom/repackage/h22;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755700215, "Lcom/repackage/h22;");
                return;
            }
        }
        e = rg1.a;
    }

    public h22(Context context) {
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

    @Override // com.repackage.d22
    public void E(v62 v62Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, v62Var) == null) || v62Var == null) {
            return;
        }
        if (e) {
            Log.d("V8MasterAdapter", "pathList item: " + v62Var.b);
        }
        this.a.j(zy1.a("appjs", v62Var.b));
    }

    @Override // com.repackage.d22
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            g22 g22Var = this.a;
            if (g22Var != null) {
                return g22Var.h();
            }
            if (e) {
                Log.d("V8MasterAdapter", Log.getStackTraceString(new Exception("illegal state")));
                return "";
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.d22
    public void c(vy1 vy1Var) {
        g22 g22Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, vy1Var) == null) || (g22Var = this.a) == null) {
            return;
        }
        g22Var.l(new b(this, vy1Var));
    }

    @Override // com.repackage.d22
    public void destroy() {
        g22 g22Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (g22Var = this.a) == null) {
            return;
        }
        g22Var.g();
    }

    @Override // com.repackage.d22
    public void e(Activity activity) {
        g22 g22Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, activity) == null) || (g22Var = this.a) == null) {
            return;
        }
        g22Var.d(activity);
    }

    @Override // com.repackage.d22
    public fz1 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a.i() : (fz1) invokeV.objValue;
    }

    public g22 i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) ? new g22(str, "runtime/index.js") : (g22) invokeL.objValue;
    }

    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? zy1.b(this.c, this.d) : invokeV.intValue;
    }

    @Override // com.repackage.d22
    public void loadUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            if (this.a == null) {
                g22 i = i(b72.U().c0());
                this.a = i;
                this.b = str;
                i.k(new a(this));
            } else if (e) {
                Log.e("V8MasterAdapter", Log.getStackTraceString(new Exception("same instance loadUrl should not be call twice.")));
            }
        }
    }

    @Override // com.repackage.d22
    @AnyThread
    public void q(int i) {
        g22 g22Var;
        p72 i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i) == null) || (g22Var = this.a) == null || (i2 = g22Var.i()) == null) {
            return;
        }
        i2.runOnJSThread(new c(this, i));
    }
}
