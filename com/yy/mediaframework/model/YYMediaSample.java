package com.yy.mediaframework.model;

import android.graphics.RectF;
import android.media.MediaFormat;
import com.yy.mediaframework.CameraInterface;
import com.yy.mediaframework.Constant;
import com.yy.mediaframework.PictureInPictureDisplayInfo;
import com.yy.mediaframework.base.VideoEncoderType;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes6.dex */
public class YYMediaSample {
    public int mCameraFacing;
    public AtomicBoolean mCameraNV21DataUsed;
    public int mCameraRotate;
    public boolean mCliped;
    public int mColorFormat;
    public int mImageFormat;
    public YMFImageBuffer mNv21Buffer;
    public int mOrginalCameraFacing;
    public int mOrientation;
    public PictureInPictureDisplayInfo mPictureInPictureDisplayInfo;
    public CameraInterface.CameraResolutionMode mResMode;
    public boolean mSwapWidthHeight;
    public int mTextureTarget;
    public boolean mVideoStabilization;
    public int mWidth = 0;
    public int mHeight = 0;
    public int mClipWidth = 0;
    public int mClipHeight = 0;
    public int mClipX = 0;
    public int mClipY = 0;
    public long mAndoridPtsNanos = 0;
    public long mYYPtsMillions = 0;
    public long mDtsMillions = 0;
    public float[] mMainTransformer = new float[16];
    public float[] mSlaveTransformer = new float[16];
    public boolean mCameraCapture = false;
    public MediaFormat mMediaFormat = null;
    public int mFrameFlag = 0;
    public int mFrameType = 255;
    public long mIndex = 0;
    public boolean mTextureValid = true;
    public ByteBuffer mDataByteBuffer = null;
    public int mBufferOffset = 0;
    public int mBufferSize = 0;
    public byte[] mDataBytes = null;
    public byte[] mRGBABytes = null;
    public boolean mIsYUVBuffer = false;
    public boolean mUseGPUBeauty = false;
    public boolean mDataMirror = false;
    public YMFImageBuffer mI420 = null;
    public YMFImageBuffer mYV12 = null;
    public YMFImageBuffer mNV21 = null;
    public YMFImageBuffer mNV12 = null;
    public YMFImageBuffer mRGBA = null;
    public int mMasterTextureId = -1;
    public int mSlaveTextureId = -1;
    public boolean isUsePbo = false;
    public long mFrameDeltaDts = 0;
    public int mBlenderTextureId = -1;
    public boolean isDualCamera = false;
    public boolean mIsMirrorEnable = false;
    public boolean mIsPreviewMirrorEnable = false;
    public long mTextureCreatedThreadId = -1;
    public boolean mTextureFlipVertical = false;
    public int mEncodeWidth = 0;
    public int mEncodeHeight = 0;
    public int mCodecId = 0;
    public int mStreamId = 0;
    public boolean mUsedExternPts = false;
    public boolean mUseExternalVideoFrame = false;
    public int mExternalFrameScaleMode = 1;
    public VideoEncoderType mEncoderType = VideoEncoderType.HARD_ENCODER_H264;
    public Constant.EncoderInputMode mEncoderInputMode = Constant.EncoderInputMode.SURFACE;
    public HashMap<String, String> mExtInfo = null;
    public RectF mScreenCropArea = null;
    public AtomicInteger mRefCnt = new AtomicInteger(0);

    public int addRef() {
        return 0;
    }

    public int decRef() {
        return 0;
    }

    public void reset() {
        this.mWidth = 0;
        this.mHeight = 0;
        this.mClipWidth = 0;
        this.mClipHeight = 0;
        this.mAndoridPtsNanos = 0L;
        this.mYYPtsMillions = 0L;
        this.mDtsMillions = 0L;
        this.mIndex = 0L;
        this.mMediaFormat = null;
        this.mColorFormat = 0;
        this.mFrameFlag = 0;
        this.mFrameType = 255;
        this.mDataByteBuffer = null;
        this.mBufferOffset = 0;
        this.mBufferSize = 0;
        this.mDataBytes = null;
        this.mI420 = null;
        this.mNV12 = null;
        this.mNV21 = null;
        this.mIsYUVBuffer = false;
        this.mSwapWidthHeight = false;
        this.mCliped = false;
        this.mCameraRotate = 0;
        this.mMasterTextureId = -1;
        this.mSlaveTextureId = -1;
        this.mTextureTarget = -1;
        this.mTextureCreatedThreadId = -1L;
        this.mTextureFlipVertical = false;
        this.mCameraCapture = false;
        this.mUsedExternPts = false;
        this.mEncodeWidth = 0;
        this.mEncodeHeight = 0;
        this.mEncoderType = VideoEncoderType.HARD_ENCODER_H264;
        this.mBlenderTextureId = -1;
        this.isUsePbo = false;
        this.mFrameDeltaDts = 0L;
        System.arraycopy(Constant.mtxIdentity, 0, this.mMainTransformer, 0, this.mMainTransformer.length);
        this.mRefCnt.set(0);
    }

