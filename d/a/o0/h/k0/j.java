package d.a.o0.h.k0;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class j {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static ArrayList<g> f50564a;

    /* renamed from: b  reason: collision with root package name */
    public static ArrayList<Integer> f50565b;

    /* renamed from: c  reason: collision with root package name */
    public static final j f50566c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1864676117, "Ld/a/o0/h/k0/j;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1864676117, "Ld/a/o0/h/k0/j;");
                return;
            }
        }
        f50566c = new j();
        f50564a = new ArrayList<>();
        f50565b = new ArrayList<>();
    }

    public j() {
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

    public final void a(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || f50565b.contains(Integer.valueOf(i2))) {
            return;
        }
        f50565b.add(Integer.valueOf(i2));
    }

    public final g b(JSRuntime jsRuntime) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jsRuntime)) == null) {
            Intrinsics.checkNotNullParameter(jsRuntime, "jsRuntime");
            g gVar = new g(jsRuntime);
            f50564a.add(gVar);
            return gVar;
        }
        return (g) invokeL.objValue;
    }

    public final boolean c(g socket) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, socket)) == null) {
            Intrinsics.checkNotNullParameter(socket, "socket");
            return !f50564a.contains(socket);
        }
        return invokeL.booleanValue;
    }

    public final boolean d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? f50565b.contains(Integer.valueOf(i2)) : invokeI.booleanValue;
    }

    public final void e(g socket) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, socket) == null) {
            Intrinsics.checkNotNullParameter(socket, "socket");
            if (f50564a.contains(socket)) {
                g(socket.B());
                f50564a.remove(socket);
            }
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            Iterator<g> it = f50564a.iterator();
            while (it.hasNext()) {
                it.next().close();
            }
        }
    }

    public final void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            f50565b.remove(Integer.valueOf(i2));
        }
    }
}
