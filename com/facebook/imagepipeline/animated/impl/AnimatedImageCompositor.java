package com.facebook.imagepipeline.animated.impl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
/* loaded from: classes3.dex */
public class AnimatedImageCompositor {
    private final com.facebook.imagepipeline.animated.base.a pFb;
    private final a pFd;
    private final Paint pGF = new Paint();

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
        com.facebook.common.references.a<Bitmap> Px(int i);

        void d(int i, Bitmap bitmap);
    }

    public AnimatedImageCompositor(com.facebook.imagepipeline.animated.base.a aVar, a aVar2) {
        this.pFb = aVar;
        this.pFd = aVar2;
        this.pGF.setColor(0);
        this.pGF.setStyle(Paint.Style.FILL);
        this.pGF.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
    }

    public void e(int i, Bitmap bitmap) {
        Canvas canvas = new Canvas(bitmap);
        canvas.drawColor(0, PorterDuff.Mode.SRC);
        for (int e = !PD(i) ? e(i - 1, canvas) : i; e < i; e++) {
            AnimatedDrawableFrameInfo OO = this.pFb.OO(e);
            AnimatedDrawableFrameInfo.DisposalMethod disposalMethod = OO.pGh;
            if (disposalMethod != AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_PREVIOUS) {
                if (OO.pGg == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND) {
                    a(canvas, OO);
                }
                this.pFb.d(e, canvas);
                this.pFd.d(e, bitmap);
                if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
                    a(canvas, OO);
                }
            }
        }
        AnimatedDrawableFrameInfo OO2 = this.pFb.OO(i);
        if (OO2.pGg == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND) {
            a(canvas, OO2);
        }
        this.pFb.d(i, canvas);
    }

    private int e(int i, Canvas canvas) {
        for (int i2 = i; i2 >= 0; i2--) {
            switch (PC(i2)) {
                case REQUIRED:
                    AnimatedDrawableFrameInfo OO = this.pFb.OO(i2);
                    com.facebook.common.references.a<Bitmap> Px = this.pFd.Px(i2);
                    if (Px != null) {
                        try {
                            canvas.drawBitmap(Px.get(), 0.0f, 0.0f, (Paint) null);
                            if (OO.pGh == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
                                a(canvas, OO);
                            }
                            return i2 + 1;
                        } finally {
                            Px.close();
                        }
                    } else if (!PD(i2)) {
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
        canvas.drawRect(animatedDrawableFrameInfo.pGf, animatedDrawableFrameInfo.iwU, animatedDrawableFrameInfo.pGf + animatedDrawableFrameInfo.width, animatedDrawableFrameInfo.iwU + animatedDrawableFrameInfo.height, this.pGF);
    }

    private FrameNeededResult PC(int i) {
        AnimatedDrawableFrameInfo OO = this.pFb.OO(i);
        AnimatedDrawableFrameInfo.DisposalMethod disposalMethod = OO.pGh;
        if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_DO_NOT) {
            return FrameNeededResult.REQUIRED;
        }
        if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
            if (a(OO)) {
                return FrameNeededResult.NOT_REQUIRED;
            }
            return FrameNeededResult.REQUIRED;
        } else if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_PREVIOUS) {
            return FrameNeededResult.SKIP;
        } else {
            return FrameNeededResult.ABORT;
        }
    }

    private boolean PD(int i) {
        if (i == 0) {
            return true;
        }
        AnimatedDrawableFrameInfo OO = this.pFb.OO(i);
        AnimatedDrawableFrameInfo OO2 = this.pFb.OO(i - 1);
        if (OO.pGg == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND && a(OO)) {
            return true;
        }
        return OO2.pGh == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND && a(OO2);
    }

    private boolean a(AnimatedDrawableFrameInfo animatedDrawableFrameInfo) {
        return animatedDrawableFrameInfo.pGf == 0 && animatedDrawableFrameInfo.iwU == 0 && animatedDrawableFrameInfo.width == this.pFb.evv() && animatedDrawableFrameInfo.height == this.pFb.evw();
    }
}
