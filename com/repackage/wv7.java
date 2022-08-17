package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ue;
/* loaded from: classes7.dex */
public class wv7 {
    public static /* synthetic */ Interceptable $ic;
    public static wv7 c;
    public transient /* synthetic */ FieldHolder $fh;
    public ue<byte[]> a;
    public ue<byte[]> b;

    public wv7() {
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
        this.a = null;
        this.b = null;
        c();
    }

    public static synchronized wv7 b() {
        InterceptResult invokeV;
        wv7 wv7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (wv7.class) {
                if (c == null) {
                    c = new wv7();
                }
                wv7Var = c;
            }
            return wv7Var;
        }
        return (wv7) invokeV.objValue;
    }

    public byte[] a(String str, boolean z) {
        InterceptResult invokeLZ;
        ue.b<byte[]> h;
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, str, z)) == null) {
            if (z) {
                ue<byte[]> ueVar = this.a;
                if (ueVar != null && str != null) {
                    h = ueVar.h(str);
                }
                h = null;
            } else {
                ue<byte[]> ueVar2 = this.b;
                if (ueVar2 != null && str != null) {
                    h = ueVar2.h(str);
                }
                h = null;
            }
            if (h == null || (bArr = h.b) == null) {
                return null;
            }
            return bArr;
        }
        return (byte[]) invokeLZ.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.a == null) {
                tr4.f();
                this.a = tr4.d("tb.pb_mark");
            }
            if (this.b == null) {
                tr4.f();
                this.b = tr4.d("tb.pb_normal");
            }
        }
    }

    public void d(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, str, z) == null) {
            if (z) {
                ue<byte[]> ueVar = this.a;
                if (ueVar == null || str == null) {
                    return;
                }
                ueVar.i(str, new byte[0], 0L);
                return;
            }
            ue<byte[]> ueVar2 = this.b;
            if (ueVar2 == null || str == null) {
                return;
            }
            ueVar2.i(str, new byte[0], 0L);
        }
    }

    public void e(String str, boolean z, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, Boolean.valueOf(z), bArr}) == null) || str == null) {
            return;
        }
        c();
        if (z) {
            this.a.e(str, bArr, 86400000L);
        } else {
            this.b.e(str, bArr, 86400000L);
        }
    }

    public void f(String str, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, str, bArr) == null) || bArr == null || str == null) {
            return;
        }
        c();
        this.a.e(str, bArr, 86400000L);
    }
}
