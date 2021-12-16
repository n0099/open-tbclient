package com.kuaishou.weapon.i;

import android.content.IntentFilter;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.un.l1;
import com.kuaishou.weapon.un.n;
import com.kuaishou.weapon.un.o;
import com.kuaishou.weapon.un.r;
import com.kuaishou.weapon.un.x;
/* loaded from: classes3.dex */
public class WeaponA implements WeaponAI {
    public static /* synthetic */ Interceptable $ic;
    public static WeaponA sInstance;
    public transient /* synthetic */ FieldHolder $fh;

    public WeaponA() {
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

    public static synchronized WeaponA getInstance() {
        InterceptResult invokeV;
        WeaponA weaponA;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (WeaponA.class) {
                if (sInstance == null) {
                    sInstance = new WeaponA();
                }
                weaponA = sInstance;
            }
            return weaponA;
        }
        return (WeaponA) invokeV.objValue;
    }

    @Override // com.kuaishou.weapon.i.WeaponAI
    public void cm(String str, String str2, String str3, WeaponCB weaponCB, Class<?>[] clsArr, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, str2, str3, weaponCB, clsArr, objArr}) == null) {
        }
    }

    @Override // com.kuaishou.weapon.i.WeaponAI
    public String p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            o c2 = o.c();
            if (c2 != null) {
                return c2.c(str);
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.kuaishou.weapon.i.WeaponAI
    public void r(String str, IntentFilter intentFilter, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, str, intentFilter, str2, str3) == null) || TextUtils.isEmpty(str) || intentFilter == null || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            o c2 = o.c();
            if (c2 == null) {
                return;
            }
            c2.a(new r(str, str2, str3, intentFilter));
        } catch (Throwable th) {
            l1.a(th);
        }
    }

    @Override // com.kuaishou.weapon.i.WeaponAI
    public void sp(String str, boolean z) {
        x i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048579, this, str, z) == null) || (i2 = x.i()) == null) {
            return;
        }
        i2.a(str, z ? 1 : 0);
    }

    @Override // com.kuaishou.weapon.i.WeaponAI
    public void ssb(int i2, boolean z) {
        x i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || (i3 = x.i()) == null) {
            return;
        }
        i3.a(i2, z ? 1 : 0);
    }

    @Override // com.kuaishou.weapon.i.WeaponAI
    public void u(String str) {
        n i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || (i2 = n.i()) == null) {
            return;
        }
        i2.b(str);
    }

    @Override // com.kuaishou.weapon.i.WeaponAI
    public void ur(String str, IntentFilter intentFilter, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048582, this, str, intentFilter, str2, str3) == null) || TextUtils.isEmpty(str) || intentFilter == null || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            o c2 = o.c();
            if (c2 == null) {
                return;
            }
            c2.b(new r(str, str2, str3, intentFilter));
        } catch (Throwable th) {
            l1.a(th);
        }
    }
}
