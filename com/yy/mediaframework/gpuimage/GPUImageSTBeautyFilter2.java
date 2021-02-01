package com.yy.mediaframework.gpuimage;

import android.opengl.GLES20;
/* loaded from: classes4.dex */
public class GPUImageSTBeautyFilter2 extends GPUImageFilter {
    private static final float ratio = 0.004f;
    private int mHeightLocation;
    private int mWidthLocation;

    public GPUImageSTBeautyFilter2(String str) {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nuniform mat4 uTexMatrix;\nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = (uTexMatrix * inputTextureCoordinate).xy;\n}", str);
    }

    @Override // com.yy.mediaframework.gpuimage.GPUImageFilter
    public void onInit() {
        super.onInit();
        this.mWidthLocation = GLES20.glGetUniformLocation(getProgram(), "width");
        this.mHeightLocation = GLES20.glGetUniformLocation(getProgram(), "height");
    }

    @Override // com.yy.mediaframework.gpuimage.GPUImageFilter
    public void onOutputSizeChanged(int i, int i2) {
        super.onOutputSizeChanged(i, i2);
        setFloat(this.mWidthLocation, ratio);
        setFloat(this.mHeightLocation, (i * ratio) / i2);
    }
}
