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
    public S f37063a;

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f37064b;

    /* renamed from: c  reason: collision with root package name */
    public final Handler f37065c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f37066d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f37067e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f37068f;

    /* renamed from: g  reason: collision with root package name */
    public Thread f37069g;

    /* renamed from: h  reason: collision with root package name */
    public long f37070h;

    /* renamed from: i  reason: collision with root package name */
    public final Runnable f37071i;
    public final Runnable j;

    public GifImageView(Context context) {
        super(context);
        this.f37065c = new Handler(Looper.getMainLooper());
        this.f37070h = -1L;
        this.f37071i = new W(this);
        this.j = new X(this);
    }

    public GifImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f37065c = new Handler(Looper.getMainLooper());
        this.f37070h = -1L;
        this.f37071i = new W(this);
        this.j = new X(this);
    }

    public void a() {
        this.f37066d = false;
        this.f37067e = false;
        this.f37068f = true;
        d();
        this.f37065c.post(this.j);
    }

    public void a(int i2) {
        S s = this.f37063a;
        if (s.n == i2 || !s.a(i2 - 1) || this.f37066d) {
            return;
        }
        this.f37067e = true;
        c();
    }

    public void b() {
        this.f37066d = true;
        c();
    }

    public final void c() {
        if ((this.f37066d || this.f37067e) && this.f37063a != null && this.f37069g == null) {
            Thread thread = new Thread(this);
            this.f37069g = thread;
            thread.start();
        }
    }

    public void d() {
        this.f37066d = false;
        Thread thread = this.f37069g;
        if (thread != null) {
            thread.interrupt();
            this.f37069g = null;
        }
    }

    public int getFrameCount() {
        return this.f37063a.p.f36955c;
    }

    public long getFramesDisplayDuration() {
        return this.f37070h;
    }

    public int getGifHeight() {
        return this.f37063a.p.f36959g;
    }

    public int getGifWidth() {
        return this.f37063a.p.f36958f;
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
            if (!this.f37066d && !this.f37067e) {
                break;
            }
            S s2 = this.f37063a;
            int i5 = s2.p.f36955c;
            int i6 = -1;
            boolean z = true;
            if (i5 > 0) {
                if (s2.n == i5 - 1) {
                    s2.o++;
                }
                int i7 = s2.p.m;
                if (i7 == -1 || s2.o <= i7) {
                    s2.n = (s2.n + 1) % s2.p.f36955c;
                    long nanoTime = System.nanoTime();
                    this.f37064b = this.f37063a.b();
                    long j = (System.nanoTime() - nanoTime) / 1000000;
                    this.f37065c.post(this.f37071i);
                    this.f37067e = false;
                    if (this.f37066d || !z) {
                        this.f37066d = false;
                        break;
                    }
                    try {
                        s = this.f37063a;
                        u = s.p;
                        i2 = u.f36955c;
                    } catch (InterruptedException unused) {
                    }
                    if (i2 > 0 && (i4 = s.n) >= 0) {
                        if (i4 >= 0 && i4 < i2) {
                            i6 = ((T) u.f36957e.get(i4)).f36951i;
                        }
                        i3 = (int) (i6 - j);
                        if (i3 > 0) {
                            Thread.sleep(this.f37070h > 0 ? this.f37070h : i3);
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
            this.f37064b = this.f37063a.b();
            long j2 = (System.nanoTime() - nanoTime2) / 1000000;
            this.f37065c.post(this.f37071i);
            this.f37067e = false;
            if (this.f37066d) {
            }
            this.f37066d = false;
            break;
        } while (this.f37066d);
        if (this.f37068f) {
            this.f37065c.post(this.j);
        }
        this.f37069g = null;
    }

    public void setBytes(byte[] bArr) {
        S s = new S();
        this.f37063a = s;
        try {
            s.a(bArr);
            if (this.f37066d) {
                c();
            } else {
                a(0);
            }
        } catch (Exception unused) {
            this.f37063a = null;
        }
    }

    public void setFramesDisplayDuration(long j) {
        this.f37070h = j;
    }

    public void setOnAnimationStart(Y y) {
    }

    public void setOnAnimationStop(Z z) {
    }

    public void setOnFrameAvailable(a0 a0Var) {
    }
}
