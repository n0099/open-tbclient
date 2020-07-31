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
    private final float owS;
    private final float owT;
    private final float owU;
    private final float owV;
    private final float owW;
    private final float owX;
    private float owY;
    private float owZ;
    private float oxa;
    private boolean oxb;

    public SuccessTickView(Context context) {
        super(context);
        this.mDensity = -1.0f;
        this.owS = aW(1.2f);
        this.owT = aW(3.0f);
        this.owU = aW(15.0f);
        this.owV = aW(25.0f);
        this.owW = aW(3.3f);
        this.owX = this.owV + aW(6.7f);
        init();
    }

    public SuccessTickView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDensity = -1.0f;
        this.owS = aW(1.2f);
        this.owT = aW(3.0f);
        this.owU = aW(15.0f);
        this.owV = aW(25.0f);
        this.owW = aW(3.3f);
        this.owX = this.owV + aW(6.7f);
        init();
    }

    private void init() {
        this.mPaint = new Paint();
        this.mPaint.setColor(getResources().getColor(b.C0950b.success_stroke_color));
        this.owZ = this.owU;
        this.oxa = this.owV;
        this.oxb = false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        canvas.rotate(45.0f, width / 2, height / 2);
        int i = (int) (width / 1.2d);
        int i2 = (int) (height / 1.4d);
        this.owY = (((i + this.owU) / 2.0f) + this.owT) - 1.0f;
        RectF rectF = new RectF();
        if (this.oxb) {
            rectF.left = 0.0f;
            rectF.right = rectF.left + this.owZ;
            rectF.top = (i2 + this.owV) / 2.0f;
            rectF.bottom = rectF.top + this.owT;
        } else {
            rectF.right = (((i + this.owU) / 2.0f) + this.owT) - 1.0f;
            rectF.left = rectF.right - this.owZ;
            rectF.top = (i2 + this.owV) / 2.0f;
            rectF.bottom = rectF.top + this.owT;
        }
        canvas.drawRoundRect(rectF, this.owS, this.owS, this.mPaint);
        RectF rectF2 = new RectF();
        rectF2.bottom = (((i2 + this.owV) / 2.0f) + this.owT) - 1.0f;
        rectF2.left = (i + this.owU) / 2.0f;
        rectF2.right = rectF2.left + this.owT;
        rectF2.top = rectF2.bottom - this.oxa;
        canvas.drawRoundRect(rectF2, this.owS, this.owS, this.mPaint);
    }

    public float aW(float f) {
        if (this.mDensity == -1.0f) {
            this.mDensity = getResources().getDisplayMetrics().density;
        }
        return (this.mDensity * f) + 0.5f;
    }

    public void eaH() {
        this.owZ = 0.0f;
        this.oxa = 0.0f;
        invalidate();
        Animation animation = new Animation() { // from class: tv.chushou.zues.widget.sweetalert.SuccessTickView.1
            @Override // android.view.animation.Animation
            protected void applyTransformation(float f, Transformation transformation) {
                super.applyTransformation(f, transformation);
                if (0.54d < f && 0.7d >= f) {
                    SuccessTickView.this.oxb = true;
                    SuccessTickView.this.owZ = SuccessTickView.this.owY * ((f - 0.54f) / 0.16f);
                    if (0.65d < f) {
                        SuccessTickView.this.oxa = SuccessTickView.this.owX * ((f - 0.65f) / 0.19f);
                    }
                    SuccessTickView.this.invalidate();
                } else if (0.7d < f && 0.84d >= f) {
                    SuccessTickView.this.oxb = false;
                    SuccessTickView.this.owZ = SuccessTickView.this.owY * (1.0f - ((f - 0.7f) / 0.14f));
                    SuccessTickView.this.owZ = SuccessTickView.this.owZ < SuccessTickView.this.owW ? SuccessTickView.this.owW : SuccessTickView.this.owZ;
                    SuccessTickView.this.oxa = SuccessTickView.this.owX * ((f - 0.65f) / 0.19f);
                    SuccessTickView.this.invalidate();
                } else if (0.84d < f && 1.0f >= f) {
                    SuccessTickView.this.oxb = false;
                    SuccessTickView.this.owZ = SuccessTickView.this.owW + ((SuccessTickView.this.owU - SuccessTickView.this.owW) * ((f - 0.84f) / 0.16f));
                    SuccessTickView.this.oxa = SuccessTickView.this.owV + ((SuccessTickView.this.owX - SuccessTickView.this.owV) * (1.0f - ((f - 0.84f) / 0.16f)));
                    SuccessTickView.this.invalidate();
                }
            }
        };
        animation.setDuration(750L);
        animation.setStartOffset(100L);
        startAnimation(animation);
    }
}
