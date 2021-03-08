package com.yy.mediaframework.filters;

import com.yy.mediaframework.gpuimage.custom.IGPUProcess;
import com.yy.mediaframework.gpuimage.custom.IYMFGpuProcess;
import com.yy.mediaframework.gpuimage.custom.YMFVideoFrame;
import com.yy.mediaframework.model.YYMediaSample;
import com.yy.mediaframework.opengles.YMFFramebuffer;
import com.yy.mediaframework.opengles.YMFShaderData;
import com.yy.mediaframework.stat.VideoDataStatUtil;
import com.yy.mediaframework.utils.YMFLog;
/* loaded from: classes6.dex */
public class YMFTextureCallbackFilter extends AbstractYYMediaFilter {
    private static final String TAG = "YMFTextureCallbackFilter";
    private boolean mCallBackInited;
    private VideoLiveFilterContext mFilterContext;
    private IGPUProcess mGpuProcess;
    private YMFFramebuffer mTextureCBFrameBuffer;
    private YMFVideoFrame mYMFVideoFrame = new YMFVideoFrame();
    private YMFShaderData mShaderData = new YMFShaderData();

    public YMFTextureCallbackFilter(VideoLiveFilterContext videoLiveFilterContext) {
        this.mFilterContext = videoLiveFilterContext;
    }

    public void setGpuProcess(IGPUProcess iGPUProcess) {
        if (iGPUProcess == null) {
            if (this.mGpuProcess != null) {
                this.mGpuProcess.onDestroy();
            }
            this.mCallBackInited = false;
        }
        YMFLog.info(this, "[Beauty  ]", "setGpuProcess:" + iGPUProcess);
        this.mGpuProcess = iGPUProcess;
    }

    private void onInitCB(int i, int i2, int i3) {
        if (this.mGpuProcess != null) {
            this.mYMFVideoFrame.mTextureTarget = i3;
            this.mYMFVideoFrame.mTextureWidth = i;
            this.mYMFVideoFrame.mTextureHeight = i2;
            this.mGpuProcess.onInit(i3, i, i2);
            this.mCallBackInited = true;
        }
    }

    private void onTextureSizeChange(int i, int i2) {
        if (this.mGpuProcess != null) {
            this.mYMFVideoFrame.mTextureWidth = i;
            this.mYMFVideoFrame.mTextureHeight = i2;
            this.mGpuProcess.onOutputSizeChanged(i, i2);
        }
    }

    private void onTextureCallback(YYMediaSample yYMediaSample) {
        if (this.mGpuProcess != null) {
            if (this.mTextureCBFrameBuffer == null) {
                this.mTextureCBFrameBuffer = new YMFFramebuffer();
            }
            this.mTextureCBFrameBuffer.attachTexture(yYMediaSample.mMasterTextureId);
            long currentTimeMillis = System.currentTimeMillis();
            this.mYMFVideoFrame.mTextureId = yYMediaSample.mMasterTextureId;
            this.mYMFVideoFrame.mTextureCoord = this.mShaderData.getTextureCoordData();
            this.mYMFVideoFrame.mYUVCaptureBuffer = yYMediaSample.mDataBytes;
            this.mYMFVideoFrame.mWidth = this.mYMFVideoFrame.mTextureWidth;
            this.mYMFVideoFrame.mHeight = this.mYMFVideoFrame.mTextureHeight;
            if (this.mGpuProcess instanceof IYMFGpuProcess) {
                ((IYMFGpuProcess) this.mGpuProcess).onDraw(this.mYMFVideoFrame);
            } else {
                this.mGpuProcess.onDraw(yYMediaSample.mMasterTextureId, this.mShaderData.getTextureCoordData());
            }
            VideoDataStatUtil.putBeautyTime(System.currentTimeMillis() - currentTimeMillis);
            this.mTextureCBFrameBuffer.unBind();
        }
    }

    @Override // com.yy.mediaframework.filters.AbstractYYMediaFilter, com.yy.mediaframework.IMediaFilter
    public boolean processMediaSample(YYMediaSample yYMediaSample, Object obj) {
        yYMediaSample.addRef();
        if (!this.mCallBackInited) {
            onInitCB(yYMediaSample.mWidth, yYMediaSample.mHeight, yYMediaSample.mTextureTarget);
        }
        if (this.mYMFVideoFrame.mTextureWidth != yYMediaSample.mWidth || this.mYMFVideoFrame.mTextureHeight != yYMediaSample.mHeight) {
            onTextureSizeChange(yYMediaSample.mWidth, yYMediaSample.mHeight);
        }
        onTextureCallback(yYMediaSample);
        if (yYMediaSample.mCameraFacing == 1) {
            yYMediaSample.mDataMirror = true;
        }
        deliverToDownStream(yYMediaSample);
        yYMediaSample.decRef();
        return false;
    }

    @Override // com.yy.mediaframework.filters.AbstractYYMediaFilter
    public void deInit() {
        super.deInit();
        if (this.mGpuProcess != null) {
            this.mGpuProcess.onDestroy();
        }
        if (this.mTextureCBFrameBuffer != null) {
            this.mTextureCBFrameBuffer.release();
        }
    }
}
