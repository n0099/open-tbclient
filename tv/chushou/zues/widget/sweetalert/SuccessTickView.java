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
    private final float oQL;
    private final float oQM;
    private final float oQN;
    private final float oQO;
    private final float oQP;
    private final float oQQ;
    private float oQR;
    private float oQS;
    private float oQT;
    private boolean oQU;

    public SuccessTickView(Context context) {
        super(context);
        this.mDensity = -1.0f;
        this.oQL = bc(1.2f);
        this.oQM = bc(3.0f);
        this.oQN = bc(15.0f);
        this.oQO = bc(25.0f);
        this.oQP = bc(3.3f);
        this.oQQ = this.oQO + bc(6.7f);
        init();
    }

    public SuccessTickView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDensity = -1.0f;
        this.oQL = bc(1.2f);
        this.oQM = bc(3.0f);
        this.oQN = bc(15.0f);
        this.oQO = bc(25.0f);
        this.oQP = bc(3.3f);
        this.oQQ = this.oQO + bc(6.7f);
        init();
    }

    private void init() {
        this.mPaint = new Paint();
        this.mPaint.setColor(getResources().getColor(b.C1008b.success_stroke_color));
        this.oQS = this.oQN;
        this.oQT = this.oQO;
        this.oQU = false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        canvas.rotate(45.0f, width / 2, height / 2);
        int i = (int) (width / 1.2d);
        int i2 = (int) (height / 1.4d);
        this.oQR = (((i + this.oQN) / 2.0f) + this.oQM) - 1.0f;
        RectF rectF = new RectF();
        if (this.oQU) {
            rectF.left = 0.0f;
            rectF.right = rectF.left + this.oQS;
            rectF.top = (i2 + this.oQO) / 2.0f;
            rectF.bottom = rectF.top + this.oQM;
        } else {
            rectF.right = (((i + this.oQN) / 2.0f) + this.oQM) - 1.0f;
            rectF.left = rectF.right - this.oQS;
            rectF.top = (i2 + this.oQO) / 2.0f;
            rectF.bottom = rectF.top + this.oQM;
        }
        canvas.drawRoundRect(rectF, this.oQL, this.oQL, this.mPaint);
        RectF rectF2 = new RectF();
        rectF2.bottom = (((i2 + this.oQO) / 2.0f) + this.oQM) - 1.0f;
        rectF2.left = (i + this.oQN) / 2.0f;
        rectF2.right = rectF2.left + this.oQM;
        rectF2.top = rectF2.bottom - this.oQT;
        canvas.drawRoundRect(rectF2, this.oQL, this.oQL, this.mPaint);
    }

    public float bc(float f) {
        if (this.mDensity == -1.0f) {
            this.mDensity = getResources().getDisplayMetrics().density;
        }
        return (this.mDensity * f) + 0.5f;
    }

    public void emL() {
        this.oQS = 0.0f;
        this.oQT = 0.0f;
        invalidate();
        Animation animation = new Animation() { // from class: tv.chushou.zues.widget.sweetalert.SuccessTickView.1
            @Override // android.view.animation.Animation
            protected void applyTransformation(float f, Transformation transformation) {
                super.applyTransformation(f, transformation);
                if (0.54d < f && 0.7d >= f) {
                    SuccessTickView.this.oQU = true;
                    SuccessTickView.this.oQS = SuccessTickView.this.oQR * ((f - 0.54f) / 0.16f);
                    if (0.65d < f) {
                        SuccessTickView.this.oQT = SuccessTickView.this.oQQ * ((f - 0.65f) / 0.19f);
                    }
                    SuccessTickView.this.invalidate();
                } else if (0.7d < f && 0.84d >= f) {
                    SuccessTickView.this.oQU = false;
                    SuccessTickView.this.oQS = SuccessTickView.this.oQR * (1.0f - ((f - 0.7f) / 0.14f));
                    SuccessTickView.this.oQS = SuccessTickView.this.oQS < SuccessTickView.this.oQP ? SuccessTickView.this.oQP : SuccessTickView.this.oQS;
                    SuccessTickView.this.oQT = SuccessTickView.this.oQQ * ((f - 0.65f) / 0.19f);
                    SuccessTickView.this.invalidate();
                } else if (0.84d < f && 1.0f >= f) {
                    SuccessTickView.this.oQU = false;
                    SuccessTickView.this.oQS = SuccessTickView.this.oQP + ((SuccessTickView.this.oQN - SuccessTickView.this.oQP) * ((f - 0.84f) / 0.16f));
                    SuccessTickView.this.oQT = SuccessTickView.this.oQO + ((SuccessTickView.this.oQQ - SuccessTickView.this.oQO) * (1.0f - ((f - 0.84f) / 0.16f)));
                    SuccessTickView.this.invalidate();
                }
            }
        };
        animation.setDuration(750L);
        animation.setStartOffset(100L);
        startAnimation(animation);
    }
}
