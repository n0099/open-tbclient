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
import com.repackage.pk2;
import com.repackage.wy2;
/* loaded from: classes6.dex */
public class iz3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public wy2 a;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppActivity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ zr1 c;
        public final /* synthetic */ pk2 d;
        public final /* synthetic */ iz3 e;

        public a(iz3 iz3Var, SwanAppActivity swanAppActivity, String str, zr1 zr1Var, pk2 pk2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iz3Var, swanAppActivity, str, zr1Var, pk2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = iz3Var;
            this.a = swanAppActivity;
            this.b = str;
            this.c = zr1Var;
            this.d = pk2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.e.f(this.a, this.b, this.c, this.d);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zr1 a;

        public b(iz3 iz3Var, zr1 zr1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iz3Var, zr1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zr1Var;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                d24.call(this.a, true, new kz3(false));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zr1 a;
        public final /* synthetic */ pk2 b;
        public final /* synthetic */ iz3 c;

        public c(iz3 iz3Var, zr1 zr1Var, pk2 pk2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iz3Var, zr1Var, pk2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = iz3Var;
            this.a = zr1Var;
            this.b = pk2Var;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                d24.call(this.a, true, new kz3(true));
                this.c.e(this.b);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755601201, "Lcom/repackage/iz3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755601201, "Lcom/repackage/iz3;");
                return;
            }
        }
        b = cg1.a;
    }

    public iz3() {
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

    public final void c(zr1 zr1Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, zr1Var, str) == null) {
            au3 au3Var = new au3();
            au3Var.errMsg = str;
            d24.call(zr1Var, false, au3Var);
        }
    }

    public void d(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jsObject) == null) {
            zr1 F = zr1.F(jsObject);
            if (F == null) {
                F = new zr1();
            }
            zr1 zr1Var = F;
            sz2 r = rz2.K().r();
            if (!r.I()) {
                c(zr1Var, "reload failed, api internal error.");
                return;
            }
            SwanAppActivity x = r.x();
            pk2.a W = r.W();
            if (x == null) {
                c(zr1Var, "reload failed, api internal error.");
                return;
            }
            String B = zr1Var.B("content");
            if (TextUtils.isEmpty(B)) {
                B = x.getString(R.string.obfuscated_res_0x7f0f017b);
            }
            md3.e0(new a(this, x, B, zr1Var, W));
        }
    }

    public final void e(@NonNull pk2 pk2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pk2Var) == null) {
            String H = pk2Var.H();
            String h1 = qk2.h1(pk2Var.H(), pk2Var.T(), pk2Var.G());
            Bundle bundle = new Bundle();
            bundle.putString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, H);
            bundle.putString("scheme", h1);
            bundle.putInt("target", SwanAppProcessInfo.current().index);
            if (b) {
                Log.d("SwanGameReloadApi", "reload-appid:" + pk2Var.H());
            }
            nw2.Q().W(bundle, jz3.class);
        }
    }

    public final void f(@NonNull Activity activity, @NonNull String str, @NonNull zr1 zr1Var, @NonNull pk2 pk2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, activity, str, zr1Var, pk2Var) == null) {
            wy2 wy2Var = this.a;
            if (wy2Var != null && wy2Var.isShowing()) {
                c(zr1Var, "reload failed, the reload dialog has been displayed.");
                return;
            }
            wy2.a aVar = new wy2.a(activity);
            aVar.U(R.string.obfuscated_res_0x7f0f017c);
            aVar.x(str);
            aVar.a();
            aVar.n(new af3());
            aVar.m(false);
            aVar.B(R.string.obfuscated_res_0x7f0f010b, new b(this, zr1Var));
            aVar.O(R.string.obfuscated_res_0x7f0f019b, new c(this, zr1Var, pk2Var));
            this.a = aVar.X();
        }
    }
}
