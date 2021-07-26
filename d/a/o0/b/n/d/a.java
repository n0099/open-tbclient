package d.a.o0.b.n.d;

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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.g1.f;
import d.a.o0.a.k;
import d.a.o0.b.g;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f49500b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Bundle f49501a;

    /* renamed from: d.a.o0.b.n.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1030a implements d.a.o0.b.n.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f49502a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.m.a f49503b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f49504c;

        /* renamed from: d.a.o0.b.n.d.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC1031a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C1030a f49505e;

            public RunnableC1031a(C1030a c1030a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1030a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f49505e = c1030a;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    d.a.o0.a.z1.b.d.a.c(this.f49505e.f49502a);
                }
            }
        }

        public C1030a(a aVar, ViewGroup viewGroup, d.a.o0.a.m.a aVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, viewGroup, aVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49504c = aVar;
            this.f49502a = viewGroup;
            this.f49503b = aVar2;
        }

        @Override // d.a.o0.b.n.g.c
        public void a(QuickLoginInfo quickLoginInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, quickLoginInfo) == null) {
                ViewGroup viewGroup = this.f49502a;
                if (viewGroup != null) {
                    viewGroup.post(new RunnableC1031a(this));
                }
                if (this.f49504c.i(quickLoginInfo)) {
                    this.f49504c.f49501a.putParcelable("quick_login_info", quickLoginInfo);
                }
                String T = d.a.o0.a.a2.d.g().r().L().T();
                String appId = d.a.o0.a.a2.d.g().getAppId();
                this.f49504c.f49501a.putString("app_name", d.a.o0.a.a2.d.g().r().O());
                this.f49504c.f49501a.putString("appid", appId);
                this.f49504c.f49501a.putString("launch_from", T);
                if (a.f49500b) {
                    Log.d("LoginAndGetMobile", "onQueryResult: mParams: " + this.f49504c.f49501a.toString());
                }
                d.a("show", "login", null, T, appId);
                this.f49504c.f(this.f49503b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements DelegateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.m.a f49506a;

        public b(a aVar, d.a.o0.a.m.a aVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, aVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49506a = aVar2;
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
        public void onDelegateCallBack(@NonNull DelegateResult delegateResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, delegateResult) == null) {
                if (delegateResult.isOk()) {
                    this.f49506a.onResult(delegateResult.mResult.getInt("loginStatusCode"));
                    return;
                }
                this.f49506a.onResult(-2);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(544142492, "Ld/a/o0/b/n/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(544142492, "Ld/a/o0/b/n/d/a;");
                return;
            }
        }
        f49500b = k.f46335a;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f49501a = new Bundle();
    }

    public final void e(d.a.o0.a.m.a aVar) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || (activity = f.V().getActivity()) == null) {
            return;
        }
        Intent intent = new Intent(activity, LoginAndGetMobileActivity.class);
        intent.putExtras(this.f49501a);
        activity.startActivity(intent);
        activity.overridePendingTransition(d.a.o0.b.b.login_get_mobile_act_enter, 0);
        c.c(aVar);
    }

    public final void f(d.a.o0.a.m.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            if (ProcessUtils.isMainProcess()) {
                e(aVar);
            } else {
                g(aVar);
            }
        }
    }

    public final void g(d.a.o0.a.m.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            DelegateUtils.callOnMainWithActivity(f.V().getActivity(), PluginDelegateActivity.class, d.a.o0.b.n.d.b.class, this.f49501a, new b(this, aVar));
        }
    }

    public void h(d.a.o0.a.m.a aVar) {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            SwanAppActivity x = d.a.o0.a.a2.d.g().x();
            if (x == null || x.isFinishing()) {
                viewGroup = null;
            } else {
                viewGroup = (ViewGroup) x.findViewById(16908290);
                d.a.o0.a.z1.b.d.a.f(x, viewGroup, x.getResources().getString(g.swanapp_login_loading));
            }
            d.a.o0.b.n.g.f.b(new C1030a(this, viewGroup, aVar));
        }
    }

    public final boolean i(QuickLoginInfo quickLoginInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, quickLoginInfo)) == null) ? quickLoginInfo != null && quickLoginInfo.supportQuickLogin : invokeL.booleanValue;
    }
}
