package com.facebook.imagepipeline.animated.impl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
/* loaded from: classes14.dex */
public class AnimatedImageCompositor {
    private final com.facebook.imagepipeline.animated.base.a pHG;
    private final a pHI;
    private final Paint pJk = new Paint();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes14.dex */
    public enum FrameNeededResult {
        REQUIRED,
        NOT_REQUIRED,
        SKIP,
        ABORT
    }

    /* loaded from: classes14.dex */
    public interface a {
        com.facebook.common.references.a<Bitmap> PC(int i);

        void d(int i, Bitmap bitmap);
    }

    public AnimatedImageCompositor(com.facebook.imagepipeline.animated.base.a aVar, a aVar2) {
        this.pHG = aVar;
        this.pHI = aVar2;
        this.pJk.setColor(0);
        this.pJk.setStyle(Paint.Style.FILL);
        this.pJk.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
    }

    public void e(int i, Bitmap bitmap) {
        Canvas canvas = new Canvas(bitmap);
        canvas.drawColor(0, PorterDuff.Mode.SRC);
        for (int e = !PI(i) ? e(i - 1, canvas) : i; e < i; e++) {
            AnimatedDrawableFrameInfo OT = this.pHG.OT(e);
            AnimatedDrawableFrameInfo.DisposalMethod disposalMethod = OT.pIM;
            if (disposalMethod != AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_PREVIOUS) {
                if (OT.pIL == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND) {
                    a(canvas, OT);
                }
                this.pHG.d(e, canvas);
                this.pHI.d(e, bitmap);
                if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
                    a(canvas, OT);
                }
            }
        }
        AnimatedDrawableFrameInfo OT2 = this.pHG.OT(i);
        if (OT2.pIL == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND) {
            a(canvas, OT2);
        }
        this.pHG.d(i, canvas);
    }

    private int e(int i, Canvas canvas) {
        for (int i2 = i; i2 >= 0; i2--) {
            switch (PH(i2)) {
                case REQUIRED:
                    AnimatedDrawableFrameInfo OT = this.pHG.OT(i2);
                    com.facebook.common.references.a<Bitmap> PC = this.pHI.PC(i2);
                    if (PC != null) {
                        try {
                            canvas.drawBitmap(PC.get(), 0.0f, 0.0f, (Paint) null);
                            if (OT.pIM == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
                                a(canvas, OT);
                            }
                            return i2 + 1;
                        } finally {
                            PC.close();
                        }
                    } else if (!PI(i2)) {
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
        canvas.drawRect(animatedDrawableFrameInfo.pIK, animatedDrawableFrameInfo.iyR, animatedDrawableFrameInfo.pIK + animatedDrawableFrameInfo.width, animatedDrawableFrameInfo.iyR + animatedDrawableFrameInfo.height, this.pJk);
    }

    private FrameNeededResult PH(int i) {
        AnimatedDrawableFrameInfo OT = this.pHG.OT(i);
        AnimatedDrawableFrameInfo.DisposalMethod disposalMethod = OT.pIM;
        if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_DO_NOT) {
            return FrameNeededResult.REQUIRED;
        }
        if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
            if (a(OT)) {
                return FrameNeededResult.NOT_REQUIRED;
            }
            return FrameNeededResult.REQUIRED;
        } else if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_PREVIOUS) {
            return FrameNeededResult.SKIP;
        } else {
            return FrameNeededResult.ABORT;
        }
    }

    private boolean PI(int i) {
        if (i == 0) {
            return true;
        }
        AnimatedDrawableFrameInfo OT = this.pHG.OT(i);
        AnimatedDrawableFrameInfo OT2 = this.pHG.OT(i - 1);
        if (OT.pIL == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND && a(OT)) {
            return true;
        }
        return OT2.pIM == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND && a(OT2);
    }

    private boolean a(AnimatedDrawableFrameInfo animatedDrawableFrameInfo) {
        return animatedDrawableFrameInfo.pIK == 0 && animatedDrawableFrameInfo.iyR == 0 && animatedDrawableFrameInfo.width == this.pHG.evM() && animatedDrawableFrameInfo.height == this.pHG.evN();
    }
}
