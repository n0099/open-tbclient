package com.win.opensdk.image.gif2;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.win.opensdk.Z;
import com.win.opensdk.a0;
import com.win.opensdk.b0;
import com.win.opensdk.d0;
import com.win.opensdk.e0;
import com.win.opensdk.f0;
import com.win.opensdk.g0;
import com.win.opensdk.h0;
/* loaded from: classes7.dex */
public class GifImageView extends ImageView implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public Z f39947a;

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f39948b;

    /* renamed from: c  reason: collision with root package name */
    public final Handler f39949c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f39950d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f39951e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f39952f;

    /* renamed from: g  reason: collision with root package name */
    public Thread f39953g;

    /* renamed from: h  reason: collision with root package name */
    public long f39954h;
    public final Runnable i;
    public final Runnable j;

    public GifImageView(Context context) {
        super(context);
        this.f39949c = new Handler(Looper.getMainLooper());
        this.f39954h = -1L;
        this.i = new d0(this);
        this.j = new e0(this);
    }

    public GifImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f39949c = new Handler(Looper.getMainLooper());
        this.f39954h = -1L;
        this.i = new d0(this);
        this.j = new e0(this);
    }

    public void a() {
        this.f39950d = false;
        this.f39951e = false;
        this.f39952f = true;
        d();
        this.f39949c.post(this.j);
    }

    public void a(int i) {
        Z z = this.f39947a;
        if (z.n == i || !z.a(i - 1) || this.f39950d) {
            return;
        }
        this.f39951e = true;
        c();
    }

    public void b() {
        this.f39950d = true;
        c();
    }

    public final void c() {
        if ((this.f39950d || this.f39951e) && this.f39947a != null && this.f39953g == null) {
            Thread thread = new Thread(this);
            this.f39953g = thread;
            thread.start();
        }
    }

    public void d() {
        this.f39950d = false;
        Thread thread = this.f39953g;
        if (thread != null) {
            thread.interrupt();
            this.f39953g = null;
        }
    }

    public int getFrameCount() {
        return this.f39947a.p.f39881c;
    }

    public long getFramesDisplayDuration() {
        return this.f39954h;
    }

    public int getGifHeight() {
        return this.f39947a.p.f39885g;
    }

    public int getGifWidth() {
        return this.f39947a.p.f39884f;
    }

    public g0 getOnAnimationStop() {
        return null;
    }

    public h0 getOnFrameAvailable() {
        return null;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:12|(4:14|(1:16)|17|(8:21|22|23|24|26|27|28|(1:54)(7:31|32|(4:(1:39)|40|(3:42|(1:44)(1:46)|45)|47)|50|40|(0)|47)))|59|22|23|24|26|27|28|(1:53)(1:55)|54) */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0058, code lost:
        r7 = 0;
     */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0084 A[Catch: InterruptedException -> 0x0092, TryCatch #0 {InterruptedException -> 0x0092, blocks: (B:29:0x0062, B:31:0x006a, B:36:0x0073, B:38:0x007f, B:40:0x0084, B:42:0x008a, B:44:0x008e, B:43:0x008d), top: B:56:0x0062 }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        Z z;
        b0 b0Var;
        int i;
        int i2;
        int i3;
        do {
            if (!this.f39950d && !this.f39951e) {
                break;
            }
            Z z2 = this.f39947a;
            int i4 = z2.p.f39881c;
            int i5 = -1;
            boolean z3 = true;
            if (i4 > 0) {
                if (z2.n == i4 - 1) {
                    z2.o++;
                }
                int i6 = z2.p.m;
                if (i6 == -1 || z2.o <= i6) {
                    z2.n = (z2.n + 1) % z2.p.f39881c;
                    long nanoTime = System.nanoTime();
                    this.f39948b = this.f39947a.b();
                    long j = (System.nanoTime() - nanoTime) / 1000000;
                    this.f39949c.post(this.i);
                    this.f39951e = false;
                    if (this.f39950d || !z3) {
                        this.f39950d = false;
                        break;
                    }
                    try {
                        z = this.f39947a;
                        b0Var = z.p;
                        i = b0Var.f39881c;
                    } catch (InterruptedException unused) {
                    }
                    if (i > 0 && (i3 = z.n) >= 0) {
                        if (i3 >= 0 && i3 < i) {
                            i5 = ((a0) b0Var.f39883e.get(i3)).i;
                        }
                        i2 = (int) (i5 - j);
                        if (i2 > 0) {
                            Thread.sleep(this.f39954h > 0 ? this.f39954h : i2);
                        }
                    }
                    i5 = 0;
                    i2 = (int) (i5 - j);
                    if (i2 > 0) {
                    }
                }
            }
            z3 = false;
            long nanoTime2 = System.nanoTime();
            this.f39948b = this.f39947a.b();
            long j2 = (System.nanoTime() - nanoTime2) / 1000000;
            this.f39949c.post(this.i);
            this.f39951e = false;
            if (this.f39950d) {
            }
            this.f39950d = false;
            break;
        } while (this.f39950d);
        if (this.f39952f) {
            this.f39949c.post(this.j);
        }
        this.f39953g = null;
    }

    public void setBytes(byte[] bArr) {
        Z z = new Z();
        this.f39947a = z;
        try {
            z.a(bArr);
            if (this.f39950d) {
                c();
            } else {
                a(0);
            }
        } catch (Exception unused) {
            this.f39947a = null;
        }
    }

    public void setFramesDisplayDuration(long j) {
        this.f39954h = j;
    }

    public void setOnAnimationStart(f0 f0Var) {
    }

    public void setOnAnimationStop(g0 g0Var) {
    }

    public void setOnFrameAvailable(h0 h0Var) {
    }
}
