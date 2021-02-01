package com.yy.mediaframework.gpuimage;

import android.opengl.GLES20;
import java.util.Map;
/* loaded from: classes4.dex */
public class GPUImageSTBeautyFilter1 extends GPUImageFilter implements IFilterParams {
    private static final float ratio = 0.004f;
    private float mContrast;
    private int mContrastStrengthLocation;
    private int mHeightLocation;
    private int mWidthLocation;

    public GPUImageSTBeautyFilter1(String str, float f) {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nuniform mat4 uTexMatrix;\nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = (uTexMatrix * inputTextureCoordinate).xy;\n}", str);
        this.mContrast = f;
    }

    @Override // com.yy.mediaframework.gpuimage.GPUImageFilter
    public void onInit() {
        super.onInit();
        this.mWidthLocation = GLES20.glGetUniformLocation(getProgram(), "width");
        this.mHeightLocation = GLES20.glGetUniformLocation(getProgram(), "height");
        this.mContrastStrengthLocation = GLES20.glGetUniformLocation(getProgram(), "contrast_strength");
        setFloat(this.mContrastStrengthLocation, getContrastValue());
    }

    @Override // com.yy.mediaframework.gpuimage.GPUImageFilter
    public void onOutputSizeChanged(int i, int i2) {
        super.onOutputSizeChanged(i, i2);
        setFloat(this.mWidthLocation, ratio);
        setFloat(this.mHeightLocation, (i * ratio) / i2);
    }

    private float getContrastValue() {
        return 4.0f * this.mContrast;
    }

    @Override // com.yy.mediaframework.gpuimage.IFilterParams
    public void setFilterParams(Map<String, String> map) {
        this.mContrast = getParamValue(map, "1");
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
