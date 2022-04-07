package com.kuaishou.weapon.i;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.un.z1;
/* loaded from: classes5.dex */
public class WeaponB implements WeaponBI {
    public static /* synthetic */ Interceptable $ic;
    public static WeaponB sInstance;
    public transient /* synthetic */ FieldHolder $fh;

    public WeaponB() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static synchronized WeaponB getInstance() {
        InterceptResult invokeV;
        WeaponB weaponB;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (WeaponB.class) {
                if (sInstance == null) {
                    sInstance = new WeaponB();
                }
                weaponB = sInstance;
            }
            return weaponB;
        }
        return (WeaponB) invokeV.objValue;
    }

    @Override // com.kuaishou.weapon.i.WeaponBI
    public void t(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            try {
                z1 d = z1.d();
                if (d != null) {
                    d.a(str);
                }
            } catch (Exception unused) {
            }
        }
    }
}
