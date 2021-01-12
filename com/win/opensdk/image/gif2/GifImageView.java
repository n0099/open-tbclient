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
    private boolean f13749a;
    public boolean pYL;
    private final Handler pZQ;
    private long pZe;
    private boolean pZl;
    private by qaA;
    private Bitmap qaB;
    private Thread qaC;
    private a qaD;
    private b qaE;
    private c qaF;
    private final Runnable qaG;
    private final Runnable qaj;

    /* loaded from: classes3.dex */
    public interface a {
        Bitmap eHb();
    }

    /* loaded from: classes3.dex */
    public interface b {
    }

    /* loaded from: classes3.dex */
    public interface c {
    }

    public GifImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.pZQ = new Handler(Looper.getMainLooper());
        this.qaD = null;
        this.pZe = -1L;
        this.qaE = null;
        this.qaF = null;
        this.qaj = new Runnable() { // from class: com.win.opensdk.image.gif2.GifImageView.1
            @Override // java.lang.Runnable
            public final void run() {
                if (GifImageView.this.qaB != null && !GifImageView.this.qaB.isRecycled()) {
                    GifImageView.this.setImageBitmap(GifImageView.this.qaB);
                }
            }
        };
        this.qaG = new Runnable() { // from class: com.win.opensdk.image.gif2.GifImageView.2
            @Override // java.lang.Runnable
            public final void run() {
                GifImageView.this.qaB = null;
                GifImageView.this.qaA = null;
                GifImageView.this.qaC = null;
                GifImageView.this.f13749a = false;
            }
        };
    }

    public GifImageView(Context context) {
        super(context);
        this.pZQ = new Handler(Looper.getMainLooper());
        this.qaD = null;
        this.pZe = -1L;
        this.qaE = null;
        this.qaF = null;
        this.qaj = new Runnable() { // from class: com.win.opensdk.image.gif2.GifImageView.1
            @Override // java.lang.Runnable
            public final void run() {
                if (GifImageView.this.qaB != null && !GifImageView.this.qaB.isRecycled()) {
                    GifImageView.this.setImageBitmap(GifImageView.this.qaB);
                }
            }
        };
        this.qaG = new Runnable() { // from class: com.win.opensdk.image.gif2.GifImageView.2
            @Override // java.lang.Runnable
            public final void run() {
                GifImageView.this.qaB = null;
                GifImageView.this.qaA = null;
                GifImageView.this.qaC = null;
                GifImageView.this.f13749a = false;
            }
        };
    }

    public void setBytes(byte[] bArr) {
        boolean z;
        this.qaA = new by();
        try {
            this.qaA.at(bArr);
            if (this.pYL) {
                eGz();
            } else if (this.qaA.f39java == 0) {
            } else {
                by byVar = this.qaA;
                if (-1 >= byVar.qaP.f43case) {
                    z = false;
                } else {
                    byVar.f39java = -1;
                    z = true;
                }
                if (!z || this.pYL) {
                    return;
                }
                this.pZl = true;
                eGz();
            }
        } catch (Exception e) {
            this.qaA = null;
        }
    }

    public long getFramesDisplayDuration() {
        return this.pZe;
    }

    public void setFramesDisplayDuration(long j) {
        this.pZe = j;
    }

    private boolean java() {
        return (this.pYL || this.pZl) && this.qaA != null && this.qaC == null;
    }

    public int getGifWidth() {
        return this.qaA.qaP.f13737a;
    }

    public int getFrameCount() {
        return this.qaA.qaP.f43case;
    }

    public int getGifHeight() {
        return this.qaA.qaP.f13738b;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        long j;
        int i;
        do {
            if (!this.pYL && !this.pZl) {
                break;
            }
            by byVar = this.qaA;
            if (byVar.qaP.f43case <= 0) {
                z = false;
            } else {
                if (byVar.f39java == byVar.qaP.f43case - 1) {
                    byVar.f38case++;
                }
                if (byVar.qaP.g == -1 || byVar.f38case <= byVar.qaP.g) {
                    byVar.f39java = (byVar.f39java + 1) % byVar.qaP.f43case;
                    z = true;
                } else {
                    z = false;
                }
            }
            try {
                long nanoTime = System.nanoTime();
                this.qaB = this.qaA.eHb();
                if (this.qaD != null) {
                    this.qaB = this.qaD.eHb();
                }
                j = (System.nanoTime() - nanoTime) / TimeUtils.NANOS_PER_MS;
                try {
                    this.pZQ.post(this.qaj);
                } catch (ArrayIndexOutOfBoundsException e) {
                } catch (IllegalArgumentException e2) {
                }
            } catch (ArrayIndexOutOfBoundsException e3) {
                j = 0;
            } catch (IllegalArgumentException e4) {
                j = 0;
            }
            this.pZl = false;
            if (!this.pYL || !z) {
                this.pYL = false;
                break;
            }
            try {
                by byVar2 = this.qaA;
                if (byVar2.qaP.f43case <= 0 || byVar2.f39java < 0) {
                    i = 0;
                } else {
                    int i2 = byVar2.f39java;
                    i = (i2 < 0 || i2 >= byVar2.qaP.f43case) ? -1 : byVar2.qaP.pZM.get(i2).e;
                }
                int i3 = (int) (i - j);
                if (i3 > 0) {
                    Thread.sleep(this.pZe > 0 ? this.pZe : i3);
                }
            } catch (InterruptedException e5) {
            }
        } while (this.pYL);
        if (this.f13749a) {
            this.pZQ.post(this.qaG);
        }
        this.qaC = null;
    }

    public a getOnFrameAvailable() {
        return this.qaD;
    }

    public void setOnFrameAvailable(a aVar) {
        this.qaD = aVar;
    }

    public b getOnAnimationStop() {
        return this.qaE;
    }

    public void setOnAnimationStop(b bVar) {
        this.qaE = bVar;
    }

    public void setOnAnimationStart(c cVar) {
        this.qaF = cVar;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.pYL = false;
        this.pZl = false;
        this.f13749a = true;
        this.pYL = false;
        if (this.qaC != null) {
            this.qaC.interrupt();
            this.qaC = null;
        }
        this.pZQ.post(this.qaG);
    }

    public final void eGz() {
        if (java()) {
            this.qaC = new Thread(this);
            this.qaC.start();
        }
    }
}
