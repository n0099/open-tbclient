package com.win.opensdk.image.gif2;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.win.opensdk.S;
import com.win.opensdk.T;
import com.win.opensdk.U;
import com.win.opensdk.W;
import com.win.opensdk.X;
import com.win.opensdk.Y;
import com.win.opensdk.Z;
import com.win.opensdk.a0;
/* loaded from: classes7.dex */
public class GifImageView extends ImageView implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public S f40845a;

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f40846b;

    /* renamed from: c  reason: collision with root package name */
    public final Handler f40847c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f40848d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f40849e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f40850f;

    /* renamed from: g  reason: collision with root package name */
    public Thread f40851g;

    /* renamed from: h  reason: collision with root package name */
    public long f40852h;

    /* renamed from: i  reason: collision with root package name */
    public final Runnable f40853i;
    public final Runnable j;

    public GifImageView(Context context) {
        super(context);
        this.f40847c = new Handler(Looper.getMainLooper());
        this.f40852h = -1L;
        this.f40853i = new W(this);
        this.j = new X(this);
    }

    public GifImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f40847c = new Handler(Looper.getMainLooper());
        this.f40852h = -1L;
        this.f40853i = new W(this);
        this.j = new X(this);
    }

    public void a() {
        this.f40848d = false;
        this.f40849e = false;
        this.f40850f = true;
        d();
        this.f40847c.post(this.j);
    }

    public void a(int i2) {
        S s = this.f40845a;
        if (s.n == i2 || !s.a(i2 - 1) || this.f40848d) {
            return;
        }
        this.f40849e = true;
        c();
    }

    public void b() {
        this.f40848d = true;
        c();
    }

    public final void c() {
        if ((this.f40848d || this.f40849e) && this.f40845a != null && this.f40851g == null) {
            Thread thread = new Thread(this);
            this.f40851g = thread;
            thread.start();
        }
    }

    public void d() {
        this.f40848d = false;
        Thread thread = this.f40851g;
        if (thread != null) {
            thread.interrupt();
            this.f40851g = null;
        }
    }

    public int getFrameCount() {
        return this.f40845a.p.f40737c;
    }

    public long getFramesDisplayDuration() {
        return this.f40852h;
    }

    public int getGifHeight() {
        return this.f40845a.p.f40741g;
    }

    public int getGifWidth() {
        return this.f40845a.p.f40740f;
    }

    public Z getOnAnimationStop() {
        return null;
    }

    public a0 getOnFrameAvailable() {
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
        S s;
        U u;
        int i2;
        int i3;
        int i4;
        do {
            if (!this.f40848d && !this.f40849e) {
                break;
            }
            S s2 = this.f40845a;
            int i5 = s2.p.f40737c;
            int i6 = -1;
            boolean z = true;
            if (i5 > 0) {
                if (s2.n == i5 - 1) {
                    s2.o++;
                }
                int i7 = s2.p.m;
                if (i7 == -1 || s2.o <= i7) {
                    s2.n = (s2.n + 1) % s2.p.f40737c;
                    long nanoTime = System.nanoTime();
                    this.f40846b = this.f40845a.b();
                    long j = (System.nanoTime() - nanoTime) / 1000000;
                    this.f40847c.post(this.f40853i);
                    this.f40849e = false;
                    if (this.f40848d || !z) {
                        this.f40848d = false;
                        break;
                    }
                    try {
                        s = this.f40845a;
                        u = s.p;
                        i2 = u.f40737c;
                    } catch (InterruptedException unused) {
                    }
                    if (i2 > 0 && (i4 = s.n) >= 0) {
                        if (i4 >= 0 && i4 < i2) {
                            i6 = ((T) u.f40739e.get(i4)).f40733i;
                        }
                        i3 = (int) (i6 - j);
                        if (i3 > 0) {
                            Thread.sleep(this.f40852h > 0 ? this.f40852h : i3);
                        }
                    }
                    i6 = 0;
                    i3 = (int) (i6 - j);
                    if (i3 > 0) {
                    }
                }
            }
            z = false;
            long nanoTime2 = System.nanoTime();
            this.f40846b = this.f40845a.b();
            long j2 = (System.nanoTime() - nanoTime2) / 1000000;
            this.f40847c.post(this.f40853i);
            this.f40849e = false;
            if (this.f40848d) {
            }
            this.f40848d = false;
            break;
        } while (this.f40848d);
        if (this.f40850f) {
            this.f40847c.post(this.j);
        }
        this.f40851g = null;
    }

    public void setBytes(byte[] bArr) {
        S s = new S();
        this.f40845a = s;
        try {
            s.a(bArr);
            if (this.f40848d) {
                c();
            } else {
                a(0);
            }
        } catch (Exception unused) {
            this.f40845a = null;
        }
    }

    public void setFramesDisplayDuration(long j) {
        this.f40852h = j;
    }

    public void setOnAnimationStart(Y y) {
    }

    public void setOnAnimationStop(Z z) {
    }

    public void setOnFrameAvailable(a0 a0Var) {
    }
}
