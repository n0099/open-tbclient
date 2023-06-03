package org.apache.commons.codec.binary4util;

import android.annotation.SuppressLint;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.google.android.exoplayer2.text.cea.Cea608Decoder;
import java.math.BigInteger;
import org.apache.commons.codec.binary4util.BaseNCodec;
import org.apache.commons.codec.net.QCodec;
@SuppressLint({"BDThrowableCheck"})
/* loaded from: classes2.dex */
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
    public static final byte[] STANDARD_ENCODE_TABLE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    public static final byte[] URL_SAFE_ENCODE_TABLE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, QCodec.UNDERSCORE};
    public static final byte[] DECODE_TABLE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, Constants.GZIP_CAST_TYPE, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, com.baidu.webkit.internal.Base64.INTERNAL_PADDING, Cea608Decoder.CTRL_DELETE_TO_END_OF_ROW, 37, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_3_ROWS, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_4_ROWS, 40, Cea608Decoder.CTRL_RESUME_DIRECT_CAPTIONING, ExifInterface.START_CODE, 43, Cea608Decoder.CTRL_ERASE_DISPLAYED_MEMORY, 45, Cea608Decoder.CTRL_ERASE_NON_DISPLAYED_MEMORY, 47, 48, 49, 50, 51};

    public Base64() {
        this(0);
    }

    public boolean isUrlSafe() {
        if (this.encodeTable == URL_SAFE_ENCODE_TABLE) {
            return true;
        }
        return false;
    }

    public Base64(int i) {
        this(i, CHUNK_SEPARATOR);
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

    public static boolean isBase64(byte b) {
        if (b != 61) {
            if (b >= 0) {
                byte[] bArr = DECODE_TABLE;
                if (b >= bArr.length || bArr[b] == -1) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // org.apache.commons.codec.binary4util.BaseNCodec
    public boolean isInAlphabet(byte b) {
        if (b >= 0) {
            byte[] bArr = this.decodeTable;
            if (b < bArr.length && bArr[b] != -1) {
                return true;
            }
        }
        return false;
    }

    public Base64(int i, byte[] bArr) {
        this(i, bArr, false);
    }

    public static byte[] encodeBase64(byte[] bArr, boolean z) {
        return encodeBase64(bArr, z, false);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Base64(int i, byte[] bArr, boolean z) {
        super(3, 4, i, r1);
        int length;
        byte[] bArr2;
        if (bArr == null) {
            length = 0;
        } else {
            length = bArr.length;
        }
        this.decodeTable = DECODE_TABLE;
        if (bArr != null) {
            if (!containsAlphabetOrPad(bArr)) {
                if (i > 0) {
                    this.encodeSize = bArr.length + 4;
                    byte[] bArr3 = new byte[bArr.length];
                    this.lineSeparator = bArr3;
                    System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
                } else {
                    this.encodeSize = 4;
                    this.lineSeparator = null;
                }
            } else {
                String newStringUtf8 = org.apache.commons.base.binary4util.CodecStringUtils.newStringUtf8(bArr);
                throw new IllegalArgumentException("lineSeparator must not contain base64 characters: [" + newStringUtf8 + PreferencesUtil.RIGHT_MOUNT);
            }
        } else {
            this.encodeSize = 4;
            this.lineSeparator = null;
        }
        this.decodeSize = this.encodeSize - 1;
        if (z) {
            bArr2 = URL_SAFE_ENCODE_TABLE;
        } else {
            bArr2 = STANDARD_ENCODE_TABLE;
        }
        this.encodeTable = bArr2;
    }

    public Base64(boolean z) {
        this(76, CHUNK_SEPARATOR, z);
    }

    public static byte[] decodeBase64(byte[] bArr) {
        return new Base64().decode(bArr);
    }

    public static boolean isBase64(String str) {
        return isBase64(org.apache.commons.base.binary4util.CodecStringUtils.getBytesUtf8(str));
    }

    public static byte[] encodeBase64(byte[] bArr, boolean z, boolean z2) {
        return encodeBase64(bArr, z, z2, Integer.MAX_VALUE);
    }

    public static byte[] encodeBase64(byte[] bArr, boolean z, boolean z2, int i) {
        Base64 base64;
        if (bArr != null && bArr.length != 0) {
            if (z) {
                base64 = new Base64(z2);
            } else {
                base64 = new Base64(0, CHUNK_SEPARATOR, z2);
            }
            long encodedLength = base64.getEncodedLength(bArr);
            if (encodedLength <= i) {
                return base64.encode(bArr);
            }
            throw new IllegalArgumentException("Input array too big, the output array would be bigger (" + encodedLength + ") than the specified maximum size of " + i);
        }
        return bArr;
    }

    public static boolean isBase64(byte[] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            if (!isBase64(bArr[i]) && !BaseNCodec.isWhiteSpace(bArr[i])) {
                return false;
            }
        }
        return true;
    }

    public static byte[] toIntegerBytes(BigInteger bigInteger) {
        int bitLength = ((bigInteger.bitLength() + 7) >> 3) << 3;
        byte[] byteArray = bigInteger.toByteArray();
        int i = 1;
        if (bigInteger.bitLength() % 8 != 0 && (bigInteger.bitLength() / 8) + 1 == bitLength / 8) {
            return byteArray;
        }
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

    @Override // org.apache.commons.codec.binary4util.BaseNCodec
    public void decode(byte[] bArr, int i, int i2, BaseNCodec.Context context) {
        byte b;
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
            byte b2 = bArr[i];
            if (b2 == this.pad) {
                context.eof = true;
                break;
            }
            if (b2 >= 0) {
                byte[] bArr2 = DECODE_TABLE;
                if (b2 < bArr2.length && (b = bArr2[b2]) >= 0) {
                    int i5 = (context.modulus + 1) % 4;
                    context.modulus = i5;
                    int i6 = (context.ibitWorkArea << 6) + b;
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
        if (context.eof && context.modulus != 0) {
            byte[] ensureBufferSize2 = ensureBufferSize(this.decodeSize, context);
            int i10 = context.modulus;
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 == 3) {
                        int i11 = context.ibitWorkArea >> 2;
                        context.ibitWorkArea = i11;
                        int i12 = context.pos;
                        int i13 = i12 + 1;
                        context.pos = i13;
                        ensureBufferSize2[i12] = (byte) ((i11 >> 8) & 255);
                        context.pos = i13 + 1;
                        ensureBufferSize2[i13] = (byte) (i11 & 255);
                        return;
                    }
                    throw new IllegalStateException("Impossible modulus " + context.modulus);
                }
                int i14 = context.ibitWorkArea >> 4;
                context.ibitWorkArea = i14;
                int i15 = context.pos;
                context.pos = i15 + 1;
                ensureBufferSize2[i15] = (byte) (i14 & 255);
            }
        }
    }

    @Override // org.apache.commons.codec.binary4util.BaseNCodec
    public void encode(byte[] bArr, int i, int i2, BaseNCodec.Context context) {
        if (context.eof) {
            return;
        }
        if (i2 < 0) {
            context.eof = true;
            if (context.modulus == 0 && this.lineLength == 0) {
                return;
            }
            byte[] ensureBufferSize = ensureBufferSize(this.encodeSize, context);
            int i3 = context.pos;
            int i4 = context.modulus;
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 == 2) {
                        int i5 = i3 + 1;
                        context.pos = i5;
                        byte[] bArr2 = this.encodeTable;
                        int i6 = context.ibitWorkArea;
                        ensureBufferSize[i3] = bArr2[(i6 >> 10) & 63];
                        int i7 = i5 + 1;
                        context.pos = i7;
                        ensureBufferSize[i5] = bArr2[(i6 >> 4) & 63];
                        int i8 = i7 + 1;
                        context.pos = i8;
                        ensureBufferSize[i7] = bArr2[(i6 << 2) & 63];
                        if (bArr2 == STANDARD_ENCODE_TABLE) {
                            context.pos = i8 + 1;
                            ensureBufferSize[i8] = this.pad;
                        }
                    } else {
                        throw new IllegalStateException("Impossible modulus " + context.modulus);
                    }
                } else {
                    int i9 = i3 + 1;
                    context.pos = i9;
                    byte[] bArr3 = this.encodeTable;
                    int i10 = context.ibitWorkArea;
                    ensureBufferSize[i3] = bArr3[(i10 >> 2) & 63];
                    int i11 = i9 + 1;
                    context.pos = i11;
                    ensureBufferSize[i9] = bArr3[(i10 << 4) & 63];
                    if (bArr3 == STANDARD_ENCODE_TABLE) {
                        int i12 = i11 + 1;
                        context.pos = i12;
                        byte b = this.pad;
                        ensureBufferSize[i11] = b;
                        context.pos = i12 + 1;
                        ensureBufferSize[i12] = b;
                    }
                }
            }
            int i13 = context.currentLinePos;
            int i14 = context.pos;
            int i15 = i13 + (i14 - i3);
            context.currentLinePos = i15;
            if (this.lineLength > 0 && i15 > 0) {
                byte[] bArr4 = this.lineSeparator;
                System.arraycopy(bArr4, 0, ensureBufferSize, i14, bArr4.length);
                context.pos += this.lineSeparator.length;
                return;
            }
            return;
        }
        int i16 = 0;
        while (i16 < i2) {
            byte[] ensureBufferSize2 = ensureBufferSize(this.encodeSize, context);
            context.modulus = (context.modulus + 1) % 3;
            int i17 = i + 1;
            int i18 = bArr[i];
            if (i18 < 0) {
                i18 += 256;
            }
            int i19 = (context.ibitWorkArea << 8) + i18;
            context.ibitWorkArea = i19;
            if (context.modulus == 0) {
                int i20 = context.pos;
                int i21 = i20 + 1;
                context.pos = i21;
                byte[] bArr5 = this.encodeTable;
                ensureBufferSize2[i20] = bArr5[(i19 >> 18) & 63];
                int i22 = i21 + 1;
                context.pos = i22;
                ensureBufferSize2[i21] = bArr5[(i19 >> 12) & 63];
                int i23 = i22 + 1;
                context.pos = i23;
                ensureBufferSize2[i22] = bArr5[(i19 >> 6) & 63];
                int i24 = i23 + 1;
                context.pos = i24;
                ensureBufferSize2[i23] = bArr5[i19 & 63];
                int i25 = context.currentLinePos + 4;
                context.currentLinePos = i25;
                int i26 = this.lineLength;
                if (i26 > 0 && i26 <= i25) {
                    byte[] bArr6 = this.lineSeparator;
                    System.arraycopy(bArr6, 0, ensureBufferSize2, i24, bArr6.length);
                    context.pos += this.lineSeparator.length;
                    context.currentLinePos = 0;
                }
            }
            i16++;
            i = i17;
        }
    }
}
