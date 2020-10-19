package com.facebook.imagepipeline.animated.impl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
/* loaded from: classes12.dex */
public class AnimatedImageCompositor {
    private final com.facebook.imagepipeline.animated.base.a nQS;
    private final a nQU;
    private final Paint nSw = new Paint();

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
        com.facebook.common.references.a<Bitmap> MK(int i);

        void b(int i, Bitmap bitmap);
    }

    public AnimatedImageCompositor(com.facebook.imagepipeline.animated.base.a aVar, a aVar2) {
        this.nQS = aVar;
        this.nQU = aVar2;
        this.nSw.setColor(0);
        this.nSw.setStyle(Paint.Style.FILL);
        this.nSw.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
    }

    public void c(int i, Bitmap bitmap) {
        Canvas canvas = new Canvas(bitmap);
        canvas.drawColor(0, PorterDuff.Mode.SRC);
        for (int d = !MQ(i) ? d(i - 1, canvas) : i; d < i; d++) {
            AnimatedDrawableFrameInfo LZ = this.nQS.LZ(d);
            AnimatedDrawableFrameInfo.DisposalMethod disposalMethod = LZ.nRY;
            if (disposalMethod != AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_PREVIOUS) {
                if (LZ.nRX == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND) {
                    a(canvas, LZ);
                }
                this.nQS.c(d, canvas);
                this.nQU.b(d, bitmap);
                if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
                    a(canvas, LZ);
                }
            }
        }
        AnimatedDrawableFrameInfo LZ2 = this.nQS.LZ(i);
        if (LZ2.nRX == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND) {
            a(canvas, LZ2);
        }
        this.nQS.c(i, canvas);
    }

    private int d(int i, Canvas canvas) {
        for (int i2 = i; i2 >= 0; i2--) {
            switch (MP(i2)) {
                case REQUIRED:
                    AnimatedDrawableFrameInfo LZ = this.nQS.LZ(i2);
                    com.facebook.common.references.a<Bitmap> MK = this.nQU.MK(i2);
                    if (MK != null) {
                        try {
                            canvas.drawBitmap(MK.get(), 0.0f, 0.0f, (Paint) null);
                            if (LZ.nRY == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
                                a(canvas, LZ);
                            }
                            return i2 + 1;
                        } finally {
                            MK.close();
                        }
                    } else if (!MQ(i2)) {
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
        canvas.drawRect(animatedDrawableFrameInfo.nRW, animatedDrawableFrameInfo.hFJ, animatedDrawableFrameInfo.nRW + animatedDrawableFrameInfo.width, animatedDrawableFrameInfo.hFJ + animatedDrawableFrameInfo.height, this.nSw);
    }

    private FrameNeededResult MP(int i) {
        AnimatedDrawableFrameInfo LZ = this.nQS.LZ(i);
        AnimatedDrawableFrameInfo.DisposalMethod disposalMethod = LZ.nRY;
        if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_DO_NOT) {
            return FrameNeededResult.REQUIRED;
        }
        if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
            if (a(LZ)) {
                return FrameNeededResult.NOT_REQUIRED;
            }
            return FrameNeededResult.REQUIRED;
        } else if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_PREVIOUS) {
            return FrameNeededResult.SKIP;
        } else {
            return FrameNeededResult.ABORT;
        }
    }

    private boolean MQ(int i) {
        if (i == 0) {
            return true;
        }
        AnimatedDrawableFrameInfo LZ = this.nQS.LZ(i);
        AnimatedDrawableFrameInfo LZ2 = this.nQS.LZ(i - 1);
        if (LZ.nRX == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND && a(LZ)) {
            return true;
        }
        return LZ2.nRY == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND && a(LZ2);
    }

    private boolean a(AnimatedDrawableFrameInfo animatedDrawableFrameInfo) {
        return animatedDrawableFrameInfo.nRW == 0 && animatedDrawableFrameInfo.hFJ == 0 && animatedDrawableFrameInfo.width == this.nQS.dZo() && animatedDrawableFrameInfo.height == this.nQS.dZp();
    }
}
