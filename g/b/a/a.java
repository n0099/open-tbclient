package g.b.a;

import java.io.IOException;
import java.io.InputStream;
import org.brotli.dec.BrotliRuntimeException;
/* loaded from: classes7.dex */
public final class a {

    /* renamed from: d  reason: collision with root package name */
    public InputStream f67571d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f67572e;

    /* renamed from: f  reason: collision with root package name */
    public long f67573f;

    /* renamed from: g  reason: collision with root package name */
    public int f67574g;

    /* renamed from: h  reason: collision with root package name */
    public int f67575h;

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f67568a = new byte[4160];

    /* renamed from: b  reason: collision with root package name */
    public final int[] f67569b = new int[1040];

    /* renamed from: c  reason: collision with root package name */
    public final h f67570c = new h();
    public int i = 0;

    public static void a(a aVar, boolean z) {
        if (aVar.f67572e) {
            int i = ((aVar.f67575h << 2) + ((aVar.f67574g + 7) >> 3)) - 8;
            int i2 = aVar.i;
            if (i > i2) {
                throw new BrotliRuntimeException("Read after end");
            }
            if (z && i != i2) {
                throw new BrotliRuntimeException("Unused bytes after end");
            }
        }
    }

    public static void b(a aVar) throws IOException {
        InputStream inputStream = aVar.f67571d;
        aVar.f67571d = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    public static void c(a aVar, byte[] bArr, int i, int i2) {
        if ((aVar.f67574g & 7) != 0) {
            throw new BrotliRuntimeException("Unaligned copyBytes");
        }
        while (true) {
            int i3 = aVar.f67574g;
            if (i3 == 64 || i2 == 0) {
                break;
            }
            bArr[i] = (byte) (aVar.f67573f >>> i3);
            aVar.f67574g = i3 + 8;
            i2--;
            i++;
        }
        if (i2 == 0) {
            return;
        }
        int min = Math.min(f(aVar), i2 >> 2);
        if (min > 0) {
            int i4 = min << 2;
            System.arraycopy(aVar.f67568a, aVar.f67575h << 2, bArr, i, i4);
            i += i4;
            i2 -= i4;
            aVar.f67575h += min;
        }
        if (i2 == 0) {
            return;
        }
        if (f(aVar) <= 0) {
            while (i2 > 0) {
                try {
                    int read = aVar.f67571d.read(bArr, i, i2);
                    if (read == -1) {
                        throw new BrotliRuntimeException("Unexpected end of input");
                    }
                    i += read;
                    i2 -= read;
                } catch (IOException e2) {
                    throw new BrotliRuntimeException("Failed to read input", e2);
                }
            }
            return;
        }
        d(aVar);
        while (i2 != 0) {
            long j = aVar.f67573f;
            int i5 = aVar.f67574g;
            bArr[i] = (byte) (j >>> i5);
            aVar.f67574g = i5 + 8;
            i2--;
            i++;
        }
        a(aVar, false);
    }

    public static void d(a aVar) {
        int i = aVar.f67574g;
        if (i >= 32) {
            int[] iArr = aVar.f67569b;
            int i2 = aVar.f67575h;
            aVar.f67575h = i2 + 1;
            aVar.f67573f = (iArr[i2] << 32) | (aVar.f67573f >>> 32);
            aVar.f67574g = i - 32;
        }
    }

    public static void e(a aVar, InputStream inputStream) {
        if (aVar.f67571d == null) {
            h.b(aVar.f67570c, aVar.f67568a, aVar.f67569b);
            aVar.f67571d = inputStream;
            aVar.f67573f = 0L;
            aVar.f67574g = 64;
            aVar.f67575h = 1024;
            aVar.f67572e = false;
            h(aVar);
            return;
        }
        throw new IllegalStateException("Bit reader already has associated input stream");
    }

    public static int f(a aVar) {
        return (aVar.f67572e ? (aVar.i + 3) >> 2 : 1024) - aVar.f67575h;
    }

    public static void g(a aVar) {
        int i = (64 - aVar.f67574g) & 7;
        if (i != 0 && i(aVar, i) != 0) {
            throw new BrotliRuntimeException("Corrupted padding bits");
        }
    }

    public static void h(a aVar) {
        j(aVar);
        a(aVar, false);
        d(aVar);
        d(aVar);
    }

    public static int i(a aVar, int i) {
        d(aVar);
        long j = aVar.f67573f;
        int i2 = aVar.f67574g;
        int i3 = ((int) (j >>> i2)) & ((1 << i) - 1);
        aVar.f67574g = i2 + i;
        return i3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0037, code lost:
        r4.f67572e = true;
        r4.i = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003c, code lost:
        r1 = r1 + 3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void j(a aVar) {
        int i = aVar.f67575h;
        if (i <= 1015) {
            return;
        }
        if (aVar.f67572e) {
            if (f(aVar) < -2) {
                throw new BrotliRuntimeException("No more input");
            }
            return;
        }
        int i2 = i << 2;
        int i3 = 4096 - i2;
        byte[] bArr = aVar.f67568a;
        System.arraycopy(bArr, i2, bArr, 0, i3);
        aVar.f67575h = 0;
        while (true) {
            if (i3 >= 4096) {
                break;
            }
            try {
                int read = aVar.f67571d.read(aVar.f67568a, i3, 4096 - i3);
                if (read <= 0) {
                    break;
                }
                i3 += read;
            } catch (IOException e2) {
                throw new BrotliRuntimeException("Failed to read input", e2);
            }
        }
        h.a(aVar.f67570c, i3 >> 2);
    }

    public static void k(a aVar) {
        if (aVar.f67574g == 64) {
            h(aVar);
        }
    }
}
