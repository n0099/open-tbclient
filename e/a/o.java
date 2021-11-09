package e.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class o {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static o f71673a;

    /* renamed from: b  reason: collision with root package name */
    public static Executor f71674b;
    public transient /* synthetic */ FieldHolder $fh;

    public o() {
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

    public static o b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f71673a == null) {
                synchronized (o.class) {
                    if (f71673a == null) {
                        f71673a = new o();
                        f71674b = Executors.newFixedThreadPool(1);
                    }
                }
            }
            return f71673a;
        }
        return (o) invokeV.objValue;
    }

    public void a(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, runnable) == null) || runnable == null) {
            return;
        }
        try {
            f71674b.execute(runnable);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
