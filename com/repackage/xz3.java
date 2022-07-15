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
import com.repackage.el2;
import com.repackage.lz2;
/* loaded from: classes7.dex */
public class xz3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public lz2 a;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppActivity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ os1 c;
        public final /* synthetic */ el2 d;
        public final /* synthetic */ xz3 e;

        public a(xz3 xz3Var, SwanAppActivity swanAppActivity, String str, os1 os1Var, el2 el2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz3Var, swanAppActivity, str, os1Var, el2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = xz3Var;
            this.a = swanAppActivity;
            this.b = str;
            this.c = os1Var;
            this.d = el2Var;
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
        public final /* synthetic */ os1 a;

        public b(xz3 xz3Var, os1 os1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz3Var, os1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = os1Var;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                s24.call(this.a, true, new zz3(false));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ os1 a;
        public final /* synthetic */ el2 b;
        public final /* synthetic */ xz3 c;

        public c(xz3 xz3Var, os1 os1Var, el2 el2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz3Var, os1Var, el2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = xz3Var;
            this.a = os1Var;
            this.b = el2Var;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                s24.call(this.a, true, new zz3(true));
                this.c.e(this.b);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755154336, "Lcom/repackage/xz3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755154336, "Lcom/repackage/xz3;");
                return;
            }
        }
        b = rg1.a;
    }

    public xz3() {
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

    public final void c(os1 os1Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, os1Var, str) == null) {
            pu3 pu3Var = new pu3();
            pu3Var.errMsg = str;
            s24.call(os1Var, false, pu3Var);
        }
    }

    public void d(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jsObject) == null) {
            os1 F = os1.F(jsObject);
            if (F == null) {
                F = new os1();
            }
            os1 os1Var = F;
            h03 q = g03.K().q();
            if (!q.I()) {
                c(os1Var, "reload failed, api internal error.");
                return;
            }
            SwanAppActivity w = q.w();
            el2.a W = q.W();
            if (w == null) {
                c(os1Var, "reload failed, api internal error.");
                return;
            }
            String B = os1Var.B("content");
            if (TextUtils.isEmpty(B)) {
                B = w.getString(R.string.obfuscated_res_0x7f0f017d);
            }
            be3.e0(new a(this, w, B, os1Var, W));
        }
    }

    public final void e(@NonNull el2 el2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, el2Var) == null) {
            String H = el2Var.H();
            String h1 = fl2.h1(el2Var.H(), el2Var.T(), el2Var.G());
            Bundle bundle = new Bundle();
            bundle.putString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, H);
            bundle.putString("scheme", h1);
            bundle.putInt("target", SwanAppProcessInfo.current().index);
            if (b) {
                Log.d("SwanGameReloadApi", "reload-appid:" + el2Var.H());
            }
            cx2.Q().W(bundle, yz3.class);
        }
    }

    public final void f(@NonNull Activity activity, @NonNull String str, @NonNull os1 os1Var, @NonNull el2 el2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, activity, str, os1Var, el2Var) == null) {
            lz2 lz2Var = this.a;
            if (lz2Var != null && lz2Var.isShowing()) {
                c(os1Var, "reload failed, the reload dialog has been displayed.");
                return;
            }
            lz2.a aVar = new lz2.a(activity);
            aVar.U(R.string.obfuscated_res_0x7f0f017e);
            aVar.x(str);
            aVar.a();
            aVar.n(new pf3());
            aVar.m(false);
            aVar.B(R.string.obfuscated_res_0x7f0f010d, new b(this, os1Var));
            aVar.O(R.string.obfuscated_res_0x7f0f019d, new c(this, os1Var, el2Var));
            this.a = aVar.X();
        }
    }
}
