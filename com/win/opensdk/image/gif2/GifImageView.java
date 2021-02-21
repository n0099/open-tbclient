package com.win.opensdk.image.gif2;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.win.opensdk.by;
/* loaded from: classes3.dex */
public class GifImageView extends ImageView implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private boolean f13751a;
    private long qjJ;
    private boolean qjQ;
    public boolean qjq;
    private final Runnable qkO;
    private final Handler qkv;
    private by qlf;
    private Bitmap qlg;
    private Thread qlh;
    private a qli;
    private b qlj;
    private c qlk;
    private final Runnable qll;

    /* loaded from: classes3.dex */
    public interface a {
        Bitmap eJz();
    }

    /* loaded from: classes3.dex */
    public interface b {
    }

    /* loaded from: classes3.dex */
    public interface c {
    }

    public GifImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.qkv = new Handler(Looper.getMainLooper());
        this.qli = null;
        this.qjJ = -1L;
        this.qlj = null;
        this.qlk = null;
        this.qkO = new Runnable() { // from class: com.win.opensdk.image.gif2.GifImageView.1
            @Override // java.lang.Runnable
            public final void run() {
                if (GifImageView.this.qlg != null && !GifImageView.this.qlg.isRecycled()) {
                    GifImageView.this.setImageBitmap(GifImageView.this.qlg);
                }
            }
        };
        this.qll = new Runnable() { // from class: com.win.opensdk.image.gif2.GifImageView.2
            @Override // java.lang.Runnable
            public final void run() {
                GifImageView.this.qlg = null;
                GifImageView.this.qlf = null;
                GifImageView.this.qlh = null;
                GifImageView.this.f13751a = false;
            }
        };
    }

    public GifImageView(Context context) {
        super(context);
        this.qkv = new Handler(Looper.getMainLooper());
        this.qli = null;
        this.qjJ = -1L;
        this.qlj = null;
        this.qlk = null;
        this.qkO = new Runnable() { // from class: com.win.opensdk.image.gif2.GifImageView.1
            @Override // java.lang.Runnable
            public final void run() {
                if (GifImageView.this.qlg != null && !GifImageView.this.qlg.isRecycled()) {
                    GifImageView.this.setImageBitmap(GifImageView.this.qlg);
                }
            }
        };
        this.qll = new Runnable() { // from class: com.win.opensdk.image.gif2.GifImageView.2
            @Override // java.lang.Runnable
            public final void run() {
                GifImageView.this.qlg = null;
                GifImageView.this.qlf = null;
                GifImageView.this.qlh = null;
                GifImageView.this.f13751a = false;
            }
        };
    }

    public void setBytes(byte[] bArr) {
        boolean z;
        this.qlf = new by();
        try {
            this.qlf.as(bArr);
            if (this.qjq) {
                eIX();
            } else if (this.qlf.f39java == 0) {
            } else {
                by byVar = this.qlf;
                if (-1 >= byVar.qlu.f43case) {
                    z = false;
                } else {
                    byVar.f39java = -1;
                    z = true;
                }
                if (!z || this.qjq) {
                    return;
                }
                this.qjQ = true;
                eIX();
            }
        } catch (Exception e) {
            this.qlf = null;
        }
    }

    public long getFramesDisplayDuration() {
        return this.qjJ;
    }

    public void setFramesDisplayDuration(long j) {
        this.qjJ = j;
    }

    private boolean java() {
        return (this.qjq || this.qjQ) && this.qlf != null && this.qlh == null;
    }

    public int getGifWidth() {
        return this.qlf.qlu.f13739a;
    }

    public int getFrameCount() {
        return this.qlf.qlu.f43case;
    }

    public int getGifHeight() {
        return this.qlf.qlu.f13740b;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        long j;
        int i;
        do {
            if (!this.qjq && !this.qjQ) {
                break;
            }
            by byVar = this.qlf;
            if (byVar.qlu.f43case <= 0) {
                z = false;
            } else {
                if (byVar.f39java == byVar.qlu.f43case - 1) {
                    byVar.f38case++;
                }
                if (byVar.qlu.g == -1 || byVar.f38case <= byVar.qlu.g) {
                    byVar.f39java = (byVar.f39java + 1) % byVar.qlu.f43case;
                    z = true;
                } else {
                    z = false;
                }
            }
            try {
                long nanoTime = System.nanoTime();
                this.qlg = this.qlf.eJz();
                if (this.qli != null) {
                    this.qlg = this.qli.eJz();
                }
                j = (System.nanoTime() - nanoTime) / TimeUtils.NANOS_PER_MS;
                try {
                    this.qkv.post(this.qkO);
                } catch (ArrayIndexOutOfBoundsException e) {
                } catch (IllegalArgumentException e2) {
                }
            } catch (ArrayIndexOutOfBoundsException e3) {
                j = 0;
            } catch (IllegalArgumentException e4) {
                j = 0;
            }
            this.qjQ = false;
            if (!this.qjq || !z) {
                this.qjq = false;
                break;
            }
            try {
                by byVar2 = this.qlf;
                if (byVar2.qlu.f43case <= 0 || byVar2.f39java < 0) {
                    i = 0;
                } else {
                    int i2 = byVar2.f39java;
                    i = (i2 < 0 || i2 >= byVar2.qlu.f43case) ? -1 : byVar2.qlu.qkr.get(i2).e;
                }
                int i3 = (int) (i - j);
                if (i3 > 0) {
                    Thread.sleep(this.qjJ > 0 ? this.qjJ : i3);
                }
            } catch (InterruptedException e5) {
            }
        } while (this.qjq);
        if (this.f13751a) {
            this.qkv.post(this.qll);
        }
        this.qlh = null;
    }

    public a getOnFrameAvailable() {
        return this.qli;
    }

    public void setOnFrameAvailable(a aVar) {
        this.qli = aVar;
    }

    public b getOnAnimationStop() {
        return this.qlj;
    }

    public void setOnAnimationStop(b bVar) {
        this.qlj = bVar;
    }

    public void setOnAnimationStart(c cVar) {
        this.qlk = cVar;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.qjq = false;
        this.qjQ = false;
        this.f13751a = true;
        this.qjq = false;
        if (this.qlh != null) {
            this.qlh.interrupt();
            this.qlh = null;
        }
        this.qkv.post(this.qll);
    }

    public final void eIX() {
        if (java()) {
            this.qlh = new Thread(this);
            this.qlh.start();
        }
    }
}
