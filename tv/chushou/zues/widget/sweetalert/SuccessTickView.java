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
    private final float qqA;
    private float qqB;
    private float qqC;
    private float qqD;
    private boolean qqE;
    private final float qqv;
    private final float qqw;
    private final float qqx;
    private final float qqy;
    private final float qqz;

    public SuccessTickView(Context context) {
        super(context);
        this.mDensity = -1.0f;
        this.qqv = bB(1.2f);
        this.qqw = bB(3.0f);
        this.qqx = bB(15.0f);
        this.qqy = bB(25.0f);
        this.qqz = bB(3.3f);
        this.qqA = this.qqy + bB(6.7f);
        init();
    }

    public SuccessTickView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDensity = -1.0f;
        this.qqv = bB(1.2f);
        this.qqw = bB(3.0f);
        this.qqx = bB(15.0f);
        this.qqy = bB(25.0f);
        this.qqz = bB(3.3f);
        this.qqA = this.qqy + bB(6.7f);
        init();
    }

    private void init() {
        this.mPaint = new Paint();
        this.mPaint.setColor(getResources().getColor(b.C1115b.success_stroke_color));
        this.qqC = this.qqx;
        this.qqD = this.qqy;
        this.qqE = false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        canvas.rotate(45.0f, width / 2, height / 2);
        int i = (int) (width / 1.2d);
        int i2 = (int) (height / 1.4d);
        this.qqB = (((i + this.qqx) / 2.0f) + this.qqw) - 1.0f;
        RectF rectF = new RectF();
        if (this.qqE) {
            rectF.left = 0.0f;
            rectF.right = rectF.left + this.qqC;
            rectF.top = (i2 + this.qqy) / 2.0f;
            rectF.bottom = rectF.top + this.qqw;
        } else {
            rectF.right = (((i + this.qqx) / 2.0f) + this.qqw) - 1.0f;
            rectF.left = rectF.right - this.qqC;
            rectF.top = (i2 + this.qqy) / 2.0f;
            rectF.bottom = rectF.top + this.qqw;
        }
        canvas.drawRoundRect(rectF, this.qqv, this.qqv, this.mPaint);
        RectF rectF2 = new RectF();
        rectF2.bottom = (((i2 + this.qqy) / 2.0f) + this.qqw) - 1.0f;
        rectF2.left = (i + this.qqx) / 2.0f;
        rectF2.right = rectF2.left + this.qqw;
        rectF2.top = rectF2.bottom - this.qqD;
        canvas.drawRoundRect(rectF2, this.qqv, this.qqv, this.mPaint);
    }

    public float bB(float f) {
        if (this.mDensity == -1.0f) {
            this.mDensity = getResources().getDisplayMetrics().density;
        }
        return (this.mDensity * f) + 0.5f;
    }

    public void eIo() {
        this.qqC = 0.0f;
        this.qqD = 0.0f;
        invalidate();
        Animation animation = new Animation() { // from class: tv.chushou.zues.widget.sweetalert.SuccessTickView.1
            @Override // android.view.animation.Animation
            protected void applyTransformation(float f, Transformation transformation) {
                super.applyTransformation(f, transformation);
                if (0.54d < f && 0.7d >= f) {
                    SuccessTickView.this.qqE = true;
                    SuccessTickView.this.qqC = SuccessTickView.this.qqB * ((f - 0.54f) / 0.16f);
                    if (0.65d < f) {
                        SuccessTickView.this.qqD = SuccessTickView.this.qqA * ((f - 0.65f) / 0.19f);
                    }
                    SuccessTickView.this.invalidate();
                } else if (0.7d < f && 0.84d >= f) {
                    SuccessTickView.this.qqE = false;
                    SuccessTickView.this.qqC = SuccessTickView.this.qqB * (1.0f - ((f - 0.7f) / 0.14f));
                    SuccessTickView.this.qqC = SuccessTickView.this.qqC < SuccessTickView.this.qqz ? SuccessTickView.this.qqz : SuccessTickView.this.qqC;
                    SuccessTickView.this.qqD = SuccessTickView.this.qqA * ((f - 0.65f) / 0.19f);
                    SuccessTickView.this.invalidate();
                } else if (0.84d < f && 1.0f >= f) {
                    SuccessTickView.this.qqE = false;
                    SuccessTickView.this.qqC = SuccessTickView.this.qqz + ((SuccessTickView.this.qqx - SuccessTickView.this.qqz) * ((f - 0.84f) / 0.16f));
                    SuccessTickView.this.qqD = SuccessTickView.this.qqy + ((SuccessTickView.this.qqA - SuccessTickView.this.qqy) * (1.0f - ((f - 0.84f) / 0.16f)));
                    SuccessTickView.this.invalidate();
                }
            }
        };
        animation.setDuration(750L);
        animation.setStartOffset(100L);
        startAnimation(animation);
    }
}
