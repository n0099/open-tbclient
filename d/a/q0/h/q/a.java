package d.a.q0.h.q;

import android.util.Log;
import com.baidu.searchbox.v8engine.console.DebugConsole;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.k;
import d.a.q0.h.f0.h;
/* loaded from: classes8.dex */
public class a implements DebugConsole {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f53575b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f53576a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1035728810, "Ld/a/q0/h/q/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1035728810, "Ld/a/q0/h/q/a;");
                return;
            }
        }
        f53575b = k.f49133a;
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

    @Override // com.baidu.searchbox.v8engine.console.DebugConsole
    public void onReceiveInfo(int i2, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) && f53575b && !h.d()) {
            if (i2 == 0) {
                Log.d("arConsole", String.format("%s: %s %s", "queue event", "", str));
            } else if (i2 == 1) {
                this.f53576a = System.currentTimeMillis();
                Log.d("arConsole", String.format("%s: %s %s", "run event start", "", str));
            } else if (i2 != 2) {
            } else {
                Log.d("arConsole", String.format("%s: %s %s", "run event end", Long.valueOf(System.currentTimeMillis() - this.f53576a), str));
            }
        }
    }
}
