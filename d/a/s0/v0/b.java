package d.a.s0.v0;

import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes9.dex */
public class b implements c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicReference<c> f68209a;

    /* renamed from: b  reason: collision with root package name */
    public static final c f68210b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-624491487, "Ld/a/s0/v0/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-624491487, "Ld/a/s0/v0/b;");
                return;
            }
        }
        f68209a = new AtomicReference<>(null);
        f68210b = new b();
    }

    public b() {
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

    public static c e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            c cVar = f68209a.get();
            return cVar == null ? f68210b : cVar;
        }
        return (c) invokeV.objValue;
    }

    @Override // d.a.s0.v0.c
    public d.a.c.k.e.a<?, ?> a(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, baseFragmentActivity, bdUniqueId)) == null) {
            return null;
        }
        return (d.a.c.k.e.a) invokeLL.objValue;
    }

    @Override // d.a.s0.v0.c
    public d.a.c.k.e.a<?, ?> b(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, baseFragmentActivity, bdUniqueId)) == null) {
            return null;
        }
        return (d.a.c.k.e.a) invokeLL.objValue;
    }

    @Override // d.a.s0.v0.c
    public d.a.c.k.e.a<?, ?> c(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, baseFragmentActivity, bdUniqueId)) == null) {
            return null;
        }
        return (d.a.c.k.e.a) invokeLL.objValue;
    }

    @Override // d.a.s0.v0.c
    public d.a.c.k.e.a<?, ?> d(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, baseFragmentActivity, bdUniqueId)) == null) {
            return null;
        }
        return (d.a.c.k.e.a) invokeLL.objValue;
    }
}
