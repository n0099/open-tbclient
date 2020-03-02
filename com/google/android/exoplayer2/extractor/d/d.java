package com.google.android.exoplayer2.extractor.d;

import com.baidu.mapapi.UIMsg;
import com.google.android.exoplayer2.util.l;
import java.io.IOException;
import java.util.Arrays;
/* loaded from: classes6.dex */
final class d {
    private final e mla = new e();
    private final l mlr = new l(new byte[UIMsg.m_AppUI.V_WM_WIFISTATECHANGE], 0);
    private int mls = -1;
    private int mlt;
    private boolean mlu;

    public void reset() {
        this.mla.reset();
        this.mlr.reset();
        this.mls = -1;
        this.mlu = false;
    }

    public boolean y(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        int i;
        com.google.android.exoplayer2.util.a.checkState(fVar != null);
        if (this.mlu) {
            this.mlu = false;
            this.mlr.reset();
        }
        while (!this.mlu) {
            if (this.mls < 0) {
                if (!this.mla.c(fVar, true)) {
                    return false;
                }
                int i2 = this.mla.mgR;
                if ((this.mla.type & 1) == 1 && this.mlr.dzu() == 0) {
                    i2 += JT(0);
                    i = this.mlt + 0;
                } else {
                    i = 0;
                }
                fVar.Jv(i2);
                this.mls = i;
            }
            int JT = JT(this.mls);
            int i3 = this.mls + this.mlt;
            if (JT > 0) {
                if (this.mlr.capacity() < this.mlr.dzu() + JT) {
                    this.mlr.data = Arrays.copyOf(this.mlr.data, this.mlr.dzu() + JT);
                }
                fVar.readFully(this.mlr.data, this.mlr.dzu(), JT);
                this.mlr.setLimit(JT + this.mlr.dzu());
                this.mlu = this.mla.mlD[i3 + (-1)] != 255;
            }
            this.mls = i3 == this.mla.mlB ? -1 : i3;
        }
        return true;
    }

    public e dvk() {
        return this.mla;
    }

    public l dvl() {
        return this.mlr;
    }

    public void dvm() {
        if (this.mlr.data.length != 65025) {
            this.mlr.data = Arrays.copyOf(this.mlr.data, Math.max((int) UIMsg.m_AppUI.V_WM_WIFISTATECHANGE, this.mlr.dzu()));
        }
    }

    private int JT(int i) {
        int i2 = 0;
        this.mlt = 0;
        while (this.mlt + i < this.mla.mlB) {
            int[] iArr = this.mla.mlD;
            int i3 = this.mlt;
            this.mlt = i3 + 1;
            int i4 = iArr[i3 + i];
            i2 += i4;
            if (i4 != 255) {
                break;
            }
        }
        return i2;
    }
}
