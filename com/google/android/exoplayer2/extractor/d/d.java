package com.google.android.exoplayer2.extractor.d;

import com.baidu.mapapi.UIMsg;
import com.google.android.exoplayer2.util.l;
import java.io.IOException;
import java.util.Arrays;
/* loaded from: classes5.dex */
final class d {
    private int mkL;
    private boolean mkM;
    private final e mks = new e();
    private final l mkJ = new l(new byte[UIMsg.m_AppUI.V_WM_WIFISTATECHANGE], 0);
    private int mkK = -1;

    public void reset() {
        this.mks.reset();
        this.mkJ.reset();
        this.mkK = -1;
        this.mkM = false;
    }

    public boolean y(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        int i;
        com.google.android.exoplayer2.util.a.checkState(fVar != null);
        if (this.mkM) {
            this.mkM = false;
            this.mkJ.reset();
        }
        while (!this.mkM) {
            if (this.mkK < 0) {
                if (!this.mks.c(fVar, true)) {
                    return false;
                }
                int i2 = this.mks.mgj;
                if ((this.mks.type & 1) == 1 && this.mkJ.dyi() == 0) {
                    i2 += JO(0);
                    i = this.mkL + 0;
                } else {
                    i = 0;
                }
                fVar.Jq(i2);
                this.mkK = i;
            }
            int JO = JO(this.mkK);
            int i3 = this.mkK + this.mkL;
            if (JO > 0) {
                if (this.mkJ.capacity() < this.mkJ.dyi() + JO) {
                    this.mkJ.data = Arrays.copyOf(this.mkJ.data, this.mkJ.dyi() + JO);
                }
                fVar.readFully(this.mkJ.data, this.mkJ.dyi(), JO);
                this.mkJ.setLimit(JO + this.mkJ.dyi());
                this.mkM = this.mks.mkV[i3 + (-1)] != 255;
            }
            this.mkK = i3 == this.mks.mkT ? -1 : i3;
        }
        return true;
    }

    public e dtX() {
        return this.mks;
    }

    public l dtY() {
        return this.mkJ;
    }

    public void dtZ() {
        if (this.mkJ.data.length != 65025) {
            this.mkJ.data = Arrays.copyOf(this.mkJ.data, Math.max((int) UIMsg.m_AppUI.V_WM_WIFISTATECHANGE, this.mkJ.dyi()));
        }
    }

    private int JO(int i) {
        int i2 = 0;
        this.mkL = 0;
        while (this.mkL + i < this.mks.mkT) {
            int[] iArr = this.mks.mkV;
            int i3 = this.mkL;
            this.mkL = i3 + 1;
            int i4 = iArr[i3 + i];
            i2 += i4;
            if (i4 != 255) {
                break;
            }
        }
        return i2;
    }
}
