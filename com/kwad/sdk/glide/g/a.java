package com.kwad.sdk.glide.g;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicReference<byte[]> f37744a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.kwad.sdk.glide.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0456a extends InputStream {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        public final ByteBuffer f37745a;

        /* renamed from: b  reason: collision with root package name */
        public int f37746b;

        public C0456a(@NonNull ByteBuffer byteBuffer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {byteBuffer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37746b = -1;
            this.f37745a = byteBuffer;
        }

        @Override // java.io.InputStream
        public int available() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f37745a.remaining() : invokeV.intValue;
        }

        @Override // java.io.InputStream
        public synchronized void mark(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                synchronized (this) {
                    this.f37746b = this.f37745a.position();
                }
            }
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // java.io.InputStream
        public int read() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (this.f37745a.hasRemaining()) {
                    return this.f37745a.get();
                }
                return -1;
            }
            return invokeV.intValue;
        }

        @Override // java.io.InputStream
        public int read(@NonNull byte[] bArr, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048580, this, bArr, i2, i3)) == null) {
                if (this.f37745a.hasRemaining()) {
                    int min = Math.min(i3, available());
                    this.f37745a.get(bArr, i2, min);
                    return min;
                }
                return -1;
            }
            return invokeLII.intValue;
        }

        @Override // java.io.InputStream
        public synchronized void reset() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                synchronized (this) {
                    if (this.f37746b == -1) {
                        throw new IOException("Cannot reset to unset mark position");
                    }
                    this.f37745a.position(this.f37746b);
                }
            }
        }

        @Override // java.io.InputStream
        public long skip(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j)) == null) {
                if (this.f37745a.hasRemaining()) {
                    long min = Math.min(j, available());
                    ByteBuffer byteBuffer = this.f37745a;
                    byteBuffer.position((int) (byteBuffer.position() + min));
                    return min;
                }
                return -1L;
            }
            return invokeJ.longValue;
        }
    }

    /* loaded from: classes7.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final int f37751a;

        /* renamed from: b  reason: collision with root package name */
        public final int f37752b;

        /* renamed from: c  reason: collision with root package name */
        public final byte[] f37753c;

        public b(@NonNull byte[] bArr, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bArr, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37753c = bArr;
            this.f37751a = i2;
            this.f37752b = i3;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(906037223, "Lcom/kwad/sdk/glide/g/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(906037223, "Lcom/kwad/sdk/glide/g/a;");
                return;
            }
        }
        f37744a = new AtomicReference<>();
    }

    @NonNull
    public static ByteBuffer a(@NonNull File file) {
        InterceptResult invokeL;
        RandomAccessFile randomAccessFile;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65537, null, file)) != null) {
            return (ByteBuffer) invokeL.objValue;
        }
        FileChannel fileChannel = null;
        try {
            long length = file.length();
            if (length <= 2147483647L) {
                if (length != 0) {
                    randomAccessFile = new RandomAccessFile(file, r.f7745a);
                    try {
                        fileChannel = randomAccessFile.getChannel();
                        MappedByteBuffer load = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0L, length).load();
                        if (fileChannel != null) {
                            try {
                                fileChannel.close();
                            } catch (IOException unused) {
                            }
                        }
                        try {
                            randomAccessFile.close();
                        } catch (IOException unused2) {
                        }
                        return load;
                    } catch (Throwable th) {
                        th = th;
                        if (fileChannel != null) {
                            try {
                                fileChannel.close();
                            } catch (IOException unused3) {
                            }
                        }
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (IOException unused4) {
                            }
                        }
                        throw th;
                    }
                }
                throw new IOException("File unsuitable for memory mapping");
            }
            throw new IOException("File too large to map into memory");
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile = null;
        }
    }

    public static void a(@NonNull ByteBuffer byteBuffer, @NonNull File file) {
        RandomAccessFile randomAccessFile;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(65538, null, byteBuffer, file) != null) {
            return;
        }
        byteBuffer.position(0);
        FileChannel fileChannel = null;
        try {
            randomAccessFile = new RandomAccessFile(file, "rw");
            try {
                fileChannel = randomAccessFile.getChannel();
                fileChannel.write(byteBuffer);
                fileChannel.force(false);
                fileChannel.close();
                randomAccessFile.close();
                if (fileChannel != null) {
                    try {
                        fileChannel.close();
                    } catch (IOException unused) {
                    }
                }
                try {
                    randomAccessFile.close();
                } catch (IOException unused2) {
                }
            } catch (Throwable th) {
                th = th;
                if (fileChannel != null) {
                    try {
                        fileChannel.close();
                    } catch (IOException unused3) {
                    }
                }
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile = null;
        }
    }

    @NonNull
    public static byte[] a(@NonNull ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, byteBuffer)) == null) {
            b c2 = c(byteBuffer);
            if (c2 != null && c2.f37751a == 0 && c2.f37752b == c2.f37753c.length) {
                return byteBuffer.array();
            }
            ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
            byte[] bArr = new byte[asReadOnlyBuffer.limit()];
            asReadOnlyBuffer.position(0);
            asReadOnlyBuffer.get(bArr);
            return bArr;
        }
        return (byte[]) invokeL.objValue;
    }

    @NonNull
    public static InputStream b(@NonNull ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65540, null, byteBuffer)) == null) ? new C0456a(byteBuffer) : (InputStream) invokeL.objValue;
    }

    @Nullable
    public static b c(@NonNull ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, byteBuffer)) == null) {
            if (byteBuffer.isReadOnly() || !byteBuffer.hasArray()) {
                return null;
            }
            return new b(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.limit());
        }
        return (b) invokeL.objValue;
    }
}
