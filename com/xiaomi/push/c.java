package com.xiaomi.push;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import kotlinx.coroutines.scheduling.CoroutineScheduler;
/* loaded from: classes7.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;

    /* renamed from: a  reason: collision with other field name */
    public final OutputStream f151a;

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f152a;

    /* renamed from: b  reason: collision with root package name */
    public int f44127b;

    /* loaded from: classes7.dex */
    public static class a extends IOException {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    public c(OutputStream outputStream, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {outputStream, bArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f151a = outputStream;
        this.f152a = bArr;
        this.f44127b = 0;
        this.a = bArr.length;
    }

    public c(byte[] bArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bArr, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f151a = null;
        this.f152a = bArr;
        this.f44127b = i;
        this.a = i + i2;
    }

    public static int a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            if (i >= 0) {
                return d(i);
            }
            return 10;
        }
        return invokeI.intValue;
    }

    public static int a(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65539, null, i, i2)) == null) ? c(i) + a(i2) : invokeII.intValue;
    }

    public static int a(int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Integer.valueOf(i), Long.valueOf(j)})) == null) ? c(i) + a(j) : invokeCommon.intValue;
    }

    public static int a(int i, com.xiaomi.push.a aVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(65541, null, i, aVar)) == null) ? c(i) + a(aVar) : invokeIL.intValue;
    }

    public static int a(int i, e eVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(65542, null, i, eVar)) == null) ? c(i) + a(eVar) : invokeIL.intValue;
    }

    public static int a(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(65543, null, i, str)) == null) ? c(i) + a(str) : invokeIL.intValue;
    }

    public static int a(int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)})) == null) ? c(i) + a(z) : invokeCommon.intValue;
    }

    public static int a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65545, null, j)) == null) ? c(j) : invokeJ.intValue;
    }

    public static int a(com.xiaomi.push.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, aVar)) == null) ? d(aVar.a()) + aVar.a() : invokeL.intValue;
    }

    public static int a(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, eVar)) == null) {
            int b2 = eVar.b();
            return d(b2) + b2;
        }
        return invokeL.intValue;
    }

    public static int a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) {
            try {
                byte[] bytes = str.getBytes("UTF-8");
                return d(bytes.length) + bytes.length;
            } catch (UnsupportedEncodingException unused) {
                throw new RuntimeException("UTF-8 not supported.");
            }
        }
        return invokeL.intValue;
    }

    public static int a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65549, null, z)) == null) {
            return 1;
        }
        return invokeZ.intValue;
    }

    public static c a(OutputStream outputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65550, null, outputStream)) == null) ? a(outputStream, 4096) : (c) invokeL.objValue;
    }

    public static c a(OutputStream outputStream, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65551, null, outputStream, i)) == null) ? new c(outputStream, new byte[i]) : (c) invokeLI.objValue;
    }

    public static c a(byte[] bArr, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(65552, null, bArr, i, i2)) == null) ? new c(bArr, i, i2) : (c) invokeLII.objValue;
    }

    public static int b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65553, null, i)) == null) ? d(i) : invokeI.intValue;
    }

    public static int b(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65554, null, i, i2)) == null) ? c(i) + b(i2) : invokeII.intValue;
    }

    public static int b(int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65555, null, new Object[]{Integer.valueOf(i), Long.valueOf(j)})) == null) ? c(i) + b(j) : invokeCommon.intValue;
    }

    public static int b(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65556, null, j)) == null) ? c(j) : invokeJ.intValue;
    }

    public static int c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65557, null, i)) == null) ? d(f.a(i, 0)) : invokeI.intValue;
    }

    public static int c(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65558, null, j)) == null) {
            if (((-128) & j) == 0) {
                return 1;
            }
            if (((-16384) & j) == 0) {
                return 2;
            }
            if ((CoroutineScheduler.PARKED_VERSION_MASK & j) == 0) {
                return 3;
            }
            if (((-268435456) & j) == 0) {
                return 4;
            }
            if (((-34359738368L) & j) == 0) {
                return 5;
            }
            if (((-4398046511104L) & j) == 0) {
                return 6;
            }
            if (((-562949953421312L) & j) == 0) {
                return 7;
            }
            if (((-72057594037927936L) & j) == 0) {
                return 8;
            }
            return (j & Long.MIN_VALUE) == 0 ? 9 : 10;
        }
        return invokeJ.intValue;
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65559, this) == null) {
            OutputStream outputStream = this.f151a;
            if (outputStream == null) {
                throw new a();
            }
            outputStream.write(this.f152a, 0, this.f44127b);
            this.f44127b = 0;
        }
    }

    public static int d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65560, null, i)) == null) {
            if ((i & (-128)) == 0) {
                return 1;
            }
            if ((i & (-16384)) == 0) {
                return 2;
            }
            if (((-2097152) & i) == 0) {
                return 3;
            }
            return (i & (-268435456)) == 0 ? 4 : 5;
        }
        return invokeI.intValue;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f151a == null) {
                return this.a - this.f44127b;
            }
            throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array.");
        }
        return invokeV.intValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m235a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f151a == null) {
            return;
        }
        c();
    }

    public void a(byte b2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeB(Constants.METHOD_SEND_USER_MSG, this, b2) == null) {
            if (this.f44127b == this.a) {
                c();
            }
            byte[] bArr = this.f152a;
            int i = this.f44127b;
            this.f44127b = i + 1;
            bArr[i] = b2;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m236a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            if (i >= 0) {
                m255d(i);
            } else {
                m254c(i);
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m237a(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) {
            c(i, 0);
            m236a(i2);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m238a(int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)}) == null) {
            c(i, 0);
            m243a(j);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m239a(int i, com.xiaomi.push.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048582, this, i, aVar) == null) {
            c(i, 2);
            m244a(aVar);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m240a(int i, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048583, this, i, eVar) == null) {
            c(i, 2);
            m245a(eVar);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m241a(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, str) == null) {
            c(i, 2);
            m246a(str);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m242a(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            c(i, 0);
            m247a(z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m243a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048586, this, j) == null) {
            m254c(j);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m244a(com.xiaomi.push.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, aVar) == null) {
            byte[] m179a = aVar.m179a();
            m255d(m179a.length);
            a(m179a);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m245a(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, eVar) == null) {
            m255d(eVar.a());
            eVar.a(this);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m246a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            byte[] bytes = str.getBytes("UTF-8");
            m255d(bytes.length);
            a(bytes);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m247a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            m253c(z ? 1 : 0);
        }
    }

    public void a(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bArr) == null) {
            m248a(bArr, 0, bArr.length);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m248a(byte[] bArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048592, this, bArr, i, i2) == null) {
            int i3 = this.a;
            int i4 = this.f44127b;
            if (i3 - i4 >= i2) {
                System.arraycopy(bArr, i, this.f152a, i4, i2);
                this.f44127b += i2;
                return;
            }
            int i5 = i3 - i4;
            System.arraycopy(bArr, i, this.f152a, i4, i5);
            int i6 = i + i5;
            int i7 = i2 - i5;
            this.f44127b = this.a;
            c();
            if (i7 > this.a) {
                this.f151a.write(bArr, i6, i7);
                return;
            }
            System.arraycopy(bArr, i6, this.f152a, 0, i7);
            this.f44127b = i7;
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && a() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m249b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            m255d(i);
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m250b(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048595, this, i, i2) == null) {
            c(i, 0);
            m249b(i2);
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m251b(int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)}) == null) {
            c(i, 0);
            m252b(j);
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m252b(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048597, this, j) == null) {
            m254c(j);
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    public void m253c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            a((byte) i);
        }
    }

    public void c(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048599, this, i, i2) == null) {
            m255d(f.a(i, i2));
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    public void m254c(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048600, this, j) == null) {
            while (((-128) & j) != 0) {
                m253c((((int) j) & 127) | 128);
                j >>>= 7;
            }
            m253c((int) j);
        }
    }

    /* renamed from: d  reason: collision with other method in class */
    public void m255d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i) == null) {
            while ((i & (-128)) != 0) {
                m253c((i & 127) | 128);
                i >>>= 7;
            }
            m253c(i);
        }
    }
}
