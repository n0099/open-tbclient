package com.facebook.imagepipeline.animated.impl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
import com.facebook.imagepipeline.animated.base.d;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes10.dex */
public class a implements com.facebook.imagepipeline.animated.base.a {
    @GuardedBy("this")
    @Nullable
    private Bitmap nqx;
    private final int oQv;
    private final com.facebook.imagepipeline.animated.b.a oTA;
    private final Rect oUA;
    private final int[] oUB;
    private final int[] oUC;
    private final AnimatedDrawableFrameInfo[] oUD;
    private final Rect oUE = new Rect();
    private final Rect oUF = new Rect();
    private final d oUy;
    private final com.facebook.imagepipeline.animated.base.b oUz;

    public a(com.facebook.imagepipeline.animated.b.a aVar, d dVar, Rect rect) {
        this.oTA = aVar;
        this.oUy = dVar;
        this.oUz = dVar.enb();
        this.oUB = this.oUz.ejh();
        this.oTA.s(this.oUB);
        this.oQv = this.oTA.t(this.oUB);
        this.oUC = this.oTA.u(this.oUB);
        this.oUA = a(this.oUz, rect);
        this.oUD = new AnimatedDrawableFrameInfo[this.oUz.getFrameCount()];
        for (int i = 0; i < this.oUz.getFrameCount(); i++) {
            this.oUD[i] = this.oUz.OO(i);
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
        return this.oUz.getFrameCount();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getLoopCount() {
        return this.oUz.getLoopCount();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getWidth() {
        return this.oUz.getWidth();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getHeight() {
        return this.oUz.getHeight();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int emZ() {
        return this.oUA.width();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int ena() {
        return this.oUA.height();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public AnimatedDrawableFrameInfo OO(int i) {
        return this.oUD[i];
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int PA(int i) {
        return this.oUB[i];
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public com.facebook.imagepipeline.animated.base.a m(Rect rect) {
        return a(this.oUz, rect).equals(this.oUA) ? this : new a(this.oTA, this.oUy, rect);
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public void c(int i, Canvas canvas) {
        com.facebook.imagepipeline.animated.base.c OQ = this.oUz.OQ(i);
        try {
            if (this.oUz.eji()) {
                a(canvas, OQ);
            } else {
                b(canvas, OQ);
            }
        } finally {
            OQ.dispose();
        }
    }

    private synchronized void dW(int i, int i2) {
        if (this.nqx != null && (this.nqx.getWidth() < i || this.nqx.getHeight() < i2)) {
            dPt();
        }
        if (this.nqx == null) {
            this.nqx = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        }
        this.nqx.eraseColor(0);
    }

    private void a(Canvas canvas, com.facebook.imagepipeline.animated.base.c cVar) {
        double width = this.oUA.width() / this.oUz.getWidth();
        double height = this.oUA.height() / this.oUz.getHeight();
        int round = (int) Math.round(cVar.getWidth() * width);
        int round2 = (int) Math.round(cVar.getHeight() * height);
        int xOffset = (int) (width * cVar.getXOffset());
        int yOffset = (int) (height * cVar.getYOffset());
        synchronized (this) {
            int width2 = this.oUA.width();
            int height2 = this.oUA.height();
            dW(width2, height2);
            cVar.b(round, round2, this.nqx);
            this.oUE.set(0, 0, width2, height2);
            this.oUF.set(xOffset, yOffset, width2 + xOffset, height2 + yOffset);
            canvas.drawBitmap(this.nqx, this.oUE, this.oUF, (Paint) null);
        }
    }

    private void b(Canvas canvas, com.facebook.imagepipeline.animated.base.c cVar) {
        int width = cVar.getWidth();
        int height = cVar.getHeight();
        int xOffset = cVar.getXOffset();
        int yOffset = cVar.getYOffset();
        synchronized (this) {
            dW(width, height);
            cVar.b(width, height, this.nqx);
            this.oUE.set(0, 0, width, height);
            this.oUF.set(0, 0, width, height);
            canvas.save();
            canvas.translate(xOffset, yOffset);
            canvas.drawBitmap(this.nqx, this.oUE, this.oUF, (Paint) null);
            canvas.restore();
        }
    }

    private synchronized void dPt() {
        if (this.nqx != null) {
            this.nqx.recycle();
            this.nqx = null;
        }
    }
}
