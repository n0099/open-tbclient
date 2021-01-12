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
    private Bitmap nDZ;
    private final com.facebook.imagepipeline.animated.b.a pvm;
    private final d pwk;
    private final com.facebook.imagepipeline.animated.base.b pwl;
    private final Rect pwm;
    private final int[] pwn;
    private final int[] pwo;
    private final AnimatedDrawableFrameInfo[] pwp;
    private final Rect pwq = new Rect();
    private final Rect pwr = new Rect();

    public a(com.facebook.imagepipeline.animated.b.a aVar, d dVar, Rect rect) {
        this.pvm = aVar;
        this.pwk = dVar;
        this.pwl = dVar.etf();
        this.pwn = this.pwl.getFrameDurations();
        this.pvm.fixFrameDurations(this.pwn);
        this.mDurationMs = this.pvm.t(this.pwn);
        this.pwo = this.pvm.u(this.pwn);
        this.pwm = a(this.pwl, rect);
        this.pwp = new AnimatedDrawableFrameInfo[this.pwl.getFrameCount()];
        for (int i = 0; i < this.pwl.getFrameCount(); i++) {
            this.pwp[i] = this.pwl.Ot(i);
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
        return this.pwl.getFrameCount();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getLoopCount() {
        return this.pwl.getLoopCount();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getWidth() {
        return this.pwl.getWidth();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getHeight() {
        return this.pwl.getHeight();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int etd() {
        return this.pwm.width();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int ete() {
        return this.pwm.height();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public AnimatedDrawableFrameInfo Ot(int i) {
        return this.pwp[i];
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int Pd(int i) {
        return this.pwn[i];
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public com.facebook.imagepipeline.animated.base.a m(Rect rect) {
        return a(this.pwl, rect).equals(this.pwm) ? this : new a(this.pvm, this.pwk, rect);
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public void d(int i, Canvas canvas) {
        com.facebook.imagepipeline.animated.base.c Ov = this.pwl.Ov(i);
        try {
            if (this.pwl.epr()) {
                a(canvas, Ov);
            } else {
                b(canvas, Ov);
            }
        } finally {
            Ov.dispose();
        }
    }

    private synchronized void eb(int i, int i2) {
        if (this.nDZ != null && (this.nDZ.getWidth() < i || this.nDZ.getHeight() < i2)) {
            dQM();
        }
        if (this.nDZ == null) {
            this.nDZ = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        }
        this.nDZ.eraseColor(0);
    }

    private void a(Canvas canvas, com.facebook.imagepipeline.animated.base.c cVar) {
        double width = this.pwm.width() / this.pwl.getWidth();
        double height = this.pwm.height() / this.pwl.getHeight();
        int round = (int) Math.round(cVar.getWidth() * width);
        int round2 = (int) Math.round(cVar.getHeight() * height);
        int xOffset = (int) (width * cVar.getXOffset());
        int yOffset = (int) (height * cVar.getYOffset());
        synchronized (this) {
            int width2 = this.pwm.width();
            int height2 = this.pwm.height();
            eb(width2, height2);
            cVar.renderFrame(round, round2, this.nDZ);
            this.pwq.set(0, 0, width2, height2);
            this.pwr.set(xOffset, yOffset, width2 + xOffset, height2 + yOffset);
            canvas.drawBitmap(this.nDZ, this.pwq, this.pwr, (Paint) null);
        }
    }

    private void b(Canvas canvas, com.facebook.imagepipeline.animated.base.c cVar) {
        int width = cVar.getWidth();
        int height = cVar.getHeight();
        int xOffset = cVar.getXOffset();
        int yOffset = cVar.getYOffset();
        synchronized (this) {
            eb(width, height);
            cVar.renderFrame(width, height, this.nDZ);
            this.pwq.set(0, 0, width, height);
            this.pwr.set(0, 0, width, height);
            canvas.save();
            canvas.translate(xOffset, yOffset);
            canvas.drawBitmap(this.nDZ, this.pwq, this.pwr, (Paint) null);
            canvas.restore();
        }
    }

    private synchronized void dQM() {
        if (this.nDZ != null) {
            this.nDZ.recycle();
            this.nDZ = null;
        }
    }
}
