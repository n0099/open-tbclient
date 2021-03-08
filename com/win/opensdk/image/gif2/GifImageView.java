package com.win.opensdk.image.gif2;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.win.opensdk.bw;
import com.win.opensdk.bz;
import com.win.opensdk.cc;
import com.win.opensdk.ci;
import com.win.opensdk.cm;
import com.win.opensdk.cq;
import com.win.opensdk.ct;
import com.win.opensdk.cw;
/* loaded from: classes14.dex */
public class GifImageView extends ImageView implements Runnable {
    public Bitmap b;
    public final Handler c;
    public boolean d;
    public boolean e;
    public boolean f;
    public Thread g;
    public long h;
    public final Runnable i;
    public final Runnable j;
    public bw qlH;

    public GifImageView(Context context) {
        super(context);
        this.c = new Handler(Looper.getMainLooper());
        this.h = -1L;
        this.i = new ci(this);
        this.j = new cm(this);
    }

    public GifImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = new Handler(Looper.getMainLooper());
        this.h = -1L;
        this.i = new ci(this);
        this.j = new cm(this);
    }

    public void a() {
        this.d = false;
        this.e = false;
        this.f = true;
        d();
        this.c.post(this.j);
    }

    public void a(int i) {
        bw bwVar = this.qlH;
        if (bwVar.n != i && bwVar.a(i - 1) && !this.d) {
            this.e = true;
            c();
        }
    }

    public final void c() {
        if ((this.d || this.e) && this.qlH != null && this.g == null) {
            this.g = new Thread(this);
            this.g.start();
        }
    }

    public void d() {
        this.d = false;
        Thread thread = this.g;
        if (thread != null) {
            thread.interrupt();
            this.g = null;
        }
    }

    public int getFrameCount() {
        return this.qlH.qlm.c;
    }

    public long getFramesDisplayDuration() {
        return this.h;
    }

    public int getGifHeight() {
        return this.qlH.qlm.g;
    }

    public int getGifWidth() {
        return this.qlH.qlm.f;
    }

    public ct getOnAnimationStop() {
        return null;
    }

    public cw getOnFrameAvailable() {
        return null;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a();
    }

    public void setBytes(byte[] bArr) {
        this.qlH = new bw();
        try {
            this.qlH.a(bArr);
            if (this.d) {
                c();
            } else {
                a(0);
            }
        } catch (Exception e) {
            this.qlH = null;
        }
    }

    public void setFramesDisplayDuration(long j) {
        this.h = j;
    }

    public void setOnAnimationStart(cq cqVar) {
    }

    public void setOnAnimationStop(ct ctVar) {
    }

    public void setOnFrameAvailable(cw cwVar) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [5=4] */
    /* JADX WARN: Can't wrap try/catch for region: R(10:13|(4:56|(1:58)|59|(7:63|16|17|18|19|20|(1:46)(6:23|24|(1:42)(1:(1:41)(1:30))|31|(3:33|(1:35)(1:37)|36)|38)))|15|16|17|18|19|20|(1:45)(1:47)|46) */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00a7, code lost:
        r2 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00ac, code lost:
        r2 = 0;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        boolean z;
        cc ccVar;
        int i;
        do {
            if (!this.d && !this.e) {
                break;
            }
            bw bwVar = this.qlH;
            int i2 = bwVar.qlm.c;
            if (i2 > 0) {
                if (bwVar.n == i2 - 1) {
                    bwVar.o++;
                }
                int i3 = bwVar.qlm.m;
                if (i3 == -1 || bwVar.o <= i3) {
                    bwVar.n = (bwVar.n + 1) % bwVar.qlm.c;
                    z = true;
                    long nanoTime = System.nanoTime();
                    this.b = this.qlH.b();
                    long j = (System.nanoTime() - nanoTime) / TimeUtils.NANOS_PER_MS;
                    this.c.post(this.i);
                    this.e = false;
                    if (this.d || !z) {
                        this.d = false;
                        break;
                    }
                    try {
                        bw bwVar2 = this.qlH;
                        int i4 = bwVar2.qlm.c;
                        int i5 = (int) (((i4 <= 0 || (i = bwVar2.n) < 0) ? 0 : (i < 0 || i >= i4) ? -1 : ((bz) ccVar.e.get(i)).i) - j);
                        if (i5 > 0) {
                            Thread.sleep(this.h > 0 ? this.h : i5);
                        }
                    } catch (InterruptedException e) {
                    }
                }
            }
            z = false;
            long nanoTime2 = System.nanoTime();
            this.b = this.qlH.b();
            long j2 = (System.nanoTime() - nanoTime2) / TimeUtils.NANOS_PER_MS;
            this.c.post(this.i);
            this.e = false;
            if (this.d) {
            }
            this.d = false;
            break;
        } while (this.d);
        if (this.f) {
            this.c.post(this.j);
        }
        this.g = null;
    }
}
