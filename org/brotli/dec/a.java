package org.brotli.dec;

import com.baidu.ala.helper.AlaLiveRtcConfig;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes6.dex */
final class a {
    int bitOffset;
    private InputStream input;
    private boolean quY;
    long quZ;
    private int qva;
    private final byte[] quV = new byte[4160];
    private final int[] quW = new int[AlaLiveRtcConfig.NativeErroCode.ERROR_PROTOCAL_SESSION_ID];
    private final h quX = new h();
    private int qvb = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003b, code lost:
        r5.quY = true;
        r5.qvb = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0040, code lost:
        r0 = r0 + 3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(a aVar) {
        if (aVar.qva > 1015) {
            if (aVar.quY) {
                if (g(aVar) < -2) {
                    throw new BrotliRuntimeException("No more input");
                }
                return;
            }
            int i = aVar.qva << 2;
            int i2 = 4096 - i;
            System.arraycopy(aVar.quV, i, aVar.quV, 0, i2);
            aVar.qva = 0;
            while (true) {
                if (i2 >= 4096) {
                    break;
                }
                try {
                    int read = aVar.input.read(aVar.quV, i2, 4096 - i2);
                    if (read <= 0) {
                        break;
                    }
                    i2 += read;
                } catch (IOException e) {
                    throw new BrotliRuntimeException("Failed to read input", e);
                }
            }
            h.a(aVar.quX, i2 >> 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(a aVar, boolean z) {
        if (aVar.quY) {
            int i = ((aVar.qva << 2) + ((aVar.bitOffset + 7) >> 3)) - 8;
            if (i > aVar.qvb) {
                throw new BrotliRuntimeException("Read after end");
            }
            if (z && i != aVar.qvb) {
                throw new BrotliRuntimeException("Unused bytes after end");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(a aVar) {
        int i;
        if (aVar.bitOffset >= 32) {
            int[] iArr = aVar.quW;
            aVar.qva = aVar.qva + 1;
            aVar.quZ = (iArr[i] << 32) | (aVar.quZ >>> 32);
            aVar.bitOffset -= 32;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(a aVar, int i) {
        b(aVar);
        int i2 = ((int) (aVar.quZ >>> aVar.bitOffset)) & ((1 << i) - 1);
        aVar.bitOffset += i;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(a aVar, InputStream inputStream) {
        if (aVar.input != null) {
            throw new IllegalStateException("Bit reader already has associated input stream");
        }
        h.a(aVar.quX, aVar.quV, aVar.quW);
        aVar.input = inputStream;
        aVar.quZ = 0L;
        aVar.bitOffset = 64;
        aVar.qva = 1024;
        aVar.quY = false;
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
        if (aVar.quY) {
            i = (aVar.qvb + 3) >> 2;
        }
        return i - aVar.qva;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(a aVar, byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        if ((aVar.bitOffset & 7) != 0) {
            throw new BrotliRuntimeException("Unaligned copyBytes");
        }
        while (aVar.bitOffset != 64 && i2 != 0) {
            bArr[i] = (byte) (aVar.quZ >>> aVar.bitOffset);
            aVar.bitOffset += 8;
            i2--;
            i++;
        }
        if (i2 != 0) {
            int min = Math.min(g(aVar), i2 >> 2);
            if (min > 0) {
                System.arraycopy(aVar.quV, aVar.qva << 2, bArr, i, min << 2);
                i4 = i + (min << 2);
                i3 = i2 - (min << 2);
                aVar.qva = min + aVar.qva;
            } else {
                i3 = i2;
                i4 = i;
            }
            if (i3 != 0) {
                if (g(aVar) > 0) {
                    b(aVar);
                    while (i3 != 0) {
                        bArr[i4] = (byte) (aVar.quZ >>> aVar.bitOffset);
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
