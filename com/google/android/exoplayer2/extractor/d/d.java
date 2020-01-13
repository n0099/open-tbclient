package com.google.android.exoplayer2.extractor.d;

import com.baidu.mapapi.UIMsg;
import com.google.android.exoplayer2.util.l;
import java.io.IOException;
import java.util.Arrays;
/* loaded from: classes5.dex */
final class d {
    private int mkG;
    private boolean mkH;
    private final e mkn = new e();
    private final l mkE = new l(new byte[UIMsg.m_AppUI.V_WM_WIFISTATECHANGE], 0);
    private int mkF = -1;

    public void reset() {
        this.mkn.reset();
        this.mkE.reset();
        this.mkF = -1;
        this.mkH = false;
    }

    public boolean y(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        int i;
        com.google.android.exoplayer2.util.a.checkState(fVar != null);
        if (this.mkH) {
            this.mkH = false;
            this.mkE.reset();
        }
        while (!this.mkH) {
            if (this.mkF < 0) {
                if (!this.mkn.c(fVar, true)) {
                    return false;
                }
                int i2 = this.mkn.mge;
                if ((this.mkn.type & 1) == 1 && this.mkE.dyg() == 0) {
                    i2 += JO(0);
                    i = this.mkG + 0;
                } else {
                    i = 0;
                }
                fVar.Jq(i2);
                this.mkF = i;
            }
            int JO = JO(this.mkF);
            int i3 = this.mkF + this.mkG;
            if (JO > 0) {
                if (this.mkE.capacity() < this.mkE.dyg() + JO) {
                    this.mkE.data = Arrays.copyOf(this.mkE.data, this.mkE.dyg() + JO);
                }
                fVar.readFully(this.mkE.data, this.mkE.dyg(), JO);
                this.mkE.setLimit(JO + this.mkE.dyg());
                this.mkH = this.mkn.mkQ[i3 + (-1)] != 255;
            }
            this.mkF = i3 == this.mkn.mkO ? -1 : i3;
        }
        return true;
    }

    public e dtV() {
        return this.mkn;
    }

    public l dtW() {
        return this.mkE;
    }

    public void dtX() {
        if (this.mkE.data.length != 65025) {
            this.mkE.data = Arrays.copyOf(this.mkE.data, Math.max((int) UIMsg.m_AppUI.V_WM_WIFISTATECHANGE, this.mkE.dyg()));
        }
    }

    private int JO(int i) {
        int i2 = 0;
        this.mkG = 0;
        while (this.mkG + i < this.mkn.mkO) {
            int[] iArr = this.mkn.mkQ;
            int i3 = this.mkG;
            this.mkG = i3 + 1;
            int i4 = iArr[i3 + i];
            i2 += i4;
            if (i4 != 255) {
                break;
            }
        }
        return i2;
    }
}
