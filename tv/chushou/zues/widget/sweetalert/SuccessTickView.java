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
    private final float qrY;
    private final float qrZ;
    private final float qsa;
    private final float qsb;
    private final float qsc;
    private final float qsd;
    private float qse;
    private float qsf;
    private float qsg;
    private boolean qsh;

    public SuccessTickView(Context context) {
        super(context);
        this.mDensity = -1.0f;
        this.qrY = bJ(1.2f);
        this.qrZ = bJ(3.0f);
        this.qsa = bJ(15.0f);
        this.qsb = bJ(25.0f);
        this.qsc = bJ(3.3f);
        this.qsd = this.qsb + bJ(6.7f);
        init();
    }

    public SuccessTickView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDensity = -1.0f;
        this.qrY = bJ(1.2f);
        this.qrZ = bJ(3.0f);
        this.qsa = bJ(15.0f);
        this.qsb = bJ(25.0f);
        this.qsc = bJ(3.3f);
        this.qsd = this.qsb + bJ(6.7f);
        init();
    }

    private void init() {
        this.mPaint = new Paint();
        this.mPaint.setColor(getResources().getColor(b.C1118b.success_stroke_color));
        this.qsf = this.qsa;
        this.qsg = this.qsb;
        this.qsh = false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        canvas.rotate(45.0f, width / 2, height / 2);
        int i = (int) (width / 1.2d);
        int i2 = (int) (height / 1.4d);
        this.qse = (((i + this.qsa) / 2.0f) + this.qrZ) - 1.0f;
        RectF rectF = new RectF();
        if (this.qsh) {
            rectF.left = 0.0f;
            rectF.right = rectF.left + this.qsf;
            rectF.top = (i2 + this.qsb) / 2.0f;
            rectF.bottom = rectF.top + this.qrZ;
        } else {
            rectF.right = (((i + this.qsa) / 2.0f) + this.qrZ) - 1.0f;
            rectF.left = rectF.right - this.qsf;
            rectF.top = (i2 + this.qsb) / 2.0f;
            rectF.bottom = rectF.top + this.qrZ;
        }
        canvas.drawRoundRect(rectF, this.qrY, this.qrY, this.mPaint);
        RectF rectF2 = new RectF();
        rectF2.bottom = (((i2 + this.qsb) / 2.0f) + this.qrZ) - 1.0f;
        rectF2.left = (i + this.qsa) / 2.0f;
        rectF2.right = rectF2.left + this.qrZ;
        rectF2.top = rectF2.bottom - this.qsg;
        canvas.drawRoundRect(rectF2, this.qrY, this.qrY, this.mPaint);
    }

    public float bJ(float f) {
        if (this.mDensity == -1.0f) {
            this.mDensity = getResources().getDisplayMetrics().density;
        }
        return (this.mDensity * f) + 0.5f;
    }

    public void eIp() {
        this.qsf = 0.0f;
        this.qsg = 0.0f;
        invalidate();
        Animation animation = new Animation() { // from class: tv.chushou.zues.widget.sweetalert.SuccessTickView.1
            @Override // android.view.animation.Animation
            protected void applyTransformation(float f, Transformation transformation) {
                super.applyTransformation(f, transformation);
                if (0.54d < f && 0.7d >= f) {
                    SuccessTickView.this.qsh = true;
                    SuccessTickView.this.qsf = SuccessTickView.this.qse * ((f - 0.54f) / 0.16f);
                    if (0.65d < f) {
                        SuccessTickView.this.qsg = SuccessTickView.this.qsd * ((f - 0.65f) / 0.19f);
                    }
                    SuccessTickView.this.invalidate();
                } else if (0.7d < f && 0.84d >= f) {
                    SuccessTickView.this.qsh = false;
                    SuccessTickView.this.qsf = SuccessTickView.this.qse * (1.0f - ((f - 0.7f) / 0.14f));
                    SuccessTickView.this.qsf = SuccessTickView.this.qsf < SuccessTickView.this.qsc ? SuccessTickView.this.qsc : SuccessTickView.this.qsf;
                    SuccessTickView.this.qsg = SuccessTickView.this.qsd * ((f - 0.65f) / 0.19f);
                    SuccessTickView.this.invalidate();
                } else if (0.84d < f && 1.0f >= f) {
                    SuccessTickView.this.qsh = false;
                    SuccessTickView.this.qsf = SuccessTickView.this.qsc + ((SuccessTickView.this.qsa - SuccessTickView.this.qsc) * ((f - 0.84f) / 0.16f));
                    SuccessTickView.this.qsg = SuccessTickView.this.qsb + ((SuccessTickView.this.qsd - SuccessTickView.this.qsb) * (1.0f - ((f - 0.84f) / 0.16f)));
                    SuccessTickView.this.invalidate();
                }
            }
        };
        animation.setDuration(750L);
        animation.setStartOffset(100L);
        startAnimation(animation);
    }
}
