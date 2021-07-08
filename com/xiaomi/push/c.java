package com.xiaomi.push;

import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.asm.Label;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import kotlinx.coroutines.scheduling.CoroutineScheduler;
/* loaded from: classes6.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final int f39916a;

    /* renamed from: a  reason: collision with other field name */
    public final OutputStream f170a;

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f171a;

    /* renamed from: b  reason: collision with root package name */
    public int f39917b;

    /* loaded from: classes6.dex */
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

    public c(OutputStream outputStream, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {outputStream, bArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f170a = outputStream;
        this.f171a = bArr;
        this.f39917b = 0;
        this.f39916a = bArr.length;
    }

    public c(byte[] bArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bArr, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f170a = null;
        this.f171a = bArr;
        this.f39917b = i2;
        this.f39916a = i2 + i3;
    }

    public static int a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
            if (i2 >= 0) {
                return d(i2);
            }
            return 10;
        }
        return invokeI.intValue;
    }

    public static int a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65539, null, i2, i3)) == null) ? c(i2) + a(i3) : invokeII.intValue;
    }

    public static int a(int i2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Integer.valueOf(i2), Long.valueOf(j)})) == null) ? c(i2) + a(j) : invokeCommon.intValue;
    }

    public static int a(int i2, com.xiaomi.push.a aVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(AdIconUtil.AD_TEXT_ID, null, i2, aVar)) == null) ? c(i2) + a(aVar) : invokeIL.intValue;
    }

    public static int a(int i2, e eVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(AdIconUtil.BAIDU_LOGO_ID, null, i2, eVar)) == null) ? c(i2) + a(eVar) : invokeIL.intValue;
    }

    public static int a(int i2, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(65543, null, i2, str)) == null) ? c(i2) + a(str) : invokeIL.intValue;
    }

    public static int a(int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) ? c(i2) + a(z) : invokeCommon.intValue;
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

    public static c a(OutputStream outputStream, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65551, null, outputStream, i2)) == null) ? new c(outputStream, new byte[i2]) : (c) invokeLI.objValue;
    }

    public static c a(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(65552, null, bArr, i2, i3)) == null) ? new c(bArr, i2, i3) : (c) invokeLII.objValue;
    }

    public static int b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65553, null, i2)) == null) ? d(i2) : invokeI.intValue;
    }

    public static int b(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65554, null, i2, i3)) == null) ? c(i2) + b(i3) : invokeII.intValue;
    }

    public static int b(int i2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65555, null, new Object[]{Integer.valueOf(i2), Long.valueOf(j)})) == null) ? c(i2) + b(j) : invokeCommon.intValue;
    }

    public static int b(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65556, null, j)) == null) ? c(j) : invokeJ.intValue;
    }

    public static int c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65557, null, i2)) == null) ? d(f.a(i2, 0)) : invokeI.intValue;
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
            OutputStream outputStream = this.f170a;
            if (outputStream == null) {
                throw new a();
            }
            outputStream.write(this.f171a, 0, this.f39917b);
            this.f39917b = 0;
        }
    }

    public static int d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65560, null, i2)) == null) {
            if ((i2 & com.alipay.sdk.encrypt.a.f1889g) == 0) {
                return 1;
            }
            if ((i2 & (-16384)) == 0) {
                return 2;
            }
            if (((-2097152) & i2) == 0) {
                return 3;
            }
            return (i2 & Label.FORWARD_REFERENCE_TYPE_MASK) == 0 ? 4 : 5;
        }
        return invokeI.intValue;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f170a == null) {
                return this.f39916a - this.f39917b;
            }
            throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array.");
        }
        return invokeV.intValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m193a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f170a == null) {
            return;
        }
        c();
    }

    public void a(byte b2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeB(Constants.METHOD_SEND_USER_MSG, this, b2) == null) {
            if (this.f39917b == this.f39916a) {
                c();
            }
            byte[] bArr = this.f171a;
            int i2 = this.f39917b;
            this.f39917b = i2 + 1;
            bArr[i2] = b2;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m194a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            if (i2 >= 0) {
                m213d(i2);
            } else {
                m212c(i2);
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m195a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i2, i3) == null) {
            c(i2, 0);
            m194a(i3);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m196a(int i2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            c(i2, 0);
            m201a(j);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m197a(int i2, com.xiaomi.push.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048582, this, i2, aVar) == null) {
            c(i2, 2);
            m202a(aVar);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m198a(int i2, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048583, this, i2, eVar) == null) {
            c(i2, 2);
            m203a(eVar);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m199a(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, str) == null) {
            c(i2, 2);
            m204a(str);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m200a(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            c(i2, 0);
            m205a(z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m201a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048586, this, j) == null) {
            m212c(j);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m202a(com.xiaomi.push.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, aVar) == null) {
            byte[] m137a = aVar.m137a();
            m213d(m137a.length);
            a(m137a);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m203a(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, eVar) == null) {
            m213d(eVar.a());
            eVar.a(this);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m204a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            byte[] bytes = str.getBytes("UTF-8");
            m213d(bytes.length);
            a(bytes);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m205a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            m211c(z ? 1 : 0);
        }
    }

    public void a(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bArr) == null) {
            m206a(bArr, 0, bArr.length);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m206a(byte[] bArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048592, this, bArr, i2, i3) == null) {
            int i4 = this.f39916a;
            int i5 = this.f39917b;
            if (i4 - i5 >= i3) {
                System.arraycopy(bArr, i2, this.f171a, i5, i3);
                this.f39917b += i3;
                return;
            }
            int i6 = i4 - i5;
            System.arraycopy(bArr, i2, this.f171a, i5, i6);
            int i7 = i2 + i6;
            int i8 = i3 - i6;
            this.f39917b = this.f39916a;
            c();
            if (i8 > this.f39916a) {
                this.f170a.write(bArr, i7, i8);
                return;
            }
            System.arraycopy(bArr, i7, this.f171a, 0, i8);
            this.f39917b = i8;
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && a() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m207b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            m213d(i2);
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m208b(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048595, this, i2, i3) == null) {
            c(i2, 0);
            m207b(i3);
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m209b(int i2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            c(i2, 0);
            m210b(j);
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m210b(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048597, this, j) == null) {
            m212c(j);
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    public void m211c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            a((byte) i2);
        }
    }

    public void c(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048599, this, i2, i3) == null) {
            m213d(f.a(i2, i3));
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    public void m212c(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048600, this, j) == null) {
            while (((-128) & j) != 0) {
                m211c((((int) j) & 127) | 128);
                j >>>= 7;
            }
            m211c((int) j);
        }
    }

    /* renamed from: d  reason: collision with other method in class */
    public void m213d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            while ((i2 & com.alipay.sdk.encrypt.a.f1889g) != 0) {
                m211c((i2 & 127) | 128);
                i2 >>>= 7;
            }
            m211c(i2);
        }
    }
}
