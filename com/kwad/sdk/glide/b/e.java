package com.kwad.sdk.glide.b;

import android.graphics.Bitmap;
import android.util.Log;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.glide.b.a;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class e implements a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f37617a = "e";
    public transient /* synthetic */ FieldHolder $fh;
    @ColorInt

    /* renamed from: b  reason: collision with root package name */
    public int[] f37618b;
    @ColorInt

    /* renamed from: c  reason: collision with root package name */
    public final int[] f37619c;

    /* renamed from: d  reason: collision with root package name */
    public final a.InterfaceC0454a f37620d;

    /* renamed from: e  reason: collision with root package name */
    public ByteBuffer f37621e;

    /* renamed from: f  reason: collision with root package name */
    public byte[] f37622f;

    /* renamed from: g  reason: collision with root package name */
    public short[] f37623g;

    /* renamed from: h  reason: collision with root package name */
    public byte[] f37624h;

    /* renamed from: i  reason: collision with root package name */
    public byte[] f37625i;
    public byte[] j;
    @ColorInt
    public int[] k;
    public int l;
    public c m;
    public Bitmap n;
    public boolean o;
    public int p;
    public int q;
    public int r;
    public int s;
    @Nullable
    public Boolean t;
    @NonNull
    public Bitmap.Config u;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(905888392, "Lcom/kwad/sdk/glide/b/e;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(905888392, "Lcom/kwad/sdk/glide/b/e;");
        }
    }

    public e(@NonNull a.InterfaceC0454a interfaceC0454a) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {interfaceC0454a};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f37619c = new int[256];
        this.u = Bitmap.Config.ARGB_8888;
        this.f37620d = interfaceC0454a;
        this.m = new c();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public e(@NonNull a.InterfaceC0454a interfaceC0454a, c cVar, ByteBuffer byteBuffer, int i2) {
        this(interfaceC0454a);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {interfaceC0454a, cVar, byteBuffer, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                this((a.InterfaceC0454a) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        a(cVar, byteBuffer, i2);
    }

    @ColorInt
    private int a(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(65539, this, i2, i3, i4)) == null) {
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            for (int i10 = i2; i10 < this.q + i2; i10++) {
                byte[] bArr = this.j;
                if (i10 >= bArr.length || i10 >= i3) {
                    break;
                }
                int i11 = this.f37618b[bArr[i10] & 255];
                if (i11 != 0) {
                    i5 += (i11 >> 24) & 255;
                    i6 += (i11 >> 16) & 255;
                    i7 += (i11 >> 8) & 255;
                    i8 += i11 & 255;
                    i9++;
                }
            }
            int i12 = i2 + i4;
            for (int i13 = i12; i13 < this.q + i12; i13++) {
                byte[] bArr2 = this.j;
                if (i13 >= bArr2.length || i13 >= i3) {
                    break;
                }
                int i14 = this.f37618b[bArr2[i13] & 255];
                if (i14 != 0) {
                    i5 += (i14 >> 24) & 255;
                    i6 += (i14 >> 16) & 255;
                    i7 += (i14 >> 8) & 255;
                    i8 += i14 & 255;
                    i9++;
                }
            }
            if (i9 == 0) {
                return 0;
            }
            return ((i5 / i9) << 24) | ((i6 / i9) << 16) | ((i7 / i9) << 8) | (i8 / i9);
        }
        return invokeIII.intValue;
    }

    private Bitmap a(b bVar, b bVar2) {
        InterceptResult invokeLL;
        int i2;
        int i3;
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65540, this, bVar, bVar2)) == null) {
            int[] iArr = this.k;
            int i4 = 0;
            if (bVar2 == null) {
                Bitmap bitmap2 = this.n;
                if (bitmap2 != null) {
                    this.f37620d.a(bitmap2);
                }
                this.n = null;
                Arrays.fill(iArr, 0);
            }
            if (bVar2 != null && bVar2.f37601g == 3 && this.n == null) {
                Arrays.fill(iArr, 0);
            }
            if (bVar2 != null && (i3 = bVar2.f37601g) > 0) {
                if (i3 == 2) {
                    if (!bVar.f37600f) {
                        c cVar = this.m;
                        int i5 = cVar.l;
                        if (bVar.k == null || cVar.j != bVar.f37602h) {
                            i4 = i5;
                        }
                    } else if (this.l == 0) {
                        this.t = Boolean.TRUE;
                    }
                    int i6 = bVar2.f37598d;
                    int i7 = this.q;
                    int i8 = i6 / i7;
                    int i9 = bVar2.f37596b / i7;
                    int i10 = bVar2.f37597c / i7;
                    int i11 = bVar2.f37595a / i7;
                    int i12 = this.s;
                    int i13 = (i9 * i12) + i11;
                    int i14 = (i8 * i12) + i13;
                    while (i13 < i14) {
                        int i15 = i13 + i10;
                        for (int i16 = i13; i16 < i15; i16++) {
                            iArr[i16] = i4;
                        }
                        i13 += this.s;
                    }
                } else if (i3 == 3 && (bitmap = this.n) != null) {
                    int i17 = this.s;
                    bitmap.getPixels(iArr, 0, i17, 0, 0, i17, this.r);
                }
            }
            c(bVar);
            if (bVar.f37599e || this.q != 1) {
                b(bVar);
            } else {
                a(bVar);
            }
            if (this.o && ((i2 = bVar.f37601g) == 0 || i2 == 1)) {
                if (this.n == null) {
                    this.n = l();
                }
                Bitmap bitmap3 = this.n;
                int i18 = this.s;
                bitmap3.setPixels(iArr, 0, i18, 0, 0, i18, this.r);
            }
            Bitmap l = l();
            int i19 = this.s;
            l.setPixels(iArr, 0, i19, 0, 0, i19, this.r);
            return l;
        }
        return (Bitmap) invokeLL.objValue;
    }

    private void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, bVar) == null) {
            b bVar2 = bVar;
            int[] iArr = this.k;
            int i2 = bVar2.f37598d;
            int i3 = bVar2.f37596b;
            int i4 = bVar2.f37597c;
            int i5 = bVar2.f37595a;
            boolean z = this.l == 0;
            int i6 = this.s;
            byte[] bArr = this.j;
            int[] iArr2 = this.f37618b;
            int i7 = 0;
            byte b2 = -1;
            while (i7 < i2) {
                int i8 = (i7 + i3) * i6;
                int i9 = i8 + i5;
                int i10 = i9 + i4;
                int i11 = i8 + i6;
                if (i11 < i10) {
                    i10 = i11;
                }
                int i12 = bVar2.f37597c * i7;
                int i13 = i9;
                while (i13 < i10) {
                    byte b3 = bArr[i12];
                    int i14 = i2;
                    int i15 = b3 & 255;
                    if (i15 != b2) {
                        int i16 = iArr2[i15];
                        if (i16 != 0) {
                            iArr[i13] = i16;
                        } else {
                            b2 = b3;
                        }
                    }
                    i12++;
                    i13++;
                    i2 = i14;
                }
                i7++;
                bVar2 = bVar;
            }
            this.t = Boolean.valueOf(this.t == null && z && b2 != -1);
        }
    }

    private void b(b bVar) {
        Boolean bool;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, bVar) == null) {
            int[] iArr = this.k;
            int i7 = bVar.f37598d;
            int i8 = this.q;
            int i9 = i7 / i8;
            int i10 = bVar.f37596b / i8;
            int i11 = bVar.f37597c / i8;
            int i12 = bVar.f37595a / i8;
            boolean z = this.l == 0;
            int i13 = this.q;
            int i14 = this.s;
            int i15 = this.r;
            byte[] bArr = this.j;
            int[] iArr2 = this.f37618b;
            Boolean bool2 = this.t;
            int i16 = 8;
            int i17 = 0;
            int i18 = 0;
            int i19 = 1;
            while (true) {
                bool = bool2;
                if (i17 >= i9) {
                    break;
                }
                if (bVar.f37599e) {
                    if (i18 >= i9) {
                        i2 = i9;
                        int i20 = i19 + 1;
                        if (i20 == 2) {
                            i19 = i20;
                            i18 = 4;
                        } else if (i20 != 3) {
                            i19 = i20;
                            if (i20 == 4) {
                                i18 = 1;
                                i16 = 2;
                            }
                        } else {
                            i19 = i20;
                            i18 = 2;
                            i16 = 4;
                        }
                    } else {
                        i2 = i9;
                    }
                    i3 = i18 + i16;
                } else {
                    i2 = i9;
                    i3 = i18;
                    i18 = i17;
                }
                int i21 = i18 + i10;
                boolean z2 = i13 == 1;
                if (i21 < i15) {
                    int i22 = i21 * i14;
                    int i23 = i22 + i12;
                    int i24 = i23 + i11;
                    int i25 = i22 + i14;
                    if (i25 < i24) {
                        i24 = i25;
                    }
                    i4 = i3;
                    int i26 = i17 * i13 * bVar.f37597c;
                    if (z2) {
                        int i27 = i23;
                        while (true) {
                            i5 = i10;
                            if (i27 >= i24) {
                                break;
                            }
                            int i28 = iArr2[bArr[i26] & 255];
                            if (i28 != 0) {
                                iArr[i27] = i28;
                            } else if (z && bool == null) {
                                bool = Boolean.TRUE;
                            }
                            i26 += i13;
                            i27++;
                            i10 = i5;
                        }
                    } else {
                        i5 = i10;
                        int i29 = ((i24 - i23) * i13) + i26;
                        int i30 = i23;
                        while (true) {
                            i6 = i11;
                            if (i30 < i24) {
                                int a2 = a(i26, i29, bVar.f37597c);
                                if (a2 != 0) {
                                    iArr[i30] = a2;
                                } else if (z && bool == null) {
                                    bool = Boolean.TRUE;
                                }
                                i26 += i13;
                                i30++;
                                i11 = i6;
                            }
                        }
                        bool2 = bool;
                        i17++;
                        i10 = i5;
                        i11 = i6;
                        i9 = i2;
                        i18 = i4;
                    }
                } else {
                    i4 = i3;
                    i5 = i10;
                }
                i6 = i11;
                bool2 = bool;
                i17++;
                i10 = i5;
                i11 = i6;
                i9 = i2;
                i18 = i4;
            }
            if (this.t == null) {
                this.t = Boolean.valueOf(bool == null ? false : bool.booleanValue());
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:83:0x00fb */
    /* JADX DEBUG: Multi-variable search result rejected for r7v15, resolved type: short */
    /* JADX WARN: Multi-variable type inference failed */
    private void c(b bVar) {
        int i2;
        int i3;
        short s;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, bVar) == null) {
            e eVar = this;
            if (bVar != null) {
                eVar.f37621e.position(bVar.j);
            }
            if (bVar == null) {
                c cVar = eVar.m;
                i2 = cVar.f37609f;
                i3 = cVar.f37610g;
            } else {
                i2 = bVar.f37597c;
                i3 = bVar.f37598d;
            }
            int i4 = i2 * i3;
            byte[] bArr = eVar.j;
            if (bArr == null || bArr.length < i4) {
                eVar.j = eVar.f37620d.a(i4);
            }
            byte[] bArr2 = eVar.j;
            if (eVar.f37623g == null) {
                eVar.f37623g = new short[4096];
            }
            short[] sArr = eVar.f37623g;
            if (eVar.f37624h == null) {
                eVar.f37624h = new byte[4096];
            }
            byte[] bArr3 = eVar.f37624h;
            if (eVar.f37625i == null) {
                eVar.f37625i = new byte[4097];
            }
            byte[] bArr4 = eVar.f37625i;
            int j = j();
            int i5 = 1 << j;
            int i6 = i5 + 1;
            int i7 = i5 + 2;
            int i8 = j + 1;
            int i9 = (1 << i8) - 1;
            int i10 = 0;
            for (int i11 = 0; i11 < i5; i11++) {
                sArr[i11] = 0;
                bArr3[i11] = (byte) i11;
            }
            byte[] bArr5 = eVar.f37622f;
            int i12 = i8;
            int i13 = i7;
            int i14 = i9;
            int i15 = 0;
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            int i20 = -1;
            int i21 = 0;
            int i22 = 0;
            while (true) {
                if (i10 >= i4) {
                    break;
                }
                if (i15 == 0) {
                    i15 = k();
                    if (i15 <= 0) {
                        eVar.p = 3;
                        break;
                    }
                    i16 = 0;
                }
                i18 += (bArr5[i16] & 255) << i17;
                i16++;
                i15--;
                int i23 = i17 + 8;
                int i24 = i13;
                int i25 = i12;
                int i26 = i20;
                int i27 = i8;
                int i28 = i21;
                while (true) {
                    if (i23 < i25) {
                        i20 = i26;
                        i13 = i24;
                        i17 = i23;
                        eVar = this;
                        i21 = i28;
                        i8 = i27;
                        i12 = i25;
                        break;
                    }
                    int i29 = i7;
                    int i30 = i18 & i14;
                    i18 >>= i25;
                    i23 -= i25;
                    if (i30 == i5) {
                        i14 = i9;
                        i25 = i27;
                        i24 = i29;
                        i7 = i24;
                        i26 = -1;
                    } else if (i30 == i6) {
                        i17 = i23;
                        i21 = i28;
                        i13 = i24;
                        i8 = i27;
                        i7 = i29;
                        i20 = i26;
                        i12 = i25;
                        eVar = this;
                        break;
                    } else if (i26 == -1) {
                        bArr2[i19] = bArr3[i30];
                        i19++;
                        i10++;
                        i26 = i30;
                        i28 = i26;
                        i7 = i29;
                        i23 = i23;
                    } else {
                        if (i30 >= i24) {
                            bArr4[i22] = (byte) i28;
                            i22++;
                            s = i26;
                        } else {
                            s = i30;
                        }
                        while (s >= i5) {
                            bArr4[i22] = bArr3[s];
                            i22++;
                            s = sArr[s];
                        }
                        i28 = bArr3[s] & 255;
                        byte b2 = (byte) i28;
                        bArr2[i19] = b2;
                        while (true) {
                            i19++;
                            i10++;
                            if (i22 <= 0) {
                                break;
                            }
                            i22--;
                            bArr2[i19] = bArr4[i22];
                        }
                        byte[] bArr6 = bArr4;
                        if (i24 < 4096) {
                            sArr[i24] = (short) i26;
                            bArr3[i24] = b2;
                            i24++;
                            if ((i24 & i14) == 0 && i24 < 4096) {
                                i25++;
                                i14 += i24;
                            }
                        }
                        i26 = i30;
                        i7 = i29;
                        i23 = i23;
                        bArr4 = bArr6;
                    }
                }
            }
            Arrays.fill(bArr2, i19, i4, (byte) 0);
        }
    }

    private int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) ? this.f37621e.get() & 255 : invokeV.intValue;
    }

    private int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            int j = j();
            if (j <= 0) {
                return j;
            }
            ByteBuffer byteBuffer = this.f37621e;
            byteBuffer.get(this.f37622f, 0, Math.min(j, byteBuffer.remaining()));
            return j;
        }
        return invokeV.intValue;
    }

    private Bitmap l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            Boolean bool = this.t;
            Bitmap a2 = this.f37620d.a(this.s, this.r, (bool == null || bool.booleanValue()) ? Bitmap.Config.ARGB_8888 : this.u);
            a2.setHasAlpha(true);
            return a2;
        }
        return (Bitmap) invokeV.objValue;
    }

    public int a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            if (i2 >= 0) {
                c cVar = this.m;
                if (i2 < cVar.f37606c) {
                    return cVar.f37608e.get(i2).f37603i;
                }
            }
            return -1;
        }
        return invokeI.intValue;
    }

    @Override // com.kwad.sdk.glide.b.a
    @NonNull
    public ByteBuffer a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f37621e : (ByteBuffer) invokeV.objValue;
    }

    @Override // com.kwad.sdk.glide.b.a
    public void a(@NonNull Bitmap.Config config) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, config) == null) {
            if (config == Bitmap.Config.ARGB_8888 || config == Bitmap.Config.RGB_565) {
                this.u = config;
                return;
            }
            throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + Bitmap.Config.ARGB_8888 + " or " + Bitmap.Config.RGB_565);
        }
    }

    public synchronized void a(@NonNull c cVar, @NonNull ByteBuffer byteBuffer, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048579, this, cVar, byteBuffer, i2) == null) {
            synchronized (this) {
                if (i2 <= 0) {
                    throw new IllegalArgumentException("Sample size must be >=0, not: " + i2);
                }
                int highestOneBit = Integer.highestOneBit(i2);
                this.p = 0;
                this.m = cVar;
                this.l = -1;
                ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
                this.f37621e = asReadOnlyBuffer;
                asReadOnlyBuffer.position(0);
                this.f37621e.order(ByteOrder.LITTLE_ENDIAN);
                this.o = false;
                Iterator<b> it = cVar.f37608e.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if (it.next().f37601g == 3) {
                        this.o = true;
                        break;
                    }
                }
                this.q = highestOneBit;
                this.s = cVar.f37609f / highestOneBit;
                this.r = cVar.f37610g / highestOneBit;
                this.j = this.f37620d.a(cVar.f37609f * cVar.f37610g);
                this.k = this.f37620d.b(this.s * this.r);
            }
        }
    }

    @Override // com.kwad.sdk.glide.b.a
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.l = (this.l + 1) % this.m.f37606c;
        }
    }

    @Override // com.kwad.sdk.glide.b.a
    public int c() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.m.f37606c <= 0 || (i2 = this.l) < 0) {
                return 0;
            }
            return a(i2);
        }
        return invokeV.intValue;
    }

    @Override // com.kwad.sdk.glide.b.a
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.m.f37606c : invokeV.intValue;
    }

    @Override // com.kwad.sdk.glide.b.a
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.l : invokeV.intValue;
    }

    @Override // com.kwad.sdk.glide.b.a
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.l = -1;
        }
    }

    @Override // com.kwad.sdk.glide.b.a
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f37621e.limit() + this.j.length + (this.k.length * 4) : invokeV.intValue;
    }

    @Override // com.kwad.sdk.glide.b.a
    @Nullable
    public synchronized Bitmap h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            synchronized (this) {
                if (this.m.f37606c <= 0 || this.l < 0) {
                    if (Log.isLoggable(f37617a, 3)) {
                        String str = f37617a;
                        Log.d(str, "Unable to decode frame, frameCount=" + this.m.f37606c + ", framePointer=" + this.l);
                    }
                    this.p = 1;
                }
                if (this.p != 1 && this.p != 2) {
                    this.p = 0;
                    if (this.f37622f == null) {
                        this.f37622f = this.f37620d.a(255);
                    }
                    b bVar = this.m.f37608e.get(this.l);
                    int i2 = this.l - 1;
                    b bVar2 = i2 >= 0 ? this.m.f37608e.get(i2) : null;
                    int[] iArr = bVar.k != null ? bVar.k : this.m.f37604a;
                    this.f37618b = iArr;
                    if (iArr != null) {
                        if (bVar.f37600f) {
                            System.arraycopy(iArr, 0, this.f37619c, 0, iArr.length);
                            int[] iArr2 = this.f37619c;
                            this.f37618b = iArr2;
                            iArr2[bVar.f37602h] = 0;
                        }
                        return a(bVar, bVar2);
                    }
                    if (Log.isLoggable(f37617a, 3)) {
                        String str2 = f37617a;
                        Log.d(str2, "No valid color table found for frame #" + this.l);
                    }
                    this.p = 1;
                    return null;
                }
                if (Log.isLoggable(f37617a, 3)) {
                    String str3 = f37617a;
                    Log.d(str3, "Unable to decode frame, status=" + this.p);
                }
                return null;
            }
        }
        return (Bitmap) invokeV.objValue;
    }

    @Override // com.kwad.sdk.glide.b.a
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.m = null;
            byte[] bArr = this.j;
            if (bArr != null) {
                this.f37620d.a(bArr);
            }
            int[] iArr = this.k;
            if (iArr != null) {
                this.f37620d.a(iArr);
            }
            Bitmap bitmap = this.n;
            if (bitmap != null) {
                this.f37620d.a(bitmap);
            }
            this.n = null;
            this.f37621e = null;
            this.t = null;
            byte[] bArr2 = this.f37622f;
            if (bArr2 != null) {
                this.f37620d.a(bArr2);
            }
        }
    }
}
