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
    private final float nSB;
    private final float nSC;
    private final float nSD;
    private final float nSE;
    private final float nSF;
    private final float nSG;
    private float nSH;
    private float nSI;
    private float nSJ;
    private boolean nSK;

    public SuccessTickView(Context context) {
        super(context);
        this.mDensity = -1.0f;
        this.nSB = aR(1.2f);
        this.nSC = aR(3.0f);
        this.nSD = aR(15.0f);
        this.nSE = aR(25.0f);
        this.nSF = aR(3.3f);
        this.nSG = this.nSE + aR(6.7f);
        init();
    }

    public SuccessTickView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDensity = -1.0f;
        this.nSB = aR(1.2f);
        this.nSC = aR(3.0f);
        this.nSD = aR(15.0f);
        this.nSE = aR(25.0f);
        this.nSF = aR(3.3f);
        this.nSG = this.nSE + aR(6.7f);
        init();
    }

    private void init() {
        this.mPaint = new Paint();
        this.mPaint.setColor(getResources().getColor(b.C0915b.success_stroke_color));
        this.nSI = this.nSD;
        this.nSJ = this.nSE;
        this.nSK = false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        canvas.rotate(45.0f, width / 2, height / 2);
        int i = (int) (width / 1.2d);
        int i2 = (int) (height / 1.4d);
        this.nSH = (((i + this.nSD) / 2.0f) + this.nSC) - 1.0f;
        RectF rectF = new RectF();
        if (this.nSK) {
            rectF.left = 0.0f;
            rectF.right = rectF.left + this.nSI;
            rectF.top = (i2 + this.nSE) / 2.0f;
            rectF.bottom = rectF.top + this.nSC;
        } else {
            rectF.right = (((i + this.nSD) / 2.0f) + this.nSC) - 1.0f;
            rectF.left = rectF.right - this.nSI;
            rectF.top = (i2 + this.nSE) / 2.0f;
            rectF.bottom = rectF.top + this.nSC;
        }
        canvas.drawRoundRect(rectF, this.nSB, this.nSB, this.mPaint);
        RectF rectF2 = new RectF();
        rectF2.bottom = (((i2 + this.nSE) / 2.0f) + this.nSC) - 1.0f;
        rectF2.left = (i + this.nSD) / 2.0f;
        rectF2.right = rectF2.left + this.nSC;
        rectF2.top = rectF2.bottom - this.nSJ;
        canvas.drawRoundRect(rectF2, this.nSB, this.nSB, this.mPaint);
    }

    public float aR(float f) {
        if (this.mDensity == -1.0f) {
            this.mDensity = getResources().getDisplayMetrics().density;
        }
        return (this.mDensity * f) + 0.5f;
    }

    public void dSB() {
        this.nSI = 0.0f;
        this.nSJ = 0.0f;
        invalidate();
        Animation animation = new Animation() { // from class: tv.chushou.zues.widget.sweetalert.SuccessTickView.1
            @Override // android.view.animation.Animation
            protected void applyTransformation(float f, Transformation transformation) {
                super.applyTransformation(f, transformation);
                if (0.54d < f && 0.7d >= f) {
                    SuccessTickView.this.nSK = true;
                    SuccessTickView.this.nSI = SuccessTickView.this.nSH * ((f - 0.54f) / 0.16f);
                    if (0.65d < f) {
                        SuccessTickView.this.nSJ = SuccessTickView.this.nSG * ((f - 0.65f) / 0.19f);
                    }
                    SuccessTickView.this.invalidate();
                } else if (0.7d < f && 0.84d >= f) {
                    SuccessTickView.this.nSK = false;
                    SuccessTickView.this.nSI = SuccessTickView.this.nSH * (1.0f - ((f - 0.7f) / 0.14f));
                    SuccessTickView.this.nSI = SuccessTickView.this.nSI < SuccessTickView.this.nSF ? SuccessTickView.this.nSF : SuccessTickView.this.nSI;
                    SuccessTickView.this.nSJ = SuccessTickView.this.nSG * ((f - 0.65f) / 0.19f);
                    SuccessTickView.this.invalidate();
                } else if (0.84d < f && 1.0f >= f) {
                    SuccessTickView.this.nSK = false;
                    SuccessTickView.this.nSI = SuccessTickView.this.nSF + ((SuccessTickView.this.nSD - SuccessTickView.this.nSF) * ((f - 0.84f) / 0.16f));
                    SuccessTickView.this.nSJ = SuccessTickView.this.nSE + ((SuccessTickView.this.nSG - SuccessTickView.this.nSE) * (1.0f - ((f - 0.84f) / 0.16f)));
                    SuccessTickView.this.invalidate();
                }
            }
        };
        animation.setDuration(750L);
        animation.setStartOffset(100L);
        startAnimation(animation);
    }
}
