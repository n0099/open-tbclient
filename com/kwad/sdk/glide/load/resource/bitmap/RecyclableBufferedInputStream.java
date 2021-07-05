package com.kwad.sdk.glide.load.resource.bitmap;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes7.dex */
public class RecyclableBufferedInputStream extends FilterInputStream {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile byte[] f38198a;

    /* renamed from: b  reason: collision with root package name */
    public int f38199b;

    /* renamed from: c  reason: collision with root package name */
    public int f38200c;

    /* renamed from: d  reason: collision with root package name */
    public int f38201d;

    /* renamed from: e  reason: collision with root package name */
    public int f38202e;

    /* renamed from: f  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.engine.bitmap_recycle.b f38203f;

    /* loaded from: classes7.dex */
    public static class InvalidMarkException extends IOException {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -4338378848813561757L;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InvalidMarkException(String str) {
            super(str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RecyclableBufferedInputStream(@NonNull InputStream inputStream, @NonNull com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar) {
        this(inputStream, bVar, 65536);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputStream, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((InputStream) objArr2[0], (com.kwad.sdk.glide.load.engine.bitmap_recycle.b) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @VisibleForTesting
    public RecyclableBufferedInputStream(@NonNull InputStream inputStream, @NonNull com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar, int i2) {
        super(inputStream);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputStream, bVar, Integer.valueOf(i2)};
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
        this.f38201d = -1;
        this.f38203f = bVar;
        this.f38198a = (byte[]) bVar.a(i2, byte[].class);
    }

    private int a(InputStream inputStream, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, inputStream, bArr)) == null) {
            int i2 = this.f38201d;
            if (i2 != -1) {
                int i3 = this.f38202e - i2;
                int i4 = this.f38200c;
                if (i3 < i4) {
                    if (i2 == 0 && i4 > bArr.length && this.f38199b == bArr.length) {
                        int length = bArr.length * 2;
                        if (length <= i4) {
                            i4 = length;
                        }
                        byte[] bArr2 = (byte[]) this.f38203f.a(i4, byte[].class);
                        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                        this.f38198a = bArr2;
                        this.f38203f.a((com.kwad.sdk.glide.load.engine.bitmap_recycle.b) bArr);
                        bArr = bArr2;
                    } else {
                        int i5 = this.f38201d;
                        if (i5 > 0) {
                            System.arraycopy(bArr, i5, bArr, 0, bArr.length - i5);
                        }
                    }
                    int i6 = this.f38202e - this.f38201d;
                    this.f38202e = i6;
                    this.f38201d = 0;
                    this.f38199b = 0;
                    int read = inputStream.read(bArr, i6, bArr.length - i6);
                    int i7 = this.f38202e;
                    if (read > 0) {
                        i7 += read;
                    }
                    this.f38199b = i7;
                    return read;
                }
            }
            int read2 = inputStream.read(bArr);
            if (read2 > 0) {
                this.f38201d = -1;
                this.f38202e = 0;
                this.f38199b = read2;
            }
            return read2;
        }
        return invokeLL.intValue;
    }

