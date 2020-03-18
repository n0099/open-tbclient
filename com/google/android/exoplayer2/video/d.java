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
    private final b mKE;
    private final a mKF;
    private long mKG;
    private long mKH;
    private long mKI;
    private long mKJ;
    private long mKK;
    private boolean mKL;
    private long mKM;
    private long mKN;
    private long mKO;
    private final WindowManager windowManager;

    public d() {
        this(null);
    }

    public d(@Nullable Context context) {
        this.windowManager = context == null ? null : (WindowManager) context.getSystemService("window");
        if (this.windowManager != null) {
            this.mKF = v.SDK_INT >= 17 ? gs(context) : null;
            this.mKE = b.dAD();
        } else {
            this.mKF = null;
            this.mKE = null;
        }
        this.mKG = -9223372036854775807L;
        this.mKH = -9223372036854775807L;
    }

    public void enable() {
        this.mKL = false;
        if (this.windowManager != null) {
            this.mKE.dAE();
            if (this.mKF != null) {
                this.mKF.register();
            }
            dAC();
        }
    }

    public void disable() {
        if (this.windowManager != null) {
            if (this.mKF != null) {
                this.mKF.unregister();
            }
            this.mKE.dAF();
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
        if (this.mKL) {
            if (j != this.mKI) {
                this.mKO++;
                this.mKJ = this.mKK;
            }
            if (this.mKO >= 6) {
                j4 = this.mKJ + ((j5 - this.mKN) / this.mKO);
                if (aa(j4, j2)) {
                    this.mKL = false;
                    j3 = j2;
                    j4 = j5;
                } else {
                    j3 = (this.mKM + j4) - this.mKN;
                }
                if (!this.mKL) {
                    this.mKN = j5;
                    this.mKM = j2;
                    this.mKO = 0L;
                    this.mKL = true;
                }
                this.mKI = j;
                this.mKK = j4;
                if (this.mKE == null && this.mKG != -9223372036854775807L) {
                    long j6 = this.mKE.mKR;
                    return j6 != -9223372036854775807L ? j(j3, j6, this.mKG) - this.mKH : j3;
                }
            } else if (aa(j5, j2)) {
                this.mKL = false;
            }
        }
        j3 = j2;
        j4 = j5;
        if (!this.mKL) {
        }
        this.mKI = j;
        this.mKK = j4;
        return this.mKE == null ? j3 : j3;
    }

    @TargetApi(17)
    private a gs(Context context) {
        DisplayManager displayManager = (DisplayManager) context.getSystemService(LogConfig.KEY_DISPLAY);
        if (displayManager == null) {
            return null;
        }
        return new a(displayManager);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dAC() {
        Display defaultDisplay = this.windowManager.getDefaultDisplay();
        if (defaultDisplay != null) {
            this.mKG = (long) (1.0E9d / defaultDisplay.getRefreshRate());
            this.mKH = (this.mKG * 80) / 100;
        }
    }

    private boolean aa(long j, long j2) {
        return Math.abs((j2 - this.mKM) - (j - this.mKN)) > 20000000;
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
        private final DisplayManager mKP;

        public a(DisplayManager displayManager) {
            this.mKP = displayManager;
        }

        public void register() {
            this.mKP.registerDisplayListener(this, null);
        }

        public void unregister() {
            this.mKP.unregisterDisplayListener(this);
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
                d.this.dAC();
            }
        }
    }

    /* loaded from: classes6.dex */
    private static final class b implements Handler.Callback, Choreographer.FrameCallback {
        private static final b mKS = new b();
        private final Handler handler;
        public volatile long mKR = -9223372036854775807L;
        private final HandlerThread mKT = new HandlerThread("ChoreographerOwner:Handler");
        private Choreographer mKU;
        private int mKV;

        public static b dAD() {
            return mKS;
        }

        private b() {
            this.mKT.start();
            this.handler = new Handler(this.mKT.getLooper(), this);
            this.handler.sendEmptyMessage(0);
        }

        public void dAE() {
            this.handler.sendEmptyMessage(1);
        }

        public void dAF() {
            this.handler.sendEmptyMessage(2);
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            this.mKR = j;
            this.mKU.postFrameCallbackDelayed(this, 500L);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    dAG();
                    return true;
                case 1:
                    dAH();
                    return true;
                case 2:
                    dAI();
                    return true;
                default:
                    return false;
            }
        }

        private void dAG() {
            this.mKU = Choreographer.getInstance();
        }

        private void dAH() {
            this.mKV++;
            if (this.mKV == 1) {
                this.mKU.postFrameCallback(this);
            }
        }

        private void dAI() {
            this.mKV--;
            if (this.mKV == 0) {
                this.mKU.removeFrameCallback(this);
                this.mKR = -9223372036854775807L;
            }
        }
    }
}
