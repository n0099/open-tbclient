package org.apache.commons.codec.binary4util;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy;
import com.baidu.webkit.internal.utils.UtilsBlink;
import io.flutter.plugin.common.StandardMessageCodec;
import java.math.BigInteger;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import org.apache.commons.codec.binary4util.BaseNCodec;
/* loaded from: classes7.dex */
public class Base64 extends BaseNCodec {
    public static final int BITS_PER_ENCODED_BYTE = 6;
    public static final int BYTES_PER_ENCODED_BLOCK = 4;
    public static final int BYTES_PER_UNENCODED_BLOCK = 3;
    public static final int MASK_6BITS = 63;
    public final int decodeSize;
    public final byte[] decodeTable;
    public final int encodeSize;
    public final byte[] encodeTable;
    public final byte[] lineSeparator;
    public static final byte[] CHUNK_SEPARATOR = {13, 10};
    public static final byte[] STANDARD_ENCODE_TABLE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    public static final byte[] URL_SAFE_ENCODE_TABLE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, UtilsBlink.VER_TYPE_SEPARATOR, 95};
    public static final byte[] DECODE_TABLE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, StandardMessageCodec.LIST, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, PublicSuffixDatabase.EXCEPTION_MARKER, 34, com.baidu.webkit.internal.Base64.INTERNAL_PADDING, 36, 37, 38, 39, 40, 41, ExifInterface.START_CODE, 43, 44, UtilsBlink.VER_TYPE_SEPARATOR, 46, 47, 48, 49, 50, 51};

    public Base64() {
        this(0);
    }

    public static byte[] decodeBase64(String str) {
        return new Base64().decode(str);
    }

    public static BigInteger decodeInteger(byte[] bArr) {
        return new BigInteger(1, decodeBase64(bArr));
    }

    public static byte[] encodeBase64(byte[] bArr) {
        return encodeBase64(bArr, false);
    }

    public static byte[] encodeBase64Chunked(byte[] bArr) {
        return encodeBase64(bArr, true);
    }

    public static String encodeBase64String(byte[] bArr) {
        return org.apache.commons.base.binary4util.CodecStringUtils.newStringUsAscii(encodeBase64(bArr, false));
    }

    public static byte[] encodeBase64URLSafe(byte[] bArr) {
        return encodeBase64(bArr, false, true);
    }

    public static String encodeBase64URLSafeString(byte[] bArr) {
        return org.apache.commons.base.binary4util.CodecStringUtils.newStringUsAscii(encodeBase64(bArr, false, true));
    }

    public static byte[] encodeInteger(BigInteger bigInteger) {
        if (bigInteger != null) {
            return encodeBase64(toIntegerBytes(bigInteger), false);
        }
        throw new NullPointerException("encodeInteger called with null parameter");
    }

    @Deprecated
    public static boolean isArrayByteBase64(byte[] bArr) {
        return isBase64(bArr);
    }

    public static boolean isBase64(byte b2) {
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

    public static byte[] toIntegerBytes(BigInteger bigInteger) {
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

    @Override // org.apache.commons.codec.binary4util.BaseNCodec
    public void decode(byte[] bArr, int i, int i2, BaseNCodec.Context context) {
        byte b2;
        if (context.eof) {
            return;
        }
        if (i2 < 0) {
            context.eof = true;
        }
        int i3 = 0;
        while (true) {
            if (i3 >= i2) {
                break;
            }
            byte[] ensureBufferSize = ensureBufferSize(this.decodeSize, context);
            int i4 = i + 1;
            byte b3 = bArr[i];
            if (b3 == this.pad) {
                context.eof = true;
                break;
            }
            if (b3 >= 0) {
                byte[] bArr2 = DECODE_TABLE;
                if (b3 < bArr2.length && (b2 = bArr2[b3]) >= 0) {
                    int i5 = (context.modulus + 1) % 4;
                    context.modulus = i5;
                    int i6 = (context.ibitWorkArea << 6) + b2;
                    context.ibitWorkArea = i6;
                    if (i5 == 0) {
                        int i7 = context.pos;
                        int i8 = i7 + 1;
                        context.pos = i8;
                        ensureBufferSize[i7] = (byte) ((i6 >> 16) & 255);
                        int i9 = i8 + 1;
                        context.pos = i9;
                        ensureBufferSize[i8] = (byte) ((i6 >> 8) & 255);
                        context.pos = i9 + 1;
                        ensureBufferSize[i9] = (byte) (i6 & 255);
                    }
                }
            }
            i3++;
            i = i4;
        }
        if (!context.eof || context.modulus == 0) {
            return;
        }
        byte[] ensureBufferSize2 = ensureBufferSize(this.decodeSize, context);
        int i10 = context.modulus;
        if (i10 != 1) {
            if (i10 == 2) {
                int i11 = context.ibitWorkArea >> 4;
                context.ibitWorkArea = i11;
                int i12 = context.pos;
                context.pos = i12 + 1;
                ensureBufferSize2[i12] = (byte) (i11 & 255);
            } else if (i10 == 3) {
                int i13 = context.ibitWorkArea >> 2;
                context.ibitWorkArea = i13;
                int i14 = context.pos;
                int i15 = i14 + 1;
                context.pos = i15;
                ensureBufferSize2[i14] = (byte) ((i13 >> 8) & 255);
                context.pos = i15 + 1;
                ensureBufferSize2[i15] = (byte) (i13 & 255);
            } else {
                throw new IllegalStateException("Impossible modulus " + context.modulus);
            }
        }
    }

    @Override // org.apache.commons.codec.binary4util.BaseNCodec
    public void encode(byte[] bArr, int i, int i2, BaseNCodec.Context context) {
        if (context.eof) {
            return;
        }
        if (i2 >= 0) {
            int i3 = 0;
            while (i3 < i2) {
                byte[] ensureBufferSize = ensureBufferSize(this.encodeSize, context);
                context.modulus = (context.modulus + 1) % 3;
                int i4 = i + 1;
                int i5 = bArr[i];
                if (i5 < 0) {
                    i5 += 256;
                }
                int i6 = (context.ibitWorkArea << 8) + i5;
                context.ibitWorkArea = i6;
                if (context.modulus == 0) {
                    int i7 = context.pos;
                    int i8 = i7 + 1;
                    context.pos = i8;
                    byte[] bArr2 = this.encodeTable;
                    ensureBufferSize[i7] = bArr2[(i6 >> 18) & 63];
                    int i9 = i8 + 1;
                    context.pos = i9;
                    ensureBufferSize[i8] = bArr2[(i6 >> 12) & 63];
                    int i10 = i9 + 1;
                    context.pos = i10;
                    ensureBufferSize[i9] = bArr2[(i6 >> 6) & 63];
                    int i11 = i10 + 1;
                    context.pos = i11;
                    ensureBufferSize[i10] = bArr2[i6 & 63];
                    int i12 = context.currentLinePos + 4;
                    context.currentLinePos = i12;
                    int i13 = this.lineLength;
                    if (i13 > 0 && i13 <= i12) {
                        byte[] bArr3 = this.lineSeparator;
                        System.arraycopy(bArr3, 0, ensureBufferSize, i11, bArr3.length);
                        context.pos += this.lineSeparator.length;
                        context.currentLinePos = 0;
                    }
                }
                i3++;
                i = i4;
            }
            return;
        }
        context.eof = true;
        if (context.modulus == 0 && this.lineLength == 0) {
            return;
        }
        byte[] ensureBufferSize2 = ensureBufferSize(this.encodeSize, context);
        int i14 = context.pos;
        int i15 = context.modulus;
        if (i15 != 0) {
            if (i15 == 1) {
                int i16 = i14 + 1;
                context.pos = i16;
                byte[] bArr4 = this.encodeTable;
                int i17 = context.ibitWorkArea;
                ensureBufferSize2[i14] = bArr4[(i17 >> 2) & 63];
                int i18 = i16 + 1;
                context.pos = i18;
                ensureBufferSize2[i16] = bArr4[(i17 << 4) & 63];
                if (bArr4 == STANDARD_ENCODE_TABLE) {
                    int i19 = i18 + 1;
                    context.pos = i19;
                    byte b2 = this.pad;
                    ensureBufferSize2[i18] = b2;
                    context.pos = i19 + 1;
                    ensureBufferSize2[i19] = b2;
                }
            } else if (i15 == 2) {
                int i20 = i14 + 1;
                context.pos = i20;
                byte[] bArr5 = this.encodeTable;
                int i21 = context.ibitWorkArea;
                ensureBufferSize2[i14] = bArr5[(i21 >> 10) & 63];
                int i22 = i20 + 1;
                context.pos = i22;
                ensureBufferSize2[i20] = bArr5[(i21 >> 4) & 63];
                int i23 = i22 + 1;
                context.pos = i23;
                ensureBufferSize2[i22] = bArr5[(i21 << 2) & 63];
                if (bArr5 == STANDARD_ENCODE_TABLE) {
                    context.pos = i23 + 1;
                    ensureBufferSize2[i23] = this.pad;
                }
            } else {
                throw new IllegalStateException("Impossible modulus " + context.modulus);
            }
        }
        int i24 = context.currentLinePos;
        int i25 = context.pos;
        int i26 = i24 + (i25 - i14);
        context.currentLinePos = i26;
        if (this.lineLength <= 0 || i26 <= 0) {
            return;
        }
        byte[] bArr6 = this.lineSeparator;
        System.arraycopy(bArr6, 0, ensureBufferSize2, i25, bArr6.length);
        context.pos += this.lineSeparator.length;
    }

    @Override // org.apache.commons.codec.binary4util.BaseNCodec
    public boolean isInAlphabet(byte b2) {
        if (b2 >= 0) {
            byte[] bArr = this.decodeTable;
            if (b2 < bArr.length && bArr[b2] != -1) {
                return true;
            }
        }
        return false;
    }

    public boolean isUrlSafe() {
        return this.encodeTable == URL_SAFE_ENCODE_TABLE;
    }

    public Base64(boolean z) {
        this(76, CHUNK_SEPARATOR, z);
    }

    public static byte[] decodeBase64(byte[] bArr) {
        return new Base64().decode(bArr);
    }

    public static byte[] encodeBase64(byte[] bArr, boolean z) {
        return encodeBase64(bArr, z, false);
    }

    public static boolean isBase64(String str) {
        return isBase64(org.apache.commons.base.binary4util.CodecStringUtils.getBytesUtf8(str));
    }

    public Base64(int i) {
        this(i, CHUNK_SEPARATOR);
    }

    public static byte[] encodeBase64(byte[] bArr, boolean z, boolean z2) {
        return encodeBase64(bArr, z, z2, Integer.MAX_VALUE);
    }

    public static boolean isBase64(byte[] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            if (!isBase64(bArr[i]) && !BaseNCodec.isWhiteSpace(bArr[i])) {
                return false;
            }
        }
        return true;
    }

    public Base64(int i, byte[] bArr) {
        this(i, bArr, false);
    }

    public static byte[] encodeBase64(byte[] bArr, boolean z, boolean z2, int i) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        Base64 base64 = z ? new Base64(z2) : new Base64(0, CHUNK_SEPARATOR, z2);
        long encodedLength = base64.getEncodedLength(bArr);
        if (encodedLength <= i) {
            return base64.encode(bArr);
        }
        throw new IllegalArgumentException("Input array too big, the output array would be bigger (" + encodedLength + ") than the specified maximum size of " + i);
    }

    public Base64(int i, byte[] bArr, boolean z) {
        super(3, 4, i, bArr == null ? 0 : bArr.length);
        this.decodeTable = DECODE_TABLE;
        if (bArr != null) {
            if (containsAlphabetOrPad(bArr)) {
                String newStringUtf8 = org.apache.commons.base.binary4util.CodecStringUtils.newStringUtf8(bArr);
                throw new IllegalArgumentException("lineSeparator must not contain base64 characters: [" + newStringUtf8 + "]");
            } else if (i > 0) {
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
