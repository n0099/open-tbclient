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
    private Bitmap lDe;
    private final int mpj;
    private final com.facebook.imagepipeline.animated.b.a mss;
    private final d mtq;
    private final com.facebook.imagepipeline.animated.base.b mtr;
    private final Rect mts;
    private final int[] mtt;
    private final int[] mtu;
    private final AnimatedDrawableFrameInfo[] mtv;
    private final Rect mtw = new Rect();
    private final Rect mtx = new Rect();

    public a(com.facebook.imagepipeline.animated.b.a aVar, d dVar, Rect rect) {
        this.mss = aVar;
        this.mtq = dVar;
        this.mtr = dVar.dxs();
        this.mtt = this.mtr.dtw();
        this.mss.n(this.mtt);
        this.mpj = this.mss.o(this.mtt);
        this.mtu = this.mss.p(this.mtt);
        this.mts = a(this.mtr, rect);
        this.mtv = new AnimatedDrawableFrameInfo[this.mtr.getFrameCount()];
        for (int i = 0; i < this.mtr.getFrameCount(); i++) {
            this.mtv[i] = this.mtr.GG(i);
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
        return this.mtr.getFrameCount();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getLoopCount() {
        return this.mtr.getLoopCount();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getWidth() {
        return this.mtr.getWidth();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getHeight() {
        return this.mtr.getHeight();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int dxq() {
        return this.mts.width();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int dxr() {
        return this.mts.height();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public AnimatedDrawableFrameInfo GG(int i) {
        return this.mtv[i];
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int Hs(int i) {
        return this.mtt[i];
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public com.facebook.imagepipeline.animated.base.a k(Rect rect) {
        return a(this.mtr, rect).equals(this.mts) ? this : new a(this.mss, this.mtq, rect);
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public void c(int i, Canvas canvas) {
        com.facebook.imagepipeline.animated.base.c GI = this.mtr.GI(i);
        try {
            if (this.mtr.dtx()) {
                a(canvas, GI);
            } else {
                b(canvas, GI);
            }
        } finally {
            GI.dispose();
        }
    }

    private synchronized void dm(int i, int i2) {
        if (this.lDe != null && (this.lDe.getWidth() < i || this.lDe.getHeight() < i2)) {
            diN();
        }
        if (this.lDe == null) {
            this.lDe = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        }
        this.lDe.eraseColor(0);
    }

    private void a(Canvas canvas, com.facebook.imagepipeline.animated.base.c cVar) {
        double width = this.mts.width() / this.mtr.getWidth();
        double height = this.mts.height() / this.mtr.getHeight();
        int round = (int) Math.round(cVar.getWidth() * width);
        int round2 = (int) Math.round(cVar.getHeight() * height);
        int xOffset = (int) (width * cVar.getXOffset());
        int yOffset = (int) (height * cVar.getYOffset());
        synchronized (this) {
            int width2 = this.mts.width();
            int height2 = this.mts.height();
            dm(width2, height2);
            cVar.b(round, round2, this.lDe);
            this.mtw.set(0, 0, width2, height2);
            this.mtx.set(xOffset, yOffset, width2 + xOffset, height2 + yOffset);
            canvas.drawBitmap(this.lDe, this.mtw, this.mtx, (Paint) null);
        }
    }

    private void b(Canvas canvas, com.facebook.imagepipeline.animated.base.c cVar) {
        int width = cVar.getWidth();
        int height = cVar.getHeight();
        int xOffset = cVar.getXOffset();
        int yOffset = cVar.getYOffset();
        synchronized (this) {
            dm(width, height);
            cVar.b(width, height, this.lDe);
            this.mtw.set(0, 0, width, height);
            this.mtx.set(0, 0, width, height);
            canvas.save();
            canvas.translate(xOffset, yOffset);
            canvas.drawBitmap(this.lDe, this.mtw, this.mtx, (Paint) null);
            canvas.restore();
        }
    }

    private synchronized void diN() {
        if (this.lDe != null) {
            this.lDe.recycle();
            this.lDe = null;
        }
    }
}
