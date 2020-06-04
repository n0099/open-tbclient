package com.facebook.imagepipeline.animated.impl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
/* loaded from: classes13.dex */
public class AnimatedImageCompositor {
    private final com.facebook.imagepipeline.animated.base.a mti;
    private final a mtk;
    private final Paint muN = new Paint();

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
        com.facebook.common.references.a<Bitmap> Ht(int i);

        void b(int i, Bitmap bitmap);
    }

    public AnimatedImageCompositor(com.facebook.imagepipeline.animated.base.a aVar, a aVar2) {
        this.mti = aVar;
        this.mtk = aVar2;
        this.muN.setColor(0);
        this.muN.setStyle(Paint.Style.FILL);
        this.muN.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
    }

    public void c(int i, Bitmap bitmap) {
        Canvas canvas = new Canvas(bitmap);
        canvas.drawColor(0, PorterDuff.Mode.SRC);
        for (int d = !Hz(i) ? d(i - 1, canvas) : i; d < i; d++) {
            AnimatedDrawableFrameInfo GI = this.mti.GI(d);
            AnimatedDrawableFrameInfo.DisposalMethod disposalMethod = GI.muo;
            if (disposalMethod != AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_PREVIOUS) {
                if (GI.mun == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND) {
                    a(canvas, GI);
                }
                this.mti.c(d, canvas);
                this.mtk.b(d, bitmap);
                if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
                    a(canvas, GI);
                }
            }
        }
        AnimatedDrawableFrameInfo GI2 = this.mti.GI(i);
        if (GI2.mun == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND) {
            a(canvas, GI2);
        }
        this.mti.c(i, canvas);
    }

    private int d(int i, Canvas canvas) {
        for (int i2 = i; i2 >= 0; i2--) {
            switch (Hy(i2)) {
                case REQUIRED:
                    AnimatedDrawableFrameInfo GI = this.mti.GI(i2);
                    com.facebook.common.references.a<Bitmap> Ht = this.mtk.Ht(i2);
                    if (Ht != null) {
                        try {
                            canvas.drawBitmap(Ht.get(), 0.0f, 0.0f, (Paint) null);
                            if (GI.muo == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
                                a(canvas, GI);
                            }
                            return i2 + 1;
                        } finally {
                            Ht.close();
                        }
                    } else if (!Hz(i2)) {
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
        canvas.drawRect(animatedDrawableFrameInfo.mum, animatedDrawableFrameInfo.gEu, animatedDrawableFrameInfo.mum + animatedDrawableFrameInfo.width, animatedDrawableFrameInfo.gEu + animatedDrawableFrameInfo.height, this.muN);
    }

    private FrameNeededResult Hy(int i) {
        AnimatedDrawableFrameInfo GI = this.mti.GI(i);
        AnimatedDrawableFrameInfo.DisposalMethod disposalMethod = GI.muo;
        if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_DO_NOT) {
            return FrameNeededResult.REQUIRED;
        }
        if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
            if (a(GI)) {
                return FrameNeededResult.NOT_REQUIRED;
            }
            return FrameNeededResult.REQUIRED;
        } else if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_PREVIOUS) {
            return FrameNeededResult.SKIP;
        } else {
            return FrameNeededResult.ABORT;
        }
    }

    private boolean Hz(int i) {
        if (i == 0) {
            return true;
        }
        AnimatedDrawableFrameInfo GI = this.mti.GI(i);
        AnimatedDrawableFrameInfo GI2 = this.mti.GI(i - 1);
        if (GI.mun == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND && a(GI)) {
            return true;
        }
        return GI2.muo == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND && a(GI2);
    }

    private boolean a(AnimatedDrawableFrameInfo animatedDrawableFrameInfo) {
        return animatedDrawableFrameInfo.mum == 0 && animatedDrawableFrameInfo.gEu == 0 && animatedDrawableFrameInfo.width == this.mti.dxE() && animatedDrawableFrameInfo.height == this.mti.dxF();
    }
}
