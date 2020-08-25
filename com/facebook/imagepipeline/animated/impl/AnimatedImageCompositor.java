package com.facebook.imagepipeline.animated.impl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
/* loaded from: classes3.dex */
public class AnimatedImageCompositor {
    private final com.facebook.imagepipeline.animated.base.a nrj;
    private final a nrl;
    private final Paint nsN = new Paint();

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
        com.facebook.common.references.a<Bitmap> Lz(int i);

        void b(int i, Bitmap bitmap);
    }

    public AnimatedImageCompositor(com.facebook.imagepipeline.animated.base.a aVar, a aVar2) {
        this.nrj = aVar;
        this.nrl = aVar2;
        this.nsN.setColor(0);
        this.nsN.setStyle(Paint.Style.FILL);
        this.nsN.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
    }

    public void c(int i, Bitmap bitmap) {
        Canvas canvas = new Canvas(bitmap);
        canvas.drawColor(0, PorterDuff.Mode.SRC);
        for (int d = !LF(i) ? d(i - 1, canvas) : i; d < i; d++) {
            AnimatedDrawableFrameInfo KO = this.nrj.KO(d);
            AnimatedDrawableFrameInfo.DisposalMethod disposalMethod = KO.nsp;
            if (disposalMethod != AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_PREVIOUS) {
                if (KO.nso == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND) {
                    a(canvas, KO);
                }
                this.nrj.c(d, canvas);
                this.nrl.b(d, bitmap);
                if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
                    a(canvas, KO);
                }
            }
        }
        AnimatedDrawableFrameInfo KO2 = this.nrj.KO(i);
        if (KO2.nso == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND) {
            a(canvas, KO2);
        }
        this.nrj.c(i, canvas);
    }

    private int d(int i, Canvas canvas) {
        for (int i2 = i; i2 >= 0; i2--) {
            switch (LE(i2)) {
                case REQUIRED:
                    AnimatedDrawableFrameInfo KO = this.nrj.KO(i2);
                    com.facebook.common.references.a<Bitmap> Lz = this.nrl.Lz(i2);
                    if (Lz != null) {
                        try {
                            canvas.drawBitmap(Lz.get(), 0.0f, 0.0f, (Paint) null);
                            if (KO.nsp == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
                                a(canvas, KO);
                            }
                            return i2 + 1;
                        } finally {
                            Lz.close();
                        }
                    } else if (!LF(i2)) {
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
        canvas.drawRect(animatedDrawableFrameInfo.nsn, animatedDrawableFrameInfo.hjI, animatedDrawableFrameInfo.nsn + animatedDrawableFrameInfo.width, animatedDrawableFrameInfo.hjI + animatedDrawableFrameInfo.height, this.nsN);
    }

    private FrameNeededResult LE(int i) {
        AnimatedDrawableFrameInfo KO = this.nrj.KO(i);
        AnimatedDrawableFrameInfo.DisposalMethod disposalMethod = KO.nsp;
        if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_DO_NOT) {
            return FrameNeededResult.REQUIRED;
        }
        if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
            if (a(KO)) {
                return FrameNeededResult.NOT_REQUIRED;
            }
            return FrameNeededResult.REQUIRED;
        } else if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_PREVIOUS) {
            return FrameNeededResult.SKIP;
        } else {
            return FrameNeededResult.ABORT;
        }
    }

    private boolean LF(int i) {
        if (i == 0) {
            return true;
        }
        AnimatedDrawableFrameInfo KO = this.nrj.KO(i);
        AnimatedDrawableFrameInfo KO2 = this.nrj.KO(i - 1);
        if (KO.nso == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND && a(KO)) {
            return true;
        }
        return KO2.nsp == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND && a(KO2);
    }

    private boolean a(AnimatedDrawableFrameInfo animatedDrawableFrameInfo) {
        return animatedDrawableFrameInfo.nsn == 0 && animatedDrawableFrameInfo.hjI == 0 && animatedDrawableFrameInfo.width == this.nrj.dRw() && animatedDrawableFrameInfo.height == this.nrj.dRx();
    }
}
