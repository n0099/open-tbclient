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
import com.repackage.ek2;
import com.repackage.ly2;
/* loaded from: classes7.dex */
public class xy3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public ly2 a;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppActivity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ or1 c;
        public final /* synthetic */ ek2 d;
        public final /* synthetic */ xy3 e;

        public a(xy3 xy3Var, SwanAppActivity swanAppActivity, String str, or1 or1Var, ek2 ek2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xy3Var, swanAppActivity, str, or1Var, ek2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = xy3Var;
            this.a = swanAppActivity;
            this.b = str;
            this.c = or1Var;
            this.d = ek2Var;
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
        public final /* synthetic */ or1 a;

        public b(xy3 xy3Var, or1 or1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xy3Var, or1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = or1Var;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                s14.call(this.a, true, new zy3(false));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ or1 a;
        public final /* synthetic */ ek2 b;
        public final /* synthetic */ xy3 c;

        public c(xy3 xy3Var, or1 or1Var, ek2 ek2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xy3Var, or1Var, ek2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = xy3Var;
            this.a = or1Var;
            this.b = ek2Var;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                s14.call(this.a, true, new zy3(true));
                this.c.e(this.b);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755155297, "Lcom/repackage/xy3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755155297, "Lcom/repackage/xy3;");
                return;
            }
        }
        b = rf1.a;
    }

    public xy3() {
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

    public final void c(or1 or1Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, or1Var, str) == null) {
            pt3 pt3Var = new pt3();
            pt3Var.errMsg = str;
            s14.call(or1Var, false, pt3Var);
        }
    }

    public void d(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jsObject) == null) {
            or1 F = or1.F(jsObject);
            if (F == null) {
                F = new or1();
            }
            or1 or1Var = F;
            hz2 r = gz2.J().r();
            if (!r.H()) {
                c(or1Var, "reload failed, api internal error.");
                return;
            }
            SwanAppActivity x = r.x();
            ek2.a V = r.V();
            if (x == null) {
                c(or1Var, "reload failed, api internal error.");
                return;
            }
            String B = or1Var.B("content");
            if (TextUtils.isEmpty(B)) {
                B = x.getString(R.string.obfuscated_res_0x7f0f017b);
            }
            bd3.e0(new a(this, x, B, or1Var, V));
        }
    }

    public final void e(@NonNull ek2 ek2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ek2Var) == null) {
            String H = ek2Var.H();
            String h1 = fk2.h1(ek2Var.H(), ek2Var.T(), ek2Var.G());
            Bundle bundle = new Bundle();
            bundle.putString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, H);
            bundle.putString("scheme", h1);
            bundle.putInt("target", SwanAppProcessInfo.current().index);
            if (b) {
                Log.d("SwanGameReloadApi", "reload-appid:" + ek2Var.H());
            }
            cw2.P().V(bundle, yy3.class);
        }
    }

    public final void f(@NonNull Activity activity, @NonNull String str, @NonNull or1 or1Var, @NonNull ek2 ek2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, activity, str, or1Var, ek2Var) == null) {
            ly2 ly2Var = this.a;
            if (ly2Var != null && ly2Var.isShowing()) {
                c(or1Var, "reload failed, the reload dialog has been displayed.");
                return;
            }
            ly2.a aVar = new ly2.a(activity);
            aVar.U(R.string.obfuscated_res_0x7f0f017c);
            aVar.x(str);
            aVar.a();
            aVar.n(new pe3());
            aVar.m(false);
            aVar.B(R.string.obfuscated_res_0x7f0f010b, new b(this, or1Var));
            aVar.O(R.string.obfuscated_res_0x7f0f019b, new c(this, or1Var, ek2Var));
            this.a = aVar.X();
        }
    }
}
