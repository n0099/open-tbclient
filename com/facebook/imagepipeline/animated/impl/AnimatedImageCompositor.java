package com.facebook.imagepipeline.animated.impl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
/* loaded from: classes13.dex */
public class AnimatedImageCompositor {
    private final com.facebook.imagepipeline.animated.base.a lOB;
    private final a lOD;
    private final Paint mTransparentFillPaint = new Paint();

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
        com.facebook.common.references.a<Bitmap> HY(int i);

        void c(int i, Bitmap bitmap);
    }

    public AnimatedImageCompositor(com.facebook.imagepipeline.animated.base.a aVar, a aVar2) {
        this.lOB = aVar;
        this.lOD = aVar2;
        this.mTransparentFillPaint.setColor(0);
        this.mTransparentFillPaint.setStyle(Paint.Style.FILL);
        this.mTransparentFillPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
    }

    public void d(int i, Bitmap bitmap) {
        Canvas canvas = new Canvas(bitmap);
        canvas.drawColor(0, PorterDuff.Mode.SRC);
        for (int c = !isKeyFrame(i) ? c(i - 1, canvas) : i; c < i; c++) {
            AnimatedDrawableFrameInfo Hn = this.lOB.Hn(c);
            AnimatedDrawableFrameInfo.DisposalMethod disposalMethod = Hn.lPF;
            if (disposalMethod != AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_PREVIOUS) {
                if (Hn.lPE == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND) {
                    a(canvas, Hn);
                }
                this.lOB.renderFrame(c, canvas);
                this.lOD.c(c, bitmap);
                if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
                    a(canvas, Hn);
                }
            }
        }
        AnimatedDrawableFrameInfo Hn2 = this.lOB.Hn(i);
        if (Hn2.lPE == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND) {
            a(canvas, Hn2);
        }
        this.lOB.renderFrame(i, canvas);
    }

    private int c(int i, Canvas canvas) {
        for (int i2 = i; i2 >= 0; i2--) {
            switch (Id(i2)) {
                case REQUIRED:
                    AnimatedDrawableFrameInfo Hn = this.lOB.Hn(i2);
                    com.facebook.common.references.a<Bitmap> HY = this.lOD.HY(i2);
                    if (HY != null) {
                        try {
                            canvas.drawBitmap(HY.get(), 0.0f, 0.0f, (Paint) null);
                            if (Hn.lPF == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
                                a(canvas, Hn);
                            }
                            return i2 + 1;
                        } finally {
                            HY.close();
                        }
                    } else if (!isKeyFrame(i2)) {
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
        canvas.drawRect(animatedDrawableFrameInfo.xOffset, animatedDrawableFrameInfo.yOffset, animatedDrawableFrameInfo.xOffset + animatedDrawableFrameInfo.width, animatedDrawableFrameInfo.yOffset + animatedDrawableFrameInfo.height, this.mTransparentFillPaint);
    }

    private FrameNeededResult Id(int i) {
        AnimatedDrawableFrameInfo Hn = this.lOB.Hn(i);
        AnimatedDrawableFrameInfo.DisposalMethod disposalMethod = Hn.lPF;
        if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_DO_NOT) {
            return FrameNeededResult.REQUIRED;
        }
        if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
            if (a(Hn)) {
                return FrameNeededResult.NOT_REQUIRED;
            }
            return FrameNeededResult.REQUIRED;
        } else if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_PREVIOUS) {
            return FrameNeededResult.SKIP;
        } else {
            return FrameNeededResult.ABORT;
        }
    }

    private boolean isKeyFrame(int i) {
        if (i == 0) {
            return true;
        }
        AnimatedDrawableFrameInfo Hn = this.lOB.Hn(i);
        AnimatedDrawableFrameInfo Hn2 = this.lOB.Hn(i - 1);
        if (Hn.lPE == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND && a(Hn)) {
            return true;
        }
        return Hn2.lPF == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND && a(Hn2);
    }

    private boolean a(AnimatedDrawableFrameInfo animatedDrawableFrameInfo) {
        return animatedDrawableFrameInfo.xOffset == 0 && animatedDrawableFrameInfo.yOffset == 0 && animatedDrawableFrameInfo.width == this.lOB.dnD() && animatedDrawableFrameInfo.height == this.lOB.dnE();
    }
}
