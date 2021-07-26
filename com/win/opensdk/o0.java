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
/* loaded from: classes6.dex */
public class o0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int[] f39888a;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f39889b;

    /* renamed from: c  reason: collision with root package name */
    public ByteBuffer f39890c;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f39891d;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f39892e;

    /* renamed from: f  reason: collision with root package name */
    public int f39893f;

    /* renamed from: g  reason: collision with root package name */
    public int f39894g;

    /* renamed from: h  reason: collision with root package name */
    public r0 f39895h;

    /* renamed from: i  reason: collision with root package name */
    public short[] f39896i;
    public byte[] j;
    public byte[] k;
    public byte[] l;
    public int[] m;
    public int n;
    public int o;
    public q0 p;
    public x0 q;
    public Bitmap r;
    public boolean s;
    public int t;
    public int u;
    public int v;
    public int w;
    public boolean x;

    public o0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        x0 x0Var = new x0();
        this.f39889b = new int[256];
        this.f39893f = 0;
        this.f39894g = 0;
        this.q = x0Var;
        this.p = new q0();
    }

    public final Bitmap a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Bitmap a2 = this.q.a(this.w, this.v, this.x ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
            if (Build.VERSION.SDK_INT >= 12) {
                a2.setHasAlpha(true);
            }
            return a2;
        }
        return (Bitmap) invokeV.objValue;
    }

    public synchronized void a(q0 q0Var, ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, q0Var, byteBuffer) == null) {
            synchronized (this) {
                a(q0Var, byteBuffer, 1);
            }
        }
    }

    public synchronized void a(q0 q0Var, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, q0Var, bArr) == null) {
            synchronized (this) {
                a(q0Var, ByteBuffer.wrap(bArr));
            }
        }
    }

    public final void a(int[] iArr, p0 p0Var, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048581, this, iArr, p0Var, i2) == null) {
            int i3 = p0Var.f39904d;
            int i4 = this.u;
            int i5 = i3 / i4;
            int i6 = p0Var.f39902b / i4;
            int i7 = p0Var.f39903c / i4;
            int i8 = p0Var.f39901a / i4;
            int i9 = this.w;
            int i10 = (i6 * i9) + i8;
            int i11 = (i5 * i9) + i10;
            while (i10 < i11) {
                int i12 = i10 + i7;
                for (int i13 = i10; i13 < i12; i13++) {
                    iArr[i13] = i2;
                }
                i10 += this.w;
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
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        short s;
        int i10;
        int i11;
        int i12;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            synchronized (this) {
                int i13 = 1;
                if (this.p.f39915c <= 0 || this.n < 0) {
                    this.t = 1;
                }
                int i14 = this.t;
                if (i14 != 1 && i14 != 2) {
                    int i15 = 0;
                    this.t = 0;
                    p0 p0Var = (p0) this.p.f39917e.get(this.n);
                    int i16 = this.n - 1;
                    p0 p0Var2 = i16 >= 0 ? (p0) this.p.f39917e.get(i16) : null;
                    int[] iArr = p0Var.k;
                    if (iArr == null) {
                        iArr = this.p.f39913a;
                    }
                    this.f39888a = iArr;
                    if (iArr == null) {
                        this.t = 1;
                        return null;
                    }
                    if (p0Var.f39906f) {
                        System.arraycopy(iArr, 0, this.f39889b, 0, iArr.length);
                        int[] iArr2 = this.f39889b;
                        this.f39888a = iArr2;
                        iArr2[p0Var.f39908h] = 0;
                    }
                    int[] iArr3 = this.m;
                    if (p0Var2 == null) {
                        Arrays.fill(iArr3, 0);
                    }
                    if (p0Var2 != null && (i11 = p0Var2.f39907g) > 0) {
                        if (i11 == 2) {
                            if (!p0Var.f39906f) {
                                q0 q0Var = this.p;
                                i12 = q0Var.l;
                                if (p0Var.k != null && q0Var.j == p0Var.f39908h) {
                                }
                                a(iArr3, p0Var2, i12);
                            } else if (this.n == 0) {
                                this.x = true;
                            }
                            i12 = 0;
                            a(iArr3, p0Var2, i12);
                        } else if (i11 == 3) {
                            Bitmap bitmap = this.r;
                            if (bitmap == null) {
                                a(iArr3, p0Var2, 0);
                            } else {
                                int i17 = p0Var2.f39904d;
                                int i18 = this.u;
                                int i19 = p0Var2.f39902b / i18;
                                int i20 = p0Var2.f39903c / i18;
                                int i21 = p0Var2.f39901a / i18;
                                int i22 = this.w;
                                bitmap.getPixels(iArr3, (i19 * i22) + i21, i22, i21, i19, i20, i17 / i18);
                            }
                        }
                    }
                    this.f39893f = 0;
                    this.f39894g = 0;
                    this.f39890c.position(p0Var.j);
                    int i23 = p0Var.f39903c * p0Var.f39904d;
                    byte[] bArr = this.l;
                    if (bArr == null || bArr.length < i23) {
                        this.l = this.q.a(i23);
                    }
                    if (this.f39896i == null) {
                        this.f39896i = new short[4096];
                    }
                    if (this.j == null) {
                        this.j = new byte[4096];
                    }
                    if (this.k == null) {
                        this.k = new byte[4097];
                    }
                    int c2 = c();
                    int i24 = 1 << c2;
                    int i25 = i24 + 1;
                    int i26 = i24 + 2;
                    int i27 = c2 + 1;
                    int i28 = (1 << i27) - 1;
                    for (int i29 = 0; i29 < i24; i29++) {
                        this.f39896i[i29] = 0;
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
                        if (i33 >= i23) {
                            break;
                        }
                        if (i34 == 0) {
                            i34 = c();
                            if (i34 > 0) {
                                try {
                                    if (this.f39891d == null) {
                                        this.f39891d = this.q.a(255);
                                    }
                                    int i42 = this.f39893f - this.f39894g;
                                    if (i42 >= i34) {
                                        System.arraycopy(this.f39892e, this.f39894g, this.f39891d, i15, i34);
                                        i10 = this.f39894g + i34;
                                    } else if (this.f39890c.remaining() + i42 >= i34) {
                                        try {
                                            System.arraycopy(this.f39892e, this.f39894g, this.f39891d, i15, i42);
                                            this.f39894g = this.f39893f;
                                            d();
                                            int i43 = i34 - i42;
                                            System.arraycopy(this.f39892e, i15, this.f39891d, i42, i43);
                                            i10 = this.f39894g + i43;
                                        } catch (Exception unused) {
                                            i13 = 1;
                                            this.t = i13;
                                            if (i34 > 0) {
                                            }
                                        }
                                    } else {
                                        this.t = i13;
                                    }
                                    this.f39894g = i10;
                                } catch (Exception unused2) {
                                }
                            }
                            if (i34 > 0) {
                                this.t = 3;
                                break;
                            }
                            i36 = 0;
                        }
                        i35 += (this.f39891d[i36] & 255) << i37;
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
                                    i9 = i44;
                                    this.t = 3;
                                } else {
                                    i9 = i44;
                                    if (i50 != i25) {
                                        if (i48 == -1) {
                                            this.k[i40] = this.j[i50];
                                            i40++;
                                            i48 = i50;
                                            i45 = i48;
                                            i27 = i49;
                                            i44 = i9;
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
                                                s = this.f39896i[s];
                                                i40++;
                                                i50 = i50;
                                            }
                                            int i51 = i50;
                                            byte[] bArr2 = this.j;
                                            int i52 = bArr2[s] & 255;
                                            int i53 = i40 + 1;
                                            int i54 = i24;
                                            byte b2 = (byte) i52;
                                            this.k[i40] = b2;
                                            if (i46 < 4096) {
                                                this.f39896i[i46] = (short) i48;
                                                bArr2[i46] = b2;
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
                                            i44 = i9;
                                            i48 = i51;
                                            i24 = i54;
                                        }
                                    }
                                }
                                i41 = i48;
                                i30 = i47;
                                i27 = i49;
                                i37 = i9;
                                i15 = 0;
                                i13 = 1;
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
                        i15 = 0;
                        i13 = 1;
                    }
                    for (int i55 = i38; i55 < i23; i55++) {
                        this.l[i55] = 0;
                    }
                    int i56 = p0Var.f39904d;
                    int i57 = this.u;
                    int i58 = i56 / i57;
                    int i59 = p0Var.f39902b / i57;
                    int i60 = p0Var.f39903c / i57;
                    int i61 = p0Var.f39901a / i57;
                    boolean z = this.n == 0;
                    int i62 = 0;
                    int i63 = 1;
                    int i64 = 0;
                    int i65 = 8;
                    while (i64 < i58) {
                        if (p0Var.f39905e) {
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
                            i3 = i62 + i65;
                        } else {
                            i3 = i62;
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
                            int i73 = i64 * i72 * p0Var.f39903c;
                            int i74 = ((i70 - i69) * i72) + i73;
                            int i75 = i69;
                            while (i75 < i70) {
                                int i76 = i58;
                                int i77 = i59;
                                if (this.u == 1) {
                                    i7 = this.f39888a[this.l[i73] & 255];
                                    i4 = i60;
                                    i5 = i61;
                                    i6 = i63;
                                } else {
                                    int i78 = p0Var.f39903c;
                                    i4 = i60;
                                    int i79 = i73;
                                    int i80 = 0;
                                    int i81 = 0;
                                    int i82 = 0;
                                    int i83 = 0;
                                    int i84 = 0;
                                    while (true) {
                                        if (i79 >= this.u + i73) {
                                            i5 = i61;
                                            break;
                                        }
                                        byte[] bArr3 = this.l;
                                        i5 = i61;
                                        if (i79 >= bArr3.length || i79 >= i74) {
                                            break;
                                        }
                                        int i85 = this.f39888a[bArr3[i79] & 255];
                                        if (i85 != 0) {
                                            i8 = i63;
                                            i83 += (i85 >> 24) & 255;
                                            i82 += (i85 >> 16) & 255;
                                            i81 += (i85 >> 8) & 255;
                                            i80 += i85 & 255;
                                            i84++;
                                        } else {
                                            i8 = i63;
                                        }
                                        i79++;
                                        i61 = i5;
                                        i63 = i8;
                                    }
                                    i6 = i63;
                                    int i86 = i78 + i73;
                                    for (int i87 = i86; i87 < this.u + i86; i87++) {
                                        byte[] bArr4 = this.l;
                                        if (i87 >= bArr4.length || i87 >= i74) {
                                            break;
                                        }
                                        int i88 = this.f39888a[bArr4[i87] & 255];
                                        if (i88 != 0) {
                                            i83 += (i88 >> 24) & 255;
                                            i82 += (i88 >> 16) & 255;
                                            i81 += (i88 >> 8) & 255;
                                            i80 += i88 & 255;
                                            i84++;
                                        }
                                    }
                                    i7 = i84 == 0 ? 0 : ((i83 / i84) << 24) | ((i82 / i84) << 16) | ((i81 / i84) << 8) | (i80 / i84);
                                }
                                if (i7 != 0) {
                                    iArr3[i75] = i7;
                                } else if (!this.x && z) {
                                    this.x = true;
                                }
                                i73 += this.u;
                                i75++;
                                i58 = i76;
                                i59 = i77;
                                i60 = i4;
                                i61 = i5;
                                i63 = i6;
                            }
                        }
                        i64++;
                        i62 = i3;
                        i58 = i58;
                        i59 = i59;
                        i60 = i60;
                        i61 = i61;
                        i63 = i63;
                    }
                    if (this.s && ((i2 = p0Var.f39907g) == 0 || i2 == 1)) {
                        if (this.r == null) {
                            this.r = a();
                        }
                        Bitmap bitmap2 = this.r;
                        int i89 = this.w;
                        bitmap2.setPixels(iArr3, 0, i89, 0, 0, i89, this.v);
                    }
                    Bitmap a2 = a();
                    int i90 = this.w;
                    a2.setPixels(iArr3, 0, i90, 0, 0, i90, this.v);
                    return a2;
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
                byte[] bArr = this.f39892e;
                int i2 = this.f39894g;
                this.f39894g = i2 + 1;
                return bArr[i2] & 255;
            } catch (Exception unused) {
                this.t = 1;
                return 0;
            }
        }
        return invokeV.intValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.f39893f > this.f39894g) {
            return;
        }
        if (this.f39892e == null) {
            this.f39892e = this.q.a(16384);
        }
        this.f39894g = 0;
        int min = Math.min(this.f39890c.remaining(), 16384);
        this.f39893f = min;
        this.f39890c.get(this.f39892e, 0, min);
    }

    public synchronized int a(byte[] bArr) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bArr)) == null) {
            synchronized (this) {
                if (this.f39895h == null) {
                    this.f39895h = new r0();
                }
                r0 a2 = this.f39895h.a(bArr);
                if (a2.f39924b != null) {
                    if (!a2.a()) {
                        String str = "";
                        for (int i3 = 0; i3 < 6; i3++) {
                            str = str + ((char) a2.b());
                        }
                        if (str.startsWith("GIF")) {
                            a2.f39925c.f39918f = a2.f39924b.getShort();
                            a2.f39925c.f39919g = a2.f39924b.getShort();
                            int b2 = a2.b();
                            a2.f39925c.f39920h = (b2 & 128) != 0;
                            q0 q0Var = a2.f39925c;
                            q0Var.f39921i = 2 << (b2 & 7);
                            q0Var.j = a2.b();
                            a2.f39925c.k = a2.b();
                            if (a2.f39925c.f39920h && !a2.a()) {
                                q0 q0Var2 = a2.f39925c;
                                q0Var2.f39913a = a2.a(q0Var2.f39921i);
                                q0 q0Var3 = a2.f39925c;
                                q0Var3.l = q0Var3.f39913a[q0Var3.j];
                            }
                        } else {
                            a2.f39925c.f39914b = 1;
                        }
                        if (!a2.a()) {
                            boolean z = false;
                            while (!z && !a2.a() && a2.f39925c.f39915c <= Integer.MAX_VALUE) {
                                int b3 = a2.b();
                                if (b3 == 33) {
                                    int b4 = a2.b();
                                    if (b4 != 1) {
                                        if (b4 == 249) {
                                            a2.f39925c.f39916d = new p0();
                                            a2.b();
                                            int b5 = a2.b();
                                            p0 p0Var = a2.f39925c.f39916d;
                                            int i4 = (b5 & 28) >> 2;
                                            p0Var.f39907g = i4;
                                            if (i4 == 0) {
                                                p0Var.f39907g = 1;
                                            }
                                            a2.f39925c.f39916d.f39906f = (b5 & 1) != 0;
                                            short s = a2.f39924b.getShort();
                                            if (s < 2) {
                                                s = 10;
                                            }
                                            p0 p0Var2 = a2.f39925c.f39916d;
                                            p0Var2.f39909i = s * 10;
                                            p0Var2.f39908h = a2.b();
                                            a2.b();
                                        } else if (b4 != 254 && b4 == 255) {
                                            a2.c();
                                            String str2 = "";
                                            for (int i5 = 0; i5 < 11; i5++) {
                                                str2 = str2 + ((char) a2.f39923a[i5]);
                                            }
                                            if (str2.equals("NETSCAPE2.0")) {
                                                do {
                                                    a2.c();
                                                    byte[] bArr2 = a2.f39923a;
                                                    if (bArr2[0] == 1) {
                                                        q0 q0Var4 = a2.f39925c;
                                                        int i6 = ((bArr2[2] & 255) << 8) | (bArr2[1] & 255);
                                                        q0Var4.m = i6;
                                                        if (i6 == 0) {
                                                            q0Var4.m = -1;
                                                        }
                                                    }
                                                    if (a2.f39926d > 0) {
                                                    }
                                                } while (!a2.a());
                                            }
                                        }
                                    }
                                    a2.d();
                                } else if (b3 == 44) {
                                    q0 q0Var5 = a2.f39925c;
                                    if (q0Var5.f39916d == null) {
                                        q0Var5.f39916d = new p0();
                                    }
                                    a2.f39925c.f39916d.f39901a = a2.f39924b.getShort();
                                    a2.f39925c.f39916d.f39902b = a2.f39924b.getShort();
                                    a2.f39925c.f39916d.f39903c = a2.f39924b.getShort();
                                    a2.f39925c.f39916d.f39904d = a2.f39924b.getShort();
                                    int b6 = a2.b();
                                    boolean z2 = (b6 & 128) != 0;
                                    int pow = (int) Math.pow(2.0d, (b6 & 7) + 1);
                                    a2.f39925c.f39916d.f39905e = (b6 & 64) != 0;
                                    if (z2) {
                                        a2.f39925c.f39916d.k = a2.a(pow);
                                    } else {
                                        a2.f39925c.f39916d.k = null;
                                    }
                                    a2.f39925c.f39916d.j = a2.f39924b.position();
                                    a2.b();
                                    a2.d();
                                    if (!a2.a()) {
                                        q0 q0Var6 = a2.f39925c;
                                        q0Var6.f39915c++;
                                        q0Var6.f39917e.add(q0Var6.f39916d);
                                    }
                                } else if (b3 != 59) {
                                    a2.f39925c.f39914b = 1;
                                } else {
                                    z = true;
                                }
                            }
                            q0 q0Var7 = a2.f39925c;
                            if (q0Var7.f39915c < 0) {
                                q0Var7.f39914b = 1;
                            }
                        }
                    }
                    q0 q0Var8 = a2.f39925c;
                    this.p = q0Var8;
                    if (bArr != null) {
                        a(q0Var8, bArr);
                    }
                    i2 = this.t;
                } else {
                    throw new IllegalStateException("You must call setData() before parseHeader()");
                }
            }
            return i2;
        }
        return invokeL.intValue;
    }

    public synchronized void a(q0 q0Var, ByteBuffer byteBuffer, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048579, this, q0Var, byteBuffer, i2) == null) {
            synchronized (this) {
                if (i2 <= 0) {
                    throw new IllegalArgumentException("Sample size must be >=0, not: " + i2);
                }
                int highestOneBit = Integer.highestOneBit(i2);
                this.t = 0;
                this.p = q0Var;
                this.x = false;
                this.n = -1;
                this.o = 0;
                ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
                this.f39890c = asReadOnlyBuffer;
                asReadOnlyBuffer.position(0);
                this.f39890c.order(ByteOrder.LITTLE_ENDIAN);
                this.s = false;
                Iterator it = q0Var.f39917e.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if (((p0) it.next()).f39907g == 3) {
                        this.s = true;
                        break;
                    }
                }
                this.u = highestOneBit;
                int i3 = q0Var.f39918f;
                this.w = i3 / highestOneBit;
                int i4 = q0Var.f39919g;
                this.v = i4 / highestOneBit;
                this.l = this.q.a(i3 * i4);
                this.m = this.q.b(this.w * this.v);
            }
        }
    }

    public boolean a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            if (i2 < -1 || i2 >= this.p.f39915c) {
                return false;
            }
            this.n = i2;
            return true;
        }
        return invokeI.booleanValue;
    }
}
