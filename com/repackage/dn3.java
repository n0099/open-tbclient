package com.repackage;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog;
import com.baidu.swan.apps.view.SwanAppErrorDialog;
import com.baidu.swan.facade.init.SwanAppInitHelper;
import com.baidu.swan.facade.requred.webview.LoadingActivity;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.ZeusWebViewPreloadClass;
import com.repackage.bn3;
import com.repackage.i62;
/* loaded from: classes5.dex */
public class dn3 implements bn3.b {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* loaded from: classes5.dex */
    public class a implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j62 a;
        public final /* synthetic */ dn3 b;

        public a(dn3 dn3Var, j62 j62Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dn3Var, j62Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dn3Var;
            this.a = j62Var;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) || -2 == i) {
                return;
            }
            this.b.j();
            this.b.l(this.a);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements af3<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j62 a;
        public final /* synthetic */ dn3 b;

        /* loaded from: classes5.dex */
        public class a implements i62.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Boolean a;
            public final /* synthetic */ b b;

            public a(b bVar, Boolean bool) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, bool};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = bVar;
                this.a = bool;
            }

            @Override // com.repackage.i62.e
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    b bVar = this.b;
                    bVar.b.i(this.a, bVar.a);
                }
            }
        }

        public b(dn3 dn3Var, j62 j62Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dn3Var, j62Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dn3Var;
            this.a = j62Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.af3
        /* renamed from: b */
        public void a(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) {
                if (dn3.b) {
                    Log.i("SailorSoDownloadAdapter", "startDownload onCallback: " + bool);
                }
                if (!bool.booleanValue()) {
                    this.b.i(bool, this.a);
                } else {
                    SwanAppInitHelper.doWebViewInit(g03.K(), new a(this, bool));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(dn3 dn3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dn3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Context appContext = AppRuntime.getAppContext();
                Intent intent = new Intent(appContext, LoadingActivity.class);
                intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                intent.putExtra("so_lib_name", ZeusWebViewPreloadClass.ZEUS_FILE_DIR);
                qc3.g(appContext, intent);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(dn3 dn3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dn3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                g03.K().p("loading_hide");
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755761688, "Lcom/repackage/dn3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755761688, "Lcom/repackage/dn3;");
                return;
            }
        }
        b = rg1.a;
    }

    public dn3() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = false;
    }

    @Override // com.repackage.bn3.b
    public ed4 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new hi4() : (ed4) invokeV.objValue;
    }

    @Override // com.repackage.bn3.b
    public void b(boolean z, j62 j62Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, j62Var) == null) {
            if (this.a) {
                if (!z) {
                    j();
                }
                l(j62Var);
            } else if (z) {
                l(j62Var);
            } else {
                k(new a(this, j62Var));
            }
        }
    }

    @Override // com.repackage.bn3.b
    public Bitmap d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (Bitmap) invokeV.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            g03.M().post(new d(this));
        }
    }

    public final void i(Boolean bool, j62 j62Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, bool, j62Var) == null) {
            this.a = false;
            h();
            if (j62Var != null) {
                if (bool.booleanValue()) {
                    j62Var.onSuccess();
                } else {
                    j62Var.onFail();
                }
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            g03.M().post(new c(this));
        }
    }

    public void k(DialogInterface.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, onClickListener) == null) {
            BaseActivityDialog.e r = SwanAppErrorDialog.r();
            r.B(R.string.obfuscated_res_0x7f0f01db);
            r.u(R.string.obfuscated_res_0x7f0f01da);
            r.w(R.string.obfuscated_res_0x7f0f01d8, onClickListener);
            r.z(R.string.obfuscated_res_0x7f0f01d9, onClickListener);
            r.D();
        }
    }

    public final void l(j62 j62Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, j62Var) == null) {
            this.a = true;
            if (b) {
                Log.i("SailorSoDownloadAdapter", "startDownload: ");
            }
            w92 w92Var = w92.d;
            x92 x92Var = new x92();
            x92Var.h(ZeusWebViewPreloadClass.ZEUS_FILE_DIR, new b(this, j62Var));
            w92Var.C(x92Var);
        }
    }
}
