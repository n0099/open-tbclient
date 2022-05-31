package com.repackage;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class bh0 implements eh0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final dh0 f;
    public final fh0 g;
    public final gh0 h;

    public bh0() {
        fh0 fh0Var;
        gh0 gh0Var;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = xg0.c().a();
        synchronized (xg0.class) {
            fh0Var = (fh0) ServiceManager.getService(fh0.b);
            fh0Var = fh0Var == null ? fh0.c : fh0Var;
        }
        this.g = fh0Var;
        synchronized (xg0.class) {
            gh0Var = (gh0) ServiceManager.getService(gh0.d);
            gh0Var = gh0Var == null ? gh0.e : gh0Var;
        }
        this.h = gh0Var;
    }

    @Override // com.repackage.dh0
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f.a() : (String) invokeV.objValue;
    }

    @Override // com.repackage.dh0
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f.b() : (String) invokeV.objValue;
    }

    @Override // com.repackage.dh0
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f.c() : (String) invokeV.objValue;
    }

    @Override // com.repackage.dh0
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f.d() : (String) invokeV.objValue;
    }

    @Override // com.repackage.dh0
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f.e() : (String) invokeV.objValue;
    }

    @Override // com.repackage.fh0
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.g.f() : (String) invokeV.objValue;
    }

    @Override // com.repackage.dh0
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f.g() : (String) invokeV.objValue;
    }

    @Override // com.repackage.dh0
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f.h() : (String) invokeV.objValue;
    }

    @Override // com.repackage.dh0
    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f.i() : (String) invokeV.objValue;
    }

    @Override // com.repackage.dh0
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f.j() : (String) invokeV.objValue;
    }

    @Override // com.repackage.dh0
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f.k() : (String) invokeV.objValue;
    }

    @Override // com.repackage.dh0
    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f.l() : (String) invokeV.objValue;
    }

    @Override // com.repackage.dh0
    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f.m() : (String) invokeV.objValue;
    }

    @Override // com.repackage.gh0
    public String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.h.n() : (String) invokeV.objValue;
    }

    @Override // com.repackage.dh0
    @NonNull
    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f.o() : (String) invokeV.objValue;
    }

    @Override // com.repackage.dh0
    public String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f.p() : (String) invokeV.objValue;
    }

    @Override // com.repackage.dh0
    public String packageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f.packageName() : (String) invokeV.objValue;
    }

    @Override // com.repackage.dh0
    public String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f.q() : (String) invokeV.objValue;
    }

    @Override // com.repackage.gh0
    public String r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.h.r() : (String) invokeV.objValue;
    }

    @Override // com.repackage.gh0
    public String s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.h.s() : (String) invokeV.objValue;
    }

    @Override // com.repackage.dh0
    public String t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f.t() : (String) invokeV.objValue;
    }

    @Override // com.repackage.dh0
    public String u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f.u() : (String) invokeV.objValue;
    }

    @Override // com.repackage.dh0
    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f.v() : invokeV.booleanValue;
    }
}
