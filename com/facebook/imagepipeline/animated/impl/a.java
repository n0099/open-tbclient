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
    private Bitmap mWT;
    private final int nOf;
    private final com.facebook.imagepipeline.animated.b.a nRm;
    private final d nSk;
    private final com.facebook.imagepipeline.animated.base.b nSl;
    private final Rect nSm;
    private final int[] nSn;
    private final int[] nSo;
    private final AnimatedDrawableFrameInfo[] nSp;
    private final Rect nSq = new Rect();
    private final Rect nSr = new Rect();

    public a(com.facebook.imagepipeline.animated.b.a aVar, d dVar, Rect rect) {
        this.nRm = aVar;
        this.nSk = dVar;
        this.nSl = dVar.dZq();
        this.nSn = this.nSl.dVw();
        this.nRm.n(this.nSn);
        this.nOf = this.nRm.o(this.nSn);
        this.nSo = this.nRm.p(this.nSn);
        this.nSm = a(this.nSl, rect);
        this.nSp = new AnimatedDrawableFrameInfo[this.nSl.getFrameCount()];
        for (int i = 0; i < this.nSl.getFrameCount(); i++) {
            this.nSp[i] = this.nSl.LZ(i);
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
        return this.nSl.getFrameCount();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getLoopCount() {
        return this.nSl.getLoopCount();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getWidth() {
        return this.nSl.getWidth();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getHeight() {
        return this.nSl.getHeight();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int dZo() {
        return this.nSm.width();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int dZp() {
        return this.nSm.height();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public AnimatedDrawableFrameInfo LZ(int i) {
        return this.nSp[i];
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int ML(int i) {
        return this.nSn[i];
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public com.facebook.imagepipeline.animated.base.a k(Rect rect) {
        return a(this.nSl, rect).equals(this.nSm) ? this : new a(this.nRm, this.nSk, rect);
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public void c(int i, Canvas canvas) {
        com.facebook.imagepipeline.animated.base.c Mb = this.nSl.Mb(i);
        try {
            if (this.nSl.dVx()) {
                a(canvas, Mb);
            } else {
                b(canvas, Mb);
            }
        } finally {
            Mb.dispose();
        }
    }

    private synchronized void dJ(int i, int i2) {
        if (this.mWT != null && (this.mWT.getWidth() < i || this.mWT.getHeight() < i2)) {
            dJK();
        }
        if (this.mWT == null) {
            this.mWT = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        }
        this.mWT.eraseColor(0);
    }

    private void a(Canvas canvas, com.facebook.imagepipeline.animated.base.c cVar) {
        double width = this.nSm.width() / this.nSl.getWidth();
        double height = this.nSm.height() / this.nSl.getHeight();
        int round = (int) Math.round(cVar.getWidth() * width);
        int round2 = (int) Math.round(cVar.getHeight() * height);
        int xOffset = (int) (width * cVar.getXOffset());
        int yOffset = (int) (height * cVar.getYOffset());
        synchronized (this) {
            int width2 = this.nSm.width();
            int height2 = this.nSm.height();
            dJ(width2, height2);
            cVar.b(round, round2, this.mWT);
            this.nSq.set(0, 0, width2, height2);
            this.nSr.set(xOffset, yOffset, width2 + xOffset, height2 + yOffset);
            canvas.drawBitmap(this.mWT, this.nSq, this.nSr, (Paint) null);
        }
    }

    private void b(Canvas canvas, com.facebook.imagepipeline.animated.base.c cVar) {
        int width = cVar.getWidth();
        int height = cVar.getHeight();
        int xOffset = cVar.getXOffset();
        int yOffset = cVar.getYOffset();
        synchronized (this) {
            dJ(width, height);
            cVar.b(width, height, this.mWT);
            this.nSq.set(0, 0, width, height);
            this.nSr.set(0, 0, width, height);
            canvas.save();
            canvas.translate(xOffset, yOffset);
            canvas.drawBitmap(this.mWT, this.nSq, this.nSr, (Paint) null);
            canvas.restore();
        }
    }

    private synchronized void dJK() {
        if (this.mWT != null) {
            this.mWT.recycle();
            this.mWT = null;
        }
    }
}
