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
/* loaded from: classes6.dex */
public class SuccessTickView extends View {
    private float mDensity;
    private Paint mPaint;
    private final float ppP;
    private final float ppQ;
    private final float ppR;
    private final float ppS;
    private final float ppT;
    private final float ppU;
    private float ppV;
    private float ppW;
    private float ppX;
    private boolean ppY;

    public SuccessTickView(Context context) {
        super(context);
        this.mDensity = -1.0f;
        this.ppP = bi(1.2f);
        this.ppQ = bi(3.0f);
        this.ppR = bi(15.0f);
        this.ppS = bi(25.0f);
        this.ppT = bi(3.3f);
        this.ppU = this.ppS + bi(6.7f);
        init();
    }

    public SuccessTickView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDensity = -1.0f;
        this.ppP = bi(1.2f);
        this.ppQ = bi(3.0f);
        this.ppR = bi(15.0f);
        this.ppS = bi(25.0f);
        this.ppT = bi(3.3f);
        this.ppU = this.ppS + bi(6.7f);
        init();
    }

    private void init() {
        this.mPaint = new Paint();
        this.mPaint.setColor(getResources().getColor(b.C1023b.success_stroke_color));
        this.ppW = this.ppR;
        this.ppX = this.ppS;
        this.ppY = false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        canvas.rotate(45.0f, width / 2, height / 2);
        int i = (int) (width / 1.2d);
        int i2 = (int) (height / 1.4d);
        this.ppV = (((i + this.ppR) / 2.0f) + this.ppQ) - 1.0f;
        RectF rectF = new RectF();
        if (this.ppY) {
            rectF.left = 0.0f;
            rectF.right = rectF.left + this.ppW;
            rectF.top = (i2 + this.ppS) / 2.0f;
            rectF.bottom = rectF.top + this.ppQ;
        } else {
            rectF.right = (((i + this.ppR) / 2.0f) + this.ppQ) - 1.0f;
            rectF.left = rectF.right - this.ppW;
            rectF.top = (i2 + this.ppS) / 2.0f;
            rectF.bottom = rectF.top + this.ppQ;
        }
        canvas.drawRoundRect(rectF, this.ppP, this.ppP, this.mPaint);
        RectF rectF2 = new RectF();
        rectF2.bottom = (((i2 + this.ppS) / 2.0f) + this.ppQ) - 1.0f;
        rectF2.left = (i + this.ppR) / 2.0f;
        rectF2.right = rectF2.left + this.ppQ;
        rectF2.top = rectF2.bottom - this.ppX;
        canvas.drawRoundRect(rectF2, this.ppP, this.ppP, this.mPaint);
    }

    public float bi(float f) {
        if (this.mDensity == -1.0f) {
            this.mDensity = getResources().getDisplayMetrics().density;
        }
        return (this.mDensity * f) + 0.5f;
    }

    public void euB() {
        this.ppW = 0.0f;
        this.ppX = 0.0f;
        invalidate();
        Animation animation = new Animation() { // from class: tv.chushou.zues.widget.sweetalert.SuccessTickView.1
            @Override // android.view.animation.Animation
            protected void applyTransformation(float f, Transformation transformation) {
                super.applyTransformation(f, transformation);
                if (0.54d < f && 0.7d >= f) {
                    SuccessTickView.this.ppY = true;
                    SuccessTickView.this.ppW = SuccessTickView.this.ppV * ((f - 0.54f) / 0.16f);
                    if (0.65d < f) {
                        SuccessTickView.this.ppX = SuccessTickView.this.ppU * ((f - 0.65f) / 0.19f);
                    }
                    SuccessTickView.this.invalidate();
                } else if (0.7d < f && 0.84d >= f) {
                    SuccessTickView.this.ppY = false;
                    SuccessTickView.this.ppW = SuccessTickView.this.ppV * (1.0f - ((f - 0.7f) / 0.14f));
                    SuccessTickView.this.ppW = SuccessTickView.this.ppW < SuccessTickView.this.ppT ? SuccessTickView.this.ppT : SuccessTickView.this.ppW;
                    SuccessTickView.this.ppX = SuccessTickView.this.ppU * ((f - 0.65f) / 0.19f);
                    SuccessTickView.this.invalidate();
                } else if (0.84d < f && 1.0f >= f) {
                    SuccessTickView.this.ppY = false;
                    SuccessTickView.this.ppW = SuccessTickView.this.ppT + ((SuccessTickView.this.ppR - SuccessTickView.this.ppT) * ((f - 0.84f) / 0.16f));
                    SuccessTickView.this.ppX = SuccessTickView.this.ppS + ((SuccessTickView.this.ppU - SuccessTickView.this.ppS) * (1.0f - ((f - 0.84f) / 0.16f)));
                    SuccessTickView.this.invalidate();
                }
            }
        };
        animation.setDuration(750L);
        animation.setStartOffset(100L);
        startAnimation(animation);
    }
}
