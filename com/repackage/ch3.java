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
public class ch3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public Bundle a;

    /* loaded from: classes5.dex */
    public class a implements mh3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ tf1 b;
        public final /* synthetic */ ch3 c;

        /* renamed from: com.repackage.ch3$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC0398a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public RunnableC0398a(a aVar) {
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
                    py2.d(this.a.a);
                }
            }
        }

        public a(ch3 ch3Var, ViewGroup viewGroup, tf1 tf1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ch3Var, viewGroup, tf1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ch3Var;
            this.a = viewGroup;
            this.b = tf1Var;
        }

        @Override // com.repackage.mh3
        public void a(QuickLoginInfo quickLoginInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, quickLoginInfo) == null) {
                ViewGroup viewGroup = this.a;
                if (viewGroup != null) {
                    viewGroup.post(new RunnableC0398a(this));
                }
                if (this.c.i(quickLoginInfo)) {
                    this.c.a.putParcelable("quick_login_info", quickLoginInfo);
                }
                String T = gz2.J().r().V().T();
                String appId = gz2.J().getAppId();
                this.c.a.putString("app_name", gz2.J().r().Y());
                this.c.a.putString("appid", appId);
                this.c.a.putString("launch_from", T);
                if (ch3.b) {
                    Log.d("LoginAndGetMobile", "onQueryResult: mParams: " + this.c.a.toString());
                }
                fh3.a("show", "login", null, T, appId);
                this.c.f(this.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements DelegateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tf1 a;

        public b(ch3 ch3Var, tf1 tf1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ch3Var, tf1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tf1Var;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755797245, "Lcom/repackage/ch3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755797245, "Lcom/repackage/ch3;");
                return;
            }
        }
        b = rf1.a;
    }

    public ch3() {
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

    public final void e(tf1 tf1Var) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, tf1Var) == null) || (activity = uk2.U().getActivity()) == null) {
            return;
        }
        Intent intent = new Intent(activity, LoginAndGetMobileActivity.class);
        intent.putExtras(this.a);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.obfuscated_res_0x7f010091, 0);
        eh3.c(tf1Var);
    }

    public final void f(tf1 tf1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tf1Var) == null) {
            if (ProcessUtils.isMainProcess()) {
                e(tf1Var);
            } else {
                g(tf1Var);
            }
        }
    }

    public final void g(tf1 tf1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tf1Var) == null) {
            DelegateUtils.callOnMainWithActivity(uk2.U().getActivity(), PluginDelegateActivity.class, dh3.class, this.a, new b(this, tf1Var));
        }
    }

    public void h(tf1 tf1Var) {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, tf1Var) == null) {
            SwanAppActivity x = gz2.J().x();
            if (x == null || x.isFinishing()) {
                viewGroup = null;
            } else {
                viewGroup = (ViewGroup) x.findViewById(16908290);
                py2.h(x, viewGroup, x.getResources().getString(R.string.obfuscated_res_0x7f0f12d4));
            }
            ph3.b(new a(this, viewGroup, tf1Var));
        }
    }

    public final boolean i(QuickLoginInfo quickLoginInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, quickLoginInfo)) == null) ? quickLoginInfo != null && quickLoginInfo.supportQuickLogin : invokeL.booleanValue;
    }
}
