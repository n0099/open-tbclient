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
    public boolean qiQ;
    private final Handler qjV;
    private long qjj;
    private boolean qjq;
    private by qkF;
    private Bitmap qkG;
    private Thread qkH;
    private a qkI;
    private b qkJ;
    private c qkK;
    private final Runnable qkL;
    private final Runnable qko;

    /* loaded from: classes3.dex */
    public interface a {
        Bitmap eJr();
    }

    /* loaded from: classes3.dex */
    public interface b {
    }

    /* loaded from: classes3.dex */
    public interface c {
    }

    public GifImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.qjV = new Handler(Looper.getMainLooper());
        this.qkI = null;
        this.qjj = -1L;
        this.qkJ = null;
        this.qkK = null;
        this.qko = new Runnable() { // from class: com.win.opensdk.image.gif2.GifImageView.1
            @Override // java.lang.Runnable
            public final void run() {
                if (GifImageView.this.qkG != null && !GifImageView.this.qkG.isRecycled()) {
                    GifImageView.this.setImageBitmap(GifImageView.this.qkG);
                }
            }
        };
        this.qkL = new Runnable() { // from class: com.win.opensdk.image.gif2.GifImageView.2
            @Override // java.lang.Runnable
            public final void run() {
                GifImageView.this.qkG = null;
                GifImageView.this.qkF = null;
                GifImageView.this.qkH = null;
                GifImageView.this.f13751a = false;
            }
        };
    }

    public GifImageView(Context context) {
        super(context);
        this.qjV = new Handler(Looper.getMainLooper());
        this.qkI = null;
        this.qjj = -1L;
        this.qkJ = null;
        this.qkK = null;
        this.qko = new Runnable() { // from class: com.win.opensdk.image.gif2.GifImageView.1
            @Override // java.lang.Runnable
            public final void run() {
                if (GifImageView.this.qkG != null && !GifImageView.this.qkG.isRecycled()) {
                    GifImageView.this.setImageBitmap(GifImageView.this.qkG);
                }
            }
        };
        this.qkL = new Runnable() { // from class: com.win.opensdk.image.gif2.GifImageView.2
            @Override // java.lang.Runnable
            public final void run() {
                GifImageView.this.qkG = null;
                GifImageView.this.qkF = null;
                GifImageView.this.qkH = null;
                GifImageView.this.f13751a = false;
            }
        };
    }

    public void setBytes(byte[] bArr) {
        boolean z;
        this.qkF = new by();
        try {
            this.qkF.as(bArr);
            if (this.qiQ) {
                eIP();
            } else if (this.qkF.f39java == 0) {
            } else {
                by byVar = this.qkF;
                if (-1 >= byVar.qkU.f43case) {
                    z = false;
                } else {
                    byVar.f39java = -1;
                    z = true;
                }
                if (!z || this.qiQ) {
                    return;
                }
                this.qjq = true;
                eIP();
            }
        } catch (Exception e) {
            this.qkF = null;
        }
    }

    public long getFramesDisplayDuration() {
        return this.qjj;
    }

    public void setFramesDisplayDuration(long j) {
        this.qjj = j;
    }

    private boolean java() {
        return (this.qiQ || this.qjq) && this.qkF != null && this.qkH == null;
    }

    public int getGifWidth() {
        return this.qkF.qkU.f13739a;
    }

    public int getFrameCount() {
        return this.qkF.qkU.f43case;
    }

    public int getGifHeight() {
        return this.qkF.qkU.f13740b;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        long j;
        int i;
        do {
            if (!this.qiQ && !this.qjq) {
                break;
            }
            by byVar = this.qkF;
            if (byVar.qkU.f43case <= 0) {
                z = false;
            } else {
                if (byVar.f39java == byVar.qkU.f43case - 1) {
                    byVar.f38case++;
                }
                if (byVar.qkU.g == -1 || byVar.f38case <= byVar.qkU.g) {
                    byVar.f39java = (byVar.f39java + 1) % byVar.qkU.f43case;
                    z = true;
                } else {
                    z = false;
                }
            }
            try {
                long nanoTime = System.nanoTime();
                this.qkG = this.qkF.eJr();
                if (this.qkI != null) {
                    this.qkG = this.qkI.eJr();
                }
                j = (System.nanoTime() - nanoTime) / TimeUtils.NANOS_PER_MS;
                try {
                    this.qjV.post(this.qko);
                } catch (ArrayIndexOutOfBoundsException e) {
                } catch (IllegalArgumentException e2) {
                }
            } catch (ArrayIndexOutOfBoundsException e3) {
                j = 0;
            } catch (IllegalArgumentException e4) {
                j = 0;
            }
            this.qjq = false;
            if (!this.qiQ || !z) {
                this.qiQ = false;
                break;
            }
            try {
                by byVar2 = this.qkF;
                if (byVar2.qkU.f43case <= 0 || byVar2.f39java < 0) {
                    i = 0;
                } else {
                    int i2 = byVar2.f39java;
                    i = (i2 < 0 || i2 >= byVar2.qkU.f43case) ? -1 : byVar2.qkU.qjR.get(i2).e;
                }
                int i3 = (int) (i - j);
                if (i3 > 0) {
                    Thread.sleep(this.qjj > 0 ? this.qjj : i3);
                }
            } catch (InterruptedException e5) {
            }
        } while (this.qiQ);
        if (this.f13751a) {
            this.qjV.post(this.qkL);
        }
        this.qkH = null;
    }

    public a getOnFrameAvailable() {
        return this.qkI;
    }

    public void setOnFrameAvailable(a aVar) {
        this.qkI = aVar;
    }

    public b getOnAnimationStop() {
        return this.qkJ;
    }

    public void setOnAnimationStop(b bVar) {
        this.qkJ = bVar;
    }

    public void setOnAnimationStart(c cVar) {
        this.qkK = cVar;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.qiQ = false;
        this.qjq = false;
        this.f13751a = true;
        this.qiQ = false;
        if (this.qkH != null) {
            this.qkH.interrupt();
            this.qkH = null;
        }
        this.qjV.post(this.qkL);
    }

    public final void eIP() {
        if (java()) {
            this.qkH = new Thread(this);
            this.qkH.start();
        }
    }
}
