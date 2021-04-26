package com.coremedia.iso;

import androidx.core.view.ViewCompat;
import java.nio.ByteBuffer;
import okhttp3.internal.ws.WebSocketProtocol;
/* loaded from: classes6.dex */
public final class IsoTypeWriter {
    public static final /* synthetic */ boolean $assertionsDisabled = false;

    public static void writeFixedPoint0230(ByteBuffer byteBuffer, double d2) {
        int i2 = (int) (d2 * 1.073741824E9d);
        byteBuffer.put((byte) (((-16777216) & i2) >> 24));
        byteBuffer.put((byte) ((16711680 & i2) >> 16));
        byteBuffer.put((byte) ((65280 & i2) >> 8));
        byteBuffer.put((byte) (i2 & 255));
    }

    public static void writeFixedPoint1616(ByteBuffer byteBuffer, double d2) {
        int i2 = (int) (d2 * 65536.0d);
        byteBuffer.put((byte) (((-16777216) & i2) >> 24));
        byteBuffer.put((byte) ((16711680 & i2) >> 16));
        byteBuffer.put((byte) ((65280 & i2) >> 8));
        byteBuffer.put((byte) (i2 & 255));
    }

    public static void writeFixedPoint88(ByteBuffer byteBuffer, double d2) {
        short s = (short) (d2 * 256.0d);
        byteBuffer.put((byte) ((65280 & s) >> 8));
        byteBuffer.put((byte) (s & 255));
    }

    public static void writeIso639(ByteBuffer byteBuffer, String str) {
        if (str.getBytes().length == 3) {
            int i2 = 0;
            for (int i3 = 0; i3 < 3; i3++) {
                i2 += (str.getBytes()[i3] - 96) << ((2 - i3) * 5);
            }
            writeUInt16(byteBuffer, i2);
            return;
        }
        throw new IllegalArgumentException("\"" + str + "\" language string isn't exactly 3 characters long!");
    }

    public static void writePascalUtfString(ByteBuffer byteBuffer, String str) {
        byte[] convert = Utf8.convert(str);
        writeUInt8(byteBuffer, convert.length);
        byteBuffer.put(convert);
    }

    public static void writeUInt16(ByteBuffer byteBuffer, int i2) {
        int i3 = i2 & 65535;
        writeUInt8(byteBuffer, i3 >> 8);
        writeUInt8(byteBuffer, i3 & 255);
    }

    public static void writeUInt16BE(ByteBuffer byteBuffer, int i2) {
        int i3 = i2 & 65535;
        writeUInt8(byteBuffer, i3 & 255);
        writeUInt8(byteBuffer, i3 >> 8);
    }

    public static void writeUInt24(ByteBuffer byteBuffer, int i2) {
        int i3 = i2 & ViewCompat.MEASURED_SIZE_MASK;
        writeUInt16(byteBuffer, i3 >> 8);
        writeUInt8(byteBuffer, i3);
    }

    public static void writeUInt32(ByteBuffer byteBuffer, long j) {
        byteBuffer.putInt((int) j);
    }

    public static void writeUInt32BE(ByteBuffer byteBuffer, long j) {
        writeUInt16BE(byteBuffer, ((int) j) & 65535);
        writeUInt16BE(byteBuffer, (int) ((j >> 16) & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    public static void writeUInt64(ByteBuffer byteBuffer, long j) {
        byteBuffer.putLong(j);
    }

    public static void writeUInt8(ByteBuffer byteBuffer, int i2) {
        byteBuffer.put((byte) (i2 & 255));
    }

    public static void writeUtf8String(ByteBuffer byteBuffer, String str) {
        byteBuffer.put(Utf8.convert(str));
        writeUInt8(byteBuffer, 0);
    }

    public static void writeZeroTermUtf8String(ByteBuffer byteBuffer, String str) {
        byteBuffer.put(Utf8.convert(str));
        writeUInt8(byteBuffer, 0);
    }
}
