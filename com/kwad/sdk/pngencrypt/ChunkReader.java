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
/* loaded from: classes2.dex */
public abstract class ChunkReader implements f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ChunkReaderMode a;

    /* renamed from: b  reason: collision with root package name */
    public int f58655b;

    /* renamed from: c  reason: collision with root package name */
    public ErrorBehaviour f58656c;

    /* renamed from: d  reason: collision with root package name */
    public final com.kwad.sdk.pngencrypt.chunk.d f58657d;

    /* renamed from: e  reason: collision with root package name */
    public int f58658e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f58659f;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class ChunkReaderMode {
        public static final /* synthetic */ ChunkReaderMode[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ChunkReaderMode BUFFER;
        public static final ChunkReaderMode PROCESS;
        public static final ChunkReaderMode SKIP;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-952968716, "Lcom/kwad/sdk/pngencrypt/ChunkReader$ChunkReaderMode;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-952968716, "Lcom/kwad/sdk/pngencrypt/ChunkReader$ChunkReaderMode;");
                    return;
                }
            }
            BUFFER = new ChunkReaderMode("BUFFER", 0);
            PROCESS = new ChunkReaderMode("PROCESS", 1);
            ChunkReaderMode chunkReaderMode = new ChunkReaderMode("SKIP", 2);
            SKIP = chunkReaderMode;
            $VALUES = new ChunkReaderMode[]{BUFFER, PROCESS, chunkReaderMode};
        }

        public ChunkReaderMode(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static ChunkReaderMode valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ChunkReaderMode) Enum.valueOf(ChunkReaderMode.class, str) : (ChunkReaderMode) invokeL.objValue;
        }

        public static ChunkReaderMode[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ChunkReaderMode[]) $VALUES.clone() : (ChunkReaderMode[]) invokeV.objValue;
        }
    }

    public ChunkReader(int i2, String str, long j2, ChunkReaderMode chunkReaderMode) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), str, Long.valueOf(j2), chunkReaderMode};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f58655b = 0;
        this.f58658e = 0;
        this.f58656c = ErrorBehaviour.STRICT;
        if (chunkReaderMode == null || str.length() != 4 || i2 < 0) {
            com.kwad.sdk.core.d.a.a(new PngjException("Bad chunk paramenters: " + chunkReaderMode));
        }
        this.a = chunkReaderMode;
        com.kwad.sdk.pngencrypt.chunk.d dVar = new com.kwad.sdk.pngencrypt.chunk.d(i2, str, chunkReaderMode == ChunkReaderMode.BUFFER);
        this.f58657d = dVar;
        dVar.a(j2);
        this.f58659f = chunkReaderMode != ChunkReaderMode.SKIP;
    }

    @Override // com.kwad.sdk.pngencrypt.f
    public final int a(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, bArr, i2, i3)) == null) {
            int i4 = 0;
            if (i3 == 0) {
                return 0;
            }
            if (i3 < 0) {
                com.kwad.sdk.core.d.a.a(new PngjException("negative length??"));
            }
            if (this.f58655b == 0 && this.f58658e == 0 && this.f58659f) {
                com.kwad.sdk.pngencrypt.chunk.d dVar = this.f58657d;
                dVar.a(dVar.f58720b, 0, 4);
            }
            int i5 = this.f58657d.a - this.f58655b;
            if (i5 > i3) {
                i5 = i3;
            }
            if (i5 > 0 || this.f58658e == 0) {
                if (this.f58659f && this.a != ChunkReaderMode.BUFFER && i5 > 0) {
                    this.f58657d.a(bArr, i2, i5);
                }
                ChunkReaderMode chunkReaderMode = this.a;
                if (chunkReaderMode == ChunkReaderMode.BUFFER) {
                    byte[] bArr2 = this.f58657d.f58722d;
                    if (bArr2 != bArr && i5 > 0) {
                        System.arraycopy(bArr, i2, bArr2, this.f58655b, i5);
                    }
                } else if (chunkReaderMode == ChunkReaderMode.PROCESS) {
                    a(this.f58655b, bArr, i2, i5);
                }
                this.f58655b += i5;
                i2 += i5;
                i3 -= i5;
            }
            if (this.f58655b == this.f58657d.a) {
                int i6 = 4 - this.f58658e;
                if (i6 <= i3) {
                    i3 = i6;
                }
                if (i3 > 0) {
                    byte[] bArr3 = this.f58657d.f58723e;
                    if (bArr != bArr3) {
                        System.arraycopy(bArr, i2, bArr3, this.f58658e, i3);
                    }
                    int i7 = this.f58658e + i3;
                    this.f58658e = i7;
                    if (i7 == 4) {
                        if (this.f58659f) {
                            if (this.a == ChunkReaderMode.BUFFER) {
                                com.kwad.sdk.pngencrypt.chunk.d dVar2 = this.f58657d;
                                dVar2.a(dVar2.f58722d, 0, dVar2.a);
                            }
                            this.f58657d.a(this.f58656c == ErrorBehaviour.STRICT);
                        }
                        com.kwad.sdk.core.d.a.a("PNG_ENCRYPT", "Chunk done");
                        c();
                    }
                }
                i4 = i3;
            }
            if (i5 > 0 || i4 > 0) {
                return i5 + i4;
            }
            return -1;
        }
        return invokeLII.intValue;
    }

    public com.kwad.sdk.pngencrypt.chunk.d a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f58657d : (com.kwad.sdk.pngencrypt.chunk.d) invokeV.objValue;
    }

    public abstract void a(int i2, byte[] bArr, int i3, int i4);

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            if (this.f58655b != 0 && z && !this.f58659f) {
                com.kwad.sdk.core.d.a.a(new PngjException("too late!"));
            }
            this.f58659f = z;
        }
    }

    @Override // com.kwad.sdk.pngencrypt.f
    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f58658e == 4 : invokeV.booleanValue;
    }

    public abstract void c();

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                com.kwad.sdk.pngencrypt.chunk.d dVar = this.f58657d;
                com.kwad.sdk.pngencrypt.chunk.d dVar2 = ((ChunkReader) obj).f58657d;
                if (dVar == null) {
                    if (dVar2 != null) {
                        return false;
                    }
                } else if (!dVar.equals(dVar2)) {
                    return false;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            com.kwad.sdk.pngencrypt.chunk.d dVar = this.f58657d;
            return 31 + (dVar == null ? 0 : dVar.hashCode());
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f58657d.toString() : (String) invokeV.objValue;
    }
}
