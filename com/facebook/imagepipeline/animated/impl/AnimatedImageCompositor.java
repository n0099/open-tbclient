package com.facebook.imagepipeline.animated.impl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
/* loaded from: classes12.dex */
public class AnimatedImageCompositor {
    private final com.facebook.imagepipeline.animated.base.a mXs;
    private final a mXu;
    private final Paint mYW = new Paint();

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
        com.facebook.common.references.a<Bitmap> IV(int i);

        void b(int i, Bitmap bitmap);
    }

    public AnimatedImageCompositor(com.facebook.imagepipeline.animated.base.a aVar, a aVar2) {
        this.mXs = aVar;
        this.mXu = aVar2;
        this.mYW.setColor(0);
        this.mYW.setStyle(Paint.Style.FILL);
        this.mYW.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
    }

    public void c(int i, Bitmap bitmap) {
        Canvas canvas = new Canvas(bitmap);
        canvas.drawColor(0, PorterDuff.Mode.SRC);
        for (int d = !Jb(i) ? d(i - 1, canvas) : i; d < i; d++) {
            AnimatedDrawableFrameInfo Ik = this.mXs.Ik(d);
            AnimatedDrawableFrameInfo.DisposalMethod disposalMethod = Ik.mYy;
            if (disposalMethod != AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_PREVIOUS) {
                if (Ik.mYx == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND) {
                    a(canvas, Ik);
                }
                this.mXs.c(d, canvas);
                this.mXu.b(d, bitmap);
                if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
                    a(canvas, Ik);
                }
            }
        }
        AnimatedDrawableFrameInfo Ik2 = this.mXs.Ik(i);
        if (Ik2.mYx == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND) {
            a(canvas, Ik2);
        }
        this.mXs.c(i, canvas);
    }

    private int d(int i, Canvas canvas) {
        for (int i2 = i; i2 >= 0; i2--) {
            switch (Ja(i2)) {
                case REQUIRED:
                    AnimatedDrawableFrameInfo Ik = this.mXs.Ik(i2);
                    com.facebook.common.references.a<Bitmap> IV = this.mXu.IV(i2);
                    if (IV != null) {
                        try {
                            canvas.drawBitmap(IV.get(), 0.0f, 0.0f, (Paint) null);
                            if (Ik.mYy == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
                                a(canvas, Ik);
                            }
                            return i2 + 1;
                        } finally {
                            IV.close();
                        }
                    } else if (!Jb(i2)) {
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
        canvas.drawRect(animatedDrawableFrameInfo.mYw, animatedDrawableFrameInfo.gWP, animatedDrawableFrameInfo.mYw + animatedDrawableFrameInfo.width, animatedDrawableFrameInfo.gWP + animatedDrawableFrameInfo.height, this.mYW);
    }

    private FrameNeededResult Ja(int i) {
        AnimatedDrawableFrameInfo Ik = this.mXs.Ik(i);
        AnimatedDrawableFrameInfo.DisposalMethod disposalMethod = Ik.mYy;
        if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_DO_NOT) {
            return FrameNeededResult.REQUIRED;
        }
        if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
            if (a(Ik)) {
                return FrameNeededResult.NOT_REQUIRED;
            }
            return FrameNeededResult.REQUIRED;
        } else if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_PREVIOUS) {
            return FrameNeededResult.SKIP;
        } else {
            return FrameNeededResult.ABORT;
        }
    }

    private boolean Jb(int i) {
        if (i == 0) {
            return true;
        }
        AnimatedDrawableFrameInfo Ik = this.mXs.Ik(i);
        AnimatedDrawableFrameInfo Ik2 = this.mXs.Ik(i - 1);
        if (Ik.mYx == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND && a(Ik)) {
            return true;
        }
        return Ik2.mYy == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND && a(Ik2);
    }

    private boolean a(AnimatedDrawableFrameInfo animatedDrawableFrameInfo) {
        return animatedDrawableFrameInfo.mYw == 0 && animatedDrawableFrameInfo.gWP == 0 && animatedDrawableFrameInfo.width == this.mXs.dFw() && animatedDrawableFrameInfo.height == this.mXs.dFx();
    }
}
