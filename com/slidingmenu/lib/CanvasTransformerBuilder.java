package com.slidingmenu.lib;

import android.graphics.Canvas;
import android.view.animation.Interpolator;
import com.slidingmenu.lib.SlidingMenu;
/* loaded from: classes.dex */
public class CanvasTransformerBuilder {
    private static Interpolator lin = new Interpolator() { // from class: com.slidingmenu.lib.CanvasTransformerBuilder.1
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return f;
        }
    };
    private SlidingMenu.CanvasTransformer mTrans;

    private void initTransformer() {
        if (this.mTrans == null) {
            this.mTrans = new SlidingMenu.CanvasTransformer() { // from class: com.slidingmenu.lib.CanvasTransformerBuilder.2
                @Override // com.slidingmenu.lib.SlidingMenu.CanvasTransformer
                public void transformCanvas(Canvas canvas, float f) {
                }
            };
        }
    }

    public SlidingMenu.CanvasTransformer zoom(int i, int i2, int i3, int i4, int i5, int i6) {
        return zoom(i, i2, i3, i4, i5, i6, lin);
    }

    public SlidingMenu.CanvasTransformer zoom(final int i, final int i2, final int i3, final int i4, final int i5, final int i6, final Interpolator interpolator) {
        initTransformer();
        this.mTrans = new SlidingMenu.CanvasTransformer() { // from class: com.slidingmenu.lib.CanvasTransformerBuilder.3
            @Override // com.slidingmenu.lib.SlidingMenu.CanvasTransformer
            public void transformCanvas(Canvas canvas, float f) {
                CanvasTransformerBuilder.this.mTrans.transformCanvas(canvas, f);
                float interpolation = interpolator.getInterpolation(f);
                canvas.scale(((i - i2) * interpolation) + i2, (interpolation * (i3 - i4)) + i4, i5, i6);
            }
        };
        return this.mTrans;
    }

    public SlidingMenu.CanvasTransformer rotate(int i, int i2, int i3, int i4) {
        return rotate(i, i2, i3, i4, lin);
    }

    public SlidingMenu.CanvasTransformer rotate(final int i, final int i2, final int i3, final int i4, final Interpolator interpolator) {
        initTransformer();
        this.mTrans = new SlidingMenu.CanvasTransformer() { // from class: com.slidingmenu.lib.CanvasTransformerBuilder.4
            @Override // com.slidingmenu.lib.SlidingMenu.CanvasTransformer
            public void transformCanvas(Canvas canvas, float f) {
                CanvasTransformerBuilder.this.mTrans.transformCanvas(canvas, f);
                canvas.rotate((interpolator.getInterpolation(f) * (i - i2)) + i2, i3, i4);
            }
        };
        return this.mTrans;
    }

    public SlidingMenu.CanvasTransformer translate(int i, int i2, int i3, int i4) {
        return translate(i, i2, i3, i4, lin);
    }

    public SlidingMenu.CanvasTransformer translate(final int i, final int i2, final int i3, final int i4, final Interpolator interpolator) {
        initTransformer();
        this.mTrans = new SlidingMenu.CanvasTransformer() { // from class: com.slidingmenu.lib.CanvasTransformerBuilder.5
            @Override // com.slidingmenu.lib.SlidingMenu.CanvasTransformer
            public void transformCanvas(Canvas canvas, float f) {
                CanvasTransformerBuilder.this.mTrans.transformCanvas(canvas, f);
                float interpolation = interpolator.getInterpolation(f);
                canvas.translate(((i - i2) * interpolation) + i2, (interpolation * (i3 - i4)) + i4);
            }
        };
        return this.mTrans;
    }

    public SlidingMenu.CanvasTransformer concatTransformer(final SlidingMenu.CanvasTransformer canvasTransformer) {
        initTransformer();
        this.mTrans = new SlidingMenu.CanvasTransformer() { // from class: com.slidingmenu.lib.CanvasTransformerBuilder.6
            @Override // com.slidingmenu.lib.SlidingMenu.CanvasTransformer
            public void transformCanvas(Canvas canvas, float f) {
                CanvasTransformerBuilder.this.mTrans.transformCanvas(canvas, f);
                canvasTransformer.transformCanvas(canvas, f);
            }
        };
        return this.mTrans;
    }
}
