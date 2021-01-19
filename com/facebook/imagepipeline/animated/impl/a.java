package com.facebook.imagepipeline.animated.impl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
import com.facebook.imagepipeline.animated.base.d;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes5.dex */
public class a implements com.facebook.imagepipeline.animated.base.a {
    private final int mDurationMs;
    @GuardedBy("this")
    @Nullable
    private Bitmap nEa;
    private final com.facebook.imagepipeline.animated.b.a pvn;
    private final d pwl;
    private final com.facebook.imagepipeline.animated.base.b pwm;
    private final Rect pwn;
    private final int[] pwo;
    private final int[] pwp;
    private final AnimatedDrawableFrameInfo[] pwq;
    private final Rect pwr = new Rect();
    private final Rect pws = new Rect();

    public a(com.facebook.imagepipeline.animated.b.a aVar, d dVar, Rect rect) {
        this.pvn = aVar;
        this.pwl = dVar;
        this.pwm = dVar.etf();
        this.pwo = this.pwm.getFrameDurations();
        this.pvn.fixFrameDurations(this.pwo);
        this.mDurationMs = this.pvn.t(this.pwo);
        this.pwp = this.pvn.u(this.pwo);
        this.pwn = a(this.pwm, rect);
        this.pwq = new AnimatedDrawableFrameInfo[this.pwm.getFrameCount()];
        for (int i = 0; i < this.pwm.getFrameCount(); i++) {
            this.pwq[i] = this.pwm.Ot(i);
        }
    }

    private static Rect a(com.facebook.imagepipeline.animated.base.b bVar, Rect rect) {
        if (rect == null) {
            return new Rect(0, 0, bVar.getWidth(), bVar.getHeight());
        }
        return new Rect(0, 0, Math.min(rect.width(), bVar.getWidth()), Math.min(rect.height(), bVar.getHeight()));
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getFrameCount() {
        return this.pwm.getFrameCount();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getLoopCount() {
        return this.pwm.getLoopCount();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getWidth() {
        return this.pwm.getWidth();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getHeight() {
        return this.pwm.getHeight();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int etd() {
        return this.pwn.width();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int ete() {
        return this.pwn.height();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public AnimatedDrawableFrameInfo Ot(int i) {
        return this.pwq[i];
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int Pd(int i) {
        return this.pwo[i];
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public com.facebook.imagepipeline.animated.base.a m(Rect rect) {
        return a(this.pwm, rect).equals(this.pwn) ? this : new a(this.pvn, this.pwl, rect);
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public void d(int i, Canvas canvas) {
        com.facebook.imagepipeline.animated.base.c Ov = this.pwm.Ov(i);
        try {
            if (this.pwm.epr()) {
                a(canvas, Ov);
            } else {
                b(canvas, Ov);
            }
        } finally {
            Ov.dispose();
        }
    }

    private synchronized void eb(int i, int i2) {
        if (this.nEa != null && (this.nEa.getWidth() < i || this.nEa.getHeight() < i2)) {
            dQM();
        }
        if (this.nEa == null) {
            this.nEa = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        }
        this.nEa.eraseColor(0);
    }

    private void a(Canvas canvas, com.facebook.imagepipeline.animated.base.c cVar) {
        double width = this.pwn.width() / this.pwm.getWidth();
        double height = this.pwn.height() / this.pwm.getHeight();
        int round = (int) Math.round(cVar.getWidth() * width);
        int round2 = (int) Math.round(cVar.getHeight() * height);
        int xOffset = (int) (width * cVar.getXOffset());
        int yOffset = (int) (height * cVar.getYOffset());
        synchronized (this) {
            int width2 = this.pwn.width();
            int height2 = this.pwn.height();
            eb(width2, height2);
            cVar.renderFrame(round, round2, this.nEa);
            this.pwr.set(0, 0, width2, height2);
            this.pws.set(xOffset, yOffset, width2 + xOffset, height2 + yOffset);
            canvas.drawBitmap(this.nEa, this.pwr, this.pws, (Paint) null);
        }
    }

    private void b(Canvas canvas, com.facebook.imagepipeline.animated.base.c cVar) {
        int width = cVar.getWidth();
        int height = cVar.getHeight();
        int xOffset = cVar.getXOffset();
        int yOffset = cVar.getYOffset();
        synchronized (this) {
            eb(width, height);
            cVar.renderFrame(width, height, this.nEa);
            this.pwr.set(0, 0, width, height);
            this.pws.set(0, 0, width, height);
            canvas.save();
            canvas.translate(xOffset, yOffset);
            canvas.drawBitmap(this.nEa, this.pwr, this.pws, (Paint) null);
            canvas.restore();
        }
    }

    private synchronized void dQM() {
        if (this.nEa != null) {
            this.nEa.recycle();
            this.nEa = null;
        }
    }
}
