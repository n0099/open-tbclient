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
    private boolean f14049a;
    private long qdF;
    private boolean qdM;
    public boolean qdm;
    private final Runnable qeK;
    private final Handler qer;
    private by qfb;
    private Bitmap qfc;
    private Thread qfd;
    private a qfe;
    private b qff;
    private c qfg;
    private final Runnable qfh;

    /* loaded from: classes4.dex */
    public interface a {
        Bitmap eKR();
    }

    /* loaded from: classes4.dex */
    public interface b {
    }

    /* loaded from: classes4.dex */
    public interface c {
    }

    public GifImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.qer = new Handler(Looper.getMainLooper());
        this.qfe = null;
        this.qdF = -1L;
        this.qff = null;
        this.qfg = null;
        this.qeK = new Runnable() { // from class: com.win.opensdk.image.gif2.GifImageView.1
            @Override // java.lang.Runnable
            public final void run() {
                if (GifImageView.this.qfc != null && !GifImageView.this.qfc.isRecycled()) {
                    GifImageView.this.setImageBitmap(GifImageView.this.qfc);
                }
            }
        };
        this.qfh = new Runnable() { // from class: com.win.opensdk.image.gif2.GifImageView.2
            @Override // java.lang.Runnable
            public final void run() {
                GifImageView.this.qfc = null;
                GifImageView.this.qfb = null;
                GifImageView.this.qfd = null;
                GifImageView.this.f14049a = false;
            }
        };
    }

    public GifImageView(Context context) {
        super(context);
        this.qer = new Handler(Looper.getMainLooper());
        this.qfe = null;
        this.qdF = -1L;
        this.qff = null;
        this.qfg = null;
        this.qeK = new Runnable() { // from class: com.win.opensdk.image.gif2.GifImageView.1
            @Override // java.lang.Runnable
            public final void run() {
                if (GifImageView.this.qfc != null && !GifImageView.this.qfc.isRecycled()) {
                    GifImageView.this.setImageBitmap(GifImageView.this.qfc);
                }
            }
        };
        this.qfh = new Runnable() { // from class: com.win.opensdk.image.gif2.GifImageView.2
            @Override // java.lang.Runnable
            public final void run() {
                GifImageView.this.qfc = null;
                GifImageView.this.qfb = null;
                GifImageView.this.qfd = null;
                GifImageView.this.f14049a = false;
            }
        };
    }

    public void setBytes(byte[] bArr) {
        boolean z;
        this.qfb = new by();
        try {
            this.qfb.au(bArr);
            if (this.qdm) {
                eKp();
            } else if (this.qfb.f40java == 0) {
            } else {
                by byVar = this.qfb;
                if (-1 >= byVar.qfq.f44case) {
                    z = false;
                } else {
                    byVar.f40java = -1;
                    z = true;
                }
                if (!z || this.qdm) {
                    return;
                }
                this.qdM = true;
                eKp();
            }
        } catch (Exception e) {
            this.qfb = null;
        }
    }

    public long getFramesDisplayDuration() {
        return this.qdF;
    }

    public void setFramesDisplayDuration(long j) {
        this.qdF = j;
    }

    private boolean java() {
        return (this.qdm || this.qdM) && this.qfb != null && this.qfd == null;
    }

    public int getGifWidth() {
        return this.qfb.qfq.f14037a;
    }

    public int getFrameCount() {
        return this.qfb.qfq.f44case;
    }

    public int getGifHeight() {
        return this.qfb.qfq.f14038b;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        long j;
        int i;
        do {
            if (!this.qdm && !this.qdM) {
                break;
            }
            by byVar = this.qfb;
            if (byVar.qfq.f44case <= 0) {
                z = false;
            } else {
                if (byVar.f40java == byVar.qfq.f44case - 1) {
                    byVar.f39case++;
                }
                if (byVar.qfq.g == -1 || byVar.f39case <= byVar.qfq.g) {
                    byVar.f40java = (byVar.f40java + 1) % byVar.qfq.f44case;
                    z = true;
                } else {
                    z = false;
                }
            }
            try {
                long nanoTime = System.nanoTime();
                this.qfc = this.qfb.eKR();
                if (this.qfe != null) {
                    this.qfc = this.qfe.eKR();
                }
                j = (System.nanoTime() - nanoTime) / TimeUtils.NANOS_PER_MS;
                try {
                    this.qer.post(this.qeK);
                } catch (ArrayIndexOutOfBoundsException e) {
                } catch (IllegalArgumentException e2) {
                }
            } catch (ArrayIndexOutOfBoundsException e3) {
                j = 0;
            } catch (IllegalArgumentException e4) {
                j = 0;
            }
            this.qdM = false;
            if (!this.qdm || !z) {
                this.qdm = false;
                break;
            }
            try {
                by byVar2 = this.qfb;
                if (byVar2.qfq.f44case <= 0 || byVar2.f40java < 0) {
                    i = 0;
                } else {
                    int i2 = byVar2.f40java;
                    i = (i2 < 0 || i2 >= byVar2.qfq.f44case) ? -1 : byVar2.qfq.qen.get(i2).e;
                }
                int i3 = (int) (i - j);
                if (i3 > 0) {
                    Thread.sleep(this.qdF > 0 ? this.qdF : i3);
                }
            } catch (InterruptedException e5) {
            }
        } while (this.qdm);
        if (this.f14049a) {
            this.qer.post(this.qfh);
        }
        this.qfd = null;
    }

    public a getOnFrameAvailable() {
        return this.qfe;
    }

    public void setOnFrameAvailable(a aVar) {
        this.qfe = aVar;
    }

    public b getOnAnimationStop() {
        return this.qff;
    }

    public void setOnAnimationStop(b bVar) {
        this.qff = bVar;
    }

    public void setOnAnimationStart(c cVar) {
        this.qfg = cVar;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.qdm = false;
        this.qdM = false;
        this.f14049a = true;
        this.qdm = false;
        if (this.qfd != null) {
            this.qfd.interrupt();
            this.qfd = null;
        }
        this.qer.post(this.qfh);
    }

    public final void eKp() {
        if (java()) {
            this.qfd = new Thread(this);
            this.qfd.start();
        }
    }
}
