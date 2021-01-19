package com.win.opensdk;

import androidx.core.view.ViewCompat;
import com.baidu.appsearch.update.patchupdate.GDiffPatcher;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
/* loaded from: classes3.dex */
public final class cb {
    ByteBuffer qaM;
    ca qaQ;
    final byte[] pZz = new byte[256];
    int java = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void eGz() {
        boolean z = false;
        while (!z && !java() && this.qaQ.f43case <= Integer.MAX_VALUE) {
            switch (eHc()) {
                case 33:
                    switch (eHc()) {
                        case 1:
                            b();
                            continue;
                        case 249:
                            this.qaQ.qaS = new bz();
                            eHc();
                            int eHc = eHc();
                            this.qaQ.qaS.c = (eHc & 28) >> 2;
                            if (this.qaQ.qaS.c == 0) {
                                this.qaQ.qaS.c = 1;
                            }
                            this.qaQ.qaS.pZm = (eHc & 1) != 0;
                            short s = this.qaM.getShort();
                            if (s < 2) {
                                s = 10;
                            }
                            this.qaQ.qaS.e = s * 10;
                            this.qaQ.qaS.d = eHc();
                            eHc();
                            continue;
                        case GDiffPatcher.COPY_INT_INT /* 254 */:
                            b();
                            continue;
                        case 255:
                            eGL();
                            String str = "";
                            for (int i = 0; i < 11; i++) {
                                str = str + ((char) this.pZz[i]);
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
                    if (this.qaQ.qaS == null) {
                        this.qaQ.qaS = new bz();
                    }
                    this.qaQ.qaS.java = this.qaM.getShort();
                    this.qaQ.qaS.f41case = this.qaM.getShort();
                    this.qaQ.qaS.f13735a = this.qaM.getShort();
                    this.qaQ.qaS.f13736b = this.qaM.getShort();
                    int eHc2 = eHc();
                    boolean z2 = (eHc2 & 128) != 0;
                    int pow = (int) Math.pow(2.0d, (eHc2 & 7) + 1);
                    this.qaQ.qaS.pYM = (eHc2 & 64) != 0;
                    if (z2) {
                        this.qaQ.qaS.f42java = RL(pow);
                    } else {
                        this.qaQ.qaS.f42java = null;
                    }
                    this.qaQ.qaS.f = this.qaM.position();
                    eHc();
                    b();
                    if (java()) {
                        break;
                    } else {
                        this.qaQ.f43case++;
                        this.qaQ.pZN.add(this.qaQ.qaS);
                        break;
                    }
                case 59:
                    z = true;
                    break;
                default:
                    this.qaQ.java = 1;
                    break;
            }
        }
    }

    private void a() {
        do {
            eGL();
            if (this.pZz[0] == 1) {
                this.qaQ.g = (this.pZz[1] & 255) | ((this.pZz[2] & 255) << 8);
                if (this.qaQ.g == 0) {
                    this.qaQ.g = -1;
                }
            }
            if (this.java <= 0) {
                return;
            }
        } while (!java());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void eGA() {
        String str = "";
        for (int i = 0; i < 6; i++) {
            str = str + ((char) eHc());
        }
        if (!str.startsWith("GIF")) {
            this.qaQ.java = 1;
            return;
        }
        this.qaQ.f13737a = this.qaM.getShort();
        this.qaQ.f13738b = this.qaM.getShort();
        int eHc = eHc();
        this.qaQ.pYM = (eHc & 128) != 0;
        this.qaQ.c = 2 << (eHc & 7);
        this.qaQ.d = eHc();
        this.qaQ.e = eHc();
        if (this.qaQ.pYM && !java()) {
            this.qaQ.f44java = RL(this.qaQ.c);
            this.qaQ.f = this.qaQ.f44java[this.qaQ.d];
        }
    }

    private int[] RL(int i) {
        int[] iArr = null;
        byte[] bArr = new byte[i * 3];
        try {
            this.qaM.get(bArr);
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
            this.qaQ.java = 1;
        }
        return iArr;
    }

    private void b() {
        int eHc;
        do {
            try {
                eHc = eHc();
                this.qaM.position(this.qaM.position() + eHc);
            } catch (IllegalArgumentException e) {
                return;
            }
        } while (eHc > 0);
    }

    private int eGL() {
        this.java = eHc();
        int i = 0;
        if (this.java > 0) {
            while (i < this.java) {
                try {
                    int i2 = this.java - i;
                    this.qaM.get(this.pZz, i, i2);
                    i += i2;
                } catch (Exception e) {
                    this.qaQ.java = 1;
                }
            }
        }
        return i;
    }

    private int eHc() {
        try {
            return this.qaM.get() & 255;
        } catch (Exception e) {
            this.qaQ.java = 1;
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean java() {
        return this.qaQ.java != 0;
    }
}
