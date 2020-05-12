package tv.chushou.zues.widget.sweetalert;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import tv.chushou.zues.b;
/* loaded from: classes5.dex */
public class SuccessTickView extends View {
    private float mDensity;
    private Paint mPaint;
    private final float nwA;
    private float nwB;
    private float nwC;
    private float nwD;
    private boolean nwE;
    private final float nwv;
    private final float nww;
    private final float nwx;
    private final float nwy;
    private final float nwz;

    public SuccessTickView(Context context) {
        super(context);
        this.mDensity = -1.0f;
        this.nwv = aS(1.2f);
        this.nww = aS(3.0f);
        this.nwx = aS(15.0f);
        this.nwy = aS(25.0f);
        this.nwz = aS(3.3f);
        this.nwA = this.nwy + aS(6.7f);
        init();
    }

    public SuccessTickView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDensity = -1.0f;
        this.nwv = aS(1.2f);
        this.nww = aS(3.0f);
        this.nwx = aS(15.0f);
        this.nwy = aS(25.0f);
        this.nwz = aS(3.3f);
        this.nwA = this.nwy + aS(6.7f);
        init();
    }

    private void init() {
        this.mPaint = new Paint();
        this.mPaint.setColor(getResources().getColor(b.C0852b.success_stroke_color));
        this.nwC = this.nwx;
        this.nwD = this.nwy;
        this.nwE = false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        canvas.rotate(45.0f, width / 2, height / 2);
        int i = (int) (width / 1.2d);
        int i2 = (int) (height / 1.4d);
        this.nwB = (((i + this.nwx) / 2.0f) + this.nww) - 1.0f;
        RectF rectF = new RectF();
        if (this.nwE) {
            rectF.left = 0.0f;
            rectF.right = rectF.left + this.nwC;
            rectF.top = (i2 + this.nwy) / 2.0f;
            rectF.bottom = rectF.top + this.nww;
        } else {
            rectF.right = (((i + this.nwx) / 2.0f) + this.nww) - 1.0f;
            rectF.left = rectF.right - this.nwC;
            rectF.top = (i2 + this.nwy) / 2.0f;
            rectF.bottom = rectF.top + this.nww;
        }
        canvas.drawRoundRect(rectF, this.nwv, this.nwv, this.mPaint);
        RectF rectF2 = new RectF();
        rectF2.bottom = (((i2 + this.nwy) / 2.0f) + this.nww) - 1.0f;
        rectF2.left = (i + this.nwx) / 2.0f;
        rectF2.right = rectF2.left + this.nww;
        rectF2.top = rectF2.bottom - this.nwD;
        canvas.drawRoundRect(rectF2, this.nwv, this.nwv, this.mPaint);
    }

    public float aS(float f) {
        if (this.mDensity == -1.0f) {
            this.mDensity = getResources().getDisplayMetrics().density;
        }
        return (this.mDensity * f) + 0.5f;
    }

    public void dKt() {
        this.nwC = 0.0f;
        this.nwD = 0.0f;
        invalidate();
        Animation animation = new Animation() { // from class: tv.chushou.zues.widget.sweetalert.SuccessTickView.1
            @Override // android.view.animation.Animation
            protected void applyTransformation(float f, Transformation transformation) {
                super.applyTransformation(f, transformation);
                if (0.54d < f && 0.7d >= f) {
                    SuccessTickView.this.nwE = true;
                    SuccessTickView.this.nwC = SuccessTickView.this.nwB * ((f - 0.54f) / 0.16f);
                    if (0.65d < f) {
                        SuccessTickView.this.nwD = SuccessTickView.this.nwA * ((f - 0.65f) / 0.19f);
                    }
                    SuccessTickView.this.invalidate();
                } else if (0.7d < f && 0.84d >= f) {
                    SuccessTickView.this.nwE = false;
                    SuccessTickView.this.nwC = SuccessTickView.this.nwB * (1.0f - ((f - 0.7f) / 0.14f));
                    SuccessTickView.this.nwC = SuccessTickView.this.nwC < SuccessTickView.this.nwz ? SuccessTickView.this.nwz : SuccessTickView.this.nwC;
                    SuccessTickView.this.nwD = SuccessTickView.this.nwA * ((f - 0.65f) / 0.19f);
                    SuccessTickView.this.invalidate();
                } else if (0.84d < f && 1.0f >= f) {
                    SuccessTickView.this.nwE = false;
                    SuccessTickView.this.nwC = SuccessTickView.this.nwz + ((SuccessTickView.this.nwx - SuccessTickView.this.nwz) * ((f - 0.84f) / 0.16f));
                    SuccessTickView.this.nwD = SuccessTickView.this.nwy + ((SuccessTickView.this.nwA - SuccessTickView.this.nwy) * (1.0f - ((f - 0.84f) / 0.16f)));
                    SuccessTickView.this.invalidate();
                }
            }
        };
        animation.setDuration(750L);
        animation.setStartOffset(100L);
        startAnimation(animation);
    }
}
