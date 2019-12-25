package com.facebook.imagepipeline.animated.impl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
/* loaded from: classes11.dex */
public class AnimatedImageCompositor {
    private final com.facebook.imagepipeline.animated.base.a lKe;
    private final a lKg;
    private final Paint mTransparentFillPaint = new Paint();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public enum FrameNeededResult {
        REQUIRED,
        NOT_REQUIRED,
        SKIP,
        ABORT
    }

    /* loaded from: classes11.dex */
    public interface a {
        com.facebook.common.references.a<Bitmap> HK(int i);

        void c(int i, Bitmap bitmap);
    }

    public AnimatedImageCompositor(com.facebook.imagepipeline.animated.base.a aVar, a aVar2) {
        this.lKe = aVar;
        this.lKg = aVar2;
        this.mTransparentFillPaint.setColor(0);
        this.mTransparentFillPaint.setStyle(Paint.Style.FILL);
        this.mTransparentFillPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
    }

    public void d(int i, Bitmap bitmap) {
        Canvas canvas = new Canvas(bitmap);
        canvas.drawColor(0, PorterDuff.Mode.SRC);
        for (int c = !isKeyFrame(i) ? c(i - 1, canvas) : i; c < i; c++) {
            AnimatedDrawableFrameInfo Hd = this.lKe.Hd(c);
            AnimatedDrawableFrameInfo.DisposalMethod disposalMethod = Hd.lLi;
            if (disposalMethod != AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_PREVIOUS) {
                if (Hd.lLh == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND) {
                    a(canvas, Hd);
                }
                this.lKe.renderFrame(c, canvas);
                this.lKg.c(c, bitmap);
                if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
                    a(canvas, Hd);
                }
            }
        }
        AnimatedDrawableFrameInfo Hd2 = this.lKe.Hd(i);
        if (Hd2.lLh == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND) {
            a(canvas, Hd2);
        }
        this.lKe.renderFrame(i, canvas);
    }

    private int c(int i, Canvas canvas) {
        for (int i2 = i; i2 >= 0; i2--) {
            switch (HP(i2)) {
                case REQUIRED:
                    AnimatedDrawableFrameInfo Hd = this.lKe.Hd(i2);
                    com.facebook.common.references.a<Bitmap> HK = this.lKg.HK(i2);
                    if (HK != null) {
                        try {
                            canvas.drawBitmap(HK.get(), 0.0f, 0.0f, (Paint) null);
                            if (Hd.lLi == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
                                a(canvas, Hd);
                            }
                            return i2 + 1;
                        } finally {
                            HK.close();
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

    private FrameNeededResult HP(int i) {
        AnimatedDrawableFrameInfo Hd = this.lKe.Hd(i);
        AnimatedDrawableFrameInfo.DisposalMethod disposalMethod = Hd.lLi;
        if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_DO_NOT) {
            return FrameNeededResult.REQUIRED;
        }
        if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
            if (a(Hd)) {
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
        AnimatedDrawableFrameInfo Hd = this.lKe.Hd(i);
        AnimatedDrawableFrameInfo Hd2 = this.lKe.Hd(i - 1);
        if (Hd.lLh == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND && a(Hd)) {
            return true;
        }
        return Hd2.lLi == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND && a(Hd2);
    }

    private boolean a(AnimatedDrawableFrameInfo animatedDrawableFrameInfo) {
        return animatedDrawableFrameInfo.xOffset == 0 && animatedDrawableFrameInfo.yOffset == 0 && animatedDrawableFrameInfo.width == this.lKe.dlj() && animatedDrawableFrameInfo.height == this.lKe.dlk();
    }
}
