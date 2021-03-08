package com.yy.mediaframework.beautystyle;
/* loaded from: classes6.dex */
public class STBeautyStyle extends AbstractStyle {
    public STBeautyStyle() {
        this.sMinParams = new float[]{0.0f, 0.0f, 0.15f, 0.0f};
        this.sDefaultParams = new float[]{0.375f, 0.0f, 0.2f, 0.38f, 0.7f};
        this.sMaxParams = new float[]{0.7f, 0.0f, 0.23f, 0.75f};
        this.mParams = new float[]{0.375f, 0.0f, 0.2f, 0.38f, 0.7f};
    }

    @Override // com.yy.mediaframework.beautystyle.AbstractStyle, com.yy.mediaframework.beautystyle.IBeautyStyle
    public void updateProgress(int i) {
        this.mProgress = i;
        for (int i2 = 0; i2 < 3; i2++) {
            this.mParams[i2] = calToRange(this.sMaxParams[i2], this.sMinParams[i2], this.sDefaultParams[i2], this.mProgress);
        }
        this.mParams[3] = calToRange(this.sMaxParams[3], this.sMinParams[3], this.sDefaultParams[3], i);
        this.mParams[4] = (1.0f * i) / 100.0f;
    }
}
