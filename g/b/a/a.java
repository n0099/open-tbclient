package g.b.a;

import java.io.IOException;
import java.io.InputStream;
import org.brotli.dec.BrotliRuntimeException;
/* loaded from: classes7.dex */
public final class a {

    /* renamed from: d  reason: collision with root package name */
    public InputStream f68729d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f68730e;

    /* renamed from: f  reason: collision with root package name */
    public long f68731f;

    /* renamed from: g  reason: collision with root package name */
    public int f68732g;

    /* renamed from: h  reason: collision with root package name */
    public int f68733h;

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f68726a = new byte[4160];

    /* renamed from: b  reason: collision with root package name */
    public final int[] f68727b = new int[1040];

    /* renamed from: c  reason: collision with root package name */
    public final h f68728c = new h();
    public int i = 0;

    public static void a(a aVar, boolean z) {
        if (aVar.f68730e) {
            int i = ((aVar.f68733h << 2) + ((aVar.f68732g + 7) >> 3)) - 8;
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
        InputStream inputStream = aVar.f68729d;
        aVar.f68729d = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    public static void c(a aVar, byte[] bArr, int i, int i2) {
        if ((aVar.f68732g & 7) != 0) {
            throw new BrotliRuntimeException("Unaligned copyBytes");
        }
        while (true) {
            int i3 = aVar.f68732g;
            if (i3 == 64 || i2 == 0) {
                break;
            }
            bArr[i] = (byte) (aVar.f68731f >>> i3);
            aVar.f68732g = i3 + 8;
            i2--;
            i++;
        }
        if (i2 == 0) {
            return;
        }
        int min = Math.min(f(aVar), i2 >> 2);
        if (min > 0) {
            int i4 = min << 2;
            System.arraycopy(aVar.f68726a, aVar.f68733h << 2, bArr, i, i4);
            i += i4;
            i2 -= i4;
            aVar.f68733h += min;
        }
        if (i2 == 0) {
            return;
        }
        if (f(aVar) <= 0) {
            while (i2 > 0) {
                try {
                    int read = aVar.f68729d.read(bArr, i, i2);
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
            long j = aVar.f68731f;
            int i5 = aVar.f68732g;
            bArr[i] = (byte) (j >>> i5);
            aVar.f68732g = i5 + 8;
            i2--;
            i++;
        }
        a(aVar, false);
    }

    public static void d(a aVar) {
        int i = aVar.f68732g;
        if (i >= 32) {
            int[] iArr = aVar.f68727b;
            int i2 = aVar.f68733h;
            aVar.f68733h = i2 + 1;
            aVar.f68731f = (iArr[i2] << 32) | (aVar.f68731f >>> 32);
            aVar.f68732g = i - 32;
        }
    }

    public static void e(a aVar, InputStream inputStream) {
        if (aVar.f68729d == null) {
            h.b(aVar.f68728c, aVar.f68726a, aVar.f68727b);
            aVar.f68729d = inputStream;
            aVar.f68731f = 0L;
            aVar.f68732g = 64;
            aVar.f68733h = 1024;
            aVar.f68730e = false;
            h(aVar);
            return;
        }
        throw new IllegalStateException("Bit reader already has associated input stream");
    }

    public static int f(a aVar) {
        return (aVar.f68730e ? (aVar.i + 3) >> 2 : 1024) - aVar.f68733h;
    }

    public static void g(a aVar) {
        int i = (64 - aVar.f68732g) & 7;
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
        long j = aVar.f68731f;
        int i2 = aVar.f68732g;
        int i3 = ((int) (j >>> i2)) & ((1 << i) - 1);
        aVar.f68732g = i2 + i;
        return i3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0037, code lost:
        r4.f68730e = true;
        r4.i = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003c, code lost:
        r1 = r1 + 3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void j(a aVar) {
        int i = aVar.f68733h;
        if (i <= 1015) {
            return;
        }
        if (aVar.f68730e) {
            if (f(aVar) < -2) {
                throw new BrotliRuntimeException("No more input");
            }
            return;
        }
        int i2 = i << 2;
        int i3 = 4096 - i2;
        byte[] bArr = aVar.f68726a;
        System.arraycopy(bArr, i2, bArr, 0, i3);
        aVar.f68733h = 0;
        while (true) {
            if (i3 >= 4096) {
                break;
            }
            try {
                int read = aVar.f68729d.read(aVar.f68726a, i3, 4096 - i3);
                if (read <= 0) {
                    break;
                }
                i3 += read;
            } catch (IOException e2) {
                throw new BrotliRuntimeException("Failed to read input", e2);
            }
        }
        h.a(aVar.f68728c, i3 >> 2);
    }

    public static void k(a aVar) {
        if (aVar.f68732g == 64) {
            h(aVar);
        }
    }
}
