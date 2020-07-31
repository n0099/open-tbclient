package org.brotli.dec;

import com.baidu.ala.helper.AlaLiveRtcConfig;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes4.dex */
final class a {
    int bitOffset;
    private InputStream input;
    private boolean ogI;
    long ogJ;
    private int ogK;
    private final byte[] ogF = new byte[4160];
    private final int[] ogG = new int[AlaLiveRtcConfig.NativeErroCode.ERROR_PROTOCAL_SESSION_ID];
    private final h ogH = new h();
    private int ogL = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003b, code lost:
        r5.ogI = true;
        r5.ogL = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0040, code lost:
        r0 = r0 + 3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(a aVar) {
        if (aVar.ogK > 1015) {
            if (aVar.ogI) {
                if (g(aVar) < -2) {
                    throw new BrotliRuntimeException("No more input");
                }
                return;
            }
            int i = aVar.ogK << 2;
            int i2 = 4096 - i;
            System.arraycopy(aVar.ogF, i, aVar.ogF, 0, i2);
            aVar.ogK = 0;
            while (true) {
                if (i2 >= 4096) {
                    break;
                }
                try {
                    int read = aVar.input.read(aVar.ogF, i2, 4096 - i2);
                    if (read <= 0) {
                        break;
                    }
                    i2 += read;
                } catch (IOException e) {
                    throw new BrotliRuntimeException("Failed to read input", e);
                }
            }
            h.a(aVar.ogH, i2 >> 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(a aVar, boolean z) {
        if (aVar.ogI) {
            int i = ((aVar.ogK << 2) + ((aVar.bitOffset + 7) >> 3)) - 8;
            if (i > aVar.ogL) {
                throw new BrotliRuntimeException("Read after end");
            }
            if (z && i != aVar.ogL) {
                throw new BrotliRuntimeException("Unused bytes after end");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(a aVar) {
        int i;
        if (aVar.bitOffset >= 32) {
            int[] iArr = aVar.ogG;
            aVar.ogK = aVar.ogK + 1;
            aVar.ogJ = (iArr[i] << 32) | (aVar.ogJ >>> 32);
            aVar.bitOffset -= 32;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(a aVar, int i) {
        b(aVar);
        int i2 = ((int) (aVar.ogJ >>> aVar.bitOffset)) & ((1 << i) - 1);
        aVar.bitOffset += i;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(a aVar, InputStream inputStream) {
        if (aVar.input != null) {
            throw new IllegalStateException("Bit reader already has associated input stream");
        }
        h.a(aVar.ogH, aVar.ogF, aVar.ogG);
        aVar.input = inputStream;
        aVar.ogJ = 0L;
        aVar.bitOffset = 64;
        aVar.ogK = 1024;
        aVar.ogI = false;
        c(aVar);
    }

    private static void c(a aVar) {
        a(aVar);
        a(aVar, false);
        b(aVar);
        b(aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d(a aVar) {
        if (aVar.bitOffset == 64) {
            c(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void e(a aVar) throws IOException {
        InputStream inputStream = aVar.input;
        aVar.input = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void f(a aVar) {
        int i = (64 - aVar.bitOffset) & 7;
        if (i != 0 && a(aVar, i) != 0) {
            throw new BrotliRuntimeException("Corrupted padding bits");
        }
    }

    static int g(a aVar) {
        int i = 1024;
        if (aVar.ogI) {
            i = (aVar.ogL + 3) >> 2;
        }
        return i - aVar.ogK;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(a aVar, byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        if ((aVar.bitOffset & 7) != 0) {
            throw new BrotliRuntimeException("Unaligned copyBytes");
        }
        while (aVar.bitOffset != 64 && i2 != 0) {
            bArr[i] = (byte) (aVar.ogJ >>> aVar.bitOffset);
            aVar.bitOffset += 8;
            i2--;
            i++;
        }
        if (i2 != 0) {
            int min = Math.min(g(aVar), i2 >> 2);
            if (min > 0) {
                System.arraycopy(aVar.ogF, aVar.ogK << 2, bArr, i, min << 2);
                i4 = i + (min << 2);
                i3 = i2 - (min << 2);
                aVar.ogK = min + aVar.ogK;
            } else {
                i3 = i2;
                i4 = i;
            }
            if (i3 != 0) {
                if (g(aVar) > 0) {
                    b(aVar);
                    while (i3 != 0) {
                        bArr[i4] = (byte) (aVar.ogJ >>> aVar.bitOffset);
                        aVar.bitOffset += 8;
                        i3--;
                        i4++;
                    }
                    a(aVar, false);
                    return;
                }
                while (i3 > 0) {
                    try {
                        int read = aVar.input.read(bArr, i4, i3);
                        if (read == -1) {
                            throw new BrotliRuntimeException("Unexpected end of input");
                        }
                        i4 += read;
                        i3 -= read;
                    } catch (IOException e) {
                        throw new BrotliRuntimeException("Failed to read input", e);
                    }
                }
            }
        }
    }
}
