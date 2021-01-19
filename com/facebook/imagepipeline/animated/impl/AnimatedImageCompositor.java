package com.facebook.imagepipeline.animated.impl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
/* loaded from: classes5.dex */
public class AnimatedImageCompositor {
    private final com.facebook.imagepipeline.animated.base.a puT;
    private final a puV;
    private final Paint pwx = new Paint();

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
        com.facebook.common.references.a<Bitmap> Pc(int i);

        void d(int i, Bitmap bitmap);
    }

    public AnimatedImageCompositor(com.facebook.imagepipeline.animated.base.a aVar, a aVar2) {
        this.puT = aVar;
        this.puV = aVar2;
        this.pwx.setColor(0);
        this.pwx.setStyle(Paint.Style.FILL);
        this.pwx.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
    }

    public void e(int i, Bitmap bitmap) {
        Canvas canvas = new Canvas(bitmap);
        canvas.drawColor(0, PorterDuff.Mode.SRC);
        for (int e = !Pi(i) ? e(i - 1, canvas) : i; e < i; e++) {
            AnimatedDrawableFrameInfo Ot = this.puT.Ot(e);
            AnimatedDrawableFrameInfo.DisposalMethod disposalMethod = Ot.pvZ;
            if (disposalMethod != AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_PREVIOUS) {
                if (Ot.pvY == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND) {
                    a(canvas, Ot);
                }
                this.puT.d(e, canvas);
                this.puV.d(e, bitmap);
                if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
                    a(canvas, Ot);
                }
            }
        }
        AnimatedDrawableFrameInfo Ot2 = this.puT.Ot(i);
        if (Ot2.pvY == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND) {
            a(canvas, Ot2);
        }
        this.puT.d(i, canvas);
    }

    private int e(int i, Canvas canvas) {
        for (int i2 = i; i2 >= 0; i2--) {
            switch (Ph(i2)) {
                case REQUIRED:
                    AnimatedDrawableFrameInfo Ot = this.puT.Ot(i2);
                    com.facebook.common.references.a<Bitmap> Pc = this.puV.Pc(i2);
                    if (Pc != null) {
                        try {
                            canvas.drawBitmap(Pc.get(), 0.0f, 0.0f, (Paint) null);
                            if (Ot.pvZ == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
                                a(canvas, Ot);
                            }
                            return i2 + 1;
                        } finally {
                            Pc.close();
                        }
                    } else if (!Pi(i2)) {
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
        canvas.drawRect(animatedDrawableFrameInfo.pvX, animatedDrawableFrameInfo.irq, animatedDrawableFrameInfo.pvX + animatedDrawableFrameInfo.width, animatedDrawableFrameInfo.irq + animatedDrawableFrameInfo.height, this.pwx);
    }

    private FrameNeededResult Ph(int i) {
        AnimatedDrawableFrameInfo Ot = this.puT.Ot(i);
        AnimatedDrawableFrameInfo.DisposalMethod disposalMethod = Ot.pvZ;
        if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_DO_NOT) {
            return FrameNeededResult.REQUIRED;
        }
        if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
            if (a(Ot)) {
                return FrameNeededResult.NOT_REQUIRED;
            }
            return FrameNeededResult.REQUIRED;
        } else if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_PREVIOUS) {
            return FrameNeededResult.SKIP;
        } else {
            return FrameNeededResult.ABORT;
        }
    }

    private boolean Pi(int i) {
        if (i == 0) {
            return true;
        }
        AnimatedDrawableFrameInfo Ot = this.puT.Ot(i);
        AnimatedDrawableFrameInfo Ot2 = this.puT.Ot(i - 1);
        if (Ot.pvY == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND && a(Ot)) {
            return true;
        }
        return Ot2.pvZ == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND && a(Ot2);
    }

    private boolean a(AnimatedDrawableFrameInfo animatedDrawableFrameInfo) {
        return animatedDrawableFrameInfo.pvX == 0 && animatedDrawableFrameInfo.irq == 0 && animatedDrawableFrameInfo.width == this.puT.etd() && animatedDrawableFrameInfo.height == this.puT.ete();
    }
}
