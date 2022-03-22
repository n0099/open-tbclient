package com.kuaishou.weapon.un;

import android.content.IntentFilter;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class r {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f38963b;

    /* renamed from: c  reason: collision with root package name */
    public String f38964c;

    /* renamed from: d  reason: collision with root package name */
    public IntentFilter f38965d;

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
        this.f38963b = str2;
        this.f38964c = str3;
        this.f38965d = intentFilter;
    }

    public boolean a(r rVar) {
        InterceptResult invokeL;
        IntentFilter intentFilter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, rVar)) == null) {
            if (rVar == null || TextUtils.isEmpty(rVar.a) || TextUtils.isEmpty(rVar.f38963b) || TextUtils.isEmpty(rVar.f38964c) || !rVar.a.equals(this.a) || !rVar.f38963b.equals(this.f38963b) || !rVar.f38964c.equals(this.f38964c)) {
                return false;
            }
            IntentFilter intentFilter2 = rVar.f38965d;
            return intentFilter2 == null || (intentFilter = this.f38965d) == null || intentFilter == intentFilter2;
        }
        return invokeL.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            try {
                return "WeaponSDKIntentFilter:" + this.a + "-" + this.f38963b + "-" + this.f38964c + "-" + this.f38965d;
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }
}
