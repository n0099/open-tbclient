package d.a.o0.h.t.b;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Singleton
@Service
/* loaded from: classes7.dex */
public class a implements d.a.o0.f.i.m.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
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

    @Override // d.a.o0.f.i.m.b.a
    public long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? d.a.o0.h.m0.d.A().n() : invokeV.longValue;
    }

    @Override // d.a.o0.f.i.m.b.a
    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            d.a.o0.h.a.c.b(z ? "gdtvideo" : "video", null);
        }
    }

    @Override // d.a.o0.f.i.m.b.a
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? d.a.o0.h.m0.d.A().C() : invokeV.booleanValue;
    }

    @Override // d.a.o0.f.i.m.b.a
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? d.a.o0.h.m0.d.A().B() : invokeV.booleanValue;
    }

    @Override // d.a.o0.f.i.m.b.a
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? d.a.o0.h.m0.d.A().v() : (String) invokeV.objValue;
    }

    @Override // d.a.o0.f.i.m.b.a
    public long f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? d.a.o0.h.m0.d.A().o() : invokeV.longValue;
    }

    @Override // d.a.o0.f.i.m.b.a
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? d.a.o0.h.m0.d.A().z() : (String) invokeV.objValue;
    }

    @Override // d.a.o0.f.i.m.b.a
    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? d.a.o0.h.m0.d.A().p() : invokeV.longValue;
    }

    @Override // d.a.o0.f.i.m.b.a
    public Long i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? d.a.o0.h.m0.d.A().w() : (Long) invokeV.objValue;
    }

    @Override // d.a.o0.f.i.m.b.a
    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? d.a.o0.h.m0.d.A().q() : invokeV.booleanValue;
    }

    @Override // d.a.o0.f.i.m.b.a
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? d.a.o0.h.m0.d.A().u() : invokeV.booleanValue;
    }

    @Override // d.a.o0.f.i.m.b.a
    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? d.a.o0.h.m0.d.A().x() : (String) invokeV.objValue;
    }

    @Override // d.a.o0.f.i.m.b.a
    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? d.a.o0.h.m0.d.A().y() : (String) invokeV.objValue;
    }
}
