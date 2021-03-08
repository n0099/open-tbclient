package com.yy.videoplayer;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.yy.videoplayer.decoder.VideoConstant;
import com.yy.videoplayer.view.YMFLayoutParams;
import com.yy.videoplayer.view.YMFPlayerSession;
/* loaded from: classes6.dex */
public final class YMFPlayerAPI {
    private static final String TAG = "[YMFPlayerAPI]";
    private YMFPlayerSession mPlayerSession;
    private Object syncLock = new Object();

    public static YMFPlayerAPI newInstance() {
        YMFPlayerAPI yMFPlayerAPI;
        synchronized (YMFPlayerAPI.class) {
            yMFPlayerAPI = new YMFPlayerAPI();
        }
        return yMFPlayerAPI;
    }

    public YMFPlayerAPI() {
        this.mPlayerSession = null;
        this.mPlayerSession = new YMFPlayerSession();
    }

    public void setUseTextureView(boolean z) {
        if (this.mPlayerSession != null) {
            synchronized (this.syncLock) {
                this.mPlayerSession.setUseTextureView(z);
            }
        }
    }

    public View createView(Context context) {
        View createView;
        if (this.mPlayerSession != null) {
            synchronized (this.syncLock) {
                createView = this.mPlayerSession.createView(context);
            }
            return createView;
        }
        return null;
    }

    @Deprecated
    public void destroyView(View view) {
        if (this.mPlayerSession != null && view != null) {
            synchronized (this.syncLock) {
                this.mPlayerSession.destroyView(view);
            }
        }
    }

    public int linkStream(View view, long j, int i) {
        int linkStream;
        if (this.mPlayerSession != null && view != null) {
            synchronized (this.syncLock) {
                linkStream = this.mPlayerSession.linkStream(view, j, i);
            }
            return linkStream;
        }
        return -1;
    }

    public int unLinkStream(View view, long j, int i) {
        int unLinkStream;
        if (this.mPlayerSession != null && view != null) {
            synchronized (this.syncLock) {
                unLinkStream = this.mPlayerSession.unLinkStream(view, j, i);
            }
            return unLinkStream;
        }
        return -1;
    }

    public int setViewLayout(View view, YMFLayoutParams yMFLayoutParams) {
        int viewLayout;
        if (this.mPlayerSession != null && view != null) {
            synchronized (this.syncLock) {
                viewLayout = this.mPlayerSession.setViewLayout(view, yMFLayoutParams);
            }
            return viewLayout;
        }
        return -1;
    }

    public void setScaleMode(View view, VideoConstant.ScaleMode scaleMode, int i) {
        if (this.mPlayerSession != null && view != null) {
            synchronized (this.syncLock) {
                this.mPlayerSession.setScaleMode(view, scaleMode, i);
            }
        }
    }

    public void setMirrorMode(View view, VideoConstant.MirrorMode mirrorMode, int i) {
        if (this.mPlayerSession != null && view != null) {
            synchronized (this.syncLock) {
                this.mPlayerSession.setMirrorMode(view, mirrorMode, i);
            }
        }
    }

    public Bitmap getVideoScreenshot(View view, int i) {
        Bitmap videoScreenshot;
        if (this.mPlayerSession != null && view != null) {
            synchronized (this.syncLock) {
                videoScreenshot = this.mPlayerSession.getVideoScreenshot(view, i);
            }
            return videoScreenshot;
        }
        return null;
    }

    public void setLastFrameRenderBlack(View view, boolean z) {
        if (this.mPlayerSession != null && view != null) {
            synchronized (this.syncLock) {
                this.mPlayerSession.setLastFrameRenderBlack(view, z);
            }
        }
    }

    public int switchDualVideoView(View view, long j, long j2, int i) {
        int switchDualVideoView;
        if (this.mPlayerSession != null && view != null) {
            synchronized (this.syncLock) {
                switchDualVideoView = this.mPlayerSession.switchDualVideoView(view, j, j2, i);
            }
            return switchDualVideoView;
        }
        return -1;
    }

    @Deprecated
    public void release() {
        if (this.mPlayerSession != null) {
            synchronized (this.syncLock) {
                this.mPlayerSession.release();
                this.mPlayerSession = null;
            }
        }
    }
}
