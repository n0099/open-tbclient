package com.google.android.exoplayer2.extractor.d;

import com.baidu.mapapi.UIMsg;
import com.google.android.exoplayer2.util.l;
import java.io.IOException;
import java.util.Arrays;
/* loaded from: classes4.dex */
final class d {
    private int mgP;
    private boolean mgQ;
    private final e mgw = new e();
    private final l mgN = new l(new byte[UIMsg.m_AppUI.V_WM_WIFISTATECHANGE], 0);
    private int mgO = -1;

    public void reset() {
        this.mgw.reset();
        this.mgN.reset();
        this.mgO = -1;
        this.mgQ = false;
    }

    public boolean y(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        int i;
        com.google.android.exoplayer2.util.a.checkState(fVar != null);
        if (this.mgQ) {
            this.mgQ = false;
            this.mgN.reset();
        }
        while (!this.mgQ) {
            if (this.mgO < 0) {
                if (!this.mgw.c(fVar, true)) {
                    return false;
                }
                int i2 = this.mgw.mcp;
                if ((this.mgw.type & 1) == 1 && this.mgN.dwW() == 0) {
                    i2 += JF(0);
                    i = this.mgP + 0;
                } else {
                    i = 0;
                }
                fVar.Jh(i2);
                this.mgO = i;
            }
            int JF = JF(this.mgO);
            int i3 = this.mgO + this.mgP;
            if (JF > 0) {
                if (this.mgN.capacity() < this.mgN.dwW() + JF) {
                    this.mgN.data = Arrays.copyOf(this.mgN.data, this.mgN.dwW() + JF);
                }
                fVar.readFully(this.mgN.data, this.mgN.dwW(), JF);
                this.mgN.setLimit(JF + this.mgN.dwW());
                this.mgQ = this.mgw.mgZ[i3 + (-1)] != 255;
            }
            this.mgO = i3 == this.mgw.mgX ? -1 : i3;
        }
        return true;
    }

    public e dsJ() {
        return this.mgw;
    }

    public l dsK() {
        return this.mgN;
    }

    public void dsL() {
        if (this.mgN.data.length != 65025) {
            this.mgN.data = Arrays.copyOf(this.mgN.data, Math.max((int) UIMsg.m_AppUI.V_WM_WIFISTATECHANGE, this.mgN.dwW()));
        }
    }

    private int JF(int i) {
        int i2 = 0;
        this.mgP = 0;
        while (this.mgP + i < this.mgw.mgX) {
            int[] iArr = this.mgw.mgZ;
            int i3 = this.mgP;
            this.mgP = i3 + 1;
            int i4 = iArr[i3 + i];
            i2 += i4;
            if (i4 != 255) {
                break;
            }
        }
        return i2;
    }
}
