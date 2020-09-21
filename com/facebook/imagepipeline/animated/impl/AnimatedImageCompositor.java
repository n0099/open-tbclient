package com.facebook.imagepipeline.animated.impl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
/* loaded from: classes6.dex */
public class AnimatedImageCompositor {
    private final a nBB;
    private final com.facebook.imagepipeline.animated.base.a nBz;
    private final Paint nDd = new Paint();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public enum FrameNeededResult {
        REQUIRED,
        NOT_REQUIRED,
        SKIP,
        ABORT
    }

    /* loaded from: classes6.dex */
    public interface a {
        com.facebook.common.references.a<Bitmap> Me(int i);

        void b(int i, Bitmap bitmap);
    }

    public AnimatedImageCompositor(com.facebook.imagepipeline.animated.base.a aVar, a aVar2) {
        this.nBz = aVar;
        this.nBB = aVar2;
        this.nDd.setColor(0);
        this.nDd.setStyle(Paint.Style.FILL);
        this.nDd.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
    }

    public void c(int i, Bitmap bitmap) {
        Canvas canvas = new Canvas(bitmap);
        canvas.drawColor(0, PorterDuff.Mode.SRC);
        for (int d = !Mk(i) ? d(i - 1, canvas) : i; d < i; d++) {
            AnimatedDrawableFrameInfo Lt = this.nBz.Lt(d);
            AnimatedDrawableFrameInfo.DisposalMethod disposalMethod = Lt.nCF;
            if (disposalMethod != AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_PREVIOUS) {
                if (Lt.nCE == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND) {
                    a(canvas, Lt);
                }
                this.nBz.c(d, canvas);
                this.nBB.b(d, bitmap);
                if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
                    a(canvas, Lt);
                }
            }
        }
        AnimatedDrawableFrameInfo Lt2 = this.nBz.Lt(i);
        if (Lt2.nCE == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND) {
            a(canvas, Lt2);
        }
        this.nBz.c(i, canvas);
    }

    private int d(int i, Canvas canvas) {
        for (int i2 = i; i2 >= 0; i2--) {
            switch (Mj(i2)) {
                case REQUIRED:
                    AnimatedDrawableFrameInfo Lt = this.nBz.Lt(i2);
                    com.facebook.common.references.a<Bitmap> Me = this.nBB.Me(i2);
                    if (Me != null) {
                        try {
                            canvas.drawBitmap(Me.get(), 0.0f, 0.0f, (Paint) null);
                            if (Lt.nCF == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
                                a(canvas, Lt);
                            }
                            return i2 + 1;
                        } finally {
                            Me.close();
                        }
                    } else if (!Mk(i2)) {
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
        canvas.drawRect(animatedDrawableFrameInfo.nCD, animatedDrawableFrameInfo.hqP, animatedDrawableFrameInfo.nCD + animatedDrawableFrameInfo.width, animatedDrawableFrameInfo.hqP + animatedDrawableFrameInfo.height, this.nDd);
    }

    private FrameNeededResult Mj(int i) {
        AnimatedDrawableFrameInfo Lt = this.nBz.Lt(i);
        AnimatedDrawableFrameInfo.DisposalMethod disposalMethod = Lt.nCF;
        if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_DO_NOT) {
            return FrameNeededResult.REQUIRED;
        }
        if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
            if (a(Lt)) {
                return FrameNeededResult.NOT_REQUIRED;
            }
            return FrameNeededResult.REQUIRED;
        } else if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_PREVIOUS) {
            return FrameNeededResult.SKIP;
        } else {
            return FrameNeededResult.ABORT;
        }
    }

    private boolean Mk(int i) {
        if (i == 0) {
            return true;
        }
        AnimatedDrawableFrameInfo Lt = this.nBz.Lt(i);
        AnimatedDrawableFrameInfo Lt2 = this.nBz.Lt(i - 1);
        if (Lt.nCE == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND && a(Lt)) {
            return true;
        }
        return Lt2.nCF == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND && a(Lt2);
    }

    private boolean a(AnimatedDrawableFrameInfo animatedDrawableFrameInfo) {
        return animatedDrawableFrameInfo.nCD == 0 && animatedDrawableFrameInfo.hqP == 0 && animatedDrawableFrameInfo.width == this.nBz.dVD() && animatedDrawableFrameInfo.height == this.nBz.dVE();
    }
}
