package com.google.android.exoplayer2.extractor.d;

import com.baidu.mapapi.UIMsg;
import com.google.android.exoplayer2.util.l;
import java.io.IOException;
import java.util.Arrays;
/* loaded from: classes6.dex */
final class d {
    private final e mkY = new e();
    private final l mlp = new l(new byte[UIMsg.m_AppUI.V_WM_WIFISTATECHANGE], 0);
    private int mlq = -1;
    private int mlr;
    private boolean mls;

    public void reset() {
        this.mkY.reset();
        this.mlp.reset();
        this.mlq = -1;
        this.mls = false;
    }

    public boolean y(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        int i;
        com.google.android.exoplayer2.util.a.checkState(fVar != null);
        if (this.mls) {
            this.mls = false;
            this.mlp.reset();
        }
        while (!this.mls) {
            if (this.mlq < 0) {
                if (!this.mkY.c(fVar, true)) {
                    return false;
                }
                int i2 = this.mkY.mgP;
                if ((this.mkY.type & 1) == 1 && this.mlp.dzs() == 0) {
                    i2 += JT(0);
                    i = this.mlr + 0;
                } else {
                    i = 0;
                }
                fVar.Jv(i2);
                this.mlq = i;
            }
            int JT = JT(this.mlq);
            int i3 = this.mlq + this.mlr;
            if (JT > 0) {
                if (this.mlp.capacity() < this.mlp.dzs() + JT) {
                    this.mlp.data = Arrays.copyOf(this.mlp.data, this.mlp.dzs() + JT);
                }
                fVar.readFully(this.mlp.data, this.mlp.dzs(), JT);
                this.mlp.setLimit(JT + this.mlp.dzs());
                this.mls = this.mkY.mlB[i3 + (-1)] != 255;
            }
            this.mlq = i3 == this.mkY.mlz ? -1 : i3;
        }
        return true;
    }

    public e dvi() {
        return this.mkY;
    }

    public l dvj() {
        return this.mlp;
    }

    public void dvk() {
        if (this.mlp.data.length != 65025) {
            this.mlp.data = Arrays.copyOf(this.mlp.data, Math.max((int) UIMsg.m_AppUI.V_WM_WIFISTATECHANGE, this.mlp.dzs()));
        }
    }

    private int JT(int i) {
        int i2 = 0;
        this.mlr = 0;
        while (this.mlr + i < this.mkY.mlz) {
            int[] iArr = this.mkY.mlB;
            int i3 = this.mlr;
            this.mlr = i3 + 1;
            int i4 = iArr[i3 + i];
            i2 += i4;
            if (i4 != 255) {
                break;
            }
        }
        return i2;
    }
}
