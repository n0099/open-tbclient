package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public static final a a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public volatile int f82a;

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f83a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1664386731, "Lcom/xiaomi/push/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1664386731, "Lcom/xiaomi/push/a;");
                return;
            }
        }
        a = new a(new byte[0]);
    }

    public a(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bArr};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f82a = 0;
        this.f83a = bArr;
    }

    public static a a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bArr)) == null) ? a(bArr, 0, bArr.length) : (a) invokeL.objValue;
    }

    public static a a(byte[] bArr, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65539, null, bArr, i, i2)) == null) {
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, i, bArr2, 0, i2);
            return new a(bArr2);
        }
        return (a) invokeLII.objValue;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f83a.length : invokeV.intValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m175a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            byte[] bArr = this.f83a;
            int length = bArr.length;
            byte[] bArr2 = new byte[length];
            System.arraycopy(bArr, 0, bArr2, 0, length);
            return bArr2;
        }
        return (byte[]) invokeV.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof a) {
                byte[] bArr = this.f83a;
                int length = bArr.length;
                byte[] bArr2 = ((a) obj).f83a;
                if (length != bArr2.length) {
                    return false;
                }
                for (int i = 0; i < length; i++) {
                    if (bArr[i] != bArr2[i]) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int i = this.f82a;
            if (i == 0) {
                byte[] bArr = this.f83a;
                int length = bArr.length;
                for (byte b : bArr) {
                    length = (length * 31) + b;
                }
                i = length == 0 ? 1 : length;
                this.f82a = i;
            }
            return i;
        }
        return invokeV.intValue;
    }
}
