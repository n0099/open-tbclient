package com.kwad.sdk.pngencrypt;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.pngencrypt.ChunkReader;
import java.io.Closeable;
import java.util.Arrays;
/* loaded from: classes10.dex */
public abstract class b implements f, Closeable {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final /* synthetic */ boolean f72716d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f72717a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f72718b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f72719c;

    /* renamed from: e  reason: collision with root package name */
    public final byte[] f72720e;

    /* renamed from: f  reason: collision with root package name */
    public final int f72721f;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f72722g;

    /* renamed from: h  reason: collision with root package name */
    public int f72723h;

    /* renamed from: i  reason: collision with root package name */
    public int f72724i;

    /* renamed from: j  reason: collision with root package name */
    public long f72725j;
    public DeflatedChunksSet k;
    public ChunkReader l;
    public long m;
    public ErrorBehaviour n;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-743219215, "Lcom/kwad/sdk/pngencrypt/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-743219215, "Lcom/kwad/sdk/pngencrypt/b;");
                return;
            }
        }
        f72716d = !b.class.desiredAssertionStatus();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b() {
        this(n.a());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((byte[]) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public b(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bArr};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f72722g = new byte[8];
        this.f72723h = 0;
        this.f72717a = false;
        this.f72718b = false;
        this.f72719c = false;
        this.f72724i = 0;
        this.f72725j = 0L;
        this.n = ErrorBehaviour.STRICT;
        this.f72720e = bArr;
        int length = bArr == null ? 0 : bArr.length;
        this.f72721f = length;
        this.f72717a = length <= 0;
    }

    @Override // com.kwad.sdk.pngencrypt.f
    public int a(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        int i4;
        long j2;
        long j3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, bArr, i2, i3)) == null) {
            if (this.f72719c) {
                return -1;
            }
            if (i3 == 0) {
                return 0;
            }
            if (i3 < 0) {
                com.kwad.sdk.core.d.a.a(new PngjException("This should not happen. Bad length: " + i3));
            }
            if (this.f72717a) {
                ChunkReader chunkReader = this.l;
                if (chunkReader == null || chunkReader.b()) {
                    int i5 = 8 - this.f72723h;
                    if (i5 <= i3) {
                        i3 = i5;
                    }
                    System.arraycopy(bArr, i2, this.f72722g, this.f72723h, i3);
                    int i6 = this.f72723h + i3;
                    this.f72723h = i6;
                    i4 = 0 + i3;
                    this.f72725j += i3;
                    if (i6 == 8) {
                        this.f72724i++;
                        a(n.c(this.f72722g, 0), com.kwad.sdk.pngencrypt.chunk.b.a(this.f72722g, 4), this.f72725j - 8);
                        this.f72723h = 0;
                    }
                    return i4;
                }
                int a2 = this.l.a(bArr, i2, i3);
                if (a2 < 0) {
                    return -1;
                }
                i4 = a2 + 0;
                j2 = this.f72725j;
                j3 = a2;
            } else {
                int i7 = this.f72721f - this.f72723h;
                if (i7 <= i3) {
                    i3 = i7;
                }
                System.arraycopy(bArr, i2, this.f72722g, this.f72723h, i3);
                int i8 = this.f72723h + i3;
                this.f72723h = i8;
                if (i8 == this.f72721f) {
                    a(this.f72722g);
                    this.f72723h = 0;
                    this.f72717a = true;
                }
                i4 = 0 + i3;
                j2 = this.f72725j;
                j3 = i3;
            }
            this.f72725j = j2 + j3;
            return i4;
        }
        return invokeLII.intValue;
    }

    public long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f72725j : invokeV.longValue;
    }

    public ChunkReader a(String str, int i2, long j2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, Integer.valueOf(i2), Long.valueOf(j2), Boolean.valueOf(z)})) == null) {
            return new ChunkReader(this, i2, str, j2, z ? ChunkReader.ChunkReaderMode.SKIP : ChunkReader.ChunkReaderMode.BUFFER) { // from class: com.kwad.sdk.pngencrypt.b.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ b f72727d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(i2, str, j2, r22);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r8;
                        Object[] objArr = {this, Integer.valueOf(i2), str, Long.valueOf(j2), r22};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super(((Integer) objArr2[0]).intValue(), (String) objArr2[1], ((Long) objArr2[2]).longValue(), (ChunkReader.ChunkReaderMode) objArr2[3]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f72727d = this;
                }

                @Override // com.kwad.sdk.pngencrypt.ChunkReader
                public void a(int i3, byte[] bArr, int i4, int i5) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i3), bArr, Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
                        com.kwad.sdk.core.d.a.a(new PngjException("should never happen"));
                    }
                }

                @Override // com.kwad.sdk.pngencrypt.ChunkReader
                public void c() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.f72727d.a(this);
                    }
                }
            };
        }
        return (ChunkReader) invokeCommon.objValue;
    }

    public abstract DeflatedChunksSet a(String str);

    public void a(int i2, String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), str, Long.valueOf(j2)}) == null) {
            com.kwad.sdk.core.d.a.a("PNG_ENCRYPT", "New chunk: " + str + " " + i2 + " off:" + j2);
            if (str.length() != 4 || !com.kwad.sdk.pngencrypt.chunk.b.f72758e.matcher(str).matches()) {
                com.kwad.sdk.core.d.a.a(new PngjException("Bad chunk id: " + str));
            }
            if (i2 < 0) {
                com.kwad.sdk.core.d.a.a(new PngjException("Bad chunk len: " + i2));
            }
            if (str.equals("IDAT")) {
                this.m += i2;
            }
            boolean b2 = b(i2, str);
            boolean a2 = a(i2, str);
            boolean b3 = b(str);
            DeflatedChunksSet deflatedChunksSet = this.k;
            boolean a3 = (deflatedChunksSet == null || deflatedChunksSet.e()) ? false : this.k.a(str);
            if (!b3 || a2) {
                this.l = a(str, i2, j2, a2);
            } else {
                if (!a3) {
                    DeflatedChunksSet deflatedChunksSet2 = this.k;
                    if (deflatedChunksSet2 != null && !deflatedChunksSet2.d()) {
                        com.kwad.sdk.core.d.a.a(new PngjException("new IDAT-like chunk when previous was not done"));
                    }
                    this.k = a(str);
                }
                this.l = new d(this, i2, str, b2, j2, this.k) { // from class: com.kwad.sdk.pngencrypt.b.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ b f72726d;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(i2, str, b2, j2, r19);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Integer.valueOf(i2), str, Boolean.valueOf(b2), Long.valueOf(j2), r19};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                Object[] objArr2 = newInitContext.callArgs;
                                super(((Integer) objArr2[0]).intValue(), (String) objArr2[1], ((Boolean) objArr2[2]).booleanValue(), ((Long) objArr2[3]).longValue(), (DeflatedChunksSet) objArr2[4]);
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f72726d = this;
                    }

                    @Override // com.kwad.sdk.pngencrypt.d, com.kwad.sdk.pngencrypt.ChunkReader
                    public void c() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            super.c();
                            this.f72726d.a(this);
                        }
                    }
                };
            }
            ChunkReader chunkReader = this.l;
            if (chunkReader == null || b2) {
                return;
            }
            chunkReader.a(false);
        }
    }

    public void a(ChunkReader chunkReader) {
        String d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, chunkReader) == null) {
            if (this.f72724i == 1 && (d2 = d()) != null && !d2.equals(chunkReader.a().f72762c)) {
                String str = "Bad first chunk: " + chunkReader.a().f72762c + " expected: " + d();
                if (this.n.f72707c < ErrorBehaviour.SUPER_LENIENT.f72707c) {
                    com.kwad.sdk.core.d.a.a(new PngjException(str));
                } else {
                    com.kwad.sdk.core.d.a.a("PNG_ENCRYPT", str);
                }
            }
            if (e() == null || !chunkReader.a().f72762c.equals(e())) {
                return;
            }
            this.f72718b = true;
            close();
        }
    }

    public void a(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, bArr) == null) || Arrays.equals(bArr, n.a())) {
            return;
        }
        com.kwad.sdk.core.d.a.a(new PngjException("Bad signature:" + Arrays.toString(bArr)));
    }

    public boolean a(int i2, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048583, this, i2, str)) == null) {
            return false;
        }
        return invokeIL.booleanValue;
    }

    @Override // com.kwad.sdk.pngencrypt.f
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f72718b : invokeV.booleanValue;
    }

    public boolean b(int i2, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048585, this, i2, str)) == null) {
            return true;
        }
        return invokeIL.booleanValue;
    }

    public boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    public DeflatedChunksSet c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.k : (DeflatedChunksSet) invokeV.objValue;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            DeflatedChunksSet deflatedChunksSet = this.k;
            if (deflatedChunksSet != null) {
                deflatedChunksSet.f();
            }
            this.f72719c = true;
        }
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? "IHDR" : (String) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? "IEND" : (String) invokeV.objValue;
    }
}
