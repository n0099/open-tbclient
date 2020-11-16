package com.sdk.base.framework.e;

import com.baidu.appsearch.update.patchupdate.GDiffPatcher;
import java.io.OutputStream;
import java.io.PushbackInputStream;
/* loaded from: classes8.dex */
public final class a extends d {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f4490a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    private static final byte[] b = new byte[256];
    private byte[] c = new byte[4];

    static {
        for (int i = 0; i < 255; i++) {
            b[i] = -1;
        }
        for (int i2 = 0; i2 < 64; i2++) {
            b[f4490a[i2]] = (byte) i2;
        }
    }

    @Override // com.sdk.base.framework.e.d
    protected final void a(PushbackInputStream pushbackInputStream, OutputStream outputStream, int i) {
        byte b2;
        byte b3;
        byte b4;
        byte b5 = -1;
        if (i < 2) {
            throw new b("BASE64Decoder: Not enough bytes for an atom.");
        }
        while (true) {
            int read = pushbackInputStream.read();
            if (read == -1) {
                throw new c();
            }
            if (read != 10 && read != 13) {
                this.c[0] = (byte) read;
                byte[] bArr = this.c;
                int i2 = i - 1;
                int i3 = 0;
                while (true) {
                    if (i3 >= i2) {
                        i3 = i2;
                        break;
                    }
                    int read2 = pushbackInputStream.read();
                    if (read2 != -1) {
                        bArr[i3 + 1] = (byte) read2;
                        i3++;
                    } else if (i3 == 0) {
                        i3 = -1;
                    }
                }
                if (i3 == -1) {
                    throw new c();
                }
                int i4 = (i <= 3 || this.c[3] != 61) ? i : 3;
                int i5 = (i4 <= 2 || this.c[2] != 61) ? i4 : 2;
                switch (i5) {
                    case 2:
                        b2 = -1;
                        b3 = b[this.c[1] & 255];
                        b4 = b[this.c[0] & 255];
                        break;
                    case 4:
                        b5 = b[this.c[3] & 255];
                    case 3:
                        b2 = b[this.c[2] & 255];
                        b3 = b[this.c[1] & 255];
                        b4 = b[this.c[0] & 255];
                        break;
                    default:
                        b2 = -1;
                        b3 = -1;
                        b4 = -1;
                        break;
                }
                switch (i5) {
                    case 2:
                        outputStream.write((byte) (((b4 << 2) & GDiffPatcher.COPY_INT_UBYTE) | ((b3 >>> 4) & 3)));
                        return;
                    case 3:
                        outputStream.write((byte) (((b4 << 2) & GDiffPatcher.COPY_INT_UBYTE) | ((b3 >>> 4) & 3)));
                        outputStream.write((byte) (((b3 << 4) & 240) | ((b2 >>> 2) & 15)));
                        return;
                    case 4:
                        outputStream.write((byte) (((b4 << 2) & GDiffPatcher.COPY_INT_UBYTE) | ((b3 >>> 4) & 3)));
                        outputStream.write((byte) (((b3 << 4) & 240) | ((b2 >>> 2) & 15)));
                        outputStream.write((byte) ((b5 & 63) | ((b2 << 6) & 192)));
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
