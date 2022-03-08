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
    public String f53788b;

    /* renamed from: c  reason: collision with root package name */
    public String f53789c;

    /* renamed from: d  reason: collision with root package name */
    public IntentFilter f53790d;

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
        this.f53788b = str2;
        this.f53789c = str3;
        this.f53790d = intentFilter;
    }

    public boolean a(r rVar) {
        InterceptResult invokeL;
        IntentFilter intentFilter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, rVar)) == null) {
            if (rVar == null || TextUtils.isEmpty(rVar.a) || TextUtils.isEmpty(rVar.f53788b) || TextUtils.isEmpty(rVar.f53789c) || !rVar.a.equals(this.a) || !rVar.f53788b.equals(this.f53788b) || !rVar.f53789c.equals(this.f53789c)) {
                return false;
            }
            IntentFilter intentFilter2 = rVar.f53790d;
            return intentFilter2 == null || (intentFilter = this.f53790d) == null || intentFilter == intentFilter2;
        }
        return invokeL.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            try {
                return "WeaponSDKIntentFilter:" + this.a + "-" + this.f53788b + "-" + this.f53789c + "-" + this.f53790d;
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }
}
