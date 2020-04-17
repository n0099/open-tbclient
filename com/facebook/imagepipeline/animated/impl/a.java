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
    private final int lVm;
    private final com.facebook.imagepipeline.animated.b.a lYt;
    private final d lZr;
    private final com.facebook.imagepipeline.animated.base.b lZs;
    private final Rect lZt;
    private final int[] lZu;
    private final int[] lZv;
    private final AnimatedDrawableFrameInfo[] lZw;
    private final Rect lZx = new Rect();
    private final Rect lZy = new Rect();
    @GuardedBy("this")
    @Nullable
    private Bitmap lkp;

    public a(com.facebook.imagepipeline.animated.b.a aVar, d dVar, Rect rect) {
        this.lYt = aVar;
        this.lZr = dVar;
        this.lZs = dVar.dqc();
        this.lZu = this.lZs.dmf();
        this.lYt.n(this.lZu);
        this.lVm = this.lYt.o(this.lZu);
        this.lZv = this.lYt.p(this.lZu);
        this.lZt = a(this.lZs, rect);
        this.lZw = new AnimatedDrawableFrameInfo[this.lZs.getFrameCount()];
        for (int i = 0; i < this.lZs.getFrameCount(); i++) {
            this.lZw[i] = this.lZs.FU(i);
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
        return this.lZs.getFrameCount();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getLoopCount() {
        return this.lZs.getLoopCount();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getWidth() {
        return this.lZs.getWidth();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getHeight() {
        return this.lZs.getHeight();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int dqa() {
        return this.lZt.width();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int dqb() {
        return this.lZt.height();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public AnimatedDrawableFrameInfo FU(int i) {
        return this.lZw[i];
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int GG(int i) {
        return this.lZu[i];
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public com.facebook.imagepipeline.animated.base.a k(Rect rect) {
        return a(this.lZs, rect).equals(this.lZt) ? this : new a(this.lYt, this.lZr, rect);
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public void c(int i, Canvas canvas) {
        com.facebook.imagepipeline.animated.base.c FW = this.lZs.FW(i);
        try {
            if (this.lZs.dmg()) {
                a(canvas, FW);
            } else {
                b(canvas, FW);
            }
        } finally {
            FW.dispose();
        }
    }

    private synchronized void dh(int i, int i2) {
        if (this.lkp != null && (this.lkp.getWidth() < i || this.lkp.getHeight() < i2)) {
            dbB();
        }
        if (this.lkp == null) {
            this.lkp = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        }
        this.lkp.eraseColor(0);
    }

    private void a(Canvas canvas, com.facebook.imagepipeline.animated.base.c cVar) {
        double width = this.lZt.width() / this.lZs.getWidth();
        double height = this.lZt.height() / this.lZs.getHeight();
        int round = (int) Math.round(cVar.getWidth() * width);
        int round2 = (int) Math.round(cVar.getHeight() * height);
        int xOffset = (int) (width * cVar.getXOffset());
        int yOffset = (int) (height * cVar.getYOffset());
        synchronized (this) {
            int width2 = this.lZt.width();
            int height2 = this.lZt.height();
            dh(width2, height2);
            cVar.b(round, round2, this.lkp);
            this.lZx.set(0, 0, width2, height2);
            this.lZy.set(xOffset, yOffset, width2 + xOffset, height2 + yOffset);
            canvas.drawBitmap(this.lkp, this.lZx, this.lZy, (Paint) null);
        }
    }

    private void b(Canvas canvas, com.facebook.imagepipeline.animated.base.c cVar) {
        int width = cVar.getWidth();
        int height = cVar.getHeight();
        int xOffset = cVar.getXOffset();
        int yOffset = cVar.getYOffset();
        synchronized (this) {
            dh(width, height);
            cVar.b(width, height, this.lkp);
            this.lZx.set(0, 0, width, height);
            this.lZy.set(0, 0, width, height);
            canvas.save();
            canvas.translate(xOffset, yOffset);
            canvas.drawBitmap(this.lkp, this.lZx, this.lZy, (Paint) null);
            canvas.restore();
        }
    }

    private synchronized void dbB() {
        if (this.lkp != null) {
            this.lkp.recycle();
            this.lkp = null;
        }
    }
}
