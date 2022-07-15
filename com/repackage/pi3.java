package com.repackage;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.callback.OneKeyLoginCallback;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.baidu.sapi2.result.OneKeyLoginResult;
import com.baidu.searchbox.process.ipc.agent.activity.PluginDelegateActivity;
import com.baidu.searchbox.process.ipc.delegate.DelegateListener;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.bdprivate.extensions.quicklogin.QuickLoginInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class pi3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a extends OneKeyLoginCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mi3 a;

        public a(mi3 mi3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mi3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mi3Var;
        }

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void available(OneKeyLoginResult oneKeyLoginResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, oneKeyLoginResult) == null) {
                if (oneKeyLoginResult == null) {
                    this.a.a(null);
                    return;
                }
                boolean z = oneKeyLoginResult.enable;
                String str = oneKeyLoginResult.operator;
                String str2 = oneKeyLoginResult.encryptPhoneNum;
                boolean z2 = oneKeyLoginResult.hasHistory;
                ki3 ki3Var = new ki3();
                ki3Var.j(z);
                ki3Var.k(str);
                ki3Var.g(str2);
                ki3Var.h(z2);
                char c = 65535;
                int hashCode = str.hashCode();
                if (hashCode != 2154) {
                    if (hashCode != 2161) {
                        if (hashCode == 2162 && str.equals(OneKeyLoginSdkCall.OPERATOR_TYPE_CUCC)) {
                            c = 1;
                        }
                    } else if (str.equals(OneKeyLoginSdkCall.OPERATOR_TYPE_CTCC)) {
                        c = 2;
                    }
                } else if (str.equals(OneKeyLoginSdkCall.OPERATOR_TYPE_CMCC)) {
                    c = 0;
                }
                if (c == 0) {
                    ki3Var.i(12);
                } else if (c == 1) {
                    ki3Var.i(13);
                } else if (c == 2) {
                    ki3Var.i(14);
                }
                this.a.a(QuickLoginInfo.parseQuickLoginInfo(ki3Var));
            }
        }

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void unAvailable(OneKeyLoginResult oneKeyLoginResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oneKeyLoginResult) == null) {
                super.unAvailable(oneKeyLoginResult);
                this.a.a(null);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b extends nw2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mi3 c;

        public b(mi3 mi3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mi3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = mi3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nw2, com.repackage.ow2, com.repackage.mw2
        public void onEvent(@NonNull kw2 kw2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, kw2Var) == null) {
                Bundle a = kw2Var.a();
                if (a == null) {
                    this.c.a(null);
                    return;
                }
                a.setClassLoader(QuickLoginInfo.class.getClassLoader());
                QuickLoginInfo quickLoginInfo = (QuickLoginInfo) a.getParcelable("quick_login_info_result");
                if (quickLoginInfo == null) {
                    this.c.a(null);
                } else {
                    this.c.a(quickLoginInfo);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c extends OneKeyLoginCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ oi3 b;

        public c(Activity activity, oi3 oi3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activity, oi3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = activity;
            this.b = oi3Var;
        }

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void available(OneKeyLoginResult oneKeyLoginResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, oneKeyLoginResult) == null) {
                ch3.a().m(this.a, oneKeyLoginResult.sign, this.b);
            }
        }

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void unAvailable(OneKeyLoginResult oneKeyLoginResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oneKeyLoginResult) == null) {
                this.b.onResult(-1);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class d implements DelegateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oi3 a;

        public d(oi3 oi3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oi3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oi3Var;
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
        public void onDelegateCallBack(@NonNull DelegateResult delegateResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, delegateResult) == null) {
                Bundle bundle = delegateResult.mResult;
                if (this.a != null) {
                    this.a.onResult(gd3.f(bundle, "quick_login", -1));
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755409001, "Lcom/repackage/pi3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755409001, "Lcom/repackage/pi3;");
                return;
            }
        }
        boolean z = rg1.a;
    }

    public static void a(mi3 mi3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, mi3Var) == null) {
            SapiAccountManager.getInstance().getOneKeyLoginIsAvailable(new a(mi3Var));
        }
    }

    public static void b(mi3 mi3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, mi3Var) == null) {
            if (ProcessUtils.isMainProcess()) {
                a(mi3Var);
            } else {
                c(mi3Var);
            }
        }
    }

    public static void c(mi3 mi3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, mi3Var) == null) {
            h03 b0 = h03.b0();
            if (b0 == null) {
                mi3Var.a(null);
                return;
            }
            cx2 y = b0.y();
            if (y == null) {
                mi3Var.a(null);
            } else {
                y.X(null, li3.class, new b(mi3Var));
            }
        }
    }

    public static void d(Activity activity, int i, oi3 oi3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(InputDeviceCompat.SOURCE_TRACKBALL, null, activity, i, oi3Var) == null) {
            SapiAccountManager.getInstance().getOneKeyLoginIsAvailable(new c(activity, oi3Var));
        }
    }

    public static void e(Activity activity, int i, oi3 oi3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65541, null, activity, i, oi3Var) == null) {
            if (ProcessUtils.isMainProcess()) {
                d(activity, i, oi3Var);
            } else {
                f(activity, i, oi3Var);
            }
        }
    }

    public static void f(Activity activity, int i, oi3 oi3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65542, null, activity, i, oi3Var) == null) {
            Bundle bundle = new Bundle();
            bundle.putInt("quick_login_mode", i);
            DelegateUtils.callOnMainWithActivity(activity, PluginDelegateActivity.class, ni3.class, bundle, new d(oi3Var));
        }
    }
}
