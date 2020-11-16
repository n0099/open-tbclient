package com.facebook.imagepipeline.animated.impl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
/* loaded from: classes10.dex */
public class AnimatedImageCompositor {
    private final com.facebook.imagepipeline.animated.base.a oTg;
    private final a oTi;
    private final Paint oUK = new Paint();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public enum FrameNeededResult {
        REQUIRED,
        NOT_REQUIRED,
        SKIP,
        ABORT
    }

    /* loaded from: classes10.dex */
    public interface a {
        com.facebook.common.references.a<Bitmap> Pz(int i);

        void c(int i, Bitmap bitmap);
    }

    public AnimatedImageCompositor(com.facebook.imagepipeline.animated.base.a aVar, a aVar2) {
        this.oTg = aVar;
        this.oTi = aVar2;
        this.oUK.setColor(0);
        this.oUK.setStyle(Paint.Style.FILL);
        this.oUK.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
    }

    public void d(int i, Bitmap bitmap) {
        Canvas canvas = new Canvas(bitmap);
        canvas.drawColor(0, PorterDuff.Mode.SRC);
        for (int d = !PF(i) ? d(i - 1, canvas) : i; d < i; d++) {
            AnimatedDrawableFrameInfo OO = this.oTg.OO(d);
            AnimatedDrawableFrameInfo.DisposalMethod disposalMethod = OO.oUm;
            if (disposalMethod != AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_PREVIOUS) {
                if (OO.oUl == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND) {
                    a(canvas, OO);
                }
                this.oTg.c(d, canvas);
                this.oTi.c(d, bitmap);
                if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
                    a(canvas, OO);
                }
            }
        }
        AnimatedDrawableFrameInfo OO2 = this.oTg.OO(i);
        if (OO2.oUl == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND) {
            a(canvas, OO2);
        }
        this.oTg.c(i, canvas);
    }

    private int d(int i, Canvas canvas) {
        for (int i2 = i; i2 >= 0; i2--) {
            switch (PE(i2)) {
                case REQUIRED:
                    AnimatedDrawableFrameInfo OO = this.oTg.OO(i2);
                    com.facebook.common.references.a<Bitmap> Pz = this.oTi.Pz(i2);
                    if (Pz != null) {
                        try {
                            canvas.drawBitmap(Pz.get(), 0.0f, 0.0f, (Paint) null);
                            if (OO.oUm == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
                                a(canvas, OO);
                            }
                            return i2 + 1;
                        } finally {
                            Pz.close();
                        }
                    } else if (!PF(i2)) {
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
        canvas.drawRect(animatedDrawableFrameInfo.oUk, animatedDrawableFrameInfo.hYD, animatedDrawableFrameInfo.oUk + animatedDrawableFrameInfo.width, animatedDrawableFrameInfo.hYD + animatedDrawableFrameInfo.height, this.oUK);
    }

    private FrameNeededResult PE(int i) {
        AnimatedDrawableFrameInfo OO = this.oTg.OO(i);
        AnimatedDrawableFrameInfo.DisposalMethod disposalMethod = OO.oUm;
        if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_DO_NOT) {
            return FrameNeededResult.REQUIRED;
        }
        if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
            if (a(OO)) {
                return FrameNeededResult.NOT_REQUIRED;
            }
            return FrameNeededResult.REQUIRED;
        } else if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_PREVIOUS) {
            return FrameNeededResult.SKIP;
        } else {
            return FrameNeededResult.ABORT;
        }
    }

    private boolean PF(int i) {
        if (i == 0) {
            return true;
        }
        AnimatedDrawableFrameInfo OO = this.oTg.OO(i);
        AnimatedDrawableFrameInfo OO2 = this.oTg.OO(i - 1);
        if (OO.oUl == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND && a(OO)) {
            return true;
        }
        return OO2.oUm == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND && a(OO2);
    }

    private boolean a(AnimatedDrawableFrameInfo animatedDrawableFrameInfo) {
        return animatedDrawableFrameInfo.oUk == 0 && animatedDrawableFrameInfo.hYD == 0 && animatedDrawableFrameInfo.width == this.oTg.emZ() && animatedDrawableFrameInfo.height == this.oTg.ena();
    }
}
