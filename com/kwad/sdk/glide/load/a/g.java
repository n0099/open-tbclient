package com.kwad.sdk.glide.load.a;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.FilterInputStream;
import java.io.InputStream;
/* loaded from: classes7.dex */
public final class g extends FilterInputStream {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f37800a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f37801b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f37802c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public final byte f37803d;

    /* renamed from: e  reason: collision with root package name */
    public int f37804e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(85330566, "Lcom/kwad/sdk/glide/load/a/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(85330566, "Lcom/kwad/sdk/glide/load/a/g;");
                return;
            }
        }
        byte[] bArr = {-1, -31, 0, 28, 69, 120, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, 18, 0, 2, 0, 0, 0, 1, 0};
        f37800a = bArr;
        int length = bArr.length;
        f37801b = length;
        f37802c = length + 2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(InputStream inputStream, int i2) {
        super(inputStream);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputStream, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((InputStream) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (i2 >= -1 && i2 <= 8) {
            this.f37803d = (byte) i2;
            return;
        }
        throw new IllegalArgumentException("Cannot add invalid orientation: " + i2);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int i3 = this.f37804e;
            int read = (i3 < 2 || i3 > (i2 = f37802c)) ? super.read() : i3 == i2 ? this.f37803d : f37800a[i3 - 2] & 255;
            if (read != -1) {
                this.f37804e++;
            }
            return read;
        }
        return invokeV.intValue;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(@NonNull byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, bArr, i2, i3)) == null) {
            int i5 = this.f37804e;
            int i6 = f37802c;
            if (i5 > i6) {
                i4 = super.read(bArr, i2, i3);
            } else if (i5 == i6) {
                bArr[i2] = this.f37803d;
                i4 = 1;
            } else if (i5 < 2) {
                i4 = super.read(bArr, i2, 2 - i5);
            } else {
                int min = Math.min(i6 - i5, i3);
                System.arraycopy(f37800a, this.f37804e - 2, bArr, i2, min);
                i4 = min;
            }
            if (i4 > 0) {
                this.f37804e += i4;
            }
            return i4;
        }
        return invokeLII.intValue;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j)) == null) {
            long skip = super.skip(j);
            if (skip > 0) {
                this.f37804e = (int) (this.f37804e + skip);
            }
            return skip;
        }
        return invokeJ.longValue;
    }
}
