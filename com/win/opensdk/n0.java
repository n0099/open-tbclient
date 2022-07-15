package com.win.opensdk;

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
/* loaded from: classes8.dex */
public class n0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int[] a;
    public final int[] b;
    public ByteBuffer c;
    public byte[] d;
    public byte[] e;
    public int f;
    public int g;
    public q0 h;
    public short[] i;
    public byte[] j;
    public byte[] k;
    public byte[] l;
    public int[] m;
    public int n;
    public int o;
    public p0 p;
    public w0 q;
    public Bitmap r;
    public boolean s;
    public int t;
    public int u;
    public int v;
    public int w;
    public boolean x;

    public n0() {
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
        w0 w0Var = new w0();
        this.b = new int[256];
        this.f = 0;
        this.g = 0;
        this.q = w0Var;
        this.p = new p0();
    }

    public final Bitmap a() {
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

    public synchronized void a(p0 p0Var, ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, p0Var, byteBuffer) == null) {
            synchronized (this) {
                a(p0Var, byteBuffer, 1);
            }
        }
    }

    public synchronized void a(p0 p0Var, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, p0Var, bArr) == null) {
            synchronized (this) {
                a(p0Var, ByteBuffer.wrap(bArr));
            }
        }
    }

    public final void a(int[] iArr, o0 o0Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048581, this, iArr, o0Var, i) == null) {
            int i2 = o0Var.d;
            int i3 = this.u;
            int i4 = i2 / i3;
            int i5 = o0Var.b / i3;
            int i6 = o0Var.c / i3;
            int i7 = o0Var.a / i3;
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

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:260:0x01fc */
    /* JADX DEBUG: Multi-variable search result rejected for r2v32, resolved type: short */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:225:0x0184 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0189  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized Bitmap b() {
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
                    o0 o0Var = (o0) this.p.e.get(this.n);
                    int i15 = this.n - 1;
                    o0 o0Var2 = i15 >= 0 ? (o0) this.p.e.get(i15) : null;
                    int[] iArr = o0Var.k;
                    if (iArr == null) {
                        iArr = this.p.a;
                    }
                    this.a = iArr;
                    if (iArr == null) {
                        this.t = 1;
                        return null;
                    }
                    if (o0Var.f) {
                        System.arraycopy(iArr, 0, this.b, 0, iArr.length);
                        int[] iArr2 = this.b;
                        this.a = iArr2;
                        iArr2[o0Var.h] = 0;
                    }
                    int[] iArr3 = this.m;
                    if (o0Var2 == null) {
                        Arrays.fill(iArr3, 0);
                    }
                    if (o0Var2 != null && (i10 = o0Var2.g) > 0) {
                        if (i10 == 2) {
                            if (!o0Var.f) {
                                p0 p0Var = this.p;
                                i11 = p0Var.l;
                                if (o0Var.k != null && p0Var.j == o0Var.h) {
                                }
                                a(iArr3, o0Var2, i11);
                            } else if (this.n == 0) {
                                this.x = true;
                            }
                            i11 = 0;
                            a(iArr3, o0Var2, i11);
                        } else if (i10 == 3) {
                            Bitmap bitmap = this.r;
                            if (bitmap == null) {
                                a(iArr3, o0Var2, 0);
                            } else {
                                int i16 = o0Var2.d;
                                int i17 = this.u;
                                int i18 = o0Var2.b / i17;
                                int i19 = o0Var2.c / i17;
                                int i20 = o0Var2.a / i17;
                                int i21 = this.w;
                                bitmap.getPixels(iArr3, (i18 * i21) + i20, i21, i20, i18, i19, i16 / i17);
                            }
                        }
                    }
                    this.f = 0;
                    this.g = 0;
                    this.c.position(o0Var.j);
                    int i22 = o0Var.c * o0Var.d;
                    byte[] bArr = this.l;
                    if (bArr == null || bArr.length < i22) {
                        this.l = this.q.a(i22);
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
                    int c = c();
                    int i23 = 1 << c;
                    int i24 = i23 + 1;
                    int i25 = i23 + 2;
                    int i26 = c + 1;
                    int i27 = (1 << i26) - 1;
                    for (int i28 = 0; i28 < i23; i28++) {
                        this.i[i28] = 0;
                        this.j[i28] = (byte) i28;
                    }
                    int i29 = i26;
                    int i30 = i25;
                    int i31 = i27;
                    int i32 = 0;
                    int i33 = 0;
                    int i34 = 0;
                    int i35 = 0;
                    int i36 = 0;
                    int i37 = 0;
                    int i38 = 0;
                    int i39 = 0;
                    int i40 = -1;
                    while (true) {
                        if (i32 >= i22) {
                            break;
                        }
                        if (i33 == 0) {
                            i33 = c();
                            if (i33 > 0) {
                                try {
                                    if (this.d == null) {
                                        this.d = this.q.a(255);
                                    }
                                    int i41 = this.f - this.g;
                                    if (i41 >= i33) {
                                        System.arraycopy(this.e, this.g, this.d, i14, i33);
                                        i9 = this.g + i33;
                                    } else if (this.c.remaining() + i41 >= i33) {
                                        try {
                                            System.arraycopy(this.e, this.g, this.d, i14, i41);
                                            this.g = this.f;
                                            d();
                                            int i42 = i33 - i41;
                                            System.arraycopy(this.e, i14, this.d, i41, i42);
                                            i9 = this.g + i42;
                                        } catch (Exception unused) {
                                            i12 = 1;
                                            this.t = i12;
                                            if (i33 > 0) {
                                            }
                                        }
                                    } else {
                                        this.t = i12;
                                    }
                                    this.g = i9;
                                } catch (Exception unused2) {
                                }
                            }
                            if (i33 > 0) {
                                this.t = 3;
                                break;
                            }
                            i35 = 0;
                        }
                        i34 += (this.d[i35] & 255) << i36;
                        i35++;
                        i33--;
                        int i43 = i36 + 8;
                        int i44 = i38;
                        int i45 = i30;
                        int i46 = i29;
                        int i47 = i40;
                        while (i43 >= i46) {
                            int i48 = i26;
                            int i49 = i34 & i31;
                            i34 >>= i46;
                            i43 -= i46;
                            if (i49 != i23) {
                                if (i49 > i45) {
                                    i8 = i43;
                                    this.t = 3;
                                } else {
                                    i8 = i43;
                                    if (i49 != i24) {
                                        if (i47 == -1) {
                                            this.k[i39] = this.j[i49];
                                            i39++;
                                            i47 = i49;
                                            i44 = i47;
                                            i26 = i48;
                                            i43 = i8;
                                        } else {
                                            if (i49 >= i45) {
                                                this.k[i39] = (byte) i44;
                                                s = i47;
                                                i39++;
                                            } else {
                                                s = i49;
                                            }
                                            while (s >= i23) {
                                                this.k[i39] = this.j[s];
                                                s = this.i[s];
                                                i39++;
                                                i49 = i49;
                                            }
                                            int i50 = i49;
                                            byte[] bArr2 = this.j;
                                            int i51 = bArr2[s] & 255;
                                            int i52 = i39 + 1;
                                            int i53 = i23;
                                            byte b = (byte) i51;
                                            this.k[i39] = b;
                                            if (i45 < 4096) {
                                                this.i[i45] = (short) i47;
                                                bArr2[i45] = b;
                                                i45++;
                                                if ((i45 & i31) == 0 && i45 < 4096) {
                                                    i46++;
                                                    i31 += i45;
                                                }
                                            }
                                            i39 = i52;
                                            while (i39 > 0) {
                                                i39--;
                                                this.l[i37] = this.k[i39];
                                                i32++;
                                                i37++;
                                            }
                                            i44 = i51;
                                            i26 = i48;
                                            i43 = i8;
                                            i47 = i50;
                                            i23 = i53;
                                        }
                                    }
                                }
                                i40 = i47;
                                i29 = i46;
                                i26 = i48;
                                i36 = i8;
                                i14 = 0;
                                i12 = 1;
                                i38 = i44;
                                i30 = i45;
                                break;
                            }
                            i45 = i25;
                            i31 = i27;
                            i26 = i48;
                            i46 = i26;
                            i47 = -1;
                        }
                        i40 = i47;
                        i36 = i43;
                        i38 = i44;
                        i30 = i45;
                        i29 = i46;
                        i14 = 0;
                        i12 = 1;
                    }
                    for (int i54 = i37; i54 < i22; i54++) {
                        this.l[i54] = 0;
                    }
                    int i55 = o0Var.d;
                    int i56 = this.u;
                    int i57 = i55 / i56;
                    int i58 = o0Var.b / i56;
                    int i59 = o0Var.c / i56;
                    int i60 = o0Var.a / i56;
                    boolean z = this.n == 0;
                    int i61 = 0;
                    int i62 = 1;
                    int i63 = 0;
                    int i64 = 8;
                    while (i63 < i57) {
                        if (o0Var.e) {
                            if (i61 >= i57) {
                                i62++;
                                if (i62 == 2) {
                                    i61 = 4;
                                } else if (i62 == 3) {
                                    i61 = 2;
                                    i64 = 4;
                                } else if (i62 == 4) {
                                    i61 = 1;
                                    i64 = 2;
                                }
                            }
                            i2 = i61 + i64;
                        } else {
                            i2 = i61;
                            i61 = i63;
                        }
                        int i65 = i61 + i58;
                        if (i65 < this.v) {
                            int i66 = this.w;
                            int i67 = i65 * i66;
                            int i68 = i67 + i60;
                            int i69 = i68 + i59;
                            int i70 = i67 + i66;
                            if (i70 < i69) {
                                i69 = i70;
                            }
                            int i71 = this.u;
                            int i72 = i63 * i71 * o0Var.c;
                            int i73 = ((i69 - i68) * i71) + i72;
                            int i74 = i68;
                            while (i74 < i69) {
                                int i75 = i57;
                                int i76 = i58;
                                if (this.u == 1) {
                                    i6 = this.a[this.l[i72] & 255];
                                    i3 = i59;
                                    i4 = i60;
                                    i5 = i62;
                                } else {
                                    int i77 = o0Var.c;
                                    i3 = i59;
                                    int i78 = i72;
                                    int i79 = 0;
                                    int i80 = 0;
                                    int i81 = 0;
                                    int i82 = 0;
                                    int i83 = 0;
                                    while (true) {
                                        if (i78 >= this.u + i72) {
                                            i4 = i60;
                                            break;
                                        }
                                        byte[] bArr3 = this.l;
                                        i4 = i60;
                                        if (i78 >= bArr3.length || i78 >= i73) {
                                            break;
                                        }
                                        int i84 = this.a[bArr3[i78] & 255];
                                        if (i84 != 0) {
                                            i7 = i62;
                                            i82 += (i84 >> 24) & 255;
                                            i81 += (i84 >> 16) & 255;
                                            i80 += (i84 >> 8) & 255;
                                            i79 += i84 & 255;
                                            i83++;
                                        } else {
                                            i7 = i62;
                                        }
                                        i78++;
                                        i60 = i4;
                                        i62 = i7;
                                    }
                                    i5 = i62;
                                    int i85 = i77 + i72;
                                    for (int i86 = i85; i86 < this.u + i85; i86++) {
                                        byte[] bArr4 = this.l;
                                        if (i86 >= bArr4.length || i86 >= i73) {
                                            break;
                                        }
                                        int i87 = this.a[bArr4[i86] & 255];
                                        if (i87 != 0) {
                                            i82 += (i87 >> 24) & 255;
                                            i81 += (i87 >> 16) & 255;
                                            i80 += (i87 >> 8) & 255;
                                            i79 += i87 & 255;
                                            i83++;
                                        }
                                    }
                                    i6 = i83 == 0 ? 0 : ((i82 / i83) << 24) | ((i81 / i83) << 16) | ((i80 / i83) << 8) | (i79 / i83);
                                }
                                if (i6 != 0) {
                                    iArr3[i74] = i6;
                                } else if (!this.x && z) {
                                    this.x = true;
                                }
                                i72 += this.u;
                                i74++;
                                i57 = i75;
                                i58 = i76;
                                i59 = i3;
                                i60 = i4;
                                i62 = i5;
                            }
                        }
                        i63++;
                        i61 = i2;
                        i57 = i57;
                        i58 = i58;
                        i59 = i59;
                        i60 = i60;
                        i62 = i62;
                    }
                    if (this.s && ((i = o0Var.g) == 0 || i == 1)) {
                        if (this.r == null) {
                            this.r = a();
                        }
                        Bitmap bitmap2 = this.r;
                        int i88 = this.w;
                        bitmap2.setPixels(iArr3, 0, i88, 0, 0, i88, this.v);
                    }
                    Bitmap a = a();
                    int i89 = this.w;
                    a.setPixels(iArr3, 0, i89, 0, 0, i89, this.v);
                    return a;
                }
                return null;
            }
        }
        return (Bitmap) invokeV.objValue;
    }

    public final int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            try {
                d();
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

    public final void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.f > this.g) {
            return;
        }
        if (this.e == null) {
            this.e = this.q.a(16384);
        }
        this.g = 0;
        int min = Math.min(this.c.remaining(), 16384);
        this.f = min;
        this.c.get(this.e, 0, min);
    }

    public synchronized int a(byte[] bArr) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bArr)) == null) {
            synchronized (this) {
                if (this.h == null) {
                    this.h = new q0();
                }
                q0 a = this.h.a(bArr);
                if (a.b != null) {
                    if (!a.a()) {
                        String str = "";
                        for (int i2 = 0; i2 < 6; i2++) {
                            str = str + ((char) a.b());
                        }
                        if (str.startsWith("GIF")) {
                            a.c.f = a.b.getShort();
                            a.c.g = a.b.getShort();
                            int b = a.b();
                            a.c.h = (b & 128) != 0;
                            p0 p0Var = a.c;
                            p0Var.i = 2 << (b & 7);
                            p0Var.j = a.b();
                            a.c.k = a.b();
                            if (a.c.h && !a.a()) {
                                p0 p0Var2 = a.c;
                                p0Var2.a = a.a(p0Var2.i);
                                p0 p0Var3 = a.c;
                                p0Var3.l = p0Var3.a[p0Var3.j];
                            }
                        } else {
                            a.c.b = 1;
                        }
                        if (!a.a()) {
                            boolean z = false;
                            while (!z && !a.a() && a.c.c <= Integer.MAX_VALUE) {
                                int b2 = a.b();
                                if (b2 == 33) {
                                    int b3 = a.b();
                                    if (b3 != 1) {
                                        if (b3 == 249) {
                                            a.c.d = new o0();
                                            a.b();
                                            int b4 = a.b();
                                            o0 o0Var = a.c.d;
                                            int i3 = (b4 & 28) >> 2;
                                            o0Var.g = i3;
                                            if (i3 == 0) {
                                                o0Var.g = 1;
                                            }
                                            a.c.d.f = (b4 & 1) != 0;
                                            short s = a.b.getShort();
                                            if (s < 2) {
                                                s = 10;
                                            }
                                            o0 o0Var2 = a.c.d;
                                            o0Var2.i = s * 10;
                                            o0Var2.h = a.b();
                                            a.b();
                                        } else if (b3 != 254 && b3 == 255) {
                                            a.c();
                                            String str2 = "";
                                            for (int i4 = 0; i4 < 11; i4++) {
                                                str2 = str2 + ((char) a.a[i4]);
                                            }
                                            if (str2.equals("NETSCAPE2.0")) {
                                                do {
                                                    a.c();
                                                    byte[] bArr2 = a.a;
                                                    if (bArr2[0] == 1) {
                                                        p0 p0Var4 = a.c;
                                                        int i5 = ((bArr2[2] & 255) << 8) | (bArr2[1] & 255);
                                                        p0Var4.m = i5;
                                                        if (i5 == 0) {
                                                            p0Var4.m = -1;
                                                        }
                                                    }
                                                    if (a.d > 0) {
                                                    }
                                                } while (!a.a());
                                            }
                                        }
                                    }
                                    a.d();
                                } else if (b2 == 44) {
                                    p0 p0Var5 = a.c;
                                    if (p0Var5.d == null) {
                                        p0Var5.d = new o0();
                                    }
                                    a.c.d.a = a.b.getShort();
                                    a.c.d.b = a.b.getShort();
                                    a.c.d.c = a.b.getShort();
                                    a.c.d.d = a.b.getShort();
                                    int b5 = a.b();
                                    boolean z2 = (b5 & 128) != 0;
                                    int pow = (int) Math.pow(2.0d, (b5 & 7) + 1);
                                    a.c.d.e = (b5 & 64) != 0;
                                    if (z2) {
                                        a.c.d.k = a.a(pow);
                                    } else {
                                        a.c.d.k = null;
                                    }
                                    a.c.d.j = a.b.position();
                                    a.b();
                                    a.d();
                                    if (!a.a()) {
                                        p0 p0Var6 = a.c;
                                        p0Var6.c++;
                                        p0Var6.e.add(p0Var6.d);
                                    }
                                } else if (b2 != 59) {
                                    a.c.b = 1;
                                } else {
                                    z = true;
                                }
                            }
                            p0 p0Var7 = a.c;
                            if (p0Var7.c < 0) {
                                p0Var7.b = 1;
                            }
                        }
                    }
                    p0 p0Var8 = a.c;
                    this.p = p0Var8;
                    if (bArr != null) {
                        a(p0Var8, bArr);
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

    public synchronized void a(p0 p0Var, ByteBuffer byteBuffer, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048579, this, p0Var, byteBuffer, i) == null) {
            synchronized (this) {
                if (i <= 0) {
                    throw new IllegalArgumentException("Sample size must be >=0, not: " + i);
                }
                int highestOneBit = Integer.highestOneBit(i);
                this.t = 0;
                this.p = p0Var;
                this.x = false;
                this.n = -1;
                this.o = 0;
                ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
                this.c = asReadOnlyBuffer;
                asReadOnlyBuffer.position(0);
                this.c.order(ByteOrder.LITTLE_ENDIAN);
                this.s = false;
                Iterator it = p0Var.e.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if (((o0) it.next()).g == 3) {
                        this.s = true;
                        break;
                    }
                }
                this.u = highestOneBit;
                int i2 = p0Var.f;
                this.w = i2 / highestOneBit;
                int i3 = p0Var.g;
                this.v = i3 / highestOneBit;
                this.l = this.q.a(i2 * i3);
                this.m = this.q.b(this.w * this.v);
            }
        }
    }

    public boolean a(int i) {
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
}
