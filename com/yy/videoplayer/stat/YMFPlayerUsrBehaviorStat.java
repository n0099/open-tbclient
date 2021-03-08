package com.yy.videoplayer.stat;

import com.yy.videoplayer.Constant;
import com.yy.videoplayer.utils.YMFLog;
/* loaded from: classes6.dex */
public class YMFPlayerUsrBehaviorStat {
    private static YMFPlayerUsrBehaviorStat mInstance;
    private String tag = "YMFPlay";
    public IYMFBehaviorEventListener mBehaviorListener = null;

    /* loaded from: classes6.dex */
    private interface UsrBehaviorStatInfoKey {
        public static final String FirstFrameDecode = "firstFrameDecode";
        public static final String FirstFrameRendered = "firstFrameRendered";
        public static final String GlManagerState = "glManagerState";
        public static final String PlayerException = "playerException";
        public static final String PlayerViewLinkStream = "viewLinkState";
        public static final String PlayerViewOnSurface = "viewDisplayState";
        public static final String PlayerViewState = "viewState";
        public static final String VideoDecoderState = "decoderState";
    }

    public static YMFPlayerUsrBehaviorStat getInstance() {
        if (mInstance == null) {
            mInstance = new YMFPlayerUsrBehaviorStat();
        }
        return mInstance;
    }

    public void setYMFBehaviorEventListener(IYMFBehaviorEventListener iYMFBehaviorEventListener) {
        this.mBehaviorListener = iYMFBehaviorEventListener;
    }

    public void notifyVideoDecoderIdState(long j, int i, boolean z) {
        YMFLog.info(this, "[Decoder ]", "upload usrBehavior notifyVideoDecoderIdState, streamId:" + j + " decoderType:" + i + " state:" + z);
        if (this.mBehaviorListener != null) {
            this.mBehaviorListener.onBehaviorEvent(this.tag, UsrBehaviorStatInfoKey.VideoDecoderState, "decoderType:" + i + ",streamId:" + j + ",state:" + (z ? "1" : "0"), 1);
        }
    }

    public void notifyVideoPlayerViewState(int i, boolean z) {
        YMFLog.info(this, Constant.MEDIACODE_PLAYVIEW, "upload usrBehavior notifyVideoPlayerViewState, viewType:" + i + " state:" + z);
        if (this.mBehaviorListener != null) {
            this.mBehaviorListener.onBehaviorEvent(this.tag, "viewState", "viewType:" + i + ",state:" + (z ? "1" : "0"), 1);
        }
    }

    public void notifyGlManagerState(int i, boolean z) {
        YMFLog.info(this, "[Procedur]", "upload usrBehavior notifyGlManagerState, viewType:" + i + " state:" + z);
        if (this.mBehaviorListener != null) {
        }
    }

    public void notifyPlayerViewLinkStream(int i, long j, boolean z) {
        YMFLog.info(this, Constant.MEDIACODE_PLAYVIEW, "upload usrBehavior notifyPlayerViewLinkStream, viewType:" + i + " streamId" + j + " state:" + z);
        if (this.mBehaviorListener != null) {
            this.mBehaviorListener.onBehaviorEvent(this.tag, UsrBehaviorStatInfoKey.PlayerViewLinkStream, "viewType:" + i + ",streamId:" + j + ",state:" + (z ? "1" : "0"), 1);
        }
    }

    public void notifyPlayerViewOnSurface(int i, boolean z) {
        YMFLog.info(this, Constant.MEDIACODE_PLAYVIEW, "upload usrBehavior notifyPlayerViewOnSurface, viewType:" + i + " state:" + z);
        if (this.mBehaviorListener != null) {
            this.mBehaviorListener.onBehaviorEvent(this.tag, "viewDisplayState", "viewType:" + i + ",state:" + (z ? "1" : "0"), 1);
        }
    }

    public void notifyPlayerException(String str) {
        YMFLog.info(this, Constant.MEDIACODE_PLAYVIEW, "upload usrBehavior notifyPlayerException, exceptionType:" + str);
        if (this.mBehaviorListener != null) {
            this.mBehaviorListener.onBehaviorEvent(this.tag, UsrBehaviorStatInfoKey.PlayerException, str, 1);
        }
    }

    public void notifyFirstFrameDecode() {
        YMFLog.info(this, Constant.MEDIACODE_PLAYVIEW, "upload usrBehavior notifyFirstFrameDecode");
        if (this.mBehaviorListener != null) {
            this.mBehaviorListener.onBehaviorEvent(this.tag, UsrBehaviorStatInfoKey.FirstFrameDecode, "systemTime:" + System.currentTimeMillis(), 1);
        }
    }

    public void notifyFirstFrameRendered(int i) {
        YMFLog.info(this, Constant.MEDIACODE_PLAYVIEW, "upload usrBehavior notifyFirstFrameRendered, type:" + i);
        if (this.mBehaviorListener != null) {
            this.mBehaviorListener.onBehaviorEvent(this.tag, "firstFrameRendered", "type:" + i + ",systemTime:" + System.currentTimeMillis(), 1);
        }
    }
}
