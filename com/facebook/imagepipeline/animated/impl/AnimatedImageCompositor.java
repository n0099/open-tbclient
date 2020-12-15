package com.facebook.imagepipeline.animated.impl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
/* loaded from: classes12.dex */
public class AnimatedImageCompositor {
    private final com.facebook.imagepipeline.animated.base.a pig;
    private final a pii;
    private final Paint pjL = new Paint();

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
        com.facebook.common.references.a<Bitmap> Qv(int i);

        void c(int i, Bitmap bitmap);
    }

    public AnimatedImageCompositor(com.facebook.imagepipeline.animated.base.a aVar, a aVar2) {
        this.pig = aVar;
        this.pii = aVar2;
        this.pjL.setColor(0);
        this.pjL.setStyle(Paint.Style.FILL);
        this.pjL.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
    }

    public void d(int i, Bitmap bitmap) {
        Canvas canvas = new Canvas(bitmap);
        canvas.drawColor(0, PorterDuff.Mode.SRC);
        for (int d = !QB(i) ? d(i - 1, canvas) : i; d < i; d++) {
            AnimatedDrawableFrameInfo PM = this.pig.PM(d);
            AnimatedDrawableFrameInfo.DisposalMethod disposalMethod = PM.pjn;
            if (disposalMethod != AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_PREVIOUS) {
                if (PM.pjm == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND) {
                    a(canvas, PM);
                }
                this.pig.c(d, canvas);
                this.pii.c(d, bitmap);
                if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
                    a(canvas, PM);
                }
            }
        }
        AnimatedDrawableFrameInfo PM2 = this.pig.PM(i);
        if (PM2.pjm == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND) {
            a(canvas, PM2);
        }
        this.pig.c(i, canvas);
    }

    private int d(int i, Canvas canvas) {
        for (int i2 = i; i2 >= 0; i2--) {
            switch (QA(i2)) {
                case REQUIRED:
                    AnimatedDrawableFrameInfo PM = this.pig.PM(i2);
                    com.facebook.common.references.a<Bitmap> Qv = this.pii.Qv(i2);
                    if (Qv != null) {
                        try {
                            canvas.drawBitmap(Qv.get(), 0.0f, 0.0f, (Paint) null);
                            if (PM.pjn == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
                                a(canvas, PM);
                            }
                            return i2 + 1;
                        } finally {
                            Qv.close();
                        }
                    } else if (!QB(i2)) {
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
        canvas.drawRect(animatedDrawableFrameInfo.pjl, animatedDrawableFrameInfo.ijC, animatedDrawableFrameInfo.pjl + animatedDrawableFrameInfo.width, animatedDrawableFrameInfo.ijC + animatedDrawableFrameInfo.height, this.pjL);
    }

    private FrameNeededResult QA(int i) {
        AnimatedDrawableFrameInfo PM = this.pig.PM(i);
        AnimatedDrawableFrameInfo.DisposalMethod disposalMethod = PM.pjn;
        if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_DO_NOT) {
            return FrameNeededResult.REQUIRED;
        }
        if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
            if (a(PM)) {
                return FrameNeededResult.NOT_REQUIRED;
            }
            return FrameNeededResult.REQUIRED;
        } else if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_PREVIOUS) {
            return FrameNeededResult.SKIP;
        } else {
            return FrameNeededResult.ABORT;
        }
    }

    private boolean QB(int i) {
        if (i == 0) {
            return true;
        }
        AnimatedDrawableFrameInfo PM = this.pig.PM(i);
        AnimatedDrawableFrameInfo PM2 = this.pig.PM(i - 1);
        if (PM.pjm == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND && a(PM)) {
            return true;
        }
        return PM2.pjn == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND && a(PM2);
    }

    private boolean a(AnimatedDrawableFrameInfo animatedDrawableFrameInfo) {
        return animatedDrawableFrameInfo.pjl == 0 && animatedDrawableFrameInfo.ijC == 0 && animatedDrawableFrameInfo.width == this.pig.esL() && animatedDrawableFrameInfo.height == this.pig.esM();
    }
}
