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
    private final int mUG;
    private final com.facebook.imagepipeline.animated.b.a mXO;
    private final d mYM;
    private final com.facebook.imagepipeline.animated.base.b mYN;
    private final Rect mYO;
    private final int[] mYP;
    private final int[] mYQ;
    private final AnimatedDrawableFrameInfo[] mYR;
    private final Rect mYS = new Rect();
    private final Rect mYT = new Rect();
    @GuardedBy("this")
    @Nullable
    private Bitmap mfs;

    public a(com.facebook.imagepipeline.animated.b.a aVar, d dVar, Rect rect) {
        this.mXO = aVar;
        this.mYM = dVar;
        this.mYN = dVar.dFz();
        this.mYP = this.mYN.dBE();
        this.mXO.n(this.mYP);
        this.mUG = this.mXO.o(this.mYP);
        this.mYQ = this.mXO.p(this.mYP);
        this.mYO = a(this.mYN, rect);
        this.mYR = new AnimatedDrawableFrameInfo[this.mYN.getFrameCount()];
        for (int i = 0; i < this.mYN.getFrameCount(); i++) {
            this.mYR[i] = this.mYN.Ik(i);
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
        return this.mYN.getFrameCount();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getLoopCount() {
        return this.mYN.getLoopCount();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getWidth() {
        return this.mYN.getWidth();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getHeight() {
        return this.mYN.getHeight();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int dFx() {
        return this.mYO.width();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int dFy() {
        return this.mYO.height();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public AnimatedDrawableFrameInfo Ik(int i) {
        return this.mYR[i];
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int IW(int i) {
        return this.mYP[i];
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public com.facebook.imagepipeline.animated.base.a k(Rect rect) {
        return a(this.mYN, rect).equals(this.mYO) ? this : new a(this.mXO, this.mYM, rect);
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public void c(int i, Canvas canvas) {
        com.facebook.imagepipeline.animated.base.c Im = this.mYN.Im(i);
        try {
            if (this.mYN.dBF()) {
                a(canvas, Im);
            } else {
                b(canvas, Im);
            }
        } finally {
            Im.dispose();
        }
    }

    private synchronized void dx(int i, int i2) {
        if (this.mfs != null && (this.mfs.getWidth() < i || this.mfs.getHeight() < i2)) {
            dqA();
        }
        if (this.mfs == null) {
            this.mfs = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        }
        this.mfs.eraseColor(0);
    }

    private void a(Canvas canvas, com.facebook.imagepipeline.animated.base.c cVar) {
        double width = this.mYO.width() / this.mYN.getWidth();
        double height = this.mYO.height() / this.mYN.getHeight();
        int round = (int) Math.round(cVar.getWidth() * width);
        int round2 = (int) Math.round(cVar.getHeight() * height);
        int xOffset = (int) (width * cVar.getXOffset());
        int yOffset = (int) (height * cVar.getYOffset());
        synchronized (this) {
            int width2 = this.mYO.width();
            int height2 = this.mYO.height();
            dx(width2, height2);
            cVar.b(round, round2, this.mfs);
            this.mYS.set(0, 0, width2, height2);
            this.mYT.set(xOffset, yOffset, width2 + xOffset, height2 + yOffset);
            canvas.drawBitmap(this.mfs, this.mYS, this.mYT, (Paint) null);
        }
    }

    private void b(Canvas canvas, com.facebook.imagepipeline.animated.base.c cVar) {
        int width = cVar.getWidth();
        int height = cVar.getHeight();
        int xOffset = cVar.getXOffset();
        int yOffset = cVar.getYOffset();
        synchronized (this) {
            dx(width, height);
            cVar.b(width, height, this.mfs);
            this.mYS.set(0, 0, width, height);
            this.mYT.set(0, 0, width, height);
            canvas.save();
            canvas.translate(xOffset, yOffset);
            canvas.drawBitmap(this.mfs, this.mYS, this.mYT, (Paint) null);
            canvas.restore();
        }
    }

    private synchronized void dqA() {
        if (this.mfs != null) {
            this.mfs.recycle();
            this.mfs = null;
        }
    }
}
