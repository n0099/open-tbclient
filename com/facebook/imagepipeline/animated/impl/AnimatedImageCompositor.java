package com.facebook.imagepipeline.animated.impl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
/* loaded from: classes3.dex */
public class AnimatedImageCompositor {
    private final com.facebook.imagepipeline.animated.base.a nrB;
    private final a nrD;
    private final Paint ntf = new Paint();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public enum FrameNeededResult {
        REQUIRED,
        NOT_REQUIRED,
        SKIP,
        ABORT
    }

    /* loaded from: classes3.dex */
    public interface a {
        com.facebook.common.references.a<Bitmap> Lz(int i);

        void b(int i, Bitmap bitmap);
    }

    public AnimatedImageCompositor(com.facebook.imagepipeline.animated.base.a aVar, a aVar2) {
        this.nrB = aVar;
        this.nrD = aVar2;
        this.ntf.setColor(0);
        this.ntf.setStyle(Paint.Style.FILL);
        this.ntf.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
    }

    public void c(int i, Bitmap bitmap) {
        Canvas canvas = new Canvas(bitmap);
        canvas.drawColor(0, PorterDuff.Mode.SRC);
        for (int d = !LF(i) ? d(i - 1, canvas) : i; d < i; d++) {
            AnimatedDrawableFrameInfo KO = this.nrB.KO(d);
            AnimatedDrawableFrameInfo.DisposalMethod disposalMethod = KO.nsH;
            if (disposalMethod != AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_PREVIOUS) {
                if (KO.nsG == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND) {
                    a(canvas, KO);
                }
                this.nrB.c(d, canvas);
                this.nrD.b(d, bitmap);
                if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
                    a(canvas, KO);
                }
            }
        }
        AnimatedDrawableFrameInfo KO2 = this.nrB.KO(i);
        if (KO2.nsG == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND) {
            a(canvas, KO2);
        }
        this.nrB.c(i, canvas);
    }

    private int d(int i, Canvas canvas) {
        for (int i2 = i; i2 >= 0; i2--) {
            switch (LE(i2)) {
                case REQUIRED:
                    AnimatedDrawableFrameInfo KO = this.nrB.KO(i2);
                    com.facebook.common.references.a<Bitmap> Lz = this.nrD.Lz(i2);
                    if (Lz != null) {
                        try {
                            canvas.drawBitmap(Lz.get(), 0.0f, 0.0f, (Paint) null);
                            if (KO.nsH == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
                                a(canvas, KO);
                            }
                            return i2 + 1;
                        } finally {
                            Lz.close();
                        }
                    } else if (!LF(i2)) {
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
        canvas.drawRect(animatedDrawableFrameInfo.nsF, animatedDrawableFrameInfo.hjM, animatedDrawableFrameInfo.nsF + animatedDrawableFrameInfo.width, animatedDrawableFrameInfo.hjM + animatedDrawableFrameInfo.height, this.ntf);
    }

    private FrameNeededResult LE(int i) {
        AnimatedDrawableFrameInfo KO = this.nrB.KO(i);
        AnimatedDrawableFrameInfo.DisposalMethod disposalMethod = KO.nsH;
        if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_DO_NOT) {
            return FrameNeededResult.REQUIRED;
        }
        if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
            if (a(KO)) {
                return FrameNeededResult.NOT_REQUIRED;
            }
            return FrameNeededResult.REQUIRED;
        } else if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_PREVIOUS) {
            return FrameNeededResult.SKIP;
        } else {
            return FrameNeededResult.ABORT;
        }
    }

    private boolean LF(int i) {
        if (i == 0) {
            return true;
        }
        AnimatedDrawableFrameInfo KO = this.nrB.KO(i);
        AnimatedDrawableFrameInfo KO2 = this.nrB.KO(i - 1);
        if (KO.nsG == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND && a(KO)) {
            return true;
        }
        return KO2.nsH == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND && a(KO2);
    }

    private boolean a(AnimatedDrawableFrameInfo animatedDrawableFrameInfo) {
        return animatedDrawableFrameInfo.nsF == 0 && animatedDrawableFrameInfo.hjM == 0 && animatedDrawableFrameInfo.width == this.nrB.dRF() && animatedDrawableFrameInfo.height == this.nrB.dRG();
    }
}
