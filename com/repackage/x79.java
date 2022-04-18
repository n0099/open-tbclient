package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.logsystem.basic.upload.ContentUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.Base64;
import com.google.android.exoplayer2.text.cea.Cea608Decoder;
import com.kwad.yoga.YogaNodeJNIBase;
import com.repackage.y79;
import org.apache.commons.codec.binary4util.BaseNCodec;
/* loaded from: classes7.dex */
public class x79 extends y79 {
    public static /* synthetic */ Interceptable $ic;
    public static final byte[] j;
    public static final byte[] k;
    public static final byte[] l;
    public static final byte[] m;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] e;
    public final byte[] f;
    public final byte[] g;
    public final int h;
    public final int i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755218537, "Lcom/repackage/x79;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755218537, "Lcom/repackage/x79;");
                return;
            }
        }
        j = new byte[]{13, 10};
        k = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, ContentUtil.GZIP_HEAD_1, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, Cea608Decoder.CTRL_END_OF_CAPTION};
        l = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, ContentUtil.GZIP_HEAD_1, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
        m = new byte[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, BaseNCodec.PAD_DEFAULT, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, Constants.GZIP_CAST_TYPE, 12, 13, YogaNodeJNIBase.LAYOUT_BORDER_START_INDEX, 15, YogaNodeJNIBase.HAS_NEW_LAYOUT, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, Base64.INTERNAL_PADDING, Cea608Decoder.CTRL_DELETE_TO_END_OF_ROW, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_2_ROWS, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_3_ROWS, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_4_ROWS, 40, Cea608Decoder.CTRL_RESUME_DIRECT_CAPTIONING, 42, 43, Cea608Decoder.CTRL_ERASE_DISPLAYED_MEMORY, 45, Cea608Decoder.CTRL_ERASE_NON_DISPLAYED_MEMORY, Cea608Decoder.CTRL_END_OF_CAPTION, 48, 49, 50, 51};
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public x79() {
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

    public static byte[] n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) ? new x79().d(str) : (byte[]) invokeL.objValue;
    }

    public static byte[] o(byte[] bArr, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(65543, null, bArr, z)) == null) ? p(bArr, z, false) : (byte[]) invokeLZ.objValue;
    }

    public static byte[] p(byte[] bArr, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{bArr, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? q(bArr, z, z2, Integer.MAX_VALUE) : (byte[]) invokeCommon.objValue;
    }

    public static byte[] q(byte[] bArr, boolean z, boolean z2, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{bArr, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i)})) == null) {
            if (bArr == null || bArr.length == 0) {
                return bArr;
            }
            x79 x79Var = z ? new x79(z2) : new x79(0, j, z2);
            long j2 = x79Var.j(bArr);
            if (j2 <= i) {
                return x79Var.g(bArr);
            }
            throw new IllegalArgumentException("Input array too big, the output array would be bigger (" + j2 + ") than the specified maximum size of " + i);
        }
        return (byte[]) invokeCommon.objValue;
    }

    public static String r(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, bArr)) == null) ? a89.d(o(bArr, false)) : (String) invokeL.objValue;
    }

    @Override // com.repackage.y79
    public void c(byte[] bArr, int i, int i2, y79.a aVar) {
        byte b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{bArr, Integer.valueOf(i), Integer.valueOf(i2), aVar}) == null) || aVar.f) {
            return;
        }
        if (i2 < 0) {
            aVar.f = true;
        }
        int i3 = 0;
        while (true) {
            if (i3 >= i2) {
                break;
            }
            byte[] h = h(this.h, aVar);
            int i4 = i + 1;
            byte b2 = bArr[i];
            if (b2 == 61) {
                aVar.f = true;
                break;
            }
            if (b2 >= 0) {
                byte[] bArr2 = m;
                if (b2 < bArr2.length && (b = bArr2[b2]) >= 0) {
                    int i5 = (aVar.h + 1) % 4;
                    aVar.h = i5;
                    int i6 = (aVar.a << 6) + b;
                    aVar.a = i6;
                    if (i5 == 0) {
                        int i7 = aVar.d;
                        int i8 = i7 + 1;
                        aVar.d = i8;
                        h[i7] = (byte) ((i6 >> 16) & 255);
                        int i9 = i8 + 1;
                        aVar.d = i9;
                        h[i8] = (byte) ((i6 >> 8) & 255);
                        aVar.d = i9 + 1;
                        h[i9] = (byte) (i6 & 255);
                    }
                }
            }
            i3++;
            i = i4;
        }
        if (!aVar.f || aVar.h == 0) {
            return;
        }
        byte[] h2 = h(this.h, aVar);
        int i10 = aVar.h;
        if (i10 != 1) {
            if (i10 == 2) {
                int i11 = aVar.a >> 4;
                aVar.a = i11;
                int i12 = aVar.d;
                aVar.d = i12 + 1;
                h2[i12] = (byte) (i11 & 255);
            } else if (i10 == 3) {
                int i13 = aVar.a >> 2;
                aVar.a = i13;
                int i14 = aVar.d;
                int i15 = i14 + 1;
                aVar.d = i15;
                h2[i14] = (byte) ((i13 >> 8) & 255);
                aVar.d = i15 + 1;
                h2[i15] = (byte) (i13 & 255);
            } else {
                throw new IllegalStateException("Impossible modulus " + aVar.h);
            }
        }
    }

    @Override // com.repackage.y79
    public void f(byte[] bArr, int i, int i2, y79.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{bArr, Integer.valueOf(i), Integer.valueOf(i2), aVar}) == null) || aVar.f) {
            return;
        }
        if (i2 >= 0) {
            int i3 = 0;
            while (i3 < i2) {
                byte[] h = h(this.i, aVar);
                aVar.h = (aVar.h + 1) % 3;
                int i4 = i + 1;
                int i5 = bArr[i];
                if (i5 < 0) {
                    i5 += 256;
                }
                int i6 = (aVar.a << 8) + i5;
                aVar.a = i6;
                if (aVar.h == 0) {
                    int i7 = aVar.d;
                    int i8 = i7 + 1;
                    aVar.d = i8;
                    byte[] bArr2 = this.e;
                    h[i7] = bArr2[(i6 >> 18) & 63];
                    int i9 = i8 + 1;
                    aVar.d = i9;
                    h[i8] = bArr2[(i6 >> 12) & 63];
                    int i10 = i9 + 1;
                    aVar.d = i10;
                    h[i9] = bArr2[(i6 >> 6) & 63];
                    int i11 = i10 + 1;
                    aVar.d = i11;
                    h[i10] = bArr2[i6 & 63];
                    int i12 = aVar.g + 4;
                    aVar.g = i12;
                    int i13 = this.c;
                    if (i13 > 0 && i13 <= i12) {
                        byte[] bArr3 = this.g;
                        System.arraycopy(bArr3, 0, h, i11, bArr3.length);
                        aVar.d += this.g.length;
                        aVar.g = 0;
                    }
                }
                i3++;
                i = i4;
            }
            return;
        }
        aVar.f = true;
        if (aVar.h == 0 && this.c == 0) {
            return;
        }
        byte[] h2 = h(this.i, aVar);
        int i14 = aVar.d;
        int i15 = aVar.h;
        if (i15 != 0) {
            if (i15 == 1) {
                int i16 = i14 + 1;
                aVar.d = i16;
                byte[] bArr4 = this.e;
                int i17 = aVar.a;
                h2[i14] = bArr4[(i17 >> 2) & 63];
                int i18 = i16 + 1;
                aVar.d = i18;
                h2[i16] = bArr4[(i17 << 4) & 63];
                if (bArr4 == k) {
                    int i19 = i18 + 1;
                    aVar.d = i19;
                    h2[i18] = BaseNCodec.PAD_DEFAULT;
                    aVar.d = i19 + 1;
                    h2[i19] = BaseNCodec.PAD_DEFAULT;
                }
            } else if (i15 == 2) {
                int i20 = i14 + 1;
                aVar.d = i20;
                byte[] bArr5 = this.e;
                int i21 = aVar.a;
                h2[i14] = bArr5[(i21 >> 10) & 63];
                int i22 = i20 + 1;
                aVar.d = i22;
                h2[i20] = bArr5[(i21 >> 4) & 63];
                int i23 = i22 + 1;
                aVar.d = i23;
                h2[i22] = bArr5[(i21 << 2) & 63];
                if (bArr5 == k) {
                    aVar.d = i23 + 1;
                    h2[i23] = BaseNCodec.PAD_DEFAULT;
                }
            } else {
                throw new IllegalStateException("Impossible modulus " + aVar.h);
            }
        }
        int i24 = aVar.g;
        int i25 = aVar.d;
        int i26 = i24 + (i25 - i14);
        aVar.g = i26;
        if (this.c <= 0 || i26 <= 0) {
            return;
        }
        byte[] bArr6 = this.g;
        System.arraycopy(bArr6, 0, h2, i25, bArr6.length);
        aVar.d += this.g.length;
    }

    @Override // com.repackage.y79
    public boolean k(byte b) {
        InterceptResult invokeB;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeB = interceptable.invokeB(Constants.METHOD_SEND_USER_MSG, this, b)) == null) {
            if (b >= 0) {
                byte[] bArr = this.f;
                if (b < bArr.length && bArr[b] != -1) {
                    return true;
                }
            }
            return false;
        }
        return invokeB.booleanValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public x79(boolean z) {
        this(76, j, z);
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

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public x79(int i) {
        this(i, j);
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
    public x79(int i, byte[] bArr) {
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
    public x79(int i, byte[] bArr, boolean z) {
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
        this.f = m;
        if (bArr != null) {
            if (b(bArr)) {
                String d = a89.d(bArr);
                throw new IllegalArgumentException("lineSeparator must not contain base64 characters: [" + d + PreferencesUtil.RIGHT_MOUNT);
            } else if (i > 0) {
                this.i = bArr.length + 4;
                byte[] bArr2 = new byte[bArr.length];
                this.g = bArr2;
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            } else {
                this.i = 4;
                this.g = null;
            }
        } else {
            this.i = 4;
            this.g = null;
        }
        this.h = this.i - 1;
        this.e = z ? l : k;
    }
}
