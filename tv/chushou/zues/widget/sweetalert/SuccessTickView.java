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
    private final float oRd;
    private final float oRe;
    private final float oRf;
    private final float oRg;
    private final float oRh;
    private final float oRi;
    private float oRj;
    private float oRk;
    private float oRl;
    private boolean oRm;

    public SuccessTickView(Context context) {
        super(context);
        this.mDensity = -1.0f;
        this.oRd = bc(1.2f);
        this.oRe = bc(3.0f);
        this.oRf = bc(15.0f);
        this.oRg = bc(25.0f);
        this.oRh = bc(3.3f);
        this.oRi = this.oRg + bc(6.7f);
        init();
    }

    public SuccessTickView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDensity = -1.0f;
        this.oRd = bc(1.2f);
        this.oRe = bc(3.0f);
        this.oRf = bc(15.0f);
        this.oRg = bc(25.0f);
        this.oRh = bc(3.3f);
        this.oRi = this.oRg + bc(6.7f);
        init();
    }

    private void init() {
        this.mPaint = new Paint();
        this.mPaint.setColor(getResources().getColor(b.C1008b.success_stroke_color));
        this.oRk = this.oRf;
        this.oRl = this.oRg;
        this.oRm = false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        canvas.rotate(45.0f, width / 2, height / 2);
        int i = (int) (width / 1.2d);
        int i2 = (int) (height / 1.4d);
        this.oRj = (((i + this.oRf) / 2.0f) + this.oRe) - 1.0f;
        RectF rectF = new RectF();
        if (this.oRm) {
            rectF.left = 0.0f;
            rectF.right = rectF.left + this.oRk;
            rectF.top = (i2 + this.oRg) / 2.0f;
            rectF.bottom = rectF.top + this.oRe;
        } else {
            rectF.right = (((i + this.oRf) / 2.0f) + this.oRe) - 1.0f;
            rectF.left = rectF.right - this.oRk;
            rectF.top = (i2 + this.oRg) / 2.0f;
            rectF.bottom = rectF.top + this.oRe;
        }
        canvas.drawRoundRect(rectF, this.oRd, this.oRd, this.mPaint);
        RectF rectF2 = new RectF();
        rectF2.bottom = (((i2 + this.oRg) / 2.0f) + this.oRe) - 1.0f;
        rectF2.left = (i + this.oRf) / 2.0f;
        rectF2.right = rectF2.left + this.oRe;
        rectF2.top = rectF2.bottom - this.oRl;
        canvas.drawRoundRect(rectF2, this.oRd, this.oRd, this.mPaint);
    }

    public float bc(float f) {
        if (this.mDensity == -1.0f) {
            this.mDensity = getResources().getDisplayMetrics().density;
        }
        return (this.mDensity * f) + 0.5f;
    }

    public void emU() {
        this.oRk = 0.0f;
        this.oRl = 0.0f;
        invalidate();
        Animation animation = new Animation() { // from class: tv.chushou.zues.widget.sweetalert.SuccessTickView.1
            @Override // android.view.animation.Animation
            protected void applyTransformation(float f, Transformation transformation) {
                super.applyTransformation(f, transformation);
                if (0.54d < f && 0.7d >= f) {
                    SuccessTickView.this.oRm = true;
                    SuccessTickView.this.oRk = SuccessTickView.this.oRj * ((f - 0.54f) / 0.16f);
                    if (0.65d < f) {
                        SuccessTickView.this.oRl = SuccessTickView.this.oRi * ((f - 0.65f) / 0.19f);
                    }
                    SuccessTickView.this.invalidate();
                } else if (0.7d < f && 0.84d >= f) {
                    SuccessTickView.this.oRm = false;
                    SuccessTickView.this.oRk = SuccessTickView.this.oRj * (1.0f - ((f - 0.7f) / 0.14f));
                    SuccessTickView.this.oRk = SuccessTickView.this.oRk < SuccessTickView.this.oRh ? SuccessTickView.this.oRh : SuccessTickView.this.oRk;
                    SuccessTickView.this.oRl = SuccessTickView.this.oRi * ((f - 0.65f) / 0.19f);
                    SuccessTickView.this.invalidate();
                } else if (0.84d < f && 1.0f >= f) {
                    SuccessTickView.this.oRm = false;
                    SuccessTickView.this.oRk = SuccessTickView.this.oRh + ((SuccessTickView.this.oRf - SuccessTickView.this.oRh) * ((f - 0.84f) / 0.16f));
                    SuccessTickView.this.oRl = SuccessTickView.this.oRg + ((SuccessTickView.this.oRi - SuccessTickView.this.oRg) * (1.0f - ((f - 0.84f) / 0.16f)));
                    SuccessTickView.this.invalidate();
                }
            }
        };
        animation.setDuration(750L);
        animation.setStartOffset(100L);
        startAnimation(animation);
    }
}
