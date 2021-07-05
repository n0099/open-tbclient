package com.kwad.sdk.glide.load.a;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.OutputStream;
/* loaded from: classes7.dex */
public final class c extends OutputStream {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public final OutputStream f37793a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f37794b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.glide.load.engine.bitmap_recycle.b f37795c;

    /* renamed from: d  reason: collision with root package name */
    public int f37796d;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c(@NonNull OutputStream outputStream, @NonNull com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar) {
        this(outputStream, bVar, 65536);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {outputStream, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((OutputStream) objArr2[0], (com.kwad.sdk.glide.load.engine.bitmap_recycle.b) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @VisibleForTesting
    public c(@NonNull OutputStream outputStream, com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {outputStream, bVar, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f37793a = outputStream;
        this.f37795c = bVar;
        this.f37794b = (byte[]) bVar.a(i2, byte[].class);
    }

    private void a() {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, this) == null) || (i2 = this.f37796d) <= 0) {
            return;
        }
        this.f37793a.write(this.f37794b, 0, i2);
        this.f37796d = 0;
    }

    private void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, this) == null) && this.f37796d == this.f37794b.length) {
            a();
        }
    }

    private void c() {
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65540, this) == null) || (bArr = this.f37794b) == null) {
            return;
        }
        this.f37795c.a((com.kwad.sdk.glide.load.engine.bitmap_recycle.b) bArr);
        this.f37794b = null;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                flush();
                this.f37793a.close();
                c();
            } catch (Throwable th) {
                this.f37793a.close();
                throw th;
            }
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            a();
            this.f37793a.flush();
        }
    }

    @Override // java.io.OutputStream
    public void write(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            byte[] bArr = this.f37794b;
            int i3 = this.f37796d;
            this.f37796d = i3 + 1;
            bArr[i3] = (byte) i2;
            b();
        }
    }

    @Override // java.io.OutputStream
    public void write(@NonNull byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bArr) == null) {
            write(bArr, 0, bArr.length);
        }
    }

    @Override // java.io.OutputStream
    public void write(@NonNull byte[] bArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048580, this, bArr, i2, i3) == null) {
            int i4 = 0;
            do {
                int i5 = i3 - i4;
                int i6 = i2 + i4;
                if (this.f37796d == 0 && i5 >= this.f37794b.length) {
                    this.f37793a.write(bArr, i6, i5);
                    return;
                }
                int min = Math.min(i5, this.f37794b.length - this.f37796d);
                System.arraycopy(bArr, i6, this.f37794b, this.f37796d, min);
                this.f37796d += min;
                i4 += min;
                b();
            } while (i4 < i3);
        }
    }
}
