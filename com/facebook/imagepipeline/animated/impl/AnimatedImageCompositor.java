package com.facebook.imagepipeline.animated.impl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
/* loaded from: classes12.dex */
public class AnimatedImageCompositor {
    private final com.facebook.imagepipeline.animated.base.a oIk;
    private final a oIm;
    private final Paint oJO = new Paint();

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
        com.facebook.common.references.a<Bitmap> OB(int i);

        void c(int i, Bitmap bitmap);
    }

    public AnimatedImageCompositor(com.facebook.imagepipeline.animated.base.a aVar, a aVar2) {
        this.oIk = aVar;
        this.oIm = aVar2;
        this.oJO.setColor(0);
        this.oJO.setStyle(Paint.Style.FILL);
        this.oJO.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
    }

    public void d(int i, Bitmap bitmap) {
        Canvas canvas = new Canvas(bitmap);
        canvas.drawColor(0, PorterDuff.Mode.SRC);
        for (int d = !OH(i) ? d(i - 1, canvas) : i; d < i; d++) {
            AnimatedDrawableFrameInfo NQ = this.oIk.NQ(d);
            AnimatedDrawableFrameInfo.DisposalMethod disposalMethod = NQ.oJq;
            if (disposalMethod != AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_PREVIOUS) {
                if (NQ.oJp == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND) {
                    a(canvas, NQ);
                }
                this.oIk.c(d, canvas);
                this.oIm.c(d, bitmap);
                if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
                    a(canvas, NQ);
                }
            }
        }
        AnimatedDrawableFrameInfo NQ2 = this.oIk.NQ(i);
        if (NQ2.oJp == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND) {
            a(canvas, NQ2);
        }
        this.oIk.c(i, canvas);
    }

    private int d(int i, Canvas canvas) {
        for (int i2 = i; i2 >= 0; i2--) {
            switch (OG(i2)) {
                case REQUIRED:
                    AnimatedDrawableFrameInfo NQ = this.oIk.NQ(i2);
                    com.facebook.common.references.a<Bitmap> OB = this.oIm.OB(i2);
                    if (OB != null) {
                        try {
                            canvas.drawBitmap(OB.get(), 0.0f, 0.0f, (Paint) null);
                            if (NQ.oJq == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
                                a(canvas, NQ);
                            }
                            return i2 + 1;
                        } finally {
                            OB.close();
                        }
                    } else if (!OH(i2)) {
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
        canvas.drawRect(animatedDrawableFrameInfo.oJo, animatedDrawableFrameInfo.hSg, animatedDrawableFrameInfo.oJo + animatedDrawableFrameInfo.width, animatedDrawableFrameInfo.hSg + animatedDrawableFrameInfo.height, this.oJO);
    }

    private FrameNeededResult OG(int i) {
        AnimatedDrawableFrameInfo NQ = this.oIk.NQ(i);
        AnimatedDrawableFrameInfo.DisposalMethod disposalMethod = NQ.oJq;
        if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_DO_NOT) {
            return FrameNeededResult.REQUIRED;
        }
        if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
            if (a(NQ)) {
                return FrameNeededResult.NOT_REQUIRED;
            }
            return FrameNeededResult.REQUIRED;
        } else if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_PREVIOUS) {
            return FrameNeededResult.SKIP;
        } else {
            return FrameNeededResult.ABORT;
        }
    }

    private boolean OH(int i) {
        if (i == 0) {
            return true;
        }
        AnimatedDrawableFrameInfo NQ = this.oIk.NQ(i);
        AnimatedDrawableFrameInfo NQ2 = this.oIk.NQ(i - 1);
        if (NQ.oJp == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND && a(NQ)) {
            return true;
        }
        return NQ2.oJq == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND && a(NQ2);
    }

    private boolean a(AnimatedDrawableFrameInfo animatedDrawableFrameInfo) {
        return animatedDrawableFrameInfo.oJo == 0 && animatedDrawableFrameInfo.hSg == 0 && animatedDrawableFrameInfo.width == this.oIk.ejm() && animatedDrawableFrameInfo.height == this.oIk.ejn();
    }
}
