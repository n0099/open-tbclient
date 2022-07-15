package com.repackage;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class dj5 {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean d = true;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public ej5 b;
    public BaseFragmentActivity c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755765470, "Lcom/repackage/dj5;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755765470, "Lcom/repackage/dj5;");
        }
    }

    public dj5(BaseFragmentActivity baseFragmentActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = -1L;
        this.c = baseFragmentActivity;
    }

    public final void a(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, intent) == null) || intent == null) {
            return;
        }
        if (intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false)) {
            Intent intent2 = new Intent();
            intent2.putExtra(DealIntentService.KEY_CLASS, 2);
            intent2.putExtra("fname", intent.getStringExtra("fname"));
            intent2.putExtra(FrsActivityConfig.FROM_SHORT_CUT, true);
            intent2.putExtra("back_special", true);
            intent2.putExtra("from", "short_cut");
            intent.putExtra(LogoActivityConfig.EXTRAINTENT, intent2);
        }
        TbadkCoreApplication.setIntent((Intent) intent.getParcelableExtra(LogoActivityConfig.EXTRAINTENT));
    }

    public final void b(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            if (te8.a(this.c.getIntent())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016560));
            }
            if (bundle != null) {
                LogoActivityConfig.isFirst = bundle.getBoolean("is_first", true);
            } else {
                LogoActivityConfig.isFirst = true;
            }
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.c.setIsAddSwipeBackLayout(false);
            this.c.setUseStyleImmersiveSticky(false);
            this.c.getWindow().setFlags(1024, 1024);
            if (Build.VERSION.SDK_INT > 16) {
                this.c.getWindow().getDecorView().setSystemUiVisibility(ARPMessageType.MSG_TYPE_VIDEO_STOP_RES);
            }
            this.c.setContentView(R.layout.obfuscated_res_0x7f0d052c);
        }
    }

    public void d(Configuration configuration) {
        ej5 ej5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, configuration) == null) || (ej5Var = this.b) == null) {
            return;
        }
        ej5Var.d(configuration);
    }

    public void e(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            this.a = System.currentTimeMillis();
            if ("MuMu".equals(Build.MODEL) && "6.0.1".equals(Build.VERSION.RELEASE)) {
                this.c.finish();
                return;
            }
            c();
            b(bundle);
            if (!te8.a(this.c.getIntent()) && (te8.b(this.c.getIntent()) || this.c.isTaskRoot())) {
                a(this.c.getIntent());
            }
            pg8.g().i(this.c.getUniqueId());
            ej5 ej5Var = new ej5(this.c);
            this.b = ej5Var;
            ej5Var.i(d);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            pg8.g().k(this.c.getUniqueId());
            d = false;
            ej5 ej5Var = this.b;
            if (ej5Var != null) {
                ej5Var.g();
            }
        }
    }

    public void g() {
        ej5 ej5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (ej5Var = this.b) == null) {
            return;
        }
        ej5Var.e();
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (LogoActivityConfig.isFirst && this.a >= 0) {
                s95.b().v(System.currentTimeMillis() - this.a);
            }
            ej5 ej5Var = this.b;
            if (ej5Var != null) {
                ej5Var.f();
            }
        }
    }
}
