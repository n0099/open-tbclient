package com.kwad.components.core.e.b;

import java.nio.ByteBuffer;
import okhttp3.internal.ws.WebSocketProtocol;
/* loaded from: classes10.dex */
public final class c {
    public final int[] Kc;

    public c(int[] iArr) {
        this.Kc = iArr;
    }

    public static c a(int[] iArr) {
        return new c(iArr);
    }

    public final String u(long j) {
        return com.kwad.sdk.core.a.c.Cj().encodeToString(ByteBuffer.allocate(8).putLong(a(j, this.Kc)).array());
    }

    public static long a(int i, int[] iArr, long j) {
        long j2 = j >>> 48;
        long j3 = (j >> 32) & WebSocketProtocol.PAYLOAD_SHORT_MAX;
        return (e(i, iArr, j2) << 32) | ((((j & WebSocketProtocol.PAYLOAD_SHORT_MAX) ^ e(i, iArr, j2)) ^ (i + 1)) << 48) | (j3 << 16) | ((j >> 16) & WebSocketProtocol.PAYLOAD_SHORT_MAX);
    }

    public static long b(int i, int[] iArr, long j) {
        long j2 = j >>> 48;
        long j3 = (j >> 32) & WebSocketProtocol.PAYLOAD_SHORT_MAX;
        long j4 = (j >> 16) & WebSocketProtocol.PAYLOAD_SHORT_MAX;
        long j5 = j & WebSocketProtocol.PAYLOAD_SHORT_MAX;
        long e = e(i, iArr, j2);
        return (((i + 1) ^ (j2 ^ j3)) << 16) | (j5 << 48) | (e << 32) | j4;
    }

    public static long c(int i, int[] iArr, long j) {
        long j2 = j >>> 48;
        long j3 = (j >> 32) & WebSocketProtocol.PAYLOAD_SHORT_MAX;
        long j4 = (j >> 16) & WebSocketProtocol.PAYLOAD_SHORT_MAX;
        long j5 = j & WebSocketProtocol.PAYLOAD_SHORT_MAX;
        long f = f(i, iArr, j3);
        return ((i + 1) ^ (j2 ^ j3)) | (j5 << 16) | (f << 48) | (j4 << 32);
    }

    public static long d(int i, int[] iArr, long j) {
        long j2 = j >>> 48;
        long j3 = (j >> 32) & WebSocketProtocol.PAYLOAD_SHORT_MAX;
        long j4 = (j >> 16) & WebSocketProtocol.PAYLOAD_SHORT_MAX;
        long j5 = j & WebSocketProtocol.PAYLOAD_SHORT_MAX;
        long f = f(i, iArr, j3);
        return (((i + 1) ^ (f(i, iArr, j3) ^ j4)) << 32) | (f << 48) | (j5 << 16) | j2;
    }

    public static long a(long j, int[] iArr) {
        int i = 0;
        while (i < 8) {
            j = a(i, iArr, j);
            i++;
        }
        while (i < 16) {
            j = b(i, iArr, j);
            i++;
        }
        while (i < 24) {
            j = a(i, iArr, j);
            i++;
        }
        while (i < 32) {
            j = b(i, iArr, j);
            i++;
        }
        return j;
    }

    public static long b(long j, int[] iArr) {
        int i = 31;
        while (i > 23) {
            j = d(i, iArr, j);
            i--;
        }
        while (i > 15) {
            j = c(i, iArr, j);
            i--;
        }
        while (i > 7) {
            j = d(i, iArr, j);
            i--;
        }
        while (i >= 0) {
            j = c(i, iArr, j);
            i--;
        }
        return j;
    }

    public static long e(int i, int[] iArr, long j) {
        int i2 = (int) (j >>> 8);
        int i3 = (int) (j & 255);
        int i4 = i * 4;
        int i5 = iArr[i4 % 10];
        int i6 = iArr[(i4 + 1) % 10];
        int i7 = iArr[(i4 + 2) % 10];
        int i8 = iArr[(i4 + 3) % 10];
        int[] iArr2 = b.Kb;
        int i9 = iArr2[i5 ^ i3] ^ i2;
        int i10 = i3 ^ iArr2[i6 ^ i9];
        int i11 = i9 ^ iArr2[i10 ^ i7];
        return (i11 << 8) | (iArr2[i8 ^ i11] ^ i10);
    }

    public static long f(int i, int[] iArr, long j) {
        int i2 = (int) (j >>> 8);
        int i3 = i * 4;
        int i4 = iArr[(i3 + 3) % 10];
        int i5 = iArr[(i3 + 2) % 10];
        int i6 = iArr[(i3 + 1) % 10];
        int i7 = iArr[i3 % 10];
        int[] iArr2 = b.Kb;
        int i8 = iArr2[i4 ^ i2] ^ ((int) (255 & j));
        int i9 = i2 ^ iArr2[i8 ^ i5];
        int i10 = i8 ^ iArr2[i9 ^ i6];
        return ((iArr2[i7 ^ i10] ^ i9) << 8) | i10;
    }

    public final long ad(String str) {
        byte[] decode = com.kwad.sdk.core.a.c.Cl().decode(str);
        if (decode != null && decode.length == 8) {
            return b(ByteBuffer.wrap(decode).getLong(), this.Kc);
        }
        throw new RuntimeException("fail to decode: " + str);
    }
}
