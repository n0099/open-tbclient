package com.facebook.imagepipeline.animated.impl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
/* loaded from: classes13.dex */
public class AnimatedImageCompositor {
    private final com.facebook.imagepipeline.animated.base.a lXZ;
    private final a lYb;
    private final Paint lZE = new Paint();

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
        com.facebook.common.references.a<Bitmap> GF(int i);

        void b(int i, Bitmap bitmap);
    }

    public AnimatedImageCompositor(com.facebook.imagepipeline.animated.base.a aVar, a aVar2) {
        this.lXZ = aVar;
        this.lYb = aVar2;
        this.lZE.setColor(0);
        this.lZE.setStyle(Paint.Style.FILL);
        this.lZE.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
    }

    public void c(int i, Bitmap bitmap) {
        Canvas canvas = new Canvas(bitmap);
        canvas.drawColor(0, PorterDuff.Mode.SRC);
        for (int d = !GL(i) ? d(i - 1, canvas) : i; d < i; d++) {
            AnimatedDrawableFrameInfo FU = this.lXZ.FU(d);
            AnimatedDrawableFrameInfo.DisposalMethod disposalMethod = FU.lZf;
            if (disposalMethod != AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_PREVIOUS) {
                if (FU.lZe == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND) {
                    a(canvas, FU);
                }
                this.lXZ.c(d, canvas);
                this.lYb.b(d, bitmap);
                if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
                    a(canvas, FU);
                }
            }
        }
        AnimatedDrawableFrameInfo FU2 = this.lXZ.FU(i);
        if (FU2.lZe == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND) {
            a(canvas, FU2);
        }
        this.lXZ.c(i, canvas);
    }

    private int d(int i, Canvas canvas) {
        for (int i2 = i; i2 >= 0; i2--) {
            switch (GK(i2)) {
                case REQUIRED:
                    AnimatedDrawableFrameInfo FU = this.lXZ.FU(i2);
                    com.facebook.common.references.a<Bitmap> GF = this.lYb.GF(i2);
                    if (GF != null) {
                        try {
                            canvas.drawBitmap(GF.get(), 0.0f, 0.0f, (Paint) null);
                            if (FU.lZf == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
                                a(canvas, FU);
                            }
                            return i2 + 1;
                        } finally {
                            GF.close();
                        }
                    } else if (!GL(i2)) {
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
        canvas.drawRect(animatedDrawableFrameInfo.lZd, animatedDrawableFrameInfo.gpo, animatedDrawableFrameInfo.lZd + animatedDrawableFrameInfo.width, animatedDrawableFrameInfo.gpo + animatedDrawableFrameInfo.height, this.lZE);
    }

    private FrameNeededResult GK(int i) {
        AnimatedDrawableFrameInfo FU = this.lXZ.FU(i);
        AnimatedDrawableFrameInfo.DisposalMethod disposalMethod = FU.lZf;
        if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_DO_NOT) {
            return FrameNeededResult.REQUIRED;
        }
        if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
            if (a(FU)) {
                return FrameNeededResult.NOT_REQUIRED;
            }
            return FrameNeededResult.REQUIRED;
        } else if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_PREVIOUS) {
            return FrameNeededResult.SKIP;
        } else {
            return FrameNeededResult.ABORT;
        }
    }

    private boolean GL(int i) {
        if (i == 0) {
            return true;
        }
        AnimatedDrawableFrameInfo FU = this.lXZ.FU(i);
        AnimatedDrawableFrameInfo FU2 = this.lXZ.FU(i - 1);
        if (FU.lZe == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND && a(FU)) {
            return true;
        }
        return FU2.lZf == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND && a(FU2);
    }

    private boolean a(AnimatedDrawableFrameInfo animatedDrawableFrameInfo) {
        return animatedDrawableFrameInfo.lZd == 0 && animatedDrawableFrameInfo.gpo == 0 && animatedDrawableFrameInfo.width == this.lXZ.dqa() && animatedDrawableFrameInfo.height == this.lXZ.dqb();
    }
}
