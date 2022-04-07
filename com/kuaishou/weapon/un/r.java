package com.kuaishou.weapon.un;

import android.content.IntentFilter;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class r {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public IntentFilter d;

    public r(String str, String str2, String str3, IntentFilter intentFilter) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, intentFilter};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = intentFilter;
    }

    public boolean a(r rVar) {
        InterceptResult invokeL;
        IntentFilter intentFilter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, rVar)) == null) {
            if (rVar == null || TextUtils.isEmpty(rVar.a) || TextUtils.isEmpty(rVar.b) || TextUtils.isEmpty(rVar.c) || !rVar.a.equals(this.a) || !rVar.b.equals(this.b) || !rVar.c.equals(this.c)) {
                return false;
            }
            IntentFilter intentFilter2 = rVar.d;
            return intentFilter2 == null || (intentFilter = this.d) == null || intentFilter == intentFilter2;
        }
        return invokeL.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            try {
                return "WeaponSDKIntentFilter:" + this.a + "-" + this.b + "-" + this.c + "-" + this.d;
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }
}
