package com.facebook.imagepipeline.animated.impl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
/* loaded from: classes13.dex */
public class AnimatedImageCompositor {
    private final com.facebook.imagepipeline.animated.base.a lQu;
    private final a lQw;
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
        com.facebook.common.references.a<Bitmap> Ie(int i);

        void c(int i, Bitmap bitmap);
    }

    public AnimatedImageCompositor(com.facebook.imagepipeline.animated.base.a aVar, a aVar2) {
        this.lQu = aVar;
        this.lQw = aVar2;
        this.mTransparentFillPaint.setColor(0);
        this.mTransparentFillPaint.setStyle(Paint.Style.FILL);
        this.mTransparentFillPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
    }

    public void d(int i, Bitmap bitmap) {
        Canvas canvas = new Canvas(bitmap);
        canvas.drawColor(0, PorterDuff.Mode.SRC);
        for (int c = !isKeyFrame(i) ? c(i - 1, canvas) : i; c < i; c++) {
            AnimatedDrawableFrameInfo Ht = this.lQu.Ht(c);
            AnimatedDrawableFrameInfo.DisposalMethod disposalMethod = Ht.lRy;
            if (disposalMethod != AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_PREVIOUS) {
                if (Ht.lRx == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND) {
                    a(canvas, Ht);
                }
                this.lQu.renderFrame(c, canvas);
                this.lQw.c(c, bitmap);
                if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
                    a(canvas, Ht);
                }
            }
        }
        AnimatedDrawableFrameInfo Ht2 = this.lQu.Ht(i);
        if (Ht2.lRx == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND) {
            a(canvas, Ht2);
        }
        this.lQu.renderFrame(i, canvas);
    }

    private int c(int i, Canvas canvas) {
        for (int i2 = i; i2 >= 0; i2--) {
            switch (Ij(i2)) {
                case REQUIRED:
                    AnimatedDrawableFrameInfo Ht = this.lQu.Ht(i2);
                    com.facebook.common.references.a<Bitmap> Ie = this.lQw.Ie(i2);
                    if (Ie != null) {
                        try {
                            canvas.drawBitmap(Ie.get(), 0.0f, 0.0f, (Paint) null);
                            if (Ht.lRy == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
                                a(canvas, Ht);
                            }
                            return i2 + 1;
                        } finally {
                            Ie.close();
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

    private FrameNeededResult Ij(int i) {
        AnimatedDrawableFrameInfo Ht = this.lQu.Ht(i);
        AnimatedDrawableFrameInfo.DisposalMethod disposalMethod = Ht.lRy;
        if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_DO_NOT) {
            return FrameNeededResult.REQUIRED;
        }
        if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
            if (a(Ht)) {
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
        AnimatedDrawableFrameInfo Ht = this.lQu.Ht(i);
        AnimatedDrawableFrameInfo Ht2 = this.lQu.Ht(i - 1);
        if (Ht.lRx == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND && a(Ht)) {
            return true;
        }
        return Ht2.lRy == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND && a(Ht2);
    }

    private boolean a(AnimatedDrawableFrameInfo animatedDrawableFrameInfo) {
        return animatedDrawableFrameInfo.xOffset == 0 && animatedDrawableFrameInfo.yOffset == 0 && animatedDrawableFrameInfo.width == this.lQu.dod() && animatedDrawableFrameInfo.height == this.lQu.doe();
    }
}
