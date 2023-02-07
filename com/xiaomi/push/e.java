package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
/* loaded from: classes8.dex */
public abstract class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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

    public e a(byte[] bArr, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, bArr, i, i2)) == null) {
            try {
                b a = b.a(bArr, i, i2);
                a(a);
                a.m196a(0);
                return this;
            } catch (d e) {
                throw e;
            } catch (IOException unused) {
                throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
            }
        }
        return (e) invokeLII.objValue;
    }

    public abstract void a(c cVar);

    /* renamed from: a  reason: collision with other method in class */
    public void m369a(byte[] bArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048581, this, bArr, i, i2) == null) {
            try {
                c a = c.a(bArr, i, i2);
                a(a);
                a.b();
            } catch (IOException unused) {
                throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).");
            }
        }
    }

    public boolean a(b bVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, bVar, i)) == null) ? bVar.m198a(i) : invokeLI.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m370a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            int b = b();
            byte[] bArr = new byte[b];
            m369a(bArr, 0, b);
            return bArr;
        }
        return (byte[]) invokeV.objValue;
    }

    public abstract int b();
}
