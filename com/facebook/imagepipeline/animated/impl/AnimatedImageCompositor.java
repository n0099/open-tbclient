package com.facebook.imagepipeline.animated.impl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
/* loaded from: classes12.dex */
public class AnimatedImageCompositor {
    private final com.facebook.imagepipeline.animated.base.a mXu;
    private final a mXw;
    private final Paint mYY = new Paint();

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
        this.mXu = aVar;
        this.mXw = aVar2;
        this.mYY.setColor(0);
        this.mYY.setStyle(Paint.Style.FILL);
        this.mYY.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
    }

    public void c(int i, Bitmap bitmap) {
        Canvas canvas = new Canvas(bitmap);
        canvas.drawColor(0, PorterDuff.Mode.SRC);
        for (int d = !Jb(i) ? d(i - 1, canvas) : i; d < i; d++) {
            AnimatedDrawableFrameInfo Ik = this.mXu.Ik(d);
            AnimatedDrawableFrameInfo.DisposalMethod disposalMethod = Ik.mYA;
            if (disposalMethod != AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_PREVIOUS) {
                if (Ik.mYz == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND) {
                    a(canvas, Ik);
                }
                this.mXu.c(d, canvas);
                this.mXw.b(d, bitmap);
                if (disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
                    a(canvas, Ik);
                }
            }
        }
        AnimatedDrawableFrameInfo Ik2 = this.mXu.Ik(i);
        if (Ik2.mYz == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND) {
            a(canvas, Ik2);
        }
        this.mXu.c(i, canvas);
    }

    private int d(int i, Canvas canvas) {
        for (int i2 = i; i2 >= 0; i2--) {
            switch (Ja(i2)) {
                case REQUIRED:
                    AnimatedDrawableFrameInfo Ik = this.mXu.Ik(i2);
                    com.facebook.common.references.a<Bitmap> IV = this.mXw.IV(i2);
                    if (IV != null) {
                        try {
                            canvas.drawBitmap(IV.get(), 0.0f, 0.0f, (Paint) null);
                            if (Ik.mYA == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
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
        canvas.drawRect(animatedDrawableFrameInfo.mYy, animatedDrawableFrameInfo.gWP, animatedDrawableFrameInfo.mYy + animatedDrawableFrameInfo.width, animatedDrawableFrameInfo.gWP + animatedDrawableFrameInfo.height, this.mYY);
    }

    private FrameNeededResult Ja(int i) {
        AnimatedDrawableFrameInfo Ik = this.mXu.Ik(i);
        AnimatedDrawableFrameInfo.DisposalMethod disposalMethod = Ik.mYA;
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
        AnimatedDrawableFrameInfo Ik = this.mXu.Ik(i);
        AnimatedDrawableFrameInfo Ik2 = this.mXu.Ik(i - 1);
        if (Ik.mYz == AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND && a(Ik)) {
            return true;
        }
        return Ik2.mYA == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND && a(Ik2);
    }

    private boolean a(AnimatedDrawableFrameInfo animatedDrawableFrameInfo) {
        return animatedDrawableFrameInfo.mYy == 0 && animatedDrawableFrameInfo.gWP == 0 && animatedDrawableFrameInfo.width == this.mXu.dFx() && animatedDrawableFrameInfo.height == this.mXu.dFy();
    }
}
