package com.yy.mediaframework.filters;

import com.yy.mediaframework.model.YYMediaSample;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes4.dex */
public class FPSFlowCtrlFilter extends AbstractYYMediaFilter {
    private VideoLiveFilterContext mFilterContext;
    private Timer mFPSTimer = null;
    private AtomicBoolean mInited = new AtomicBoolean(false);
    private long mLastSampleYYPtsMS = 0;
    private YYMediaSample mCurrentMediaSample = null;

    FPSFlowCtrlFilter(VideoLiveFilterContext videoLiveFilterContext) {
        this.mFilterContext = videoLiveFilterContext;
    }

    public void init() {
        this.mFPSTimer = new Timer();
        this.mFPSTimer.schedule(new TimerTask() { // from class: com.yy.mediaframework.filters.FPSFlowCtrlFilter.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                FPSFlowCtrlFilter.this.mFilterContext.getGlManager().post(new Runnable() { // from class: com.yy.mediaframework.filters.FPSFlowCtrlFilter.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        FPSFlowCtrlFilter.this.onEncodeFrame();
                    }
                });
            }
        }, 0L, 1000 / this.mFilterContext.getVideoEncoderConfig().mFrameRate);
        this.mInited.set(true);
    }

    @Override // com.yy.mediaframework.filters.AbstractYYMediaFilter
    public void deInit() {
        this.mInited.set(false);
        this.mFPSTimer.cancel();
        if (this.mCurrentMediaSample != null) {
            this.mCurrentMediaSample.decRef();
            this.mCurrentMediaSample = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onEncodeFrame() {
        if (this.mCurrentMediaSample != null && this.mLastSampleYYPtsMS != this.mCurrentMediaSample.mYYPtsMillions && this.mInited.get()) {
            this.mLastSampleYYPtsMS = this.mCurrentMediaSample.mYYPtsMillions;
            deliverToDownStream(this.mCurrentMediaSample);
            this.mCurrentMediaSample.decRef();
            this.mCurrentMediaSample = null;
        }
    }

    @Override // com.yy.mediaframework.filters.AbstractYYMediaFilter, com.yy.mediaframework.IMediaFilter
    public boolean processMediaSample(YYMediaSample yYMediaSample, Object obj) {
        if (this.mCurrentMediaSample != null) {
            this.mCurrentMediaSample.decRef();
        }
        this.mCurrentMediaSample = yYMediaSample;
        this.mCurrentMediaSample.addRef();
        return false;
    }
}
