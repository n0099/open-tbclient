package com.thunder.livesdk.video;

import android.hardware.Camera;
import com.yy.mediaframework.gpuimage.custom.YMFVideoFrame;
import java.nio.FloatBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes4.dex */
public class ThunderVideoFrame {
    public long mIndex = 0;
    public AtomicBoolean mWillBeRendered = null;
    public int mTextureTarget = 0;
    public int mTextureId = 0;
    public int mTextureWidth = 0;
    public int mTextureHeight = 0;
    public FloatBuffer mTextureCoord = null;
    public byte[] mYUVCaptureBuffer = null;
    public int mImageFormat = 17;
    public int mYuvWidth = 0;
    public int mYuvHeight = 0;
    public Camera mCamera = null;

    public void setVideoFrame(YMFVideoFrame yMFVideoFrame) {
        if (yMFVideoFrame != null) {
            this.mIndex = yMFVideoFrame.mIndex;
            this.mWillBeRendered = yMFVideoFrame.mWillBeRendered;
            this.mTextureTarget = yMFVideoFrame.mTextureTarget;
            this.mTextureId = yMFVideoFrame.mTextureId;
            this.mTextureWidth = yMFVideoFrame.mTextureWidth;
            this.mTextureHeight = yMFVideoFrame.mTextureHeight;
            this.mTextureCoord = yMFVideoFrame.mTextureCoord;
            this.mYUVCaptureBuffer = yMFVideoFrame.mYUVCaptureBuffer;
            this.mImageFormat = yMFVideoFrame.mImageFormat;
            this.mYuvWidth = yMFVideoFrame.mYuvWidth;
            this.mYuvHeight = yMFVideoFrame.mYuvHeight;
            this.mCamera = yMFVideoFrame.mCamera;
            return;
        }
        this.mIndex = 0L;
        this.mWillBeRendered = null;
        this.mTextureTarget = 0;
        this.mTextureId = 0;
        this.mTextureWidth = 0;
        this.mTextureHeight = 0;
        this.mTextureCoord = null;
        this.mYUVCaptureBuffer = null;
        this.mImageFormat = 17;
        this.mYuvWidth = 0;
        this.mYuvHeight = 0;
        this.mCamera = null;
    }
}
