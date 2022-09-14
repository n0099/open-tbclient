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
/* loaded from: classes8.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;

    /* renamed from: a  reason: collision with other field name */
    public final OutputStream f157a;

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f158a;
    public int b;

    /* loaded from: classes8.dex */
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
        this.f157a = outputStream;
        this.f158a = bArr;
        this.b = 0;
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
        this.f157a = null;
        this.f158a = bArr;
        this.b = i;
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
            int b = eVar.b();
            return d(b) + b;
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
            OutputStream outputStream = this.f157a;
            if (outputStream == null) {
                throw new a();
            }
            outputStream.write(this.f158a, 0, this.b);
            this.b = 0;
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
            if (this.f157a == null) {
                return this.a - this.b;
            }
            throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array.");
        }
        return invokeV.intValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m217a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f157a == null) {
            return;
        }
        c();
    }

    public void a(byte b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeB(Constants.METHOD_SEND_USER_MSG, this, b) == null) {
            if (this.b == this.a) {
                c();
            }
            byte[] bArr = this.f158a;
            int i = this.b;
            this.b = i + 1;
            bArr[i] = b;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m218a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            if (i >= 0) {
                m237d(i);
            } else {
                m236c(i);
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m219a(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) {
            c(i, 0);
            m218a(i2);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m220a(int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)}) == null) {
            c(i, 0);
            m225a(j);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m221a(int i, com.xiaomi.push.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048582, this, i, aVar) == null) {
            c(i, 2);
            m226a(aVar);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m222a(int i, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048583, this, i, eVar) == null) {
            c(i, 2);
            m227a(eVar);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m223a(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, str) == null) {
            c(i, 2);
            m228a(str);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m224a(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            c(i, 0);
            m229a(z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m225a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048586, this, j) == null) {
            m236c(j);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m226a(com.xiaomi.push.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, aVar) == null) {
            byte[] m161a = aVar.m161a();
            m237d(m161a.length);
            a(m161a);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m227a(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, eVar) == null) {
            m237d(eVar.a());
            eVar.a(this);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m228a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            byte[] bytes = str.getBytes("UTF-8");
            m237d(bytes.length);
            a(bytes);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m229a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            m235c(z ? 1 : 0);
        }
    }

    public void a(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bArr) == null) {
            m230a(bArr, 0, bArr.length);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m230a(byte[] bArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048592, this, bArr, i, i2) == null) {
            int i3 = this.a;
            int i4 = this.b;
            if (i3 - i4 >= i2) {
                System.arraycopy(bArr, i, this.f158a, i4, i2);
                this.b += i2;
                return;
            }
            int i5 = i3 - i4;
            System.arraycopy(bArr, i, this.f158a, i4, i5);
            int i6 = i + i5;
            int i7 = i2 - i5;
            this.b = this.a;
            c();
            if (i7 > this.a) {
                this.f157a.write(bArr, i6, i7);
                return;
            }
            System.arraycopy(bArr, i6, this.f158a, 0, i7);
            this.b = i7;
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && a() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m231b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            m237d(i);
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m232b(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048595, this, i, i2) == null) {
            c(i, 0);
            m231b(i2);
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m233b(int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)}) == null) {
            c(i, 0);
            m234b(j);
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m234b(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048597, this, j) == null) {
            m236c(j);
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    public void m235c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            a((byte) i);
        }
    }

    public void c(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048599, this, i, i2) == null) {
            m237d(f.a(i, i2));
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    public void m236c(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048600, this, j) == null) {
            while (((-128) & j) != 0) {
                m235c((((int) j) & 127) | 128);
                j >>>= 7;
            }
            m235c((int) j);
        }
    }

    /* renamed from: d  reason: collision with other method in class */
    public void m237d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i) == null) {
            while ((i & (-128)) != 0) {
                m235c((i & 127) | 128);
                i >>>= 7;
            }
            m235c(i);
        }
    }
}
