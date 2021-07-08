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
/* loaded from: classes6.dex */
public abstract class ChunkReader implements f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final ChunkReaderMode f35725a;

    /* renamed from: b  reason: collision with root package name */
    public int f35726b;

    /* renamed from: c  reason: collision with root package name */
    public ErrorBehaviour f35727c;

    /* renamed from: d  reason: collision with root package name */
    public final com.kwad.sdk.pngencrypt.chunk.d f35728d;

    /* renamed from: e  reason: collision with root package name */
    public int f35729e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f35730f;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
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

    public ChunkReader(int i2, String str, long j, ChunkReaderMode chunkReaderMode) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), str, Long.valueOf(j), chunkReaderMode};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f35726b = 0;
        this.f35729e = 0;
        this.f35727c = ErrorBehaviour.STRICT;
        if (chunkReaderMode == null || str.length() != 4 || i2 < 0) {
            com.kwad.sdk.core.d.a.a(new PngjException("Bad chunk paramenters: " + chunkReaderMode));
        }
        this.f35725a = chunkReaderMode;
        com.kwad.sdk.pngencrypt.chunk.d dVar = new com.kwad.sdk.pngencrypt.chunk.d(i2, str, chunkReaderMode == ChunkReaderMode.BUFFER);
        this.f35728d = dVar;
        dVar.a(j);
        this.f35730f = chunkReaderMode != ChunkReaderMode.SKIP;
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
            if (this.f35726b == 0 && this.f35729e == 0 && this.f35730f) {
                com.kwad.sdk.pngencrypt.chunk.d dVar = this.f35728d;
                dVar.a(dVar.f35790b, 0, 4);
            }
            int i5 = this.f35728d.f35789a - this.f35726b;
            if (i5 > i3) {
                i5 = i3;
            }
            if (i5 > 0 || this.f35729e == 0) {
                if (this.f35730f && this.f35725a != ChunkReaderMode.BUFFER && i5 > 0) {
                    this.f35728d.a(bArr, i2, i5);
                }
                ChunkReaderMode chunkReaderMode = this.f35725a;
                if (chunkReaderMode == ChunkReaderMode.BUFFER) {
                    byte[] bArr2 = this.f35728d.f35792d;
                    if (bArr2 != bArr && i5 > 0) {
                        System.arraycopy(bArr, i2, bArr2, this.f35726b, i5);
                    }
                } else if (chunkReaderMode == ChunkReaderMode.PROCESS) {
                    a(this.f35726b, bArr, i2, i5);
                }
                this.f35726b += i5;
                i2 += i5;
                i3 -= i5;
            }
            if (this.f35726b == this.f35728d.f35789a) {
                int i6 = 4 - this.f35729e;
                if (i6 <= i3) {
                    i3 = i6;
                }
                if (i3 > 0) {
                    byte[] bArr3 = this.f35728d.f35793e;
                    if (bArr != bArr3) {
                        System.arraycopy(bArr, i2, bArr3, this.f35729e, i3);
                    }
                    int i7 = this.f35729e + i3;
                    this.f35729e = i7;
                    if (i7 == 4) {
                        if (this.f35730f) {
                            if (this.f35725a == ChunkReaderMode.BUFFER) {
                                com.kwad.sdk.pngencrypt.chunk.d dVar2 = this.f35728d;
                                dVar2.a(dVar2.f35792d, 0, dVar2.f35789a);
                            }
                            this.f35728d.a(this.f35727c == ErrorBehaviour.STRICT);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f35728d : (com.kwad.sdk.pngencrypt.chunk.d) invokeV.objValue;
    }

    public abstract void a(int i2, byte[] bArr, int i3, int i4);

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            if (this.f35726b != 0 && z && !this.f35730f) {
                com.kwad.sdk.core.d.a.a(new PngjException("too late!"));
            }
            this.f35730f = z;
        }
    }

    @Override // com.kwad.sdk.pngencrypt.f
    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f35729e == 4 : invokeV.booleanValue;
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
                com.kwad.sdk.pngencrypt.chunk.d dVar = this.f35728d;
                com.kwad.sdk.pngencrypt.chunk.d dVar2 = ((ChunkReader) obj).f35728d;
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
            com.kwad.sdk.pngencrypt.chunk.d dVar = this.f35728d;
            return 31 + (dVar == null ? 0 : dVar.hashCode());
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f35728d.toString() : (String) invokeV.objValue;
    }
}
