package d.a.q0.a.n0.j.e;

import android.os.Bundle;
import android.util.Log;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.k;
import d.a.q0.a.v1.b.d;
import d.a.q0.a.v1.b.f;
/* loaded from: classes8.dex */
public class a extends ProviderDelegation {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f49557a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1427269693, "Ld/a/q0/a/n0/j/e/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1427269693, "Ld/a/q0/a/n0/j/e/a;");
                return;
            }
        }
        f49557a = k.f49133a;
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
            }
        }
    }

    public static int a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
            if (ProcessUtils.isMainProcess()) {
                return b.b().c(i2);
            }
            Bundle bundle = new Bundle();
            bundle.putInt("level", i2);
            f b2 = d.b(a.class, bundle);
            int i3 = b2.a() ? b2.f51225a.getInt("count", 0) : 0;
            if (f49557a) {
                Log.d("RecoveryCountDelegation", "GetRecoveryCount level=" + i2 + ";count=" + i3);
            }
            return i3;
        }
        return invokeI.intValue;
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
    public Bundle execCall(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bundle)) == null) {
            int i2 = bundle.getInt("level", -1);
            Bundle bundle2 = new Bundle();
            bundle2.putInt("count", b.b().c(i2));
            return bundle2;
        }
        return (Bundle) invokeL.objValue;
    }
}
