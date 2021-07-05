package d.a.k.d.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Array;
import java.security.InvalidKeyException;
/* loaded from: classes8.dex */
public final class b implements a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static int[] f45903g;

    /* renamed from: h  reason: collision with root package name */
    public static int[] f45904h;

    /* renamed from: i  reason: collision with root package name */
    public static final byte[] f45905i;
    public static final byte[] j;
    public static final int[] k;
    public static final int[] l;
    public static final int[] m;
    public static final int[] n;
    public static final int[] o;
    public static final int[] p;
    public static final int[] q;
    public static final int[] r;
    public static final int[] s;
    public static final int[] t;
    public static final int[] u;
    public static final int[] v;
    public static final byte[] w;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public boolean f45906b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f45907c;

    /* renamed from: d  reason: collision with root package name */
    public Object[] f45908d;

    /* renamed from: e  reason: collision with root package name */
    public int[] f45909e;

    /* renamed from: f  reason: collision with root package name */
    public int f45910f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1116341189, "Ld/a/k/d/a/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1116341189, "Ld/a/k/d/a/b;");
                return;
            }
        }
        int[] iArr = new int[256];
        f45903g = iArr;
        f45904h = new int[256];
        f45905i = new byte[256];
        j = new byte[256];
        k = new int[256];
        l = new int[256];
        m = new int[256];
        n = new int[256];
        o = new int[256];
        p = new int[256];
        q = new int[256];
        r = new int[256];
        s = new int[256];
        t = new int[256];
        u = new int[256];
        v = new int[256];
        w = new byte[30];
        iArr[0] = 1;
        for (int i2 = 1; i2 < 256; i2++) {
            int[] iArr2 = f45903g;
            int i3 = i2 - 1;
            int i4 = iArr2[i3] ^ (iArr2[i3] << 1);
            if ((i4 & 256) != 0) {
                i4 ^= 283;
            }
            f45903g[i2] = i4;
        }
        for (int i5 = 1; i5 < 255; i5++) {
            f45904h[f45903g[i5]] = i5;
        }
        byte[][] bArr = {new byte[]{1, 1, 1, 1, 1, 0, 0, 0}, new byte[]{0, 1, 1, 1, 1, 1, 0, 0}, new byte[]{0, 0, 1, 1, 1, 1, 1, 0}, new byte[]{0, 0, 0, 1, 1, 1, 1, 1}, new byte[]{1, 0, 0, 0, 1, 1, 1, 1}, new byte[]{1, 1, 0, 0, 0, 1, 1, 1}, new byte[]{1, 1, 1, 0, 0, 0, 1, 1}, new byte[]{1, 1, 1, 1, 0, 0, 0, 1}};
        byte[] bArr2 = {0, 1, 1, 0, 0, 0, 1, 1};
        byte[][] bArr3 = (byte[][]) Array.newInstance(byte.class, 256, 8);
        bArr3[1][7] = 1;
        for (int i6 = 2; i6 < 256; i6++) {
            int i7 = f45903g[255 - f45904h[i6]];
            for (int i8 = 0; i8 < 8; i8++) {
                bArr3[i6][i8] = (byte) ((i7 >>> (7 - i8)) & 1);
            }
        }
        byte[][] bArr4 = (byte[][]) Array.newInstance(byte.class, 256, 8);
        for (int i9 = 0; i9 < 256; i9++) {
            for (int i10 = 0; i10 < 8; i10++) {
                bArr4[i9][i10] = bArr2[i10];
                for (int i11 = 0; i11 < 8; i11++) {
                    byte[] bArr5 = bArr4[i9];
                    bArr5[i10] = (byte) (bArr5[i10] ^ (bArr[i10][i11] * bArr3[i9][i11]));
                }
            }
        }
        for (int i12 = 0; i12 < 256; i12++) {
            f45905i[i12] = (byte) (bArr4[i12][0] << 7);
            for (int i13 = 1; i13 < 8; i13++) {
                byte[] bArr6 = f45905i;
                bArr6[i12] = (byte) (bArr6[i12] ^ (bArr4[i12][i13] << (7 - i13)));
            }
            j[f45905i[i12] & 255] = (byte) i12;
        }
        byte[][] bArr7 = {new byte[]{2, 1, 1, 3}, new byte[]{3, 2, 1, 1}, new byte[]{1, 3, 2, 1}, new byte[]{1, 1, 3, 2}};
        byte[][] bArr8 = (byte[][]) Array.newInstance(byte.class, 4, 8);
        for (int i14 = 0; i14 < 4; i14++) {
            for (int i15 = 0; i15 < 4; i15++) {
                bArr8[i14][i15] = bArr7[i14][i15];
            }
            bArr8[i14][i14 + 4] = 1;
        }
        byte[][] bArr9 = (byte[][]) Array.newInstance(byte.class, 4, 4);
        for (int i16 = 0; i16 < 4; i16++) {
            byte b2 = bArr8[i16][i16];
            if (b2 == 0) {
                int i17 = i16 + 1;
                while (bArr8[i17][i16] == 0 && i17 < 4) {
                    i17++;
                }
                if (i17 == 4) {
                    throw new RuntimeException("G matrix is not invertible");
                }
                for (int i18 = 0; i18 < 8; i18++) {
                    byte b3 = bArr8[i16][i18];
                    bArr8[i16][i18] = bArr8[i17][i18];
                    bArr8[i17][i18] = b3;
                }
                b2 = bArr8[i16][i16];
            }
            for (int i19 = 0; i19 < 8; i19++) {
                if (bArr8[i16][i19] != 0) {
                    byte[] bArr10 = bArr8[i16];
                    int[] iArr3 = f45903g;
                    int[] iArr4 = f45904h;
                    bArr10[i19] = (byte) iArr3[((iArr4[bArr8[i16][i19] & 255] + 255) - iArr4[b2 & 255]) % 255];
                }
            }
            for (int i20 = 0; i20 < 4; i20++) {
                if (i16 != i20) {
                    for (int i21 = i16 + 1; i21 < 8; i21++) {
                        byte[] bArr11 = bArr8[i20];
                        bArr11[i21] = (byte) (bArr11[i21] ^ b(bArr8[i16][i21], bArr8[i20][i16]));
                    }
                    bArr8[i20][i16] = 0;
                }
            }
        }
        for (int i22 = 0; i22 < 4; i22++) {
            for (int i23 = 0; i23 < 4; i23++) {
                bArr9[i22][i23] = bArr8[i22][i23 + 4];
            }
        }
        for (int i24 = 0; i24 < 256; i24++) {
            byte b4 = f45905i[i24];
            k[i24] = c(b4, bArr7[0]);
            l[i24] = c(b4, bArr7[1]);
            m[i24] = c(b4, bArr7[2]);
            n[i24] = c(b4, bArr7[3]);
            byte b5 = j[i24];
            o[i24] = c(b5, bArr9[0]);
            p[i24] = c(b5, bArr9[1]);
            q[i24] = c(b5, bArr9[2]);
            r[i24] = c(b5, bArr9[3]);
            s[i24] = c(i24, bArr9[0]);
            t[i24] = c(i24, bArr9[1]);
            u[i24] = c(i24, bArr9[2]);
            v[i24] = c(i24, bArr9[3]);
        }
        int i25 = 1;
        w[0] = 1;
        for (int i26 = 1; i26 < 30; i26++) {
            i25 = b(2, i25);
            w[i26] = (byte) i25;
        }
        f45904h = null;
        f45903g = null;
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f45906b = false;
        this.f45907c = false;
        this.f45908d = null;
        this.f45909e = null;
        this.f45910f = 0;
    }

    public static final int b(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65538, null, i2, i3)) == null) {
            if (i2 == 0 || i3 == 0) {
                return 0;
            }
            int[] iArr = f45903g;
            int[] iArr2 = f45904h;
            return iArr[(iArr2[i2 & 255] + iArr2[i3 & 255]) % 255];
        }
        return invokeII.intValue;
    }

    public static final int c(int i2, byte[] bArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65539, null, i2, bArr)) == null) {
            if (i2 == 0) {
                return 0;
            }
            int[] iArr = f45904h;
            int i3 = iArr[i2 & 255];
            return ((bArr[0] != 0 ? f45903g[(iArr[bArr[0] & 255] + i3) % 255] & 255 : 0) << 24) | ((bArr[1] != 0 ? f45903g[(f45904h[bArr[1] & 255] + i3) % 255] & 255 : 0) << 16) | ((bArr[2] != 0 ? f45903g[(f45904h[bArr[2] & 255] + i3) % 255] & 255 : 0) << 8) | (bArr[3] != 0 ? f45903g[(i3 + f45904h[bArr[3] & 255]) % 255] & 255 : 0);
        }
        return invokeIL.intValue;
    }

    public static final boolean g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeI = interceptable.invokeI(65540, null, i2)) != null) {
            return invokeI.booleanValue;
        }
        int i3 = 0;
        while (true) {
            int[] iArr = a.f45902a;
            if (i3 >= iArr.length) {
                return false;
            }
            if (i2 == iArr[i3]) {
                return true;
            }
            i3++;
        }
    }

    public static Object[] h(byte[] bArr) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, bArr)) == null) {
            if (bArr != null) {
                if (!g(bArr.length)) {
                    throw new InvalidKeyException("Invalid AES key length: " + bArr.length + " bytes");
                }
                int i3 = i(bArr.length);
                int i4 = i3 + 1;
                int i5 = i4 * 4;
                char c2 = 0;
                int[][] iArr = (int[][]) Array.newInstance(int.class, i4, 4);
                int[][] iArr2 = (int[][]) Array.newInstance(int.class, i4, 4);
                int length = bArr.length / 4;
                int[] iArr3 = new int[length];
                int i6 = 0;
                int i7 = 0;
                while (i6 < length) {
                    iArr3[i6] = ((bArr[i7 + 2] & 255) << 8) | (bArr[i7] << 24) | ((bArr[i7 + 1] & 255) << 16) | (bArr[i7 + 3] & 255);
                    i6++;
                    i7 += 4;
                }
                int i8 = 0;
                int i9 = 0;
                while (i8 < length && i9 < i5) {
                    int i10 = i9 / 4;
                    int i11 = i9 % 4;
                    iArr[i10][i11] = iArr3[i8];
                    iArr2[i3 - i10][i11] = iArr3[i8];
                    i8++;
                    i9++;
                }
                int i12 = 0;
                while (i9 < i5) {
                    int i13 = iArr3[length - 1];
                    int i14 = iArr3[c2];
                    byte[] bArr2 = f45905i;
                    int i15 = (((bArr2[(i13 >>> 16) & 255] << 24) ^ ((bArr2[(i13 >>> 8) & 255] & 255) << 16)) ^ ((bArr2[i13 & 255] & 255) << 8)) ^ (bArr2[i13 >>> 24] & 255);
                    int i16 = i12 + 1;
                    iArr3[c2] = ((w[i12] << 24) ^ i15) ^ i14;
                    int i17 = 1;
                    int i18 = 0;
                    if (length != 8) {
                        while (i17 < length) {
                            iArr3[i17] = iArr3[i17] ^ iArr3[i18];
                            i17++;
                            i18++;
                        }
                    } else {
                        while (true) {
                            i2 = length / 2;
                            if (i17 >= i2) {
                                break;
                            }
                            iArr3[i17] = iArr3[i17] ^ iArr3[i18];
                            i17++;
                            i18++;
                        }
                        int i19 = iArr3[i2 - 1];
                        int i20 = iArr3[i2];
                        byte[] bArr3 = f45905i;
                        iArr3[i2] = ((bArr3[i19 >>> 24] << 24) ^ ((((bArr3[(i19 >>> 8) & 255] & 255) << 8) ^ (bArr3[i19 & 255] & 255)) ^ ((bArr3[(i19 >>> 16) & 255] & 255) << 16))) ^ i20;
                        int i21 = i2 + 1;
                        while (i21 < length) {
                            iArr3[i21] = iArr3[i21] ^ iArr3[i2];
                            i21++;
                            i2++;
                        }
                    }
                    int i22 = 0;
                    while (i22 < length && i9 < i5) {
                        int i23 = i9 / 4;
                        int i24 = i9 % 4;
                        iArr[i23][i24] = iArr3[i22];
                        iArr2[i3 - i23][i24] = iArr3[i22];
                        i22++;
                        i9++;
                    }
                    i12 = i16;
                    c2 = 0;
                }
                for (int i25 = 1; i25 < i3; i25++) {
                    for (int i26 = 0; i26 < 4; i26++) {
                        int i27 = iArr2[i25][i26];
                        iArr2[i25][i26] = v[i27 & 255] ^ ((s[(i27 >>> 24) & 255] ^ t[(i27 >>> 16) & 255]) ^ u[(i27 >>> 8) & 255]);
                    }
                }
                return new Object[]{iArr, iArr2};
            }
            throw new InvalidKeyException("Empty key");
        }
        return (Object[]) invokeL.objValue;
    }

    public static int i(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.BAIDU_LOGO_ID, null, i2)) == null) ? (i2 >> 2) + 6 : invokeI.intValue;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 16;
        }
        return invokeV.intValue;
    }

    public final void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            int[][] iArr = (int[][]) this.f45908d[z ? 1 : 0];
            int length = iArr.length;
            this.f45909e = new int[length * 4];
            for (int i2 = 0; i2 < length; i2++) {
                for (int i3 = 0; i3 < 4; i3++) {
                    this.f45909e[(i2 * 4) + i3] = iArr[i2][i3];
                }
            }
            if (z) {
                int[] iArr2 = this.f45909e;
                int i4 = iArr2[iArr2.length - 4];
                int i5 = iArr2[iArr2.length - 3];
                int i6 = iArr2[iArr2.length - 2];
                int i7 = iArr2[iArr2.length - 1];
                for (int length2 = iArr2.length - 1; length2 > 3; length2--) {
                    int[] iArr3 = this.f45909e;
                    iArr3[length2] = iArr3[length2 - 4];
                }
                int[] iArr4 = this.f45909e;
                iArr4[0] = i4;
                iArr4[1] = i5;
                iArr4[2] = i6;
                iArr4[3] = i7;
            }
            this.f45906b = length >= 13;
            this.f45907c = length == 15;
            this.f45910f = (length - 1) * 4;
        }
    }

    public void e(boolean z, String str, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), str, bArr}) == null) {
            if (g(bArr.length)) {
                this.f45908d = h(bArr);
                d(z);
                return;
            }
            throw new InvalidKeyException("Invalid AES key length: " + bArr.length + " bytes");
        }
    }

    public void f(byte[] bArr, int i2, byte[] bArr2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{bArr, Integer.valueOf(i2), bArr2, Integer.valueOf(i3)}) == null) {
            int i4 = i2 + 1;
            int i5 = i4 + 1;
            int i6 = i5 + 1;
            int i7 = ((bArr[i4] & 255) << 16) | (bArr[i2] << 24) | ((bArr[i5] & 255) << 8);
            int i8 = i6 + 1;
            int i9 = i7 | (bArr[i6] & 255);
            int[] iArr = this.f45909e;
            int i10 = i9 ^ iArr[0];
            int i11 = i8 + 1;
            int i12 = i11 + 1;
            int i13 = (bArr[i8] << 24) | ((bArr[i11] & 255) << 16);
            int i14 = i12 + 1;
            int i15 = i13 | ((bArr[i12] & 255) << 8);
            int i16 = i14 + 1;
            int i17 = (i15 | (bArr[i14] & 255)) ^ iArr[1];
            int i18 = i16 + 1;
            int i19 = i18 + 1;
            int i20 = ((bArr[i18] & 255) << 16) | (bArr[i16] << 24);
            int i21 = i19 + 1;
            int i22 = i20 | ((bArr[i19] & 255) << 8);
            int i23 = i21 + 1;
            int i24 = (i22 | (bArr[i21] & 255)) ^ iArr[2];
            int i25 = i23 + 1;
            int i26 = i25 + 1;
            int i27 = iArr[3] ^ (((((bArr[i25] & 255) << 16) | (bArr[i23] << 24)) | ((bArr[i26] & 255) << 8)) | (bArr[i26 + 1] & 255));
            int i28 = 4;
            while (i28 < this.f45910f) {
                int[] iArr2 = k;
                int i29 = iArr2[i10 >>> 24];
                int[] iArr3 = l;
                int i30 = i29 ^ iArr3[(i17 >>> 16) & 255];
                int[] iArr4 = m;
                int i31 = i30 ^ iArr4[(i24 >>> 8) & 255];
                int[] iArr5 = n;
                int i32 = i31 ^ iArr5[i27 & 255];
                int[] iArr6 = this.f45909e;
                int i33 = i28 + 1;
                int i34 = iArr6[i28] ^ i32;
                int i35 = i33 + 1;
                int i36 = (((iArr2[i17 >>> 24] ^ iArr3[(i24 >>> 16) & 255]) ^ iArr4[(i27 >>> 8) & 255]) ^ iArr5[i10 & 255]) ^ iArr6[i33];
                int i37 = ((iArr2[i24 >>> 24] ^ iArr3[(i27 >>> 16) & 255]) ^ iArr4[(i10 >>> 8) & 255]) ^ iArr5[i17 & 255];
                int i38 = i35 + 1;
                int i39 = (((iArr3[(i10 >>> 16) & 255] ^ iArr2[i27 >>> 24]) ^ iArr4[(i17 >>> 8) & 255]) ^ iArr5[i24 & 255]) ^ iArr6[i38];
                i17 = i36;
                i24 = i37 ^ iArr6[i35];
                i27 = i39;
                i10 = i34;
                i28 = i38 + 1;
            }
            int[] iArr7 = this.f45909e;
            int i40 = i28 + 1;
            int i41 = iArr7[i28];
            int i42 = i3 + 1;
            byte[] bArr3 = f45905i;
            bArr2[i3] = (byte) (bArr3[i10 >>> 24] ^ (i41 >>> 24));
            int i43 = i42 + 1;
            bArr2[i42] = (byte) (bArr3[(i17 >>> 16) & 255] ^ (i41 >>> 16));
            int i44 = i43 + 1;
            bArr2[i43] = (byte) (bArr3[(i24 >>> 8) & 255] ^ (i41 >>> 8));
            int i45 = i44 + 1;
            bArr2[i44] = (byte) (i41 ^ bArr3[i27 & 255]);
            int i46 = i40 + 1;
            int i47 = iArr7[i40];
            int i48 = i45 + 1;
            bArr2[i45] = (byte) (bArr3[i17 >>> 24] ^ (i47 >>> 24));
            int i49 = i48 + 1;
            bArr2[i48] = (byte) (bArr3[(i24 >>> 16) & 255] ^ (i47 >>> 16));
            int i50 = i49 + 1;
            bArr2[i49] = (byte) (bArr3[(i27 >>> 8) & 255] ^ (i47 >>> 8));
            int i51 = i50 + 1;
            bArr2[i50] = (byte) (i47 ^ bArr3[i10 & 255]);
            int i52 = i46 + 1;
            int i53 = iArr7[i46];
            int i54 = i51 + 1;
            bArr2[i51] = (byte) (bArr3[i24 >>> 24] ^ (i53 >>> 24));
            int i55 = i54 + 1;
            bArr2[i54] = (byte) (bArr3[(i27 >>> 16) & 255] ^ (i53 >>> 16));
            int i56 = i55 + 1;
            bArr2[i55] = (byte) (bArr3[(i10 >>> 8) & 255] ^ (i53 >>> 8));
            int i57 = i56 + 1;
            bArr2[i56] = (byte) (i53 ^ bArr3[i17 & 255]);
            int i58 = iArr7[i52];
            int i59 = i57 + 1;
            bArr2[i57] = (byte) (bArr3[i27 >>> 24] ^ (i58 >>> 24));
            int i60 = i59 + 1;
            bArr2[i59] = (byte) (bArr3[(i10 >>> 16) & 255] ^ (i58 >>> 16));
            bArr2[i60] = (byte) (bArr3[(i17 >>> 8) & 255] ^ (i58 >>> 8));
            bArr2[i60 + 1] = (byte) (bArr3[i24 & 255] ^ i58);
        }
    }

    public void j(byte[] bArr, int i2, byte[] bArr2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{bArr, Integer.valueOf(i2), bArr2, Integer.valueOf(i3)}) == null) {
            int i9 = i2 + 1;
            int i10 = i9 + 1;
            int i11 = i10 + 1;
            int i12 = ((bArr[i9] & 255) << 16) | (bArr[i2] << 24) | ((bArr[i10] & 255) << 8);
            int i13 = i11 + 1;
            int i14 = i12 | (bArr[i11] & 255);
            int[] iArr = this.f45909e;
            int i15 = i14 ^ iArr[4];
            int i16 = i13 + 1;
            int i17 = i16 + 1;
            int i18 = (bArr[i13] << 24) | ((bArr[i16] & 255) << 16);
            int i19 = i17 + 1;
            int i20 = i18 | ((bArr[i17] & 255) << 8);
            int i21 = i19 + 1;
            int i22 = (i20 | (bArr[i19] & 255)) ^ iArr[5];
            int i23 = i21 + 1;
            int i24 = i23 + 1;
            int i25 = ((bArr[i23] & 255) << 16) | (bArr[i21] << 24);
            int i26 = i24 + 1;
            int i27 = i25 | ((bArr[i24] & 255) << 8);
            int i28 = i26 + 1;
            int i29 = (i27 | (bArr[i26] & 255)) ^ iArr[6];
            int i30 = i28 + 1;
            int i31 = i30 + 1;
            int i32 = (((((bArr[i30] & 255) << 16) | (bArr[i28] << 24)) | ((bArr[i31] & 255) << 8)) | (bArr[i31 + 1] & 255)) ^ iArr[7];
            if (this.f45906b) {
                int[] iArr2 = o;
                int i33 = iArr2[i15 >>> 24];
                int[] iArr3 = p;
                int i34 = i33 ^ iArr3[(i32 >>> 16) & 255];
                int[] iArr4 = q;
                int i35 = i34 ^ iArr4[(i29 >>> 8) & 255];
                int[] iArr5 = r;
                int i36 = (i35 ^ iArr5[i22 & 255]) ^ iArr[8];
                int i37 = (((iArr3[(i15 >>> 16) & 255] ^ iArr2[i22 >>> 24]) ^ iArr4[(i32 >>> 8) & 255]) ^ iArr5[i29 & 255]) ^ iArr[9];
                int i38 = (((iArr3[(i22 >>> 16) & 255] ^ iArr2[i29 >>> 24]) ^ iArr4[(i15 >>> 8) & 255]) ^ iArr5[i32 & 255]) ^ iArr[10];
                int i39 = iArr2[i32 >>> 24];
                int i40 = (iArr5[i15 & 255] ^ (iArr4[(i22 >>> 8) & 255] ^ (iArr3[(i29 >>> 16) & 255] ^ i39))) ^ iArr[11];
                i7 = iArr[12] ^ (((iArr2[i36 >>> 24] ^ iArr3[(i40 >>> 16) & 255]) ^ iArr4[(i38 >>> 8) & 255]) ^ iArr5[i37 & 255]);
                i6 = (((iArr2[i37 >>> 24] ^ iArr3[(i36 >>> 16) & 255]) ^ iArr4[(i40 >>> 8) & 255]) ^ iArr5[i38 & 255]) ^ iArr[13];
                i5 = (((iArr2[i38 >>> 24] ^ iArr3[(i37 >>> 16) & 255]) ^ iArr4[(i36 >>> 8) & 255]) ^ iArr5[i40 & 255]) ^ iArr[14];
                int i41 = (((iArr2[i40 >>> 24] ^ iArr3[(i38 >>> 16) & 255]) ^ iArr4[(i37 >>> 8) & 255]) ^ iArr5[i36 & 255]) ^ iArr[15];
                if (this.f45907c) {
                    int i42 = (((iArr2[i7 >>> 24] ^ iArr3[(i41 >>> 16) & 255]) ^ iArr4[(i5 >>> 8) & 255]) ^ iArr5[i6 & 255]) ^ iArr[16];
                    int i43 = iArr[17] ^ (((iArr2[i6 >>> 24] ^ iArr3[(i7 >>> 16) & 255]) ^ iArr4[(i41 >>> 8) & 255]) ^ iArr5[i5 & 255]);
                    int i44 = (((iArr2[i5 >>> 24] ^ iArr3[(i6 >>> 16) & 255]) ^ iArr4[(i7 >>> 8) & 255]) ^ iArr5[i41 & 255]) ^ iArr[18];
                    int i45 = (((iArr2[i41 >>> 24] ^ iArr3[(i5 >>> 16) & 255]) ^ iArr4[(i6 >>> 8) & 255]) ^ iArr5[i7 & 255]) ^ iArr[19];
                    i7 = iArr[20] ^ (((iArr2[i42 >>> 24] ^ iArr3[(i45 >>> 16) & 255]) ^ iArr4[(i44 >>> 8) & 255]) ^ iArr5[i43 & 255]);
                    i6 = (((iArr2[i43 >>> 24] ^ iArr3[(i42 >>> 16) & 255]) ^ iArr4[(i45 >>> 8) & 255]) ^ iArr5[i44 & 255]) ^ iArr[21];
                    i5 = (((iArr2[i44 >>> 24] ^ iArr3[(i43 >>> 16) & 255]) ^ iArr4[(i42 >>> 8) & 255]) ^ iArr5[i45 & 255]) ^ iArr[22];
                    i4 = (((iArr2[i45 >>> 24] ^ iArr3[(i44 >>> 16) & 255]) ^ iArr4[(i43 >>> 8) & 255]) ^ iArr5[i42 & 255]) ^ iArr[23];
                    i8 = 24;
                } else {
                    i4 = i41;
                    i8 = 16;
                }
            } else {
                i4 = i32;
                i5 = i29;
                i6 = i22;
                i7 = i15;
                i8 = 8;
            }
            int[] iArr6 = o;
            int i46 = iArr6[i7 >>> 24];
            int[] iArr7 = p;
            int i47 = i46 ^ iArr7[(i4 >>> 16) & 255];
            int[] iArr8 = q;
            int i48 = i47 ^ iArr8[(i5 >>> 8) & 255];
            int[] iArr9 = r;
            int i49 = i48 ^ iArr9[i6 & 255];
            int[] iArr10 = this.f45909e;
            int i50 = i8 + 1;
            int i51 = iArr10[i8] ^ i49;
            int i52 = i50 + 1;
            int i53 = (((iArr6[i6 >>> 24] ^ iArr7[(i7 >>> 16) & 255]) ^ iArr8[(i4 >>> 8) & 255]) ^ iArr9[i5 & 255]) ^ iArr10[i50];
            int i54 = i52 + 1;
            int i55 = (((iArr6[i5 >>> 24] ^ iArr7[(i6 >>> 16) & 255]) ^ iArr8[(i7 >>> 8) & 255]) ^ iArr9[i4 & 255]) ^ iArr10[i52];
            int i56 = ((iArr6[i4 >>> 24] ^ iArr7[(i5 >>> 16) & 255]) ^ iArr8[(i6 >>> 8) & 255]) ^ iArr9[i7 & 255];
            int i57 = i54 + 1;
            int i58 = i56 ^ iArr10[i54];
            int i59 = i57 + 1;
            int i60 = iArr10[i57] ^ (((iArr6[i51 >>> 24] ^ iArr7[(i58 >>> 16) & 255]) ^ iArr8[(i55 >>> 8) & 255]) ^ iArr9[i53 & 255]);
            int i61 = i59 + 1;
            int i62 = (((iArr6[i53 >>> 24] ^ iArr7[(i51 >>> 16) & 255]) ^ iArr8[(i58 >>> 8) & 255]) ^ iArr9[i55 & 255]) ^ iArr10[i59];
            int i63 = i61 + 1;
            int i64 = (((iArr6[i55 >>> 24] ^ iArr7[(i53 >>> 16) & 255]) ^ iArr8[(i51 >>> 8) & 255]) ^ iArr9[i58 & 255]) ^ iArr10[i61];
            int i65 = iArr9[i51 & 255] ^ ((iArr6[i58 >>> 24] ^ iArr7[(i55 >>> 16) & 255]) ^ iArr8[(i53 >>> 8) & 255]);
            int i66 = i63 + 1;
            int i67 = i65 ^ iArr10[i63];
            int i68 = i66 + 1;
            int i69 = iArr10[i66] ^ (((iArr6[i60 >>> 24] ^ iArr7[(i67 >>> 16) & 255]) ^ iArr8[(i64 >>> 8) & 255]) ^ iArr9[i62 & 255]);
            int i70 = i68 + 1;
            int i71 = (((iArr6[i62 >>> 24] ^ iArr7[(i60 >>> 16) & 255]) ^ iArr8[(i67 >>> 8) & 255]) ^ iArr9[i64 & 255]) ^ iArr10[i68];
            int i72 = i70 + 1;
            int i73 = (((iArr6[i64 >>> 24] ^ iArr7[(i62 >>> 16) & 255]) ^ iArr8[(i60 >>> 8) & 255]) ^ iArr9[i67 & 255]) ^ iArr10[i70];
            int i74 = ((iArr6[i67 >>> 24] ^ iArr7[(i64 >>> 16) & 255]) ^ iArr8[(i62 >>> 8) & 255]) ^ iArr9[i60 & 255];
            int i75 = i72 + 1;
            int i76 = i74 ^ iArr10[i72];
            int i77 = i75 + 1;
            int i78 = iArr10[i75] ^ (((iArr6[i69 >>> 24] ^ iArr7[(i76 >>> 16) & 255]) ^ iArr8[(i73 >>> 8) & 255]) ^ iArr9[i71 & 255]);
            int i79 = i77 + 1;
            int i80 = (((iArr6[i71 >>> 24] ^ iArr7[(i69 >>> 16) & 255]) ^ iArr8[(i76 >>> 8) & 255]) ^ iArr9[i73 & 255]) ^ iArr10[i77];
            int i81 = i79 + 1;
            int i82 = (((iArr6[i73 >>> 24] ^ iArr7[(i71 >>> 16) & 255]) ^ iArr8[(i69 >>> 8) & 255]) ^ iArr9[i76 & 255]) ^ iArr10[i79];
            int i83 = ((iArr6[i76 >>> 24] ^ iArr7[(i73 >>> 16) & 255]) ^ iArr8[(i71 >>> 8) & 255]) ^ iArr9[i69 & 255];
            int i84 = i81 + 1;
            int i85 = i83 ^ iArr10[i81];
            int i86 = i84 + 1;
            int i87 = iArr10[i84] ^ (((iArr6[i78 >>> 24] ^ iArr7[(i85 >>> 16) & 255]) ^ iArr8[(i82 >>> 8) & 255]) ^ iArr9[i80 & 255]);
            int i88 = i86 + 1;
            int i89 = (((iArr6[i80 >>> 24] ^ iArr7[(i78 >>> 16) & 255]) ^ iArr8[(i85 >>> 8) & 255]) ^ iArr9[i82 & 255]) ^ iArr10[i86];
            int i90 = i88 + 1;
            int i91 = (((iArr6[i82 >>> 24] ^ iArr7[(i80 >>> 16) & 255]) ^ iArr8[(i78 >>> 8) & 255]) ^ iArr9[i85 & 255]) ^ iArr10[i88];
            int i92 = ((iArr6[i85 >>> 24] ^ iArr7[(i82 >>> 16) & 255]) ^ iArr8[(i80 >>> 8) & 255]) ^ iArr9[i78 & 255];
            int i93 = i90 + 1;
            int i94 = i92 ^ iArr10[i90];
            int i95 = i93 + 1;
            int i96 = iArr10[i93] ^ (((iArr6[i87 >>> 24] ^ iArr7[(i94 >>> 16) & 255]) ^ iArr8[(i91 >>> 8) & 255]) ^ iArr9[i89 & 255]);
            int i97 = i95 + 1;
            int i98 = (((iArr6[i89 >>> 24] ^ iArr7[(i87 >>> 16) & 255]) ^ iArr8[(i94 >>> 8) & 255]) ^ iArr9[i91 & 255]) ^ iArr10[i95];
            int i99 = i97 + 1;
            int i100 = (((iArr6[i91 >>> 24] ^ iArr7[(i89 >>> 16) & 255]) ^ iArr8[(i87 >>> 8) & 255]) ^ iArr9[i94 & 255]) ^ iArr10[i97];
            int i101 = ((iArr6[i94 >>> 24] ^ iArr7[(i91 >>> 16) & 255]) ^ iArr8[(i89 >>> 8) & 255]) ^ iArr9[i87 & 255];
            int i102 = i99 + 1;
            int i103 = i101 ^ iArr10[i99];
            int i104 = i102 + 1;
            int i105 = iArr10[i102] ^ (((iArr6[i96 >>> 24] ^ iArr7[(i103 >>> 16) & 255]) ^ iArr8[(i100 >>> 8) & 255]) ^ iArr9[i98 & 255]);
            int i106 = i104 + 1;
            int i107 = (((iArr6[i98 >>> 24] ^ iArr7[(i96 >>> 16) & 255]) ^ iArr8[(i103 >>> 8) & 255]) ^ iArr9[i100 & 255]) ^ iArr10[i104];
            int i108 = i106 + 1;
            int i109 = (((iArr6[i100 >>> 24] ^ iArr7[(i98 >>> 16) & 255]) ^ iArr8[(i96 >>> 8) & 255]) ^ iArr9[i103 & 255]) ^ iArr10[i106];
            int i110 = ((iArr6[i103 >>> 24] ^ iArr7[(i100 >>> 16) & 255]) ^ iArr8[(i98 >>> 8) & 255]) ^ iArr9[i96 & 255];
            int i111 = i108 + 1;
            int i112 = i110 ^ iArr10[i108];
            int i113 = i111 + 1;
            int i114 = iArr10[i111] ^ (((iArr6[i105 >>> 24] ^ iArr7[(i112 >>> 16) & 255]) ^ iArr8[(i109 >>> 8) & 255]) ^ iArr9[i107 & 255]);
            int i115 = i113 + 1;
            int i116 = (((iArr6[i107 >>> 24] ^ iArr7[(i105 >>> 16) & 255]) ^ iArr8[(i112 >>> 8) & 255]) ^ iArr9[i109 & 255]) ^ iArr10[i113];
            int i117 = i115 + 1;
            int i118 = (((iArr6[i109 >>> 24] ^ iArr7[(i107 >>> 16) & 255]) ^ iArr8[(i105 >>> 8) & 255]) ^ iArr9[i112 & 255]) ^ iArr10[i115];
            int i119 = ((iArr6[i112 >>> 24] ^ iArr7[(i109 >>> 16) & 255]) ^ iArr8[(i107 >>> 8) & 255]) ^ iArr9[i105 & 255];
            int i120 = i117 + 1;
            int i121 = i119 ^ iArr10[i117];
            int i122 = i120 + 1;
            int i123 = iArr10[i120] ^ (((iArr6[i114 >>> 24] ^ iArr7[(i121 >>> 16) & 255]) ^ iArr8[(i118 >>> 8) & 255]) ^ iArr9[i116 & 255]);
            int i124 = i122 + 1;
            int i125 = (((iArr6[i116 >>> 24] ^ iArr7[(i114 >>> 16) & 255]) ^ iArr8[(i121 >>> 8) & 255]) ^ iArr9[i118 & 255]) ^ iArr10[i122];
            int i126 = (((iArr6[i118 >>> 24] ^ iArr7[(i116 >>> 16) & 255]) ^ iArr8[(i114 >>> 8) & 255]) ^ iArr9[i121 & 255]) ^ iArr10[i124];
            int i127 = (((iArr6[i121 >>> 24] ^ iArr7[(i118 >>> 16) & 255]) ^ iArr8[(i116 >>> 8) & 255]) ^ iArr9[i114 & 255]) ^ iArr10[i124 + 1];
            int i128 = iArr10[0];
            int i129 = i3 + 1;
            byte[] bArr3 = j;
            bArr2[i3] = (byte) (bArr3[i123 >>> 24] ^ (i128 >>> 24));
            int i130 = i129 + 1;
            bArr2[i129] = (byte) (bArr3[(i127 >>> 16) & 255] ^ (i128 >>> 16));
            int i131 = i130 + 1;
            bArr2[i130] = (byte) (bArr3[(i126 >>> 8) & 255] ^ (i128 >>> 8));
            int i132 = i131 + 1;
            bArr2[i131] = (byte) (i128 ^ bArr3[i125 & 255]);
            int i133 = iArr10[1];
            int i134 = i132 + 1;
            bArr2[i132] = (byte) (bArr3[i125 >>> 24] ^ (i133 >>> 24));
            int i135 = i134 + 1;
            bArr2[i134] = (byte) (bArr3[(i123 >>> 16) & 255] ^ (i133 >>> 16));
            int i136 = i135 + 1;
            bArr2[i135] = (byte) (bArr3[(i127 >>> 8) & 255] ^ (i133 >>> 8));
            int i137 = i136 + 1;
            bArr2[i136] = (byte) (i133 ^ bArr3[i126 & 255]);
            int i138 = iArr10[2];
            int i139 = i137 + 1;
            bArr2[i137] = (byte) (bArr3[i126 >>> 24] ^ (i138 >>> 24));
            int i140 = i139 + 1;
            bArr2[i139] = (byte) (bArr3[(i125 >>> 16) & 255] ^ (i138 >>> 16));
            int i141 = i140 + 1;
            bArr2[i140] = (byte) (bArr3[(i123 >>> 8) & 255] ^ (i138 >>> 8));
            int i142 = i141 + 1;
            bArr2[i141] = (byte) (i138 ^ bArr3[i127 & 255]);
            int i143 = iArr10[3];
            int i144 = i142 + 1;
            bArr2[i142] = (byte) (bArr3[i127 >>> 24] ^ (i143 >>> 24));
            int i145 = i144 + 1;
            bArr2[i144] = (byte) (bArr3[(i126 >>> 16) & 255] ^ (i143 >>> 16));
            bArr2[i145] = (byte) (bArr3[(i125 >>> 8) & 255] ^ (i143 >>> 8));
            bArr2[i145 + 1] = (byte) (bArr3[i123 & 255] ^ i143);
        }
    }
}
