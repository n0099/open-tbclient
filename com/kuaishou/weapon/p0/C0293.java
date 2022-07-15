package com.kuaishou.weapon.p0;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* renamed from: com.kuaishou.weapon.p0.ʻʼ  reason: contains not printable characters */
/* loaded from: classes5.dex */
public class C0293 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: ʻ  reason: contains not printable characters */
    public int f16;

    /* renamed from: ʼ  reason: contains not printable characters */
    public String f17;

    /* renamed from: ʽ  reason: contains not printable characters */
    public String f18;

    public C0293() {
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
        this.f18 = "";
        this.f17 = "";
        this.f16 = 0;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public String m83() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f18 : (String) invokeV.objValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public void m84(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.f16 = i;
        }
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public void m85(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f18 = str;
        }
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public int m86() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f16 : invokeV.intValue;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public void m87(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f17 = str;
        }
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public String m88() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f17 : (String) invokeV.objValue;
    }
}
