package d.b.c.b.f;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.b.c.b.h.a.e;
import d.b.c.b.l;
/* loaded from: classes10.dex */
public class c implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f71858a;

    public c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f71858a = context;
    }

    @Override // d.b.c.b.f.b
    public void a(long j, Thread thread, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), thread, th}) == null) {
            d.b.c.b.e.a c2 = d.b.c.b.e.a.c(j, this.f71858a, thread, th);
            l.e.d(this.f71858a, com.bytedance.tea.crash.c.f32269b.a(), Thread.currentThread().getName());
            d.b.c.b.n.a.a().b(e.c().a(com.bytedance.tea.crash.c.f32269b, c2).j());
        }
    }

    @Override // d.b.c.b.f.b
    public boolean a(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }
}
