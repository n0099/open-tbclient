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
import com.kwad.sdk.pngencrypt.chunk.ChunkLoadBehaviour;
import com.kwad.sdk.pngencrypt.chunk.q;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public class c extends b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public k f58690e;

    /* renamed from: f  reason: collision with root package name */
    public k f58691f;

    /* renamed from: g  reason: collision with root package name */
    public e f58692g;

    /* renamed from: h  reason: collision with root package name */
    public int f58693h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.pngencrypt.chunk.e f58694i;

    /* renamed from: j  reason: collision with root package name */
    public final boolean f58695j;

    /* renamed from: k  reason: collision with root package name */
    public long f58696k;
    public boolean l;
    public boolean m;
    public Set<String> n;
    public long o;
    public long p;
    public long q;
    public g r;
    public ChunkLoadBehaviour s;

    /* renamed from: com.kwad.sdk.pngencrypt.c$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1269085213, "Lcom/kwad/sdk/pngencrypt/c$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1269085213, "Lcom/kwad/sdk/pngencrypt/c$1;");
                    return;
                }
            }
            int[] iArr = new int[ChunkLoadBehaviour.values().length];
            a = iArr;
            try {
                iArr[ChunkLoadBehaviour.LOAD_CHUNK_IF_SAFE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ChunkLoadBehaviour.LOAD_CHUNK_NEVER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f58693h = -1;
        this.f58694i = null;
        this.f58696k = 0L;
        this.l = true;
        this.m = false;
        this.n = new HashSet();
        this.o = 0L;
        this.p = 0L;
        this.q = 0L;
        this.s = ChunkLoadBehaviour.LOAD_CHUNK_ALWAYS;
        this.f58695j = z;
        this.r = new com.kwad.sdk.pngencrypt.chunk.a();
    }

    private void e(String str) {
        int i2;
        PngjException pngjException;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, str) == null) {
            if (str.equals("IHDR")) {
                if (this.f58693h < 0) {
                    i2 = 0;
                    this.f58693h = i2;
                    return;
                }
                pngjException = new PngjException("unexpected chunk " + str);
                com.kwad.sdk.core.d.a.a(pngjException);
            } else if (str.equals("PLTE")) {
                int i3 = this.f58693h;
                if (i3 == 0 || i3 == 1) {
                    i2 = 2;
                    this.f58693h = i2;
                    return;
                }
                pngjException = new PngjException("unexpected chunk here " + str);
                com.kwad.sdk.core.d.a.a(pngjException);
            } else {
                if (!str.equals("IDAT")) {
                    if (!str.equals("IEND")) {
                        int i4 = this.f58693h;
                        if (i4 <= 1) {
                            this.f58693h = 1;
                            return;
                        } else if (i4 <= 3) {
                            this.f58693h = 3;
                            return;
                        } else {
                            i2 = 5;
                        }
                    } else if (this.f58693h >= 4) {
                        i2 = 6;
                    } else {
                        pngjException = new PngjException("unexpected chunk " + str);
                    }
                    this.f58693h = i2;
                    return;
                }
                int i5 = this.f58693h;
                if (i5 >= 0 && i5 <= 4) {
                    this.f58693h = 4;
                    return;
                }
                pngjException = new PngjException("unexpected chunk " + str);
                com.kwad.sdk.core.d.a.a(pngjException);
            }
        }
    }

    @Override // com.kwad.sdk.pngencrypt.b, com.kwad.sdk.pngencrypt.f
    public int a(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, bArr, i2, i3)) == null) ? super.a(bArr, i2, i3) : invokeLII.intValue;
    }

    @Override // com.kwad.sdk.pngencrypt.b
    public DeflatedChunksSet a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? new j(str, this.f58695j, l(), this.f58692g) : (DeflatedChunksSet) invokeL.objValue;
    }

    @Override // com.kwad.sdk.pngencrypt.b
    public void a(int i2, String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), str, Long.valueOf(j2)}) == null) {
            e(str);
            super.a(i2, str, j2);
        }
    }

    public void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j2) == null) {
            this.o = j2;
        }
    }

    @Override // com.kwad.sdk.pngencrypt.b
    public void a(ChunkReader chunkReader) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, chunkReader) == null) {
            super.a(chunkReader);
            if (chunkReader.a().f58721c.equals("IHDR")) {
                q qVar = new q(null);
                qVar.a(chunkReader.a());
                k i2 = qVar.i();
                this.f58690e = i2;
                this.f58691f = i2;
                if (qVar.h()) {
                    this.f58692g = new e(this.f58691f);
                }
                this.f58694i = new com.kwad.sdk.pngencrypt.chunk.e(this.f58690e);
            }
            if (chunkReader.a == ChunkReader.ChunkReaderMode.BUFFER && d(chunkReader.a().f58721c)) {
                this.f58696k += chunkReader.a().a;
            }
            if (chunkReader.a == ChunkReader.ChunkReaderMode.BUFFER || this.m) {
                try {
                    this.f58694i.a(this.r.a(chunkReader.a(), j()), this.f58693h);
                } catch (PngjException e2) {
                    throw e2;
                }
            }
            if (b()) {
                i();
            }
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.l = z;
        }
    }

    @Override // com.kwad.sdk.pngencrypt.b
    public boolean a(int i2, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048582, this, i2, str)) == null) {
            if (super.a(i2, str)) {
                return true;
            }
            if (this.o > 0 && i2 + a() > this.o) {
                com.kwad.sdk.core.d.a.a(new PngjException("Maximum total bytes to read exceeeded: " + this.o + " offset:" + a() + " len=" + i2));
            }
            if (this.n.contains(str)) {
                return true;
            }
            if (com.kwad.sdk.pngencrypt.chunk.b.b(str)) {
                return false;
            }
            long j2 = this.p;
            if (j2 <= 0 || i2 <= j2) {
                long j3 = this.q;
                if (j3 <= 0 || i2 <= j3 - this.f58696k) {
                    int i3 = AnonymousClass1.a[this.s.ordinal()];
                    if (i3 != 1) {
                        if (i3 == 2) {
                            return true;
                        }
                    } else if (!com.kwad.sdk.pngencrypt.chunk.b.d(str)) {
                        return true;
                    }
                    return false;
                }
                return true;
            }
            return true;
        }
        return invokeIL.booleanValue;
    }

    public void b(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j2) == null) {
            this.p = j2;
        }
    }

    @Override // com.kwad.sdk.pngencrypt.b
    public boolean b(int i2, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, str)) == null) ? this.l : invokeIL.booleanValue;
    }

    @Override // com.kwad.sdk.pngencrypt.b
    public boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) ? str.equals("IDAT") : invokeL.booleanValue;
    }

    public void c(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048586, this, j2) == null) {
            this.q = j2;
        }
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.n.add(str);
        }
    }

    @Override // com.kwad.sdk.pngencrypt.b, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (this.f58693h != 6) {
                this.f58693h = 6;
            }
            super.close();
        }
    }

    public boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) ? !com.kwad.sdk.pngencrypt.chunk.b.b(str) : invokeL.booleanValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f58693h : invokeV.intValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? f() < 4 : invokeV.booleanValue;
    }

    public j h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            DeflatedChunksSet c2 = c();
            if (c2 instanceof j) {
                return (j) c2;
            }
            return null;
        }
        return (j) invokeV.objValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
        }
    }

    public k j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f58690e : (k) invokeV.objValue;
    }

    public e k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f58692g : (e) invokeV.objValue;
    }

    public k l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f58691f : (k) invokeV.objValue;
    }
}
