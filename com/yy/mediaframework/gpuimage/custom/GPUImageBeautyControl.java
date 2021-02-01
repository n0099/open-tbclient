package com.yy.mediaframework.gpuimage.custom;
/* loaded from: classes4.dex */
public class GPUImageBeautyControl {
    private IGPUProcess mGPUImageProcess = null;

    public void setGPUImageBeautyFilter(IGPUProcess iGPUProcess) {
        this.mGPUImageProcess = iGPUProcess;
    }

    public IGPUProcess getGPUImageBeautyFilter() {
        return this.mGPUImageProcess;
    }
}
