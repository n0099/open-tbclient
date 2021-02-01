package com.thunder.livesdk.video;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.thunder.livesdk.log.ThunderLog;
import com.yy.mediaframework.Constant;
import com.yy.videoplayer.decoder.VideoConstant;
import com.yy.videoplayer.view.YMFLayoutParams;
/* loaded from: classes4.dex */
public abstract class VideoPlayerView extends FrameLayout {
    protected VideoConstant.MirrorMode mMirrorMode;
    public boolean mPrepared;
    protected VideoConstant.ScaleMode mScaleMode;
    protected View mUniformView;
    protected int mViewHeight;
    protected VideoConstant.ViewType mViewType;
    protected int mViewWidth;

    public abstract void enterMultiVideoViewMode(YMFLayoutParams yMFLayoutParams, Constant.MultiLianmaiMode multiLianmaiMode);

    public abstract Bitmap getVideoScreenshot(int i);

    public abstract void leaveMultiVideoViewMode();

    public abstract int linkToStream(long j, int i);

    public abstract void setMirrorMode(int i, int i2);

    public abstract boolean setScaleMode(int i, int i2);

    public abstract int switchDualVideoView(long j, long j2, int i);

    public abstract int unLinkFromStream(long j, int i);

    public abstract void updateMultiViewLayout(YMFLayoutParams yMFLayoutParams);

    public VideoPlayerView(Context context) {
        super(context);
        this.mUniformView = null;
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.mPrepared = false;
        this.mScaleMode = VideoConstant.ScaleMode.AspectFit;
        this.mMirrorMode = VideoConstant.MirrorMode.Disabled;
    }

    public VideoPlayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mUniformView = null;
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.mPrepared = false;
        this.mScaleMode = VideoConstant.ScaleMode.AspectFit;
        this.mMirrorMode = VideoConstant.MirrorMode.Disabled;
    }

    public VideoPlayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mUniformView = null;
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.mPrepared = false;
        this.mScaleMode = VideoConstant.ScaleMode.AspectFit;
        this.mMirrorMode = VideoConstant.MirrorMode.Disabled;
    }

    public int getViewType() {
        return this.mViewType == VideoConstant.ViewType.SURFACE_VIDEO_VIEW ? 1 : 0;
    }

    public View getView() {
        return this.mUniformView;
    }

    public View getYspVideoView() {
        return this.mUniformView;
    }

    public boolean isPrepared() {
        return this.mPrepared;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public VideoConstant.ScaleMode scaleModeConvert(int i) {
        switch (i) {
            case 0:
                return VideoConstant.ScaleMode.FillParent;
            case 1:
                return VideoConstant.ScaleMode.AspectFit;
            case 2:
                return VideoConstant.ScaleMode.ClipToBounds;
            case 3:
                return VideoConstant.ScaleMode.Original;
            default:
                ThunderLog.warn(ThunderLog.kLogTagVideo, "invalid scale mode %d", Integer.valueOf(i));
                return VideoConstant.ScaleMode.AspectFit;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public VideoConstant.MirrorMode mirrorModeConvert(int i) {
        switch (i) {
            case 0:
                return VideoConstant.MirrorMode.Disabled;
            case 1:
                return VideoConstant.MirrorMode.Enabled;
            default:
                ThunderLog.warn(ThunderLog.kLogTagVideo, "invalid mirror mode %d", Integer.valueOf(i));
                return VideoConstant.MirrorMode.Disabled;
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mViewWidth = i;
        this.mViewHeight = i2;
    }
}
