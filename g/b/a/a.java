package g.b.a;

import java.io.IOException;
import java.io.InputStream;
import org.brotli.dec.BrotliRuntimeException;
/* loaded from: classes8.dex */
public final class a {

    /* renamed from: d  reason: collision with root package name */
    public InputStream f71571d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f71572e;

    /* renamed from: f  reason: collision with root package name */
    public long f71573f;

    /* renamed from: g  reason: collision with root package name */
    public int f71574g;

    /* renamed from: h  reason: collision with root package name */
    public int f71575h;

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f71568a = new byte[4160];

    /* renamed from: b  reason: collision with root package name */
    public final int[] f71569b = new int[1040];

    /* renamed from: c  reason: collision with root package name */
    public final h f71570c = new h();

    /* renamed from: i  reason: collision with root package name */
    public int f71576i = 0;

    public static void a(a aVar, boolean z) {
        if (aVar.f71572e) {
            int i2 = ((aVar.f71575h << 2) + ((aVar.f71574g + 7) >> 3)) - 8;
            int i3 = aVar.f71576i;
            if (i2 > i3) {
                throw new BrotliRuntimeException("Read after end");
            }
            if (z && i2 != i3) {
                throw new BrotliRuntimeException("Unused bytes after end");
            }
        }
    }

    public static void b(a aVar) throws IOException {
        InputStream inputStream = aVar.f71571d;
        aVar.f71571d = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    public static void c(a aVar, byte[] bArr, int i2, int i3) {
        if ((aVar.f71574g & 7) != 0) {
            throw new BrotliRuntimeException("Unaligned copyBytes");
        }
        while (true) {
            int i4 = aVar.f71574g;
            if (i4 == 64 || i3 == 0) {
                break;
            }
            bArr[i2] = (byte) (aVar.f71573f >>> i4);
            aVar.f71574g = i4 + 8;
            i3--;
            i2++;
        }
        if (i3 == 0) {
            return;
        }
        int min = Math.min(f(aVar), i3 >> 2);
        if (min > 0) {
            int i5 = min << 2;
            System.arraycopy(aVar.f71568a, aVar.f71575h << 2, bArr, i2, i5);
            i2 += i5;
            i3 -= i5;
            aVar.f71575h += min;
        }
        if (i3 == 0) {
            return;
        }
        if (f(aVar) <= 0) {
            while (i3 > 0) {
                try {
                    int read = aVar.f71571d.read(bArr, i2, i3);
                    if (read == -1) {
                        throw new BrotliRuntimeException("Unexpected end of input");
                    }
                    i2 += read;
                    i3 -= read;
                } catch (IOException e2) {
                    throw new BrotliRuntimeException("Failed to read input", e2);
                }
            }
            return;
        }
        d(aVar);
        while (i3 != 0) {
            long j = aVar.f71573f;
            int i6 = aVar.f71574g;
            bArr[i2] = (byte) (j >>> i6);
            aVar.f71574g = i6 + 8;
            i3--;
            i2++;
        }
        a(aVar, false);
    }

    public static void d(a aVar) {
        int i2 = aVar.f71574g;
        if (i2 >= 32) {
            int[] iArr = aVar.f71569b;
            int i3 = aVar.f71575h;
            aVar.f71575h = i3 + 1;
            aVar.f71573f = (iArr[i3] << 32) | (aVar.f71573f >>> 32);
            aVar.f71574g = i2 - 32;
        }
    }

    public static void e(a aVar, InputStream inputStream) {
        if (aVar.f71571d == null) {
            h.b(aVar.f71570c, aVar.f71568a, aVar.f71569b);
            aVar.f71571d = inputStream;
            aVar.f71573f = 0L;
            aVar.f71574g = 64;
            aVar.f71575h = 1024;
            aVar.f71572e = false;
            h(aVar);
            return;
        }
        throw new IllegalStateException("Bit reader already has associated input stream");
    }

    public static int f(a aVar) {
        return (aVar.f71572e ? (aVar.f71576i + 3) >> 2 : 1024) - aVar.f71575h;
    }

    public static void g(a aVar) {
        int i2 = (64 - aVar.f71574g) & 7;
        if (i2 != 0 && i(aVar, i2) != 0) {
            throw new BrotliRuntimeException("Corrupted padding bits");
        }
    }

    public static void h(a aVar) {
        j(aVar);
        a(aVar, false);
        d(aVar);
        d(aVar);
    }

    public static int i(a aVar, int i2) {
        d(aVar);
        long j = aVar.f71573f;
        int i3 = aVar.f71574g;
        int i4 = ((int) (j >>> i3)) & ((1 << i2) - 1);
        aVar.f71574g = i3 + i2;
        return i4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0037, code lost:
        r4.f71572e = true;
        r4.f71576i = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003c, code lost:
        r1 = r1 + 3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void j(a aVar) {
        int i2 = aVar.f71575h;
        if (i2 <= 1015) {
            return;
        }
        if (aVar.f71572e) {
            if (f(aVar) < -2) {
                throw new BrotliRuntimeException("No more input");
            }
            return;
        }
        int i3 = i2 << 2;
        int i4 = 4096 - i3;
        byte[] bArr = aVar.f71568a;
        System.arraycopy(bArr, i3, bArr, 0, i4);
        aVar.f71575h = 0;
        while (true) {
            if (i4 >= 4096) {
                break;
            }
            try {
                int read = aVar.f71571d.read(aVar.f71568a, i4, 4096 - i4);
                if (read <= 0) {
                    break;
                }
                i4 += read;
            } catch (IOException e2) {
                throw new BrotliRuntimeException("Failed to read input", e2);
            }
        }
        h.a(aVar.f71570c, i4 >> 2);
    }

    public static void k(a aVar) {
        if (aVar.f71574g == 64) {
            h(aVar);
        }
    }
}
