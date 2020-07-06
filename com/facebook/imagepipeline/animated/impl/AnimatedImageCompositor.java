package com.facebook.imagepipeline.animated.impl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
/* loaded from: classes13.dex */
public class AnimatedImageCompositor {
    private final com.facebook.imagepipeline.animated.base.a mPi;
    private final a mPk;
    private final Paint mQO = new Paint();

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
        com.facebook.common.references.a<Bitmap> IA(int i);

        void b(int i, Bitmap bitmap);
    }

    public AnimatedImageCompositor(com.facebook.imagepipeline.animated.base.a aVar, a aVar2) {
        this.mPi = aVar;
        this.mPk = aVar2;
        this.mQO.setColor(0);
        this.mQO.setStyle(Paint.Style.FILL);
        this.mQO.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
    }

    public void c(int i, Bitmap bitmap) {
        Canvas canvas = new Canvas(bitmap);
        canvas.drawColor(0, PorterDuff.Mode.SRC);
        for (int d = !IG(i) ? d(i - 1, canvas) : i; d < i; d++) {
            AnimatedDrawableFrameInfo HP = this.mPi.HP(d);
            AnimatedDrawableFrameInfo.DisposalMethod disposalMethod = HP.mQq;
            if (disposalMethod != AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_PREVIOUS) {
                if (HP.mQp == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND) {
                    a(canvas, HP);
                }
                this.mPi.c(d, canvas);
                this.mPk.b(d, bitmap);
                if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
                    a(canvas, HP);
                }
            }
        }
        AnimatedDrawableFrameInfo HP2 = this.mPi.HP(i);
        if (HP2.mQp == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND) {
            a(canvas, HP2);
        }
        this.mPi.c(i, canvas);
    }

    private int d(int i, Canvas canvas) {
        for (int i2 = i; i2 >= 0; i2--) {
            switch (IF(i2)) {
                case REQUIRED:
                    AnimatedDrawableFrameInfo HP = this.mPi.HP(i2);
                    com.facebook.common.references.a<Bitmap> IA = this.mPk.IA(i2);
                    if (IA != null) {
                        try {
                            canvas.drawBitmap(IA.get(), 0.0f, 0.0f, (Paint) null);
                            if (HP.mQq == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
                                a(canvas, HP);
                            }
                            return i2 + 1;
                        } finally {
                            IA.close();
                        }
                    } else if (!IG(i2)) {
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
        canvas.drawRect(animatedDrawableFrameInfo.mQo, animatedDrawableFrameInfo.gRk, animatedDrawableFrameInfo.mQo + animatedDrawableFrameInfo.width, animatedDrawableFrameInfo.gRk + animatedDrawableFrameInfo.height, this.mQO);
    }

    private FrameNeededResult IF(int i) {
        AnimatedDrawableFrameInfo HP = this.mPi.HP(i);
        AnimatedDrawableFrameInfo.DisposalMethod disposalMethod = HP.mQq;
        if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_DO_NOT) {
            return FrameNeededResult.REQUIRED;
        }
        if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
            if (a(HP)) {
                return FrameNeededResult.NOT_REQUIRED;
            }
            return FrameNeededResult.REQUIRED;
        } else if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_PREVIOUS) {
            return FrameNeededResult.SKIP;
        } else {
            return FrameNeededResult.ABORT;
        }
    }

    private boolean IG(int i) {
        if (i == 0) {
            return true;
        }
        AnimatedDrawableFrameInfo HP = this.mPi.HP(i);
        AnimatedDrawableFrameInfo HP2 = this.mPi.HP(i - 1);
        if (HP.mQp == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND && a(HP)) {
            return true;
        }
        return HP2.mQq == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND && a(HP2);
    }

    private boolean a(AnimatedDrawableFrameInfo animatedDrawableFrameInfo) {
        return animatedDrawableFrameInfo.mQo == 0 && animatedDrawableFrameInfo.gRk == 0 && animatedDrawableFrameInfo.width == this.mPi.dCk() && animatedDrawableFrameInfo.height == this.mPi.dCl();
    }
}
