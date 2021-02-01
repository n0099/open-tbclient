package com.win.opensdk;

import androidx.core.view.ViewCompat;
import com.baidu.appsearch.update.patchupdate.GDiffPatcher;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
/* loaded from: classes3.dex */
public final class cb {
    ByteBuffer qkQ;
    ca qkU;
    final byte[] qjD = new byte[256];
    int java = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void eIP() {
        boolean z = false;
        while (!z && !java() && this.qkU.f43case <= Integer.MAX_VALUE) {
            switch (eJs()) {
                case 33:
                    switch (eJs()) {
                        case 1:
                            b();
                            continue;
                        case 249:
                            this.qkU.qkW = new bz();
                            eJs();
                            int eJs = eJs();
                            this.qkU.qkW.c = (eJs & 28) >> 2;
                            if (this.qkU.qkW.c == 0) {
                                this.qkU.qkW.c = 1;
                            }
                            this.qkU.qkW.qjq = (eJs & 1) != 0;
                            short s = this.qkQ.getShort();
                            if (s < 2) {
                                s = 10;
                            }
                            this.qkU.qkW.e = s * 10;
                            this.qkU.qkW.d = eJs();
                            eJs();
                            continue;
                        case GDiffPatcher.COPY_INT_INT /* 254 */:
                            b();
                            continue;
                        case 255:
                            eJb();
                            String str = "";
                            for (int i = 0; i < 11; i++) {
                                str = str + ((char) this.qjD[i]);
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
                    if (this.qkU.qkW == null) {
                        this.qkU.qkW = new bz();
                    }
                    this.qkU.qkW.java = this.qkQ.getShort();
                    this.qkU.qkW.f41case = this.qkQ.getShort();
                    this.qkU.qkW.f13737a = this.qkQ.getShort();
                    this.qkU.qkW.f13738b = this.qkQ.getShort();
                    int eJs2 = eJs();
                    boolean z2 = (eJs2 & 128) != 0;
                    int pow = (int) Math.pow(2.0d, (eJs2 & 7) + 1);
                    this.qkU.qkW.qiQ = (eJs2 & 64) != 0;
                    if (z2) {
                        this.qkU.qkW.f42java = Sg(pow);
                    } else {
                        this.qkU.qkW.f42java = null;
                    }
                    this.qkU.qkW.f = this.qkQ.position();
                    eJs();
                    b();
                    if (java()) {
                        break;
                    } else {
                        this.qkU.f43case++;
                        this.qkU.qjR.add(this.qkU.qkW);
                        break;
                    }
                case 59:
                    z = true;
                    break;
                default:
                    this.qkU.java = 1;
                    break;
            }
        }
    }

    private void a() {
        do {
            eJb();
            if (this.qjD[0] == 1) {
                this.qkU.g = (this.qjD[1] & 255) | ((this.qjD[2] & 255) << 8);
                if (this.qkU.g == 0) {
                    this.qkU.g = -1;
                }
            }
            if (this.java <= 0) {
                return;
            }
        } while (!java());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void eIQ() {
        String str = "";
        for (int i = 0; i < 6; i++) {
            str = str + ((char) eJs());
        }
        if (!str.startsWith("GIF")) {
            this.qkU.java = 1;
            return;
        }
        this.qkU.f13739a = this.qkQ.getShort();
        this.qkU.f13740b = this.qkQ.getShort();
        int eJs = eJs();
        this.qkU.qiQ = (eJs & 128) != 0;
        this.qkU.c = 2 << (eJs & 7);
        this.qkU.d = eJs();
        this.qkU.e = eJs();
        if (this.qkU.qiQ && !java()) {
            this.qkU.f44java = Sg(this.qkU.c);
            this.qkU.f = this.qkU.f44java[this.qkU.d];
        }
    }

    private int[] Sg(int i) {
        int[] iArr = null;
        byte[] bArr = new byte[i * 3];
        try {
            this.qkQ.get(bArr);
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
            this.qkU.java = 1;
        }
        return iArr;
    }

    private void b() {
        int eJs;
        do {
            try {
                eJs = eJs();
                this.qkQ.position(this.qkQ.position() + eJs);
            } catch (IllegalArgumentException e) {
                return;
            }
        } while (eJs > 0);
    }

    private int eJb() {
        this.java = eJs();
        int i = 0;
        if (this.java > 0) {
            while (i < this.java) {
                try {
                    int i2 = this.java - i;
                    this.qkQ.get(this.qjD, i, i2);
                    i += i2;
                } catch (Exception e) {
                    this.qkU.java = 1;
                }
            }
        }
        return i;
    }

    private int eJs() {
        try {
            return this.qkQ.get() & 255;
        } catch (Exception e) {
            this.qkU.java = 1;
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean java() {
        return this.qkU.java != 0;
    }
}
