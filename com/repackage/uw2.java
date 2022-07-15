package com.repackage;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.IProcessBridge;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class uw2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Class a;
        public final /* synthetic */ Bundle b;
        public final /* synthetic */ qw2 c;

        public a(Class cls, Bundle bundle, qw2 qw2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cls, bundle, qw2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cls;
            this.b = bundle;
            this.c = qw2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Bundle b = uw2.b(this.a, this.b);
                qw2 qw2Var = this.c;
                if (qw2Var != null) {
                    qw2Var.onResult(b);
                }
            }
        }
    }

    public static void a(@NonNull Class<? extends ProviderDelegation> cls, @Nullable Bundle bundle, @Nullable qw2<Bundle> qw2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, cls, bundle, qw2Var) == null) {
            bd3.k(new a(cls, bundle, qw2Var), "asyncCallMainProcess");
        }
    }

    @NonNull
    public static Bundle b(@NonNull Class<? extends ProviderDelegation> cls, @Nullable Bundle bundle) {
        InterceptResult invokeLL;
        IProcessBridge S;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, cls, bundle)) == null) {
            if (ProcessUtils.isMainProcess()) {
                Bundle d = d(cls, bundle);
                return d == null ? new Bundle() : d;
            }
            cx2 y = g03.K().y();
            if (y != null && (S = y.S()) != null) {
                try {
                    Bundle callMainProcessSync = S.callMainProcessSync(cls.getName(), bundle);
                    return callMainProcessSync == null ? new Bundle() : callMainProcessSync;
                } catch (Throwable th) {
                    hx1.d("SwanProcessCallManager", "callMainProcessSync", th);
                }
            }
            return DelegateUtils.callOnMainWithContentProvider(oj2.c(), cls, bundle).mResult;
        }
        return (Bundle) invokeLL.objValue;
    }

    @NonNull
    public static ww2 c(@NonNull Class<? extends ProviderDelegation> cls, @Nullable Bundle bundle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, cls, bundle)) == null) ? new ww2(b(cls, bundle)) : (ww2) invokeLL.objValue;
    }

    @Nullable
    @SuppressLint({"BDThrowableCheck"})
    public static Bundle d(@NonNull Class<? extends ProviderDelegation> cls, @Nullable Bundle bundle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, cls, bundle)) == null) {
            if (ProcessUtils.isMainProcess()) {
                ProviderDelegation a2 = vw2.a(cls);
                if (a2 == null) {
                    try {
                        a2 = cls.newInstance();
                    } catch (Exception e) {
                        hx1.d("SwanProcessCallManager", "callOnMainProcess", e);
                    }
                }
                if (a2 != null) {
                    return a2.execCall(bundle);
                }
                return null;
            }
            return null;
        }
        return (Bundle) invokeLL.objValue;
    }

    @Nullable
    @SuppressLint({"BDThrowableCheck"})
    public static Bundle e(@NonNull String str, @Nullable Bundle bundle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, bundle)) == null) {
            if (ProcessUtils.isMainProcess()) {
                ProviderDelegation b = vw2.b(str);
                if (b == null) {
                    try {
                        b = (ProviderDelegation) Class.forName(str).newInstance();
                    } catch (Exception e) {
                        hx1.d("SwanProcessCallManager", "callOnMainProcess", e);
                    }
                }
                if (b != null) {
                    return b.execCall(bundle);
                }
                return null;
            }
            return null;
        }
        return (Bundle) invokeLL.objValue;
    }
}
