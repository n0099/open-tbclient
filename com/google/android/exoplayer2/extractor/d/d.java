package com.google.android.exoplayer2.extractor.d;

import com.baidu.mapapi.UIMsg;
import com.google.android.exoplayer2.util.l;
import java.io.IOException;
import java.util.Arrays;
/* loaded from: classes6.dex */
final class d {
    private int mlE;
    private boolean mlF;
    private final e mll = new e();
    private final l mlC = new l(new byte[UIMsg.m_AppUI.V_WM_WIFISTATECHANGE], 0);
    private int mlD = -1;

    public void reset() {
        this.mll.reset();
        this.mlC.reset();
        this.mlD = -1;
        this.mlF = false;
    }

    public boolean y(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        int i;
        com.google.android.exoplayer2.util.a.checkState(fVar != null);
        if (this.mlF) {
            this.mlF = false;
            this.mlC.reset();
        }
        while (!this.mlF) {
            if (this.mlD < 0) {
                if (!this.mll.c(fVar, true)) {
                    return false;
                }
                int i2 = this.mll.mhc;
                if ((this.mll.type & 1) == 1 && this.mlC.dzv() == 0) {
                    i2 += JT(0);
                    i = this.mlE + 0;
                } else {
                    i = 0;
                }
                fVar.Jv(i2);
                this.mlD = i;
            }
            int JT = JT(this.mlD);
            int i3 = this.mlD + this.mlE;
            if (JT > 0) {
                if (this.mlC.capacity() < this.mlC.dzv() + JT) {
                    this.mlC.data = Arrays.copyOf(this.mlC.data, this.mlC.dzv() + JT);
                }
                fVar.readFully(this.mlC.data, this.mlC.dzv(), JT);
                this.mlC.setLimit(JT + this.mlC.dzv());
                this.mlF = this.mll.mlO[i3 + (-1)] != 255;
            }
            this.mlD = i3 == this.mll.mlM ? -1 : i3;
        }
        return true;
    }

    public e dvl() {
        return this.mll;
    }

    public l dvm() {
        return this.mlC;
    }

    public void dvn() {
        if (this.mlC.data.length != 65025) {
            this.mlC.data = Arrays.copyOf(this.mlC.data, Math.max((int) UIMsg.m_AppUI.V_WM_WIFISTATECHANGE, this.mlC.dzv()));
        }
    }

    private int JT(int i) {
        int i2 = 0;
        this.mlE = 0;
        while (this.mlE + i < this.mll.mlM) {
            int[] iArr = this.mll.mlO;
            int i3 = this.mlE;
            this.mlE = i3 + 1;
            int i4 = iArr[i3 + i];
            i2 += i4;
            if (i4 != 255) {
                break;
            }
        }
        return i2;
    }
}
