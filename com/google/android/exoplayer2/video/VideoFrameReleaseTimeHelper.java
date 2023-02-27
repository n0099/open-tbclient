package com.google.android.exoplayer2.video;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
import android.view.Display;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.util.Util;
@TargetApi(16)
/* loaded from: classes7.dex */
public final class VideoFrameReleaseTimeHelper {
    public static final long CHOREOGRAPHER_SAMPLE_DELAY_MILLIS = 500;
    public static final long MAX_ALLOWED_DRIFT_NS = 20000000;
    public static final int MIN_FRAMES_FOR_ADJUSTMENT = 6;
    public static final long VSYNC_OFFSET_PERCENTAGE = 80;
    public long adjustedLastFrameTimeNs;
    public final DefaultDisplayListener displayListener;
    public long frameCount;
    public boolean haveSync;
    public long lastFramePresentationTimeUs;
    public long pendingAdjustedFrameTimeNs;
    public long syncFramePresentationTimeNs;
    public long syncUnadjustedReleaseTimeNs;
    public long vsyncDurationNs;
    public long vsyncOffsetNs;
    public final VSyncSampler vsyncSampler;
    public final WindowManager windowManager;

    @TargetApi(17)
    /* loaded from: classes7.dex */
    public final class DefaultDisplayListener implements DisplayManager.DisplayListener {
        public final DisplayManager displayManager;

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int i) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int i) {
        }

        public DefaultDisplayListener(DisplayManager displayManager) {
            this.displayManager = displayManager;
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int i) {
            if (i != 0) {
                return;
            }
            VideoFrameReleaseTimeHelper.this.updateDefaultDisplayRefreshRateParams();
        }

        public void register() {
            this.displayManager.registerDisplayListener(this, null);
        }

        public void unregister() {
            this.displayManager.unregisterDisplayListener(this);
        }
    }

    /* loaded from: classes7.dex */
    public static final class VSyncSampler implements Choreographer.FrameCallback, Handler.Callback {
        public static final int CREATE_CHOREOGRAPHER = 0;
        public static final VSyncSampler INSTANCE = new VSyncSampler();
        public static final int MSG_ADD_OBSERVER = 1;
        public static final int MSG_REMOVE_OBSERVER = 2;
        public Choreographer choreographer;
        public final HandlerThread choreographerOwnerThread;
        public final Handler handler;
        public int observerCount;
        public volatile long sampledVsyncTimeNs = C.TIME_UNSET;

        public VSyncSampler() {
            HandlerThread handlerThread = new HandlerThread("ChoreographerOwner:Handler");
            this.choreographerOwnerThread = handlerThread;
            handlerThread.start();
            Handler handler = new Handler(this.choreographerOwnerThread.getLooper(), this);
            this.handler = handler;
            handler.sendEmptyMessage(0);
        }

        private void addObserverInternal() {
            int i = this.observerCount + 1;
            this.observerCount = i;
            if (i == 1) {
                this.choreographer.postFrameCallback(this);
            }
        }

        private void createChoreographerInstanceInternal() {
            this.choreographer = Choreographer.getInstance();
        }

        public static VSyncSampler getInstance() {
            return INSTANCE;
        }

        private void removeObserverInternal() {
            int i = this.observerCount - 1;
            this.observerCount = i;
            if (i == 0) {
                this.choreographer.removeFrameCallback(this);
                this.sampledVsyncTimeNs = C.TIME_UNSET;
            }
        }

        public void addObserver() {
            this.handler.sendEmptyMessage(1);
        }

        public void removeObserver() {
            this.handler.sendEmptyMessage(2);
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            this.sampledVsyncTimeNs = j;
            this.choreographer.postFrameCallbackDelayed(this, 500L);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        return false;
                    }
                    removeObserverInternal();
                    return true;
                }
                addObserverInternal();
                return true;
            }
            createChoreographerInstanceInternal();
            return true;
        }
    }

    public VideoFrameReleaseTimeHelper() {
        this(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDefaultDisplayRefreshRateParams() {
        Display defaultDisplay = this.windowManager.getDefaultDisplay();
        if (defaultDisplay != null) {
            long refreshRate = (long) (1.0E9d / defaultDisplay.getRefreshRate());
            this.vsyncDurationNs = refreshRate;
            this.vsyncOffsetNs = (refreshRate * 80) / 100;
        }
    }

    public void disable() {
        if (this.windowManager != null) {
            DefaultDisplayListener defaultDisplayListener = this.displayListener;
            if (defaultDisplayListener != null) {
                defaultDisplayListener.unregister();
            }
            this.vsyncSampler.removeObserver();
        }
    }

    public void enable() {
        this.haveSync = false;
        if (this.windowManager != null) {
            this.vsyncSampler.addObserver();
            DefaultDisplayListener defaultDisplayListener = this.displayListener;
            if (defaultDisplayListener != null) {
                defaultDisplayListener.register();
            }
            updateDefaultDisplayRefreshRateParams();
        }
    }

    public VideoFrameReleaseTimeHelper(@Nullable Context context) {
        WindowManager windowManager;
        if (context == null) {
            windowManager = null;
        } else {
            windowManager = (WindowManager) context.getSystemService("window");
        }
        this.windowManager = windowManager;
        if (windowManager != null) {
            this.displayListener = Util.SDK_INT >= 17 ? maybeBuildDefaultDisplayListenerV17(context) : null;
            this.vsyncSampler = VSyncSampler.getInstance();
        } else {
            this.displayListener = null;
            this.vsyncSampler = null;
        }
        this.vsyncDurationNs = C.TIME_UNSET;
        this.vsyncOffsetNs = C.TIME_UNSET;
    }

    @TargetApi(17)
    private DefaultDisplayListener maybeBuildDefaultDisplayListenerV17(Context context) {
        DisplayManager displayManager = (DisplayManager) context.getSystemService(CriusAttrConstants.DISPLAY);
        if (displayManager == null) {
            return null;
        }
        return new DefaultDisplayListener(displayManager);
    }

    public static long closestVsync(long j, long j2, long j3) {
        long j4;
        long j5 = j2 + (((j - j2) / j3) * j3);
        if (j <= j5) {
            j4 = j5 - j3;
        } else {
            j5 = j3 + j5;
            j4 = j5;
        }
        if (j5 - j >= j - j4) {
            return j4;
        }
        return j5;
    }

    private boolean isDriftTooLarge(long j, long j2) {
        if (Math.abs((j2 - this.syncUnadjustedReleaseTimeNs) - (j - this.syncFramePresentationTimeNs)) > MAX_ALLOWED_DRIFT_NS) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long adjustReleaseTime(long j, long j2) {
        long j3;
        long j4;
        VSyncSampler vSyncSampler;
        long j5 = 1000 * j;
        if (this.haveSync) {
            if (j != this.lastFramePresentationTimeUs) {
                this.frameCount++;
                this.adjustedLastFrameTimeNs = this.pendingAdjustedFrameTimeNs;
            }
            long j6 = this.frameCount;
            if (j6 >= 6) {
                j4 = this.adjustedLastFrameTimeNs + ((j5 - this.syncFramePresentationTimeNs) / j6);
                if (isDriftTooLarge(j4, j2)) {
                    this.haveSync = false;
                } else {
                    j3 = (this.syncUnadjustedReleaseTimeNs + j4) - this.syncFramePresentationTimeNs;
                    if (!this.haveSync) {
                        this.syncFramePresentationTimeNs = j5;
                        this.syncUnadjustedReleaseTimeNs = j2;
                        this.frameCount = 0L;
                        this.haveSync = true;
                    }
                    this.lastFramePresentationTimeUs = j;
                    this.pendingAdjustedFrameTimeNs = j4;
                    vSyncSampler = this.vsyncSampler;
                    if (vSyncSampler == null && this.vsyncDurationNs != C.TIME_UNSET) {
                        long j7 = vSyncSampler.sampledVsyncTimeNs;
                        if (j7 == C.TIME_UNSET) {
                            return j3;
                        }
                        return closestVsync(j3, j7, this.vsyncDurationNs) - this.vsyncOffsetNs;
                    }
                    return j3;
                }
            } else if (isDriftTooLarge(j5, j2)) {
                this.haveSync = false;
            }
        }
        j3 = j2;
        j4 = j5;
        if (!this.haveSync) {
        }
        this.lastFramePresentationTimeUs = j;
        this.pendingAdjustedFrameTimeNs = j4;
        vSyncSampler = this.vsyncSampler;
        if (vSyncSampler == null) {
        }
        return j3;
    }
}
