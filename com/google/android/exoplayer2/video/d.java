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
/* loaded from: classes5.dex */
public final class d {
    private final b mIc;
    private final a mIe;
    private long mIf;
    private long mIg;
    private long mIh;
    private long mIi;
    private long mIj;
    private boolean mIk;
    private long mIl;
    private long mIm;
    private long mIn;
    private final WindowManager windowManager;

    public d() {
        this(null);
    }

    public d(@Nullable Context context) {
        this.windowManager = context == null ? null : (WindowManager) context.getSystemService("window");
        if (this.windowManager != null) {
            this.mIe = v.SDK_INT >= 17 ? gu(context) : null;
            this.mIc = b.dyT();
        } else {
            this.mIe = null;
            this.mIc = null;
        }
        this.mIf = -9223372036854775807L;
        this.mIg = -9223372036854775807L;
    }

    public void enable() {
        this.mIk = false;
        if (this.windowManager != null) {
            this.mIc.dyU();
            if (this.mIe != null) {
                this.mIe.register();
            }
            dyS();
        }
    }

    public void disable() {
        if (this.windowManager != null) {
            if (this.mIe != null) {
                this.mIe.unregister();
            }
            this.mIc.dyV();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long aa(long j, long j2) {
        long j3;
        long j4;
        long j5 = j * 1000;
        if (this.mIk) {
            if (j != this.mIh) {
                this.mIn++;
                this.mIi = this.mIj;
            }
            if (this.mIn >= 6) {
                j4 = this.mIi + ((j5 - this.mIm) / this.mIn);
                if (ab(j4, j2)) {
                    this.mIk = false;
                    j3 = j2;
                    j4 = j5;
                } else {
                    j3 = (this.mIl + j4) - this.mIm;
                }
                if (!this.mIk) {
                    this.mIm = j5;
                    this.mIl = j2;
                    this.mIn = 0L;
                    this.mIk = true;
                }
                this.mIh = j;
                this.mIj = j4;
                if (this.mIc == null && this.mIf != -9223372036854775807L) {
                    long j6 = this.mIc.mIr;
                    return j6 != -9223372036854775807L ? i(j3, j6, this.mIf) - this.mIg : j3;
                }
            } else if (ab(j5, j2)) {
                this.mIk = false;
            }
        }
        j3 = j2;
        j4 = j5;
        if (!this.mIk) {
        }
        this.mIh = j;
        this.mIj = j4;
        return this.mIc == null ? j3 : j3;
    }

    @TargetApi(17)
    private a gu(Context context) {
        DisplayManager displayManager = (DisplayManager) context.getSystemService(LogConfig.KEY_DISPLAY);
        if (displayManager == null) {
            return null;
        }
        return new a(displayManager);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dyS() {
        Display defaultDisplay = this.windowManager.getDefaultDisplay();
        if (defaultDisplay != null) {
            this.mIf = (long) (1.0E9d / defaultDisplay.getRefreshRate());
            this.mIg = (this.mIf * 80) / 100;
        }
    }

    private boolean ab(long j, long j2) {
        return Math.abs((j2 - this.mIl) - (j - this.mIm)) > 20000000;
    }

    private static long i(long j, long j2, long j3) {
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
    /* loaded from: classes5.dex */
    public final class a implements DisplayManager.DisplayListener {
        private final DisplayManager mIo;

        public a(DisplayManager displayManager) {
            this.mIo = displayManager;
        }

        public void register() {
            this.mIo.registerDisplayListener(this, null);
        }

        public void unregister() {
            this.mIo.unregisterDisplayListener(this);
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
                d.this.dyS();
            }
        }
    }

    /* loaded from: classes5.dex */
    private static final class b implements Handler.Callback, Choreographer.FrameCallback {
        private static final b mIt = new b();
        private final Handler handler;
        public volatile long mIr = -9223372036854775807L;
        private final HandlerThread mIu = new HandlerThread("ChoreographerOwner:Handler");
        private Choreographer mIv;
        private int mIw;

        public static b dyT() {
            return mIt;
        }

        private b() {
            this.mIu.start();
            this.handler = new Handler(this.mIu.getLooper(), this);
            this.handler.sendEmptyMessage(0);
        }

        public void dyU() {
            this.handler.sendEmptyMessage(1);
        }

        public void dyV() {
            this.handler.sendEmptyMessage(2);
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            this.mIr = j;
            this.mIv.postFrameCallbackDelayed(this, 500L);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    dyW();
                    return true;
                case 1:
                    dyX();
                    return true;
                case 2:
                    dyY();
                    return true;
                default:
                    return false;
            }
        }

        private void dyW() {
            this.mIv = Choreographer.getInstance();
        }

        private void dyX() {
            this.mIw++;
            if (this.mIw == 1) {
                this.mIv.postFrameCallback(this);
            }
        }

        private void dyY() {
            this.mIw--;
            if (this.mIw == 0) {
                this.mIv.removeFrameCallback(this);
                this.mIr = -9223372036854775807L;
            }
        }
    }
}
