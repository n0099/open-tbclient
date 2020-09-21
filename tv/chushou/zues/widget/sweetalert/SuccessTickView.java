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
    private float paA;
    private float paB;
    private float paC;
    private boolean paD;
    private final float pat;
    private final float pau;
    private final float pav;
    private final float paw;
    private final float pax;
    private final float paz;

    public SuccessTickView(Context context) {
        super(context);
        this.mDensity = -1.0f;
        this.pat = bc(1.2f);
        this.pau = bc(3.0f);
        this.pav = bc(15.0f);
        this.paw = bc(25.0f);
        this.pax = bc(3.3f);
        this.paz = this.paw + bc(6.7f);
        init();
    }

    public SuccessTickView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDensity = -1.0f;
        this.pat = bc(1.2f);
        this.pau = bc(3.0f);
        this.pav = bc(15.0f);
        this.paw = bc(25.0f);
        this.pax = bc(3.3f);
        this.paz = this.paw + bc(6.7f);
        init();
    }

    private void init() {
        this.mPaint = new Paint();
        this.mPaint.setColor(getResources().getColor(b.C1005b.success_stroke_color));
        this.paB = this.pav;
        this.paC = this.paw;
        this.paD = false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        canvas.rotate(45.0f, width / 2, height / 2);
        int i = (int) (width / 1.2d);
        int i2 = (int) (height / 1.4d);
        this.paA = (((i + this.pav) / 2.0f) + this.pau) - 1.0f;
        RectF rectF = new RectF();
        if (this.paD) {
            rectF.left = 0.0f;
            rectF.right = rectF.left + this.paB;
            rectF.top = (i2 + this.paw) / 2.0f;
            rectF.bottom = rectF.top + this.pau;
        } else {
            rectF.right = (((i + this.pav) / 2.0f) + this.pau) - 1.0f;
            rectF.left = rectF.right - this.paB;
            rectF.top = (i2 + this.paw) / 2.0f;
            rectF.bottom = rectF.top + this.pau;
        }
        canvas.drawRoundRect(rectF, this.pat, this.pat, this.mPaint);
        RectF rectF2 = new RectF();
        rectF2.bottom = (((i2 + this.paw) / 2.0f) + this.pau) - 1.0f;
        rectF2.left = (i + this.pav) / 2.0f;
        rectF2.right = rectF2.left + this.pau;
        rectF2.top = rectF2.bottom - this.paC;
        canvas.drawRoundRect(rectF2, this.pat, this.pat, this.mPaint);
    }

    public float bc(float f) {
        if (this.mDensity == -1.0f) {
            this.mDensity = getResources().getDisplayMetrics().density;
        }
        return (this.mDensity * f) + 0.5f;
    }

    public void eqQ() {
        this.paB = 0.0f;
        this.paC = 0.0f;
        invalidate();
        Animation animation = new Animation() { // from class: tv.chushou.zues.widget.sweetalert.SuccessTickView.1
            @Override // android.view.animation.Animation
            protected void applyTransformation(float f, Transformation transformation) {
                super.applyTransformation(f, transformation);
                if (0.54d < f && 0.7d >= f) {
                    SuccessTickView.this.paD = true;
                    SuccessTickView.this.paB = SuccessTickView.this.paA * ((f - 0.54f) / 0.16f);
                    if (0.65d < f) {
                        SuccessTickView.this.paC = SuccessTickView.this.paz * ((f - 0.65f) / 0.19f);
                    }
                    SuccessTickView.this.invalidate();
                } else if (0.7d < f && 0.84d >= f) {
                    SuccessTickView.this.paD = false;
                    SuccessTickView.this.paB = SuccessTickView.this.paA * (1.0f - ((f - 0.7f) / 0.14f));
                    SuccessTickView.this.paB = SuccessTickView.this.paB < SuccessTickView.this.pax ? SuccessTickView.this.pax : SuccessTickView.this.paB;
                    SuccessTickView.this.paC = SuccessTickView.this.paz * ((f - 0.65f) / 0.19f);
                    SuccessTickView.this.invalidate();
                } else if (0.84d < f && 1.0f >= f) {
                    SuccessTickView.this.paD = false;
                    SuccessTickView.this.paB = SuccessTickView.this.pax + ((SuccessTickView.this.pav - SuccessTickView.this.pax) * ((f - 0.84f) / 0.16f));
                    SuccessTickView.this.paC = SuccessTickView.this.paw + ((SuccessTickView.this.paz - SuccessTickView.this.paw) * (1.0f - ((f - 0.84f) / 0.16f)));
                    SuccessTickView.this.invalidate();
                }
            }
        };
        animation.setDuration(750L);
        animation.setStartOffset(100L);
        startAnimation(animation);
    }
}
