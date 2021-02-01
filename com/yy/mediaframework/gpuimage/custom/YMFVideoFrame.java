package com.yy.mediaframework.gpuimage.custom;

import android.hardware.Camera;
import java.nio.FloatBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes4.dex */
public class YMFVideoFrame {
    public long mIndex = 0;
    public AtomicBoolean mWillBeRendered = null;
    public int mTextureTarget = 0;
    public int mTextureId = 0;
    public int mTextureWidth = 0;
    public int mTextureHeight = 0;
    public int mWidth = 0;
    public int mHeight = 0;
    public FloatBuffer mTextureCoord = null;
    public byte[] mYUVCaptureBuffer = null;
    public int mImageFormat = 17;
    public int mYuvWidth = 0;
    public int mYuvHeight = 0;
    public Camera mCamera = null;
}
