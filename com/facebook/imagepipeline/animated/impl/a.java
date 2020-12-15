package com.facebook.imagepipeline.animated.impl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
import com.facebook.imagepipeline.animated.base.d;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes12.dex */
public class a implements com.facebook.imagepipeline.animated.base.a {
    @GuardedBy("this")
    @Nullable
    private Bitmap nEA;
    private final int pfF;
    private final com.facebook.imagepipeline.animated.b.a piB;
    private final com.facebook.imagepipeline.animated.base.b pjA;
    private final Rect pjB;
    private final int[] pjC;
    private final int[] pjD;
    private final AnimatedDrawableFrameInfo[] pjE;
    private final Rect pjF = new Rect();
    private final Rect pjG = new Rect();
    private final d pjz;

    public a(com.facebook.imagepipeline.animated.b.a aVar, d dVar, Rect rect) {
        this.piB = aVar;
        this.pjz = dVar;
        this.pjA = dVar.esN();
        this.pjC = this.pjA.eoY();
        this.piB.s(this.pjC);
        this.pfF = this.piB.t(this.pjC);
        this.pjD = this.piB.u(this.pjC);
        this.pjB = a(this.pjA, rect);
        this.pjE = new AnimatedDrawableFrameInfo[this.pjA.getFrameCount()];
        for (int i = 0; i < this.pjA.getFrameCount(); i++) {
            this.pjE[i] = this.pjA.PM(i);
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
        return this.pjA.getFrameCount();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getLoopCount() {
        return this.pjA.getLoopCount();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getWidth() {
        return this.pjA.getWidth();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getHeight() {
        return this.pjA.getHeight();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int esL() {
        return this.pjB.width();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int esM() {
        return this.pjB.height();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public AnimatedDrawableFrameInfo PM(int i) {
        return this.pjE[i];
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int Qw(int i) {
        return this.pjC[i];
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public com.facebook.imagepipeline.animated.base.a m(Rect rect) {
        return a(this.pjA, rect).equals(this.pjB) ? this : new a(this.piB, this.pjz, rect);
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public void c(int i, Canvas canvas) {
        com.facebook.imagepipeline.animated.base.c PO = this.pjA.PO(i);
        try {
            if (this.pjA.eoZ()) {
                a(canvas, PO);
            } else {
                b(canvas, PO);
            }
        } finally {
            PO.dispose();
        }
    }

    private synchronized void eb(int i, int i2) {
        if (this.nEA != null && (this.nEA.getWidth() < i || this.nEA.getHeight() < i2)) {
            dUM();
        }
        if (this.nEA == null) {
            this.nEA = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        }
        this.nEA.eraseColor(0);
    }

    private void a(Canvas canvas, com.facebook.imagepipeline.animated.base.c cVar) {
        double width = this.pjB.width() / this.pjA.getWidth();
        double height = this.pjB.height() / this.pjA.getHeight();
        int round = (int) Math.round(cVar.getWidth() * width);
        int round2 = (int) Math.round(cVar.getHeight() * height);
        int xOffset = (int) (width * cVar.getXOffset());
        int yOffset = (int) (height * cVar.getYOffset());
        synchronized (this) {
            int width2 = this.pjB.width();
            int height2 = this.pjB.height();
            eb(width2, height2);
            cVar.b(round, round2, this.nEA);
            this.pjF.set(0, 0, width2, height2);
            this.pjG.set(xOffset, yOffset, width2 + xOffset, height2 + yOffset);
            canvas.drawBitmap(this.nEA, this.pjF, this.pjG, (Paint) null);
        }
    }

    private void b(Canvas canvas, com.facebook.imagepipeline.animated.base.c cVar) {
        int width = cVar.getWidth();
        int height = cVar.getHeight();
        int xOffset = cVar.getXOffset();
        int yOffset = cVar.getYOffset();
        synchronized (this) {
            eb(width, height);
            cVar.b(width, height, this.nEA);
            this.pjF.set(0, 0, width, height);
            this.pjG.set(0, 0, width, height);
            canvas.save();
            canvas.translate(xOffset, yOffset);
            canvas.drawBitmap(this.nEA, this.pjF, this.pjG, (Paint) null);
            canvas.restore();
        }
    }

    private synchronized void dUM() {
        if (this.nEA != null) {
            this.nEA.recycle();
            this.nEA = null;
        }
    }
}
