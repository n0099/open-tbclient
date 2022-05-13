package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.InvalidKeyException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
/* loaded from: classes5.dex */
public class e10 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public g10 a;

    public e10() {
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

    public static e10 a() throws NoSuchPaddingException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            e10 e10Var = new e10();
            g10 g10Var = new g10();
            e10Var.a = g10Var;
            g10Var.e("PKCS1Padding");
            return e10Var;
        }
        return (e10) invokeV.objValue;
    }

    public void b(int i, h10 h10Var) throws InvalidKeyException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, h10Var) == null) {
            this.a.a(i, h10Var, f10.a);
        }
    }

    public final byte[] c(byte[] bArr) throws IllegalBlockSizeException, BadPaddingException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr)) == null) {
            if (bArr != null) {
                return this.a.d(bArr, 0, bArr.length);
            }
            throw new IllegalArgumentException("Null input buffer");
        }
        return (byte[]) invokeL.objValue;
    }
}
