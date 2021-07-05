package d.a.q0.h.m;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.k;
import d.a.q0.a.p0.a;
import d.a.q0.a.p0.d.b;
/* loaded from: classes8.dex */
public class a extends b<d.a.q0.h.m.d.a, d.a.q0.h.m.e.a> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f53378d;

    /* renamed from: e  reason: collision with root package name */
    public static volatile a f53379e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.q0.h.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C1149a extends a.C0910a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1149a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // d.a.q0.a.p0.a.C0910a
        public int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 1;
            }
            return invokeV.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1035609646, "Ld/a/q0/h/m/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1035609646, "Ld/a/q0/h/m/a;");
                return;
            }
        }
        f53378d = k.f49133a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a() {
        super(new d.a.q0.h.m.d.a(), new d.a.q0.h.m.e.a());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                super((d.a.q0.a.p0.h.b) objArr[0], (d.a.q0.a.p0.i.a) objArr[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static a i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f53379e == null) {
                synchronized (a.class) {
                    if (f53379e == null) {
                        f53379e = new a();
                    }
                }
            }
            return f53379e;
        }
        return (a) invokeV.objValue;
    }

    @Override // d.a.q0.a.p0.d.b
    public String b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            if (i2 == 1) {
                return d.a.q0.h.m.b.b.b().getPath();
            }
            return null;
        }
        return (String) invokeI.objValue;
    }

    @Override // d.a.q0.a.p0.d.b
    @Nullable
    public ExtensionCore c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (ProcessUtils.isMainProcess()) {
                return d();
            }
            Bundle bundle = DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), C1149a.class, null).mResult;
            bundle.setClassLoader(ExtensionCore.class.getClassLoader());
            ExtensionCore extensionCore = (ExtensionCore) bundle.getParcelable("aiapps_extension_core");
            if (f53378d) {
                Log.d("ExtCore-GamesManager", "getExtensionCore:" + ProcessUtils.getCurProcessName() + " extension core: " + extensionCore);
                return extensionCore;
            }
            return extensionCore;
        }
        return (ExtensionCore) invokeV.objValue;
    }
}
