package com.thunder.livesdk.video;

import com.thunder.livesdk.ThunderBridgeLib;
import com.yy.mediaframework.gpuimage.custom.IYMFGpuProcess;
import com.yy.mediaframework.gpuimage.custom.YMFVideoFrame;
import java.nio.FloatBuffer;
/* loaded from: classes6.dex */
public class VideoFrameTextrue implements IYMFGpuProcess {
    private static volatile VideoFrameTextrue instance;
    private static Object syncLock = new Object();
    private VideoTextureFrameObserver mVideoTextureFrameObserver = null;
    private VideoTextureFrameObserver mNewVideoTextureFrameObserver = null;
    ThunderVideoFrame mVideoFrame = new ThunderVideoFrame();

    public static VideoFrameTextrue getInstance() {
        if (instance == null) {
            synchronized (syncLock) {
                if (instance == null) {
                    instance = new VideoFrameTextrue();
                }
            }
        }
        return instance;
    }

    private VideoFrameTextrue() {
    }

    public void enableVideoTextrue(VideoTextureFrameObserver videoTextureFrameObserver) {
        synchronized (syncLock) {
            if (videoTextureFrameObserver != null) {
                this.mNewVideoTextureFrameObserver = videoTextureFrameObserver;
                ThunderBridgeLib.getInstance().setGPUImageProcessFilter(this);
            }
        }
    }

    @Override // com.yy.mediaframework.gpuimage.custom.IGPUProcess
    public void onInit(int i, int i2, int i3) {
        synchronized (syncLock) {
            this.mVideoTextureFrameObserver = this.mNewVideoTextureFrameObserver;
            if (this.mVideoTextureFrameObserver != null) {
                this.mVideoTextureFrameObserver.onInit(i, i2, i3);
            }
        }
    }

    @Override // com.yy.mediaframework.gpuimage.custom.IGPUProcess
    public void onDraw(int i, FloatBuffer floatBuffer) {
    }

    @Override // com.yy.mediaframework.gpuimage.custom.IYMFGpuProcess
    public void onDraw(YMFVideoFrame yMFVideoFrame) {
        synchronized (syncLock) {
            if (this.mVideoTextureFrameObserver != null) {
                this.mVideoFrame.setVideoFrame(yMFVideoFrame);
                this.mVideoTextureFrameObserver.onDraw(this.mVideoFrame);
            }
        }
    }

    @Override // com.yy.mediaframework.gpuimage.custom.IGPUProcess
    public void onDestroy() {
        synchronized (syncLock) {
            if (this.mVideoTextureFrameObserver != null) {
                this.mVideoTextureFrameObserver.onDestroy();
            }
        }
    }

    @Override // com.yy.mediaframework.gpuimage.custom.IGPUProcess
    public void onOutputSizeChanged(int i, int i2) {
        synchronized (syncLock) {
            if (this.mVideoTextureFrameObserver != null) {
                this.mVideoTextureFrameObserver.onOutputSizeChanged(i, i2);
            }
        }
    }
}
