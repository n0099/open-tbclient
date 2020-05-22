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
    private boolean nRA;
    private final float nRr;
    private final float nRs;
    private final float nRt;
    private final float nRu;
    private final float nRv;
    private final float nRw;
    private float nRx;
    private float nRy;
    private float nRz;

    public SuccessTickView(Context context) {
        super(context);
        this.mDensity = -1.0f;
        this.nRr = aR(1.2f);
        this.nRs = aR(3.0f);
        this.nRt = aR(15.0f);
        this.nRu = aR(25.0f);
        this.nRv = aR(3.3f);
        this.nRw = this.nRu + aR(6.7f);
        init();
    }

    public SuccessTickView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDensity = -1.0f;
        this.nRr = aR(1.2f);
        this.nRs = aR(3.0f);
        this.nRt = aR(15.0f);
        this.nRu = aR(25.0f);
        this.nRv = aR(3.3f);
        this.nRw = this.nRu + aR(6.7f);
        init();
    }

    private void init() {
        this.mPaint = new Paint();
        this.mPaint.setColor(getResources().getColor(b.C0914b.success_stroke_color));
        this.nRy = this.nRt;
        this.nRz = this.nRu;
        this.nRA = false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        canvas.rotate(45.0f, width / 2, height / 2);
        int i = (int) (width / 1.2d);
        int i2 = (int) (height / 1.4d);
        this.nRx = (((i + this.nRt) / 2.0f) + this.nRs) - 1.0f;
        RectF rectF = new RectF();
        if (this.nRA) {
            rectF.left = 0.0f;
            rectF.right = rectF.left + this.nRy;
            rectF.top = (i2 + this.nRu) / 2.0f;
            rectF.bottom = rectF.top + this.nRs;
        } else {
            rectF.right = (((i + this.nRt) / 2.0f) + this.nRs) - 1.0f;
            rectF.left = rectF.right - this.nRy;
            rectF.top = (i2 + this.nRu) / 2.0f;
            rectF.bottom = rectF.top + this.nRs;
        }
        canvas.drawRoundRect(rectF, this.nRr, this.nRr, this.mPaint);
        RectF rectF2 = new RectF();
        rectF2.bottom = (((i2 + this.nRu) / 2.0f) + this.nRs) - 1.0f;
        rectF2.left = (i + this.nRt) / 2.0f;
        rectF2.right = rectF2.left + this.nRs;
        rectF2.top = rectF2.bottom - this.nRz;
        canvas.drawRoundRect(rectF2, this.nRr, this.nRr, this.mPaint);
    }

    public float aR(float f) {
        if (this.mDensity == -1.0f) {
            this.mDensity = getResources().getDisplayMetrics().density;
        }
        return (this.mDensity * f) + 0.5f;
    }

    public void dSn() {
        this.nRy = 0.0f;
        this.nRz = 0.0f;
        invalidate();
        Animation animation = new Animation() { // from class: tv.chushou.zues.widget.sweetalert.SuccessTickView.1
            @Override // android.view.animation.Animation
            protected void applyTransformation(float f, Transformation transformation) {
                super.applyTransformation(f, transformation);
                if (0.54d < f && 0.7d >= f) {
                    SuccessTickView.this.nRA = true;
                    SuccessTickView.this.nRy = SuccessTickView.this.nRx * ((f - 0.54f) / 0.16f);
                    if (0.65d < f) {
                        SuccessTickView.this.nRz = SuccessTickView.this.nRw * ((f - 0.65f) / 0.19f);
                    }
                    SuccessTickView.this.invalidate();
                } else if (0.7d < f && 0.84d >= f) {
                    SuccessTickView.this.nRA = false;
                    SuccessTickView.this.nRy = SuccessTickView.this.nRx * (1.0f - ((f - 0.7f) / 0.14f));
                    SuccessTickView.this.nRy = SuccessTickView.this.nRy < SuccessTickView.this.nRv ? SuccessTickView.this.nRv : SuccessTickView.this.nRy;
                    SuccessTickView.this.nRz = SuccessTickView.this.nRw * ((f - 0.65f) / 0.19f);
                    SuccessTickView.this.invalidate();
                } else if (0.84d < f && 1.0f >= f) {
                    SuccessTickView.this.nRA = false;
                    SuccessTickView.this.nRy = SuccessTickView.this.nRv + ((SuccessTickView.this.nRt - SuccessTickView.this.nRv) * ((f - 0.84f) / 0.16f));
                    SuccessTickView.this.nRz = SuccessTickView.this.nRu + ((SuccessTickView.this.nRw - SuccessTickView.this.nRu) * (1.0f - ((f - 0.84f) / 0.16f)));
                    SuccessTickView.this.invalidate();
                }
            }
        };
        animation.setDuration(750L);
        animation.setStartOffset(100L);
        startAnimation(animation);
    }
}
