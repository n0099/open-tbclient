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
    private float nwA;
    private boolean nwB;
    private final float nws;
    private final float nwt;
    private final float nwu;
    private final float nwv;
    private final float nww;
    private final float nwx;
    private float nwy;
    private float nwz;

    public SuccessTickView(Context context) {
        super(context);
        this.mDensity = -1.0f;
        this.nws = aS(1.2f);
        this.nwt = aS(3.0f);
        this.nwu = aS(15.0f);
        this.nwv = aS(25.0f);
        this.nww = aS(3.3f);
        this.nwx = this.nwv + aS(6.7f);
        init();
    }

    public SuccessTickView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDensity = -1.0f;
        this.nws = aS(1.2f);
        this.nwt = aS(3.0f);
        this.nwu = aS(15.0f);
        this.nwv = aS(25.0f);
        this.nww = aS(3.3f);
        this.nwx = this.nwv + aS(6.7f);
        init();
    }

    private void init() {
        this.mPaint = new Paint();
        this.mPaint.setColor(getResources().getColor(b.C0831b.success_stroke_color));
        this.nwz = this.nwu;
        this.nwA = this.nwv;
        this.nwB = false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        canvas.rotate(45.0f, width / 2, height / 2);
        int i = (int) (width / 1.2d);
        int i2 = (int) (height / 1.4d);
        this.nwy = (((i + this.nwu) / 2.0f) + this.nwt) - 1.0f;
        RectF rectF = new RectF();
        if (this.nwB) {
            rectF.left = 0.0f;
            rectF.right = rectF.left + this.nwz;
            rectF.top = (i2 + this.nwv) / 2.0f;
            rectF.bottom = rectF.top + this.nwt;
        } else {
            rectF.right = (((i + this.nwu) / 2.0f) + this.nwt) - 1.0f;
            rectF.left = rectF.right - this.nwz;
            rectF.top = (i2 + this.nwv) / 2.0f;
            rectF.bottom = rectF.top + this.nwt;
        }
        canvas.drawRoundRect(rectF, this.nws, this.nws, this.mPaint);
        RectF rectF2 = new RectF();
        rectF2.bottom = (((i2 + this.nwv) / 2.0f) + this.nwt) - 1.0f;
        rectF2.left = (i + this.nwu) / 2.0f;
        rectF2.right = rectF2.left + this.nwt;
        rectF2.top = rectF2.bottom - this.nwA;
        canvas.drawRoundRect(rectF2, this.nws, this.nws, this.mPaint);
    }

    public float aS(float f) {
        if (this.mDensity == -1.0f) {
            this.mDensity = getResources().getDisplayMetrics().density;
        }
        return (this.mDensity * f) + 0.5f;
    }

    public void dKw() {
        this.nwz = 0.0f;
        this.nwA = 0.0f;
        invalidate();
        Animation animation = new Animation() { // from class: tv.chushou.zues.widget.sweetalert.SuccessTickView.1
            @Override // android.view.animation.Animation
            protected void applyTransformation(float f, Transformation transformation) {
                super.applyTransformation(f, transformation);
                if (0.54d < f && 0.7d >= f) {
                    SuccessTickView.this.nwB = true;
                    SuccessTickView.this.nwz = SuccessTickView.this.nwy * ((f - 0.54f) / 0.16f);
                    if (0.65d < f) {
                        SuccessTickView.this.nwA = SuccessTickView.this.nwx * ((f - 0.65f) / 0.19f);
                    }
                    SuccessTickView.this.invalidate();
                } else if (0.7d < f && 0.84d >= f) {
                    SuccessTickView.this.nwB = false;
                    SuccessTickView.this.nwz = SuccessTickView.this.nwy * (1.0f - ((f - 0.7f) / 0.14f));
                    SuccessTickView.this.nwz = SuccessTickView.this.nwz < SuccessTickView.this.nww ? SuccessTickView.this.nww : SuccessTickView.this.nwz;
                    SuccessTickView.this.nwA = SuccessTickView.this.nwx * ((f - 0.65f) / 0.19f);
                    SuccessTickView.this.invalidate();
                } else if (0.84d < f && 1.0f >= f) {
                    SuccessTickView.this.nwB = false;
                    SuccessTickView.this.nwz = SuccessTickView.this.nww + ((SuccessTickView.this.nwu - SuccessTickView.this.nww) * ((f - 0.84f) / 0.16f));
                    SuccessTickView.this.nwA = SuccessTickView.this.nwv + ((SuccessTickView.this.nwx - SuccessTickView.this.nwv) * (1.0f - ((f - 0.84f) / 0.16f)));
                    SuccessTickView.this.invalidate();
                }
            }
        };
        animation.setDuration(750L);
        animation.setStartOffset(100L);
        startAnimation(animation);
    }
}
