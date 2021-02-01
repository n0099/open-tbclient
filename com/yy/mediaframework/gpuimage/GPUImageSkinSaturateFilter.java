package com.yy.mediaframework.gpuimage;

import android.opengl.GLES20;
import java.util.Map;
/* loaded from: classes4.dex */
public class GPUImageSkinSaturateFilter extends GPUImageFilter implements IFilterParams {
    float mSaturate;
    private int mSaturateStrengthLocation;

    public GPUImageSkinSaturateFilter(String str, float f) {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nuniform mat4 uTexMatrix;\nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = (uTexMatrix * inputTextureCoordinate).xy;\n}", str);
        this.mSaturate = 0.1f;
        this.mSaturate = f;
    }

    @Override // com.yy.mediaframework.gpuimage.GPUImageFilter
    public void onInit() {
        super.onInit();
        this.mSaturateStrengthLocation = GLES20.glGetUniformLocation(getProgram(), "saturate_strength");
        setFloat(this.mSaturateStrengthLocation, this.mSaturate);
    }

    @Override // com.yy.mediaframework.gpuimage.IFilterParams
    public void setFilterParams(Map<String, String> map) {
        this.mSaturate = getParamValue(map, "3");
        setFloat(this.mSaturateStrengthLocation, this.mSaturate);
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
