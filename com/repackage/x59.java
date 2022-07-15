package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class x59 implements e69 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public k59 a;
    public int b;
    public int c;
    public boolean d;

    public x59() {
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
        this.d = true;
    }

    @Override // com.repackage.e69
    public int a(byte[] bArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, bArr, i)) == null) {
            k59 k59Var = this.a;
            if (k59Var == null || bArr == null) {
                return 0;
            }
            this.b += bArr.length;
            k59Var.putBytes(bArr, i);
            return this.b;
        }
        return invokeLI.intValue;
    }

    @Override // com.repackage.e69
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? b() && this.d && this.a.available() : invokeV.booleanValue;
    }

    @Override // com.repackage.e69
    public boolean a(int i, int i2, int i3, int i4) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(Constants.METHOD_SEND_USER_MSG, this, i, i2, i3, i4)) == null) {
            if (this.a == null) {
                this.a = (k59) m99.a("com.baidu.ugc.audioedit.AudioChangeOperator");
            }
            k59 k59Var = this.a;
            if (k59Var != null) {
                k59Var.initVoiceChanger(i, i2, i3, i4);
            }
            return this.a != null;
        }
        return invokeIIII.booleanValue;
    }

    @Override // com.repackage.e69
    public byte[] a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            k59 k59Var = this.a;
            if (k59Var == null || k59Var.availableBytes() <= 0) {
                return new byte[0];
            }
            byte[] bArr = new byte[4096];
            int bytes = this.a.getBytes(bArr, 4096);
            this.c += bytes;
            if (bytes == 0) {
                return null;
            }
            if (4096 == bytes) {
                return bArr;
            }
            byte[] bArr2 = new byte[bytes];
            System.arraycopy(bArr, 0, bArr2, 0, bytes);
            return bArr2;
        }
        return (byte[]) invokeI.objValue;
    }

    public void b(int[] iArr) {
        k59 k59Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, iArr) == null) || (k59Var = this.a) == null) {
            return;
        }
        k59Var.setVoiceChangeType(iArr);
    }

    @Override // com.repackage.e69
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a != null : invokeV.booleanValue;
    }

    @Override // com.repackage.e69
    public void c() {
        k59 k59Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (k59Var = this.a) == null) {
            return;
        }
        k59Var.flush();
    }

    public void c(int[] iArr, int[] iArr2, double[] dArr) {
        k59 k59Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048583, this, iArr, iArr2, dArr) == null) || (k59Var = this.a) == null) {
            return;
        }
        k59Var.setVoiceChangeType(iArr, iArr2, dArr);
    }

    @Override // com.repackage.e69
    public void d() {
        k59 k59Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (k59Var = this.a) == null) {
            return;
        }
        k59Var.close();
        this.a = null;
    }

    @Override // com.repackage.e69
    public void e() {
        k59 k59Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (k59Var = this.a) == null) {
            return;
        }
        k59Var.clearQueues();
    }
}
