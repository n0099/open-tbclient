package com.google.android.exoplayer2.video;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.Choreographer;
import android.view.Display;
import android.view.WindowManager;
import com.baidu.live.tbadk.log.LogConfig;
import com.google.android.exoplayer2.util.v;
@TargetApi(16)
/* loaded from: classes6.dex */
public final class d {
    private final b mIN;
    private final a mIO;
    private long mIP;
    private long mIQ;
    private long mIR;
    private long mIS;
    private long mIT;
    private boolean mIU;
    private long mIV;
    private long mIW;
    private long mIX;
    private final WindowManager windowManager;

    public d() {
        this(null);
    }

    public d(@Nullable Context context) {
        this.windowManager = context == null ? null : (WindowManager) context.getSystemService("window");
        if (this.windowManager != null) {
            this.mIO = v.SDK_INT >= 17 ? gt(context) : null;
            this.mIN = b.dAf();
        } else {
            this.mIO = null;
            this.mIN = null;
        }
        this.mIP = -9223372036854775807L;
        this.mIQ = -9223372036854775807L;
    }

    public void enable() {
        this.mIU = false;
        if (this.windowManager != null) {
            this.mIN.dAg();
            if (this.mIO != null) {
                this.mIO.register();
            }
            dAe();
        }
    }

    public void disable() {
        if (this.windowManager != null) {
            if (this.mIO != null) {
                this.mIO.unregister();
            }
            this.mIN.dAh();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long Z(long j, long j2) {
        long j3;
        long j4;
        long j5 = j * 1000;
        if (this.mIU) {
            if (j != this.mIR) {
                this.mIX++;
                this.mIS = this.mIT;
            }
            if (this.mIX >= 6) {
                j4 = this.mIS + ((j5 - this.mIW) / this.mIX);
                if (aa(j4, j2)) {
                    this.mIU = false;
                    j3 = j2;
                    j4 = j5;
                } else {
                    j3 = (this.mIV + j4) - this.mIW;
                }
                if (!this.mIU) {
                    this.mIW = j5;
                    this.mIV = j2;
                    this.mIX = 0L;
                    this.mIU = true;
                }
                this.mIR = j;
                this.mIT = j4;
                if (this.mIN == null && this.mIP != -9223372036854775807L) {
                    long j6 = this.mIN.mJa;
                    return j6 != -9223372036854775807L ? j(j3, j6, this.mIP) - this.mIQ : j3;
                }
            } else if (aa(j5, j2)) {
                this.mIU = false;
            }
        }
        j3 = j2;
        j4 = j5;
        if (!this.mIU) {
        }
        this.mIR = j;
        this.mIT = j4;
        return this.mIN == null ? j3 : j3;
    }

    @TargetApi(17)
    private a gt(Context context) {
        DisplayManager displayManager = (DisplayManager) context.getSystemService(LogConfig.KEY_DISPLAY);
        if (displayManager == null) {
            return null;
        }
        return new a(displayManager);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dAe() {
        Display defaultDisplay = this.windowManager.getDefaultDisplay();
        if (defaultDisplay != null) {
            this.mIP = (long) (1.0E9d / defaultDisplay.getRefreshRate());
            this.mIQ = (this.mIP * 80) / 100;
        }
    }

    private boolean aa(long j, long j2) {
        return Math.abs((j2 - this.mIV) - (j - this.mIW)) > 20000000;
    }

    private static long j(long j, long j2, long j3) {
        long j4;
        long j5 = (((j - j2) / j3) * j3) + j2;
        if (j <= j5) {
            j4 = j5 - j3;
        } else {
            j4 = j5;
            j5 += j3;
        }
        return j5 - j < j - j4 ? j5 : j4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(17)
    /* loaded from: classes6.dex */
    public final class a implements DisplayManager.DisplayListener {
        private final DisplayManager mIY;

        public a(DisplayManager displayManager) {
            this.mIY = displayManager;
        }

        public void register() {
            this.mIY.registerDisplayListener(this, null);
        }

        public void unregister() {
            this.mIY.unregisterDisplayListener(this);
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int i) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int i) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int i) {
            if (i == 0) {
                d.this.dAe();
            }
        }
    }

    /* loaded from: classes6.dex */
    private static final class b implements Handler.Callback, Choreographer.FrameCallback {
        private static final b mJb = new b();
        private final Handler handler;
        public volatile long mJa = -9223372036854775807L;
        private final HandlerThread mJc = new HandlerThread("ChoreographerOwner:Handler");
        private Choreographer mJd;
        private int mJe;

        public static b dAf() {
            return mJb;
        }

        private b() {
            this.mJc.start();
            this.handler = new Handler(this.mJc.getLooper(), this);
            this.handler.sendEmptyMessage(0);
        }

        public void dAg() {
            this.handler.sendEmptyMessage(1);
        }

        public void dAh() {
            this.handler.sendEmptyMessage(2);
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            this.mJa = j;
            this.mJd.postFrameCallbackDelayed(this, 500L);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    dAi();
                    return true;
                case 1:
                    dAj();
                    return true;
                case 2:
                    dAk();
                    return true;
                default:
                    return false;
            }
        }

        private void dAi() {
            this.mJd = Choreographer.getInstance();
        }

        private void dAj() {
            this.mJe++;
            if (this.mJe == 1) {
                this.mJd.postFrameCallback(this);
            }
        }

        private void dAk() {
            this.mJe--;
            if (this.mJe == 0) {
                this.mJd.removeFrameCallback(this);
                this.mJa = -9223372036854775807L;
            }
        }
    }
}
