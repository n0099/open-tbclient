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
    private Bitmap lXZ;
    private final int mMv;
    private final com.facebook.imagepipeline.animated.b.a mPE;
    private final d mQC;
    private final com.facebook.imagepipeline.animated.base.b mQD;
    private final Rect mQE;
    private final int[] mQF;
    private final int[] mQG;
    private final AnimatedDrawableFrameInfo[] mQH;
    private final Rect mQI = new Rect();
    private final Rect mQJ = new Rect();

    public a(com.facebook.imagepipeline.animated.b.a aVar, d dVar, Rect rect) {
        this.mPE = aVar;
        this.mQC = dVar;
        this.mQD = dVar.dCm();
        this.mQF = this.mQD.dyr();
        this.mPE.n(this.mQF);
        this.mMv = this.mPE.o(this.mQF);
        this.mQG = this.mPE.p(this.mQF);
        this.mQE = a(this.mQD, rect);
        this.mQH = new AnimatedDrawableFrameInfo[this.mQD.getFrameCount()];
        for (int i = 0; i < this.mQD.getFrameCount(); i++) {
            this.mQH[i] = this.mQD.HP(i);
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
        return this.mQD.getFrameCount();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getLoopCount() {
        return this.mQD.getLoopCount();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getWidth() {
        return this.mQD.getWidth();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getHeight() {
        return this.mQD.getHeight();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int dCk() {
        return this.mQE.width();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int dCl() {
        return this.mQE.height();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public AnimatedDrawableFrameInfo HP(int i) {
        return this.mQH[i];
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int IB(int i) {
        return this.mQF[i];
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public com.facebook.imagepipeline.animated.base.a k(Rect rect) {
        return a(this.mQD, rect).equals(this.mQE) ? this : new a(this.mPE, this.mQC, rect);
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public void c(int i, Canvas canvas) {
        com.facebook.imagepipeline.animated.base.c HR = this.mQD.HR(i);
        try {
            if (this.mQD.dys()) {
                a(canvas, HR);
            } else {
                b(canvas, HR);
            }
        } finally {
            HR.dispose();
        }
    }

    private synchronized void dv(int i, int i2) {
        if (this.lXZ != null && (this.lXZ.getWidth() < i || this.lXZ.getHeight() < i2)) {
            dnp();
        }
        if (this.lXZ == null) {
            this.lXZ = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        }
        this.lXZ.eraseColor(0);
    }

    private void a(Canvas canvas, com.facebook.imagepipeline.animated.base.c cVar) {
        double width = this.mQE.width() / this.mQD.getWidth();
        double height = this.mQE.height() / this.mQD.getHeight();
        int round = (int) Math.round(cVar.getWidth() * width);
        int round2 = (int) Math.round(cVar.getHeight() * height);
        int xOffset = (int) (width * cVar.getXOffset());
        int yOffset = (int) (height * cVar.getYOffset());
        synchronized (this) {
            int width2 = this.mQE.width();
            int height2 = this.mQE.height();
            dv(width2, height2);
            cVar.b(round, round2, this.lXZ);
            this.mQI.set(0, 0, width2, height2);
            this.mQJ.set(xOffset, yOffset, width2 + xOffset, height2 + yOffset);
            canvas.drawBitmap(this.lXZ, this.mQI, this.mQJ, (Paint) null);
        }
    }

    private void b(Canvas canvas, com.facebook.imagepipeline.animated.base.c cVar) {
        int width = cVar.getWidth();
        int height = cVar.getHeight();
        int xOffset = cVar.getXOffset();
        int yOffset = cVar.getYOffset();
        synchronized (this) {
            dv(width, height);
            cVar.b(width, height, this.lXZ);
            this.mQI.set(0, 0, width, height);
            this.mQJ.set(0, 0, width, height);
            canvas.save();
            canvas.translate(xOffset, yOffset);
            canvas.drawBitmap(this.lXZ, this.mQI, this.mQJ, (Paint) null);
            canvas.restore();
        }
    }

    private synchronized void dnp() {
        if (this.lXZ != null) {
            this.lXZ.recycle();
            this.lXZ = null;
        }
    }
}
