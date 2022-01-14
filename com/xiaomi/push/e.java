package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
/* loaded from: classes4.dex */
public abstract class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public e() {
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

    public abstract int a();

    public abstract e a(b bVar);

    public e a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bArr)) == null) ? a(bArr, 0, bArr.length) : (e) invokeL.objValue;
    }

    public e a(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, bArr, i2, i3)) == null) {
            try {
                b a = b.a(bArr, i2, i3);
                a(a);
                a.m226a(0);
                return this;
            } catch (d e2) {
                throw e2;
            } catch (IOException unused) {
                throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
            }
        }
        return (e) invokeLII.objValue;
    }

    public abstract void a(c cVar);

    /* renamed from: a  reason: collision with other method in class */
    public void m344a(byte[] bArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048581, this, bArr, i2, i3) == null) {
            try {
                c a = c.a(bArr, i2, i3);
                a(a);
                a.b();
            } catch (IOException unused) {
                throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).");
            }
        }
    }

    public boolean a(b bVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, bVar, i2)) == null) ? bVar.m228a(i2) : invokeLI.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m345a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            int b2 = b();
            byte[] bArr = new byte[b2];
            m344a(bArr, 0, b2);
            return bArr;
        }
        return (byte[]) invokeV.objValue;
    }

    public abstract int b();
}
