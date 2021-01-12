package com.win.opensdk;

import androidx.core.view.ViewCompat;
import com.baidu.appsearch.update.patchupdate.GDiffPatcher;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
/* loaded from: classes3.dex */
public final class cb {
    ByteBuffer qaL;
    ca qaP;
    final byte[] pZy = new byte[256];
    int java = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void eGz() {
        boolean z = false;
        while (!z && !java() && this.qaP.f43case <= Integer.MAX_VALUE) {
            switch (eHc()) {
                case 33:
                    switch (eHc()) {
                        case 1:
                            b();
                            continue;
                        case 249:
                            this.qaP.qaR = new bz();
                            eHc();
                            int eHc = eHc();
                            this.qaP.qaR.c = (eHc & 28) >> 2;
                            if (this.qaP.qaR.c == 0) {
                                this.qaP.qaR.c = 1;
                            }
                            this.qaP.qaR.pZl = (eHc & 1) != 0;
                            short s = this.qaL.getShort();
                            if (s < 2) {
                                s = 10;
                            }
                            this.qaP.qaR.e = s * 10;
                            this.qaP.qaR.d = eHc();
                            eHc();
                            continue;
                        case GDiffPatcher.COPY_INT_INT /* 254 */:
                            b();
                            continue;
                        case 255:
                            eGL();
                            String str = "";
                            for (int i = 0; i < 11; i++) {
                                str = str + ((char) this.pZy[i]);
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
                    if (this.qaP.qaR == null) {
                        this.qaP.qaR = new bz();
                    }
                    this.qaP.qaR.java = this.qaL.getShort();
                    this.qaP.qaR.f41case = this.qaL.getShort();
                    this.qaP.qaR.f13735a = this.qaL.getShort();
                    this.qaP.qaR.f13736b = this.qaL.getShort();
                    int eHc2 = eHc();
                    boolean z2 = (eHc2 & 128) != 0;
                    int pow = (int) Math.pow(2.0d, (eHc2 & 7) + 1);
                    this.qaP.qaR.pYL = (eHc2 & 64) != 0;
                    if (z2) {
                        this.qaP.qaR.f42java = RL(pow);
                    } else {
                        this.qaP.qaR.f42java = null;
                    }
                    this.qaP.qaR.f = this.qaL.position();
                    eHc();
                    b();
                    if (java()) {
                        break;
                    } else {
                        this.qaP.f43case++;
                        this.qaP.pZM.add(this.qaP.qaR);
                        break;
                    }
                case 59:
                    z = true;
                    break;
                default:
                    this.qaP.java = 1;
                    break;
            }
        }
    }

    private void a() {
        do {
            eGL();
            if (this.pZy[0] == 1) {
                this.qaP.g = (this.pZy[1] & 255) | ((this.pZy[2] & 255) << 8);
                if (this.qaP.g == 0) {
                    this.qaP.g = -1;
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
            this.qaP.java = 1;
            return;
        }
        this.qaP.f13737a = this.qaL.getShort();
        this.qaP.f13738b = this.qaL.getShort();
        int eHc = eHc();
        this.qaP.pYL = (eHc & 128) != 0;
        this.qaP.c = 2 << (eHc & 7);
        this.qaP.d = eHc();
        this.qaP.e = eHc();
        if (this.qaP.pYL && !java()) {
            this.qaP.f44java = RL(this.qaP.c);
            this.qaP.f = this.qaP.f44java[this.qaP.d];
        }
    }

    private int[] RL(int i) {
        int[] iArr = null;
        byte[] bArr = new byte[i * 3];
        try {
            this.qaL.get(bArr);
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
            this.qaP.java = 1;
        }
        return iArr;
    }

    private void b() {
        int eHc;
        do {
            try {
                eHc = eHc();
                this.qaL.position(this.qaL.position() + eHc);
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
                    this.qaL.get(this.pZy, i, i2);
                    i += i2;
                } catch (Exception e) {
                    this.qaP.java = 1;
                }
            }
        }
        return i;
    }

    private int eHc() {
        try {
            return this.qaL.get() & 255;
        } catch (Exception e) {
            this.qaP.java = 1;
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean java() {
        return this.qaP.java != 0;
    }
}
