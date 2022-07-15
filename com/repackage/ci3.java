package com.repackage;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.process.ipc.agent.activity.PluginDelegateActivity;
import com.baidu.searchbox.process.ipc.delegate.DelegateListener;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.bdprivate.extensions.loginauthmobile.LoginAndGetMobileActivity;
import com.baidu.swan.bdprivate.extensions.quicklogin.QuickLoginInfo;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ci3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public Bundle a;

    /* loaded from: classes5.dex */
    public class a implements mi3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ tg1 b;
        public final /* synthetic */ ci3 c;

        /* renamed from: com.repackage.ci3$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC0606a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public RunnableC0606a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    pz2.d(this.a.a);
                }
            }
        }

        public a(ci3 ci3Var, ViewGroup viewGroup, tg1 tg1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci3Var, viewGroup, tg1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ci3Var;
            this.a = viewGroup;
            this.b = tg1Var;
        }

        @Override // com.repackage.mi3
        public void a(QuickLoginInfo quickLoginInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, quickLoginInfo) == null) {
                ViewGroup viewGroup = this.a;
                if (viewGroup != null) {
                    viewGroup.post(new RunnableC0606a(this));
                }
                if (this.c.i(quickLoginInfo)) {
                    this.c.a.putParcelable("quick_login_info", quickLoginInfo);
                }
                String T = g03.K().q().W().T();
                String appId = g03.K().getAppId();
                this.c.a.putString("app_name", g03.K().q().Z());
                this.c.a.putString("appid", appId);
                this.c.a.putString("launch_from", T);
                if (ci3.b) {
                    Log.d("LoginAndGetMobile", "onQueryResult: mParams: " + this.c.a.toString());
                }
                fi3.a("show", "login", null, T, appId);
                this.c.f(this.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements DelegateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tg1 a;

        public b(ci3 ci3Var, tg1 tg1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci3Var, tg1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tg1Var;
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
        public void onDelegateCallBack(@NonNull DelegateResult delegateResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, delegateResult) == null) {
                if (delegateResult.isOk()) {
                    this.a.onResult(delegateResult.mResult.getInt("loginStatusCode"));
                    return;
                }
                this.a.onResult(-2);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755796284, "Lcom/repackage/ci3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755796284, "Lcom/repackage/ci3;");
                return;
            }
        }
        b = rg1.a;
    }

    public ci3() {
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
        this.a = new Bundle();
    }

    public final void e(tg1 tg1Var) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, tg1Var) == null) || (activity = ul2.U().getActivity()) == null) {
            return;
        }
        Intent intent = new Intent(activity, LoginAndGetMobileActivity.class);
        intent.putExtras(this.a);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.obfuscated_res_0x7f010093, 0);
        ei3.c(tg1Var);
    }

    public final void f(tg1 tg1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tg1Var) == null) {
            if (ProcessUtils.isMainProcess()) {
                e(tg1Var);
            } else {
                g(tg1Var);
            }
        }
    }

    public final void g(tg1 tg1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tg1Var) == null) {
            DelegateUtils.callOnMainWithActivity(ul2.U().getActivity(), PluginDelegateActivity.class, di3.class, this.a, new b(this, tg1Var));
        }
    }

    public void h(tg1 tg1Var) {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, tg1Var) == null) {
            SwanAppActivity w = g03.K().w();
            if (w == null || w.isFinishing()) {
                viewGroup = null;
            } else {
                viewGroup = (ViewGroup) w.findViewById(16908290);
                pz2.h(w, viewGroup, w.getResources().getString(R.string.obfuscated_res_0x7f0f12da));
            }
            pi3.b(new a(this, viewGroup, tg1Var));
        }
    }

    public final boolean i(QuickLoginInfo quickLoginInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, quickLoginInfo)) == null) ? quickLoginInfo != null && quickLoginInfo.supportQuickLogin : invokeL.booleanValue;
    }
}
