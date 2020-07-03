package com.facebook.imagepipeline.animated.impl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
/* loaded from: classes13.dex */
public class AnimatedImageCompositor {
    private final com.facebook.imagepipeline.animated.base.a mPf;
    private final a mPh;
    private final Paint mQL = new Paint();

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
        this.mPf = aVar;
        this.mPh = aVar2;
        this.mQL.setColor(0);
        this.mQL.setStyle(Paint.Style.FILL);
        this.mQL.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
    }

    public void c(int i, Bitmap bitmap) {
        Canvas canvas = new Canvas(bitmap);
        canvas.drawColor(0, PorterDuff.Mode.SRC);
        for (int d = !IG(i) ? d(i - 1, canvas) : i; d < i; d++) {
            AnimatedDrawableFrameInfo HP = this.mPf.HP(d);
            AnimatedDrawableFrameInfo.DisposalMethod disposalMethod = HP.mQn;
            if (disposalMethod != AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_PREVIOUS) {
                if (HP.mQm == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND) {
                    a(canvas, HP);
                }
                this.mPf.c(d, canvas);
                this.mPh.b(d, bitmap);
                if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
                    a(canvas, HP);
                }
            }
        }
        AnimatedDrawableFrameInfo HP2 = this.mPf.HP(i);
        if (HP2.mQm == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND) {
            a(canvas, HP2);
        }
        this.mPf.c(i, canvas);
    }

    private int d(int i, Canvas canvas) {
        for (int i2 = i; i2 >= 0; i2--) {
            switch (IF(i2)) {
                case REQUIRED:
                    AnimatedDrawableFrameInfo HP = this.mPf.HP(i2);
                    com.facebook.common.references.a<Bitmap> IA = this.mPh.IA(i2);
                    if (IA != null) {
                        try {
                            canvas.drawBitmap(IA.get(), 0.0f, 0.0f, (Paint) null);
                            if (HP.mQn == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
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
        canvas.drawRect(animatedDrawableFrameInfo.mQl, animatedDrawableFrameInfo.gRk, animatedDrawableFrameInfo.mQl + animatedDrawableFrameInfo.width, animatedDrawableFrameInfo.gRk + animatedDrawableFrameInfo.height, this.mQL);
    }

    private FrameNeededResult IF(int i) {
        AnimatedDrawableFrameInfo HP = this.mPf.HP(i);
        AnimatedDrawableFrameInfo.DisposalMethod disposalMethod = HP.mQn;
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
        AnimatedDrawableFrameInfo HP = this.mPf.HP(i);
        AnimatedDrawableFrameInfo HP2 = this.mPf.HP(i - 1);
        if (HP.mQm == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND && a(HP)) {
            return true;
        }
        return HP2.mQn == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND && a(HP2);
    }

    private boolean a(AnimatedDrawableFrameInfo animatedDrawableFrameInfo) {
        return animatedDrawableFrameInfo.mQl == 0 && animatedDrawableFrameInfo.gRk == 0 && animatedDrawableFrameInfo.width == this.mPf.dCg() && animatedDrawableFrameInfo.height == this.mPf.dCh();
    }
}
