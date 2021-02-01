package com.yy.mediaframework.beautystyle;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public abstract class AbstractStyle implements IBeautyStyle {
    protected float[] sMinParams = {0.6f, 0.6f, 0.6f, 0.0f};
    protected float[] sDefaultParams = {0.67f, 0.75f, 0.7f, 0.1f, 0.7f};
    protected float[] sMaxParams = {0.75f, 0.9f, 0.75f, 0.2f};
    protected float[] mParams = this.sDefaultParams;
    protected int mProgress = 50;
    Map<String, String> mParamMap = new HashMap(5);

    @Override // com.yy.mediaframework.beautystyle.IBeautyStyle
    public Map<String, String> getFilterParams() {
        this.mParamMap.put("0", String.valueOf(this.mParams[0]));
        this.mParamMap.put("1", String.valueOf(this.mParams[1]));
        this.mParamMap.put("2", String.valueOf(this.mParams[2]));
        this.mParamMap.put("3", String.valueOf(this.mParams[3]));
        this.mParamMap.put("4", String.valueOf(this.mParams[4]));
        return this.mParamMap;
    }

    @Override // com.yy.mediaframework.beautystyle.IBeautyStyle
    public void changeParams(int i, float f) {
        if (i > -1 && i < 4) {
            this.mParams[i] = f;
        }
    }

    @Override // com.yy.mediaframework.beautystyle.IBeautyStyle
    public void updateProgress(int i) {
        this.mProgress = 100 - i;
        for (int i2 = 0; i2 < 3; i2++) {
            this.mParams[i2] = calToRange(this.sMaxParams[i2], this.sMinParams[i2], this.sDefaultParams[i2], this.mProgress);
        }
        this.mParams[3] = calToRange(this.sMaxParams[3], this.sMinParams[3], this.sDefaultParams[3], i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float calToRange(float f, float f2, float f3, int i) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        float f4 = f3 >= 0.0f ? f3 : 0.0f;
        if (i < 0) {
            i = 0;
        }
        if (i > 50) {
            return Math.round((f4 + (((f - f4) / 50.0f) * Math.abs(i - 50))) * 1000.0f) / 1000.0f;
        }
        if (i < 50) {
            return Math.round((f4 - (((f4 - f2) / 50.0f) * Math.abs(50 - i))) * 1000.0f) / 1000.0f;
        }
        return f4;
    }
}
