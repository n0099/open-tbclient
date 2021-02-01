package com.yy.mediaframework.beautystyle;
/* loaded from: classes4.dex */
public class MagicBeautyNewStyle extends AbstractStyle {
    public MagicBeautyNewStyle() {
        this.sMinParams = new float[]{0.0f, 0.0f, 0.0f, 0.0f};
        this.sDefaultParams = new float[]{1.0f, 1.0f, 1.0f, 1.0f};
        this.sMaxParams = new float[]{1.0f, 1.0f, 1.0f, 1.0f};
        this.mParams = new float[]{1.0f, 1.0f, 1.0f, 1.0f};
    }

    @Override // com.yy.mediaframework.beautystyle.AbstractStyle, com.yy.mediaframework.beautystyle.IBeautyStyle
    public void updateProgress(int i) {
        this.mProgress = i;
        for (int i2 = 0; i2 < 4; i2++) {
            this.mParams[i2] = calToRange(this.sMaxParams[i2], this.sMinParams[i2], 0.5f, this.mProgress);
        }
    }
}
