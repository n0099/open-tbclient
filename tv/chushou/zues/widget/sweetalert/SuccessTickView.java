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
    private final float oaA;
    private float oaB;
    private float oaC;
    private float oaD;
    private boolean oaE;
    private final float oav;
    private final float oaw;
    private final float oax;
    private final float oay;
    private final float oaz;

    public SuccessTickView(Context context) {
        super(context);
        this.mDensity = -1.0f;
        this.oav = bL(1.2f);
        this.oaw = bL(3.0f);
        this.oax = bL(15.0f);
        this.oay = bL(25.0f);
        this.oaz = bL(3.3f);
        this.oaA = this.oay + bL(6.7f);
        init();
    }

    public SuccessTickView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDensity = -1.0f;
        this.oav = bL(1.2f);
        this.oaw = bL(3.0f);
        this.oax = bL(15.0f);
        this.oay = bL(25.0f);
        this.oaz = bL(3.3f);
        this.oaA = this.oay + bL(6.7f);
        init();
    }

    private void init() {
        this.mPaint = new Paint();
        this.mPaint.setColor(getResources().getColor(b.C0807b.success_stroke_color));
        this.oaC = this.oax;
        this.oaD = this.oay;
        this.oaE = false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        canvas.rotate(45.0f, width / 2, height / 2);
        int i = (int) (width / 1.2d);
        int i2 = (int) (height / 1.4d);
        this.oaB = (((i + this.oax) / 2.0f) + this.oaw) - 1.0f;
        RectF rectF = new RectF();
        if (this.oaE) {
            rectF.left = 0.0f;
            rectF.right = rectF.left + this.oaC;
            rectF.top = (i2 + this.oay) / 2.0f;
            rectF.bottom = rectF.top + this.oaw;
        } else {
            rectF.right = (((i + this.oax) / 2.0f) + this.oaw) - 1.0f;
            rectF.left = rectF.right - this.oaC;
            rectF.top = (i2 + this.oay) / 2.0f;
            rectF.bottom = rectF.top + this.oaw;
        }
        canvas.drawRoundRect(rectF, this.oav, this.oav, this.mPaint);
        RectF rectF2 = new RectF();
        rectF2.bottom = (((i2 + this.oay) / 2.0f) + this.oaw) - 1.0f;
        rectF2.left = (i + this.oax) / 2.0f;
        rectF2.right = rectF2.left + this.oaw;
        rectF2.top = rectF2.bottom - this.oaD;
        canvas.drawRoundRect(rectF2, this.oav, this.oav, this.mPaint);
    }

    public float bL(float f) {
        if (this.mDensity == -1.0f) {
            this.mDensity = getResources().getDisplayMetrics().density;
        }
        return (this.mDensity * f) + 0.5f;
    }

    public void dQT() {
        this.oaC = 0.0f;
        this.oaD = 0.0f;
        invalidate();
        Animation animation = new Animation() { // from class: tv.chushou.zues.widget.sweetalert.SuccessTickView.1
            @Override // android.view.animation.Animation
            protected void applyTransformation(float f, Transformation transformation) {
                super.applyTransformation(f, transformation);
                if (0.54d < f && 0.7d >= f) {
                    SuccessTickView.this.oaE = true;
                    SuccessTickView.this.oaC = SuccessTickView.this.oaB * ((f - 0.54f) / 0.16f);
                    if (0.65d < f) {
                        SuccessTickView.this.oaD = SuccessTickView.this.oaA * ((f - 0.65f) / 0.19f);
                    }
                    SuccessTickView.this.invalidate();
                } else if (0.7d < f && 0.84d >= f) {
                    SuccessTickView.this.oaE = false;
                    SuccessTickView.this.oaC = SuccessTickView.this.oaB * (1.0f - ((f - 0.7f) / 0.14f));
                    SuccessTickView.this.oaC = SuccessTickView.this.oaC < SuccessTickView.this.oaz ? SuccessTickView.this.oaz : SuccessTickView.this.oaC;
                    SuccessTickView.this.oaD = SuccessTickView.this.oaA * ((f - 0.65f) / 0.19f);
                    SuccessTickView.this.invalidate();
                } else if (0.84d < f && 1.0f >= f) {
                    SuccessTickView.this.oaE = false;
                    SuccessTickView.this.oaC = SuccessTickView.this.oaz + ((SuccessTickView.this.oax - SuccessTickView.this.oaz) * ((f - 0.84f) / 0.16f));
                    SuccessTickView.this.oaD = SuccessTickView.this.oay + ((SuccessTickView.this.oaA - SuccessTickView.this.oay) * (1.0f - ((f - 0.84f) / 0.16f)));
                    SuccessTickView.this.invalidate();
                }
            }
        };
        animation.setDuration(750L);
        animation.setStartOffset(100L);
        startAnimation(animation);
    }
}
