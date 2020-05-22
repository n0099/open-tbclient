package com.facebook.imagepipeline.animated.impl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
/* loaded from: classes13.dex */
public class AnimatedImageCompositor {
    private final com.facebook.imagepipeline.animated.base.a mrX;
    private final a mrZ;
    private final Paint mtD = new Paint();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public enum FrameNeededResult {
        REQUIRED,
        NOT_REQUIRED,
        SKIP,
        ABORT
    }

    /* loaded from: classes13.dex */
    public interface a {
        com.facebook.common.references.a<Bitmap> Hr(int i);

        void b(int i, Bitmap bitmap);
    }

    public AnimatedImageCompositor(com.facebook.imagepipeline.animated.base.a aVar, a aVar2) {
        this.mrX = aVar;
        this.mrZ = aVar2;
        this.mtD.setColor(0);
        this.mtD.setStyle(Paint.Style.FILL);
        this.mtD.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
    }

    public void c(int i, Bitmap bitmap) {
        Canvas canvas = new Canvas(bitmap);
        canvas.drawColor(0, PorterDuff.Mode.SRC);
        for (int d = !Hx(i) ? d(i - 1, canvas) : i; d < i; d++) {
            AnimatedDrawableFrameInfo GG = this.mrX.GG(d);
            AnimatedDrawableFrameInfo.DisposalMethod disposalMethod = GG.mte;
            if (disposalMethod != AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_PREVIOUS) {
                if (GG.mtd == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND) {
                    a(canvas, GG);
                }
                this.mrX.c(d, canvas);
                this.mrZ.b(d, bitmap);
                if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
                    a(canvas, GG);
                }
            }
        }
        AnimatedDrawableFrameInfo GG2 = this.mrX.GG(i);
        if (GG2.mtd == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND) {
            a(canvas, GG2);
        }
        this.mrX.c(i, canvas);
    }

    private int d(int i, Canvas canvas) {
        for (int i2 = i; i2 >= 0; i2--) {
            switch (Hw(i2)) {
                case REQUIRED:
                    AnimatedDrawableFrameInfo GG = this.mrX.GG(i2);
                    com.facebook.common.references.a<Bitmap> Hr = this.mrZ.Hr(i2);
                    if (Hr != null) {
                        try {
                            canvas.drawBitmap(Hr.get(), 0.0f, 0.0f, (Paint) null);
                            if (GG.mte == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
                                a(canvas, GG);
                            }
                            return i2 + 1;
                        } finally {
                            Hr.close();
                        }
                    } else if (!Hx(i2)) {
                        break;
                    } else {
                        return i2;
                    }
                case NOT_REQUIRED:
                    return i2 + 1;
                case ABORT:
                    return i2;
            }
        }
        return 0;
    }

    private void a(Canvas canvas, AnimatedDrawableFrameInfo animatedDrawableFrameInfo) {
        canvas.drawRect(animatedDrawableFrameInfo.mtc, animatedDrawableFrameInfo.gEj, animatedDrawableFrameInfo.mtc + animatedDrawableFrameInfo.width, animatedDrawableFrameInfo.gEj + animatedDrawableFrameInfo.height, this.mtD);
    }

    private FrameNeededResult Hw(int i) {
        AnimatedDrawableFrameInfo GG = this.mrX.GG(i);
        AnimatedDrawableFrameInfo.DisposalMethod disposalMethod = GG.mte;
        if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_DO_NOT) {
            return FrameNeededResult.REQUIRED;
        }
        if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
            if (a(GG)) {
                return FrameNeededResult.NOT_REQUIRED;
            }
            return FrameNeededResult.REQUIRED;
        } else if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_PREVIOUS) {
            return FrameNeededResult.SKIP;
        } else {
            return FrameNeededResult.ABORT;
        }
    }

    private boolean Hx(int i) {
        if (i == 0) {
            return true;
        }
        AnimatedDrawableFrameInfo GG = this.mrX.GG(i);
        AnimatedDrawableFrameInfo GG2 = this.mrX.GG(i - 1);
        if (GG.mtd == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND && a(GG)) {
            return true;
        }
        return GG2.mte == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND && a(GG2);
    }

    private boolean a(AnimatedDrawableFrameInfo animatedDrawableFrameInfo) {
        return animatedDrawableFrameInfo.mtc == 0 && animatedDrawableFrameInfo.gEj == 0 && animatedDrawableFrameInfo.width == this.mrX.dxq() && animatedDrawableFrameInfo.height == this.mrX.dxr();
    }
}
