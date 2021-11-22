package org.apache.commons.codec.binary4util;

import android.annotation.SuppressLint;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.utils.UtilsBlink;
import io.flutter.plugin.common.StandardMessageCodec;
import java.math.BigInteger;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import org.apache.commons.codec.binary4util.BaseNCodec;
@SuppressLint({"BDThrowableCheck"})
/* loaded from: classes3.dex */
public class Base64 extends BaseNCodec {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BITS_PER_ENCODED_BYTE = 6;
    public static final int BYTES_PER_ENCODED_BLOCK = 4;
    public static final int BYTES_PER_UNENCODED_BLOCK = 3;
    public static final byte[] CHUNK_SEPARATOR;
    public static final byte[] DECODE_TABLE;
    public static final int MASK_6BITS = 63;
    public static final byte[] STANDARD_ENCODE_TABLE;
    public static final byte[] URL_SAFE_ENCODE_TABLE;
    public transient /* synthetic */ FieldHolder $fh;
    public final int decodeSize;
    public final byte[] decodeTable;
    public final int encodeSize;
    public final byte[] encodeTable;
    public final byte[] lineSeparator;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-878726872, "Lorg/apache/commons/codec/binary4util/Base64;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-878726872, "Lorg/apache/commons/codec/binary4util/Base64;");
                return;
            }
        }
        CHUNK_SEPARATOR = new byte[]{13, 10};
        STANDARD_ENCODE_TABLE = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
        URL_SAFE_ENCODE_TABLE = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, UtilsBlink.VER_TYPE_SEPARATOR, 95};
        DECODE_TABLE = new byte[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, StandardMessageCodec.LIST, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, PublicSuffixDatabase.EXCEPTION_MARKER, 34, com.baidu.webkit.internal.Base64.INTERNAL_PADDING, 36, 37, 38, 39, 40, 41, 42, 43, 44, UtilsBlink.VER_TYPE_SEPARATOR, 46, 47, 48, 49, 50, 51};
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Base64() {
        this(0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static byte[] decodeBase64(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) ? new Base64().decode(str) : (byte[]) invokeL.objValue;
    }

    public static BigInteger decodeInteger(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, bArr)) == null) ? new BigInteger(1, decodeBase64(bArr)) : (BigInteger) invokeL.objValue;
    }

    public static byte[] encodeBase64(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, bArr)) == null) ? encodeBase64(bArr, false) : (byte[]) invokeL.objValue;
    }

    public static byte[] encodeBase64Chunked(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, bArr)) == null) ? encodeBase64(bArr, true) : (byte[]) invokeL.objValue;
    }

    public static String encodeBase64String(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65550, null, bArr)) == null) ? org.apache.commons.base.binary4util.CodecStringUtils.newStringUsAscii(encodeBase64(bArr, false)) : (String) invokeL.objValue;
    }

    public static byte[] encodeBase64URLSafe(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65551, null, bArr)) == null) ? encodeBase64(bArr, false, true) : (byte[]) invokeL.objValue;
    }

    public static String encodeBase64URLSafeString(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65552, null, bArr)) == null) ? org.apache.commons.base.binary4util.CodecStringUtils.newStringUsAscii(encodeBase64(bArr, false, true)) : (String) invokeL.objValue;
    }

    public static byte[] encodeInteger(BigInteger bigInteger) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, bigInteger)) == null) {
            if (bigInteger != null) {
                return encodeBase64(toIntegerBytes(bigInteger), false);
            }
            throw new NullPointerException("encodeInteger called with null parameter");
        }
        return (byte[]) invokeL.objValue;
    }

    @Deprecated
    public static boolean isArrayByteBase64(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65554, null, bArr)) == null) ? isBase64(bArr) : invokeL.booleanValue;
    }

    public static boolean isBase64(byte b2) {
        InterceptResult invokeB;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeB = interceptable.invokeB(65555, null, b2)) == null) {
            if (b2 != 61) {
                if (b2 >= 0) {
                    byte[] bArr = DECODE_TABLE;
                    if (b2 >= bArr.length || bArr[b2] == -1) {
                    }
                }
                return false;
            }
            return true;
        }
        return invokeB.booleanValue;
    }

    public static byte[] toIntegerBytes(BigInteger bigInteger) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, bigInteger)) == null) {
            int bitLength = ((bigInteger.bitLength() + 7) >> 3) << 3;
            byte[] byteArray = bigInteger.toByteArray();
            int i2 = 1;
            if (bigInteger.bitLength() % 8 == 0 || (bigInteger.bitLength() / 8) + 1 != bitLength / 8) {
                int length = byteArray.length;
                if (bigInteger.bitLength() % 8 == 0) {
                    length--;
                } else {
                    i2 = 0;
                }
                int i3 = bitLength / 8;
                int i4 = i3 - length;
                byte[] bArr = new byte[i3];
                System.arraycopy(byteArray, i2, bArr, i4, length);
                return bArr;
            }
            return byteArray;
        }
        return (byte[]) invokeL.objValue;
    }

    @Override // org.apache.commons.codec.binary4util.BaseNCodec
    public void decode(byte[] bArr, int i2, int i3, BaseNCodec.Context context) {
        byte b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), context}) == null) || context.eof) {
            return;
        }
        if (i3 < 0) {
            context.eof = true;
        }
        int i4 = 0;
        while (true) {
            if (i4 >= i3) {
                break;
            }
            byte[] ensureBufferSize = ensureBufferSize(this.decodeSize, context);
            int i5 = i2 + 1;
            byte b3 = bArr[i2];
            if (b3 == this.pad) {
                context.eof = true;
                break;
            }
            if (b3 >= 0) {
                byte[] bArr2 = DECODE_TABLE;
                if (b3 < bArr2.length && (b2 = bArr2[b3]) >= 0) {
                    int i6 = (context.modulus + 1) % 4;
                    context.modulus = i6;
                    int i7 = (context.ibitWorkArea << 6) + b2;
                    context.ibitWorkArea = i7;
                    if (i6 == 0) {
                        int i8 = context.pos;
                        int i9 = i8 + 1;
                        context.pos = i9;
                        ensureBufferSize[i8] = (byte) ((i7 >> 16) & 255);
                        int i10 = i9 + 1;
                        context.pos = i10;
                        ensureBufferSize[i9] = (byte) ((i7 >> 8) & 255);
                        context.pos = i10 + 1;
                        ensureBufferSize[i10] = (byte) (i7 & 255);
                    }
                }
            }
            i4++;
            i2 = i5;
        }
        if (!context.eof || context.modulus == 0) {
            return;
        }
        byte[] ensureBufferSize2 = ensureBufferSize(this.decodeSize, context);
        int i11 = context.modulus;
        if (i11 != 1) {
            if (i11 == 2) {
                int i12 = context.ibitWorkArea >> 4;
                context.ibitWorkArea = i12;
                int i13 = context.pos;
                context.pos = i13 + 1;
                ensureBufferSize2[i13] = (byte) (i12 & 255);
            } else if (i11 == 3) {
                int i14 = context.ibitWorkArea >> 2;
                context.ibitWorkArea = i14;
                int i15 = context.pos;
                int i16 = i15 + 1;
                context.pos = i16;
                ensureBufferSize2[i15] = (byte) ((i14 >> 8) & 255);
                context.pos = i16 + 1;
                ensureBufferSize2[i16] = (byte) (i14 & 255);
            } else {
                throw new IllegalStateException("Impossible modulus " + context.modulus);
            }
        }
    }

    @Override // org.apache.commons.codec.binary4util.BaseNCodec
    public void encode(byte[] bArr, int i2, int i3, BaseNCodec.Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), context}) == null) || context.eof) {
            return;
        }
        if (i3 >= 0) {
            int i4 = 0;
            while (i4 < i3) {
                byte[] ensureBufferSize = ensureBufferSize(this.encodeSize, context);
                context.modulus = (context.modulus + 1) % 3;
                int i5 = i2 + 1;
                int i6 = bArr[i2];
                if (i6 < 0) {
                    i6 += 256;
                }
                int i7 = (context.ibitWorkArea << 8) + i6;
                context.ibitWorkArea = i7;
                if (context.modulus == 0) {
                    int i8 = context.pos;
                    int i9 = i8 + 1;
                    context.pos = i9;
                    byte[] bArr2 = this.encodeTable;
                    ensureBufferSize[i8] = bArr2[(i7 >> 18) & 63];
                    int i10 = i9 + 1;
                    context.pos = i10;
                    ensureBufferSize[i9] = bArr2[(i7 >> 12) & 63];
                    int i11 = i10 + 1;
                    context.pos = i11;
                    ensureBufferSize[i10] = bArr2[(i7 >> 6) & 63];
                    int i12 = i11 + 1;
                    context.pos = i12;
                    ensureBufferSize[i11] = bArr2[i7 & 63];
                    int i13 = context.currentLinePos + 4;
                    context.currentLinePos = i13;
                    int i14 = this.lineLength;
                    if (i14 > 0 && i14 <= i13) {
                        byte[] bArr3 = this.lineSeparator;
                        System.arraycopy(bArr3, 0, ensureBufferSize, i12, bArr3.length);
                        context.pos += this.lineSeparator.length;
                        context.currentLinePos = 0;
                    }
                }
                i4++;
                i2 = i5;
            }
            return;
        }
        context.eof = true;
        if (context.modulus == 0 && this.lineLength == 0) {
            return;
        }
        byte[] ensureBufferSize2 = ensureBufferSize(this.encodeSize, context);
        int i15 = context.pos;
        int i16 = context.modulus;
        if (i16 != 0) {
            if (i16 == 1) {
                int i17 = i15 + 1;
                context.pos = i17;
                byte[] bArr4 = this.encodeTable;
                int i18 = context.ibitWorkArea;
                ensureBufferSize2[i15] = bArr4[(i18 >> 2) & 63];
                int i19 = i17 + 1;
                context.pos = i19;
                ensureBufferSize2[i17] = bArr4[(i18 << 4) & 63];
                if (bArr4 == STANDARD_ENCODE_TABLE) {
                    int i20 = i19 + 1;
                    context.pos = i20;
                    byte b2 = this.pad;
                    ensureBufferSize2[i19] = b2;
                    context.pos = i20 + 1;
                    ensureBufferSize2[i20] = b2;
                }
            } else if (i16 == 2) {
                int i21 = i15 + 1;
                context.pos = i21;
                byte[] bArr5 = this.encodeTable;
                int i22 = context.ibitWorkArea;
                ensureBufferSize2[i15] = bArr5[(i22 >> 10) & 63];
                int i23 = i21 + 1;
                context.pos = i23;
                ensureBufferSize2[i21] = bArr5[(i22 >> 4) & 63];
                int i24 = i23 + 1;
                context.pos = i24;
                ensureBufferSize2[i23] = bArr5[(i22 << 2) & 63];
                if (bArr5 == STANDARD_ENCODE_TABLE) {
                    context.pos = i24 + 1;
                    ensureBufferSize2[i24] = this.pad;
                }
            } else {
                throw new IllegalStateException("Impossible modulus " + context.modulus);
            }
        }
        int i25 = context.currentLinePos;
        int i26 = context.pos;
        int i27 = i25 + (i26 - i15);
        context.currentLinePos = i27;
        if (this.lineLength <= 0 || i27 <= 0) {
            return;
        }
        byte[] bArr6 = this.lineSeparator;
        System.arraycopy(bArr6, 0, ensureBufferSize2, i26, bArr6.length);
        context.pos += this.lineSeparator.length;
    }

    @Override // org.apache.commons.codec.binary4util.BaseNCodec
    public boolean isInAlphabet(byte b2) {
        InterceptResult invokeB;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeB = interceptable.invokeB(Constants.METHOD_SEND_USER_MSG, this, b2)) == null) {
            if (b2 >= 0) {
                byte[] bArr = this.decodeTable;
                if (b2 < bArr.length && bArr[b2] != -1) {
                    return true;
                }
            }
            return false;
        }
        return invokeB.booleanValue;
    }

    public boolean isUrlSafe() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.encodeTable == URL_SAFE_ENCODE_TABLE : invokeV.booleanValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Base64(boolean z) {
        this(76, CHUNK_SEPARATOR, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(AdIconUtil.AD_TEXT_ID, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), (byte[]) objArr2[1], ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(AdIconUtil.AD_TEXT_ID, newInitContext);
                return;
            }
        }
    }

    public static byte[] decodeBase64(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, bArr)) == null) ? new Base64().decode(bArr) : (byte[]) invokeL.objValue;
    }

    public static byte[] encodeBase64(byte[] bArr, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(65546, null, bArr, z)) == null) ? encodeBase64(bArr, z, false) : (byte[]) invokeLZ.objValue;
    }

    public static boolean isBase64(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65556, null, str)) == null) ? isBase64(org.apache.commons.base.binary4util.CodecStringUtils.getBytesUtf8(str)) : invokeL.booleanValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Base64(int i2) {
        this(i2, CHUNK_SEPARATOR);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), (byte[]) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public static byte[] encodeBase64(byte[] bArr, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{bArr, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? encodeBase64(bArr, z, z2, Integer.MAX_VALUE) : (byte[]) invokeCommon.objValue;
    }

    public static boolean isBase64(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, bArr)) == null) {
            for (int i2 = 0; i2 < bArr.length; i2++) {
                if (!isBase64(bArr[i2]) && !BaseNCodec.isWhiteSpace(bArr[i2])) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Base64(int i2, byte[] bArr) {
        this(i2, bArr, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), bArr};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), (byte[]) objArr2[1], ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    public static byte[] encodeBase64(byte[] bArr, boolean z, boolean z2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{bArr, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2)})) == null) {
            if (bArr == null || bArr.length == 0) {
                return bArr;
            }
            Base64 base64 = z ? new Base64(z2) : new Base64(0, CHUNK_SEPARATOR, z2);
            long encodedLength = base64.getEncodedLength(bArr);
            if (encodedLength <= i2) {
                return base64.encode(bArr);
            }
            throw new IllegalArgumentException("Input array too big, the output array would be bigger (" + encodedLength + ") than the specified maximum size of " + i2);
        }
        return (byte[]) invokeCommon.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Base64(int i2, byte[] bArr, boolean z) {
        super(3, 4, i2, bArr == null ? 0 : bArr.length);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), bArr, Boolean.valueOf(z)};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.decodeTable = DECODE_TABLE;
        if (bArr != null) {
            if (containsAlphabetOrPad(bArr)) {
                String newStringUtf8 = org.apache.commons.base.binary4util.CodecStringUtils.newStringUtf8(bArr);
                throw new IllegalArgumentException("lineSeparator must not contain base64 characters: [" + newStringUtf8 + PreferencesUtil.RIGHT_MOUNT);
            } else if (i2 > 0) {
                this.encodeSize = bArr.length + 4;
                byte[] bArr2 = new byte[bArr.length];
                this.lineSeparator = bArr2;
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            } else {
                this.encodeSize = 4;
                this.lineSeparator = null;
            }
        } else {
            this.encodeSize = 4;
            this.lineSeparator = null;
        }
        this.decodeSize = this.encodeSize - 1;
        this.encodeTable = z ? URL_SAFE_ENCODE_TABLE : STANDARD_ENCODE_TABLE;
    }
}
