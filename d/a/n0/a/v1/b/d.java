package d.a.n0.a.v1.b;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.IProcessBridge;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static Bundle a(@NonNull Class<? extends ProviderDelegation> cls, @Nullable Bundle bundle) {
        InterceptResult invokeLL;
        IProcessBridge G;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, cls, bundle)) == null) {
            if (d.a.n0.a.r1.l.b.k()) {
                if (ProcessUtils.isMainProcess()) {
                    return c(cls, bundle);
                }
                d.a.n0.a.v1.c.e.a z = d.a.n0.a.a2.d.g().z();
                if (z != null && (G = z.G()) != null) {
                    try {
                        Bundle callMainProcessSync = G.callMainProcessSync(cls.getName(), bundle);
                        return callMainProcessSync == null ? new Bundle() : callMainProcessSync;
                    } catch (Throwable th) {
                        d.a.n0.a.e0.d.c("SwanProcessCallManager", "callMainProcessSync", th);
                    }
                }
            }
            return DelegateUtils.callOnMainWithContentProvider(d.a.n0.a.c1.a.b(), cls, bundle).mResult;
        }
        return (Bundle) invokeLL.objValue;
    }

    @NonNull
    public static f b(@NonNull Class<? extends ProviderDelegation> cls, @Nullable Bundle bundle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, cls, bundle)) == null) ? new f(a(cls, bundle)) : (f) invokeLL.objValue;
    }

    @Nullable
    public static Bundle c(@NonNull Class<? extends ProviderDelegation> cls, @Nullable Bundle bundle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, cls, bundle)) == null) {
            if (ProcessUtils.isMainProcess()) {
                ProviderDelegation a2 = e.a(cls);
                if (a2 == null) {
                    try {
                        a2 = cls.newInstance();
                    } catch (Exception e2) {
                        d.a.n0.a.e0.d.c("SwanProcessCallManager", "callOnMainProcess", e2);
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
    public static Bundle d(@NonNull String str, @Nullable Bundle bundle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, bundle)) == null) {
            if (ProcessUtils.isMainProcess()) {
                ProviderDelegation b2 = e.b(str);
                if (b2 == null) {
                    try {
                        b2 = (ProviderDelegation) Class.forName(str).newInstance();
                    } catch (Exception e2) {
                        d.a.n0.a.e0.d.c("SwanProcessCallManager", "callOnMainProcess", e2);
                    }
                }
                if (b2 != null) {
                    return b2.execCall(bundle);
                }
                return null;
            }
            return null;
        }
        return (Bundle) invokeLL.objValue;
    }
}
