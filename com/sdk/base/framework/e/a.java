package com.sdk.base.framework.e;

import com.baidu.appsearch.update.patchupdate.GDiffPatcher;
import java.io.OutputStream;
import java.io.PushbackInputStream;
/* loaded from: classes6.dex */
public final class a extends d {

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f38534a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};

    /* renamed from: b  reason: collision with root package name */
    public static final byte[] f38535b = new byte[256];

    /* renamed from: c  reason: collision with root package name */
    public byte[] f38536c = new byte[4];

    static {
        for (int i = 0; i < 255; i++) {
            f38535b[i] = -1;
        }
        for (int i2 = 0; i2 < 64; i2++) {
            f38535b[f38534a[i2]] = (byte) i2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00c5  */
    @Override // com.sdk.base.framework.e.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(PushbackInputStream pushbackInputStream, OutputStream outputStream, int i) {
        byte b2;
        byte b3;
        byte b4;
        byte b5;
        int i2;
        if (i < 2) {
            throw new b("BASE64Decoder: Not enough bytes for an atom.");
        }
        while (true) {
            int read = pushbackInputStream.read();
            byte b6 = -1;
            if (read == -1) {
                throw new c();
            }
            if (read != 10 && read != 13) {
                byte[] bArr = this.f38536c;
                bArr[0] = (byte) read;
                int i3 = i - 1;
                int i4 = 0;
                while (true) {
                    if (i4 >= i3) {
                        break;
                    }
                    int read2 = pushbackInputStream.read();
                    if (read2 == -1) {
                        i3 = i4 == 0 ? -1 : i4;
                    } else {
                        i4++;
                        bArr[i4] = (byte) read2;
                    }
                }
                if (i3 == -1) {
                    throw new c();
                }
                if (i > 3 && this.f38536c[3] == 61) {
                    i = 3;
                }
                if (i > 2 && this.f38536c[2] == 61) {
                    i = 2;
                }
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            b4 = -1;
                            b5 = -1;
                            b3 = -1;
                            if (i != 2) {
                                i2 = ((b3 >>> 4) & 3) | ((b6 << 2) & GDiffPatcher.COPY_INT_UBYTE);
                            } else if (i != 3) {
                                if (i != 4) {
                                    return;
                                }
                                outputStream.write((byte) (((b6 << 2) & GDiffPatcher.COPY_INT_UBYTE) | ((b3 >>> 4) & 3)));
                                outputStream.write((byte) (((b3 << 4) & 240) | ((b4 >>> 2) & 15)));
                                outputStream.write((byte) (((b4 << 6) & 192) | (b5 & 63)));
                                return;
                            } else {
                                outputStream.write((byte) (((b6 << 2) & GDiffPatcher.COPY_INT_UBYTE) | (3 & (b3 >>> 4))));
                                i2 = ((b3 << 4) & 240) | ((b4 >>> 2) & 15);
                            }
                            outputStream.write((byte) i2);
                            return;
                        }
                        b6 = f38535b[this.f38536c[3] & 255];
                    }
                    b2 = b6;
                    b6 = f38535b[this.f38536c[2] & 255];
                } else {
                    b2 = -1;
                }
                byte[] bArr2 = f38535b;
                byte[] bArr3 = this.f38536c;
                b3 = bArr2[bArr3[1] & 255];
                byte b7 = b2;
                b4 = b6;
                b6 = bArr2[bArr3[0] & 255];
                b5 = b7;
                if (i != 2) {
                }
                outputStream.write((byte) i2);
                return;
            }
        }
    }
}
