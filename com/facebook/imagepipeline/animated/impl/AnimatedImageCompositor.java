package com.facebook.imagepipeline.animated.impl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
/* loaded from: classes5.dex */
public class AnimatedImageCompositor {
    private final Paint pAX = new Paint();
    private final com.facebook.imagepipeline.animated.base.a pzt;
    private final a pzv;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public enum FrameNeededResult {
        REQUIRED,
        NOT_REQUIRED,
        SKIP,
        ABORT
    }

    /* loaded from: classes5.dex */
    public interface a {
        com.facebook.common.references.a<Bitmap> QJ(int i);

        void d(int i, Bitmap bitmap);
    }

    public AnimatedImageCompositor(com.facebook.imagepipeline.animated.base.a aVar, a aVar2) {
        this.pzt = aVar;
        this.pzv = aVar2;
        this.pAX.setColor(0);
        this.pAX.setStyle(Paint.Style.FILL);
        this.pAX.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
    }

    public void e(int i, Bitmap bitmap) {
        Canvas canvas = new Canvas(bitmap);
        canvas.drawColor(0, PorterDuff.Mode.SRC);
        for (int e = !QP(i) ? e(i - 1, canvas) : i; e < i; e++) {
            AnimatedDrawableFrameInfo Qa = this.pzt.Qa(e);
            AnimatedDrawableFrameInfo.DisposalMethod disposalMethod = Qa.pAz;
            if (disposalMethod != AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_PREVIOUS) {
                if (Qa.pAy == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND) {
                    a(canvas, Qa);
                }
                this.pzt.d(e, canvas);
                this.pzv.d(e, bitmap);
                if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
                    a(canvas, Qa);
                }
            }
        }
        AnimatedDrawableFrameInfo Qa2 = this.pzt.Qa(i);
        if (Qa2.pAy == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND) {
            a(canvas, Qa2);
        }
        this.pzt.d(i, canvas);
    }

    private int e(int i, Canvas canvas) {
        for (int i2 = i; i2 >= 0; i2--) {
            switch (QO(i2)) {
                case REQUIRED:
                    AnimatedDrawableFrameInfo Qa = this.pzt.Qa(i2);
                    com.facebook.common.references.a<Bitmap> QJ = this.pzv.QJ(i2);
                    if (QJ != null) {
                        try {
                            canvas.drawBitmap(QJ.get(), 0.0f, 0.0f, (Paint) null);
                            if (Qa.pAz == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
                                a(canvas, Qa);
                            }
                            return i2 + 1;
                        } finally {
                            QJ.close();
                        }
                    } else if (!QP(i2)) {
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
        canvas.drawRect(animatedDrawableFrameInfo.pAx, animatedDrawableFrameInfo.ivX, animatedDrawableFrameInfo.pAx + animatedDrawableFrameInfo.width, animatedDrawableFrameInfo.ivX + animatedDrawableFrameInfo.height, this.pAX);
    }

    private FrameNeededResult QO(int i) {
        AnimatedDrawableFrameInfo Qa = this.pzt.Qa(i);
        AnimatedDrawableFrameInfo.DisposalMethod disposalMethod = Qa.pAz;
        if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_DO_NOT) {
            return FrameNeededResult.REQUIRED;
        }
        if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
            if (a(Qa)) {
                return FrameNeededResult.NOT_REQUIRED;
            }
            return FrameNeededResult.REQUIRED;
        } else if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_PREVIOUS) {
            return FrameNeededResult.SKIP;
        } else {
            return FrameNeededResult.ABORT;
        }
    }

    private boolean QP(int i) {
        if (i == 0) {
            return true;
        }
        AnimatedDrawableFrameInfo Qa = this.pzt.Qa(i);
        AnimatedDrawableFrameInfo Qa2 = this.pzt.Qa(i - 1);
        if (Qa.pAy == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND && a(Qa)) {
            return true;
        }
        return Qa2.pAz == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND && a(Qa2);
    }

    private boolean a(AnimatedDrawableFrameInfo animatedDrawableFrameInfo) {
        return animatedDrawableFrameInfo.pAx == 0 && animatedDrawableFrameInfo.ivX == 0 && animatedDrawableFrameInfo.width == this.pzt.ewV() && animatedDrawableFrameInfo.height == this.pzt.ewW();
    }
}
