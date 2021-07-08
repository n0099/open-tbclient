package d.a.n0.a.r1.p;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes7.dex */
public class c implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<Long> f47184a;

    /* renamed from: b  reason: collision with root package name */
    public long f47185b;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f47184a = new ArrayList();
        this.f47185b = -1L;
    }

    @Override // d.a.n0.a.r1.p.e
    public long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            List<Long> list = this.f47184a;
            if (list == null || list.size() <= 0 || this.f47185b < 0) {
                return -1L;
            }
            return this.f47185b - ((Long) Collections.min(this.f47184a)).longValue();
        }
        return invokeV.longValue;
    }

    @Override // d.a.n0.a.r1.p.e
    public void b(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            this.f47185b = j;
        }
    }

    @Override // d.a.n0.a.r1.p.e
    public void c(long j) {
        List<Long> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) || (list = this.f47184a) == null) {
            return;
        }
        list.add(Long.valueOf(j));
    }

    @Override // d.a.n0.a.r1.p.e
    public String getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "PageUpdateRender" : (String) invokeV.objValue;
    }
}
