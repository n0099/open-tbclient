package com.win.opensdk.image.gif2;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.win.opensdk.by;
/* loaded from: classes4.dex */
public class GifImageView extends ImageView implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private boolean f14048a;
    public boolean qbE;
    private long qbX;
    private final Handler qcJ;
    private boolean qce;
    private final Runnable qdc;
    private by qdt;
    private Bitmap qdu;
    private Thread qdv;
    private a qdw;
    private b qdx;
    private c qdy;
    private final Runnable qdz;

    /* loaded from: classes4.dex */
    public interface a {
        Bitmap eKn();
    }

    /* loaded from: classes4.dex */
    public interface b {
    }

    /* loaded from: classes4.dex */
    public interface c {
    }

    public GifImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.qcJ = new Handler(Looper.getMainLooper());
        this.qdw = null;
        this.qbX = -1L;
        this.qdx = null;
        this.qdy = null;
        this.qdc = new Runnable() { // from class: com.win.opensdk.image.gif2.GifImageView.1
            @Override // java.lang.Runnable
            public final void run() {
                if (GifImageView.this.qdu != null && !GifImageView.this.qdu.isRecycled()) {
                    GifImageView.this.setImageBitmap(GifImageView.this.qdu);
                }
            }
        };
        this.qdz = new Runnable() { // from class: com.win.opensdk.image.gif2.GifImageView.2
            @Override // java.lang.Runnable
            public final void run() {
                GifImageView.this.qdu = null;
                GifImageView.this.qdt = null;
                GifImageView.this.qdv = null;
                GifImageView.this.f14048a = false;
            }
        };
    }

    public GifImageView(Context context) {
        super(context);
        this.qcJ = new Handler(Looper.getMainLooper());
        this.qdw = null;
        this.qbX = -1L;
        this.qdx = null;
        this.qdy = null;
        this.qdc = new Runnable() { // from class: com.win.opensdk.image.gif2.GifImageView.1
            @Override // java.lang.Runnable
            public final void run() {
                if (GifImageView.this.qdu != null && !GifImageView.this.qdu.isRecycled()) {
                    GifImageView.this.setImageBitmap(GifImageView.this.qdu);
                }
            }
        };
        this.qdz = new Runnable() { // from class: com.win.opensdk.image.gif2.GifImageView.2
            @Override // java.lang.Runnable
            public final void run() {
                GifImageView.this.qdu = null;
                GifImageView.this.qdt = null;
                GifImageView.this.qdv = null;
                GifImageView.this.f14048a = false;
            }
        };
    }

    public void setBytes(byte[] bArr) {
        boolean z;
        this.qdt = new by();
        try {
            this.qdt.au(bArr);
            if (this.qbE) {
                eJL();
            } else if (this.qdt.f39java == 0) {
            } else {
                by byVar = this.qdt;
                if (-1 >= byVar.qdI.f43case) {
                    z = false;
                } else {
                    byVar.f39java = -1;
                    z = true;
                }
                if (!z || this.qbE) {
                    return;
                }
                this.qce = true;
                eJL();
            }
        } catch (Exception e) {
            this.qdt = null;
        }
    }

    public long getFramesDisplayDuration() {
        return this.qbX;
    }

    public void setFramesDisplayDuration(long j) {
        this.qbX = j;
    }

    private boolean java() {
        return (this.qbE || this.qce) && this.qdt != null && this.qdv == null;
    }

    public int getGifWidth() {
        return this.qdt.qdI.f14036a;
    }

    public int getFrameCount() {
        return this.qdt.qdI.f43case;
    }

    public int getGifHeight() {
        return this.qdt.qdI.f14037b;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        long j;
        int i;
        do {
            if (!this.qbE && !this.qce) {
                break;
            }
            by byVar = this.qdt;
            if (byVar.qdI.f43case <= 0) {
                z = false;
            } else {
                if (byVar.f39java == byVar.qdI.f43case - 1) {
                    byVar.f38case++;
                }
                if (byVar.qdI.g == -1 || byVar.f38case <= byVar.qdI.g) {
                    byVar.f39java = (byVar.f39java + 1) % byVar.qdI.f43case;
                    z = true;
                } else {
                    z = false;
                }
            }
            try {
                long nanoTime = System.nanoTime();
                this.qdu = this.qdt.eKn();
                if (this.qdw != null) {
                    this.qdu = this.qdw.eKn();
                }
                j = (System.nanoTime() - nanoTime) / TimeUtils.NANOS_PER_MS;
                try {
                    this.qcJ.post(this.qdc);
                } catch (ArrayIndexOutOfBoundsException e) {
                } catch (IllegalArgumentException e2) {
                }
            } catch (ArrayIndexOutOfBoundsException e3) {
                j = 0;
            } catch (IllegalArgumentException e4) {
                j = 0;
            }
            this.qce = false;
            if (!this.qbE || !z) {
                this.qbE = false;
                break;
            }
            try {
                by byVar2 = this.qdt;
                if (byVar2.qdI.f43case <= 0 || byVar2.f39java < 0) {
                    i = 0;
                } else {
                    int i2 = byVar2.f39java;
                    i = (i2 < 0 || i2 >= byVar2.qdI.f43case) ? -1 : byVar2.qdI.qcF.get(i2).e;
                }
                int i3 = (int) (i - j);
                if (i3 > 0) {
                    Thread.sleep(this.qbX > 0 ? this.qbX : i3);
                }
            } catch (InterruptedException e5) {
            }
        } while (this.qbE);
        if (this.f14048a) {
            this.qcJ.post(this.qdz);
        }
        this.qdv = null;
    }

    public a getOnFrameAvailable() {
        return this.qdw;
    }

    public void setOnFrameAvailable(a aVar) {
        this.qdw = aVar;
    }

    public b getOnAnimationStop() {
        return this.qdx;
    }

    public void setOnAnimationStop(b bVar) {
        this.qdx = bVar;
    }

    public void setOnAnimationStart(c cVar) {
        this.qdy = cVar;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.qbE = false;
        this.qce = false;
        this.f14048a = true;
        this.qbE = false;
        if (this.qdv != null) {
            this.qdv.interrupt();
            this.qdv = null;
        }
        this.qcJ.post(this.qdz);
    }

    public final void eJL() {
        if (java()) {
            this.qdv = new Thread(this);
            this.qdv.start();
        }
    }
}
