package com.facebook.imagepipeline.animated.impl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
/* loaded from: classes13.dex */
public class AnimatedImageCompositor {
    private final com.facebook.imagepipeline.animated.base.a lYd;
    private final a lYf;
    private final Paint lZI = new Paint();

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
        com.facebook.common.references.a<Bitmap> GF(int i);

        void b(int i, Bitmap bitmap);
    }

    public AnimatedImageCompositor(com.facebook.imagepipeline.animated.base.a aVar, a aVar2) {
        this.lYd = aVar;
        this.lYf = aVar2;
        this.lZI.setColor(0);
        this.lZI.setStyle(Paint.Style.FILL);
        this.lZI.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
    }

    public void c(int i, Bitmap bitmap) {
        Canvas canvas = new Canvas(bitmap);
        canvas.drawColor(0, PorterDuff.Mode.SRC);
        for (int d = !GL(i) ? d(i - 1, canvas) : i; d < i; d++) {
            AnimatedDrawableFrameInfo FU = this.lYd.FU(d);
            AnimatedDrawableFrameInfo.DisposalMethod disposalMethod = FU.lZj;
            if (disposalMethod != AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_PREVIOUS) {
                if (FU.lZi == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND) {
                    a(canvas, FU);
                }
                this.lYd.c(d, canvas);
                this.lYf.b(d, bitmap);
                if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
                    a(canvas, FU);
                }
            }
        }
        AnimatedDrawableFrameInfo FU2 = this.lYd.FU(i);
        if (FU2.lZi == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND) {
            a(canvas, FU2);
        }
        this.lYd.c(i, canvas);
    }

    private int d(int i, Canvas canvas) {
        for (int i2 = i; i2 >= 0; i2--) {
            switch (GK(i2)) {
                case REQUIRED:
                    AnimatedDrawableFrameInfo FU = this.lYd.FU(i2);
                    com.facebook.common.references.a<Bitmap> GF = this.lYf.GF(i2);
                    if (GF != null) {
                        try {
                            canvas.drawBitmap(GF.get(), 0.0f, 0.0f, (Paint) null);
                            if (FU.lZj == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
                                a(canvas, FU);
                            }
                            return i2 + 1;
                        } finally {
                            GF.close();
                        }
                    } else if (!GL(i2)) {
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
        canvas.drawRect(animatedDrawableFrameInfo.lZh, animatedDrawableFrameInfo.gpu, animatedDrawableFrameInfo.lZh + animatedDrawableFrameInfo.width, animatedDrawableFrameInfo.gpu + animatedDrawableFrameInfo.height, this.lZI);
    }

    private FrameNeededResult GK(int i) {
        AnimatedDrawableFrameInfo FU = this.lYd.FU(i);
        AnimatedDrawableFrameInfo.DisposalMethod disposalMethod = FU.lZj;
        if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_DO_NOT) {
            return FrameNeededResult.REQUIRED;
        }
        if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
            if (a(FU)) {
                return FrameNeededResult.NOT_REQUIRED;
            }
            return FrameNeededResult.REQUIRED;
        } else if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_PREVIOUS) {
            return FrameNeededResult.SKIP;
        } else {
            return FrameNeededResult.ABORT;
        }
    }

    private boolean GL(int i) {
        if (i == 0) {
            return true;
        }
        AnimatedDrawableFrameInfo FU = this.lYd.FU(i);
        AnimatedDrawableFrameInfo FU2 = this.lYd.FU(i - 1);
        if (FU.lZi == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND && a(FU)) {
            return true;
        }
        return FU2.lZj == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND && a(FU2);
    }

    private boolean a(AnimatedDrawableFrameInfo animatedDrawableFrameInfo) {
        return animatedDrawableFrameInfo.lZh == 0 && animatedDrawableFrameInfo.gpu == 0 && animatedDrawableFrameInfo.width == this.lYd.dpX() && animatedDrawableFrameInfo.height == this.lYd.dpY();
    }
}
