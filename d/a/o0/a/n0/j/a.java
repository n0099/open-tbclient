package d.a.o0.a.n0.j;

import android.os.Bundle;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class a extends ProviderDelegation {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46752a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1477395925, "Ld/a/o0/a/n0/j/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1477395925, "Ld/a/o0/a/n0/j/a;");
                return;
            }
        }
        d.a.o0.a.c1.a.Z().getSwitch("swan_recovery_enable", true);
        f46752a = true;
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

    public static void a(d.a.o0.a.n0.j.f.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, aVar) == null) && f46752a && aVar != null) {
            if (ProcessUtils.isMainProcess()) {
                b.a(aVar).b();
                d.a.o0.a.n0.j.e.b.b().a(aVar.f46762a);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("recovery_level", aVar.f46762a);
            bundle.putStringArrayList("recovery_app_list", aVar.f46763b);
            DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), a.class, bundle);
        }
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
    public Bundle execCall(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bundle)) == null) {
            if (f46752a) {
                int i2 = bundle.getInt("recovery_level", -1);
                ArrayList<String> stringArrayList = bundle.getStringArrayList("recovery_app_list");
                d.a.o0.a.n0.j.f.a aVar = new d.a.o0.a.n0.j.f.a();
                aVar.f46762a = i2;
                if (stringArrayList != null) {
                    aVar.f46763b = stringArrayList;
                }
                b.a(aVar).b();
                d.a.o0.a.n0.j.e.b.b().a(aVar.f46762a);
                return null;
            }
            return null;
        }
        return (Bundle) invokeL.objValue;
    }
}
