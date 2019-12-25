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
/* loaded from: classes4.dex */
public final class d {
    private final b mEj;
    private final a mEk;
    private long mEl;
    private long mEm;
    private long mEn;
    private long mEo;
    private long mEp;
    private boolean mEq;
    private long mEr;
    private long mEs;
    private long mEt;
    private final WindowManager windowManager;

    public d() {
        this(null);
    }

    public d(@Nullable Context context) {
        this.windowManager = context == null ? null : (WindowManager) context.getSystemService("window");
        if (this.windowManager != null) {
            this.mEk = v.SDK_INT >= 17 ? gt(context) : null;
            this.mEj = b.dxH();
        } else {
            this.mEk = null;
            this.mEj = null;
        }
        this.mEl = -9223372036854775807L;
        this.mEm = -9223372036854775807L;
    }

    public void enable() {
        this.mEq = false;
        if (this.windowManager != null) {
            this.mEj.dxI();
            if (this.mEk != null) {
                this.mEk.register();
            }
            dxG();
        }
    }

    public void disable() {
        if (this.windowManager != null) {
            if (this.mEk != null) {
                this.mEk.unregister();
            }
            this.mEj.dxJ();
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
        if (this.mEq) {
            if (j != this.mEn) {
                this.mEt++;
                this.mEo = this.mEp;
            }
            if (this.mEt >= 6) {
                j4 = this.mEo + ((j5 - this.mEs) / this.mEt);
                if (ab(j4, j2)) {
                    this.mEq = false;
                    j3 = j2;
                    j4 = j5;
                } else {
                    j3 = (this.mEr + j4) - this.mEs;
                }
                if (!this.mEq) {
                    this.mEs = j5;
                    this.mEr = j2;
                    this.mEt = 0L;
                    this.mEq = true;
                }
                this.mEn = j;
                this.mEp = j4;
                if (this.mEj == null && this.mEl != -9223372036854775807L) {
                    long j6 = this.mEj.mEw;
                    return j6 != -9223372036854775807L ? i(j3, j6, this.mEl) - this.mEm : j3;
                }
            } else if (ab(j5, j2)) {
                this.mEq = false;
            }
        }
        j3 = j2;
        j4 = j5;
        if (!this.mEq) {
        }
        this.mEn = j;
        this.mEp = j4;
        return this.mEj == null ? j3 : j3;
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
    public void dxG() {
        Display defaultDisplay = this.windowManager.getDefaultDisplay();
        if (defaultDisplay != null) {
            this.mEl = (long) (1.0E9d / defaultDisplay.getRefreshRate());
            this.mEm = (this.mEl * 80) / 100;
        }
    }

    private boolean ab(long j, long j2) {
        return Math.abs((j2 - this.mEr) - (j - this.mEs)) > 20000000;
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
    /* loaded from: classes4.dex */
    public final class a implements DisplayManager.DisplayListener {
        private final DisplayManager mEu;

        public a(DisplayManager displayManager) {
            this.mEu = displayManager;
        }

        public void register() {
            this.mEu.registerDisplayListener(this, null);
        }

        public void unregister() {
            this.mEu.unregisterDisplayListener(this);
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
                d.this.dxG();
            }
        }
    }

    /* loaded from: classes4.dex */
    private static final class b implements Handler.Callback, Choreographer.FrameCallback {
        private static final b mEx = new b();
        private final Handler handler;
        private int mEA;
        public volatile long mEw = -9223372036854775807L;
        private final HandlerThread mEy = new HandlerThread("ChoreographerOwner:Handler");
        private Choreographer mEz;

        public static b dxH() {
            return mEx;
        }

        private b() {
            this.mEy.start();
            this.handler = new Handler(this.mEy.getLooper(), this);
            this.handler.sendEmptyMessage(0);
        }

        public void dxI() {
            this.handler.sendEmptyMessage(1);
        }

        public void dxJ() {
            this.handler.sendEmptyMessage(2);
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            this.mEw = j;
            this.mEz.postFrameCallbackDelayed(this, 500L);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    dxK();
                    return true;
                case 1:
                    dxL();
                    return true;
                case 2:
                    dxM();
                    return true;
                default:
                    return false;
            }
        }

        private void dxK() {
            this.mEz = Choreographer.getInstance();
        }

        private void dxL() {
            this.mEA++;
            if (this.mEA == 1) {
                this.mEz.postFrameCallback(this);
            }
        }

        private void dxM() {
            this.mEA--;
            if (this.mEA == 0) {
                this.mEz.removeFrameCallback(this);
                this.mEw = -9223372036854775807L;
            }
        }
    }
}
