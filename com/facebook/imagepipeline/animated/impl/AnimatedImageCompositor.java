package com.facebook.imagepipeline.animated.impl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
/* loaded from: classes3.dex */
public class AnimatedImageCompositor {
    private final com.facebook.imagepipeline.animated.base.a pFB;
    private final a pFD;
    private final Paint pHf = new Paint();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public enum FrameNeededResult {
        REQUIRED,
        NOT_REQUIRED,
        SKIP,
        ABORT
    }

    /* loaded from: classes3.dex */
    public interface a {
        com.facebook.common.references.a<Bitmap> Py(int i);

        void d(int i, Bitmap bitmap);
    }

    public AnimatedImageCompositor(com.facebook.imagepipeline.animated.base.a aVar, a aVar2) {
        this.pFB = aVar;
        this.pFD = aVar2;
        this.pHf.setColor(0);
        this.pHf.setStyle(Paint.Style.FILL);
        this.pHf.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
    }

    public void e(int i, Bitmap bitmap) {
        Canvas canvas = new Canvas(bitmap);
        canvas.drawColor(0, PorterDuff.Mode.SRC);
        for (int e = !PE(i) ? e(i - 1, canvas) : i; e < i; e++) {
            AnimatedDrawableFrameInfo OP = this.pFB.OP(e);
            AnimatedDrawableFrameInfo.DisposalMethod disposalMethod = OP.pGH;
            if (disposalMethod != AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_PREVIOUS) {
                if (OP.pGG == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND) {
                    a(canvas, OP);
                }
                this.pFB.d(e, canvas);
                this.pFD.d(e, bitmap);
                if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
                    a(canvas, OP);
                }
            }
        }
        AnimatedDrawableFrameInfo OP2 = this.pFB.OP(i);
        if (OP2.pGG == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND) {
            a(canvas, OP2);
        }
        this.pFB.d(i, canvas);
    }

    private int e(int i, Canvas canvas) {
        for (int i2 = i; i2 >= 0; i2--) {
            switch (PD(i2)) {
                case REQUIRED:
                    AnimatedDrawableFrameInfo OP = this.pFB.OP(i2);
                    com.facebook.common.references.a<Bitmap> Py = this.pFD.Py(i2);
                    if (Py != null) {
                        try {
                            canvas.drawBitmap(Py.get(), 0.0f, 0.0f, (Paint) null);
                            if (OP.pGH == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
                                a(canvas, OP);
                            }
                            return i2 + 1;
                        } finally {
                            Py.close();
                        }
                    } else if (!PE(i2)) {
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
        canvas.drawRect(animatedDrawableFrameInfo.pGF, animatedDrawableFrameInfo.ixi, animatedDrawableFrameInfo.pGF + animatedDrawableFrameInfo.width, animatedDrawableFrameInfo.ixi + animatedDrawableFrameInfo.height, this.pHf);
    }

    private FrameNeededResult PD(int i) {
        AnimatedDrawableFrameInfo OP = this.pFB.OP(i);
        AnimatedDrawableFrameInfo.DisposalMethod disposalMethod = OP.pGH;
        if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_DO_NOT) {
            return FrameNeededResult.REQUIRED;
        }
        if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
            if (a(OP)) {
                return FrameNeededResult.NOT_REQUIRED;
            }
            return FrameNeededResult.REQUIRED;
        } else if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_PREVIOUS) {
            return FrameNeededResult.SKIP;
        } else {
            return FrameNeededResult.ABORT;
        }
    }

    private boolean PE(int i) {
        if (i == 0) {
            return true;
        }
        AnimatedDrawableFrameInfo OP = this.pFB.OP(i);
        AnimatedDrawableFrameInfo OP2 = this.pFB.OP(i - 1);
        if (OP.pGG == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND && a(OP)) {
            return true;
        }
        return OP2.pGH == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND && a(OP2);
    }

    private boolean a(AnimatedDrawableFrameInfo animatedDrawableFrameInfo) {
        return animatedDrawableFrameInfo.pGF == 0 && animatedDrawableFrameInfo.ixi == 0 && animatedDrawableFrameInfo.width == this.pFB.evD() && animatedDrawableFrameInfo.height == this.pFB.evE();
    }
}
