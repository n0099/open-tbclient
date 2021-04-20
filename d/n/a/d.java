package d.n.a;

import com.alibaba.fastjson.asm.Label;
import com.squareup.wire2.FieldEncoding;
import java.io.IOException;
import okio.BufferedSink;
import okio.ByteString;
/* loaded from: classes6.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final BufferedSink f67317a;

    public d(BufferedSink bufferedSink) {
        this.f67317a = bufferedSink;
    }

    public static int a(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public static long b(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    public static int c(int i) {
        return (i >> 31) ^ (i << 1);
    }

    public static long d(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static int e(int i) {
        if (i >= 0) {
            return i(i);
        }
        return 10;
    }

    public static int f(int i, FieldEncoding fieldEncoding) {
        return (i << 3) | fieldEncoding.value;
    }

    public static int g(int i) {
        return i(f(i, FieldEncoding.VARINT));
    }

    public static int h(String str) {
        int i;
        int length = str.length();
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            char charAt = str.charAt(i2);
            if (charAt >= 128) {
                if (charAt < 2048) {
                    i3 += 2;
                } else if (charAt < 55296 || charAt > 57343) {
                    i3 += 3;
                } else if (charAt <= 56319 && (i = i2 + 1) < length && str.charAt(i) >= 56320 && str.charAt(i) <= 57343) {
                    i3 += 4;
                    i2 = i;
                }
                i2++;
            }
            i3++;
            i2++;
        }
        return i3;
    }

    public static int i(int i) {
        if ((i & com.alipay.sdk.encrypt.a.f1921g) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return (i & Label.FORWARD_REFERENCE_TYPE_MASK) == 0 ? 4 : 5;
    }

    public static int j(long j) {
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
        return (j & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    public void k(ByteString byteString) throws IOException {
        this.f67317a.write(byteString);
    }

    public void l(int i) throws IOException {
        this.f67317a.writeIntLe(i);
    }

    public void m(long j) throws IOException {
        this.f67317a.writeLongLe(j);
    }

    public void n(int i) throws IOException {
        if (i >= 0) {
            q(i);
        } else {
            r(i);
        }
    }

    public void o(String str) throws IOException {
        this.f67317a.writeUtf8(str);
    }

    public void p(int i, FieldEncoding fieldEncoding) throws IOException {
        q(f(i, fieldEncoding));
    }

    public void q(int i) throws IOException {
        while ((i & com.alipay.sdk.encrypt.a.f1921g) != 0) {
            this.f67317a.writeByte((i & 127) | 128);
            i >>>= 7;
        }
        this.f67317a.writeByte(i);
    }

    public void r(long j) throws IOException {
        while (((-128) & j) != 0) {
            this.f67317a.writeByte((((int) j) & 127) | 128);
            j >>>= 7;
        }
        this.f67317a.writeByte((int) j);
    }
}
