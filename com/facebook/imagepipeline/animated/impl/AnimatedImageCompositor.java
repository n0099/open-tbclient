package com.facebook.imagepipeline.animated.impl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
/* loaded from: classes12.dex */
public class AnimatedImageCompositor {
    private final com.facebook.imagepipeline.animated.base.a oRD;
    private final a oRF;
    private final Paint oTh = new Paint();

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
        com.facebook.common.references.a<Bitmap> OW(int i);

        void c(int i, Bitmap bitmap);
    }

    public AnimatedImageCompositor(com.facebook.imagepipeline.animated.base.a aVar, a aVar2) {
        this.oRD = aVar;
        this.oRF = aVar2;
        this.oTh.setColor(0);
        this.oTh.setStyle(Paint.Style.FILL);
        this.oTh.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
    }

    public void d(int i, Bitmap bitmap) {
        Canvas canvas = new Canvas(bitmap);
        canvas.drawColor(0, PorterDuff.Mode.SRC);
        for (int d = !Pc(i) ? d(i - 1, canvas) : i; d < i; d++) {
            AnimatedDrawableFrameInfo Ol = this.oRD.Ol(d);
            AnimatedDrawableFrameInfo.DisposalMethod disposalMethod = Ol.oSJ;
            if (disposalMethod != AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_PREVIOUS) {
                if (Ol.oSI == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND) {
                    a(canvas, Ol);
                }
                this.oRD.c(d, canvas);
                this.oRF.c(d, bitmap);
                if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
                    a(canvas, Ol);
                }
            }
        }
        AnimatedDrawableFrameInfo Ol2 = this.oRD.Ol(i);
        if (Ol2.oSI == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND) {
            a(canvas, Ol2);
        }
        this.oRD.c(i, canvas);
    }

    private int d(int i, Canvas canvas) {
        for (int i2 = i; i2 >= 0; i2--) {
            switch (Pb(i2)) {
                case REQUIRED:
                    AnimatedDrawableFrameInfo Ol = this.oRD.Ol(i2);
                    com.facebook.common.references.a<Bitmap> OW = this.oRF.OW(i2);
                    if (OW != null) {
                        try {
                            canvas.drawBitmap(OW.get(), 0.0f, 0.0f, (Paint) null);
                            if (Ol.oSJ == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
                                a(canvas, Ol);
                            }
                            return i2 + 1;
                        } finally {
                            OW.close();
                        }
                    } else if (!Pc(i2)) {
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
        canvas.drawRect(animatedDrawableFrameInfo.oSH, animatedDrawableFrameInfo.hYd, animatedDrawableFrameInfo.oSH + animatedDrawableFrameInfo.width, animatedDrawableFrameInfo.hYd + animatedDrawableFrameInfo.height, this.oTh);
    }

    private FrameNeededResult Pb(int i) {
        AnimatedDrawableFrameInfo Ol = this.oRD.Ol(i);
        AnimatedDrawableFrameInfo.DisposalMethod disposalMethod = Ol.oSJ;
        if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_DO_NOT) {
            return FrameNeededResult.REQUIRED;
        }
        if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
            if (a(Ol)) {
                return FrameNeededResult.NOT_REQUIRED;
            }
            return FrameNeededResult.REQUIRED;
        } else if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_PREVIOUS) {
            return FrameNeededResult.SKIP;
        } else {
            return FrameNeededResult.ABORT;
        }
    }

    private boolean Pc(int i) {
        if (i == 0) {
            return true;
        }
        AnimatedDrawableFrameInfo Ol = this.oRD.Ol(i);
        AnimatedDrawableFrameInfo Ol2 = this.oRD.Ol(i - 1);
        if (Ol.oSI == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND && a(Ol)) {
            return true;
        }
        return Ol2.oSJ == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND && a(Ol2);
    }

    private boolean a(AnimatedDrawableFrameInfo animatedDrawableFrameInfo) {
        return animatedDrawableFrameInfo.oSH == 0 && animatedDrawableFrameInfo.hYd == 0 && animatedDrawableFrameInfo.width == this.oRD.enb() && animatedDrawableFrameInfo.height == this.oRD.enc();
    }
}
