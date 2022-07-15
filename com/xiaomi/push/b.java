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
/* loaded from: classes8.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public final InputStream f846a;

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f847a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;

    public b(InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputStream};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = Integer.MAX_VALUE;
        this.h = 64;
        this.i = CodedInputStream.DEFAULT_SIZE_LIMIT;
        this.f847a = new byte[4096];
        this.a = 0;
        this.c = 0;
        this.f846a = inputStream;
    }

    public b(byte[] bArr, int i, int i2) {
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
        this.f = Integer.MAX_VALUE;
        this.h = 64;
        this.i = CodedInputStream.DEFAULT_SIZE_LIMIT;
        this.f847a = bArr;
        this.a = i2 + i;
        this.c = i;
        this.f846a = null;
    }

    public static b a(InputStream inputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, inputStream)) == null) ? new b(inputStream) : (b) invokeL.objValue;
    }

    public static b a(byte[] bArr, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(65539, null, bArr, i, i2)) == null) ? new b(bArr, i, i2) : (b) invokeLII.objValue;
    }

    private boolean a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TRACKBALL, this, z)) == null) {
            int i = this.c;
            int i2 = this.a;
            if (i >= i2) {
                int i3 = this.e;
                if (i3 + i2 == this.f) {
                    if (z) {
                        throw d.a();
                    }
                    return false;
                }
                this.e = i3 + i2;
                this.c = 0;
                InputStream inputStream = this.f846a;
                int read = inputStream == null ? -1 : inputStream.read(this.f847a);
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
                    int i4 = this.e + this.a + this.b;
                    if (i4 > this.i || i4 < 0) {
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
            int i = this.a + this.b;
            this.a = i;
            int i2 = this.e + i;
            int i3 = this.f;
            if (i2 <= i3) {
                this.b = 0;
                return;
            }
            int i4 = i2 - i3;
            this.b = i4;
            this.a = i - i4;
        }
    }

    public byte a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.c == this.a) {
                a(true);
            }
            byte[] bArr = this.f847a;
            int i = this.c;
            this.c = i + 1;
            return bArr[i];
        }
        return invokeV.byteValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public int m1112a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (m1123b()) {
                this.d = 0;
                return 0;
            }
            int d = d();
            this.d = d;
            if (d != 0) {
                return d;
            }
            throw d.d();
        }
        return invokeV.intValue;
    }

    public int a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            if (i >= 0) {
                int i2 = i + this.e + this.c;
                int i3 = this.f;
                if (i2 <= i3) {
                    this.f = i2;
                    b();
                    return i3;
                }
                throw d.a();
            }
            throw d.b();
        }
        return invokeI.intValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public long m1113a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? m1124c() : invokeV.longValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public a m1114a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int d = d();
            int i = this.a;
            int i2 = this.c;
            if (d > i - i2 || d <= 0) {
                return a.a(m1120a(d));
            }
            a a = a.a(this.f847a, i2, d);
            this.c += d;
            return a;
        }
        return (a) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m1115a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            int d = d();
            if (d > this.a - this.c || d <= 0) {
                return new String(m1120a(d), "UTF-8");
            }
            String str = new String(this.f847a, this.c, d, "UTF-8");
            this.c += d;
            return str;
        }
        return (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m1116a() {
        int m1112a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            do {
                m1112a = m1112a();
                if (m1112a == 0) {
                    return;
                }
            } while (m1119a(m1112a));
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m1117a(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048583, this, i) == null) && this.d != i) {
            throw d.e();
        }
    }

    public void a(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar) == null) {
            int d = d();
            if (this.g >= this.h) {
                throw d.g();
            }
            int a = a(d);
            this.g++;
            eVar.a(this);
            m1117a(0);
            this.g--;
            b(a);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m1118a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? d() != 0 : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m1119a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            int a = f.a(i);
            if (a == 0) {
                m1121b();
                return true;
            } else if (a == 1) {
                m1125d();
                return true;
            } else if (a == 2) {
                c(d());
                return true;
            } else if (a == 3) {
                m1116a();
                m1117a(f.a(f.b(i), 4));
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
    public byte[] m1120a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeI = interceptable.invokeI(1048587, this, i)) != null) {
            return (byte[]) invokeI.objValue;
        }
        if (i < 0) {
            throw d.b();
        }
        int i2 = this.e;
        int i3 = this.c;
        int i4 = i2 + i3 + i;
        int i5 = this.f;
        if (i4 > i5) {
            c((i5 - i2) - i3);
            throw d.a();
        }
        int i6 = this.a;
        if (i <= i6 - i3) {
            byte[] bArr = new byte[i];
            System.arraycopy(this.f847a, i3, bArr, 0, i);
            this.c += i;
            return bArr;
        } else if (i >= 4096) {
            this.e = i2 + i6;
            this.c = 0;
            this.a = 0;
            int i7 = i6 - i3;
            int i8 = i - i7;
            Vector vector = new Vector();
            while (i8 > 0) {
                int min = Math.min(i8, 4096);
                byte[] bArr2 = new byte[min];
                int i9 = 0;
                while (i9 < min) {
                    InputStream inputStream = this.f846a;
                    int read = inputStream == null ? -1 : inputStream.read(bArr2, i9, min - i9);
                    if (read == -1) {
                        throw d.a();
                    }
                    this.e += read;
                    i9 += read;
                }
                i8 -= min;
                vector.addElement(bArr2);
            }
            byte[] bArr3 = new byte[i];
            System.arraycopy(this.f847a, i3, bArr3, 0, i7);
            for (int i10 = 0; i10 < vector.size(); i10++) {
                byte[] bArr4 = (byte[]) vector.elementAt(i10);
                System.arraycopy(bArr4, 0, bArr3, i7, bArr4.length);
                i7 += bArr4.length;
            }
            return bArr3;
        } else {
            byte[] bArr5 = new byte[i];
            int i11 = i6 - i3;
            System.arraycopy(this.f847a, i3, bArr5, 0, i11);
            this.c = this.a;
            while (true) {
                a(true);
                int i12 = i - i11;
                int i13 = this.a;
                if (i12 <= i13) {
                    System.arraycopy(this.f847a, 0, bArr5, i11, i12);
                    this.c = i12;
                    return bArr5;
                }
                System.arraycopy(this.f847a, 0, bArr5, i11, i13);
                int i14 = this.a;
                i11 += i14;
                this.c = i14;
            }
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public int m1121b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? d() : invokeV.intValue;
    }

    /* renamed from: b  reason: collision with other method in class */
    public long m1122b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? m1124c() : invokeV.longValue;
    }

    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.f = i;
            b();
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m1123b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.c == this.a && !a(false) : invokeV.booleanValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? d() : invokeV.intValue;
    }

    /* renamed from: c  reason: collision with other method in class */
    public long m1124c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            long j = 0;
            for (int i = 0; i < 64; i += 7) {
                byte a = a();
                j |= (a & ByteCompanionObject.MAX_VALUE) << i;
                if ((a & 128) == 0) {
                    return j;
                }
            }
            throw d.c();
        }
        return invokeV.longValue;
    }

    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            if (i < 0) {
                throw d.b();
            }
            int i2 = this.e;
            int i3 = this.c;
            int i4 = i2 + i3 + i;
            int i5 = this.f;
            if (i4 > i5) {
                c((i5 - i2) - i3);
                throw d.a();
            }
            int i6 = this.a;
            if (i <= i6 - i3) {
                this.c = i3 + i;
                return;
            }
            int i7 = i6 - i3;
            this.e = i2 + i6;
            this.c = 0;
            this.a = 0;
            while (i7 < i) {
                InputStream inputStream = this.f846a;
                int skip = inputStream == null ? -1 : (int) inputStream.skip(i - i7);
                if (skip <= 0) {
                    throw d.a();
                }
                i7 += skip;
                this.e += skip;
            }
        }
    }

    public int d() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            byte a = a();
            if (a >= 0) {
                return a;
            }
            int i2 = a & ByteCompanionObject.MAX_VALUE;
            byte a2 = a();
            if (a2 >= 0) {
                i = a2 << 7;
            } else {
                i2 |= (a2 & ByteCompanionObject.MAX_VALUE) << 7;
                byte a3 = a();
                if (a3 >= 0) {
                    i = a3 << 14;
                } else {
                    i2 |= (a3 & ByteCompanionObject.MAX_VALUE) << 14;
                    byte a4 = a();
                    if (a4 < 0) {
                        int i3 = i2 | ((a4 & ByteCompanionObject.MAX_VALUE) << 21);
                        byte a5 = a();
                        int i4 = i3 | (a5 << 28);
                        if (a5 < 0) {
                            for (int i5 = 0; i5 < 5; i5++) {
                                if (a() >= 0) {
                                    return i4;
                                }
                            }
                            throw d.c();
                        }
                        return i4;
                    }
                    i = a4 << 21;
                }
            }
            return i2 | i;
        }
        return invokeV.intValue;
    }

    /* renamed from: d  reason: collision with other method in class */
    public long m1125d() {
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
