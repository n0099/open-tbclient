package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class jj extends jl {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public it f798a;

    public jj(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f798a = new it(i);
    }

    @Override // com.xiaomi.push.jl
    public int a(byte[] bArr, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, bArr, i, i2)) == null) {
            byte[] m554a = this.f798a.m554a();
            if (i2 > this.f798a.a() - this.a) {
                i2 = this.f798a.a() - this.a;
            }
            if (i2 > 0) {
                System.arraycopy(m554a, this.a, bArr, i, i2);
                this.a += i2;
            }
            return i2;
        }
        return invokeLII.intValue;
    }

    @Override // com.xiaomi.push.jl
    public void a(byte[] bArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr, i, i2) == null) {
            this.f798a.write(bArr, i, i2);
        }
    }

    public int a_() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f798a.size() : invokeV.intValue;
    }
}
