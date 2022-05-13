package com.repackage;

import android.graphics.Bitmap;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class es9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int[] a;
    public final int[] b;
    public ByteBuffer c;
    public byte[] d;
    public byte[] e;
    public int f;
    public int g;
    public qs9 h;
    public short[] i;
    public byte[] j;
    public byte[] k;
    public byte[] l;
    public int[] m;
    public int n;
    public int o;
    public ms9 p;
    public nt9 q;
    public Bitmap r;
    public boolean s;
    public int t;
    public int u;
    public int v;
    public int w;
    public boolean x;

    public es9() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        nt9 nt9Var = new nt9();
        this.b = new int[256];
        this.f = 0;
        this.g = 0;
        this.q = nt9Var;
        this.p = new ms9();
    }

    public synchronized int a(byte[] bArr) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bArr)) == null) {
            synchronized (this) {
                if (this.h == null) {
                    this.h = new qs9();
                }
                qs9 qs9Var = this.h;
                qs9Var.a(bArr);
                if (qs9Var.b != null) {
                    if (!qs9Var.b()) {
                        String str = "";
                        for (int i2 = 0; i2 < 6; i2++) {
                            str = str + ((char) qs9Var.d());
                        }
                        if (str.startsWith("GIF")) {
                            qs9Var.c.f = qs9Var.b.getShort();
                            qs9Var.c.g = qs9Var.b.getShort();
                            int d = qs9Var.d();
                            qs9Var.c.h = (d & 128) != 0;
                            ms9 ms9Var = qs9Var.c;
                            ms9Var.i = 2 << (d & 7);
                            ms9Var.j = qs9Var.d();
                            qs9Var.c.k = qs9Var.d();
                            if (qs9Var.c.h && !qs9Var.b()) {
                                ms9 ms9Var2 = qs9Var.c;
                                ms9Var2.a = qs9Var.c(ms9Var2.i);
                                ms9 ms9Var3 = qs9Var.c;
                                ms9Var3.l = ms9Var3.a[ms9Var3.j];
                            }
                        } else {
                            qs9Var.c.b = 1;
                        }
                        if (!qs9Var.b()) {
                            boolean z = false;
                            while (!z && !qs9Var.b() && qs9Var.c.c <= Integer.MAX_VALUE) {
                                int d2 = qs9Var.d();
                                if (d2 == 33) {
                                    int d3 = qs9Var.d();
                                    if (d3 != 1) {
                                        if (d3 == 249) {
                                            qs9Var.c.d = new is9();
                                            qs9Var.d();
                                            int d4 = qs9Var.d();
                                            is9 is9Var = qs9Var.c.d;
                                            int i3 = (d4 & 28) >> 2;
                                            is9Var.g = i3;
                                            if (i3 == 0) {
                                                is9Var.g = 1;
                                            }
                                            qs9Var.c.d.f = (d4 & 1) != 0;
                                            short s = qs9Var.b.getShort();
                                            if (s < 2) {
                                                s = 10;
                                            }
                                            is9 is9Var2 = qs9Var.c.d;
                                            is9Var2.i = s * 10;
                                            is9Var2.h = qs9Var.d();
                                            qs9Var.d();
                                        } else if (d3 != 254 && d3 == 255) {
                                            qs9Var.e();
                                            String str2 = "";
                                            for (int i4 = 0; i4 < 11; i4++) {
                                                str2 = str2 + ((char) qs9Var.a[i4]);
                                            }
                                            if (str2.equals("NETSCAPE2.0")) {
                                                do {
                                                    qs9Var.e();
                                                    byte[] bArr2 = qs9Var.a;
                                                    if (bArr2[0] == 1) {
                                                        ms9 ms9Var4 = qs9Var.c;
                                                        int i5 = ((bArr2[2] & 255) << 8) | (bArr2[1] & 255);
                                                        ms9Var4.m = i5;
                                                        if (i5 == 0) {
                                                            ms9Var4.m = -1;
                                                        }
                                                    }
                                                    if (qs9Var.d > 0) {
                                                    }
                                                } while (!qs9Var.b());
                                            }
                                        }
                                    }
                                    qs9Var.f();
                                } else if (d2 == 44) {
                                    ms9 ms9Var5 = qs9Var.c;
                                    if (ms9Var5.d == null) {
                                        ms9Var5.d = new is9();
                                    }
                                    qs9Var.c.d.a = qs9Var.b.getShort();
                                    qs9Var.c.d.b = qs9Var.b.getShort();
                                    qs9Var.c.d.c = qs9Var.b.getShort();
                                    qs9Var.c.d.d = qs9Var.b.getShort();
                                    int d5 = qs9Var.d();
                                    boolean z2 = (d5 & 128) != 0;
                                    int pow = (int) Math.pow(2.0d, (d5 & 7) + 1);
                                    qs9Var.c.d.e = (d5 & 64) != 0;
                                    if (z2) {
                                        qs9Var.c.d.k = qs9Var.c(pow);
                                    } else {
                                        qs9Var.c.d.k = null;
                                    }
                                    qs9Var.c.d.j = qs9Var.b.position();
                                    qs9Var.d();
                                    qs9Var.f();
                                    if (!qs9Var.b()) {
                                        ms9 ms9Var6 = qs9Var.c;
                                        ms9Var6.c++;
                                        ms9Var6.e.add(ms9Var6.d);
                                    }
                                } else if (d2 != 59) {
                                    qs9Var.c.b = 1;
                                } else {
                                    z = true;
                                }
                            }
                            ms9 ms9Var7 = qs9Var.c;
                            if (ms9Var7.c < 0) {
                                ms9Var7.b = 1;
                            }
                        }
                    }
                    ms9 ms9Var8 = qs9Var.c;
                    this.p = ms9Var8;
                    if (bArr != null) {
                        e(ms9Var8, bArr);
                    }
                    i = this.t;
                } else {
                    throw new IllegalStateException("You must call setData() before parseHeader()");
                }
            }
            return i;
        }
        return invokeL.intValue;
    }

    public final Bitmap b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Bitmap a = this.q.a(this.w, this.v, this.x ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
            if (Build.VERSION.SDK_INT >= 12) {
                a.setHasAlpha(true);
            }
            return a;
        }
        return (Bitmap) invokeV.objValue;
    }

    public synchronized void c(ms9 ms9Var, ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, ms9Var, byteBuffer) == null) {
            synchronized (this) {
                d(ms9Var, byteBuffer, 1);
            }
        }
    }

    public synchronized void d(ms9 ms9Var, ByteBuffer byteBuffer, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048579, this, ms9Var, byteBuffer, i) == null) {
            synchronized (this) {
                if (i <= 0) {
                    throw new IllegalArgumentException("Sample size must be >=0, not: " + i);
                }
                int highestOneBit = Integer.highestOneBit(i);
                this.t = 0;
                this.p = ms9Var;
                this.x = false;
                this.n = -1;
                this.o = 0;
                ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
                this.c = asReadOnlyBuffer;
                asReadOnlyBuffer.position(0);
                this.c.order(ByteOrder.LITTLE_ENDIAN);
                this.s = false;
                Iterator it = ms9Var.e.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if (((is9) it.next()).g == 3) {
                        this.s = true;
                        break;
                    }
                }
                this.u = highestOneBit;
                int i2 = ms9Var.f;
                this.w = i2 / highestOneBit;
                int i3 = ms9Var.g;
                this.v = i3 / highestOneBit;
                this.l = this.q.b(i2 * i3);
                this.m = this.q.c(this.w * this.v);
            }
        }
    }

    public synchronized void e(ms9 ms9Var, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, ms9Var, bArr) == null) {
            synchronized (this) {
                c(ms9Var, ByteBuffer.wrap(bArr));
            }
        }
    }

    public final void f(int[] iArr, is9 is9Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048581, this, iArr, is9Var, i) == null) {
            int i2 = is9Var.d;
            int i3 = this.u;
            int i4 = i2 / i3;
            int i5 = is9Var.b / i3;
            int i6 = is9Var.c / i3;
            int i7 = is9Var.a / i3;
            int i8 = this.w;
            int i9 = (i5 * i8) + i7;
            int i10 = (i4 * i8) + i9;
            while (i9 < i10) {
                int i11 = i9 + i6;
                for (int i12 = i9; i12 < i11; i12++) {
                    iArr[i12] = i;
                }
                i9 += this.w;
            }
        }
    }

    public boolean g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            if (i < -1 || i >= this.p.c) {
                return false;
            }
            this.n = i;
            return true;
        }
        return invokeI.booleanValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:260:0x01fc */
    /* JADX DEBUG: Multi-variable search result rejected for r2v32, resolved type: short */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:225:0x0184 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0189  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized Bitmap h() {
        InterceptResult invokeV;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        short s;
        int i9;
        int i10;
        int i11;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            synchronized (this) {
                int i12 = 1;
                if (this.p.c <= 0 || this.n < 0) {
                    this.t = 1;
                }
                int i13 = this.t;
                if (i13 != 1 && i13 != 2) {
                    int i14 = 0;
                    this.t = 0;
                    is9 is9Var = (is9) this.p.e.get(this.n);
                    int i15 = this.n - 1;
                    is9 is9Var2 = i15 >= 0 ? (is9) this.p.e.get(i15) : null;
                    int[] iArr = is9Var.k;
                    if (iArr == null) {
                        iArr = this.p.a;
                    }
                    this.a = iArr;
                    if (iArr == null) {
                        this.t = 1;
                        return null;
                    }
                    if (is9Var.f) {
                        System.arraycopy(iArr, 0, this.b, 0, iArr.length);
                        int[] iArr2 = this.b;
                        this.a = iArr2;
                        iArr2[is9Var.h] = 0;
                    }
                    int[] iArr3 = this.m;
                    if (is9Var2 == null) {
                        Arrays.fill(iArr3, 0);
                    }
                    if (is9Var2 != null && (i10 = is9Var2.g) > 0) {
                        if (i10 == 2) {
                            if (!is9Var.f) {
                                ms9 ms9Var = this.p;
                                i11 = ms9Var.l;
                                if (is9Var.k != null && ms9Var.j == is9Var.h) {
                                }
                                f(iArr3, is9Var2, i11);
                            } else if (this.n == 0) {
                                this.x = true;
                            }
                            i11 = 0;
                            f(iArr3, is9Var2, i11);
                        } else if (i10 == 3) {
                            Bitmap bitmap = this.r;
                            if (bitmap == null) {
                                f(iArr3, is9Var2, 0);
                            } else {
                                int i16 = is9Var2.d;
                                int i17 = this.u;
                                int i18 = is9Var2.b / i17;
                                int i19 = is9Var2.c / i17;
                                int i20 = is9Var2.a / i17;
                                int i21 = this.w;
                                bitmap.getPixels(iArr3, (i18 * i21) + i20, i21, i20, i18, i19, i16 / i17);
                            }
                        }
                    }
                    this.f = 0;
                    this.g = 0;
                    this.c.position(is9Var.j);
                    int i22 = is9Var.c * is9Var.d;
                    byte[] bArr = this.l;
                    if (bArr == null || bArr.length < i22) {
                        this.l = this.q.b(i22);
                    }
                    if (this.i == null) {
                        this.i = new short[4096];
                    }
                    if (this.j == null) {
                        this.j = new byte[4096];
                    }
                    if (this.k == null) {
                        this.k = new byte[4097];
                    }
                    int i23 = i();
                    int i24 = 1 << i23;
                    int i25 = i24 + 1;
                    int i26 = i24 + 2;
                    int i27 = i23 + 1;
                    int i28 = (1 << i27) - 1;
                    for (int i29 = 0; i29 < i24; i29++) {
                        this.i[i29] = 0;
                        this.j[i29] = (byte) i29;
                    }
                    int i30 = i27;
                    int i31 = i26;
                    int i32 = i28;
                    int i33 = 0;
                    int i34 = 0;
                    int i35 = 0;
                    int i36 = 0;
                    int i37 = 0;
                    int i38 = 0;
                    int i39 = 0;
                    int i40 = 0;
                    int i41 = -1;
                    while (true) {
                        if (i33 >= i22) {
                            break;
                        }
                        if (i34 == 0) {
                            i34 = i();
                            if (i34 > 0) {
                                try {
                                    if (this.d == null) {
                                        this.d = this.q.b(255);
                                    }
                                    int i42 = this.f - this.g;
                                    if (i42 >= i34) {
                                        System.arraycopy(this.e, this.g, this.d, i14, i34);
                                        i9 = this.g + i34;
                                    } else if (this.c.remaining() + i42 >= i34) {
                                        try {
                                            System.arraycopy(this.e, this.g, this.d, i14, i42);
                                            this.g = this.f;
                                            j();
                                            int i43 = i34 - i42;
                                            System.arraycopy(this.e, i14, this.d, i42, i43);
                                            i9 = this.g + i43;
                                        } catch (Exception unused) {
                                            i12 = 1;
                                            this.t = i12;
                                            if (i34 > 0) {
                                            }
                                        }
                                    } else {
                                        this.t = i12;
                                    }
                                    this.g = i9;
                                } catch (Exception unused2) {
                                }
                            }
                            if (i34 > 0) {
                                this.t = 3;
                                break;
                            }
                            i36 = 0;
                        }
                        i35 += (this.d[i36] & 255) << i37;
                        i36++;
                        i34--;
                        int i44 = i37 + 8;
                        int i45 = i39;
                        int i46 = i31;
                        int i47 = i30;
                        int i48 = i41;
                        while (i44 >= i47) {
                            int i49 = i27;
                            int i50 = i35 & i32;
                            i35 >>= i47;
                            i44 -= i47;
                            if (i50 != i24) {
                                if (i50 > i46) {
                                    i8 = i44;
                                    this.t = 3;
                                } else {
                                    i8 = i44;
                                    if (i50 != i25) {
                                        if (i48 == -1) {
                                            this.k[i40] = this.j[i50];
                                            i40++;
                                            i48 = i50;
                                            i45 = i48;
                                            i27 = i49;
                                            i44 = i8;
                                        } else {
                                            if (i50 >= i46) {
                                                this.k[i40] = (byte) i45;
                                                s = i48;
                                                i40++;
                                            } else {
                                                s = i50;
                                            }
                                            while (s >= i24) {
                                                this.k[i40] = this.j[s];
                                                s = this.i[s];
                                                i40++;
                                                i50 = i50;
                                            }
                                            int i51 = i50;
                                            byte[] bArr2 = this.j;
                                            int i52 = bArr2[s] & 255;
                                            int i53 = i40 + 1;
                                            int i54 = i24;
                                            byte b = (byte) i52;
                                            this.k[i40] = b;
                                            if (i46 < 4096) {
                                                this.i[i46] = (short) i48;
                                                bArr2[i46] = b;
                                                i46++;
                                                if ((i46 & i32) == 0 && i46 < 4096) {
                                                    i47++;
                                                    i32 += i46;
                                                }
                                            }
                                            i40 = i53;
                                            while (i40 > 0) {
                                                i40--;
                                                this.l[i38] = this.k[i40];
                                                i33++;
                                                i38++;
                                            }
                                            i45 = i52;
                                            i27 = i49;
                                            i44 = i8;
                                            i48 = i51;
                                            i24 = i54;
                                        }
                                    }
                                }
                                i41 = i48;
                                i30 = i47;
                                i27 = i49;
                                i37 = i8;
                                i14 = 0;
                                i12 = 1;
                                i39 = i45;
                                i31 = i46;
                                break;
                            }
                            i46 = i26;
                            i32 = i28;
                            i27 = i49;
                            i47 = i27;
                            i48 = -1;
                        }
                        i41 = i48;
                        i37 = i44;
                        i39 = i45;
                        i31 = i46;
                        i30 = i47;
                        i14 = 0;
                        i12 = 1;
                    }
                    for (int i55 = i38; i55 < i22; i55++) {
                        this.l[i55] = 0;
                    }
                    int i56 = is9Var.d;
                    int i57 = this.u;
                    int i58 = i56 / i57;
                    int i59 = is9Var.b / i57;
                    int i60 = is9Var.c / i57;
                    int i61 = is9Var.a / i57;
                    boolean z = this.n == 0;
                    int i62 = 0;
                    int i63 = 1;
                    int i64 = 0;
                    int i65 = 8;
                    while (i64 < i58) {
                        if (is9Var.e) {
                            if (i62 >= i58) {
                                i63++;
                                if (i63 == 2) {
                                    i62 = 4;
                                } else if (i63 == 3) {
                                    i62 = 2;
                                    i65 = 4;
                                } else if (i63 == 4) {
                                    i62 = 1;
                                    i65 = 2;
                                }
                            }
                            i2 = i62 + i65;
                        } else {
                            i2 = i62;
                            i62 = i64;
                        }
                        int i66 = i62 + i59;
                        if (i66 < this.v) {
                            int i67 = this.w;
                            int i68 = i66 * i67;
                            int i69 = i68 + i61;
                            int i70 = i69 + i60;
                            int i71 = i68 + i67;
                            if (i71 < i70) {
                                i70 = i71;
                            }
                            int i72 = this.u;
                            int i73 = i64 * i72 * is9Var.c;
                            int i74 = ((i70 - i69) * i72) + i73;
                            int i75 = i69;
                            while (i75 < i70) {
                                int i76 = i58;
                                int i77 = i59;
                                if (this.u == 1) {
                                    i6 = this.a[this.l[i73] & 255];
                                    i3 = i60;
                                    i4 = i61;
                                    i5 = i63;
                                } else {
                                    int i78 = is9Var.c;
                                    i3 = i60;
                                    int i79 = i73;
                                    int i80 = 0;
                                    int i81 = 0;
                                    int i82 = 0;
                                    int i83 = 0;
                                    int i84 = 0;
                                    while (true) {
                                        if (i79 >= this.u + i73) {
                                            i4 = i61;
                                            break;
                                        }
                                        byte[] bArr3 = this.l;
                                        i4 = i61;
                                        if (i79 >= bArr3.length || i79 >= i74) {
                                            break;
                                        }
                                        int i85 = this.a[bArr3[i79] & 255];
                                        if (i85 != 0) {
                                            i7 = i63;
                                            i83 += (i85 >> 24) & 255;
                                            i82 += (i85 >> 16) & 255;
                                            i81 += (i85 >> 8) & 255;
                                            i80 += i85 & 255;
                                            i84++;
                                        } else {
                                            i7 = i63;
                                        }
                                        i79++;
                                        i61 = i4;
                                        i63 = i7;
                                    }
                                    i5 = i63;
                                    int i86 = i78 + i73;
                                    for (int i87 = i86; i87 < this.u + i86; i87++) {
                                        byte[] bArr4 = this.l;
                                        if (i87 >= bArr4.length || i87 >= i74) {
                                            break;
                                        }
                                        int i88 = this.a[bArr4[i87] & 255];
                                        if (i88 != 0) {
                                            i83 += (i88 >> 24) & 255;
                                            i82 += (i88 >> 16) & 255;
                                            i81 += (i88 >> 8) & 255;
                                            i80 += i88 & 255;
                                            i84++;
                                        }
                                    }
                                    i6 = i84 == 0 ? 0 : ((i83 / i84) << 24) | ((i82 / i84) << 16) | ((i81 / i84) << 8) | (i80 / i84);
                                }
                                if (i6 != 0) {
                                    iArr3[i75] = i6;
                                } else if (!this.x && z) {
                                    this.x = true;
                                }
                                i73 += this.u;
                                i75++;
                                i58 = i76;
                                i59 = i77;
                                i60 = i3;
                                i61 = i4;
                                i63 = i5;
                            }
                        }
                        i64++;
                        i62 = i2;
                        i58 = i58;
                        i59 = i59;
                        i60 = i60;
                        i61 = i61;
                        i63 = i63;
                    }
                    if (this.s && ((i = is9Var.g) == 0 || i == 1)) {
                        if (this.r == null) {
                            this.r = b();
                        }
                        Bitmap bitmap2 = this.r;
                        int i89 = this.w;
                        bitmap2.setPixels(iArr3, 0, i89, 0, 0, i89, this.v);
                    }
                    Bitmap b2 = b();
                    int i90 = this.w;
                    b2.setPixels(iArr3, 0, i90, 0, 0, i90, this.v);
                    return b2;
                }
                return null;
            }
        }
        return (Bitmap) invokeV.objValue;
    }

    public final int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            try {
                j();
                byte[] bArr = this.e;
                int i = this.g;
                this.g = i + 1;
                return bArr[i] & 255;
            } catch (Exception unused) {
                this.t = 1;
                return 0;
            }
        }
        return invokeV.intValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.f > this.g) {
            return;
        }
        if (this.e == null) {
            this.e = this.q.b(16384);
        }
        this.g = 0;
        int min = Math.min(this.c.remaining(), 16384);
        this.f = min;
        this.c.get(this.e, 0, min);
    }
}
