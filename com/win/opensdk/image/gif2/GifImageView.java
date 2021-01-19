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
    public boolean pYM;
    private final Handler pZR;
    private long pZf;
    private boolean pZm;
    private by qaB;
    private Bitmap qaC;
    private Thread qaD;
    private a qaE;
    private b qaF;
    private c qaG;
    private final Runnable qaH;
    private final Runnable qak;

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
        this.pZR = new Handler(Looper.getMainLooper());
        this.qaE = null;
        this.pZf = -1L;
        this.qaF = null;
        this.qaG = null;
        this.qak = new Runnable() { // from class: com.win.opensdk.image.gif2.GifImageView.1
            @Override // java.lang.Runnable
            public final void run() {
                if (GifImageView.this.qaC != null && !GifImageView.this.qaC.isRecycled()) {
                    GifImageView.this.setImageBitmap(GifImageView.this.qaC);
                }
            }
        };
        this.qaH = new Runnable() { // from class: com.win.opensdk.image.gif2.GifImageView.2
            @Override // java.lang.Runnable
            public final void run() {
                GifImageView.this.qaC = null;
                GifImageView.this.qaB = null;
                GifImageView.this.qaD = null;
                GifImageView.this.f13749a = false;
            }
        };
    }

    public GifImageView(Context context) {
        super(context);
        this.pZR = new Handler(Looper.getMainLooper());
        this.qaE = null;
        this.pZf = -1L;
        this.qaF = null;
        this.qaG = null;
        this.qak = new Runnable() { // from class: com.win.opensdk.image.gif2.GifImageView.1
            @Override // java.lang.Runnable
            public final void run() {
                if (GifImageView.this.qaC != null && !GifImageView.this.qaC.isRecycled()) {
                    GifImageView.this.setImageBitmap(GifImageView.this.qaC);
                }
            }
        };
        this.qaH = new Runnable() { // from class: com.win.opensdk.image.gif2.GifImageView.2
            @Override // java.lang.Runnable
            public final void run() {
                GifImageView.this.qaC = null;
                GifImageView.this.qaB = null;
                GifImageView.this.qaD = null;
                GifImageView.this.f13749a = false;
            }
        };
    }

    public void setBytes(byte[] bArr) {
        boolean z;
        this.qaB = new by();
        try {
            this.qaB.at(bArr);
            if (this.pYM) {
                eGz();
            } else if (this.qaB.f39java == 0) {
            } else {
                by byVar = this.qaB;
                if (-1 >= byVar.qaQ.f43case) {
                    z = false;
                } else {
                    byVar.f39java = -1;
                    z = true;
                }
                if (!z || this.pYM) {
                    return;
                }
                this.pZm = true;
                eGz();
            }
        } catch (Exception e) {
            this.qaB = null;
        }
    }

    public long getFramesDisplayDuration() {
        return this.pZf;
    }

    public void setFramesDisplayDuration(long j) {
        this.pZf = j;
    }

    private boolean java() {
        return (this.pYM || this.pZm) && this.qaB != null && this.qaD == null;
    }

    public int getGifWidth() {
        return this.qaB.qaQ.f13737a;
    }

    public int getFrameCount() {
        return this.qaB.qaQ.f43case;
    }

    public int getGifHeight() {
        return this.qaB.qaQ.f13738b;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        long j;
        int i;
        do {
            if (!this.pYM && !this.pZm) {
                break;
            }
            by byVar = this.qaB;
            if (byVar.qaQ.f43case <= 0) {
                z = false;
            } else {
                if (byVar.f39java == byVar.qaQ.f43case - 1) {
                    byVar.f38case++;
                }
                if (byVar.qaQ.g == -1 || byVar.f38case <= byVar.qaQ.g) {
                    byVar.f39java = (byVar.f39java + 1) % byVar.qaQ.f43case;
                    z = true;
                } else {
                    z = false;
                }
            }
            try {
                long nanoTime = System.nanoTime();
                this.qaC = this.qaB.eHb();
                if (this.qaE != null) {
                    this.qaC = this.qaE.eHb();
                }
                j = (System.nanoTime() - nanoTime) / TimeUtils.NANOS_PER_MS;
                try {
                    this.pZR.post(this.qak);
                } catch (ArrayIndexOutOfBoundsException e) {
                } catch (IllegalArgumentException e2) {
                }
            } catch (ArrayIndexOutOfBoundsException e3) {
                j = 0;
            } catch (IllegalArgumentException e4) {
                j = 0;
            }
            this.pZm = false;
            if (!this.pYM || !z) {
                this.pYM = false;
                break;
            }
            try {
                by byVar2 = this.qaB;
                if (byVar2.qaQ.f43case <= 0 || byVar2.f39java < 0) {
                    i = 0;
                } else {
                    int i2 = byVar2.f39java;
                    i = (i2 < 0 || i2 >= byVar2.qaQ.f43case) ? -1 : byVar2.qaQ.pZN.get(i2).e;
                }
                int i3 = (int) (i - j);
                if (i3 > 0) {
                    Thread.sleep(this.pZf > 0 ? this.pZf : i3);
                }
            } catch (InterruptedException e5) {
            }
        } while (this.pYM);
        if (this.f13749a) {
            this.pZR.post(this.qaH);
        }
        this.qaD = null;
    }

    public a getOnFrameAvailable() {
        return this.qaE;
    }

    public void setOnFrameAvailable(a aVar) {
        this.qaE = aVar;
    }

    public b getOnAnimationStop() {
        return this.qaF;
    }

    public void setOnAnimationStop(b bVar) {
        this.qaF = bVar;
    }

    public void setOnAnimationStart(c cVar) {
        this.qaG = cVar;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.pYM = false;
        this.pZm = false;
        this.f13749a = true;
        this.pYM = false;
        if (this.qaD != null) {
            this.qaD.interrupt();
            this.qaD = null;
        }
        this.pZR.post(this.qaH);
    }

    public final void eGz() {
        if (java()) {
            this.qaD = new Thread(this);
            this.qaD.start();
        }
    }
}
