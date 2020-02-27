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
    private final b mIL;
    private final a mIM;
    private long mIN;
    private long mIO;
    private long mIP;
    private long mIQ;
    private long mIR;
    private boolean mIS;
    private long mIT;
    private long mIU;
    private long mIV;
    private final WindowManager windowManager;

    public d() {
        this(null);
    }

    public d(@Nullable Context context) {
        this.windowManager = context == null ? null : (WindowManager) context.getSystemService("window");
        if (this.windowManager != null) {
            this.mIM = v.SDK_INT >= 17 ? gt(context) : null;
            this.mIL = b.dAd();
        } else {
            this.mIM = null;
            this.mIL = null;
        }
        this.mIN = -9223372036854775807L;
        this.mIO = -9223372036854775807L;
    }

    public void enable() {
        this.mIS = false;
        if (this.windowManager != null) {
            this.mIL.dAe();
            if (this.mIM != null) {
                this.mIM.register();
            }
            dAc();
        }
    }

    public void disable() {
        if (this.windowManager != null) {
            if (this.mIM != null) {
                this.mIM.unregister();
            }
            this.mIL.dAf();
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
        if (this.mIS) {
            if (j != this.mIP) {
                this.mIV++;
                this.mIQ = this.mIR;
            }
            if (this.mIV >= 6) {
                j4 = this.mIQ + ((j5 - this.mIU) / this.mIV);
                if (aa(j4, j2)) {
                    this.mIS = false;
                    j3 = j2;
                    j4 = j5;
                } else {
                    j3 = (this.mIT + j4) - this.mIU;
                }
                if (!this.mIS) {
                    this.mIU = j5;
                    this.mIT = j2;
                    this.mIV = 0L;
                    this.mIS = true;
                }
                this.mIP = j;
                this.mIR = j4;
                if (this.mIL == null && this.mIN != -9223372036854775807L) {
                    long j6 = this.mIL.mIY;
                    return j6 != -9223372036854775807L ? j(j3, j6, this.mIN) - this.mIO : j3;
                }
            } else if (aa(j5, j2)) {
                this.mIS = false;
            }
        }
        j3 = j2;
        j4 = j5;
        if (!this.mIS) {
        }
        this.mIP = j;
        this.mIR = j4;
        return this.mIL == null ? j3 : j3;
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
    public void dAc() {
        Display defaultDisplay = this.windowManager.getDefaultDisplay();
        if (defaultDisplay != null) {
            this.mIN = (long) (1.0E9d / defaultDisplay.getRefreshRate());
            this.mIO = (this.mIN * 80) / 100;
        }
    }

    private boolean aa(long j, long j2) {
        return Math.abs((j2 - this.mIT) - (j - this.mIU)) > 20000000;
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
        private final DisplayManager mIW;

        public a(DisplayManager displayManager) {
            this.mIW = displayManager;
        }

        public void register() {
            this.mIW.registerDisplayListener(this, null);
        }

        public void unregister() {
            this.mIW.unregisterDisplayListener(this);
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
                d.this.dAc();
            }
        }
    }

    /* loaded from: classes6.dex */
    private static final class b implements Handler.Callback, Choreographer.FrameCallback {
        private static final b mIZ = new b();
        private final Handler handler;
        public volatile long mIY = -9223372036854775807L;
        private final HandlerThread mJa = new HandlerThread("ChoreographerOwner:Handler");
        private Choreographer mJb;
        private int mJc;

        public static b dAd() {
            return mIZ;
        }

        private b() {
            this.mJa.start();
            this.handler = new Handler(this.mJa.getLooper(), this);
            this.handler.sendEmptyMessage(0);
        }

        public void dAe() {
            this.handler.sendEmptyMessage(1);
        }

        public void dAf() {
            this.handler.sendEmptyMessage(2);
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            this.mIY = j;
            this.mJb.postFrameCallbackDelayed(this, 500L);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    dAg();
                    return true;
                case 1:
                    dAh();
                    return true;
                case 2:
                    dAi();
                    return true;
                default:
                    return false;
            }
        }

        private void dAg() {
            this.mJb = Choreographer.getInstance();
        }

        private void dAh() {
            this.mJc++;
            if (this.mJc == 1) {
                this.mJb.postFrameCallback(this);
            }
        }

        private void dAi() {
            this.mJc--;
            if (this.mJc == 0) {
                this.mJb.removeFrameCallback(this);
                this.mIY = -9223372036854775807L;
            }
        }
    }
}
