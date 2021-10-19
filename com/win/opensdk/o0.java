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
/* loaded from: classes10.dex */
public class o0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int[] f77468a;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f77469b;

    /* renamed from: c  reason: collision with root package name */
    public ByteBuffer f77470c;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f77471d;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f77472e;

    /* renamed from: f  reason: collision with root package name */
    public int f77473f;

    /* renamed from: g  reason: collision with root package name */
    public int f77474g;

    /* renamed from: h  reason: collision with root package name */
    public r0 f77475h;

    /* renamed from: i  reason: collision with root package name */
    public short[] f77476i;

    /* renamed from: j  reason: collision with root package name */
    public byte[] f77477j;
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
        this.f77469b = new int[256];
        this.f77473f = 0;
        this.f77474g = 0;
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
            int i3 = p0Var.f77485d;
            int i4 = this.u;
            int i5 = i3 / i4;
            int i6 = p0Var.f77483b / i4;
            int i7 = p0Var.f77484c / i4;
            int i8 = p0Var.f77482a / i4;
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
                if (this.p.f77497c <= 0 || this.n < 0) {
                    this.t = 1;
                }
                int i14 = this.t;
                if (i14 != 1 && i14 != 2) {
                    int i15 = 0;
                    this.t = 0;
                    p0 p0Var = (p0) this.p.f77499e.get(this.n);
                    int i16 = this.n - 1;
                    p0 p0Var2 = i16 >= 0 ? (p0) this.p.f77499e.get(i16) : null;
                    int[] iArr = p0Var.k;
                    if (iArr == null) {
                        iArr = this.p.f77495a;
                    }
                    this.f77468a = iArr;
                    if (iArr == null) {
                        this.t = 1;
                        return null;
                    }
                    if (p0Var.f77487f) {
                        System.arraycopy(iArr, 0, this.f77469b, 0, iArr.length);
                        int[] iArr2 = this.f77469b;
                        this.f77468a = iArr2;
                        iArr2[p0Var.f77489h] = 0;
                    }
                    int[] iArr3 = this.m;
                    if (p0Var2 == null) {
                        Arrays.fill(iArr3, 0);
                    }
                    if (p0Var2 != null && (i11 = p0Var2.f77488g) > 0) {
                        if (i11 == 2) {
                            if (!p0Var.f77487f) {
                                q0 q0Var = this.p;
                                i12 = q0Var.l;
                                if (p0Var.k != null && q0Var.f77504j == p0Var.f77489h) {
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
                                int i17 = p0Var2.f77485d;
                                int i18 = this.u;
                                int i19 = p0Var2.f77483b / i18;
                                int i20 = p0Var2.f77484c / i18;
                                int i21 = p0Var2.f77482a / i18;
                                int i22 = this.w;
                                bitmap.getPixels(iArr3, (i19 * i22) + i21, i22, i21, i19, i20, i17 / i18);
                            }
                        }
                    }
                    this.f77473f = 0;
                    this.f77474g = 0;
                    this.f77470c.position(p0Var.f77491j);
                    int i23 = p0Var.f77484c * p0Var.f77485d;
                    byte[] bArr = this.l;
                    if (bArr == null || bArr.length < i23) {
                        this.l = this.q.a(i23);
                    }
                    if (this.f77476i == null) {
                        this.f77476i = new short[4096];
                    }
                    if (this.f77477j == null) {
                        this.f77477j = new byte[4096];
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
                        this.f77476i[i29] = 0;
                        this.f77477j[i29] = (byte) i29;
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
                                    if (this.f77471d == null) {
                                        this.f77471d = this.q.a(255);
                                    }
                                    int i42 = this.f77473f - this.f77474g;
                                    if (i42 >= i34) {
                                        System.arraycopy(this.f77472e, this.f77474g, this.f77471d, i15, i34);
                                        i10 = this.f77474g + i34;
                                    } else if (this.f77470c.remaining() + i42 >= i34) {
                                        try {
                                            System.arraycopy(this.f77472e, this.f77474g, this.f77471d, i15, i42);
                                            this.f77474g = this.f77473f;
                                            d();
                                            int i43 = i34 - i42;
                                            System.arraycopy(this.f77472e, i15, this.f77471d, i42, i43);
                                            i10 = this.f77474g + i43;
                                        } catch (Exception unused) {
                                            i13 = 1;
                                            this.t = i13;
                                            if (i34 > 0) {
                                            }
                                        }
                                    } else {
                                        this.t = i13;
                                    }
                                    this.f77474g = i10;
                                } catch (Exception unused2) {
                                }
                            }
                            if (i34 > 0) {
                                this.t = 3;
                                break;
                            }
                            i36 = 0;
                        }
                        i35 += (this.f77471d[i36] & 255) << i37;
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
                                            this.k[i40] = this.f77477j[i50];
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
                                                this.k[i40] = this.f77477j[s];
                                                s = this.f77476i[s];
                                                i40++;
                                                i50 = i50;
                                            }
                                            int i51 = i50;
                                            byte[] bArr2 = this.f77477j;
                                            int i52 = bArr2[s] & 255;
                                            int i53 = i40 + 1;
                                            int i54 = i24;
                                            byte b2 = (byte) i52;
                                            this.k[i40] = b2;
                                            if (i46 < 4096) {
                                                this.f77476i[i46] = (short) i48;
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
                    int i56 = p0Var.f77485d;
                    int i57 = this.u;
                    int i58 = i56 / i57;
                    int i59 = p0Var.f77483b / i57;
                    int i60 = p0Var.f77484c / i57;
                    int i61 = p0Var.f77482a / i57;
                    boolean z = this.n == 0;
                    int i62 = 0;
                    int i63 = 1;
                    int i64 = 0;
                    int i65 = 8;
                    while (i64 < i58) {
                        if (p0Var.f77486e) {
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
                            int i73 = i64 * i72 * p0Var.f77484c;
                            int i74 = ((i70 - i69) * i72) + i73;
                            int i75 = i69;
                            while (i75 < i70) {
                                int i76 = i58;
                                int i77 = i59;
                                if (this.u == 1) {
                                    i7 = this.f77468a[this.l[i73] & 255];
                                    i4 = i60;
                                    i5 = i61;
                                    i6 = i63;
                                } else {
                                    int i78 = p0Var.f77484c;
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
                                        int i85 = this.f77468a[bArr3[i79] & 255];
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
                                        int i88 = this.f77468a[bArr4[i87] & 255];
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
                    if (this.s && ((i2 = p0Var.f77488g) == 0 || i2 == 1)) {
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
                byte[] bArr = this.f77472e;
                int i2 = this.f77474g;
                this.f77474g = i2 + 1;
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
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.f77473f > this.f77474g) {
            return;
        }
        if (this.f77472e == null) {
            this.f77472e = this.q.a(16384);
        }
        this.f77474g = 0;
        int min = Math.min(this.f77470c.remaining(), 16384);
        this.f77473f = min;
        this.f77470c.get(this.f77472e, 0, min);
    }

    public synchronized int a(byte[] bArr) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bArr)) == null) {
            synchronized (this) {
                if (this.f77475h == null) {
                    this.f77475h = new r0();
                }
                r0 a2 = this.f77475h.a(bArr);
                if (a2.f77507b != null) {
                    if (!a2.a()) {
                        String str = "";
                        for (int i3 = 0; i3 < 6; i3++) {
                            str = str + ((char) a2.b());
                        }
                        if (str.startsWith("GIF")) {
                            a2.f77508c.f77500f = a2.f77507b.getShort();
                            a2.f77508c.f77501g = a2.f77507b.getShort();
                            int b2 = a2.b();
                            a2.f77508c.f77502h = (b2 & 128) != 0;
                            q0 q0Var = a2.f77508c;
                            q0Var.f77503i = 2 << (b2 & 7);
                            q0Var.f77504j = a2.b();
                            a2.f77508c.k = a2.b();
                            if (a2.f77508c.f77502h && !a2.a()) {
                                q0 q0Var2 = a2.f77508c;
                                q0Var2.f77495a = a2.a(q0Var2.f77503i);
                                q0 q0Var3 = a2.f77508c;
                                q0Var3.l = q0Var3.f77495a[q0Var3.f77504j];
                            }
                        } else {
                            a2.f77508c.f77496b = 1;
                        }
                        if (!a2.a()) {
                            boolean z = false;
                            while (!z && !a2.a() && a2.f77508c.f77497c <= Integer.MAX_VALUE) {
                                int b3 = a2.b();
                                if (b3 == 33) {
                                    int b4 = a2.b();
                                    if (b4 != 1) {
                                        if (b4 == 249) {
                                            a2.f77508c.f77498d = new p0();
                                            a2.b();
                                            int b5 = a2.b();
                                            p0 p0Var = a2.f77508c.f77498d;
                                            int i4 = (b5 & 28) >> 2;
                                            p0Var.f77488g = i4;
                                            if (i4 == 0) {
                                                p0Var.f77488g = 1;
                                            }
                                            a2.f77508c.f77498d.f77487f = (b5 & 1) != 0;
                                            short s = a2.f77507b.getShort();
                                            if (s < 2) {
                                                s = 10;
                                            }
                                            p0 p0Var2 = a2.f77508c.f77498d;
                                            p0Var2.f77490i = s * 10;
                                            p0Var2.f77489h = a2.b();
                                            a2.b();
                                        } else if (b4 != 254 && b4 == 255) {
                                            a2.c();
                                            String str2 = "";
                                            for (int i5 = 0; i5 < 11; i5++) {
                                                str2 = str2 + ((char) a2.f77506a[i5]);
                                            }
                                            if (str2.equals("NETSCAPE2.0")) {
                                                do {
                                                    a2.c();
                                                    byte[] bArr2 = a2.f77506a;
                                                    if (bArr2[0] == 1) {
                                                        q0 q0Var4 = a2.f77508c;
                                                        int i6 = ((bArr2[2] & 255) << 8) | (bArr2[1] & 255);
                                                        q0Var4.m = i6;
                                                        if (i6 == 0) {
                                                            q0Var4.m = -1;
                                                        }
                                                    }
                                                    if (a2.f77509d > 0) {
                                                    }
                                                } while (!a2.a());
                                            }
                                        }
                                    }
                                    a2.d();
                                } else if (b3 == 44) {
                                    q0 q0Var5 = a2.f77508c;
                                    if (q0Var5.f77498d == null) {
                                        q0Var5.f77498d = new p0();
                                    }
                                    a2.f77508c.f77498d.f77482a = a2.f77507b.getShort();
                                    a2.f77508c.f77498d.f77483b = a2.f77507b.getShort();
                                    a2.f77508c.f77498d.f77484c = a2.f77507b.getShort();
                                    a2.f77508c.f77498d.f77485d = a2.f77507b.getShort();
                                    int b6 = a2.b();
                                    boolean z2 = (b6 & 128) != 0;
                                    int pow = (int) Math.pow(2.0d, (b6 & 7) + 1);
                                    a2.f77508c.f77498d.f77486e = (b6 & 64) != 0;
                                    if (z2) {
                                        a2.f77508c.f77498d.k = a2.a(pow);
                                    } else {
                                        a2.f77508c.f77498d.k = null;
                                    }
                                    a2.f77508c.f77498d.f77491j = a2.f77507b.position();
                                    a2.b();
                                    a2.d();
                                    if (!a2.a()) {
                                        q0 q0Var6 = a2.f77508c;
                                        q0Var6.f77497c++;
                                        q0Var6.f77499e.add(q0Var6.f77498d);
                                    }
                                } else if (b3 != 59) {
                                    a2.f77508c.f77496b = 1;
                                } else {
                                    z = true;
                                }
                            }
                            q0 q0Var7 = a2.f77508c;
                            if (q0Var7.f77497c < 0) {
                                q0Var7.f77496b = 1;
                            }
                        }
                    }
                    q0 q0Var8 = a2.f77508c;
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
                this.f77470c = asReadOnlyBuffer;
                asReadOnlyBuffer.position(0);
                this.f77470c.order(ByteOrder.LITTLE_ENDIAN);
                this.s = false;
                Iterator it = q0Var.f77499e.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if (((p0) it.next()).f77488g == 3) {
                        this.s = true;
                        break;
                    }
                }
                this.u = highestOneBit;
                int i3 = q0Var.f77500f;
                this.w = i3 / highestOneBit;
                int i4 = q0Var.f77501g;
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
            if (i2 < -1 || i2 >= this.p.f77497c) {
                return false;
            }
            this.n = i2;
            return true;
        }
        return invokeI.booleanValue;
    }
}
