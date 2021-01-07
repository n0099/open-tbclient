package com.win.opensdk;

import androidx.core.view.ViewCompat;
import com.baidu.appsearch.update.patchupdate.GDiffPatcher;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
/* loaded from: classes4.dex */
public final class cb {
    ByteBuffer qfm;
    ca qfq;
    final byte[] qdZ = new byte[256];
    int java = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void eKp() {
        boolean z = false;
        while (!z && !java() && this.qfq.f44case <= Integer.MAX_VALUE) {
            switch (eKS()) {
                case 33:
                    switch (eKS()) {
                        case 1:
                            b();
                            continue;
                        case 249:
                            this.qfq.qfs = new bz();
                            eKS();
                            int eKS = eKS();
                            this.qfq.qfs.c = (eKS & 28) >> 2;
                            if (this.qfq.qfs.c == 0) {
                                this.qfq.qfs.c = 1;
                            }
                            this.qfq.qfs.qdM = (eKS & 1) != 0;
                            short s = this.qfm.getShort();
                            if (s < 2) {
                                s = 10;
                            }
                            this.qfq.qfs.e = s * 10;
                            this.qfq.qfs.d = eKS();
                            eKS();
                            continue;
                        case GDiffPatcher.COPY_INT_INT /* 254 */:
                            b();
                            continue;
                        case 255:
                            eKB();
                            String str = "";
                            for (int i = 0; i < 11; i++) {
                                str = str + ((char) this.qdZ[i]);
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
                    if (this.qfq.qfs == null) {
                        this.qfq.qfs = new bz();
                    }
                    this.qfq.qfs.java = this.qfm.getShort();
                    this.qfq.qfs.f42case = this.qfm.getShort();
                    this.qfq.qfs.f14035a = this.qfm.getShort();
                    this.qfq.qfs.f14036b = this.qfm.getShort();
                    int eKS2 = eKS();
                    boolean z2 = (eKS2 & 128) != 0;
                    int pow = (int) Math.pow(2.0d, (eKS2 & 7) + 1);
                    this.qfq.qfs.qdm = (eKS2 & 64) != 0;
                    if (z2) {
                        this.qfq.qfs.f43java = Ts(pow);
                    } else {
                        this.qfq.qfs.f43java = null;
                    }
                    this.qfq.qfs.f = this.qfm.position();
                    eKS();
                    b();
                    if (java()) {
                        break;
                    } else {
                        this.qfq.f44case++;
                        this.qfq.qen.add(this.qfq.qfs);
                        break;
                    }
                case 59:
                    z = true;
                    break;
                default:
                    this.qfq.java = 1;
                    break;
            }
        }
    }

    private void a() {
        do {
            eKB();
            if (this.qdZ[0] == 1) {
                this.qfq.g = (this.qdZ[1] & 255) | ((this.qdZ[2] & 255) << 8);
                if (this.qfq.g == 0) {
                    this.qfq.g = -1;
                }
            }
            if (this.java <= 0) {
                return;
            }
        } while (!java());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void eKq() {
        String str = "";
        for (int i = 0; i < 6; i++) {
            str = str + ((char) eKS());
        }
        if (!str.startsWith("GIF")) {
            this.qfq.java = 1;
            return;
        }
        this.qfq.f14037a = this.qfm.getShort();
        this.qfq.f14038b = this.qfm.getShort();
        int eKS = eKS();
        this.qfq.qdm = (eKS & 128) != 0;
        this.qfq.c = 2 << (eKS & 7);
        this.qfq.d = eKS();
        this.qfq.e = eKS();
        if (this.qfq.qdm && !java()) {
            this.qfq.f45java = Ts(this.qfq.c);
            this.qfq.f = this.qfq.f45java[this.qfq.d];
        }
    }

    private int[] Ts(int i) {
        int[] iArr = null;
        byte[] bArr = new byte[i * 3];
        try {
            this.qfm.get(bArr);
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
            this.qfq.java = 1;
        }
        return iArr;
    }

    private void b() {
        int eKS;
        do {
            try {
                eKS = eKS();
                this.qfm.position(this.qfm.position() + eKS);
            } catch (IllegalArgumentException e) {
                return;
            }
        } while (eKS > 0);
    }

    private int eKB() {
        this.java = eKS();
        int i = 0;
        if (this.java > 0) {
            while (i < this.java) {
                try {
                    int i2 = this.java - i;
                    this.qfm.get(this.qdZ, i, i2);
                    i += i2;
                } catch (Exception e) {
                    this.qfq.java = 1;
                }
            }
        }
        return i;
    }

    private int eKS() {
        try {
            return this.qfm.get() & 255;
        } catch (Exception e) {
            this.qfq.java = 1;
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean java() {
        return this.qfq.java != 0;
    }
}
