package com.kuaishou.weapon.un;

import android.content.IntentFilter;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class r {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f57402b;

    /* renamed from: c  reason: collision with root package name */
    public String f57403c;

    /* renamed from: d  reason: collision with root package name */
    public IntentFilter f57404d;

    public r(String str, String str2, String str3, IntentFilter intentFilter) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, intentFilter};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = str;
        this.f57402b = str2;
        this.f57403c = str3;
        this.f57404d = intentFilter;
    }

    public boolean a(r rVar) {
        InterceptResult invokeL;
        IntentFilter intentFilter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, rVar)) == null) {
            if (rVar == null || TextUtils.isEmpty(rVar.a) || TextUtils.isEmpty(rVar.f57402b) || TextUtils.isEmpty(rVar.f57403c) || !rVar.a.equals(this.a) || !rVar.f57402b.equals(this.f57402b) || !rVar.f57403c.equals(this.f57403c)) {
                return false;
            }
            IntentFilter intentFilter2 = rVar.f57404d;
            return intentFilter2 == null || (intentFilter = this.f57404d) == null || intentFilter == intentFilter2;
        }
        return invokeL.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            try {
                return "WeaponSDKIntentFilter:" + this.a + "-" + this.f57402b + "-" + this.f57403c + "-" + this.f57404d;
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }
}
