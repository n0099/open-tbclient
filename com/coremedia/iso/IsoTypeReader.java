package com.coremedia.iso;

import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import com.baidu.appsearch.update.patchupdate.GDiffPatcher;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.googlecode.mp4parser.util.IntHashMap;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
/* loaded from: classes7.dex */
public final class IsoTypeReader {
    private static IntHashMap codeCache = new IntHashMap();
    private static byte[] codeBytes = new byte[4];

    public static long readUInt32BE(ByteBuffer byteBuffer) {
        long readUInt8 = readUInt8(byteBuffer) << 16;
        long readUInt82 = readUInt8(byteBuffer) << 8;
        return (readUInt8(byteBuffer) << 0) + readUInt82 + readUInt8 + (readUInt8(byteBuffer) << 24);
    }

    public static long readUInt32(ByteBuffer byteBuffer) {
        long j = byteBuffer.getInt();
        if (j < 0) {
            return j + AccountConstants.TYPE_MODIFY_EXT_FIELDS;
        }
        return j;
    }

    public static int readUInt24(ByteBuffer byteBuffer) {
        return 0 + (readUInt16(byteBuffer) << 8) + byte2int(byteBuffer.get());
    }

    public static int readUInt16(ByteBuffer byteBuffer) {
        return 0 + (byte2int(byteBuffer.get()) << 8) + byte2int(byteBuffer.get());
    }

    public static int readUInt16BE(ByteBuffer byteBuffer) {
        return 0 + byte2int(byteBuffer.get()) + (byte2int(byteBuffer.get()) << 8);
    }

    public static int readUInt8(ByteBuffer byteBuffer) {
        return byte2int(byteBuffer.get());
    }

    public static int byte2int(byte b) {
        return b < 0 ? b + GDiffPatcher.EOF : b;
    }

    public static String readString(ByteBuffer byteBuffer) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            byte b = byteBuffer.get();
            if (b != 0) {
                byteArrayOutputStream.write(b);
            } else {
                return Utf8.convert(byteArrayOutputStream.toByteArray());
            }
        }
    }

    public static String readString(ByteBuffer byteBuffer, int i) {
        byte[] bArr = new byte[i];
        byteBuffer.get(bArr);
        return Utf8.convert(bArr);
    }

    public static long readUInt64(ByteBuffer byteBuffer) {
        long readUInt32 = (readUInt32(byteBuffer) << 32) + 0;
        if (readUInt32 < 0) {
            throw new RuntimeException("I don't know how to deal with UInt64! long is not sufficient and I don't want to use BigInt");
        }
        return readUInt32 + readUInt32(byteBuffer);
    }

    public static double readFixedPoint1616(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[4];
        byteBuffer.get(bArr);
        return ((bArr[3] & 255) | (((((bArr[0] << 24) & ViewCompat.MEASURED_STATE_MASK) | 0) | ((bArr[1] << 16) & 16711680)) | ((bArr[2] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK))) / 65536.0d;
    }

    public static double readFixedPoint0230(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[4];
        byteBuffer.get(bArr);
        return ((bArr[3] & 255) | (((((bArr[0] << 24) & ViewCompat.MEASURED_STATE_MASK) | 0) | ((bArr[1] << 16) & 16711680)) | ((bArr[2] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK))) / 1.073741824E9d;
    }

    public static float readFixedPoint88(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[2];
        byteBuffer.get(bArr);
        return ((short) ((bArr[1] & 255) | ((short) (((bArr[0] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) | 0)))) / 256.0f;
    }

    public static String readIso639(ByteBuffer byteBuffer) {
        int readUInt16 = readUInt16(byteBuffer);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sb.append((char) (((readUInt16 >> ((2 - i) * 5)) & 31) + 96));
        }
        return sb.toString();
    }

    public static String read4cc(ByteBuffer byteBuffer) {
        byteBuffer.get(codeBytes);
        int i = (codeBytes[3] & 255) | ((codeBytes[0] << 24) & ViewCompat.MEASURED_STATE_MASK) | ((codeBytes[1] << 16) & 16711680) | ((codeBytes[2] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK);
        String str = (String) codeCache.get(i);
        if (str == null) {
            try {
                String str2 = new String(codeBytes, "ISO-8859-1");
                codeCache.put(i, str2);
                return str2;
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }
        }
        return str;
    }
}
