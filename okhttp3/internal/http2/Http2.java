package okhttp3.internal.http2;

import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import com.huawei.hms.common.internal.TransactionIdCreater;
import java.io.IOException;
import okhttp3.internal.Util;
import okio.ByteString;
/* loaded from: classes10.dex */
public final class Http2 {
    public static final byte FLAG_ACK = 1;
    public static final byte FLAG_COMPRESSED = 32;
    public static final byte FLAG_END_HEADERS = 4;
    public static final byte FLAG_END_PUSH_PROMISE = 4;
    public static final byte FLAG_END_STREAM = 1;
    public static final byte FLAG_NONE = 0;
    public static final byte FLAG_PADDED = 8;
    public static final byte FLAG_PRIORITY = 32;
    public static final int INITIAL_MAX_FRAME_SIZE = 16384;
    public static final byte TYPE_CONTINUATION = 9;
    public static final byte TYPE_DATA = 0;
    public static final byte TYPE_GOAWAY = 7;
    public static final byte TYPE_HEADERS = 1;
    public static final byte TYPE_PING = 6;
    public static final byte TYPE_PRIORITY = 2;
    public static final byte TYPE_PUSH_PROMISE = 5;
    public static final byte TYPE_RST_STREAM = 3;
    public static final byte TYPE_SETTINGS = 4;
    public static final byte TYPE_WINDOW_UPDATE = 8;
    public static final ByteString CONNECTION_PREFACE = ByteString.encodeUtf8("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
    public static final String[] FRAME_NAMES = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
    public static final String[] FLAGS = new String[64];
    public static final String[] BINARY = new String[256];

    static {
        int i;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            String[] strArr = BINARY;
            if (i3 >= strArr.length) {
                break;
            }
            strArr[i3] = Util.format("%8s", Integer.toBinaryString(i3)).replace(WebvttCueParser.CHAR_SPACE, TransactionIdCreater.FILL_BYTE);
            i3++;
        }
        String[] strArr2 = FLAGS;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        for (int i4 = 0; i4 < 1; i4++) {
            FLAGS[iArr[i4] | 8] = FLAGS[i] + "|PADDED";
        }
        String[] strArr3 = FLAGS;
        strArr3[4] = "END_HEADERS";
        strArr3[32] = "PRIORITY";
        strArr3[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i5 = 0; i5 < 3; i5++) {
            int i6 = iArr2[i5];
            for (int i7 = 0; i7 < 1; i7++) {
                int i8 = iArr[i7];
                int i9 = i8 | i6;
                FLAGS[i9] = FLAGS[i8] + '|' + FLAGS[i6];
                FLAGS[i9 | 8] = FLAGS[i8] + '|' + FLAGS[i6] + "|PADDED";
            }
        }
        while (true) {
            String[] strArr4 = FLAGS;
            if (i2 < strArr4.length) {
                if (strArr4[i2] == null) {
                    strArr4[i2] = BINARY[i2];
                }
                i2++;
            } else {
                return;
            }
        }
    }

    public static String formatFlags(byte b, byte b2) {
        String str;
        if (b2 == 0) {
            return "";
        }
        if (b != 2 && b != 3) {
            if (b != 4 && b != 6) {
                if (b != 7 && b != 8) {
                    String[] strArr = FLAGS;
                    if (b2 < strArr.length) {
                        str = strArr[b2];
                    } else {
                        str = BINARY[b2];
                    }
                    if (b == 5 && (b2 & 4) != 0) {
                        return str.replace("HEADERS", "PUSH_PROMISE");
                    }
                    if (b == 0 && (b2 & 32) != 0) {
                        return str.replace("PRIORITY", "COMPRESSED");
                    }
                    return str;
                }
            } else if (b2 == 1) {
                return "ACK";
            } else {
                return BINARY[b2];
            }
        }
        return BINARY[b2];
    }

    public static String frameLog(boolean z, int i, int i2, byte b, byte b2) {
        String format;
        String str;
        String[] strArr = FRAME_NAMES;
        if (b < strArr.length) {
            format = strArr[b];
        } else {
            format = Util.format("0x%02x", Byte.valueOf(b));
        }
        String formatFlags = formatFlags(b, b2);
        Object[] objArr = new Object[5];
        if (z) {
            str = "<<";
        } else {
            str = ">>";
        }
        objArr[0] = str;
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = format;
        objArr[4] = formatFlags;
        return Util.format("%s 0x%08x %5d %-13s %s", objArr);
    }

    public static IllegalArgumentException illegalArgument(String str, Object... objArr) {
        throw new IllegalArgumentException(Util.format(str, objArr));
    }

    public static IOException ioException(String str, Object... objArr) throws IOException {
        throw new IOException(Util.format(str, objArr));
    }
}
