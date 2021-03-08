package com.yy.mediaframework.gpuimage;

import android.opengl.GLES20;
import java.nio.FloatBuffer;
import java.util.Map;
/* loaded from: classes6.dex */
public class GPUImageSTBeautyFilter3 extends GPUImageFilter implements IFilterParams {
    private float mContrast;
    private int mContrastStrengthLocation;
    private int mMidImageTextureLoc;
    private int mMidWareTextureId;
    private float mSmooth;
    private int mSmoothStrengthLocation;

    public GPUImageSTBeautyFilter3(String str, float f, float f2) {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nuniform mat4 uTexMatrix;\nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = (uTexMatrix * inputTextureCoordinate).xy;\n}", str);
        this.mMidWareTextureId = -1;
        this.mContrast = f;
        this.mSmooth = f2;
    }

    @Override // com.yy.mediaframework.gpuimage.GPUImageFilter
    public void onInit() {
        super.onInit();
        this.mContrastStrengthLocation = GLES20.glGetUniformLocation(getProgram(), "contrast_strength");
        this.mSmoothStrengthLocation = GLES20.glGetUniformLocation(getProgram(), "smooth_strength");
        this.mMidImageTextureLoc = GLES20.glGetUniformLocation(getProgram(), "midImageTexture");
        setFloat(this.mContrastStrengthLocation, getContrastValue());
        setFloat(this.mSmoothStrengthLocation, getSmoothValue());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yy.mediaframework.gpuimage.GPUImageFilter
    public void onDrawArraysPre(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2, int i2, float[] fArr) {
        super.onDrawArraysPre(i, floatBuffer, floatBuffer2, i2, fArr);
        if (this.mMidWareTextureId != -1) {
            GLES20.glActiveTexture(33987);
            GLES20.glBindTexture(3553, this.mMidWareTextureId);
            GLES20.glUniform1i(this.mMidImageTextureLoc, 3);
        }
    }

    public void setMidImageTextureId(int i) {
        this.mMidWareTextureId = i;
    }

    private float getContrastValue() {
        return 4.0f * this.mContrast;
    }

    private float getSmoothValue() {
        return 0.2857143f + (this.mSmooth / 2.45f);
    }

    @Override // com.yy.mediaframework.gpuimage.IFilterParams
    public void setFilterParams(Map<String, String> map) {
        this.mSmooth = getParamValue(map, "0");
        this.mContrast = getParamValue(map, "1");
        setFloat(this.mSmoothStrengthLocation, getSmoothValue());
        setFloat(this.mContrastStrengthLocation, getContrastValue());
    }

    private float getParamValue(Map<String, String> map, String str) {
        String str2 = map.get(str);
        if (str2 != null) {
            try {
                return Float.valueOf(str2).floatValue();
            } catch (NumberFormatException e) {
                return 0.0f;
            }
        }
        return 0.0f;
    }
}
