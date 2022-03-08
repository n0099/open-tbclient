package com.kuaishou.weapon.i;

import android.location.Location;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.un.l1;
import java.util.List;
/* loaded from: classes7.dex */
public class WeaponE implements WeaponEI {
    public static /* synthetic */ Interceptable $ic;
    public static WeaponE sInstance;
    public transient /* synthetic */ FieldHolder $fh;

    public WeaponE() {
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

    public static synchronized WeaponE getInstance() {
        InterceptResult invokeV;
        WeaponE weaponE;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (WeaponE.class) {
                if (sInstance == null) {
                    sInstance = new WeaponE();
                }
                weaponE = sInstance;
            }
            return weaponE;
        }
        return (WeaponE) invokeV.objValue;
    }

    @Override // com.kuaishou.weapon.i.WeaponEI
    public String getA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? l1.a() : (String) invokeV.objValue;
    }

    @Override // com.kuaishou.weapon.i.WeaponEI
    public List<String> getAL() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? l1.e() : (List) invokeV.objValue;
    }

    @Override // com.kuaishou.weapon.i.WeaponEI
    public String getI() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? l1.c() : (String) invokeV.objValue;
    }

    @Override // com.kuaishou.weapon.i.WeaponEI
    public String[] getIs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? l1.d() : (String[]) invokeV.objValue;
    }

    @Override // com.kuaishou.weapon.i.WeaponEI
    public String getM() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? l1.g() : (String) invokeV.objValue;
    }

    @Override // com.kuaishou.weapon.i.WeaponEI
    public Location getP() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? l1.f() : (Location) invokeV.objValue;
    }
}
