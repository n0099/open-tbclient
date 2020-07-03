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
    private final float ooq;
    private final float oor;
    private final float oos;
    private final float oot;
    private final float oou;
    private final float oov;
    private float oow;
    private float oox;
    private float ooy;
    private boolean ooz;

    public SuccessTickView(Context context) {
        super(context);
        this.mDensity = -1.0f;
        this.ooq = aX(1.2f);
        this.oor = aX(3.0f);
        this.oos = aX(15.0f);
        this.oot = aX(25.0f);
        this.oou = aX(3.3f);
        this.oov = this.oot + aX(6.7f);
        init();
    }

    public SuccessTickView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDensity = -1.0f;
        this.ooq = aX(1.2f);
        this.oor = aX(3.0f);
        this.oos = aX(15.0f);
        this.oot = aX(25.0f);
        this.oou = aX(3.3f);
        this.oov = this.oot + aX(6.7f);
        init();
    }

    private void init() {
        this.mPaint = new Paint();
        this.mPaint.setColor(getResources().getColor(b.C0934b.success_stroke_color));
        this.oox = this.oos;
        this.ooy = this.oot;
        this.ooz = false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        canvas.rotate(45.0f, width / 2, height / 2);
        int i = (int) (width / 1.2d);
        int i2 = (int) (height / 1.4d);
        this.oow = (((i + this.oos) / 2.0f) + this.oor) - 1.0f;
        RectF rectF = new RectF();
        if (this.ooz) {
            rectF.left = 0.0f;
            rectF.right = rectF.left + this.oox;
            rectF.top = (i2 + this.oot) / 2.0f;
            rectF.bottom = rectF.top + this.oor;
        } else {
            rectF.right = (((i + this.oos) / 2.0f) + this.oor) - 1.0f;
            rectF.left = rectF.right - this.oox;
            rectF.top = (i2 + this.oot) / 2.0f;
            rectF.bottom = rectF.top + this.oor;
        }
        canvas.drawRoundRect(rectF, this.ooq, this.ooq, this.mPaint);
        RectF rectF2 = new RectF();
        rectF2.bottom = (((i2 + this.oot) / 2.0f) + this.oor) - 1.0f;
        rectF2.left = (i + this.oos) / 2.0f;
        rectF2.right = rectF2.left + this.oor;
        rectF2.top = rectF2.bottom - this.ooy;
        canvas.drawRoundRect(rectF2, this.ooq, this.ooq, this.mPaint);
    }

    public float aX(float f) {
        if (this.mDensity == -1.0f) {
            this.mDensity = getResources().getDisplayMetrics().density;
        }
        return (this.mDensity * f) + 0.5f;
    }

    public void dXh() {
        this.oox = 0.0f;
        this.ooy = 0.0f;
        invalidate();
        Animation animation = new Animation() { // from class: tv.chushou.zues.widget.sweetalert.SuccessTickView.1
            @Override // android.view.animation.Animation
            protected void applyTransformation(float f, Transformation transformation) {
                super.applyTransformation(f, transformation);
                if (0.54d < f && 0.7d >= f) {
                    SuccessTickView.this.ooz = true;
                    SuccessTickView.this.oox = SuccessTickView.this.oow * ((f - 0.54f) / 0.16f);
                    if (0.65d < f) {
                        SuccessTickView.this.ooy = SuccessTickView.this.oov * ((f - 0.65f) / 0.19f);
                    }
                    SuccessTickView.this.invalidate();
                } else if (0.7d < f && 0.84d >= f) {
                    SuccessTickView.this.ooz = false;
                    SuccessTickView.this.oox = SuccessTickView.this.oow * (1.0f - ((f - 0.7f) / 0.14f));
                    SuccessTickView.this.oox = SuccessTickView.this.oox < SuccessTickView.this.oou ? SuccessTickView.this.oou : SuccessTickView.this.oox;
                    SuccessTickView.this.ooy = SuccessTickView.this.oov * ((f - 0.65f) / 0.19f);
                    SuccessTickView.this.invalidate();
                } else if (0.84d < f && 1.0f >= f) {
                    SuccessTickView.this.ooz = false;
                    SuccessTickView.this.oox = SuccessTickView.this.oou + ((SuccessTickView.this.oos - SuccessTickView.this.oou) * ((f - 0.84f) / 0.16f));
                    SuccessTickView.this.ooy = SuccessTickView.this.oot + ((SuccessTickView.this.oov - SuccessTickView.this.oot) * (1.0f - ((f - 0.84f) / 0.16f)));
                    SuccessTickView.this.invalidate();
                }
            }
        };
        animation.setDuration(750L);
        animation.setStartOffset(100L);
        startAnimation(animation);
    }
}
