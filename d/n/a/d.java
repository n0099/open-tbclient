package d.n.a;

import com.alibaba.fastjson.asm.Label;
import com.squareup.wire2.FieldEncoding;
import java.io.IOException;
import kotlinx.coroutines.scheduling.CoroutineScheduler;
import okio.BufferedSink;
import okio.ByteString;
/* loaded from: classes6.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final BufferedSink f65794a;

    public d(BufferedSink bufferedSink) {
        this.f65794a = bufferedSink;
    }

    public static int a(int i2) {
        return (-(i2 & 1)) ^ (i2 >>> 1);
    }

    public static long b(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    public static int c(int i2) {
        return (i2 >> 31) ^ (i2 << 1);
    }

    public static long d(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static int e(int i2) {
        if (i2 >= 0) {
            return i(i2);
        }
        return 10;
    }

    public static int f(int i2, FieldEncoding fieldEncoding) {
        return (i2 << 3) | fieldEncoding.value;
    }

    public static int g(int i2) {
        return i(f(i2, FieldEncoding.VARINT));
    }

    public static int h(String str) {
        int i2;
        int length = str.length();
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            char charAt = str.charAt(i3);
            if (charAt >= 128) {
                if (charAt < 2048) {
                    i4 += 2;
                } else if (charAt < 55296 || charAt > 57343) {
                    i4 += 3;
                } else if (charAt <= 56319 && (i2 = i3 + 1) < length && str.charAt(i2) >= 56320 && str.charAt(i2) <= 57343) {
                    i4 += 4;
                    i3 = i2;
                }
                i3++;
            }
            i4++;
            i3++;
        }
        return i4;
    }

    public static int i(int i2) {
        if ((i2 & com.alipay.sdk.encrypt.a.f1872g) == 0) {
            return 1;
        }
        if ((i2 & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i2) == 0) {
            return 3;
        }
        return (i2 & Label.FORWARD_REFERENCE_TYPE_MASK) == 0 ? 4 : 5;
    }

    public static int j(long j) {
        if (((-128) & j) == 0) {
            return 1;
        }
        if (((-16384) & j) == 0) {
            return 2;
        }
        if ((CoroutineScheduler.PARKED_VERSION_MASK & j) == 0) {
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
        return (j & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    public void k(ByteString byteString) throws IOException {
        this.f65794a.write(byteString);
    }

    public void l(int i2) throws IOException {
        this.f65794a.writeIntLe(i2);
    }

    public void m(long j) throws IOException {
        this.f65794a.writeLongLe(j);
    }

    public void n(int i2) throws IOException {
        if (i2 >= 0) {
            q(i2);
        } else {
            r(i2);
        }
    }

    public void o(String str) throws IOException {
        this.f65794a.writeUtf8(str);
    }

    public void p(int i2, FieldEncoding fieldEncoding) throws IOException {
        q(f(i2, fieldEncoding));
    }

    public void q(int i2) throws IOException {
        while ((i2 & com.alipay.sdk.encrypt.a.f1872g) != 0) {
            this.f65794a.writeByte((i2 & 127) | 128);
            i2 >>>= 7;
        }
        this.f65794a.writeByte(i2);
    }

    public void r(long j) throws IOException {
        while (((-128) & j) != 0) {
            this.f65794a.writeByte((((int) j) & 127) | 128);
            j >>>= 7;
        }
        this.f65794a.writeByte((int) j);
    }
}
