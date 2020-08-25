package org.java_websocket.e;

import com.baidu.android.imsdk.internal.Constants;
import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.zip.GZIPOutputStream;
/* loaded from: classes7.dex */
public class a {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final byte[] _ORDERED_ALPHABET;
    private static final byte[] _ORDERED_DECODABET;
    private static final byte[] _STANDARD_ALPHABET;
    private static final byte[] _STANDARD_DECODABET;
    private static final byte[] _URL_SAFE_ALPHABET;
    private static final byte[] _URL_SAFE_DECODABET;

    static {
        $assertionsDisabled = !a.class.desiredAssertionStatus();
        _STANDARD_ALPHABET = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
        _STANDARD_DECODABET = new byte[]{-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, Constants.GZIP_CAST_TYPE, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
        _URL_SAFE_ALPHABET = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
        _URL_SAFE_DECODABET = new byte[]{-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, Constants.GZIP_CAST_TYPE, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
        _ORDERED_ALPHABET = new byte[]{45, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122};
        _ORDERED_DECODABET = new byte[]{-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -9, -9, -9, -1, -9, -9, -9, Constants.GZIP_CAST_TYPE, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, -9, -9, -9, -9, 37, -9, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
    }

    private static final byte[] getAlphabet(int i) {
        if ((i & 16) == 16) {
            return _URL_SAFE_ALPHABET;
        }
        if ((i & 32) == 32) {
            return _ORDERED_ALPHABET;
        }
        return _STANDARD_ALPHABET;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final byte[] getDecodabet(int i) {
        if ((i & 16) == 16) {
            return _URL_SAFE_DECODABET;
        }
        if ((i & 32) == 32) {
            return _ORDERED_DECODABET;
        }
        return _STANDARD_DECODABET;
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] encode3to4(byte[] bArr, byte[] bArr2, int i, int i2) {
        encode3to4(bArr2, 0, i, bArr, 0, i2);
        return bArr;
    }

    private static byte[] encode3to4(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) {
        byte[] alphabet = getAlphabet(i4);
        int i5 = (i2 > 2 ? (bArr[i + 2] << 24) >>> 24 : 0) | (i2 > 1 ? (bArr[i + 1] << 24) >>> 16 : 0) | (i2 > 0 ? (bArr[i] << 24) >>> 8 : 0);
        switch (i2) {
            case 1:
                bArr2[i3] = alphabet[i5 >>> 18];
                bArr2[i3 + 1] = alphabet[(i5 >>> 12) & 63];
                bArr2[i3 + 2] = 61;
                bArr2[i3 + 3] = 61;
                break;
            case 2:
                bArr2[i3] = alphabet[i5 >>> 18];
                bArr2[i3 + 1] = alphabet[(i5 >>> 12) & 63];
                bArr2[i3 + 2] = alphabet[(i5 >>> 6) & 63];
                bArr2[i3 + 3] = 61;
                break;
            case 3:
                bArr2[i3] = alphabet[i5 >>> 18];
                bArr2[i3 + 1] = alphabet[(i5 >>> 12) & 63];
                bArr2[i3 + 2] = alphabet[(i5 >>> 6) & 63];
                bArr2[i3 + 3] = alphabet[i5 & 63];
                break;
        }
        return bArr2;
    }

    public static String encodeBytes(byte[] bArr) {
        String str = null;
        try {
            str = encodeBytes(bArr, 0, bArr.length, 0);
        } catch (IOException e) {
            if (!$assertionsDisabled) {
                throw new AssertionError(e.getMessage());
            }
        }
        if ($assertionsDisabled || str != null) {
            return str;
        }
        throw new AssertionError();
    }

    public static String encodeBytes(byte[] bArr, int i, int i2, int i3) throws IOException {
        byte[] encodeBytesToBytes = encodeBytesToBytes(bArr, i, i2, i3);
        try {
            return new String(encodeBytesToBytes, "US-ASCII");
        } catch (UnsupportedEncodingException e) {
            return new String(encodeBytesToBytes);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [695=5, 696=4, 697=4] */
    public static byte[] encodeBytesToBytes(byte[] bArr, int i, int i2, int i3) throws IOException {
        C0984a c0984a;
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        GZIPOutputStream gZIPOutputStream;
        GZIPOutputStream gZIPOutputStream2 = null;
        if (bArr == null) {
            throw new IllegalArgumentException("Cannot serialize a null array.");
        }
        if (i < 0) {
            throw new IllegalArgumentException("Cannot have negative offset: " + i);
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("Cannot have length offset: " + i2);
        }
        if (i + i2 > bArr.length) {
            throw new IllegalArgumentException(String.format("Cannot have offset of %d and length of %d with array of length %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(bArr.length)));
        }
        if ((i3 & 2) == 0) {
            boolean z = (i3 & 8) != 0;
            int i4 = (i2 % 3 > 0 ? 4 : 0) + ((i2 / 3) * 4);
            if (z) {
                i4 += i4 / 76;
            }
            byte[] bArr2 = new byte[i4];
            int i5 = i2 - 2;
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            while (i8 < i5) {
                encode3to4(bArr, i8 + i, 3, bArr2, i7, i3);
                int i9 = i6 + 4;
                if (z && i9 >= 76) {
                    bArr2[i7 + 4] = 10;
                    i7++;
                    i9 = 0;
                }
                i7 += 4;
                i6 = i9;
                i8 += 3;
            }
            if (i8 < i2) {
                encode3to4(bArr, i8 + i, i2 - i8, bArr2, i7, i3);
                i7 += 4;
            }
            if (i7 <= bArr2.length - 1) {
                byte[] bArr3 = new byte[i7];
                System.arraycopy(bArr2, 0, bArr3, 0, i7);
                return bArr3;
            }
            return bArr2;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                c0984a = new C0984a(byteArrayOutputStream, i3 | 1);
                try {
                    gZIPOutputStream = new GZIPOutputStream(c0984a);
                } catch (IOException e) {
                    e = e;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                } catch (Throwable th) {
                    th = th;
                }
            } catch (IOException e2) {
                e = e2;
                c0984a = null;
                byteArrayOutputStream2 = byteArrayOutputStream;
            } catch (Throwable th2) {
                th = th2;
                c0984a = null;
            }
        } catch (IOException e3) {
            e = e3;
            c0984a = null;
            byteArrayOutputStream2 = null;
        } catch (Throwable th3) {
            th = th3;
            c0984a = null;
            byteArrayOutputStream = null;
        }
        try {
            gZIPOutputStream.write(bArr, i, i2);
            gZIPOutputStream.close();
            try {
                gZIPOutputStream.close();
            } catch (Exception e4) {
            }
            try {
                c0984a.close();
            } catch (Exception e5) {
            }
            try {
                byteArrayOutputStream.close();
            } catch (Exception e6) {
            }
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e7) {
            e = e7;
            gZIPOutputStream2 = gZIPOutputStream;
            byteArrayOutputStream2 = byteArrayOutputStream;
            try {
                throw e;
            } catch (Throwable th4) {
                th = th4;
                byteArrayOutputStream = byteArrayOutputStream2;
                try {
                    gZIPOutputStream2.close();
                } catch (Exception e8) {
                }
                try {
                    c0984a.close();
                } catch (Exception e9) {
                }
                try {
                    byteArrayOutputStream.close();
                } catch (Exception e10) {
                }
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            gZIPOutputStream2 = gZIPOutputStream;
            gZIPOutputStream2.close();
            c0984a.close();
            byteArrayOutputStream.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int decode4to3(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        if (bArr == null) {
            throw new IllegalArgumentException("Source array was null.");
        }
        if (bArr2 == null) {
            throw new IllegalArgumentException("Destination array was null.");
        }
        if (i < 0 || i + 3 >= bArr.length) {
            throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and still process four bytes.", Integer.valueOf(bArr.length), Integer.valueOf(i)));
        }
        if (i2 < 0 || i2 + 2 >= bArr2.length) {
            throw new IllegalArgumentException(String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", Integer.valueOf(bArr2.length), Integer.valueOf(i2)));
        }
        byte[] decodabet = getDecodabet(i3);
        if (bArr[i + 2] == 61) {
            bArr2[i2] = (byte) ((((decodabet[bArr[i]] & 255) << 18) | ((decodabet[bArr[i + 1]] & 255) << 12)) >>> 16);
            return 1;
        } else if (bArr[i + 3] == 61) {
            int i4 = ((decodabet[bArr[i]] & 255) << 18) | ((decodabet[bArr[i + 1]] & 255) << 12) | ((decodabet[bArr[i + 2]] & 255) << 6);
            bArr2[i2] = (byte) (i4 >>> 16);
            bArr2[i2 + 1] = (byte) (i4 >>> 8);
            return 2;
        } else {
            int i5 = ((decodabet[bArr[i]] & 255) << 18) | ((decodabet[bArr[i + 1]] & 255) << 12) | ((decodabet[bArr[i + 2]] & 255) << 6) | (decodabet[bArr[i + 3]] & 255);
            bArr2[i2] = (byte) (i5 >> 16);
            bArr2[i2 + 1] = (byte) (i5 >> 8);
            bArr2[i2 + 2] = (byte) i5;
            return 3;
        }
    }

    /* renamed from: org.java_websocket.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0984a extends FilterOutputStream {
        private byte[] b4;
        private boolean breakLines;
        private byte[] buffer;
        private int bufferLength;
        private byte[] decodabet;
        private boolean encode;
        private int lineLength;
        private int options;
        private int position;
        private boolean suspendEncoding;

        public C0984a(OutputStream outputStream, int i) {
            super(outputStream);
            this.breakLines = (i & 8) != 0;
            this.encode = (i & 1) != 0;
            this.bufferLength = this.encode ? 3 : 4;
            this.buffer = new byte[this.bufferLength];
            this.position = 0;
            this.lineLength = 0;
            this.suspendEncoding = false;
            this.b4 = new byte[4];
            this.options = i;
            this.decodabet = a.getDecodabet(i);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(int i) throws IOException {
            if (this.suspendEncoding) {
                this.out.write(i);
            } else if (this.encode) {
                byte[] bArr = this.buffer;
                int i2 = this.position;
                this.position = i2 + 1;
                bArr[i2] = (byte) i;
                if (this.position >= this.bufferLength) {
                    this.out.write(a.encode3to4(this.b4, this.buffer, this.bufferLength, this.options));
                    this.lineLength += 4;
                    if (this.breakLines && this.lineLength >= 76) {
                        this.out.write(10);
                        this.lineLength = 0;
                    }
                    this.position = 0;
                }
            } else if (this.decodabet[i & 127] > -5) {
                byte[] bArr2 = this.buffer;
                int i3 = this.position;
                this.position = i3 + 1;
                bArr2[i3] = (byte) i;
                if (this.position >= this.bufferLength) {
                    this.out.write(this.b4, 0, a.decode4to3(this.buffer, 0, this.b4, 0, this.options));
                    this.position = 0;
                }
            } else if (this.decodabet[i & 127] != -5) {
                throw new IOException("Invalid character in Base64 data.");
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            if (this.suspendEncoding) {
                this.out.write(bArr, i, i2);
                return;
            }
            for (int i3 = 0; i3 < i2; i3++) {
                write(bArr[i + i3]);
            }
        }

        public void flushBase64() throws IOException {
            if (this.position > 0) {
                if (this.encode) {
                    this.out.write(a.encode3to4(this.b4, this.buffer, this.position, this.options));
                    this.position = 0;
                    return;
                }
                throw new IOException("Base64 input not properly padded.");
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            flushBase64();
            super.close();
            this.buffer = null;
            this.out = null;
        }
    }
}
