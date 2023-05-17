package com.heytap.mcssdk.a;

import androidx.core.view.InputDeviceCompat;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.Base64;
import com.google.android.exoplayer2.text.cea.Cea608Decoder;
import java.math.BigInteger;
import org.apache.commons.codec.binary.StringUtils;
import org.apache.commons.codec.net.QCodec;
/* loaded from: classes9.dex */
public class a extends b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final byte[] a;
    public static final int m = 6;
    public static final int n = 3;
    public static final int o = 4;
    public static final byte[] p;
    public static final byte[] q;
    public static final byte[] r;
    public static final int s = 63;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] t;
    public final byte[] u;
    public final byte[] v;
    public final int w;
    public final int x;
    public int y;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-964158132, "Lcom/heytap/mcssdk/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-964158132, "Lcom/heytap/mcssdk/a/a;");
                return;
            }
        }
        a = new byte[]{13, 10};
        p = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
        q = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, QCodec.UNDERSCORE};
        r = new byte[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, Constants.GZIP_CAST_TYPE, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, Base64.INTERNAL_PADDING, Cea608Decoder.CTRL_DELETE_TO_END_OF_ROW, 37, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_3_ROWS, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_4_ROWS, 40, Cea608Decoder.CTRL_RESUME_DIRECT_CAPTIONING, ExifInterface.START_CODE, 43, Cea608Decoder.CTRL_ERASE_DISPLAYED_MEMORY, 45, Cea608Decoder.CTRL_ERASE_NON_DISPLAYED_MEMORY, 47, 48, 49, 50, 51};
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a() {
        this(0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(int i) {
        this(i, a);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), (byte[]) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(int i, byte[] bArr) {
        this(i, bArr, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), bArr};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), (byte[]) objArr2[1], ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public a(int i, byte[] bArr, boolean z) {
        super(3, 4, i, bArr == null ? 0 : bArr.length);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), bArr, Boolean.valueOf(z)};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.u = r;
        if (bArr != null) {
            if (l(bArr)) {
                String newStringUtf8 = StringUtils.newStringUtf8(bArr);
                throw new IllegalArgumentException("lineSeparator must not contain base64 characters: [" + newStringUtf8 + PreferencesUtil.RIGHT_MOUNT);
            } else if (i > 0) {
                this.x = bArr.length + 4;
                byte[] bArr2 = new byte[bArr.length];
                this.v = bArr2;
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                this.w = this.x - 1;
                this.t = !z ? q : p;
            }
        }
        this.x = 4;
        this.v = null;
        this.w = this.x - 1;
        this.t = !z ? q : p;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(boolean z) {
        this(76, a, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65541, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), (byte[]) objArr2[1], ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65541, newInitContext);
                return;
            }
        }
    }

    public static boolean a(byte b) {
        InterceptResult invokeB;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeB = interceptable.invokeB(65542, null, b)) == null) {
            if (b != 61) {
                if (b >= 0) {
                    byte[] bArr = r;
                    if (b >= bArr.length || bArr[b] == -1) {
                    }
                }
                return false;
            }
            return true;
        }
        return invokeB.booleanValue;
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) ? b(StringUtils.getBytesUtf8(str)) : invokeL.booleanValue;
    }

    public static boolean a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, bArr)) == null) ? b(bArr) : invokeL.booleanValue;
    }

    public static byte[] a(BigInteger bigInteger) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, bigInteger)) == null) {
            if (bigInteger != null) {
                return a(b(bigInteger), false);
            }
            throw new NullPointerException("encodeInteger called with null parameter");
        }
        return (byte[]) invokeL.objValue;
    }

    public static byte[] a(byte[] bArr, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(65546, null, bArr, z)) == null) ? a(bArr, z, false) : (byte[]) invokeLZ.objValue;
    }

    public static byte[] a(byte[] bArr, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{bArr, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? a(bArr, z, z2, Integer.MAX_VALUE) : (byte[]) invokeCommon.objValue;
    }

    public static byte[] a(byte[] bArr, boolean z, boolean z2, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{bArr, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i)})) == null) {
            if (bArr == null || bArr.length == 0) {
                return bArr;
            }
            a aVar = z ? new a(z2) : new a(0, a, z2);
            long m2 = aVar.m(bArr);
            if (m2 <= i) {
                return aVar.encode(bArr);
            }
            throw new IllegalArgumentException("Input array too big, the output array would be bigger (" + m2 + ") than the specified maximum size of " + i);
        }
        return (byte[]) invokeCommon.objValue;
    }

    public static boolean b(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, bArr)) == null) {
            for (int i = 0; i < bArr.length; i++) {
                if (!a(bArr[i]) && !b.c(bArr[i])) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static byte[] b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65550, null, str)) == null) ? new a().c(str) : (byte[]) invokeL.objValue;
    }

    public static byte[] b(BigInteger bigInteger) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, bigInteger)) == null) {
            int bitLength = ((bigInteger.bitLength() + 7) >> 3) << 3;
            byte[] byteArray = bigInteger.toByteArray();
            int i = 1;
            if (bigInteger.bitLength() % 8 == 0 || (bigInteger.bitLength() / 8) + 1 != bitLength / 8) {
                int length = byteArray.length;
                if (bigInteger.bitLength() % 8 == 0) {
                    length--;
                } else {
                    i = 0;
                }
                int i2 = bitLength / 8;
                int i3 = i2 - length;
                byte[] bArr = new byte[i2];
                System.arraycopy(byteArray, i, bArr, i3, length);
                return bArr;
            }
            return byteArray;
        }
        return (byte[]) invokeL.objValue;
    }

    public static byte[] c(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65552, null, bArr)) == null) ? a(bArr, false) : (byte[]) invokeL.objValue;
    }

    public static String d(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65553, null, bArr)) == null) ? StringUtils.newStringUtf8(a(bArr, false)) : (String) invokeL.objValue;
    }

    public static byte[] e(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65554, null, bArr)) == null) ? a(bArr, false, true) : (byte[]) invokeL.objValue;
    }

    public static String f(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65555, null, bArr)) == null) ? StringUtils.newStringUtf8(a(bArr, false, true)) : (String) invokeL.objValue;
    }

    public static byte[] g(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65556, null, bArr)) == null) ? a(bArr, true) : (byte[]) invokeL.objValue;
    }

    public static byte[] h(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65557, null, bArr)) == null) ? new a().decode(bArr) : (byte[]) invokeL.objValue;
    }

    public static BigInteger i(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65558, null, bArr)) == null) ? new BigInteger(1, h(bArr)) : (BigInteger) invokeL.objValue;
    }

    @Override // com.heytap.mcssdk.a.b
    public void a(byte[] bArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048576, this, bArr, i, i2) == null) || this.j) {
            return;
        }
        if (i2 >= 0) {
            int i3 = 0;
            while (i3 < i2) {
                a(this.x);
                this.l = (this.l + 1) % 3;
                int i4 = i + 1;
                int i5 = bArr[i];
                if (i5 < 0) {
                    i5 += 256;
                }
                int i6 = (this.y << 8) + i5;
                this.y = i6;
                if (this.l == 0) {
                    byte[] bArr2 = this.h;
                    int i7 = this.i;
                    int i8 = i7 + 1;
                    this.i = i8;
                    byte[] bArr3 = this.t;
                    bArr2[i7] = bArr3[(i6 >> 18) & 63];
                    int i9 = i8 + 1;
                    this.i = i9;
                    bArr2[i8] = bArr3[(i6 >> 12) & 63];
                    int i10 = i9 + 1;
                    this.i = i10;
                    bArr2[i9] = bArr3[(i6 >> 6) & 63];
                    int i11 = i10 + 1;
                    this.i = i11;
                    bArr2[i10] = bArr3[i6 & 63];
                    int i12 = this.k + 4;
                    this.k = i12;
                    int i13 = this.g;
                    if (i13 > 0 && i13 <= i12) {
                        byte[] bArr4 = this.v;
                        System.arraycopy(bArr4, 0, bArr2, i11, bArr4.length);
                        this.i += this.v.length;
                        this.k = 0;
                    }
                }
                i3++;
                i = i4;
            }
            return;
        }
        this.j = true;
        if (this.l == 0 && this.g == 0) {
            return;
        }
        a(this.x);
        int i14 = this.i;
        int i15 = this.l;
        if (i15 == 1) {
            byte[] bArr5 = this.h;
            int i16 = i14 + 1;
            this.i = i16;
            byte[] bArr6 = this.t;
            int i17 = this.y;
            bArr5[i14] = bArr6[(i17 >> 2) & 63];
            int i18 = i16 + 1;
            this.i = i18;
            bArr5[i16] = bArr6[(i17 << 4) & 63];
            if (bArr6 == p) {
                int i19 = i18 + 1;
                this.i = i19;
                bArr5[i18] = 61;
                this.i = i19 + 1;
                bArr5[i19] = 61;
            }
        } else if (i15 == 2) {
            byte[] bArr7 = this.h;
            int i20 = i14 + 1;
            this.i = i20;
            byte[] bArr8 = this.t;
            int i21 = this.y;
            bArr7[i14] = bArr8[(i21 >> 10) & 63];
            int i22 = i20 + 1;
            this.i = i22;
            bArr7[i20] = bArr8[(i21 >> 4) & 63];
            int i23 = i22 + 1;
            this.i = i23;
            bArr7[i22] = bArr8[(i21 << 2) & 63];
            if (bArr8 == p) {
                this.i = i23 + 1;
                bArr7[i23] = 61;
            }
        }
        int i24 = this.k;
        int i25 = this.i;
        int i26 = i24 + (i25 - i14);
        this.k = i26;
        if (this.g <= 0 || i26 <= 0) {
            return;
        }
        byte[] bArr9 = this.v;
        System.arraycopy(bArr9, 0, this.h, i25, bArr9.length);
        this.i += this.v.length;
    }

    /* JADX DEBUG: Possible override for method com.heytap.mcssdk.a.b.a()V */
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.t == q : invokeV.booleanValue;
    }

    @Override // com.heytap.mcssdk.a.b
    public void b(byte[] bArr, int i, int i2) {
        byte b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, bArr, i, i2) == null) || this.j) {
            return;
        }
        if (i2 < 0) {
            this.j = true;
        }
        int i3 = 0;
        while (true) {
            if (i3 >= i2) {
                break;
            }
            a(this.w);
            int i4 = i + 1;
            byte b2 = bArr[i];
            if (b2 == 61) {
                this.j = true;
                break;
            }
            if (b2 >= 0) {
                byte[] bArr2 = r;
                if (b2 < bArr2.length && (b = bArr2[b2]) >= 0) {
                    int i5 = (this.l + 1) % 4;
                    this.l = i5;
                    int i6 = (this.y << 6) + b;
                    this.y = i6;
                    if (i5 == 0) {
                        byte[] bArr3 = this.h;
                        int i7 = this.i;
                        int i8 = i7 + 1;
                        this.i = i8;
                        bArr3[i7] = (byte) ((i6 >> 16) & 255);
                        int i9 = i8 + 1;
                        this.i = i9;
                        bArr3[i8] = (byte) ((i6 >> 8) & 255);
                        this.i = i9 + 1;
                        bArr3[i9] = (byte) (i6 & 255);
                    }
                }
            }
            i3++;
            i = i4;
        }
        if (!this.j || this.l == 0) {
            return;
        }
        a(this.w);
        int i10 = this.l;
        if (i10 == 2) {
            int i11 = this.y >> 4;
            this.y = i11;
            byte[] bArr4 = this.h;
            int i12 = this.i;
            this.i = i12 + 1;
            bArr4[i12] = (byte) (i11 & 255);
        } else if (i10 != 3) {
        } else {
            int i13 = this.y >> 2;
            this.y = i13;
            byte[] bArr5 = this.h;
            int i14 = this.i;
            int i15 = i14 + 1;
            this.i = i15;
            bArr5[i14] = (byte) ((i13 >> 8) & 255);
            this.i = i15 + 1;
            bArr5[i15] = (byte) (i13 & 255);
        }
    }

    @Override // com.heytap.mcssdk.a.b
    public boolean b(byte b) {
        InterceptResult invokeB;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeB = interceptable.invokeB(1048579, this, b)) == null) {
            if (b >= 0) {
                byte[] bArr = this.u;
                if (b < bArr.length && bArr[b] != -1) {
                    return true;
                }
            }
            return false;
        }
        return invokeB.booleanValue;
    }
}
