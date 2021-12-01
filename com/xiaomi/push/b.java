package com.xiaomi.push;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.protobuf.CodedInputStream;
import java.io.InputStream;
import java.util.Vector;
import kotlin.jvm.internal.ByteCompanionObject;
/* loaded from: classes3.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public final InputStream f150a;

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f151a;

    /* renamed from: b  reason: collision with root package name */
    public int f62731b;

    /* renamed from: c  reason: collision with root package name */
    public int f62732c;

    /* renamed from: d  reason: collision with root package name */
    public int f62733d;

    /* renamed from: e  reason: collision with root package name */
    public int f62734e;

    /* renamed from: f  reason: collision with root package name */
    public int f62735f;

    /* renamed from: g  reason: collision with root package name */
    public int f62736g;

    /* renamed from: h  reason: collision with root package name */
    public int f62737h;

    /* renamed from: i  reason: collision with root package name */
    public int f62738i;

    public b(InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputStream};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f62735f = Integer.MAX_VALUE;
        this.f62737h = 64;
        this.f62738i = CodedInputStream.DEFAULT_SIZE_LIMIT;
        this.f151a = new byte[4096];
        this.a = 0;
        this.f62732c = 0;
        this.f150a = inputStream;
    }

    public b(byte[] bArr, int i2, int i3) {
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
        this.f62735f = Integer.MAX_VALUE;
        this.f62737h = 64;
        this.f62738i = CodedInputStream.DEFAULT_SIZE_LIMIT;
        this.f151a = bArr;
        this.a = i3 + i2;
        this.f62732c = i2;
        this.f150a = null;
    }

    public static b a(InputStream inputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, inputStream)) == null) ? new b(inputStream) : (b) invokeL.objValue;
    }

    public static b a(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(65539, null, bArr, i2, i3)) == null) ? new b(bArr, i2, i3) : (b) invokeLII.objValue;
    }

    private boolean a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TRACKBALL, this, z)) == null) {
            int i2 = this.f62732c;
            int i3 = this.a;
            if (i2 >= i3) {
                int i4 = this.f62734e;
                if (i4 + i3 == this.f62735f) {
                    if (z) {
                        throw d.a();
                    }
                    return false;
                }
                this.f62734e = i4 + i3;
                this.f62732c = 0;
                InputStream inputStream = this.f150a;
                int read = inputStream == null ? -1 : inputStream.read(this.f151a);
                this.a = read;
                if (read == 0 || read < -1) {
                    throw new IllegalStateException("InputStream#read(byte[]) returned invalid result: " + this.a + "\nThe InputStream implementation is buggy.");
                } else if (read == -1) {
                    this.a = 0;
                    if (z) {
                        throw d.a();
                    }
                    return false;
                } else {
                    b();
                    int i5 = this.f62734e + this.a + this.f62731b;
                    if (i5 > this.f62738i || i5 < 0) {
                        throw d.h();
                    }
                    return true;
                }
            }
            throw new IllegalStateException("refillBuffer() called when buffer wasn't empty.");
        }
        return invokeZ.booleanValue;
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            int i2 = this.a + this.f62731b;
            this.a = i2;
            int i3 = this.f62734e + i2;
            int i4 = this.f62735f;
            if (i3 <= i4) {
                this.f62731b = 0;
                return;
            }
            int i5 = i3 - i4;
            this.f62731b = i5;
            this.a = i2 - i5;
        }
    }

    public byte a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f62732c == this.a) {
                a(true);
            }
            byte[] bArr = this.f151a;
            int i2 = this.f62732c;
            this.f62732c = i2 + 1;
            return bArr[i2];
        }
        return invokeV.byteValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public int m209a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (m220b()) {
                this.f62733d = 0;
                return 0;
            }
            int d2 = d();
            this.f62733d = d2;
            if (d2 != 0) {
                return d2;
            }
            throw d.d();
        }
        return invokeV.intValue;
    }

    public int a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            if (i2 >= 0) {
                int i3 = i2 + this.f62734e + this.f62732c;
                int i4 = this.f62735f;
                if (i3 <= i4) {
                    this.f62735f = i3;
                    b();
                    return i4;
                }
                throw d.a();
            }
            throw d.b();
        }
        return invokeI.intValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public long m210a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? m221c() : invokeV.longValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public a m211a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int d2 = d();
            int i2 = this.a;
            int i3 = this.f62732c;
            if (d2 > i2 - i3 || d2 <= 0) {
                return a.a(m217a(d2));
            }
            a a = a.a(this.f151a, i3, d2);
            this.f62732c += d2;
            return a;
        }
        return (a) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m212a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            int d2 = d();
            if (d2 > this.a - this.f62732c || d2 <= 0) {
                return new String(m217a(d2), "UTF-8");
            }
            String str = new String(this.f151a, this.f62732c, d2, "UTF-8");
            this.f62732c += d2;
            return str;
        }
        return (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m213a() {
        int m209a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            do {
                m209a = m209a();
                if (m209a == 0) {
                    return;
                }
            } while (m216a(m209a));
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m214a(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048583, this, i2) == null) && this.f62733d != i2) {
            throw d.e();
        }
    }

    public void a(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar) == null) {
            int d2 = d();
            if (this.f62736g >= this.f62737h) {
                throw d.g();
            }
            int a = a(d2);
            this.f62736g++;
            eVar.a(this);
            m214a(0);
            this.f62736g--;
            b(a);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m215a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? d() != 0 : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m216a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            int a = f.a(i2);
            if (a == 0) {
                m218b();
                return true;
            } else if (a == 1) {
                m222d();
                return true;
            } else if (a == 2) {
                c(d());
                return true;
            } else if (a == 3) {
                m213a();
                m214a(f.a(f.b(i2), 4));
                return true;
            } else if (a != 4) {
                if (a == 5) {
                    e();
                    return true;
                }
                throw d.f();
            } else {
                return false;
            }
        }
        return invokeI.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m217a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeI = interceptable.invokeI(1048587, this, i2)) != null) {
            return (byte[]) invokeI.objValue;
        }
        if (i2 < 0) {
            throw d.b();
        }
        int i3 = this.f62734e;
        int i4 = this.f62732c;
        int i5 = i3 + i4 + i2;
        int i6 = this.f62735f;
        if (i5 > i6) {
            c((i6 - i3) - i4);
            throw d.a();
        }
        int i7 = this.a;
        if (i2 <= i7 - i4) {
            byte[] bArr = new byte[i2];
            System.arraycopy(this.f151a, i4, bArr, 0, i2);
            this.f62732c += i2;
            return bArr;
        } else if (i2 >= 4096) {
            this.f62734e = i3 + i7;
            this.f62732c = 0;
            this.a = 0;
            int i8 = i7 - i4;
            int i9 = i2 - i8;
            Vector vector = new Vector();
            while (i9 > 0) {
                int min = Math.min(i9, 4096);
                byte[] bArr2 = new byte[min];
                int i10 = 0;
                while (i10 < min) {
                    InputStream inputStream = this.f150a;
                    int read = inputStream == null ? -1 : inputStream.read(bArr2, i10, min - i10);
                    if (read == -1) {
                        throw d.a();
                    }
                    this.f62734e += read;
                    i10 += read;
                }
                i9 -= min;
                vector.addElement(bArr2);
            }
            byte[] bArr3 = new byte[i2];
            System.arraycopy(this.f151a, i4, bArr3, 0, i8);
            for (int i11 = 0; i11 < vector.size(); i11++) {
                byte[] bArr4 = (byte[]) vector.elementAt(i11);
                System.arraycopy(bArr4, 0, bArr3, i8, bArr4.length);
                i8 += bArr4.length;
            }
            return bArr3;
        } else {
            byte[] bArr5 = new byte[i2];
            int i12 = i7 - i4;
            System.arraycopy(this.f151a, i4, bArr5, 0, i12);
            this.f62732c = this.a;
            while (true) {
                a(true);
                int i13 = i2 - i12;
                int i14 = this.a;
                if (i13 <= i14) {
                    System.arraycopy(this.f151a, 0, bArr5, i12, i13);
                    this.f62732c = i13;
                    return bArr5;
                }
                System.arraycopy(this.f151a, 0, bArr5, i12, i14);
                int i15 = this.a;
                i12 += i15;
                this.f62732c = i15;
            }
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public int m218b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? d() : invokeV.intValue;
    }

    /* renamed from: b  reason: collision with other method in class */
    public long m219b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? m221c() : invokeV.longValue;
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.f62735f = i2;
            b();
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m220b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f62732c == this.a && !a(false) : invokeV.booleanValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? d() : invokeV.intValue;
    }

    /* renamed from: c  reason: collision with other method in class */
    public long m221c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            long j2 = 0;
            for (int i2 = 0; i2 < 64; i2 += 7) {
                byte a = a();
                j2 |= (a & ByteCompanionObject.MAX_VALUE) << i2;
                if ((a & ByteCompanionObject.MIN_VALUE) == 0) {
                    return j2;
                }
            }
            throw d.c();
        }
        return invokeV.longValue;
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            if (i2 < 0) {
                throw d.b();
            }
            int i3 = this.f62734e;
            int i4 = this.f62732c;
            int i5 = i3 + i4 + i2;
            int i6 = this.f62735f;
            if (i5 > i6) {
                c((i6 - i3) - i4);
                throw d.a();
            }
            int i7 = this.a;
            if (i2 <= i7 - i4) {
                this.f62732c = i4 + i2;
                return;
            }
            int i8 = i7 - i4;
            this.f62734e = i3 + i7;
            this.f62732c = 0;
            this.a = 0;
            while (i8 < i2) {
                InputStream inputStream = this.f150a;
                int skip = inputStream == null ? -1 : (int) inputStream.skip(i2 - i8);
                if (skip <= 0) {
                    throw d.a();
                }
                i8 += skip;
                this.f62734e += skip;
            }
        }
    }

    public int d() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            byte a = a();
            if (a >= 0) {
                return a;
            }
            int i3 = a & ByteCompanionObject.MAX_VALUE;
            byte a2 = a();
            if (a2 >= 0) {
                i2 = a2 << 7;
            } else {
                i3 |= (a2 & ByteCompanionObject.MAX_VALUE) << 7;
                byte a3 = a();
                if (a3 >= 0) {
                    i2 = a3 << 14;
                } else {
                    i3 |= (a3 & ByteCompanionObject.MAX_VALUE) << 14;
                    byte a4 = a();
                    if (a4 < 0) {
                        int i4 = i3 | ((a4 & ByteCompanionObject.MAX_VALUE) << 21);
                        byte a5 = a();
                        int i5 = i4 | (a5 << 28);
                        if (a5 < 0) {
                            for (int i6 = 0; i6 < 5; i6++) {
                                if (a() >= 0) {
                                    return i5;
                                }
                            }
                            throw d.c();
                        }
                        return i5;
                    }
                    i2 = a4 << 21;
                }
            }
            return i3 | i2;
        }
        return invokeV.intValue;
    }

    /* renamed from: d  reason: collision with other method in class */
    public long m222d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            byte a = a();
            return ((a() & 255) << 8) | (a & 255) | ((a() & 255) << 16) | ((a() & 255) << 24) | ((a() & 255) << 32) | ((a() & 255) << 40) | ((a() & 255) << 48) | ((a() & 255) << 56);
        }
        return invokeV.longValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? (a() & 255) | ((a() & 255) << 8) | ((a() & 255) << 16) | ((a() & 255) << 24) : invokeV.intValue;
    }
}
