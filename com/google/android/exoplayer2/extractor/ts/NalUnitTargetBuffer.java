package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.util.Assertions;
import java.util.Arrays;
/* loaded from: classes7.dex */
public final class NalUnitTargetBuffer {
    public boolean isCompleted;
    public boolean isFilling;
    public byte[] nalData;
    public int nalLength;
    public final int targetType;

    public NalUnitTargetBuffer(int i, int i2) {
        this.targetType = i;
        byte[] bArr = new byte[i2 + 3];
        this.nalData = bArr;
        bArr[2] = 1;
    }

    public void appendToNalUnit(byte[] bArr, int i, int i2) {
        if (!this.isFilling) {
            return;
        }
        int i3 = i2 - i;
        byte[] bArr2 = this.nalData;
        int length = bArr2.length;
        int i4 = this.nalLength;
        if (length < i4 + i3) {
            this.nalData = Arrays.copyOf(bArr2, (i4 + i3) * 2);
        }
        System.arraycopy(bArr, i, this.nalData, this.nalLength, i3);
        this.nalLength += i3;
    }

    public boolean endNalUnit(int i) {
        if (!this.isFilling) {
            return false;
        }
        this.nalLength -= i;
        this.isFilling = false;
        this.isCompleted = true;
        return true;
    }

    public void startNalUnit(int i) {
        boolean z = true;
        Assertions.checkState(!this.isFilling);
        if (i != this.targetType) {
            z = false;
        }
        this.isFilling = z;
        if (z) {
            this.nalLength = 3;
            this.isCompleted = false;
        }
    }

    public boolean isCompleted() {
        return this.isCompleted;
    }

    public void reset() {
        this.isFilling = false;
        this.isCompleted = false;
    }
}
