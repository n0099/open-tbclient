package com.yy.videoplayer.view;

import com.yy.videoplayer.decoder.VideoConstant;
import com.yy.videoplayer.decoder.VideoSizeUtils;
import com.yy.videoplayer.render.YMFImageBuffer;
/* loaded from: classes4.dex */
public class YMFRenderImage {
    public YMFImageBuffer mDecodeImage;
    public YMFVideoPosition mBackGroundPosition = new YMFVideoPosition();
    public YMFVideoPosition mDrawPosition = new YMFVideoPosition();
    public YMFVideoPosition mOriginPosition = new YMFVideoPosition();
    public VideoSizeUtils.Size mVideoSize = new VideoSizeUtils.Size();
    public VideoConstant.ScaleMode mScaleMode = VideoConstant.ScaleMode.AspectFit;
    public VideoConstant.VideoViewMode mVideoMode = VideoConstant.VideoViewMode.SingeMode;
    public VideoConstant.MirrorMode mMirrorMode = VideoConstant.MirrorMode.Disabled;
    public long mStreamId = 0;
    public int mVideoWidth = 0;
    public int mVideoHeight = 0;
    public int mSurfaceWidth = 0;
    public int mSurfaceHeight = 0;
    public boolean mRenderPrepared = false;

    public String toString() {
        return ("" + this.mVideoMode + ":") + this.mStreamId + "," + this.mSurfaceWidth + "," + this.mSurfaceHeight + ":" + this.mDrawPosition.toString();
    }
}
