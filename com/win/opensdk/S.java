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
/* loaded from: classes7.dex */
public class S {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int[] f42457a;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f42458b;

    /* renamed from: c  reason: collision with root package name */
    public ByteBuffer f42459c;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f42460d;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f42461e;

    /* renamed from: f  reason: collision with root package name */
    public int f42462f;

    /* renamed from: g  reason: collision with root package name */
    public int f42463g;

    /* renamed from: h  reason: collision with root package name */
    public V f42464h;

    /* renamed from: i  reason: collision with root package name */
    public short[] f42465i;
    public byte[] j;
    public byte[] k;
    public byte[] l;
    public int[] m;
    public int n;
    public int o;
    public U p;
    public b0 q;
    public Bitmap r;
    public boolean s;
    public int t;
    public int u;
    public int v;
    public int w;
    public boolean x;

    public S() {
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
        b0 b0Var = new b0();
        this.f42458b = new int[256];
        this.f42462f = 0;
        this.f42463g = 0;
        this.q = b0Var;
        this.p = new U();
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

    public synchronized void a(U u, ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, u, byteBuffer) == null) {
            synchronized (this) {
                a(u, byteBuffer, 1);
            }
        }
    }

    public synchronized void a(U u, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, u, bArr) == null) {
            synchronized (this) {
                a(u, ByteBuffer.wrap(bArr));
            }
        }
    }

    public final void a(int[] iArr, T t, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048581, this, iArr, t, i2) == null) {
            int i3 = t.f42471d;
            int i4 = this.u;
            int i5 = i3 / i4;
            int i6 = t.f42469b / i4;
            int i7 = t.f42470c / i4;
            int i8 = t.f42468a / i4;
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
                if (this.p.f42480c <= 0 || this.n < 0) {
                    this.t = 1;
                }
                int i14 = this.t;
                if (i14 != 1 && i14 != 2) {
                    int i15 = 0;
                    this.t = 0;
                    T t = (T) this.p.f42482e.get(this.n);
                    int i16 = this.n - 1;
                    T t2 = i16 >= 0 ? (T) this.p.f42482e.get(i16) : null;
                    int[] iArr = t.k;
                    if (iArr == null) {
                        iArr = this.p.f42478a;
                    }
                    this.f42457a = iArr;
                    if (iArr == null) {
                        this.t = 1;
                        return null;
                    }
                    if (t.f42473f) {
                        System.arraycopy(iArr, 0, this.f42458b, 0, iArr.length);
                        int[] iArr2 = this.f42458b;
                        this.f42457a = iArr2;
                        iArr2[t.f42475h] = 0;
                    }
                    int[] iArr3 = this.m;
                    if (t2 == null) {
                        Arrays.fill(iArr3, 0);
                    }
                    if (t2 != null && (i11 = t2.f42474g) > 0) {
                        if (i11 == 2) {
                            if (!t.f42473f) {
                                U u = this.p;
                                i12 = u.l;
                                if (t.k != null && u.j == t.f42475h) {
                                }
                                a(iArr3, t2, i12);
                            } else if (this.n == 0) {
                                this.x = true;
                            }
                            i12 = 0;
                            a(iArr3, t2, i12);
                        } else if (i11 == 3) {
                            Bitmap bitmap = this.r;
                            if (bitmap == null) {
                                a(iArr3, t2, 0);
                            } else {
                                int i17 = t2.f42471d;
                                int i18 = this.u;
                                int i19 = t2.f42469b / i18;
                                int i20 = t2.f42470c / i18;
                                int i21 = t2.f42468a / i18;
                                int i22 = this.w;
                                bitmap.getPixels(iArr3, (i19 * i22) + i21, i22, i21, i19, i20, i17 / i18);
                            }
                        }
                    }
                    this.f42462f = 0;
                    this.f42463g = 0;
                    this.f42459c.position(t.j);
                    int i23 = t.f42470c * t.f42471d;
                    byte[] bArr = this.l;
                    if (bArr == null || bArr.length < i23) {
                        this.l = this.q.a(i23);
                    }
                    if (this.f42465i == null) {
                        this.f42465i = new short[4096];
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
                        this.f42465i[i29] = 0;
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
                                    if (this.f42460d == null) {
                                        this.f42460d = this.q.a(255);
                                    }
                                    int i42 = this.f42462f - this.f42463g;
                                    if (i42 >= i34) {
                                        System.arraycopy(this.f42461e, this.f42463g, this.f42460d, i15, i34);
                                        i10 = this.f42463g + i34;
                                    } else if (this.f42459c.remaining() + i42 >= i34) {
                                        try {
                                            System.arraycopy(this.f42461e, this.f42463g, this.f42460d, i15, i42);
                                            this.f42463g = this.f42462f;
                                            d();
                                            int i43 = i34 - i42;
                                            System.arraycopy(this.f42461e, i15, this.f42460d, i42, i43);
                                            i10 = this.f42463g + i43;
                                        } catch (Exception unused) {
                                            i13 = 1;
                                            this.t = i13;
                                            if (i34 > 0) {
                                            }
                                        }
                                    } else {
                                        this.t = i13;
                                    }
                                    this.f42463g = i10;
                                } catch (Exception unused2) {
                                }
                            }
                            if (i34 > 0) {
                                this.t = 3;
                                break;
                            }
                            i36 = 0;
                        }
                        i35 += (this.f42460d[i36] & 255) << i37;
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
                                                s = this.f42465i[s];
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
                                                this.f42465i[i46] = (short) i48;
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
                    int i56 = t.f42471d;
                    int i57 = this.u;
                    int i58 = i56 / i57;
                    int i59 = t.f42469b / i57;
                    int i60 = t.f42470c / i57;
                    int i61 = t.f42468a / i57;
                    boolean z = this.n == 0;
                    int i62 = 0;
                    int i63 = 1;
                    int i64 = 0;
                    int i65 = 8;
                    while (i64 < i58) {
                        if (t.f42472e) {
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
                            int i73 = i64 * i72 * t.f42470c;
                            int i74 = ((i70 - i69) * i72) + i73;
                            int i75 = i69;
                            while (i75 < i70) {
                                int i76 = i58;
                                int i77 = i59;
                                if (this.u == 1) {
                                    i7 = this.f42457a[this.l[i73] & 255];
                                    i4 = i60;
                                    i5 = i61;
                                    i6 = i63;
                                } else {
                                    int i78 = t.f42470c;
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
                                        int i85 = this.f42457a[bArr3[i79] & 255];
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
                                        int i88 = this.f42457a[bArr4[i87] & 255];
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
                    if (this.s && ((i2 = t.f42474g) == 0 || i2 == 1)) {
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
                byte[] bArr = this.f42461e;
                int i2 = this.f42463g;
                this.f42463g = i2 + 1;
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
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.f42462f > this.f42463g) {
            return;
        }
        if (this.f42461e == null) {
            this.f42461e = this.q.a(16384);
        }
        this.f42463g = 0;
        int min = Math.min(this.f42459c.remaining(), 16384);
        this.f42462f = min;
        this.f42459c.get(this.f42461e, 0, min);
    }

    public synchronized int a(byte[] bArr) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bArr)) == null) {
            synchronized (this) {
                if (this.f42464h == null) {
                    this.f42464h = new V();
                }
                V a2 = this.f42464h.a(bArr);
                if (a2.f42490b != null) {
                    if (!a2.a()) {
                        String str = "";
                        for (int i3 = 0; i3 < 6; i3++) {
                            str = str + ((char) a2.b());
                        }
                        if (str.startsWith("GIF")) {
                            a2.f42491c.f42483f = a2.f42490b.getShort();
                            a2.f42491c.f42484g = a2.f42490b.getShort();
                            int b2 = a2.b();
                            a2.f42491c.f42485h = (b2 & 128) != 0;
                            U u = a2.f42491c;
                            u.f42486i = 2 << (b2 & 7);
                            u.j = a2.b();
                            a2.f42491c.k = a2.b();
                            if (a2.f42491c.f42485h && !a2.a()) {
                                U u2 = a2.f42491c;
                                u2.f42478a = a2.a(u2.f42486i);
                                U u3 = a2.f42491c;
                                u3.l = u3.f42478a[u3.j];
                            }
                        } else {
                            a2.f42491c.f42479b = 1;
                        }
                        if (!a2.a()) {
                            boolean z = false;
                            while (!z && !a2.a() && a2.f42491c.f42480c <= Integer.MAX_VALUE) {
                                int b3 = a2.b();
                                if (b3 == 33) {
                                    int b4 = a2.b();
                                    if (b4 != 1) {
                                        if (b4 == 249) {
                                            a2.f42491c.f42481d = new T();
                                            a2.b();
                                            int b5 = a2.b();
                                            T t = a2.f42491c.f42481d;
                                            int i4 = (b5 & 28) >> 2;
                                            t.f42474g = i4;
                                            if (i4 == 0) {
                                                t.f42474g = 1;
                                            }
                                            a2.f42491c.f42481d.f42473f = (b5 & 1) != 0;
                                            short s = a2.f42490b.getShort();
                                            if (s < 2) {
                                                s = 10;
                                            }
                                            T t2 = a2.f42491c.f42481d;
                                            t2.f42476i = s * 10;
                                            t2.f42475h = a2.b();
                                            a2.b();
                                        } else if (b4 != 254 && b4 == 255) {
                                            a2.c();
                                            String str2 = "";
                                            for (int i5 = 0; i5 < 11; i5++) {
                                                str2 = str2 + ((char) a2.f42489a[i5]);
                                            }
                                            if (str2.equals("NETSCAPE2.0")) {
                                                do {
                                                    a2.c();
                                                    byte[] bArr2 = a2.f42489a;
                                                    if (bArr2[0] == 1) {
                                                        U u4 = a2.f42491c;
                                                        int i6 = ((bArr2[2] & 255) << 8) | (bArr2[1] & 255);
                                                        u4.m = i6;
                                                        if (i6 == 0) {
                                                            u4.m = -1;
                                                        }
                                                    }
                                                    if (a2.f42492d > 0) {
                                                    }
                                                } while (!a2.a());
                                            }
                                        }
                                    }
                                    a2.d();
                                } else if (b3 == 44) {
                                    U u5 = a2.f42491c;
                                    if (u5.f42481d == null) {
                                        u5.f42481d = new T();
                                    }
                                    a2.f42491c.f42481d.f42468a = a2.f42490b.getShort();
                                    a2.f42491c.f42481d.f42469b = a2.f42490b.getShort();
                                    a2.f42491c.f42481d.f42470c = a2.f42490b.getShort();
                                    a2.f42491c.f42481d.f42471d = a2.f42490b.getShort();
                                    int b6 = a2.b();
                                    boolean z2 = (b6 & 128) != 0;
                                    int pow = (int) Math.pow(2.0d, (b6 & 7) + 1);
                                    a2.f42491c.f42481d.f42472e = (b6 & 64) != 0;
                                    if (z2) {
                                        a2.f42491c.f42481d.k = a2.a(pow);
                                    } else {
                                        a2.f42491c.f42481d.k = null;
                                    }
                                    a2.f42491c.f42481d.j = a2.f42490b.position();
                                    a2.b();
                                    a2.d();
                                    if (!a2.a()) {
                                        U u6 = a2.f42491c;
                                        u6.f42480c++;
                                        u6.f42482e.add(u6.f42481d);
                                    }
                                } else if (b3 != 59) {
                                    a2.f42491c.f42479b = 1;
                                } else {
                                    z = true;
                                }
                            }
                            U u7 = a2.f42491c;
                            if (u7.f42480c < 0) {
                                u7.f42479b = 1;
                            }
                        }
                    }
                    U u8 = a2.f42491c;
                    this.p = u8;
                    if (bArr != null) {
                        a(u8, bArr);
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

    public synchronized void a(U u, ByteBuffer byteBuffer, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048579, this, u, byteBuffer, i2) == null) {
            synchronized (this) {
                if (i2 <= 0) {
                    throw new IllegalArgumentException("Sample size must be >=0, not: " + i2);
                }
                int highestOneBit = Integer.highestOneBit(i2);
                this.t = 0;
                this.p = u;
                this.x = false;
                this.n = -1;
                this.o = 0;
                ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
                this.f42459c = asReadOnlyBuffer;
                asReadOnlyBuffer.position(0);
                this.f42459c.order(ByteOrder.LITTLE_ENDIAN);
                this.s = false;
                Iterator it = u.f42482e.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if (((T) it.next()).f42474g == 3) {
                        this.s = true;
                        break;
                    }
                }
                this.u = highestOneBit;
                int i3 = u.f42483f;
                this.w = i3 / highestOneBit;
                int i4 = u.f42484g;
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
            if (i2 < -1 || i2 >= this.p.f42480c) {
                return false;
            }
            this.n = i2;
            return true;
        }
        return invokeI.booleanValue;
    }
}
