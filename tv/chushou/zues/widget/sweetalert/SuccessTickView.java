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
    private final float qha;
    private final float qhb;
    private final float qhc;
    private final float qhd;
    private final float qhe;
    private final float qhf;
    private float qhg;
    private float qhh;
    private float qhi;
    private boolean qhj;

    public SuccessTickView(Context context) {
        super(context);
        this.mDensity = -1.0f;
        this.qha = bz(1.2f);
        this.qhb = bz(3.0f);
        this.qhc = bz(15.0f);
        this.qhd = bz(25.0f);
        this.qhe = bz(3.3f);
        this.qhf = this.qhd + bz(6.7f);
        init();
    }

    public SuccessTickView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDensity = -1.0f;
        this.qha = bz(1.2f);
        this.qhb = bz(3.0f);
        this.qhc = bz(15.0f);
        this.qhd = bz(25.0f);
        this.qhe = bz(3.3f);
        this.qhf = this.qhd + bz(6.7f);
        init();
    }

    private void init() {
        this.mPaint = new Paint();
        this.mPaint.setColor(getResources().getColor(b.C1095b.success_stroke_color));
        this.qhh = this.qhc;
        this.qhi = this.qhd;
        this.qhj = false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        canvas.rotate(45.0f, width / 2, height / 2);
        int i = (int) (width / 1.2d);
        int i2 = (int) (height / 1.4d);
        this.qhg = (((i + this.qhc) / 2.0f) + this.qhb) - 1.0f;
        RectF rectF = new RectF();
        if (this.qhj) {
            rectF.left = 0.0f;
            rectF.right = rectF.left + this.qhh;
            rectF.top = (i2 + this.qhd) / 2.0f;
            rectF.bottom = rectF.top + this.qhb;
        } else {
            rectF.right = (((i + this.qhc) / 2.0f) + this.qhb) - 1.0f;
            rectF.left = rectF.right - this.qhh;
            rectF.top = (i2 + this.qhd) / 2.0f;
            rectF.bottom = rectF.top + this.qhb;
        }
        canvas.drawRoundRect(rectF, this.qha, this.qha, this.mPaint);
        RectF rectF2 = new RectF();
        rectF2.bottom = (((i2 + this.qhd) / 2.0f) + this.qhb) - 1.0f;
        rectF2.left = (i + this.qhc) / 2.0f;
        rectF2.right = rectF2.left + this.qhb;
        rectF2.top = rectF2.bottom - this.qhi;
        canvas.drawRoundRect(rectF2, this.qha, this.qha, this.mPaint);
    }

    public float bz(float f) {
        if (this.mDensity == -1.0f) {
            this.mDensity = getResources().getDisplayMetrics().density;
        }
        return (this.mDensity * f) + 0.5f;
    }

    public void eEz() {
        this.qhh = 0.0f;
        this.qhi = 0.0f;
        invalidate();
        Animation animation = new Animation() { // from class: tv.chushou.zues.widget.sweetalert.SuccessTickView.1
            @Override // android.view.animation.Animation
            protected void applyTransformation(float f, Transformation transformation) {
                super.applyTransformation(f, transformation);
                if (0.54d < f && 0.7d >= f) {
                    SuccessTickView.this.qhj = true;
                    SuccessTickView.this.qhh = SuccessTickView.this.qhg * ((f - 0.54f) / 0.16f);
                    if (0.65d < f) {
                        SuccessTickView.this.qhi = SuccessTickView.this.qhf * ((f - 0.65f) / 0.19f);
                    }
                    SuccessTickView.this.invalidate();
                } else if (0.7d < f && 0.84d >= f) {
                    SuccessTickView.this.qhj = false;
                    SuccessTickView.this.qhh = SuccessTickView.this.qhg * (1.0f - ((f - 0.7f) / 0.14f));
                    SuccessTickView.this.qhh = SuccessTickView.this.qhh < SuccessTickView.this.qhe ? SuccessTickView.this.qhe : SuccessTickView.this.qhh;
                    SuccessTickView.this.qhi = SuccessTickView.this.qhf * ((f - 0.65f) / 0.19f);
                    SuccessTickView.this.invalidate();
                } else if (0.84d < f && 1.0f >= f) {
                    SuccessTickView.this.qhj = false;
                    SuccessTickView.this.qhh = SuccessTickView.this.qhe + ((SuccessTickView.this.qhc - SuccessTickView.this.qhe) * ((f - 0.84f) / 0.16f));
                    SuccessTickView.this.qhi = SuccessTickView.this.qhd + ((SuccessTickView.this.qhf - SuccessTickView.this.qhd) * (1.0f - ((f - 0.84f) / 0.16f)));
                    SuccessTickView.this.invalidate();
                }
            }
        };
        animation.setDuration(750L);
        animation.setStartOffset(100L);
        startAnimation(animation);
    }
}
