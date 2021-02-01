package com.squareup.wire2;

import com.thunder.livesdk.system.ThunderNetStateService;
import java.io.IOException;
import okio.BufferedSink;
import okio.ByteString;
/* loaded from: classes4.dex */
public final class d {
    private final BufferedSink sink;

    private static int a(int i, FieldEncoding fieldEncoding) {
        return (i << 3) | fieldEncoding.value;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int QK(int i) {
        return varint32Size(a(i, FieldEncoding.VARINT));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int utf8Length(String str) {
        int i;
        int length = str.length();
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            char charAt = str.charAt(i2);
            if (charAt < 128) {
                i = i3 + 1;
            } else if (charAt < 2048) {
                i = i3 + 2;
            } else if (charAt < 55296 || charAt > 57343) {
                i = i3 + 3;
            } else if (charAt <= 56319 && i2 + 1 < length && str.charAt(i2 + 1) >= 56320 && str.charAt(i2 + 1) <= 57343) {
                i = i3 + 4;
                i2++;
            } else {
                i = i3 + 1;
            }
            i2++;
            i3 = i;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int int32Size(int i) {
        if (i >= 0) {
            return varint32Size(i);
        }
        return 10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int varint32Size(int i) {
        if ((i & (-128)) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return ((-268435456) & i) == 0 ? 4 : 5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int varint64Size(long j) {
        if (((-128) & j) == 0) {
            return 1;
        }
        if (((-16384) & j) == 0) {
            return 2;
        }
        if (((-2097152) & j) == 0) {
            return 3;
        }
        if (((-268435456) & j) == 0) {
            return 4;
        }
        if (((-34359738368L) & j) == 0) {
            return 5;
        }
        if (((-4398046511104L) & j) == 0) {
            return 6;
        }
        if (((-562949953421312L) & j) == 0) {
            return 7;
        }
        if (((-72057594037927936L) & j) == 0) {
            return 8;
        }
        return (Long.MIN_VALUE & j) == 0 ? 9 : 10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int encodeZigZag32(int i) {
        return (i << 1) ^ (i >> 31);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int decodeZigZag32(int i) {
        return (i >>> 1) ^ (-(i & 1));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long encodeZigZag64(long j) {
        return (j << 1) ^ (j >> 63);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long decodeZigZag64(long j) {
        return (j >>> 1) ^ (-(1 & j));
    }

    public d(BufferedSink bufferedSink) {
        this.sink = bufferedSink;
    }

    public void b(ByteString byteString) throws IOException {
        this.sink.write(byteString);
    }

    public void writeString(String str) throws IOException {
        this.sink.writeUtf8(str);
    }

    public void b(int i, FieldEncoding fieldEncoding) throws IOException {
        writeVarint32(a(i, fieldEncoding));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeSignedVarint32(int i) throws IOException {
        if (i >= 0) {
            writeVarint32(i);
        } else {
            writeVarint64(i);
        }
    }

    public void writeVarint32(int i) throws IOException {
        while ((i & (-128)) != 0) {
            this.sink.writeByte((i & ThunderNetStateService.NetState.SYSNET_UNKNOWN) | 128);
            i >>>= 7;
        }
        this.sink.writeByte(i);
    }

    public void writeVarint64(long j) throws IOException {
        while (((-128) & j) != 0) {
            this.sink.writeByte((((int) j) & ThunderNetStateService.NetState.SYSNET_UNKNOWN) | 128);
            j >>>= 7;
        }
        this.sink.writeByte((int) j);
    }

    public void writeFixed32(int i) throws IOException {
        this.sink.writeIntLe(i);
    }

    public void writeFixed64(long j) throws IOException {
        this.sink.writeLongLe(j);
    }
}
