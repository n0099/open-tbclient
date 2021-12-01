package com.kuaishou.weapon.un;

import android.content.IntentFilter;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class r {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f56821b;

    /* renamed from: c  reason: collision with root package name */
    public String f56822c;

    /* renamed from: d  reason: collision with root package name */
    public IntentFilter f56823d;

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
        this.f56821b = str2;
        this.f56822c = str3;
        this.f56823d = intentFilter;
    }

    public boolean a(r rVar) {
        InterceptResult invokeL;
        IntentFilter intentFilter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, rVar)) == null) {
            if (rVar == null || TextUtils.isEmpty(rVar.a) || TextUtils.isEmpty(rVar.f56821b) || TextUtils.isEmpty(rVar.f56822c) || !rVar.a.equals(this.a) || !rVar.f56821b.equals(this.f56821b) || !rVar.f56822c.equals(this.f56822c)) {
                return false;
            }
            IntentFilter intentFilter2 = rVar.f56823d;
            return intentFilter2 == null || (intentFilter = this.f56823d) == null || intentFilter == intentFilter2;
        }
        return invokeL.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            try {
                return "WeaponSDKIntentFilter:" + this.a + "-" + this.f56821b + "-" + this.f56822c + "-" + this.f56823d;
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }
}
