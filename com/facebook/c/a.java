package com.facebook.c;

import com.facebook.c.c;
import com.facebook.common.internal.g;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class a implements c.a {
    private static final byte[] ked = {-1, -40, -1};
    private static final int kee = ked.length;
    private static final byte[] kef = {-119, 80, 78, 71, 13, 10, 26, 10};
    private static final int keg = kef.length;
    private static final byte[] keh = e.HK("GIF87a");
    private static final byte[] kei = e.HK("GIF89a");
    private static final byte[] kej = e.HK("BM");
    private static final int kek = kej.length;
    final int kec = com.facebook.common.internal.e.l(21, 20, kee, keg, 6, kek);

    @Override // com.facebook.c.c.a
    public int getHeaderSize() {
        return this.kec;
    }

    @Override // com.facebook.c.c.a
    @Nullable
    public final c l(byte[] bArr, int i) {
        g.checkNotNull(bArr);
        if (com.facebook.common.g.c.o(bArr, 0, i)) {
            return m(bArr, i);
        }
        if (n(bArr, i)) {
            return b.kel;
        }
        if (o(bArr, i)) {
            return b.kem;
        }
        if (p(bArr, i)) {
            return b.ken;
        }
        if (q(bArr, i)) {
            return b.keo;
        }
        return c.keu;
    }

    private static c m(byte[] bArr, int i) {
        g.checkArgument(com.facebook.common.g.c.o(bArr, 0, i));
        if (com.facebook.common.g.c.i(bArr, 0)) {
            return b.kep;
        }
        if (com.facebook.common.g.c.j(bArr, 0)) {
            return b.keq;
        }
        if (com.facebook.common.g.c.n(bArr, 0, i)) {
            if (com.facebook.common.g.c.h(bArr, 0)) {
                return b.ket;
            }
            if (com.facebook.common.g.c.k(bArr, 0)) {
                return b.kes;
            }
            return b.ker;
        }
        return c.keu;
    }

    private static boolean n(byte[] bArr, int i) {
        return i >= ked.length && e.c(bArr, ked);
    }

    private static boolean o(byte[] bArr, int i) {
        return i >= kef.length && e.c(bArr, kef);
    }

    private static boolean p(byte[] bArr, int i) {
        if (i < 6) {
            return false;
        }
        return e.c(bArr, keh) || e.c(bArr, kei);
    }

    private static boolean q(byte[] bArr, int i) {
        if (i < kej.length) {
            return false;
        }
        return e.c(bArr, kej);
    }
}
