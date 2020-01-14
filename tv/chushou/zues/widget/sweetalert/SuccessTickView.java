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
/* loaded from: classes4.dex */
public class SuccessTickView extends View {
    private float mDensity;
    private Paint mPaint;
    private final float nZF;
    private final float nZG;
    private final float nZH;
    private final float nZI;
    private final float nZJ;
    private final float nZK;
    private float nZL;
    private float nZM;
    private float nZN;
    private boolean nZO;

    public SuccessTickView(Context context) {
        super(context);
        this.mDensity = -1.0f;
        this.nZF = bM(1.2f);
        this.nZG = bM(3.0f);
        this.nZH = bM(15.0f);
        this.nZI = bM(25.0f);
        this.nZJ = bM(3.3f);
        this.nZK = this.nZI + bM(6.7f);
        init();
    }

    public SuccessTickView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDensity = -1.0f;
        this.nZF = bM(1.2f);
        this.nZG = bM(3.0f);
        this.nZH = bM(15.0f);
        this.nZI = bM(25.0f);
        this.nZJ = bM(3.3f);
        this.nZK = this.nZI + bM(6.7f);
        init();
    }

    private void init() {
        this.mPaint = new Paint();
        this.mPaint.setColor(getResources().getColor(b.C0799b.success_stroke_color));
        this.nZM = this.nZH;
        this.nZN = this.nZI;
        this.nZO = false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        canvas.rotate(45.0f, width / 2, height / 2);
        int i = (int) (width / 1.2d);
        int i2 = (int) (height / 1.4d);
        this.nZL = (((i + this.nZH) / 2.0f) + this.nZG) - 1.0f;
        RectF rectF = new RectF();
        if (this.nZO) {
            rectF.left = 0.0f;
            rectF.right = rectF.left + this.nZM;
            rectF.top = (i2 + this.nZI) / 2.0f;
            rectF.bottom = rectF.top + this.nZG;
        } else {
            rectF.right = (((i + this.nZH) / 2.0f) + this.nZG) - 1.0f;
            rectF.left = rectF.right - this.nZM;
            rectF.top = (i2 + this.nZI) / 2.0f;
            rectF.bottom = rectF.top + this.nZG;
        }
        canvas.drawRoundRect(rectF, this.nZF, this.nZF, this.mPaint);
        RectF rectF2 = new RectF();
        rectF2.bottom = (((i2 + this.nZI) / 2.0f) + this.nZG) - 1.0f;
        rectF2.left = (i + this.nZH) / 2.0f;
        rectF2.right = rectF2.left + this.nZG;
        rectF2.top = rectF2.bottom - this.nZN;
        canvas.drawRoundRect(rectF2, this.nZF, this.nZF, this.mPaint);
    }

    public float bM(float f) {
        if (this.mDensity == -1.0f) {
            this.mDensity = getResources().getDisplayMetrics().density;
        }
        return (this.mDensity * f) + 0.5f;
    }

    public void dPE() {
        this.nZM = 0.0f;
        this.nZN = 0.0f;
        invalidate();
        Animation animation = new Animation() { // from class: tv.chushou.zues.widget.sweetalert.SuccessTickView.1
            @Override // android.view.animation.Animation
            protected void applyTransformation(float f, Transformation transformation) {
                super.applyTransformation(f, transformation);
                if (0.54d < f && 0.7d >= f) {
                    SuccessTickView.this.nZO = true;
                    SuccessTickView.this.nZM = SuccessTickView.this.nZL * ((f - 0.54f) / 0.16f);
                    if (0.65d < f) {
                        SuccessTickView.this.nZN = SuccessTickView.this.nZK * ((f - 0.65f) / 0.19f);
                    }
                    SuccessTickView.this.invalidate();
                } else if (0.7d < f && 0.84d >= f) {
                    SuccessTickView.this.nZO = false;
                    SuccessTickView.this.nZM = SuccessTickView.this.nZL * (1.0f - ((f - 0.7f) / 0.14f));
                    SuccessTickView.this.nZM = SuccessTickView.this.nZM < SuccessTickView.this.nZJ ? SuccessTickView.this.nZJ : SuccessTickView.this.nZM;
                    SuccessTickView.this.nZN = SuccessTickView.this.nZK * ((f - 0.65f) / 0.19f);
                    SuccessTickView.this.invalidate();
                } else if (0.84d < f && 1.0f >= f) {
                    SuccessTickView.this.nZO = false;
                    SuccessTickView.this.nZM = SuccessTickView.this.nZJ + ((SuccessTickView.this.nZH - SuccessTickView.this.nZJ) * ((f - 0.84f) / 0.16f));
                    SuccessTickView.this.nZN = SuccessTickView.this.nZI + ((SuccessTickView.this.nZK - SuccessTickView.this.nZI) * (1.0f - ((f - 0.84f) / 0.16f)));
                    SuccessTickView.this.invalidate();
                }
            }
        };
        animation.setDuration(750L);
        animation.setStartOffset(100L);
        startAnimation(animation);
    }
}
