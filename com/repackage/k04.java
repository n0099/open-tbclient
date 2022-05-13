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
import com.repackage.rl2;
import com.repackage.yz2;
/* loaded from: classes6.dex */
public class k04 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public yz2 a;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppActivity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ bt1 c;
        public final /* synthetic */ rl2 d;
        public final /* synthetic */ k04 e;

        public a(k04 k04Var, SwanAppActivity swanAppActivity, String str, bt1 bt1Var, rl2 rl2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k04Var, swanAppActivity, str, bt1Var, rl2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = k04Var;
            this.a = swanAppActivity;
            this.b = str;
            this.c = bt1Var;
            this.d = rl2Var;
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
        public final /* synthetic */ bt1 a;

        public b(k04 k04Var, bt1 bt1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k04Var, bt1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bt1Var;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                f34.call(this.a, true, new m04(false));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bt1 a;
        public final /* synthetic */ rl2 b;
        public final /* synthetic */ k04 c;

        public c(k04 k04Var, bt1 bt1Var, rl2 rl2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k04Var, bt1Var, rl2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = k04Var;
            this.a = bt1Var;
            this.b = rl2Var;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                f34.call(this.a, true, new m04(true));
                this.c.e(this.b);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755612702, "Lcom/repackage/k04;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755612702, "Lcom/repackage/k04;");
                return;
            }
        }
        b = eh1.a;
    }

    public k04() {
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

    public final void c(bt1 bt1Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, bt1Var, str) == null) {
            cv3 cv3Var = new cv3();
            cv3Var.errMsg = str;
            f34.call(bt1Var, false, cv3Var);
        }
    }

    public void d(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jsObject) == null) {
            bt1 F = bt1.F(jsObject);
            if (F == null) {
                F = new bt1();
            }
            bt1 bt1Var = F;
            u03 r = t03.J().r();
            if (!r.H()) {
                c(bt1Var, "reload failed, api internal error.");
                return;
            }
            SwanAppActivity x = r.x();
            rl2.a V = r.V();
            if (x == null) {
                c(bt1Var, "reload failed, api internal error.");
                return;
            }
            String B = bt1Var.B("content");
            if (TextUtils.isEmpty(B)) {
                B = x.getString(R.string.obfuscated_res_0x7f0f017a);
            }
            oe3.e0(new a(this, x, B, bt1Var, V));
        }
    }

    public final void e(@NonNull rl2 rl2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, rl2Var) == null) {
            String H = rl2Var.H();
            String h1 = sl2.h1(rl2Var.H(), rl2Var.T(), rl2Var.G());
            Bundle bundle = new Bundle();
            bundle.putString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, H);
            bundle.putString("scheme", h1);
            bundle.putInt("target", SwanAppProcessInfo.current().index);
            if (b) {
                Log.d("SwanGameReloadApi", "reload-appid:" + rl2Var.H());
            }
            px2.P().V(bundle, l04.class);
        }
    }

    public final void f(@NonNull Activity activity, @NonNull String str, @NonNull bt1 bt1Var, @NonNull rl2 rl2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, activity, str, bt1Var, rl2Var) == null) {
            yz2 yz2Var = this.a;
            if (yz2Var != null && yz2Var.isShowing()) {
                c(bt1Var, "reload failed, the reload dialog has been displayed.");
                return;
            }
            yz2.a aVar = new yz2.a(activity);
            aVar.U(R.string.obfuscated_res_0x7f0f017b);
            aVar.x(str);
            aVar.a();
            aVar.n(new cg3());
            aVar.m(false);
            aVar.B(R.string.obfuscated_res_0x7f0f010a, new b(this, bt1Var));
            aVar.O(R.string.obfuscated_res_0x7f0f019a, new c(this, bt1Var, rl2Var));
            this.a = aVar.X();
        }
    }
}
