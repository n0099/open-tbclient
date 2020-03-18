package com.google.android.exoplayer2.extractor.d;

import com.baidu.mapapi.UIMsg;
import com.google.android.exoplayer2.util.l;
import java.io.IOException;
import java.util.Arrays;
/* loaded from: classes6.dex */
final class d {
    private final e mmR = new e();
    private final l mni = new l(new byte[UIMsg.m_AppUI.V_WM_WIFISTATECHANGE], 0);
    private int mnj = -1;
    private int mnk;
    private boolean mnl;

    public void reset() {
        this.mmR.reset();
        this.mni.reset();
        this.mnj = -1;
        this.mnl = false;
    }

    public boolean y(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        int i;
        com.google.android.exoplayer2.util.a.checkState(fVar != null);
        if (this.mnl) {
            this.mnl = false;
            this.mni.reset();
        }
        while (!this.mnl) {
            if (this.mnj < 0) {
                if (!this.mmR.c(fVar, true)) {
                    return false;
                }
                int i2 = this.mmR.miK;
                if ((this.mmR.type & 1) == 1 && this.mni.dzS() == 0) {
                    i2 += JZ(0);
                    i = this.mnk + 0;
                } else {
                    i = 0;
                }
                fVar.JB(i2);
                this.mnj = i;
            }
            int JZ = JZ(this.mnj);
            int i3 = this.mnj + this.mnk;
            if (JZ > 0) {
                if (this.mni.capacity() < this.mni.dzS() + JZ) {
                    this.mni.data = Arrays.copyOf(this.mni.data, this.mni.dzS() + JZ);
                }
                fVar.readFully(this.mni.data, this.mni.dzS(), JZ);
                this.mni.setLimit(JZ + this.mni.dzS());
                this.mnl = this.mmR.mnu[i3 + (-1)] != 255;
            }
            this.mnj = i3 == this.mmR.mns ? -1 : i3;
        }
        return true;
    }

    public e dvI() {
        return this.mmR;
    }

    public l dvJ() {
        return this.mni;
    }

    public void dvK() {
        if (this.mni.data.length != 65025) {
            this.mni.data = Arrays.copyOf(this.mni.data, Math.max((int) UIMsg.m_AppUI.V_WM_WIFISTATECHANGE, this.mni.dzS()));
        }
    }

    private int JZ(int i) {
        int i2 = 0;
        this.mnk = 0;
        while (this.mnk + i < this.mmR.mns) {
            int[] iArr = this.mmR.mnu;
            int i3 = this.mnk;
            this.mnk = i3 + 1;
            int i4 = iArr[i3 + i];
            i2 += i4;
            if (i4 != 255) {
                break;
            }
        }
        return i2;
    }
}
