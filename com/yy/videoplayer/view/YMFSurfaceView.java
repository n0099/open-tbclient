package com.yy.videoplayer.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.yy.videoplayer.IVideoInfoCallback;
import com.yy.videoplayer.decoder.HardDecodeWay;
import com.yy.videoplayer.decoder.StateMonitor;
import com.yy.videoplayer.decoder.VideoConstant;
import com.yy.videoplayer.decoder.VideoDecoderCenterExt;
import com.yy.videoplayer.decoder.YLightweightVideoViewExt;
import com.yy.videoplayer.decoder.YYVideoLibMgr;
import com.yy.videoplayer.utils.YMFLog;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public class YMFSurfaceView extends SurfaceView implements SurfaceHolder.Callback2, YLightweightVideoViewExt {
    private static final String TAG = "YMFSurfaceView";
    private int mHeight;
    private boolean mIsReleased;
    private Object mLockObject;
    private VideoConstant.OrientationType mOrientationType;
    private int mParentHeight;
    private int mParentWidth;
    private int mRotateAngle;
    private VideoConstant.ScaleMode mScaleMode;
    private long mStreamId;
    private SurfaceHolder mSurfaceHolder;
    private IVideoInfoCallback mVideoInfoCallback;
    private int mViewState;
    private WeakReference<HardDecodeWay> mWeakHard;
    private int mWidth;

    public YMFSurfaceView(Context context) {
        super(context.getApplicationContext());
        this.mWidth = 64;
        this.mHeight = 64;
        this.mParentWidth = 64;
        this.mParentHeight = 64;
        this.mScaleMode = VideoConstant.ScaleMode.AspectFit;
        this.mOrientationType = VideoConstant.OrientationType.Normal;
        this.mRotateAngle = 0;
        this.mIsReleased = false;
        this.mVideoInfoCallback = null;
        this.mLockObject = new Object();
        this.mViewState = 1;
        init();
    }

    public YMFSurfaceView(Context context, AttributeSet attributeSet) {
        super(context.getApplicationContext(), attributeSet);
        this.mWidth = 64;
        this.mHeight = 64;
        this.mParentWidth = 64;
        this.mParentHeight = 64;
        this.mScaleMode = VideoConstant.ScaleMode.AspectFit;
        this.mOrientationType = VideoConstant.OrientationType.Normal;
        this.mRotateAngle = 0;
        this.mIsReleased = false;
        this.mVideoInfoCallback = null;
        this.mLockObject = new Object();
        this.mViewState = 1;
        init();
    }

    public YMFSurfaceView(Context context, AttributeSet attributeSet, int i) {
        super(context.getApplicationContext(), attributeSet, i);
        this.mWidth = 64;
        this.mHeight = 64;
        this.mParentWidth = 64;
        this.mParentHeight = 64;
        this.mScaleMode = VideoConstant.ScaleMode.AspectFit;
        this.mOrientationType = VideoConstant.OrientationType.Normal;
        this.mRotateAngle = 0;
        this.mIsReleased = false;
        this.mVideoInfoCallback = null;
        this.mLockObject = new Object();
        this.mViewState = 1;
        init();
    }

    private void notifySurfaceToDecoderStaff(boolean z) {
        SurfaceHolder surfaceHolder;
        synchronized (this) {
            if (this.mWeakHard != null && this.mSurfaceHolder != null) {
                HardDecodeWay hardDecodeWay = this.mWeakHard.get();
                if (hardDecodeWay != null) {
                    try {
                        surfaceHolder = this.mSurfaceHolder;
                    } catch (Exception e) {
                        YMFLog.error(this, "[Render  ]", "notifySurfaceToDecoderStaff exception:" + YMFLog.stackTraceOf(e));
                    }
                    if (surfaceHolder != null) {
                        hardDecodeWay.OnSurfaceCreated();
                        hardDecodeWay.OnSurfaceChanged(this, surfaceHolder.getSurface(), this.mWidth, this.mHeight, this.mWidth, this.mHeight, this.mRotateAngle, this.mOrientationType, this.mScaleMode);
                    }
                }
            }
        }
    }

    private void notifySurfaceCreatedToDecoderStaff() {
        HardDecodeWay hardDecodeWay;
        if (this.mWeakHard != null && (hardDecodeWay = this.mWeakHard.get()) != null) {
            hardDecodeWay.OnSurfaceCreated();
        }
    }

    private void notifySurfaceRedrawToDecoderStaff() {
        HardDecodeWay hardDecodeWay;
        if (this.mWeakHard != null && (hardDecodeWay = this.mWeakHard.get()) != null) {
            hardDecodeWay.OnSurfaceRedraw();
        }
    }

    private void notifyDecoderStaffToReleaseSurface() {
        if (this.mWeakHard == null) {
            YMFLog.error(this, "[Render  ]", "notifyDecoderStaffToReleaseSurface mWeakHard == null");
            return;
        }
        HardDecodeWay hardDecodeWay = this.mWeakHard.get();
        if (hardDecodeWay == null) {
            YMFLog.error(this, "[Render  ]", "notifyDecoderStaffToReleaseSurface hardDecodeWay == null");
            return;
        }
        hardDecodeWay.SetPlayNotify(null);
        if (this.mSurfaceHolder != null) {
            hardDecodeWay.OnSurfaceDestroyed(this.mSurfaceHolder.getSurface());
            hardDecodeWay.setVideoInfoCallback(null);
            return;
        }
        YMFLog.error(this, "[Render  ]", "notifyDecoderStaffToReleaseSurface mSurfaceHolder == null");
    }

    @Override // com.yy.videoplayer.decoder.YLightweightVideoViewExt
    public void HoldDecoderStaff() {
        HardDecodeWay decoderStaff = VideoDecoderCenterExt.getDecoderStaff(this.mStreamId);
        YMFLog.info(this, "[Render  ]", "HoldDecoderStaff mStreamId:" + this.mStreamId + " hardDecodeWay:" + (decoderStaff != null));
        if (decoderStaff != null) {
            this.mWeakHard = new WeakReference<>(decoderStaff);
            notifySurfaceToDecoderStaff(false);
            decoderStaff.setVideoInfoCallback(this.mVideoInfoCallback);
        }
    }

    @Override // android.view.SurfaceHolder.Callback2
    public void surfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
        notifySurfaceRedrawToDecoderStaff();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.mSurfaceHolder = surfaceHolder;
        notifySurfaceCreatedToDecoderStaff();
        notifyViewStateChange(0);
        YMFLog.info(this, "[Render  ]", "surfaceCreated streamId:" + this.mStreamId);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        YMFLog.info(this, "[Render  ]", "surfaceChanged streamId:" + this.mStreamId + " width:" + i2 + " height:" + i3);
        this.mSurfaceHolder = surfaceHolder;
        this.mWidth = i2;
        this.mHeight = i3;
        notifyViewStateChange(0);
        notifySurfaceToDecoderStaff(true);
        notifySurfaceRedrawToDecoderStaff();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        YMFLog.info(this, "[Render  ]", "surfaceDestroyed streamId:" + this.mStreamId);
        notifyViewStateChange(1);
        this.mSurfaceHolder = surfaceHolder;
        notifyDecoderStaffToReleaseSurface();
        this.mSurfaceHolder = null;
    }

    public VideoConstant.ViewType getViewType() {
        return VideoConstant.ViewType.SURFACE_VIDEO_VIEW;
    }

    private void notifyViewStateChange(int i) {
        if (this.mViewState != i) {
            this.mViewState = i;
            YYVideoLibMgr.instance().onViewStateNotify(this.mStreamId, this.mViewState);
        }
    }

    public boolean setScaleMode(VideoConstant.ScaleMode scaleMode) {
        YMFLog.info(this, "[Render  ]", "setScaleMode:" + scaleMode);
        this.mScaleMode = scaleMode;
        notifySurfaceToDecoderStaff(false);
        return true;
    }

    public VideoConstant.ScaleMode getScaleMode() {
        return this.mScaleMode;
    }

    public void linkToStream(long j) {
        YMFLog.info(this, "[Render  ]", "linkToStream streamId:" + j);
        synchronized (this.mLockObject) {
            this.mStreamId = j;
            VideoDecoderCenterExt.Link(j, this);
            HoldDecoderStaff();
        }
        StateMonitor.instance().NotifyAddView(this.mStreamId, 0, VideoConstant.ViewType.SURFACE_VIDEO_VIEW, TAG);
    }

    public void unLinkFromStream() {
        YMFLog.info(this, "[Render  ]", "unlinktostream no param, mStreamId:" + this.mStreamId);
        synchronized (this.mLockObject) {
            notifyDecoderStaffToReleaseSurface();
            VideoDecoderCenterExt.Unlink(this.mStreamId);
            this.mWeakHard = null;
            StateMonitor.instance().NotifyRemoveView(this.mStreamId);
        }
    }

    public void unLinkFromStream(long j) {
        YMFLog.info(this, "[Render  ]", "unlinktostream streamId:" + j);
        synchronized (this.mLockObject) {
            notifyDecoderStaffToReleaseSurface();
            VideoDecoderCenterExt.Unlink(j);
            this.mWeakHard = null;
            StateMonitor.instance().NotifyRemoveView(this.mStreamId);
        }
    }

    public void init() {
        try {
            YMFLog.info(this, "[Render  ]", "YSurfaceVideoView init");
            setFocusable(true);
            getHolder().addCallback(this);
            setBackgroundColor(0);
            this.mIsReleased = false;
        } catch (Exception e) {
            YMFLog.error(this, "[Render  ]", "YSurfaceVideoView failed init, exception:" + e.toString());
        }
    }

    public void release() {
        YMFLog.info(this, "[Render  ]", "YSurfaceVideoView release");
        synchronized (this.mLockObject) {
            this.mIsReleased = true;
        }
    }

    public void setOrientation(VideoConstant.OrientationType orientationType, int i) {
        YMFLog.info(this, "[Render  ]", "setOrientation orientationType:" + orientationType + " rotateAngle:" + i);
        this.mOrientationType = orientationType;
        this.mRotateAngle = i;
        notifySurfaceToDecoderStaff(false);
    }

    public void onParentSizeChanged(int i, int i2) {
        YMFLog.info(this, "[Render  ]", "onParentSizeChanged width:" + i + " height:" + i2);
        this.mParentWidth = i;
        this.mParentHeight = i2;
        notifySurfaceToDecoderStaff(false);
    }

    public boolean isReleased() {
        return this.mIsReleased;
    }

    public void setVideoInfoCallback(IVideoInfoCallback iVideoInfoCallback) {
        this.mVideoInfoCallback = iVideoInfoCallback;
        if (this.mWeakHard == null) {
            YMFLog.error(this, "[Render  ]", "notifyDecoderStaffToReleaseSurface mWeakHard == null");
            return;
        }
        HardDecodeWay hardDecodeWay = this.mWeakHard.get();
        if (hardDecodeWay == null) {
            YMFLog.error(this, "[Render  ]", "notifyDecoderStaffToReleaseSurface hardDecodeWay == null");
        } else {
            hardDecodeWay.setVideoInfoCallback(iVideoInfoCallback);
        }
    }
}
