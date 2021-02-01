package com.yy.mediaframework.gpuimage;

import android.opengl.GLES20;
/* loaded from: classes4.dex */
public class GPUImageTwoPassTextureFilter extends GPUImageFilterGroup {
    public GPUImageTwoPassTextureFilter(String str, String str2, String str3, String str4) {
        super(null);
        addFilter(new GPUImageFilter(str, str2));
        addFilter(new GPUImageFilter(str3, str4));
    }

    @Override // com.yy.mediaframework.gpuimage.GPUImageFilterGroup, com.yy.mediaframework.gpuimage.GPUImageFilter
    public void onInit() {
        super.onInit();
        initTexelOffsets();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initTexelOffsets() {
        float horizontalTexelOffsetRatio = getHorizontalTexelOffsetRatio();
        GPUImageFilter gPUImageFilter = this.mFilters.get(0);
        int glGetUniformLocation = GLES20.glGetUniformLocation(gPUImageFilter.getProgram(), "texelWidthOffset");
        int glGetUniformLocation2 = GLES20.glGetUniformLocation(gPUImageFilter.getProgram(), "texelHeightOffset");
        int glGetUniformLocation3 = GLES20.glGetUniformLocation(gPUImageFilter.getProgram(), "distanceNormalizationFactor");
        int glGetUniformLocation4 = GLES20.glGetUniformLocation(gPUImageFilter.getProgram(), "gamaVal");
        gPUImageFilter.setFloat(glGetUniformLocation3, horizontalTexelOffsetRatio);
        gPUImageFilter.setFloat(glGetUniformLocation4, 0.9f);
        if (this.mOutputHeight != 0) {
            gPUImageFilter.setFloat(glGetUniformLocation2, 2.0f / this.mOutputHeight);
        }
        gPUImageFilter.setFloat(glGetUniformLocation, 0.0f);
        GPUImageFilter gPUImageFilter2 = this.mFilters.get(1);
        int glGetUniformLocation5 = GLES20.glGetUniformLocation(gPUImageFilter2.getProgram(), "texelWidthOffset");
        int glGetUniformLocation6 = GLES20.glGetUniformLocation(gPUImageFilter2.getProgram(), "texelHeightOffset");
        gPUImageFilter2.setFloat(glGetUniformLocation5, 0.0f);
        if (this.mOutputWidth != 0) {
            gPUImageFilter2.setFloat(glGetUniformLocation6, 2.0f / this.mOutputWidth);
        }
        int glGetUniformLocation7 = GLES20.glGetUniformLocation(gPUImageFilter2.getProgram(), "distanceNormalizationFactor");
        int glGetUniformLocation8 = GLES20.glGetUniformLocation(gPUImageFilter2.getProgram(), "gamaVal");
        gPUImageFilter2.setFloat(glGetUniformLocation7, horizontalTexelOffsetRatio);
        gPUImageFilter2.setFloat(glGetUniformLocation8, 0.9f);
    }

    @Override // com.yy.mediaframework.gpuimage.GPUImageFilterGroup, com.yy.mediaframework.gpuimage.GPUImageFilter
    public void onOutputSizeChanged(int i, int i2) {
        super.onOutputSizeChanged(i, i2);
        initTexelOffsets();
    }

    public float getVerticalTexelOffsetRatio() {
        return 1.0f;
    }

    public float getHorizontalTexelOffsetRatio() {
        return 1.0f;
    }
}