    public void assigne(YYMediaSample yYMediaSample) {
        this.mWidth = yYMediaSample.mWidth;
        this.mHeight = yYMediaSample.mHeight;
        this.mClipWidth = yYMediaSample.mClipWidth;
        this.mClipHeight = yYMediaSample.mClipHeight;
        this.mAndoridPtsNanos = yYMediaSample.mAndoridPtsNanos;
        this.mYYPtsMillions = yYMediaSample.mYYPtsMillions;
        this.mDtsMillions = yYMediaSample.mDtsMillions;
        this.mResMode = yYMediaSample.mResMode;
        this.mImageFormat = yYMediaSample.mImageFormat;
        this.mCameraFacing = yYMediaSample.mCameraFacing;
        this.mOrientation = yYMediaSample.mOrientation;
        this.mVideoStabilization = yYMediaSample.mVideoStabilization;
        System.arraycopy(yYMediaSample.mMainTransformer, 0, this.mMainTransformer, 0, this.mMainTransformer.length);
        this.mMediaFormat = yYMediaSample.mMediaFormat;
        this.mColorFormat = yYMediaSample.mColorFormat;
        this.mFrameFlag = yYMediaSample.mFrameFlag;
        this.mFrameType = yYMediaSample.mFrameType;
        this.mDataByteBuffer = yYMediaSample.mDataByteBuffer;
        this.mBufferOffset = yYMediaSample.mBufferOffset;
        this.mBufferSize = yYMediaSample.mBufferSize;
        this.mDataBytes = yYMediaSample.mDataBytes;
        this.mMasterTextureId = yYMediaSample.mMasterTextureId;
        this.mSlaveTextureId = yYMediaSample.mSlaveTextureId;
        this.mTextureTarget = yYMediaSample.mTextureTarget;
        this.mTextureCreatedThreadId = yYMediaSample.mTextureCreatedThreadId;
        this.mExtInfo = yYMediaSample.mExtInfo;
        this.mScreenCropArea = yYMediaSample.mScreenCropArea;
        this.mTextureFlipVertical = yYMediaSample.mTextureFlipVertical;
        this.mEncodeWidth = yYMediaSample.mEncodeWidth;
        this.mEncodeHeight = yYMediaSample.mEncodeHeight;
        this.mEncoderType = yYMediaSample.mEncoderType;
        this.mCameraCapture = yYMediaSample.mCameraCapture;
        this.mBlenderTextureId = yYMediaSample.mBlenderTextureId;
        this.mIsMirrorEnable = yYMediaSample.mIsMirrorEnable;
        this.mIsPreviewMirrorEnable = yYMediaSample.mIsPreviewMirrorEnable;
        this.mCliped = yYMediaSample.mCliped;
        this.mIsYUVBuffer = yYMediaSample.mIsYUVBuffer;
        this.mUsedExternPts = yYMediaSample.mUsedExternPts;
        this.mIndex = yYMediaSample.mIndex;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" mWidth:").append(this.mWidth);
        sb.append(" mHeight:").append(this.mHeight);
        sb.append(" mEncodeWidth:").append(this.mEncodeWidth);
        sb.append(" mEncodeHeight:").append(this.mEncodeHeight);
        sb.append(" mFrameType:").append(this.mFrameType);
        sb.append(" mMasterTextureId:").append(this.mMasterTextureId);
        sb.append(" mEncoderType:").append(this.mEncoderType);
        sb.append(" mCameraFacing:").append(this.mCameraFacing);
        sb.append(" mOrientation:").append(this.mOrientation);
        sb.append(" mClipWidth:").append(this.mClipWidth);
        sb.append(" mClipHeight:").append(this.mClipHeight);
        sb.append(" mIndex:").append(this.mIndex);
        return sb.toString();
    }

    static YYMediaSample allocSample() {
        return YYMediaSampleAlloc.instance().alloc();
    }
}
