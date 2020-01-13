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
    private final b mHX;
    private final a mHY;
    private long mHZ;
    private long mIa;
    private long mIb;
    private long mIc;
    private long mIe;
    private boolean mIf;
    private long mIg;
    private long mIh;
    private long mIi;
    private final WindowManager windowManager;

    public d() {
        this(null);
    }

    public d(@Nullable Context context) {
        this.windowManager = context == null ? null : (WindowManager) context.getSystemService("window");
        if (this.windowManager != null) {
            this.mHY = v.SDK_INT >= 17 ? gu(context) : null;
            this.mHX = b.dyR();
        } else {
            this.mHY = null;
            this.mHX = null;
        }
        this.mHZ = -9223372036854775807L;
        this.mIa = -9223372036854775807L;
    }

    public void enable() {
        this.mIf = false;
        if (this.windowManager != null) {
            this.mHX.dyS();
            if (this.mHY != null) {
                this.mHY.register();
            }
            dyQ();
        }
    }

    public void disable() {
        if (this.windowManager != null) {
            if (this.mHY != null) {
                this.mHY.unregister();
            }
            this.mHX.dyT();
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
        if (this.mIf) {
            if (j != this.mIb) {
                this.mIi++;
                this.mIc = this.mIe;
            }
            if (this.mIi >= 6) {
                j4 = this.mIc + ((j5 - this.mIh) / this.mIi);
                if (ab(j4, j2)) {
                    this.mIf = false;
                    j3 = j2;
                    j4 = j5;
                } else {
                    j3 = (this.mIg + j4) - this.mIh;
                }
                if (!this.mIf) {
                    this.mIh = j5;
                    this.mIg = j2;
                    this.mIi = 0L;
                    this.mIf = true;
                }
                this.mIb = j;
                this.mIe = j4;
                if (this.mHX == null && this.mHZ != -9223372036854775807L) {
                    long j6 = this.mHX.mIl;
                    return j6 != -9223372036854775807L ? i(j3, j6, this.mHZ) - this.mIa : j3;
                }
            } else if (ab(j5, j2)) {
                this.mIf = false;
            }
        }
        j3 = j2;
        j4 = j5;
        if (!this.mIf) {
        }
        this.mIb = j;
        this.mIe = j4;
        return this.mHX == null ? j3 : j3;
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
    public void dyQ() {
        Display defaultDisplay = this.windowManager.getDefaultDisplay();
        if (defaultDisplay != null) {
            this.mHZ = (long) (1.0E9d / defaultDisplay.getRefreshRate());
            this.mIa = (this.mHZ * 80) / 100;
        }
    }

    private boolean ab(long j, long j2) {
        return Math.abs((j2 - this.mIg) - (j - this.mIh)) > 20000000;
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
        private final DisplayManager mIj;

        public a(DisplayManager displayManager) {
            this.mIj = displayManager;
        }

        public void register() {
            this.mIj.registerDisplayListener(this, null);
        }

        public void unregister() {
            this.mIj.unregisterDisplayListener(this);
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
                d.this.dyQ();
            }
        }
    }

    /* loaded from: classes5.dex */
    private static final class b implements Handler.Callback, Choreographer.FrameCallback {
        private static final b mIm = new b();
        private final Handler handler;
        public volatile long mIl = -9223372036854775807L;
        private final HandlerThread mIn = new HandlerThread("ChoreographerOwner:Handler");
        private Choreographer mIo;
        private int mIq;

        public static b dyR() {
            return mIm;
        }

        private b() {
            this.mIn.start();
            this.handler = new Handler(this.mIn.getLooper(), this);
            this.handler.sendEmptyMessage(0);
        }

        public void dyS() {
            this.handler.sendEmptyMessage(1);
        }

        public void dyT() {
            this.handler.sendEmptyMessage(2);
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            this.mIl = j;
            this.mIo.postFrameCallbackDelayed(this, 500L);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    dyU();
                    return true;
                case 1:
                    dyV();
                    return true;
                case 2:
                    dyW();
                    return true;
                default:
                    return false;
            }
        }

        private void dyU() {
            this.mIo = Choreographer.getInstance();
        }

        private void dyV() {
            this.mIq++;
            if (this.mIq == 1) {
                this.mIo.postFrameCallback(this);
            }
        }

        private void dyW() {
            this.mIq--;
            if (this.mIq == 0) {
                this.mIo.removeFrameCallback(this);
                this.mIl = -9223372036854775807L;
            }
        }
    }
}
