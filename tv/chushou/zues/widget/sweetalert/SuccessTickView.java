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
    private float oaA;
    private float oaB;
    private boolean oaC;
    private final float oat;
    private final float oau;
    private final float oav;
    private final float oaw;
    private final float oax;
    private final float oay;
    private float oaz;

    public SuccessTickView(Context context) {
        super(context);
        this.mDensity = -1.0f;
        this.oat = bL(1.2f);
        this.oau = bL(3.0f);
        this.oav = bL(15.0f);
        this.oaw = bL(25.0f);
        this.oax = bL(3.3f);
        this.oay = this.oaw + bL(6.7f);
        init();
    }

    public SuccessTickView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDensity = -1.0f;
        this.oat = bL(1.2f);
        this.oau = bL(3.0f);
        this.oav = bL(15.0f);
        this.oaw = bL(25.0f);
        this.oax = bL(3.3f);
        this.oay = this.oaw + bL(6.7f);
        init();
    }

    private void init() {
        this.mPaint = new Paint();
        this.mPaint.setColor(getResources().getColor(b.C0807b.success_stroke_color));
        this.oaA = this.oav;
        this.oaB = this.oaw;
        this.oaC = false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        canvas.rotate(45.0f, width / 2, height / 2);
        int i = (int) (width / 1.2d);
        int i2 = (int) (height / 1.4d);
        this.oaz = (((i + this.oav) / 2.0f) + this.oau) - 1.0f;
        RectF rectF = new RectF();
        if (this.oaC) {
            rectF.left = 0.0f;
            rectF.right = rectF.left + this.oaA;
            rectF.top = (i2 + this.oaw) / 2.0f;
            rectF.bottom = rectF.top + this.oau;
        } else {
            rectF.right = (((i + this.oav) / 2.0f) + this.oau) - 1.0f;
            rectF.left = rectF.right - this.oaA;
            rectF.top = (i2 + this.oaw) / 2.0f;
            rectF.bottom = rectF.top + this.oau;
        }
        canvas.drawRoundRect(rectF, this.oat, this.oat, this.mPaint);
        RectF rectF2 = new RectF();
        rectF2.bottom = (((i2 + this.oaw) / 2.0f) + this.oau) - 1.0f;
        rectF2.left = (i + this.oav) / 2.0f;
        rectF2.right = rectF2.left + this.oau;
        rectF2.top = rectF2.bottom - this.oaB;
        canvas.drawRoundRect(rectF2, this.oat, this.oat, this.mPaint);
    }

    public float bL(float f) {
        if (this.mDensity == -1.0f) {
            this.mDensity = getResources().getDisplayMetrics().density;
        }
        return (this.mDensity * f) + 0.5f;
    }

    public void dQR() {
        this.oaA = 0.0f;
        this.oaB = 0.0f;
        invalidate();
        Animation animation = new Animation() { // from class: tv.chushou.zues.widget.sweetalert.SuccessTickView.1
            @Override // android.view.animation.Animation
            protected void applyTransformation(float f, Transformation transformation) {
                super.applyTransformation(f, transformation);
                if (0.54d < f && 0.7d >= f) {
                    SuccessTickView.this.oaC = true;
                    SuccessTickView.this.oaA = SuccessTickView.this.oaz * ((f - 0.54f) / 0.16f);
                    if (0.65d < f) {
                        SuccessTickView.this.oaB = SuccessTickView.this.oay * ((f - 0.65f) / 0.19f);
                    }
                    SuccessTickView.this.invalidate();
                } else if (0.7d < f && 0.84d >= f) {
                    SuccessTickView.this.oaC = false;
                    SuccessTickView.this.oaA = SuccessTickView.this.oaz * (1.0f - ((f - 0.7f) / 0.14f));
                    SuccessTickView.this.oaA = SuccessTickView.this.oaA < SuccessTickView.this.oax ? SuccessTickView.this.oax : SuccessTickView.this.oaA;
                    SuccessTickView.this.oaB = SuccessTickView.this.oay * ((f - 0.65f) / 0.19f);
                    SuccessTickView.this.invalidate();
                } else if (0.84d < f && 1.0f >= f) {
                    SuccessTickView.this.oaC = false;
                    SuccessTickView.this.oaA = SuccessTickView.this.oax + ((SuccessTickView.this.oav - SuccessTickView.this.oax) * ((f - 0.84f) / 0.16f));
                    SuccessTickView.this.oaB = SuccessTickView.this.oaw + ((SuccessTickView.this.oay - SuccessTickView.this.oaw) * (1.0f - ((f - 0.84f) / 0.16f)));
                    SuccessTickView.this.invalidate();
                }
            }
        };
        animation.setDuration(750L);
        animation.setStartOffset(100L);
        startAnimation(animation);
    }
}
