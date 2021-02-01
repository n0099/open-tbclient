package com.yy.videoplayer.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.yy.videoplayer.decoder.VideoConstant;
import com.yy.videoplayer.utils.YMFLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes4.dex */
public class YMFPlayerSession {
    private ConcurrentHashMap<View, YMFPlayerController> mPlayerViewControllerMap = new ConcurrentHashMap<>();
    private Context mContext = null;
    private boolean mUseTextureView = false;

    public void setUseTextureView(boolean z) {
        YMFLog.info(this, "[Api     ]", "setUseTextureView," + z);
        this.mUseTextureView = z;
    }

    public View createView(Context context) {
        this.mContext = context;
        YMFPlayerController yMFPlayerController = new YMFPlayerController(this.mContext);
        yMFPlayerController.setUseTextureView(this.mUseTextureView);
        View createVideoView = yMFPlayerController.createVideoView();
        this.mPlayerViewControllerMap.put(createVideoView, yMFPlayerController);
        YMFLog.info(this, "[Render  ]", "createView," + createVideoView);
        return createVideoView;
    }

    @Deprecated
    public void destroyView(View view) {
        if (this.mPlayerViewControllerMap.get(view) != null) {
            YMFLog.info(this, "[Render  ]", "destroyView," + view);
            this.mPlayerViewControllerMap.get(view).destroyVideoView();
            this.mPlayerViewControllerMap.get(view).release();
            this.mPlayerViewControllerMap.remove(view);
        }
    }

    public int linkStream(View view, long j, int i) {
        if (this.mPlayerViewControllerMap.get(view) != null) {
            if (i >= 0) {
                return this.mPlayerViewControllerMap.get(view).linkStream(j, i);
            }
            return this.mPlayerViewControllerMap.get(view).linkStream(j);
        }
        return -1;
    }

    public int unLinkStream(View view, long j, int i) {
        if (this.mPlayerViewControllerMap.get(view) != null) {
            if (i >= 0) {
                return this.mPlayerViewControllerMap.get(view).unLinkStream(j, i);
            }
            return this.mPlayerViewControllerMap.get(view).unLinkStream(j);
        }
        return -2;
    }

    public int setViewLayout(View view, YMFLayoutParams yMFLayoutParams) {
        if (this.mPlayerViewControllerMap.get(view) != null) {
            YMFLog.info(this, "[Render  ]", "setViewLayout," + view);
            return this.mPlayerViewControllerMap.get(view).setViewLayout(yMFLayoutParams);
        }
        return -2;
    }

    public int setScaleMode(View view, VideoConstant.ScaleMode scaleMode, int i) {
        if (this.mPlayerViewControllerMap.get(view) != null) {
            if (i < 0) {
                return this.mPlayerViewControllerMap.get(view).setScaleMode(scaleMode);
            }
            return this.mPlayerViewControllerMap.get(view).setScaleMode(scaleMode, i);
        }
        return -2;
    }

    public int setMirrorMode(View view, VideoConstant.MirrorMode mirrorMode, int i) {
        if (this.mPlayerViewControllerMap.get(view) != null) {
            if (i < 0) {
                return this.mPlayerViewControllerMap.get(view).setMirrorMode(mirrorMode, 0);
            }
            return this.mPlayerViewControllerMap.get(view).setMirrorMode(mirrorMode, i);
        }
        return -2;
    }

    public Bitmap getVideoScreenshot(View view, int i) {
        if (this.mPlayerViewControllerMap.get(view) != null) {
            if (i < 0) {
                return this.mPlayerViewControllerMap.get(view).getVideoScreenshot();
            }
            return this.mPlayerViewControllerMap.get(view).getVideoScreenshotExt(i);
        }
        return null;
    }

    public int switchDualVideoView(View view, long j, long j2, int i) {
        if (this.mPlayerViewControllerMap.get(view) != null) {
            if (i >= 0) {
                return this.mPlayerViewControllerMap.get(view).switchDualVideoView(j, j2, i);
            }
            return this.mPlayerViewControllerMap.get(view).switchDualVideoView(j, j2, 0);
        }
        return -1;
    }

    public int setLastFrameRenderBlack(View view, boolean z) {
        if (this.mPlayerViewControllerMap.get(view) != null) {
            this.mPlayerViewControllerMap.get(view).setLastFrameRenderBlack(z);
            return 0;
        }
        return -2;
    }

    public void release() {
        if (this.mPlayerViewControllerMap != null) {
            for (Map.Entry<View, YMFPlayerController> entry : this.mPlayerViewControllerMap.entrySet()) {
                YMFPlayerController value = entry.getValue();
                if (value != null) {
                    value.release();
                }
            }
            this.mPlayerViewControllerMap.clear();
        }
    }
}
