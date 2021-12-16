package com.kwad.sdk.kwai;

import android.location.Location;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.IWeaponInitParams;
import com.kwad.sdk.core.config.b;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.av;
import java.util.List;
/* loaded from: classes3.dex */
public class a implements IWeaponInitParams {
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

    @Override // com.kuaishou.weapon.IWeaponInitParams
    public String getAndroidID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? ao.f() : (String) invokeV.objValue;
    }

    @Override // com.kuaishou.weapon.IWeaponInitParams
    public String getAppKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "400000" : (String) invokeV.objValue;
    }

    @Override // com.kuaishou.weapon.IWeaponInitParams
    public String getChannel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "" : (String) invokeV.objValue;
    }

    @Override // com.kuaishou.weapon.IWeaponInitParams
    public String getDeviceId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? av.u() : (String) invokeV.objValue;
    }

    @Override // com.kuaishou.weapon.IWeaponInitParams
    public String getHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "" : (String) invokeV.objValue;
    }

    @Override // com.kuaishou.weapon.IWeaponInitParams
    public String getImei() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? ao.d() : (String) invokeV.objValue;
    }

    @Override // com.kuaishou.weapon.IWeaponInitParams
    public String[] getImeis() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? ao.e() : (String[]) invokeV.objValue;
    }

    @Override // com.kuaishou.weapon.IWeaponInitParams
    public List<String> getInstalledPackages() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? ao.n() : (List) invokeV.objValue;
    }

    @Override // com.kuaishou.weapon.IWeaponInitParams
    public Location getLocation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? ao.b() : (Location) invokeV.objValue;
    }

    @Override // com.kuaishou.weapon.IWeaponInitParams
    public String getMacAddress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? ao.h() : (String) invokeV.objValue;
    }

    @Override // com.kuaishou.weapon.IWeaponInitParams
    public String getOaid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? com.kwad.sdk.core.f.a.a() : (String) invokeV.objValue;
    }

    @Override // com.kuaishou.weapon.IWeaponInitParams
    public int getPS() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            long j2 = ao.c() ? 4227L : 0L;
            if (ao.g()) {
                j2 |= 4;
            }
            if (ao.i()) {
                j2 |= 2048;
            }
            if (ao.l()) {
                j2 |= 8192;
            }
            if (ao.a()) {
                j2 |= 64;
            }
            if (ao.k()) {
                j2 |= 40;
            }
            if (ao.m()) {
                j2 |= 16;
            }
            return (int) (j2 | b.Y());
        }
        return invokeV.intValue;
    }

    @Override // com.kuaishou.weapon.IWeaponInitParams
    public boolean getPrivacySwitch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.kuaishou.weapon.IWeaponInitParams
    public String getProductName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? "ksadsdk" : (String) invokeV.objValue;
    }

    @Override // com.kuaishou.weapon.IWeaponInitParams
    public String getSecKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? "f12536c198aee4d8198aad2300827430" : (String) invokeV.objValue;
    }

    @Override // com.kuaishou.weapon.IWeaponInitParams
    public String getUserId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? "" : (String) invokeV.objValue;
    }
}
