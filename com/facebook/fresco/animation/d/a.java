package com.facebook.fresco.animation.d;

import com.facebook.fresco.animation.a.d;
/* loaded from: classes11.dex */
public class a implements b {
    private final d lJN;
    private long lKF = -1;

    public a(d dVar) {
        this.lJN = dVar;
    }

    @Override // com.facebook.fresco.animation.d.b
    public int L(long j, long j2) {
        if (!dlg() && j / dlf() >= this.lJN.getLoopCount()) {
            return -1;
        }
        return ff(j % dlf());
    }

    public long dlf() {
        if (this.lKF != -1) {
            return this.lKF;
        }
        this.lKF = 0L;
        int frameCount = this.lJN.getFrameCount();
        for (int i = 0; i < frameCount; i++) {
            this.lKF += this.lJN.HF(i);
        }
        return this.lKF;
    }

    @Override // com.facebook.fresco.animation.d.b
    public long fe(long j) {
        long j2 = 0;
        long dlf = dlf();
        if (dlf == 0) {
            return -1L;
        }
        if (dlg() || j / dlf() < this.lJN.getLoopCount()) {
            long j3 = j % dlf;
            int frameCount = this.lJN.getFrameCount();
            for (int i = 0; i < frameCount && j2 <= j3; i++) {
                j2 += this.lJN.HF(i);
            }
            return (j2 - j3) + j;
        }
        return -1L;
    }

    public boolean dlg() {
        return this.lJN.getLoopCount() == 0;
    }

    int ff(long j) {
        int i = 0;
        long j2 = 0;
        do {
            j2 += this.lJN.HF(i);
            i++;
        } while (j >= j2);
        return i - 1;
    }
}
