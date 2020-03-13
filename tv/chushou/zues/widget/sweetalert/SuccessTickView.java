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
    private final float oaG;
    private final float oaH;
    private final float oaI;
    private final float oaJ;
    private final float oaK;
    private final float oaL;
    private float oaM;
    private float oaN;
    private float oaO;
    private boolean oaP;

    public SuccessTickView(Context context) {
        super(context);
        this.mDensity = -1.0f;
        this.oaG = bL(1.2f);
        this.oaH = bL(3.0f);
        this.oaI = bL(15.0f);
        this.oaJ = bL(25.0f);
        this.oaK = bL(3.3f);
        this.oaL = this.oaJ + bL(6.7f);
        init();
    }

    public SuccessTickView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDensity = -1.0f;
        this.oaG = bL(1.2f);
        this.oaH = bL(3.0f);
        this.oaI = bL(15.0f);
        this.oaJ = bL(25.0f);
        this.oaK = bL(3.3f);
        this.oaL = this.oaJ + bL(6.7f);
        init();
    }

    private void init() {
        this.mPaint = new Paint();
        this.mPaint.setColor(getResources().getColor(b.C0807b.success_stroke_color));
        this.oaN = this.oaI;
        this.oaO = this.oaJ;
        this.oaP = false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        canvas.rotate(45.0f, width / 2, height / 2);
        int i = (int) (width / 1.2d);
        int i2 = (int) (height / 1.4d);
        this.oaM = (((i + this.oaI) / 2.0f) + this.oaH) - 1.0f;
        RectF rectF = new RectF();
        if (this.oaP) {
            rectF.left = 0.0f;
            rectF.right = rectF.left + this.oaN;
            rectF.top = (i2 + this.oaJ) / 2.0f;
            rectF.bottom = rectF.top + this.oaH;
        } else {
            rectF.right = (((i + this.oaI) / 2.0f) + this.oaH) - 1.0f;
            rectF.left = rectF.right - this.oaN;
            rectF.top = (i2 + this.oaJ) / 2.0f;
            rectF.bottom = rectF.top + this.oaH;
        }
        canvas.drawRoundRect(rectF, this.oaG, this.oaG, this.mPaint);
        RectF rectF2 = new RectF();
        rectF2.bottom = (((i2 + this.oaJ) / 2.0f) + this.oaH) - 1.0f;
        rectF2.left = (i + this.oaI) / 2.0f;
        rectF2.right = rectF2.left + this.oaH;
        rectF2.top = rectF2.bottom - this.oaO;
        canvas.drawRoundRect(rectF2, this.oaG, this.oaG, this.mPaint);
    }

    public float bL(float f) {
        if (this.mDensity == -1.0f) {
            this.mDensity = getResources().getDisplayMetrics().density;
        }
        return (this.mDensity * f) + 0.5f;
    }

    public void dQU() {
        this.oaN = 0.0f;
        this.oaO = 0.0f;
        invalidate();
        Animation animation = new Animation() { // from class: tv.chushou.zues.widget.sweetalert.SuccessTickView.1
            @Override // android.view.animation.Animation
            protected void applyTransformation(float f, Transformation transformation) {
                super.applyTransformation(f, transformation);
                if (0.54d < f && 0.7d >= f) {
                    SuccessTickView.this.oaP = true;
                    SuccessTickView.this.oaN = SuccessTickView.this.oaM * ((f - 0.54f) / 0.16f);
                    if (0.65d < f) {
                        SuccessTickView.this.oaO = SuccessTickView.this.oaL * ((f - 0.65f) / 0.19f);
                    }
                    SuccessTickView.this.invalidate();
                } else if (0.7d < f && 0.84d >= f) {
                    SuccessTickView.this.oaP = false;
                    SuccessTickView.this.oaN = SuccessTickView.this.oaM * (1.0f - ((f - 0.7f) / 0.14f));
                    SuccessTickView.this.oaN = SuccessTickView.this.oaN < SuccessTickView.this.oaK ? SuccessTickView.this.oaK : SuccessTickView.this.oaN;
                    SuccessTickView.this.oaO = SuccessTickView.this.oaL * ((f - 0.65f) / 0.19f);
                    SuccessTickView.this.invalidate();
                } else if (0.84d < f && 1.0f >= f) {
                    SuccessTickView.this.oaP = false;
                    SuccessTickView.this.oaN = SuccessTickView.this.oaK + ((SuccessTickView.this.oaI - SuccessTickView.this.oaK) * ((f - 0.84f) / 0.16f));
                    SuccessTickView.this.oaO = SuccessTickView.this.oaJ + ((SuccessTickView.this.oaL - SuccessTickView.this.oaJ) * (1.0f - ((f - 0.84f) / 0.16f)));
                    SuccessTickView.this.invalidate();
                }
            }
        };
        animation.setDuration(750L);
        animation.setStartOffset(100L);
        startAnimation(animation);
    }
}