    public static IOException c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            throw new IOException("BufferedInputStream is closed");
        }
        return (IOException) invokeV.objValue;
    }

    public synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                this.f38200c = this.f38198a.length;
            }
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() {
        InterceptResult invokeV;
        int available;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this) {
                InputStream inputStream = ((FilterInputStream) this).in;
                if (this.f38198a == null || inputStream == null) {
                    throw c();
                }
                available = (this.f38199b - this.f38202e) + inputStream.available();
            }
            return available;
        }
        return invokeV.intValue;
    }

    public synchronized void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                if (this.f38198a != null) {
                    this.f38203f.a((com.kwad.sdk.glide.load.engine.bitmap_recycle.b) this.f38198a);
                    this.f38198a = null;
                }
            }
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f38198a != null) {
                this.f38203f.a((com.kwad.sdk.glide.load.engine.bitmap_recycle.b) this.f38198a);
                this.f38198a = null;
            }
            InputStream inputStream = ((FilterInputStream) this).in;
            ((FilterInputStream) this).in = null;
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            synchronized (this) {
                this.f38200c = Math.max(this.f38200c, i2);
                this.f38201d = this.f38202e;
            }
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this) {
                byte[] bArr = this.f38198a;
                InputStream inputStream = ((FilterInputStream) this).in;
                if (bArr == null || inputStream == null) {
                    throw c();
                }
                if (this.f38202e < this.f38199b || a(inputStream, bArr) != -1) {
                    if (bArr != this.f38198a && (bArr = this.f38198a) == null) {
                        throw c();
                    }
                    if (this.f38199b - this.f38202e > 0) {
                        int i2 = this.f38202e;
                        this.f38202e = i2 + 1;
                        return bArr[i2] & 255;
                    }
                    return -1;
                }
                return -1;
            }
        }
        return invokeV.intValue;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(@NonNull byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLII = interceptable.invokeLII(1048583, this, bArr, i2, i3)) != null) {
            return invokeLII.intValue;
        }
        synchronized (this) {
            byte[] bArr2 = this.f38198a;
            if (bArr2 == null) {
                throw c();
            }
            if (i3 == 0) {
                return 0;
            }
            InputStream inputStream = ((FilterInputStream) this).in;
            if (inputStream == null) {
                throw c();
            }
            if (this.f38202e < this.f38199b) {
                int i6 = this.f38199b - this.f38202e >= i3 ? i3 : this.f38199b - this.f38202e;
                System.arraycopy(bArr2, this.f38202e, bArr, i2, i6);
                this.f38202e += i6;
                if (i6 == i3 || inputStream.available() == 0) {
                    return i6;
                }
                i2 += i6;
                i4 = i3 - i6;
            } else {
                i4 = i3;
            }
            while (true) {
                if (this.f38201d == -1 && i4 >= bArr2.length) {
                    i5 = inputStream.read(bArr, i2, i4);
                    if (i5 == -1) {
                        return i4 != i3 ? i3 - i4 : -1;
                    }
                } else if (a(inputStream, bArr2) == -1) {
                    return i4 != i3 ? i3 - i4 : -1;
                } else {
                    if (bArr2 != this.f38198a && (bArr2 = this.f38198a) == null) {
                        throw c();
                    }
                    i5 = this.f38199b - this.f38202e >= i4 ? i4 : this.f38199b - this.f38202e;
                    System.arraycopy(bArr2, this.f38202e, bArr, i2, i5);
                    this.f38202e += i5;
                }
                i4 -= i5;
                if (i4 == 0) {
                    return i3;
                }
                if (inputStream.available() == 0) {
                    return i3 - i4;
                }
                i2 += i5;
            }
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            synchronized (this) {
                if (this.f38198a == null) {
                    throw new IOException("Stream is closed");
                }
                if (-1 == this.f38201d) {
                    throw new InvalidMarkException("Mark has been invalidated, pos: " + this.f38202e + " markLimit: " + this.f38200c);
                }
                this.f38202e = this.f38201d;
            }
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048585, this, j)) == null) {
            synchronized (this) {
                if (j < 1) {
                    return 0L;
                }
                byte[] bArr = this.f38198a;
                if (bArr != null) {
                    InputStream inputStream = ((FilterInputStream) this).in;
                    if (inputStream != null) {
                        if (this.f38199b - this.f38202e >= j) {
                            this.f38202e = (int) (this.f38202e + j);
                            return j;
                        }
                        long j2 = this.f38199b - this.f38202e;
                        this.f38202e = this.f38199b;
                        if (this.f38201d == -1 || j > this.f38200c) {
                            return j2 + inputStream.skip(j - j2);
                        }
                        if (a(inputStream, bArr) == -1) {
                            return j2;
                        }
                        if (this.f38199b - this.f38202e >= j - j2) {
                            this.f38202e = (int) ((this.f38202e + j) - j2);
                            return j;
                        }
                        long j3 = (j2 + this.f38199b) - this.f38202e;
                        this.f38202e = this.f38199b;
                        return j3;
                    }
                    throw c();
                }
                throw c();
            }
        }
        return invokeJ.longValue;
    }
}
