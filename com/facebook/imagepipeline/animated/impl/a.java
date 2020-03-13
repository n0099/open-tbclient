package com.facebook.imagepipeline.animated.impl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
import com.facebook.imagepipeline.animated.base.d;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes13.dex */
public class a implements com.facebook.imagepipeline.animated.base.a {
    @GuardedBy("this")
    @Nullable
    private Bitmap kyt;
    private final com.facebook.imagepipeline.animated.b.a lPi;
    private final d lQe;
    private final com.facebook.imagepipeline.animated.base.b lQf;
    private final Rect lQg;
    private final int[] lQh;
    private final int[] lQi;
    private final AnimatedDrawableFrameInfo[] lQj;
    private final Rect lQk = new Rect();
    private final Rect lQl = new Rect();
    private final int mDurationMs;

    public a(com.facebook.imagepipeline.animated.b.a aVar, d dVar, Rect rect) {
        this.lPi = aVar;
        this.lQe = dVar;
        this.lQf = dVar.dnI();
        this.lQh = this.lQf.getFrameDurations();
        this.lPi.fixFrameDurations(this.lQh);
        this.mDurationMs = this.lPi.l(this.lQh);
        this.lQi = this.lPi.m(this.lQh);
        this.lQg = a(this.lQf, rect);
        this.lQj = new AnimatedDrawableFrameInfo[this.lQf.getFrameCount()];
        for (int i = 0; i < this.lQf.getFrameCount(); i++) {
            this.lQj[i] = this.lQf.Hn(i);
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
        return this.lQf.getFrameCount();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getLoopCount() {
        return this.lQf.getLoopCount();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getWidth() {
        return this.lQf.getWidth();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getHeight() {
        return this.lQf.getHeight();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int dnG() {
        return this.lQg.width();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int dnH() {
        return this.lQg.height();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public AnimatedDrawableFrameInfo Hn(int i) {
        return this.lQj[i];
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int HZ(int i) {
        return this.lQh[i];
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public com.facebook.imagepipeline.animated.base.a k(Rect rect) {
        return a(this.lQf, rect).equals(this.lQg) ? this : new a(this.lPi, this.lQe, rect);
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public void renderFrame(int i, Canvas canvas) {
        com.facebook.imagepipeline.animated.base.c Hp = this.lQf.Hp(i);
        try {
            if (this.lQf.djT()) {
                a(canvas, Hp);
            } else {
                b(canvas, Hp);
            }
        } finally {
            Hp.dispose();
        }
    }

    private synchronized void dw(int i, int i2) {
        if (this.kyt != null && (this.kyt.getWidth() < i || this.kyt.getHeight() < i2)) {
            cQk();
        }
        if (this.kyt == null) {
            this.kyt = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        }
        this.kyt.eraseColor(0);
    }

    private void a(Canvas canvas, com.facebook.imagepipeline.animated.base.c cVar) {
        double width = this.lQg.width() / this.lQf.getWidth();
        double height = this.lQg.height() / this.lQf.getHeight();
        int round = (int) Math.round(cVar.getWidth() * width);
        int round2 = (int) Math.round(cVar.getHeight() * height);
        int xOffset = (int) (width * cVar.getXOffset());
        int yOffset = (int) (height * cVar.getYOffset());
        synchronized (this) {
            int width2 = this.lQg.width();
            int height2 = this.lQg.height();
            dw(width2, height2);
            cVar.renderFrame(round, round2, this.kyt);
            this.lQk.set(0, 0, width2, height2);
            this.lQl.set(xOffset, yOffset, width2 + xOffset, height2 + yOffset);
            canvas.drawBitmap(this.kyt, this.lQk, this.lQl, (Paint) null);
        }
    }

    private void b(Canvas canvas, com.facebook.imagepipeline.animated.base.c cVar) {
        int width = cVar.getWidth();
        int height = cVar.getHeight();
        int xOffset = cVar.getXOffset();
        int yOffset = cVar.getYOffset();
        synchronized (this) {
            dw(width, height);
            cVar.renderFrame(width, height, this.kyt);
            this.lQk.set(0, 0, width, height);
            this.lQl.set(0, 0, width, height);
            canvas.save();
            canvas.translate(xOffset, yOffset);
            canvas.drawBitmap(this.kyt, this.lQk, this.lQl, (Paint) null);
            canvas.restore();
        }
    }

    private synchronized void cQk() {
        if (this.kyt != null) {
            this.kyt.recycle();
            this.kyt = null;
        }
    }
}
