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
    private Bitmap kxk;
    private final com.facebook.imagepipeline.animated.b.a lOo;
    private final d lPk;
    private final com.facebook.imagepipeline.animated.base.b lPl;
    private final Rect lPm;
    private final int[] lPn;
    private final int[] lPo;
    private final AnimatedDrawableFrameInfo[] lPp;
    private final Rect lPq = new Rect();
    private final Rect lPr = new Rect();
    private final int mDurationMs;

    public a(com.facebook.imagepipeline.animated.b.a aVar, d dVar, Rect rect) {
        this.lOo = aVar;
        this.lPk = dVar;
        this.lPl = dVar.dms();
        this.lPn = this.lPl.getFrameDurations();
        this.lOo.fixFrameDurations(this.lPn);
        this.mDurationMs = this.lOo.m(this.lPn);
        this.lPo = this.lOo.n(this.lPn);
        this.lPm = a(this.lPl, rect);
        this.lPp = new AnimatedDrawableFrameInfo[this.lPl.getFrameCount()];
        for (int i = 0; i < this.lPl.getFrameCount(); i++) {
            this.lPp[i] = this.lPl.Hi(i);
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
        return this.lPl.getFrameCount();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getLoopCount() {
        return this.lPl.getLoopCount();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getWidth() {
        return this.lPl.getWidth();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getHeight() {
        return this.lPl.getHeight();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int dmq() {
        return this.lPm.width();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int dmr() {
        return this.lPm.height();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public AnimatedDrawableFrameInfo Hi(int i) {
        return this.lPp[i];
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int HU(int i) {
        return this.lPn[i];
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public com.facebook.imagepipeline.animated.base.a k(Rect rect) {
        return a(this.lPl, rect).equals(this.lPm) ? this : new a(this.lOo, this.lPk, rect);
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public void renderFrame(int i, Canvas canvas) {
        com.facebook.imagepipeline.animated.base.c Hk = this.lPl.Hk(i);
        try {
            if (this.lPl.diD()) {
                a(canvas, Hk);
            } else {
                b(canvas, Hk);
            }
        } finally {
            Hk.dispose();
        }
    }

    private synchronized void dt(int i, int i2) {
        if (this.kxk != null && (this.kxk.getWidth() < i || this.kxk.getHeight() < i2)) {
            cOO();
        }
        if (this.kxk == null) {
            this.kxk = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        }
        this.kxk.eraseColor(0);
    }

    private void a(Canvas canvas, com.facebook.imagepipeline.animated.base.c cVar) {
        double width = this.lPm.width() / this.lPl.getWidth();
        double height = this.lPm.height() / this.lPl.getHeight();
        int round = (int) Math.round(cVar.getWidth() * width);
        int round2 = (int) Math.round(cVar.getHeight() * height);
        int xOffset = (int) (width * cVar.getXOffset());
        int yOffset = (int) (height * cVar.getYOffset());
        synchronized (this) {
            int width2 = this.lPm.width();
            int height2 = this.lPm.height();
            dt(width2, height2);
            cVar.renderFrame(round, round2, this.kxk);
            this.lPq.set(0, 0, width2, height2);
            this.lPr.set(xOffset, yOffset, width2 + xOffset, height2 + yOffset);
            canvas.drawBitmap(this.kxk, this.lPq, this.lPr, (Paint) null);
        }
    }

    private void b(Canvas canvas, com.facebook.imagepipeline.animated.base.c cVar) {
        int width = cVar.getWidth();
        int height = cVar.getHeight();
        int xOffset = cVar.getXOffset();
        int yOffset = cVar.getYOffset();
        synchronized (this) {
            dt(width, height);
            cVar.renderFrame(width, height, this.kxk);
            this.lPq.set(0, 0, width, height);
            this.lPr.set(0, 0, width, height);
            canvas.save();
            canvas.translate(xOffset, yOffset);
            canvas.drawBitmap(this.kxk, this.lPq, this.lPr, (Paint) null);
            canvas.restore();
        }
    }

    private synchronized void cOO() {
        if (this.kxk != null) {
            this.kxk.recycle();
            this.kxk = null;
        }
    }
}
