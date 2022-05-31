package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.qe;
/* loaded from: classes5.dex */
public class as7 {
    public static /* synthetic */ Interceptable $ic;
    public static as7 c;
    public transient /* synthetic */ FieldHolder $fh;
    public qe<byte[]> a;
    public qe<byte[]> b;

    public as7() {
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

    public static synchronized as7 b() {
        InterceptResult invokeV;
        as7 as7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (as7.class) {
                if (c == null) {
                    c = new as7();
                }
                as7Var = c;
            }
            return as7Var;
        }
        return (as7) invokeV.objValue;
    }

    public byte[] a(String str, boolean z) {
        InterceptResult invokeLZ;
        qe.b<byte[]> h;
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, str, z)) == null) {
            if (z) {
                qe<byte[]> qeVar = this.a;
                if (qeVar != null && str != null) {
                    h = qeVar.h(str);
                }
                h = null;
            } else {
                qe<byte[]> qeVar2 = this.b;
                if (qeVar2 != null && str != null) {
                    h = qeVar2.h(str);
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
                cq4.f();
                this.a = cq4.d("tb.pb_mark");
            }
            if (this.b == null) {
                cq4.f();
                this.b = cq4.d("tb.pb_normal");
            }
        }
    }

    public void d(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, str, z) == null) {
            if (z) {
                qe<byte[]> qeVar = this.a;
                if (qeVar == null || str == null) {
                    return;
                }
                qeVar.i(str, new byte[0], 0L);
                return;
            }
            qe<byte[]> qeVar2 = this.b;
            if (qeVar2 == null || str == null) {
                return;
            }
            qeVar2.i(str, new byte[0], 0L);
        }
    }

    public void e(String str, boolean z, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, Boolean.valueOf(z), bArr}) == null) || str == null) {
            return;
        }
        c();
        if (z) {
            this.a.e(str, bArr, 604800000L);
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
        this.a.e(str, bArr, 2592000000L);
    }
}
