package com.repackage;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.gl2;
import com.repackage.nz2;
/* loaded from: classes7.dex */
public class zz3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public nz2 a;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppActivity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ qs1 c;
        public final /* synthetic */ gl2 d;
        public final /* synthetic */ zz3 e;

        public a(zz3 zz3Var, SwanAppActivity swanAppActivity, String str, qs1 qs1Var, gl2 gl2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zz3Var, swanAppActivity, str, qs1Var, gl2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = zz3Var;
            this.a = swanAppActivity;
            this.b = str;
            this.c = qs1Var;
            this.d = gl2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.e.f(this.a, this.b, this.c, this.d);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qs1 a;

        public b(zz3 zz3Var, qs1 qs1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zz3Var, qs1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qs1Var;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                u24.call(this.a, true, new b04(false));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qs1 a;
        public final /* synthetic */ gl2 b;
        public final /* synthetic */ zz3 c;

        public c(zz3 zz3Var, qs1 qs1Var, gl2 gl2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zz3Var, qs1Var, gl2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = zz3Var;
            this.a = qs1Var;
            this.b = gl2Var;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                u24.call(this.a, true, new b04(true));
                this.c.e(this.b);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755094754, "Lcom/repackage/zz3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755094754, "Lcom/repackage/zz3;");
                return;
            }
        }
        b = tg1.a;
    }

    public zz3() {
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

    public final void c(qs1 qs1Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, qs1Var, str) == null) {
            ru3 ru3Var = new ru3();
            ru3Var.errMsg = str;
            u24.call(qs1Var, false, ru3Var);
        }
    }

    public void d(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jsObject) == null) {
            qs1 F = qs1.F(jsObject);
            if (F == null) {
                F = new qs1();
            }
            qs1 qs1Var = F;
            j03 r = i03.J().r();
            if (!r.H()) {
                c(qs1Var, "reload failed, api internal error.");
                return;
            }
            SwanAppActivity x = r.x();
            gl2.a V = r.V();
            if (x == null) {
                c(qs1Var, "reload failed, api internal error.");
                return;
            }
            String B = qs1Var.B("content");
            if (TextUtils.isEmpty(B)) {
                B = x.getString(R.string.obfuscated_res_0x7f0f0178);
            }
            de3.e0(new a(this, x, B, qs1Var, V));
        }
    }

    public final void e(@NonNull gl2 gl2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gl2Var) == null) {
            String H = gl2Var.H();
            String h1 = hl2.h1(gl2Var.H(), gl2Var.T(), gl2Var.G());
            Bundle bundle = new Bundle();
            bundle.putString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, H);
            bundle.putString("scheme", h1);
            bundle.putInt("target", SwanAppProcessInfo.current().index);
            if (b) {
                Log.d("SwanGameReloadApi", "reload-appid:" + gl2Var.H());
            }
            ex2.P().V(bundle, a04.class);
        }
    }

    public final void f(@NonNull Activity activity, @NonNull String str, @NonNull qs1 qs1Var, @NonNull gl2 gl2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, activity, str, qs1Var, gl2Var) == null) {
            nz2 nz2Var = this.a;
            if (nz2Var != null && nz2Var.isShowing()) {
                c(qs1Var, "reload failed, the reload dialog has been displayed.");
                return;
            }
            nz2.a aVar = new nz2.a(activity);
            aVar.U(R.string.obfuscated_res_0x7f0f0179);
            aVar.x(str);
            aVar.a();
            aVar.n(new rf3());
            aVar.m(false);
            aVar.B(R.string.obfuscated_res_0x7f0f0108, new b(this, qs1Var));
            aVar.O(R.string.obfuscated_res_0x7f0f0198, new c(this, qs1Var, gl2Var));
            this.a = aVar.X();
        }
    }
}
