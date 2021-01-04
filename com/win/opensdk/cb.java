package com.win.opensdk;

import androidx.core.view.ViewCompat;
import com.baidu.appsearch.update.patchupdate.GDiffPatcher;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
/* loaded from: classes4.dex */
public final class cb {
    ByteBuffer qdE;
    ca qdI;
    final byte[] qcr = new byte[256];
    int java = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void eJL() {
        boolean z = false;
        while (!z && !java() && this.qdI.f43case <= Integer.MAX_VALUE) {
            switch (eKo()) {
                case 33:
                    switch (eKo()) {
                        case 1:
                            b();
                            continue;
                        case 249:
                            this.qdI.qdK = new bz();
                            eKo();
                            int eKo = eKo();
                            this.qdI.qdK.c = (eKo & 28) >> 2;
                            if (this.qdI.qdK.c == 0) {
                                this.qdI.qdK.c = 1;
                            }
                            this.qdI.qdK.qce = (eKo & 1) != 0;
                            short s = this.qdE.getShort();
                            if (s < 2) {
                                s = 10;
                            }
                            this.qdI.qdK.e = s * 10;
                            this.qdI.qdK.d = eKo();
                            eKo();
                            continue;
                        case GDiffPatcher.COPY_INT_INT /* 254 */:
                            b();
                            continue;
                        case 255:
                            eJX();
                            String str = "";
                            for (int i = 0; i < 11; i++) {
                                str = str + ((char) this.qcr[i]);
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
                    if (this.qdI.qdK == null) {
                        this.qdI.qdK = new bz();
                    }
                    this.qdI.qdK.java = this.qdE.getShort();
                    this.qdI.qdK.f41case = this.qdE.getShort();
                    this.qdI.qdK.f14034a = this.qdE.getShort();
                    this.qdI.qdK.f14035b = this.qdE.getShort();
                    int eKo2 = eKo();
                    boolean z2 = (eKo2 & 128) != 0;
                    int pow = (int) Math.pow(2.0d, (eKo2 & 7) + 1);
                    this.qdI.qdK.qbE = (eKo2 & 64) != 0;
                    if (z2) {
                        this.qdI.qdK.f42java = Tc(pow);
                    } else {
                        this.qdI.qdK.f42java = null;
                    }
                    this.qdI.qdK.f = this.qdE.position();
                    eKo();
                    b();
                    if (java()) {
                        break;
                    } else {
                        this.qdI.f43case++;
                        this.qdI.qcF.add(this.qdI.qdK);
                        break;
                    }
                case 59:
                    z = true;
                    break;
                default:
                    this.qdI.java = 1;
                    break;
            }
        }
    }

    private void a() {
        do {
            eJX();
            if (this.qcr[0] == 1) {
                this.qdI.g = (this.qcr[1] & 255) | ((this.qcr[2] & 255) << 8);
                if (this.qdI.g == 0) {
                    this.qdI.g = -1;
                }
            }
            if (this.java <= 0) {
                return;
            }
        } while (!java());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void eJM() {
        String str = "";
        for (int i = 0; i < 6; i++) {
            str = str + ((char) eKo());
        }
        if (!str.startsWith("GIF")) {
            this.qdI.java = 1;
            return;
        }
        this.qdI.f14036a = this.qdE.getShort();
        this.qdI.f14037b = this.qdE.getShort();
        int eKo = eKo();
        this.qdI.qbE = (eKo & 128) != 0;
        this.qdI.c = 2 << (eKo & 7);
        this.qdI.d = eKo();
        this.qdI.e = eKo();
        if (this.qdI.qbE && !java()) {
            this.qdI.f44java = Tc(this.qdI.c);
            this.qdI.f = this.qdI.f44java[this.qdI.d];
        }
    }

    private int[] Tc(int i) {
        int[] iArr = null;
        byte[] bArr = new byte[i * 3];
        try {
            this.qdE.get(bArr);
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
            this.qdI.java = 1;
        }
        return iArr;
    }

    private void b() {
        int eKo;
        do {
            try {
                eKo = eKo();
                this.qdE.position(this.qdE.position() + eKo);
            } catch (IllegalArgumentException e) {
                return;
            }
        } while (eKo > 0);
    }

    private int eJX() {
        this.java = eKo();
        int i = 0;
        if (this.java > 0) {
            while (i < this.java) {
                try {
                    int i2 = this.java - i;
                    this.qdE.get(this.qcr, i, i2);
                    i += i2;
                } catch (Exception e) {
                    this.qdI.java = 1;
                }
            }
        }
        return i;
    }

    private int eKo() {
        try {
            return this.qdE.get() & 255;
        } catch (Exception e) {
            this.qdI.java = 1;
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean java() {
        return this.qdI.java != 0;
    }
}
