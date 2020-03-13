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
    private final b mIY;
    private final a mIZ;
    private long mJa;
    private long mJb;
    private long mJc;
    private long mJd;
    private long mJe;
    private boolean mJf;
    private long mJg;
    private long mJh;
    private long mJi;
    private final WindowManager windowManager;

    public d() {
        this(null);
    }

    public d(@Nullable Context context) {
        this.windowManager = context == null ? null : (WindowManager) context.getSystemService("window");
        if (this.windowManager != null) {
            this.mIZ = v.SDK_INT >= 17 ? gt(context) : null;
            this.mIY = b.dAg();
        } else {
            this.mIZ = null;
            this.mIY = null;
        }
        this.mJa = -9223372036854775807L;
        this.mJb = -9223372036854775807L;
    }

    public void enable() {
        this.mJf = false;
        if (this.windowManager != null) {
            this.mIY.dAh();
            if (this.mIZ != null) {
                this.mIZ.register();
            }
            dAf();
        }
    }

    public void disable() {
        if (this.windowManager != null) {
            if (this.mIZ != null) {
                this.mIZ.unregister();
            }
            this.mIY.dAi();
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
        if (this.mJf) {
            if (j != this.mJc) {
                this.mJi++;
                this.mJd = this.mJe;
            }
            if (this.mJi >= 6) {
                j4 = this.mJd + ((j5 - this.mJh) / this.mJi);
                if (aa(j4, j2)) {
                    this.mJf = false;
                    j3 = j2;
                    j4 = j5;
                } else {
                    j3 = (this.mJg + j4) - this.mJh;
                }
                if (!this.mJf) {
                    this.mJh = j5;
                    this.mJg = j2;
                    this.mJi = 0L;
                    this.mJf = true;
                }
                this.mJc = j;
                this.mJe = j4;
                if (this.mIY == null && this.mJa != -9223372036854775807L) {
                    long j6 = this.mIY.mJl;
                    return j6 != -9223372036854775807L ? j(j3, j6, this.mJa) - this.mJb : j3;
                }
            } else if (aa(j5, j2)) {
                this.mJf = false;
            }
        }
        j3 = j2;
        j4 = j5;
        if (!this.mJf) {
        }
        this.mJc = j;
        this.mJe = j4;
        return this.mIY == null ? j3 : j3;
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
    public void dAf() {
        Display defaultDisplay = this.windowManager.getDefaultDisplay();
        if (defaultDisplay != null) {
            this.mJa = (long) (1.0E9d / defaultDisplay.getRefreshRate());
            this.mJb = (this.mJa * 80) / 100;
        }
    }

    private boolean aa(long j, long j2) {
        return Math.abs((j2 - this.mJg) - (j - this.mJh)) > 20000000;
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
        private final DisplayManager mJj;

        public a(DisplayManager displayManager) {
            this.mJj = displayManager;
        }

        public void register() {
            this.mJj.registerDisplayListener(this, null);
        }

        public void unregister() {
            this.mJj.unregisterDisplayListener(this);
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
                d.this.dAf();
            }
        }
    }

    /* loaded from: classes6.dex */
    private static final class b implements Handler.Callback, Choreographer.FrameCallback {
        private static final b mJm = new b();
        private final Handler handler;
        public volatile long mJl = -9223372036854775807L;
        private final HandlerThread mJn = new HandlerThread("ChoreographerOwner:Handler");
        private Choreographer mJo;
        private int mJp;

        public static b dAg() {
            return mJm;
        }

        private b() {
            this.mJn.start();
            this.handler = new Handler(this.mJn.getLooper(), this);
            this.handler.sendEmptyMessage(0);
        }

        public void dAh() {
            this.handler.sendEmptyMessage(1);
        }

        public void dAi() {
            this.handler.sendEmptyMessage(2);
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            this.mJl = j;
            this.mJo.postFrameCallbackDelayed(this, 500L);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    dAj();
                    return true;
                case 1:
                    dAk();
                    return true;
                case 2:
                    dAl();
                    return true;
                default:
                    return false;
            }
        }

        private void dAj() {
            this.mJo = Choreographer.getInstance();
        }

        private void dAk() {
            this.mJp++;
            if (this.mJp == 1) {
                this.mJo.postFrameCallback(this);
            }
        }

        private void dAl() {
            this.mJp--;
            if (this.mJp == 0) {
                this.mJo.removeFrameCallback(this);
                this.mJl = -9223372036854775807L;
            }
        }
    }
}
