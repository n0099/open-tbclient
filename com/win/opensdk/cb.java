package com.win.opensdk;

import androidx.core.view.ViewCompat;
import com.baidu.appsearch.update.patchupdate.GDiffPatcher;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
/* loaded from: classes3.dex */
public final class cb {
    ByteBuffer qlq;
    ca qlu;
    final byte[] qkd = new byte[256];
    int java = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void eIX() {
        boolean z = false;
        while (!z && !java() && this.qlu.f43case <= Integer.MAX_VALUE) {
            switch (eJA()) {
                case 33:
                    switch (eJA()) {
                        case 1:
                            b();
                            continue;
                        case 249:
                            this.qlu.qlw = new bz();
                            eJA();
                            int eJA = eJA();
                            this.qlu.qlw.c = (eJA & 28) >> 2;
                            if (this.qlu.qlw.c == 0) {
                                this.qlu.qlw.c = 1;
                            }
                            this.qlu.qlw.qjQ = (eJA & 1) != 0;
                            short s = this.qlq.getShort();
                            if (s < 2) {
                                s = 10;
                            }
                            this.qlu.qlw.e = s * 10;
                            this.qlu.qlw.d = eJA();
                            eJA();
                            continue;
                        case GDiffPatcher.COPY_INT_INT /* 254 */:
                            b();
                            continue;
                        case 255:
                            eJj();
                            String str = "";
                            for (int i = 0; i < 11; i++) {
                                str = str + ((char) this.qkd[i]);
                            }
                            if (str.equals("NETSCAPE2.0")) {
                                a();
                                break;
                            } else {
                                b();
                                continue;
                            }
                        default:
                            b();
                            continue;
                    }
                case 44:
                    if (this.qlu.qlw == null) {
                        this.qlu.qlw = new bz();
                    }
                    this.qlu.qlw.java = this.qlq.getShort();
                    this.qlu.qlw.f41case = this.qlq.getShort();
                    this.qlu.qlw.f13737a = this.qlq.getShort();
                    this.qlu.qlw.f13738b = this.qlq.getShort();
                    int eJA2 = eJA();
                    boolean z2 = (eJA2 & 128) != 0;
                    int pow = (int) Math.pow(2.0d, (eJA2 & 7) + 1);
                    this.qlu.qlw.qjq = (eJA2 & 64) != 0;
                    if (z2) {
                        this.qlu.qlw.f42java = Sh(pow);
                    } else {
                        this.qlu.qlw.f42java = null;
                    }
                    this.qlu.qlw.f = this.qlq.position();
                    eJA();
                    b();
                    if (java()) {
                        break;
                    } else {
                        this.qlu.f43case++;
                        this.qlu.qkr.add(this.qlu.qlw);
                        break;
                    }
                case 59:
                    z = true;
                    break;
                default:
                    this.qlu.java = 1;
                    break;
            }
        }
    }

    private void a() {
        do {
            eJj();
            if (this.qkd[0] == 1) {
                this.qlu.g = (this.qkd[1] & 255) | ((this.qkd[2] & 255) << 8);
                if (this.qlu.g == 0) {
                    this.qlu.g = -1;
                }
            }
            if (this.java <= 0) {
                return;
            }
        } while (!java());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void eIY() {
        String str = "";
        for (int i = 0; i < 6; i++) {
            str = str + ((char) eJA());
        }
        if (!str.startsWith("GIF")) {
            this.qlu.java = 1;
            return;
        }
        this.qlu.f13739a = this.qlq.getShort();
        this.qlu.f13740b = this.qlq.getShort();
        int eJA = eJA();
        this.qlu.qjq = (eJA & 128) != 0;
        this.qlu.c = 2 << (eJA & 7);
        this.qlu.d = eJA();
        this.qlu.e = eJA();
        if (this.qlu.qjq && !java()) {
            this.qlu.f44java = Sh(this.qlu.c);
            this.qlu.f = this.qlu.f44java[this.qlu.d];
        }
    }

    private int[] Sh(int i) {
        int[] iArr = null;
        byte[] bArr = new byte[i * 3];
        try {
            this.qlq.get(bArr);
            iArr = new int[256];
            int i2 = 0;
            int i3 = 0;
            while (i3 < i) {
                int i4 = i2 + 1;
                int i5 = bArr[i2] & 255;
                int i6 = i4 + 1;
                int i7 = bArr[i4] & 255;
                i2 = i6 + 1;
                int i8 = i3 + 1;
                iArr[i3] = (i5 << 16) | ViewCompat.MEASURED_STATE_MASK | (i7 << 8) | (bArr[i6] & 255);
                i3 = i8;
            }
        } catch (BufferUnderflowException e) {
            this.qlu.java = 1;
        }
        return iArr;
    }

    private void b() {
        int eJA;
        do {
            try {
                eJA = eJA();
                this.qlq.position(this.qlq.position() + eJA);
            } catch (IllegalArgumentException e) {
                return;
            }
        } while (eJA > 0);
    }

    private int eJj() {
        this.java = eJA();
        int i = 0;
        if (this.java > 0) {
            while (i < this.java) {
                try {
                    int i2 = this.java - i;
                    this.qlq.get(this.qkd, i, i2);
                    i += i2;
                } catch (Exception e) {
                    this.qlu.java = 1;
                }
            }
        }
        return i;
    }

    private int eJA() {
        try {
            return this.qlq.get() & 255;
        } catch (Exception e) {
            this.qlu.java = 1;
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean java() {
        return this.qlu.java != 0;
    }
}
