package com.facebook.imagepipeline.animated.impl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
/* loaded from: classes12.dex */
public class AnimatedImageCompositor {
    private final com.facebook.imagepipeline.animated.base.a pie;
    private final a pig;
    private final Paint pjJ = new Paint();

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
        this.pie = aVar;
        this.pig = aVar2;
        this.pjJ.setColor(0);
        this.pjJ.setStyle(Paint.Style.FILL);
        this.pjJ.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
    }

    public void d(int i, Bitmap bitmap) {
        Canvas canvas = new Canvas(bitmap);
        canvas.drawColor(0, PorterDuff.Mode.SRC);
        for (int d = !QB(i) ? d(i - 1, canvas) : i; d < i; d++) {
            AnimatedDrawableFrameInfo PM = this.pie.PM(d);
            AnimatedDrawableFrameInfo.DisposalMethod disposalMethod = PM.pjl;
            if (disposalMethod != AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_PREVIOUS) {
                if (PM.pjk == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND) {
                    a(canvas, PM);
                }
                this.pie.c(d, canvas);
                this.pig.c(d, bitmap);
                if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
                    a(canvas, PM);
                }
            }
        }
        AnimatedDrawableFrameInfo PM2 = this.pie.PM(i);
        if (PM2.pjk == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND) {
            a(canvas, PM2);
        }
        this.pie.c(i, canvas);
    }

    private int d(int i, Canvas canvas) {
        for (int i2 = i; i2 >= 0; i2--) {
            switch (QA(i2)) {
                case REQUIRED:
                    AnimatedDrawableFrameInfo PM = this.pie.PM(i2);
                    com.facebook.common.references.a<Bitmap> Qv = this.pig.Qv(i2);
                    if (Qv != null) {
                        try {
                            canvas.drawBitmap(Qv.get(), 0.0f, 0.0f, (Paint) null);
                            if (PM.pjl == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
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
        canvas.drawRect(animatedDrawableFrameInfo.pjj, animatedDrawableFrameInfo.ijA, animatedDrawableFrameInfo.pjj + animatedDrawableFrameInfo.width, animatedDrawableFrameInfo.ijA + animatedDrawableFrameInfo.height, this.pjJ);
    }

    private FrameNeededResult QA(int i) {
        AnimatedDrawableFrameInfo PM = this.pie.PM(i);
        AnimatedDrawableFrameInfo.DisposalMethod disposalMethod = PM.pjl;
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
        AnimatedDrawableFrameInfo PM = this.pie.PM(i);
        AnimatedDrawableFrameInfo PM2 = this.pie.PM(i - 1);
        if (PM.pjk == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND && a(PM)) {
            return true;
        }
        return PM2.pjl == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND && a(PM2);
    }

    private boolean a(AnimatedDrawableFrameInfo animatedDrawableFrameInfo) {
        return animatedDrawableFrameInfo.pjj == 0 && animatedDrawableFrameInfo.ijA == 0 && animatedDrawableFrameInfo.width == this.pie.esK() && animatedDrawableFrameInfo.height == this.pie.esL();
    }
}
