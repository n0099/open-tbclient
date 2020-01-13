package com.facebook.imagepipeline.animated.impl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
/* loaded from: classes12.dex */
public class AnimatedImageCompositor {
    private final com.facebook.imagepipeline.animated.base.a lNP;
    private final a lNR;
    private final Paint mTransparentFillPaint = new Paint();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public enum FrameNeededResult {
        REQUIRED,
        NOT_REQUIRED,
        SKIP,
        ABORT
    }

    /* loaded from: classes12.dex */
    public interface a {
        com.facebook.common.references.a<Bitmap> HT(int i);

        void c(int i, Bitmap bitmap);
    }

    public AnimatedImageCompositor(com.facebook.imagepipeline.animated.base.a aVar, a aVar2) {
        this.lNP = aVar;
        this.lNR = aVar2;
        this.mTransparentFillPaint.setColor(0);
        this.mTransparentFillPaint.setStyle(Paint.Style.FILL);
        this.mTransparentFillPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
    }

    public void d(int i, Bitmap bitmap) {
        Canvas canvas = new Canvas(bitmap);
        canvas.drawColor(0, PorterDuff.Mode.SRC);
        for (int c = !isKeyFrame(i) ? c(i - 1, canvas) : i; c < i; c++) {
            AnimatedDrawableFrameInfo Hi = this.lNP.Hi(c);
            AnimatedDrawableFrameInfo.DisposalMethod disposalMethod = Hi.lOT;
            if (disposalMethod != AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_PREVIOUS) {
                if (Hi.lOS == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND) {
                    a(canvas, Hi);
                }
                this.lNP.renderFrame(c, canvas);
                this.lNR.c(c, bitmap);
                if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
                    a(canvas, Hi);
                }
            }
        }
        AnimatedDrawableFrameInfo Hi2 = this.lNP.Hi(i);
        if (Hi2.lOS == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND) {
            a(canvas, Hi2);
        }
        this.lNP.renderFrame(i, canvas);
    }

    private int c(int i, Canvas canvas) {
        for (int i2 = i; i2 >= 0; i2--) {
            switch (HY(i2)) {
                case REQUIRED:
                    AnimatedDrawableFrameInfo Hi = this.lNP.Hi(i2);
                    com.facebook.common.references.a<Bitmap> HT = this.lNR.HT(i2);
                    if (HT != null) {
                        try {
                            canvas.drawBitmap(HT.get(), 0.0f, 0.0f, (Paint) null);
                            if (Hi.lOT == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
                                a(canvas, Hi);
                            }
                            return i2 + 1;
                        } finally {
                            HT.close();
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

    private FrameNeededResult HY(int i) {
        AnimatedDrawableFrameInfo Hi = this.lNP.Hi(i);
        AnimatedDrawableFrameInfo.DisposalMethod disposalMethod = Hi.lOT;
        if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_DO_NOT) {
            return FrameNeededResult.REQUIRED;
        }
        if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
            if (a(Hi)) {
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
        AnimatedDrawableFrameInfo Hi = this.lNP.Hi(i);
        AnimatedDrawableFrameInfo Hi2 = this.lNP.Hi(i - 1);
        if (Hi.lOS == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND && a(Hi)) {
            return true;
        }
        return Hi2.lOT == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND && a(Hi2);
    }

    private boolean a(AnimatedDrawableFrameInfo animatedDrawableFrameInfo) {
        return animatedDrawableFrameInfo.xOffset == 0 && animatedDrawableFrameInfo.yOffset == 0 && animatedDrawableFrameInfo.width == this.lNP.dmo() && animatedDrawableFrameInfo.height == this.lNP.dmp();
    }
}
