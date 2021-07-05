package d.a.q0.a.p.c;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.p.d.n;
/* loaded from: classes8.dex */
public class i implements d.a.q0.a.p.d.n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Boolean f49892a;

    public i() {
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

    @Override // d.a.q0.a.p.d.n
    public void a(n.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
            return;
        }
        aVar.onFinish();
    }

    @Override // d.a.q0.a.p.d.n
    public void b(Activity activity, Bundle bundle, d.a.q0.a.m.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, bundle, aVar) == null) {
            d.a.q0.a.s.a.f.f50510d.i(aVar);
        }
    }

    @Override // d.a.q0.a.p.d.n
    public void c(d.a.q0.a.m.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) || cVar == null) {
            return;
        }
        d.a.q0.a.s.a.f.f50510d.m(cVar);
    }

    @Override // d.a.q0.a.p.d.n
    public String d(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) ? d.a.q0.a.s.a.d.f50505a.a() : (String) invokeL.objValue;
    }

    @Override // d.a.q0.a.p.d.n
    public boolean e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            boolean g2 = d.a.q0.a.s.a.f.f50510d.g();
            this.f49892a = Boolean.TRUE;
            return g2;
        }
        return invokeL.booleanValue;
    }

    @Override // d.a.q0.a.p.d.n
    public String f(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) ? d.a.q0.u.b.b(context).a() : (String) invokeL.objValue;
    }

    @Override // d.a.q0.a.p.d.n
    public void g(n.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) || cVar == null) {
            return;
        }
        cVar.b();
    }

    @Override // d.a.q0.a.p.d.n
    public String h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, context)) == null) ? d.a.q0.a.s.a.h.f50521b.a() : (String) invokeL.objValue;
    }

    @Override // d.a.q0.a.p.d.n
    public String i(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context)) == null) ? d.a.q0.u.b.b(context).a() : (String) invokeL.objValue;
    }

    @Override // d.a.q0.a.p.d.n
    public void j(d.a.q0.a.m.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) {
        }
    }

    public boolean k(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, context)) == null) {
            if (this.f49892a == null) {
                e(context);
            }
            Boolean bool = this.f49892a;
            if (bool == null) {
                return false;
            }
            return bool.booleanValue();
        }
        return invokeL.booleanValue;
    }
}
