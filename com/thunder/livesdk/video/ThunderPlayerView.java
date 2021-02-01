package com.thunder.livesdk.video;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import com.thunder.livesdk.log.ThunderLog;
import com.yy.mediaframework.Constant;
import com.yy.mediaframework.YYVideoSDK;
import com.yy.videoplayer.YMFPlayerAPI;
import com.yy.videoplayer.view.YMFLayoutParams;
import com.yy.videoplayer.view.YMFVideoPosition;
/* loaded from: classes4.dex */
public class ThunderPlayerView extends VideoPlayerView {
    public final int INVALID_STREAM_ID;
    private final String TAG;
    private long mStreamId;
    private YMFLayoutParams mYMFLayoutParams;
    private YMFPlayerAPI mYMFPlayerInstance;

    public ThunderPlayerView(Context context) {
        super(context);
        this.TAG = "ThunderPlayerView " + Integer.toHexString(hashCode());
        this.mStreamId = 0L;
        this.mYMFPlayerInstance = null;
        this.INVALID_STREAM_ID = -1;
        createVideoView();
    }

    public ThunderPlayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.TAG = "ThunderPlayerView " + Integer.toHexString(hashCode());
        this.mStreamId = 0L;
        this.mYMFPlayerInstance = null;
        this.INVALID_STREAM_ID = -1;
        createVideoView();
    }

    public ThunderPlayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.TAG = "ThunderPlayerView " + Integer.toHexString(hashCode());
        this.mStreamId = 0L;
        this.mYMFPlayerInstance = null;
        this.INVALID_STREAM_ID = -1;
        createVideoView();
    }

    public boolean isViewLinkedToStream() {
        return this.mStreamId != 0;
    }

    public boolean isViewPrepared() {
        return this.mPrepared;
    }

    public boolean createVideoView() {
        if (this.mYMFPlayerInstance == null) {
            this.mYMFPlayerInstance = YMFPlayerAPI.newInstance();
        }
        this.mUniformView = this.mYMFPlayerInstance.createView(getContext());
        if (this.mUniformView != null) {
            addView(this.mUniformView);
            if (this.mYMFLayoutParams != null) {
                this.mYMFPlayerInstance.setViewLayout(this.mUniformView, this.mYMFLayoutParams);
            }
            this.mYMFPlayerInstance.setScaleMode(this.mUniformView, this.mScaleMode, -1);
            this.mPrepared = true;
        }
        return true;
    }

    public void linkToStream(long j) {
        synchronized (this) {
            if (this.mYMFPlayerInstance != null && this.mUniformView != null) {
                drawBlackScreen(false);
                this.mYMFPlayerInstance.linkStream(this.mUniformView, j, -1);
            }
            this.mStreamId = j;
        }
        ThunderLog.release(ThunderLog.kLogTagVideo, this.TAG + " linkToStream " + j);
    }

    @Override // com.thunder.livesdk.video.VideoPlayerView
    public int linkToStream(long j, int i) {
        ThunderLog.release(ThunderLog.kLogTagVideo, this.TAG + " linkToStream mUniformView " + this.mUniformView + " linkToStream " + j + " videoIndex " + i);
        if (j == 0 || i < 0 || this.mUniformView == null) {
            return -1;
        }
        if (this.mYMFPlayerInstance != null) {
            drawBlackScreen(false);
            return this.mYMFPlayerInstance.linkStream(this.mUniformView, j, i);
        }
        return 0;
    }

    @Override // com.thunder.livesdk.video.VideoPlayerView
    public int unLinkFromStream(long j, int i) {
        ThunderLog.release(ThunderLog.kLogTagVideo, this.TAG + " unLinkFromStream mUniformView " + this.mUniformView + " linkToStream " + j + " videoIndex " + i);
        if (j == 0 || i < 0 || this.mUniformView == null) {
            return -1;
        }
        if (this.mYMFPlayerInstance != null) {
            return this.mYMFPlayerInstance.unLinkStream(this.mUniformView, j, i);
        }
        return 0;
    }

    public void unLinkFromStream(long j) {
        synchronized (this) {
            if (this.mYMFPlayerInstance != null && this.mUniformView != null) {
                this.mYMFPlayerInstance.unLinkStream(this.mUniformView, j, -1);
            }
            this.mStreamId = 0L;
        }
        ThunderLog.release(ThunderLog.kLogTagVideo, this.TAG + " unLinkFromStream " + j);
    }

    public void unLinkFromStream() {
        if (this.mYMFPlayerInstance != null && this.mUniformView != null) {
            this.mYMFPlayerInstance.unLinkStream(this.mUniformView, this.mStreamId, -1);
        }
        this.mStreamId = 0L;
        ThunderLog.release(ThunderLog.kLogTagVideo, this.TAG + " unLinkFromStream() ");
    }

    public boolean setScaleMode(int i) {
        this.mScaleMode = scaleModeConvert(i);
        if (this.mYMFPlayerInstance != null) {
            this.mYMFPlayerInstance.setScaleMode(this.mUniformView, this.mScaleMode, -1);
        }
        return false;
    }

    @Override // com.thunder.livesdk.video.VideoPlayerView
    public boolean setScaleMode(int i, int i2) {
        synchronized (this) {
            this.mScaleMode = scaleModeConvert(i2);
            if (this.mYMFPlayerInstance != null) {
                this.mYMFPlayerInstance.setScaleMode(this.mUniformView, this.mScaleMode, i);
            }
        }
        return false;
    }

    @Override // com.thunder.livesdk.video.VideoPlayerView
    public void setMirrorMode(int i, int i2) {
        this.mMirrorMode = mirrorModeConvert(i2);
        if (this.mYMFPlayerInstance != null) {
            this.mYMFPlayerInstance.setMirrorMode(this.mUniformView, this.mMirrorMode, i);
        }
    }

    @Override // com.thunder.livesdk.video.VideoPlayerView
    public Bitmap getVideoScreenshot(int i) {
        synchronized (this) {
            if (this.mYMFPlayerInstance != null) {
                return this.mYMFPlayerInstance.getVideoScreenshot(this.mUniformView, i);
            }
            return null;
        }
    }

    public void drawBlackScreen(boolean z) {
        if (this.mYMFPlayerInstance != null) {
            this.mYMFPlayerInstance.setLastFrameRenderBlack(this.mUniformView, z);
        }
    }

    @Override // com.thunder.livesdk.video.VideoPlayerView
    public void updateMultiViewLayout(YMFLayoutParams yMFLayoutParams) {
        this.mYMFLayoutParams = yMFLayoutParams;
        drawBlackScreen(false);
        if (this.mYMFPlayerInstance != null) {
            this.mYMFPlayerInstance.setViewLayout(this.mUniformView, yMFLayoutParams);
        }
    }

    @Override // com.thunder.livesdk.video.VideoPlayerView
    public void enterMultiVideoViewMode(YMFLayoutParams yMFLayoutParams, Constant.MultiLianmaiMode multiLianmaiMode) {
        if (ThunderLog.isInfoValid()) {
            ThunderLog.info(this.TAG, "enterMultiVideoViewMode multiVideoViewParams = [" + yMFLayoutParams + "], lianmaiMode=" + multiLianmaiMode);
        }
        if (yMFLayoutParams == null) {
            YMFLayoutParams yMFLayoutParams2 = new YMFLayoutParams(1);
            YMFVideoPosition yMFVideoPosition = new YMFVideoPosition();
            yMFVideoPosition.mIndex = 0;
            yMFVideoPosition.mX = 0;
            yMFVideoPosition.mY = 0;
            yMFVideoPosition.mHeight = -2;
            yMFVideoPosition.mWidth = -2;
            yMFLayoutParams2.mDrawPosition[0] = yMFVideoPosition;
            setUseMultiVideoView(yMFLayoutParams2);
            return;
        }
        synchronized (this) {
            YYVideoSDK.getInstance().setMultiVideoLianmaiMode(multiLianmaiMode);
            setUseMultiVideoView(yMFLayoutParams);
        }
    }

    @Override // com.thunder.livesdk.video.VideoPlayerView
    public void leaveMultiVideoViewMode() {
        if (ThunderLog.isInfoValid()) {
            ThunderLog.info(this.TAG, "leaveMultiVideoViewMode ");
        }
        synchronized (this) {
            setUseMultiVideoView(null);
            YYVideoSDK.getInstance().setMultiVideoLianmaiMode(Constant.MultiLianmaiMode.NormalMode);
        }
    }

    private void setUseMultiVideoView(YMFLayoutParams yMFLayoutParams) {
        if (ThunderLog.isInfoValid()) {
            ThunderLog.info(this.TAG, "setUseMultiVideoView");
        }
        this.mYMFLayoutParams = yMFLayoutParams;
        drawBlackScreen(false);
        if (this.mYMFPlayerInstance != null) {
            this.mYMFPlayerInstance.setViewLayout(this.mUniformView, this.mYMFLayoutParams);
        }
    }

    @Override // com.thunder.livesdk.video.VideoPlayerView
    public int switchDualVideoView(long j, long j2, int i) {
        if (j == 0 || j2 == 0 || this.mUniformView == null || this.mYMFPlayerInstance == null || this.mUniformView == null) {
            return -1;
        }
        return this.mYMFPlayerInstance.switchDualVideoView(this.mUniformView, j, j2, i);
    }
}
