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
    private final float nZA;
    private final float nZB;
    private final float nZC;
    private final float nZD;
    private final float nZE;
    private final float nZF;
    private float nZG;
    private float nZH;
    private float nZI;
    private boolean nZJ;

    public SuccessTickView(Context context) {
        super(context);
        this.mDensity = -1.0f;
        this.nZA = bM(1.2f);
        this.nZB = bM(3.0f);
        this.nZC = bM(15.0f);
        this.nZD = bM(25.0f);
        this.nZE = bM(3.3f);
        this.nZF = this.nZD + bM(6.7f);
        init();
    }

    public SuccessTickView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDensity = -1.0f;
        this.nZA = bM(1.2f);
        this.nZB = bM(3.0f);
        this.nZC = bM(15.0f);
        this.nZD = bM(25.0f);
        this.nZE = bM(3.3f);
        this.nZF = this.nZD + bM(6.7f);
        init();
    }

    private void init() {
        this.mPaint = new Paint();
        this.mPaint.setColor(getResources().getColor(b.C0799b.success_stroke_color));
        this.nZH = this.nZC;
        this.nZI = this.nZD;
        this.nZJ = false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        canvas.rotate(45.0f, width / 2, height / 2);
        int i = (int) (width / 1.2d);
        int i2 = (int) (height / 1.4d);
        this.nZG = (((i + this.nZC) / 2.0f) + this.nZB) - 1.0f;
        RectF rectF = new RectF();
        if (this.nZJ) {
            rectF.left = 0.0f;
            rectF.right = rectF.left + this.nZH;
            rectF.top = (i2 + this.nZD) / 2.0f;
            rectF.bottom = rectF.top + this.nZB;
        } else {
            rectF.right = (((i + this.nZC) / 2.0f) + this.nZB) - 1.0f;
            rectF.left = rectF.right - this.nZH;
            rectF.top = (i2 + this.nZD) / 2.0f;
            rectF.bottom = rectF.top + this.nZB;
        }
        canvas.drawRoundRect(rectF, this.nZA, this.nZA, this.mPaint);
        RectF rectF2 = new RectF();
        rectF2.bottom = (((i2 + this.nZD) / 2.0f) + this.nZB) - 1.0f;
        rectF2.left = (i + this.nZC) / 2.0f;
        rectF2.right = rectF2.left + this.nZB;
        rectF2.top = rectF2.bottom - this.nZI;
        canvas.drawRoundRect(rectF2, this.nZA, this.nZA, this.mPaint);
    }

    public float bM(float f) {
        if (this.mDensity == -1.0f) {
            this.mDensity = getResources().getDisplayMetrics().density;
        }
        return (this.mDensity * f) + 0.5f;
    }

    public void dPC() {
        this.nZH = 0.0f;
        this.nZI = 0.0f;
        invalidate();
        Animation animation = new Animation() { // from class: tv.chushou.zues.widget.sweetalert.SuccessTickView.1
            @Override // android.view.animation.Animation
            protected void applyTransformation(float f, Transformation transformation) {
                super.applyTransformation(f, transformation);
                if (0.54d < f && 0.7d >= f) {
                    SuccessTickView.this.nZJ = true;
                    SuccessTickView.this.nZH = SuccessTickView.this.nZG * ((f - 0.54f) / 0.16f);
                    if (0.65d < f) {
                        SuccessTickView.this.nZI = SuccessTickView.this.nZF * ((f - 0.65f) / 0.19f);
                    }
                    SuccessTickView.this.invalidate();
                } else if (0.7d < f && 0.84d >= f) {
                    SuccessTickView.this.nZJ = false;
                    SuccessTickView.this.nZH = SuccessTickView.this.nZG * (1.0f - ((f - 0.7f) / 0.14f));
                    SuccessTickView.this.nZH = SuccessTickView.this.nZH < SuccessTickView.this.nZE ? SuccessTickView.this.nZE : SuccessTickView.this.nZH;
                    SuccessTickView.this.nZI = SuccessTickView.this.nZF * ((f - 0.65f) / 0.19f);
                    SuccessTickView.this.invalidate();
                } else if (0.84d < f && 1.0f >= f) {
                    SuccessTickView.this.nZJ = false;
                    SuccessTickView.this.nZH = SuccessTickView.this.nZE + ((SuccessTickView.this.nZC - SuccessTickView.this.nZE) * ((f - 0.84f) / 0.16f));
                    SuccessTickView.this.nZI = SuccessTickView.this.nZD + ((SuccessTickView.this.nZF - SuccessTickView.this.nZD) * (1.0f - ((f - 0.84f) / 0.16f)));
                    SuccessTickView.this.invalidate();
                }
            }
        };
        animation.setDuration(750L);
        animation.setStartOffset(100L);
        startAnimation(animation);
    }
}
